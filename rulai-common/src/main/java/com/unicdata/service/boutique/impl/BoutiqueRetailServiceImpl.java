package com.unicdata.service.boutique.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.enu.RetailEnum;
import com.unicdata.base.enu.RetailStatusEnum;
import com.unicdata.base.util.DateUtil;
import com.unicdata.condition.BoutiqueRetailCondition;
import com.unicdata.condition.RetailSettleCondition;
import com.unicdata.constant.BoutiqueEnum;
import com.unicdata.constant.BoutiqueEnum.BoutiqueSource;
import com.unicdata.constant.BoutiqueEnum.BoutiqueType;
import com.unicdata.constant.BoutiqueEnum.OutboundType;
import com.unicdata.dao.boutique.BoutiqueInformationMapper;
import com.unicdata.dao.boutique.BoutiqueInstallMapper;
import com.unicdata.dao.boutique.BoutiqueInstallProjectMapper;
import com.unicdata.dao.boutique.BoutiqueOutboundDetailMapper;
import com.unicdata.dao.boutique.BoutiqueOutboundMapper;
import com.unicdata.dao.boutique.BoutiquePackageIncludeMapper;
import com.unicdata.dao.boutique.BoutiquePackageMapper;
import com.unicdata.dao.boutique.BoutiqueRetailCustomerMapper;
import com.unicdata.dao.boutique.BoutiqueRetailIncludeMapper;
import com.unicdata.dao.boutique.BoutiqueRetailMapper;
import com.unicdata.dao.boutique.BoutiqueRetailRecordMapper;
import com.unicdata.dao.boutique.BoutiqueSupplierMapper;
import com.unicdata.dao.car.CarGoodInfoMapper;
import com.unicdata.dao.counter.CounterMapper;
import com.unicdata.dao.customer.CustomerMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.dao.system.EmployeeMapper;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.BoutiqueInstall;
import com.unicdata.entity.boutique.BoutiqueInstallProject;
import com.unicdata.entity.boutique.BoutiqueOutbound;
import com.unicdata.entity.boutique.BoutiqueOutboundDetail;
import com.unicdata.entity.boutique.BoutiquePackage;
import com.unicdata.entity.boutique.BoutiquePackageInclude;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.boutique.BoutiqueRetailCustomer;
import com.unicdata.entity.boutique.BoutiqueRetailInclude;
import com.unicdata.entity.boutique.BoutiqueRetailRecord;
import com.unicdata.entity.boutique.BoutiqueSupplier;
import com.unicdata.entity.boutique.order.OrderReatilDetail;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.counter.Counter;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.CounterService;
import com.unicdata.service.boutique.BoutiqueRetailService;

import io.swagger.annotations.ApiModelProperty;

@Service
public class BoutiqueRetailServiceImpl implements BoutiqueRetailService {

    @Autowired
    private BoutiqueRetailMapper boutiqueRetailMapper;

    @Autowired
    private BoutiqueRetailIncludeMapper boutiqueRetailIncludeMapper;

    @Autowired
    private BoutiqueRetailRecordMapper boutiqueRetailRecordMapper;

    @Autowired
    private CounterMapper counterMapper;

    @Autowired
    private BoutiqueInformationMapper informationMapper;

    @Autowired
    private BoutiqueOutboundMapper outboundMapper;

    @Autowired
    private BoutiqueOutboundDetailMapper outboundDetailMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private BoutiqueRetailCustomerMapper retailCustomerMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CarGoodInfoMapper carGoodInfoMapper;

    @Autowired
    private BoutiquePackageMapper packageMapper;
    @Autowired
    private BoutiquePackageIncludeMapper packageIncludeMapper;

    @Autowired
    private BoutiqueInstallMapper installMapper;

    @Autowired
    private BoutiqueInstallProjectMapper installProjectMapper;

    @Autowired
    private BoutiqueSupplierMapper supplierMapper;

    @Autowired
    private CounterService counterService;

    @Autowired
    private CustomerMapper customerMapper;
    
