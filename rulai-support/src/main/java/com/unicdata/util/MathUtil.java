package com.unicdata.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Create by zhang
 */
public class MathUtil {
    /**
     * 相除并获取百分比结果（两位小数）
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String numFormatter(Long num1, Long num2) {
        double percent = 0;
        if(num2 > 0){
            percent = (double) num1 / (double) num2;
        }
        // 获取格式化对象
        NumberFormat nt = NumberFormat.getPercentInstance();
        // 设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(2);
        return nt.format(percent);
    }
    
    /**
	 * 数字格式转换 
	 * 元转换为万元 并加上千位分隔符
	 * @param num
	 * @return
	 */
	public static String numFomatter(double num){
		if (num < 10000){
			num = 10000;
		}
		num = num * 100 / 1000000;
		BigDecimal bd = new BigDecimal(num);
		DecimalFormat df = new DecimalFormat(",###,###");
		return df.format(bd);
	}
}
