package com.unicdata.service.boutique;

import com.github.pagehelper.PageInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface InstallSupportService extends BoutiqueInstallService{

	Double getBoutiqueWorkHoursByStoreId(Map<String, Object> workHoursMap);

	int updateInstallByProjectId(Integer projectId, Integer status);

	/**
	 * 根据参数获取精品项目加装分析分页列表(项目名,成本,销售额)
	 * @param retailIds
	 * @return
	 */
	PageInfo<Map<String, Object>> selectListByParams2(List<Integer> retailIds, Integer pageNum, Integer pageSize);

	/**
	 * 根据ID集合获取精品（销售数量，赠送数量）
	 * @param params
	 * @return
	 */
	Map<Integer,BigDecimal> getSaleQuantityByboutiqueIds(Map<String,Object> params);

	/**
	 * 根据精品订单ID集合获取精品订单总销售额
	 * @param retailIds
	 * @return
	 */
	BigDecimal getSumSaleAmount2(List<Integer> retailIds);

	/**
	 * 根据精品订单ID集合获取精品订单总成本
	 * @param retailIds
	 * @return
	 */
	BigDecimal getSumCost2(List<Integer> retailIds);

	/**
	 * 根据精品ID集合获取加装台数（订单数）
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> getDecorationsByIds2(Map<String,Object> params);

	/**
	 * 根据精品ID集合获取付款时间段内的各精品的总订单数量
	 * @param params
	 * @return
	 */
	List<Map<String,Object>> getSumOrderByBoutiqueIds2(Map<String,Object> params);

	/**
	 * 根据ID集合获取精品销售额
	 * @param params
	 * @return
	 */
	Map<Integer,BigDecimal> getSalePriceByboutiqueIds(Map<String,Object> params);

}
