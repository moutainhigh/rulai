package com.unicdata.service.boutique;

import com.unicdata.entity.boutique.BoutiqueRetailIncludePackDivision;

public interface RetailIncludePackDivisionSupportService {

	BoutiqueRetailIncludePackDivision selectByIncludeIdAndBoutiqueId(Integer id, Integer id2);

}
