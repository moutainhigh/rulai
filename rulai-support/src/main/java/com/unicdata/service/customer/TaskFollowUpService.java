package com.unicdata.service.customer;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.customer.TaskFollowUp;

import java.util.List;
import java.util.Map;

public interface TaskFollowUpService {
    /**
     * 根据客户ID 和日期等参数获取跟进信息
     * @param customerId
     * @param date("yyyy-MM-dd")
     * @return
     */
    List<TaskFollowUp> getTaskFollowUpsBy(Integer customerId,String date);

    /**
     * 获取客户下一次的跟进时间
     * @return
     */
    String getLastFollowTime(Integer customerId);

    /**
     * 保存客户跟进信息并返回客户所有的跟进信息
     * @return
     */
    void save(TaskFollowUp taskFollowUp);

    /**
     * 根据参数获取(潜客跟进/潜客邀约)分页列表
     *
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 根据参数获取(订单跟进/今日交车/后续服务)分页列表
     *
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams2(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 获取本月待交车车辆数
     * @param params
     * @return
     */
    int selectCountByStore(Map<String, Object> params);
}
