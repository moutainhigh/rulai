package com.unicdata.service.boutique;

import com.unicdata.entity.boutique.BoutiqueRetailRecord;
import com.unicdata.entity.boutique.BoutiqueRetailRecordExample;

import java.util.List;

/**
 * Created by lenovo on 2018/6/14.
 */
public interface BoutiqueRetailRecordService {
    int updateByPrimaryKeySelective(BoutiqueRetailRecord record);

    List<BoutiqueRetailRecord> selectByExample(BoutiqueRetailRecordExample example);

    int insertSelective(BoutiqueRetailRecord record);
}
