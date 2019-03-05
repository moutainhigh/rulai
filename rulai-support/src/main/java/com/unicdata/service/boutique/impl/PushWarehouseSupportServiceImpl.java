package com.unicdata.service.boutique.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.condition.PushWareHouseCondition;
import com.unicdata.dao.boutique.BoutiqueInformationMapper;
import com.unicdata.dao.boutique.BoutiquePushWarehouseDetailMapper;
import com.unicdata.dao.boutique.BoutiquePushWarehouseMapper;
import com.unicdata.dao.boutique.BoutiqueSupplierMapper;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiquePushWarehouse;
import com.unicdata.entity.boutique.BoutiquePushWarehouseDetail;
import com.unicdata.entity.boutique.BoutiqueSupplier;
import com.unicdata.service.boutique.PushWarehouseSupportService;
@Service
public class PushWarehouseSupportServiceImpl extends BoutiquePushWarehouseServiceImpl  implements PushWarehouseSupportService {

	@Autowired
	private BoutiquePushWarehouseMapper pushWarehouseMapper;
	
	@Autowired
	private BoutiquePushWarehouseDetailMapper boutiquePushWarehouseDetailMapper;
	
	@Autowired
	private BoutiqueInformationMapper boutiqueInformationMapper;
	
	@Autowired
	private BoutiqueSupplierMapper boutiqueSupplierMapper;
	
	@Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
	public int insert(BoutiquePushWarehouse info) {
		List<BoutiquePushWarehouseDetail> list = info.getList();
		info.setNum(list.size());
		info.setTypeLive(1);
		info.setPushTime(new Date());
		int id = pushWarehouseMapper.insertuseGeneratedKeys(info);
		int count = 0;
		for (BoutiquePushWarehouseDetail detail : list) {
			detail.setPushId(info.getId());
			Integer boutiqueId = detail.getBoutiqueId();
			
			int insert_count = 0;
			while(true){
				
				if(insert_count == 3){
					return 0;
				}
				
				BoutiqueInformation information = boutiqueInformationMapper.selectByPrimaryKey(boutiqueId);
				detail.setSalesType(information.getSaleType());
				Integer stock = detail.getStock();
				Integer historyStock = information.getStock();
				
				information.setSaleType(detail.getSalesType());
				BigDecimal taxPrice = information.getTaxPrice();// 信息表含税单价
				if(taxPrice == null || taxPrice.equals(BigDecimal.valueOf(0.00).setScale(2))){
					information.setTaxPrice(detail.getTaxUnitPrice());
					information.setUnitprice(detail.getTaxUnitPrice().multiply(information.getCoefficient()) );
					information.setTaxCost(detail.getTaxUnitPrice().multiply(BigDecimal.valueOf(stock)));
				}else{
					BigDecimal taxUnitPrice = detail.getTaxUnitPrice();//新增含税单价
					BigDecimal taxPriceAll = taxPrice.multiply(BigDecimal.valueOf(historyStock)).add(taxUnitPrice.multiply(BigDecimal.valueOf(stock))) ;
					information.setTaxPrice(taxPriceAll.divide(BigDecimal.valueOf(historyStock + stock),BigDecimal.ROUND_HALF_EVEN).setScale(2));
					information.setTaxCost(information.getTaxPrice().multiply(BigDecimal.valueOf(historyStock + stock)).setScale(2));
					information.setUnitprice(information.getTaxPrice().multiply(information.getCoefficient()) );
					detail.setSalesCost(information.getUnitprice());
				}
				information.setLastPushTime(new Date());
				information.setStock( historyStock + stock );
				int update = boutiqueInformationMapper.uppdateStock(information);
				if(update == 1){
					int insertSelective = boutiquePushWarehouseDetailMapper.insertSelective(detail);
					if(insertSelective == 0){
						return 0;
					}else{
						count++;
					}
					break;
				}
				insert_count++;
			}
		}
		return count;
	}

	@Override
	public PageInfo<Map<String, Object>> selectPushWarehouseByCondition(PushWareHouseCondition condition) {
		PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
		Page<Map<String, Object>> page = pushWarehouseMapper.selectPushWarehouseByCondition(condition);
		for(int i = 0 ; i < page.size() ; i++){
			BoutiquePushWarehouse info = (BoutiquePushWarehouse) page.get(i);
			Integer suppilerId = info.getSuppilerId();
			BoutiqueSupplier supplier = boutiqueSupplierMapper.selectByPrimaryKey(suppilerId);
			info.setSuppilerIdStr(supplier.getName());
			PushWareHouseCondition conditionList = new PushWareHouseCondition();
			conditionList.setId(info.getId());
			conditionList.setStoreId(condition.getStoreId());
			List<BoutiquePushWarehouseDetail> ushWarehouseDetails = boutiquePushWarehouseDetailMapper.selectPushWarehouseById(conditionList);
			info.setList(ushWarehouseDetails);
		}
		return page.toPageInfo();
	}

	@Override
	public List<BoutiquePushWarehouseDetail> selectPushWarehouseById(PushWareHouseCondition condition) {
		return boutiquePushWarehouseDetailMapper.selectPushWarehouseById(condition);
	}

}
