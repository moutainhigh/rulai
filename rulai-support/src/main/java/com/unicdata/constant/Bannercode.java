package com.unicdata.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * banner相关状态码，从410-499
 */
public class Bannercode {

	
	 /**
     * 请求成功
     */
    public static final String BANNER_CODE_SUCC = "410";

    /**
     * 接口异常
     */
    public static final String BANNER_CODE_EXCEPTION = "999";

    public static Map<String,String> map = new HashMap<String, String>(){

        private static final long serialVersionUID = 1L;

        {
            put(BANNER_CODE_SUCC, "请求成功！");
            put(BANNER_CODE_EXCEPTION, "接口异常！");
        }
    };
}
