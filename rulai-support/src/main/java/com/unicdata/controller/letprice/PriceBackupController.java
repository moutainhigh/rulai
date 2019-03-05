package com.unicdata.controller.letprice;

import com.github.pagehelper.PageInfo;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.DateUtils;
import com.unicdata.base.util.StringUtil;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.entity.car.CarVehicleConfExample;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.car.CarVehicleConfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;

/**
 * Created by shenyong on 2018/6/12.
 */
@Api(value = "价格报备管理")
@RestController
@RequestMapping(value = "/rulai/priceBackup")
public class PriceBackupController extends HomeBaseController {

    @Autowired
    private CarVehicleConfService carVehicleConfService;

    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "adjustStatus", value = "调整状态 0未报备，1待报备，2待审批，3已审批，4驳回", required = false, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "brandId", value = "品牌id", required = false, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "familyId", value = "车系id", required = false, dataType = "Integer", paramType = "form")
    })
    @RequestMapping(value = "/list" ,method = RequestMethod.POST)
    public ApiReturnInfo<CarVehicleConf> list(HttpServletRequest request ,CarVehicleConf vehicle, Integer pageSize, Integer pageNum){
        ApiReturnInfo ar = new ApiReturnInfo();
        Employee employee = super.getMember(request);
        vehicle.setDistributorStoreId(employee.getStoreId());
        PageInfo<CarVehicleConf> carVehicleConfPageInfo = carVehicleConfService.selectVehicleList(vehicle, pageSize, pageNum);
        ar.setData(carVehicleConfPageInfo);
        return ar;
    }


    @ApiOperation(value = "限价编辑")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "levelOneAdjust", value = "销售顾问", required = true, dataType = "BigDecimal", paramType = "form"),
            @ApiImplicitParam(name = "levelTwoAdjust", value = "销售经理", required = true, dataType = "BigDecimal", paramType = "form"),
            @ApiImplicitParam(name = "levelThreeAdjust", value = "总经理", required = true, dataType = "BigDecimal", paramType = "form"),
    })
    @RequestMapping(value = "/priceEdit" ,method = RequestMethod.POST)
    public ApiReturnInfo priceEdit(HttpServletRequest request ,CarVehicleConf vehicle){
        return carVehicleConfService.priceEdit(vehicle);
    }


    @ApiOperation(value = "撤销，全部报备，审批，全部审批，驳回操作接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "adjustStatus", value = "对应功能  1撤销，2全部报备，3审批，4全部审批，5驳回 ", required = true, dataType = "Integer", paramType = "form"),
            @ApiImplicitParam(name = "ids", value = "需要审批或者撤销的编号（adjustStatus = 1 时为单个id ，adjustStatus = 3 时为多个id，用半角逗号隔开）", required = false, dataType = "String", paramType = "form")
    })
    @RequestMapping(value = "/chageStatus" ,method = RequestMethod.POST)
    public ApiReturnInfo chageStatus(HttpServletRequest request ,Integer adjustStatus ,String ids){
        return carVehicleConfService.chageStatus(adjustStatus,ids);
    }
    public static void main(String[] args) {

        //创建LocalDateTime对象
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1=LocalDateTime.of(2018, 11, 11, 11, 11);
        System.out.println(localDateTime1);

        //获取LocalDateTime对象的属性
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());

        //根据已有的LocalDateTime对象创建新的对象，原来的对象保持不变
        LocalDateTime localDateTime2=localDateTime.withDayOfMonth(1);
        LocalDateTime localDateTime3=localDateTime.withDayOfYear(1);
        LocalDateTime localDateTime4=localDateTime.withHour(1);
        LocalDateTime localDateTime5=localDateTime.withMinute(1);
        LocalDateTime localDateTime6=localDateTime.withYear(2019);
        LocalDateTime localDateTime7=localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime localDateTime8=localDateTime.with(TemporalAdjusters.firstDayOfNextMonth());
        LocalDateTime localDateTime9=localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime localDateTime10=localDateTime.withMonth(1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
        System.out.println(localDateTime4);
        System.out.println(localDateTime5);
        System.out.println(localDateTime6);
        System.out.println(localDateTime7);
        System.out.println(localDateTime8);
        System.out.println(localDateTime9);
        System.out.println(localDateTime10);

        LocalDate localDate=localDateTime.toLocalDate();
        LocalTime localTime=localDateTime.toLocalTime();
        System.out.println(localDate);
        System.out.println(localTime);


        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ld = LocalDateTime.now();
        ld.format(d);
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println(d.format(LocalDateTime.of(2018,12,31,23,56,59)));
        System.out.println(d.format(ld));
        System.out.println( d.format(ld.withDayOfMonth(12)));

        System.out.println(LocalDateTime.parse("2018-07-21 12:00:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(LocalDateTime.parse("2018-07-21 12:00:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).minusHours(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(LocalDateTime.parse("2018-07-21 12:00:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(DateUtils.getAbsTimeDiffDay(LocalDateTime.now(),LocalDateTime.parse("2018-07-22 12:00:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        if(LocalDateTime.now().isBefore(LocalDateTime.parse("2018-07-22 12:00:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))){
            System.out.println(1);
        }
    }


}

