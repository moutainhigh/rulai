package com.unicdata.controller.holleworld;

import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.BaseController;
import com.unicdata.entity.holleworld.HolleWorld;
import com.unicdata.service.HolleWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by shenyong on 2018/5/28.
 */
@Controller
@RequestMapping("/")
public class HolleWorldController extends BaseController {

    @Autowired
    private HolleWorldService holleWorldService;

    @RequestMapping(value = "/holleworld")
    @ResponseBody
    public ApiReturnInfo init(){
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setCode(ResultCodeEnum.RESULT_CODE_SUCCESS.getCode());
        ar.setMessage(ResultCodeEnum.RESULT_CODE_SUCCESS.getMessage());
        List<HolleWorld> holleWorlds = holleWorldService.selectByExample(null);
        ar.setData(holleWorlds);
        return ar;
    }
}
