package com.unicdata.controller.customer;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.unicdata.entity.basedata.Dictionary;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.entity.carInfo.UnicdataFamily;
import com.unicdata.entity.order.Order;
import com.unicdata.service.basedata.PcDictionaryService;
import com.unicdata.service.car.CarFamilyService;
import com.unicdata.service.carInfo.BaseCarInfoService;
import com.unicdata.service.customer.TaskFollowUpService;
import com.unicdata.service.order.OrderQuotedPriceService;
import com.unicdata.service.order.SaleOrderService;
import io.swagger.annotations.*;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.DictionaryType;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.customer.Customer;
import com.unicdata.service.customer.CustomerService;
import com.unicdata.service.customer.TestDriveService;
import com.unicdata.service.dictionary.DictionaryService;
import com.unicdata.util.DictUtil;
import com.unicdata.util.NumberGenerateUtil;

@Controller
@RequestMapping("/rulai/customer")
@Api(value = "客户信息", tags = {"客户相关接口"})
public class CustomerController extends HomeBaseController {

    @Autowired
    private TestDriveService testDriveService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderQuotedPriceService orderQuotedPriceService;

    @Autowired
    private CarFamilyService carFamilyService;

    @Autowired
    private TaskFollowUpService taskFollowUpService;

    @Autowired
    private SaleOrderService orderService;

    @Autowired
    private BaseCarInfoService baseCarInfoService;

    @Autowired
    private PcDictionaryService pcDictionaryService;

    @ApiOperation(value = "获取下拉框选项值", notes = "获取下拉框选项值")
    @RequestMapping(value = "/selects", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "types", value = "类型用逗号隔开。查所有的话此字段不传", dataType = "String")
    @ResponseBody
    public ApiReturnInfo<Map<Integer, List<Map<String, Object>>>> getSelects(String types) {
        ApiReturnInfo<Map<Integer, List<Map<String, Object>>>> apiReturnInfo = new ApiReturnInfo<>();
        apiReturnInfo.setData(pcDictionaryService.getSelectOptions(types));
        return apiReturnInfo;
    }

   /* @RequestMapping(value = "/toRedis")
    @ResponseBody
    public Object data() {
        List<Dictionary> dictionaries = dictionaryService.data();
        for (Dictionary dictionary : dictionaries) {
            DictUtil.setToRedis(dictionary);
        }
        return dictionaryService.data();
    }*/

