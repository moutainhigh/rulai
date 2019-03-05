package com.unicdata.service.boutique;

import com.unicdata.entity.boutique.BoutiqueProceedsRecord;

public interface BoutiqueProceedsRecordService {

	int insertSelective(BoutiqueProceedsRecord record);

	int updateByPrimaryKeySelective(BoutiqueProceedsRecord record);

}
