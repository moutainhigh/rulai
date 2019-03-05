package com.unicdata.service.car;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.car.CarAllotApplication;

/**
 * 车辆调拨申请
 * 
 * @author wxn
 * @date 2018年6月4日
 */
public interface CarAllotApplicationService {
	int insertSelective(CarAllotApplication record);

	CarAllotApplication selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(CarAllotApplication record);

	int updateByPrimaryKeyWithBLOBs(CarAllotApplication record);
	
	PageInfo<Map<String, Object>> selectListByStore(Integer distributorStoreId, Integer pageSize, Integer pageNum);
}
