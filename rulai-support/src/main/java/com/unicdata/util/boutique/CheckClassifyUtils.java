package com.unicdata.util.boutique;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.unicdata.dao.boutique.BoutiqueClassifyMapper;
import com.unicdata.entity.boutique.BoutiqueClassify;
import com.unicdata.util.SpringContextUtil;

public class CheckClassifyUtils {

	public static JSONObject check(BoutiqueClassify classify) {
		JSONObject result = new JSONObject();
		
		
		if(classify != null){
			String classifyName = classify.getClassify();
			
			if(StringUtils.isBlank(classifyName)){
				result.put("status", 0);
				result.put("msg", "添加失败，菜单名称不能为空！");
				return result;
			}
			String code = classify.getCode();
			if(StringUtils.isBlank(code)){
				result.put("status", 0);
				result.put("msg", "添加失败，菜单编号不能为空！");
				return result;
			}
			
			ApplicationContext context = SpringContextUtil.getApplicationContext();
			BoutiqueClassifyMapper classifyMapper = context.getBean(BoutiqueClassifyMapper.class);
			Integer count = classifyMapper.selectCountByLevelAndCode4Add(classify);
			if(count > 0){
				result.put("status", 0);
				result.put("msg", "添加失败，同级菜单编号不能相同！");
				return result;
			}
			result.put("status", 1);
			result.put("msg", "添加成功！");
		}else{
			result.put("status", 0);
			result.put("msg", "添加失败");
		}
		return result;
	}

	public static JSONObject checkUpdate(BoutiqueClassify classify) {
		JSONObject result = new JSONObject();
		
		if(classify != null){
			String classifyName = classify.getClassify();
			if(StringUtils.isBlank(classifyName)){
				result.put("status", 0);
				result.put("msg", "添加失败，菜单名称不能为空！");
				return result;
			}
			String code = classify.getCode();
			if(StringUtils.isBlank(code)){
				result.put("status", 0);
				result.put("msg", "添加失败，菜单编号不能为空！");
				return result;
			}
			
			ApplicationContext context = SpringContextUtil.getApplicationContext();
			BoutiqueClassifyMapper classifyMapper = context.getBean(BoutiqueClassifyMapper.class);
			Integer count = classifyMapper.selectCountByLevelAndCode4Update(classify);
			if(count > 0){
				result.put("status", 0);
				result.put("msg", "添加失败，同级菜单编号不能相同！");
				return result;
			}
			result.put("status", 1);
			result.put("msg", "添加成功！");
		}
		return result;
	}

}
