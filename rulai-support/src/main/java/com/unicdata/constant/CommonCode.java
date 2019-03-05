package com.unicdata.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by zhang
 */
public class CommonCode {
    /**
     * 请求成功
     */
    public static final Integer RESULT_CODE_SUCC = 200;

    /**
     * 接口异常
     */
    public static final Integer RESULT_CODE_EXCEPTION = 999;
    /**
     * token验证失败
     */
    public static final Integer TOKEN_ERROR = 998;

    /**
     * 必传参数不可为空
     */
    public static final Integer PARAM_NULL = 997;

    public static Map<Integer,String> map = new HashMap<Integer, String>(){

        private static final long serialVersionUID = 1L;

        {
            put(RESULT_CODE_SUCC, "请求成功！");
            put(RESULT_CODE_EXCEPTION, "接口异常！");
            put(TOKEN_ERROR, "token验证失败！");
            put(PARAM_NULL, "必传参数不可为空！");
        }
    };

}
