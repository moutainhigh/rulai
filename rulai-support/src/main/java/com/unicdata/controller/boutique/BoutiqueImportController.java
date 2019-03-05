package com.unicdata.controller.boutique;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicdata.base.enu.ResultCodeEnum;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.BoutiqueImportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

@Controller
@RequestMapping("/rulai/boutiqueImport")
@Api(value = "精品导入导出相关接口", tags = {"精品导入导出相关接口"})
public class BoutiqueImportController extends HomeBaseController {

    @Value("${boutique.file.url}")
    private String boutiqueUrl;
    @Value("${boutique.file.name}")
    private String boutiqueName;


    @Value("${boutique.push.file.url}")
    private String pushUrl;
    @Value("${boutique.push.file.name}")
    private String pushName;

    @Value("${boutique.position.file.url}")
    private String positionUrl;
    @Value("${boutique.position.file.name}")
    private String positionName;

    @Value("${upload.access.path}")   
    private String url_pre;
    
    
    @Autowired
    private BoutiqueImportService boutiqueImportService;


    @ApiOperation(value = "导出精品信息库模板")
    @RequestMapping(value = "/downloadBoutiqueModel", method = {RequestMethod.GET})
    @ResponseBody
    public ApiReturnInfo<String> downloadBoutiqueModel(HttpServletRequest request, HttpServletResponse response) {
        ApiReturnInfo<String> result = new ApiReturnInfo<String>();
        try {
            boutiqueImportService.exportModel(response, url_pre+ boutiqueUrl, boutiqueName);

        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
            result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
            result.setData("failed!");
        }
        return result;
    }


    @ApiOperation(value = "导出精品入库导入模板")
    @RequestMapping(value = "/downloadBoutiquePushModel", method = {RequestMethod.GET})
    @ResponseBody
    public ApiReturnInfo<String> downloadBoutiquePushModel(HttpServletRequest request, HttpServletResponse response) {
        ApiReturnInfo<String> result = new ApiReturnInfo<String>();
        try {


            boutiqueImportService.exportModel(response, url_pre+ pushUrl, pushName);

        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
            result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
            result.setData("failed!");
        }
        return result;
    }
    
    @ApiOperation(value = "导出精品仓库模板")
    @RequestMapping(value = "/downloadBoutiquePositionModel", method = {RequestMethod.GET})
    @ResponseBody
    public ApiReturnInfo<String> downloadBoutiquePositionModel(HttpServletRequest request, HttpServletResponse response) {
    	ApiReturnInfo<String> result = new ApiReturnInfo<String>();
    	try {
    		boutiqueImportService.exportModel(response, url_pre + positionUrl, positionName);
    	} catch (Exception e) {
    		e.printStackTrace();
    		result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
    		result.setMessage(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getReason());
    		result.setData("failed!");
    	}
    	return result;
    }

    
    
    
    
