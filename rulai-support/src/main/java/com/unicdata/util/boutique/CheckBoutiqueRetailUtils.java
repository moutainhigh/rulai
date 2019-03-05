package com.unicdata.util.boutique;

import com.alibaba.fastjson.JSONObject;
import com.unicdata.entity.boutique.BoutiqueRetail;

public class CheckBoutiqueRetailUtils {


		public static JSONObject check(BoutiqueRetail retail) {
			JSONObject result = new JSONObject();
			JSONObject detail = new JSONObject();
			
			int status_count = 0;
			
			if(retail.getEmployeeId() == null ){
				detail.put("employeeId", "请选择销售人员！");
				status_count++;
			}
			
			if(retail.getCustomerId() == null){
				detail.put("customerId", "请选择客户！");
				status_count++;
			}
			if(retail.getList() == null || retail.getList().size() == 0){
				detail.put("list", "请选择精品！");
				status_count++;
			}

			result.put("status", status_count);
			result.put("detail", detail);
			return result;
		}


}
