package com.unicdata.dao.order;

import com.unicdata.entity.order.StoreService;
import com.unicdata.entity.order.StoreServiceExample;
import java.util.List;

public interface StoreServiceMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(StoreService record);

	int insertSelective(StoreService record);

	List<StoreService> selectByExample(StoreServiceExample example);

	StoreService selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(StoreService record);

	int updateByPrimaryKey(StoreService record);

}