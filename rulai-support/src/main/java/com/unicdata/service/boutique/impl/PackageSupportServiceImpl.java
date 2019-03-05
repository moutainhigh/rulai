package com.unicdata.service.boutique.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.condition.BoutiquePackageCondition;
import com.unicdata.dao.boutique.BoutiqueInformationMapper;
import com.unicdata.dao.boutique.BoutiquePackageCarMapper;
import com.unicdata.dao.boutique.BoutiquePackageIncludeMapper;
import com.unicdata.dao.boutique.BoutiquePackageMapper;
import com.unicdata.dao.car.CarFamilyMapper;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiquePackage;
import com.unicdata.entity.boutique.BoutiquePackageCar;
import com.unicdata.entity.boutique.BoutiquePackageInclude;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.service.boutique.PackageSupportService;
@Service
public class PackageSupportServiceImpl extends BoutiquePackageServiceImpl implements PackageSupportService {

	@Autowired
	private BoutiquePackageMapper boutiquePackageMapper;
	
	@Autowired
	private BoutiquePackageIncludeMapper boutiquePackageIncludeMapper;
	
	@Autowired
	private BoutiquePackageCarMapper boutiquePackageCarMapper;
	
	@Autowired
	private BoutiqueInformationMapper boutiqueInformationMapper;
	
	
	@Value("${upload.access.path}")
	private String pictuerURL;
	
	@Override
	@Transactional
	public int insert(BoutiquePackage packageInfo) {
		int result = 0 ;
			List<BoutiquePackageInclude> list = packageInfo.getList();
			int count = 0 ;
			for (BoutiquePackageInclude include : list) {
				count += include.getInformationNum();
				include.setTypeLive(1);
			}
			packageInfo.setIncludeNum(count);
			packageInfo.setTypeLive(1);
			packageInfo.setStatus(1);
			
			int add = boutiquePackageMapper.insertUseGeneratedKeys(packageInfo);
			if(add == 1){
				result++;
				Integer packageId = packageInfo.getId();
				for (BoutiquePackageInclude include : list) {
					include.setPackageId(packageId);
					boutiquePackageIncludeMapper.insertSelective(include);
				}
				
				
				String carIds = packageInfo.getCarIds();
				List<BoutiquePackageCar> packageCars = new ArrayList<>();

				if(carIds.indexOf(",") >= 0){
					String[] split = carIds.split(",");
					for(int i = 0 ; i < split.length ; i++){
						BoutiquePackageCar packCar = new BoutiquePackageCar();
						packCar.setPackId(packageInfo.getId());
						int carId = Integer.parseInt(split[i]);
						packCar.setCarId(carId);
						CarFamily carFamily = carFamilyMapper.selectByPrimaryKey(carId);
						packCar.setCarName(carFamily.getName());
						packCar.setStoreId(packageInfo.getStoreId());
						packCar.setTypeLive(1);
						
						packageCars.add(packCar);
					}
				}else{
					BoutiquePackageCar packCar = new BoutiquePackageCar();
					packCar.setPackId(packageInfo.getId());
					int carId = Integer.parseInt(carIds);
					packCar.setCarId(carId);
					CarFamily carFamily = carFamilyMapper.selectByPrimaryKey(carId);
					packCar.setCarName(carFamily.getName());
					packCar.setStoreId(packageInfo.getStoreId());
					packCar.setTypeLive(1);
					packageCars.add(packCar);
				}
				
				for (BoutiquePackageCar boutiquePackageCar : packageCars) {
					boutiquePackageCarMapper.insert(boutiquePackageCar);
				}
			}
		return result;
	}

