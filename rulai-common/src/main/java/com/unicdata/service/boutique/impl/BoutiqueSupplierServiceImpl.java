package com.unicdata.service.boutique.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.boutique.BoutiqueBrandMapper;
import com.unicdata.dao.boutique.BoutiqueSupplierMapper;
import com.unicdata.entity.boutique.BoutiqueBrand;
import com.unicdata.entity.boutique.BoutiqueSupplier;
import com.unicdata.service.boutique.BoutiqueSupplierService;
@Service
public class BoutiqueSupplierServiceImpl implements BoutiqueSupplierService {

	@Autowired
	private BoutiqueSupplierMapper supplierMapper ;
	
	@Autowired
	private BoutiqueBrandMapper boutiqueBrandMapper;
	
	@Override
	public int addSupplier(BoutiqueSupplier supplier) {
		supplier.setTypeLive(1);
		return supplierMapper.insert(supplier);
	}

	@Override
	public int deleteSupplier(Integer id) {
		return supplierMapper.deleteSupplier(id);
	}

	@Override
	public int updateSupplier(BoutiqueSupplier supplier) {
		return supplierMapper.updateByPrimaryKeySelective(supplier);
	}

	@Override
	public PageInfo<Map<String, Object>> selectSupplier(Integer storeId, String name,Integer pageSize,Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Map<String, Object>> page = supplierMapper.selectSupplier(name,storeId);
		
		for(int i = 0; i < page.size() ; i++){
			BoutiqueSupplier supplier = (BoutiqueSupplier) page.get(i);
			String ids = supplier.getFineBrandIds();
			
			//TODO HAHA
			if(ids.indexOf(",") >= 0){
				String[] split = ids.split(",");
				StringBuilder sbl = new StringBuilder();
				
				for (int j = 0 ; j < split.length ; j++) {
					BoutiqueBrand brand = boutiqueBrandMapper.selectByPrimaryKey(Integer.parseInt(split[j]));
					if( j == 0){
						sbl.append(brand.getName());
					}else{
						sbl.append(" ; " + brand.getName());
					}
				}
				supplier.setFineBrandName(sbl.toString());
			}else{
				
				if(StringUtils.isNotBlank(ids)){
					BoutiqueBrand brand = boutiqueBrandMapper.selectByPrimaryKey(Integer.parseInt(ids));
					supplier.setFineBrandName(brand.getName());
				}
				
			}
		}
		
		return page.toPageInfo();
	}

	@Override
	public List<BoutiqueSupplier> selectAllSupplier(Integer storeId) {
		return supplierMapper.selectAllSupplier(storeId);
	}

}
