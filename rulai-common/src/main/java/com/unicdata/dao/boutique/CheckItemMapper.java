package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.CheckItem;
import com.unicdata.entity.boutique.CheckItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CheckItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckItem record);

    int insertSelective(CheckItem record);

    List<CheckItem> selectByExample(CheckItemExample example);

    CheckItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckItem record);

    int updateByPrimaryKey(CheckItem record);

    /**
     * 根据参数获取盘点项集合
     *
     * @param checkId
     * @param gain
     * @return
     */
    List<Map<String, Object>> getCheckItemsByParams(@Param("checkId") Integer checkId, @Param("gain") Boolean gain);

    /**
     * 根据盘点单ID删除盘点项
     *
     * @param checkId
     */
    void deleteByCheckId(Integer checkId);
}