package com.unicdata.entity.letprice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonthPlanDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonthPlanDetailExample() {
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

        public Criteria andMonthPlanIdIsNull() {
            addCriterion("month_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andMonthPlanIdIsNotNull() {
            addCriterion("month_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andMonthPlanIdEqualTo(Integer value) {
            addCriterion("month_plan_id =", value, "monthPlanId");
            return (Criteria) this;
        }

        public Criteria andMonthPlanIdNotEqualTo(Integer value) {
            addCriterion("month_plan_id <>", value, "monthPlanId");
            return (Criteria) this;
        }

        public Criteria andMonthPlanIdGreaterThan(Integer value) {
            addCriterion("month_plan_id >", value, "monthPlanId");
            return (Criteria) this;
        }

        public Criteria andMonthPlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("month_plan_id >=", value, "monthPlanId");
            return (Criteria) this;
        }

        public Criteria andMonthPlanIdLessThan(Integer value) {
            addCriterion("month_plan_id <", value, "monthPlanId");
            return (Criteria) this;
        }

        public Criteria andMonthPlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("month_plan_id <=", value, "monthPlanId");
            return (Criteria) this;
        }

        public Criteria andMonthPlanIdIn(List<Integer> values) {
            addCriterion("month_plan_id in", values, "monthPlanId");
            return (Criteria) this;
        }

        public Criteria andMonthPlanIdNotIn(List<Integer> values) {
            addCriterion("month_plan_id not in", values, "monthPlanId");
            return (Criteria) this;
        }

        public Criteria andMonthPlanIdBetween(Integer value1, Integer value2) {
            addCriterion("month_plan_id between", value1, value2, "monthPlanId");
            return (Criteria) this;
        }

        public Criteria andMonthPlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("month_plan_id not between", value1, value2, "monthPlanId");
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

        public Criteria andLevelOneIsNull() {
            addCriterion("level_one is null");
            return (Criteria) this;
        }

        public Criteria andLevelOneIsNotNull() {
            addCriterion("level_one is not null");
            return (Criteria) this;
        }

        public Criteria andLevelOneEqualTo(BigDecimal value) {
            addCriterion("level_one =", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneNotEqualTo(BigDecimal value) {
            addCriterion("level_one <>", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneGreaterThan(BigDecimal value) {
            addCriterion("level_one >", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("level_one >=", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneLessThan(BigDecimal value) {
            addCriterion("level_one <", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneLessThanOrEqualTo(BigDecimal value) {
            addCriterion("level_one <=", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneIn(List<BigDecimal> values) {
            addCriterion("level_one in", values, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneNotIn(List<BigDecimal> values) {
            addCriterion("level_one not in", values, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_one between", value1, value2, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_one not between", value1, value2, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsNull() {
            addCriterion("level_two is null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsNotNull() {
            addCriterion("level_two is not null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoEqualTo(BigDecimal value) {
            addCriterion("level_two =", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoNotEqualTo(BigDecimal value) {
            addCriterion("level_two <>", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoGreaterThan(BigDecimal value) {
            addCriterion("level_two >", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("level_two >=", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoLessThan(BigDecimal value) {
            addCriterion("level_two <", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("level_two <=", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIn(List<BigDecimal> values) {
            addCriterion("level_two in", values, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoNotIn(List<BigDecimal> values) {
            addCriterion("level_two not in", values, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_two between", value1, value2, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_two not between", value1, value2, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelThreeIsNull() {
            addCriterion("level_three is null");
            return (Criteria) this;
        }

        public Criteria andLevelThreeIsNotNull() {
            addCriterion("level_three is not null");
            return (Criteria) this;
        }

        public Criteria andLevelThreeEqualTo(BigDecimal value) {
            addCriterion("level_three =", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeNotEqualTo(BigDecimal value) {
            addCriterion("level_three <>", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeGreaterThan(BigDecimal value) {
            addCriterion("level_three >", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("level_three >=", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeLessThan(BigDecimal value) {
            addCriterion("level_three <", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("level_three <=", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeIn(List<BigDecimal> values) {
            addCriterion("level_three in", values, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeNotIn(List<BigDecimal> values) {
            addCriterion("level_three not in", values, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_three between", value1, value2, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_three not between", value1, value2, "levelThree");
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