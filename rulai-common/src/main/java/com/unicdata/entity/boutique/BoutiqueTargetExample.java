package com.unicdata.entity.boutique;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoutiqueTargetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BoutiqueTargetExample() {
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

        public Criteria andEmployeeGroupIdIsNull() {
            addCriterion("employee_group_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeGroupIdIsNotNull() {
            addCriterion("employee_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeGroupIdEqualTo(Integer value) {
            addCriterion("employee_group_id =", value, "employeeGroupId");
            return (Criteria) this;
        }

        public Criteria andEmployeeGroupIdNotEqualTo(Integer value) {
            addCriterion("employee_group_id <>", value, "employeeGroupId");
            return (Criteria) this;
        }

        public Criteria andEmployeeGroupIdGreaterThan(Integer value) {
            addCriterion("employee_group_id >", value, "employeeGroupId");
            return (Criteria) this;
        }

        public Criteria andEmployeeGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_group_id >=", value, "employeeGroupId");
            return (Criteria) this;
        }

        public Criteria andEmployeeGroupIdLessThan(Integer value) {
            addCriterion("employee_group_id <", value, "employeeGroupId");
            return (Criteria) this;
        }

        public Criteria andEmployeeGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("employee_group_id <=", value, "employeeGroupId");
            return (Criteria) this;
        }

        public Criteria andEmployeeGroupIdIn(List<Integer> values) {
            addCriterion("employee_group_id in", values, "employeeGroupId");
            return (Criteria) this;
        }

        public Criteria andEmployeeGroupIdNotIn(List<Integer> values) {
            addCriterion("employee_group_id not in", values, "employeeGroupId");
            return (Criteria) this;
        }

        public Criteria andEmployeeGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("employee_group_id between", value1, value2, "employeeGroupId");
            return (Criteria) this;
        }

        public Criteria andEmployeeGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_group_id not between", value1, value2, "employeeGroupId");
            return (Criteria) this;
        }

        public Criteria andProjectIsNull() {
            addCriterion("project is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsNotNull() {
            addCriterion("project is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEqualTo(String value) {
            addCriterion("project =", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotEqualTo(String value) {
            addCriterion("project <>", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThan(String value) {
            addCriterion("project >", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThanOrEqualTo(String value) {
            addCriterion("project >=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThan(String value) {
            addCriterion("project <", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThanOrEqualTo(String value) {
            addCriterion("project <=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLike(String value) {
            addCriterion("project like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotLike(String value) {
            addCriterion("project not like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectIn(List<String> values) {
            addCriterion("project in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotIn(List<String> values) {
            addCriterion("project not in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectBetween(String value1, String value2) {
            addCriterion("project between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotBetween(String value1, String value2) {
            addCriterion("project not between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andIncomePlayIsNull() {
            addCriterion("income_play is null");
            return (Criteria) this;
        }

        public Criteria andIncomePlayIsNotNull() {
            addCriterion("income_play is not null");
            return (Criteria) this;
        }

        public Criteria andIncomePlayEqualTo(BigDecimal value) {
            addCriterion("income_play =", value, "incomePlay");
            return (Criteria) this;
        }

        public Criteria andIncomePlayNotEqualTo(BigDecimal value) {
            addCriterion("income_play <>", value, "incomePlay");
            return (Criteria) this;
        }

        public Criteria andIncomePlayGreaterThan(BigDecimal value) {
            addCriterion("income_play >", value, "incomePlay");
            return (Criteria) this;
        }

        public Criteria andIncomePlayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income_play >=", value, "incomePlay");
            return (Criteria) this;
        }

        public Criteria andIncomePlayLessThan(BigDecimal value) {
            addCriterion("income_play <", value, "incomePlay");
            return (Criteria) this;
        }

        public Criteria andIncomePlayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income_play <=", value, "incomePlay");
            return (Criteria) this;
        }

        public Criteria andIncomePlayIn(List<BigDecimal> values) {
            addCriterion("income_play in", values, "incomePlay");
            return (Criteria) this;
        }

        public Criteria andIncomePlayNotIn(List<BigDecimal> values) {
            addCriterion("income_play not in", values, "incomePlay");
            return (Criteria) this;
        }

        public Criteria andIncomePlayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_play between", value1, value2, "incomePlay");
            return (Criteria) this;
        }

        public Criteria andIncomePlayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_play not between", value1, value2, "incomePlay");
            return (Criteria) this;
        }

        public Criteria andProfitPlayIsNull() {
            addCriterion("profit_play is null");
            return (Criteria) this;
        }

        public Criteria andProfitPlayIsNotNull() {
            addCriterion("profit_play is not null");
            return (Criteria) this;
        }

        public Criteria andProfitPlayEqualTo(BigDecimal value) {
            addCriterion("profit_play =", value, "profitPlay");
            return (Criteria) this;
        }

        public Criteria andProfitPlayNotEqualTo(BigDecimal value) {
            addCriterion("profit_play <>", value, "profitPlay");
            return (Criteria) this;
        }

        public Criteria andProfitPlayGreaterThan(BigDecimal value) {
            addCriterion("profit_play >", value, "profitPlay");
            return (Criteria) this;
        }

        public Criteria andProfitPlayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("profit_play >=", value, "profitPlay");
            return (Criteria) this;
        }

        public Criteria andProfitPlayLessThan(BigDecimal value) {
            addCriterion("profit_play <", value, "profitPlay");
            return (Criteria) this;
        }

        public Criteria andProfitPlayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("profit_play <=", value, "profitPlay");
            return (Criteria) this;
        }

        public Criteria andProfitPlayIn(List<BigDecimal> values) {
            addCriterion("profit_play in", values, "profitPlay");
            return (Criteria) this;
        }

        public Criteria andProfitPlayNotIn(List<BigDecimal> values) {
            addCriterion("profit_play not in", values, "profitPlay");
            return (Criteria) this;
        }

        public Criteria andProfitPlayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("profit_play between", value1, value2, "profitPlay");
            return (Criteria) this;
        }

        public Criteria andProfitPlayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("profit_play not between", value1, value2, "profitPlay");
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

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
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