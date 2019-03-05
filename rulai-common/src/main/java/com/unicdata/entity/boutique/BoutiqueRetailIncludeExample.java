package com.unicdata.entity.boutique;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BoutiqueRetailIncludeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BoutiqueRetailIncludeExample() {
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

        public Criteria andRetailIdIsNull() {
            addCriterion("retail_id is null");
            return (Criteria) this;
        }

        public Criteria andRetailIdIsNotNull() {
            addCriterion("retail_id is not null");
            return (Criteria) this;
        }

        public Criteria andRetailIdEqualTo(Integer value) {
            addCriterion("retail_id =", value, "retailId");
            return (Criteria) this;
        }

        public Criteria andRetailIdNotEqualTo(Integer value) {
            addCriterion("retail_id <>", value, "retailId");
            return (Criteria) this;
        }

        public Criteria andRetailIdGreaterThan(Integer value) {
            addCriterion("retail_id >", value, "retailId");
            return (Criteria) this;
        }

        public Criteria andRetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("retail_id >=", value, "retailId");
            return (Criteria) this;
        }

        public Criteria andRetailIdLessThan(Integer value) {
            addCriterion("retail_id <", value, "retailId");
            return (Criteria) this;
        }

        public Criteria andRetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("retail_id <=", value, "retailId");
            return (Criteria) this;
        }

        public Criteria andRetailIdIn(List<Integer> values) {
            addCriterion("retail_id in", values, "retailId");
            return (Criteria) this;
        }

        public Criteria andRetailIdNotIn(List<Integer> values) {
            addCriterion("retail_id not in", values, "retailId");
            return (Criteria) this;
        }

        public Criteria andRetailIdBetween(Integer value1, Integer value2) {
            addCriterion("retail_id between", value1, value2, "retailId");
            return (Criteria) this;
        }

        public Criteria andRetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("retail_id not between", value1, value2, "retailId");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackIdIsNull() {
            addCriterion("information_or_pack_id is null");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackIdIsNotNull() {
            addCriterion("information_or_pack_id is not null");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackIdEqualTo(Integer value) {
            addCriterion("information_or_pack_id =", value, "informationOrPackId");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackIdNotEqualTo(Integer value) {
            addCriterion("information_or_pack_id <>", value, "informationOrPackId");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackIdGreaterThan(Integer value) {
            addCriterion("information_or_pack_id >", value, "informationOrPackId");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("information_or_pack_id >=", value, "informationOrPackId");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackIdLessThan(Integer value) {
            addCriterion("information_or_pack_id <", value, "informationOrPackId");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackIdLessThanOrEqualTo(Integer value) {
            addCriterion("information_or_pack_id <=", value, "informationOrPackId");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackIdIn(List<Integer> values) {
            addCriterion("information_or_pack_id in", values, "informationOrPackId");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackIdNotIn(List<Integer> values) {
            addCriterion("information_or_pack_id not in", values, "informationOrPackId");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackIdBetween(Integer value1, Integer value2) {
            addCriterion("information_or_pack_id between", value1, value2, "informationOrPackId");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackIdNotBetween(Integer value1, Integer value2) {
            addCriterion("information_or_pack_id not between", value1, value2, "informationOrPackId");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackNumIsNull() {
            addCriterion("information_or_pack_num is null");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackNumIsNotNull() {
            addCriterion("information_or_pack_num is not null");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackNumEqualTo(Integer value) {
            addCriterion("information_or_pack_num =", value, "informationOrPackNum");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackNumNotEqualTo(Integer value) {
            addCriterion("information_or_pack_num <>", value, "informationOrPackNum");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackNumGreaterThan(Integer value) {
            addCriterion("information_or_pack_num >", value, "informationOrPackNum");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("information_or_pack_num >=", value, "informationOrPackNum");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackNumLessThan(Integer value) {
            addCriterion("information_or_pack_num <", value, "informationOrPackNum");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackNumLessThanOrEqualTo(Integer value) {
            addCriterion("information_or_pack_num <=", value, "informationOrPackNum");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackNumIn(List<Integer> values) {
            addCriterion("information_or_pack_num in", values, "informationOrPackNum");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackNumNotIn(List<Integer> values) {
            addCriterion("information_or_pack_num not in", values, "informationOrPackNum");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackNumBetween(Integer value1, Integer value2) {
            addCriterion("information_or_pack_num between", value1, value2, "informationOrPackNum");
            return (Criteria) this;
        }

        public Criteria andInformationOrPackNumNotBetween(Integer value1, Integer value2) {
            addCriterion("information_or_pack_num not between", value1, value2, "informationOrPackNum");
            return (Criteria) this;
        }

        public Criteria andSaleValueIsNull() {
            addCriterion("sale_value is null");
            return (Criteria) this;
        }

        public Criteria andSaleValueIsNotNull() {
            addCriterion("sale_value is not null");
            return (Criteria) this;
        }

        public Criteria andSaleValueEqualTo(BigDecimal value) {
            addCriterion("sale_value =", value, "saleValue");
            return (Criteria) this;
        }

        public Criteria andSaleValueNotEqualTo(BigDecimal value) {
            addCriterion("sale_value <>", value, "saleValue");
            return (Criteria) this;
        }

        public Criteria andSaleValueGreaterThan(BigDecimal value) {
            addCriterion("sale_value >", value, "saleValue");
            return (Criteria) this;
        }

        public Criteria andSaleValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_value >=", value, "saleValue");
            return (Criteria) this;
        }

        public Criteria andSaleValueLessThan(BigDecimal value) {
            addCriterion("sale_value <", value, "saleValue");
            return (Criteria) this;
        }

        public Criteria andSaleValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_value <=", value, "saleValue");
            return (Criteria) this;
        }

        public Criteria andSaleValueIn(List<BigDecimal> values) {
            addCriterion("sale_value in", values, "saleValue");
            return (Criteria) this;
        }

        public Criteria andSaleValueNotIn(List<BigDecimal> values) {
            addCriterion("sale_value not in", values, "saleValue");
            return (Criteria) this;
        }

        public Criteria andSaleValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_value between", value1, value2, "saleValue");
            return (Criteria) this;
        }

        public Criteria andSaleValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_value not between", value1, value2, "saleValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueIsNull() {
            addCriterion("apply_value is null");
            return (Criteria) this;
        }

        public Criteria andApplyValueIsNotNull() {
            addCriterion("apply_value is not null");
            return (Criteria) this;
        }

        public Criteria andApplyValueEqualTo(BigDecimal value) {
            addCriterion("apply_value =", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueNotEqualTo(BigDecimal value) {
            addCriterion("apply_value <>", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueGreaterThan(BigDecimal value) {
            addCriterion("apply_value >", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_value >=", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueLessThan(BigDecimal value) {
            addCriterion("apply_value <", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("apply_value <=", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueIn(List<BigDecimal> values) {
            addCriterion("apply_value in", values, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueNotIn(List<BigDecimal> values) {
            addCriterion("apply_value not in", values, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_value between", value1, value2, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("apply_value not between", value1, value2, "applyValue");
            return (Criteria) this;
        }

        public Criteria andIsPackageIsNull() {
            addCriterion("is_package is null");
            return (Criteria) this;
        }

        public Criteria andIsPackageIsNotNull() {
            addCriterion("is_package is not null");
            return (Criteria) this;
        }

        public Criteria andIsPackageEqualTo(Integer value) {
            addCriterion("is_package =", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageNotEqualTo(Integer value) {
            addCriterion("is_package <>", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageGreaterThan(Integer value) {
            addCriterion("is_package >", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_package >=", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageLessThan(Integer value) {
            addCriterion("is_package <", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageLessThanOrEqualTo(Integer value) {
            addCriterion("is_package <=", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageIn(List<Integer> values) {
            addCriterion("is_package in", values, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageNotIn(List<Integer> values) {
            addCriterion("is_package not in", values, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageBetween(Integer value1, Integer value2) {
            addCriterion("is_package between", value1, value2, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageNotBetween(Integer value1, Integer value2) {
            addCriterion("is_package not between", value1, value2, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsGiftEqualTo(Integer value) {
            addCriterion("is_gift =", value, "isGift");
            return (Criteria) this;
        }
        
        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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