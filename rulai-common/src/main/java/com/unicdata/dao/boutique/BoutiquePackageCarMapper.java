package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiquePackageCar;
import com.unicdata.entity.boutique.BoutiquePackageCarExample;
import java.util.List;

public interface BoutiquePackageCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiquePackageCar record);

    int insertSelective(BoutiquePackageCar record);

    List<BoutiquePackageCar> selectByExample(BoutiquePackageCarExample example);

    BoutiquePackageCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiquePackageCar record);

    int updateByPrimaryKey(BoutiquePackageCar record);

	List<BoutiquePackageCar> selectCarByPackId(Integer id);
}