package com.unicdata.util;

import com.unicdata.entity.basedata.Dictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DictUtil {

    private static Logger logger = LoggerFactory.getLogger(DictUtil.class);
    private static String DICT_CACHE_KEY_PREFIX = "dict:";

    public DictUtil() {
    }

    /**
     * 将字典表对象保存到redis中
     * @param dict
     */
    public static void setToRedis(Dictionary dict) {
        logger.info("向Redis中写入Dict对象 --> dict.type - dict.resourceKey : {}, dict.resourceValue : {}", dict.getType() + "-" + dict.getResourceKey(), dict.getResourceValue());
        if(dict.getResourceValue()!=null){
            RedisUtil.set(DICT_CACHE_KEY_PREFIX + dict.getType() + ":" + dict.getResourceKey(), dict);
        }else{
            RedisUtil.set(DICT_CACHE_KEY_PREFIX + dict.getType(), dict);
        }
    }

    /**
     * 根据type和resourceKey获取Dictionary对象
     * @param type
     * @param resourceKey
     * @return
     */
    public static Dictionary getFromRedis(Integer type, Integer resourceKey) {
        logger.info("从Redis中读取Dict对象 --> dict.type : {}, dict.resourceKey:{}", type, resourceKey);
        Object obj = RedisUtil.get(DICT_CACHE_KEY_PREFIX + type + ":" + resourceKey, Dictionary.class);
        return (Dictionary)obj;
    }

    /**
     * 根据type获取没有resourceKey的Dictionary对象
     * @param type
     * @return
     */
    public static Dictionary getFromRedis(Integer type) {
        logger.info("从Redis中读取Dict对象 --> dict.type : {}", type);
        Object obj = RedisUtil.get(DICT_CACHE_KEY_PREFIX + type, Dictionary.class);
        return (Dictionary)obj;
    }

}
