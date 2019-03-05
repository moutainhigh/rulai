package com.unicdata.service.car.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.conditon.CarPurchaseCondition;
import com.unicdata.constant.CarEnum;
import com.unicdata.constant.ModelEnum;
import com.unicdata.entity.car.CarBrand;
import com.unicdata.entity.car.CarColor;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.car.CarOptionalPackage;
import com.unicdata.entity.car.CarPurchaseOrder;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.entity.model.Model;
import com.unicdata.entity.product.FinanceCompany;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.car.CarBrandService;
import com.unicdata.service.car.CarColorService;
import com.unicdata.service.car.CarFamilyService;
import com.unicdata.service.car.CarGoodInfoService;
import com.unicdata.service.car.CarOptionalPackageService;
import com.unicdata.service.car.CarPurchaseOrderService;
import com.unicdata.service.car.CarTimerService;
import com.unicdata.service.car.CarVehicleConfService;
import com.unicdata.service.car.PurchaseCarService;
import com.unicdata.service.model.ModelService;
import com.unicdata.service.policy.RebateProjectService;
import com.unicdata.service.product.FinanceCompanyService;
import com.unicdata.util.ExcelTemplateUtil;

@Service
public class PurchaseCarServiceImpl implements PurchaseCarService {

	@Autowired
	private CarPurchaseOrderService carPurchaseOrderService;
	@Autowired
	private CarGoodInfoService carGoodInfoService;
	@Autowired
	private CarOptionalPackageService carOptionalPackageService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private CarVehicleConfService carVehicleConfService;
	@Autowired
	private CarColorService carColorService;
	@Autowired
	private CarFamilyService carFamilyService;
	@Autowired
	private RebateProjectService rebateProjectService;
	@Autowired
	private FinanceCompanyService financeCompanyService;
	@Autowired
	private CarBrandService carBrandService;
	@Autowired
	private CarTimerService carTimerService;

