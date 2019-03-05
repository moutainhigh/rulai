package com.unicdata.controller.car;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.CarEnum;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.car.CarColor;
import com.unicdata.entity.car.CarOptionalPackage;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.car.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/2.
 */
@Controller
@RequestMapping("/app/carGoodInfo")
@Api(value = "仓库分页查询", tags = {"仓库分页查询"})
public class CarGoodInfoController extends HomeBaseController {
    @Autowired
    AppCarGoodInfoService carGoodInfoService;
    @Autowired
    AppCarFamilyService appCarFamilyService;
    @Autowired
    AppCarVehicleConfService appCarVehicleConfService;
    @Autowired
    AppCarColorService appCarColorService;
    @Autowired
    AppCarGoodInfoService appCarGoodInfoService;
    @Autowired
    AppCarOptionalPackageService appCarOptionalPackageService;
    @Autowired
    AppCarBoutiqueBindingService appCarBoutiqueBindingService;

    /**
     * @param familyId         车系id
     * @param decorationsOutId 颜色
     * @param vehicleId        车型
     * @param storageStatus    库存状态
     * @param name             搜索车型名字
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "通过条件查询仓库信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "brandId", value = "品牌id", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "familyId", value = "车系id", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "decorationsOutId", value = "颜色Id", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "vehicleId", value = "车型Id", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "storageStatus", value = "库存状态", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "map", value = "搜索车型名字", required = false, dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "inStorageDay", value = "安全在库天数", required = false, dataType = "Integer")
    })
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo list(HttpServletRequest request, Integer familyId, Integer decorationsOutId, Integer vehicleId, Integer brandId,
                              Integer storageStatus, String map, Integer pageNum, Integer pageSize, Integer inStorageDay) {
        //当前用户
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee emp = getMember(request);
        Map<String, Object> familyTypeMap = new HashMap<String, Object>();
        Map<String, Object> VehicleMap = new HashMap<String, Object>();
        Map<String, Object> carColorMap = new HashMap<String, Object>();
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>();
        //车系
        Map<String, Object> storageStatusMap = new HashMap<String, Object>();
        storageStatusMap.put("storeId", emp.getStoreId());
        storageStatusMap.put("brandId", brandId);
        pageInfo = appCarFamilyService.selectListByBrandId(storageStatusMap, 30, 0);
        familyTypeMap.put("list", pageInfo.getList());
        //车型配置
        Map<String, Object> storageStatusMap2 = new HashMap<String, Object>();
        storageStatusMap2.put("storeId", emp.getStoreId());
        storageStatusMap2.put("brandId", brandId);
        storageStatusMap2.put("familyId", familyId);
        pageInfo = appCarVehicleConfService.selectListByBrandId(storageStatusMap2, 30, 0);
        VehicleMap.put("list", pageInfo.getList());
        //颜色
        List<CarColor> carColors = appCarColorService.selectByFamilyId(familyId);
        carColorMap.put("list", carColors);

        //库存状态列表
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", "0");
        map1.put("code", "默认");
        arrayList.add(0, map1);

        CarEnum.CarStorageStatus[] values = CarEnum.CarStorageStatus.values();
        for (CarEnum.CarStorageStatus value : values) {
            if (value.getCode() != 4 && value.getCode() != 6) {
                Map<String, Object> hashMap = new HashMap<>();
                hashMap.put("id", value.getCode());
                hashMap.put("code", value.getReason());
                arrayList.add(hashMap);
            }
        }

        Integer storeId = emp.getStoreId();
        Map<String, Object> carMap = new HashMap<String, Object>();
        carMap.put("storeId", storeId);
        carMap.put("familyId", familyId);
        carMap.put("decorationsOutId", decorationsOutId);
        carMap.put("vehicleId", vehicleId);
        carMap.put("storageStatus", storageStatus);
        carMap.put("name", map);
        carMap.put("inStorageDay", inStorageDay);
        Map<String, Object> map3 = new HashMap<String, Object>();
        PageInfo maps = carGoodInfoService.selectByManyConditions(carMap, pageNum, pageSize);
        map3.put("list", maps.getList());
        map3.put("pageResult", getPageResult(maps));

        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("data", map3);
        map4.put("familyType", familyTypeMap);
        map4.put("vehicleMap", VehicleMap);
        map4.put("carColorMap", carColorMap);
        //库存状态
        map4.put("storageStatusMap", arrayList);
        ar.setData(map4);
        return ar;
    }

    /**
     * 获取车型 wp
     *
     * @param brandId
     * @param familyId
     * @param request
     * @return
     */
    @RequestMapping(value = "/selectCarConf", method = RequestMethod.POST)
    @ApiOperation(value = "车型")
    @ResponseBody
    public ApiReturnInfo selectCarConf(
            HttpServletRequest request,
            Integer pageNum,
            Integer pageSize
    ) {
        ApiReturnInfo ar = new ApiReturnInfo<>();
        Employee emp = getMember(request);
        Integer storeId = emp.getStoreId();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("storeId", storeId);
        List<Map<String, Object>> list = appCarGoodInfoService.selectCarConf(map);
        //试驾车试驾状态处理 
        if (list!=null) {
        	for (Map<String, Object> map2 : list) {
    			Integer testCarId=(Integer) map2.get("id");
    			Map<String, Object> map3=new HashMap<String, Object>();
    			Map<String, Object> testMap=null;
    			if (testCarId!=null) {
    				map3.put("testCarId", testCarId);
    				testMap=carGoodInfoService.isDrive(map3);
    			}
    			Integer status=null;
    			if (testMap !=null) {
					status=(Integer) testMap.get("status");
				}
    			if (status==null) {
					map2.put("isdrive", 1);
				}else if (status==1) {
					map2.put("isdrive", 2);
				}else if (status==2) {
					map2.put("isdrive", 1);
				}
    		}
		}
        Map<String, Object> mapr = new HashMap<String, Object>();
        mapr.put("list", list);
        ar.setData(mapr);
        return ar;
    }

