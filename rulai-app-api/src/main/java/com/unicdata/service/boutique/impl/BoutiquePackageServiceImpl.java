package com.unicdata.service.boutique.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.dao.boutique.BoutiquePackageIncludeMapper;
import com.unicdata.dao.boutique.BoutiquePackageMapper;
import com.unicdata.entity.boutique.BoutiquePackage;
import com.unicdata.entity.boutique.BoutiquePackageExample;
import com.unicdata.service.boutique.BoutiquePackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 精品信息服务层
 *
 * @author admin
 */
@Service
public class BoutiquePackageServiceImpl implements BoutiquePackageService {
    //图片上传地址
    @Value(value = "${upload.access.path}")
    private String uploadAccessPath;

    @Autowired
    private BoutiquePackageMapper boutiquePackageMapper;
    @Autowired
    private BoutiquePackageIncludeMapper bPackageIncludeMapper;


    @Transactional(readOnly = true)
    public BoutiquePackage selectByPrimaryKey(Integer id) {
        return boutiquePackageMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectBoutiquePackage(Integer storeId, Integer familyId, String name) {
        /*BoutiquePackageExample example = new BoutiquePackageExample();
        BoutiquePackageExample.Criteria criteria = example.createCriteria();
        if (familyId != null) {
//            criteria.andCarIdEqualTo(familyId);
        }
        if (name != null) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andStoreIdEqualTo(storeId);
        List<BoutiquePackage> list = boutiquePackageMapper.selectByExample(example);
        //封装返回list
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (BoutiquePackage information : list) {
            map = new HashMap<String, Object>();
            map.put("id", information.getId());
            map.put("name", information.getName());
            map.put("salveValue", information.getSalveValue());
            map.put("picture", information.getPicture());
            map.put("includeNum", information.getIncludeNum());
            resultList.add(map);
        }*/
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("familyId", familyId);
        params.put("storeId", storeId);
        params.put("name", name);
        List<Map<String, Object>> resultList = boutiquePackageMapper.selectPackageByMap(params);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> selectBoutiquePackageDetail(Integer packageId) {
        List<Map<String, Object>> mapList = bPackageIncludeMapper.selectBoutiquePackageDetailByPid(packageId);
        for (Map<String, Object> map : mapList) {
            BigDecimal bigDecimal = new BigDecimal(0);
            Object sum_money = map.get("saleValue");
            Object information_num = map.get("informationNum");
            if (sum_money != null && information_num != null) {
                BigDecimal saleCount = new BigDecimal(sum_money.toString());
                BigDecimal saleNum = new BigDecimal(information_num.toString());
                bigDecimal = bigDecimal.add(saleCount.multiply(saleNum));
            }
            //每个精品礼包中单品的金额=单价*数量
            map.put("thisNum", bigDecimal);
        }
        return mapList;
    }

    /**
     * 查询精品礼包集合根据礼包名称
     *
     * @param storeId
     * @param name
     * @return
     */
    @Transactional(readOnly = true)
    public PageInfo selectBoutiquePackageByName(Integer pageNum, Integer pageSize, Integer storeId, String name) {
        BoutiquePackageExample example = new BoutiquePackageExample();
        BoutiquePackageExample.Criteria criteria = example.createCriteria();
        if (name != null) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andStoreIdEqualTo(storeId);
        criteria.andStatusEqualTo(Byte.valueOf("1"));
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        //封装返回list
        List<BoutiquePackage> list = boutiquePackageMapper.selectByExample(example);
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (BoutiquePackage information : list) {
            map = new HashMap<String, Object>();
            map.put("id", information.getId());
            map.put("name", information.getName());
            map.put("salveValue", information.getSalveValue());
            map.put("picture", information.getPicture() == null ? "" : uploadAccessPath + information.getPicture());
            map.put("includeNum", information.getIncludeNum());
            resultList.add(map);
        }
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(resultList);
        PageInfo pageInfo2 = new PageInfo(list);
        pageInfo2.setList(pageInfo.getList());
        return pageInfo2;
    }
}
