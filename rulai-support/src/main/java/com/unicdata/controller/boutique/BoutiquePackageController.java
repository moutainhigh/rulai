package com.unicdata.controller.boutique;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.condition.BoutiquePackageCondition;
import com.unicdata.condition.OutboundCondition;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.boutique.BoutiqueOutbound;
import com.unicdata.entity.boutique.BoutiquePackage;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.OutboundSupportService;
import com.unicdata.service.boutique.PackageSupportService;
import com.unicdata.util.boutique.CheckBoutiquePackageUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/rulai/boutiquePackage")
@Api(value="精品礼包 、出库",tags={"精品库存 -- 礼包 、出库"})
public class BoutiquePackageController extends HomeBaseController{

	private static final Logger LOG = LoggerFactory.getLogger(BoutiquePackageController.class);
	
	
	@Autowired
	private PackageSupportService packageSupportService;
	
	@Autowired
	private OutboundSupportService outboundSupportService;
	
	/**
	 * 新建精品礼包
	 */
	@ApiOperation(value = "新建精品礼包", notes = "")
	@ApiImplicitParam(name = "packageInfo", value = "精品礼包", required = true,  dataType = "BoutiquePackage")
	@ResponseBody
	@RequestMapping(value = "/addPackageInfo", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> addPackageInfo(HttpServletRequest request,@RequestBody BoutiquePackage packageInfo){
		ApiReturnInfo<JSONObject> result = new ApiReturnInfo<JSONObject>();
		result.setMessage("添加成功！");
		Employee member = getMember(request);
		if(member != null){
			packageInfo.setStoreId(member.getStoreId());
		}
		JSONObject check = null;
		try {
			check = CheckBoutiquePackageUtils.check(packageInfo);
			Integer status = check.getInteger("status");
			if(status != null && status == 0){
				int add = packageSupportService.insert(packageInfo);
				if(add <= 0 ){
					result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
					result.setMessage("添加失败！");
				}
			}else{
				result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
				result.setMessage("添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("添加失败！");
		}
		result.setData(check);
		return result;
	}
	
	/**
	 * 条件分页查询精品礼包
	 */
	@ApiOperation(value = "条件分页查询精品礼包", notes = "")
	@ApiImplicitParam(name = "condition", value = "条件分页查询", required = true,  dataType = "BoutiquePackageCondition")
	@ResponseBody
	@RequestMapping(value = "/selectPackageByCondition", method = { RequestMethod.POST })
	public ApiReturnInfo<PageInfo<Map<String, Object>>> selectPackageByCondition(HttpServletRequest request,BoutiquePackageCondition condition){
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<PageInfo<Map<String, Object>>>();
		Employee member = getMember(request);
		if(member != null){
			condition.setStoreId(member.getStoreId());
		}
		PageInfo<Map<String, Object>> page = packageSupportService.selectPackageByCondition(condition);
		result.setData(page);
		return result;
	}
	
	/**
	 * 根据礼包id查询
	 */
	@ApiOperation(value = "编辑-根据礼包id查询", notes = "")
	@ApiImplicitParam(name = "id", value = "礼包id", required = true,  dataType = "BoutiquePackageCondition")
	@ResponseBody
	@RequestMapping(value = "/selectPackageById", method = { RequestMethod.POST })
	public ApiReturnInfo<BoutiquePackage> selectPackageById(HttpServletRequest request,Integer id){
		ApiReturnInfo<BoutiquePackage> result = new ApiReturnInfo<BoutiquePackage>();
		Employee member = getMember(request);
		BoutiquePackage pack = packageSupportService.selectPackageById(id);
		result.setData(pack);
		return result;
	}
	
	/**
	 * 编辑精品礼包
	 */
	@ApiOperation(value = "保存编辑精品礼包", notes = "")
	@ApiImplicitParam(name = "packageInfo", value = "精品礼包", required = true,  dataType = "BoutiquePackage")
	@ResponseBody
	@RequestMapping(value = "/updatePackageInfo", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> updatePackageInfo(HttpServletRequest request,@RequestBody BoutiquePackage packageInfo){
		ApiReturnInfo<JSONObject> result = new ApiReturnInfo<JSONObject>();
		
		JSONObject check = null;
		try {
			check = CheckBoutiquePackageUtils.check(packageInfo);
			Integer status = check.getInteger("status");
			if(status != null && status == 0){
				int update = packageSupportService.updatePackageInfo(packageInfo);
				if(update <= 0 ){
					result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
					result.setData(null);
					result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
				}
			}else{
				result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
				result.setData(null);
				result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setData(null);
			result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
		}
		result.setData(check);
		return result;
	}
	
	/**
	 * 精品礼包下架
	 */
	@ApiOperation(value = "精品礼包上架/下架", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "精品礼包id", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "status", value = "是否上架(0-下架 ； 1 -上架)", required = true,  dataType = "Number")
	})
	@ResponseBody
	@RequestMapping(value = "/updatePackageInfoDrop", method = { RequestMethod.POST })
	public ApiReturnInfo<String> updatePackageInfoDrop(HttpServletRequest request,Integer id,Integer status){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		
			int update = packageSupportService.updatePackageInfoDrop(id,status);
			if(update <= 0 ){
				result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
				result.setData("失败！");
				result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
			}else{
				result.setCode(ConstantEnumStatus.OK.getCode());
				result.setData("成功！");
				result.setMessage(ConstantEnumStatus.OK.getReason());
			}
		return result;
	}
	
	/**
	 * 精品出库分页条件查询
	 */
	@ApiOperation(value = "精品出库分页条件查询", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "type", value = "销售出库 - 0 , 维修出库 - 1 ，精品零售 - 2)", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "salveNo", value = "销售订单号", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "employeeName", value = "员工姓名", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "customerName", value = "客户姓名", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "boutiqueNo", value = "精品单号", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "status", value = "单据状态（ 0 - 未出料 ； 1 - 部分出料 ； 2- 全部出料）", required = false,  dataType = "Number"),
		@ApiImplicitParam(name = "pageSize", value = "精品礼包", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "pageNum", value = "精品礼包", required = true,  dataType = "Number")
	})
	@ResponseBody
	@RequestMapping(value = "/selectOutboundByCondition", method = { RequestMethod.POST })
	public ApiReturnInfo<PageInfo<Map<String, Object>>> selectOutboundByCondition(HttpServletRequest request, OutboundCondition condition){
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new  ApiReturnInfo<PageInfo<Map<String, Object>>> ();
		Employee member = getMember(request);
		if(member != null){
			condition.setStoreId(member.getStoreId());
		}
		PageInfo<Map<String, Object>> page = outboundSupportService.selectOutboundByCondition(condition);
		result.setData(page);
		return result;
	}
	
	
	/**
	 * 精品出库领料
	 */
	@ApiOperation(value = "领料", notes = "")
	@ApiImplicitParam(name = "id", value = "出库单id", required = true,  dataType = "Number")
	@ResponseBody
	@RequestMapping(value = "/outboundPicking", method = { RequestMethod.POST })
	public  ApiReturnInfo<BoutiqueOutbound> outboundPicking(HttpServletRequest request,Integer id){
		ApiReturnInfo<BoutiqueOutbound> result = new ApiReturnInfo<BoutiqueOutbound>();		
		if(id == null || id == 0){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
		}else{
			Employee member = getMember(request);
			BoutiqueOutbound json = outboundSupportService.outboundPicking(member.getStoreId(), id);
			result.setData(json);
		}
		return result;
	}
	
	/**
	 * 出库
	 */
	@ApiOperation(value = "出库", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "出库订单Id", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "ids", value = "出库订单详情Id数组", required = true,  dataType = "Array"),
		@ApiImplicitParam(name = "pickerId", value = "领料人姓名", required = true,  dataType = "String")
	})
	@ResponseBody
	@RequestMapping(value = "/beginOutbound", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> beginOutbound(HttpServletRequest request,Integer id , String ids,Integer pickerId){
		ApiReturnInfo<JSONObject> result = new ApiReturnInfo<JSONObject>();
		
		JSONObject resultJson = new JSONObject();
		String[] split = ids.split(",");
		Integer[] Ids = new Integer[split.length];
		for (int i = 0; i <split.length;i++ ) {
			Ids[i] = Integer.parseInt(split[i]);
		}
		try {
			resultJson = outboundSupportService.beginOutbound(id,Ids,pickerId);
//				if(status == 1){
//					result.setData("出库成功！");
//				}else{
//					result.setData("出库失败！");
//					result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
//					result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
//				}
		} catch (Exception e) {
			LOG.error("出库失败！",e);
			e.printStackTrace();
			resultJson.put("status", 1);
			
			resultJson.put("msg", "出库失败！");
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
		}
		result.setData(resultJson);
		return result;
	}
	
}
