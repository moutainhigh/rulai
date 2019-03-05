package com.unicdata.service.boutique;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.unicdata.constant.BoutiqueEnum.BoutiqueSource;
import com.unicdata.constant.BoutiqueEnum.BoutiqueType;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.system.Employee;

public interface RetailSupportService extends BoutiqueRetailService{

	List<Map<String, Object>> getMouthBoutiqueRetailByStoreId(Date saleDate, Integer storeId,BoutiqueType type,BoutiqueSource source);

	Double getMouthCostSumByisPackage(Date saleDate, Integer storeId,Integer ispackage,BoutiqueType boutiqueType);

	List<Map<String, Object>> getMouthBoutiqueRetailByStoreId(Map<String, Object> retail);

	Integer getBoutiqueDeliverCarByStoreId(Map<String, Object> dayRetail);

	/**
	 * 根据订单ID获取精品订单
	 * @param orderId
	 * @return
	 */
	BoutiqueRetail getRetailByOrderId(Integer orderId);

	int approvalRetail(Integer retailid, Integer type,String note,Employee member);

	int updateRetailDivision(JSONObject division, Employee member);

	int updateByPrimaryKeySelective(BoutiqueRetail record);

	List<Integer> selectRetailPackageId(Integer retailId);

}
