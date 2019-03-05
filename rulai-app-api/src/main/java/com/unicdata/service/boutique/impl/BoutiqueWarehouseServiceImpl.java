package com.unicdata.service.boutique.impl;

import com.unicdata.dao.boutique.BoutiqueWarehouseMapper;
import com.unicdata.entity.boutique.BoutiqueWarehouse;
import com.unicdata.service.boutique.BoutiqueWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/6/8.
 */
@Service
public class BoutiqueWarehouseServiceImpl implements BoutiqueWarehouseService {
    @Autowired
    private BoutiqueWarehouseMapper boutiqueWarehouseMapper;

    @Override
    public List<BoutiqueWarehouse> findAll(Integer storeId) {
        return boutiqueWarehouseMapper.findAll(storeId);
    }
}
