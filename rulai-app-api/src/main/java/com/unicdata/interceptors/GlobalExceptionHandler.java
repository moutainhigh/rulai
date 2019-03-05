package com.unicdata.interceptors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	/**
     * 所有异常报错
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=Exception.class)  
    public ApiReturnInfo allExceptionHandler(HttpServletRequest request,  
            Exception exception) throws Exception  
    {  
        exception.printStackTrace();
        ApiReturnInfo ari = new ApiReturnInfo();
        ari.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
        ari.setMessage("服务器异常，请联系管理员！");
        System.out.println("系统报错了："+exception.getLocalizedMessage());
        System.out.println("系统报错了："+exception.getCause());
        System.out.println("系统报错了："+exception.getSuppressed());
        System.out.println("系统报错了："+exception.getMessage());
        System.out.println("系统报错了："+exception.getStackTrace());
        return ari;  
    }  
}
