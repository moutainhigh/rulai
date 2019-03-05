package com.unicdata.service.product;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.product.ExtensionInsuranceCompany;

import java.util.List;
import java.util.Map;

public interface ExtensionService {

    /**
     * 根据参数获取延保公司列表
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 保存延保公司
     * @param extension
     */
    void save(ExtensionInsuranceCompany extension);

    /**
     * 根据ID获取延保公司
     * @param extensionId
     * @return
     */
    ExtensionInsuranceCompany getExtensionById(Integer extensionId);

    /**
     * 根据延保公司名称和店铺id获取延保公司
     *
     * @param storeId
     * @param name
     * @return
     */
    ExtensionInsuranceCompany selectByNameAndStoreId(Integer storeId, String name);

    /**
     * 根据店铺ID获取所有延保公司
     * @return
     */
    List<ExtensionInsuranceCompany> getAll(Integer storeId);
}
