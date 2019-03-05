package com.unicdata.entity.policy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanExtractionRebateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlanExtractionRebateExample() {
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

        public Criteria andPlanYearIsNull() {
            addCriterion("plan_year is null");
            return (Criteria) this;
        }

        public Criteria andPlanYearIsNotNull() {
            addCriterion("plan_year is not null");
            return (Criteria) this;
        }

        public Criteria andPlanYearEqualTo(Integer value) {
            addCriterion("plan_year =", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearNotEqualTo(Integer value) {
            addCriterion("plan_year <>", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearGreaterThan(Integer value) {
            addCriterion("plan_year >", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_year >=", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearLessThan(Integer value) {
            addCriterion("plan_year <", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearLessThanOrEqualTo(Integer value) {
            addCriterion("plan_year <=", value, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearIn(List<Integer> values) {
            addCriterion("plan_year in", values, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearNotIn(List<Integer> values) {
            addCriterion("plan_year not in", values, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearBetween(Integer value1, Integer value2) {
            addCriterion("plan_year between", value1, value2, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanYearNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_year not between", value1, value2, "planYear");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateIsNull() {
            addCriterion("plan_extraction_date is null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateIsNotNull() {
            addCriterion("plan_extraction_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateEqualTo(Integer value) {
            addCriterion("plan_extraction_date =", value, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateNotEqualTo(Integer value) {
            addCriterion("plan_extraction_date <>", value, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateGreaterThan(Integer value) {
            addCriterion("plan_extraction_date >", value, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_extraction_date >=", value, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateLessThan(Integer value) {
            addCriterion("plan_extraction_date <", value, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateLessThanOrEqualTo(Integer value) {
            addCriterion("plan_extraction_date <=", value, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateIn(List<Integer> values) {
            addCriterion("plan_extraction_date in", values, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateNotIn(List<Integer> values) {
            addCriterion("plan_extraction_date not in", values, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateBetween(Integer value1, Integer value2) {
            addCriterion("plan_extraction_date between", value1, value2, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionDateNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_extraction_date not between", value1, value2, "planExtractionDate");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIdIsNull() {
            addCriterion("plan_extraction_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIdIsNotNull() {
            addCriterion("plan_extraction_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIdEqualTo(Integer value) {
            addCriterion("plan_extraction_id =", value, "planExtractionId");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIdNotEqualTo(Integer value) {
            addCriterion("plan_extraction_id <>", value, "planExtractionId");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIdGreaterThan(Integer value) {
            addCriterion("plan_extraction_id >", value, "planExtractionId");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_extraction_id >=", value, "planExtractionId");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIdLessThan(Integer value) {
            addCriterion("plan_extraction_id <", value, "planExtractionId");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIdLessThanOrEqualTo(Integer value) {
            addCriterion("plan_extraction_id <=", value, "planExtractionId");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIdIn(List<Integer> values) {
            addCriterion("plan_extraction_id in", values, "planExtractionId");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIdNotIn(List<Integer> values) {
            addCriterion("plan_extraction_id not in", values, "planExtractionId");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIdBetween(Integer value1, Integer value2) {
            addCriterion("plan_extraction_id between", value1, value2, "planExtractionId");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_extraction_id not between", value1, value2, "planExtractionId");
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

        public Criteria andRebateProjectNameIsNull() {
            addCriterion("rebate_project_name is null");
            return (Criteria) this;
        }

        public Criteria andRebateProjectNameIsNotNull() {
            addCriterion("rebate_project_name is not null");
            return (Criteria) this;
        }

        public Criteria andRebateProjectNameEqualTo(String value) {
            addCriterion("rebate_project_name =", value, "rebateProjectName");
            return (Criteria) this;
        }

        public Criteria andRebateProjectNameNotEqualTo(String value) {
            addCriterion("rebate_project_name <>", value, "rebateProjectName");
            return (Criteria) this;
        }

        public Criteria andRebateProjectNameGreaterThan(String value) {
            addCriterion("rebate_project_name >", value, "rebateProjectName");
            return (Criteria) this;
        }

        public Criteria andRebateProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("rebate_project_name >=", value, "rebateProjectName");
            return (Criteria) this;
        }

        public Criteria andRebateProjectNameLessThan(String value) {
            addCriterion("rebate_project_name <", value, "rebateProjectName");
            return (Criteria) this;
        }

        public Criteria andRebateProjectNameLessThanOrEqualTo(String value) {
            addCriterion("rebate_project_name <=", value, "rebateProjectName");
            return (Criteria) this;
        }

        public Criteria andRebateProjectNameLike(String value) {
            addCriterion("rebate_project_name like", value, "rebateProjectName");
            return (Criteria) this;
        }

        public Criteria andRebateProjectNameNotLike(String value) {
            addCriterion("rebate_project_name not like", value, "rebateProjectName");
            return (Criteria) this;
        }

        public Criteria andRebateProjectNameIn(List<String> values) {
            addCriterion("rebate_project_name in", values, "rebateProjectName");
            return (Criteria) this;
        }

        public Criteria andRebateProjectNameNotIn(List<String> values) {
            addCriterion("rebate_project_name not in", values, "rebateProjectName");
            return (Criteria) this;
        }

        public Criteria andRebateProjectNameBetween(String value1, String value2) {
            addCriterion("rebate_project_name between", value1, value2, "rebateProjectName");
            return (Criteria) this;
        }

        public Criteria andRebateProjectNameNotBetween(String value1, String value2) {
            addCriterion("rebate_project_name not between", value1, value2, "rebateProjectName");
            return (Criteria) this;
        }

        public Criteria andMonthPlanMoneyIsNull() {
            addCriterion("month_plan_money is null");
            return (Criteria) this;
        }

        public Criteria andMonthPlanMoneyIsNotNull() {
            addCriterion("month_plan_money is not null");
            return (Criteria) this;
        }

        public Criteria andMonthPlanMoneyEqualTo(BigDecimal value) {
            addCriterion("month_plan_money =", value, "monthPlanMoney");
            return (Criteria) this;
        }

        public Criteria andMonthPlanMoneyNotEqualTo(BigDecimal value) {
            addCriterion("month_plan_money <>", value, "monthPlanMoney");
            return (Criteria) this;
        }

        public Criteria andMonthPlanMoneyGreaterThan(BigDecimal value) {
            addCriterion("month_plan_money >", value, "monthPlanMoney");
            return (Criteria) this;
        }

        public Criteria andMonthPlanMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("month_plan_money >=", value, "monthPlanMoney");
            return (Criteria) this;
        }

        public Criteria andMonthPlanMoneyLessThan(BigDecimal value) {
            addCriterion("month_plan_money <", value, "monthPlanMoney");
            return (Criteria) this;
        }

        public Criteria andMonthPlanMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("month_plan_money <=", value, "monthPlanMoney");
            return (Criteria) this;
        }

        public Criteria andMonthPlanMoneyIn(List<BigDecimal> values) {
            addCriterion("month_plan_money in", values, "monthPlanMoney");
            return (Criteria) this;
        }

        public Criteria andMonthPlanMoneyNotIn(List<BigDecimal> values) {
            addCriterion("month_plan_money not in", values, "monthPlanMoney");
            return (Criteria) this;
        }

        public Criteria andMonthPlanMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_plan_money between", value1, value2, "monthPlanMoney");
            return (Criteria) this;
        }

        public Criteria andMonthPlanMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_plan_money not between", value1, value2, "monthPlanMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanMoneyIsNull() {
            addCriterion("year_plan_money is null");
            return (Criteria) this;
        }

        public Criteria andYearPlanMoneyIsNotNull() {
            addCriterion("year_plan_money is not null");
            return (Criteria) this;
        }

        public Criteria andYearPlanMoneyEqualTo(BigDecimal value) {
            addCriterion("year_plan_money =", value, "yearPlanMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanMoneyNotEqualTo(BigDecimal value) {
            addCriterion("year_plan_money <>", value, "yearPlanMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanMoneyGreaterThan(BigDecimal value) {
            addCriterion("year_plan_money >", value, "yearPlanMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("year_plan_money >=", value, "yearPlanMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanMoneyLessThan(BigDecimal value) {
            addCriterion("year_plan_money <", value, "yearPlanMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("year_plan_money <=", value, "yearPlanMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanMoneyIn(List<BigDecimal> values) {
            addCriterion("year_plan_money in", values, "yearPlanMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanMoneyNotIn(List<BigDecimal> values) {
            addCriterion("year_plan_money not in", values, "yearPlanMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("year_plan_money between", value1, value2, "yearPlanMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("year_plan_money not between", value1, value2, "yearPlanMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanAbjustMoneyIsNull() {
            addCriterion("year_plan_abjust_money is null");
            return (Criteria) this;
        }

        public Criteria andYearPlanAbjustMoneyIsNotNull() {
            addCriterion("year_plan_abjust_money is not null");
            return (Criteria) this;
        }

        public Criteria andYearPlanAbjustMoneyEqualTo(BigDecimal value) {
            addCriterion("year_plan_abjust_money =", value, "yearPlanAbjustMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanAbjustMoneyNotEqualTo(BigDecimal value) {
            addCriterion("year_plan_abjust_money <>", value, "yearPlanAbjustMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanAbjustMoneyGreaterThan(BigDecimal value) {
            addCriterion("year_plan_abjust_money >", value, "yearPlanAbjustMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanAbjustMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("year_plan_abjust_money >=", value, "yearPlanAbjustMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanAbjustMoneyLessThan(BigDecimal value) {
            addCriterion("year_plan_abjust_money <", value, "yearPlanAbjustMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanAbjustMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("year_plan_abjust_money <=", value, "yearPlanAbjustMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanAbjustMoneyIn(List<BigDecimal> values) {
            addCriterion("year_plan_abjust_money in", values, "yearPlanAbjustMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanAbjustMoneyNotIn(List<BigDecimal> values) {
            addCriterion("year_plan_abjust_money not in", values, "yearPlanAbjustMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanAbjustMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("year_plan_abjust_money between", value1, value2, "yearPlanAbjustMoney");
            return (Criteria) this;
        }

        public Criteria andYearPlanAbjustMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("year_plan_abjust_money not between", value1, value2, "yearPlanAbjustMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyIsNull() {
            addCriterion("proofreader_money is null");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyIsNotNull() {
            addCriterion("proofreader_money is not null");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyEqualTo(BigDecimal value) {
            addCriterion("proofreader_money =", value, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyNotEqualTo(BigDecimal value) {
            addCriterion("proofreader_money <>", value, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyGreaterThan(BigDecimal value) {
            addCriterion("proofreader_money >", value, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("proofreader_money >=", value, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyLessThan(BigDecimal value) {
            addCriterion("proofreader_money <", value, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("proofreader_money <=", value, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyIn(List<BigDecimal> values) {
            addCriterion("proofreader_money in", values, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyNotIn(List<BigDecimal> values) {
            addCriterion("proofreader_money not in", values, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("proofreader_money between", value1, value2, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andProofreaderMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("proofreader_money not between", value1, value2, "proofreaderMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyIsNull() {
            addCriterion("arrive_bill_money is null");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyIsNotNull() {
            addCriterion("arrive_bill_money is not null");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyEqualTo(BigDecimal value) {
            addCriterion("arrive_bill_money =", value, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyNotEqualTo(BigDecimal value) {
            addCriterion("arrive_bill_money <>", value, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyGreaterThan(BigDecimal value) {
            addCriterion("arrive_bill_money >", value, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("arrive_bill_money >=", value, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyLessThan(BigDecimal value) {
            addCriterion("arrive_bill_money <", value, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("arrive_bill_money <=", value, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyIn(List<BigDecimal> values) {
            addCriterion("arrive_bill_money in", values, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyNotIn(List<BigDecimal> values) {
            addCriterion("arrive_bill_money not in", values, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("arrive_bill_money between", value1, value2, "arriveBillMoney");
            return (Criteria) this;
        }

        public Criteria andArriveBillMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("arrive_bill_money not between", value1, value2, "arriveBillMoney");
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