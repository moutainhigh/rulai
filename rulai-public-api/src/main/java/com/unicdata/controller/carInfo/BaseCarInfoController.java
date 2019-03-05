package com.unicdata.controller.carInfo;

import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.entity.carInfo.UnicdataBrand;
import com.unicdata.entity.carInfo.UnicdataFamily;
import com.unicdata.service.carInfo.BaseCarInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/rulai/public/car")
@Api(value = "所有品牌车系相关接口", tags = {"所有品牌车系相关接口"})
public class BaseCarInfoController {

    @Autowired
    private BaseCarInfoService baseCarInfoService;

    @ApiOperation(value = "获取所有品牌", notes = "获取所有品牌")
    @RequestMapping(value = "/brands", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo<List<UnicdataBrand>> getBrands() {
        ApiReturnInfo<List<UnicdataBrand>> result = new ApiReturnInfo<>();
        result.setData(baseCarInfoService.allBrand());
        return result;
    }

    @ApiOperation(value = "根据品牌获取车系", notes = "根据品牌获取车系")
    @RequestMapping(value = "/families", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "brandId", value = "品牌ID", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<List<UnicdataFamily>> getFamilies(Integer brandId) {
        ApiReturnInfo<List<UnicdataFamily>> result = new ApiReturnInfo<>();
        if (brandId == null) {
            result.setMessage("品牌ID不能为空");
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            return result;
        }
        result.setData(baseCarInfoService.familiesByBrandId(brandId));
        return result;
    }
}
