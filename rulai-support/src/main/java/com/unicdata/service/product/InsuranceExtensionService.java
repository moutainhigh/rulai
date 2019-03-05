package com.unicdata.service.product;

import com.github.pagehelper.PageInfo;
import com.unicdata.dao.product.InsuranceExtensionMapper;
import com.unicdata.entity.product.InsuranceExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface InsuranceExtensionService {

    /**
     * 根据参数获取延保套餐列表
     *
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 保存延保套餐
     *
     * @param insuranceExtension
     */
    void save(InsuranceExtension insuranceExtension);

    /**
     * 根据ID获取延保公司
     *
     * @param insuranceExtensionId
     * @return
     */
    InsuranceExtension getInsuranceExtensionById(Integer insuranceExtensionId);

    /**
     * 根据店铺获取车系下拉框
     *
     * @param storeId
     * @return
     */
    List<Map<String, Object>> getCarFamilyByStoreId(Integer storeId);

    /**
     * 根据店铺ID和套餐名获取延保套餐
     *
     * @param storeId
     * @param name
     * @return
     */
    InsuranceExtension selectByNameAndStoreId(Integer storeId, String name);
}
