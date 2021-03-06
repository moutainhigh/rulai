package com.unicdata.controller.salemanager;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.CarEnum;
import com.unicdata.constant.SettleEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.order.OrderInsuranceItem;
import com.unicdata.service.order.OrderInsuranceItemService;
import com.unicdata.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/rulai/order/insurance/item")
@Api(value = "保险单管理", tags = {"保险单管理相关接口"})
public class OrderInsuranceItemController extends HomeBaseController {

    // 文件访问路径
    @Value("${upload.access.path}")
    private String uploadAccessPath;

    @Autowired
    private OrderInsuranceItemService orderInsuranceItemService;

    @ApiOperation(value = "金融管理列表", notes = "金融管理列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "insuranceNum", value = "保险单号", dataType = "String"),
            @ApiImplicitParam(name = "insuranceState", value = "保险单状态", dataType = "Integer"),
            @ApiImplicitParam(name = "cusName", value = "客户/公司名称", dataType = "String"),
            @ApiImplicitParam(name = "cusPhone", value = "客户手机号", dataType = "String"),
            @ApiImplicitParam(name = "vin", value = "vin码", dataType = "String"),
            @ApiImplicitParam(name = "insuranceType", value = "险种类型", dataType = "Integer"),
            @ApiImplicitParam(name = "orderNum", value = "销售单号", dataType = "String"),
            @ApiImplicitParam(name = "orderState", value = "销售单状态", dataType = "Integer"),
            @ApiImplicitParam(name = "beginTime", value = "保险到期开始时间", dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "保险到期结束时间", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> list(String insuranceNum, Integer insuranceState, String cusName,
                                                             String cusPhone, String vin, Integer insuranceType, String orderNum,
                                                             Integer orderState, String beginTime, String endTime,
                                                             Integer pageNum, Integer pageSize, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        Map<String, Object> params = Maps.newHashMap();
        if (StringUtils.isNotBlank(insuranceNum)) {
            params.put("insuranceNum", insuranceNum);
        }
        if (insuranceState != null) {
            params.put("insuranceState", insuranceState);
        }
        if (StringUtils.isNotBlank(cusName)) {
            params.put("cusName", cusName);
        }
        if (StringUtils.isNotBlank(cusPhone)) {
            params.put("cusPhone", cusPhone);
        }
        if (StringUtils.isNotBlank(vin)) {
            params.put("vin", vin);
        }
        if (insuranceType != null) {
            params.put("insuranceType", insuranceType);
        }
        if (StringUtils.isNotBlank(orderNum)) {
            params.put("orderNum", orderNum);
        }
        if (orderState != null) {
            params.put("orderState", orderState);
        }
        params.put("storeId", getMember(request) == null ? null : getMember(request).getStoreId());
        params.put("beginTime", StringUtils.isNotBlank(beginTime) ? beginTime.trim() + " 00:00:00" : null);
        params.put("endTime", StringUtils.isNotBlank(endTime) ? endTime.trim() + " 23:59:59" : null);
        PageInfo<Map<String, Object>> pageInfo = orderInsuranceItemService.getListByParams(params, pageNum, pageSize);
        List<Map<String, Object>> orderInsuranceItems = pageInfo.getList();
        for (Map<String, Object> map : orderInsuranceItems) {
            //销售单号状态
            map.put("orderStateDesc", map.get("orderState") == null ? null : SettleEnum.OrderStatus.getByCode(Integer.valueOf(map.get("orderState").toString())).getReason());
            //保险单状态
            map.put("insuranceStateDesc", map.get("insuranceState") == null ? null : SettleEnum.OrderInsuranceStates.getByCode(Integer.valueOf(map.get("insuranceState").toString())).getDesc());
        }
        result.setData(pageInfo);
        return result;
    }

    @ApiOperation(value = "保险单详情", notes = "保险单详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "id", value = "订单-保险单ID", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<Map<String, Object>> detail(Integer id, HttpServletRequest request) {
        ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
        if (id == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("id不能为空");
            return result;
        }
        Map<String, Object> map = orderInsuranceItemService.getInfoById(id);
        if (map != null) {
            map.put("carCharacter", map.get("carCharacter") != null ? CarEnum.CarCharacters.getByCode(Integer.valueOf(map.get("carCharacter").toString())).getDesc() : null);
            map.put("insuranceImg", (map.get("insuranceImg") != null && StringUtils.isNotBlank(map.get("insuranceImg").toString())) ? (uploadAccessPath + map.get("insuranceImg").toString()) : "");
        }
        result.setData(map);
        return result;
    }

    @ApiOperation(value = "保险单操作（提交投保，取消）", notes = "保险单操作（提交投保，取消）")
    @RequestMapping(value = "/operate", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "保险单号ID", dataType = "Integer"),
            @ApiImplicitParam(name = "state", value = "1未提交2已提交3已取消(提交投保传2，取消传3)", dataType = "Integer"),
            @ApiImplicitParam(name = "carCharacter", value = "车辆性质", dataType = "Integer"),
            @ApiImplicitParam(name = "insuranceImg", value = "保险单图片", dataType = "String"),
            @ApiImplicitParam(name = "number", value = "保险单号", dataType = "String"),
            @ApiImplicitParam(name = "deadline", value = "保险到期日", dataType = "String")
    })
    @ResponseBody
    public ApiReturnInfo save(Integer id, Integer state, String insuranceImg, Integer carCharacter, String number, String deadline) {
        ApiReturnInfo result = new ApiReturnInfo<>();
        if (id == null || state == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("参数不能为空");
            return result;
        }
        //如果是投保，判断字段不能为空
        if (Objects.equals(state, SettleEnum.OrderInsuranceStates.COMMITTED.getCode()) && (carCharacter == null || StringUtils.isBlank(number) || StringUtils.isBlank(deadline))) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("投保参数不能为空");
            return result;
        }
        OrderInsuranceItem orderInsuranceItem = orderInsuranceItemService.getById(id);
        if (orderInsuranceItem == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("订单保险信息为空");
            return result;
        }
        orderInsuranceItem.setStatus(state);
        if (Objects.equals(state, SettleEnum.OrderInsuranceStates.COMMITTED.getCode())) {
            orderInsuranceItem.setInsuranceImg(insuranceImg);
            orderInsuranceItem.setCarCharacter(carCharacter);
            orderInsuranceItem.setNumber(number);
            orderInsuranceItem.setDeadline(StringUtils.isNotBlank(deadline) ? DateUtil.stringToDate(deadline, DateUtil.sdf2) : null);
        }
        int res = orderInsuranceItemService.save(orderInsuranceItem);
        if (res == 0) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("操作失败，请重试");
            return result;
        }
        return result;
    }
}
