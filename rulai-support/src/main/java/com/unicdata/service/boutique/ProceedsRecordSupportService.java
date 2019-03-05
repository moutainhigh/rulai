package com.unicdata.service.boutique;

import java.util.Map;

public interface ProceedsRecordSupportService extends BoutiqueProceedsRecordService{

	Map<String, Object> selectByRetail(Integer orderId, Integer type);

}
