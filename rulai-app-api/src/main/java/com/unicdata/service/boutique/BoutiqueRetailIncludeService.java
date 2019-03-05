package com.unicdata.service.boutique;

import java.util.List;
import java.util.Map;

import com.unicdata.entity.boutique.BoutiqueRetailInclude;

/**
 * Created by lenovo on 2018/6/14.
 */
public interface BoutiqueRetailIncludeService {
    int updateByPrimaryKeySelective(BoutiqueRetailInclude record);
    /**
     * 根据条件删除精品订单明细
     * @param params
     * @return
     */
    int deleteBoutiqueRetailInclude(Map<String,Object> params);
    
    /**
	 * 查询已加入订单的精品礼包明细
	 * @param packageId
	 * @return
	 */
	List<Map<String,Object>> selectOrderBoutiquePackageDetail(Integer orderId,Integer retailId,Integer packageId);
	/**
	 * 查询已加入订单的精品明细
	 * @param orderId
	 * @param retailId
	 * @param boutiqueId
	 * @return
	 */
	Map<String,Object> selectOrderBoutiqueDetail(Integer orderId,Integer retailId,Integer boutiqueId);
}
