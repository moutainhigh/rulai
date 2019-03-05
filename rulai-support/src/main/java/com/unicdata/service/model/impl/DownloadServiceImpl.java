package com.unicdata.service.model.impl;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.unicdata.service.model.DownloadService;

@Service
public class DownloadServiceImpl implements DownloadService{

	/**
	 * @功能 下载文件接口
	 * 
	 * @param url
	 *            请求的路径
	 * @param fileName
	 *            文件保存名称
	 * @return
	 */
	public void saveUrlAs(HttpServletResponse response, String url, String fileName) {

		try {
			fileName = new String(fileName.getBytes(), "iso8859-1");// 解决中文
																	// 文件名问题
			response.reset();// 清空输出流
			response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls"); // 设定输出文件头,该方法有两个参数，分别表示应答头的名字和值。
			response.setContentType("application/msexcel");

			HttpURLConnection conn = null;
			InputStream inputStream = null;
			// 建立链接
			URL httpUrl = new URL(url);
			conn = (HttpURLConnection) httpUrl.openConnection();
			// 以Post方式提交表单，默认get方式
			// conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			// post方式不能使用缓存
			// conn.setUseCaches(false);
			// 连接指定的资源
			conn.connect();
			// 获取网络输入流
			inputStream = conn.getInputStream();
			BufferedInputStream in = new BufferedInputStream(inputStream);
			// 输出流
			OutputStream out = response.getOutputStream();
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while ((bytes = in.read(bufferOut)) != -1) {
				out.write(bufferOut, 0, bytes);
			}
			out.close();
			in.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("抛出异常！！");
		}
	}

}
