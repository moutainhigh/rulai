package com.unicdata.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 门店相关参数
 * @author Administrator
 *
 */
public class StoreCode {

    /**
     * 门店编码重复
     */
    public static final Integer CODE_REPEAT = 980;

    public static Map<Integer,String> map = new HashMap<Integer, String>(){

        private static final long serialVersionUID = 1L;

        {
            put(CODE_REPEAT, "已有该门店编码存在");
        }
    };
}
