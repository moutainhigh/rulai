package com.unicdata.entity.policy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RebateCarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RebateCarExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIsNull() {
            addCriterion("policy_id is null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIsNotNull() {
            addCriterion("policy_id is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdEqualTo(Integer value) {
            addCriterion("policy_id =", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotEqualTo(Integer value) {
            addCriterion("policy_id <>", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThan(Integer value) {
            addCriterion("policy_id >", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("policy_id >=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThan(Integer value) {
            addCriterion("policy_id <", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThanOrEqualTo(Integer value) {
            addCriterion("policy_id <=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIn(List<Integer> values) {
            addCriterion("policy_id in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotIn(List<Integer> values) {
            addCriterion("policy_id not in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdBetween(Integer value1, Integer value2) {
            addCriterion("policy_id between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("policy_id not between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andRebateProjectIdIsNull() {
            addCriterion("rebate_project_id is null");
            return (Criteria) this;
        }

        public Criteria andRebateProjectIdIsNotNull() {
            addCriterion("rebate_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andRebateProjectIdEqualTo(Integer value) {
            addCriterion("rebate_project_id =", value, "rebateProjectId");
            return (Criteria) this;
        }

        public Criteria andRebateProjectIdNotEqualTo(Integer value) {
            addCriterion("rebate_project_id <>", value, "rebateProjectId");
            return (Criteria) this;
        }

        public Criteria andRebateProjectIdGreaterThan(Integer value) {
            addCriterion("rebate_project_id >", value, "rebateProjectId");
            return (Criteria) this;
        }

        public Criteria andRebateProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rebate_project_id >=", value, "rebateProjectId");
            return (Criteria) this;
        }

        public Criteria andRebateProjectIdLessThan(Integer value) {
            addCriterion("rebate_project_id <", value, "rebateProjectId");
            return (Criteria) this;
        }

        public Criteria andRebateProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("rebate_project_id <=", value, "rebateProjectId");
            return (Criteria) this;
        }

        public Criteria andRebateProjectIdIn(List<Integer> values) {
            addCriterion("rebate_project_id in", values, "rebateProjectId");
            return (Criteria) this;
        }

        public Criteria andRebateProjectIdNotIn(List<Integer> values) {
            addCriterion("rebate_project_id not in", values, "rebateProjectId");
            return (Criteria) this;
        }

        public Criteria andRebateProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("rebate_project_id between", value1, value2, "rebateProjectId");
            return (Criteria) this;
        }

        public Criteria andRebateProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rebate_project_id not between", value1, value2, "rebateProjectId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Integer value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Integer value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Integer value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Integer value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Integer> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Integer> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Integer value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Integer value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Integer value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Integer value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Integer> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Integer> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Integer value1, Integer value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andVinIsNull() {
            addCriterion("vin is null");
            return (Criteria) this;
        }

        public Criteria andVinIsNotNull() {
            addCriterion("vin is not null");
            return (Criteria) this;
        }

        public Criteria andVinEqualTo(String value) {
            addCriterion("vin =", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotEqualTo(String value) {
            addCriterion("vin <>", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThan(String value) {
            addCriterion("vin >", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThanOrEqualTo(String value) {
            addCriterion("vin >=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThan(String value) {
            addCriterion("vin <", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThanOrEqualTo(String value) {
            addCriterion("vin <=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLike(String value) {
            addCriterion("vin like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotLike(String value) {
            addCriterion("vin not like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinIn(List<String> values) {
            addCriterion("vin in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotIn(List<String> values) {
            addCriterion("vin not in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinBetween(String value1, String value2) {
            addCriterion("vin between", value1, value2, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotBetween(String value1, String value2) {
            addCriterion("vin not between", value1, value2, "vin");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateRebateIsNull() {
            addCriterion("first_estimate_rebate is null");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateRebateIsNotNull() {
            addCriterion("first_estimate_rebate is not null");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateRebateEqualTo(BigDecimal value) {
            addCriterion("first_estimate_rebate =", value, "firstEstimateRebate");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateRebateNotEqualTo(BigDecimal value) {
            addCriterion("first_estimate_rebate <>", value, "firstEstimateRebate");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateRebateGreaterThan(BigDecimal value) {
            addCriterion("first_estimate_rebate >", value, "firstEstimateRebate");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateRebateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_estimate_rebate >=", value, "firstEstimateRebate");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateRebateLessThan(BigDecimal value) {
            addCriterion("first_estimate_rebate <", value, "firstEstimateRebate");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateRebateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_estimate_rebate <=", value, "firstEstimateRebate");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateRebateIn(List<BigDecimal> values) {
            addCriterion("first_estimate_rebate in", values, "firstEstimateRebate");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateRebateNotIn(List<BigDecimal> values) {
            addCriterion("first_estimate_rebate not in", values, "firstEstimateRebate");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateRebateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_estimate_rebate between", value1, value2, "firstEstimateRebate");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateRebateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_estimate_rebate not between", value1, value2, "firstEstimateRebate");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustIsNull() {
            addCriterion("estimate_adjust is null");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustIsNotNull() {
            addCriterion("estimate_adjust is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustEqualTo(BigDecimal value) {
            addCriterion("estimate_adjust =", value, "estimateAdjust");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustNotEqualTo(BigDecimal value) {
            addCriterion("estimate_adjust <>", value, "estimateAdjust");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustGreaterThan(BigDecimal value) {
            addCriterion("estimate_adjust >", value, "estimateAdjust");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("estimate_adjust >=", value, "estimateAdjust");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustLessThan(BigDecimal value) {
            addCriterion("estimate_adjust <", value, "estimateAdjust");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustLessThanOrEqualTo(BigDecimal value) {
            addCriterion("estimate_adjust <=", value, "estimateAdjust");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustIn(List<BigDecimal> values) {
            addCriterion("estimate_adjust in", values, "estimateAdjust");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustNotIn(List<BigDecimal> values) {
            addCriterion("estimate_adjust not in", values, "estimateAdjust");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("estimate_adjust between", value1, value2, "estimateAdjust");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("estimate_adjust not between", value1, value2, "estimateAdjust");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIsNull() {
            addCriterion("plan_extraction is null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIsNotNull() {
            addCriterion("plan_extraction is not null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionEqualTo(BigDecimal value) {
            addCriterion("plan_extraction =", value, "planExtraction");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionNotEqualTo(BigDecimal value) {
            addCriterion("plan_extraction <>", value, "planExtraction");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionGreaterThan(BigDecimal value) {
            addCriterion("plan_extraction >", value, "planExtraction");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_extraction >=", value, "planExtraction");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionLessThan(BigDecimal value) {
            addCriterion("plan_extraction <", value, "planExtraction");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_extraction <=", value, "planExtraction");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIn(List<BigDecimal> values) {
            addCriterion("plan_extraction in", values, "planExtraction");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionNotIn(List<BigDecimal> values) {
            addCriterion("plan_extraction not in", values, "planExtraction");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_extraction between", value1, value2, "planExtraction");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_extraction not between", value1, value2, "planExtraction");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustIsNull() {
            addCriterion("plan_extraction_adjust is null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustIsNotNull() {
            addCriterion("plan_extraction_adjust is not null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustEqualTo(BigDecimal value) {
            addCriterion("plan_extraction_adjust =", value, "planExtractionAdjust");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustNotEqualTo(BigDecimal value) {
            addCriterion("plan_extraction_adjust <>", value, "planExtractionAdjust");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustGreaterThan(BigDecimal value) {
            addCriterion("plan_extraction_adjust >", value, "planExtractionAdjust");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_extraction_adjust >=", value, "planExtractionAdjust");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustLessThan(BigDecimal value) {
            addCriterion("plan_extraction_adjust <", value, "planExtractionAdjust");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_extraction_adjust <=", value, "planExtractionAdjust");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustIn(List<BigDecimal> values) {
            addCriterion("plan_extraction_adjust in", values, "planExtractionAdjust");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustNotIn(List<BigDecimal> values) {
            addCriterion("plan_extraction_adjust not in", values, "planExtractionAdjust");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_extraction_adjust between", value1, value2, "planExtractionAdjust");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_extraction_adjust not between", value1, value2, "planExtractionAdjust");
            return (Criteria) this;
        }

        public Criteria andIsPlanExtractionIsNull() {
            addCriterion("is_plan_extraction is null");
            return (Criteria) this;
        }

        public Criteria andIsPlanExtractionIsNotNull() {
            addCriterion("is_plan_extraction is not null");
            return (Criteria) this;
        }

        public Criteria andIsPlanExtractionEqualTo(Integer value) {
            addCriterion("is_plan_extraction =", value, "isPlanExtraction");
            return (Criteria) this;
        }

        public Criteria andIsPlanExtractionNotEqualTo(Integer value) {
            addCriterion("is_plan_extraction <>", value, "isPlanExtraction");
            return (Criteria) this;
        }

        public Criteria andIsPlanExtractionGreaterThan(Integer value) {
            addCriterion("is_plan_extraction >", value, "isPlanExtraction");
            return (Criteria) this;
        }

        public Criteria andIsPlanExtractionGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_plan_extraction >=", value, "isPlanExtraction");
            return (Criteria) this;
        }

        public Criteria andIsPlanExtractionLessThan(Integer value) {
            addCriterion("is_plan_extraction <", value, "isPlanExtraction");
            return (Criteria) this;
        }

        public Criteria andIsPlanExtractionLessThanOrEqualTo(Integer value) {
            addCriterion("is_plan_extraction <=", value, "isPlanExtraction");
            return (Criteria) this;
        }

        public Criteria andIsPlanExtractionIn(List<Integer> values) {
            addCriterion("is_plan_extraction in", values, "isPlanExtraction");
            return (Criteria) this;
        }

        public Criteria andIsPlanExtractionNotIn(List<Integer> values) {
            addCriterion("is_plan_extraction not in", values, "isPlanExtraction");
            return (Criteria) this;
        }

        public Criteria andIsPlanExtractionBetween(Integer value1, Integer value2) {
            addCriterion("is_plan_extraction between", value1, value2, "isPlanExtraction");
            return (Criteria) this;
        }

        public Criteria andIsPlanExtractionNotBetween(Integer value1, Integer value2) {
            addCriterion("is_plan_extraction not between", value1, value2, "isPlanExtraction");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateIsNull() {
            addCriterion("plan_extraction_date is null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateIsNotNull() {
            addCriterion("plan_extraction_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateEqualTo(Date value) {
            addCriterion("plan_extraction_date =", value, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateNotEqualTo(Date value) {
            addCriterion("plan_extraction_date <>", value, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateGreaterThan(Date value) {
            addCriterion("plan_extraction_date >", value, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_extraction_date >=", value, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateLessThan(Date value) {
            addCriterion("plan_extraction_date <", value, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateLessThanOrEqualTo(Date value) {
            addCriterion("plan_extraction_date <=", value, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateIn(List<Date> values) {
            addCriterion("plan_extraction_date in", values, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateNotIn(List<Date> values) {
            addCriterion("plan_extraction_date not in", values, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateBetween(Date value1, Date value2) {
            addCriterion("plan_extraction_date between", value1, value2, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateNotBetween(Date value1, Date value2) {
            addCriterion("plan_extraction_date not between", value1, value2, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andProofreaderIdIsNull() {
            addCriterion("proofreader_id is null");
            return (Criteria) this;
        }

        public Criteria andProofreaderIdIsNotNull() {
            addCriterion("proofreader_id is not null");
            return (Criteria) this;
        }

        public Criteria andProofreaderIdEqualTo(Integer value) {
            addCriterion("proofreader_id =", value, "proofreaderId");
            return (Criteria) this;
        }

        public Criteria andProofreaderIdNotEqualTo(Integer value) {
            addCriterion("proofreader_id <>", value, "proofreaderId");
            return (Criteria) this;
        }

        public Criteria andProofreaderIdGreaterThan(Integer value) {
            addCriterion("proofreader_id >", value, "proofreaderId");
            return (Criteria) this;
        }

        public Criteria andProofreaderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("proofreader_id >=", value, "proofreaderId");
            return (Criteria) this;
        }

        public Criteria andProofreaderIdLessThan(Integer value) {
            addCriterion("proofreader_id <", value, "proofreaderId");
            return (Criteria) this;
        }

        public Criteria andProofreaderIdLessThanOrEqualTo(Integer value) {
            addCriterion("proofreader_id <=", value, "proofreaderId");
            return (Criteria) this;
        }

        public Criteria andProofreaderIdIn(List<Integer> values) {
            addCriterion("proofreader_id in", values, "proofreaderId");
            return (Criteria) this;
        }

        public Criteria andProofreaderIdNotIn(List<Integer> values) {
            addCriterion("proofreader_id not in", values, "proofreaderId");
            return (Criteria) this;
        }

        public Criteria andProofreaderIdBetween(Integer value1, Integer value2) {
            addCriterion("proofreader_id between", value1, value2, "proofreaderId");
            return (Criteria) this;
        }

        public Criteria andProofreaderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("proofreader_id not between", value1, value2, "proofreaderId");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyIsNull() {
            addCriterion("proofreader_money is null");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyIsNotNull() {
            addCriterion("proofreader_money is not null");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyEqualTo(BigDecimal value) {
            addCriterion("proofreader_money =", value, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyNotEqualTo(BigDecimal value) {
            addCriterion("proofreader_money <>", value, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyGreaterThan(BigDecimal value) {
            addCriterion("proofreader_money >", value, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("proofreader_money >=", value, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyLessThan(BigDecimal value) {
            addCriterion("proofreader_money <", value, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("proofreader_money <=", value, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyIn(List<BigDecimal> values) {
            addCriterion("proofreader_money in", values, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyNotIn(List<BigDecimal> values) {
            addCriterion("proofreader_money not in", values, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("proofreader_money between", value1, value2, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("proofreader_money not between", value1, value2, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderDateIsNull() {
            addCriterion("proofreader_date is null");
            return (Criteria) this;
        }

        public Criteria andProofreaderDateIsNotNull() {
            addCriterion("proofreader_date is not null");
            return (Criteria) this;
        }

        public Criteria andProofreaderDateEqualTo(Date value) {
            addCriterion("proofreader_date =", value, "proofreaderDate");
            return (Criteria) this;
        }

        public Criteria andProofreaderDateNotEqualTo(Date value) {
            addCriterion("proofreader_date <>", value, "proofreaderDate");
            return (Criteria) this;
        }

        public Criteria andProofreaderDateGreaterThan(Date value) {
            addCriterion("proofreader_date >", value, "proofreaderDate");
            return (Criteria) this;
        }

        public Criteria andProofreaderDateGreaterThanOrEqualTo(Date value) {
            addCriterion("proofreader_date >=", value, "proofreaderDate");
            return (Criteria) this;
        }

        public Criteria andProofreaderDateLessThan(Date value) {
            addCriterion("proofreader_date <", value, "proofreaderDate");
            return (Criteria) this;
        }

        public Criteria andProofreaderDateLessThanOrEqualTo(Date value) {
            addCriterion("proofreader_date <=", value, "proofreaderDate");
            return (Criteria) this;
        }

        public Criteria andProofreaderDateIn(List<Date> values) {
            addCriterion("proofreader_date in", values, "proofreaderDate");
            return (Criteria) this;
        }

        public Criteria andProofreaderDateNotIn(List<Date> values) {
            addCriterion("proofreader_date not in", values, "proofreaderDate");
            return (Criteria) this;
        }

        public Criteria andProofreaderDateBetween(Date value1, Date value2) {
            addCriterion("proofreader_date between", value1, value2, "proofreaderDate");
            return (Criteria) this;
        }

        public Criteria andProofreaderDateNotBetween(Date value1, Date value2) {
            addCriterion("proofreader_date not between", value1, value2, "proofreaderDate");
            return (Criteria) this;
        }

        public Criteria andArriveBillIdIsNull() {
            addCriterion("arrive_bill_id is null");
            return (Criteria) this;
        }

        public Criteria andArriveBillIdIsNotNull() {
            addCriterion("arrive_bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andArriveBillIdEqualTo(Integer value) {
            addCriterion("arrive_bill_id =", value, "arriveBillId");
            return (Criteria) this;
        }

        public Criteria andArriveBillIdNotEqualTo(Integer value) {
            addCriterion("arrive_bill_id <>", value, "arriveBillId");
            return (Criteria) this;
        }

        public Criteria andArriveBillIdGreaterThan(Integer value) {
            addCriterion("arrive_bill_id >", value, "arriveBillId");
            return (Criteria) this;
        }

        public Criteria andArriveBillIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("arrive_bill_id >=", value, "arriveBillId");
            return (Criteria) this;
        }

        public Criteria andArriveBillIdLessThan(Integer value) {
            addCriterion("arrive_bill_id <", value, "arriveBillId");
            return (Criteria) this;
        }

        public Criteria andArriveBillIdLessThanOrEqualTo(Integer value) {
            addCriterion("arrive_bill_id <=", value, "arriveBillId");
            return (Criteria) this;
        }

        public Criteria andArriveBillIdIn(List<Integer> values) {
            addCriterion("arrive_bill_id in", values, "arriveBillId");
            return (Criteria) this;
        }

        public Criteria andArriveBillIdNotIn(List<Integer> values) {
            addCriterion("arrive_bill_id not in", values, "arriveBillId");
            return (Criteria) this;
        }

        public Criteria andArriveBillIdBetween(Integer value1, Integer value2) {
            addCriterion("arrive_bill_id between", value1, value2, "arriveBillId");
            return (Criteria) this;
        }

        public Criteria andArriveBillIdNotBetween(Integer value1, Integer value2) {
            addCriterion("arrive_bill_id not between", value1, value2, "arriveBillId");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyIsNull() {
            addCriterion("arrive_bill_money is null");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyIsNotNull() {
            addCriterion("arrive_bill_money is not null");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyEqualTo(BigDecimal value) {
            addCriterion("arrive_bill_money =", value, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyNotEqualTo(BigDecimal value) {
            addCriterion("arrive_bill_money <>", value, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyGreaterThan(BigDecimal value) {
            addCriterion("arrive_bill_money >", value, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("arrive_bill_money >=", value, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyLessThan(BigDecimal value) {
            addCriterion("arrive_bill_money <", value, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("arrive_bill_money <=", value, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyIn(List<BigDecimal> values) {
            addCriterion("arrive_bill_money in", values, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyNotIn(List<BigDecimal> values) {
            addCriterion("arrive_bill_money not in", values, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("arrive_bill_money between", value1, value2, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("arrive_bill_money not between", value1, value2, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillDateIsNull() {
            addCriterion("arrive_bill_date is null");
            return (Criteria) this;
        }

        public Criteria andArriveBillDateIsNotNull() {
            addCriterion("arrive_bill_date is not null");
            return (Criteria) this;
        }

        public Criteria andArriveBillDateEqualTo(Date value) {
            addCriterion("arrive_bill_date =", value, "arriveBillDate");
            return (Criteria) this;
        }

        public Criteria andArriveBillDateNotEqualTo(Date value) {
            addCriterion("arrive_bill_date <>", value, "arriveBillDate");
            return (Criteria) this;
        }

        public Criteria andArriveBillDateGreaterThan(Date value) {
            addCriterion("arrive_bill_date >", value, "arriveBillDate");
            return (Criteria) this;
        }

        public Criteria andArriveBillDateGreaterThanOrEqualTo(Date value) {
            addCriterion("arrive_bill_date >=", value, "arriveBillDate");
            return (Criteria) this;
        }

        public Criteria andArriveBillDateLessThan(Date value) {
            addCriterion("arrive_bill_date <", value, "arriveBillDate");
            return (Criteria) this;
        }

        public Criteria andArriveBillDateLessThanOrEqualTo(Date value) {
            addCriterion("arrive_bill_date <=", value, "arriveBillDate");
            return (Criteria) this;
        }

        public Criteria andArriveBillDateIn(List<Date> values) {
            addCriterion("arrive_bill_date in", values, "arriveBillDate");
            return (Criteria) this;
        }

        public Criteria andArriveBillDateNotIn(List<Date> values) {
            addCriterion("arrive_bill_date not in", values, "arriveBillDate");
            return (Criteria) this;
        }

        public Criteria andArriveBillDateBetween(Date value1, Date value2) {
            addCriterion("arrive_bill_date between", value1, value2, "arriveBillDate");
            return (Criteria) this;
        }

        public Criteria andArriveBillDateNotBetween(Date value1, Date value2) {
            addCriterion("arrive_bill_date not between", value1, value2, "arriveBillDate");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(Integer value) {
            addCriterion("employee_id =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(Integer value) {
            addCriterion("employee_id <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(Integer value) {
            addCriterion("employee_id >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_id >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(Integer value) {
            addCriterion("employee_id <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("employee_id <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<Integer> values) {
            addCriterion("employee_id in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<Integer> values) {
            addCriterion("employee_id not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("employee_id between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_id not between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}