package com.unicdata.service.boutique;

import java.util.List;

import com.unicdata.entity.boutique.BoutiqueRetailCustomer;
import com.unicdata.entity.system.Employee;

public interface RetailCustomerSupportService extends BoutiqueRetailCustomerService{

	int insert(BoutiqueRetailCustomer customer);

	List<BoutiqueRetailCustomer> selectBoutiqueRetailCustomer(BoutiqueRetailCustomer customer);

	BoutiqueRetailCustomer selectByPrimaryKey(Integer id);

}
