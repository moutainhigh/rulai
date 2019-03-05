package com.unicdata.dao.boutique;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.unicdata.entity.boutique.BoutiqueBrand;
import com.unicdata.entity.boutique.BoutiqueBrandExample;

public interface BoutiqueBrandMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueBrand record);

    int insertSelective(BoutiqueBrand record);

    List<BoutiqueBrand> selectByExample(BoutiqueBrandExample example);

    BoutiqueBrand selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueBrand record);

    int updateByPrimaryKey(BoutiqueBrand record);

	List<BoutiqueBrand> findAll(@Param("storeId")Integer storeId);

	Page<Map<String, Object>> selectPage(@Param("storeId")Integer storeId);

	int deleteById(@Param("id")Integer id);

	BoutiqueBrand selectBySupplierName(@Param("name")String name);

}