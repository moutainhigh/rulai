package com.unicdata.controller.policy;

import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.policy.ProofreaderListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 核对单
 * Created by shenyong on 2018/6/7.
 */
@Api(value = "核对单接口")
@RestController
@RequestMapping(value = "/rulai/proofreader")
public class ProofreaderListController extends HomeBaseController {

    @Value("${proofreader.list.file.url}")
    private String proofreaderListFileUrl;
    @Value("${upload.access.path}")
    private String uploadAccessPath;

    @Autowired
    private ProofreaderListService proofreaderListService;



    @ApiOperation(value = "核对单导入")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rebateId", value = "返利项目id", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "mfile", value = "导入Execl", required = true, dataType = "MultipartFile", paramType = "form")
    })
    @RequestMapping(value = "/import", method = { RequestMethod.POST })
    @ResponseBody
    @Transactional
    public ApiReturnInfo importProofreader(HttpServletRequest request, MultipartFile mfile,Integer rebateId ){
        ApiReturnInfo ar = new ApiReturnInfo();
        if(mfile == null ){
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage("核对单文件为空！");
            return ar;
        }
        Employee employee = super.getMember(request);
        Map resultMap = proofreaderListService.importProofreader(employee, mfile, rebateId);
        ar.setData(resultMap);
        return ar;
    }

    @ApiOperation(value = "核对单导入查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rebateId", value = "返利项目id", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "mfile", value = "导入Execl", required = true, dataType = "MultipartFile", paramType = "form")
    })
    @RequestMapping(value = "/selectImport", method = { RequestMethod.POST })
    @ResponseBody
    public ApiReturnInfo selectImportProofreader(HttpServletRequest request, MultipartFile mfile,Integer rebateId ){
        ApiReturnInfo ar = new ApiReturnInfo();
        if(mfile == null ){
            ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
            ar.setMessage("核对单文件为空！");
            return ar;
        }
        Map resultMap = proofreaderListService.selectImportProofreader( mfile, rebateId);
        ar.setData(resultMap);
        return ar;
    }

    @ApiOperation(value = "核对单模板导出")
    @RequestMapping(value = "/downloadUrl", method = { RequestMethod.POST ,RequestMethod.GET})
    @ResponseBody
    public ApiReturnInfo downLoad(HttpServletResponse response ) throws Exception {
        ApiReturnInfo ar = new ApiReturnInfo();
        ar.setData(uploadAccessPath+proofreaderListFileUrl);
        return ar;
    }

}
