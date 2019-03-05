package com.unicdata.dao.product;

import com.unicdata.entity.product.InsuranceTypePrice;
import com.unicdata.entity.product.InsuranceTypePriceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface InsuranceTypePriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceTypePrice record);

    int insertSelective(InsuranceTypePrice record);

    List<InsuranceTypePrice> selectByExample(InsuranceTypePriceExample example);

    InsuranceTypePrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InsuranceTypePrice record);

    int updateByPrimaryKey(InsuranceTypePrice record);

    void deleteByInsuranceIdAndStoreId(@Param("insuranceIds") List<Integer> insuranceIds, @Param("storeId") Integer storeId);

    /**
     * 按照参数获取下面的费率设置
     * @param params
     * @return
     */
    List<InsuranceTypePrice> selectPrices(Map<String,Object> params);
}