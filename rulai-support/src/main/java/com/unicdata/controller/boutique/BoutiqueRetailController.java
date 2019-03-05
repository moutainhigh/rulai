package com.unicdata.controller.boutique;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.condition.BoutiqueInfoCondition;
import com.unicdata.condition.BoutiqueRetailCondition;
import com.unicdata.constant.BoutiqueEnum;
import com.unicdata.constant.BoutiqueEnum.BoutiqueType;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.boutique.BoutiqueRetailCustomer;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.InformationSupportService;
import com.unicdata.service.boutique.RetailCustomerSupportService;
import com.unicdata.service.boutique.RetailSupportService;
import com.unicdata.util.boutique.CheckBoutiqueRetailUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/rulai/boutiqueRetail")
@Api(value="精品零售",tags={"精品零售相关接口"})
public class BoutiqueRetailController  extends HomeBaseController{

	@Autowired
	private InformationSupportService infoService;
	
	@Autowired
	private RetailCustomerSupportService retailCustomerSupportService;
	
	@Autowired
	private RetailSupportService retailSupportService;
	
	/**
	 * 分页条件查询精品信息
	 * @param info
	 * @return
	 */
	@ApiOperation(value = "分页条件查询精品信息", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "code", value = "精品编号", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "name", value = "精品名称", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "pageNum", value = "页码", required = true,  dataType = "Number"),
	})
	@ResponseBody
	@RequestMapping(value = "/selectBoutiqueInfoByCondition", method = { RequestMethod.POST })
	public ApiReturnInfo<PageInfo<Map<String, Object>>> selectBoutiqueInfoByCondition(HttpServletRequest request,BoutiqueInfoCondition condition){
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<PageInfo<Map<String, Object>>>();
		Employee member = getMember(request);
		PageInfo<Map<String, Object>> page = infoService.selectBoutiqueInfoByConditionPage(condition,member.getStoreId());
		result.setData(page);
		return result;
	}
	
	/**
	 * 新增零售客户信息
	 */
	@ApiOperation(value = "新增零售客户信息", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "精品零售客户/企业名称", required = true,  dataType = "String"),
		@ApiImplicitParam(name = "phone", value = "手机号码", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "note", value = "备注", required = false,  dataType = "Number")
	})
	@ResponseBody
	@RequestMapping(value = "/addBoutiqueRetailCustomer", method = { RequestMethod.POST })
	public ApiReturnInfo<BoutiqueRetailCustomer> addBoutiqueRetailCustomer(HttpServletRequest request,BoutiqueRetailCustomer customer){
		ApiReturnInfo<BoutiqueRetailCustomer> result = new ApiReturnInfo<BoutiqueRetailCustomer>();
		Employee member = getMember(request);
		customer.setStoreId(member.getStoreId());
		customer.setTypeLive(1);
		int id =  retailCustomerSupportService.insert(customer);
		if(id > 0 ){
			customer.setId(id);
			result.setData(customer);
		}else{
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setData(null);
			result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
		}
		return result;
	}
	
	/**
	 * 查询零售客户信息
	 */
	@ApiOperation(value = "查询零售客户信息", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "精品零售客户/企业名称", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "phone", value = "手机号码", required = false,  dataType = "String")
	})
	@ResponseBody
	@RequestMapping(value = "/selectBoutiqueRetailCustomer", method = { RequestMethod.POST })
	public ApiReturnInfo<List<BoutiqueRetailCustomer>> selectBoutiqueRetailCustomer(HttpServletRequest request,BoutiqueRetailCustomer customer){
		ApiReturnInfo<List<BoutiqueRetailCustomer>> result = new ApiReturnInfo<List<BoutiqueRetailCustomer>>();
		Employee member = getMember(request);
		customer.setStoreId(member.getStoreId());
		try {
			List<BoutiqueRetailCustomer> select = retailCustomerSupportService.selectBoutiqueRetailCustomer(customer);
			result.setData(select);
		} catch (Exception e) {
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setData(null);
			result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
		}

		return result;
	}
	
	
	/**
	 * 精品零售单新增
	 */
	@ApiOperation(value = "精品零售单新增", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "employeeId", value = "员工id", required = true,  dataType = "Number"),
