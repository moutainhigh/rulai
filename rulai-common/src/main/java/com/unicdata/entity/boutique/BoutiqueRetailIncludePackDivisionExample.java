package com.unicdata.entity.boutique;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoutiqueRetailIncludePackDivisionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BoutiqueRetailIncludePackDivisionExample() {
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

        public Criteria andRetialIncludeIdIsNull() {
            addCriterion("retial_include_id is null");
            return (Criteria) this;
        }

        public Criteria andRetialIncludeIdIsNotNull() {
            addCriterion("retial_include_id is not null");
            return (Criteria) this;
        }

        public Criteria andRetialIncludeIdEqualTo(Integer value) {
            addCriterion("retial_include_id =", value, "retialIncludeId");
            return (Criteria) this;
        }

        public Criteria andRetialIncludeIdNotEqualTo(Integer value) {
            addCriterion("retial_include_id <>", value, "retialIncludeId");
            return (Criteria) this;
        }

        public Criteria andRetialIncludeIdGreaterThan(Integer value) {
            addCriterion("retial_include_id >", value, "retialIncludeId");
            return (Criteria) this;
        }

        public Criteria andRetialIncludeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("retial_include_id >=", value, "retialIncludeId");
            return (Criteria) this;
        }

        public Criteria andRetialIncludeIdLessThan(Integer value) {
            addCriterion("retial_include_id <", value, "retialIncludeId");
            return (Criteria) this;
        }

        public Criteria andRetialIncludeIdLessThanOrEqualTo(Integer value) {
            addCriterion("retial_include_id <=", value, "retialIncludeId");
            return (Criteria) this;
        }

        public Criteria andRetialIncludeIdIn(List<Integer> values) {
            addCriterion("retial_include_id in", values, "retialIncludeId");
            return (Criteria) this;
        }

        public Criteria andRetialIncludeIdNotIn(List<Integer> values) {
            addCriterion("retial_include_id not in", values, "retialIncludeId");
            return (Criteria) this;
        }

        public Criteria andRetialIncludeIdBetween(Integer value1, Integer value2) {
            addCriterion("retial_include_id between", value1, value2, "retialIncludeId");
            return (Criteria) this;
        }

        public Criteria andRetialIncludeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("retial_include_id not between", value1, value2, "retialIncludeId");
            return (Criteria) this;
        }

        public Criteria andPackIdIsNull() {
            addCriterion("pack_id is null");
            return (Criteria) this;
        }

        public Criteria andPackIdIsNotNull() {
            addCriterion("pack_id is not null");
            return (Criteria) this;
        }

        public Criteria andPackIdEqualTo(Integer value) {
            addCriterion("pack_id =", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdNotEqualTo(Integer value) {
            addCriterion("pack_id <>", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdGreaterThan(Integer value) {
            addCriterion("pack_id >", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pack_id >=", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdLessThan(Integer value) {
            addCriterion("pack_id <", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdLessThanOrEqualTo(Integer value) {
            addCriterion("pack_id <=", value, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdIn(List<Integer> values) {
            addCriterion("pack_id in", values, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdNotIn(List<Integer> values) {
            addCriterion("pack_id not in", values, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdBetween(Integer value1, Integer value2) {
            addCriterion("pack_id between", value1, value2, "packId");
            return (Criteria) this;
        }

        public Criteria andPackIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pack_id not between", value1, value2, "packId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdIsNull() {
            addCriterion("boutique_id is null");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdIsNotNull() {
            addCriterion("boutique_id is not null");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdEqualTo(Integer value) {
            addCriterion("boutique_id =", value, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdNotEqualTo(Integer value) {
            addCriterion("boutique_id <>", value, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdGreaterThan(Integer value) {
            addCriterion("boutique_id >", value, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("boutique_id >=", value, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdLessThan(Integer value) {
            addCriterion("boutique_id <", value, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdLessThanOrEqualTo(Integer value) {
            addCriterion("boutique_id <=", value, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdIn(List<Integer> values) {
            addCriterion("boutique_id in", values, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdNotIn(List<Integer> values) {
            addCriterion("boutique_id not in", values, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdBetween(Integer value1, Integer value2) {
            addCriterion("boutique_id between", value1, value2, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdNotBetween(Integer value1, Integer value2) {
            addCriterion("boutique_id not between", value1, value2, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andDivisionValueIsNull() {
            addCriterion("division_value is null");
            return (Criteria) this;
        }

        public Criteria andDivisionValueIsNotNull() {
            addCriterion("division_value is not null");
            return (Criteria) this;
        }

        public Criteria andDivisionValueEqualTo(BigDecimal value) {
            addCriterion("division_value =", value, "divisionValue");
            return (Criteria) this;
        }

        public Criteria andDivisionValueNotEqualTo(BigDecimal value) {
            addCriterion("division_value <>", value, "divisionValue");
            return (Criteria) this;
        }

        public Criteria andDivisionValueGreaterThan(BigDecimal value) {
            addCriterion("division_value >", value, "divisionValue");
            return (Criteria) this;
        }

        public Criteria andDivisionValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("division_value >=", value, "divisionValue");
            return (Criteria) this;
        }

        public Criteria andDivisionValueLessThan(BigDecimal value) {
            addCriterion("division_value <", value, "divisionValue");
            return (Criteria) this;
        }

        public Criteria andDivisionValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("division_value <=", value, "divisionValue");
            return (Criteria) this;
        }

        public Criteria andDivisionValueIn(List<BigDecimal> values) {
            addCriterion("division_value in", values, "divisionValue");
            return (Criteria) this;
        }

        public Criteria andDivisionValueNotIn(List<BigDecimal> values) {
            addCriterion("division_value not in", values, "divisionValue");
            return (Criteria) this;
        }

        public Criteria andDivisionValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("division_value between", value1, value2, "divisionValue");
            return (Criteria) this;
        }

        public Criteria andDivisionValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("division_value not between", value1, value2, "divisionValue");
            return (Criteria) this;
        }

        public Criteria andTypeLiveIsNull() {
            addCriterion("type_live is null");
            return (Criteria) this;
        }

        public Criteria andTypeLiveIsNotNull() {
            addCriterion("type_live is not null");
            return (Criteria) this;
        }

        public Criteria andTypeLiveEqualTo(Byte value) {
            addCriterion("type_live =", value, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveNotEqualTo(Byte value) {
            addCriterion("type_live <>", value, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveGreaterThan(Byte value) {
            addCriterion("type_live >", value, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveGreaterThanOrEqualTo(Byte value) {
            addCriterion("type_live >=", value, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveLessThan(Byte value) {
            addCriterion("type_live <", value, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveLessThanOrEqualTo(Byte value) {
            addCriterion("type_live <=", value, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveIn(List<Byte> values) {
            addCriterion("type_live in", values, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveNotIn(List<Byte> values) {
            addCriterion("type_live not in", values, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveBetween(Byte value1, Byte value2) {
            addCriterion("type_live between", value1, value2, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveNotBetween(Byte value1, Byte value2) {
            addCriterion("type_live not between", value1, value2, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNull() {
            addCriterion("timestamp is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(Date value) {
            addCriterion("timestamp =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(Date value) {
            addCriterion("timestamp <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(Date value) {
            addCriterion("timestamp >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("timestamp >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(Date value) {
            addCriterion("timestamp <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(Date value) {
            addCriterion("timestamp <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<Date> values) {
            addCriterion("timestamp in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<Date> values) {
            addCriterion("timestamp not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(Date value1, Date value2) {
            addCriterion("timestamp between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(Date value1, Date value2) {
            addCriterion("timestamp not between", value1, value2, "timestamp");
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