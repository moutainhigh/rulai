package com.unicdata.service.boutique.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.condition.BoutiqueInfoCondition;
import com.unicdata.constant.BoutiqueEnum.ConstructionNode;
import com.unicdata.dao.boutique.BoutiqueClassifyMapper;
import com.unicdata.dao.boutique.BoutiqueInformationMapper;
import com.unicdata.dao.car.CarFamilyMapper;
import com.unicdata.entity.boutique.BoutiqueClassify;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.entity.counter.Counter;
import com.unicdata.service.CounterService;
import com.unicdata.service.boutique.BoutiqueInformationService;
@Service
@Transactional
public class BoutiqueInformationServiceImpl implements BoutiqueInformationService {

	@Autowired
	private BoutiqueInformationMapper infoMapper;
	
	@Autowired
	private BoutiqueClassifyMapper boutiqueClassifyMapper;
	
//	@Autowired
//	private CounterMapper counterMapper;
	
	@Autowired
	private CounterService counterService;
	
	@Autowired
	private CarFamilyMapper carFamilyMapper;
	
	@Value("${upload.access.path}")
	private String pictuerURL;	
	
	@Override
	public int insert(BoutiqueInformation record) {
		String classify = record.getClassify();
		StringBuilder builder = new StringBuilder();
		
		if(classify.indexOf("-") >= 0){
			String[] split = classify.split("-");
			for(int i = 0 ; i < split.length ; i++){
				int classifyId = Integer.parseInt(split[i]);
				BoutiqueClassify classify2 = boutiqueClassifyMapper.selectByPrimaryKey(classifyId);
				builder.append(classify2.getCode());
				
				if( i == split.length -1){
					
					BoutiqueClassify classify3 = boutiqueClassifyMapper.selectByPrimaryKey(classify2.getParentId());
					String code = counterService.generateCodeBoutique(Counter.BOUTIQUE_CLASSIFY_PRE + "_" + classify3.getCode() + "_" + classify2.getCode(), 5);
					builder.append(code);
				}
			}
		}else{
			int classifyId = Integer.parseInt(classify);
			BoutiqueClassify classify2 = boutiqueClassifyMapper.selectByPrimaryKey(classifyId);
			builder.append(classify2.getCode());
			BoutiqueClassify classify3 = boutiqueClassifyMapper.selectByPrimaryKey(classify2.getParentId());
			String code = counterService.generateCodeBoutique(Counter.BOUTIQUE_CLASSIFY_PRE + "_" + classify3.getCode() + "_" + classify2.getCode(), 5);
			builder.append(code);
		}
		record.setCode(builder.toString());
		return infoMapper.insert(record);
	}

	@Override
	public int insertSelective(BoutiqueInformation record) {
		return infoMapper.insertSelective(record);
	}

	@Override
	public int deleteById(Integer id) {
		int delete = 0;
		synchronized (BoutiqueInformationServiceImpl.class) {
			delete = infoMapper.deleteById(id);
		}
		return delete;
	}

	@Override
	public int update(BoutiqueInformation info) {
		int update =  0 ;
		synchronized (BoutiqueInformationServiceImpl.class) {
			String picture = info.getPicture();
			if(StringUtils.isNotBlank(picture)){
				if(picture.indexOf(pictuerURL) >= 0){
					picture = picture.substring(pictuerURL.length(), picture.length());
					info.setPicture(picture);
				}
			}
			update = infoMapper.updateByPrimaryKeySelective(info);
		}
		return update;
	}

	@Override
	public PageInfo<Map<String, Object>> selectBoutiqueInfoByConditionPage(BoutiqueInfoCondition condition,Integer storeId) {
		Integer pageNum = condition.getPageNum();
		Integer pageSize = condition.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		condition.setStoreId(storeId);
		Page<Map<String, Object>> page = infoMapper.selectBoutiqueInfoByCondition(condition);
		
		List<BoutiqueClassify> classifyAll = boutiqueClassifyMapper.selectBoutiqueClassifyAllType(storeId);
		Map<Integer, BoutiqueClassify> classifyAllMap = new HashMap<Integer, BoutiqueClassify>();
		for (BoutiqueClassify boutiqueClassify : classifyAll) {
			classifyAllMap.put(boutiqueClassify.getId(), boutiqueClassify);
		}
		
		List<CarFamily> findAllFamilyByStoreId = carFamilyMapper.findAllFamilyByStoreId(storeId);
		Map<Integer, CarFamily> carFamilyMap = new HashMap<Integer, CarFamily>();
		for (CarFamily carFamily : findAllFamilyByStoreId) {
			carFamilyMap.put(carFamily.getId(), carFamily);
		}
		
		int no = 1 ;
		if(pageNum >1 ){
			no = (pageNum - 1) * pageSize +1;
		}
		
		for(int i = 0; i < page.size() ; i ++){
			BoutiqueInformation info = (BoutiqueInformation)page.get(i);
			
			String classify = info.getClassify();
			if(StringUtils.isNotBlank(classify)){
				String[] split = classify.split("-");
				StringBuilder builder = new StringBuilder();
				for (int j = 0 ; j < split.length ; j ++) {
					if(j == 0 ){
						builder.append(classifyAllMap.get(Integer.parseInt(split[j])).getClassify());
					}else{
						builder.append("-" + classifyAllMap.get(Integer.parseInt(split[j])).getClassify());
					}
				}
				info.setClassifyStr(builder.toString());
			}
			Integer constructionNode = info.getConstructionNode();
			info.setConstructionNodeStr(ConstructionNode.getReason(constructionNode));
			
			StringBuilder carSbl = getCarFamily(carFamilyMap, info);
			info.setCarClassify(carSbl.toString());
			if(StringUtils.isNotBlank(info.getPicture())){
				info.setPicture(pictuerURL + info.getPicture());
			}
			info.setNo(no);
			no++;
		}
		return page.toPageInfo();
	}