    @ApiOperation(value = "客户信息保存修改", notes = "客户信息保存修改")
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "customer", value = "客户", required = true, dataType = "Customer")
    @ResponseBody
    public ApiReturnInfo<Customer> save(@RequestBody Customer customer, HttpServletRequest request) {
        ApiReturnInfo result = new ApiReturnInfo<Map<String, Object>>();
        if (StringUtils.isBlank(customer.getName())) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("请填写客户姓名！");
            return result;
        }
        if (customer.getSex() == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("请选择客户性别！");
            return result;
        }
        if (StringUtils.isBlank(customer.getPhone())) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("请填写客户手机号！");
            return result;
        }
        if (customer.getId() == null) {
            //编号
            customer.setNumber(NumberGenerateUtil.getCustomerNumber(request));
            //所属店铺
            customer.setStoreId(getMember(request) == null ? null : getMember(request).getStoreId());
            //销售顾问
            customer.setEmployeeId(getMember(request) == null ? null : getMember(request).getId());
        } else {
            customer.setStoreId(customerService.getCustomerById(customer.getId()).getStoreId());
        }
        if (customerService.ifCustomerExist(customer)) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("该客户已存在，请勿重复添加！");
            return result;
        }
        customerService.save(customer);
        result.setData(customer);
        return result;
    }

    @ApiOperation(value = "客户信息详情", notes = "客户信息详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "id", value = "客户Id", required = true, dataType = "Integer")
    @ResponseBody
    public ApiReturnInfo<Map<String, Object>> details(Integer id) {
        ApiReturnInfo<Map<String, Object>> result = new ApiReturnInfo<>();
        Map<String, Object> map = Maps.newHashMap();
        if (id == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("客户ID不能为空！");
            return result;
        }
        //客户信息
        Customer customer = customerService.getCustomerById(id);
        map.put("id", customer.getId());
        map.put("name", customer.getName());
        map.put("sex", customer.getSex());
        map.put("sexDesc", customer.getSex() != null ? (customer.getSex() == 0 ? "男" : "女") : "");
        map.put("phone", customer.getPhone());
        map.put("cityId", customer.getCityId());
        map.put("province", customer.getProvinceId());
        map.put("districtId", customer.getDistrictId());
        map.put("ownedCar", customer.getOwnedCar());
        UnicdataFamily unicdataFamily = null;
        if (customer.getOwnedCar() != null) {
            unicdataFamily = baseCarInfoService.getFamilyByFamilyId(customer.getOwnedCar());
        }
        map.put("ownedCarBrandId", unicdataFamily == null ? null : unicdataFamily.getBrandId());
        map.put("licensePlate", customer.getLicensePlate());
        map.put("type", customer.getType());
        map.put("relationCustomer", customer.getRelationCustomer());
        map.put("relationCustomerDesc", customer.getRelationCustomer() == null ? "" : (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_RELATION_CUSTOMER, customer.getRelationCustomer()) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_RELATION_CUSTOMER, customer.getRelationCustomer()).getResourceValue()));
        map.put("typeDesc", customer.getType() != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_TYPE, customer.getType()) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_TYPE, customer.getType()).getResourceValue()) : "");
        map.put("origin", customer.getOrigin());
        map.put("originDesc", customer.getOrigin() != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_ORIGIN, customer.getOrigin()) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_ORIGIN, customer.getOrigin()).getResourceValue()) : "");
        map.put("channel", customer.getChannel());
        map.put("channelDesc", customer.getChannel() != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_CHANNEL, customer.getChannel()) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_CHANNEL, customer.getChannel()).getResourceValue()) : "");
        map.put("level", customer.getLevel());
        map.put("levelDesc", customer.getLevel() != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_LEVEL, customer.getLevel()) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_LEVEL, customer.getLevel()).getResourceValue()) : "");
        map.put("contactTime", customer.getContactTime());
        map.put("contactTimeDesc", customer.getContactTime() != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_CONTACT_TIME, customer.getContactTime()) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_CONTACT_TIME, customer.getContactTime()).getResourceValue()) : "");
        map.put("intentionFamilyId", customer.getIntentionFamilyId());
        CarFamily carFamily = null;
        if (customer.getIntentionFamilyId() != null) {
            carFamily = carFamilyService.selectByPrimaryKey(customer.getIntentionFamilyId());
        }
        map.put("brandId", carFamily == null ? null : carFamily.getBrandId());
        map.put("usage", customer.getUsage());
        map.put("usageDesc", customer.getUsage() != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_CAR_USAGE, customer.getUsage()) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_CAR_USAGE, customer.getUsage()).getResourceValue()) : "");
        map.put("user", customer.getUser());
        map.put("userDesc", customer.getUser() != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_CAR_USER, customer.getUser()) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_CAR_USER, customer.getUser()).getResourceValue()) : "");
        map.put("userSex", customer.getUserSex());
        map.put("sexDesc", customer.getUserSex() != null ? (customer.getSex() == 0 ? "男" : "女") : "");
        map.put("attentionPoint", customer.getAttentionPoint());
        map.put("budget", customer.getBudget());
        map.put("industry", customer.getIndustry());
        map.put("expectBuyTime", customer.getExpectBuyTime());
        map.put("buyType", customer.getBuyType());
        map.put("buyTypeDesc", customer.getBuyType() != null ? (customer.getBuyType() == 1 ? "一次性付款" : "贷款") : "");
        //意向车型1
        map.put("attentionCarOne", customer.getAttentionCarOne());
        UnicdataFamily carFamilyOne = null;
        if (customer.getAttentionCarOne() != null) {
            carFamilyOne = baseCarInfoService.getFamilyByFamilyId(customer.getAttentionCarOne());
        }
        map.put("attentionCarOneBrandId", carFamilyOne == null ? null : carFamilyOne.getBrandId());
        //意向车型2
        map.put("attentionCarTwo", customer.getAttentionCarTwo());
        UnicdataFamily carFamilyTwo = null;
        if (customer.getAttentionCarTwo() != null) {
            carFamilyTwo = baseCarInfoService.getFamilyByFamilyId(customer.getAttentionCarTwo());
        }
        map.put("attentionCarTwoBrandId", carFamilyTwo == null ? null : carFamilyTwo.getBrandId());
        //意向车型3
        UnicdataFamily carFamilyThree = null;
        map.put("attentionCarThree", customer.getAttentionCarThree());
        if (customer.getAttentionCarThree() != null) {
            carFamilyThree = baseCarInfoService.getFamilyByFamilyId(customer.getAttentionCarThree());
        }
        map.put("attentionCarThreeBrandId", carFamilyThree == null ? null : carFamilyThree.getBrandId());

        map.put("cusInfoSources", customer.getCusInfoSources());
        //报价信息
        map.put("orderQuotedPrices", orderQuotedPriceService.getOrderQuotesBy(id, null));
        //试驾信息
        map.put("testDrives", testDriveService.getTestDrivesByCusId(id));
        //跟进信息
        map.put("taskFollowUp", taskFollowUpService.getTaskFollowUpsBy(id, null));
        //是否有订单
        List<Order> orders = orderService.getOrdersByCusAndDate(customer.getId(), null);
        map.put("hasOrder", (orders == null || orders.isEmpty()) ? 0 : 1);
        result.setData(map);
        return result;
    }


    @ApiOperation(value = "客户列表", notes = "客户列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "客户ID", dataType = "Integer"),
            @ApiImplicitParam(name = "keyword", value = "输入框值", dataType = "String"),
            @ApiImplicitParam(name = "category", value = "客户类型", dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<Map<String, Object>>> list(Integer id, String keyword, Integer category, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<Map<String, Object>>> result = new ApiReturnInfo<>();
        if (pageNum == null || pageSize == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("分页字段不能为空");
            return result;
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("id", id);
        params.put("keyword", StringUtils.isNotBlank(keyword) ? keyword.trim() : null);
        params.put("category", category);
        params.put("storeId", getMember(request) == null ? null : getMember(request).getStoreId());
        PageInfo<Map<String, Object>> pageInfo = customerService.getListByParams(params, pageNum, pageSize);
        List<Map<String, Object>> data = pageInfo.getList();
        for (Map<String, Object> map : data) {
            map.put("testVehicleName", map.get("id") != null ? testDriveService.getLastDrive((Integer) map.get("id")) : "");
            map.put("nextDate", map.get("id") != null ? taskFollowUpService.getLastFollowTime((Integer) map.get("id")) : "");
            map.put("sex", map.get("sex") != null ? ((Integer) map.get("sex") == 1 ? "女" : "男") : "");
            map.put("levelDesc", map.get("level") != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_LEVEL, (Integer) map.get("level")) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_LEVEL, (Integer) map.get("level")).getResourceValue()) : "");
        }
        result.setData(pageInfo);
        return result;
    }
}