    @ApiOperation(value = "精品仓库库位导入")
    @RequestMapping(value = "/uploadBoutiquePosition", method = {RequestMethod.POST})
    @ApiImplicitParam(name = "warehouseId", value = "仓库ID", dataType = "String")
    @ResponseBody
    public ApiReturnInfo<String> uploadBoutiquePosition(Integer warehouseId, HttpServletRequest request) {
        ApiReturnInfo<String> result = new ApiReturnInfo<String>();
        if (warehouseId == null) {
			result.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
			result.setMessage("仓库ID不能为空");
			return result;
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("positionExcel");

        if(file == null){
            result.setData("no file!");
            result.setMessage("false");
            result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
            return result;
        }

        Map<String,String> result_map = boutiqueImportService.uploadPosition(request,file,warehouseId);
        if(result_map != null){
            if("200".equals(result_map.get("status"))){
                result.setData(result_map.get("msg"));
            }else{
                result.setData(result_map.get("msg"));
                result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
                result.setMessage("false");
            }
        }
        return result;
    }

    
    @ApiOperation(value = "精品分类导入")
    @ApiImplicitParam(name = "classifyExcel", value = "form表单设置enctype=\"multipart/form-data\" , input标签name为classifyExcel ", dataType = "String")
    @RequestMapping(value = "/uploadBoutiqueClassify", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo<String> uploadBoutiqueClassify( HttpServletRequest request){
        ApiReturnInfo<String> result = new ApiReturnInfo<String>();
    	
        Employee member = getMember(request);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("classifyExcel");

        if(file == null){
            result.setData("no file!");
            result.setMessage("false");
            result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
            return result;
        }

        Map<String,String> result_map = boutiqueImportService.uploadClassify(request,file,member );
        if(result_map != null){
            if("200".equals(result_map.get("status"))){
                result.setData(result_map.get("msg"));
            }else{
                result.setData(result_map.get("msg"));
                result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
                result.setMessage("false");
            }
        }
        return result;
    	
    }
    
    @ApiOperation(value = "精品供应商导入")
    @ApiImplicitParam(name = "supplierExcel", value = "form表单设置enctype=\"multipart/form-data\" , input标签name为supplierExcel ", dataType = "String")
    @RequestMapping(value = "/uploadBoutiqueSuppiler", method = {RequestMethod.POST})
    @ResponseBody 
    public ApiReturnInfo<String> uploadBoutiqueSuppiler(HttpServletRequest request){
        ApiReturnInfo<String> result = new ApiReturnInfo<String>();
    	
        Employee member = getMember(request);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("supplierExcel");

        if(file == null){
            result.setData("no file!");
            result.setMessage("false");
            result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
            return result;
        }

        Map<String,String> result_map = boutiqueImportService.uploadSupplier(request,file,member );
        if(result_map != null){
            if("200".equals(result_map.get("status"))){
                result.setData(result_map.get("msg"));
            }else{
                result.setData(result_map.get("msg"));
                result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
                result.setMessage("false");
            }
        }
        return result;
    }
    
    @ApiOperation(value = "精品品牌导入")
    @ApiImplicitParam(name = "brandExcel", value = "form表单设置enctype=\"multipart/form-data\" , input标签name为brandExcel ", dataType = "String")
    @RequestMapping(value = "/uploadBoutiqueBrand", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo<String> uploadBoutiqueBrand(HttpServletRequest request){
        ApiReturnInfo<String> result = new ApiReturnInfo<String>();
    	
        Employee member = getMember(request);
        
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("brandExcel");

        if(file == null){
            result.setData("no file!");
            result.setMessage("false");
            result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
            return result;
        }

        Map<String,String> result_map = boutiqueImportService.uploadBrand(request,file,member );
        if(result_map != null){
            if("200".equals(result_map.get("status"))){
                result.setData(result_map.get("msg"));
            }else{
                result.setData(result_map.get("msg"));
                result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
                result.setMessage("false");
            }
        }
        return result;
    }
    
    @ApiOperation(value = "精品基础信息库导入")
    @ApiImplicitParam(name = "boutiqueExcel", value = "form表单设置enctype=\"multipart/form-data\" , input标签name为boutiqueExcel ", dataType = "String")
    @RequestMapping(value = "/uploadBoutique", method = {RequestMethod.POST})
    @ResponseBody
    public ApiReturnInfo<String> uploadBoutique(HttpServletRequest request){
        ApiReturnInfo<String> result = new ApiReturnInfo<String>();
    	
        Employee member = getMember(request);
        
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("boutiqueExcel");

        if(file == null){
            result.setData("no file!");
            result.setMessage("false");
            result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
            return result;
        }

        Map<String,String> result_map = boutiqueImportService.uploadBoutique(request,file,member );
        if(result_map != null){
            if("200".equals(result_map.get("status"))){
                result.setData(result_map.get("msg"));
            }else{
                result.setData(result_map.get("msg"));
                result.setCode(ConstantEnumStatus.INTERNAL_SERVER_ERROR.getCode());
                result.setMessage("false");
            }
        }
        return result;
    }
    
    
}
