package com.unicdata.entity.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InsuranceConnectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InsuranceConnectionExample() {
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

        public Criteria andInsurerIdIsNull() {
            addCriterion("insurer_id is null");
            return (Criteria) this;
        }

        public Criteria andInsurerIdIsNotNull() {
            addCriterion("insurer_id is not null");
            return (Criteria) this;
        }

        public Criteria andInsurerIdEqualTo(Integer value) {
            addCriterion("insurer_id =", value, "insurerId");
            return (Criteria) this;
        }

        public Criteria andInsurerIdNotEqualTo(Integer value) {
            addCriterion("insurer_id <>", value, "insurerId");
            return (Criteria) this;
        }

        public Criteria andInsurerIdGreaterThan(Integer value) {
            addCriterion("insurer_id >", value, "insurerId");
            return (Criteria) this;
        }

        public Criteria andInsurerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("insurer_id >=", value, "insurerId");
            return (Criteria) this;
        }

        public Criteria andInsurerIdLessThan(Integer value) {
            addCriterion("insurer_id <", value, "insurerId");
            return (Criteria) this;
        }

        public Criteria andInsurerIdLessThanOrEqualTo(Integer value) {
            addCriterion("insurer_id <=", value, "insurerId");
            return (Criteria) this;
        }

        public Criteria andInsurerIdIn(List<Integer> values) {
            addCriterion("insurer_id in", values, "insurerId");
            return (Criteria) this;
        }

        public Criteria andInsurerIdNotIn(List<Integer> values) {
            addCriterion("insurer_id not in", values, "insurerId");
            return (Criteria) this;
        }

        public Criteria andInsurerIdBetween(Integer value1, Integer value2) {
            addCriterion("insurer_id between", value1, value2, "insurerId");
            return (Criteria) this;
        }

        public Criteria andInsurerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("insurer_id not between", value1, value2, "insurerId");
            return (Criteria) this;
        }

        public Criteria andInsuranceIdIsNull() {
            addCriterion("insurance_id is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceIdIsNotNull() {
            addCriterion("insurance_id is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceIdEqualTo(Integer value) {
            addCriterion("insurance_id =", value, "insuranceId");
            return (Criteria) this;
        }

        public Criteria andInsuranceIdNotEqualTo(Integer value) {
            addCriterion("insurance_id <>", value, "insuranceId");
            return (Criteria) this;
        }

        public Criteria andInsuranceIdGreaterThan(Integer value) {
            addCriterion("insurance_id >", value, "insuranceId");
            return (Criteria) this;
        }

        public Criteria andInsuranceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("insurance_id >=", value, "insuranceId");
            return (Criteria) this;
        }

        public Criteria andInsuranceIdLessThan(Integer value) {
            addCriterion("insurance_id <", value, "insuranceId");
            return (Criteria) this;
        }

        public Criteria andInsuranceIdLessThanOrEqualTo(Integer value) {
            addCriterion("insurance_id <=", value, "insuranceId");
            return (Criteria) this;
        }

        public Criteria andInsuranceIdIn(List<Integer> values) {
            addCriterion("insurance_id in", values, "insuranceId");
            return (Criteria) this;
        }

        public Criteria andInsuranceIdNotIn(List<Integer> values) {
            addCriterion("insurance_id not in", values, "insuranceId");
            return (Criteria) this;
        }

        public Criteria andInsuranceIdBetween(Integer value1, Integer value2) {
            addCriterion("insurance_id between", value1, value2, "insuranceId");
            return (Criteria) this;
        }

        public Criteria andInsuranceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("insurance_id not between", value1, value2, "insuranceId");
            return (Criteria) this;
        }

        public Criteria andTaxRemovalRatioIsNull() {
            addCriterion("tax_removal_ratio is null");
            return (Criteria) this;
        }

        public Criteria andTaxRemovalRatioIsNotNull() {
            addCriterion("tax_removal_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRemovalRatioEqualTo(BigDecimal value) {
            addCriterion("tax_removal_ratio =", value, "taxRemovalRatio");
            return (Criteria) this;
        }

        public Criteria andTaxRemovalRatioNotEqualTo(BigDecimal value) {
            addCriterion("tax_removal_ratio <>", value, "taxRemovalRatio");
            return (Criteria) this;
        }

        public Criteria andTaxRemovalRatioGreaterThan(BigDecimal value) {
            addCriterion("tax_removal_ratio >", value, "taxRemovalRatio");
            return (Criteria) this;
        }

        public Criteria andTaxRemovalRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_removal_ratio >=", value, "taxRemovalRatio");
            return (Criteria) this;
        }

        public Criteria andTaxRemovalRatioLessThan(BigDecimal value) {
            addCriterion("tax_removal_ratio <", value, "taxRemovalRatio");
            return (Criteria) this;
        }

        public Criteria andTaxRemovalRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_removal_ratio <=", value, "taxRemovalRatio");
            return (Criteria) this;
        }

        public Criteria andTaxRemovalRatioIn(List<BigDecimal> values) {
            addCriterion("tax_removal_ratio in", values, "taxRemovalRatio");
            return (Criteria) this;
        }

        public Criteria andTaxRemovalRatioNotIn(List<BigDecimal> values) {
            addCriterion("tax_removal_ratio not in", values, "taxRemovalRatio");
            return (Criteria) this;
        }

        public Criteria andTaxRemovalRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_removal_ratio between", value1, value2, "taxRemovalRatio");
            return (Criteria) this;
        }

        public Criteria andTaxRemovalRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_removal_ratio not between", value1, value2, "taxRemovalRatio");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameIsNull() {
            addCriterion("insurance_name is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameIsNotNull() {
            addCriterion("insurance_name is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameEqualTo(String value) {
            addCriterion("insurance_name =", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameNotEqualTo(String value) {
            addCriterion("insurance_name <>", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameGreaterThan(String value) {
            addCriterion("insurance_name >", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameGreaterThanOrEqualTo(String value) {
            addCriterion("insurance_name >=", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameLessThan(String value) {
            addCriterion("insurance_name <", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameLessThanOrEqualTo(String value) {
            addCriterion("insurance_name <=", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameLike(String value) {
            addCriterion("insurance_name like", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameNotLike(String value) {
            addCriterion("insurance_name not like", value, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameIn(List<String> values) {
            addCriterion("insurance_name in", values, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameNotIn(List<String> values) {
            addCriterion("insurance_name not in", values, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameBetween(String value1, String value2) {
            addCriterion("insurance_name between", value1, value2, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsuranceNameNotBetween(String value1, String value2) {
            addCriterion("insurance_name not between", value1, value2, "insuranceName");
            return (Criteria) this;
        }

        public Criteria andInsurerNameIsNull() {
            addCriterion("insurer_name is null");
            return (Criteria) this;
        }

        public Criteria andInsurerNameIsNotNull() {
            addCriterion("insurer_name is not null");
            return (Criteria) this;
        }

        public Criteria andInsurerNameEqualTo(String value) {
            addCriterion("insurer_name =", value, "insurerName");
            return (Criteria) this;
        }

        public Criteria andInsurerNameNotEqualTo(String value) {
            addCriterion("insurer_name <>", value, "insurerName");
            return (Criteria) this;
        }

        public Criteria andInsurerNameGreaterThan(String value) {
            addCriterion("insurer_name >", value, "insurerName");
            return (Criteria) this;
        }

        public Criteria andInsurerNameGreaterThanOrEqualTo(String value) {
            addCriterion("insurer_name >=", value, "insurerName");
            return (Criteria) this;
        }

        public Criteria andInsurerNameLessThan(String value) {
            addCriterion("insurer_name <", value, "insurerName");
            return (Criteria) this;
        }

        public Criteria andInsurerNameLessThanOrEqualTo(String value) {
            addCriterion("insurer_name <=", value, "insurerName");
            return (Criteria) this;
        }

        public Criteria andInsurerNameLike(String value) {
            addCriterion("insurer_name like", value, "insurerName");
            return (Criteria) this;
        }

        public Criteria andInsurerNameNotLike(String value) {
            addCriterion("insurer_name not like", value, "insurerName");
            return (Criteria) this;
        }

        public Criteria andInsurerNameIn(List<String> values) {
            addCriterion("insurer_name in", values, "insurerName");
            return (Criteria) this;
        }

        public Criteria andInsurerNameNotIn(List<String> values) {
            addCriterion("insurer_name not in", values, "insurerName");
            return (Criteria) this;
        }

        public Criteria andInsurerNameBetween(String value1, String value2) {
            addCriterion("insurer_name between", value1, value2, "insurerName");
            return (Criteria) this;
        }

        public Criteria andInsurerNameNotBetween(String value1, String value2) {
            addCriterion("insurer_name not between", value1, value2, "insurerName");
            return (Criteria) this;
        }

        public Criteria andRebateRatioIsNull() {
            addCriterion("rebate_ratio is null");
            return (Criteria) this;
        }

        public Criteria andRebateRatioIsNotNull() {
            addCriterion("rebate_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andRebateRatioEqualTo(BigDecimal value) {
            addCriterion("rebate_ratio =", value, "rebateRatio");
            return (Criteria) this;
        }

        public Criteria andRebateRatioNotEqualTo(BigDecimal value) {
            addCriterion("rebate_ratio <>", value, "rebateRatio");
            return (Criteria) this;
        }

        public Criteria andRebateRatioGreaterThan(BigDecimal value) {
            addCriterion("rebate_ratio >", value, "rebateRatio");
            return (Criteria) this;
        }

        public Criteria andRebateRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rebate_ratio >=", value, "rebateRatio");
            return (Criteria) this;
        }

        public Criteria andRebateRatioLessThan(BigDecimal value) {
            addCriterion("rebate_ratio <", value, "rebateRatio");
            return (Criteria) this;
        }

        public Criteria andRebateRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rebate_ratio <=", value, "rebateRatio");
            return (Criteria) this;
        }

        public Criteria andRebateRatioIn(List<BigDecimal> values) {
            addCriterion("rebate_ratio in", values, "rebateRatio");
            return (Criteria) this;
        }

        public Criteria andRebateRatioNotIn(List<BigDecimal> values) {
            addCriterion("rebate_ratio not in", values, "rebateRatio");
            return (Criteria) this;
        }

        public Criteria andRebateRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rebate_ratio between", value1, value2, "rebateRatio");
            return (Criteria) this;
        }

        public Criteria andRebateRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rebate_ratio not between", value1, value2, "rebateRatio");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost not between", value1, value2, "cost");
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