    public PageInfo<Map<String, Object>> selectListByCondition(RetailSettleCondition retailSettleCondition) {
        PageHelper.startPage(retailSettleCondition.getPageNum(), retailSettleCondition.getPageSize());
        return boutiqueRetailMapper.selectListByCondition(retailSettleCondition).toPageInfo();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public int addBoutiqueRetail(BoutiqueRetail retail, Integer storeId,
                                 BoutiqueSource boutiqueSource, BoutiqueType boutiqueType) {

        /**
         * 礼包
         */
        List<BoutiqueRetailInclude> list = retail.getList();//精品订单明细
        int saleNum = 0;
        for (int i = 0; i < list.size(); i++) {
            BoutiqueRetailInclude include = list.get(i);
            saleNum += include.getInformationNum();
        }
        int retailId = 0;//精品订单Id

        //订单包含精品
        if (list != null && list.size() > 0) {
            Integer source = boutiqueSource.getCode(); // 来源
            Integer status = boutiqueType.getCode();//状态
            if (retail.getSaleCount().equals(retail.getApplyCount())) {
                status = BoutiqueEnum.BoutiqueType.NULL.getCode();
            }
            retail.setStoreId(storeId);
            retail.setSource(source);
            retail.setType(status);
            retail.setStatus(1);
            retail.setTypeLive(1);
            retail.setSaleNum(saleNum);

            String dateFormat = DateUtil.dateFormat(new Date(), DateUtil.sdf5);

            String generateCode = counterService.generateCode(dateFormat + Counter.BOUTIQUE_RETAIL, DateUtil.sdf5, 5);
            retail.setCode(generateCode.substring(dateFormat.length(), generateCode.length()));//精品订单号
            counterMapper.updCounterCode(Counter.BOUTIQUE_RETAIL);
            int addRetail = boutiqueRetailMapper.insertUseGeneratedKeys(retail);
            if (addRetail == 1) {
                retailId = retail.getId();
                for (BoutiqueRetailInclude include : list) {
                    include.setRetailId(retailId);
                    include.setTypeLive(1);
                    include.setDivisionValue(new BigDecimal(0));

                    if (include.getIsPackage() == null || include.getIsPackage() == 0) {
                        // 不是礼包
                        include.setIsPackage(0);
                        Integer informationId = include.getInformationId();
                        if (informationId != null) {
                            BoutiqueInformation info = informationMapper.selectByPrimaryKey(informationId);
                            include.setConstructionNode(info.getConstructionNode());
                        }
                    } else {
                        //是礼包
                    }
                    boutiqueRetailIncludeMapper.insertSelective(include);
                }
            }
        } else {
            return 0;
        }
        return retailId;
    }

    @Override
    @Transactional
    public BoutiqueRetail selectBoutiqueRetailDetailById(Integer id) {
        BoutiqueRetail retail = boutiqueRetailMapper.selectBoutiqueRetailDetailById(id);
//		List<BoutiqueRetailInclude> list = boutiqueRetailIncludeMapper.selectListByRetailId(retail.getId());

        List<BoutiqueRetailInclude> allList = boutiqueRetailIncludeMapper.selectAllByRetailId(retail.getId());
        for (BoutiqueRetailInclude include : allList) {
            Integer isPackage = include.getIsPackage();
            if (isPackage.equals(0)) {
                //不是礼包,单个精品
                BoutiqueInformation information = informationMapper.selectByPrimaryKey(include.getInformationId());
                include.setInformationName(information.getName());
                include.setInformationCode(information.getCode());
                BoutiqueSupplier supplier = supplierMapper.selectByPrimaryKey(information.getSupplierId());
                include.setIsHost(supplier.getIsHost());
            } else {
                //是礼包
                BoutiquePackage package1 = packageMapper.selectByPrimaryKey(include.getPackId());
                List<BoutiquePackageInclude> selectByPackageId = packageIncludeMapper.selectByPackageId(package1.getId());
                for (BoutiquePackageInclude packageInclude : selectByPackageId) {
                    BoutiqueInformation information = informationMapper.selectByPrimaryKey(packageInclude.getInformationId());
                    packageInclude.setBoutiqueInfo(information);
                }
                include.setPackContains(selectByPackageId);
            }
        }
        retail.setList(allList);

        return retail;
    }

    @Override
    public PageInfo<Map<String, Object>> selectBoutiqueRetailPage(BoutiqueRetailCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());

        Page<Map<String, Object>> page = boutiqueRetailMapper.selectBoutiqueRetailPage(condition);

        Map<Integer, String> typeMap = new HashMap<Integer, String>();
        BoutiqueType[] values = BoutiqueType.values();
        for (BoutiqueType boutiqueType : values) {
            typeMap.put(boutiqueType.getCode(), boutiqueType.getReason());
        }

        for (int i = 0; i < page.size(); i++) {
            BoutiqueRetail retail = (BoutiqueRetail) page.get(i);
            Integer type = retail.getType();

            if (type >= 3) {
                retail.setTypeStr("审批通过");
            } else {
                retail.setTypeStr(typeMap.get(type));
            }

            String approvalReason = "";
            List<BoutiqueRetailRecord> retailRecords = boutiqueRetailRecordMapper.selectRecordByRetailId(retail.getId());

            if (retailRecords != null && retailRecords.size() > 0) {
                BoutiqueRetailRecord retailRecord = retailRecords.get(0);
                approvalReason = retailRecord.getNote() == null ? "" : retailRecord.getNote();
            }
            retail.setApprovalReason(approvalReason);

            Integer invoice = retail.getInvoice();
            if (invoice != null) {
                switch (invoice) {
                    case (0): {
                        retail.setInvoiceStr("否");
                        break;
                    }
                    case (1): {
                        retail.setInvoiceStr("是");
                        break;
                    }
                }
            }
        }
        return page.toPageInfo();
    }

