package com.unicdata.controller.product;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.product.ExtensionInsuranceCompany;
import com.unicdata.service.product.ExtensionService;
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
@RequestMapping("/rulai/extension")
@Api(value = "延保公司维护", tags = {"延保公司相关接口"})
public class ExtensionController extends HomeBaseController {

    @Autowired
    private ExtensionService extensionService;

    @ApiOperation(value = "延保公司列表", notes = "延保公司列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "延保公司名称", dataType = "String"),
            @ApiImplicitParam(name = "enabled", value = "是否有效", dataType = "Boolean"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String,Object>>> list(String name, Boolean enabled, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String,Object>>> result = new ApiReturnInfo<>();
        if (pageNum == null || pageSize == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("分页字段不能为空");
            return result;
        }
        Map<String,Object> params = Maps.newHashMap();
        params.put("name",name);
        params.put("enabled",enabled);
        Integer storeId = getMember(request).getStoreId();
        params.put("storeId",storeId);
        PageInfo<Map<String,Object>> pageInfo = extensionService.getListByParams(params,pageNum, pageSize);
        result.setData(pageInfo);
        return result;
    }

    @ApiOperation(value = "保存延保公司", notes = "保存延保公司")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "extension", value = "延保公司", dataType = "ExtensionInsuranceCompany")
    @ResponseBody
    public ApiReturnInfo list(@RequestBody ExtensionInsuranceCompany extension, HttpServletRequest request) {
        ApiReturnInfo result = new ApiReturnInfo<>();
        if (StringUtils.isBlank(extension.getName())) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("延保公司名称不能为空");
            return result;
        }
        if (StringUtils.isBlank(extension.getContactor())) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("延保公司联系人不能为空");
            return result;
        }
        //操作人
        extension.setOperatorId(getMember(request).getId());
        //新增时放入门店ID
        if(extension.getId() == null){
            extension.setStoreId(getMember(request).getStoreId());
        }
        try {
            extensionService.save(extension);
        } catch (Exception e) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage(e.getMessage());
            return result;
        }
        return result;
    }

    @ApiOperation(value = "延保公司详情", notes = "延保公司详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "extensionId", value = "延保公司Id", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<ExtensionInsuranceCompany> detail(Integer extensionId) {
        ApiReturnInfo<ExtensionInsuranceCompany> result = new ApiReturnInfo<>();
        if (extensionId == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("延保公司ID不能为空");
            return result;
        }
        result.setData(extensionService.getExtensionById(extensionId));
        return result;
    }

    @ApiOperation(value = "获取所有延保公司", notes = "获取所有延保公司")
    @RequestMapping(value = "/all", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo<List<ExtensionInsuranceCompany>> all(HttpServletRequest request) {
        ApiReturnInfo<List<ExtensionInsuranceCompany>> result = new ApiReturnInfo<>();
        Integer storeId = getMember(request).getStoreId();
        result.setData(extensionService.getAll(storeId));
        return result;
    }
}
