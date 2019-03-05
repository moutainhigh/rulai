package com.unicdata.service.boutique.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unicdata.constant.BoutiqueEnum;
import com.unicdata.constant.BoutiqueEnum.ConstructionNode;
import com.unicdata.dao.boutique.BoutiqueBrandMapper;
import com.unicdata.dao.boutique.BoutiqueClassifyMapper;
import com.unicdata.dao.boutique.BoutiqueInformationMapper;
import com.unicdata.dao.boutique.BoutiqueSupplierBrandMapper;
import com.unicdata.dao.boutique.BoutiqueSupplierMapper;
import com.unicdata.dao.boutique.BoutiqueWarehouseMapper;
import com.unicdata.dao.boutique.BoutiqueWarehousePositionMapper;
import com.unicdata.dao.car.CarFamilyMapper;
import com.unicdata.dao.counter.CounterMapper;
import com.unicdata.entity.boutique.BoutiqueBrand;
import com.unicdata.entity.boutique.BoutiqueClassify;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiqueSupplier;
import com.unicdata.entity.boutique.BoutiqueSupplierBrand;
import com.unicdata.entity.boutique.BoutiqueWarehouse;
import com.unicdata.entity.boutique.BoutiqueWarehousePosition;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.entity.counter.Counter;
import com.unicdata.entity.system.Employee;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicdata.service.CounterService;
import com.unicdata.service.boutique.BoutiqueImportService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoutiqueImportServiceImpl implements BoutiqueImportService {

    @Autowired
    private BoutiqueWarehouseMapper boutiqueWarehouseMapper;

    @Autowired
    private BoutiqueWarehousePositionMapper boutiqueWarehousePositionMapper;

    @Autowired
    private BoutiqueClassifyMapper boutiqueClassifyMapper;
    
    @Autowired
    private CounterMapper counterMapper;
    
    @Autowired
    private BoutiqueBrandMapper boutiqueBrandMapper;
    
    @Autowired
    private BoutiqueSupplierMapper boutiqueSupplierMapper;
    
    @Autowired
    private CarFamilyMapper carFamilyMapper;
    
    @Autowired
    private BoutiqueInformationMapper boutiqueInformationMapper;
    
    @Autowired
    private CounterService counterService;
    
    @Autowired
    private BoutiqueSupplierBrandMapper boutiqueSupplierBrandMapper;
    
    @Override
    public void exportModel(HttpServletResponse response, String fileUrl, String fileName) throws Exception {

        fileName = new String(fileName.getBytes(), "iso8859-1");// 解决中文
        // 文件名问题
        response.reset();// 清空输出流
        response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls"); // 设定输出文件头,该方法有两个参数，分别表示应答头的名字和值。
        response.setContentType("application/msexcel");

        HttpURLConnection conn = null;
        InputStream inputStream = null;
        // 建立链接
        URL httpUrl = new URL(fileUrl);
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
    }


    @Transactional(readOnly = false)
    @Override
    public Map<String, String> uploadPosition(HttpServletRequest request, MultipartFile file, Integer warehouseId) {
        //获取仓库
        BoutiqueWarehouse boutiqueWarehouse = boutiqueWarehouseMapper.selectByPrimaryKey(warehouseId);
        //门店ID
        Integer storeId = boutiqueWarehouse.getStoreId();
        //仓库名称
        String wareHouseName = boutiqueWarehouse.getName();
        Map<String, String> result = new HashMap<>();
        result.put("status", "200");
        result.put("msg", "上传成功！");
        try {
            XSSFWorkbook book = new XSSFWorkbook(file.getInputStream());
            XSSFSheet sheet = book.getSheetAt(0);
            //第几行
            int count = 0;
            //遍历行
            for (Row row : sheet) {
                // 跳过第一行的标题
                if (count == 0) {
                    count++;
                    continue;
                }
                //将所有列单位设置位string类型
                for (Cell cell : row) {
                    if (cell != null) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                }
                //获取仓库名
                String warehouseName = getCellValue(row,0);
                if (Objects.equals(warehouseName, wareHouseName)) {
                    //获取库位名称
                    String positionName = getCellValue(row,1);
                    //如果该库位不存在就导入
                    BoutiqueWarehousePosition position = new BoutiqueWarehousePosition();
                    position.setWarehouseId(warehouseId);
                    position.setName(positionName);
                    position.setStoreId(storeId);
                    boutiqueWarehousePositionMapper.insertSelective(position);
                }
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("msg", "上传错误，请检查文件格式！");
            result.put("status", "500");
        }
        return result;
    }


	@Override
	@Transactional
	public Map<String, String> uploadClassify(HttpServletRequest request, MultipartFile file,Employee member) {
        Map<String, String> result = new HashMap<>();
        result.put("status", "200");
        result.put("msg", "上传成功！");
		
        List<BoutiqueClassify> allClassify = new ArrayList<>();
        List<BoutiqueClassify> superParent = new ArrayList<>();
        Map<String, BoutiqueClassify> allClassifyMap = new HashMap<>();
        XSSFWorkbook book;
		try {
			book = new XSSFWorkbook(file.getInputStream());
			XSSFSheet sheet = book.getSheetAt(0);
			
            //第几行
            int count = 0;
            //遍历行
            for (Row row : sheet) {
                // 跳过第一行的标题
                if (count == 0) {
                    count++;
                    continue;
                }
			
                //将所有列单位设置位string类型
                for (Cell cell : row) {
                    if (cell != null) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                }
                BoutiqueClassify classify = new BoutiqueClassify();

                Cell cell = row.getCell(0);
                if(cell == null || cell.getStringCellValue() ==null){
                	break;
                }
                String name = getCellValue(row,0);
                String code = getCellValue(row,1);
                String parentCode = getCellValue(row,2);
                String level = getCellValue(row,3);
                String have_son = getCellValue(row,4);
                
                classify.setClassify(name);
                classify.setCode(code);
                classify.setLevel(Integer.parseInt(level));
                classify.setHaveSon(Integer.parseInt(have_son));
                classify.setStoreId(member.getStoreId());
                classify.setClassifyUse(0);
                classify.setTypeLive(1);

                Integer parentId = 0;
                if(StringUtils.isBlank(parentCode)){
                	classify.setParentId(parentId);
                	superParent.add(classify);
                }else{
                	classify.setParentCode(parentCode);
                	BoutiqueClassify boutiqueClassify = allClassifyMap.get(parentCode);
                	classify.setParentName(boutiqueClassify.getClassify());
                	allClassify.add(classify);
                }
                allClassifyMap.put(code, classify);
            }
            
            for(int i = 0; i < superParent.size() ; i++){
            	BoutiqueClassify classify = superParent.get(i);
            	boutiqueClassifyMapper.insertSelective(classify);
            }
            
            for(int i = 0 ; i < allClassify.size() ; i++){
            	BoutiqueClassify classify = allClassify.get(i);
            	String parentCode = classify.getParentCode();
            	String parentName = classify.getParentName();
            	BoutiqueClassify parent = boutiqueClassifyMapper.selectClassifyByCode(member.getStoreId(),parentCode,parentName);
            	classify.setParentId(parent.getId());
            	boutiqueClassifyMapper.insert(classify);
            	
//            	if(classify.getHaveSon() == 0){
            		Integer code = counterMapper.findCounterCode(Counter.BOUTIQUE_CLASSIFY_PRE + "_" + parentCode + "_" + classify.getCode());
            		if(code == null || code == 0){
            			Counter counter = new Counter();
            			counter.setCounter(1);
            			counter.setCodePrefix(Counter.BOUTIQUE_CLASSIFY_PRE + "_" + parentCode + "_" + classify.getCode());
            			counterMapper.insert(counter);
            		}
//            	}
            }
		} catch (Exception e) {
            e.printStackTrace();
            result.put("msg", "上传错误，请检查文件格式！");
            result.put("status", "500");
		}
        
		return result;
	}

	@Override
	public Map<String, String> uploadSupplier(HttpServletRequest request, MultipartFile file, Employee member) {
        Map<String, String> result = new HashMap<>();
        result.put("status", "200");
        result.put("msg", "上传成功！");
		
        List<BoutiqueSupplier> allSupplier = new ArrayList<>();
        
        XSSFWorkbook book;
		
        try {
			
			book = new XSSFWorkbook(file.getInputStream());
			XSSFSheet sheet = book.getSheetAt(0);
			
            //第几行
            int count = 0;
            //遍历行
            for (Row row : sheet) {
                // 跳过第一行的标题
                if (count == 0) {
                    count++;
                    continue;
                }
			
                //将所有列单位设置位string类型
                for (Cell cell : row) {
                    if (cell != null) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                }
                
                BoutiqueSupplier supplier = new BoutiqueSupplier();
                
                supplier.setName(getCellValue(row,0));
                supplier.setCompanyTel(getCellValue(row,1));
                supplier.setContactsOne(getCellValue(row,2));
                supplier.setContactsOnePhone(getCellValue(row,3));

                supplier.setContactsTwo(getCellValue(row,4));
                supplier.setContactsTwoPhone(getCellValue(row,5));
                supplier.setAddress(getCellValue(row,8));
                supplier.setIsHost(judgeHost(getCellValue(row,7)));
                
                String fineBrandNames = getCellValue(row,6);

                StringBuilder sbl = new StringBuilder();

                List<Integer> brandIds = new ArrayList<Integer>();
                if(fineBrandNames.indexOf(",") >= 0 || fineBrandNames.indexOf("，") >= 0){ //中英文逗号
                	String[] split = fineBrandNames.split(",");
                	if(split.length == 0){
                		split = fineBrandNames.split("，");
                	}
                	for(int i = 0 ; i < split.length ; i++){
                		BoutiqueBrand brand = boutiqueBrandMapper.selectBySupplierName(split[i]);
                		brandIds.add(brand.getId());
                		if(i == split.length - 1){
                			sbl.append(brand.getId());
                		}else{
                			sbl.append(brand.getId() + ",");
                		}
                	}
                }else{
                	BoutiqueBrand brand = boutiqueBrandMapper.selectBySupplierName(fineBrandNames);
                	sbl.append("" + brand.getId());
                	brandIds.add(brand.getId());
                }
                supplier.setFineBrandIds( sbl.toString() );
                supplier.setStoreId(member.getStoreId());
                supplier.setTypeLive(1);
                int id = boutiqueSupplierMapper.insertUseGeneratedKeys(supplier);
                
                List<BoutiqueSupplierBrand> BoutiqueSupplierBrands = new ArrayList<>();
                for(Integer brandId :brandIds){
                	BoutiqueSupplierBrand supplierBrand = new BoutiqueSupplierBrand();
                	supplierBrand.setBrandId(brandId);
                	supplierBrand.setSuppilerId(supplier.getId());
                	BoutiqueSupplierBrands.add(supplierBrand);
                }
                
                for (BoutiqueSupplierBrand supplierBrand :BoutiqueSupplierBrands) {
                	boutiqueSupplierBrandMapper.insertSelective(supplierBrand);
				}
                
            }
		} catch (Exception e) {
            e.printStackTrace();
            result.put("msg", "上传错误，请检查文件格式！");
            result.put("status", "500");
		}
		return result;
	}

	/**
	 * 判断是否是主机厂
	 * @param isHostStr
	 * @return
	 */
	private int judgeHost(String isHostStr) {
		switch (isHostStr) {
			case "是": return 1;
			case "否": return 0;
		}
		return 0;
	}


	/**
	 * 获取表格内容
	 * @param row
	 * @param index
	 * @return
	 */
	private String getCellValue(Row row, int index) {
		Cell cell = row.getCell(index);
		if(cell != null){
			return cell.getStringCellValue().trim();
		}
		return null;
	}

	@Override
	public Map<String, String> uploadBrand(HttpServletRequest request, MultipartFile file, Employee member) {
        Map<String, String> result = new HashMap<>();
        result.put("status", "200");
        result.put("msg", "上传成功！");
		
        XSSFWorkbook book;
		
        try {
			book = new XSSFWorkbook(file.getInputStream());
			XSSFSheet sheet = book.getSheetAt(0);
			
            //第几行
            int count = 0;
            //遍历行
            for (Row row : sheet) {
                // 跳过第一行的标题
                if (count == 0) {
                    count++;
                    continue;
                }
			
                //将所有列单位设置位string类型
                for (Cell cell : row) {
                    if (cell != null) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                }
                
               BoutiqueBrand brand = new BoutiqueBrand();
               brand.setTypeLive(1);
               brand.setStoreId(member.getStoreId());
               String name = getCellValue(row,0);
               if(StringUtils.isNotBlank(name)){
            	   brand.setName(name);
            	   boutiqueBrandMapper.insertSelective(brand);
               }
            }
		} catch (Exception e) {
            e.printStackTrace();
            result.put("msg", "上传错误，请检查文件格式！");
            result.put("status", "500");
		}
		return result;
	}


	@Override
	public Map<String, String> uploadBoutique(HttpServletRequest request, MultipartFile file, Employee member) {
        Map<String, String> result = new HashMap<>();
        result.put("status", "200");
        result.put("msg", "上传成功！");
		
        List<BoutiqueWarehouse> findAllWH = boutiqueWarehouseMapper.findAll(member.getStoreId());
        Map<String, BoutiqueWarehouse> AllWHMap = new HashMap<>();
        for (BoutiqueWarehouse warehouse : findAllWH) {
        	List<BoutiqueWarehousePosition> findAllPos = boutiqueWarehousePositionMapper.findAllByWarehouseId(warehouse.getId(), member.getStoreId());
        	Map<String, BoutiqueWarehousePosition> allPosition = new HashMap<>();
        	warehouse.setList(findAllPos);
        	for (BoutiqueWarehousePosition position : findAllPos) {
        		allPosition.put(position.getName().trim(), position);
			}
        	warehouse.setPosMap(allPosition);
        	AllWHMap.put(warehouse.getName().trim(), warehouse);
		}
        
        List<BoutiqueClassify> classifyAll = boutiqueClassifyMapper.selectBoutiqueClassifyAll(member.getStoreId());
        Map<String, BoutiqueClassify> classifyAllMap = new HashMap<>();
        for (BoutiqueClassify classify : classifyAll) {
        	classifyAllMap.put(classify.getClassify().trim(), classify);
		}
        
        List<CarFamily> allCarFamily = carFamilyMapper.findAllFamilyByStoreId(member.getStoreId());
        Map<String, CarFamily>  carFamilyMap = new HashMap<>();
        for (CarFamily carFamily : allCarFamily) {
        	carFamilyMap.put(carFamily.getName().trim(), carFamily);
		}
        
        
        List<BoutiqueBrand> findAllBrand = boutiqueBrandMapper.findAll(member.getStoreId());
        Map<String, BoutiqueBrand> allBrandMap = new HashMap<>();
        for (BoutiqueBrand boutiqueBrand : findAllBrand) {
        	allBrandMap.put(boutiqueBrand.getName().trim(), boutiqueBrand);
		}
        
        
        List<BoutiqueSupplier> findAllSupplier = boutiqueSupplierMapper.selectAllSupplier(member.getStoreId());
        Map<String, BoutiqueSupplier> allSupplierMap = new HashMap<>();
        for (BoutiqueSupplier boutiqueSupplier : findAllSupplier) {
        	allSupplierMap.put(boutiqueSupplier.getName().trim(), boutiqueSupplier);
		}
        
        ConstructionNode[] values = BoutiqueEnum.ConstructionNode.values();
        Map<String, Integer> nodeMap = new HashMap<>();
        for (ConstructionNode node : values) {
        	nodeMap.put(node.getReason().trim(), node.getCode());
		}
        
        
        XSSFWorkbook book;
		try {
			book = new XSSFWorkbook(file.getInputStream());
			XSSFSheet sheet = book.getSheetAt(0);
			
			List<BoutiqueInformation> allInfo = new ArrayList<>();
			
            //第几行
            int count = 0;
            //遍历行
            for (Row row : sheet) {
                // 跳过第一行的标题
                if (count == 0) {
                    count++;
                    continue;
                }
                
                //将所有列单位设置位string类型
                for (Cell cell : row) {
                    if (cell != null) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                }
                
                BoutiqueInformation info = new BoutiqueInformation();
                
                info.setName(getCellValue(row,1));//精品名称
                String wareHouseName = getCellValue(row,2);//仓库
                BoutiqueWarehouse warehouse = AllWHMap.get(wareHouseName);
                info.setWarehouseId(warehouse.getId());
                
                Map<String, BoutiqueWarehousePosition> posMap = warehouse.getPosMap();
                String positionName = getCellValue(row,3);//库位名称
                BoutiqueWarehousePosition position = posMap.get(positionName);
                info.setPositionId(position.getId());
                
                String safetyStock = getCellValue(row,4);//安全库存
                info.setSafetyStock(Integer.parseInt(safetyStock));
                
                String cautionDate = getCellValue(row,5);//警戒天数
                info.setCautionDate(cautionDate);
                
                String classifyName = getCellValue(row,6);//分类
                StringBuilder sbl = new StringBuilder();
                StringBuilder codeSbl = new StringBuilder();
                
                String code = null;
                if(classifyName.indexOf("-") >= 0){
                	String[] split = classifyName.split("-");
                	for(int i = 0 ; i < split.length ; i++){
                    	BoutiqueClassify classify = classifyAllMap.get(split[i].trim());
                    	if(i == split.length - 1){
                    		sbl.append(classify.getId());
                    		BoutiqueClassify classifyParent = boutiqueClassifyMapper.selectByPrimaryKey(classify.getParentId());
                    		code = counterService.generateCodeBoutique(Counter.BOUTIQUE_CLASSIFY_PRE + "_" + classifyParent.getCode() + "_" + classify.getCode(), 5);
                    		info.setClassifyId(classify.getId());
                    		boutiqueClassifyMapper.updateClassifyUse(classify.getId());
                    	}else{
                    		sbl.append(classify.getId() + "-");
                    	}
                    	codeSbl.append(classify.getCode());
                	}
                	info.setClassify(sbl.toString());
                }else{
                	BoutiqueClassify classify = classifyAllMap.get(classifyName.trim());
                	info.setClassify(classify.getId() + "");
                	info.setClassifyId(classify.getId());
                	BoutiqueClassify classifyParent = boutiqueClassifyMapper.selectByPrimaryKey(classify.getParentId());
                	code = counterService.generateCodeBoutique(Counter.BOUTIQUE_CLASSIFY_PRE + "_" + classifyParent.getCode() + "_" + classify.getCode(), 5);
                	codeSbl.append(classify.getCode());
                }
                info.setCode(codeSbl.toString() + code);
                
                String carFamilys = getCellValue(row,7);//车系分类
                StringBuilder carSbl = new StringBuilder();
                if(carFamilys.indexOf("、") >= 0){
                	String[] split = carFamilys.split("、");
                	for(int i = 0 ; i < split.length ; i++){
                		CarFamily carFamily = carFamilyMap.get(split[i].trim());
                		
                		if(i == split.length - 1){
                			carSbl.append(carFamily.getId());
                		}else{
                			carSbl.append(carFamily.getId() + ",");
                		}
                	}
                	info.setCarClassifyId(carSbl.toString());
                }else{
                	CarFamily carFamily = carFamilyMap.get(carFamilys.trim());
                	info.setCarClassifyId(carFamily.getId() + "");
                }
                
                String brand = getCellValue(row,8);//精品品牌
                BoutiqueBrand boutiqueBrand = allBrandMap.get(brand.trim());
                info.setBrandId(boutiqueBrand.getId());
                
                info.setCompany(getCellValue(row,9));//单位
                
                String node = getCellValue(row,10);//交车节点
                info.setConstructionNode(nodeMap.get(node.trim()));
                
                String supplierName = getCellValue(row,11);//供应商
                BoutiqueSupplier supplier = allSupplierMap.get(supplierName.trim());
                info.setSupplierId(supplier.getId());
                
                String tax_priceStr = getCellValue(row,12);//含税成本单价
                info.setTaxPrice(new BigDecimal(tax_priceStr));
                
                String coefficientStr = getCellValue(row,13);//精品系数
                info.setCoefficient(new BigDecimal(coefficientStr));
                
                String workinghoursStr = getCellValue(row,14);//标准工时
                info.setWorkinghours(new Double(workinghoursStr));
                
                String expect_workinghoursStr = getCellValue(row,15);//预计完成时长
                info.setExpectWorkinghours(new Double(expect_workinghoursStr));
                
                String labor_costStr = getCellValue(row,16);//工时费
                info.setLaborCost(new Double(labor_costStr));
                
                String original_code =  getCellValue(row,17);//原厂精品编号
                info.setOriginalCode(original_code);
                
                String saleType = getCellValue(row,18);//售卖类型
                info.setSaleType(saleType);
                
                info.setStoreId(member.getStoreId());
    			info.setTaxCost(new BigDecimal(0));
    			info.setStatus(1);
    			info.setTypeLive(1);
    			info.setStock(0);
    			info.setVersion(0);
    			info.setIsShelf(1);
    			info.setUnitprice(info.getTaxPrice().multiply(info.getCoefficient()));
                allInfo.add(info);
            }
            
            boutiqueInformationMapper.insertBatch(allInfo);
            
		} catch (Exception e) {
            e.printStackTrace();
            result.put("msg", "上传错误，请检查文件格式！");
            result.put("status", "500");
		}
		return result;
	}
}
