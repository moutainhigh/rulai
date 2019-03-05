package com.unicdata.util.boutique;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.unicdata.entity.boutique.BoutiquePackage;
import com.unicdata.entity.boutique.BoutiquePackageInclude;

public class CheckBoutiquePackageUtils {
	
	public static JSONObject check(BoutiquePackage info){
		JSONObject result = new JSONObject();
		JSONObject detail = new JSONObject();
		
		int status_count = 0 ;
		String name = info.getName();
		if(StringUtils.isBlank(name)){
			detail.put("name", "套餐名称不能为空！");
			status_count++;
		}
		BigDecimal salveValue = info.getSalveValue();
		if(salveValue == null  ){
			detail.put("salveValue", "销售价格不能为空！");
			status_count++;
		}else if(salveValue.compareTo(BigDecimal.valueOf(0) ) == -1){
			detail.put("salveValue", "销售价格不能小于0！");
			status_count++;
		}
		String carId = info.getCarIds();
		if(carId == null ){
			detail.put("carId", "请选择适用车型");
			status_count++;
		}
		List<BoutiquePackageInclude> list = info.getList();
		if(list == null || list.size() == 0){
			detail.put("list", "请添加精品！");
			status_count++;
		}
		result.put("result", detail);
		result.put("status", status_count);
		return result;
	}
	
}
