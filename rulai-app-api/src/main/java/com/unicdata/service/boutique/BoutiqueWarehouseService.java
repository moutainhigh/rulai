package com.unicdata.service.boutique;

import com.unicdata.entity.boutique.BoutiqueWarehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/6/8.
 */
public interface BoutiqueWarehouseService {
    List<BoutiqueWarehouse> findAll(@Param("storeId")Integer storeId);
}
