package com.unicdata.service.dictionary;

import com.unicdata.entity.basedata.Dictionary;

import java.util.List;
import java.util.Map;

public interface DictionaryService {

    /**
     * 获取客户页面下拉框基础数据（除省市区外）
     * @return
     */
    Map<Integer,List<Map<String, Object>>> getSelectOptions(String types);

    /**
     * 根据Id获取实体
     * @param id
     * @return
     */
    Dictionary getById(Integer id);


    List<Dictionary> data();


}
