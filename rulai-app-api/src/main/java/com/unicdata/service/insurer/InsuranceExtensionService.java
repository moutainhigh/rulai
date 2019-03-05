package com.unicdata.service.insurer;

import java.util.List;
import java.util.Map;

/**
 * 延保service
 * @author admin
 *
 */
public interface InsuranceExtensionService  {
	/**
	 * 获取延保列表
	 * @param record
	 * @return
	 */
	List<Map<String,Object>> selectListByMap(Integer storeId,Integer familyId);
}
