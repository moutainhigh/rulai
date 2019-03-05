package com.unicdata.service.boutique;

import org.springframework.web.multipart.MultipartFile;

import com.unicdata.entity.system.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface BoutiqueImportService {

	/**
	 * 导出模板
	 * @param response
	 * @param boutiqueUrl
	 * @param boutiqueName
	 */
	void exportModel(HttpServletResponse response, String fileUrl, String fileName) throws Exception ;

	/**
	 * 导入精品库位Excel
	 * @param request
	 * @param file
	 * @param warehouseId
	 * @return
	 */
	Map<String,String> uploadPosition(HttpServletRequest request, MultipartFile file,Integer warehouseId);

	/**
	 * 导入精品分类Excel
	 * @param request
	 * @param file
	 * @return
	 */
	Map<String, String> uploadClassify(HttpServletRequest request, MultipartFile file,Employee member);

	/**
	 * 导入精品供应商Excel
	 * @param request
	 * @param file
	 * @param member
	 * @return
	 */
	Map<String, String> uploadSupplier(HttpServletRequest request, MultipartFile file, Employee member);

	/**
	 * 导入精品品牌Excel
	 * @param request
	 * @param file
	 * @param member
	 * @return
	 */
	Map<String, String> uploadBrand(HttpServletRequest request, MultipartFile file, Employee member);

	/**
	 * 导入精品信息库Excel
	 * @param request
	 * @param file
	 * @param member
	 * @return
	 */
	Map<String, String> uploadBoutique(HttpServletRequest request, MultipartFile file, Employee member);

}
