package com.unicdata.service.boutique;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by lenovo on 2018/6/8.
 */
public interface BoutiqueSupplierService {
    Page<Map<String, Object>> selectSupplier(@Param("name")String name, @Param("storeId")Integer storeId);
}
