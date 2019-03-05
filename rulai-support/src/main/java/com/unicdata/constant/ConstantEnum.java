package com.unicdata.constant;

/**
 * 枚举类型
 * 
 */
public class ConstantEnum {

	/**
	 * 账号状态
	 */
	public enum accountStatus {
		LOCK(0,"禁用"), 
		NORMAL(1,"启用");
		
		private final int code;
		
		private final String reason;
		
		public int getCode() {
			return code;
		}

		accountStatus(int code,String reason){
			this.code = code;
			this.reason = reason;
		}

		public String getReason() {
			return reason;
		}
	}
}
