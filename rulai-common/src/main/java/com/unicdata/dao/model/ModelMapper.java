package com.unicdata.dao.model;

import java.util.List;

import com.unicdata.entity.model.Model;

public interface ModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Model record);

    int insertSelective(Model record);

    Model selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);

	List<Model> getListByBelong(Integer belongId);
}