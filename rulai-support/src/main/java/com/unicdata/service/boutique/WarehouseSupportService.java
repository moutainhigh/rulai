package com.unicdata.service.boutique;

public interface WarehouseSupportService extends BoutiqueWarehouseService{

    /**
     * 根据id集合查询精品仓库名字集合（用逗号隔开）
     * @param ids
     * @return
     */
    String findNamesByIds(String ids);

}
