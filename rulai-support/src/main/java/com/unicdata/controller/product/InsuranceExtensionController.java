package com.unicdata.controller.product;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.InsuranceEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.entity.product.InsuranceExtension;
import com.unicdata.entity.product.InsuranceExtensionFamily;
import com.unicdata.service.car.CarFamilyService;
import com.unicdata.service.car.CarVehicleConfService;
import com.unicdata.service.product.ExtensionService;
import com.unicdata.service.product.InsuranceExtensionFamilyService;
import com.unicdata.service.product.InsuranceExtensionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/rulai/extension/insurance")
@Api(value = "延保套餐维护", tags = {"延保套餐相关接口"})
public class InsuranceExtensionController extends HomeBaseController {

    @Autowired
    private InsuranceExtensionService insuranceExtensionService;

    @Autowired
    private CarFamilyService carFamilyService;

    @Autowired
    private ExtensionService extensionService;

    @Autowired
    private InsuranceExtensionFamilyService insuranceExtensionFamilyService;

    @ApiOperation(value = "延保套餐列表", notes = "延保套餐列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "延保套餐名称", dataType = "String"),
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
        PageInfo<Map<String, Object>> pageInfo = insuranceExtensionService.getListByParams(params, pageNum, pageSize);
        List<Map<String, Object>> data = pageInfo.getList();
        for (Map<String, Object> map : data) {
            map.put("typeDesc", map.get("type") != null ? InsuranceEnum.ExtensionType.getByCode((Integer) map.get("type")).getDesc() : "");
        }
        result.setData(pageInfo);
        return result;
    }

    @ApiOperation(value = "保存延套餐", notes = "保存延套餐")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "insuranceExtension", value = "延保公司", dataType = "InsuranceExtension")
    @ResponseBody
    public ApiReturnInfo list(@RequestBody InsuranceExtension insuranceExtension, HttpServletRequest request) {
        ApiReturnInfo result = new ApiReturnInfo<>();
        if (StringUtils.isBlank(insuranceExtension.getName())) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("延保套餐名称不能为空");
            return result;
        }
        if (insuranceExtension.getPrice() == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("延保套餐金额不能为空");
            return result;
        }
        if (insuranceExtension.getInsuranceExtensionFamilies().isEmpty()) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("请选择延保套餐关联车系");
            return result;
        }
        if (insuranceExtension.getType() == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("请选择延保套餐类型");
            return result;
        }
        if (Objects.equals(insuranceExtension.getType(), InsuranceEnum.ExtensionType.STORE_EXT.getCode()) && insuranceExtension.getCost() == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("请填写延保成本");
            return result;
        }
        if (insuranceExtension.getExtensionId() == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("请选择延保套餐所属公司");
            return result;
        }
        if (insuranceExtension.getItemsList() != null && !insuranceExtension.getItemsList().isEmpty()) {
            List<String> strs = Lists.newArrayList();
            for (Map<String, Object> map : insuranceExtension.getItemsList()) {
                if (map.get("name") != null && StringUtils.isNotBlank(map.get("name").toString())) {
                    strs.add(map.get("name").toString());
                }
            }
            insuranceExtension.setItems(StringUtils.join(strs, ","));
        }
        //操作人
        insuranceExtension.setOperatorId(getMember(request).getId());
        //新增时放入门店ID
        if (insuranceExtension.getId() == null) {
            insuranceExtension.setStoreId(getMember(request).getStoreId());
        }
        insuranceExtensionService.save(insuranceExtension);
        return result;
    }

    @ApiOperation(value = "延保套餐详情", notes = "延保套餐详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "insuranceExtensionId", value = "延保套餐Id", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<Map<String, Object>> detail(Integer insuranceExtensionId, HttpServletRequest request) {
        ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
        if (insuranceExtensionId == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("延保套餐ID不能为空");
            return result;
        }
        InsuranceExtension insuranceExtension = insuranceExtensionService.getInsuranceExtensionById(insuranceExtensionId);
        if (insuranceExtension == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("延保套餐不存在");
            return result;
        }
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", insuranceExtension.getId());
        map.put("name", insuranceExtension.getName());
        map.put("enabled", insuranceExtension.getEnabled());
        map.put("price", insuranceExtension.getPrice());
        List<InsuranceExtensionFamily> families = insuranceExtensionFamilyService.getListByExtensionInsuranceId(insuranceExtensionId);
        //关联车系
        map.put("insuranceExtensionFamilies", families);
        List<String> familyNames = Lists.newArrayList();
        for (InsuranceExtensionFamily entity : families) {
            CarFamily carFamily = carFamilyService.selectByPrimaryKey(entity.getFamilyId());
            if(carFamily != null){
                familyNames.add(carFamily.getName());
            }
        }
        map.put("familyNames" ,familyNames);
        map.put("extensionId", insuranceExtension.getExtensionId());
        map.put("extensionName", extensionService.getExtensionById(insuranceExtension.getExtensionId()) == null ? "" : extensionService.getExtensionById(insuranceExtension.getExtensionId()).getName());
        map.put("rebate",insuranceExtension.getRebate());
        List<Map<String, Object>> items = Lists.newArrayList();
        if (StringUtils.isNotBlank(insuranceExtension.getItems())) {
            String[] strs = insuranceExtension.getItems().split(",");
            for (String str : strs) {
                Map<String, Object> strMap = Maps.newHashMap();
                strMap.put("name", str);
                items.add(strMap);
            }
        }
        map.put("itemsList", items);
        map.put("cost", insuranceExtension.getCost());
        map.put("remark", insuranceExtension.getRemark());
        map.put("type", insuranceExtension.getType());
        map.put("typeDesc", insuranceExtension.getType() != null ? InsuranceEnum.ExtensionType.getByCode(insuranceExtension.getType()).getDesc() : "");
        result.setData(map);
        return result;
    }

    @ApiOperation(value = "车系关联下拉框", notes = "车系关联下拉框")
    @RequestMapping(value = "/vehicle", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo<List<Map<String, Object>>> detail(HttpServletRequest request) {
        ApiReturnInfo<List<Map<String, Object>>> result = new ApiReturnInfo<>();
        Integer storeId = getMember(request) == null ? null : getMember(request).getStoreId();
        if (storeId == null) {
            result.setData(Lists.newArrayList());
            return result;
        }
        List<Map<String, Object>> list = insuranceExtensionService.getCarFamilyByStoreId(storeId);
        result.setData(list);
        return result;
    }
}
