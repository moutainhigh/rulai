package com.unicdata.service.boutique.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unicdata.base.util.DateUtil;
import com.unicdata.constant.BoutiqueEnum.BoutiqueSource;
import com.unicdata.dao.boutique.BoutiqueTargetGroupMapper;
import com.unicdata.dao.boutique.BoutiqueTargetMapper;
import com.unicdata.entity.boutique.BoutiqueTarget;
import com.unicdata.entity.boutique.BoutiqueTargetGroup;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.TargetSupportService;
@Service
public class TargetSupportServiceImpl extends BoutiqueTargetServiceImpl implements TargetSupportService {

	@Autowired
	private BoutiqueTargetMapper boutiqueTargetMapper;
	
	@Autowired
	private BoutiqueTargetGroupMapper boutiqueTargetGroupMapper;
	
	@Override
    public List<BoutiqueTarget> getBoutiqueTargetByStoreId(Map<String, Object> map) {
        return boutiqueTargetMapper.getBoutiqueTargetByStoreId(map);
    }

	@Override
	public List<BoutiqueTarget> getBoutiqueTargetByStoreId(Date saleDate, Integer storeId,BoutiqueSource source) {
		Map<String,Object> map = new HashMap<>();
		map.put("date", saleDate);
		map.put("storeId", storeId);
		if(source != null){
			map.put("source", source.getCode());
		}
        return boutiqueTargetMapper.getBoutiqueTargetByStoreId(map);
	}

	@Override
	public List<Map<String, Object>> selectTargetByYear(String year, Employee member) {
		List<Map<String, Object>> restulList = new ArrayList<>(12);
		Map<String, List<BoutiqueTarget>> result = new HashMap<>();
		resultInit(result);
		
		Integer nowMonth = Integer.parseInt(DateUtil.dateFormat(new Date(), "MM"));
		Integer nowYear = Integer.parseInt(DateUtil.dateFormat(new Date(), "yyyy"));
		
		Integer yearInt = Integer.parseInt(year);
		
		List<BoutiqueTarget> list = boutiqueTargetMapper.selectTargetByYear(year,member.getStoreId());
		for (BoutiqueTarget target : list) {
			Date date = target.getDate();
			Integer employeeGroupId = target.getEmployeeGroupId();
			BoutiqueTargetGroup targetGroup = boutiqueTargetGroupMapper.selectByPrimaryKey(employeeGroupId);
			target.setGroupName(targetGroup.getGroupName());
			String targetMonth = DateUtil.dateFormat(date, "MM");
			List<BoutiqueTarget> targetList = result.get(targetMonth);
			targetList.add(target);
			result.put(targetMonth, targetList);
		}
		
		for(int i = 0 ; i < 12 ; i ++){
			Map<String, Object> restulListMap = new HashMap<>();
			String month = "";
			restulListMap.put("year", Integer.parseInt(year));
			if(i < 9){
				restulListMap.put("month", (i + 1));
				month = "0" + (i + 1);
			}else{
				restulListMap.put("month", (i + 1));
				month = month + (i + 1);
			}

			List<BoutiqueTarget> list2 = new ArrayList<>();
			list2 = result.get(month);
			if((i+1) >= nowMonth && yearInt.equals(nowYear)){
				restulListMap.put("edit", true);

				if(list2 == null || list2.size() == 0){
					list2 = initTargetList(member,list2);
				}
			}else{
				
				restulListMap.put("edit", false);
			}
			restulListMap.put("list", list2);
			restulList.add(restulListMap);
		}
		return restulList;
	}

	private void resultInit(Map<String, List<BoutiqueTarget>> result) {
		for(int i = 1 ; i <= 12 ; i ++){
			if(i < 10){
				result.put("0" + i, new ArrayList<>());
			}else{
				result.put("" + i, new ArrayList<>());
			}
		}
	}
	
	private List<BoutiqueTarget> initTargetList(Employee member,List<BoutiqueTarget> list){
		List<BoutiqueTargetGroup> allGroup = boutiqueTargetGroupMapper.selectAllGroup();
		
		for(BoutiqueTargetGroup targetGroup : allGroup){
			String groupName = targetGroup.getGroupName();
			Integer source = targetGroup.getSource();
			BoutiqueTarget target = new BoutiqueTarget();
			target.setId(0);
			target.setSource(source);
			target.setEmployeeGroupId(targetGroup.getId());
			target.setGroupName(groupName);
			target.setStoreId(member.getStoreId());
			target.setTypeLive(1);
			list.add(target);
		}
		return list;
	}
	
	@Override
	public int addOrUpdateTargetByYear(String jsonArray, Employee member) {
		int status = 0 ;
		
		try {
			JSONObject parseObject = JSON.parseObject(jsonArray);
			JSONArray targetJson = parseObject.getJSONArray("target");
//			JSONArray targetJson = JSONArray.parseArray(jsonArray);
			
			List<BoutiqueTarget> insertList = new ArrayList<>();
			List<BoutiqueTarget> updateList = new ArrayList<>();
			
			for (Object object : targetJson) {
				JSONObject all = JSON.parseObject(object.toString());
				String edit = all.get("edit").toString();
				
				if("true".equals(edit)){
					String year = all.get("year").toString();
					String month = all.get("month").toString();
					JSONArray array = all.getJSONArray("list");
					for (Object object2 : array) {
						JSONObject target = JSON.parseObject(object2.toString());
						BoutiqueTarget boutiqueTarget = new BoutiqueTarget();
						boutiqueTarget.setEmployeeGroupId(target.getInteger("employeeGroupId"));
						String incomePlay = target.get("incomePlay") == null ? "0" : target.get("incomePlay").toString();
						String profitPlay = target.get("profitPlay") == null ? "0" : target.get("profitPlay").toString();
						boutiqueTarget.setIncomePlay(new BigDecimal(incomePlay));
						boutiqueTarget.setProfitPlay(new BigDecimal(profitPlay));
						boutiqueTarget.setSource(Integer.parseInt(target.get("source").toString()));
						boutiqueTarget.setStoreId(member.getStoreId());
						boutiqueTarget.setTypeLive(1);
						boutiqueTarget.setDate(DateUtil.stringToDate(year + "-" + month , DateUtil.sdf7));
						String targetId = target.get("id").toString();
						if(StringUtils.isBlank(targetId) || "0".equals(targetId)){
							insertList.add(boutiqueTarget);
						}else{
							Integer nowMonth = Integer.parseInt(DateUtil.dateFormat(new Date(), "MM"));
							
							boutiqueTarget.setId(Integer.parseInt(targetId));
							updateList.add(boutiqueTarget);
						}
					}
				}
			}
			
			if(insertList.size() > 0 ){
				boutiqueTargetMapper.insertBatch(insertList);
			}
			
			if(updateList.size() > 0){
				boutiqueTargetMapper.updateBatch(updateList);
			}
			status = 1;
		} catch (Exception e) {
			e.printStackTrace();
			status = 0;
		}
		return status;
	}

	@Override
	public int deleteTargetById(Integer id) {
		int update = boutiqueTargetMapper.deleteTargetById(id);
		return update;
	}
	
}
