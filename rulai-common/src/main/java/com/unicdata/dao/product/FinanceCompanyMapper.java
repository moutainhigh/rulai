package com.unicdata.dao.product;

import com.github.pagehelper.Page;
import com.unicdata.entity.product.FinanceCompany;
import com.unicdata.entity.product.FinanceCompanyExample;
import java.util.List;
import java.util.Map;

public interface FinanceCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinanceCompany record);

    int insertSelective(FinanceCompany record);

    List<FinanceCompany> selectByExample(FinanceCompanyExample example);

    FinanceCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinanceCompany record);

    int updateByPrimaryKey(FinanceCompany record);

    /**
     * 根据参数获取分页列表
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String,Object> params);

	FinanceCompany selectByName(Map<String, Object> params);

    public List<Map<String, Object>> selectFinanceYears(Map<String, Object> params);
}