package com.unicdata.controller.boutique;


import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.BoutiqueEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.boutique.BoutiqueWarehouse;
import com.unicdata.entity.boutique.CheckItem;
import com.unicdata.entity.boutique.DepotCheck;
import com.unicdata.service.boutique.DepotCheckService;
import com.unicdata.service.boutique.WarehouseSupportService;
import com.unicdata.service.car.CarFamilyService;
import com.unicdata.util.DateUtil;
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
@RequestMapping("/rulai/boutique/depotcheck")
@Api(value = "库存盘点", tags = {"库存盘点"})
public class DepotCheckController extends HomeBaseController {

    @Autowired
    private DepotCheckService depotCheckService;

    @Autowired
    private WarehouseSupportService warehouseSupportService;

    @Autowired
    private CarFamilyService carFamilyService;


    @ApiOperation(value = "盘点单列表", notes = "盘点单列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "number", value = "盘点单编号", dataType = "String"),
            @ApiImplicitParam(name = "beginTime", value = "盘点开始时间", dataType = "String"),
            @ApiImplicitParam(name = "endTime", value = "盘点结束时间", dataType = "String"),
            @ApiImplicitParam(name = "warehouseIds", value = "仓库ID(用,隔开)", dataType = "String"),
            @ApiImplicitParam(name = "state", value = "盘点单状态", dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> list(String number, String beginTime,
                                                             String endTime, String warehouseIds,
                                                             Integer state, Integer pageNum,
                                                             Integer pageSize, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        if (pageNum == null || pageSize == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("分页字段不能为空");
            return result;
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("number", number);
        params.put("state", state);
        params.put("beginTime", StringUtils.isNotBlank(beginTime) ? beginTime.trim() + " 00:00:00" : null);
        params.put("endTime", StringUtils.isNotBlank(endTime) ? endTime.trim() + " 23:59:59" : null);
        params.put("warehouseIds", warehouseIds == null ? null : warehouseIds.trim());
        params.put("storeId", getMember(request).getStoreId());
        PageInfo<Map<String, Object>> pageInfo = depotCheckService.getListByParams(params, pageNum, pageSize);
        List<Map<String, Object>> data = pageInfo.getList();
        for (Map<String, Object> map : data) {
            if (map.get("state") != null && StringUtils.isNotBlank(map.get("state").toString())) {
                map.put("stateDesc", BoutiqueEnum.DepotCheckStates.getByCode(Integer.valueOf(map.get("state").toString())).getDesc());
            }
            if (map.get("warehouseIds") != null && StringUtils.isNotBlank(map.get("warehouseIds").toString())) {
                map.put("warehouseNames", warehouseSupportService.findNamesByIds(map.get("warehouseIds").toString()));
            }
        }
        result.setData(pageInfo);
        return result;
    }


    @ApiOperation(value = "查看盘点单详情", notes = "查看盘点单详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "checkId", value = "盘点单ID", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<Map<String, Object>> detail(Integer checkId, HttpServletRequest request) {
        ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
        if (checkId == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("checkId不能为空");
            return result;
        }
        Map<String, Object> map = Maps.newHashMap();
        DepotCheck check = depotCheckService.getCheckById(checkId);
        map.put("id", check.getId());
        map.put("number", check.getNumber());
        map.put("checkTime", check.getCheckTime() == null ? "" : DateUtil.dateFormat(check.getCheckTime(), DateUtil.sdf3));
        map.put("checker", check.getChecker());
        map.put("checkName", check.getCheckName());
        map.put("remark", check.getRemark());
        List<Integer> warehouseIds = Lists.newArrayList();
        if (StringUtils.isNotBlank(check.getWarehouseIds())) {
            String[] warehouseIdStrs = check.getWarehouseIds().split(",");
            for (String idStr : warehouseIdStrs) {
                warehouseIds.add(Integer.valueOf(idStr));
            }
        }
        //选中的多选框
        map.put("warehouseIds", warehouseIds);

        //盘点项
        List<Map<String, Object>> checkItems = depotCheckService.getCheckItemsByCheckId(checkId);
        if (checkItems != null) {
            for (Map<String, Object> item : checkItems) {
                if (item.get("familyIds") != null && StringUtils.isNotBlank(item.get("familyIds").toString())) {
                    item.put("vehicleName", carFamilyService.getNamesByIds(item.get("familyIds").toString()));
                } else {
                    item.put("vehicleName", "");
                }
            }
        }
        map.put("checkItems", checkItems);
        result.setData(map);
        return result;
    }

    @ApiOperation(value = "根据店铺ID获取仓库集合", notes = "根据店铺ID获取仓库集合")
    @RequestMapping(value = "/warehouses", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "request", value = "request", dataType = "HttpServletRequest")
    @ResponseBody
    public ApiReturnInfo<List<BoutiqueWarehouse>> detail(HttpServletRequest request) {
        ApiReturnInfo<List<BoutiqueWarehouse>> result = new ApiReturnInfo<>();
        Integer storeId = getMember(request).getStoreId();
        if (storeId == null) {
            result.setData(Lists.newArrayList());
            return result;
        }
        List<BoutiqueWarehouse> houses = warehouseSupportService.findAll(storeId);
        result.setData(houses);
        return result;
    }

    @ApiOperation(value = "根据仓库获取仓库下精品信息", notes = "根据仓库获取仓库下精品信息")
    @RequestMapping(value = "/boutiqueinfos", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "warehouseIds", value = "仓库ID(用，隔开)", dataType = "String")
    @ResponseBody
    public ApiReturnInfo<List<Map<String, Object>>> dd(String warehouseIds) {
        ApiReturnInfo<List<Map<String, Object>>> result = new ApiReturnInfo<>();
        if (StringUtils.isBlank(warehouseIds.trim())) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("warehouseId不能为空");
            return result;
        }
        List<Map<String, Object>> data = depotCheckService.getCheckItemsByWarehouseIds(warehouseIds);
        for (Map<String, Object> map : data) {
            if (map.get("familyIds") != null && StringUtils.isNotBlank(map.get("familyIds").toString())) {
                map.put("vehicleName", carFamilyService.getNamesByIds(map.get("familyIds").toString()));
            } else {
                map.put("vehicleName", "");
            }
            map.put("physicalInventory", null);
            map.put("differenceQuantity", null);
        }
        result.setData(data);
        return result;
    }

    @ApiOperation(value = "保存盘点单", notes = "保存盘点单")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "depotCheck", value = "盘点单信息", dataType = "DepotCheck")
    @ResponseBody
    public ApiReturnInfo<Integer> save(@RequestBody DepotCheck depotCheck, HttpServletRequest request) {
        ApiReturnInfo<Integer> result = new ApiReturnInfo<>();
        if (StringUtils.isBlank(depotCheck.getCheckName())) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("盘点单名称不能为空");
            return result;
        }
        if (depotCheck.getState() == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("盘点单状态不能为空");
            return result;
        }
        List<CheckItem> checkItems = depotCheck.getCheckItems();
        //默认都填写了清点数量
        Boolean flag = Boolean.TRUE;
        for (CheckItem item : checkItems) {
            if (item.getPhysicalInventory() == null) {
                flag = Boolean.FALSE;
                break;
            }
        }
        //如果是确认盘点且有都有没填写盘点数量的
        if (Objects.equals(depotCheck.getState(), BoutiqueEnum.DepotCheckStates.CONFIRMED.getCode()) && !flag) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("清点数量不能为空");
            return result;
        }
        if (depotCheck.getId() == null) {
            //记录盘点人
            depotCheck.setChecker(getMember(request).getFullName());
            //门店
            depotCheck.setStoreId(getMember(request).getStoreId());
        }
        int checkId = depotCheckService.save(depotCheck);
        result.setData(depotCheck.getId() == null ? checkId : null);
        return result;
    }

    @ApiOperation(value = "盘点单作废", notes = "盘点单作废")
    @RequestMapping(value = "/scrap", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "checkId", value = "盘点单ID", dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo scrap(Integer checkId) {
        ApiReturnInfo result = new ApiReturnInfo<>();
        if (checkId == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("盘点单ID不能为空");
            return result;
        }
        DepotCheck check = depotCheckService.getCheckById(checkId);
        if (check == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("盘点单不存在");
            return result;
        }
        check.setState(BoutiqueEnum.DepotCheckStates.DISCARDED.getCode());
        depotCheckService.scrap(check);
        return result;
    }

    @ApiOperation(value = "盘点差异分析", notes = "盘点差异分析")
    @RequestMapping(value = "/difference", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "number", value = "盘点单编号", dataType = "String")
    @ResponseBody
    public ApiReturnInfo<Map<String, Object>> difference(String number) {
        ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
        if (StringUtils.isBlank(number)) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("盘点单编号不能为空");
            return result;
        }
        DepotCheck check = depotCheckService.getCheckByNumber(number);
        if (check == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("盘点单不存在");
            return result;
        }
        result.setData(depotCheckService.getDifferenceByCheckId(check.getId()));
        return result;
    }

    @ApiOperation(value = "库存调整", notes = "库存调整")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "checkItems", value = "盘点项集合", dataType = "List")
    @ResponseBody
    public ApiReturnInfo<Map<String, Object>> difference(@RequestBody List<CheckItem> items) {
        ApiReturnInfo result = new ApiReturnInfo<>();
        if (items == null || items.isEmpty()) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("入库项不能为空");
            return result;
        }
        Boolean flag = Boolean.TRUE;
        for (CheckItem item : items) {
            if (item.getPhysicalInventory() == null) {
                flag = Boolean.FALSE;
                break;
            }
        }
        if (Objects.equals(flag, Boolean.FALSE)) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("存在入库数量为空，请填写");
            return result;
        }
        try {
            depotCheckService.updateDepot(items);
        } catch (Exception e) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage(e.getMessage());
            return result;
        }
        return result;
    }

    @ApiOperation(value = "获取盘点单号和盘点人", notes = "获取盘点单号和盘点人")
    @RequestMapping(value = "/number", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo<Map<String, Object>> difference(HttpServletRequest request) {
        ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
        Map<String, Object> data = Maps.newHashMap();
        //data.put("number", NumberGenerateUtil.getDepotNumber());
        data.put("checker", getMember(request) == null ? null : getMember(request).getFullName());
        result.setData(data);
        return result;
    }

}
