package com.unicdata.util;

import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.unicdata.base.util.StringUtil;

public class ExcelTemplateUtil {

	/**
	 * 解析Excel里面的数据
	 *
	 * @param wb
	 * @return
	 */
	public static List<Map<String, Object>> readExcelValue(Workbook wb, File tempFile) {

		// 得到第一个shell
		Sheet sheet = wb.getSheetAt(0);
		// 得到Excel的行数
		int totalRows = sheet.getPhysicalNumberOfRows();
		// 总列数
		int totalCells = 0;
		// 得到Excel的列数(前提是有行数)，从第二行算起
		if (totalRows >= 2 && sheet.getRow(1) != null) {
			totalCells = sheet.getRow(1).getPhysicalNumberOfCells();
		}
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 标题行
		Row titleRow = sheet.getRow(0);
		// 循环Excel行数,从第二行开始。标题不入库
		for (int r = 1; r < totalRows; r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			// 判断是否整行为空
			boolean flag = true;
			// 循环Excel的列
			for (int c = 0; c < totalCells; c++) {
				Cell cell = row.getCell(c);
				String cellValue = "";
				if (null != cell) {
					// 以下是判断数据的类型
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC: // 数字
						if (0 == cell.getCellType()) {// 判断单元格的类型是否则NUMERIC类型
							if (HSSFDateUtil.isCellDateFormatted(cell)) {// 判断是否为日期类型
								Date date = cell.getDateCellValue();
								DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								cellValue = formater.format(date);
							} else {
								cellValue = cell.getNumericCellValue() + "";
								Double d = cell.getNumericCellValue();
								DecimalFormat df = new DecimalFormat("#.##");
								cellValue = df.format(d);
							}
						}
						break;

					case HSSFCell.CELL_TYPE_STRING: // 字符串
						cellValue = cell.getStringCellValue();
						break;

					case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
						cellValue = cell.getBooleanCellValue() + "";
						break;

					case HSSFCell.CELL_TYPE_FORMULA: // 公式
						// cellValue = cell.getCellFormula() + "";
						try {
							// 获取公式计算结果
							if (HSSFDateUtil.isCellDateFormatted(cell)) {// 判断是否为日期类型
								Date date = cell.getDateCellValue();
								DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								cellValue = formater.format(date);
							} else {
								cellValue = cell.getNumericCellValue() + "";
								Double d = cell.getNumericCellValue();
								DecimalFormat df = new DecimalFormat("#.##");
								cellValue = df.format(d);
							}
						} catch (IllegalStateException e) {
							cellValue = String.valueOf(cell.getRichStringCellValue());
						}
						break;

					case HSSFCell.CELL_TYPE_BLANK: // 空值
						cellValue = "";
						break;

					case HSSFCell.CELL_TYPE_ERROR: // 故障
						cellValue = "非法字符";
						break;

					default:
						cellValue = "未知类型";
						break;
					}
				}
				if (StringUtil.isNotBlank(cellValue)) {
					flag = false;
				}
				String title = titleRow.getCell(c).getStringCellValue();
				map.put(title.trim(), cellValue.trim());
			}
			if (!flag) {
				list.add(map);
			}
		}
		// 删除上传的临时文件
		if (tempFile.exists())

		{
			tempFile.delete();
		}
		return list;
	}

	/**
	 * 读取上传excel
	 *
	 * @param file
	 * @return
	 */
	public static List<Map<String, String>> readExcelValue(MultipartFile file) {
		Workbook wb = null;
		try {
			// 根据文件名判断文件是2003版本还是2007版本
			if (ExcelTemplateUtil.isExcel2007(file.getOriginalFilename())) {
				wb = new XSSFWorkbook(file.getInputStream());
			} else {
				wb = new HSSFWorkbook(file.getInputStream());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 得到第一个shell
		Sheet sheet = wb.getSheetAt(0);
		// 得到Excel的行数
		int totalRows = sheet.getPhysicalNumberOfRows();
		// 总列数
		int totalCells = 0;
		// 得到Excel的列数(前提是有行数)，从第二行算起
		if (totalRows >= 2 && sheet.getRow(1) != null) {
			totalCells = sheet.getRow(1).getPhysicalNumberOfCells();
		}
		List<Map<String, String>> list = new ArrayList<Map<String, String>>(totalRows);
		// 标题行
		Row titleRow = sheet.getRow(0);
		// 循环Excel行数,从第二行开始。标题不入库
		for (int r = 1; r < totalRows; r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			Map<String, String> map = new HashMap<String, String>();
			// 循环Excel的列
			for (int c = 0; c < totalCells; c++) {
				if (r == 1) {
					titleRow.getCell(c).setCellType(Cell.CELL_TYPE_STRING);
				}
				row.getCell(c).setCellType(Cell.CELL_TYPE_STRING);
				map.put(titleRow.getCell(c).getStringCellValue(), row.getCell(c).getStringCellValue());
			}
			list.add(map);
		}
		return list;
	}

	// @描述：是否是2003的excel，返回true是2003
	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}

	// @描述：是否是2007的excel，返回true是2007
	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}

	/**
	 * 验证EXCEL文件
	 * 
	 * @param filePath
	 * @return
	 */
	public static boolean validateExcel(String filePath) {
		if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
			return false;
		}
		return true;
	}
}
