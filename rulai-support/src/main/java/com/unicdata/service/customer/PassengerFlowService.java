package com.unicdata.service.customer;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.customer.PassengerFlow;
import com.unicdata.entity.customer.PassengerFlowDto;

import java.util.List;
import java.util.Map;

/**
 * @author wp
 */
public interface PassengerFlowService {

    /**
     * 客流数量信息 wp
     */
    List<PassengerFlow> selectPassengerFlowMes(PassengerFlow passengerFlow);

    /**
     * 添加客流信息 wp
     */
    int addPassengerFlow(PassengerFlow passengerFlow);

    /**
     * 更新客流表
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(PassengerFlow record);

    /**
     * 替岗换销售 wp
     */
    int changeSellMan(PassengerFlow passengerFlow);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(PassengerFlow record);

    /**
     * 根据月份获取客流
     * @param map
     * @return
     */
    int getMouthPassengerFlowList(Map<String, Object> map);

    /**
     * 获取员工当月客流目标完成数
     */
    int thisMonthPassengerFlow(Map<String,Object> params);

    /**
     * 获取当月首次客流数
     */
    int thisMonthFirstPassengerFlow(Map<String,Object> params);

    /**
     * pc端客流列表
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<PassengerFlowDto> selectFlowListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);
}
