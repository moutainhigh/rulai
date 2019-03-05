package com.unicdata.service.boutique.impl;

import com.unicdata.constant.BoutiqueEnum.NoYesType;
import com.unicdata.dao.boutique.BoutiqueRetailIncludeMapper;
import com.unicdata.entity.boutique.BoutiqueRetailInclude;
import com.unicdata.service.boutique.BoutiqueRetailIncludeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2018/6/14.
 */
@Service
public class BoutiqueRetailIncludeServiceImpl implements BoutiqueRetailIncludeService {
    @Autowired
    private BoutiqueRetailIncludeMapper boutiqueRetailIncludeMapper;

    @Override
    public int updateByPrimaryKeySelective(BoutiqueRetailInclude record) {
        return boutiqueRetailIncludeMapper.updateByPrimaryKeySelective(record);
    }

	@Override
	public int deleteBoutiqueRetailInclude(Map<String, Object> params) {
		return boutiqueRetailIncludeMapper.deleteByMap(params);
	}
	
	@Override
	public List<Map<String, Object>> selectOrderBoutiquePackageDetail(Integer orderId, Integer retailId,
			Integer packageId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("packageId", packageId);
		params.put("isPackage", NoYesType.YES.getCode());
		params.put("retailId", retailId);
		return boutiqueRetailIncludeMapper.getBoutiquePackageByMap(params);
	}

	@Override
	public Map<String, Object> selectOrderBoutiqueDetail(Integer orderId, Integer retailId, Integer boutiqueId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("informationId", boutiqueId);
		params.put("isPackage", NoYesType.NO.getCode());
		params.put("retailId", retailId);
		List<Map<String, Object>> list = boutiqueRetailIncludeMapper.getBoutiquePackageByMap(params);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
