package com.unicdata.service.model;

import javax.servlet.http.HttpServletResponse;

/**
 * 模板下载
 * 
 * @author wxn
 * @date 2018年6月13日
 */
public interface DownloadService {
	void saveUrlAs(HttpServletResponse response, String url, String fileName);
}
