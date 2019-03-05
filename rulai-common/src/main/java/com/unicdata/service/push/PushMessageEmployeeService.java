package com.unicdata.service.push;

import com.unicdata.entity.push.PushMessageEmployee;

import java.util.List;
import java.util.Map;

public interface PushMessageEmployeeService {

    /**
     * 根据员工ID获取他所有未读的推送消息
     *
     * @param employeeId
     * @return
     */
    List<Map<String, Object>> listByEmployeeId(Integer employeeId);

    /**
     * 根据推送消息ID和用户ID获取推送消息
     *
     * @param messageId
     * @param employeeId
     * @return
     */
    PushMessageEmployee getByEmployeeIdAndMessageId(Integer messageId, Integer employeeId);

    /**
     * 修改
     *
     * @param pushMessageEmployee
     */
    int updateSelective(PushMessageEmployee pushMessageEmployee);

}