	@Autowired
	private CarFamilyMapper carFamilyMapper;
	@Override
	public PageInfo<Map<String, Object>> selectPackageByCondition(BoutiquePackageCondition condition) {
		Integer pageNum = condition.getPageNum();
		Integer pageSize = condition.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		Page<Map<String, Object>> page = boutiquePackageMapper.selectPackageByCondition(condition);
		int no = 1;
		if(pageNum > 1){
			no = (pageNum - 1) * pageSize + 1;
		}
		for(int i = 0; i < page.size() ; i ++){
			BoutiquePackage pack = (BoutiquePackage)page.get(i);
			
			
			pack.setPicture(pictuerURL + pack.getPicture());
			List<BoutiquePackageCar> packageCars = boutiquePackageCarMapper.selectCarByPackId(pack.getId());
			StringBuilder sbl = new StringBuilder();
			int size = packageCars.size();
			for(int j = 0 ; j < size ; j ++){
				BoutiquePackageCar packageCar = packageCars.get(j);
				if(size == 1){
					sbl.append(packageCar.getCarName());
				}else{
					if( j == size -1){
						sbl.append(packageCar.getCarName());
					}else{
						sbl.append(packageCar.getCarName() + " , ");
					}
				}
			}
			pack.setCarIdStr(sbl.toString());
			
			List<BoutiquePackageInclude> includes = boutiquePackageIncludeMapper.selectByPackageId(pack.getId());
			for (BoutiquePackageInclude include : includes) {
				BoutiqueInformation boutiqueInfo = boutiqueInformationMapper.selectBoutiqueInfoDetailById(include.getInformationId());
				include.setBoutiqueInfo(boutiqueInfo);
			}
			pack.setList(includes);
			pack.setNo(no);
			no++;
		}
		return page.toPageInfo();
	}

	@Override
	@Transactional
	public int updatePackageInfo(BoutiquePackage packageInfo) {
		int result = 0 ;
		List<BoutiquePackageInclude> list = packageInfo.getList();
		Map<Integer, BoutiquePackageInclude> listMap = new HashMap<Integer, BoutiquePackageInclude>();
		for (BoutiquePackageInclude include : list) {
			listMap.put(include.getInformationId(), include);
		}
		
		int count = 0 ;
		for (BoutiquePackageInclude include : list) {
			count += include.getInformationNum();
			include.setTypeLive(1);
		}
		packageInfo.setIncludeNum(count);
		packageInfo.setTypeLive(1);
		packageInfo.setStatus(1);

		String picture = packageInfo.getPicture();
		if(StringUtils.isNotBlank(picture)){
			if(picture.indexOf(pictuerURL) >= 0){
				picture = picture.substring(pictuerURL.length(), picture.length());
				packageInfo.setPicture(picture);
			}
		}
		
		int update = boutiquePackageMapper.updateByPrimaryKeySelective(packageInfo);
		
		List<BoutiquePackageInclude> historyList = boutiquePackageIncludeMapper.selectByPackageId(packageInfo.getId());
		Map<Integer, BoutiquePackageInclude> historyListMap = new HashMap<>();
		for (BoutiquePackageInclude include : historyList) {
			historyListMap.put(include.getInformationId(), include);
		}
		
		List<BoutiquePackageInclude> updateList = new ArrayList<>();
		List<BoutiquePackageInclude> insertList = new ArrayList<>();
		List<BoutiquePackageInclude> removeList = new ArrayList<>();
		
		List<BoutiquePackageCar> packageCarsHistory = boutiquePackageCarMapper.selectCarByPackId(packageInfo.getId());
		Map<Integer, BoutiquePackageCar> packageCarsHistoryMap = new HashMap<>();
		List<Integer> carIdsHistoryList = new ArrayList<>();
		if(packageCarsHistory != null && packageCarsHistory.size() > 0){
			for (BoutiquePackageCar packageCar : packageCarsHistory) {
				packageCarsHistoryMap.put(packageCar.getCarId(), packageCar);
				carIdsHistoryList.add(packageCar.getId());
			}
		}
		
		List<BoutiquePackageCar> historyCarsList = new ArrayList<>();
		List<BoutiquePackageCar> insertCarsList = new ArrayList<>();
		List<BoutiquePackageCar> removeCarsList = new ArrayList<>();
		
		
		if(update == 1){
			result++;
			Integer packageId = packageInfo.getId();
			
			for (int i = 0; i < list.size() ; i++) {
				BoutiquePackageInclude include = list.get(i);
				BoutiquePackageInclude include2 = historyListMap.get(include.getInformationId());
				if(include2 == null){
					include.setPackageId(packageId);
					insertList.add(include);
				}else{
					include.setId(include2.getId());
					updateList.add(include);
				}
				removeList.add(include2);
			}
			historyList.removeAll(removeList);
			
			for (BoutiquePackageInclude include : updateList) {
				boutiquePackageIncludeMapper.updateByPrimaryKeySelective(include);
			}
			
			for (BoutiquePackageInclude include : insertList) {
				boutiquePackageIncludeMapper.insert(include);
			}
			
			for (BoutiquePackageInclude include : historyList) {
				include.setTypeLive(0);
				if(include.getId() != null){
					boutiquePackageIncludeMapper.updateByPrimaryKeySelective(include);
				}
			}

			String carIds = packageInfo.getCarIds();
			List<Integer> carIdsList = new ArrayList<>();
			
			if(carIds.indexOf(",") >= 0){
				String[] split = carIds.split(",");
				for (String carId : split) {
					carIdsList.add(Integer.parseInt(carId));
				}
			}else{
				carIdsList.add(Integer.parseInt(carIds));
			}
			
			for(int i = 0 ; i < carIdsList.size() ; i++){
				Integer carId = carIdsList.get(i);
				
				BoutiquePackageCar packageCar = packageCarsHistoryMap.get(carId);
				if(packageCar == null){
					BoutiquePackageCar newCar = new BoutiquePackageCar();
					newCar.setPackId(packageInfo.getId());
					newCar.setCarId(carId);
					CarFamily carFamily = carFamilyMapper.selectByPrimaryKey(carId);
					newCar.setCarName(carFamily.getName());
					newCar.setStoreId(packageInfo.getStoreId());
					newCar.setTypeLive(1);
					insertCarsList.add(newCar);
				}else{
					packageCarsHistoryMap.remove(carId);
				}
				
			}
			
			for(int i = 0 ; i < insertCarsList.size() ; i ++){
				BoutiquePackageCar packageCar = insertCarsList.get(i);
				packageCar.setStoreId(packageInfo.getStoreId());
				boutiquePackageCarMapper.insert(insertCarsList.get(i));
			}
			
			if(packageCarsHistoryMap != null && packageCarsHistoryMap.size() >0){
				Set<Integer> keySet = packageCarsHistoryMap.keySet();
				for (Integer carId : keySet) {
					BoutiquePackageCar packageCar = packageCarsHistoryMap.get(carId);
					packageCar.setTypeLive(0);
					boutiquePackageCarMapper.updateByPrimaryKeySelective(packageCar);
				}
			}
			
			
		}
		return result;
	}

