package com.unicdata.util.boutique;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.unicdata.dao.boutique.BoutiqueInformationMapper;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiquePushWarehouse;
import com.unicdata.entity.boutique.BoutiquePushWarehouseDetail;
import com.unicdata.util.SpringContextUtil;

public class CheckPushWareHouseUtils {

	private static final Logger LOG = LoggerFactory.getLogger(CheckPushWareHouseUtils.class);
	
	private static final DecimalFormat DF = new DecimalFormat("#.##");
	
	public static JSONObject check(BoutiquePushWarehouse info){
		JSONObject result = new JSONObject();
		JSONObject detail = new JSONObject();
		
		int count = 0 ; 
		String code = info.getCode();
		if(StringUtils.isBlank(code)){
			detail.put("detail", "请填写入库编号！");
			count++;
		}
		
		Date time = info.getOperationTime();
		if(time == null){
			detail.put("operationTime", "请选择操作时间！");
			count++;
		}
		
		String name = info.getName();
		if(StringUtils.isBlank(name)){
			detail.put("name", "请填写入库名称！");
			count++;			
		}
		
		List<BoutiquePushWarehouseDetail> list = info.getList();
		
		List<String> retrunList = new ArrayList<>();
		if(list == null || list.size() == 0){
			retrunList.add("入库内容不能为空！");
			count++;
		}
		detail.put("list", retrunList);
		result.put("status", count);
		result.put("detail", detail);
		return result;
	}

