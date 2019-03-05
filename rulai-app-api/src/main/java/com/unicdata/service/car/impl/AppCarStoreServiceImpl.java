package com.unicdata.service.car.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.DictionaryTypeEnum.StoreStatus;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.constant.CarEnum.CarStorageStatus;
import com.unicdata.constant.ConstantEnum.CarCheckStatus;
import com.unicdata.dao.boutique.CarWashMapper;
import com.unicdata.dao.car.CarAllotApplicationMapper;
import com.unicdata.dao.car.CarAllotMapper;
import com.unicdata.dao.car.CarCheckRecordMapper;
import com.unicdata.dao.car.CarDepotCheckMapper;
import com.unicdata.dao.car.CarFamilyMapper;
import com.unicdata.dao.car.CarGoodInfoMapper;
import com.unicdata.dao.car.CarInsuranceRecordMapper;
import com.unicdata.dao.car.CarMaintainRecordMapper;
import com.unicdata.dao.car.CarOutApplicationMapper;
import com.unicdata.dao.car.CarOutMapper;
import com.unicdata.dao.car.CarOutstorgeRecordMapper;
import com.unicdata.dao.car.CarPurchaseOrderMapper;
import com.unicdata.dao.car.CarRefuelRecordMapper;
import com.unicdata.dao.car.CarStorageMapper;
import com.unicdata.dao.car.CarTestInfoMapper;
import com.unicdata.dao.car.CarVehicleConfMapper;
import com.unicdata.dao.car.CarWarehouseMapper;
import com.unicdata.dao.car.CarWeihuRecordMapper;
import com.unicdata.dao.car.CarZhengbeiRecordMapper;
import com.unicdata.dao.order.DeliverCarMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.dao.system.EmployeeMapper;
import com.unicdata.entity.boutique.CarWash;
import com.unicdata.entity.car.CarCheckRecord;
import com.unicdata.entity.car.CarDepotCheck;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarMaintainRecord;
import com.unicdata.entity.car.CarOutApplication;
import com.unicdata.entity.car.CarOutstorgeRecord;
import com.unicdata.entity.car.CarPurchaseOrder;
import com.unicdata.entity.car.CarRefuelRecord;
import com.unicdata.entity.car.CarStorage;
import com.unicdata.entity.car.CarTestInfo;
import com.unicdata.entity.car.CarWarehouse;
import com.unicdata.entity.car.CarWeihuRecord;
import com.unicdata.entity.car.CarZhengbeiRecord;
import com.unicdata.entity.order.DeliverCar;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.car.AppCarStoreService;
@Service
public class AppCarStoreServiceImpl implements AppCarStoreService {

