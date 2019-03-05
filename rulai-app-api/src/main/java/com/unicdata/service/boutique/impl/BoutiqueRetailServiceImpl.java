package com.unicdata.service.boutique.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.BoutiqueEnum;
import com.unicdata.constant.BoutiqueEnum.BoutiqueSource;
import com.unicdata.constant.BoutiqueEnum.BoutiqueType;
import com.unicdata.constant.ConstantEnum.dataStatus;
import com.unicdata.dao.boutique.*;
import com.unicdata.dao.car.CarGoodInfoMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.dao.system.EmployeeMapper;
import com.unicdata.entity.boutique.*;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.entity.order.Order;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.BoutiqueRetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * 订单服务层
 *
 * @author admin
 */
@Service
public class BoutiqueRetailServiceImpl implements BoutiqueRetailService {
    @Autowired
    private BoutiqueRetailMapper boutiqueRetailMapper;
    @Autowired
    private BoutiqueRetailIncludeMapper boutiqueRetailIncludeMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private BoutiqueInstallMapper installMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private CarGoodInfoMapper carGoodInfoMapper;
    @Autowired
    private BoutiqueRetailCustomerMapper retailCustomerMapper;
    @Autowired
    private BoutiqueOutboundMapper outboundMapper;
    @Autowired
    private BoutiquePackageIncludeMapper packageIncludeMapper;
    @Autowired
    private BoutiqueOutboundDetailMapper outboundDetailMapper;

    @Transactional
    public int addBoutiqueRetail(BoutiqueRetail record, BoutiqueRetailInclude bri, String jsonStr, Integer editType) {
        record.setSource(0);
        //根据orderid查询精品订单
        BoutiqueRetail boutiqueRetail = boutiqueRetailMapper.selectByCondition(record);
        if (null == boutiqueRetail) {
            Order order = orderMapper.selectByPrimaryKey(record.getOrderId());
            record.setCode(order.getOrderNum());
            record.setCustomerId(order.getCusId());
            record.setType(BoutiqueType.UNSUBMITTED.getCode());
            int res = boutiqueRetailMapper.insertSelective(record);
            if (res > 0) {
                //修改订单精品状态
                Order tempOrder = new Order();
                tempOrder.setId(record.getOrderId());
                tempOrder.setBoutiqueStatus(1);
                orderMapper.updateByPrimaryKeySelective(tempOrder);
            }
        } else {//下过精品订单,再次购买只添加明细表
            record = boutiqueRetail;
            //先删除再新增		
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("retailId", boutiqueRetail.getId());
            params.put("isPackage", bri.getIsPackage());
            if (bri.getIsPackage() == 1) {
                params.put("packId", bri.getInformationId());
            } else {
                params.put("informationId", bri.getInformationId());
            }
            boutiqueRetailIncludeMapper.deleteByMap(params);
        }
        if (bri.getIsPackage() == 1) {
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            JSONArray jsonArr = new JSONArray();
            if (StringUtil.isNotBlank(jsonStr)) {
                jsonArr = JSONArray.parseArray(jsonStr);
                for (int i = 0; i < jsonArr.size(); i++) {
                    JSONObject json = jsonArr.getJSONObject(i);
                    Map<String, Object> map = JSON.parseObject(json.toJSONString());
                    map.put("retailId", record.getId());
                    map.put("packId", bri.getInformationId());
                    map.put("isPackage", bri.getIsPackage());
                    map.put("isGift", bri.getIsGift());
                    list.add(map);
                }
            }
            //批量插入
            boutiqueRetailIncludeMapper.insertBatch(list);
        } else {
            bri.setRetailId(record.getId());
            //单品插入
            bri.setApplyValue(bri.getSaleValue());
            boutiqueRetailIncludeMapper.insertSelective(bri);
        }
        //计算毛利
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("retailId", record.getId());
        List<Map<String, Object>> informationList = boutiqueRetailIncludeMapper.getBoutiquePackageByMap(params);
        BigDecimal cost = BigDecimal.ZERO;
        for(Map<String, Object> info:informationList){
        	String taxPrice = String.valueOf(info.get("taxPrice"));
        	cost = cost.add(new BigDecimal(taxPrice));
        }
        
        Map<String, Object> calcParams = new HashMap<String, Object>();
        calcParams.put("retailId", record.getId());
        calcParams.put("isGift", 0);
        //计算总价
        BigDecimal priceSum = boutiqueRetailIncludeMapper.calcBoutiqueSumByRetailId(calcParams);
        //同步精品订单总销售价
        BoutiqueRetail tempRecord = new BoutiqueRetail();
        tempRecord.setId(record.getId());
        tempRecord.setSaleCount(priceSum);
        tempRecord.setApplyCount(priceSum);
        tempRecord.setMargin(priceSum.subtract(cost));//毛利
        boutiqueRetailMapper.updateByPrimaryKeySelective(tempRecord);
        return 1;
    }