	public static JSONObject importCheck(MultipartFile file,int storeId) {
		JSONObject result = new JSONObject();
		List<String> msg = new ArrayList<>();
		
		
		int stock_All = 0;
		BigDecimal taxUnitPrice_ALL = new BigDecimal(0);
		BigDecimal taxCost_ALL = new BigDecimal(0);
		BigDecimal salesCost_ALL = new BigDecimal(0);
		
		if(file == null){
			msg.add("Excel不能为空文件！");
			result.put("msg", msg);
			result.put("status", 1);
			result.put("list", new ArrayList<>());
			return result;
		}
		int status_count = 0;
		
		//存放所有导入的信息
		List<BoutiquePushWarehouseDetail> list = new ArrayList<>();
		try {
			XSSFWorkbook book = new XSSFWorkbook(file.getInputStream());
			XSSFSheet sheet = book.getSheetAt(0);
			XSSFRow title = sheet.getRow(0);
			boolean flag = importExcelCanUse(title);
			if(!flag){
				msg.add("Excel格式错误！");
				result.put("msg", msg);
				result.put("status", 1);
				result.put("list", new ArrayList<>());
				return result;
			}
			
			int rownum = 1 ;
			ApplicationContext context = SpringContextUtil.getApplicationContext();
			BoutiqueInformationMapper informationMapper = context.getBean(BoutiqueInformationMapper.class);
			List<BoutiqueInformation> allBaseInfo = informationMapper.selectBoutiqueInfoAll(storeId);
			Map<String, BoutiqueInformation> allBaseInfoMap = new HashMap<>();//key - code 
			
			for (BoutiqueInformation boutiqueInformation : allBaseInfo) {
				allBaseInfoMap.put(boutiqueInformation.getCode(), boutiqueInformation);
			}

			while(true){
				XSSFRow row = sheet.getRow(rownum);
				if(row == null) break;
				
                //将所有列单位设置位string类型
                for (Cell cell : row) {
                    if (cell != null) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                }
				
				Cell fisrtCell = row.getCell(0);
				if(fisrtCell == null){
					break;
				}
				String stringCellValue = fisrtCell.getStringCellValue();
				if(StringUtils.isBlank(stringCellValue)){
					break;
				}
                
				BoutiquePushWarehouseDetail detail = new BoutiquePushWarehouseDetail();	
//				String code = row.getCell(0).getStringCellValue();
				String code = getCellValue(row,0);
				detail.setStoreId(storeId);
				detail.setBoutiqueCode(code);
				BoutiqueInformation information = allBaseInfoMap.get(code);
				if(information != null && StringUtils.isNotBlank(code)){
					detail.setBoutiqueId(information.getId());
					String name = getCellValue(row,1);			
					if(name != null && name.equals(information.getName())){
						detail.setNameRed(0);
					}else{
						msg.add("第" + rownum + "行精品名称 " + name + " 与精品信息库中精品编号为：" + information.getCode() + "的精品名称不匹配！" );
						detail.setNameRed(1);
					}
					detail.setBoutiqueName(name);
					
					String stockCellValue = getCellValue(row,2);
					double stock = Double.parseDouble(StringUtils.isBlank(stockCellValue) ? "-1" : stockCellValue);
					if(stock < 0){
						msg.add("第" + rownum + "行的精品库存不能小于0！" );
						detail.setStockRed(1);
						
						status_count++;
					}else{
						stock_All += stock;
						detail.setStockRed(0);
					}
					detail.setStock((new Double(stock)).intValue());
					
					String taxUnitPriceCellValue = getCellValue(row,3);
					double taxUnitPrice = Double.parseDouble(StringUtils.isBlank(taxUnitPriceCellValue) ? "-1" : taxUnitPriceCellValue);
					BigDecimal taxUnitPriceDecimal = new BigDecimal(taxUnitPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
					detail.setTaxUnitPrice(taxUnitPriceDecimal);
					if(taxUnitPrice < 0){
						msg.add("第" + rownum + "行的含税单价成本不能小于0！" );
						detail.setTaxUnitPriceRed(1);
						status_count++;
					}else{
						detail.setTaxUnitPriceRed(0);
						taxUnitPrice_ALL.add(taxUnitPriceDecimal);
						
						BigDecimal taxCost = new BigDecimal(new BigDecimal(taxUnitPrice).multiply( new BigDecimal(stock))+"").setScale(2, BigDecimal.ROUND_HALF_UP);
						taxCost_ALL.add(taxCost);
						detail.setTaxCost( taxCost);
					}
					BigDecimal unitprice = information.getUnitprice();
					if(unitprice == null || unitprice.equals(0)){
						unitprice = new BigDecimal(taxUnitPrice).multiply( information.getCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP);
					}
					salesCost_ALL.add(unitprice);
					detail.setSalesCost(unitprice);
					detail.setTypeLive(1);
					detail.setRowRed(0);
					list.add(detail);
				}else{
					detail.setRowRed(1);
					msg.add("第" + rownum + "行精品编号 " + code + "在精品信息库中不存在,请在信息库中添加信息!" );
					
					status_count++;
					list.add(detail);
				}
				rownum++;
			}
		} catch (Exception e) {
			LOG.error("import error ", e);
			msg.add("Excel格式错误！");
			result.put("msg", msg);
			result.put("status", 1);
			result.put("list", new ArrayList<>());
			return result;
		}
		result.put("msg", msg);
		result.put("status", status_count);
		result.put("stock_All", stock_All);
		result.put("taxUnitPrice_ALL", taxUnitPrice_ALL);
		result.put("taxCost_ALL", taxCost_ALL);
		result.put("salesCost_ALL", salesCost_ALL);
		result.put("list", list);
		return result;
	}

	
	/**
	 * 获取表格内容
	 * @param row
	 * @param index
	 * @return
	 */
	private static String getCellValue(Row row, int index) {
		Cell cell = row.getCell(index);
		if(cell != null){
			return cell.getStringCellValue().trim();
		}
		return null;
	}
	
	private static boolean importExcelCanUse(XSSFRow title) {
		boolean flag = true;
		String code = title.getCell(0).getStringCellValue();
		if(!"精品编号".equals(code)){
			flag = false;
		}
		
		String name = title.getCell(1).getStringCellValue();
		if(!"精品名称".equals(name)){
			flag = false;
		}
		
		String stock = title.getCell(2).getStringCellValue();
		if(!"库存".equals(stock)){
			flag = false;
		}
		String taxUnitPrice = title.getCell(3).getStringCellValue();
		if(!"含税成本单价".equals(taxUnitPrice)){
			flag = false;
		}
//		String salesType = title.getCell(4).getStringCellValue();
//		if(!"售卖类型".equals(salesType)){
//			flag = false;
//		}
		return flag;
	}
}
