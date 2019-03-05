package com.unicdata.base.constant;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * 数据字典类型枚举
 * @author 许兵
 * @date 2018年2月8日
 */
public class DictionaryTypeEnum {

	/**
	 * 文章类型
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum ArticleType{
		
		NEWS(1,"新闻"),
		ABOUT_US(2,"关于我们"),
		CAR_PURCHASE_NOTICE(3,"购车须知"),
		SERVICE_PROTOCOL(4,"服务协议"),
		INTEGRAL_EXPLAIN(5,"积分说明");
		
		private final int code;
		
		private final String reason;
		
		public int getCode() {
			return code;
		}

		ArticleType(int code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 商品状态
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum CommodityStatus{

		GROUNDING((byte)1,"上架"),
		UNDERCARRIAGE((byte)2,"下架");
		
		private final byte code;
		
		private final String reason;
		
		public byte getCode() {
			return code;
		}

		CommodityStatus(byte code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 员工状态
	 * @author admin
	 */
	public enum EmployeeStatus{

		DISABLE(0,"禁用"),
		ENABLE(1,"启动");
		
		private final int code;
		
		private final String reason;
		
		public int getCode() {
			return code;
		}

		EmployeeStatus(int code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	
	/**
	 * 商品有效期
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum EffectiveDate{

		FIFTEEN_DAY(1,"15天"),
		ONE_MONTH(2,"一个月"),
		TWO_MONTHS(3,"两个月"),
		EFFECTIVE(4,"一直有效");
		
		private final int code;
		
		private final String reason;
		
		public int getCode() {
			return code;
		}

		EffectiveDate(int code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
		
		/**
	     *将该枚举全部转化成json
	     * @return
	     */
	    public static List<JSONObject> toJson(){
	    	List<JSONObject> list = new ArrayList<JSONObject>();
	        for (EffectiveDate e : EffectiveDate.values()) {
	            JSONObject object = new JSONObject();
	            object.put("code", e.getCode());
	            object.put("reason", e.getReason());
	            list.add(object);
	        }
	        return list;
	    }
	}
	
	/**
	 * 文件所属表类型
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum SubordinateType{

		NOTHING(1,"无"),
		CAR_LEFT_ANTERIOR(2,"车型图片左前"),
		CAR_POSITIVE(3,"车型图片正面"),
		CAR_RIGHT_FRONT(4,"车型图片右前"),
		CAR_LEFT(5,"车型图片左侧"),
		CAR_LEFT_AFTER(6,"车型图片左后"),
		CAR_BEHIND(7,"车型图片后面"),
		CAR_RIGHT_AFTER(8,"车型图片右后"),
		CAR_REALISTIC(9,"车型图片写实");
		
		private final int code;
		
		private final String reason;
		
		public int getCode() {
			return code;
		}

		SubordinateType(int code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 文件类型
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum FileType{

		PICTURE((byte)1,"图片"),
		VIDEO((byte)2,"视频");
		
		private final byte code;
		
		private final String reason;
		
		public byte getCode() {
			return code;
		}

		FileType(byte code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 奖品类型
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum RewardPrizeType{

		INTEGRAL(1,"积分"),
		COMMODITY(2,"商城商品");
		
		private final int code;
		
		private final String reason;
		
		public int getCode() {
			return code;
		}

		RewardPrizeType(int code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 微信显示是否是新车
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum IsNewsCar{

		YES(1,"是"),
		NO(2,"否");
		
		private final int code;
		
		private final String reason;
		
		public int getCode() {
			return code;
		}

		IsNewsCar(int code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 车源状态
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum CarSourceStatus{

		GROUNDING((byte)1,"上架"),
		UNDERCARRIAGE((byte)2,"下架");
		
		private final byte code;
		
		private final String reason;
		
		public byte getCode() {
			return code;
		}

		CarSourceStatus(byte code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 门店状态
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum StoreStatus{

		GROUNDING((byte)1,"上架"),
		UNDERCARRIAGE((byte)2,"下架");
		
		private final byte code;
		
		private final String reason;
		
		public byte getCode() {
			return code;
		}

		StoreStatus(byte code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 栏目状态
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum ColumnStatus{

		GROUNDING((byte)1,"上架"),
		UNDERCARRIAGE((byte)2,"下架");
		
		private final byte code;
		
		private final String reason;
		
		public byte getCode() {
			return code;
		}

		ColumnStatus(byte code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 广告状态
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum AdvertisingStatus{

		GROUNDING((byte)1,"上架"),
		UNDERCARRIAGE((byte)2,"下架");
		
		private final byte code;
		
		private final String reason;
		
		public byte getCode() {
			return code;
		}

		AdvertisingStatus(byte code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	/**
	 * 核销状态
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum VerificationStatus{

		WRITE_OFF_YES((byte)1,"已核销"),
		WRITE_OFF_NOT((byte)2,"未核销");
		
		private final byte code;
		
		private final String reason;
		
		public byte getCode() {
			return code;
		}

		VerificationStatus(byte code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 问题类型
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum ComplaintsType{

		COMPLAINTS_TYPE(11,"问题类型");
		
		private final int code;
		
		private final String reason;
		
		public int getCode() {
			return code;
		}

		ComplaintsType(int code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	
	/**
	 * 会员需求类型
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum MemberDemandType{

		INQUIRE(1,"询底价"),
		SUBSCRIBE(2,"预约看车"),
		RIDE(3,"试乘试驾");
		
		private final int code;
		
		private final String reason;
		
		public int getCode() {
			return code;
		}

		MemberDemandType(int code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	
	/**
	 * 用户性别
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum MemberSex{

		UNKNOWN(0,"未知"),
		MAN(1,"男"),
		WOMAN(2,"女");
		
		private final int code;
		
		private final String reason;
		
		public int getCode() {
			return code;
		}

		MemberSex(int code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	
	/**
	 * 消息状态
	 * @author 许兵
	 * @date 2018年2月8日
	 */
	public enum MessageStatus{

