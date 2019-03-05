package com.unicdata.service.boutique.impl;

import com.unicdata.dao.boutique.BoutiqueWarehouseMapper;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.service.boutique.WarehouseSupportService;

import java.util.List;

@Service
public class WarehouseSupportServiceImpl extends BoutiqueWarehouseServiceImpl implements WarehouseSupportService {


    @Autowired
    private BoutiqueWarehouseMapper warehouseMapper;

    @Override
    public String findNamesByIds(String ids) {
        if (StringUtils.isBlank(ids)) {
            return null;
        }
        List<Integer> list = Lists.newArrayList();
        for(String id:ids.trim().split(",")){
            list.add(Integer.valueOf(id));
        }
        List<String> names = warehouseMapper.getNamesByIds(list);
        return StringUtils.join(names,",");
    }

}
