package com.unicdata.controller.product;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.product.SetMeal;
import com.unicdata.service.product.SetMealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rulai/setmeal")
@Api(value = "套餐代金券维护", tags = {"套餐代金券相关接口"})
public class SetMealController extends HomeBaseController {

    // 文件访问路径
    @Value("${upload.access.path}")
    private String uploadAccessPath;

    @Autowired
    private SetMealService setMealService;

    @ApiOperation(value = "套餐代金券列表", notes = "套餐代金券列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "套餐/代金券名称", dataType = "String"),
            @ApiImplicitParam(name = "enabled", value = "是否有效", dataType = "Boolean"),
            @ApiImplicitParam(name = "type", value = "类型", dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> list(String name, Boolean enabled, Integer pageNum, Integer type, Integer pageSize, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        if (pageNum == null || pageSize == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("分页字段不能为空");
            return result;
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("type", type);
        params.put("name", name);
        params.put("enabled", enabled);
        Integer storeId = getMember(request).getStoreId();
        params.put("storeId", storeId);
        PageInfo<Map<String, Object>> pageInfo = setMealService.getListByParams(params, pageNum, pageSize);
        List<Map<String, Object>> data = pageInfo.getList();
        for (Map<String, Object> map : data) {
            map.put("imgUrl", (map.get("imgUrl") != null && StringUtils.isNotBlank(map.get("imgUrl").toString())) ? (uploadAccessPath + map.get("imgUrl").toString()) : "");
        }
        result.setData(pageInfo);
        return result;
    }


    @ApiOperation(value = "保存套餐代金券", notes = "保存套餐代金券")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "setMeal", value = "套餐/代金券", dataType = "SetMeal")
    @ResponseBody
    public ApiReturnInfo list(@RequestBody SetMeal setMeal, HttpServletRequest request) {
        ApiReturnInfo result = new ApiReturnInfo<>();
        if (StringUtils.isBlank(setMeal.getName())) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("名称不能为空");
            return result;
        }
        if (setMeal.getMoney() == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("金额不能为空");
            return result;
        }
        if(setMeal.getCost() == null){
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("成本不能为空");
            return result;
        }
        setMeal.setOperatorId(getMember(request).getId());
        //新增时放入门店ID
        if (setMeal.getId() == null) {
            setMeal.setStoreId(getMember(request).getStoreId());
        }
        try {
            setMealService.save(setMeal);
        } catch (Exception e) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage(e.getMessage());
            return result;
        }
        return result;
    }

    @ApiOperation(value = "套餐代金券详情", notes = "套餐代金券详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "setMealId", value = "套餐代金券Id", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<SetMeal> ditail(Integer setMealId) {
        ApiReturnInfo<SetMeal> result = new ApiReturnInfo<>();
        if (setMealId == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("套餐代金券Id不能为空");
            return result;
        }
        SetMeal meal = setMealService.getSetMealById(setMealId);
        if (meal != null && StringUtils.isNotBlank(meal.getImgUrl())) {
            meal.setImgUrl(uploadAccessPath + meal.getImgUrl());
        }
        result.setData(meal);
        return result;
    }
}
