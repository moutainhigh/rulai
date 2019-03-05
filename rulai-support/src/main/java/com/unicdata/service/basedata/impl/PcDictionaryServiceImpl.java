package com.unicdata.service.basedata.impl;

import com.unicdata.dao.basedata.DictionaryMapper;
import com.unicdata.entity.basedata.Dictionary;
import com.unicdata.entity.basedata.DictionaryExample;
import com.unicdata.service.basedata.PcDictionaryService;
import com.unicdata.service.dictionary.impl.DictionaryServiceImpl;
import com.unicdata.util.DictUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PcDictionaryServiceImpl extends DictionaryServiceImpl implements PcDictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public Dictionary getByTypeAndKey(Integer type, Integer resourceKey) {
        //先从redis中取
        Dictionary dictionary = DictUtil.getFromRedis(type, resourceKey);
        //取不到从数据库里取
        if (dictionary == null) {
            DictionaryExample example = new DictionaryExample();
            DictionaryExample.Criteria criteria = example.createCriteria();
            criteria.andTypeEqualTo(type);
            criteria.andResourceKeyEqualTo(resourceKey);
            List<Dictionary> dictionaries = dictionaryMapper.selectByExample(example);
            //从数据库中取到同时同步到redis
            if (dictionaries != null && !dictionaries.isEmpty()) {
                dictionary = dictionaries.get(0);
                DictUtil.setToRedis(dictionary);
            }
        }
        return dictionary;
    }
}
