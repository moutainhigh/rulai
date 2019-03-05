package com.unicdata.entity.carInfo;

import java.util.ArrayList;
import java.util.List;

public class UnicdataVehicleConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UnicdataVehicleConfigExample() {
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

        public Criteria andRowNamesIsNull() {
            addCriterion("row_names is null");
            return (Criteria) this;
        }

        public Criteria andRowNamesIsNotNull() {
            addCriterion("row_names is not null");
            return (Criteria) this;
        }

        public Criteria andRowNamesEqualTo(Integer value) {
            addCriterion("row_names =", value, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesNotEqualTo(Integer value) {
            addCriterion("row_names <>", value, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesGreaterThan(Integer value) {
            addCriterion("row_names >", value, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesGreaterThanOrEqualTo(Integer value) {
            addCriterion("row_names >=", value, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesLessThan(Integer value) {
            addCriterion("row_names <", value, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesLessThanOrEqualTo(Integer value) {
            addCriterion("row_names <=", value, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesIn(List<Integer> values) {
            addCriterion("row_names in", values, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesNotIn(List<Integer> values) {
            addCriterion("row_names not in", values, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesBetween(Integer value1, Integer value2) {
            addCriterion("row_names between", value1, value2, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesNotBetween(Integer value1, Integer value2) {
            addCriterion("row_names not between", value1, value2, "rowNames");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyIsNull() {
            addCriterion("unicdatakey is null");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyIsNotNull() {
            addCriterion("unicdatakey is not null");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyEqualTo(String value) {
            addCriterion("unicdatakey =", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyNotEqualTo(String value) {
            addCriterion("unicdatakey <>", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyGreaterThan(String value) {
            addCriterion("unicdatakey >", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyGreaterThanOrEqualTo(String value) {
            addCriterion("unicdatakey >=", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyLessThan(String value) {
            addCriterion("unicdatakey <", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyLessThanOrEqualTo(String value) {
            addCriterion("unicdatakey <=", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyLike(String value) {
            addCriterion("unicdatakey like", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyNotLike(String value) {
            addCriterion("unicdatakey not like", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyIn(List<String> values) {
            addCriterion("unicdatakey in", values, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyNotIn(List<String> values) {
            addCriterion("unicdatakey not in", values, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyBetween(String value1, String value2) {
            addCriterion("unicdatakey between", value1, value2, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyNotBetween(String value1, String value2) {
            addCriterion("unicdatakey not between", value1, value2, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("value not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andNameIdIsNull() {
            addCriterion("name_id is null");
            return (Criteria) this;
        }

        public Criteria andNameIdIsNotNull() {
            addCriterion("name_id is not null");
            return (Criteria) this;
        }

        public Criteria andNameIdEqualTo(Long value) {
            addCriterion("name_id =", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdNotEqualTo(Long value) {
            addCriterion("name_id <>", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdGreaterThan(Long value) {
            addCriterion("name_id >", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdGreaterThanOrEqualTo(Long value) {
            addCriterion("name_id >=", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdLessThan(Long value) {
            addCriterion("name_id <", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdLessThanOrEqualTo(Long value) {
            addCriterion("name_id <=", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdIn(List<Long> values) {
            addCriterion("name_id in", values, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdNotIn(List<Long> values) {
            addCriterion("name_id not in", values, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdBetween(Long value1, Long value2) {
            addCriterion("name_id between", value1, value2, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdNotBetween(Long value1, Long value2) {
            addCriterion("name_id not between", value1, value2, "nameId");
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