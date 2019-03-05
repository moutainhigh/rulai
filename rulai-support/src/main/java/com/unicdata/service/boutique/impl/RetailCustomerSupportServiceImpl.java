package com.unicdata.service.boutique.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.boutique.BoutiqueRetailCustomerMapper;
import com.unicdata.entity.boutique.BoutiqueRetailCustomer;
import com.unicdata.service.boutique.RetailCustomerSupportService;
@Service
public class RetailCustomerSupportServiceImpl extends BoutiqueRetailCustomerServiceImpl implements RetailCustomerSupportService {

	@Autowired
	private BoutiqueRetailCustomerMapper customerMapper ;
	
	
	@Override
	public int insert(BoutiqueRetailCustomer customer) {
		int i = customerMapper.insertUseGeneratedKeys(customer);
		if( i == 1){
			return customer.getId();
		}else{
			return 0;
		}
	}


	@Override
	public List<BoutiqueRetailCustomer> selectBoutiqueRetailCustomer(BoutiqueRetailCustomer customer) {
		return customerMapper.selectBoutiqueRetailCustomer(customer);
	}

	@Override
	public BoutiqueRetailCustomer selectByPrimaryKey(Integer id) {
		return customerMapper.selectByPrimaryKey(id);
	}

}
