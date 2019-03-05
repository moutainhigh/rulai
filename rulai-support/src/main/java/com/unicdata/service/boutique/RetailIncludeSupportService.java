package com.unicdata.service.boutique;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface RetailIncludeSupportService extends BoutiqueRetailIncludeService{

	List<Map<String, Object>> selectListByRetail(Integer retailId);
}
