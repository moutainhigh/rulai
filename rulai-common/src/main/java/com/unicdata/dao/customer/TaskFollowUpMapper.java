package com.unicdata.dao.customer;

import com.github.pagehelper.Page;
import com.unicdata.entity.customer.TaskFollowUp;
import com.unicdata.entity.customer.TaskFollowUpExample;
import java.util.List;
import java.util.Map;

public interface TaskFollowUpMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(TaskFollowUp record);

    int insertSelective(TaskFollowUp record);

    List<TaskFollowUp> selectByExample(TaskFollowUpExample example);
    //通过客户 id获取跟进
    List<TaskFollowUp> selectByCustomerId(Integer customerId);

    TaskFollowUp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskFollowUp record);

    int updateByPrimaryKey(TaskFollowUp record);
    //根据用户获取任务数量
    Map<String,Object> getTaskNumByEmployee(Integer employeeId);

    List<Map<String, Object>> selectTaskList(Map<String, Object> map);

    /**
     * 根据参数获取(潜客跟进/潜客�?�?)分页列表
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String,Object> params);

    /**
     * 根据参数获取(订单跟进/今日交车/后续服务)分页列表
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams2(Map<String,Object> params);
    
    TaskFollowUp selectTaskByMap(Map<String,Object> params);
    
    int completeTask(TaskFollowUp record);

	int selectCountByStore(Map<String, Object> params);
}