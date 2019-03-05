package com.unicdata.service.customer.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.customer.PassengerFlowMapper;
import com.unicdata.entity.customer.PassengerFlow;
import com.unicdata.entity.customer.PassengerFlowDto;
import com.unicdata.service.customer.PassengerFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 客流服务层
 *
 * @author Administrator
 */
@Service
public class PassengerFlowServiceImpl implements PassengerFlowService {
    @Autowired
    private PassengerFlowMapper passengerFlowMapper;

    /**
     * 客流数量信息wp
     */
    public List<PassengerFlow> selectPassengerFlowMes(PassengerFlow passengerFlow) {
        return passengerFlowMapper.selectPassengerFlowMes(passengerFlow);
    }

    /**
     * 添加客流信息wp
     */
    public int addPassengerFlow(PassengerFlow passengerFlow) {
        passengerFlow.setCreateTime(new Date());
        return passengerFlowMapper.addPassengerFlow(passengerFlow);
    }

    @Override
    public int updateByPrimaryKey(PassengerFlow record) {
        return passengerFlowMapper.updateByPrimaryKey(record);
    }

    /**
     * 替岗换销售wp
     */
    public int changeSellMan(PassengerFlow passengerFlow) {
        return passengerFlowMapper.changeSellMan(passengerFlow);
    }


    @Override
    public int updateByPrimaryKeySelective(PassengerFlow record) {
        return passengerFlowMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int getMouthPassengerFlowList(Map<String, Object> map) {
        return passengerFlowMapper.getMouthPassengerFlowList(map);
    }

    @Override
    public int thisMonthPassengerFlow(Map<String, Object> params) {
        return passengerFlowMapper.thisMonthPassengerFlow(params);
    }

    @Override
    public int thisMonthFirstPassengerFlow(Map<String, Object> params) {
        return passengerFlowMapper.thisMonthFirstPassengerFlow(params);
    }

    @Override
    public PageInfo<PassengerFlowDto> selectFlowListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return passengerFlowMapper.selectFlowListByParams(params).toPageInfo();
    }
}
