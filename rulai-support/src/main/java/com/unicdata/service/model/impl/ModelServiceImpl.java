package com.unicdata.service.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.model.ModelMapper;
import com.unicdata.entity.model.Model;
import com.unicdata.service.model.ModelService;

@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<Model> getListByBelong(Integer belongId) {
		return modelMapper.getListByBelong(belongId);
	}

}
