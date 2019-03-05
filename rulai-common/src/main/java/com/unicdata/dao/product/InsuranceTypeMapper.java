package com.unicdata.dao.product;

import com.unicdata.entity.product.InsuranceType;
import com.unicdata.entity.product.InsuranceTypeExample;
import java.util.List;
import java.util.Map;

public interface InsuranceTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceType record);

    int insertSelective(InsuranceType record);

    List<InsuranceType> selectByExample(InsuranceTypeExample example);

    InsuranceType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InsuranceType record);

    int updateByPrimaryKey(InsuranceType record);

    //查子险种 wp
    List<Map<String, Object>> selectChildTypes(Integer parentId);
    //查险种 wp
    List<Map<String, Object>> selectTypes();
    List<Map<String, Object>> selectChildTypeList(Map<String, Object> params);
    List<Map<String, Object>> selectInsuredAmounts(Map<String, Object> params);
}