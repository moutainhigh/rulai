package com.unicdata.service.boutique;

import com.unicdata.entity.boutique.BoutiqueRetailIncludePackDivision;
import com.unicdata.entity.boutique.BoutiqueRetailIncludePackDivisionExample;

import java.util.List;

/**
 * Created by lenovo on 2018/6/19.
 */
public interface BoutiqueRetailIncludePackDivisionService {
    List<BoutiqueRetailIncludePackDivision> selectByExample(BoutiqueRetailIncludePackDivisionExample example);

    int updateByPrimaryKeySelective(BoutiqueRetailIncludePackDivision record);

    int insertSelective(BoutiqueRetailIncludePackDivision record);
}
