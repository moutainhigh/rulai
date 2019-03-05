package com.unicdata.controller.boutique;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.boutique.BoutiqueBrand;
import com.unicdata.entity.boutique.BoutiqueClassify;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiqueSupplier;
import com.unicdata.entity.boutique.BoutiqueUnit;
import com.unicdata.entity.boutique.BoutiqueWarehouse;
import com.unicdata.entity.boutique.BoutiqueWarehousePosition;
import com.unicdata.entity.counter.Counter;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.CounterService;
import com.unicdata.service.boutique.BrandSupportService;
import com.unicdata.service.boutique.ClassifySupportService;
import com.unicdata.service.boutique.InformationSupportService;
import com.unicdata.service.boutique.SupplierSupportService;
import com.unicdata.service.boutique.UnitSuppourtService;
import com.unicdata.service.boutique.WarehousePositionSupportService;
import com.unicdata.service.boutique.WarehouseSupportService;
import com.unicdata.util.boutique.CheckBouttiqueUtils;
import com.unicdata.util.boutique.CheckClassifyUtils;
import com.unicdata.util.boutique.CheckSupplierUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/rulai/boutiqueBase")
@Api(value="精品管理 - 基础数据管理",tags={"精品管理 - 基础数据管理相关接口"})
public class BoutiqueBaseController extends HomeBaseController{

	@Autowired
	private InformationSupportService infoService;
	
	@Autowired
	private WarehouseSupportService warehouseSupportService;
	
	@Autowired
	private WarehousePositionSupportService warehousePositionSupportService;
	
	@Autowired
	private BrandSupportService brandSupportService;
	
	@Autowired
	private ClassifySupportService classifySupportService;
	
	@Autowired
	private UnitSuppourtService unitSuppourtService;
	
	@Autowired
	private SupplierSupportService supportService;
	
