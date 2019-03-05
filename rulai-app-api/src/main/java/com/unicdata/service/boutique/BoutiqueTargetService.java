package com.unicdata.service.boutique;

import com.unicdata.entity.boutique.BoutiqueTarget;
import com.unicdata.entity.boutique.BoutiqueTargetExample;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/5.
 */
public interface BoutiqueTargetService {
    List<BoutiqueTarget> selectByExample(BoutiqueTargetExample example);

    //通过门户id获取
    List<BoutiqueTarget> getBoutiqueTargetByStoreId(Map<String,Object> map);

    //获取精品目标，通过年份
    List<BoutiqueTarget> selectBoutiqueTargetSum(Map<String,Object> map);

    int insertSelective(BoutiqueTarget record);

    int updateByPrimaryKeySelective(BoutiqueTarget record);
}
