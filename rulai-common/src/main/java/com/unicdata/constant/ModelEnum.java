package com.unicdata.constant;

/**
 * 模板枚举
 * 
 * @author wxn
 * @date 2018年6月6日
 */
public class ModelEnum {
	/**
	 * 模板类型枚举
	 *
	 * @author wxn
	 * @date 2018年6月4日
	 */
	public enum BelongType {

		CAR(1, "销售"),
		OPTIONAL(2, "售后");

		private final int code;

		private final String reason;

		public int getCode() {
			return code;
		}

		BelongType(int code, String reason) {
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
}
