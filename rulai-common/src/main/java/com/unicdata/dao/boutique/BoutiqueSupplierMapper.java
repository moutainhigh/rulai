package com.unicdata.dao.boutique;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.unicdata.entity.boutique.BoutiqueSupplier;
import com.unicdata.entity.boutique.BoutiqueSupplierExample;

public interface BoutiqueSupplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueSupplier record);

    int insertSelective(BoutiqueSupplier record);

    List<BoutiqueSupplier> selectByExample(BoutiqueSupplierExample example);

    BoutiqueSupplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueSupplier record);

    int updateByPrimaryKey(BoutiqueSupplier record);

    Page<Map<String, Object>> selectSupplier(@Param("name")String name,@Param("storeId")Integer storeId);

	int deleteSupplier(@Param("id")Integer id);

	List<BoutiqueSupplier> selectAllSupplier(@Param("storeId")Integer storeId);

	int insertUseGeneratedKeys(BoutiqueSupplier supplier);
}