	@Autowired
	private DeliverCarMapper deliverCarMapper;
	@Autowired
	private CarOutMapper carOutMapper;
	@Autowired
	private CarGoodInfoMapper carGoodInfoMapper;
	@Autowired
	private CarTestInfoMapper carTestInfoMapper;
	@Autowired
	private CarRefuelRecordMapper carRefuelRecordMapper;
	@Autowired
	private CarAllotMapper carAllotMapper;
	@Autowired
	private CarMaintainRecordMapper carMaintainRecordMapper;
	@Autowired
	private CarWeihuRecordMapper carWeihuRecordMapper;
	@Autowired
	private CarCheckRecordMapper carCheckRecordMapper;
	@Autowired
	private CarWarehouseMapper carWarehouseMapper;
	@Autowired
	private CarStorageMapper carStorageMapper;
	@Autowired
	private CarDepotCheckMapper carDepotCheckMapper;
	@Autowired
	private CarZhengbeiRecordMapper carZhengbeiRecordMapper;
	@Autowired
	private CarInsuranceRecordMapper carInsuranceRecordMapper;
	@Autowired
	private CarPurchaseOrderMapper carPurchaseOrderMapper;
	@Autowired
	private CarWashMapper carWashMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private CarFamilyMapper carFamilyMapper;
	@Autowired
	private CarVehicleConfMapper carVehicleConfMapper;
	@Autowired
	private CarOutApplicationMapper carOutApplicationMapper;
	@Autowired
	private CarAllotApplicationMapper carAllotApplicationMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private CarOutstorgeRecordMapper carOutstorgeRecordMapper;
	/**
	 * 交车列表 wp
	 */
	@Override
	 public PageInfo selectDeliverCarList(Map<String, Object> map,Integer pageNum,Integer pageSize) {
		pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = deliverCarMapper.selectDeliverCarList(map);
		//封装分页信息
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list); 
		return pageInfo;
	}
	/**
	 * 汽车外出 wp
	 */
	public PageInfo selectCarOutList(Map<String, Object> map,Integer pageNum,Integer pageSize){
		pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list =  carOutMapper.selectCarOutList(map);
		//封装分页信息
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list); 
		return pageInfo;
	}
	/**
	 * 商品车列表 wp
	 */
	@Override
	public PageInfo selectCarList(Map<String, Object> map,Integer pageNum,Integer pageSize) {
		pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = carGoodInfoMapper.selectCarList(map);
		//封装分页信息
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list); 
		return pageInfo;
	}
	
	/**
	 * 试驾车列表wp
	 */
	@Override
	public PageInfo selectTestCarList(Map<String, Object> map,Integer pageNum,Integer pageSize) {
		pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = carTestInfoMapper.selectTestCarList(map);
		//封装分页信息
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list); 
		return pageInfo;
	}
	/**
	 * 商品车详情 wp
	 */
	@Override
	public Map<String, Object> carDetailInfo(Map<String, Object> map) {
		return carGoodInfoMapper.carDetailInfo(map);
		
	}
	/**
	 * 试驾车详情 wp
	 */
	@Override
	public Map<String, Object> carTestDetailInfo(Map<String, Object> map) {
		return carTestInfoMapper.carTestDetailInfo(map);
	}
	/**
	 * 加油记录列 wp
	 */
	public List<CarRefuelRecord> selectListByTestCar(Integer testCarId){
		return carRefuelRecordMapper.selectListByTestCar(testCarId);
	}
	/**
	 * 添加加油记录 wp
	 */
	@Transactional
	public int insertSelective(CarRefuelRecord record) {
		return carRefuelRecordMapper.insertSelective(record);
	}
	
	/**
	 * 今日调拨列 wp
	 */
	@Override
	public PageInfo carAllotList(Map<String, Object> map, Integer pageNum, Integer pageSize) {
		pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = carAllotMapper.carAllotList(map);
		//封装分页信息
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list); 
		return pageInfo;
	}
	/**
	 * 整备提醒 wp
	 */
	@Override
	public PageInfo detectionCarList(Map<String, Object> map, Integer pageNum, Integer pageSize) {
		pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = carZhengbeiRecordMapper.detectionCarList(map);
		//封装分页信息
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list); 
		return pageInfo;
	}
	/**
	 * 扫一扫 wp
	 */
	public Map<String, Object> carScan(String vin){
		return carGoodInfoMapper.carScan(vin);
	}
	
	/**
	 * 入库录单 wp
	 */
	public PageInfo carRukuList(Map<String, Object> map, Integer pageNum, Integer pageSize) {
		pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = carGoodInfoMapper.carRukuList(map);
		//封装分页信息
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list); 
		return pageInfo;
	}
	/**
	 * 试驾车维修登记 wp
	 */
	@Transactional
	 public int weixiuRecord(CarMaintainRecord carMaintainRecord) {
		return carMaintainRecordMapper.insertSelective(carMaintainRecord); 
	 }
	 /**
	  * 试驾车维修历史记录 wp
	  */
	@Override
	public List<CarMaintainRecord> selectMaintanList(Integer testCarId) {
		return carMaintainRecordMapper.selectListByTestCar(testCarId);
	}
	/**
	 * 商品车维护登记 wp
	 */
	@Override
	@Transactional
	public int weihuRecord(CarWeihuRecord carWeihuRecord) {
		return carWeihuRecordMapper.insertSelective(carWeihuRecord);
	}
	
	 /**
	  * 商品车维护记录 wp
	  */
	@Override
	public List<Map<String, Object>> selectByCarId(Integer carId) {
		return carWeihuRecordMapper.selectByCarId(carId);
	}
	/**
	 * 试驾车扫一扫 wp
	 */
	@Override
	public Map<String, Object> carTestScan(String vin) {
		return carTestInfoMapper.carTestScan(vin);
	}
	/**
	 * 入库检查登记 wp
	 */
	@Override
	@Transactional
	public int insertCheckRecord(CarCheckRecord carCheckRecord) {
		return carCheckRecordMapper.insertSelective(carCheckRecord);
		
	}
	/**
	 * 变更汽车在库、处理状态 wp
	 */
	@Override
	@Transactional
	public int updateCarStatus(CarGoodInfo record) {
		return carGoodInfoMapper.updateCarInfoSelective(record);
		
	}
	/**
	 * 门店的仓库 wp
	 */
	@Override
	public List<CarWarehouse> selectCarWarehouseByStore(Integer storeId) {
		return carWarehouseMapper.selectListByStore(storeId);
		
	}
	/**
	 * 仓库下的库位 wp
	 */
	@Override
	public List<Map<String, Object>> selectCarStoreByWarehouse(Integer warehouseId) {
		return carStorageMapper.selectListByWareHouseS(warehouseId);
	}
	/**
	 * 仓库下的汽车 wp
	 */
	@Override
	public List<Map<String, Object>> selectCarInStore(Map<String, Object> map) {
		return carGoodInfoMapper.selectCarInStore(map);
		
	}
	/**
	 * 盘点登记 wp
	 */
	@Override
	@Transactional
	public int insertDepotCheckRecord(CarDepotCheck carDepotCheck) {
		return carDepotCheckMapper.insertSelective(carDepotCheck);
	}
	/**
	 * 盘点历史 wp
	 */
	@Override
	public List<Map<String, Object>> depotCheckHistory(Map<String, Object> map) {
		return carDepotCheckMapper.depotCheckHistory(map);
	}
	/**
	 * 盘亏列表 wp
	 */
	@Override
	public List<Map<String, Object>> depotCheckLossList(Map<String, Object> map) {
		return carDepotCheckMapper.depotCheckLossList(map);
	}
	/**
	 * 盘亏number下的汽车
	 */
	@Override
	public List<Map<String, Object>> depotCheckLossCars(Map<String, Object> map) {
		return carDepotCheckMapper.depotCheckLossCars(map);
	}
	
	/**
	 * 整备生成工单 wp
	 */
	@Transactional
	public int insertWorkPage(CarZhengbeiRecord carZhengbeiRecord,CarGoodInfo carGoodInfo) {
		//添加信息值整备表
		int i=carZhengbeiRecordMapper.updateZhengbeiInfo(carZhengbeiRecord);
		int i2=carGoodInfoMapper.updateCarInfoSelective(carGoodInfo);
		int r=0;
		if(i>0&&i2>0) {
			r=1;
		}
		return r;
	 }
	
	/**
	 * 整备 待送修、维修中、维修完成 wp
	 */
	@Transactional
	public int updateZhengBeiStatus(CarZhengbeiRecord carZhengbeiRecord) {
		return carZhengbeiRecordMapper.updateByPrimaryKeySelective(carZhengbeiRecord);
	}
	/**
	 * 保险到期提醒 wp
	 */
	@Override
	public PageInfo selectInsurerRemind(Integer pageNum,Integer pageSize,Integer storeId) {
		pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = carInsuranceRecordMapper.selectInsurerRemind(storeId);
		//封装分页信息
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list); 
		return pageInfo;
	}
	/**
	 * 采购单列表 wp
	 */
	@Override
	public PageInfo carPurchaseList(Map<String, Object> map,Integer pageNum,Integer pageSize) {
		pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = carPurchaseOrderMapper.carPurchaseList(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return pageInfo;
	}
	/**
	 * 采购单下的汽车列 wp
	 */
	@Override
	public PageInfo selectCarByPurchaseId(Integer carOrderId,Integer pageNum,Integer pageSize) {
		pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		Map<String, Object> mapo=new HashMap<>();
		mapo.put("carOrderId", carOrderId);
		List<Map<String, Object>> list = carPurchaseOrderMapper.selectCarByPurchaseId(mapo);
		//封装分页信息
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list); 
		return pageInfo;
	}
	/**
	 * 汽车入库登记 wp
	 */
	@Transactional
	 public int carCheckInStore(Integer carOrderId,CarGoodInfo carGoodInfo) {
		 //变更汽车的在库状态
		 int i=carGoodInfoMapper.updateCarInfoSelective(carGoodInfo);
		 int i1=0;
		 //查询是否已完成采购单下的全部入库且全部已检测OK 
		 if (carGoodInfo !=null) {
			Map<String, Object> mapo=new HashMap<>();
			mapo.put("carOrderId", carOrderId);
		 List<Map<String, Object>> list=carPurchaseOrderMapper.selectCarByPurchaseId(mapo);
		 boolean flag=true;
		 if(list != null) {
			 for (Map<String, Object> map : list) {
				//检测状态处理
					Integer carId=(Integer) map.get("id");
					if (carId !=null) {
						Map<String, Object> map2=new HashMap<>();
						map2.put("carId", carId);
						Map<String, Object> checkMap=carPurchaseOrderMapper.checkStatus(map2);
						Integer checkInteger=null;
						if (checkMap !=null) {
							checkInteger=(Integer) checkMap.get("check_status");
						}
						Integer storageStatus=null;//是否检测（integer） 1未检测2已检测3暂收未检测4已完成5拒收6整备7暂收待整备
						if (checkInteger ==null) {
							storageStatus=1;
						}else if (checkInteger==4) {
							storageStatus=3;
						}else if (checkInteger==1) {
							storageStatus=2;
						}else if (checkInteger==5) {
							storageStatus=4;
						}else if (checkInteger==2) {
							storageStatus=5;
						}else if (checkInteger==3) {
							storageStatus=6;
						}else if (checkInteger==6) {
							storageStatus=7;
						}
				 		//判断是否同时完成已检测OK和入库
						if(storageStatus!=4 && storageStatus!=5) {
							flag=false;
							break;
						}
					}
				}
			//采购单下的汽车全部入库(或者拒收)后修改采购单的状态
			 if (flag) {
				 CarPurchaseOrder record=new CarPurchaseOrder();
				 record.setId(carOrderId);
				 record.setOrderStatus(3);//采购单变为已完成
				 i1=carPurchaseOrderMapper.updateByPrimaryKeySelective(record);
			 }else {
				 CarPurchaseOrder record=new CarPurchaseOrder();
				 record.setId(carOrderId);
				 record.setOrderStatus(2);//采购单变为进行中
				 i1=carPurchaseOrderMapper.updateByPrimaryKeySelective(record);	
			 }
		 }
		 if (i>0) {
			return 1;
		 }
		 
      }
		 return 0;
	 }
	/**
	 * 洗车登记 wp
	 */
	@Override
	@Transactional
	public int carWashRecord(CarWash carWash) {
		return carWashMapper.insertSelective(carWash);
	}
	/**
	 * 洗车是否关联订单 wp
	 */
	@Override
	public Map<String, Object> carOrderWash(Integer carId) {
		return orderMapper.carOrderWash(carId);
	}
	/**
	 * 车系 wp
	 */
	@Override
	public List<Map<String, Object>> selectCarFamily(Map<String, Object> map) {
		return carFamilyMapper.selectCarFamily(map);
	}
	/**
	 * 车型 wp
	 */
	@Override
	public List<Map<String, Object>> selectCarConfByFamily(Map<String, Object> map) {
		return carVehicleConfMapper.selectCarConfByFamily(map);
	}
	/**
	 * 汽车外出申请单 wp
	 */
	@Override
	public List<Map<String, Object>> selectCarOutApply(Map<String, Object> map) {
		return carOutApplicationMapper.selectCarOutApply(map);
		
	}
	/**
	 * 申请单下的汽车 wp
	 */
	@Override
	public List<Map<String, Object>> selectCarListByApply(Map<String, Object> map) {
		return carOutApplicationMapper.selectCarListByApply(map);
	}
	/**
	 *变更汽车外出在库状态 wp
	 */
	@Override
	@Transactional
	public int updateByOutApplication(Integer storageStatus, Integer applicationId) {
		Map<String, Object> params = new HashMap<>();
		params.put("storageStatus", storageStatus);
		params.put("applicationId", applicationId);
		return carGoodInfoMapper.updateByOutApplication(params);
	}
	/**
	 * 盘点单状态 wp
	 */
	@Override
	public List<Map<String, Object>> selectPanDianDanStatus(String number) {
		return carDepotCheckMapper.selectPanDianDanStatus(number);
	}
	/**
	 * 通过ID查仓库名 wp
	 */
	@Override
	public CarWarehouse selectByPrimaryKey(Integer id) {
		return carWarehouseMapper.selectByPrimaryKey(id);
		
	}
	/**
	 * 调拨申请单 wp
	 */
	@Override
	public List<Map<String, Object>> selectAllotApplication(Map<String, Object> map) {
		return carAllotApplicationMapper.selectAllotApplication(map);
		
	}
	/**
	 * 外出申请单下的汽车列 wp
	 */
	@Override
	public List<Map<String, Object>> selectCarListByAllot(Map<String, Object> map) {
		return carAllotApplicationMapper.selectCarListByAllot(map);
	}
	/**
	 * 入库历史 wp
	 */
	@Override
	public List<Map<String, Object>> ruKuHistoryList(Map<String, Object> map) {
		return carPurchaseOrderMapper.ruKuHistoryList(map);
	}
	/**
	 *通过汽车ID查盘点记录 wp 
	 */
	@Override
	public Integer selectDepotByCarId(Integer carId) {
		return carDepotCheckMapper.selectDepotByCarId(carId);
	}
	/**
	 * 确认盘点提交 wp
	 */
	@Override
	@Transactional
	public int updateCheckDepot(CarDepotCheck carDepotCheck) {
		return carDepotCheckMapper.updateByNumberSelective(carDepotCheck);
	}
	/**
	 * 盘点人员列表 wp
	 */
	@Override
	public List<Employee> selectPanDianEmps(Map<String, Object> map) {
		return employeeMapper.selectPanDianEmps(map);
	}
	/**
	 * 库管我的加油记录 wp
	 */
	@Override
	public List<CarRefuelRecord> selectRefuleListByOperator(Map<String, Object> map) {
		return carRefuelRecordMapper.selectRefuleListByOperator(map);
	}
	/**
	 * 库管我的维修记录 wp
	 */
	@Override
	public List<CarMaintainRecord> selectMaintainListByOperator(Map<String, Object> map) {
		return carMaintainRecordMapper.selectMaintainListByOperator(map);
	}
	/**
	 * 汽车调拨改变汽车在库状态 wp
	 */
	@Override
	public int updateCarStoregStatusByAllot(Map<String, Object> map) {
		return carGoodInfoMapper.updateCarStoregStatusByAllot(map);
	}
	/**
	 * 检测后返回汽车信息状态 wp
	 */
	@Override
	public Map<String, Object> selectCheckAfterCarInfo(Map<String, Object> map) {
		return carGoodInfoMapper.selectCheckAfterCarInfo(map);
	}
	 //添加出库记录 wp
	@Transactional
	 public int insertCarOutStoreRecord(CarOutstorgeRecord carOutstorgeRecord) {
		 return carOutstorgeRecordMapper.insertSelective(carOutstorgeRecord);
	 }
	 /**
	  * 变更我的状态 wp
	  */
	@Override
	@Transactional
	public int updateEmpStatus(Map<String, Object> map) {
		return employeeMapper .updateEmpStatus(map);
		
	}
	/**
	 * 我的信息 wp
	 */
	@Override
	public Map<String, Object> myInfo(Map<String, Object> map) {
		return employeeMapper.myInfo(map);
	}
	/**
	 * 变更汽车检测登记记录 wp
	 */
	@Override
	@Transactional
	public int updateCheckRecord(CarCheckRecord carCheckRecord,Integer carOrderId) {
		int i=carCheckRecordMapper.updateCheckStatus(carCheckRecord);
		//查询是否已完成采购单下的全部入库且全部已检测OK 
		if (carOrderId !=null) {
			Map<String, Object> mapo=new HashMap<>();
			mapo.put("carOrderId", carOrderId);
		 List<Map<String, Object>> list=carPurchaseOrderMapper.selectCarByPurchaseId(mapo);
		 boolean flag=true;
		 if(list != null) {
			 for (Map<String, Object> map : list) {
			    //检测状态处理
				Integer carId=(Integer) map.get("id");
				if (carId !=null) {
					Map<String, Object> map2=new HashMap<>();
					map2.put("carId", carId);
					Map<String, Object> checkMap=carPurchaseOrderMapper.checkStatus(map2);
					Integer checkInteger=null;
					if (checkMap !=null) {
						checkInteger=(Integer) checkMap.get("check_status");
					}
					Integer storageStatus=null; //是否检测（integer） 1未检测2已检测3暂收未检测4已完成5拒收6整备7暂收待整备
					if (checkInteger ==null) {
						storageStatus=1;
					}else if (checkInteger==4) {
						storageStatus=3;
					}else if (checkInteger==1) {
						storageStatus=2;
					}else if (checkInteger==5) {
						storageStatus=4;
					}else if (checkInteger==2) {
						storageStatus=5;
					}else if (checkInteger==3) {
						storageStatus=6;
					}else if (checkInteger==6) {
						storageStatus=7;
					}
			 		//判断是否同时完成已检测OK和入库
					if(storageStatus!=4 && storageStatus!=5) {
						flag=false;
						break;
					}
				}
			}
		 }
		 //采购单下的汽车全部入库后修改采购单的状态
		 if (flag) {
			 CarPurchaseOrder record=new CarPurchaseOrder();
			 record.setId(carOrderId);
			 record.setOrderStatus(3);//采购单变为已完成
			 int i1=carPurchaseOrderMapper.updateByPrimaryKeySelective(record);
		 }else {
			 CarPurchaseOrder record=new CarPurchaseOrder();
			 record.setId(carOrderId);
			 record.setOrderStatus(2);//采购单变为进行中
			 int i1=carPurchaseOrderMapper.updateByPrimaryKeySelective(record);	
		 }
		}
		 return i;
	}
	/**
	 * 改变申请单的状态 wp
	 */
	@Override
	public int updateCarOutAppliStatus(CarOutApplication carOutApplication) {
		return carOutApplicationMapper.updateByPrimaryKeySelective(carOutApplication);
	}
	/**
	 * 检测整备添加整备记录 wp
	 */
	@Override
	public int insertZhengbeiRecord(CarZhengbeiRecord carZhengbeiRecord) {
		return carZhengbeiRecordMapper.insertSelective(carZhengbeiRecord);
	}
	/**
	 * 获取整备记录 wp
	 */
	@Override
	public CarZhengbeiRecord selectCarZhengbeiRecord(Integer zhengbeiId) {
		return carZhengbeiRecordMapper.selectByPrimaryKey(zhengbeiId);
	}
	/**
	 * 今日交车洗车记录 wp
	 */
	@Override
	public Map<String, Object> selectCarWashRecord(Map<String, Object> map) {
		return deliverCarMapper.selectCarWashRecord(map);
	}
	/**
	 * 今日交车维修记录 wp
	 */
	@Override
	public Map<String, Object> selectCarCheckRecord(Map<String, Object> map) {
		return deliverCarMapper.selectCarCheckRecord(map);
	}
	/**
	 * 汽车检测记录 wp
	 */
	@Override
	public Map<String, Object> checkStatus(Map<String, Object> map) {
		return carPurchaseOrderMapper.checkStatus(map);
		
	}
	/**
	 * 改变采购订单的处理状态 wp
	 */
	@Override
	public int updateCarOrderState(CarPurchaseOrder carPurchaseOrder) {
		return carPurchaseOrderMapper.updateByPrimaryKeySelective(carPurchaseOrder);
	}
	/**
	 * 暂收整备状态处理 wp
	 */
	@Override
	public Map<String, Object> zanshouZhengbeiStatus(Map<String, Object> map) {
		return carZhengbeiRecordMapper.zanshouZhengbeiStatus(map);
		
	}
	/**
	 * 改变汽车在库状态 wp
	 */
	@Override
	public int carCheckInStoreStatus(CarGoodInfo carGoodInfo) {
		return carGoodInfoMapper.updateCarInfoSelective(carGoodInfo);
	}
	/**
	 * 盘点是否有汽车盘点信息 wp
	 */
	@Override
	public List<Map<String, Object>> selectIsExistCar(Map<String, Object> map) {
		return carDepotCheckMapper.selectIsExistCar(map);
		
	}
}