	@Value("${upload.access.path}")
	private String pictuerURL;	
	//精品基础信息
	/**
	 * 增加单个基础精品信息
	 */
	@ApiOperation(value = "增加单个基础精品信息", notes = "")
	@ApiImplicitParam(name = "info", value = "基础精品信息", required = true,  dataType = "BoutiqueInformation")
	@ResponseBody
	@RequestMapping(value = "/addBoutiqueInfo", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> addBoutiqueInfo(HttpServletRequest request,BoutiqueInformation info){
		ApiReturnInfo<JSONObject> result = new ApiReturnInfo<JSONObject>();
		result.setMessage("添加成功！");
		JSONObject check = CheckBouttiqueUtils.checkBouttique(info);
		Integer status = check.getInteger("status");
		if(status != null && status == 0){
			Employee member = getMember(request);
			if(member != null){
				info.setStoreId(member.getStoreId());
			}
			info.setTaxCost(new BigDecimal(0));
			info.setStatus(1);
			info.setTypeLive(1);
			info.setStock(0);
			info.setVersion(0);
			info.setIsShelf(1);
			String classify = info.getClassify();
			
			if(classify.indexOf("-") >= 0){
				String[] split = classify.split("-");
				int classifyId = Integer.parseInt(split[split.length-1]);
				info.setClassifyId(classifyId);
			}else{
				int classifyId = Integer.parseInt(classify);
				info.setClassifyId(classifyId);
			}
			classifySupportService.updateClassifyUse(info.getClassifyId());
			
			int add = infoService.insert(info);
			if(add <= 0 ){
				result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
				result.setMessage("添加失败！");
			}
		}else{
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("添加失败！");
		}
		result.setData(check);
		return result;
	}
	
	/**
	 * 删除精品信息
	 * @param info
	 * @return
	 */
	@ApiOperation(value = "删除精品信息", notes = "")
	@ApiImplicitParam(name = "id", value = "精品id", required = true,  dataType = "Number")
	@ResponseBody
	@RequestMapping(value = "/deleteBoutiqueInfo", method = { RequestMethod.POST })
	public ApiReturnInfo<String> deleteBoutiqueInfo(HttpServletRequest request,@RequestBody BoutiqueInformation info){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		Employee member = getMember(request);
		BoutiqueInformation information = infoService.selectBoutiqueInfoById(info.getId(), member.getStoreId());
		
		int delete = infoService.deleteById(info.getId());
		
		Integer countUse = infoService.selectCountUseByClassifyId(information.getClassifyId(), member.getStoreId());
		if(countUse.equals(0)){
			classifySupportService.updateClassifyNotUse(information.getClassifyId());
		}
		
		if(delete <= 0){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("删除失败!");
		}else{
			result.setData("删除成功！");
		}
		return result;
	}
	
	/**
	 * 保存修改精品信息
	 * @param info
	 * @return
	 */
	@ApiOperation(value = "保存修改精品信息", notes = "")
	@ApiImplicitParam(name = "id", value = "精品id", required = true,  dataType = "Number")
	@ResponseBody
	@RequestMapping(value = "/updateBoutiqueInfo", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> updateBoutiqueInfo(BoutiqueInformation info){
		ApiReturnInfo<JSONObject> result = new ApiReturnInfo<JSONObject>();
		result.setMessage("修改成功！");
		JSONObject check = CheckBouttiqueUtils.checkBouttique(info);
		Integer status = check.getInteger("status");
		if(status != null && status == 0){
			info.setStatus(1);
			info.setTypeLive(1);
			int add = infoService.update(info);
			if(add <= 0 ){
				result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
				result.setMessage("修改失败！");
			}
		}else{
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("修改失败！");
		}
		result.setData(check);
		return result;
	}
	
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
		@ApiImplicitParam(name = "warehouseId", value = "仓库ID", required = false,  dataType = "Number"),
		@ApiImplicitParam(name = "positionId", value = "库位ID", required = false,  dataType = "Number")
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
	 * 条件查询所有精品信息
	 * @param info
	 * @return
	 */
	@ApiOperation(value = "条件查询所有精品信息", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "code", value = "精品编号", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "name", value = "精品名称", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "warehouseId", value = "仓库ID", required = false,  dataType = "Number"),
		@ApiImplicitParam(name = "positionId", value = "库位ID", required = false,  dataType = "Number")
	})
	@ResponseBody
	@RequestMapping(value = "/selectBoutiqueInfoListByCondition", method = { RequestMethod.POST })
	public ApiReturnInfo<List<BoutiqueInformation>> selectBoutiqueInfoListByCondition(HttpServletRequest request,BoutiqueInfoCondition condition){
		ApiReturnInfo<List<BoutiqueInformation>> result = new ApiReturnInfo<List<BoutiqueInformation>>();
		Employee member = getMember(request);
		List<BoutiqueInformation> list = infoService.selectBoutiqueInfoListByCondition(condition,member.getStoreId());
		result.setData(list);
		return result;
	}
	
	
	/**
	 * 根据id查询精品信息
	 * @param info
	 * @return
	 */
	@ApiOperation(value = "根据id查询精品信息", notes = "")
	@ApiImplicitParam(name = "id", value = "精品编号", required = true,  dataType = "Number")
	@ResponseBody
	@RequestMapping(value = "/selectBoutiqueInfoById", method = { RequestMethod.POST })
	public ApiReturnInfo<BoutiqueInformation> selectBoutiqueInfoById(HttpServletRequest request,Integer id){
		ApiReturnInfo<BoutiqueInformation> result = new ApiReturnInfo<BoutiqueInformation>();
		Employee member = getMember(request);
		BoutiqueInformation boutiqueInformation = infoService.selectBoutiqueInfoById(id,member.getStoreId());
		result.setData(boutiqueInformation);
		return result;
	}
	
	
	//仓库
	/**
	 * 添加精品仓库
	 */
	@ApiOperation(value = "添加精品仓库", notes = "")
	@ApiImplicitParam(name = "BoutiqueWarehouse", value = "精品仓库", required = true,  dataType = "BoutiqueWarehouse")
	@ResponseBody
	@RequestMapping(value = "/addWarehouse", method = { RequestMethod.POST })
	public ApiReturnInfo<String> addWarehouse(HttpServletRequest request,BoutiqueWarehouse warehouse){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		Employee member = getMember(request);
		if(member != null){
			warehouse.setStoreId(member.getStoreId());
		}
		warehouse.setTypeLive(1);
		int add = warehouseSupportService.add(warehouse);
		if(add <= 0 ){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
		}
		return result;
	}
	
