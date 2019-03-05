package com.unicdata.service.policy;

import com.github.pagehelper.PageInfo;
import com.unicdata.conditon.RebateProjectCondition;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.policy.RebateProject;
import com.unicdata.entity.policy.RebateProjectExample;
import io.swagger.models.auth.In;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 返利项目service
 * Created by shenyong on 2018/6/3.
 */
public interface RebateProjectService {

    int deleteByPrimaryKey(Integer id);

    int insert(RebateProject record);

    int insertSelective(RebateProject record);

    List<RebateProject> selectByExample(RebateProjectExample example);

    RebateProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RebateProject record);

    int updateByPrimaryKey(RebateProject record);

    /**
     * 根据商务政策id获取其所有返利项目
     * @param policyId
     * @return
     */
    List<RebateProject> selectRebate(Integer policyId);

    /**
     * 保存返利项目
     * @param rp
     * @return
     * @throws ParseException
     */
    Integer saveRebate(RebateProject rp) throws ParseException;

    /**
     * 修改返利项目
     * @param rp
     * @return
     */
    Integer updateRebate(RebateProject rp);

    List<CarGoodInfo> selectCarInfo(RebateProject rp);

    /**
     * 查询车辆信息
     * @param rp
     * @return
     */
    PageInfo<List<CarGoodInfo>> selectCarInfoPage(RebateProject rp,Integer pageNum, Integer pageSize);

    /**
     * 计算该返利项目各个金额总计
     * @param rebateId
     * @return
     */
    int calcRebateTotalMoney(Integer rebateId);


    RebateProject selectRebateById(Integer id);

    /**
     * 计算车辆计提金额（在DMS上报和车辆全款时调用）
     * @param carId
     * @return
     */
    int executeCarPlanExtraction(Integer carId);

    /**
     * 采购单入库时 计算车辆适合的返利项目并加入到返利项目中
     * @param carId
     * @return
     */
    void inStorageCarRebateProject(Integer carId);

    /**
     * 查询返利项目修改明细 核对单、到账单明细
     * @param rebateId
     * @return
     */
    RebateProjectCondition selectDetail(Integer rebateId);
}
