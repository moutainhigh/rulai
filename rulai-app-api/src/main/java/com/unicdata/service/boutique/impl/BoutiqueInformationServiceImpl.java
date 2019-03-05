package com.unicdata.service.boutique.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.dao.boutique.BoutiqueInformationMapper;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiqueInformationExample;
import com.unicdata.service.boutique.BoutiqueInformationService;
import com.unicdata.util.PageResult;

/**
 * 精品信息服务层
 *
 * @author admin
 */
@Service
public class BoutiqueInformationServiceImpl implements BoutiqueInformationService {
    @Value("${upload.access.path}")
    private String uploadAccessPath;//图片域名

    @Autowired
    private BoutiqueInformationMapper boutiqueInformationMapper;

    @Transactional(readOnly = true)
    public Map<String, Object> selectBoutiqueInformation(Integer pageNum, Integer pageSize,Integer storeId, Integer id) {
    	Map<String,Object> resultMap = new HashMap<String, Object>();
		pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
    	BoutiqueInformationExample example = new BoutiqueInformationExample();
        BoutiqueInformationExample.Criteria criteria = example.createCriteria();
        criteria.andStoreIdEqualTo(storeId);
        criteria.andClassifyIdEqualTo(id);
        criteria.andTypeLiveEqualTo(1);
        criteria.andStatusEqualTo(1);
        List<BoutiqueInformation> list = boutiqueInformationMapper.selectByExample(example);
        //封装分页信息
        PageInfo<BoutiqueInformation> pageInfo = new PageInfo<BoutiqueInformation>(list);
        //封装返回list
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        for (BoutiqueInformation information : pageInfo.getList()) {
            map = new HashMap<String, Object>();
            map.put("id", information.getId());
            map.put("code", information.getCode());
            map.put("name", information.getName());
            map.put("unitprice", information.getUnitprice());
            map.put("picture", information.getPicture() == null ? "" : uploadAccessPath + information.getPicture());
            map.put("constructionNode", information.getConstructionNode());
            resultList.add(map);
        }
        resultMap.put("list", resultList);
        PageResult page = new PageResult();
		BeanUtils.copyProperties(pageInfo,page);
		resultMap.put("pageResult",page);
        return resultMap;
    }

    @Override
    public List<Map<String, Object>> selectBoutiqueStockByStoreId(Map<String, Object> map) {
        List<Map<String, Object>> mapList = boutiqueInformationMapper.selectBoutiqueStockByStoreId(map);
        for (Map<String, Object> stringObjectMap : mapList) {
            if (stringObjectMap != null) {
                Object picture = stringObjectMap.get("picture");
                stringObjectMap.put("picture", picture == null ? "" : uploadAccessPath + picture.toString());
            }
        }
        return mapList;
    }

    @Override
    public BoutiqueInformation selectByPrimaryKey(Integer id) {
        return boutiqueInformationMapper.selectByPrimaryKey(id);
    }
}
