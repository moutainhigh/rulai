package com.unicdata.service.product;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.product.Insurer;

import java.util.List;
import java.util.Map;

public interface InsurerService {

    /**
     * 根据参数获取保险公司列表
     *
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 保存保险公司
     *
     * @param insurer
     */
    void save(Insurer insurer);

    /**
     * 根据ID获取保险公司详情
     *
     * @param insurerId
     * @return
     */
    Insurer getInsurerById(Integer insurerId);

    /**
     * 根据保险公司名称和店铺id获取保险公司
     *
     * @param storeId
     * @param name
     * @return
     */
    Insurer selectByNameAndStoreId(Integer storeId, String name);
}