	/**
	 * 删除精品仓库
	 */
	@ApiOperation(value = "删除精品仓库", notes = "")
	@ApiImplicitParam(name = "BoutiqueWarehouse", value = "精品仓库", required = true,  dataType = "BoutiqueWarehouse")
	@ResponseBody
	@RequestMapping(value = "/deleteWarehouse", method = { RequestMethod.POST })
	public ApiReturnInfo<String> deleteWarehouse(HttpServletRequest request,BoutiqueWarehouse warehouse){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		Employee member = getMember(request);
		if(member != null){
			warehouse.setStoreId(member.getStoreId());
		}
		int update = warehouseSupportService.deleteById(warehouse.getId());
		if(update <= 0 ){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
		}
		return result;
	}
	
	/**
	 * 修改精品仓库
	 */
	@ApiOperation(value = "保存修改精品仓库", notes = "")
	@ApiImplicitParam(name = "BoutiqueWarehouse", value = "精品仓库", required = true,  dataType = "BoutiqueWarehouse")
	@ResponseBody
	@RequestMapping(value = "/updateWarehouse", method = { RequestMethod.POST })
	public ApiReturnInfo<String> updateWarehouse(HttpServletRequest request,BoutiqueWarehouse warehouse){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		Employee member = getMember(request);
		if(member != null){
			warehouse.setStoreId(member.getStoreId());
		}
		int update = warehouseSupportService.update(warehouse);
		if(update <= 0 ){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
		}
		return result;
	}
	
	/**
	 * 查询所有精品仓库
	 */
	@ApiOperation(value = "查询所有精品仓库", notes = "")
	@ResponseBody
	@RequestMapping(value = "/selectWarehouseAll", method = { RequestMethod.GET })
	public ApiReturnInfo<List<BoutiqueWarehouse>> selectWarehouseAll(HttpServletRequest request,BoutiqueWarehouse warehouse){
		ApiReturnInfo<List<BoutiqueWarehouse>> result = new ApiReturnInfo<List<BoutiqueWarehouse>>();
		Employee member = getMember(request);
		if(member != null){
			warehouse.setStoreId(member.getStoreId());
		}
		List<BoutiqueWarehouse> findAll = warehouseSupportService.findAll(warehouse.getStoreId());
		result.setData(findAll);
		return result;
	}
	
	//仓库库位
	/**
	 * 添加精品仓库库位
	 */
	@ApiOperation(value = "添加精品仓库库位", notes = "")
	@ApiImplicitParam(name = "BoutiqueWarehousePosition", value = "精品仓库", required = true,  dataType = "BoutiqueWarehousePosition")
	@ResponseBody
	@RequestMapping(value = "/addWarehousePosition", method = { RequestMethod.POST })
	public ApiReturnInfo<String> addWarehousePosition(HttpServletRequest request,BoutiqueWarehousePosition warehousePosition){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		Employee member = getMember(request);
		if(member != null){
			warehousePosition.setStoreId(member.getStoreId());
		}
		warehousePosition.setTypeLive(1);
		int add = warehousePositionSupportService.add(warehousePosition);
		if(add <= 0 ){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
		}
		return result;
	}
	
	/**
	 * 删除精品仓库库位
	 */
	@ApiOperation(value = "删除精品仓库库位", notes = "")
	@ApiImplicitParam(name = "BoutiqueWarehousePosition", value = "精品仓库库位", required = true,  dataType = "BoutiqueWarehousePosition")
	@ResponseBody
	@RequestMapping(value = "/deleteWarehousePosition", method = { RequestMethod.POST })
	public ApiReturnInfo<String> deleteWarehousePosition(HttpServletRequest request,BoutiqueWarehousePosition warehousePosition){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		Employee member = getMember(request);
		if(member != null){
			warehousePosition.setStoreId(member.getStoreId());
		}
		int update = warehousePositionSupportService.deleteById(warehousePosition.getId());
		if(update <= 0 ){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
		}
		return result;
	}
	
