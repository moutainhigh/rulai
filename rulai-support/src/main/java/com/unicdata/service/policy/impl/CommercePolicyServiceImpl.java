package com.unicdata.service.policy.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.util.StringUtil;
import com.unicdata.dao.policy.CommercePolicyMapper;
import com.unicdata.entity.counter.Counter;
import com.unicdata.entity.policy.CommercePolicy;
import com.unicdata.entity.policy.CommercePolicyExample;
import com.unicdata.entity.policy.RebateCar;
import com.unicdata.entity.policy.RebateProject;
import com.unicdata.service.CounterService;
import com.unicdata.service.policy.CommercePolicyService;
import com.unicdata.service.policy.RebateCarService;
import com.unicdata.service.policy.RebateProjectService;
import com.unicdata.util.DateUtil;
import net.minidev.json.writer.CompessorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by myMsi on 2018/5/28.
 */
@Service
public class CommercePolicyServiceImpl implements CommercePolicyService {

    @Autowired
    private CommercePolicyMapper commercePolicyMapper;
    @Autowired
    private CounterService counterService;
    @Autowired
    private RebateProjectService rebateProjectService;
    @Autowired
    private RebateCarService rebateCarService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return commercePolicyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CommercePolicy record) {
        return commercePolicyMapper.insert(record);
    }

    @Override
    public int insertSelective(CommercePolicy record) {
        return commercePolicyMapper.insertSelective(record);
    }

    @Override
    public List<CommercePolicy> selectByExample(CommercePolicyExample example) {
        return commercePolicyMapper.selectByExample(example);
    }

    @Override
    public CommercePolicy selectByPrimaryKey(Integer id) {
        return commercePolicyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CommercePolicy record) {
        return commercePolicyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CommercePolicy record) {
        return commercePolicyMapper.updateByPrimaryKey(record);
    }

    @Override
    public Map  selectPolicyPage(CommercePolicy record, Integer pageNum, Integer pageSize) {
        Set virtualRecordTotalSet = new HashSet<>();
        CommercePolicyExample cpe = new CommercePolicyExample();
        CommercePolicyExample.Criteria criteria = cpe.createCriteria();

        if(record.getStoreId() != null && record.getStoreId() > 0 ){
            criteria.andStoreIdEqualTo(record.getStoreId());
        }
        if(StringUtil.isNotBlank(record.getPolicyName())){
            criteria.andPolicyNameEqualTo(record.getPolicyName());
        }
        criteria.andPolicyCreateDateGreaterThanOrEqualTo(DateUtil.stringToDate(record.getYear()+"-01-01","yyyy-MM-dd")).andPolicyCreateDateLessThanOrEqualTo(DateUtil.stringToDate(record.getYear()+"-12-31 23:59:59","yyyy-MM-dd HH:mm:ss"));
        cpe.setOrderByClause(" policy_create_date desc ");
        List<CommercePolicy> commercePolicies = commercePolicyMapper.selectByExample(cpe);
        for(CommercePolicy cp : commercePolicies){
            Long arriveBillDate = 0L;//到账单最新日期
            Long proofreaderDate = 0L;//核对单最新日期
            BigDecimal firstEstimateTotal = BigDecimal.ZERO;
            BigDecimal estimateAdjustTotal = BigDecimal.ZERO;
            BigDecimal planExtractionTotal = BigDecimal.ZERO;
            BigDecimal planExtractionAdjustTotal = BigDecimal.ZERO;
            List<RebateProject> rebateProjects = rebateProjectService.selectRebate(cp.getId());
            for(RebateProject rp : rebateProjects){
                firstEstimateTotal = firstEstimateTotal.add(rp.getFirstEstimateTotal());
                estimateAdjustTotal = estimateAdjustTotal.add(rp.getEstimateAdjustTotal());
                planExtractionTotal = planExtractionTotal.add(rp.getPlanExtractionTotal());
                planExtractionAdjustTotal = planExtractionAdjustTotal.add(rp.getPlanExtractionAdjustTotal());
                if(rp.getProofreaderLists()!=null && rp.getProofreaderLists().size() > 0 && proofreaderDate < rp.getProofreaderLists().get(0).getCreateDate().getTime() ){
                    proofreaderDate = rp.getProofreaderLists().get(0).getCreateDate().getTime();
                }
                if(rp.getArriveBillLists() != null && rp.getArriveBillLists().size() > 0 && arriveBillDate < rp.getArriveBillLists().get(0).getCreateDate().getTime() ){
                    arriveBillDate = rp.getArriveBillLists().get(0).getCreateDate().getTime();
                }
            }
            RebateCar rebateCar = rebateCarService.selectSumProofreaderArriveBillByPolicyId(cp.getId());
            cp.setFirstEstimateTotal(firstEstimateTotal);
            cp.setEstimateAdjustTotal(estimateAdjustTotal);
            cp.setPlanExtractionTotal(planExtractionTotal);
            cp.setPlanExtractionAdjustTotal(planExtractionAdjustTotal);
            cp.setProofreaderDate(proofreaderDate > 0 ? new Date(proofreaderDate) : null);
            cp.setArriveBillDate(arriveBillDate > 0 ? new Date(arriveBillDate) : null);
            cp.setArriveBillMoney(rebateCar != null ? rebateCar.getArriveBillMoney():BigDecimal.ZERO);
            cp.setProofreaderMoney(rebateCar != null ? rebateCar.getProofreaderMoney():BigDecimal.ZERO);

            //查询返利政策虚报台数 （车辆去重）
            List<Integer> virtualRecordTotal = commercePolicyMapper.selectPolicyVirtualRecordTotal(cp.getId());
            cp.setVirtualRecordTotal(BigDecimal.valueOf(virtualRecordTotal== null || virtualRecordTotal.size()<= 0 ? 0 : virtualRecordTotal.size()));//虚报台数
            virtualRecordTotal.forEach(v ->virtualRecordTotalSet.add(v));
        }
        Map map = new HashMap();
        map.put("data",commercePolicies);
        map.put("total",virtualRecordTotalSet.size());
        return map;
    }

    @Override
    public Integer save(CommercePolicy cp) {
        cp.setUpdateDate(new Date());
        if(cp.getId() == null || cp.getId() <= 0) {
            String policyCode = counterService.generateCode(Counter.COMMERCE_POLICY_CODE,"yyyy",4);
            cp.setPolicyCode(policyCode);
            cp.setCreateDate(new Date());
            commercePolicyMapper.insertSelective(cp);
            return cp.getId();
        } else {
            cp.setPolicyCode(null);
            int x = commercePolicyMapper.updateByPrimaryKeySelective(cp);
            return x;
        }
    }


}
