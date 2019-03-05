package com.unicdata.dao.product;

import com.unicdata.entity.product.MealItem;
import com.unicdata.entity.product.MealItemExample;
import java.util.List;

public interface MealItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MealItem record);

    int insertSelective(MealItem record);

    List<MealItem> selectByExample(MealItemExample example);

    MealItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MealItem record);

    int updateByPrimaryKey(MealItem record);

    /**
     * 根据套餐ID删除套餐项
     * @param mealId
     */
    void deleteByMealId(Integer mealId);
}