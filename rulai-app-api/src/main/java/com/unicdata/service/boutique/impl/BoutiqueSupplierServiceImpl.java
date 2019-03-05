package com.unicdata.service.boutique.impl;

import com.github.pagehelper.Page;
import com.unicdata.dao.boutique.BoutiqueSupplierMapper;
import com.unicdata.service.boutique.BoutiqueSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by lenovo on 2018/6/8.
 */
@Service
public class BoutiqueSupplierServiceImpl implements BoutiqueSupplierService {
    @Autowired
    private BoutiqueSupplierMapper boutiqueSupplierMapper;

    @Override
    public Page<Map<String, Object>> selectSupplier(String name, Integer storeId) {
        return boutiqueSupplierMapper.selectSupplier(name, storeId);
    }
}
