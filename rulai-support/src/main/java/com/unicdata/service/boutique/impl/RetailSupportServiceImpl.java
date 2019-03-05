package com.unicdata.service.boutique.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.unicdata.constant.SettleEnum;
import com.unicdata.constant.BoutiqueEnum.BoutiqueSource;
import com.unicdata.constant.BoutiqueEnum.BoutiqueType;
import com.unicdata.constant.PushEnum;
import com.unicdata.dao.boutique.BoutiqueRetailIncludeMapper;
import com.unicdata.dao.boutique.BoutiqueRetailIncludePackDivisionMapper;
import com.unicdata.dao.boutique.BoutiqueRetailMapper;
import com.unicdata.dao.boutique.BoutiqueRetailRecordMapper;
import com.unicdata.entity.approval.ApprovalOrder;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.boutique.BoutiqueRetailExample;
import com.unicdata.entity.boutique.BoutiqueRetailIncludePackDivision;
import com.unicdata.entity.boutique.BoutiqueRetailRecord;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.approval.ApprovalOrderService;
import com.unicdata.service.boutique.RetailSupportService;
import com.unicdata.service.customer.CustomerService;
import com.unicdata.service.order.SaleOrderService;
import com.unicdata.service.push.PushMessageService;
import com.unicdata.service.system.EmployeeService;

@Service
public class RetailSupportServiceImpl extends BoutiqueRetailServiceImpl implements RetailSupportService {

    @Autowired
    private BoutiqueRetailMapper boutiqueRetailMapper;
 
    @Autowired
    private BoutiqueRetailIncludeMapper boutiqueRetailIncludeMapper;

    @Autowired
    private BoutiqueRetailRecordMapper retailRecordMapper;
    
    @Autowired
    private BoutiqueRetailIncludePackDivisionMapper packDivisionMapper;
    
    @Autowired
    private ApprovalOrderService approvalOrderService;
    
    @Autowired
    private SaleOrderService saleOrderService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private PushMessageService pushMessageService;
    
    //销售顾问
    @Value("${SALES_CONSULTANT_POSITION}")
    private String salesConsultantPosition;
    //销售经理
    @Value("${SALES_MANAGER_POSITION}")
    private String salesManagerPosition;
    //财务
    @Value("${FINANCE_POSITION}")
    private String financePosition;
    //保险专员
    @Value("${INSURANCE_SPECIALIST_POSITION}")
    private String insuranceSpecialistPosition;
    //金融专员
    @Value("${FINANCE_POSITION}")
    private String financialSpecialistPosition;
    //信息员
    @Value("${FINANCE_POSITION}")
    private String informationMemberPosition;
    //销售库管
    @Value("${STOREHOUSE}")
    private String storehouse;
    
