package com.unicdata.controller.customer;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.DictionaryType;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.customer.PassengerFlowDto;
import com.unicdata.service.area.AreaService;
import com.unicdata.service.basedata.PcDictionaryService;
import com.unicdata.service.car.CarFamilyService;
import com.unicdata.service.carInfo.BaseCarInfoService;
import com.unicdata.service.customer.PassengerFlowService;
import com.unicdata.service.customer.TaskFollowUpService;
import com.unicdata.service.customer.TestDriveService;
import com.unicdata.service.order.OrderQuotedPriceService;
import com.unicdata.service.order.SaleOrderService;
import com.unicdata.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rulai/passengerFlow")
@Api(value = "客流相关接口", tags = {"销售顾问客流相关接口"})
public class PassengerFlowController extends HomeBaseController {

    @Autowired
    private PassengerFlowService passengerFlowService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private CarFamilyService carFamilyService;

    @Autowired
    private TestDriveService testDriveService;

    @Autowired
    private SaleOrderService orderService;

    @Autowired
    private OrderQuotedPriceService orderQuotedPriceService;

    @Autowired
    private TaskFollowUpService taskFollowUpService;

    @Autowired
    private BaseCarInfoService baseCarInfoService;

    @Autowired
    private PcDictionaryService pcDictionaryService;

    @ApiOperation(value = "客流列表", notes = "客流列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "日期", dataType = "String"),
            @ApiImplicitParam(name = "type", value = "进店类型", dataType = "Integer"),
            @ApiImplicitParam(name = "keyword", value = "客户姓名/手机号", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "记录数", dataType = "Integer")
    })
    @ResponseBody
    public ApiReturnInfo<PageInfo<PassengerFlowDto>> list(String keyword, String date, Integer type, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        ApiReturnInfo<PageInfo<PassengerFlowDto>> result = new ApiReturnInfo<>();
        if (pageNum == null || pageSize == null) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("分页字段不能为空");
            return result;
        }
        if (StringUtils.isBlank(date)) {
            result.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            result.setMessage("日期不能为空");
            return result;
        }
        Map<String, Object> params = Maps.newHashMap();
        params.put("date", date);
        if (StringUtils.isNotBlank(keyword)) {
            params.put("keyword", keyword);
        }
        if (type != null) {
            params.put("type", type);
        }
        params.put("storeId", getMember(request) == null ? null : getMember(request).getStoreId());
        PageInfo<PassengerFlowDto> pageInfo = passengerFlowService.selectFlowListByParams(params, pageNum, pageSize);
        List<PassengerFlowDto> data = pageInfo.getList();
        for (PassengerFlowDto dto : data) {
            dto.setTypeDesc(dto.getType() == null ? "" : (dto.getType() == 1 ? "首次" : "再次"));
            dto.setLevelDesc(dto.getLevel() != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_LEVEL, dto.getLevel()) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_LEVEL, dto.getLevel()).getResourceValue()) : "");
            dto.setCusSexDesc(dto.getCusSex() == null ? "" : (dto.getCusSex() == 0 ? "男" : "女"));
            dto.setAddress(areaService.getAddressBy(dto.getProvinceId(), dto.getCityId(), dto.getDistrictId()));
            dto.setIntentionFamilyDesc(dto.getIntentionFamilyId() == null ? "" : (carFamilyService.selectByPrimaryKey(dto.getIntentionFamilyId()) == null ? "" : carFamilyService.selectByPrimaryKey(dto.getIntentionFamilyId()).getName()));
            dto.setBudgetDesc(dto.getBudget() != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_BUDGET, dto.getBudget()) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_BUDGET, dto.getBudget()).getResourceValue()) : "");
            dto.setCusInfoSourcesDesc(dto.getCusInfoSources() != null ? (pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_MESSAGE_ORIGIN, dto.getCusInfoSources()) == null ? "" : pcDictionaryService.getByTypeAndKey(DictionaryType.CUSTOMER_MESSAGE_ORIGIN, dto.getCusInfoSources()).getResourceValue()) : "");
            if (dto.getArriveTime() != null && dto.getLeaveTime() != null) {
                long hour = DateUtil.howLong("h", dto.getArriveTime(), dto.getLeaveTime());
                long minute = DateUtil.howLong("m", dto.getArriveTime(), dto.getLeaveTime()) % 60;
                dto.setReceptionTime(hour + "小时" + minute + "分钟");
            }
            if (dto.getCusId() != null) {
                //获取客户试驾信息
                Map<String, Object> map = testDriveService.getTestInfoToday(dto.getCusId(), date);
                dto.setDriveStartTime(map.get("driveBeginTime") == null ? null : (Date) map.get("driveBeginTime"));
                dto.setDriveEndTime(map.get("driveEndTime") == null ? null : (Date) map.get("driveEndTime"));
                dto.setTestDriveCars(map.get("driveCars") == null ? "" : map.get("driveCars").toString());
                dto.setDriveTime(map.get("driveTime") == null ? "" : map.get("driveTime").toString());
                dto.setDoTestDrive(map.get("doTestDrive") == null ? "" : map.get("doTestDrive").toString());
                //判断用户是否当日有生效订单
                if (orderService.getOrdersByCusAndDate(dto.getCusId(), date) != null && orderService.getOrdersByCusAndDate(dto.getCusId(), date).size() > 0) {
                    dto.setHasOrder("是");
                }
                //是否当日存在报价单
                if (orderQuotedPriceService.getOrderQuotesBy(dto.getCusId(), date) != null && orderQuotedPriceService.getOrderQuotesBy(dto.getCusId(), date).size() > 0) {
                    dto.setHasQuotedPrice("是");
                }
                //是否邀约
                if (taskFollowUpService.getTaskFollowUpsBy(dto.getCusId(), date) != null && taskFollowUpService.getTaskFollowUpsBy(dto.getCusId(), date).size() > 0) {
                    dto.setIsInvited("是");
                }
            }
            List<Integer> familyIds = Lists.newArrayList();
            if (dto.getAttentionCarOne() != null) {
                familyIds.add(dto.getAttentionCarOne());
            }
            if (dto.getAttentionCarTwo() != null) {
                familyIds.add(dto.getAttentionCarTwo());
            }
            if (dto.getAttentionCarThree() != null) {
                familyIds.add(dto.getAttentionCarThree());
            }
            dto.setComparisonCar(StringUtils.join(baseCarInfoService.getFamilyNamesByFamilyIds(familyIds), ","));
        }
        result.setData(pageInfo);
        return result;
    }
}