		UNREAD(1,"未读"),
		READ(2,"已读");
		
		private final int code;
		
		private final String reason;
		
		public int getCode() {
			return code;
		}

		MessageStatus(int code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 活动状态 发布报名结束
	 * 
	 */
	public enum ActivityStatus{

		UNPUBLISHED((byte)0,"未发布"),
		SIGNING((byte)1,"报名中"),
		PROCESSING((byte)2,"进行中"),
		FINISHED((byte)3,"已结束");
		
		private final byte code;
		
		private final String reason;
		
		public byte getCode() {
			return code;
		}

		ActivityStatus(byte code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 活动状态 上下架
	 * 
	 */
	public enum ActivityUpdown{

		GROUNDING((byte)1,"上架"),
		UNDERCARRIAGE((byte)2,"下架");
		
		private final byte code;
		
		private final String reason;
		
		public byte getCode() {
			return code;
		}

		ActivityUpdown(byte code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 活动是否收藏、点评、报名
	 */
	public enum IsTrue{

		YES(1,"是"),
		NO(2,"否");
		
		private final int code;
		
		private final String reason;
		
		public int getCode() {
			return code;
		}

		IsTrue(int code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 数据状态
	 */
	public enum DateStatus{

		DELETED((byte)0,"已删除"),
		NOMAL((byte)1,"正常");
		
		private final byte code;
		
		private final String reason;
		
		public byte getCode() {
			return code;
		}

		DateStatus(byte code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	
	/**
	 * 员工状态
	 */
	public enum StaffStatus{

		ISProhibit((byte)2,"禁止"),
		NOProhibit((byte)1,"未禁止");
		
		private final byte code;
		
		private final String reason;
		
		public byte getCode() {
			return code;
		}

		StaffStatus(byte code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
	
	/**
	 * 
	 * 任务类型
	 */
	public enum taskTypes{
		
		ISClue(1,"线索"),
		ISDive(2,"潜客"),
		ISDEAL(3,"成交"),
		ISAfterSale(4,"售后"),
		ISaActivity(5,"活动");
		
		private final int code;
		
		private final String reason;
		
		private taskTypes(int code, String reason) {
			this.code = code;
			this.reason = reason;
		}


		public int getCode() {
			return code;
		}

		public String getReason() {
			return reason;
		}
		
	}
}
