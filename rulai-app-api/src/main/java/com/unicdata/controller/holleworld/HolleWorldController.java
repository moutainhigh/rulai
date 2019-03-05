package com.unicdata.controller.holleworld;

import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.holleworld.HolleWorld;
import com.unicdata.service.CounterService;
import com.unicdata.service.HolleWorldService;
import com.unicdata.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by shenyong on 2018/5/28.
 */
@Controller
@RequestMapping("/")
@Api(value="HolleWorld",tags={"HolleWorld相关接口"})
public class HolleWorldController extends HomeBaseController {

    @Autowired
    private HolleWorldService holleWorldService;
    @Autowired
    private CounterService counterService;


    @ApiOperation(value="HolleWorld初始化方法实体类参数")
    @ApiImplicitParam(name = "holleWorld", value = "HolleWorld", required = true, dataType = "HolleWorld")
    @RequestMapping(value = "/holleworld")
    @ResponseBody
    public ApiReturnInfo<HolleWorld> init(@RequestBody HolleWorld holleWorld){
        String ar2 = RedisUtil.get("ar")+"";
        System.out.println(ar2);
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        List<HolleWorld> holleWorlds = holleWorldService.selectByExample(null);
        ar.setData(holleWorlds);

        RedisUtil.setex("ar",holleWorlds.get(0).getContext()+" "+ System.currentTimeMillis(),10);
        return ar;
    }

    @ApiOperation(value="HolleWorld初始化方法多个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "c", value = "内容描述", required = true, dataType = "String")
    })
    @RequestMapping(value = "/holleworld1")
    @ResponseBody
    public ApiReturnInfo init1(String c ,Integer id){
        String ar2 = RedisUtil.get("ar")+"";
        System.out.println(ar2);
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        List<HolleWorld> holleWorlds = holleWorldService.selectByExample(null);
        ar.setData(holleWorlds);
        RedisUtil.setex("ar",holleWorlds.get(0).getContext()+" "+ System.currentTimeMillis(),10);
        return ar;
    }

    @ApiOperation(value="HolleWorld初始化方法单个参数")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer")
    @RequestMapping(value = "/holleworld2")
    @ResponseBody
    public ApiReturnInfo init2(Integer id){
        String ar2 = RedisUtil.get("ar")+"";
        System.out.println(ar2);
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        List<HolleWorld> holleWorlds = holleWorldService.selectByExample(null);
        ar.setData(holleWorlds);
        RedisUtil.setex("ar",holleWorlds.get(0).getContext()+" "+ System.currentTimeMillis(),10);
        return ar;
    }


    @ApiOperation(value="测试自定义code")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "codePrefix", value = "生成code前缀", required = true, dataType = "String"),
            @ApiImplicitParam(name = "dateFormat", value = "时间格式化参数如：yyMM", required = false, dataType = "String"),
            @ApiImplicitParam(name = "number", value = "code后缀位数(默认6位)", required = false, dataType = "Integer")
    })
    @RequestMapping(value = "/testcode")
    @ResponseBody
    public ApiReturnInfo init1(String codePrefix, String dateFormat , Integer number){
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        ar.setData(counterService.generateCode(codePrefix,dateFormat,number));
        return ar;
    }
}
