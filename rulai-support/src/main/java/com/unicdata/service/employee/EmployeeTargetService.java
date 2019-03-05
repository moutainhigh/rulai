package com.unicdata.service.employee;

import com.unicdata.entity.system.EmployeeTarget;

import java.util.List;
import java.util.Map;

/**
 * 员工销售目标
 *
 * @author admin
 */
public interface EmployeeTargetService {

    int insertSelective(EmployeeTarget record);

    int updateByPrimaryKeySelective(EmployeeTarget record);

    /**
     * 获取本月销售订单目标
     *
     * @param employeeId
     * @return
     */
    EmployeeTarget getCurrentMothTarget(Integer employeeId);

    /**
     * 根据门店id获取目标
     *
     * @param map
     * @return
     */
    List<EmployeeTarget> selectEmployeeTargetByStoreId(Map<String, Object> map);

    /**
     * 根据门店id获取目标总数
     *
     * @param map
     * @return
     */
    Map<String, Object> getMothTargetNumByStoreId(Map<String, Object> map);

    /**
     * 根据条件获取员工目标
     *
     * @param param
     * @return
     */
    List<Map<String, Object>> saleManTarget(Map param);

    /**
     * 根据员工id和目标周期获取员工目标
     *
     * @param param
     * @return
     */
    EmployeeTarget employeeIdTarget(Map param);
}
