package com.unicdata.service.passengerflow;

import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.EntranceGuardRemind;
import com.unicdata.entity.customer.PassengerFlow;

import java.util.List;
import java.util.Map;

/**
 * @author wp
 */
public interface PassengerFlowService {

    /**
     * 分页获取客流列表
     *
     * @param record
     * @return
     */
    Map<String, Object> getPassengerFlowList(Integer pageNum, Integer pageSize, PassengerFlow record);

    /**
     * 根据条件查询客流
     * @param record
     * @return
     */
    Map<String, Object> selectByCondition(PassengerFlow record);
    
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
     * 修改客流离店信息
     * @param record
     * @return
     */
    int updateLeaveShop(PassengerFlow record);

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
     * 根据车牌号获取顾客信息 wp
     * @param licensePlate
     * @return
     */
    Map<String, Object> selectCustomerByLicensePlate(Map<String, Object> map);
    /**
     * 获取未接待、正接待的客流 wp
     * @param map
     * @return
     */
    List<Map<String, Object>> selectDoingPassengerFlow(Map<String , Object> map);
    //通过ID查客流信息 wp
    PassengerFlow getPassengerFlowById(Integer id);
    //换岗为null wp
    int changeRepalceNull(PassengerFlow passengerFlow);
    
    PassengerFlow selectByPrimaryKey(Integer id);
    //获取门禁信息 wp
    List<Map<String, Object>> selectDoorRemindMes(Map<String, Object> map);
    // 将二次到店的门禁信息存入
    int insertDoorRemindMes(EntranceGuardRemind entranceGuardRemind);
    /**
     * 意向车型 wp
     */
    Map<String, Object> selectAttentionCarFamily(Map<String, Object> map);
    
    int updateReplacePostData(PassengerFlow passengerFlow);
    //客流处理试驾状态 wp
    Map<String, Object> testStatus(Map<String, Object> map);
    //变更客户表替岗、换销售后的员工ID
    int updateCustomerEmp(Customer customer);
    
}
