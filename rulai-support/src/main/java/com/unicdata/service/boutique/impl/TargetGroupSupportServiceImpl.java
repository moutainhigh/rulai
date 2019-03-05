package com.unicdata.service.boutique.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicdata.dao.boutique.BoutiqueTargetGroupMapper;
import com.unicdata.entity.boutique.BoutiqueTargetGroup;
import com.unicdata.service.boutique.TargetGroupSupportService;
@Service
public class TargetGroupSupportServiceImpl implements TargetGroupSupportService {

	@Autowired
	private BoutiqueTargetGroupMapper boutiqueTargetGroupMapper;
	
	@Override
	public List<BoutiqueTargetGroup> selectTargetGroups() {
		
		return boutiqueTargetGroupMapper.selectAllGroup();

	}

}