	/**
	 * 修改精品仓库库位
	 */
	@ApiOperation(value = "保存修改精品仓库库位", notes = "")
	@ApiImplicitParam(name = "BoutiqueWarehousePosition", value = "精品仓库", required = true,  dataType = "BoutiqueWarehousePosition")
	@ResponseBody
	@RequestMapping(value = "/updateWarehousePosition", method = { RequestMethod.POST })
	public ApiReturnInfo<String> updateWarehousePosition(HttpServletRequest request,BoutiqueWarehousePosition warehousePosition){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		Employee member = getMember(request);
		if(member != null){
			warehousePosition.setStoreId(member.getStoreId());
		}
		int update = warehousePositionSupportService.update(warehousePosition);
		if(update <= 0 ){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
		}
		return result;
	}
	
	/**
	 * 根据仓库id查询所有精品仓库库位
	 */
	@ApiOperation(value = "根据仓库id查询所有精品仓库库位", notes = "")
	@ApiImplicitParam(name = "id", value = "精品仓库id", required = true,  dataType = "Number")
	@ResponseBody
	@RequestMapping(value = "/selectWarehousePositionAll", method = { RequestMethod.POST })
	public ApiReturnInfo<List<BoutiqueWarehousePosition>> selectWarehousePositionAll(HttpServletRequest request,BoutiqueWarehouse warehouse){
		ApiReturnInfo<List<BoutiqueWarehousePosition>> result = new ApiReturnInfo<List<BoutiqueWarehousePosition>>();
		Employee member = getMember(request);
		if(member != null){
			warehouse.setStoreId(member.getStoreId());
		}
		List<BoutiqueWarehousePosition> findAll = warehousePositionSupportService.findAllByWarehouseId(warehouse.getId(),warehouse.getStoreId());
		result.setData(findAll);
		return result;
	}
	
