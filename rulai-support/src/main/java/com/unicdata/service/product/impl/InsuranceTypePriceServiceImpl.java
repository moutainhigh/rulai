package com.unicdata.service.product.impl;

import com.google.common.collect.Maps;
import com.unicdata.dao.product.InsuranceTypeMapper;
import com.unicdata.dao.product.InsuranceTypePriceMapper;
import com.unicdata.entity.product.InsuranceType;
import com.unicdata.entity.product.InsuranceTypeExample;
import com.unicdata.entity.product.InsuranceTypePrice;
import com.unicdata.entity.product.InsuranceTypePriceExample;
import com.unicdata.service.product.InsuranceTypePriceService;
import com.unicdata.service.product.InsuranceTypeService;
import com.unicdata.util.PinyinUtil;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class InsuranceTypePriceServiceImpl implements InsuranceTypePriceService {

    @Autowired
    private InsuranceTypeService insuranceTypeService;

    @Autowired
    private InsuranceTypePriceMapper insuranceTypePriceMapper;

    @Autowired
    private InsuranceTypeMapper insuranceTypeMapper;


    @Transactional(readOnly = false)
    @Override
    public void savePrices(List<InsuranceTypePrice> prices, Integer storeId) {
        List<Integer> insuranceIds = Lists.newArrayList();
        //如果是交强险或者车船税
        if (prices.size() == 1 || insuranceTypeService.getIds().contains(prices.get(0).getInsuranceId())) {
            insuranceIds.add(prices.get(0).getInsuranceId());
        } else {
            //获取二级险种
            List<InsuranceType> types = insuranceTypeService.getInsuranceTypes(2);
            for (InsuranceType type : types) {
                insuranceIds.add(type.getId());
            }
            if (types.isEmpty()) {
                insuranceIds.add(0);
            }
        }
        insuranceTypePriceMapper.deleteByInsuranceIdAndStoreId(insuranceIds, storeId);
        for (InsuranceTypePrice price : prices) {
            price.setStoreId(storeId);
            insuranceTypePriceMapper.insertSelective(price);
        }
    }

    /*@Override
    public Map<String, List<InsuranceTypePrice>> pricesByInsuranceId(Integer insuranceId, Integer storeId) {
        Map<String, List<InsuranceTypePrice>> result = Maps.newHashMap();
        Map<String, Object> params = Maps.newHashMap();
        params.put("storeId", storeId);
        Integer level = null;
        //如果是交强险/车船税
        if (insuranceTypeService.getIds().contains(insuranceId)) {
            level = 1;
            params.put("type", 1);
            params.put("id", insuranceId);
            InsuranceType insurance = insuranceTypeMapper.selectByPrimaryKey(insuranceId);
            List<InsuranceTypePrice> price = insuranceTypePriceMapper.selectPrices(params);
            String key = PinyinUtil.getPYIndexStr(insurance.getName(), false);
            result.put(key, price);
        } else {
            //如果是商业险
            level = 2;
            //查出商业险下所有的一对一设置费率的子险种
            InsuranceTypeExample example1 = new InsuranceTypeExample();
            InsuranceTypeExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andSelfDefinedNotEqualTo(2);
            criteria1.andLevelEqualTo(2);
            List<InsuranceType> types = insuranceTypeMapper.selectByExample(example1);
            Map<Integer, InsuranceType> typeMap = Maps.newHashMap();
            for (InsuranceType type : types) {
                typeMap.put(type.getId(), type);
            }
            //所有险种ID
            Set<Integer> typeIds = typeMap.keySet();
            params.put("level", level);
            params.put("type", 3);
            //车损险/盗抢险（一对一且多个字段）
            List<InsuranceTypePrice> price1 = insuranceTypePriceMapper.selectPrices(params);
            //自燃险/玻璃险等（一对一且一个字段）
            params.put("type", 1);
            List<InsuranceTypePrice> price2 = insuranceTypePriceMapper.selectPrices(params);
            //已经设置了费率的费率ID
            Set<Integer> settedTypeIds = Sets.newHashSet();
            for (InsuranceTypePrice price : price1) {
                settedTypeIds.add(price.getInsuranceId());
            }
            price1.addAll(price2);
            //没有设置的造假数据
            for (InsuranceType type : types) {
                if (!settedTypeIds.contains(type.getId())) {
                    InsuranceTypePrice price = new InsuranceTypePrice();
                    price.setInsuranceName(type.getName());
                    price.setInsuranceId(type.getId());
                    price.setType(type.getHasBaseFee());
                    price1.add(price);
                }
            }
            result.put("index1", price1);
            params.put("type", 2);
            InsuranceTypeExample example = new InsuranceTypeExample();
            InsuranceTypeExample.Criteria criteria = example.createCriteria();
            criteria.andSelfDefinedEqualTo(2);
            List<InsuranceType> insuranceTypes = insuranceTypeMapper.selectByExample(example);
            for (InsuranceType insuranceType : insuranceTypes) {
                params.put("id", insuranceType.getId());
                List<InsuranceTypePrice> xz = insuranceTypePriceMapper.selectPrices(params);
                result.put(PinyinUtil.getPYIndexStr(insuranceType.getName(), false), xz);
            }
        }
        return result;
    }*/


    @Override
    public Map<String, List> pricesByInsuranceId(Integer insuranceId, Integer storeId) {
        Map<String, List> result = Maps.newHashMap();
        Map<String, Object> params = Maps.newHashMap();
        params.put("storeId", storeId);
        //如果是交强险/车船税
        if (insuranceTypeService.getIds().contains(insuranceId)) {
            params.put("id", insuranceId);
            List<InsuranceTypePrice> price = insuranceTypePriceMapper.selectPrices(params);
            result.put("insurance", price);
        } else {
            //如果是商业险
            //查出商业险下所有需要设置费率或者自定义金额的险种
            InsuranceTypeExample example1 = new InsuranceTypeExample();
            InsuranceTypeExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andSelfDefinedNotEqualTo(2);
            criteria1.andLevelEqualTo(2);
            List<InsuranceType> types = insuranceTypeMapper.selectByExample(example1);
            Map<Integer, InsuranceType> typeMap = Maps.newHashMap();
            for (InsuranceType type : types) {
                typeMap.put(type.getId(), type);
            }
            params.put("level", 2);
            //可以自定义金额的险种
            params.put("selfDefined", 1);
            List<InsuranceTypePrice> price1 = insuranceTypePriceMapper.selectPrices(params);
            //需要设置费率的险种
            params.put("selfDefined", 3);
            List<InsuranceTypePrice> price2 = insuranceTypePriceMapper.selectPrices(params);
            price1.addAll(price2);
            //已经设置了费率的费率ID
            Set<Integer> settedTypeIds = Sets.newHashSet();
            for (InsuranceTypePrice price : price1) {
                settedTypeIds.add(price.getInsuranceId());
            }
            //没有设置的造假数据
            for (InsuranceType type : types) {
                if (!settedTypeIds.contains(type.getId())) {
                    InsuranceTypePrice price = new InsuranceTypePrice();
                    price.setInsuranceName(type.getName());
                    price.setInsuranceId(type.getId());
                    price.setType(type.getHasBaseFee());
                    price.setSelfDefined(type.getSelfDefined());
                    price1.add(price);
                }
            }
            result.put("oneToOne", price1);
            //查出所有的一对多的险种
            params.put("selfDefined", 2);
            List<Map<String, Object>> oneToMore = Lists.newArrayList();
            InsuranceTypeExample example = new InsuranceTypeExample();
            InsuranceTypeExample.Criteria criteria = example.createCriteria();
            criteria.andSelfDefinedEqualTo(2);
            List<InsuranceType> insuranceTypes = insuranceTypeMapper.selectByExample(example);
            for (InsuranceType insuranceType : insuranceTypes) {
                Map<String, Object> map = Maps.newHashMap();
                map.put("insuranceId", insuranceType.getId());
                map.put("insuranceName", insuranceType.getName());
                params.put("id", insuranceType.getId());
                List<InsuranceTypePrice> prices = insuranceTypePriceMapper.selectPrices(params);
                map.put("prices", prices);
                oneToMore.add(map);
            }
            result.put("oneToMore", oneToMore);
        }
        return result;
    }
}