    @Override
    public List<BoutiqueRetail> selectByExample(BoutiqueRetailExample example) {
        return boutiqueRetailMapper.selectByExample(example);
    }

    @Override
    public BoutiqueRetail selectByCondition(BoutiqueRetail record) {
        return boutiqueRetailMapper.selectByCondition(record);
    }

    /**
     * 精品审批分页
     *
     * @param record
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo getMouthBoutiqueRetailByStoreId(Map<String, Object> map, Integer pageNum, Integer pageSize) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> boutiqueRetails1 = boutiqueRetailMapper.getMouthBoutiqueRetailByStoreId(map);
        for (Map<String, Object> objectMap : boutiqueRetails1) {
            Object apply_count = objectMap.get("apply_count");
            Object sale_count = objectMap.get("sale_count");
            if (apply_count != null && sale_count != null) {
                BigDecimal apply_count1 = new BigDecimal(apply_count.toString());
                BigDecimal sale_count1 = new BigDecimal(sale_count.toString());
                BigDecimal bigDecimal = new BigDecimal(100);
                if (sale_count1.compareTo(BigDecimal.ZERO) == 1) {
                    String discount = apply_count1.divide(sale_count1, 4, BigDecimal.ROUND_HALF_DOWN).multiply(bigDecimal).setScale(2) + "%";
                    objectMap.put("discount", discount);
                } else {
                    objectMap.put("discount", "0.00%");
                }
            } else {
                objectMap.put("discount", "0.00%");
            }
            //精品来源
            Object source = objectMap.get("source");
            if (source != null) {
                Integer integer = Integer.valueOf(source.toString());
                BoutiqueEnum.BoutiqueSource[] values = BoutiqueEnum.BoutiqueSource.values();
                String reason = values[integer].getReason();
                objectMap.put("source", reason + "订单");
                if (integer == 0) {
                    objectMap.put("sellCusName", objectMap.get("sellCusName") == null ? "" : objectMap.get("sellCusName".toString()));
                } else {
                    objectMap.put("sellCusName", objectMap.get("retailCusName") == null ? "" : objectMap.get("retailCusName".toString()));
                }
            }
        }
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(boutiqueRetails1);
        return pageInfo;
    }

    @Override
    public Double getMouthCostSumByisPackage(Map<String, Object> map) {
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
    public Map<String, Object> getBoutiqueListByOrderId(Integer orderId) {
        //订单精品-礼包
        List<Map<String, Object>> boutiquePackage = boutiqueRetailMapper.getBoutiquePackageOrderId(orderId);
        //订单精品-单品
        List<Map<String, Object>> boutiqueInformation = boutiqueRetailMapper.getBoutiqueInformationOrderId(orderId);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> boutiqueMap = new HashMap<String, Object>();
        if (boutiquePackage.size() > 0) {
            for (Map<String, Object> bi : boutiqueInformation) {
                boutiquePackage.add(bi);
            }
            list = boutiquePackage;
        } else {
            list = boutiqueInformation;
        }
        boutiqueMap.put("boutiqueList", list);
        boutiqueMap.put("boutiqueOrderId", list.size() > 0 ? list.get(0).get("id") : null);
        //精品订单审批状态
        boutiqueMap.put("type", list.size() > 0 ? list.get(0).get("type") : null);
        boutiqueMap.put("saleCount", list.size() > 0 ? list.get(0).get("applyCount") : 0);
        return boutiqueMap;
    }

    @Override
    public List<Map<String, Object>> getBoutiqueOrderId(Integer orderId) {
        return boutiqueRetailMapper.getBoutiqueOrderId(orderId);
    }

    @Override
    public PageInfo getBoutiqueEetailRecordByMouthId(Map<String, Object> map, Integer pageNum, Integer pageSize) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> boutiqueRetails1 = boutiqueRetailMapper.getBoutiqueEetailRecordByMouthId(map);
        for (Map<String, Object> objectMap : boutiqueRetails1) {
            Object apply_count = objectMap.get("apply_count");
            Object sale_count = objectMap.get("sale_count");
            if (apply_count != null && sale_count != null) {
                BigDecimal apply_count1 = new BigDecimal(apply_count.toString());
                BigDecimal sale_count1 = new BigDecimal(sale_count.toString());
                BigDecimal bigDecimal = new BigDecimal(100);
                String discount = apply_count1.divide(sale_count1, 4, BigDecimal.ROUND_HALF_DOWN).multiply(bigDecimal).setScale(2) + "%";
                objectMap.put("discount", discount);
            } else {
                objectMap.put("discount", "0.00%");
            }
            //精品来源
            Object source = objectMap.get("source");
            if (source != null) {
                Integer integer = Integer.valueOf(source.toString());
                BoutiqueEnum.BoutiqueSource[] values = BoutiqueEnum.BoutiqueSource.values();
                String reason = values[integer].getReason();
                objectMap.put("source", reason + "订单");
                if (integer == 0) {
                    objectMap.put("sellCusName", objectMap.get("sellCusName") == null ? "" : objectMap.get("sellCusName".toString()));
                } else {
                    objectMap.put("sellCusName", objectMap.get("retailCusName") == null ? "" : objectMap.get("retailCusName".toString()));
                }
            }
            //是否价格划分
            Object is_division = objectMap.get("is_division");
            if (is_division != null) {
                Integer integer = Integer.valueOf(is_division.toString());
                String isDivision = integer == 0 ? "未划分" : "已划分";
                objectMap.put("is_division", isDivision);
            }
        }
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(boutiqueRetails1);
        return pageInfo;
    }

    @Override
    public int updateByPrimaryKeySelective(BoutiqueRetail record) {
        return boutiqueRetailMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    public int deleteBoutiqueRetail(Map<String, Object> params) {
        int res = 0;
        BoutiqueRetail br = new BoutiqueRetail();
        Integer orderId = Integer.valueOf(String.valueOf(params.get("orderId")));
        br.setOrderId(orderId);
        br = boutiqueRetailMapper.selectByCondition(br);
        if (null != br) {
            int retailId = br.getId();
            params.put("retailId", retailId);
            res = boutiqueRetailIncludeMapper.deleteByMap(params);
            if (res > 0) {//删除成功
                List<BoutiqueRetailInclude> list = boutiqueRetailIncludeMapper.selectAllByRetailId(retailId);
                if (list.size() <= 0) {//查询是否还有精品明细
                    params.put("status", dataStatus.Disable.ordinal());
                    params.put("source", BoutiqueSource.SELL.getCode());
                    res = boutiqueRetailMapper.delBoutiqueRetail(params);
                }else{
                	//计算毛利
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("retailId", retailId);
                    List<Map<String, Object>> informationList = boutiqueRetailIncludeMapper.getBoutiquePackageByMap(map);
                    BigDecimal cost = BigDecimal.ZERO;
                    for(Map<String, Object> info:informationList){
                    	String taxPrice = String.valueOf(info.get("taxPrice"));
                    	cost = cost.add(new BigDecimal(taxPrice));
                    }
                    
                    Map<String, Object> calcParams = new HashMap<String, Object>();
                    calcParams.put("retailId", retailId);
                    calcParams.put("isGift", 0);
                    //计算总价
                    BigDecimal priceSum = boutiqueRetailIncludeMapper.calcBoutiqueSumByRetailId(calcParams);
                    //同步精品订单总销售价
                    BoutiqueRetail tempRecord = new BoutiqueRetail();
                    tempRecord.setId(retailId);
                    tempRecord.setSaleCount(priceSum);
                    tempRecord.setApplyCount(priceSum);
                    tempRecord.setMargin(priceSum.subtract(cost));//毛利
                    boutiqueRetailMapper.updateByPrimaryKeySelective(tempRecord);
                }
            }
        }
        return res;
    }

    /**
     * 精品经理确定排程日期时，需要生成精品出库数据。此接口提供根据排程单Id，生成出库数据。
     * <hr/>
     * 精品APP上首次确认精品安装排期时间后调用这个接口。
     *
     * @param installId@return
     */
    @Override
    public boolean createOutboundByInstallId(Integer installId) {
        boolean flag = false;
        BoutiqueInstall boutiqueInstall = installMapper.selectByPrimaryKey(installId);
        flag = createOutbound(boutiqueInstall.getRetailId(), installId);
        return flag;
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

        outbound.setBoutiqueNo(retail.getCode()); //精品订单号
        outbound.setStatus(BoutiqueEnum.OutboundType.NOT.getCode());//单据状态
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
            	
//                Integer isPackage = retailInclude.getIsPackage();
//                if (isPackage == 0) {
//                    BoutiqueOutboundDetail detail = new BoutiqueOutboundDetail();
//
//                    detail.setBoutiqueId(retailInclude.getInformationId());//精品ID
//                    detail.setNumer(retailInclude.getInformationNum());//精品数量
//                    detail.setOutboundId(outbound.getId());//出库单id
//                    detail.setBoutiqueOrderId(retail.getId());//精品订单id
//                    detail.setBoutiqueConstruction(retailInclude.getConstructionNode());//施工节点
//                    detail.setStatus(0);//默认未出库
//                    detail.setTypeLive(1);
//                    allDetail.add(detail);
//                } else {
//                    Integer packId = retailInclude.getPackId();
//                    Integer num = retailInclude.getInformationNum();
//                    List<BoutiquePackageInclude> selectByPackageId = packageIncludeMapper.selectByPackageId(packId);
//                    for (BoutiquePackageInclude packageInclude : selectByPackageId) {
//                        BoutiqueOutboundDetail detail = new BoutiqueOutboundDetail();
//
//                        detail.setBoutiqueId(packageInclude.getInformationId());//精品ID
//                        detail.setNumer(num * packageInclude.getInformationNum());//精品数量
//                        detail.setOutboundId(outbound.getId());//出库单id
//                        detail.setBoutiqueOrderId(retail.getId());//精品订单id
//                        detail.setBoutiqueConstruction(retailInclude.getConstructionNode());//施工节点
//                        detail.setStatus(0);//默认未出库
//                        detail.setTypeLive(1);
//                        allDetail.add(detail);
//                    }
//                }
            }
            outboundDetailMapper.insertBatch(allDetail);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * 根据订单id查询订单精品集合
     *
     * @param orderId
     * @return
     */
    @Override
    public List<Map<String, Object>> getBoutiqueRetailByOId(Integer orderId) {
        return boutiqueRetailMapper.getBoutiqueRetailByOId(orderId);
    }
}
