package com.unicdata.base.enu;

/**
 * @Description: 调用状态枚举
 * @Author: muchunfa
 * @CreateDate: 2018/3/1 15:10
 */
public enum ResultCodeEnum {
    RESULT_CODE_SUCCESS(200,"提交成功"),
    RESULT_CODE_ERROR(500,"提交失败"),
    RESULT_CODE_NULL(400,"无数据"),
    //参数错误从1033开始--1200结束
    RESULT_CODE_PARAM_FAMILYID_MISS(1033,"缺少参数车系id"),
    RESULT_CODE_PARAM_VEHICLEID_MISS(1034,"缺少参数车型id"),
    RESULT_CODE_PARAM_KEY_MISS(1035,"缺少必要参数"),
    RESULT_CODE_PARAM_DISTRIBUTORID_MISS(1036,"缺少集团id参数"),
    RESULT_CODE_PARAM_TOKEN_NULL(1037,"token为空"),
    RESULT_CODE_PARAM_TOKEN_INVALID(1038,"token失效"),
    RESULT_CODE_PARAM_ACCOUNT_NO_EXISTENT(1039,"账号不存在"),
    RESULT_CODE_PARAM_ACCOUNT_STATUS_FAIL(1040,"账号已禁用"),
    RESULT_CODE_PARAM_PASSWORD_FAIL(1041,"密码错误"),
    //业务错误 从2033--2200
    RESULT_CODE_HAD_SIGNED(2033,"已经报过名"),
    RESULT_CODE_ORDER_EXISTENT(2034,"该用户已存在未完成的订单"),
    RESULT_CODE_TEST_DRIVER_NO_EXISTENT(2035,"该用户没有申请试驾记录"),
    RESULT_CODE_WORK_EXISTENT(2036,"你有正在接待的客户，此时无法更改状态"),
    RESULT_CODE_SUBMIT_FAIL(2037,"提交失败"),
    RESULT_CODE_PHONE_EXISTENT(2038,"此手机号已记录为另一客户"),
    RESULT_CODE_PHONE_OTHER_EXISTENT(2039,"此手机号是顾问XXX的客户,请联系前台'替岗'或'换销售'"),
    //系统异常
    NullPointerException(500,"空指针异常"),
    IllegalArgumentException(500,"请求参数类型不匹配"),
    SQLException(500,"数据库访问异常"),
    ServerExceprion(500,"服务器异常,请联系管理员")
    ;


    /**
     * 状态码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