/*		@ApiImplicitParam(name = "operatorId", value = "操作人员id", required = true,  dataType = "Number"),*/
		@ApiImplicitParam(name = "customerId", value = "客户/企业名称id", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "invoice", value = "是否开发票( 0 - 未开发票 ； 1- 开发票)", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "saleCount", value = "销售总价", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "applyCount", value = "申请总价", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "reason", value = "原因", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "list", value = "订单包含具体精品的集合", required = true,  dataType = "Array[BoutiqueRetailInclude]")
	})
	@ResponseBody
	@RequestMapping(value = "/addBoutiqueRetail", method = { RequestMethod.POST })	
	public ApiReturnInfo<JSONObject> addBoutiqueRetail(HttpServletRequest request,@RequestBody BoutiqueRetail retail){
		ApiReturnInfo<JSONObject> result = new ApiReturnInfo<JSONObject>();
		try {
			JSONObject json = CheckBoutiqueRetailUtils.check(retail);
			result.setData(json);
			Integer status = json.getInteger("status");
			if(status != null && status == 0){
				Employee member = getMember(request);
				retail.setOperatorId(member.getId());
				int add = retailSupportService.addBoutiqueRetail(retail,member.getStoreId(),BoutiqueEnum.BoutiqueSource.RETAIL,BoutiqueEnum.BoutiqueType.APPROVAL_WAIT);
				if(add <= 0 ){
					result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
					result.setMessage("添加失败！");
				}
			}else{
				result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
				result.setMessage("添加失败！");
			}
		} catch (Exception e) {
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("添加失败！");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 精品零售明细
	 */
	@ApiOperation(value = "精品零售明细", notes = "")
	@ApiImplicitParam(name = "id", value = "精品订单id", required = true,  dataType = "Array[BoutiqueRetailInclude]")
	@ResponseBody
	@RequestMapping(value = "/selectBoutiqueRetailDetail", method = { RequestMethod.POST })	
	public ApiReturnInfo<BoutiqueRetail> selectBoutiqueRetailDetail(HttpServletRequest request,Integer id){
		ApiReturnInfo<BoutiqueRetail> result = new ApiReturnInfo<BoutiqueRetail>();
		BoutiqueRetail retail = retailSupportService.selectBoutiqueRetailDetailById(id);
		result.setData(retail);
		return result;
	}
	
	
	/**
	 * 分页条件查询零售订单
	 */
	@ApiOperation(value = "分页条件查询零售", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "精品订单id", required = false,  dataType = "Number"),
		@ApiImplicitParam(name = "code", value = "精品订单编号", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "customerName", value = "客户姓名", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "saleDate", value = "销售日期", required = false,  dataType = "date"),
		@ApiImplicitParam(name = "type", value = "状态 (0,'无需审批'),(1,'待审批'),(2,'审批不通过'),(3,'审批通过')", required = false,  dataType = "Number"),
		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "pageNum", value = "页码", required = true,  dataType = "Number")
	})
	@ResponseBody
	@RequestMapping(value = "/selectBoutiqueRetailPage", method = { RequestMethod.POST })	
	public ApiReturnInfo<PageInfo<Map<String, Object>>> selectBoutiqueRetailPage(HttpServletRequest request,BoutiqueRetailCondition condition){
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<PageInfo<Map<String, Object>>>();
		Employee member = getMember(request);
		condition.setStoreId(member.getStoreId());
		PageInfo<Map<String, Object>> page = retailSupportService.selectBoutiqueRetailPage(condition);
		result.setData(page);
		return result;
	}
	
	/**
	 * 精品零售状态
	 */
	@ApiOperation(value = "精品零售状态", notes = "")
	@ResponseBody
	@RequestMapping(value = "/selectAllBoutiqueType", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONArray> selectAllBoutiqueType(){
		ApiReturnInfo<JSONArray> result = new ApiReturnInfo<JSONArray>();
		
		JSONObject json = new JSONObject();
		
		JSONArray array = new JSONArray();
		JSONObject retailType1 = new JSONObject();
		retailType1.put("code", BoutiqueType.NULL.getCode());
		retailType1.put("value", BoutiqueType.NULL.getReason());
		array.add(retailType1);
		JSONObject retailType2 = new JSONObject();
		retailType2.put("code", BoutiqueType.APPROVAL_WAIT.getCode());
		retailType2.put("value", BoutiqueType.APPROVAL_WAIT.getReason());
		array.add(retailType2);
		JSONObject retailType3 = new JSONObject();
		retailType3.put("code", BoutiqueType.APPROVAL_REFUSE.getCode());
		retailType3.put("value", BoutiqueType.APPROVAL_REFUSE.getReason());
		array.add(retailType3);
		JSONObject retailType4 = new JSONObject();
		retailType4.put("code", 3);
		retailType4.put("value", "审批通过");
		array.add(retailType4);
		result.setData(array);
		
		return result;
	}
	
}
