package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueRetailCustomer;
import com.unicdata.entity.boutique.BoutiqueRetailCustomerExample;
import java.util.List;

public interface BoutiqueRetailCustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueRetailCustomer record);

    int insertSelective(BoutiqueRetailCustomer record);

    List<BoutiqueRetailCustomer> selectByExample(BoutiqueRetailCustomerExample example);

    BoutiqueRetailCustomer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueRetailCustomer record);

    int updateByPrimaryKey(BoutiqueRetailCustomer record);

	int insertUseGeneratedKeys(BoutiqueRetailCustomer customer);

	List<BoutiqueRetailCustomer> selectBoutiqueRetailCustomer(BoutiqueRetailCustomer customer);
}