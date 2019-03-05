package com.unicdata.service.boutique.impl;


import com.unicdata.dao.boutique.BoutiqueInstallMapper;
import com.unicdata.entity.boutique.BoutiqueInstall;
import com.unicdata.entity.boutique.BoutiqueInstallExample;
import com.unicdata.service.boutique.BoutiqueInstallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoutiqueInstallServiceImpl implements BoutiqueInstallService {
    @Autowired
    private BoutiqueInstallMapper boutiqueInstallMapper;

    @Override
    public int updateByPrimaryKeySelective(BoutiqueInstall record) {
        return boutiqueInstallMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<BoutiqueInstall> selectByExample(BoutiqueInstallExample example) {
        return boutiqueInstallMapper.selectByExample(example);
    }
}
