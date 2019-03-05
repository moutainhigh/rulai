package com.unicdata.controller.insurer;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.DateUtil;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.car.CarInsuranceRecord;
import com.unicdata.entity.product.Insurer;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.insurer.InsurerServiece;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/app/insurer")
@Api(value="保险相关接口",tags={"保险相关接口"})
public class InsurerController extends HomeBaseController{

	@Autowired
	private InsurerServiece insurerServiece;
	
	/**
	 * 保险公司列 wp
	 * @param storeId
	 * @param request
	 * @return
	 */
	@ApiOperation(value="保险公司列")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "familyId", value = "车系id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/selectInsurerList",method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo selectInsurerList(HttpServletRequest request) {
		Employee emp = getMember(request);
		Integer storeId=emp.getStoreId();
    	ApiReturnInfo ari = new ApiReturnInfo();
    	List<Insurer> list=insurerServiece.selectInsure(storeId);
    	ari.setData(list);
    	return ari;
	}
	
	/**
	 * 保险公司下的险种 wp 
	 * @param request
	 * @param id
	 * @return
	 */
	@ApiOperation(value="保险公司下的险种")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "insurerId", value = "保险公司id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/selectInsurerType",method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo selectInsurerType(HttpServletRequest request,Integer insurerId ) {
		Employee emp = getMember(request);
		Integer storeId=emp.getStoreId();
		List<Map<String, Object>> listr=insurerServiece.selectChildTypes(insurerId,storeId);
    	ApiReturnInfo ari = new ApiReturnInfo();
    	ari.setData(listr);
    	return ari;
	}
	/**
	 * 试驾车保险历史记录 wp
	 * @param testCarId
	 * @return
	 */
	@ApiOperation(value="试驾车保险记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "familyId", value = "车系id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/selectInsurRecordList",method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo selectInsurRecordList(Integer testCarId) {
		ApiReturnInfo ari = new ApiReturnInfo();
		List<Map<String, Object>> list=insurerServiece.selectInsurRecordList(testCarId);
		ari.setData(list);
		return ari;
	}
	
