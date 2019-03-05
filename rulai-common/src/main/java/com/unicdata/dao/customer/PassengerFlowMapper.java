package com.unicdata.dao.customer;

import com.github.pagehelper.Page;
import com.unicdata.entity.customer.PassengerFlow;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.customer.PassengerFlowDto;
import com.unicdata.entity.customer.PassengerFlowExample;

public interface PassengerFlowMapper {

	List<PassengerFlow> selectByExample(PassengerFlowExample example);

	int deleteByPrimaryKey(Integer id);

    int insert(PassengerFlow record);

    int insertSelective(PassengerFlow record);

    PassengerFlow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PassengerFlow record);

    int updateByPrimaryKey(PassengerFlow record);
    
    Map<String, Object> selectByCondition(PassengerFlow record);

    //分页获取客流列表
    List<PassengerFlow> selectPassengerFlowMes(PassengerFlow record);
    List<Map<String, Object>> getPassengerFlowList(PassengerFlow record);

    //生成客流 wp
    int addPassengerFlow(PassengerFlow passengerFlow);

    //换销售 wp
    int changeSellMan(PassengerFlow passengerFlow);

    //根据月份获取客流
    int getMouthPassengerFlowList(Map<String, Object> map);

    //获取员工当月客流数量
    int thisMonthPassengerFlow(Map<String,Object> params);
    //获取二次到店顾客信息 wp
    Map<String, Object> selectCustomerByLicensePlate(Map<String, Object> map);
    //获取未接待、正接待的客流 wp
    List<Map<String, Object>> selectDoingPassengerFlow(Map<String , Object> map);
    //换岗为null wp
    int changeRepalceNull(PassengerFlow passengerFlow);
    
    int updateReplacePostData(Map<String,Object> params);

    int thisMonthFirstPassengerFlow(Map<String,Object> params);
    //客流处理试驾状态 wp
    Map<String, Object> testStatus(Map<String, Object> map);

    /**
     * pc 客流列表
     * @param params
     * @return
     */
    Page<PassengerFlowDto> selectFlowListByParams(Map<String,Object> params);
}