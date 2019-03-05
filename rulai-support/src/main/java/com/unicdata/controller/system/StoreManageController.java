package com.unicdata.controller.system;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.DictionaryTypeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.CommonCode;
import com.unicdata.constant.StoreCode;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.DistributorStoreInfo;
import com.unicdata.service.system.DistributorStoreInfoService;
import com.unicdata.util.NumberUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rulai/store")
@Api(value = "门店管理", tags = { "门店管理相关接口" }) // swagger控制器说明注解
public class StoreManageController extends HomeBaseController {

	@Autowired
	private DistributorStoreInfoService distributorStoreInfoService;

	@Value(value = "${upload.access.path}")
	private String uploadAccessPath;
	// 图片格式
	@Value(value = "${upload.picture.type}")
	private String uploadPictureType;
	// 文件上传路径
	@Value(value = "${upload.file.path}")
	private String uploadFilePath;

	/**
	 * 获取门店列表
	 */
	@ApiOperation(value = "获取门店列表", notes = "获取门店列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "显示数目", required = true, paramType = "form", dataType = "Integer"),
			@ApiImplicitParam(name = "pageNum", value = "页码", required = true, paramType = "form", dataType = "Integer") })
	@ResponseBody
	@RequestMapping(value = "/list", method = { RequestMethod.POST })
	public ApiReturnInfo<PageInfo<DistributorStoreInfo>> list(Integer pageSize, Integer pageNum,HttpServletRequest request) {
		ApiReturnInfo<PageInfo<DistributorStoreInfo>> result = new ApiReturnInfo<PageInfo<DistributorStoreInfo>>();
		result.setData(distributorStoreInfoService.selectPageByDistributor(getMember(request).getGroupId(), pageSize,pageNum));
		return result;
	}

	/**
	 * 上/下架
	 */
	@ApiOperation(value = "上/下架", notes = "上/下架")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "storeId", value = "门店id", required = true, paramType = "form", dataType = "Integer"),
			@ApiImplicitParam(name = "storeStatus", value = "门店状态", required = true, paramType = "form", dataType = "Integer") })
	@ResponseBody
	@RequestMapping(value = "/changeStatus", method = { RequestMethod.POST })
	public ApiReturnInfo<String> changeStatus(Integer storeId, Integer storeStatus, HttpServletRequest request) {
		DistributorStoreInfo distributorStoreInfo = new DistributorStoreInfo();
		distributorStoreInfo.setId(storeId);
		distributorStoreInfo.setStoreStatus(storeStatus.byteValue());
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		distributorStoreInfoService.updateByPrimaryKeySelective(distributorStoreInfo);
		return result;
	}

	/**
	 * 获取门店信息
	 */
	@ApiOperation(value = "获取门店信息", notes = "获取门店信息")
	@ApiImplicitParam(name = "storeId", value = "门店id", required = true, paramType = "form", dataType = "Integer")
	@ResponseBody
	@RequestMapping(value = "/info", method = { RequestMethod.POST })
	public ApiReturnInfo<Map<String, Object>> info(Integer storeId, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("storeInfo", distributorStoreInfoService.getById(storeId));
		map.put("picUrl", uploadAccessPath);
		ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<Map<String, Object>>();
		result.setData(map);
		return result;
	}

	/**
	 * 获取品牌列表
	 */
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "获取品牌列表", notes = "获取品牌列表")
	@ResponseBody
	@RequestMapping(value = "/brandList", method = { RequestMethod.POST })
	public ApiReturnInfo<List<Map>> brandList(HttpSession session, HttpServletRequest request) {
		ApiReturnInfo<List<Map>> result = new ApiReturnInfo<List<Map>>();
//		result.setData(VehicleInfoUtil.getBrandInfo());
		return result;
	}
	
	/**
	 * 验证门店编码（查重）
	 */
	@ApiOperation(value = "验证门店编码（查重）", notes = "验证门店编码（查重）")
	@ApiImplicitParam(name = "code", value = "code", required = true, paramType = "form", dataType = "String")
	@ResponseBody
	@RequestMapping(value = "/codeValid", method = { RequestMethod.POST })
	public ApiReturnInfo<String> codeValid(DistributorStoreInfo distributorStoreInfo, Integer storeId, HttpSession session, HttpServletRequest request) {
		distributorStoreInfo.setDistributorId(getMember(request).getGroupId());
		distributorStoreInfo = distributorStoreInfoService.getByDistributorAndCode(distributorStoreInfo);
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		boolean flag = true;
		if(null != distributorStoreInfo){
			if(null != distributorStoreInfo.getId() && distributorStoreInfo.getId() > 0){
				if(distributorStoreInfo.getId() == storeId){
					flag = false;
				}
			}
			if(flag) {
				result.setCode(StoreCode.CODE_REPEAT);
				result.setMessage(StoreCode.map.get(StoreCode.CODE_REPEAT));
			}
		}
		return result;
	}

	/**
	 * 保存门店信息
	 */
	@ApiOperation(value = "保存门店信息", notes = "保存门店信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "distributorStoreInfo", value = "门店实体(修改要传id)", required = true, dataType = "DistributorStoreInfo"),
			@ApiImplicitParam(name = "brandId", value = "品牌id(多个id以逗号分隔)", required = false, paramType = "form", dataType = "Integer") })
	@ResponseBody
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public ApiReturnInfo<String> save(@RequestBody DistributorStoreInfo storeDTO, HttpServletRequest request) {
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		if (StringUtil.isBlank(storeDTO.getName())) {
			result.setCode(CommonCode.PARAM_NULL);
			result.setMessage("请输入门店名称");
			return result;
		}
		if (StringUtil.isBlank(storeDTO.getAbbreviation())) {
			result.setCode(CommonCode.PARAM_NULL);
			result.setMessage("请输入门店简称");
			return result;
		}
		if (StringUtil.isBlank(storeDTO.getCode())) {
			result.setCode(CommonCode.PARAM_NULL);
			result.setMessage("请输入门店编码");
			return result;
		}
		if (storeDTO.getProvinceId() == null  || storeDTO.getCityId() == null || StringUtil.isBlank(storeDTO.getStreet())) {
			result.setCode(CommonCode.PARAM_NULL);
			result.setMessage("请输入门店详细地址");
			return result;
		}
		if (StringUtil.isBlank(storeDTO.getLongitude()) || StringUtil.isBlank(storeDTO.getLatitude())) {
			result.setCode(CommonCode.PARAM_NULL);
			result.setMessage("请输入门店经纬度");
			return result;
		}
		if (StringUtil.isBlank(storeDTO.getLandline())) {
			result.setCode(CommonCode.PARAM_NULL);
			result.setMessage("请输入门店电话");
			return result;
		} else {
			// 验证手机号格式
			boolean flag = NumberUtil.isMobileNO(storeDTO.getLandline());
			// 验证座机格式
			flag = flag || NumberUtil.isPhone(storeDTO.getLandline());
			if (!flag) {
				result.setCode(CommonCode.RESULT_CODE_EXCEPTION);
				result.setMessage("门店电话验证不通过");
				return result;
			}
		}

		DistributorStoreInfo distributorStoreInfo = storeDTO;
		distributorStoreInfo.setDistributorId(getMember(request).getGroupId());
		if (null != distributorStoreInfo.getId() && distributorStoreInfo.getId() > 0) {
			// 修改
			distributorStoreInfoService.updateByPrimaryKeySelective(distributorStoreInfo);
		} else {
			// 新增
			int num = distributorStoreInfoService.insertSelective(distributorStoreInfo);
			if (num <= 0) {
				result.setCode(CommonCode.RESULT_CODE_EXCEPTION);
				result.setMessage(CommonCode.map.get(CommonCode.RESULT_CODE_EXCEPTION));
				return result;
			}
		}
		return result;
	}

	/**
	 * 获取门店保养套餐列表
	 */
	@ApiOperation(value = "获取门店保养套餐列表", notes = "获取门店保养套餐列表")
	@ResponseBody
	@ApiImplicitParam(name = "storeId", value = "门店id", required = true, paramType = "form", dataType = "Integer")
	@RequestMapping(value = "/mealList", method = { RequestMethod.POST })
	public ApiReturnInfo<List<Map<String, Object>>> mealList(Integer storeId, HttpServletRequest request) {
		ApiReturnInfo<List<Map<String, Object>>> result = new ApiReturnInfo<List<Map<String, Object>>>();
//		result.setData(distributorStoreMealService.selectListByStore(storeId));
		return result;
	}

	/**
	 * 保存门店保养套餐
	 */
	/*@ApiOperation(value = "保存门店保养套餐", notes = "保存门店保养套餐")
	@ResponseBody
	@ApiImplicitParam(name = "mealListDTO", value = "套餐实体", required = true, paramType = "form", dataType = "MealListDTO")
	@RequestMapping(value = "/saveMeals", method = { RequestMethod.POST })
	public ApiReturnInfo<String> saveMeals(@RequestBody MealListDTO mealListDTO, HttpServletRequest request) {
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		List<MealDTO> meals = mealListDTO.getMealList();
		MealDTO mealDTO = null;
		for (int i = 0; i < meals.size(); i++) {
			mealDTO = meals.get(i);
			DistributorStoreMeal distributorStoreMeal = new DistributorStoreMeal();
			distributorStoreMeal.setDistributorStoreId(mealDTO.getDistributorStoreId());
			distributorStoreMeal.setName(mealDTO.getName());
			distributorStoreMeal.setIntroduce(mealDTO.getIntroduce());
			distributorStoreMeal.setPrice(mealDTO.getPrice());
			distributorStoreMeal.setStartDate(mealDTO.getStartDate());
			distributorStoreMeal.setEndDate(mealDTO.getEndDate());
			if (null != mealDTO.getMealId() && mealDTO.getMealId() > 0) {
				distributorStoreMeal.setId(mealDTO.getMealId());
				distributorStoreMealService.updateByPrimaryKeySelective(distributorStoreMeal);
			} else {
				distributorStoreMealService.insertSelective(distributorStoreMeal);
			}
			if (null != distributorStoreMeal.getId() && distributorStoreMeal.getId() > 0) {
				DistributorStoreMealSeries distributorStoreMealSeries = new DistributorStoreMealSeries();
				distributorStoreMealSeries.setDistributorStoreMeal(distributorStoreMeal.getId());
				distributorStoreMealSeries.setBrandId(mealDTO.getBrandId());
				distributorStoreMealSeries.setSeriesId(mealDTO.getSeriesId());
				distributorStoreMealSeries.setFactoryId(mealDTO.getFactoryId());
				if (null != mealDTO.getSupportId() && mealDTO.getSupportId() > 0) {
					distributorStoreMealSeries.setId(mealDTO.getSupportId());
					distributorStoreMealSeriesService.updateByPrimaryKeySelective(distributorStoreMealSeries);
				} else {
					distributorStoreMealSeriesService.insertSelective(distributorStoreMealSeries);
				}
			}
		}
		return result;
	}
*/
	/**
	 * 删除门店保养套餐
	 */
	/*@ApiOperation(value = "删除门店保养套餐", notes = "删除门店保养套餐")
	@ResponseBody
	@ApiImplicitParams({
			@ApiImplicitParam(name = "mealId", value = "套餐id", required = true, paramType = "form", dataType = "Integer"),
			@ApiImplicitParam(name = "supportId", value = "套餐支持车系id", required = true, paramType = "form", dataType = "Integer"), })
	@RequestMapping(value = "/delMeal", method = { RequestMethod.POST })
	public ApiReturnInfo<String> delMeal(Integer mealId, Integer supportId, HttpServletRequest request) {
		ApiReturnInfo<String> result = new ApiReturnInfo<String>();
		DistributorStoreMeal distributorStoreMeal = new DistributorStoreMeal();
		distributorStoreMeal.setId(mealId);
		distributorStoreMeal.setDataStatus(DictionaryTypeEnum.DateStatus.DELETED.getCode());
		distributorStoreMealService.updateByPrimaryKeySelective(distributorStoreMeal);
		DistributorStoreMealSeries distributorStoreMealSeries = new DistributorStoreMealSeries();
		distributorStoreMealSeries.setId(supportId);
		distributorStoreMealSeries.setDataStatus(DictionaryTypeEnum.DateStatus.DELETED.getCode());
		distributorStoreMealSeriesService.updateByPrimaryKeySelective(distributorStoreMealSeries);
		return result;
	}*/
}
