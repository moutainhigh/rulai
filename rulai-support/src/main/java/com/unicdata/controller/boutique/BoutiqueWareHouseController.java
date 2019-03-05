package com.unicdata.controller.boutique;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.unicdata.condition.BoutiqueInfoCondition;
import com.unicdata.condition.WareHouseChangeCondition;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.boutique.BoutiqueWarehouse;
import com.unicdata.entity.boutique.BoutiqueWarehouseChange;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.InformationSupportService;
import com.unicdata.service.boutique.WarehouseChangeDetailSupportService;
import com.unicdata.service.boutique.WarehouseChangeSupportService;
import com.unicdata.util.boutique.CheckBoutiquePackageUtils;
import com.unicdata.util.boutique.CheckBoutiqueWarehouseChangeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/rulai/boutiquePackage")
@Api(value="精品库位变更",tags={"库位变更相关接口"})
public class BoutiqueWareHouseController extends HomeBaseController{

	@Autowired
	private InformationSupportService infoService;
	
	@Autowired
	private WarehouseChangeDetailSupportService warehouseChangeDetailSupportService;
	
	@Autowired
	private WarehouseChangeSupportService wsarehouseChangeSupportService;
	
	/**
	 * 精品查询
	 * @param info
	 * @return
	 */
	@ApiOperation(value = "精品查询", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "code", value = "精品编号", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "name", value = "精品名称", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "warehouseId", value = "仓库id", required = false,  dataType = "Number"),
		@ApiImplicitParam(name = "positionId", value = "库位id", required = false,  dataType = "Number"),
		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "pageNum", value = "页码", required = true,  dataType = "Number")
	})
	@ResponseBody
	@RequestMapping(value = "/selectBoutiqueByCondition", method = { RequestMethod.POST })
	public ApiReturnInfo<PageInfo<Map<String, Object>>> selectBoutiqueByCondition(HttpServletRequest request,BoutiqueInfoCondition condition){
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<PageInfo<Map<String, Object>>>();
		Employee member = getMember(request);
		condition.setStoreId(member.getStoreId());
		PageInfo<Map<String, Object>> page = infoService.selectBoutiqueInfoByConditionPage(condition,member.getStoreId());
		result.setData(page);
		return result;
	}
	
	/**
	 * 仓库仓位变更
	 */
	@ApiOperation(value = "仓库仓位变更确认", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "applyName", value = "申请名称", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "applyDate", value = "申请时间", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "note", value = "备注", required = false,  dataType = "Number"),
		@ApiImplicitParam(name = "list", value = "发生变更仓库、库位、库存变更的精品集合", required = true,  dataType = "Array")
		
	})
	@ResponseBody
	@RequestMapping(value = "/addBoutiqueWareHouseChange", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> addBoutiqueWareHouseChange(HttpServletRequest request,@RequestBody BoutiqueWarehouseChange wareHouseChange){
		ApiReturnInfo<JSONObject> result = new ApiReturnInfo<JSONObject>();
		result.setMessage("变更成功！");
		Employee member = getMember(request);
		if(member != null){
			wareHouseChange.setStoreId(member.getStoreId());
		}
		JSONObject check = null;
		try {
			check = CheckBoutiqueWarehouseChangeUtil.check(wareHouseChange);
			Integer status = check.getInteger("status");
			if(status != null && status == 0){
				int add = wsarehouseChangeSupportService.insert(wareHouseChange);
				if(add <= 0 ){
					result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
					result.setMessage("变更失败！");
				}
			}else{
				result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
				result.setMessage("变更失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("变更失败！");
		}
		result.setData(check);
		
		return result;
	}
	
	/**
	 * 明细
	 */
	@ApiOperation(value = "明细", notes = "")
	@ApiImplicitParam(name = "id", value = "变更id", required = true,  dataType = "Array")
	@ResponseBody
	@RequestMapping(value = "/selectBoutiqueWareHouseChangeDetail", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> selectBoutiqueWareHouseChangeDetail(HttpServletRequest request,Integer id){
		ApiReturnInfo<JSONObject> result = new ApiReturnInfo<JSONObject>();
		JSONObject json = warehouseChangeDetailSupportService.selectBoutiqueWareHouseChangeDetail(id);
		result.setData(json);
		return result;
	}
	
	/**
	 * 条件分页查询仓库库位变更
	 */
	@ApiOperation(value = "条件分页查询仓库库位变更", notes = "")
	@ApiImplicitParam(name = "id", value = "变更id", required = true,  dataType = "Array")
	@ResponseBody
	@RequestMapping(value = "/selectBoutiqueWareHouseChangePage", method = { RequestMethod.POST })
	public ApiReturnInfo<PageInfo<Map<String, Object>>> selectBoutiqueWareHouseChangePage(HttpServletRequest request,WareHouseChangeCondition condition){
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<PageInfo<Map<String, Object>>>();
		Employee member = getMember(request);
		condition.setStoreId(member.getStoreId());
		PageInfo<Map<String, Object>> page = wsarehouseChangeSupportService.selectBoutiqueWareHouseChangePage(condition);
		result.setData(page);
		return result;
	}
	
	
	
}
