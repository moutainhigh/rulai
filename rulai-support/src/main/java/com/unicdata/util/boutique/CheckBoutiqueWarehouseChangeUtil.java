package com.unicdata.util.boutique;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiqueWarehouseChange;

public class CheckBoutiqueWarehouseChangeUtil {

	public static JSONObject check(BoutiqueWarehouseChange change) {
		JSONObject result = new JSONObject();
		JSONObject detail = new JSONObject();
		
		int status_count = 0 ;
		String applyName = change.getApplyName();
		if(StringUtils.isBlank(applyName)){
			detail.put("applyName", "申请名称不能为空！");
			status_count++;
		}
		Date applyDate = change.getApplyDate();
		if(applyDate == null){
			detail.put("applyDate", "申请日期不能为空！");
			status_count++;
		}
		
		List<BoutiqueInformation> list = change.getList();
		if(list == null || list.size() ==0){
			detail.put("list", "仓库库位变更列表不能为空！");
			status_count++;
		}
		result.put("status", status_count);
		return result;
	}

	
	
	
}
