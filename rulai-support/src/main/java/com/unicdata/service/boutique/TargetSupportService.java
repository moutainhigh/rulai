package com.unicdata.service.boutique;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.unicdata.constant.BoutiqueEnum.BoutiqueSource;
import com.unicdata.entity.boutique.BoutiqueTarget;
import com.unicdata.entity.system.Employee;


public interface TargetSupportService extends BoutiqueTargetService {
	
	// 通过门户id获取
	List<BoutiqueTarget> getBoutiqueTargetByStoreId(Map<String, Object> map);
	
	List<BoutiqueTarget> getBoutiqueTargetByStoreId(Date saleDate, Integer storeId,BoutiqueSource source);
	
	/**
	 * 查询指定年份的所有目标设定
	 * @param year
	 * @param member
	 * @return
	 */
	List<Map<String, Object>> selectTargetByYear(String year, Employee member);

	int addOrUpdateTargetByYear(String target, Employee member);

	int deleteTargetById(Integer id);
}
