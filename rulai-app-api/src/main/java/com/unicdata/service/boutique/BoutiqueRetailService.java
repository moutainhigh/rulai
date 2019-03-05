package com.unicdata.service.boutique;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.boutique.BoutiqueRetailExample;
import com.unicdata.entity.boutique.BoutiqueRetailInclude;

import java.util.List;
import java.util.Map;

/**
 * 精品订单service
 * @author admin
 *
 */
public interface BoutiqueRetailService  {
	/**
	 * 新增精品订单
	 * @param record
	 * @return
	 */
    int addBoutiqueRetail(BoutiqueRetail record,BoutiqueRetailInclude bri,String jsonStr,Integer editType);


	List<BoutiqueRetail> selectByExample(BoutiqueRetailExample example);
	
	BoutiqueRetail selectByCondition(BoutiqueRetail record);

	int updateByPrimaryKeySelective(BoutiqueRetail record);
	/**
	 * 某月精品收入
	 * @param record
	 * @return
	 */
	List<Map<String, Object>> getMouthBoutiqueRetailByStoreId(Map<String, Object> map);
	//分页
	PageInfo getMouthBoutiqueRetailByStoreId(Map<String, Object> map, Integer pageNum, Integer pageSize);

	/**
	 * 某月精品/礼包成本含税
	 * @param map
	 * @return
	 */
	Double getMouthCostSumByisPackage(Map<String,Object> map);

	/**
	 * 某月某日交车订单精品收入
	 * @param map
	 * @return
	 */
	Integer getBoutiqueDeliverCarByStoreId(Map<String, Object> map);
	
	/**
	 * 根据订单id查询订单精品集合
	 * @param orderId
	 * @return
	 */

	Map<String, Object> getBoutiqueListByOrderId(Integer orderId);

	/**
	 * 根据订单id查询订单精品集合
	 * @param orderId
	 * @return
	 */

	List<Map<String, Object>> getBoutiqueRetailByOId(Integer orderId);

	/**
	 * 根据精品id查询订单精品集合
	 * @param orderId
	 * @return
	 */
	List<Map<String, Object>> getBoutiqueOrderId(Integer orderId);

	/**
	 * 某月某日审批记录表
	 * @param map
	 * @return
	 */
	PageInfo getBoutiqueEetailRecordByMouthId(Map<String, Object> map, Integer pageNum, Integer pageSize);
	
	/**
	 * 删除订单精品
	 * @param map
	 * @return
	 */
	int deleteBoutiqueRetail(Map<String, Object> map);

	/**
	 * 精品经理确定排程日期时，需要生成精品出库数据。此接口提供根据排程单Id，生成出库数据。
	 * <hr/>
	 * 精品APP上首次确认精品安装排期时间后调用这个接口。
	 *
	 * @param retailId
	 *            精品加装排程单Id
	 * @return
	 */
	boolean createOutboundByInstallId(Integer installId);
}
