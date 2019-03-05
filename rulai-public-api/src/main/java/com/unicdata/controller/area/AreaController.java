package com.unicdata.controller.area;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.entity.basedata.City;
import com.unicdata.entity.basedata.District;
import com.unicdata.entity.basedata.Province;
import com.unicdata.service.area.AreaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/rulai/public/area")
@Api(value = "省市区", tags = {"省市区相关接口"})
public class AreaController {

    @Autowired
    private AreaService areaService;

    @ApiOperation(value = "获取所有省份", notes = "获取所有省份")
    @RequestMapping(value = "/provinces", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo<List<Province>> getProvinces() {
        ApiReturnInfo<List<Province>> result = new ApiReturnInfo<>();
        result.setData(areaService.provinces());
        return result;
    }

    @ApiOperation(value = "根据省份ID获取所有市", notes = "根据省份ID获取所有市")
    @RequestMapping(value = "/cities", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "provinceId", value = "省份ID", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<List<City>> getCities(Integer provinceId) {
        ApiReturnInfo<List<City>> result = new ApiReturnInfo<>();
        if(provinceId == null){
            result.setMessage("省份ID不能为空");
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            return result;
        }
        result.setData(areaService.CitiesByProvinceId(provinceId));
        return result;
    }

    @ApiOperation(value = "根据市ID获取所有区", notes = "根据市ID获取所有区")
    @RequestMapping(value = "/districts", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "cityId", value = "市ID", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<List<District>> getDistricts(Integer cityId) {
        ApiReturnInfo<List<District>> result = new ApiReturnInfo<>();
        if(cityId == null){
            result.setMessage("市ID不能为空");
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            return result;
        }
        result.setData(areaService.DistrictsByCityId(cityId));
        return result;
    }
    
    @ApiOperation(value = "根据市名称获取id", notes = "根据名称转换id")
    @RequestMapping(value = "/getIdByName", method = {RequestMethod.POST})
    @ApiImplicitParams({
		@ApiImplicitParam(name = "provinceName", value = "省", dataType = "String"),
		@ApiImplicitParam(name = "cityName", value = "市", dataType = "String"),
		@ApiImplicitParam(name = "districtName", value = "区", dataType = "String")})
    @ResponseBody
    public ApiReturnInfo getIdByName(String provinceName,String cityName,String districtName) {
        ApiReturnInfo result = new ApiReturnInfo();
        Integer provinceId = null;
        Integer cityId = null;
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtil.isNotBlank(provinceName)){
        	provinceId = areaService.getIdByName(provinceName, 1, null);
        	map.put("provinceId", provinceId);
        }
        if(StringUtil.isNotBlank(cityName)){
        	cityId = areaService.getIdByName(cityName, 2, provinceId);
        	map.put("cityId", cityId);
        }
        if(StringUtil.isNotBlank(districtName)){
        	map.put("districtId", areaService.getIdByName(districtName, 3, cityId));
        }
        result.setData(map);
        return result;
    }
}
