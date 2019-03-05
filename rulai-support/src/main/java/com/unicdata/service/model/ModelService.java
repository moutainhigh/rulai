package com.unicdata.service.model;

import java.util.List;

import com.unicdata.entity.model.Model;

/**
 * 导入字段信息表
 * 
 * @author wxn
 * @date 2018年6月6日
 */
public interface ModelService {

	List<Model> getListByBelong(Integer belongId);

}
