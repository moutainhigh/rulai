package com.unicdata.controller.car;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.DateUtil;
import com.unicdata.util.FileUtil;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.CarEnum.CarDisposeStatus;
import com.unicdata.constant.CarEnum.CarStorageStatus;
import com.unicdata.constant.CarEnum.CarWashStates;
import com.unicdata.constant.CarEnum.ColorStatus;
import com.unicdata.constant.ConstantEnum.CarCheckStatus;
import com.unicdata.constant.ConstantEnum.CarDepotCheckStatus;
import com.unicdata.constant.ConstantEnum.CarPriceStatus;
import com.unicdata.constant.ConstantEnum.DetectStatu;
import com.unicdata.constant.ConstantEnum.PanDianResult;
import com.unicdata.controller.HomeBaseController;
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
import com.unicdata.entity.car.CarWarehouse;
import com.unicdata.entity.car.CarWeihuRecord;
import com.unicdata.entity.car.CarZhengbeiRecord;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.car.AppCarColorService;
import com.unicdata.service.car.AppCarStoreService;
import com.unicdata.service.employee.AppEmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/app/carStore")
@Api(value = "库管", tags = {"库管"})
public class AppCarStoreController extends HomeBaseController{

	@Autowired
	private AppCarStoreService appCarStoreService;
	@Autowired
	private AppEmployeeService appEmployeeService;
	@Autowired
	private AppCarColorService appCarColorService;
	
	// 文件上传路径
	@Value("${upload.file.path}")
	private String uploadFilePath;
	// 图片上传路后缀
	@Value("${upload.picture.type}")
	private String uploadPictureType;
	//图片上传大小
	private static final long size=4194304;
	/**
	 * 库管首页 wp
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "库管首页")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/carStoreIndex",method = {RequestMethod.POST})
	public ApiReturnInfo carStoreIndex(
			HttpServletRequest request,
			Integer pageSize,
			Integer pageNum
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
    	Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	//交车
    	Map<String , Object> mapd=new HashMap<String , Object>();
    	mapd.put("storeId", storeId);
		mapd.put("deliveryDate",new Date());
    	PageInfo<Map<String , Object>> pageInfod=appCarStoreService.selectDeliverCarList(mapd,pageNum,pageSize);
    	List<Map<String , Object>> listdeliv=pageInfod.getList();
    	//外出
    	Map<String , Object> mapout=new HashMap<>();
		mapout.put("planOutDay", DateUtil.dateFormat(new Date(), DateUtil.sdf2));
		mapout.put("storeId", storeId);
	    List<Map<String, Object>> listout=appCarStoreService.selectCarOutApply(mapout);
    	//调拨
	    Map<String, Object> mapall=new HashMap<>();
	    mapall.put("storeId", storeId);
	    mapall.put("operateDate", DateUtil.dateFormat(new Date(), DateUtil.sdf2));
		List<Map<String , Object>> listall=appCarStoreService.selectAllotApplication(mapall);
    	int deliverNum=0;
    	int caroutNum=0;
    	int tiaoboNum=0;
    	if (listdeliv!=null&&listdeliv.size()>0) {
    		for (Map<String, Object> de : listdeliv) {
        		deliverNum++;
    		}
		}
    	if (listout!=null&&listout.size()>0) {
    		for (Map<String, Object> map1 : listout) {
        		caroutNum++;
    		}
		}
    	 if (listall!=null&&listall.size()>0) {
    		 for (Map<String, Object> map2 : listall) {
    	    		tiaoboNum++;
    		}
		}
    	Map<String, Object> map=new HashMap<>();
    	map.put("deliverNum",deliverNum );//交车数量
    	map.put("caroutNum", caroutNum);//外出数量
    	map.put("tiaoboNum", tiaoboNum);//调拨数量
    	//保险到期提醒
    	PageInfo<Map<String, Object>> pageInfo1=appCarStoreService.selectInsurerRemind(pageNum, pageSize,storeId);
		Map<String, Object> mapr=new HashMap<>();
		mapr.put("list", pageInfo1.getList());
		mapr.put("pageResult", getPageResult(pageInfo1));
		map.put("insurer", mapr);
		ar.setData(map);
    	return ar;
	}
	/**
	 * 商品车列 wp
	 * @param request
	 * @param chexingName
	 * @param chexiName
	 * @param pinpaiName
	 * @param outColor
	 * @param inColor
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ApiOperation(value = "商品车")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectCarList",method = {RequestMethod.POST})
	public ApiReturnInfo selectCarList(
			HttpServletRequest request,
			Integer chexingName,
			Integer chexiName,
			String searchName,
			Integer storageStatus,
			String outColor,
			String inColor,
			Integer pageNum,
			Integer pageSize) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
		//汽车列表
    	Map<String , Object> map2=new HashMap<String , Object>();
    	map2.put("storeId", storeId);
    	map2.put("chexingName", chexingName);
    	map2.put("chexiName", chexiName);
    	map2.put("searchName", searchName);
    	map2.put("storageStatus", storageStatus);
    	map2.put("outColor", outColor);
    	map2.put("inColor", inColor);
    	PageInfo pageInfo=appCarStoreService.selectCarList(map2, pageNum, pageSize);
    	List<Map<String, Object>> listcar=pageInfo.getList();
    	if (listcar !=null) {
    		for (Map<String, Object> map : listcar) {
    			//处理洗车状态
        		String vin=(String) map.get("vin");
        		Map<String, Object> mapc1=new HashMap<>();
    			mapc1.put("vin", vin);
    			Map<String, Object> washMap=appCarStoreService.selectCarWashRecord(mapc1);
    			Integer washInteger=null;
    			if (washMap !=null) {
    				washInteger=(Integer) washMap.get("state");
    			}
    			if (washInteger == null) {
    				map.put("wash_status", 1);
    			}else if (washInteger == 1 || washInteger==0) {
    				map.put("wash_status", 0);
    			}else if (washInteger==2) {
    				map.put("wash_status", 2);
    			}
    		}
		}
    	//车系
    	List<Map<String, Object>> listFamily=appCarStoreService.selectCarFamily(map2);
    	Map<String, Object> map=new HashMap<>();
    	map.put("listcar", listcar);
    	map.put("carFamily", listFamily);
    	map.put("pageResult",getPageResult(pageInfo));
    	ar.setData(map);
    	return ar;
	}
	
	/**
	 * 试驾车列wp
	 * @param request
	 * @param chexingName
	 * @param chexiName
	 * @param pinpaiName
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ApiOperation(value = "试驾车列表")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectTestCarList",method = {RequestMethod.POST})
	public ApiReturnInfo selectCarList(
			HttpServletRequest request, 
			String searchName,
			Integer pageNum,
			Integer pageSize
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	//汽车列表
    	Map<String , Object> map2=new HashMap<String , Object>();
    	map2.put("searchName", searchName);
    	map2.put("storeId", storeId);
    	PageInfo pageInfo=appCarStoreService.selectTestCarList(map2, pageNum, pageSize);
    	List<Map<String, Object>> listcar=pageInfo.getList();
    	Map<String, Object> map=new HashMap<>();
    	map.put("listcar", listcar);
    	map.put("pageResult",getPageResult(pageInfo));
    	ar.setData(map);
    	return ar;
	}
	
	/**
	 * 商品车详情
	 * @param request
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "商品车详情")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/carDetailInfo",method = {RequestMethod.POST})
	public ApiReturnInfo carDetailInfo(
			HttpServletRequest request,
			Integer id
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	Map<String , Object> map=new HashMap<String , Object>();
    	map.put("id", id);
//    	map.put("id", 2);
    	map.put("storeId", storeId);
    	Map<String, Object> carGoodInfo=appCarStoreService.carDetailInfo(map);
    	ar.setData(carGoodInfo);
    	return ar;
	}
	
	/**
	 * 试驾车详情 wp
	 * @param request
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "试驾车详情")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/carTestDetailInfo",method = {RequestMethod.POST})
	public ApiReturnInfo carTestDetailInfo(
			HttpServletRequest request,
			Integer id
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	Map<String , Object> map=new HashMap<String , Object>();
//    	map.put("id", id);
    	map.put("id", 1);
    	map.put("storeId", storeId);
    	Map<String, Object> carTestInfo=appCarStoreService.carTestDetailInfo(map);
    	ar.setData(carTestInfo);
    	return ar;
	}
	
	/**
	 * 外出列表
	 * @param request
	 * @param date
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ApiOperation(value = "车外出列")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/carOutList",method = {RequestMethod.POST})
	public ApiReturnInfo carOutList(
			HttpServletRequest request,
			Date date,
			Integer pageNum,
			Integer pageSize
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	//外出
    	Map<String , Object> maps=new HashMap<String , Object>();
    	maps.put("storeId",storeId);
    	if(date==null) {
    		maps.put("outDay",new Date());
    	}else {
			maps.put("outDay", date);//需时间转换
		}
    	PageInfo<Map<String, Object>> pageInfo=appCarStoreService.selectCarOutList(maps,pageNum,pageSize);
    	List<Map<String, Object>> list=pageInfo.getList();
    	Map<String, Object> map=new HashMap<>();
    	map.put("carOut", list);
    	map.put("pageResult", getPageResult(pageInfo));
    	ar.setData(map);
    	return ar;
	}
	
	/**
	 * 今日交车列表
	 * @param request
	 * @param date
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ApiOperation(value = "交车列")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/deliverCarList",method = {RequestMethod.POST})
	public ApiReturnInfo deliverCarList(
			HttpServletRequest request,
			String date,//选取的日期
			Integer pageNum,
			Integer pageSize
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	//交车
    	Map<String , Object> mapd=new HashMap<String , Object>();
    	mapd.put("storeId", storeId);
    	if(date==null) {
    		mapd.put("deliveryDate",new Date());	
    	}else {
    		mapd.put("deliveryDate",DateUtil.stringToDate(date, DateUtil.sdf2));//需时间转换	
		}
    	PageInfo<Map<String , Object>> pageInfod=appCarStoreService.selectDeliverCarList(mapd,pageNum,pageSize);
    	List<Map<String , Object>> list=pageInfod.getList();
    	//处理洗车记录及pdi检测记录
    	for (Map<String, Object> map : list) {
			Integer carId=(Integer) map.get("id");
			String vin = (String) map.get("vin");
			Map<String, Object> mapc=new HashMap<>();
			mapc.put("carId", carId);
			Map<String, Object> checkMap=appCarStoreService.selectCarCheckRecord(mapc);
			Integer checkInteger=null;
			if (checkMap !=null) {
				checkInteger=(Integer) checkMap.get("check_status");
			}
			if (checkInteger == null) {
				map.put("pdi_status", 1);
			}else if (checkInteger==3) {
				map.put("pdi_status", 3);
			}else if(checkInteger==1){
				map.put("pdi_status", 2);
			}
			Map<String, Object> mapc1=new HashMap<>();
			mapc1.put("vin", vin);
			Map<String, Object> washMap=appCarStoreService.selectCarWashRecord(mapc1);
			Integer washInteger=null;
			if (washMap !=null) {
				washInteger=(Integer) washMap.get("state");
			}
			if (washInteger == null) {
				map.put("wash_status", 1);
			}else if (washInteger == 1 || washInteger==0) {
				map.put("wash_status", 0);
			}else if (washInteger==2) {
				map.put("wash_status", 2);
			}
		}
    	Map<String, Object> map=new HashMap<>();
    	map.put("pageResult", getPageResult(pageInfod));
    	map.put("deliverCar", list);
    	ar.setData(map);
    	return ar;
	}
	
	/**
	 * 试驾车的加油记录列表 wp
	 * @param request
	 * @param testCarId
	 * @return
	 */
	@ApiOperation(value = "加油列")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/refuelRecordList",method = {RequestMethod.POST})
	public ApiReturnInfo refuelRecordList(
			HttpServletRequest request,
			Integer testCarId
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	List<CarRefuelRecord> list=appCarStoreService.selectListByTestCar(testCarId);
    	ar.setData(list);
    	return ar;
	}
	
