package com.unicdata.controller;

/**
 * Created by shenyong on 2018/6/28.
 */

import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * 返回Rest错误信息
 */
@RestControllerAdvice
public class RestErrorEndpoint {
    private final static Logger logger = LoggerFactory.getLogger(RestErrorEndpoint.class);

    @ExceptionHandler
    public ApiReturnInfo handler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        ApiReturnInfo ar = new ApiReturnInfo();
        logger.info("Restful Http请求发生异常...");

        if (e instanceof NullPointerException) {
            logger.error("NullPointerException：" + e.getMessage(), e);
            ar.setCode(ResultCodeEnum.NullPointerException.getCode());
            ar.setMessage(ResultCodeEnum.NullPointerException.getMessage());
            return ar;
        } else if (e instanceof IllegalArgumentException) {
            logger.error("IllegalArgumentException：" + e.getMessage(), e);
            ar.setCode(ResultCodeEnum.IllegalArgumentException.getCode());
            ar.setMessage(ResultCodeEnum.IllegalArgumentException.getMessage());
            return  ar;
        } else if (e instanceof SQLException) {
            ar.setCode(ResultCodeEnum.SQLException.getCode());
            ar.setMessage(ResultCodeEnum.SQLException.getMessage());
            logger.error("SQLException：" + e.getMessage(), e);
            return  ar;
        } else {
            logger.error("ServerError：" + e.getMessage(), e);
            ar.setCode(ResultCodeEnum.ServerExceprion.getCode());
            ar.setMessage(ResultCodeEnum.ServerExceprion.getMessage());
            return  ar;
        }
    }

}