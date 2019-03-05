package com.unicdata.dao.product;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.product.InsuranceConnection;
import com.unicdata.entity.product.InsuranceConnectionExample;

public interface InsuranceConnectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceConnection record);

    int insertSelective(InsuranceConnection record);

    List<InsuranceConnection> selectByExample(InsuranceConnectionExample example);

    InsuranceConnection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InsuranceConnection record);

    int updateByPrimaryKey(InsuranceConnection record);

    /**
     * 根据保险公司ID删除关联表中的数据
     * @param insurerId
     */
    void deleteByInsurerId(Integer insurerId);
    
    InsuranceConnection getInsuranceConnectionByMap(Map<String,Object> params);
}