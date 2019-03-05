package com.unicdata.service.boutique;

import com.unicdata.entity.boutique.BoutiqueInstall;
import com.unicdata.entity.boutique.BoutiqueInstallExample;

import java.util.List;

public interface BoutiqueInstallService {
    int updateByPrimaryKeySelective(BoutiqueInstall record);

    List<BoutiqueInstall> selectByExample(BoutiqueInstallExample example);
}
