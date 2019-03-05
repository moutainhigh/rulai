package com.unicdata.service.boutique;

import java.math.BigDecimal;

public interface PackageIncludeSupportService extends BoutiquePackageIncludeService {

	BigDecimal sumPackageCountValue(Integer packId);

}
