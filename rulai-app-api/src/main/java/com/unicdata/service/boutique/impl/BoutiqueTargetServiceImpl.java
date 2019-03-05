package com.unicdata.service.boutique.impl;

import com.unicdata.dao.boutique.BoutiqueTargetMapper;
import com.unicdata.entity.boutique.BoutiqueTarget;
import com.unicdata.entity.boutique.BoutiqueTargetExample;
import com.unicdata.service.boutique.BoutiqueTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/5.
 */
@Service
public class BoutiqueTargetServiceImpl implements BoutiqueTargetService {
    @Autowired
    private BoutiqueTargetMapper boutiqueTargetMapper;

    @Override
    public List<BoutiqueTarget> selectByExample(BoutiqueTargetExample example) {
        return boutiqueTargetMapper.selectByExample(example);
    }

    @Override
    public List<BoutiqueTarget> getBoutiqueTargetByStoreId(Map<String, Object> map) {
        return boutiqueTargetMapper.getBoutiqueTargetByStoreId(map);
    }

    @Override
    public List<BoutiqueTarget> selectBoutiqueTargetSum(Map<String, Object> map) {
        return boutiqueTargetMapper.selectBoutiqueTargetSum(map);
    }

    @Override
    public int insertSelective(BoutiqueTarget record) {
        return boutiqueTargetMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(BoutiqueTarget record) {
        return boutiqueTargetMapper.updateByPrimaryKeySelective(record);
    }
}
