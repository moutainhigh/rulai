package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueWarehouse;
import com.unicdata.entity.boutique.BoutiqueWarehouseExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BoutiqueWarehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueWarehouse record);

    int insertSelective(BoutiqueWarehouse record);

    List<BoutiqueWarehouse> selectByExample(BoutiqueWarehouseExample example);

    BoutiqueWarehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueWarehouse record);

    int updateByPrimaryKey(BoutiqueWarehouse record);

	List<BoutiqueWarehouse> findAll(@Param("storeId")Integer storeId);

	int deleteById(@Param("id")Integer id);

    /**
     * 根据Ids获取仓库名
     * @param ids
     * @return
     */
    List<String> getNamesByIds(List<Integer> ids);

	BoutiqueWarehouse selectWarehouseByName(@Param("name")String name,@Param("storeId") Integer storeId);
}