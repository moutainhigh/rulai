package com.unicdata.service.car;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.unicdata.condition.CarCheckConditon;

@Service
public interface CarDepotCheckService {

	// 盘点列表
	PageInfo<Map<String, Object>> selectListByStore(CarCheckConditon carCheckConditon);
	// 盘点仓库
	List<String> selectWarehouseByNumber(String number);
	// 盘点车辆
	List<Map<String, Object>> selectCarByNumber(Integer storeId, String number);

}
