package com.unicdata.entity.policy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProofreaderListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProofreaderListExample() {
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

        public Criteria andTotalDifferenceIsNull() {
            addCriterion("total_difference is null");
            return (Criteria) this;
        }

        public Criteria andTotalDifferenceIsNotNull() {
            addCriterion("total_difference is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDifferenceEqualTo(BigDecimal value) {
            addCriterion("total_difference =", value, "totalDifference");
            return (Criteria) this;
        }

        public Criteria andTotalDifferenceNotEqualTo(BigDecimal value) {
            addCriterion("total_difference <>", value, "totalDifference");
            return (Criteria) this;
        }

        public Criteria andTotalDifferenceGreaterThan(BigDecimal value) {
            addCriterion("total_difference >", value, "totalDifference");
            return (Criteria) this;
        }

        public Criteria andTotalDifferenceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_difference >=", value, "totalDifference");
            return (Criteria) this;
        }

        public Criteria andTotalDifferenceLessThan(BigDecimal value) {
            addCriterion("total_difference <", value, "totalDifference");
            return (Criteria) this;
        }

        public Criteria andTotalDifferenceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_difference <=", value, "totalDifference");
            return (Criteria) this;
        }

        public Criteria andTotalDifferenceIn(List<BigDecimal> values) {
            addCriterion("total_difference in", values, "totalDifference");
            return (Criteria) this;
        }

        public Criteria andTotalDifferenceNotIn(List<BigDecimal> values) {
            addCriterion("total_difference not in", values, "totalDifference");
            return (Criteria) this;
        }

        public Criteria andTotalDifferenceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_difference between", value1, value2, "totalDifference");
            return (Criteria) this;
        }

        public Criteria andTotalDifferenceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_difference not between", value1, value2, "totalDifference");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(BigDecimal value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andUnmatchedNumIsNull() {
            addCriterion("unmatched_num is null");
            return (Criteria) this;
        }

        public Criteria andUnmatchedNumIsNotNull() {
            addCriterion("unmatched_num is not null");
            return (Criteria) this;
        }

        public Criteria andUnmatchedNumEqualTo(Integer value) {
            addCriterion("unmatched_num =", value, "unmatchedNum");
            return (Criteria) this;
        }

        public Criteria andUnmatchedNumNotEqualTo(Integer value) {
            addCriterion("unmatched_num <>", value, "unmatchedNum");
            return (Criteria) this;
        }

        public Criteria andUnmatchedNumGreaterThan(Integer value) {
            addCriterion("unmatched_num >", value, "unmatchedNum");
            return (Criteria) this;
        }

        public Criteria andUnmatchedNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("unmatched_num >=", value, "unmatchedNum");
            return (Criteria) this;
        }

        public Criteria andUnmatchedNumLessThan(Integer value) {
            addCriterion("unmatched_num <", value, "unmatchedNum");
            return (Criteria) this;
        }

        public Criteria andUnmatchedNumLessThanOrEqualTo(Integer value) {
            addCriterion("unmatched_num <=", value, "unmatchedNum");
            return (Criteria) this;
        }

        public Criteria andUnmatchedNumIn(List<Integer> values) {
            addCriterion("unmatched_num in", values, "unmatchedNum");
            return (Criteria) this;
        }

        public Criteria andUnmatchedNumNotIn(List<Integer> values) {
            addCriterion("unmatched_num not in", values, "unmatchedNum");
            return (Criteria) this;
        }

        public Criteria andUnmatchedNumBetween(Integer value1, Integer value2) {
            addCriterion("unmatched_num between", value1, value2, "unmatchedNum");
            return (Criteria) this;
        }

        public Criteria andUnmatchedNumNotBetween(Integer value1, Integer value2) {
            addCriterion("unmatched_num not between", value1, value2, "unmatchedNum");
            return (Criteria) this;
        }

        public Criteria andUnmatchedMoneyIsNull() {
            addCriterion("unmatched_money is null");
            return (Criteria) this;
        }

        public Criteria andUnmatchedMoneyIsNotNull() {
            addCriterion("unmatched_money is not null");
            return (Criteria) this;
        }

        public Criteria andUnmatchedMoneyEqualTo(BigDecimal value) {
            addCriterion("unmatched_money =", value, "unmatchedMoney");
            return (Criteria) this;
        }

        public Criteria andUnmatchedMoneyNotEqualTo(BigDecimal value) {
            addCriterion("unmatched_money <>", value, "unmatchedMoney");
            return (Criteria) this;
        }

        public Criteria andUnmatchedMoneyGreaterThan(BigDecimal value) {
            addCriterion("unmatched_money >", value, "unmatchedMoney");
            return (Criteria) this;
        }

        public Criteria andUnmatchedMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unmatched_money >=", value, "unmatchedMoney");
            return (Criteria) this;
        }

        public Criteria andUnmatchedMoneyLessThan(BigDecimal value) {
            addCriterion("unmatched_money <", value, "unmatchedMoney");
            return (Criteria) this;
        }

        public Criteria andUnmatchedMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unmatched_money <=", value, "unmatchedMoney");
            return (Criteria) this;
        }

        public Criteria andUnmatchedMoneyIn(List<BigDecimal> values) {
            addCriterion("unmatched_money in", values, "unmatchedMoney");
            return (Criteria) this;
        }

        public Criteria andUnmatchedMoneyNotIn(List<BigDecimal> values) {
            addCriterion("unmatched_money not in", values, "unmatchedMoney");
            return (Criteria) this;
        }

        public Criteria andUnmatchedMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unmatched_money between", value1, value2, "unmatchedMoney");
            return (Criteria) this;
        }

        public Criteria andUnmatchedMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unmatched_money not between", value1, value2, "unmatchedMoney");
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