    @Override
    public boolean updateRetailType(Integer retailId, BoutiqueType boutiqueType) {
        boolean flag = false;
        BoutiqueRetail retail = new BoutiqueRetail();
        retail.setId(retailId);
        retail.setType(boutiqueType.getCode());
        int update = boutiqueRetailMapper.updateByPrimaryKeySelective(retail);
        if (update == 1) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean createOutboundByRetailId(Integer retailId) {
        boolean flag = false;
        flag = createOutbound(retailId, null);
        return flag;
    }

    @Override
    @Transactional
    public boolean createInstallByRetailId(Integer retailId) {
        boolean flag = false;

        BoutiqueRetail retail = boutiqueRetailMapper.selectByPrimaryKey(retailId);
        List<BoutiqueRetailInclude> list = boutiqueRetailIncludeMapper.selectListByRetailId(retail.getId());
        Integer source = retail.getSource();
        if (source == 0) {
        	List<BoutiqueRetailInclude> before = new ArrayList<BoutiqueRetailInclude>();//交车前
        	List<BoutiqueRetailInclude> after = new ArrayList<BoutiqueRetailInclude>();//交车后
        	List<BoutiqueRetailInclude> not = new ArrayList<BoutiqueRetailInclude>();//交车后
        	
        	int beforeCode = BoutiqueEnum.ConstructionNode.BEFORE.getCode();
        	int afterCode = BoutiqueEnum.ConstructionNode.AFTER.getCode();
        	int notCode = BoutiqueEnum.ConstructionNode.NOT.getCode();
        	
        	if(list != null && list.size() > 0){
            	for (BoutiqueRetailInclude include : list) {
            		Integer constructionNode = include.getConstructionNode();
            		if(beforeCode == constructionNode){
            			before.add(include);
            		}
            		if(afterCode == constructionNode){
            			after.add(include);
            		}
            		if(notCode == constructionNode){
            			not.add(include);
            		}
            		
            	}
        	}
        	
        	if(before.size() > 0){
                BoutiqueInstall install = createInstall(retailId, retail);
                install.setConstructionNode(beforeCode);
                install.setConstructionType(1);
                install.setUpdateTime(new Date());
                flag = createInstallProject(retail, before, install);
        	}
        	if(after.size() > 0){
                BoutiqueInstall install = createInstall(retailId, retail);
                install.setConstructionNode(afterCode);
                install.setConstructionType(0);
                install.setUpdateTime(new Date());
                flag = createInstallProject(retail, after, install);
        	}

        }
        return flag;
    }

	private synchronized boolean createInstallProject(BoutiqueRetail retail, List<BoutiqueRetailInclude> list,
			BoutiqueInstall install) {
		boolean flag;
		int insertInstall = installMapper.insertUseGeneratedKeys(install);
		if (insertInstall == 1) {

		    List<BoutiqueInstallProject> installProjects = new ArrayList<BoutiqueInstallProject>();
		    for (BoutiqueRetailInclude include : list) {
		        BoutiqueInstallProject project = new BoutiqueInstallProject();
		        project.setInstallId(install.getId());//排程ID
		        project.setBoutiqueId(include.getInformationId());//精品ID
		        project.setIncludeId(include.getId());
		        project.setBoutiqueProject(include.getInformationName());//精品施工项目(精品名称)
		        BoutiqueInformation information = informationMapper.selectByPrimaryKey(include.getInformationId());
		        Integer constructionNode = include.getConstructionNode();

		        switch (constructionNode) {
		            case 3: {
		                project.setStatus(BoutiqueEnum.IntsallType.ALL.getCode());//
		                break;
		            }
		            default: {
		                project.setStatus(BoutiqueEnum.IntsallType.NOT.getCode());//
		                break;
		            }
		        }
		        project.setConstructionNode(constructionNode);
		        project.setWorkinghours(information.getWorkinghours());//标准工时
		        project.setExpectWorkinghours(information.getExpectWorkinghours());//预计完成时长
		        project.setStartTime(null);
		        project.setEndTime(null);
		        project.setWorkinghoursUse(null);
		        project.setPrincipal(retail.getEmployeeName());//负责人
//                        project.setStatus();//状态
		        project.setIsGift(include.getIsGift());//是否是赠送
		        project.setTypeLive(1);//
		        installProjects.add(project);
		    }
		    installProjectMapper.insertBatch(installProjects);
		    flag = true;
		} else {
		    flag = false;
		}
		return flag;
	}

	private synchronized BoutiqueInstall createInstall(Integer retailId, BoutiqueRetail retail) {
		BoutiqueInstall install = new BoutiqueInstall();
		Integer orderId = retail.getOrderId();
		//来源于销售
		install.setOrderId(orderId);//销售订单id
		install.setRetailId(retailId);//精品订单id
		Order order = orderMapper.selectByPrimaryKey(orderId);
		install.setFollowUp(null);//后续加装时间
		install.setExpectedDelivery(order.getDeliveryDate());//预计交车时间
		install.setExpectedComplete(null);//安排施工时间
		install.setBegin(null);//开始时间
		install.setActualDelivery(null);//实际完成时间
		install.setStatus(0); //状态(  0  -  未分配 ；1 - 未开始 ； 2- 已开始 ； 3 - 已完成)

		install.setCode(order.getOrderNum());
		Integer employeeId = retail.getEmployeeId();
		install.setEmployeeId(employeeId);
		Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
		retail.setEmployeeName(employee.getFullName());
		Integer customerId = retail.getCustomerId();
		Customer customer = customerMapper.selectByPrimaryKey(customerId);
		install.setCustomerName(customer.getName());
		Integer matchingCarId = order.getMatchingCarId();
		
		if(matchingCarId != null){
			CarGoodInfoWithBLOBs carGoodInfo = carGoodInfoMapper.selectByPrimaryKey(matchingCarId);
			install.setVin(carGoodInfo.getVin());//vin码
			install.setModel(carGoodInfo.getVehicleName());//车型
		}
//			install.setLicensePlate(retail.get);//车牌
		install.setSource(0);
		install.setStoreId(retail.getStoreId());
		install.setTypeLive(1);//
		install.setTimestamp(new Date());
		return install;
	}

    @Override
    public boolean createOutboundByInstallId(Integer installId) {
        boolean flag = false;
        BoutiqueInstall boutiqueInstall = installMapper.selectByPrimaryKey(installId);
        flag = createOutbound(boutiqueInstall.getRetailId(), installId);
        return flag;
    }

	@Override
	public BoutiqueRetail selectBoutiqueRetailDetailByOrderId(Integer orderId) {
		BoutiqueRetail retail = boutiqueRetailMapper.selectBoutiqueRetailDetailByOrderId(orderId);
		if(retail != null){
			List<BoutiqueRetailInclude> list = boutiqueRetailIncludeMapper.selectListByRetailId(retail.getId());
			if(list != null && list.size() >0 ){
				List<BoutiqueRetailInclude> result = new ArrayList<BoutiqueRetailInclude>();
				Map<Integer, List<BoutiqueRetailInclude>> resultMap = new HashMap<Integer, List<BoutiqueRetailInclude>>();
				for (BoutiqueRetailInclude include : list) {
					Integer isPackage = include.getIsPackage();
					if(isPackage == 0){
						result.add(include);
					}else{
						List<BoutiqueRetailInclude> list2 = resultMap.get(include.getPackId());
						if(list2 == null || list2.size() == 0){
							list2 = new ArrayList<BoutiqueRetailInclude>();
						}
						list2.add(include);
						resultMap.put(include.getPackId(), list2);
					}
				}
				
				Set<Integer> keySet = resultMap.keySet();
				if(keySet.size() > 0){
			 		for (Integer packId : keySet) {
						List<BoutiqueRetailInclude> list2 = resultMap.get(packId);
						BoutiqueRetailInclude packInclude = new BoutiqueRetailInclude();
						
						BoutiquePackage boutiquePackage = packageMapper.selectByPrimaryKey(packId);
						packInclude.setInformationName(boutiquePackage.getName());
						
						BigDecimal totalPack = new BigDecimal(0);
						Integer isGift = 0;
						for (BoutiqueRetailInclude include2 : list2) {
							BigDecimal divisionValue = include2.getDivisionValue();
							totalPack = totalPack.add(divisionValue == null ? new BigDecimal(0) : divisionValue);
							isGift = include2.getIsGift();
						}
						packInclude.setDivisionValue(totalPack);
						packInclude.setIsGift(isGift);
						packInclude.setSaleValue(boutiquePackage.getSalveValue());
						packInclude.setApplyValue(boutiquePackage.getSalveValue());
						packInclude.setInformationNum(boutiquePackage.getIncludeNum());
						
						result.add(packInclude);
					}
				}
				retail.setList(result);
			}
		}
		return retail;
	}
    /**
     * 生成精品出库数据
     *
     * @param retailId  精品订单id
     * @param installId 加装排程id
     * @return
     */
    private boolean createOutbound(Integer retailId, Integer installId) {
        boolean flag;
        BoutiqueOutbound outbound = new BoutiqueOutbound();

        BoutiqueRetail retail = boutiqueRetailMapper.selectByPrimaryKey(retailId);
        List<BoutiqueRetailInclude> list = boutiqueRetailIncludeMapper.selectListByRetailId(retail.getId());

        outbound.setStatus(OutboundType.NOT.getCode());//单据状态
        Integer source = retail.getSource();
        outbound.setType(source);//来源
        outbound.setStoreId(retail.getStoreId());//门店id
        outbound.setTypeLive(1);//状态( 0 - 删除 ； 1 - 删除)
        outbound.setApplyDate(new Date());

        Integer employeeId = retail.getEmployeeId();
        Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
        outbound.setEmployeeName(employee.getLoginName());//员工名字
        switch (source) {
            case (0): {
                //订单
                Integer orderId = retail.getOrderId();
                Order order = orderMapper.selectByPrimaryKey(orderId);
                outbound.setSalveNo(order.getOrderNum());//销售订单号
                outbound.setCustomerName(order.getCusName());//客户名字
                Integer carId = order.getCarId();
                CarGoodInfoWithBLOBs carGoodInfo = carGoodInfoMapper.selectByPrimaryKey(carId);
                outbound.setVin(carGoodInfo.getVin());//VIN码
                outbound.setVehicleId(carGoodInfo.getVehicleId());//车型ID
                outbound.setInstallId(installId);
                break;
            }
            case (1): {
                //售后
                break;
            }
            case (2): {
                //零售
                BoutiqueRetailCustomer customer = retailCustomerMapper.selectByPrimaryKey(retail.getCustomerId());
                outbound.setCustomerName(customer.getName());//客户名字
                outbound.setBoutiqueNo(retail.getCode()); //精品订单号
                break;
            }
        }

        int isertOutbound = outboundMapper.insertUseGeneratedKeys(outbound);

        if (isertOutbound == 1) {
            List<BoutiqueOutboundDetail> allDetail = new ArrayList<BoutiqueOutboundDetail>();

            for (BoutiqueRetailInclude retailInclude : list) {
            	
                BoutiqueOutboundDetail detail = new BoutiqueOutboundDetail();

                detail.setBoutiqueId(retailInclude.getInformationId());//精品ID
                detail.setNumer(retailInclude.getInformationNum());//精品数量
                detail.setOutboundId(outbound.getId());//出库单id
                detail.setBoutiqueOrderId(retail.getId());//精品订单id
                detail.setBoutiqueConstruction(retailInclude.getConstructionNode());//施工节点
                detail.setStatus(0);//默认未出库
                detail.setTypeLive(1);
                allDetail.add(detail);
            	
            }
            outboundDetailMapper.insertBatch(allDetail);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public OrderReatilDetail getReatilDetailByOrderId(Integer orderId) {
        OrderReatilDetail detail = new OrderReatilDetail();
        BoutiqueRetail retail = boutiqueRetailMapper.selectBoutiqueRetailDetailByOrderId(orderId);

        try {
            if (retail != null) {
                detail.setAllCount(retail.getApplyCount());//精品金额  -- 精品订单申请价格
                BoutiqueInstall install = installMapper.selectByOrderId(orderId);
                List<BoutiqueInstallProject> allProjects = installProjectMapper.selectByInstallId(install.getId());

                List<BoutiqueInstallProject> already = new ArrayList<BoutiqueInstallProject>();
                List<BoutiqueInstallProject> not = new ArrayList<BoutiqueInstallProject>();
                List<BoutiqueInstallProject> gift = new ArrayList<BoutiqueInstallProject>();

                if (allProjects != null && allProjects.size() > 0) {
                    for (BoutiqueInstallProject project : allProjects) {
                        BoutiqueRetailInclude include = boutiqueRetailIncludeMapper.selectByPrimaryKey(project.getIncludeId());
                        project.setDivisionValue(include.getDivisionValue());
                        if (include.getIsGift().equals(0)) {
                            //不是赠送
                            switch (project.getStatus()) {
                                case (0): {
                                    not.add(project);
                                    break;
                                }//1 - 未开始
                                case (1): {
                                    already.add(project);
                                    break;
                                }//2- 已开始
                                case (2): {
                                    already.add(project);
                                    break;
                                }//3 - 已完成
                            }
                        } else {
                            //是赠送
                            gift.add(project);
                        }
                    }
                }

                BigDecimal alreadyCount = new BigDecimal(0);//已施工金额
                BigDecimal alreadyMaterial = new BigDecimal(0);//已施工材料成本金额
                BigDecimal alreadyPeople = new BigDecimal(0);//已施工人工成本金额
                BigDecimal alreadyProfit = new BigDecimal(0);//已施工毛利金额
                BigDecimal alreadyGift = new BigDecimal(0);//已施工赠送金额
                BigDecimal notCount = new BigDecimal(0);//未施工金额

                BigDecimal notMaterial = new BigDecimal(0);//未施工材料成本金额
                BigDecimal notPeople = new BigDecimal(0); //未施工人工成本金额
                BigDecimal notProfit = new BigDecimal(0);//未施工毛利金额
                BigDecimal notGift = new BigDecimal(0);//未施工赠送金额
                BigDecimal allProfit = new BigDecimal(0);//总预估毛利

                for (int i = 0; i < already.size(); i++) {
                    BoutiqueInstallProject project = already.get(i);
                    BoutiqueInformation information = informationMapper.selectByPrimaryKey(project.getBoutiqueId());
                    alreadyCount.add(project.getDivisionValue());//完成施工的申请价格
                    alreadyMaterial.add(information.getTaxPrice());//含税单价
                    BigDecimal people = new BigDecimal(information.getLaborCost() * information.getExpectWorkinghours());//精品工时费  * 预计完成时长
                    alreadyPeople.add(people);//人工成本
                    alreadyProfit.add(project.getDivisionValue().subtract(information.getTaxPrice()).subtract(people));//申请价格 - 含税单价 - 人工成本
                }

                for (int i = 0; i < not.size(); i++) {
                    BoutiqueInstallProject project = not.get(i);
                    BoutiqueInformation information = informationMapper.selectByPrimaryKey(project.getBoutiqueId());
                    notCount.add(project.getDivisionValue());//未施工金额
                    notMaterial.add(information.getTaxPrice());//含税单价
                    BigDecimal people = new BigDecimal(information.getLaborCost() * information.getExpectWorkinghours());//精品工时费  * 预计完成时长
                    notPeople.add(people);
                    notProfit.add(project.getDivisionValue().subtract(information.getTaxPrice()).subtract(people));//申请价格 - 含税单价 - 人工成本
                }

                for (int i = 0; i < gift.size(); i++) {
                    BoutiqueInstallProject project = gift.get(i);
                    switch (project.getStatus()) {
                        case 0:
                            notGift.add(project.getDivisionValue());
                            break;
                        case 1:
                            break;
                        case 2:
                            alreadyGift.add(project.getDivisionValue());
                            break;
                        default:
                            break;
                    }
                }

                allProfit.add(alreadyProfit);
                allProfit.add(notProfit);

                detail.setAllProfit(allProfit);
                detail.setAlreadyCount(alreadyCount);
                detail.setAlreadyGift(alreadyGift);
                detail.setAlreadyMaterial(alreadyMaterial);
                detail.setAlreadyPeople(alreadyPeople);
                detail.setAlreadyProfit(alreadyProfit);
                detail.setNotCount(notCount);
                detail.setNotGift(notGift);
                detail.setNotMaterial(notMaterial);
                detail.setNotPeople(notPeople);
                detail.setNotProfit(notProfit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return detail;
    }

}
