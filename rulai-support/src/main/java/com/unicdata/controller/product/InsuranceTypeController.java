package com.unicdata.controller.product;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.product.InsuranceType;
import com.unicdata.entity.product.InsuranceTypePrice;
import com.unicdata.service.product.InsuranceTypePriceService;
import com.unicdata.service.product.InsuranceTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rulai/insurertType")
@Api(value = "险种维护", tags = {"险种相关接口"})
public class InsuranceTypeController extends HomeBaseController {

    @Autowired
    private InsuranceTypeService insuranceTypeService;

    @Autowired
    private InsuranceTypePriceService insuranceTypePriceService;

    @ApiOperation(value = "保存险种费用", notes = "保存险种费用")
    @RequestMapping(value = "/price/save", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "prices", value = "费率集合", dataType = "prices")
    @ResponseBody
    public ApiReturnInfo list(@RequestBody List<InsuranceTypePrice> prices, HttpServletRequest request) {
        Integer storeId = getMember(request).getStoreId();
        ApiReturnInfo result = new ApiReturnInfo<>();
        if(prices == null || prices.isEmpty()){
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("参数不能为空");
            return result;
        }
        insuranceTypePriceService.savePrices(prices,storeId);
        return result;
    }


    @ApiOperation(value = "获取不同级别险种列表", notes = "获取不同级别险种列表")
    @RequestMapping(value = "/insuranceTypes", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "level", value = "级别 1,2", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<List<InsuranceType>> insuranceTypes(Integer level) {
        ApiReturnInfo<List<InsuranceType>> result = new ApiReturnInfo<>();
        result.setData(insuranceTypeService.getInsuranceTypes(level));
        return result;
    }

    @ApiOperation(value = "险种详情", notes = "险种详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "insuranceId", value = "险种ID", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<Map<String,List>> detail(Integer insuranceId, HttpServletRequest request) {
        ApiReturnInfo<Map<String,List>> result = new ApiReturnInfo<>();
        if(insuranceId == null){
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("险种ID不能为空");
            return result;
        }
        Integer storeId = getMember(request).getStoreId();
        result.setData(insuranceTypePriceService.pricesByInsuranceId(insuranceId,storeId));
        return result;
    }
}
