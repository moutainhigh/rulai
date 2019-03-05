package com.unicdata.service.boutique;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.condition.BoutiqueInstallCondition;

public interface BoutiqueInstallService {

	/**
	 * 条件分页查询精品加装排程
	 * @param condition
	 * @return
	 */
	PageInfo<Map<String, Object>> selectInstallByCondition(BoutiqueInstallCondition condition);
	
}
