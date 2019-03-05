package com.unicdata.dao.car;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.unicdata.entity.car.CarPurchaseOrder;

public interface CarPurchaseOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarPurchaseOrder record);

    int insertSelective(CarPurchaseOrder record);

    CarPurchaseOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarPurchaseOrder record);

    int updateByPrimaryKey(CarPurchaseOrder record);

	Page<Map<String, Object>> selectListByStore(Integer distributorStoreId);
	//采购清单 wp
	List<Map<String, Object>> carPurchaseList(Map<String, Object> map);
	//采购单下的汽车 wp
	List<Map<String, Object>> selectCarByPurchaseId(Map<String, Object> map);
	//入库历史 wp
	List<Map<String, Object>> ruKuHistoryList(Map<String , Object> map);
	//采购清单汽车检测状态 wp
	Map<String, Object> checkStatus(Map<String, Object> map);
}