	/**
	 * 添加保险登记 wp
	 * @param testCarId
	 * @param insurerId
	 * @param insuranceTypeId
	 * @param price
	 * @param endTime
	 * @param insuranceMoney
	 * @param request
	 * @return
	@ApiOperation(value="试驾车保险记录登记")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "familyId", value = "车系id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/testCarInsurerRecord",method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo testCarInsurerRecord(
    		String map,
    		Integer testCarId,
    		String price,
    		Integer insureId,
    		String endTime,
    		HttpServletRequest request
    		) {
		System.out.println("testCarId---->"+testCarId);
		System.out.println("price---->"+price);
		System.out.println("insureId---->"+insureId);
		System.out.println("endTime---->"+endTime);
		Employee emp = getMember(request);
		ApiReturnInfo ari = new ApiReturnInfo();
		Integer employeeID=emp.getId();
		List<Integer> insuranceTypeId=new ArrayList<Integer>();
		List<Map<String, Object>> list=new ArrayList<>();
		Map<String,Object> map1 = JSON.parseObject(map);
//		Map<String,Object> map1=new HashMap<>();
//		map1.put("1", "y");
//		map1.put("2", "33333");
//		map1.put("3", "35002");
//		map1.put("4", "y");
		Double insuranceMoney=null;
		Double priceDouble=Double.parseDouble(price);
		for (Map.Entry<String, Object> mapData : map1.entrySet()) {
		System.out.println(mapData.getKey()+"--->"+mapData.getValue());
		if (mapData.getValue().equals("y")) {
			insuranceTypeId.add(Integer.parseInt(mapData.getKey()));
		 }else {
			insuranceTypeId.add(Integer.parseInt(mapData.getKey()));
		    insuranceMoney=Double.parseDouble((String) mapData.getValue());
		    Integer insuranceType=Integer.parseInt(mapData.getKey());//变更保额的险种ID
		    Map<String, Object> map2=new HashMap<>();
			map2.put("insuranceMoney", insuranceMoney);
			map2.put("testCarId", testCarId);
			map2.put("insurerId", insureId);
			map2.put("insuranceType", insuranceType);
			list.add(map2);
		  }
		}
		List<Integer> newInsuranceTypeId = insuranceTypeId.stream().distinct().collect(Collectors.toList()); 
		int i=insurerServiece.insertInsurerRecord(testCarId, insureId, newInsuranceTypeId,priceDouble, DateUtil.stringToDate(endTime, DateUtil.sdf2), employeeID,list);
		if (i <= 0) {
			ari.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
			ari.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
		}
//		Map<String, Object> map=new HashMap<>();
//		map.put("testCarId", 2);
//		map.put("1", "y");
//		map.put("price", "3200");
//		map.put("2", "y");
//		map.put("2", "33333");
//		map.put("3", "y");
//		map.put("3", "35002");
//		map.put("endTime", "2018-06-12");
//		map.put("insureId", 1);
//		testCarId=(Integer) map.get("testCarId");
//		price=(String) map.get("price");
//		endTime=(String) map.get("endTime");
//		insurerId=(Integer)map.get("insureId");
//		Logger logger=Logger.getLogger(this.getClass());
//		logger.info(map);
//		//遍历map 获取险种ID、carId等
//		Map<String, Object> map2=null;
//		for(Map.Entry<String, Object> entry : map.entrySet()){
//		   System.out.println("key= "+entry.getKey()+" and value= "+entry.getValue());
//		  
//		   String entrys=entry.getKey();
//		    if (!entrys.equals("testCarId")&&!entrys.equals("price")
//				&&!entrys.equals("endTime")&&!entrys.equals("insureId")){
//				insuranceTypeId.add(Integer.parseInt(entrys));
//			}
//		    //获取险种及对应的包额
//		    if(!entrys.equals("testCarId")&&!entrys.equals("price")
//					&&!entrys.equals("endTime")&&!entrys.equals("insureId")
//					&&!entry.getValue().equals("y")
//					){//获取剩下的险种ID及对应的金额
//				    //传险种ID及保额，进行更新
//					map2=new HashMap<>();//添加保额的map2条件
//				    insuranceMoney=(String) entry.getValue();
//				    Integer insuranceType=Integer.valueOf(entry.getKey());
//					map2.put("insuranceMoney", insuranceMoney);
//					map2.put("testCarId", testCarId);
//					map2.put("insurerId", insurerId);
//					map2.put("insuranceType", insuranceType);
//					list.add(map2);
//			}
		
//		}
//		Double priceDouble=null;
//		if(price !=null) {
//			 priceDouble= Double.parseDouble(price);
//		}
//		//去重
//		List<Integer> newInsuranceTypeId = insuranceTypeId.stream().distinct().collect(Collectors.toList()); 
//		int i=insurerServiece.insertInsurerRecord(testCarId, insurerId, newInsuranceTypeId,priceDouble, DateUtil.stringToDate(endTime, DateUtil.sdf1), employeeID,list);
//		if(i<=0) {
//			if (i <= 0) {
//				ari.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
//				ari.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
//			}
//		}
		return ari;
	}
	 */
	
