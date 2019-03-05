package com.unicdata.service.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.product.MealItemMapper;
import com.unicdata.dao.product.SetMealMapper;
import com.unicdata.entity.product.MealItem;
import com.unicdata.entity.product.MealItemExample;
import com.unicdata.entity.product.SetMeal;
import com.unicdata.entity.product.SetMealExample;
import com.unicdata.service.product.SetMealService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class SetMealServiceImpl implements SetMealService {

    @Autowired
    private SetMealMapper setMealMapper;

    @Autowired
    private MealItemMapper mealItemMapper;

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return setMealMapper.selectListByParams(params).toPageInfo();
    }

    @Transactional(readOnly = false)
    @Override
    public void save(SetMeal setMeal) {
        Integer mealId = setMeal.getId();
        if (setMeal.getId() == null) {//新增
            if (this.selectByNameAndStoreId(setMeal.getStoreId(), setMeal.getName()) != null) {
                throw new RuntimeException("该套餐/代金券已存在，请勿重复添加");
            }
            setMeal.setCreateTime(new Date());
            setMeal.setModifyTime(new Date());
            setMealMapper.insertSelective(setMeal);
            mealId = setMeal.getId();
        } else {//修改
            setMeal.setModifyTime(new Date());
            setMealMapper.updateByPrimaryKeySelective(setMeal);
            //如果是套餐
            if (setMeal.getType() == 1) {
                mealItemMapper.deleteByMealId(setMeal.getId());
            }
        }
        //如果是套餐
        if (setMeal.getType() == 1) {
            for (MealItem item : setMeal.getMealItems()) {
                item.setMealId(mealId);
                mealItemMapper.insert(item);
            }
        }
    }

    @Override
    public SetMeal getSetMealById(Integer id) {
        SetMeal meal = setMealMapper.selectByPrimaryKey(id);
        if (meal != null) {
            MealItemExample example = new MealItemExample();
            MealItemExample.Criteria criteria = example.createCriteria();
            criteria.andMealIdEqualTo(id);
            example.setOrderByClause("id desc");
            List<MealItem> mealItems = mealItemMapper.selectByExample(example);
            meal.setMealItems(mealItems);
        }
        return meal;
    }

    @Override
    public SetMeal selectByNameAndStoreId(Integer storeId, String name) {
        SetMealExample example = new SetMealExample();
        SetMealExample.Criteria criteria = example.createCriteria();
        criteria.andStoreIdEqualTo(storeId);
        criteria.andNameEqualTo(name);
        List<SetMeal> setMeals = setMealMapper.selectByExample(example);
        if (setMeals.isEmpty() || setMeals == null) {
            return null;
        } else {
            return setMeals.get(0);
        }
    }
}
