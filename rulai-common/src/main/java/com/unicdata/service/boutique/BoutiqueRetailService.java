package com.unicdata.service.boutique;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.unicdata.condition.BoutiqueRetailCondition;
import com.unicdata.condition.RetailSettleCondition;
import com.unicdata.constant.BoutiqueEnum.BoutiqueSource;
import com.unicdata.constant.BoutiqueEnum.BoutiqueType;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.boutique.order.OrderReatilDetail;

public interface BoutiqueRetailService {

	PageInfo<Map<String, Object>> selectListByCondition(RetailSettleCondition retailSettleCondition);

	/**
	 * 订单或精品零售产生的精品订单。
	 * <hr/>
	 * 注意事项：<br/>
	 * 1、精品订单实体类中需包含一个或多个精品（礼包）,否则无法生成精品订单<br/>
	 * 2、精品还是礼包用is_package字段区分。<br/>
	 * 3、订单来源请根据实际业务选择。<br/>
	 * 4、初始添加订单状态设置为待审批。
	 * 
	 * retail.set
	 * 
	 * @param retail
	 *            精品订单
	 * @param storeId
	 *            门店id
	 * @param boutiqueSource
	 *            订单来源
	 * @param boutiqueType
	 *            订单状态
	 * @return 精品订单ID。 0 添加失败 ，非0即精品订单ID
	 */
	int addBoutiqueRetail(BoutiqueRetail retail, Integer storeId, BoutiqueSource boutiqueSource,
			BoutiqueType boutiqueType);

	/**
	 * 根据精品订单id，查询明细
	 * 
	 * @param 精品id
	 * @return
	 */
	BoutiqueRetail selectBoutiqueRetailDetailById(Integer retialId);

	/**
	 * 根据订单id，查询明细
	 * 
	 * @param 订单id
	 * @return
	 */
	BoutiqueRetail selectBoutiqueRetailDetailByOrderId(Integer orderId);

	/**
	 * 分页条件查询零售订单
	 * 
	 * @param condition
	 * @return
	 */
	PageInfo<Map<String, Object>> selectBoutiqueRetailPage(BoutiqueRetailCondition condition);

	/**
	 * 修改精品订单状态。
	 * 
	 * @param retailId
	 *            精品订单Id
	 * @param boutiqueType
	 *            精品订单状态枚举
	 * @return 修改是否成功 ， true 修改成功 ， false修改失败
	 */
	boolean updateRetailType(Integer retailId, BoutiqueType boutiqueType);

	/**
	 * 精品零售财务财务收款后，需要生成精品出库数据。此接口是提供根据精品订单id，生成出库数据。
	 * 
	 * @param retailId
	 *            精品零售单Id
	 * @return
	 */
	boolean createOutboundByRetailId(Integer retailId);

	/**
	 * 精品经理确定排程日期时，需要生成精品出库数据。此接口提供根据排程单Id，生成出库数据。
	 * <hr/>
	 * 精品APP上首次确认精品安装排期时间后调用这个接口。
	 * 
	 * @param installId
	 *            精品加装排程单Id
	 * @return
	 */
	boolean createOutboundByInstallId(Integer installId);

	/**
	 * 订单财务收款后，需要生成精品排程数据。此接口提供根据精品订单id，生成精品加装排程数据。
	 * 
	 * @param retailId
	 *            精品订单id
	 * @return
	 */
	boolean createInstallByRetailId(Integer retailId);

	/**
	 * 根据销售订单id查询 精品项目明细 必须是财务收取全款后的订单
	 * 
	 * @return
	 */
	OrderReatilDetail getReatilDetailByOrderId(Integer orderId);

}
