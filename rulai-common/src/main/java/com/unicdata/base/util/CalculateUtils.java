package com.unicdata.base.util;

import com.unicdata.constant.InsuranceEnum.ExtensionType;

import java.math.BigDecimal;

/**
 * 计算工具类
 * @author admin
 *
 */
public class CalculateUtils {
	
	/**
	 * 计算订单保险毛利
	 * 保险毛利= 险种金额 / 去税系数 x 返点系数 - 成本
	 * @param salePrice 险种金额
	 * @param taxRemovalRatio  去税系数
	 * @param rebateRatio 返点系数
	 * @param cost 成本
	 * @return
	 */

	public static BigDecimal calcInsuranceProfit(BigDecimal salePrice,BigDecimal taxRemovalRatio,BigDecimal rebateRatio,BigDecimal cost){
//		taxRemovalRatio = BigDecimalUtils.div(taxRemovalRatio,new BigDecimal(100));
//		rebateRatio = BigDecimalUtils.div(rebateRatio,new BigDecimal(100));
		return BigDecimalUtils.round(BigDecimalUtils.div(salePrice, taxRemovalRatio).multiply(rebateRatio).subtract(cost),2);
	}
	
	/**
	 * 计算订单延保毛利
	 * 延保毛利=自店延保（延保售价*返点100%-延保成本）
	 * 延保毛利=保险公司/厂家延保（延保售价x返点）
	 * @param salePrice 延保售价
	 * @param cost 延保成本
	 * @param type 类型  1.自店延保 2.厂家延保 3.保险公司延保
	 * @param rebate 返点
	 * @return
	 */
	public static BigDecimal calcoOrderExtensionProfit(BigDecimal salePrice,BigDecimal cost,Integer type,BigDecimal rebate){
		//返点率
		BigDecimal rebateRate = BigDecimalUtils.div(rebate, new BigDecimal(100));
		if(type == ExtensionType.STORE_EXT.getCode()){
			return salePrice.multiply(rebateRate).subtract(cost);
		}else{
			return salePrice.multiply(rebateRate);
		}
	}

	/**
	 * 计算精品价格划分后的价格=精品金额*(报价/合计)
	 *
	 * @param sale_value  金额
	 * @param sale_count  合计
	 * @param apply_count 报价
	 * @return
	 */
	public static BigDecimal boutiquePrice(BigDecimal sale_value, BigDecimal sale_count, BigDecimal apply_count) {
		if (sale_value.compareTo(BigDecimal.ZERO) == 1 && sale_count.compareTo(BigDecimal.ZERO) == 1 && apply_count.compareTo(BigDecimal.ZERO) == 1) {
			BigDecimal divide = apply_count.divide(sale_count, 7, BigDecimal.ROUND_HALF_UP);
			BigDecimal multiply = sale_value.multiply(divide);
			return multiply.setScale(2,BigDecimal.ROUND_HALF_UP);
		} else {
			return new BigDecimal(0);
		}
	}

	/**
	 * 计算整车毛利 = 车辆销售价 - （采购金额（采购价+PIO费用+运费）- 返利金额 + 费用（所有赠送金额））
	 * (月度计划管理使用)
	 * @param salePrice 车辆销售价
	 * @param purchasePrice 采购金额（采购价+PIO费用+运费）
	 * @param forecastProfit 返利金额
	 * @param donationAmount 费用（所有赠送金额）
     * @return
     */
	public static BigDecimal calcCarGrossProfit(BigDecimal salePrice ,BigDecimal purchasePrice ,BigDecimal forecastProfit,BigDecimal donationAmount){
		salePrice = salePrice == null ? BigDecimal.ZERO : salePrice;
		purchasePrice = purchasePrice == null ? BigDecimal.ZERO : purchasePrice;
		forecastProfit = forecastProfit == null ? BigDecimal.ZERO : forecastProfit;
		donationAmount = donationAmount == null ? BigDecimal.ZERO : donationAmount;
		BigDecimal purchaseCost = purchasePrice.subtract(forecastProfit).add(donationAmount);//计算采购成本
		BigDecimal carGrossProfit = salePrice.subtract(purchaseCost); // 整车毛利
		return carGrossProfit;
	}

}
