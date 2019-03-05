package com.unicdata.service.dictionary.impl;

import com.google.common.collect.Maps;
import com.unicdata.constant.DictionaryType;
import com.unicdata.dao.basedata.DictionaryMapper;
import com.unicdata.entity.basedata.Dictionary;
import com.unicdata.entity.basedata.DictionaryExample;
import com.unicdata.service.dictionary.DictionaryService;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Transactional(readOnly = true)
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public Map<Integer, List<Map<String, Object>>> getSelectOptions(String types) {
        Map<Integer, List<Map<String, Object>>> result = Maps.newHashMap();
        List<Integer> params = Lists.newArrayList();
        if (StringUtils.isNotBlank(types)) {
            String[] paramStrs = types.split(",");
            for (String paramStr : paramStrs) {
                params.add(Integer.parseInt(paramStr));
            }
        } else {
            params = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 18, 19);
        }
        for (Integer param : params) {
            DictionaryExample example = new DictionaryExample();
            DictionaryExample.Criteria criteria = example.createCriteria();
            criteria.andTypeEqualTo(param);
            criteria.andEnabledEqualTo(Boolean.TRUE);
            List<Dictionary> list = dictionaryMapper.selectByExample(example);
            List<Map<String, Object>> options = Lists.newArrayList();
            for (Dictionary dictionary : list) {
                Map<String, Object> option = Maps.newHashMap();
                option.put("key", dictionary.getResourceKey());
                option.put("value", dictionary.getResourceValue());
                options.add(option);
            }
            result.put(param, options);
        }
        return result;
    }


    @Override
    public Dictionary getById(Integer id) {
        return dictionaryMapper.selectByPrimaryKey(id);
    }

    public List<Dictionary> data() {
        DictionaryExample example = new DictionaryExample();
        DictionaryExample.Criteria criteria = example.createCriteria();
        criteria.andEnabledEqualTo(Boolean.TRUE);
        List<Dictionary> list = dictionaryMapper.selectByExample(example);
        return list;
    }
}
