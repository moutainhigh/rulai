package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueSupplierBrand;
import com.unicdata.entity.boutique.BoutiqueSupplierBrandExample;
import java.util.List;

public interface BoutiqueSupplierBrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueSupplierBrand record);

    int insertSelective(BoutiqueSupplierBrand record);

    List<BoutiqueSupplierBrand> selectByExample(BoutiqueSupplierBrandExample example);

    BoutiqueSupplierBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueSupplierBrand record);

    int updateByPrimaryKey(BoutiqueSupplierBrand record);
}