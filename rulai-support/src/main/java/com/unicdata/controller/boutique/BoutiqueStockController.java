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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.condition.BoutiqueInfoCondition;
import com.unicdata.condition.PushWareHouseCondition;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiquePushWarehouse;
import com.unicdata.entity.boutique.BoutiquePushWarehouseDetail;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.InformationSupportService;
import com.unicdata.service.boutique.PushWarehouseSupportService;
import com.unicdata.util.boutique.CheckPushWareHouseUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/rulai/boutiqueStock")
@Api(value="精品库存",tags={"精品库存 -- 入库 、 库存"})
public class BoutiqueStockController extends HomeBaseController{

	@Autowired
	private PushWarehouseSupportService pushWarehouseSupportService;
	
	@Autowired
	private InformationSupportService infoService;
	
	/**
	 * 精品入库导入
	 * 
	 * status 为  0 可以入库
	 * status 不为0 不可以入库
	 *  
	 * 
	 */
	@ApiOperation(value = "精品入库导入", notes = "")
	@ApiImplicitParam(name = "detailExcel", value = "form表单设置enctype=\"multipart/form-data\" , input标签name为detailExcel ", required = true,  dataType = "BoutiquePushWarehouse")
	@ResponseBody
	@RequestMapping(value = "/importPushWarehouseInfoDetail", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> importPushWarehouseInfoDetail(HttpServletRequest request){
		ApiReturnInfo<JSONObject> result = new ApiReturnInfo<JSONObject>();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("detailExcel");
		Employee member = getMember(request);
		JSONObject check = CheckPushWareHouseUtils.importCheck(file,member.getStoreId());
		result.setData(check);
		return result;
	}
	
	/**
	 * 精品入库
	 */
	@ApiOperation(value = "入库", notes = "")
	@ApiImplicitParam(name = "info", value = "入库信息", required = true,  dataType = "BoutiquePushWarehouse")
	@ResponseBody
	@RequestMapping(value = "/addPushWarehouseInfo", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> addPushWarehouseInfo(HttpServletRequest request,@RequestBody BoutiquePushWarehouse info){
		ApiReturnInfo<JSONObject> result = new ApiReturnInfo<JSONObject>();
		result.setMessage("添加成功！");
		Employee member = getMember(request);
		if(member != null){
			info.setStoreId(member.getStoreId());
		}
		JSONObject check = null;
		try {
			check = CheckPushWareHouseUtils.check(info);
			Integer status = check.getInteger("status");
			if(status != null && status == 0){
				int add = pushWarehouseSupportService.insert(info);
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
	 * 精品入库分页条件查询
	 */
	@ApiOperation(value = "精品入库分页条件查询", notes = "")
	@ApiImplicitParam(name = "PushWareHouseCondition", value = "分页条件", required = false,  dataType = "PushWareHouseCondition")
	@ResponseBody
	@RequestMapping(value = "/selectPushWarehouseByCondition", method = { RequestMethod.POST })
	public ApiReturnInfo<PageInfo<Map<String, Object>>> selectPushWarehouseByCondition(HttpServletRequest request,PushWareHouseCondition condition){
		ApiReturnInfo<PageInfo<Map<String, Object>>> result =  new ApiReturnInfo<PageInfo<Map<String, Object>>>();
		Employee member = getMember(request);
		if(member != null){
			condition.setStoreId(member.getStoreId());
		}
		PageInfo<Map<String, Object>> page = pushWarehouseSupportService.selectPushWarehouseByCondition(condition);
		result.setData(page);
		return result;
	}
	
	/**
	 * 精品入库查看详细
	 */
	@ApiOperation(value = "精品入库查看详细", notes = "")
	@ApiImplicitParam(name = "id", value = "页码", required = false,  dataType = "Number")
	@ResponseBody
	@RequestMapping(value = "/selectPushWarehouseById", method = { RequestMethod.POST })
	public ApiReturnInfo<List<BoutiquePushWarehouseDetail>> selectPushWarehouseById(HttpServletRequest request,PushWareHouseCondition condition){
		ApiReturnInfo<List<BoutiquePushWarehouseDetail>> result =  new ApiReturnInfo<List<BoutiquePushWarehouseDetail>>();
		Employee member = getMember(request);
		if(member != null){
			condition.setStoreId(member.getStoreId());
		}
		List<BoutiquePushWarehouseDetail> list = pushWarehouseSupportService.selectPushWarehouseById(condition);
		result.setData(list);
		return result;
	}
	
	
	/**
	 * 精品库存
	 * @param info
	 * @return
	 */
	@ApiOperation(value = "分页条件查询精品库存", notes = "")
	@ApiImplicitParam(name = "condition", value = "精品分页查询条件", required = false,  dataType = "BoutiqueInfoCondition")
	@ResponseBody
	@RequestMapping(value = "/selectBoutiqueStockByCondition", method = { RequestMethod.POST })
	public ApiReturnInfo<PageInfo<Map<String, Object>>> selectBoutiqueStockByCondition(HttpServletRequest request,BoutiqueInfoCondition condition){
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<PageInfo<Map<String, Object>>>();
		Employee member = getMember(request);
		PageInfo<Map<String, Object>> page = infoService.selectBoutiqueInfoByConditionPage(condition,member.getStoreId());
		result.setData(page);
		return result;
	}
	
	/**
	 * 精品下架\上架
	 * @param info
	 * @return
	 */
	@ApiOperation(value = "精品下架、上架", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "精品id", required = false,  dataType = "Number"),
		@ApiImplicitParam(name = "status", value = "状态(0 下架； 1 上架)", required = false,  dataType = "Number"),
	})
	@ResponseBody
	@RequestMapping(value = "/updateBoutiqueStatus", method = { RequestMethod.POST })
	public ApiReturnInfo<String> updateBoutiqueStatus(HttpServletRequest request,BoutiqueInformation info){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		int update = infoService.updateBoutiqueStatus(info);
		if(update == 1){
			result.setData("更新成功！");
		}else{
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setData("更新失败！");
			result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
		}
		return result;
	}
	
	
	
}
