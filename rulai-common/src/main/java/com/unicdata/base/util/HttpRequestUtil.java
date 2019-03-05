package com.unicdata.base.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.unicdata.base.constant.Constant;


/**
 * http请求帮助类
 * @author 许兵
 * @date 2013-10-30 14:37:30
 */
public class HttpRequestUtil {
	
	private static Logger log = Logger.getLogger(HttpRequestUtil.class);
	
	/**
	 * 发送GET请求
	 * 
	 * @param url  请求的地址(含参数)
	 * @return 响应内容
	 */
	public static String sendGetRequest(String url) {
		HttpGet httpGet = new HttpGet(url);
		HttpClient httpclient = HttpClientBuilder.create().build();
		try {
			HttpResponse response = httpclient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity he = response.getEntity();
				InputStream is = he.getContent();
				BufferedReader br = new BufferedReader(new InputStreamReader(is,Constant.CHARSET_UTF_8));
				String line = null;
				StringBuilder sb = new StringBuilder();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				is.close();
				br.close();
				return sb.toString();
			} else {
				return "error";
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return "exception";
		} catch (IOException e) {
			e.printStackTrace();
			return "exception";
		}
	}
	
	/**
	 * 发送POST请求
	 * @param url url地址
	 * @param params 参数
	 * @return
	 */
	public static String sendPostRequest(String url,Map<String, String> params,String cookie){
		return sendPostRequest(url, params, "cookie", cookie);
	}
	
	/**
	 * 发送POST请求
	 * @param url url地址
	 * @param params 参数
	 * @return
	 */
	public static String sendPostRequest(String url,Map<String, String> params){
		return sendPostRequest(url, params,null,null);
	}
	
	/**
	 * 发送POST请求
	 * @param url 请求地址
	 * @param params 请求参数
	 * @param key 放入header key值
	 * @param value 放入header  value值
	 * @return
	 */
	public static String sendPostRequest(String url,Map<String, String> params,String key,String value){
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        try {
	        List<BasicNameValuePair> postData = new ArrayList<BasicNameValuePair>();
	        if(null != params){
	        	 for(Map.Entry<String, String> entry : params.entrySet()){
	 	            postData.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
	 	        }  
	        }
	        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postData,Constant.CHARSET_UTF_8);//设置格式为utf-8的格式
	        post.setEntity(entity);
	        if(StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value))
	        	post.setHeader(key,value);
	        HttpResponse response = httpClient.execute(post);
	        //成功 状态码 200
	        if (response.getStatusLine().getStatusCode() == 200) {  
	            // 取出回应字串
	            return EntityUtils.toString(response.getEntity(),Constant.CHARSET_UTF_8);//接受设置为utf-8格式
	        }
	        return "error";
        } catch (Exception e) {
        	log.info(e.getMessage());
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 发送POST请求
	 * @param url url地址
	 * @param params 参数
	 * @return
	 */
	public static String sendPostRequest(String url,String params){
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        try {
	        StringEntity entity = new StringEntity(params,Constant.CHARSET_UTF_8);
	        post.setEntity(entity);
	        HttpResponse response = httpClient.execute(post);
	        //成功 状态码 200
	        if (response.getStatusLine().getStatusCode() == 200) {  
	            // 取出回应字串
	            return EntityUtils.toString(response.getEntity(),Constant.CHARSET_UTF_8);//接受设置为utf-8格式
	        }
	        return "error";
        } catch (Exception e) {
        	log.info(e.getMessage());
			e.printStackTrace();
			return "error";
		}
	}
}
