package com.unicdata.service.boutique;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.boutique.CheckItem;
import com.unicdata.entity.boutique.DepotCheck;

import java.util.List;
import java.util.Map;

public interface DepotCheckService {

    /**
     * 根据参数获取盘点单列表
     *
     * @param params
     * @param pageNumber
     * @param pageSize
     * @return
     */
    PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize);

    /**
     * 根据ID获取盘点单
     *
     * @param checkId
     * @return
     */
    DepotCheck getCheckById(Integer checkId);


    /**
     * 根据盘点单ID获取盘点项
     *
     * @param checkId
     * @return
     */
    List<Map<String, Object>> getCheckItemsByCheckId(Integer checkId);


    /**
     * 根据仓库ID集合获取盘点项
     *
     * @param warehouseIds
     * @return
     */
    List<Map<String, Object>> getCheckItemsByWarehouseIds(String warehouseIds);

    /**
     * 保存盘点单
     *
     * @param depotCheck
     */
    int save(DepotCheck depotCheck);

    /**
     * 盘点单作废
     *
     * @param check
     */
    void scrap(DepotCheck check);

    /**
     * 根据盘点单编号获取盘点单(已确认的盘点单)
     *
     * @param number
     * @return
     */
    DepotCheck getCheckByNumber(String number);

    /**
     * 根据盘点单ID获取盘点差异列表
     *
     * @param checkId
     * @return
     */
    Map<String, Object> getDifferenceByCheckId(Integer checkId);

    /**
     * 库存调整
     *
     * @param items
     */
    void updateDepot(List<CheckItem> items) throws Exception;
}