	@Override
	@Transactional(readOnly = false)
	public ApiReturnInfo<String> addOrder(Employee employee, CarPurchaseCondition carPurchaseCondition) {
		CarPurchaseOrder carPurchaseOrder = carPurchaseCondition.getCarPurchaseOrder();
		List<CarGoodInfoWithBLOBs> carList = carPurchaseCondition.getCarList();
		List<CarOptionalPackage> optionalList = carPurchaseCondition.getOptionalList();
		ApiReturnInfo<String> result = new ApiReturnInfo<>();
		// 验证空值 采购单
		if (null == carPurchaseOrder || null == carList || StringUtil.isBlank(carPurchaseOrder.getCode())
				|| StringUtil.isBlank(carPurchaseOrder.getName()) || null == carPurchaseOrder.getFundProperty()
				|| null == carPurchaseOrder.getBatchRebate() || null == carPurchaseOrder.getRetailRebate()
				|| null == carPurchaseOrder.getSource()) {
			result.setCode(ConstantEnumStatus.PARAM_NULL.getCode());
			result.setMessage(ConstantEnumStatus.PARAM_NULL.getReason());
			return result;
		}
		carPurchaseOrder.setOperatorId(employee.getId());
		carPurchaseOrder.setDistributorStoreId(employee.getStoreId());
		int num = carPurchaseOrderService.insertSelective(carPurchaseOrder);
		BigDecimal standardPriceSum = new BigDecimal(0);
		BigDecimal perchasePriceSum = new BigDecimal(0);
		if (num > 0) {
			if (null != optionalList) {
				for (int i = 0; i < optionalList.size(); i++) {
					// 选装包
					CarOptionalPackage carOptionalPackage = optionalList.get(i);
					if (null != carOptionalPackage.getStatus() && carOptionalPackage.getStatus() == 1) {
						carOptionalPackage.setOperatorId(employee.getId());
						carOptionalPackageService.insertSelective(carOptionalPackage);
					}
				}
			}
			for (int i = 0; i < carList.size(); i++) {
				// 车辆信息
				CarGoodInfoWithBLOBs carGoodInfoWithBLOBs = carList.get(i);
				carGoodInfoWithBLOBs.setCarOrderId(carPurchaseOrder.getId());
				carGoodInfoWithBLOBs.setDistributorStoreId(employee.getStoreId());
				carGoodInfoWithBLOBs.setFundProperty(carPurchaseOrder.getFundProperty());
				carGoodInfoWithBLOBs.setBatchRebate(carPurchaseOrder.getBatchRebate());
				carGoodInfoWithBLOBs.setSource(carPurchaseOrder.getSource());
				carGoodInfoWithBLOBs.setRetailRebate(carPurchaseOrder.getRetailRebate());
				// 采购金额 指导价 含精品指导价
				CarVehicleConf carVehicleConf = carVehicleConfService
						.selectByPrimaryKey(carGoodInfoWithBLOBs.getVehicleId());
				carGoodInfoWithBLOBs.setStandardPrice(carVehicleConf.getGuidePrice());
				carGoodInfoWithBLOBs.setPurchasePrice(carVehicleConf.getPurchasePrice());
				carGoodInfoWithBLOBs.setIncludeBoutiquePrice(carVehicleConf.getGuidePrice());
				// 全国统一指导价
				carGoodInfoWithBLOBs.setNationGuidePrice(carVehicleConf.getPurchasePrice()
						.subtract(carOptionalPackageService.selectSumByVin(carGoodInfoWithBLOBs.getVin())));
				// 计算总采购金额 指导价
				standardPriceSum = standardPriceSum.add(carVehicleConf.getGuidePrice());
				perchasePriceSum = perchasePriceSum.add(carVehicleConf.getPurchasePrice());
				// 整车采购价
				carGoodInfoWithBLOBs.setEntirePurchasePrice(carGoodInfoWithBLOBs.getPurchasePrice()
						.add(null == carGoodInfoWithBLOBs.getPurchasePricePio() ? new BigDecimal(0)
								: carGoodInfoWithBLOBs.getPurchasePricePio())
						.add(null == carGoodInfoWithBLOBs.getFreightCharge() ? new BigDecimal(0)
								: carGoodInfoWithBLOBs.getFreightCharge()));
				// 改为在途
				carGoodInfoWithBLOBs.setStorageStatus(CarEnum.CarStorageStatus.ON_WAY.getCode());
				// 颜色
				if (StringUtil.isNotBlank(carGoodInfoWithBLOBs.getDecorationsOutName())) {
					carGoodInfoWithBLOBs
							.setDecorationsOutName(carGoodInfoWithBLOBs.getDecorationsOutName().replace("色", ""));
					// 车身颜色
					CarColor carColor = carColorService.selectByFamilyAndName(carGoodInfoWithBLOBs.getFamilyId(),
							carGoodInfoWithBLOBs.getDecorationsOutName(), CarEnum.ColorStatus.OUT.getCode());
					if (null == carColor) {
						carColor = new CarColor();
						carColor.setFamilyId(carGoodInfoWithBLOBs.getFamilyId());
						carColor.setLocationStatus(CarEnum.ColorStatus.OUT.getCode());
						carColor.setName(carGoodInfoWithBLOBs.getDecorationsOutName());
						carColorService.insertSelective(carColor);
					}
					carGoodInfoWithBLOBs.setDecorationsOutId(carColor.getId());
				}
				if (StringUtil.isNotBlank(carGoodInfoWithBLOBs.getDecorationsInName())) {
					carGoodInfoWithBLOBs
							.setDecorationsInName(carGoodInfoWithBLOBs.getDecorationsInName().replace("色", ""));
					// 内饰
					CarColor carColor = carColorService.selectByFamilyAndName(carGoodInfoWithBLOBs.getFamilyId(),
							carGoodInfoWithBLOBs.getDecorationsInName(), CarEnum.ColorStatus.IN.getCode());
					if (null == carColor) {
						carColor = new CarColor();
						carColor.setFamilyId(carGoodInfoWithBLOBs.getFamilyId());
						carColor.setLocationStatus(CarEnum.ColorStatus.IN.getCode());
						carColor.setName(carGoodInfoWithBLOBs.getDecorationsInName());
						carColorService.insertSelective(carColor);
					}
					carGoodInfoWithBLOBs.setDecorationsInId(carColor.getId());
				}
				// 保存
				carGoodInfoWithBLOBs.setOperatorId(employee.getId());
				carGoodInfoWithBLOBs.setDistributorStoreId(employee.getStoreId());
				// 计算各个天数以及利息
				carGoodInfoWithBLOBs = carTimerService.carTimerCaculate(carList.get(i));
				carGoodInfoService.insertSelective(carGoodInfoWithBLOBs);
				// 为采购车辆适配返利项目
				rebateProjectService.inStorageCarRebateProject(carGoodInfoWithBLOBs.getId());
			}
			carPurchaseOrder.setStandardPrice(standardPriceSum);
			carPurchaseOrder.setPerchasePrice(perchasePriceSum);
			carPurchaseOrderService.updateByPrimaryKeySelective(carPurchaseOrder);
		} else {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public ApiReturnInfo<List<Map<String, Object>>> importCar(HttpServletRequest request, Employee employee,
			MultipartFile mfile) {
		ApiReturnInfo<List<Map<String, Object>>> result = new ApiReturnInfo<>();
		if (null != mfile) {
			List<Model> modelList = modelService.getListByBelong(ModelEnum.BelongType.CAR.getCode());
			// MultipartFile转为File
			String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
			File dir = new File(filePath);
			if (!dir.exists()) {
				dir.mkdir();
			}
			String path = filePath + mfile.getOriginalFilename();
			File tempFile = new File(path);
			// 初始化输入流
			InputStream is = null;
			try {
				// 将上传的文件写入新建的文件中
				mfile.transferTo(tempFile);
				// 根据新建的文件实例化输入流
				is = new FileInputStream(tempFile);
				// 根据版本选择创建Workbook的方式
				Workbook wb = null;
				// 根据文件名判断文件是2003版本还是2007版本
				if (ExcelTemplateUtil.isExcel2007(mfile.getOriginalFilename())) {
					wb = new XSSFWorkbook(is);
				} else {
					wb = new HSSFWorkbook(is);
				}
				// 根据excel里面的内容读取知识库信息
				List<Map<String, Object>> list = ExcelTemplateUtil.readExcelValue(wb, tempFile);
				List<Map<String, Object>> resultList = new ArrayList<>();
				// 判断是否有重复vin码
				Map<String, Object> vinMap = new HashMap<>();
				int size = 0;
				for (int i = 0; i < list.size(); i++) {
					String vin = list.get(i).get("车架号") + "";
					if (StringUtil.isBlank(vin) || StringUtil.equals(vin, "null")) {
						continue;
					}
					size++;
					vinMap.put(vin, "");
					if (vinMap.size() < size) {
						result.setCode(ConstantEnumStatus.FAIL.getCode());
						result.setMessage("导入车辆数据有重复vin码，请重新导入！");
						return result;
					}
				}
				// 循环所有数据
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> returnMap = new HashMap<String, Object>();
					Map<String, Object> map = list.get(i);
					// 循环模板
					for (int j = 0; j < modelList.size(); j++) {
						Model model = modelList.get(j);
						String data = map.get(model.getNameCh()) + "";
						if (StringUtil.isBlank(data) || StringUtil.equals(data, "null")) {
							data = "";
						}
						returnMap.put(model.getNameEn(), data);
					}
					// 处理数据
					// 车架号相关
					String vin = returnMap.get("vin") + "";
					returnMap.put("ifStorage", CarEnum.CarStatus.NO.getCode());
					returnMap.put("carSupplyStatus", CarEnum.SupplyStatus.NO_SUPPLY.getCode());
					if (StringUtil.isNotBlank(vin)) {
						// 非远期车则判断是否存在
						CarGoodInfoWithBLOBs carGoodInfoWithBLOBs = carGoodInfoService.selectByVin(vin);
						if (null != carGoodInfoWithBLOBs) {
							returnMap.put("ifStorage", CarEnum.CarStatus.YES.getCode());
							returnMap.put("carSupplyStatus", carGoodInfoWithBLOBs.getCarSupplyStatus());
						}
						returnMap.put("forwardCarStatus", CarEnum.CarStatus.NO.getCode());
					} else {
						// 远期车
						returnMap.put("forwardCarStatus", CarEnum.CarStatus.YES.getCode());
					}
					// 年款
					returnMap.put("year", returnMap.get("year").toString().replace("年", "").replace("款", ""));
					// 品牌
					CarBrand carBrand = null;
					if (StringUtil.isNotBlank(returnMap.get("brandName").toString())
							&& StringUtil.isNotBlank(returnMap.get("factoryName").toString())) {
						carBrand = carBrandService.selectByName(employee.getStoreId(),
								returnMap.get("brandName").toString(), returnMap.get("factoryName").toString());
					}
					// 车系
					CarFamily carFamily = null;
					CarVehicleConf carVehicleConf = null;
					if (null != carBrand && StringUtil.isNotBlank(returnMap.get("familyName").toString())) {
						carFamily = carFamilyService.selectByName(employee.getStoreId(),
								returnMap.get("familyName").toString(), carBrand.getId());
						returnMap.put("brandId", carBrand.getId());
					} else {
						returnMap.put("brandId", "");
					}
					if (null != carFamily && StringUtil.isNotBlank(returnMap.get("vehicleName").toString())) {
						returnMap.put("familyId", carFamily.getId());
						// 免息天数
						returnMap.put("interestFreeDay", carFamily.getInterestFreeDay());
						// 车型配置
						carVehicleConf = carVehicleConfService.selectByNameAndYear(employee.getStoreId(),
								carFamily.getId(), returnMap.get("vehicleName").toString(),
								returnMap.get("year").toString());
					} else {
						returnMap.put("familyId", "");
						// 免息天数
						returnMap.put("interestFreeDay", "");
					}
					if (null != carVehicleConf) {
						// 匹配到库中的车型
						returnMap.put("vehicleId", carVehicleConf.getId());
						returnMap.put("standardPrice", carVehicleConf.getGuidePrice());
						returnMap.put("purchasePrice", carVehicleConf.getPurchasePrice());
					} else {
						returnMap.put("vehicleId", "");
						returnMap.put("standardPrice", "");
						returnMap.put("purchasePrice", "");
					}
					// 是否抵押
					String guarantyStatus = returnMap.get("guarantyStatus").toString();
					if (StringUtil.isNotBlank(guarantyStatus)
							&& StringUtil.equals(guarantyStatus, CarEnum.CarStatus.YES.getReason())) {
						returnMap.put("guarantyStatus", CarEnum.CarStatus.YES.getCode());
					} else {
						returnMap.put("guarantyStatus", CarEnum.CarStatus.NO.getCode());
					}
					// 抵押公司id
					FinanceCompany financeCompany = financeCompanyService.selectByName(employee.getStoreId(),
							returnMap.get("financeCompanyName").toString());
					if (null != financeCompany) {
						returnMap.put("financeCompanyId", financeCompany.getId());
					} else {
						returnMap.put("financeCompanyId", "");
					}

					// 车辆状态
					returnMap.put("storageStatus", CarEnum.CarStorageStatus.ON_WAY.getCode());
					resultList.add(returnMap);
				}
				result.setData(resultList);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						is = null;
						e.printStackTrace();
					}
				}
			}
		} else {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public ApiReturnInfo<List<Map<String, Object>>> importOptional(HttpServletRequest request, Employee employee,
			MultipartFile mfile) {
		ApiReturnInfo<List<Map<String, Object>>> result = new ApiReturnInfo<>();
		if (null != mfile) {
			List<Model> modelList = modelService.getListByBelong(ModelEnum.BelongType.OPTIONAL.getCode());
			// MultipartFile转为File
			String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
			File dir = new File(filePath);
			if (!dir.exists()) {
				dir.mkdir();
			}
			String path = filePath + mfile.getOriginalFilename();
			File tempFile = new File(path);
			// 初始化输入流
			InputStream is = null;
			try {
				// 将上传的文件写入新建的文件中
				mfile.transferTo(tempFile);
				// 根据新建的文件实例化输入流
				is = new FileInputStream(tempFile);
				// 根据版本选择创建Workbook的方式
				Workbook wb = null;
				// 根据文件名判断文件是2003版本还是2007版本
				if (ExcelTemplateUtil.isExcel2007(mfile.getOriginalFilename())) {
					wb = new XSSFWorkbook(is);
				} else {
					wb = new HSSFWorkbook(is);
				}
				// 根据excel里面的内容读取知识库信息
				List<Map<String, Object>> list = ExcelTemplateUtil.readExcelValue(wb, tempFile);
				List<Map<String, Object>> resultList = new ArrayList<>();
				// 循环所有数据
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> returnMap = new HashMap<String, Object>();
					Map<String, Object> map = list.get(i);
					// 循环模板数据
					for (int j = 0; j < modelList.size(); j++) {
						Model model = modelList.get(j);
						String data = map.get(model.getNameCh()) + "";
						if (StringUtil.isBlank(data) || StringUtil.equals(data, "null")) {
							data = "";
						}
						if (StringUtil.isBlank(data) && !StringUtil.equals(model.getNameEn(), "code")) {
							result.setCode(ConstantEnumStatus.FAIL.getCode());
							result.setMessage("导入选装包信息不全，请重新进行导入！");
							return result;
						}
						returnMap.put(model.getNameEn(), data);
					}
					resultList.add(returnMap);
				}
				result.setData(resultList);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						is = null;
						e.printStackTrace();
					}
				}
			}
		} else {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		}
		return result;
	}

}
