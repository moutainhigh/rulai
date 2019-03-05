package com.unicdata.service.area.impl;

import com.unicdata.dao.basedata.CityMapper;
import com.unicdata.dao.basedata.DistrictMapper;
import com.unicdata.dao.basedata.ProvinceMapper;
import com.unicdata.entity.basedata.*;
import com.unicdata.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AreaServiceImpl implements AreaService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<Province> provinces() {
        ProvinceExample example = new ProvinceExample();
        ProvinceExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("order_by");
        return provinceMapper.selectByExample(example);
    }

    @Override
    public List<City> CitiesByProvinceId(Integer provinceId) {
        CityExample example = new CityExample();
        CityExample.Criteria criteria = example.createCriteria();
        criteria.andProvinceIdEqualTo(provinceId);
        example.setOrderByClause("order_by");
        return cityMapper.selectByExample(example);
    }

    @Override
    public List<District> DistrictsByCityId(Integer cityId) {
        DistrictExample example = new DistrictExample();
        DistrictExample.Criteria criteria = example.createCriteria();
        criteria.andCityIdEqualTo(cityId);
        return districtMapper.selectByExample(example);
    }

	@Override
	public Integer getIdByName(String name, int level, Integer parentId) {
		if(level == 1){
			ProvinceExample example = new ProvinceExample();
	        ProvinceExample.Criteria criteria = example.createCriteria();
	        criteria.andProvinceNameEqualTo(name);
	        List<Province> list = provinceMapper.selectByExample(example);
	        if(list!=null && list.size()>0){
	        	return list.get(0).getId();
	        }
		}else if(level == 2){
			CityExample example = new CityExample();
	        CityExample.Criteria criteria = example.createCriteria();
	        if(parentId!=null)
	        	criteria.andProvinceIdEqualTo(parentId);
	        criteria.andCityNameEqualTo(name);
	        List<City> list = cityMapper.selectByExample(example);
	        if(list!=null && list.size()>0){
	        	return list.get(0).getId();
	        }
		}else if(level == 3){
			DistrictExample example = new DistrictExample();
	        DistrictExample.Criteria criteria = example.createCriteria();
	        if(parentId!=null)
	        	criteria.andCityIdEqualTo(parentId);
	        criteria.andDistrictNameEqualTo(name);
	        List<District> list = districtMapper.selectByExample(example);
	        if(list!=null && list.size()>0){
	        	return list.get(0).getId();
	        }
		}
		return null;
	}
}
