package com.unicdata.controller.product;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.product.InsuranceType;
import com.unicdata.entity.product.Insurer;
import com.unicdata.service.product.InsurerService;
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
@RequestMapping("/rulai/insurer")
@Api(value = "保险公司维护", tags = {"保险公司相关接口"})
public class InsurerController extends HomeBaseController {

    @Autowired
    private InsurerService insurerService;

    @ApiOperation(value = "保险公司列表", notes = "保险公司列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "保险公司名称", dataType = "String"),
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
        PageInfo<Map<String, Object>> pageInfo = insurerService.getListByParams(params, pageNum, pageSize);
        List<Map<String, Object>> carWashs = pageInfo.getList();
        for (Map<String, Object> map : carWashs) {
            map.put("enabled", map.get("enabled") != null ? ((boolean) map.get("enabled") == true ? 1 : 0) : null);
        }
        result.setData(pageInfo);
        return result;
    }

    @ApiOperation(value = "保存保险公司", notes = "保存保险公司")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "insurer", value = "保险公司", dataType = "Insurer")
    @ResponseBody
    public ApiReturnInfo list(@RequestBody Insurer insurer, HttpServletRequest request) {
        ApiReturnInfo result = new ApiReturnInfo<>();
        if (StringUtils.isBlank(insurer.getName())) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("保险公司名称不能为空");
            return result;
        }
        if (StringUtils.isBlank(insurer.getContactor())) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("保险公司联系人不能为空");
            return result;
        }
        if(insurer.getTaxRemovalRatio() == null || insurer.getRebateRatio() == null || insurer.getCost() == null){
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("三年联保去税系数/返点系数/成本不能为空");
            return result;
        }
        //操作人
        insurer.setOperatorId(getMember(request).getId());
        //新增时放入门店ID
        if (insurer.getId() == null) {
            insurer.setStoreId(getMember(request).getStoreId());
        }
        try {
            insurerService.save(insurer);
        } catch (Exception e) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage(e.getMessage());
            return result;
        }
        return result;
    }


    @ApiOperation(value = "保险公司详情", notes = "保险公司详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "insurerId", value = "保险公司Id", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<Insurer> detail(Integer insurerId) {
        ApiReturnInfo<Insurer> result = new ApiReturnInfo<>();
        if (insurerId == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("保险公司ID不能为空");
            return result;
        }
        result.setData(insurerService.getInsurerById(insurerId));
        return result;
    }
}
