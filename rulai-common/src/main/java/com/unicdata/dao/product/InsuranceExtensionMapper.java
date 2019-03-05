package com.unicdata.dao.product;

import com.github.pagehelper.Page;
import com.unicdata.entity.product.InsuranceExtension;
import com.unicdata.entity.product.InsuranceExtensionExample;
import java.util.List;
import java.util.Map;

public interface InsuranceExtensionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceExtension record);

    int insertSelective(InsuranceExtension record);

    List<InsuranceExtension> selectByExample(InsuranceExtensionExample example);

    InsuranceExtension selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InsuranceExtension record);

    int updateByPrimaryKey(InsuranceExtension record);

    /**
     * 根据参数获取分页列表
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String,Object> params);

    /**
     * 将记录的cost值清空
     * @param id
     * @return
     */
    int updateCostNull(Integer id);

    List<Map<String,Object>> selectListByMap(Map<String,Object> params);
}