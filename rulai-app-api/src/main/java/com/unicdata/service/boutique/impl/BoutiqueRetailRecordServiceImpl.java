package com.unicdata.service.boutique.impl;

import com.unicdata.dao.boutique.BoutiqueRetailRecordMapper;
import com.unicdata.entity.boutique.BoutiqueRetailRecord;
import com.unicdata.entity.boutique.BoutiqueRetailRecordExample;
import com.unicdata.service.boutique.BoutiqueRetailRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/6/14.
 */
@Service
public class BoutiqueRetailRecordServiceImpl implements BoutiqueRetailRecordService {
    @Autowired
    private BoutiqueRetailRecordMapper boutiqueRetailRecordMapper;

    @Override
    public int updateByPrimaryKeySelective(BoutiqueRetailRecord record) {
        return boutiqueRetailRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<BoutiqueRetailRecord> selectByExample(BoutiqueRetailRecordExample example) {
        return boutiqueRetailRecordMapper.selectByExample(example);
    }

    @Override
    public int insertSelective(BoutiqueRetailRecord record) {
        return boutiqueRetailRecordMapper.insertSelective(record);
    }
}
