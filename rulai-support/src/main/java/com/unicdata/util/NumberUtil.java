package com.unicdata.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtil {
	
	/**
     * 随机生成五位随机数
     * @param len 需要生成几位随机数
     * @return
     */
	public static String getFiveRandom(int len) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        Random random = new Random();

        //循环产生
        for(int i=9;i>1;i--) {
            int index = random.nextInt(i);
            int temp = array[index];
            array[index] = array[i-1];
            array[i-1] = temp;
        }
        //拼接结果为字符串
        int result = 0;
        for(int i=0;i<len;i++) {
            result = result*10+array[i];
        }
        String randomVerify = Integer.toString(result);


        return randomVerify;
    }

	//验证手机号码
	public static boolean isMobileNO(String mobiles){
		Pattern p = Pattern.compile("^1(3|4|5|7|8)\\d{9}$");
		Matcher m = p.matcher(mobiles);
//		System.out.println(m.matches()+"---");
		return m.matches();
	}
	

    /**
     * 电话号码验证
     *
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isPhone(String str) {
        Pattern p1 = null, p2 = null;
        Matcher m  = null;
        boolean b  = false;
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
        if (str.length() > 9) {
            m = p1.matcher(str);
            b = m.matches();
        } else {
            m = p2.matcher(str);
            b = m.matches();
        }
        return b;
    }
	
	//验证密码
	public static boolean pwdValidation(String mobiles){
		Pattern p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,15}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}
	
	//随机生成指定范围之间的随机数
	public static int random(int min,int max){
		Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
	}
	
/*	public static void main(String[] args) {
		for(int i = 0;i < 20;i++){
			System.out.println(random(1,8));
		}
	}*/
}