	/**
	 * 试驾车保险登记
	 * @param commercialPic
	 * @param saliPic
	 * @param testCarId
	 * @param price
	 * @param insureId
	 * @param endTime
	 * @param request
	 * @return
	 */
	@ApiOperation(value="试驾车保险登记")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "familyId", value = "车系id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/testCarInsurerRecord",method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo testCarInsurerRecord(
    		String commercialPic,//商业险图片地址
    		String saliPic,//交强险图片地址
    		Integer testCarId,
    		String price,
    		Integer insureId,
    		String endTime,
    		HttpServletRequest request
    		) {
		Employee emp = getMember(request);
		ApiReturnInfo ari = new ApiReturnInfo();
		Integer employeeID=emp.getId();
		Double priceDouble=Double.parseDouble(price);
		CarInsuranceRecord carInsuranceRecord=new CarInsuranceRecord();
		carInsuranceRecord.setCreateDate(new Date());
		carInsuranceRecord.setCommercialPic(commercialPic);
		carInsuranceRecord.setEndTime(DateUtil.stringToDate(endTime, DateUtil.sdf2));
		carInsuranceRecord.setPrice(priceDouble);
		carInsuranceRecord.setOperatorId(emp.getId());
		carInsuranceRecord.setInsurerId(insureId);
		carInsuranceRecord.setSaliPic(saliPic);
		carInsuranceRecord.setTestCarId(testCarId);
		int i=insurerServiece.addInsureRecord(carInsuranceRecord);
		if (i <= 0) {
			ari.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
			ari.setMessage(ResultCodeEnum.RESULT_CODE_ERROR.getMessage());
		}
		return ari;
	}
	/**
	 * 保险公司及险种 wp
	 * @param request
	 * @return
	 */
	@ApiOperation(value="保险公司及险种")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "familyId", value = "车系id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/selectInsurerAndType",method = {RequestMethod.POST })
    @ResponseBody
    public ApiReturnInfo selectInsurerAndType(HttpServletRequest request) {
		Employee emp = getMember(request);
		ApiReturnInfo ari = new ApiReturnInfo();
		Integer storeId=emp.getStoreId();
		//查保险公司
		List<Insurer> listinsure=insurerServiece.selectInsure(storeId);
		/*List<Insurer> list=insurerServiece.selectInsurerAndType();//保险公司列
		for (Insurer insurer : list) {
			List<InsuranceType> listt=insurer.getInsuranceType();//保险公司下的父险种
			for (InsuranceType insuranceType : listt) {
				Integer parentId=insuranceType.getId();
				//查子保险 
				List<InsuranceType> listchilds=insurerServiece.selectChildInsuranceTypes(parentId);
				//将子保险添加至险种的insuranceTypes属性中
				insuranceType.setInsuranceTypes(listchilds);
			}
		}*/
		//查父险种
		List<Map<String, Object>> listinsureTypes=insurerServiece.selectTypes();
		//获取子险种
		for (Map<String, Object> insuranceType : listinsureTypes) {
			insuranceType.put("choiceStatus", 0);//是否选中 0未选 1.选中
			Integer parentId=(Integer) insuranceType.get("id");
			insuranceType.put("moneyNum", 0);
			//查询子保险
			List<Map<String, Object>> list=insurerServiece.selectChildInsuranceTypes(parentId);
			for (Map<String, Object> insuranceType2 : list) {
				insuranceType2.put("choiceStatus", 0);//是否选中 0未选 1选中
				insuranceType2.put("moneyNum", 0);//输入金额
			}
			if(list.size()>0) {//判断父险种如果存在子险种
				insuranceType.put("childTypes",list);
			}
		}
		Map<String, Object> map=new HashMap<>();
		map.put("listinsure", listinsure);
		map.put("listinsureTypes", listinsureTypes);
		ari.setData(map);
		return ari;
	}
	
	/**
	 * 保险公司及险种
	 * @param request
	 * @return
	 */
	@ApiOperation(value="保险公司及险种")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "familyId", value = "车系id", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/getInsurerAndType",method = {RequestMethod.POST })
    @ResponseBody
    public ApiReturnInfo getInsurerAndType(HttpServletRequest request) {
		Employee emp = getMember(request);
		ApiReturnInfo ari = new ApiReturnInfo();
		Integer storeId=emp.getStoreId();
		//查保险公司
		List<Insurer> listinsure=insurerServiece.selectInsure(storeId);
		Map<String, Object> params = null;
		//查父险种
		params = new HashMap<String, Object>();
		params.put("storeId", emp.getStoreId());
		params.put("level", 1);
		List<Map<String, Object>> listinsureTypes=insurerServiece.selectChildTypeList(params);
//		List<Map<String, Object>> listinsureTypes=insurerServiece.selectTypes();
		//获取子险种
		for (Map<String, Object> insuranceType : listinsureTypes) {
			insuranceType.put("choiceStatus", 0);//是否选中 0未选 1.选中
			Integer parentId=(Integer) insuranceType.get("id");
			insuranceType.put("moneyNum", 0);
			insuranceType.put("insuredAmount", 0);
			params = new HashMap<String, Object>();
			params.put("parentId", parentId);
			params.put("storeId", emp.getStoreId());
			params.put("level", 2);
			//查询子保险
			List<Map<String, Object>> list=insurerServiece.selectChildTypeList(params);
			for (Map<String, Object> insuranceType2 : list) {
				insuranceType2.put("choiceStatus", 0);//是否选中 0未选 1选中
				insuranceType2.put("moneyNum", 0);//输入金额
				insuranceType2.put("insuredAmount", 0);
				Integer selfDefined = Integer.valueOf(String.valueOf(insuranceType2.get("selfDefined")));
				if(selfDefined == 2){
					params.put("insuranceId", insuranceType2.get("id"));
					List<Map<String, Object>> amountList=insurerServiece.selectInsuredAmounts(params);
					insuranceType2.put("amountList", amountList);
				}
			}
			if(list.size()>0) {//判断父险种如果存在子险种
				insuranceType.put("childTypes",list);
			}
		}
		Map<String, Object> map=new HashMap<>();
		map.put("listinsure", listinsure);
		map.put("listinsureTypes", listinsureTypes);
		ari.setData(map);
		return ari;
	}
	
}