    @ApiOperation(value = "根据vin码获取选装包详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vin", value = "vin码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/selectCarByVin")
    @ResponseBody
    public ApiReturnInfo selectCarByVin(String vin) {
        ApiReturnInfo ar = new ApiReturnInfo<>();
        List<CarOptionalPackage> carOptionalPackages = appCarOptionalPackageService.selectByVin(vin);
        ArrayList<Object> list = new ArrayList<>();
        for (CarOptionalPackage aPackage : carOptionalPackages) {
            list.add(aPackage.getName());
        }
        ar.setData(list);
        return ar;
    }


    @ApiOperation(value = "根据车辆id,获取精品名称及数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carId", value = "车辆id", required = true, dataType = "String")
    })
    @RequestMapping(value = "/selectBoutiqueByCarId")
    @ResponseBody
    public ApiReturnInfo selectBoutiqueByCarId(HttpServletRequest request, Integer carId) {
        ApiReturnInfo ar = new ApiReturnInfo<>();
        List<Map<String, Object>> mapList = appCarBoutiqueBindingService.selectByCarId(carId);
        ArrayList<Object> list = new ArrayList<>();
        for (Map<String, Object> objectMap : mapList) {
            Object boutiqueNum = objectMap.get("boutiqueNum");
            String boutiqueNuStr = "";
            if (boutiqueNum != null) {
                boutiqueNuStr = boutiqueNum.toString();
            }
            Object boutiqueName = objectMap.get("name");
            String boutiqueNameStr = "";
            if (boutiqueName != null) {
                boutiqueNameStr = boutiqueName.toString();
                list.add(boutiqueNameStr + " x " + boutiqueNuStr);
            }
        }
        ar.setData(list);
        return ar;
    }
}
