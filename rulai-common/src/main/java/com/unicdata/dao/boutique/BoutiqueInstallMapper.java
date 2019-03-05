package com.unicdata.dao.boutique;

import com.github.pagehelper.Page;
import com.unicdata.condition.BoutiqueInstallCondition;
import com.unicdata.entity.boutique.BoutiqueInstall;
import com.unicdata.entity.boutique.BoutiqueInstallExample;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BoutiqueInstallMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueInstall record);

    int insertSelective(BoutiqueInstall record);

    List<BoutiqueInstall> selectByExample(BoutiqueInstallExample example);

    BoutiqueInstall selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueInstall record);

    int updateByPrimaryKey(BoutiqueInstall record);

	int insertUseGeneratedKeys(BoutiqueInstall install);

	Page<Map<String, Object>> selectInstallByCondition(BoutiqueInstallCondition condition);

	void updateStatusById(@Param("id")Integer id, @Param("status")Integer status,@Param("startTime")Date startTime ,@Param("endTime")Date endTime);

	/**
	 * 根销售订单ID查询排程
	 * @param orderId
	 * @return
	 */
	BoutiqueInstall selectByOrderId(Integer orderId);

	/**
	 * 根据参数获取分页列表(项目名，成本等)
	 * @param retailIds
	 * @return
	 */
	Page<Map<String, Object>> selectListByParams2(@Param("retailIds") List<Integer> retailIds);

	/**
	 * 根据ID集合获取精品（销售数量，赠送数量）
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> getSaleQuantityByboutiqueIds(Map<String,Object> params);

	/**
	 * 根据精品订单ID集合获取精品订单总销售额
	 * @param retailIds
	 * @return
	 */
	BigDecimal getSumSaleAmount2(@Param("retailIds") List<Integer> retailIds);

	/**
	 * 根据精品订单ID集合获取精品订单总成本
	 * @param retailIds
	 * @return
	 */
	BigDecimal getSumCost2(@Param("retailIds") List<Integer> retailIds);

	/**
	 * 根据ID集合获取加装台数
	 * @param params
	 * @return
	 */
	List<Map<String, Object>> getDecorationsByIds2(Map<String,Object> params);

	/**
	 * 根据ID集合获取对应订单的数量
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> getSumOrderByBoutiqueIds2(Map<String,Object> params);
}