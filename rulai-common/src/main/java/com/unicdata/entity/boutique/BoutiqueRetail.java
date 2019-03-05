package com.unicdata.entity.boutique;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "精品订单")
public class BoutiqueRetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7154714553546417410L;

	@ApiModelProperty(value = "精品订单Id")
    private Integer id;
	@ApiModelProperty(value = "精品零售单号")
    private String code;
	@ApiModelProperty(value = "客户/企业名称id")
    private Integer customerId;
	@ApiModelProperty(value = "员工id")
    private Integer employeeId;
	@ApiModelProperty(value = "操作人员id")
    private Integer operatorId;
	@ApiModelProperty(value = "手机号码")
    private String phone;
	@ApiModelProperty(value = "项目名称")
    private String project;
	@ApiModelProperty(value = "销售日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date saleDate;
	@ApiModelProperty(value = "购买数量")
    private Integer saleNum;
	@ApiModelProperty(value = "销售总价")
    private BigDecimal saleCount;
	@ApiModelProperty(value = "申请总价")
    private BigDecimal applyCount;
	@ApiModelProperty(value = "精品订单状态((0,'无')(1,'待审批'),(2,'审批不通过'),(3,'待付款'),(4,'已收讫')， 5 已退单))")
    private Integer type;
	@ApiModelProperty(value = "精品订单状态")
	private String typeStr;
	@ApiModelProperty(value = "是否开发票( 0 - 未开发票 ； 1- 开发票)")
    private Integer invoice;
	@ApiModelProperty(value = "是否开发票")
	private String invoiceStr;
	@ApiModelProperty(value = "备注")
    private String reason;
	@ApiModelProperty(value = "审批原因")
    private String approvalReason;
	@ApiModelProperty(value = "订单id")
    private Integer orderId;
	@ApiModelProperty(value = "来源(销售订单-0 ， 售后订单 - 1,精品零售订单 - 2)")
    private Integer source;
	@ApiModelProperty(value = "门店id")
    private Integer storeId;

	@ApiModelProperty(value = "订单状态（ 0 - 删除 ； 1 - 正常）")
    private Integer status;

    private Integer typeLive;

	@ApiModelProperty(value = "订单包含具体精品的集合")
    private List<BoutiqueRetailInclude> list;
    
	@ApiModelProperty(value = "销售人员所属部门名称")
	private String departmentDesc;
	@ApiModelProperty(value = "销售人员名字")
	private String employeeName;
	@ApiModelProperty(value = "销售人员职位")
	private String postName;
	@ApiModelProperty(value = "操作人员名字")
	private String operatorName;
	@ApiModelProperty(value = "客户名字")
	private String customerName;
	@ApiModelProperty(value = "客户手机号码")
	private String customerPhone;
	@ApiModelProperty(value = "毛利")
	private BigDecimal margin;
	
	
    public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getApprovalReason() {
		return approvalReason;
	}

	public void setApprovalReason(String approvalReason) {
		this.approvalReason = approvalReason;
	}

	public String getTypeStr() {
		return typeStr;
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}

	public String getInvoiceStr() {
		return invoiceStr;
	}

	public void setInvoiceStr(String invoiceStr) {
		this.invoiceStr = invoiceStr;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getDepartmentDesc() {
		return departmentDesc;
	}

	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public List<BoutiqueRetailInclude> getList() {
		return list;
	}

	public void setList(List<BoutiqueRetailInclude> list) {
		this.list = list;
	}

	public Integer getTypeLive() {
		return typeLive;
	}

	public void setTypeLive(Integer typeLive) {
		this.typeLive = typeLive;
	}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public BigDecimal getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(BigDecimal saleCount) {
        this.saleCount = saleCount;
    }

    public BigDecimal getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(BigDecimal applyCount) {
        this.applyCount = applyCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getInvoice() {
        return invoice;
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	public BigDecimal getMargin() {
		return margin;
	}

	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}
}