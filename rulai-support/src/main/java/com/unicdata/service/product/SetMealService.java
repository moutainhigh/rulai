package com.unicdata.service.product;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.product.SetMeal;

import java.util.List;
import java.util.Map;

public interface SetMealService {

    /**
     * 根据条件查询套餐代金券列表
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 保存套餐/代金券
     * @param setMeal
     */
    void save(SetMeal setMeal);

    /**
     * 根据ID获取套餐/代金券
     * @param id
     * @return
     */
    SetMeal getSetMealById(Integer id);

    /**
     * 根据套餐代金券名称和店铺id获取保险公司
     *
     * @param storeId
     * @param name
     * @return
     */
    SetMeal selectByNameAndStoreId(Integer storeId, String name);
}