    @Override
    public List<Map<String, Object>> getMouthBoutiqueRetailByStoreId(Date saleDate, Integer storeId, BoutiqueType type, BoutiqueSource source) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("saleDate", saleDate);
        map.put("storeId", storeId);
        if (type != null) {
            map.put("type", type.getCode());
        }
        if (source != null) {
            map.put("source", source.getCode());
        }
        return boutiqueRetailMapper.getMouthBoutiqueRetailByStoreId(map);
    }

    @Override
    public Double getMouthCostSumByisPackage(Date saleDate, Integer storeId, Integer ispackage,BoutiqueType boutiqueType) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("saleDate", saleDate);
        map.put("storeId", storeId);
        map.put("isPackage", ispackage);
        map.put("type", boutiqueType.getCode());
        return boutiqueRetailMapper.getMouthCostSumByisPackage(map);
    }

    @Override
    public List<Map<String, Object>> getMouthBoutiqueRetailByStoreId(Map<String, Object> map) {
        return boutiqueRetailMapper.getMouthBoutiqueRetailByStoreId(map);
    }

    @Override
    public Integer getBoutiqueDeliverCarByStoreId(Map<String, Object> map) {
        return boutiqueRetailMapper.getBoutiqueDeliverCarByStoreId(map);
    }

    @Override
    public BoutiqueRetail getRetailByOrderId(Integer orderId) {
        BoutiqueRetailExample example = new BoutiqueRetailExample();
        BoutiqueRetailExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdEqualTo(orderId);
        List<BoutiqueRetail> retails = boutiqueRetailMapper.selectByExample(example);
        if (retails.isEmpty() || retails == null) {
            return null;
        } else {
            return retails.get(0);
        }
    }

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
	public int approvalRetail(Integer retailid, Integer type,String note,Employee member) {
		Integer storeId = member.getStoreId();
		
		int update = boutiqueRetailMapper.approvalRetail(retailid,type);
		int insert = 0;
		if(update == 1 ){
			BoutiqueRetail retail = boutiqueRetailMapper.selectByPrimaryKey(retailid);
			Integer source = retail.getSource();

			Integer employeeId = retail.getEmployeeId();
			List<String> postNames = new ArrayList<String>();
			postNames.add(salesConsultantPosition);
			postNames.add(financePosition);
			postNames.add(informationMemberPosition);
			Employee employee = employeeService.selectByPrimaryKey(employeeId);
			
			if(source == 0){
				Integer orderId = retail.getOrderId();
				ApprovalOrder approvalOrder = approvalOrderService.selectApprovalByOrderId(orderId);
				approvalOrder.setIfBoutiqueApproval(1);
				approvalOrder.setBoutiqueApproveId(member.getId());
				approvalOrder.setBoutiqueApprovalTime(new Date());
				if(type == 3){
					approvalOrder.setBoutiqueApprovalResult(1);
				}else{
					approvalOrder.setBoutiqueApprovalResult(2);
					approvalOrder.setApprovalStatus(2);
				}
				approvalOrderService.updateApprovalOrder(approvalOrder);
				
	            //判断如果销售经理和精品经理都已经审核通过则修改订单状态为已生效
	            if (approvalOrderService.ifPass(approvalOrder.getId())) {
	                Order order = saleOrderService.selectByPrimaryKey(approvalOrder.getOrderId());
	                //更新订单状态
	                order.setStatus(SettleEnum.OrderStatus.EFFECTIVE.getCode());
	                saleOrderService.updateOrder(order);
	                //修改客户分类为订单
	                Customer customerById = customerService.getCustomerById(order.getCusId());
	                customerById.setCategory(2);
	                customerService.save(customerById);
	                
					saleOrderService.pushMess(storeId, postNames, PushEnum.PushType.ORDER_AUDITED.getCode(),
							PushEnum.PushType.ORDER_AUDITED.getDesc(), member.getId(), order, employee);
	            }
	            
	            Order order = saleOrderService.selectByPrimaryKey(orderId);
				if(type == 3){
					order.setBoutiquePriceStatus(3);
					order.setBoutiqueStatus(1);
				}else{
					order.setBoutiquePriceStatus(2);
				}
				saleOrderService.updateOrder(order);
				
			}else if(source == 1){
				
			}else if(source == 2){
				
//		        Map<String, Object> param = new HashMap<>();
//		        param.put("storeId", storeId);
//		        for (String postName : postNames) {
//		            param.put("postName", postName);
//		            //如果是销售顾问则只推送给订单所属的销售顾问
//		            if ((salesConsultantPosition).equals(postName)) {
//		                Map<String, Object> saleParam = new HashMap<>();
//		                saleParam.put("employeeId", employee.getId());
//		                saleParam.put("urlId", geturlIdAndContent(type, postName, employee).get("urlId"));
//		                saleParam.put("terminal", geturlIdAndContent(type, postName,employee).get("terminal"));
//		                List<Map<String, Object>> receivers = new ArrayList<>();
//		                receivers.add(saleParam);
//		                pushMessageService.createPushMessage(PushEnum.PushType.ORDER_AUDITED.getCode(),
//								PushEnum.PushType.ORDER_AUDITED.getDesc(), geturlIdAndContent(type, postName,employee).get("content").toString(), member.getId(), receivers);
//		            } 
//		        }
			}
			
			BoutiqueRetailRecord record = new BoutiqueRetailRecord();
			record.setOrderId(retail.getOrderId());
			record.setRetailId(retail.getId());
			record.setEmployeeId(member.getId());
			record.setNote(note);
			record.setType(type);
			record.setStoreId(member.getStoreId());
			record.setIsDivision(0);
			record.setTypeLive(1);
			insert = retailRecordMapper.insert(record);
		}
		return insert;
	}

	@Override
	@Transactional
	public int updateRetailDivision(JSONObject divisionJson, Employee member) {
		int result = 1 ;
		JSONObject division = divisionJson.getJSONObject("division");
		
		String retailId = division.getString("retailId");
		JSONArray singles = division.getJSONArray("single");
		for (Object single : singles) {
			JSONObject singl = (JSONObject)single;
			Integer retailIncludeId = Integer.parseInt(singl.get("retailIncludeId").toString());
			BigDecimal divisionValue = new BigDecimal(singl.get("divisionValue").toString());
			boutiqueRetailIncludeMapper.updateRetailDivisionById(retailIncludeId,divisionValue);
		}
		
		JSONArray pack = division.getJSONArray("pack");
		for (Object object : pack) {
			JSONObject packInclude = (JSONObject)object;
			JSONArray packIncludes = (JSONArray)packInclude.get("packageIncluedes");
			for (Object object2 : packIncludes) {
				JSONObject include = (JSONObject)object2;
				
				boutiqueRetailIncludeMapper.updateRetailDivisionById(Integer.parseInt(include.get("retailIncludeId").toString()),new BigDecimal(include.get("divisionValue").toString()));
				
//				BoutiqueRetailIncludePackDivision packDivision  = new BoutiqueRetailIncludePackDivision();
//				packDivision.setBoutiqueId(Integer.parseInt(include.get("informationId").toString()));
//				packDivision.setDivisionValue(new BigDecimal(include.get("divisionValue").toString()));
//				packDivision.setNum(Integer.parseInt(include.get("saleNum").toString()));
//				packDivision.setPackId(Integer.parseInt(include.get("packageId").toString()));
//				packDivision.setRetialIncludeId(Integer.parseInt(include.get("retailIncludeId").toString()));
//				packDivision.setTypeLive(1);
//				packDivision.setTimestamp(new Date());
//				packDivisionMapper.insertSelective(packDivision);
			}
		}
		retailRecordMapper.updateByRetailId(Integer.parseInt(retailId),1);
		
		return result;
	}

	@Override
	public int updateByPrimaryKeySelective(BoutiqueRetail record) {
		return boutiqueRetailMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Integer> selectRetailPackageId(Integer retailId) {
		return boutiqueRetailIncludeMapper.selectRetailPackageId(retailId);
	}

}