	/**
	 * 根据仓库id查询精品仓库库位分页显示
	 */
	@ApiOperation(value = "根据仓库id查询精品仓库库位分页显示", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "精品仓库id", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "pageNum", value = "页码", required = true,  dataType = "Number")
	})
	@ResponseBody
	@RequestMapping(value = "/selectWarehousePositionAllPage", method = { RequestMethod.POST })
	public ApiReturnInfo<PageInfo<Map<String, Object>>> selectWarehousePositionAllPage(HttpServletRequest request,BoutiqueWarehouse warehouse
			,Integer pageSize,Integer pageNum){
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<PageInfo<Map<String, Object>>>();
		Employee member = getMember(request);
		if(member != null){
			warehouse.setStoreId(member.getStoreId());
		}
		PageInfo<Map<String, Object>> page = warehousePositionSupportService.selectWarehousePositionAllPage(warehouse.getId(),warehouse.getStoreId(),pageSize,pageNum);
		result.setData(page);
		return result;
	}
	
	
	/**
	 * 库位模板导出
	 * 
	 */
	
	
	/**
	 * 库位批量导入
	 */
	
	
	// 品牌
	/**
	 * 添加精品品牌
	 */
	@ApiOperation(value = "添加精品品牌", notes = "")
	@ApiImplicitParam(name = "BoutiqueBrand", value = "精品品牌", required = true,  dataType = "BoutiqueBrand")
	@ResponseBody
	@RequestMapping(value = "/addBoutiqueBrand", method = { RequestMethod.POST })
	public ApiReturnInfo<String> addBoutiqueBrand(HttpServletRequest request,BoutiqueBrand boutiqueBrand){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		Employee member = getMember(request);
		if(member != null){
			boutiqueBrand.setStoreId(member.getStoreId());
		}
		boutiqueBrand.setTypeLive(1);
		int add = brandSupportService.add(boutiqueBrand);
		if(add <= 0 ){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
		}
		return result;
	}
	
	/**
	 * 删除精品品牌
	 */
	@ApiOperation(value = "删除精品品牌", notes = "")
	@ApiImplicitParam(name = "BoutiqueBrand", value = "精品品牌", required = true,  dataType = "BoutiqueBrand")
	@ResponseBody
	@RequestMapping(value = "/deleteBoutiqueBrand", method = { RequestMethod.POST })
	public ApiReturnInfo<String> deleteBoutiqueBrand(HttpServletRequest request,BoutiqueBrand boutiqueBrand){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		Employee member = getMember(request);
		if(member != null){
			boutiqueBrand.setStoreId(member.getStoreId());
		}
		int delete = brandSupportService.deleteById(boutiqueBrand.getId());
		if(delete <= 0 ){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
		}
		return result;
	}
	
	/**
	 * 修改精品品牌
	 */
	@ApiOperation(value = "保存修改精品品牌", notes = "")
	@ApiImplicitParam(name = "BoutiqueBrand", value = "精品品牌", required = true,  dataType = "BoutiqueBrand")
	@ResponseBody
	@RequestMapping(value = "/updateBoutiqueBrand", method = { RequestMethod.POST })
	public ApiReturnInfo<String> updateBoutiqueBrand(HttpServletRequest request,BoutiqueBrand boutiqueBrand){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		Employee member = getMember(request);
		if(member != null){
			boutiqueBrand.setStoreId(member.getStoreId());
		}
		int update = brandSupportService.update(boutiqueBrand);
		if(update <= 0 ){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
		}
		return result;
	}
	
	/**
	 * 分页查询精品品牌
	 */
	@ApiOperation(value = "分页查询精品品牌", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageNum", value = "页码", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "pageSize", value = "页码大小", required = true,  dataType = "Number")
	})
	@ResponseBody
	@RequestMapping(value = "/selectBrandPage", method = { RequestMethod.POST })
	public ApiReturnInfo<PageInfo<Map<String, Object>>> selectBrandPage(HttpServletRequest request,Integer pageNum,Integer pageSize){
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<PageInfo<Map<String, Object>>>();
		Employee member = getMember(request);
		Integer storeId = 0;
		if(member != null){
			storeId = member.getStoreId();
		}
		PageInfo<Map<String, Object>> selectPage = brandSupportService.selectPage(pageNum, pageSize,storeId);
		result.setData(selectPage);
		return result;
	}

	
	/**
	 * 查询所有精品品牌
	 */
	@ApiOperation(value = "查询所有精品品牌", notes = "")
	@ResponseBody
	@RequestMapping(value = "/selectAllBrand", method = { RequestMethod.POST })
	public ApiReturnInfo<List<BoutiqueBrand>> selectAllBrand(HttpServletRequest request){
		ApiReturnInfo<List<BoutiqueBrand>> result = new ApiReturnInfo<List<BoutiqueBrand>>();
		Employee member = getMember(request);
		Integer storeId = 0;
		if(member != null){
			storeId = member.getStoreId();
		}
		List<BoutiqueBrand> list = brandSupportService.findAll(storeId);
		result.setData(list);
		return result;
	}
	
	//精品分类
	/**
	 * 添加精品分类
	 * @param boutiqueBrand
	 * @return
	 */
	@ApiOperation(value = "添加精品分类", notes = "")
	@ApiImplicitParam(name = "BoutiqueClassify", value = "精品分类", required = true,  dataType = "BoutiqueClassify")
	@ResponseBody
	@RequestMapping(value = "/addBoutiqueClassify", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> addBoutiqueClassify(HttpServletRequest request,BoutiqueClassify boutiqueClassify){
		ApiReturnInfo<JSONObject> result = new ApiReturnInfo<JSONObject>();
		Integer parentId = boutiqueClassify.getParentId();
		int update = -1;
		
		if(parentId != 0 && parentId != null){
			update =classifySupportService.updateParent(parentId);
		}
		if(parentId != 0 && update <= 0 ){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
			return result;
		}
		Employee member = getMember(request);
		boutiqueClassify.setStoreId(member.getStoreId());
		boutiqueClassify.setClassifyUse(0);
		
		JSONObject checkResult = CheckClassifyUtils.check(boutiqueClassify);
		
		Integer status = checkResult.getInteger("status");
		
		if(status == 0){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setData(checkResult);
			result.setMessage("Failed");
		}else{
			int add = classifySupportService.add(boutiqueClassify);
			if(add <= 0 ){
				checkResult.put("status", 0);
				checkResult.put("msg", "添加失败!");
				result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
				result.setData(checkResult);
				result.setMessage("Failed");
			}else{
				checkResult.put("status", 1);
				checkResult.put("msg", "添加成功！");
				result.setData(checkResult);
			}
		}
		return result;
	}
	
	/**
	 * 删除精品分类
	 */
	@ApiOperation(value = "删除精品分类", notes = "")
	@ApiImplicitParam(name = "BoutiqueClassify", value = "删除精品分类", required = true,  dataType = "BoutiqueClassify")
	@ResponseBody
	@RequestMapping(value = "/deleteBoutiqueClassify", method = { RequestMethod.POST })
	public ApiReturnInfo<String> deleteBoutiqueClassify(HttpServletRequest request,BoutiqueClassify boutiqueClassify){
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		BoutiqueClassify  classify= classifySupportService.selectBoutiqueClassifyById(boutiqueClassify.getId());
		
		if(classify.getHaveSon() != null && classify.getHaveSon() == 1){
			List<BoutiqueClassify> sonClassifys = classifySupportService.selectSonClassifyLiveByParentId(classify.getId());
			if(sonClassifys.size() > 0){
				result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
				result.setData("无法删除菜单，该菜单下有子菜单。请先删除子级菜单");
				result.setMessage("Failed");
				return result;
			}
		}
		
		if(classify.getClassifyUse().equals(1)){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setData("无法删除菜单，该精品分类正在被使用。");
			result.setMessage("Failed");
			return result;
		}
		
		Employee member = getMember(request);
		boutiqueClassify.setStoreId(member.getStoreId());
		int delete = classifySupportService.deleteById(classify);
		if(delete <= 0 ){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
		}
		return result;
	}
	
	/**
	 * 修改精品分类
	 */
	@ApiOperation(value = "保存修改精品分类", notes = "")
	@ApiImplicitParam(name = "BoutiqueClassify", value = "修改精品分类", required = true,  dataType = "BoutiqueClassify")
	@ResponseBody
	@RequestMapping(value = "/updateBoutiqueClassify", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> updateBoutiqueClassify(HttpServletRequest request,BoutiqueClassify boutiqueClassify){
		ApiReturnInfo<JSONObject> result = new ApiReturnInfo<JSONObject>();
		JSONObject checkResult = new JSONObject();
		
		if(boutiqueClassify.getClassifyUse().equals(1)){
			checkResult.put("status", 0);
			checkResult.put("msg", "无法修改菜单，该精品分类正在被使用。");
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setData(checkResult);
			result.setMessage("Failed");
			return result;
		}
		Employee member = getMember(request);
		boutiqueClassify.setStoreId(member.getStoreId());
		
		checkResult = CheckClassifyUtils.checkUpdate(boutiqueClassify);
		
		Integer status = checkResult.getInteger("status");
		
		if(status == 0){
			result.setData(checkResult);
			result.setMessage("Failed");
		}else{
			int update = classifySupportService.update(boutiqueClassify);
			if(update <= 0 ){
				checkResult.put("status", 0);
				checkResult.put("msg", "修改失败!");
				result.setData(checkResult);
				result.setMessage("Failed");
			}else{
				checkResult.put("status", 1);
				checkResult.put("msg", "修改成功！");
				result.setData(checkResult);
			}
		}
		return result;
	}	
	
	/**
	 * 查询所有精品分类
	 */
	@ApiOperation(value = "查询所有精品分类", notes = "")
	@ResponseBody
	@RequestMapping(value = "/selectBoutiqueClassifyAll", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> selectBoutiqueClassifyAll(HttpServletRequest request){
		ApiReturnInfo<JSONObject> result = new ApiReturnInfo<JSONObject>();
		JSONObject tree = new JSONObject();
		Employee member = getMember(request);
		
		List<BoutiqueClassify> all = classifySupportService.selectBoutiqueClassifyAll(member.getStoreId());
		Map<Integer, BoutiqueClassify> allMap = new HashMap<>();
		
		Map<Integer, List<BoutiqueClassify>> sons = new HashMap<>();
		for (BoutiqueClassify classify : all) {
			if(classify.getTypeLive().equals(1)){
				Integer parentId = classify.getParentId();
				if(parentId != null ){
					List<BoutiqueClassify> list = sons.get(parentId);
					if(list == null){
						list = new ArrayList<>();
					}
					list.add(classify);
					if(parentId != 0){
						sons.put(parentId, list);
					}
					allMap.put(classify.getId(), classify);
				}
			}
		}
		
		Set<Integer> keySet = sons.keySet();
		for (Integer parentId : keySet) {
			BoutiqueClassify classify = allMap.get(parentId);
			List<BoutiqueClassify> list = sons.get(parentId);
			if(classify != null && list != null){
				classify.setSons(list);
			}
			
		}
		
		Map<Integer, List<BoutiqueClassify>> levelMap = new HashMap<>();
		int level_max = 0;
		for (BoutiqueClassify boutiqueClassify : all) {
			if(boutiqueClassify.getTypeLive().equals(1)){
				Integer level = boutiqueClassify.getLevel();
				if( level >= level_max){
					level_max = level;
				}
				List<BoutiqueClassify> list = levelMap.get(level);
				if(list == null ){
					list = new ArrayList<>();
				}
				list.add(boutiqueClassify);
				levelMap.put(level, list);
			}
		}
		
		tree.put("list", levelMap.get(1));
		result.setData(tree);
		return result;
	}
	
	/**
	 * 分类级别查询
	 */
	@ApiOperation(value = "分类级别查询", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "level", value = "级别", required = true,  dataType = "BoutiqueSupplier"),
		@ApiImplicitParam(name = "parentId", value = "父级id", required = false,  dataType = "BoutiqueSupplier")
	})
	@ResponseBody
	@RequestMapping(value = "/selectBoutiqueClassifyByLevel", method = { RequestMethod.POST })
	public ApiReturnInfo<List<BoutiqueClassify>> selectBoutiqueClassifyByLevel(HttpServletRequest request,Integer level,Integer parentId){
		ApiReturnInfo<List<BoutiqueClassify>> result = new ApiReturnInfo<List<BoutiqueClassify>>();
		List<BoutiqueClassify> list = classifySupportService.selectBoutiqueClassifyByLevel(level,parentId);
		result.setData(list);
		return result;
	}
	
	//精品供应商
	/**
	 * 添加精品供应商
	 * status 为0 则校验通过
	 */
	@ApiOperation(value = "添加精品供应商", notes = "")
	@ApiImplicitParam(name = "BoutiqueSupplier", value = "精品供应商", required = true,  dataType = "BoutiqueSupplier")
	@ResponseBody
	@RequestMapping(value = "/addSupplier", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> addSupplier(HttpServletRequest request,BoutiqueSupplier supplier){
		ApiReturnInfo<JSONObject> result =  new ApiReturnInfo<JSONObject>();
		Employee member = getMember(request);
		if(member != null){
			supplier.setStoreId(member.getStoreId());
		}
		JSONObject check = CheckSupplierUtils.check(supplier);
		
		Integer status = check.getInteger("status");
		if(status != null && status == 0){
			supplier.setTypeLive(1);
			int add = supportService.addSupplier(supplier);
			if(add <= 0 ){
				result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
				result.setMessage("Failed");
			}
		}else{
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
		}
		result.setData(check);
		return result;
	}
	
	/**
	 * 删除供应商
	 * @param request
	 * @param supplier
	 * @return
	 */
	@ApiOperation(value = "删除供应商", notes = "")
	@ApiImplicitParam(name = "id", value = "精品供应商id", required = true,  dataType = "Number")
	@ResponseBody
	@RequestMapping(value = "/deleteSupplier", method = { RequestMethod.POST })
	public ApiReturnInfo<String> deleteSupplier(HttpServletRequest request,Integer id){
		ApiReturnInfo<String> result =  new ApiReturnInfo<String>();
		int delete = supportService.deleteSupplier(id);
		if(delete <= 0 ){
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
		}
		return result;
	}
	
	/**
	 * 修改供应商
	 * 
	 * status 为0 则校验通过
	 * @param request
	 * @param supplier
	 * @return
	 */
	@ApiOperation(value = "修改供应商", notes = "")
	@ApiImplicitParam(name = "id", value = "精品供应商id", required = true,  dataType = "Number")
	@ResponseBody
	@RequestMapping(value = "/updateSupplier", method = { RequestMethod.POST })
	public ApiReturnInfo<JSONObject> updateSupplier(HttpServletRequest request,BoutiqueSupplier  supplier){
		ApiReturnInfo<JSONObject> result =  new ApiReturnInfo<JSONObject>();
		Employee member = getMember(request);
		if(member != null){
			supplier.setStoreId(member.getStoreId());
		}
		JSONObject check = CheckSupplierUtils.check(supplier);
		Integer status = check.getInteger("status");
		
		if(status != null && status == 0){
			int update = supportService.updateSupplier(supplier);
			if(update <= 0 ){
				result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
				result.setMessage("Failed");
			}
		}else{
			result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
			result.setMessage("Failed");
		}
		result.setData(check);
		return result;
	}
	
	/**
	 * 分页条件查询供应商
	 * @param request
	 * @param name
	 * @return
	 */
	@ApiOperation(value = "分页条件查询供应商", notes = "")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "精品供应商名称", required = false,  dataType = "String"),
		@ApiImplicitParam(name = "pageSize", value = "页面大小", required = true,  dataType = "Number"),
		@ApiImplicitParam(name = "pageNum", value = "页码", required = true,  dataType = "Number")
	})
	@ResponseBody
	@RequestMapping(value = "/selectSupplier", method = { RequestMethod.POST })
	public ApiReturnInfo<PageInfo<Map<String, Object>>> selectSupplier(HttpServletRequest request,String  name,Integer pageSize,Integer pageNum){
		ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<PageInfo<Map<String, Object>>>();
		Integer storeId = 0;
		Employee member = getMember(request);
		if(member != null){
			storeId = member.getStoreId();
		}
		PageInfo<Map<String, Object>> list = supportService.selectSupplier(storeId,name,pageSize, pageNum);
		result.setData(list);
		return result;
	}
	
	/**
	 * 查询所有供应商
	 * @param request
	 * @param name
	 * @return
	 */
	@ApiOperation(value = "查询所有供应商", notes = "")
	@ResponseBody
	@RequestMapping(value = "/selectAllSupplier", method = { RequestMethod.POST })
	public ApiReturnInfo<List<BoutiqueSupplier>> selectAllSupplier(HttpServletRequest request){
		ApiReturnInfo<List<BoutiqueSupplier>> result = new ApiReturnInfo<List<BoutiqueSupplier>>();
		Integer storeId = 0;
		Employee member = getMember(request);
		if(member != null){
			storeId = member.getStoreId();
		}
		List<BoutiqueSupplier> list = supportService.selectAllSupplier(storeId);
		result.setData(list);
		return result;
	}
	
	/**
	 * 查询所有单位
	 * @param request
	 * @param name
	 * @return
	 */
	@ApiOperation(value = "查询所有单位", notes = "")
	@ResponseBody
	@RequestMapping(value = "/selectBoutiqueUnitList", method = { RequestMethod.POST })
	public ApiReturnInfo<List<BoutiqueUnit>> selectBoutiqueUnitList(){
		ApiReturnInfo<List<BoutiqueUnit>> result = new ApiReturnInfo<List<BoutiqueUnit>>();
		List<BoutiqueUnit> list = unitSuppourtService.selectBoutiqueUnitList();
		result.setData(list);
		return result;
	}
	
}
