package com.unicdata.base.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * Created by shenyong on 2017/3/14.
 * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精
 * 确的浮点数运算，包括加减乘除和四舍五入。
 */
public class BigDecimalUtils {
    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;

    //这个类不能实例化
    private BigDecimalUtils(){}
    /**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static BigDecimal add(BigDecimal v1,BigDecimal v2){
        return v1.add(v2);
    }
    /**
     * 提供精确的减法运算。
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static BigDecimal sub(BigDecimal v1,BigDecimal v2){
        return v1.subtract(v2);
    }
    /**
     * 提供精确的乘法运算。
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static BigDecimal mul(BigDecimal v1,BigDecimal v2){
        return v1.multiply(v2);
    }
    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static BigDecimal div(BigDecimal v1,BigDecimal v2){
        return div(v1,v2,DEF_DIV_SCALE);
    }
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static BigDecimal div(BigDecimal v1,BigDecimal v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        return v1.divide(v2,scale,BigDecimal.ROUND_HALF_UP);
    }
    /**
     * 提供精确的小数位四舍五入处理。
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static BigDecimal round(BigDecimal v,int scale){
        if(scale<0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal one = new BigDecimal("1");
        return v.divide(one,scale,BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 计算百分比
     * @param v1 第一个
     * @param v2 第二个
     * @return 计算后的百分比 如: 1.5%
     */
    public static String percentage(BigDecimal v1,BigDecimal v2){
        BigDecimal a1 = v1.setScale(7, BigDecimal.ROUND_HALF_UP);
        BigDecimal a2 = v2.setScale(7, BigDecimal.ROUND_HALF_UP);
        BigDecimal r = (a1.subtract(a2)).divide(a2, 4, BigDecimal.ROUND_HALF_EVEN).setScale(4,BigDecimal.ROUND_HALF_UP);
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        return percent.format(r);
    }

    /**
     * 计算万元
     * @param obj 数值
     * @param num 取小数位数
     * @return
     */
    public static BigDecimal toW(Integer obj,Integer num){
        BigDecimal v1 = new BigDecimal(obj);
        BigDecimal divisor = new BigDecimal(10000);
        BigDecimal price = v1.divide(divisor, num, BigDecimal.ROUND_HALF_UP);
        return price ;
    }
    /**
     * 计算万元
     * @param obj 数值
     * @param num 取小数位数
     * @return
     */
    public static BigDecimal toW(Double obj,Integer num){
        BigDecimal v1 = new BigDecimal(obj);
        BigDecimal divisor = new BigDecimal(10000);
        BigDecimal price = v1.divide(divisor, num, BigDecimal.ROUND_HALF_UP);
        return price ;
    }
    /**
     * 计算万元
     * @param obj 数值
     * @param num 取小数位数
     * @return
     */
    public static BigDecimal toW(BigDecimal obj,Integer num){
        BigDecimal divisor = new BigDecimal(10000);
        BigDecimal price = obj.divide(divisor, num, BigDecimal.ROUND_HALF_UP);
        return price ;
    }
    /**
     * 四省五入
     * @param value
     * @return
     */
    public static BigDecimal format(BigDecimal value,int num) {
        return value.setScale(num, RoundingMode.HALF_UP);
    }

}
