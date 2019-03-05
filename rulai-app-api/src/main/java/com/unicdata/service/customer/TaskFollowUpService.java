package com.unicdata.service.customer;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.customer.TaskFollowUp;

/**
 * 任务跟进service
 * @author admin
 *
 */
public interface TaskFollowUpService  {
	/**
	 * 根据条件获取列表
	 * @param pageNum
	 * @param pageSize
	 * @param taskFollowUp
	 * @return
	 */
	PageInfo selectListByExample(Integer pageNum, Integer pageSize,TaskFollowUp taskFollowUp);
	
	/**
	 * 根据用户获取任务数量
	 * @param employeeId
	 * @return
	 */
    Map<String,Object> getTaskNumByEmployee(Integer employeeId);

	/**
	 * 根据客户id及日期查询跟进信息
	 * @param map
	 * @return
	 */
	public TaskFollowUp selectTaskByMap(Map<String,Object> map);
	
	/**
	 * 根据客户id获取未来任务日期
	 * @param map
	 * @return
	 */
	public List<Map<String,Object>> selectTaskDateList(Integer cusId);
	
	/**
	 * 添加任务跟进记录
	 * @param taskFollowUp
	 * @return
	 */
	public int addTaskFollowUpRecord(TaskFollowUp taskFollowUp);
	
	/**
	 * 跟进任务列表
	 * @param pageNum
	 * @param pageSize
	 * @param map
	 * @return
	 */
	PageInfo selectTaskList(Integer pageNum, Integer pageSize,Map<String,Object> map);

	/**
	 * 获取本月待交车车辆数
	 * @param params
	 * @return
	 */
	int selectCountByStore(Map<String, Object> params);
}
