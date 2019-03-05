package com.unicdata.dao.boutique;

import com.github.pagehelper.Page;
import com.unicdata.entity.boutique.DepotCheck;
import com.unicdata.entity.boutique.DepotCheckExample;
import java.util.List;
import java.util.Map;

public interface DepotCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DepotCheck record);

    int insertSelective(DepotCheck record);

    List<DepotCheck> selectByExample(DepotCheckExample example);

    DepotCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DepotCheck record);

    int updateByPrimaryKey(DepotCheck record);

    /**
     * 根据盘点单编号获取盘点单
     * @param number
     * @return
     */
    DepotCheck getCheckByNumber(String number);

    /**
     * 根据参数获取分页列表
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String,Object> params);
}