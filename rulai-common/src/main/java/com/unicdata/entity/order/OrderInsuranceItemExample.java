package com.unicdata.entity.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderInsuranceItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderInsuranceItemExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andOrderInsuranceIdIsNull() {
            addCriterion("order_insurance_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderInsuranceIdIsNotNull() {
            addCriterion("order_insurance_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderInsuranceIdEqualTo(Integer value) {
            addCriterion("order_insurance_id =", value, "orderInsuranceId");
            return (Criteria) this;
        }

        public Criteria andOrderInsuranceIdNotEqualTo(Integer value) {
            addCriterion("order_insurance_id <>", value, "orderInsuranceId");
            return (Criteria) this;
        }

        public Criteria andOrderInsuranceIdGreaterThan(Integer value) {
            addCriterion("order_insurance_id >", value, "orderInsuranceId");
            return (Criteria) this;
        }

        public Criteria andOrderInsuranceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_insurance_id >=", value, "orderInsuranceId");
            return (Criteria) this;
        }

        public Criteria andOrderInsuranceIdLessThan(Integer value) {
            addCriterion("order_insurance_id <", value, "orderInsuranceId");
            return (Criteria) this;
        }

        public Criteria andOrderInsuranceIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_insurance_id <=", value, "orderInsuranceId");
            return (Criteria) this;
        }

        public Criteria andOrderInsuranceIdIn(List<Integer> values) {
            addCriterion("order_insurance_id in", values, "orderInsuranceId");
            return (Criteria) this;
        }

        public Criteria andOrderInsuranceIdNotIn(List<Integer> values) {
            addCriterion("order_insurance_id not in", values, "orderInsuranceId");
            return (Criteria) this;
        }

        public Criteria andOrderInsuranceIdBetween(Integer value1, Integer value2) {
            addCriterion("order_insurance_id between", value1, value2, "orderInsuranceId");
            return (Criteria) this;
        }

        public Criteria andOrderInsuranceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_insurance_id not between", value1, value2, "orderInsuranceId");
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

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andInsuredAmountIsNull() {
            addCriterion("insured_amount is null");
            return (Criteria) this;
        }

        public Criteria andInsuredAmountIsNotNull() {
            addCriterion("insured_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredAmountEqualTo(BigDecimal value) {
            addCriterion("insured_amount =", value, "insuredAmount");
            return (Criteria) this;
        }

        public Criteria andInsuredAmountNotEqualTo(BigDecimal value) {
            addCriterion("insured_amount <>", value, "insuredAmount");
            return (Criteria) this;
        }

        public Criteria andInsuredAmountGreaterThan(BigDecimal value) {
            addCriterion("insured_amount >", value, "insuredAmount");
            return (Criteria) this;
        }

        public Criteria andInsuredAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("insured_amount >=", value, "insuredAmount");
            return (Criteria) this;
        }

        public Criteria andInsuredAmountLessThan(BigDecimal value) {
            addCriterion("insured_amount <", value, "insuredAmount");
            return (Criteria) this;
        }

        public Criteria andInsuredAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("insured_amount <=", value, "insuredAmount");
            return (Criteria) this;
        }

        public Criteria andInsuredAmountIn(List<BigDecimal> values) {
            addCriterion("insured_amount in", values, "insuredAmount");
            return (Criteria) this;
        }

        public Criteria andInsuredAmountNotIn(List<BigDecimal> values) {
            addCriterion("insured_amount not in", values, "insuredAmount");
            return (Criteria) this;
        }

        public Criteria andInsuredAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("insured_amount between", value1, value2, "insuredAmount");
            return (Criteria) this;
        }

        public Criteria andInsuredAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("insured_amount not between", value1, value2, "insuredAmount");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(Date value) {
            addCriterionForJDBCDate("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(Date value) {
            addCriterionForJDBCDate("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(Date value) {
            addCriterionForJDBCDate("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(Date value) {
            addCriterionForJDBCDate("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<Date> values) {
            addCriterionForJDBCDate("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<Date> values) {
            addCriterionForJDBCDate("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deadline not between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andCarCharacterIsNull() {
            addCriterion("car_character is null");
            return (Criteria) this;
        }

        public Criteria andCarCharacterIsNotNull() {
            addCriterion("car_character is not null");
            return (Criteria) this;
        }

        public Criteria andCarCharacterEqualTo(Integer value) {
            addCriterion("car_character =", value, "carCharacter");
            return (Criteria) this;
        }

        public Criteria andCarCharacterNotEqualTo(Integer value) {
            addCriterion("car_character <>", value, "carCharacter");
            return (Criteria) this;
        }

        public Criteria andCarCharacterGreaterThan(Integer value) {
            addCriterion("car_character >", value, "carCharacter");
            return (Criteria) this;
        }

        public Criteria andCarCharacterGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_character >=", value, "carCharacter");
            return (Criteria) this;
        }

        public Criteria andCarCharacterLessThan(Integer value) {
            addCriterion("car_character <", value, "carCharacter");
            return (Criteria) this;
        }

        public Criteria andCarCharacterLessThanOrEqualTo(Integer value) {
            addCriterion("car_character <=", value, "carCharacter");
            return (Criteria) this;
        }

        public Criteria andCarCharacterIn(List<Integer> values) {
            addCriterion("car_character in", values, "carCharacter");
            return (Criteria) this;
        }

        public Criteria andCarCharacterNotIn(List<Integer> values) {
            addCriterion("car_character not in", values, "carCharacter");
            return (Criteria) this;
        }

        public Criteria andCarCharacterBetween(Integer value1, Integer value2) {
            addCriterion("car_character between", value1, value2, "carCharacter");
            return (Criteria) this;
        }

        public Criteria andCarCharacterNotBetween(Integer value1, Integer value2) {
            addCriterion("car_character not between", value1, value2, "carCharacter");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgIsNull() {
            addCriterion("insurance_img is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgIsNotNull() {
            addCriterion("insurance_img is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgEqualTo(String value) {
            addCriterion("insurance_img =", value, "insuranceImg");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgNotEqualTo(String value) {
            addCriterion("insurance_img <>", value, "insuranceImg");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgGreaterThan(String value) {
            addCriterion("insurance_img >", value, "insuranceImg");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgGreaterThanOrEqualTo(String value) {
            addCriterion("insurance_img >=", value, "insuranceImg");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgLessThan(String value) {
            addCriterion("insurance_img <", value, "insuranceImg");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgLessThanOrEqualTo(String value) {
            addCriterion("insurance_img <=", value, "insuranceImg");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgLike(String value) {
            addCriterion("insurance_img like", value, "insuranceImg");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgNotLike(String value) {
            addCriterion("insurance_img not like", value, "insuranceImg");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgIn(List<String> values) {
            addCriterion("insurance_img in", values, "insuranceImg");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgNotIn(List<String> values) {
            addCriterion("insurance_img not in", values, "insuranceImg");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgBetween(String value1, String value2) {
            addCriterion("insurance_img between", value1, value2, "insuranceImg");
            return (Criteria) this;
        }

        public Criteria andInsuranceImgNotBetween(String value1, String value2) {
            addCriterion("insurance_img not between", value1, value2, "insuranceImg");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andVehicleVesselTaxIsNull() {
            addCriterion("vehicle_vessel_tax is null");
            return (Criteria) this;
        }

        public Criteria andVehicleVesselTaxIsNotNull() {
            addCriterion("vehicle_vessel_tax is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleVesselTaxEqualTo(BigDecimal value) {
            addCriterion("vehicle_vessel_tax =", value, "vehicleVesselTax");
            return (Criteria) this;
        }

        public Criteria andVehicleVesselTaxNotEqualTo(BigDecimal value) {
            addCriterion("vehicle_vessel_tax <>", value, "vehicleVesselTax");
            return (Criteria) this;
        }

        public Criteria andVehicleVesselTaxGreaterThan(BigDecimal value) {
            addCriterion("vehicle_vessel_tax >", value, "vehicleVesselTax");
            return (Criteria) this;
        }

        public Criteria andVehicleVesselTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vehicle_vessel_tax >=", value, "vehicleVesselTax");
            return (Criteria) this;
        }

        public Criteria andVehicleVesselTaxLessThan(BigDecimal value) {
            addCriterion("vehicle_vessel_tax <", value, "vehicleVesselTax");
            return (Criteria) this;
        }

        public Criteria andVehicleVesselTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vehicle_vessel_tax <=", value, "vehicleVesselTax");
            return (Criteria) this;
        }

        public Criteria andVehicleVesselTaxIn(List<BigDecimal> values) {
            addCriterion("vehicle_vessel_tax in", values, "vehicleVesselTax");
            return (Criteria) this;
        }

        public Criteria andVehicleVesselTaxNotIn(List<BigDecimal> values) {
            addCriterion("vehicle_vessel_tax not in", values, "vehicleVesselTax");
            return (Criteria) this;
        }

        public Criteria andVehicleVesselTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vehicle_vessel_tax between", value1, value2, "vehicleVesselTax");
            return (Criteria) this;
        }

        public Criteria andVehicleVesselTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vehicle_vessel_tax not between", value1, value2, "vehicleVesselTax");
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