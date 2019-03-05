package com.unicdata.controller.product;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.product.FinanceCompany;
import com.unicdata.entity.product.FinanceLoanRange;
import com.unicdata.entity.product.FinanceLoanYear;
import com.unicdata.service.product.FinanceCompanyService;
import com.unicdata.service.product.FinanceLoanRangeService;
import com.unicdata.service.product.FinanceLoanYearService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/rulai/finance/company")
@Api(value = "金融公司维护", tags = {"金融公司相关接口"})
public class FinanceCompanyController extends HomeBaseController {

    @Autowired
    private FinanceCompanyService financeCompanyService;

    @Autowired
    private FinanceLoanYearService financeLoanYearService;

    @Autowired
    private FinanceLoanRangeService financeLoanRangeService;


    @ApiOperation(value = "金融公司列表", notes = "金融公司列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "险种名称", dataType = "String"),
            @ApiImplicitParam(name = "enabled", value = "是否有效", dataType = "Boolean"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> list(String name, Boolean enabled, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        if (pageNum == null || pageSize == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("分页字段不能为空");
            return result;
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("name", name);
        params.put("enabled", enabled);
        Integer storeId = getMember(request).getStoreId();
        params.put("storeId", storeId);
        PageInfo<Map<String, Object>> pageInfo = financeCompanyService.getListByParams(params, pageNum, pageSize);
        result.setData(pageInfo);
        return result;
    }

    @ApiOperation(value = "保存金融公司", notes = "保存金融公司")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "financeCompany", value = "金融公司", dataType = "FinanceCompany")
    @ResponseBody
    public ApiReturnInfo list(@RequestBody FinanceCompany financeCompany, HttpServletRequest request) {
        ApiReturnInfo result = new ApiReturnInfo<>();
        if (StringUtils.isBlank(financeCompany.getName())) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("金融公司名称不能为空");
            return result;
        }
        financeCompany.setOperatorId(getMember(request).getId());
        //新增时放入门店ID
        if (financeCompany.getId() == null) {
            financeCompany.setStoreId(getMember(request).getStoreId());
        }
        try {
            financeCompanyService.save(financeCompany);
        } catch (Exception e) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage(e.getMessage());
            return result;
        }
        return result;
    }

    @ApiOperation(value = "获取店铺下金融公司列表", notes = "获取店铺下金融公司列表")
    @RequestMapping(value = "/all", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo<List<FinanceCompany>> getListByStoreId(HttpServletRequest request) {
        ApiReturnInfo<List<FinanceCompany>> result = new ApiReturnInfo<>();
        Integer storeId = getMember(request) == null ? null : getMember(request).getStoreId();
        result.setData(financeCompanyService.getListByStoreId(storeId));
        return result;
    }

    @ApiOperation(value = "获取店铺下贷款年限列表", notes = "获取店铺下贷款年限列表")
    @RequestMapping(value = "/years/list", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo<List<FinanceLoanYear>> getYearList(HttpServletRequest request) {
        ApiReturnInfo<List<FinanceLoanYear>> result = new ApiReturnInfo<>();
        Integer storeId = getMember(request) == null ? null : getMember(request).getStoreId();
        result.setData(financeLoanYearService.getListByStoreId(storeId));
        return result;
    }

    @ApiOperation(value = "保存店铺下设置的年限", notes = "保存店铺下设置的年限")
    @RequestMapping(value = "/years/save", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "years", value = "年限列表", dataType = "FinanceLoanYear")
    @ResponseBody
    public ApiReturnInfo<List<FinanceLoanYear>> yearSave(@RequestBody List<FinanceLoanYear> years, HttpServletRequest request) {
        ApiReturnInfo<List<FinanceLoanYear>> result = new ApiReturnInfo<>();
        if (years == null || years.isEmpty()) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("年限设置不能为空");
            return result;
        }
        //去重
        Set<Integer> yearSet = Sets.newHashSet();
        for (FinanceLoanYear year : years) {
            yearSet.add(year.getYear());
        }
        if (years.size() > yearSet.size()) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("年限设置不能重复");
            return result;
        }
        Integer storeId = getMember(request) == null ? null : getMember(request).getStoreId();
        financeLoanYearService.saveYears(years, storeId);
        return result;
    }

    @ApiOperation(value = "根据金融公司ID获取贷款金额范围列表", notes = "根据保险公司ID获取贷款金额范围列表")
    @RequestMapping(value = "/ranges/list", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "financeId", value = "金融公司ID", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<List<FinanceLoanRange>> getRangeList(Integer financeId) {
        ApiReturnInfo<List<FinanceLoanRange>> result = new ApiReturnInfo<>();
        if (financeId == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("金融公司ID不能为空");
            return result;
        }
        result.setData(financeLoanRangeService.getListByFinanceId(financeId));
        return result;
    }

    @ApiOperation(value = "保存贷款利率设置", notes = "保存贷款利率设置")
    @RequestMapping(value = "/ranges/save", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "ranges", value = "利率列表", dataType = "FinanceCompany")
    @ResponseBody
    public ApiReturnInfo rangeSave(@RequestBody List<FinanceLoanRange> ranges) {
        ApiReturnInfo result = new ApiReturnInfo<>();
        if (ranges == null || ranges.isEmpty()) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("贷款金额范围不能为空");
            return result;
        }
        financeLoanRangeService.saveRanges(ranges);
        return result;
    }
}
