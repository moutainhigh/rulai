package com.unicdata.constant;

/**
 * 精品相关枚举类型
 *
 * @author wxn
 * @date 2018年6月4日
 */
public class BoutiqueEnum {

    /**
     * 精品订单销售类型
     *
     * @author wxn
     * @date 2018年6月4日
     */
    public enum BoutiqueSource {

        SELL(0, "销售"),
        AFTER_SELL(1, "售后"),
        RETAIL(2, "零售");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        BoutiqueSource(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
        
    	public static String getReason(int code){
    		BoutiqueSource[] values = BoutiqueSource.values();
    		for (BoutiqueSource boutiqueSource : values) {
    			if(boutiqueSource.getCode() == code){
    				return boutiqueSource.getReason();
    			}
    		}
    		return null;
    	}
    }

    /**
     * 精品订单订单状态
     *
     * @author wxn
     * @date 2018年6月4日
     */
    public enum BoutiqueType {
    	
    	NULL(0, "无需审批"),
        APPROVAL_WAIT(1, "待审批"),
        APPROVAL_REFUSE(2, "审批不通过"),
        EARNEST_WAIT(3, "待付款"),
        FINISHED(4, "已收讫"),
        BACK_PAYMENT(5, "已退单"),
        UNSUBMITTED(6, "未提交审批");
    	

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        BoutiqueType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 精品订单审批记录状态
     *
     * @author wxn
     * @date 2018年6月4日
     */
    public enum BoutiqueRetailRecordType {
        APPROVAL_WAIT(1, "待审批"),
        APPROVAL_REFUSE(2, "审批不通过"),
        EARNEST_WAIT(3, "审批通过");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        BoutiqueRetailRecordType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    public enum ChangeType{
    	
        BEFORE(0, "变更前"),
        AFTER(1, "变更后");
    	
        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        ChangeType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }
    
    public enum OutboundType{
    	
        NOT(0, "未出料"),
        PART(1, "部分出料"),
        ALL(2, "全部出料");
    	
        private final int code;

        private final String reason;

        
        public int getCode() {
            return code;
        }

        OutboundType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
        
        public static String getReason(int code){
        	OutboundType[] values = OutboundType.values();
        	for (OutboundType outboundType : values) {
				if(outboundType.getCode() == code){
					return outboundType.getReason();
				}
			}
        	return null;
        }
    }
    
    public enum IntsallType{
    	NO(0,"未分配"),
        NOT(1, "未施工"),
        PART(2, "施工中"),
        ALL(3, "已完工");
    	
        private final int code;

        private final String reason;

        
        public int getCode() {
            return code;
        }

        IntsallType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
        
        public static String getReason(int code){
        	IntsallType[] values = IntsallType.values();
        	for (IntsallType intsallType : values) {
				if(intsallType.getCode() == code){
					return intsallType.getReason();
				}
			}
        	return null;
        }
    }
    
    public enum ConstructionNode{
    	
    	BEFORE(1, "交车前"),
    	AFTER(2, "交车后"),
    	NOT(3, "不施工");
    	
    	private final int code;
    	
    	private final String reason;
    	
    	
    	public int getCode() {
    		return code;
    	}
    	
    	ConstructionNode(int code, String reason) {
    		this.code = code;
    		this.reason = reason;
    	}
    	
    	public String getReason() {
    		return reason;
    	}
    	
    	public static String getReason(int code){
    		ConstructionNode[] values = ConstructionNode.values();
    		for (ConstructionNode constructionNode : values) {
    			if(constructionNode.getCode() == code){
    				return constructionNode.getReason();
    			}
    		}
    		return null;
    	}
    }

    //盘点单状态
    public enum DepotCheckStates {

        CONFIRMED(0, "已确认"),
        DISCARDED(1, "已作废"),
        DRAFT(2, "已保存");

        DepotCheckStates(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static DepotCheckStates getByCode(Integer code) {
            for(DepotCheckStates item : DepotCheckStates.values()) {
                if(item.getCode().equals(code)) {
                    return item;
                }
            }
            return null;
        }

        private Integer code;

        private String desc;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    /**
     * 是否
     */
    public enum NoYesType{

        NO(0, "否"),
        YES(1, "是");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        NoYesType(int code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

    /**
     * 数据状态
     * @author wxn
     * @date 2018年6月4日
     */
    public enum DataStatus{

        NORMAL(1,"正常"),
        DELETED(2,"已删除");

        private final int code;

        private final String reason;

        public int getCode() {
            return code;
        }

        DataStatus(int code,String reason){
            this.code = code;
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }

}
