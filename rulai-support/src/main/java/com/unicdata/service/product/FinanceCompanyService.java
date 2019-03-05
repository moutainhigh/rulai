package com.unicdata.service.product;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.product.FinanceCompany;

import java.util.List;
import java.util.Map;

public interface FinanceCompanyService {

	/**
	 * 根据条件获取金融公司列表
	 * 
	 * @param params
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);

	/**
	 * 保存金融公司
	 * 
	 * @param financeCompany
	 */
	void save(FinanceCompany financeCompany);

	/**
	 * 根据门店ID获取该门店的金融公司
	 * 
	 * @param storeId
	 * @return
	 */
	List<FinanceCompany> getListByStoreId(Integer storeId);

	/**
	 * 根据名称 查询金融公司
	 * 
	 * @param storeId
	 * @param string
	 * @return
	 */
	FinanceCompany selectByName(Integer storeId, String name);
}