	/**
	 * 加油登记 wp
	 * @param request
	 * @param testCarId
	 * @return
	 */
	@ApiOperation(value = "加油登记")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/refuelRecord",method = {RequestMethod.POST})
 	public ApiReturnInfo refuelRecord(
 			HttpServletRequest request,
 			Integer testCarId,
 			String remark,
 			String date,
 			Double oilNum,
 			BigDecimal price,
// 			@RequestParam(value = "file", required = false) MultipartFile oilCard ,
//			@RequestParam(value = "file", required = false) MultipartFile oilTicket
 			String oilCard,
 			String oilTicket
 			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	CarRefuelRecord record=new CarRefuelRecord();
    	record.setCreateDate(DateUtil.stringToDate(date, DateUtil.sdf2));
    	record.setFuelCapacity(oilNum);//加油量
    	record.setPrice(price);
    	record.setOilCard(oilCard);
    	record.setGasolineCoupon(oilTicket);
    	record.setOperatorId(emp.getId());
    	record.setRemark(remark);
    	record.setTestCarId(testCarId);
    	//上传图片
//    	String oilCardp ="";
//    	String oilTicketp ="";
//    	if (null != oilCard) {
//			try {
//				// 验证图片格式
//				// 原始的文件名
//				String filename = oilCard.getOriginalFilename();
//				// 获取扩展名
//				String extensionName = StringUtils.substringAfterLast(filename, ".");
//				if (uploadPictureType.indexOf(extensionName) < 0 ) {
//					ar.setCode(ConstantEnumStatus.FAIL.getCode());
//					ar.setMessage("图片请上传后缀为'" + uploadPictureType + "'文件");
//					return ar;
//				}
//				if (oilCard.getSize() > size) {
//					ar.setCode(ConstantEnumStatus.FAIL.getCode());
//					ar.setMessage("图片大小请限制在" + FileUtil.FormetFileSize(size) + "以内");
//					return ar;
//				}
//				oilCardp = FileUtil.uploadFile(oilCard.getInputStream(), oilCard.getOriginalFilename(), null,
//						"/picture", uploadFilePath);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//    	if (null !=oilTicket) {
//			try {
//				// 验证图片格式
//				// 原始的文件名
//				String filename1 = oilTicket.getOriginalFilename();
//				// 获取扩展名
//				String extensionName1 = StringUtils.substringAfterLast(filename1, ".");
//				if (uploadPictureType.indexOf(extensionName1) < 0) {
//					ar.setCode(ConstantEnumStatus.FAIL.getCode());
//					ar.setMessage("图片请上传后缀为'" + uploadPictureType + "'文件");
//					return ar;
//				}
//				if (oilTicket.getSize() > size) {
//					ar.setCode(ConstantEnumStatus.FAIL.getCode());
//					ar.setMessage("图片大小请限制在" + FileUtil.FormetFileSize(size) + "以内");
//					return ar;
//				}
//				oilTicketp = FileUtil.uploadFile(oilTicket.getInputStream(), oilTicket.getOriginalFilename(), null,
//						"/picture", uploadFilePath);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//    	record.setOilCard(oilCardp);//油卡
//    	record.setGasolineCoupon(oilTicketp);//油票
    	record.setOilCard(oilCard);
    	record.setGasolineCoupon(oilTicket);
    	int i=appCarStoreService.insertSelective(record);
    	if (i<=0) {
    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
		} 
    	return ar;
	}
	/**
	 * 今日调拨列 wp
	 * @param request
	 * @param date
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ApiOperation(value = "今日调拨列")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/carAllotList",method = {RequestMethod.POST})
	public ApiReturnInfo carAllot(
			HttpServletRequest request,
			String date,//选取的日期
			Integer pageNum,
			Integer pageSize
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	Map<String , Object> map=new HashMap<String , Object>();
    	map.put("storeId", storeId);
    	if(date==null) {
    		map.put("operateDate",DateUtil.dateFormat(new Date(), DateUtil.sdf2));	
    	}else {
    		map.put("operateDate",DateUtil.dateFormat(DateUtil.stringToDate(date, DateUtil.sdf2), DateUtil.sdf2));//需时间转换	
		}
    	PageInfo<Map<String , Object>> pageInfo=appCarStoreService.carAllotList(map, pageNum, pageSize);
    	List<Map<String , Object>> list=pageInfo.getList();
    	Map<String , Object> mapd=new HashMap<String , Object>();
    	mapd.put("list",list);
    	mapd.put("pageResult", getPageResult(pageInfo));
    	ar.setData(mapd);
    	return ar;
	}
	
	/**
	 * 整备提醒 wp
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ApiOperation(value = "整备提醒")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/detectionCarList",method = {RequestMethod.POST})
	public ApiReturnInfo detectionCarList(
			HttpServletRequest request,
			Integer pageNum,
			Integer pageSize
			) { 
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	Map<String, Object> map=new HashMap<>();
    	PageInfo<Map<String, Object>> pageInfo=appCarStoreService.detectionCarList(map, pageNum, pageSize);
    	List<Map<String, Object>> list=pageInfo.getList();
    	int zbNum=0;
    	if (list.size()>0&&list!=null) {
    		for (Map<String, Object> map2 : list) {
    			zbNum++;
    		}
		}
    	Map<String, Object> mapr=new HashMap<>();
    	mapr.put("list", list);
    	mapr.put("zbNum", zbNum);
    	mapr.put("pageResult",getPageResult(pageInfo));
    	ar.setData(mapr);
		return ar;
	}
	
	/**
	 * 扫一扫wp
	 * @param vin
	 * @return
	 */
	@ApiOperation(value = "扫一扫")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/carScan",method = {RequestMethod.POST})
	public ApiReturnInfo carScan(String vin) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Map<String, Object> map=appCarStoreService.carScan(vin);
		Map<String, Object> mapr=new HashMap<>();
//		Map<String, Object> map=appCarStoreService.carScan("vin12541138111");
		if(map!=null) {
			mapr.put("carInfo", map);
			ar.setData(map);	
		}else{
			Map<String, Object> mapt=appCarStoreService.carTestScan(vin);
//			Map<String, Object> mapt=appCarStoreService.carTestScan("vin1254113888");
			if(mapt !=null) {
				mapt.put("carType", "试驾车");
				mapr.put("carInfo", mapt);
			}
			ar.setData(mapr);
		}
		return ar;
	}
	/**
	 * 入库录单 wp
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ApiOperation(value = "入库录单")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/carRukuList",method = {RequestMethod.POST})
	public ApiReturnInfo carRukuList(
			HttpServletRequest request,
			Integer pageNum,
			Integer pageSize
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	Map<String, Object> map=new HashMap<>();
    	map.put("storeId", storeId);
    	PageInfo<Map<String, Object>> pageInfo=appCarStoreService.carRukuList(map, pageNum, pageSize);
    	List<Map<String, Object>> list=pageInfo.getList();
    	Map<String, Object> mapr=new HashMap<>();
    	mapr.put("list",list);
    	mapr.put("pageResult", getPageResult(pageInfo));
    	ar.setData(mapr);
    	return ar;
	}
	
	/**
	 * 试驾车维修登记 wp
	 * @param carId
	 * @param maintainPage
	 * @param remark
	 * @param startTime
	 * @param endTime
	 * @param request
	 * @param operatorId
	 * @return
	 */
	@ApiOperation(value = "维修登记")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/weixiuRecord",method = {RequestMethod.POST})
	public ApiReturnInfo weixiuRecord(
			Integer carId,
//			@RequestParam(value = "file", required = false) MultipartFile maintainPage,//维修单
			String maintainPage,
			String remark,
			String startTime,
			String endTime,
			HttpServletRequest request
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	//上传图片
//    	String maintainPagep ="";
//    	if (null != maintainPage) {
//			try {
//				// 验证图片格式
//				// 原始的文件名
//				String filename = maintainPage.getOriginalFilename();
//				// 获取扩展名
//				String extensionName = StringUtils.substringAfterLast(filename, ".");
//				if (uploadPictureType.indexOf(extensionName) < 0 ) {
//					ar.setCode(ConstantEnumStatus.FAIL.getCode());
//					ar.setMessage("图片请上传后缀为'" + uploadPictureType + "'文件");
//					return ar;
//				}
//				if (maintainPage.getSize() > size) {
//					ar.setCode(ConstantEnumStatus.FAIL.getCode());
//					ar.setMessage("图片大小请限制在" + FileUtil.FormetFileSize(size) + "以内");
//					return ar;
//				}
//				maintainPagep = FileUtil.uploadFile(maintainPage.getInputStream(), maintainPage.getOriginalFilename(), null,
//						"/picture", uploadFilePath);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
    	CarMaintainRecord carMaintainRecord=new CarMaintainRecord();
    	carMaintainRecord.setCreateDate(new Date());
    	carMaintainRecord.setStartTime(DateUtil.stringToDate(startTime, DateUtil.sdf3));
    	carMaintainRecord.setEndTime(DateUtil.stringToDate(endTime,DateUtil.sdf3));
    	carMaintainRecord.setTestCarId(carId);
    	carMaintainRecord.setOperatorId(emp.getId());
//    	carMaintainRecord.setMaintainPage(maintainPagep);
    	carMaintainRecord.setMaintainPage(maintainPage);
    	carMaintainRecord.setRemark(remark);
    	int i=appCarStoreService.weixiuRecord(carMaintainRecord);
    	if (i<=0) {
    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
		} 
    	return ar;
	}
	
	/**
	 * 维修历史 wp
	 * @param testCarId
	 * @return
	 */
	@ApiOperation(value = "维修历史")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectMaintanList",method = {RequestMethod.POST})
	public ApiReturnInfo selectMaintanList(Integer testCarId) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		List<CarMaintainRecord> list=appCarStoreService.selectMaintanList(testCarId);
		ar.setData(list);
		return ar;
	}
	
	/**
	 * 维护登记 wp
	 * @param carId
	 * @param remark
	 * @param startTime
	 * @param endTime
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "维护登记")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/weihuRecord",method = {RequestMethod.POST})
	public ApiReturnInfo weihuRecord(
			Integer carId,
			String remark,
			String startTime,
			String endTime,
			HttpServletRequest request
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	CarWeihuRecord carWeihuRecord=new CarWeihuRecord();
    	carWeihuRecord.setCarId(carId);
    	carWeihuRecord.setCreateDate(new Date());
    	carWeihuRecord.setStartTime(DateUtil.stringToDate(startTime,DateUtil.sdf1));
    	carWeihuRecord.setEndTime(DateUtil.stringToDate(endTime, DateUtil.sdf1));
    	carWeihuRecord.setStoreId(storeId);
    	carWeihuRecord.setRemark(remark);
    	int i=appCarStoreService.weihuRecord(carWeihuRecord);
    	if (i<=0) {
    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
		} 
    	return ar;
	}
	
	/**
	 * 商品车维护历史 wp
	 * @param testCarId
	 * @return
	 */
	@ApiOperation(value = "维护历史")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectWeihuList",method = {RequestMethod.POST})
	public ApiReturnInfo selectWeihuList(Integer carId) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		List<Map<String, Object>> list=appCarStoreService.selectByCarId(carId);
		ar.setData(list);
		return ar;
	}
	
	/**
	 * 检验检测登记 wp
	 * @param request
	 * @param carId
	 * @param checkPage
	 * @param exceptionPhoto
	 * @param exceptionExplain
	 * @param checkStatus
	 * @param updateTime
	 * @return
	 */
	@ApiOperation(value = "检验登记")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/insertCheckRecord",method = {RequestMethod.POST})
	public ApiReturnInfo insertCheckRecord(
			HttpServletRequest request,
			Integer carId,
			Integer carOrderId,
			Integer type, //传1暂收检测 2pdi检测 null不传则默认初始检测
//			@RequestParam(value = "file", required = false) MultipartFile[] checkPage,
//			@RequestParam(value = "file", required = false) MultipartFile[]  exceptionPhoto,
			String checkPage,
			String exceptionPhoto,
			String exceptionExplain,
			String vin,
			//检验状态，1检查OK 2拒收 3整备
			Integer checkStatus
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
		CarCheckRecord carCheckRecord=new CarCheckRecord();
		carCheckRecord.setCarId(carId);
		if (exceptionExplain !=null) {
			carCheckRecord.setExceptionExplain(exceptionExplain);
		}
		carCheckRecord.setStoreId(storeId);
		carCheckRecord.setExceptionPhoto(exceptionPhoto);
		carCheckRecord.setCheckPage(checkPage);
		//当checkStatus为1已检测 汽车表无改动,当为2拒收时汽车表store_status改为6拒收
		CarGoodInfo record=new CarGoodInfo();
		record.setId(carId);
			if (type !=null) {//1暂收未检测 2pdi检测
				if (type==1) {//暂收未检测，入库后进行检测
					if(checkStatus==CarCheckStatus.拒收.getCode()) {
						record.setStorageStatus(CarStorageStatus.REFUSE.getCode());
						record.setUpdateDate(new Date());
						record.setDisposeStatus(CarDisposeStatus.REFULSE.getCode());//暂收在库 处理拒收 
						int ic=appCarStoreService.updateCarStatus(record);
						//变更检验记录
						carCheckRecord.setUpdateTime(new Date());
						carCheckRecord.setCheckStatus(CarCheckStatus.拒收.getCode());
						carCheckRecord.setCarId(carId);
						carCheckRecord.setCheckType(0);
						int icc=appCarStoreService.updateCheckRecord(carCheckRecord, carOrderId);
					}else if(checkStatus==CarCheckStatus.整备.getCode()){//当checkStatus为3整备 汽车表改为待整备
						record.setDisposeStatus(CarDisposeStatus.REPAIR_WAIT.getCode());//待整备
						int ic=appCarStoreService.updateCarStatus(record);
						//变更检验记录
						carCheckRecord.setCarId(carId);
						carCheckRecord.setCheckType(0);
						carCheckRecord.setUpdateTime(new Date());
						carCheckRecord.setCheckStatus(CarCheckStatus.暂收待整备.getCode());
						int icc=appCarStoreService.updateCheckRecord(carCheckRecord, carOrderId);
						//生成整备记录
						CarZhengbeiRecord carZhengbeiRecord =new CarZhengbeiRecord();
						carZhengbeiRecord.setCarId(carId);
						carZhengbeiRecord.setVin(vin);//??
						carZhengbeiRecord.setStoreId(storeId);
						carZhengbeiRecord.setCreateTime(new Date());
						carZhengbeiRecord.setDetectStatus(DetectStatu.未生成工单1.getId());//整备状态 1未生成工单 2待送修 3维修中 4维修完成
						carZhengbeiRecord.setZhengbeiType(1);//整备类型 1采购单入库 2销售出库单 3商品车库存
						int j=appCarStoreService.insertZhengbeiRecord(carZhengbeiRecord);
					}else if(checkStatus==CarCheckStatus.检验OK.getCode()){
						record.setUpdateDate(new Date());
						record.setDisposeStatus(CarDisposeStatus.NORMAL.getCode());//正常
						int ic=appCarStoreService.updateCarStatus(record);
						//通过汽车ID完善暂收入库汽车的检测信息
						carCheckRecord.setUpdateTime(new Date());
						carCheckRecord.setCheckStatus(CarCheckStatus.已完成.getCode());
						carCheckRecord.setCarId(carId);
						carCheckRecord.setCheckType(0);
						int i=appCarStoreService.updateCheckRecord(carCheckRecord, carOrderId);
					}
				}
				if (type==2){//pdi检测
					if(checkStatus==CarCheckStatus.拒收.getCode()) {
						record.setStorageStatus(CarStorageStatus.REFUSE.getCode());
						record.setUpdateDate(new Date());
						int ic=appCarStoreService.updateCarStatus(record);
						//登记pdi检测信息
						carCheckRecord.setUpdateTime(new Date());
						carCheckRecord.setCheckType(1);//PDI检测
						carCheckRecord.setCheckStatus(CarCheckStatus.拒收.getCode());
						int i=appCarStoreService.insertCheckRecord(carCheckRecord);
					}else if(checkStatus ==CarCheckStatus.整备.getCode()){//当checkStatus为3整备 汽车表改为待整备
						record.setDisposeStatus(CarDisposeStatus.REPAIR_WAIT.getCode());//待整备
						int ic=appCarStoreService.updateCarStatus(record);
						//登记pdi检测信息
						carCheckRecord.setUpdateTime(new Date());
						carCheckRecord.setCheckType(1);//PDI检测
						carCheckRecord.setCheckStatus(CarCheckStatus.整备.getCode());
						int i=appCarStoreService.insertCheckRecord(carCheckRecord);
						//生成整备记录
						CarZhengbeiRecord carZhengbeiRecord =new CarZhengbeiRecord();
						carZhengbeiRecord.setCarId(carId);
						carZhengbeiRecord.setCreateTime(new Date());
						carZhengbeiRecord.setVin(vin);//??
						carZhengbeiRecord.setStoreId(storeId);
						carZhengbeiRecord.setDetectStatus(DetectStatu.未生成工单1.getId());//整备状态 1未生成工单 2待送修 3维修中 4维修完成
						carZhengbeiRecord.setZhengbeiType(2);//整备类型 1采购单入库 2销售出库单 3商品车库存
						int j=appCarStoreService.insertZhengbeiRecord(carZhengbeiRecord);
					}else if(checkStatus==CarCheckStatus.检验OK.getCode()){
						//通过汽车ID完善暂收入库汽车的检测信息
						carCheckRecord.setUpdateTime(new Date());
						carCheckRecord.setCheckType(1);//PDI检测
						carCheckRecord.setCheckStatus(CarCheckStatus.检验OK.getCode());
						int i=appCarStoreService.insertCheckRecord(carCheckRecord);
					}
				}
				
			}
			if (type==null) {//采购清单首次检测 
				if(checkStatus==CarCheckStatus.拒收.getCode()) {
					record.setStorageStatus(CarStorageStatus.REFUSE.getCode());
					record.setUpdateDate(new Date());
					record.setDisposeStatus(CarDisposeStatus.REFULSE.getCode());//在库状态拒收 处理状态拒收
					int ic=appCarStoreService.updateCarStatus(record);
					//登记检测信息
					carCheckRecord.setCreateTime(new Date());
					carCheckRecord.setCheckStatus(CarCheckStatus.拒收.getCode());
					int i=appCarStoreService.insertCheckRecord(carCheckRecord);
					//变更订单处理状态为处理中
					CarPurchaseOrder carPurchaseOrder=new CarPurchaseOrder();
					carPurchaseOrder.setId(carOrderId);
					carPurchaseOrder.setOperateDate(new Date());
					carPurchaseOrder.setOrderStatus(2);
					int j=appCarStoreService.updateCarOrderState(carPurchaseOrder);
				}else if(checkStatus==CarCheckStatus.整备.getCode()){//当checkStatus为3整备 汽车表改为待整备
					record.setDisposeStatus(CarDisposeStatus.REPAIR_WAIT.getCode());//待整备
					record.setUpdateDate(new Date());
					int ic=appCarStoreService.updateCarStatus(record);
					//登记检测信息
					carCheckRecord.setCreateTime(new Date());
					carCheckRecord.setCheckStatus(CarCheckStatus.整备.getCode());
					int i=appCarStoreService.insertCheckRecord(carCheckRecord);
					//生成整备记录
					CarZhengbeiRecord carZhengbeiRecord =new CarZhengbeiRecord();
					carZhengbeiRecord.setCarId(carId);
					carZhengbeiRecord.setVin(vin);//??
					carZhengbeiRecord.setStoreId(storeId);
					carZhengbeiRecord.setCreateTime(new Date());
					carZhengbeiRecord.setDetectStatus(DetectStatu.未生成工单1.getId());//整备状态 1未生成工单 2待送修 3维修中 4维修完成
					carZhengbeiRecord.setZhengbeiType(1);//整备类型 1采购单入库 2销售出库单 3商品车库存
					int j=appCarStoreService.insertZhengbeiRecord(carZhengbeiRecord);
					//变更订单处理状态为处理中
					CarPurchaseOrder carPurchaseOrder=new CarPurchaseOrder();
					carPurchaseOrder.setId(carOrderId);
					carPurchaseOrder.setOperateDate(new Date());
					carPurchaseOrder.setOrderStatus(2);
					int k=appCarStoreService.updateCarOrderState(carPurchaseOrder);
				}else if(checkStatus==CarCheckStatus.检验OK.getCode()){
					carCheckRecord.setCreateTime(new Date());
					carCheckRecord.setCheckStatus(CarCheckStatus.检验OK.getCode());
					int i=appCarStoreService.insertCheckRecord(carCheckRecord);
					//变更订单处理状态为处理中
					CarPurchaseOrder carPurchaseOrder=new CarPurchaseOrder();
					carPurchaseOrder.setId(carOrderId);
					carPurchaseOrder.setOrderStatus(2);
					carPurchaseOrder.setOperateDate(new Date());
					int j=appCarStoreService.updateCarOrderState(carPurchaseOrder);
				}
			}
		//返回汽车信息
		Map<String, Object> map =new HashMap<>();
		map.put("carId", carId);
		Map<String, Object> carinfo=appCarStoreService.selectCheckAfterCarInfo(map);
		Map<String, Object> checkMap=appCarStoreService.checkStatus(map);
		if (checkMap !=null) {
			Integer check_status=(Integer) checkMap.get("check_status");
			carinfo.put("check_status", check_status);
		}
		ar.setData(carinfo);
		return ar;
	}
	
	/**
	 * 门店仓库 wp
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "门店仓库")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/carWarehouse",method = {RequestMethod.POST})
	public ApiReturnInfo carWarehouse(
			HttpServletRequest request
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
		Integer storeId=emp.getStoreId();
		List<CarWarehouse> list=appCarStoreService.selectCarWarehouseByStore(storeId);
		ar.setData(list);
		return ar;
	}
	
	/**
	 * 仓库库位 wp
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "仓库下的库位")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectCarStoreByWarehouse",method = {RequestMethod.POST})
	public ApiReturnInfo selectCarStoreByWarehouse(
			HttpServletRequest request,
			Integer warehouseId
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
		Integer storeId=emp.getStoreId();
		List<Map<String, Object>> list=appCarStoreService.selectCarStoreByWarehouse(warehouseId);
		ar.setData(list);
		return ar;
	}
	
	/**
	 * 入库登记 wp
	 * @param request
	 * @param warehouseId
	 * @param storageId
	 * @return
	 */
	@ApiOperation(value = "入库登记")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "warehouseId", value = "仓库ID", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "storageId", value = "库位ID", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "carOrderId", value = "采购单ID", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/carCheckInStore",method = {RequestMethod.POST})
	public ApiReturnInfo carCheckInStore(
			HttpServletRequest request,
			Integer warehouseId,
			Integer storageId,
			String remark,
			Integer type,//区分暂收入库 1暂收入库 2待整备入库  null已检测OK(不传)
			Integer carOrderId,
			Integer carId,
			String twoDimensionalCode
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
		Integer operatorId=emp.getId();
    	Integer storeId=emp.getStoreId();
    	CarGoodInfo carGoodInfo=new CarGoodInfo();
    	//暂收入库
    	carGoodInfo.setStorageStatus(CarStorageStatus.IN_STORAGE.getCode());//在库状态（在库）
    	carGoodInfo.setOperatorId(operatorId);
    	carGoodInfo.setInStorageDate(new Date());
    	carGoodInfo.setId(carId);
    	carGoodInfo.setWarehouseId(warehouseId);
    	carGoodInfo.setStorageId(storageId);
    	carGoodInfo.setInstoreRemark(remark);//入库备注
    	carGoodInfo.setTwoDimensionalCode(twoDimensionalCode);
    	if (type !=null) {//暂收入库、整备入库
    		if (type==1) {//暂收入库
    			carGoodInfo.setDisposeStatus(CarDisposeStatus.IN_TEMPORARY.getCode());//处理状态暂收
    			//执行汽车入库（service处理业务）
    	    	int i=appCarStoreService.carCheckInStoreStatus(carGoodInfo);
    			//在检测表插入一条检验结果为 4暂收未检测记录
        		CarCheckRecord carCheckRecord=new CarCheckRecord();
        		carCheckRecord.setCarId(carId);
        		carCheckRecord.setCreateTime(new Date());
        		carCheckRecord.setStoreId(storeId);
        		carCheckRecord.setUpdateTime(new Date());
        		carCheckRecord.setCheckStatus(CarCheckStatus.暂收未检测.getCode());
        		int j=appCarStoreService.insertCheckRecord(carCheckRecord);
        		//变更订单处理状态为处理中
    			CarPurchaseOrder carPurchaseOrder=new CarPurchaseOrder();
    			carPurchaseOrder.setId(carOrderId);
    			carPurchaseOrder.setOrderStatus(2);
    			carPurchaseOrder.setOperateDate(new Date());
    			int k=appCarStoreService.updateCarOrderState(carPurchaseOrder);
			}
    		if (type==2) {//整备入库
    			//执行汽车入库（service处理业务）
    	    	int i=appCarStoreService.carCheckInStoreStatus(carGoodInfo);
				//暂收整备状态处理 判断是否在库，整备完成
    			Map<String, Object> mapzan=new HashMap<>();
    			mapzan.put("carId", carId);
    			Map<String, Object> zanzhengMap=appCarStoreService.zanshouZhengbeiStatus(mapzan);
    			Integer storage_status=null;
    			Integer detect_status=null;
    			if (zanzhengMap !=null) {
    				storage_status=(Integer) zanzhengMap.get("storage_status");
    				detect_status=(Integer) zanzhengMap.get("detect_status");
    				if (storage_status!=null && detect_status !=null) {
    					if (storage_status==2 && detect_status==4) {//先整备再入库
    						//将汽车的状态改变为处理完成
    						//通过汽车ID完善暂收入库汽车的检测信息
    						CarCheckRecord carCheckRecord=new CarCheckRecord();
    						carCheckRecord.setUpdateTime(new Date());
    						carCheckRecord.setCheckStatus(CarCheckStatus.已完成.getCode());
    						carCheckRecord.setCarId(carId);
    						carCheckRecord.setCheckType(0);
    						int j=appCarStoreService.updateCheckRecord(carCheckRecord, carOrderId);
    					}
    					if (storage_status==2 && detect_status!=4) {//先入库再整备
    						//通过汽车ID完善暂收入库汽车的检测信息
    						CarCheckRecord carCheckRecord=new CarCheckRecord();
    						carCheckRecord.setUpdateTime(new Date());
    						carCheckRecord.setCheckStatus(CarCheckStatus.暂收待整备.getCode());
    						carCheckRecord.setCarId(carId);
    						carCheckRecord.setCheckType(0);
    						int j=appCarStoreService.updateCheckRecord(carCheckRecord, carOrderId);
						}
    				}
    			}
			}
    	}
    	if (type ==null) {//检验OK后入库
			carGoodInfo.setDisposeStatus(CarDisposeStatus.NORMAL.getCode());//处理状态正常
			CarCheckRecord carCheckRecord=new CarCheckRecord();
			carCheckRecord.setCarId(carId);
			carCheckRecord.setCheckType(0);
			carCheckRecord.setCheckStatus(CarCheckStatus.已完成.getCode());
			int s=appCarStoreService.updateCheckRecord(carCheckRecord,carOrderId);
			//执行汽车入库（service处理业务）
	    	int i=appCarStoreService.carCheckInStoreStatus(carGoodInfo);
	    	if (i<=0) {
	    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
	 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
			}
    	}
    	int i=appCarStoreService.carCheckInStore(carOrderId, carGoodInfo);//变更订单处理状态
    	if (i<=0) {
    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
		}
    	return ar;
	}
	
	/**
	 * 盘点首页(盘点录单) wp
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "盘点首页")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/checkIndex",method = {RequestMethod.POST})
	public ApiReturnInfo checkIndex(
			HttpServletRequest request
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
		Integer operatorId=emp.getId();
    	Integer storeId=emp.getStoreId();
    	//生成盘点单号
    	String number=StringUtil.serialNumber("PD");
    	//仓库
    	List<CarWarehouse> listw=appCarStoreService.selectCarWarehouseByStore(storeId);
    	Map<String, Object> map=new HashMap<>();
    	map.put("storeId", storeId);
    	map.put("postName", "会计");//会计岗位
    	List<Employee> liste=appCarStoreService.selectPanDianEmps(map);
    	//判断当前用户状态 是否休假和培训
    	Map<String, Object> map2=new HashMap<>();
    	map2.put("employeeId", emp.getId());
    	Map<String, Object> empMap=appCarStoreService.myInfo(map2);
    	Integer empType=(Integer) empMap.get("type");
    	if (empType==0 || empType==1) {
    		liste.add(emp);
		}
    	//经办人(该门店下具有财务角色的列表)？
    	Map<String, Object> mapr=new HashMap<>();
    	mapr.put("number", number);
    	mapr.put("listw", listw);
    	mapr.put("emp", liste);
    	ar.setData(mapr);
    	return ar;
	}
	
	/**
	 * 仓库下的汽车库存明细 wp
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "仓库下的汽车")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectCarInStore",method = {RequestMethod.POST})
	public ApiReturnInfo selectCarInStore(
			HttpServletRequest request,
			Integer  warehouseId
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	Map<String, Object> map=new HashMap<>();
    	map.put("storeId", storeId);
    	map.put("warehouseId", warehouseId);
    	map.put("storageStatus", CarStorageStatus.IN_STORAGE.getCode());
    	List<Map<String, Object>> listt=new ArrayList<>();
    	int checkNum=0;
    	int	unCheckNum=0;
    	//仓库下的汽车
    	List<Map<String,Object>> list=appCarStoreService.selectCarInStore(map);
    	if (list!=null) {
    		for (Map<String, Object> map2 : list) {
        		Integer checkStatus=(Integer) map2.get("car_check_status");
        		if (checkStatus !=null) {
	    			if (checkStatus==2) {
	    				checkNum++;
	    			}else {
	    				unCheckNum++;
	    			}
        		}else {
        			unCheckNum++;
				}
        		listt.add(map2);
    		}
		}
    	Map<String, Object> mapr=new HashMap<>();
    	mapr.put("checkNum", checkNum);
    	mapr.put("unCheckNum", unCheckNum);
    	mapr.put("listt", listt);
    	ar.setData(mapr);
    	return ar;
	}
	/**
	 * 添加(修改)盘点记录（扫一扫已核） wp
	 * @param request
	 * @param warehouseId
	 * @param carId
	 * @param checkStatus
	 * @param loss
	 * @param gain
	 * @param checker
	 * @param number
	 * @return
	 */
	@ApiOperation(value = "添加盘点记录")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/insertDepotCheckRecord",method = {RequestMethod.POST})
	public ApiReturnInfo insertDepotCheckRecord(
			HttpServletRequest request,
			Integer warehouseId,
			Integer carId,
			Integer checker,
			String number
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	List<Integer> list=new ArrayList<>();
    	CarDepotCheck carDepotCheck = new CarDepotCheck();
    	carDepotCheck.setCarId(carId);
    	carDepotCheck.setStoreId(storeId);
    	carDepotCheck.setChecker(checker.toString());
    	carDepotCheck.setCheckStatus(CarDepotCheckStatus.正常1.getCode());//盘点状态 1正常 2异常
    	carDepotCheck.setCheckTime(new Date());
    	carDepotCheck.setWarehouseId(warehouseId);
    	carDepotCheck.setNumber(number);
    	//盘点登记表登记信息，如果汽车信息为空则添加 如果信息不为空则修改
    	Map<String, Object> mapdepotMap=new HashMap<>();
    	mapdepotMap.put("number", number);
    	mapdepotMap.put("carId", carId);
    	List<Map<String, Object>> cardepotMaps=appCarStoreService.selectIsExistCar(mapdepotMap);
    	int i=0;
    	if (cardepotMaps==null || cardepotMaps.size()<=0) {
        	i=appCarStoreService.insertDepotCheckRecord(carDepotCheck);
		}else {//如果不为空则修改盘点记录
	    	int j=appCarStoreService.updateCheckDepot(carDepotCheck);
		}
        //修改汽车表的盘点状态
        CarGoodInfo record=new CarGoodInfo();
        record.setId(carId);
    	record.setCarCheckId(carDepotCheck.getId());
    	record.setCarCheckStatus(PanDianResult.已核2.getCode());
    	int ic=appCarStoreService.updateCarStatus(record);
    	if (i<=0 ||ic<=0) {
    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
		}
    	return ar;
	}
	
	/**
	 * 确认提交实盘 wp
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "提交实盘")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/submitDepotCheck",method=RequestMethod.POST)
	public ApiReturnInfo submitDepotCheck(
			HttpServletRequest request,
			String remark,
			String number
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	CarDepotCheck carDepotCheck=new CarDepotCheck();
    	carDepotCheck.setRemark(remark);
    	carDepotCheck.setNumber(number);
    	int i=appCarStoreService.updateCheckDepot(carDepotCheck);
    	if(i<=0) {
    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
    	}
    	return ar;
    	}
	
	/**
	 * 实盘 wp
	 * @param request
	 * @param warehouseId
	 * @param checker
	 * @param number
	 * @return
	 */
	@ApiOperation(value = "实盘")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectPanDianDanStatus",method=RequestMethod.POST)
	public ApiReturnInfo selectPanDianDanStatus(
			HttpServletRequest request,
			Integer warehouseId,
			Integer checker,
			String number
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	//判断仓库下的车是否有车辆未核 有则亏
    	Map<String, Object> map=new HashMap<>();
    	map.put("storeId", storeId);
    	map.put("carCheckStatus", PanDianResult.未核1.getCode());//汽车表车辆盘点状态 1未核 2已核 或者NULL
    	map.put("warehouseId", warehouseId);
    	map.put("storageStatus", CarStorageStatus.IN_STORAGE.getCode());
    	List<Map<String, Object>> list=appCarStoreService.selectCarInStore(map);
    	//将未核实的添加到盘点记录表
    	if(list!=null) {
    		for (Map<String, Object> map2 : list) {
				Integer carId=(Integer) map2.get("id");
				CarDepotCheck carDepotCheck=new CarDepotCheck();
				carDepotCheck.setCarId(carId);
				carDepotCheck.setStoreId(storeId);
		    	carDepotCheck.setChecker(checker.toString());
		    	carDepotCheck.setCheckStatus(CarDepotCheckStatus.异常2.getCode());//盘点状态 1正常 2.异常
		    	carDepotCheck.setCheckTime(new Date());
		    	carDepotCheck.setWarehouseId(warehouseId);
		    	carDepotCheck.setNumber(number);
		    	//判断汽车ID是否已加入盘点表 如果已加入则不添加
		    	Integer num=appCarStoreService.selectDepotByCarId(carId);
		    	if (num<=0) {
		    		int i=appCarStoreService.insertDepotCheckRecord(carDepotCheck);
				}
			}
    	}
    	
    	//盘点单号下的汽车列表查询 
    	Map<String, Object> mapp=new HashMap<>();
    	mapp.put("storeId", storeId);
    	mapp.put("warehouseId", warehouseId);
    	mapp.put("storageStatus", CarStorageStatus.IN_STORAGE.getCode());
    	List<Map<String, Object>> listt=appCarStoreService.selectCarInStore(mapp);
    	Map<String, Object> maplist=new HashMap<>();
//    	maplist.put("mapr", mapr);//眉头信息
    	maplist.put("list", listt);//仓库盘点后的汽车
    	ar.setData(maplist);
    	return ar;
	}
	/**
	 * 盘点历史 wp
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "盘点历史")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/depotCheckHistory",method = {RequestMethod.POST})
	public ApiReturnInfo depotCheckHistory(
			HttpServletRequest request
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	Map<String , Object> mapc=new HashMap<>();
    	mapc.put("storeId", storeId);
    	List<Map<String, Object>> list=appCarStoreService.depotCheckHistory(mapc);
    	List<Map<String, Object>> listr=new ArrayList<Map<String,Object>>();
    	for (Map<String, Object> map : list) {
    		String names="";
    		String chekers=(String) map.get("checker");
			Employee che=appEmployeeService.selectEmployeeById(Integer.parseInt(chekers));
			if (che!=null) {
				names=che.getFullName();
			}
			map.put("names", names);
			listr.add(map);
		}
    	ar.setData(listr);
    	return ar;
	}
	/**
	 * 盘亏列表 wp
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "盘亏列表")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/depotCheckLossList",method = {RequestMethod.POST})
	public ApiReturnInfo depotCheckLossList(
			HttpServletRequest request
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
    	Integer storeId=emp.getStoreId();
    	Map<String, Object> map=new HashMap<>();
    	map.put("storeId", storeId);
    	List<Map<String, Object>> list=appCarStoreService.depotCheckLossList(map);
    	ar.setData(list);
    	return ar;
	}
	/**
	 * 盘亏下汽车 wp
	 * @param request
	 * @param number
	 * @return
	 */
	@ApiOperation(value = "盘亏下汽车")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/depotCheckLossCars",method = {RequestMethod.POST})
	public ApiReturnInfo depotCheckLossCars(
			HttpServletRequest request,
			String number
			) {
	ApiReturnInfo ar=new ApiReturnInfo<>();
	Employee emp = getMember(request);
	Integer storeId=emp.getStoreId();
	Map<String, Object> map=new HashMap<>();
	map.put("number", number);
	map.put("storeId", storeId);
	List<Map<String, Object>> list=appCarStoreService.depotCheckLossCars(map);
	ar.setData(list);
	return ar;
	}
	
	/**
	 * 整备生成创建工单 wp
	 * @param request
	 * @param expectStartTime
	 * @param expectEndTime
	 * @param carId
	 * @return
	 */
	@ApiOperation(value = "整备生成工单")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/insertWorkPage",method=RequestMethod.POST)
	public ApiReturnInfo insertWorkPage(
			HttpServletRequest request,
			String expectStartTime,
			String expectEndTime,
			Integer carId
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
		Integer storeId=emp.getStoreId();
		CarZhengbeiRecord carZhengbeiRecord=new CarZhengbeiRecord();
		carZhengbeiRecord.setCarId(carId);
		carZhengbeiRecord.setCreateTime(new Date());
		carZhengbeiRecord.setExpectStartTime(DateUtil.stringToDate(expectStartTime, DateUtil.sdf3));
		carZhengbeiRecord.setExpectEndTime(DateUtil.stringToDate(expectEndTime, DateUtil.sdf3));
		carZhengbeiRecord.setExpectTime(DateUtil.stringToDate(expectEndTime, DateUtil.sdf3));
		carZhengbeiRecord.setStoreId(storeId);
		String workPage="GD"+DateUtil.dateFormat(new Date(), DateUtil.sdf5)+StringUtil.getSixCode();
		carZhengbeiRecord.setWorkPage(workPage);
		carZhengbeiRecord.setDetectStatus(DetectStatu.待送修2.getId());//待送修
		//改变车辆在库状态
		CarGoodInfo carGoodInfo=new CarGoodInfo();
		carGoodInfo.setDisposeStatus(CarDisposeStatus.REPAIR_WAIT.getCode());//待整备
		carGoodInfo.setId(carId);
		//添加信息值整备表 
		int i=appCarStoreService.insertWorkPage(carZhengbeiRecord, carGoodInfo);
		if (i<=0) {
    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
		}
		Map<String, Object> map=new HashMap<>();
		map.put("detectStatus", DetectStatu.待送修2.getId());//待送修
		ar.setData(map);
		return ar;
	}
	
	/**
	 * 整备 送修、维修完成 wp
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "送修、维修完成")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/updateZhengBeiStatus",method = {RequestMethod.POST})
	public ApiReturnInfo updateZhengBeiStatus(
			HttpServletRequest request,
			Integer detectStatus,//根据整备状态判断进行相应的操作
			Integer zhengBeiId
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
		Integer storeId=emp.getStoreId();
		//根据整备ID查整备类型
		CarZhengbeiRecord carZhengbeiRecordi=appCarStoreService.selectCarZhengbeiRecord(zhengBeiId);
		Integer zhengBeiTypeInteger=carZhengbeiRecordi.getZhengbeiType();//整备类型
		Integer carId=carZhengbeiRecordi.getCarId();
		if (detectStatus !=null) {
		if(detectStatus==DetectStatu.待送修2.getId()) {//待送修，进行送修操作
			CarZhengbeiRecord carZhengbeiRecord=new CarZhengbeiRecord();
			carZhengbeiRecord.setId(zhengBeiId);
			carZhengbeiRecord.setUpdateTime(new Date());
			carZhengbeiRecord.setDetectStatus(DetectStatu.维修中3.getId());//维修中
		    int i=appCarStoreService.updateZhengBeiStatus(carZhengbeiRecord);
		    //汽车状态改变为整备出库，整备中
		    CarGoodInfo carGoodInfo=new CarGoodInfo();
		    if (zhengBeiTypeInteger==1) {//采购单整备
		    	carGoodInfo.setId(carId);
		    	carGoodInfo.setDisposeStatus(CarDisposeStatus.REPAIRING.getCode());//整备中
			    int j=appCarStoreService.updateCarStatus(carGoodInfo);
			    if (j<=0) {
		    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
		 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
				}
			}
		    if (zhengBeiTypeInteger==2) {//pdi整备
		    	carGoodInfo.setId(carId);
		    	carGoodInfo.setDisposeStatus(CarDisposeStatus.REPAIRING.getCode());//整备中
			    carGoodInfo.setStorageStatus(CarStorageStatus.IN_STORAGE.getCode());//在库
			    int j=appCarStoreService.updateCarStatus(carGoodInfo);
			    if (j<=0) {
		    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
		 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
				}
			}
		    if (zhengBeiTypeInteger==3) {//商品车库存整备
		    	carGoodInfo.setId(carId);
		    	carGoodInfo.setDisposeStatus(CarDisposeStatus.REPAIRING.getCode());//整备中
			    carGoodInfo.setStorageStatus(CarStorageStatus.IN_STORAGE.getCode());//在库
			    int j=appCarStoreService.updateCarStatus(carGoodInfo);
			    if (j<=0) {
		    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
		 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
				}
			}
		   
		}
		if (detectStatus==DetectStatu.维修中3.getId()) {//维修中，进行维修完成的操作
			CarZhengbeiRecord carZhengbeiRecord=new CarZhengbeiRecord();
			carZhengbeiRecord.setId(zhengBeiId);
			carZhengbeiRecord.setUpdateTime(new Date());
			carZhengbeiRecord.setDetectStatus(DetectStatu.维修完成4.getId());//维修完成
			int i1=appCarStoreService.updateZhengBeiStatus(carZhengbeiRecord);
			//汽车表处理状态改为 正常
			CarGoodInfo carGoodInfo=new CarGoodInfo();
			carGoodInfo.setId(carId);
			carGoodInfo.setDisposeStatus(CarDisposeStatus.NORMAL.getCode());
			appCarStoreService.updateCarStatus(carGoodInfo);
			if (i1<=0) {
	    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
	 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
			}
			//暂收整备状态处理
			Map<String, Object> mapzan=new HashMap<>();
			mapzan.put("carId", carId);
			Map<String, Object> zanzhengMap=appCarStoreService.zanshouZhengbeiStatus(mapzan);
			Integer storage_status=null;
			Integer detect_status=null;
			Integer carOrderId=null;
			if (zanzhengMap !=null) {
				storage_status=(Integer) zanzhengMap.get("storage_status");
				detect_status=(Integer) zanzhengMap.get("detect_status");
				carOrderId=(Integer) zanzhengMap.get("car_order_id");
				if (storage_status!=null && detect_status !=null) {
					if (storage_status==2 && detect_status==4) {//暂收整备处理完成
						//将汽车的状态改变为处理完成
						//通过汽车ID完善暂收入库汽车的检测信息
						CarCheckRecord carCheckRecord=new CarCheckRecord();
						carCheckRecord.setUpdateTime(new Date());
						carCheckRecord.setCheckStatus(CarCheckStatus.已完成.getCode());
						carCheckRecord.setCarId(carId);
						carCheckRecord.setCheckType(0);
						int i=appCarStoreService.updateCheckRecord(carCheckRecord, carOrderId);
					}
				}
			}
		 }
		}
		return ar;
	}
	/**
	 * 保险到期提醒 wp
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ApiOperation(value = "保险到期提醒")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectInsurerRemind",method=RequestMethod.POST)
	public ApiReturnInfo selectInsurerRemind(
			HttpServletRequest request,
			Integer pageNum,
			Integer pageSize
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
		Integer storeId=emp.getStoreId();
		PageInfo<Map<String, Object>> pageInfo=appCarStoreService.selectInsurerRemind(pageNum, pageSize,storeId);
		Map<String, Object> mapr=new HashMap<>();
		mapr.put("list", pageInfo.getList());
		mapr.put("pageResult", getPageResult(pageInfo));
		ar.setData(mapr);
		return ar;
	}
	/**
	 * 采购清单列表 wp
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@ApiOperation(value = "采购清单列表")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/carPurchaseList",method=RequestMethod.POST)
	public ApiReturnInfo carPurchaseList(
			Integer  pageNum,
			Integer pageSize,
			HttpServletRequest request
			) {
		ApiReturnInfo ar=new ApiReturnInfo<>();
		Employee emp = getMember(request);
		Integer storeId=emp.getStoreId();
		Map<String, Object> map=new HashMap<>();
		map.put("storeId", storeId);
		PageInfo<List<Map<String, Object>>> pageInfo=appCarStoreService.carPurchaseList(map,pageNum,pageSize);
		Map<String, Object> mapr=new HashMap<>();
		mapr.put("list",pageInfo.getList());
		mapr.put("pageResult", getPageResult(pageInfo));
		ar.setData(mapr);
		return ar;
	}
	/**
	 * 采购单下的汽车 wp
	 * @param request
	 * @param pageNum
	 * @param pageSize
	 * @param carOrderId
	 * @return
	 */
	@ApiOperation(value = "采购单下的汽车")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectCarByPurchaseId",method = {RequestMethod.POST})
	public ApiReturnInfo selectCarByPurchaseId(
			HttpServletRequest request,
			Integer pageNum,
			Integer pageSize,
			Integer carOrderId
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 PageInfo<Map<String, Object>> pageInfo=appCarStoreService.selectCarByPurchaseId(carOrderId, pageNum, pageSize);
		 List<Map<String, Object>> carList=pageInfo.getList();
		 if (carList !=null) {
			for (Map<String, Object> map : carList) {
				Integer carId=(Integer) map.get("id");
				if (carId !=null) {
					Map<String, Object> map2=new HashMap<>();
					map2.put("carId", carId);
					Map<String, Object> checkMap=appCarStoreService.checkStatus(map2);
					Integer checkInteger=null;
					if (checkMap !=null) {
						checkInteger=(Integer) checkMap.get("check_status");
					}
					if (checkInteger ==null) {
						map.put("check_status", 1);
					}else if (checkInteger==4) {
						map.put("check_status", 3);
					}else if (checkInteger==1) {
						map.put("check_status", 2);
					}else if (checkInteger==5) {
						map.put("check_status", 4);
					}else if (checkInteger==2) {
						map.put("check_status", 5);
					}else if (checkInteger==3) {
						map.put("check_status", 6);
					}else if (checkInteger==6) {
						map.put("check_status", 7);
					}
				}
			}
		}
		 Map<String,Object> map=new HashMap<String, Object>();
		 map.put("list", carList);
		 map.put("pageResult", getPageResult(pageInfo));
		 ar.setData(map);
		 return ar;
	}
	/**
	 * 入库历史 wp
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "入库历史")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/ruKuHistoryList",method = {RequestMethod.POST})
	public ApiReturnInfo ruKuHistoryList(
			HttpServletRequest request
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 Map<String, Object> map=new HashMap<>();
		 map.put("storeId", storeId);
		 List<Map<String, Object>> list= appCarStoreService.ruKuHistoryList(map);
		 ar.setData(list);
		 return ar;
	}
	
	/**
	 * 汽车颜色条件筛选 wp
	 * @param request
	 * @param familyId
	 * @return
	 */
	@ApiOperation(value = "汽车颜色条件筛选")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectColorOutIn",method = {RequestMethod.POST})
	public ApiReturnInfo selectColorOutIn(
			HttpServletRequest request,
			Integer familyId
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 Map<String, Object> map=new HashMap<>();
		 map.put("storeId", storeId);
		 map.put("familyId", familyId);
//		 map.put("storeId", 1);
//		 map.put("familyId", 1);
		 List<Map<String, Object>> list=appCarColorService.selectColorOutIn(map);
		 List<Map<String, Object>> list1=new ArrayList();
		 List<Map<String, Object>> list2=new ArrayList();
		 if (list!=null&&list.size()>0) {
		 for (Map<String, Object> map2 : list) {
			if ((Integer)map2.get("location_status")==ColorStatus.OUT.getCode()) {
				list1.add(map2);//车身颜色
			}else {
				list2.add(map2);
			}
		}
		}
		 Map<String, Object> mapr=new HashMap<>();
		 mapr.put("list1", list1);
		 mapr.put("list2", list2);
		 ar.setData(mapr);
		 return ar;
	}
	/**
	 * 洗车登记 wp
	 * @param request
	 * @param carNumber
	 * @param carId
	 * @return
	 */
	@ApiOperation(value = "洗车登记")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/carWashRecord",method = {RequestMethod.POST})
	public ApiReturnInfo carWashRecord(
			HttpServletRequest request,
			String vin
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
//    	 Map<String , Object> map=new HashMap<String , Object>();
//    	 map.put("storeId", storeId);
//    	 Map<String, Object> carGoodInfo=appCarStoreService.carDetailInfo(map);
         Map<String, Object> carGoodInfo=appCarStoreService.carScan(vin);
         Map<String, Object> carTestInfo=appCarStoreService.carTestScan(vin);
		 CarWash carWash=new CarWash();
		 carWash.setEmployeeId(emp.getId());
		 Integer carId=null;
		 if (carTestInfo!=null) {
			 String license_num=(String) carTestInfo.get("license_num");
			 if (license_num!=null) {
				 carWash.setCarNumber(license_num);
			 }
			 carId=(Integer) carTestInfo.get("id");
		 }
		 carWash.setVinCode(vin);
		 carWash.setState(CarWashStates.NO_WASHING.getCode());//1：未洗车，0：洗车中，2，已完成
		 carWash.setApplyTime(new Date());
		 carWash.setOperatorId(emp.getId());
		 carWash.setStoreId(storeId);
		 //判断该车辆是否绑定订单，若绑定则添加客户ID及客户名
		 if (carGoodInfo!=null) {
			 Map<String, Object> car=appCarStoreService.carOrderWash((Integer)carGoodInfo.get("id"));
			 if(car!=null) {
				 String cus_name=(String) car.get("cus_name");
				 if (cus_name!=null) {
					 carWash.setCustomerName(cus_name);
				 }
				 Integer customerId=(Integer) car.get("cus_id");
				 if (customerId!=null) {
					 carWash.setCustomerId(customerId);
				 }
			 }
			 carId=(Integer) carGoodInfo.get("id");
		}
		 int i=appCarStoreService.carWashRecord(carWash);
		 if (i<=0) {
	    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
	 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
			}
		 //返回车辆信息
		 Map<String, Object> car=null;
		 if (carId!=null) {
			    Map<String , Object> map=new HashMap<String , Object>();
		    	map.put("id", carId);
		    	map.put("storeId", storeId);
			    car= appCarStoreService.carDetailInfo(map);
				Map<String, Object> mapc=new HashMap<>();
				mapc.put("carId", carId);
				Map<String, Object> checkMap=appCarStoreService.selectCarCheckRecord(mapc);
				Integer checkInteger=null;
				if (checkMap !=null) {
					checkInteger=(Integer) checkMap.get("check_status");
				}
				if (checkInteger == null) {
					car.put("pdi_status", 1);
				}else if (checkInteger==3) {
					car.put("pdi_status", 3);
				}else if(checkInteger==1){
					car.put("pdi_status", 2);
				}
				Map<String, Object> mapc1=new HashMap<>();
				mapc1.put("vin", vin);
				Map<String, Object> washMap=appCarStoreService.selectCarWashRecord(mapc1);
				Integer washInteger=null;
				if (washMap !=null) {
					washInteger=(Integer) washMap.get("state");
				}
				if (washInteger == null) {
					car.put("wash_status", 1);
				}else if (washInteger == 1 || washInteger==0) {
					car.put("wash_status", 0);
				}else if (washInteger==2) {
					car.put("wash_status", 2);
				}
		}
		 ar.setData(car);
		 return ar;
	}
	/**
	 * 车系下的车型 wp
	 * @param request
	 * @param familyId
	 * @return
	 */
	@ApiOperation(value = "查车系下的车型")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectCarConfByFamily",method = {RequestMethod.POST})
	public ApiReturnInfo selectCarConfByFamily(
			HttpServletRequest request,
			Integer familyId
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
    	 Map<String , Object> map=new HashMap<String , Object>();
    	 map.put("storeId", storeId);
    	 map.put("familyId", familyId);
    	 List<Map<String, Object>> list=appCarStoreService.selectCarConfByFamily(map);
    	 ar.setData(list);
    	 return ar;
	}
	/**
	 * 暂收 wp
	 * @param request
	 * @param familyId
	 * @return
	 */
	@ApiOperation(value = "暂收")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/temporaryCollection",method = {RequestMethod.POST})
	public ApiReturnInfo temporaryCollection(
			HttpServletRequest request,
			Integer carId
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 CarGoodInfo carGoodInfo=new CarGoodInfo();
		 carGoodInfo.setDisposeStatus(CarDisposeStatus.IN_TEMPORARY.getCode());
		 carGoodInfo.setId(carId);
		 int i=appCarStoreService.updateCarStatus(carGoodInfo);
		 //将暂收（状态）存入检测表
		 CarCheckRecord carCheckRecord=new CarCheckRecord();
		 carCheckRecord.setCarId(carId);
		 carCheckRecord.setStoreId(storeId);
		 carCheckRecord.setCheckStatus(CarCheckStatus.暂收未检测.getCode());
		 int j=appCarStoreService.insertCheckRecord(carCheckRecord);
		 if (i<=0 || j<=0) {
	    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
	 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
			}
		 return ar;
	}
	/**
	 * 外出申请单列 wp
	 * @param request
	 * @param planOutDay
	 * @return
	 */
	@ApiOperation(value = "外出申请单列")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectCarOutApply",method = {RequestMethod.POST})
	public ApiReturnInfo selectCarOutApply(
			HttpServletRequest request,
			String  planOutDay
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 Map<String , Object> map=new HashMap<>();
		 if (planOutDay!=null) {
			 map.put("planOutDay", DateUtil.dateFormat(DateUtil.stringToDate(planOutDay, DateUtil.sdf2), DateUtil.sdf2));
		}else {
			 map.put("planOutDay", DateUtil.dateFormat(new Date(), DateUtil.sdf2));
		}
		 map.put("storeId", storeId);
		 List<Map<String, Object>> list=appCarStoreService.selectCarOutApply(map);
		 ar.setData(list);
		 return ar;
	}
	/**
	 * 外出申请单下的汽车列 wp
	 * @param request
	 * @param applicationId
	 * @return
	 */
	@ApiOperation(value = "外出申请单下的汽车列")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectCarListByApply",method = {RequestMethod.POST})
	public ApiReturnInfo selectCarListByApply(
			HttpServletRequest request,
			Integer applicationId
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 Map<String , Object> map=new HashMap<>();
		 map.put("storeId", storeId);
		 map.put("applicationId", applicationId);
		 List<Map<String, Object>> list=appCarStoreService.selectCarListByApply(map);
		 ar.setData(list);
		 return ar;
	}
	/**
	 * 外出出库
	 * 同时改变外出申请单下的汽车的状态 wp 
	 * @param request
	 * @param applicationId
	 * @return
	 */
	@ApiOperation(value = "改变外出申请单下的汽车的状态")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/carOutFromStorage",method = {RequestMethod.POST})
	public ApiReturnInfo carOutFromStorage(
			HttpServletRequest request,
			Integer applicationId
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 Map<String , Object> map=new HashMap<>();
		 Integer storageStatus=(Integer)CarStorageStatus.OUT.getCode();
		 try {
		 //汽车表出库
		 int i=appCarStoreService.updateByOutApplication(storageStatus, applicationId);
		 //出库表登记
		 CarOutstorgeRecord carOutstorgeRecord =new CarOutstorgeRecord();
		 carOutstorgeRecord.setStoreId(storeId);
		 carOutstorgeRecord.setOperatorId(emp.getId());
		 carOutstorgeRecord.setOutstoreTime(new Date());
		 carOutstorgeRecord.setOutstoreType(2);//出库类型 1销售出库 2外出出库
		 Map<String , Object> maps=new HashMap<>();
		 maps.put("applicationId", applicationId);
		 maps.put("storeId", storeId);
		 //查汽车ID
		 List<Map<String, Object>> list=appCarStoreService.selectCarListByApply(maps);
		 for (Map<String, Object> map2 : list) {
			Integer carId=(Integer) map2.get("id");
			carOutstorgeRecord.setCarId(carId);
			//出库表插入出库记录
		    int j=appCarStoreService.insertCarOutStoreRecord(carOutstorgeRecord);
		 }
		 //出库申请单状态改变
		 CarOutApplication carOutApplication=new CarOutApplication();
		 carOutApplication.setApplicateStatus(1);//申请状态 1 外出中 2 已入库 null未出库
		 carOutApplication.setUpdateDate(new Date());
		 carOutApplication.setId(applicationId);
		 int k=appCarStoreService.updateCarOutAppliStatus(carOutApplication);
		 } catch (Exception e) {
			 ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
			 ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
		 }
		 return ar;
	}
	/**
	 * 今日调拨单列 wp
	 * @param request
	 * @param date
	 * @return
	 */
	@ApiOperation(value = "调拨申请单列")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectAllotApplication",method = {RequestMethod.POST})
	public ApiReturnInfo selectAllotApplication(
			HttpServletRequest request,
			String date
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 Map<String, Object> map=new HashMap<>();
		 map.put("storeId", storeId);
		 if (date==null || date.length()==0) {
			 map.put("operateDate", DateUtil.dateFormat(new Date(), DateUtil.sdf2));
		}else {
			 map.put("operateDate", DateUtil.dateFormat(DateUtil.stringToDate(date, DateUtil.sdf2), DateUtil.sdf2));
		}
		 List<Map<String , Object>> list=appCarStoreService.selectAllotApplication(map);
		 //判断调拨申请单下的汽车是否全部出库
		 for (Map<String, Object> map2 : list) {
			 boolean flag=true;
			 boolean flag1=true;
			 Map<String, Object> mapa=new HashMap<>();
			 mapa.put("storeId", storeId);
			 mapa.put("applicationId", (Integer)map2.get("id"));
			 List<Map<String, Object>> listcar=appCarStoreService.selectCarListByAllot(mapa);
			 //判断是否有未出库的车辆
			 if (listcar!=null) {
				 for (Map<String, Object> map3 : listcar) {
					Integer storgeStatus=(Integer) map3.get("storage_status");
					if (storgeStatus!=CarStorageStatus.SELL_OUT.getCode()) {
						flag=false;
						break;
					}
				 }
				 if (flag) {
					 map2.put("outstore_status", 2);//汽车调拨申请单出库状态 1有车未出库2全出库
				 } else {
					 map2.put("outstore_status", 1);// 有车未出库
				 }
			}else {
				 map2.put("outstore_status", 3);//没有车辆
			}
			//判断调拨单下的汽车是否全部在库
			if (listcar !=null) {
		    for (Map<String, Object> map3 : listcar) {
				Integer storgeStatus=(Integer) map3.get("storage_status");
				if (storgeStatus==CarStorageStatus.ON_WAY.getCode()) {
					flag1=false;
					break;
				}
			 }
			 if (flag1) {
				 map2.put("onway_status", 1);//1全部在库 2存在在途汽车 提示不可批量出库
			 } else {
				 map2.put("onway_status", 2);
			 }
	       }else {
	    	   map2.put("onway_status", 3);//没有车辆
	       }
		 }
		 ar.setData(list);
		 return ar;
	}
	/**
	 * 调拨申请单下的汽车列 wp
	 * @param request
	 * @param applicationId
	 * @return
	 */
	@ApiOperation(value = "调拨申请单下的汽车列")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectCarListByAllot",method = {RequestMethod.POST})
	public ApiReturnInfo selectCarListByAllot(
			HttpServletRequest request,
			Integer applicationId
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 Map<String, Object> map=new HashMap<>();
		 map.put("storeId", storeId);
		 map.put("applicationId", applicationId);
		 List<Map<String , Object>> list=appCarStoreService.selectCarListByAllot(map);
		 ar.setData(list);
		 return ar;
	}
	/**
	 * 交车、调拨通用出库 wp
	 * @param request
	 * @param carId
	 * @return
	 */
	@ApiOperation(value = "通用出库")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/carOutStoreByCarId",method = {RequestMethod.POST})
	public ApiReturnInfo carOutStoreByCarId(
			HttpServletRequest request,
			Integer carId
			) {
		System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>"+carId);
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 Map<String, Object> map=new HashMap<>();
		 map.put("storeId", storeId);
		 CarGoodInfo carGoodInfo=new CarGoodInfo();
		 carGoodInfo.setId(carId);
		 carGoodInfo.setStorageStatus(CarStorageStatus.SELL_OUT.getCode());//库存状态 1 在途 2 在库 3 整备出库 4 销售出库 5 外出 6 拒收
		 carGoodInfo.setOutStorageDate(new Date());
		 try {
			 int i=appCarStoreService.updateCarStatus(carGoodInfo);
			 CarOutstorgeRecord carOutstorgeRecord =new CarOutstorgeRecord();
			 carOutstorgeRecord.setStoreId(storeId);
			 carOutstorgeRecord.setOperatorId(emp.getId());
			 carOutstorgeRecord.setOutstoreTime(new Date());
			 carOutstorgeRecord.setOutstoreType(1);//出库类型 1销售出库 2外出出库
			 carOutstorgeRecord.setCarId(carId);
			 int j= appCarStoreService.insertCarOutStoreRecord(carOutstorgeRecord);
		} catch (Exception e) {
			ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
		}
		//返回车辆信息
		 Map<String , Object> mapcar=new HashMap<String , Object>();
		 mapcar.put("id", carId);
		 mapcar.put("storeId", storeId);
		 Map<String, Object> car= appCarStoreService.carDetailInfo(mapcar);
		 ar.setData(car);
		 return ar;
	}
	/**
	 * 库管我的加油记录 wp
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "库管我的加油记录")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectRefuleListByOperator",method = {RequestMethod.POST})
	public ApiReturnInfo selectRefuleListByOperator(
			HttpServletRequest request
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 Map<String, Object> map=new HashMap<>();
		 map.put("storeId", storeId);
		 map.put("operatorId", emp.getId());
		 List<CarRefuelRecord> list= appCarStoreService.selectRefuleListByOperator(map);
		 ar.setData(list);
		 return ar;
	}
	/**
	 * 库管我的维修记录 wp
	 * @param request
	 * @param operatorId
	 * @return
	 */
	@ApiOperation(value = "库管我的维修记录")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/selectMaintainListByOperator",method = {RequestMethod.POST})
	public ApiReturnInfo selectMaintainListByOperator(
			HttpServletRequest request
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 Map<String, Object> map=new HashMap<>();
		 map.put("operatorId", emp.getId());
		 List<CarMaintainRecord> list = appCarStoreService.selectMaintainListByOperator(map);
		 ar.setData(list);
		 return ar;
	}
	/**
	 * 调拨出库变更汽车在库状态 wp
	 * @param request
	 * @param applicationId
	 * @param storageStatus
	 * @return
	 */
	@ApiOperation(value = "调拨变更汽车在库状态")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/updateCarStoregStatusByAllot",method = {RequestMethod.POST})
	public ApiReturnInfo updateCarStoregStatusByAllot(
			HttpServletRequest request,
			Integer applicationId
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 Map<String, Object> map =new HashMap<>();
		 map.put("applicationId", applicationId);
		 map.put("storageStatus", CarStorageStatus.SELL_OUT.getCode());
		 int i=appCarStoreService.updateCarStoregStatusByAllot(map);
		 //出库登记
		 Map<String, Object> map2=new HashMap<>();
		 map2.put("applicationId", applicationId);
		 List<Map<String, Object>> list= appCarStoreService.selectCarListByAllot(map2);
		 //获取出库车辆ID
		 CarOutstorgeRecord carOutstorgeRecord =new CarOutstorgeRecord();
		 carOutstorgeRecord.setStoreId(storeId);
		 carOutstorgeRecord.setOperatorId(emp.getId());
		 carOutstorgeRecord.setOutstoreTime(new Date());
		 carOutstorgeRecord.setOutstoreType(1);//出库类型 1销售出库 2外出出库
		 for (Map<String, Object> map3 : list) {
				Integer carId=(Integer)map3.get("id");
				carOutstorgeRecord.setCarId(carId);
			}
		 int j=appCarStoreService.insertCarOutStoreRecord(carOutstorgeRecord);
		 if (i<=0 || j<=0) {
	    		ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
	 			ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
			}
		 return ar;
	}
	/**
	 * 库管我的信息
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "库管我的信息")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/myInfo",method = {RequestMethod.POST})
	public ApiReturnInfo myInfo(
			HttpServletRequest request
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Map<String, Object> map=new HashMap<>();
		 Integer id=emp.getId();
		 map.put("employeeId", id);
		 Map<String, Object> empsMap=appCarStoreService.myInfo(map);
		 ar.setData(empsMap);
		 return ar;
	}
	/**
	 * 变更我的状态 wp
	 * @param request
	 * @param type
	 * @return
	 */
	@ApiOperation(value = "变更我的状态")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/updateEmpStatus",method = {RequestMethod.POST})
	public ApiReturnInfo updateEmpStatus(
			HttpServletRequest request,
			Integer type
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Map<String, Object> map=new HashMap<>();
		 map.put("type", type);
		 map.put("employeeId", emp.getId());
		 int i=appCarStoreService.updateEmpStatus(map);
		 if(i<=0) {
			ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
	 		ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage()); 
		 }
		 return ar;
	}
	
	
	
	@ApiOperation(value = "库存车整备")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "brandId", value = "品牌id", required = true, dataType = "Integer"),
           @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer")
    })
	@ResponseBody
	@RequestMapping(value="/storeZhengBeiRecord",method = {RequestMethod.POST})
	public ApiReturnInfo storeZhengBeiRecord(
			HttpServletRequest request,
			Integer carId,
			String vin
			) {
		 ApiReturnInfo ar=new ApiReturnInfo<>();
		 Employee emp = getMember(request);
		 Integer storeId=emp.getStoreId();
		 Map<String, Object> map=new HashMap<>();
		 CarZhengbeiRecord carZhengbeiRecord=new CarZhengbeiRecord();
		 carZhengbeiRecord.setCarId(carId);
		 carZhengbeiRecord.setCreateTime(new Date());
		 carZhengbeiRecord.setStoreId(storeId);
		 carZhengbeiRecord.setDetectStatus(DetectStatu.未生成工单1.getId());//整备状态 1未生成工单 2待送修 3维修中 4维修完成
		 carZhengbeiRecord.setZhengbeiType(3);//整备类型 1采购单入库 2销售出库单 3商品车库存'
		 carZhengbeiRecord.setVin(vin);
		 int i=appCarStoreService.insertZhengbeiRecord(carZhengbeiRecord);
		 //变更汽车整理状态
		 CarGoodInfo record=new CarGoodInfo();
		 record.setDisposeStatus(CarDisposeStatus.REPAIR_WAIT.getCode());//待整备
		 int ic=appCarStoreService.updateCarStatus(record);
		 if (i<=0) {
			 ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
		 	 ar.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage()); 
		}
		 return ar;
	}
	
}
