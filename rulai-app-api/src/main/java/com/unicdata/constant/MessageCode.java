package com.unicdata.constant;

import java.util.HashMap;

/**
 * 返回代码及描述
 * 
 */
public class MessageCode {
	/**
	 * 前台发起新客流 
	 */
	public static final String MESSAGE_NEW_PASSENGER = "101";
	public static final String MESSAGE_NEW_PASSENGER2 = "102";

	/**
	 * 前台发起试驾
	 */
	public static final String MESSAGE_NEW_TESTDRIVE = "201";
	/**
	 * 前台结束试驾 
	 */
	public static final String MESSAGE_END_TESTDRIVE = "202";
	/**
	 * 销售顾问客流操作留档
	 */
	public static final String MESSAGE_PASSENGER_CREATEARCHIVES = "301";
	/**
	 * 销售顾问客流操作离店
	 */
	public static final String MESSAGE_PASSENGER_LEAVE = "302";
	/**
	 * 二次到店门禁提醒 
	 */
	public static final String ENTRANCE_GUARD_REMIND = "501";
	public static final String ENTRANCE_GUARD_REMIND2 = "502";
	/**
	 * 替岗 
	 */
	public static final String MESSAGE_REPLACE_SALEMAN = "601";
	public static final String MESSAGE_REPLACE_SALEMAN2 = "602";
	/**
	 * 换销售 
	 */
	public static final String MESSAGE_EXCHANGE_SALEMAN = "1001";
	public static final String MESSAGE_EXCHANGE_SALEMAN2 = "1002";
	/**
	 * 订单审核
	 */
	public static final String MESSAGE_APPROVALORDERPASS = "1101";
	public static final String MESSAGE_APPROVALORDREJECT = "1102";
	public static final String MESSAGE_ORDER_NEW_APPLY = "1103";
	public static final String MESSAGE_APPROVAL_TDORDERPASS = "1104";
	public static final String MESSAGE_APPROVAL_TDORDREJECT = "1105";
	public static final String MESSAGE_ORDER_NEW_APPLY_INFORMATION = "1106";
	/**
	 * 客户休眠审批通过/驳回 
	 */
	public static final String MESSAGE_APPROVAL_XMCUSPASS = "801";
	public static final String MESSAGE_APPROVAL_XMCUSREJECT = "802";
	public static final String MESSAGE_NEW_DORMANCY = "803";
	public static final String MESSAGE_NEW_DEFEAT = "804";
	public static final String MESSAGE_APPROVAL_ZBCUSPASS = "805";
	public static final String MESSAGE_APPROVAL_ZBCUSREJECT = "806";

	/**
	 * 精品审核 
	 */
	public static final String MESSAGE_BOUTIQUEPASS = "901";
	public static final String MESSAGE_BOUTIQUEREJECT = "902";
	/**
	 * K 消息码 V 消息描述
	 */
	public static HashMap<String, String> resultCodeMap = new HashMap<String, String>() {
		/**
         * 
         */
		private static final long serialVersionUID = -6209197629101992324L;

		{
			put(MESSAGE_NEW_PASSENGER, "您有一位新客户到店,请及时接待!");
			put(MESSAGE_NEW_PASSENGER2, "您的客户 XXX 到店,请及时接待!");
			put(MESSAGE_NEW_TESTDRIVE, "试驾申请已通过, 请提醒客户安全驾驶.");
			put(MESSAGE_END_TESTDRIVE, "试驾已结束,请完善客户试驾信息.");
			put(MESSAGE_PASSENGER_CREATEARCHIVES, "顾问 XXX 完善客户信息中 ,请知悉.");
			put(MESSAGE_PASSENGER_LEAVE, "顾问 XXX 的客户已离店, 请知悉.");
			put(ENTRANCE_GUARD_REMIND, "有新客户到店,请及时处理");
			put(ENTRANCE_GUARD_REMIND2, "顾问 XXX 的客户 YYY 到店,请及时处理.");
			put(MESSAGE_REPLACE_SALEMAN, "顾问XXX的客户到店,需要您替岗接待,请及时接待!");//替岗
			put(MESSAGE_REPLACE_SALEMAN2, "您的客户XXX,已由顾问YYY替岗接待,请知悉!");//替岗
			put(MESSAGE_EXCHANGE_SALEMAN, "您有一位客户到店,请及时接待!");//换销售
			put(MESSAGE_EXCHANGE_SALEMAN2, "您正接待的客户,已完成\"换销售\"操作,请知悉.");//换销售
			put(MESSAGE_APPROVALORDERPASS, "客户XXX的订单YYY已通过审核.请及时跟进!");
			put(MESSAGE_APPROVALORDREJECT, "客户XXX的订单YYY被驳回.请及时跟进!");
			put(MESSAGE_APPROVAL_TDORDERPASS, "客户XXX的订单退订YYY已通过审核.请及时跟进!");
			put(MESSAGE_APPROVAL_TDORDREJECT, "客户XXX的订单退订YYY被驳回.请及时跟进!");
			put(MESSAGE_APPROVAL_XMCUSPASS, "客户XXX休眠审批已通过，请知悉。");
			put(MESSAGE_APPROVAL_XMCUSREJECT, "客户XXX休眠审批被驳回，请知悉。");
			put(MESSAGE_APPROVAL_ZBCUSPASS, "客户XXX战败审批已通过，请知悉。");
			put(MESSAGE_APPROVAL_ZBCUSREJECT, "客户XXX战败审批被驳回，请知悉。");
			put(MESSAGE_BOUTIQUEPASS, "客户XXX的精品订单YYY已通过审核.请及时跟进!");
			put(MESSAGE_BOUTIQUEREJECT, "客户XXX的精品订单YYY被驳回.请及时跟进!");
			put(MESSAGE_NEW_DORMANCY, "有新的休眠申请，请及时处理");
			put(MESSAGE_NEW_DEFEAT, "有新的战败申请，请及时处理");
			put(MESSAGE_ORDER_NEW_APPLY, "有新的订单需要审批，请及时处理!");
			put(MESSAGE_ORDER_NEW_APPLY_INFORMATION,"顾问 XXX 的客户 YYY 订单 ZZZ 需要配车,请及时处理!");
		}
	};
}
