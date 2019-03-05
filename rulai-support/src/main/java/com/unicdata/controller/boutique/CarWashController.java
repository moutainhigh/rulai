package com.unicdata.controller.boutique;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.CarEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.boutique.CarWash;
import com.unicdata.service.boutique.CarWashService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rulai/boutique/carwash")
@Api(value = "洗车服务", tags = {"洗车服务相关接口"})
public class CarWashController extends HomeBaseController {

    @Autowired
    private CarWashService carWashService;

    @ApiOperation(value = "洗车列表", notes = "洗车列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "客户姓名", dataType = "String"),
            @ApiImplicitParam(name = "beginTime", value = "申请开始时间", dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "申请结束时间", dataType = "String"),
            @ApiImplicitParam(name = "state", value = "洗车状态", dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> list(String name, String beginTime, String endTime,
                                                             Integer state, Integer pageNum,
                                                             Integer pageSize, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        if (pageNum == null || pageSize == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("分页字段不能为空");
            return result;
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("state", state);
        params.put("name", name);
        params.put("beginTime", StringUtils.isNotBlank(beginTime) ? beginTime + " 00:00:00" : null);
        params.put("endTime", StringUtils.isNotBlank(endTime) ? endTime + " 23:59:59" : null);
        params.put("storeId", getMember(request).getStoreId());
        PageInfo<Map<String, Object>> pageInfo = carWashService.getListByParams(params, pageNum, pageSize);
        List<Map<String, Object>> carWashs = pageInfo.getList();
        for (Map<String, Object> map : carWashs) {
            map.put("stateDesc", map.get("state") != null ? CarEnum.CarWashStates.getByCode(Integer.valueOf(map.get("state").toString())).getDesc() : null);
        }
        result.setData(pageInfo);
        return result;
    }

    @ApiOperation(value = "洗车服务状态转换", notes = "洗车服务状态转换")
    @RequestMapping(value = "/change", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", dataType = "Integer"),
            @ApiImplicitParam(name = "state", value = "洗车状态（0：洗车中，1：未洗车，2：已完成）,开始按钮传0，完成按钮传2", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo detail(Integer state, Integer id, HttpServletRequest request) {
        ApiReturnInfo result = new ApiReturnInfo<>();
        if (id == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("id不能为空");
            return result;
        }
        if (state == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("洗车状态不能为空");
            return result;
        }
        CarWash carWash = carWashService.getCarWashById(id);
        if (carWash == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("洗车记录为空");
            return result;
        }
        carWash.setOperatorId(getMember(request).getId());
        carWash.setState(state);
        carWashService.stateChange(carWash);
        return result;
    }

    @ApiOperation(value = "优先洗车", notes = "优先洗车")
    @RequestMapping(value = "/prior", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "id", value = "ID", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo difference(Integer id) {
        ApiReturnInfo result = new ApiReturnInfo<>();
        if (id == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("ID不能为空");
            return result;
        }
        CarWash carWash = carWashService.getCarWashById(id);
        if (carWash == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("洗车记录为空");
            return result;
        }
        carWashService.prior(carWash);
        return result;
    }
}
