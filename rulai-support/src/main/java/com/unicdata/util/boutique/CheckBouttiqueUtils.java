package com.unicdata.util.boutique;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.unicdata.entity.boutique.BoutiqueInformation;

public class CheckBouttiqueUtils {

	private static String code; //精品编号
	private static String name;//精品名称
	private static Integer warehouse_id;//仓库id
	private static Integer position_id;//库位id
	private static String classify;//精品分类id组合
	private static String car_classify;//车系分类
	private static Integer brand_id;//精品品牌id
	private static String company;//单位
	private static Integer construction_node;//施工节点
	private static Integer supplier_id;//供应商id
	private static BigDecimal cost;//含税成本
	private static BigDecimal coefficient;//精品系数
	private static BigDecimal unitprice;//精品单价
	private static Double workinghours;//工时
	private static Integer safety_stock;//安全库存
	private static String picture;//图片位置
	private static String remark;//备注
	
	public static JSONObject checkBouttique(BoutiqueInformation info){
		reset();
		JSONObject result = new JSONObject();
		JSONObject detail = new JSONObject();
		int count = 0;
//		code = info.getCode();
//		count = checkString(detail, count,code,"code");
		
		name = info.getName();
		count = checkString(detail, count,name,"name");
		
		warehouse_id = info.getWarehouseId();
		count = checkInt(detail, count,warehouse_id,"warehouse_id");
		
		position_id = info.getPositionId();
		count = checkInt(detail, count,position_id,"position_id");
		
		classify = info.getClassify();
		count = checkString(detail, count,classify,"classify");
		
		car_classify = info.getCarClassifyId();
		count = checkString(detail, count,car_classify,"car_classify");
		
		brand_id = info.getBrandId();
		count = checkInt(detail, count,brand_id,"brand_id");
		
		company = info.getCompany();
		count = checkString(detail, count,company,"company");
		
		construction_node = info.getConstructionNode();
		count = checkInt(detail, count,construction_node,"construction_node");
		
		supplier_id = info.getSupplierId();
		count = checkInt(detail, count,supplier_id,"supplier_id");
		
		coefficient = info.getCoefficient();
		count = checkDecimal(detail, count,coefficient,"coefficient");
		
		workinghours = info.getWorkinghours();
		if(workinghours == null){
			detail.put("workinghours", "is null");
			count++;
		}
		
		safety_stock = info.getSafetyStock();
		count = checkInt(detail, count,safety_stock,"safety_stock");
		
		if(count == 0 ){
			result.put("status", "0");
		}else{
			result.put("status", "1");
		}
		result.put("detail", detail);
		reset();
		return result;
	}

	private static int checkDecimal(JSONObject detail, int count,BigDecimal decimal , String strName) {
		if(decimal == null){
			detail.put(strName, strName + "必填！");
			count++;
		}
		return count;
	}
	
	private static int checkInt(JSONObject detail, int count,Integer interger , String strName) {
		if(interger == null || interger == 0 ){
			detail.put(strName, "必填！");
			count++;
		}
		return count;
	}

	private static int checkString(JSONObject detail, int count,String str , String strName) {
		if(StringUtils.isBlank(str)){
			detail.put(strName, "必填！");
			count++;
		}
		return count;
	}
	
	private static synchronized void reset(){
		code = null; 
		name = null;//精品名称
		warehouse_id = null;//仓库id
		position_id = null;//库位id
		classify = null;//精品分类id组合
		car_classify = null;//车型分类
		brand_id = null;//精品品牌id
		company = null;//单位
		construction_node = null;//施工节点
		supplier_id = null;//供应商id
		cost = null;//含税成本
		coefficient = null;//精品系数
		unitprice = null;//精品单价
		workinghours = null;//工时
		safety_stock = null;//安全库存
		picture = null;//图片位置
		remark = null;//备注
	}
	
}
