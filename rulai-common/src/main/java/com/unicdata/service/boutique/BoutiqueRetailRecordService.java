package com.unicdata.service.boutique;

import com.unicdata.entity.boutique.BoutiqueRetailRecord;

public interface BoutiqueRetailRecordService {

	/**
	 * 精品经理审批后，添加审批记录
	 * @param record
	 * @return ID 如果返回值是0则添加失败
	 */
	int addRetailRecord(BoutiqueRetailRecord record);
	
	BoutiqueRetailRecord selectByPrimaryKey(Integer id);
	
}
