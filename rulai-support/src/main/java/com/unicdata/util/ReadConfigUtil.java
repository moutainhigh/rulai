package com.unicdata.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 读取上传配置文件
 * 
 * @author 申勇
 * @date 2013-10-30 14:41:30
 */
public class ReadConfigUtil {

	private static final Logger logger = Logger.getLogger(ReadConfigUtil.class);
	private static String FILE = "/application.properties";
	/**
	 * 文件上传配置
	 */
	private static Properties config = new Properties();

	static {
		InputStream is = ReadConfigUtil.class.getResourceAsStream(FILE);
		try {
			config.load(is);
		} catch (IOException e) {
			logger.error("读取文件上传配置失败 :" + FILE);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				logger.error("关闭文件上传配置读取！");
			}
		}
	}

	/**
	 * 车型url
	 * 
	 * @return
	 */
	public static String getVehicleUrl() {
		return config.getProperty("vehicle.info.url");
	}

	/**
	 * 通过车系拿车型接口
	 * 
	 * @return
	 */
	public static String getModels() {
		return config.getProperty("models.info.url");
	}

	/**
	 * 品牌列表
	 * 
	 * @return
	 */
	public static String getBrandUrl() {
		return config.getProperty("brand.info.url");
	}
	
	/**
	 * 车型列表
	 * 
	 * @return
	 */
	public static String getVehicleList() {
		return config.getProperty("vehicle.list.url");
	}	
	
	/**
	 * 多个品牌详情
	 * 
	 * @return
	 */
	public static String getSeveralBrandUrl() {
		return config.getProperty("brand.several.url");
	}

	/**
	 * 通过品牌拿车系列表
	 * 
	 * @return
	 */
	public static String getSeriesUrl() {
		return config.getProperty("series.info.url");
	}
	
	/**
	 * 通过品牌id取图片
	 * 
	 * @return
	 */
	public static String getBrandPicUrl() {
		return config.getProperty("brand.pic.url");
	}
	
	/**
	 * 通过品牌id 获取活动列表
	 * 
	 * @return
	 */
	public static String getActivityBrandUrl() {
		return config.getProperty("activity.brand.url");
	}
	
	/**
	 * 获取当前活动此用户是否报过名
	 * 
	 * @return
	 */
	public static String getActivitySignUrl() {
		return config.getProperty("activity.sign.url");
	}
	
	/**
	 * 活动报名
	 * 
	 * @return
	 */
	public static String getActivityDosignUrl() {
		return config.getProperty("activity.dosign.url");
	}
	
	/**
	 * 车型详细配置
	 * 
	 * @return
	 */
	public static String getVehicleDetailedUrl() {
		return config.getProperty("vehicle.detailed.url");
	}
	
}
