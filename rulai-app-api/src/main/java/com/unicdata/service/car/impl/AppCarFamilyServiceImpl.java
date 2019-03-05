package com.unicdata.service.car.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.car.CarFamilyMapper;
import com.unicdata.dao.carInfo.UnicdataFamilyMapper;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.entity.carInfo.UnicdataFamily;
import com.unicdata.service.car.AppCarFamilyService;

@Service
public class AppCarFamilyServiceImpl implements AppCarFamilyService {

    @Autowired
    private CarFamilyMapper carFamilyMapper;
    @Autowired
    private UnicdataFamilyMapper unicdataFamilyMapper;

    public int insertSelective(CarFamily record) {
        return carFamilyMapper.insertSelective(record);
    }

    public CarFamily selectByPrimaryKey(Integer id) {
        return carFamilyMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(CarFamily record) {
        return carFamilyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<Map<String, Object>> selectListByBrandId(Map<String, Object> map, Integer pageSize,
                                                             Integer pageNum) {
        if (null != pageSize && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        Page<Map<String, Object>> maps1 = new Page<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("name", "默认");
        objectHashMap.put("id", "0");
        maps1.add(0, objectHashMap);
        Page<Map<String, Object>> maps = carFamilyMapper.selectListByBrandId(map);
        maps1.addAll(maps);
        return maps1.toPageInfo();
    }

	@Override
	public List<Map<String, Object>> selectListByStoreId(Integer storeId) {
		return carFamilyMapper.selectListByStoreId(storeId);
	}

	@Override
	public String getUnicdataFamilyById(Integer id) {
		UnicdataFamily uf = unicdataFamilyMapper.selectByFamilyId(id);
		return uf!=null?uf.getFamilyName():"";
	}

}
