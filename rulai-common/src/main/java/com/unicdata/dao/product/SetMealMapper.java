package com.unicdata.dao.product;

import com.github.pagehelper.Page;
import com.unicdata.entity.product.SetMeal;
import com.unicdata.entity.product.SetMealExample;
import java.util.List;
import java.util.Map;

public interface SetMealMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SetMeal record);

    int insertSelective(SetMeal record);

    List<SetMeal> selectByExample(SetMealExample example);

    SetMeal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SetMeal record);

    int updateByPrimaryKey(SetMeal record);

    /**
     * 根据参数获取分页列表
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String,Object> params);
}