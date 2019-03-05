package com.unicdata.constant;

/**
 * 枚举类型
 * @author admin
 *
 */
public class ConstantEnum {
	
	/**
	 * 数据状态
	 * Disable 假删
	 * Enable 正常
	 * @author admin
	 *
	 * 2014年12月9日 下午1:56:32
	 */
	public enum dataStatus{
		Disable, Enable
	}
	
	/**
	 * 客流状态
	 * @author admin
	 * 
	 */
	public enum enumPassengerFlowStatus{
		未接待(1),接待中(2),离店(3);
		
		private int id;
		
		enumPassengerFlowStatus(int id){
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}
	
	/**
	 * 是否状态
	 * @author admin
	 * 
	 */
	public enum enumIsOrNoStatus{
		否(0),是(1);
		
		private int id;
		
		enumIsOrNoStatus(int id){
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}
	/**
	 * 整备状态 wp
	 * @author Administrator
	 */
	public enum DetectStatu{
		未生成工单1(1),
		待送修2(2), 
		维修中3(3), 
		维修完成4(4);
		private int id;
		DetectStatu(int id){
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	}
	/**
	 * 客户到店次数 wp
	 * @author Administrator
	 *
	 */
	public enum PassengerFloweType{
		首次到店1(1),
		再次到店2(2);
		private int code;
		PassengerFloweType(int code){
			this.code=code;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
	}
	/**
	 * 盘点状态 wp
	 * @author Administrator
	 *
	 */
	public enum CarDepotCheckStatus{
		正常1(1),异常2(2);
		private int code;

		private CarDepotCheckStatus(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}
	}
	/**
	 * 试驾状态 wp
	 * @author Administrator
	 *
	 */
	public enum TestDriveStatus{
		试驾中1(1),已试驾2(2);
		private int code;
		TestDriveStatus(int code) {
			this.code = code;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
	}
	/**
	 * 汽车核实状态 wp
	 * @author Administrator
	 *
	 */
	public enum PanDianResult{
		已核2(2),未核1(1);
		private int code;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		private PanDianResult(int code) {
			this.code = code;
		}
	}
	/**
	 * 检验状态(与表对应) wp
	 * @author Administrator
	 */
	public enum CarCheckStatus{
		检验OK(1),整备(3),暂收未检测(4),已完成(5),拒收(2),暂收待整备(6);
		private int code;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		private CarCheckStatus(int code) {
			this.code = code;
		}
		
	}
	
	/**
	 * 跟进任务
	 * @author 
	 */
	public enum nextTaskContent{
		潜客跟进(1),潜客邀约(2),订单跟进(3),今日交车(4),后续服务(5);
		private int code;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		private nextTaskContent(int code) {
			this.code = code;
		}
		
	}
	
	/**
	 * 跟进任务
	 * @author 
	 */
	public enum nextTaskChannel{
		展厅接待(1),电话(2),短信(3),微信(4);
		private int code;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		private nextTaskChannel(int code) {
			this.code = code;
		}
		
	}
	
	/**
	 * 订单状态
	 * @author 
	 */
	public enum AppOrderStatus{
		未生效(1),待付款(2),已付订金(3),已付全款(4),待交车(5),已交车(6),退单审批(7),退单中(8),已退单(9),已驳回(10);
		private int code;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		private AppOrderStatus(int code) {
			this.code = code;
		}
		
	}
	
	/**
	 * 订单车辆价格审批状态
	 * @author 
	 */
	public enum CarPriceStatus{
		未提交(0),审批中(1),已通过(2),已驳回(3);
		private int code;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		private CarPriceStatus(int code) {
			this.code = code;
		}
	}
	
	/**
	 * 销售顾问工作状态
	 * @author 
	 */
	public enum EmployeeWorkStatus{
		空闲(0),忙碌(1),休假(2),培训(3);
		private int code;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		private EmployeeWorkStatus(int code) {
			this.code = code;
		}
	}
	
	/**
	 * 销售顾问工作状态
	 * @author 
	 */
	public enum nextServiceItem{
		精品装潢(1),首保邀约(2),手续办理(3),其他(4);
		private int code;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		private nextServiceItem(int code) {
			this.code = code;
		}
	}
	
}
