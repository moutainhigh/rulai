package com.unicdata.service.boutique.impl;

import com.unicdata.dao.boutique.BoutiqueRetailIncludePackDivisionMapper;
import com.unicdata.entity.boutique.BoutiqueRetailIncludePackDivision;
import com.unicdata.entity.boutique.BoutiqueRetailIncludePackDivisionExample;
import com.unicdata.service.boutique.BoutiqueRetailIncludePackDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/6/19.
 */

@Service
public class BoutiqueRetailIncludePackDivisionServiceImpl implements BoutiqueRetailIncludePackDivisionService {
    @Autowired
    private BoutiqueRetailIncludePackDivisionMapper boutiqueRetailIncludePackDivisionMapper;

    @Override
    public List<BoutiqueRetailIncludePackDivision> selectByExample(BoutiqueRetailIncludePackDivisionExample example) {
        return boutiqueRetailIncludePackDivisionMapper.selectByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(BoutiqueRetailIncludePackDivision record) {
        return boutiqueRetailIncludePackDivisionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(BoutiqueRetailIncludePackDivision record) {
        return boutiqueRetailIncludePackDivisionMapper.insertSelective(record);
    }
}
