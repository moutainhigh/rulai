package com.unicdata.service.insurer.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicdata.dao.car.CarGoodInfoMapper;
import com.unicdata.dao.product.InsuranceExtensionMapper;
import com.unicdata.service.insurer.InsuranceExtensionService;

/**
 * 延保服务层
 * @author admin
 *
 */
@Service
public class InsuranceExtensionServiceImpl implements InsuranceExtensionService {

    @Autowired
    private InsuranceExtensionMapper insuranceExtensionMapper;
    @Autowired
    private CarGoodInfoMapper carGoodInfoMapper;

    @Transactional(readOnly=true)
	public List<Map<String,Object>> selectListByMap(Integer storeId,Integer familyId) {
//    	Map<String,Object> car = carGoodInfoMapper.getCarDetailById(carId);
    	Map<String,Object> params = new HashMap<String, Object>();
    	params.put("storeId", 1);
//    	String familyId = "0";
//    	if(car != null){
//    		familyId = String.valueOf(car.get("familyId"));
//    	}
    	params.put("familyId", familyId);
    	List<Map<String,Object>> list = insuranceExtensionMapper.selectListByMap(params);
		return list;
	}
}
