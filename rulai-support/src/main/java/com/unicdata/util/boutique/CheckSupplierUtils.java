package com.unicdata.util.boutique;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.unicdata.entity.boutique.BoutiqueSupplier;
import com.unicdata.util.NumberUtil;

public class CheckSupplierUtils {

	/**
	 * status 为0 则校验通过
	 * @param supplier
	 * @return
	 */
	public static JSONObject check(BoutiqueSupplier supplier) {
		JSONObject result = new JSONObject();
		
		int status = 0;
		String name = supplier.getName();
		if(StringUtils.isBlank(name)){
			result.put("name", "供应商名称不能为空！");
			status++;
		}
//		String tel = supplier.getCompanyTel();
//		if(StringUtils.isBlank(tel)){
//			result.put("tel", "公司电话必填！");
//			status++;
//		}else{
//			boolean mobileNO = NumberUtil.isMobileNO(tel);
//			boolean phone = NumberUtil.isPhone(tel);
//			if(!mobileNO && !phone){
//				result.put("tel", "请填写正确的公司电话！");
//				status++;
//			}
//		}
//		String contactsOne = supplier.getContactsOne();
//		if(StringUtils.isBlank(contactsOne)){
//			result.put("contactsOne", "联系人1必填！");
//			status++;
//		}
//		String contactsOnePhone = supplier.getContactsOnePhone();
//		if(StringUtils.isBlank(contactsOnePhone)){
//			result.put("contactsOnePhone", "联系人1手机号码必填！");
//			status++;
//		}
		String fineBrandId = supplier.getFineBrandIds();
		if(fineBrandId == null){
			result.put("fineBrandId", "品牌必选！");
			status++;
		}
		result.put("status", status);
		return result;
	}
}