	@Override
	@Transactional
	public int updatePackageInfoDrop(Integer id,Integer status) {
		int packageUpdate = boutiquePackageMapper.updatePackageInfoDrop(id,status);
		
		if(packageUpdate == 1 ){
			return 1;
		}
		return 0;
	}

	@Override
	public BoutiquePackage selectPackageById(Integer id) {
		BoutiquePackage package1 = boutiquePackageMapper.selectByPrimaryKey(id);
		List<BoutiquePackageInclude> list = boutiquePackageIncludeMapper.selectByPackageId(id);
		for (BoutiquePackageInclude include : list) {
			BoutiqueInformation information = boutiqueInformationMapper.selectByPrimaryKey(include.getInformationId());
			include.setBoutiqueInfo(information);
		}
		
		List<BoutiquePackageCar> packageCars = boutiquePackageCarMapper.selectCarByPackId(package1.getId());
		StringBuilder sbl = new StringBuilder();
		for(int i = 0 ; i < packageCars.size() ; i ++){
			BoutiquePackageCar boutiquePackageCar = packageCars.get(i);
			if(i == packageCars.size() - 1){
				sbl.append(boutiquePackageCar.getCarName());
			}else{
				sbl.append(boutiquePackageCar.getCarName() + " , ");
			}
		}
		package1.setCarIdStr(sbl.toString());
		package1.setList(list);
		return package1;
	}

}
