package com.unicdata.entity.counter;

import java.util.ArrayList;
import java.util.List;

public class CounterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CounterExample() {
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

        public Criteria andCodePrefixIsNull() {
            addCriterion("code_prefix is null");
            return (Criteria) this;
        }

        public Criteria andCodePrefixIsNotNull() {
            addCriterion("code_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andCodePrefixEqualTo(String value) {
            addCriterion("code_prefix =", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixNotEqualTo(String value) {
            addCriterion("code_prefix <>", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixGreaterThan(String value) {
            addCriterion("code_prefix >", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixGreaterThanOrEqualTo(String value) {
            addCriterion("code_prefix >=", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixLessThan(String value) {
            addCriterion("code_prefix <", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixLessThanOrEqualTo(String value) {
            addCriterion("code_prefix <=", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixLike(String value) {
            addCriterion("code_prefix like", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixNotLike(String value) {
            addCriterion("code_prefix not like", value, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixIn(List<String> values) {
            addCriterion("code_prefix in", values, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixNotIn(List<String> values) {
            addCriterion("code_prefix not in", values, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixBetween(String value1, String value2) {
            addCriterion("code_prefix between", value1, value2, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCodePrefixNotBetween(String value1, String value2) {
            addCriterion("code_prefix not between", value1, value2, "codePrefix");
            return (Criteria) this;
        }

        public Criteria andCounterIsNull() {
            addCriterion("counter is null");
            return (Criteria) this;
        }

        public Criteria andCounterIsNotNull() {
            addCriterion("counter is not null");
            return (Criteria) this;
        }

        public Criteria andCounterEqualTo(Integer value) {
            addCriterion("counter =", value, "counter");
            return (Criteria) this;
        }

        public Criteria andCounterNotEqualTo(Integer value) {
            addCriterion("counter <>", value, "counter");
            return (Criteria) this;
        }

        public Criteria andCounterGreaterThan(Integer value) {
            addCriterion("counter >", value, "counter");
            return (Criteria) this;
        }

        public Criteria andCounterGreaterThanOrEqualTo(Integer value) {
            addCriterion("counter >=", value, "counter");
            return (Criteria) this;
        }

        public Criteria andCounterLessThan(Integer value) {
            addCriterion("counter <", value, "counter");
            return (Criteria) this;
        }

        public Criteria andCounterLessThanOrEqualTo(Integer value) {
            addCriterion("counter <=", value, "counter");
            return (Criteria) this;
        }

        public Criteria andCounterIn(List<Integer> values) {
            addCriterion("counter in", values, "counter");
            return (Criteria) this;
        }

        public Criteria andCounterNotIn(List<Integer> values) {
            addCriterion("counter not in", values, "counter");
            return (Criteria) this;
        }

        public Criteria andCounterBetween(Integer value1, Integer value2) {
            addCriterion("counter between", value1, value2, "counter");
            return (Criteria) this;
        }

        public Criteria andCounterNotBetween(Integer value1, Integer value2) {
            addCriterion("counter not between", value1, value2, "counter");
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