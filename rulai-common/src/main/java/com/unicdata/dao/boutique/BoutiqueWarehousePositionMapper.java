package com.unicdata.dao.boutique;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.unicdata.entity.boutique.BoutiqueWarehousePosition;
import com.unicdata.entity.boutique.BoutiqueWarehousePositionExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BoutiqueWarehousePositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueWarehousePosition record);

    int insertSelective(BoutiqueWarehousePosition record);

    List<BoutiqueWarehousePosition> selectByExample(BoutiqueWarehousePositionExample example);

    BoutiqueWarehousePosition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueWarehousePosition record);

    int updateByPrimaryKey(BoutiqueWarehousePosition record);

	int deleteByWarehouseId(@Param("warehouseId")Integer warehouseId);

	List<BoutiqueWarehousePosition> findAllByWarehouseId(@Param("warehouseId")Integer warehouseId,@Param("storeId")Integer storeId);

	int deleteById(@Param("id")Integer id);

	Page<Map<String, Object>> selectWarehousePositionAllPage(@Param("warehouseId")Integer warehouseId,@Param("storeId")Integer storeId);

    BoutiqueWarehousePosition selectByName(String name);
}