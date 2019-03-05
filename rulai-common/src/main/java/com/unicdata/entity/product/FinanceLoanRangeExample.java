package com.unicdata.entity.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FinanceLoanRangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinanceLoanRangeExample() {
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

        public Criteria andFinanceIdIsNull() {
            addCriterion("finance_id is null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIsNotNull() {
            addCriterion("finance_id is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceIdEqualTo(Integer value) {
            addCriterion("finance_id =", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotEqualTo(Integer value) {
            addCriterion("finance_id <>", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThan(Integer value) {
            addCriterion("finance_id >", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("finance_id >=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThan(Integer value) {
            addCriterion("finance_id <", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("finance_id <=", value, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdIn(List<Integer> values) {
            addCriterion("finance_id in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotIn(List<Integer> values) {
            addCriterion("finance_id not in", values, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdBetween(Integer value1, Integer value2) {
            addCriterion("finance_id between", value1, value2, "financeId");
            return (Criteria) this;
        }

        public Criteria andFinanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("finance_id not between", value1, value2, "financeId");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLowIsNull() {
            addCriterion("loan_amount_low is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLowIsNotNull() {
            addCriterion("loan_amount_low is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLowEqualTo(BigDecimal value) {
            addCriterion("loan_amount_low =", value, "loanAmountLow");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLowNotEqualTo(BigDecimal value) {
            addCriterion("loan_amount_low <>", value, "loanAmountLow");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLowGreaterThan(BigDecimal value) {
            addCriterion("loan_amount_low >", value, "loanAmountLow");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_amount_low >=", value, "loanAmountLow");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLowLessThan(BigDecimal value) {
            addCriterion("loan_amount_low <", value, "loanAmountLow");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_amount_low <=", value, "loanAmountLow");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLowIn(List<BigDecimal> values) {
            addCriterion("loan_amount_low in", values, "loanAmountLow");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLowNotIn(List<BigDecimal> values) {
            addCriterion("loan_amount_low not in", values, "loanAmountLow");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_amount_low between", value1, value2, "loanAmountLow");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_amount_low not between", value1, value2, "loanAmountLow");
            return (Criteria) this;
        }

        public Criteria andLoanAmountHignIsNull() {
            addCriterion("loan_amount_hign is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountHignIsNotNull() {
            addCriterion("loan_amount_hign is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountHignEqualTo(BigDecimal value) {
            addCriterion("loan_amount_hign =", value, "loanAmountHign");
            return (Criteria) this;
        }

        public Criteria andLoanAmountHignNotEqualTo(BigDecimal value) {
            addCriterion("loan_amount_hign <>", value, "loanAmountHign");
            return (Criteria) this;
        }

        public Criteria andLoanAmountHignGreaterThan(BigDecimal value) {
            addCriterion("loan_amount_hign >", value, "loanAmountHign");
            return (Criteria) this;
        }

        public Criteria andLoanAmountHignGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_amount_hign >=", value, "loanAmountHign");
            return (Criteria) this;
        }

        public Criteria andLoanAmountHignLessThan(BigDecimal value) {
            addCriterion("loan_amount_hign <", value, "loanAmountHign");
            return (Criteria) this;
        }

        public Criteria andLoanAmountHignLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_amount_hign <=", value, "loanAmountHign");
            return (Criteria) this;
        }

        public Criteria andLoanAmountHignIn(List<BigDecimal> values) {
            addCriterion("loan_amount_hign in", values, "loanAmountHign");
            return (Criteria) this;
        }

        public Criteria andLoanAmountHignNotIn(List<BigDecimal> values) {
            addCriterion("loan_amount_hign not in", values, "loanAmountHign");
            return (Criteria) this;
        }

        public Criteria andLoanAmountHignBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_amount_hign between", value1, value2, "loanAmountHign");
            return (Criteria) this;
        }

        public Criteria andLoanAmountHignNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_amount_hign not between", value1, value2, "loanAmountHign");
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