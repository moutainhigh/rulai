package com.unicdata.service.basedata;

import com.unicdata.entity.basedata.Dictionary;
import com.unicdata.service.dictionary.DictionaryService;

public interface PcDictionaryService extends DictionaryService {

    /**
     * 根据类型和key查找
     * @param type
     * @param resourceKey
     * @return
     */
    Dictionary getByTypeAndKey(Integer type, Integer resourceKey);
}