	private StringBuilder getCarFamily(Map<Integer, CarFamily> carFamilyMap, BoutiqueInformation info) {
		String carClassifyId = info.getCarClassifyId();
		StringBuilder carSbl = new StringBuilder();
		if(StringUtils.isNotBlank(carClassifyId)){
			if(carClassifyId.indexOf(",") >= 0){
				String[] split = carClassifyId.split(",");

				for(int j = 0 ; j < split.length ; j++){
					CarFamily carFamily = carFamilyMap.get(Integer.parseInt(split[j]));
					if(carFamily != null){
						if( j == split.length - 1){
							carSbl.append(carFamily.getName() == null ? "" : carFamily.getName());
						}else{
							carSbl.append(carFamily.getName() == null ? "" : carFamily.getName() + " , ");
						}
					}
				}
				
			}else{
				CarFamily carFamily = carFamilyMap.get(Integer.parseInt(carClassifyId));
				if(carFamily != null){
					carSbl.append(carFamily.getName() == null ? "" : carFamily.getName() );
				}
			}
		}
		return carSbl;
	}

	@Override
	public BoutiqueInformation selectBoutiqueInfoById(Integer id, Integer storeId) {
		
		BoutiqueInformation info = infoMapper.selectBoutiqueInfoById(id,storeId);
		
		List<BoutiqueClassify> classifyAll = boutiqueClassifyMapper.selectBoutiqueClassifyAll(storeId);
		Map<Integer, BoutiqueClassify> classifyAllMap = new HashMap<Integer, BoutiqueClassify>();
		for (BoutiqueClassify boutiqueClassify : classifyAll) {
			classifyAllMap.put(boutiqueClassify.getId(), boutiqueClassify);
		}
		
		List<CarFamily> findAllFamilyByStoreId = carFamilyMapper.findAllFamilyByStoreId(storeId);
		
		Map<Integer, CarFamily> carFamilyMap = new HashMap<Integer, CarFamily>();
		for (CarFamily carFamily : findAllFamilyByStoreId) {
			carFamilyMap.put(carFamily.getId(), carFamily);
		}
		String classify = info.getClassify();
		if(StringUtils.isNotBlank(classify)){
			if(classify.indexOf("-") >= 0){
				String[] split = classify.split("-");
				StringBuilder builder = new StringBuilder();
				for (int j = 0 ; j < split.length ; j ++) {
					if(j == 0 ){
						builder.append(classifyAllMap.get(Integer.parseInt(split[j])).getClassify());
					}else{
						builder.append("-" + classifyAllMap.get(Integer.parseInt(split[j])).getClassify());
					}
				}
				info.setClassifyStr(builder.toString());
//				info.setClassify();
			}else{
				info.setClassifyStr(classifyAllMap.get(Integer.parseInt(classify)).getClassify());
//				info.setClassify(classifyAllMap.get(Integer.parseInt(classify)).getClassify());
			}
		}
		
		if(StringUtils.isNotBlank(info.getPicture())){
			info.setPicture(pictuerURL + info.getPicture());
		}
		
		StringBuilder builder = getCarFamily(carFamilyMap,info);
		info.setCarClassify(builder.toString());
		return info;
	}

	@Override
	public int updateBoutiqueStatus(BoutiqueInformation info) {
		return infoMapper.updateBoutiqueStatus(info);
	}

	@Override
	public List<BoutiqueInformation> selectBoutiqueInfoListByCondition(BoutiqueInfoCondition condition,
			Integer storeId) {
		condition.setStoreId(storeId);
		List<BoutiqueInformation> list = infoMapper.selectBoutiqueInfoListByCondition(condition);
		
		List<BoutiqueClassify> classifyAll = boutiqueClassifyMapper.selectBoutiqueClassifyAll(storeId);
		Map<Integer, BoutiqueClassify> classifyAllMap = new HashMap<Integer, BoutiqueClassify>();
		for (BoutiqueClassify boutiqueClassify : classifyAll) {
			classifyAllMap.put(boutiqueClassify.getId(), boutiqueClassify);
		}
		
		List<CarFamily> findAllFamilyByStoreId = carFamilyMapper.findAllFamilyByStoreId(storeId);
		Map<Integer, CarFamily> carFamilyMap = new HashMap<Integer, CarFamily>();
		for (CarFamily carFamily : findAllFamilyByStoreId) {
			carFamilyMap.put(carFamily.getId(), carFamily);
		}
		
		for(int i = 0; i < list.size() ; i ++){
			BoutiqueInformation info = (BoutiqueInformation)list.get(i);
			System.out.println();
			String classify = info.getClassify();
			if(StringUtils.isNotBlank(classify)){
				String[] split = classify.split("-");
				StringBuilder builder = new StringBuilder();
				for (int j = 0 ; j < split.length ; j ++) {
					if(j == 0 ){
						builder.append(classifyAllMap.get(Integer.parseInt(split[j])).getClassify());
					}else{
						builder.append("-" + classifyAllMap.get(Integer.parseInt(split[j])).getClassify());
					}
				}
				info.setClassifyStr(builder.toString());
			}
			Integer constructionNode = info.getConstructionNode();
			info.setConstructionNodeStr(ConstructionNode.getReason(constructionNode));
			StringBuilder builder = getCarFamily(carFamilyMap,info);
			info.setCarClassify(builder.toString());
			
		}
		return list;
	}

}
