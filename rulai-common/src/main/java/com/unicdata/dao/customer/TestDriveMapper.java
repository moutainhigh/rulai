package com.unicdata.dao.customer;

import com.unicdata.entity.customer.TestDrive;
import com.unicdata.entity.customer.TestDriveExample;

import java.util.List;
import java.util.Map;

public interface TestDriveMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(TestDrive record);

	int insertSelective(TestDrive record);

	List<TestDrive> selectByExample(TestDriveExample example);

	TestDrive selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(TestDrive record);

	int updateByPrimaryKey(TestDrive record);

	List<Map<String, Object>> selectByCusId(Map<String, Object> map);

	/**
	 * 获取员工本月完成的试驾数
	 * 
	 * @param params
	 * @return
	 */
	int getCurrentMothTestDrive(Map<String, Object> params);

	/**
	 * 根据map条件查询
	 * 
	 * @param params
	 * @return
	 */
	public TestDrive getTestDrivesByMap(Map<String, Object> params);

	// 选ID
	Map<String, Object> selectTestDriveId(Map<String, Object> map);

	public List<TestDrive> getTestDriveListByMap(Map<String, Object> params);

	/**
	 * 获取试驾车的试驾记录
	 * 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selectByCarId(Integer testCarId);
}