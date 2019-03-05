package com.unicdata.dao.boutique;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.unicdata.condition.BoutiqueInfoCondition;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiqueInformationExample;
import com.unicdata.entity.boutique.home.BoutiqueStay;

public interface BoutiqueInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueInformation record);

    int insertSelective(BoutiqueInformation record);

    List<BoutiqueInformation> selectByExampleWithBLOBs(BoutiqueInformationExample example);

    List<BoutiqueInformation> selectByExample(BoutiqueInformationExample example);

    BoutiqueInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueInformation record);

    int updateByPrimaryKeyWithBLOBs(BoutiqueInformation record);

    int updateByPrimaryKey(BoutiqueInformation record);

    /**
     * 根据仓库ID集合获取精品信息
     * @param warehouseIds
     * @return
     */
    List<Map<String,Object>> getBoutiquesByWarehouseId(@Param("warehouseIds") List<Integer> warehouseIds);

	int deleteById(@Param("id")Integer id);

	Page<Map<String, Object>> selectBoutiqueInfoByCondition(BoutiqueInfoCondition condition);

	BoutiqueInformation selectBoutiqueInfoById(@Param("id")Integer id, @Param("storeId")Integer storeId);

	/**
	 * 查询门店下所有的精品信息
	 * @param storeId
	 * @return
	 */
	List<BoutiqueInformation> selectBoutiqueInfoAll(Integer storeId);

	/**
	 * 乐观锁更新库存
	 * @param boutiqueId
	 * @return
	 */
	int uppdateStock(BoutiqueInformation information);

	int updateBoutiqueStatus(BoutiqueInformation info);

	BoutiqueInformation selectBoutiqueInfoDetailById(@Param("id")Integer id);

	/**
	 * 查询门店下所有安全库存、不安全库存
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> selectBoutiqueStockByStoreId(Map<String,Object> map);

	int beginOutbound(BoutiqueInformation info);

	int selectCountOutbound(@Param("outboundId")Integer outboundId);

	/**
	 * 乐观锁更新库存
	 * @param information
	 * @return
	 */
	int updateStock(BoutiqueInformation information);

	/**
	 * 更新仓库、库位、库存
	 * @param info
	 * @return
	 */
	int updateWareHouseAndStock(BoutiqueInformation info);

	List<BoutiqueInformation> selectBoutiqueInfoListByCondition(BoutiqueInfoCondition condition);

	Page<Map<String, Object>> selectBoutiqueStockByStoreIdPage(Map<String, Object> questMap);

	Integer selectCountUseByClassifyId(@Param("classifyId")Integer classifyId,@Param("storeId") Integer storeId);

	void insertBatch(List<BoutiqueInformation> list);
}