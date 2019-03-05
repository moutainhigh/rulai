package com.unicdata.entity.letprice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonthPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonthPlanExample() {
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

        public Criteria andPlanMonthIsNull() {
            addCriterion("plan_month is null");
            return (Criteria) this;
        }

        public Criteria andPlanMonthIsNotNull() {
            addCriterion("plan_month is not null");
            return (Criteria) this;
        }

        public Criteria andPlanMonthEqualTo(String value) {
            addCriterion("plan_month =", value, "planMonth");
            return (Criteria) this;
        }

        public Criteria andPlanMonthNotEqualTo(String value) {
            addCriterion("plan_month <>", value, "planMonth");
            return (Criteria) this;
        }

        public Criteria andPlanMonthGreaterThan(String value) {
            addCriterion("plan_month >", value, "planMonth");
            return (Criteria) this;
        }

        public Criteria andPlanMonthGreaterThanOrEqualTo(String value) {
            addCriterion("plan_month >=", value, "planMonth");
            return (Criteria) this;
        }

        public Criteria andPlanMonthLessThan(String value) {
            addCriterion("plan_month <", value, "planMonth");
            return (Criteria) this;
        }

        public Criteria andPlanMonthLessThanOrEqualTo(String value) {
            addCriterion("plan_month <=", value, "planMonth");
            return (Criteria) this;
        }

        public Criteria andPlanMonthIn(List<String> values) {
            addCriterion("plan_month in", values, "planMonth");
            return (Criteria) this;
        }

        public Criteria andPlanMonthNotIn(List<String> values) {
            addCriterion("plan_month not in", values, "planMonth");
            return (Criteria) this;
        }

        public Criteria andPlanMonthBetween(String value1, String value2) {
            addCriterion("plan_month between", value1, value2, "planMonth");
            return (Criteria) this;
        }

        public Criteria andPlanMonthNotBetween(String value1, String value2) {
            addCriterion("plan_month not between", value1, value2, "planMonth");
            return (Criteria) this;
        }

        public Criteria andGoalSalesVolumeIsNull() {
            addCriterion("goal_sales_volume is null");
            return (Criteria) this;
        }

        public Criteria andGoalSalesVolumeIsNotNull() {
            addCriterion("goal_sales_volume is not null");
            return (Criteria) this;
        }

        public Criteria andGoalSalesVolumeEqualTo(Integer value) {
            addCriterion("goal_sales_volume =", value, "goalSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGoalSalesVolumeNotEqualTo(Integer value) {
            addCriterion("goal_sales_volume <>", value, "goalSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGoalSalesVolumeGreaterThan(Integer value) {
            addCriterion("goal_sales_volume >", value, "goalSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGoalSalesVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goal_sales_volume >=", value, "goalSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGoalSalesVolumeLessThan(Integer value) {
            addCriterion("goal_sales_volume <", value, "goalSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGoalSalesVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("goal_sales_volume <=", value, "goalSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGoalSalesVolumeIn(List<Integer> values) {
            addCriterion("goal_sales_volume in", values, "goalSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGoalSalesVolumeNotIn(List<Integer> values) {
            addCriterion("goal_sales_volume not in", values, "goalSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGoalSalesVolumeBetween(Integer value1, Integer value2) {
            addCriterion("goal_sales_volume between", value1, value2, "goalSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGoalSalesVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("goal_sales_volume not between", value1, value2, "goalSalesVolume");
            return (Criteria) this;
        }

        public Criteria andGoalGrossProfitIsNull() {
            addCriterion("goal_gross_profit is null");
            return (Criteria) this;
        }

        public Criteria andGoalGrossProfitIsNotNull() {
            addCriterion("goal_gross_profit is not null");
            return (Criteria) this;
        }

        public Criteria andGoalGrossProfitEqualTo(BigDecimal value) {
            addCriterion("goal_gross_profit =", value, "goalGrossProfit");
            return (Criteria) this;
        }

        public Criteria andGoalGrossProfitNotEqualTo(BigDecimal value) {
            addCriterion("goal_gross_profit <>", value, "goalGrossProfit");
            return (Criteria) this;
        }

        public Criteria andGoalGrossProfitGreaterThan(BigDecimal value) {
            addCriterion("goal_gross_profit >", value, "goalGrossProfit");
            return (Criteria) this;
        }

        public Criteria andGoalGrossProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goal_gross_profit >=", value, "goalGrossProfit");
            return (Criteria) this;
        }

        public Criteria andGoalGrossProfitLessThan(BigDecimal value) {
            addCriterion("goal_gross_profit <", value, "goalGrossProfit");
            return (Criteria) this;
        }

        public Criteria andGoalGrossProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goal_gross_profit <=", value, "goalGrossProfit");
            return (Criteria) this;
        }

        public Criteria andGoalGrossProfitIn(List<BigDecimal> values) {
            addCriterion("goal_gross_profit in", values, "goalGrossProfit");
            return (Criteria) this;
        }

        public Criteria andGoalGrossProfitNotIn(List<BigDecimal> values) {
            addCriterion("goal_gross_profit not in", values, "goalGrossProfit");
            return (Criteria) this;
        }

        public Criteria andGoalGrossProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goal_gross_profit between", value1, value2, "goalGrossProfit");
            return (Criteria) this;
        }

        public Criteria andGoalGrossProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goal_gross_profit not between", value1, value2, "goalGrossProfit");
            return (Criteria) this;
        }

        public Criteria andPlanSalesVolumeIsNull() {
            addCriterion("plan_sales_volume is null");
            return (Criteria) this;
        }

        public Criteria andPlanSalesVolumeIsNotNull() {
            addCriterion("plan_sales_volume is not null");
            return (Criteria) this;
        }

        public Criteria andPlanSalesVolumeEqualTo(Integer value) {
            addCriterion("plan_sales_volume =", value, "planSalesVolume");
            return (Criteria) this;
        }

        public Criteria andPlanSalesVolumeNotEqualTo(Integer value) {
            addCriterion("plan_sales_volume <>", value, "planSalesVolume");
            return (Criteria) this;
        }

        public Criteria andPlanSalesVolumeGreaterThan(Integer value) {
            addCriterion("plan_sales_volume >", value, "planSalesVolume");
            return (Criteria) this;
        }

        public Criteria andPlanSalesVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_sales_volume >=", value, "planSalesVolume");
            return (Criteria) this;
        }

        public Criteria andPlanSalesVolumeLessThan(Integer value) {
            addCriterion("plan_sales_volume <", value, "planSalesVolume");
            return (Criteria) this;
        }

        public Criteria andPlanSalesVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("plan_sales_volume <=", value, "planSalesVolume");
            return (Criteria) this;
        }

        public Criteria andPlanSalesVolumeIn(List<Integer> values) {
            addCriterion("plan_sales_volume in", values, "planSalesVolume");
            return (Criteria) this;
        }

        public Criteria andPlanSalesVolumeNotIn(List<Integer> values) {
            addCriterion("plan_sales_volume not in", values, "planSalesVolume");
            return (Criteria) this;
        }

        public Criteria andPlanSalesVolumeBetween(Integer value1, Integer value2) {
            addCriterion("plan_sales_volume between", value1, value2, "planSalesVolume");
            return (Criteria) this;
        }

        public Criteria andPlanSalesVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_sales_volume not between", value1, value2, "planSalesVolume");
            return (Criteria) this;
        }

        public Criteria andPlanGrossProfitIsNull() {
            addCriterion("plan_gross_profit is null");
            return (Criteria) this;
        }

        public Criteria andPlanGrossProfitIsNotNull() {
            addCriterion("plan_gross_profit is not null");
            return (Criteria) this;
        }

        public Criteria andPlanGrossProfitEqualTo(BigDecimal value) {
            addCriterion("plan_gross_profit =", value, "planGrossProfit");
            return (Criteria) this;
        }

        public Criteria andPlanGrossProfitNotEqualTo(BigDecimal value) {
            addCriterion("plan_gross_profit <>", value, "planGrossProfit");
            return (Criteria) this;
        }

        public Criteria andPlanGrossProfitGreaterThan(BigDecimal value) {
            addCriterion("plan_gross_profit >", value, "planGrossProfit");
            return (Criteria) this;
        }

        public Criteria andPlanGrossProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_gross_profit >=", value, "planGrossProfit");
            return (Criteria) this;
        }

        public Criteria andPlanGrossProfitLessThan(BigDecimal value) {
            addCriterion("plan_gross_profit <", value, "planGrossProfit");
            return (Criteria) this;
        }

        public Criteria andPlanGrossProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_gross_profit <=", value, "planGrossProfit");
            return (Criteria) this;
        }

        public Criteria andPlanGrossProfitIn(List<BigDecimal> values) {
            addCriterion("plan_gross_profit in", values, "planGrossProfit");
            return (Criteria) this;
        }

        public Criteria andPlanGrossProfitNotIn(List<BigDecimal> values) {
            addCriterion("plan_gross_profit not in", values, "planGrossProfit");
            return (Criteria) this;
        }

        public Criteria andPlanGrossProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_gross_profit between", value1, value2, "planGrossProfit");
            return (Criteria) this;
        }

        public Criteria andPlanGrossProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_gross_profit not between", value1, value2, "planGrossProfit");
            return (Criteria) this;
        }

        public Criteria andCompleteSalesVolumeIsNull() {
            addCriterion("complete_sales_volume is null");
            return (Criteria) this;
        }

        public Criteria andCompleteSalesVolumeIsNotNull() {
            addCriterion("complete_sales_volume is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteSalesVolumeEqualTo(Integer value) {
            addCriterion("complete_sales_volume =", value, "completeSalesVolume");
            return (Criteria) this;
        }

        public Criteria andCompleteSalesVolumeNotEqualTo(Integer value) {
            addCriterion("complete_sales_volume <>", value, "completeSalesVolume");
            return (Criteria) this;
        }

        public Criteria andCompleteSalesVolumeGreaterThan(Integer value) {
            addCriterion("complete_sales_volume >", value, "completeSalesVolume");
            return (Criteria) this;
        }

        public Criteria andCompleteSalesVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("complete_sales_volume >=", value, "completeSalesVolume");
            return (Criteria) this;
        }

        public Criteria andCompleteSalesVolumeLessThan(Integer value) {
            addCriterion("complete_sales_volume <", value, "completeSalesVolume");
            return (Criteria) this;
        }

        public Criteria andCompleteSalesVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("complete_sales_volume <=", value, "completeSalesVolume");
            return (Criteria) this;
        }

        public Criteria andCompleteSalesVolumeIn(List<Integer> values) {
            addCriterion("complete_sales_volume in", values, "completeSalesVolume");
            return (Criteria) this;
        }

        public Criteria andCompleteSalesVolumeNotIn(List<Integer> values) {
            addCriterion("complete_sales_volume not in", values, "completeSalesVolume");
            return (Criteria) this;
        }

        public Criteria andCompleteSalesVolumeBetween(Integer value1, Integer value2) {
            addCriterion("complete_sales_volume between", value1, value2, "completeSalesVolume");
            return (Criteria) this;
        }

        public Criteria andCompleteSalesVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("complete_sales_volume not between", value1, value2, "completeSalesVolume");
            return (Criteria) this;
        }

        public Criteria andCompleteGrossProfitIsNull() {
            addCriterion("complete_gross_profit is null");
            return (Criteria) this;
        }

        public Criteria andCompleteGrossProfitIsNotNull() {
            addCriterion("complete_gross_profit is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteGrossProfitEqualTo(BigDecimal value) {
            addCriterion("complete_gross_profit =", value, "completeGrossProfit");
            return (Criteria) this;
        }

        public Criteria andCompleteGrossProfitNotEqualTo(BigDecimal value) {
            addCriterion("complete_gross_profit <>", value, "completeGrossProfit");
            return (Criteria) this;
        }

        public Criteria andCompleteGrossProfitGreaterThan(BigDecimal value) {
            addCriterion("complete_gross_profit >", value, "completeGrossProfit");
            return (Criteria) this;
        }

        public Criteria andCompleteGrossProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("complete_gross_profit >=", value, "completeGrossProfit");
            return (Criteria) this;
        }

        public Criteria andCompleteGrossProfitLessThan(BigDecimal value) {
            addCriterion("complete_gross_profit <", value, "completeGrossProfit");
            return (Criteria) this;
        }

        public Criteria andCompleteGrossProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("complete_gross_profit <=", value, "completeGrossProfit");
            return (Criteria) this;
        }

        public Criteria andCompleteGrossProfitIn(List<BigDecimal> values) {
            addCriterion("complete_gross_profit in", values, "completeGrossProfit");
            return (Criteria) this;
        }

        public Criteria andCompleteGrossProfitNotIn(List<BigDecimal> values) {
            addCriterion("complete_gross_profit not in", values, "completeGrossProfit");
            return (Criteria) this;
        }

        public Criteria andCompleteGrossProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("complete_gross_profit between", value1, value2, "completeGrossProfit");
            return (Criteria) this;
        }

        public Criteria andCompleteGrossProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("complete_gross_profit not between", value1, value2, "completeGrossProfit");
            return (Criteria) this;
        }

        public Criteria andDifferenceSalesVolumeIsNull() {
            addCriterion("difference_sales_volume is null");
            return (Criteria) this;
        }

        public Criteria andDifferenceSalesVolumeIsNotNull() {
            addCriterion("difference_sales_volume is not null");
            return (Criteria) this;
        }

        public Criteria andDifferenceSalesVolumeEqualTo(Integer value) {
            addCriterion("difference_sales_volume =", value, "differenceSalesVolume");
            return (Criteria) this;
        }

        public Criteria andDifferenceSalesVolumeNotEqualTo(Integer value) {
            addCriterion("difference_sales_volume <>", value, "differenceSalesVolume");
            return (Criteria) this;
        }

        public Criteria andDifferenceSalesVolumeGreaterThan(Integer value) {
            addCriterion("difference_sales_volume >", value, "differenceSalesVolume");
            return (Criteria) this;
        }

        public Criteria andDifferenceSalesVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("difference_sales_volume >=", value, "differenceSalesVolume");
            return (Criteria) this;
        }

        public Criteria andDifferenceSalesVolumeLessThan(Integer value) {
            addCriterion("difference_sales_volume <", value, "differenceSalesVolume");
            return (Criteria) this;
        }

        public Criteria andDifferenceSalesVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("difference_sales_volume <=", value, "differenceSalesVolume");
            return (Criteria) this;
        }

        public Criteria andDifferenceSalesVolumeIn(List<Integer> values) {
            addCriterion("difference_sales_volume in", values, "differenceSalesVolume");
            return (Criteria) this;
        }

        public Criteria andDifferenceSalesVolumeNotIn(List<Integer> values) {
            addCriterion("difference_sales_volume not in", values, "differenceSalesVolume");
            return (Criteria) this;
        }

        public Criteria andDifferenceSalesVolumeBetween(Integer value1, Integer value2) {
            addCriterion("difference_sales_volume between", value1, value2, "differenceSalesVolume");
            return (Criteria) this;
        }

        public Criteria andDifferenceSalesVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("difference_sales_volume not between", value1, value2, "differenceSalesVolume");
            return (Criteria) this;
        }

        public Criteria andDifferenceGrossProfitIsNull() {
            addCriterion("difference_gross_profit is null");
            return (Criteria) this;
        }

        public Criteria andDifferenceGrossProfitIsNotNull() {
            addCriterion("difference_gross_profit is not null");
            return (Criteria) this;
        }

        public Criteria andDifferenceGrossProfitEqualTo(BigDecimal value) {
            addCriterion("difference_gross_profit =", value, "differenceGrossProfit");
            return (Criteria) this;
        }

        public Criteria andDifferenceGrossProfitNotEqualTo(BigDecimal value) {
            addCriterion("difference_gross_profit <>", value, "differenceGrossProfit");
            return (Criteria) this;
        }

        public Criteria andDifferenceGrossProfitGreaterThan(BigDecimal value) {
            addCriterion("difference_gross_profit >", value, "differenceGrossProfit");
            return (Criteria) this;
        }

        public Criteria andDifferenceGrossProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("difference_gross_profit >=", value, "differenceGrossProfit");
            return (Criteria) this;
        }

        public Criteria andDifferenceGrossProfitLessThan(BigDecimal value) {
            addCriterion("difference_gross_profit <", value, "differenceGrossProfit");
            return (Criteria) this;
        }

        public Criteria andDifferenceGrossProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("difference_gross_profit <=", value, "differenceGrossProfit");
            return (Criteria) this;
        }

        public Criteria andDifferenceGrossProfitIn(List<BigDecimal> values) {
            addCriterion("difference_gross_profit in", values, "differenceGrossProfit");
            return (Criteria) this;
        }

        public Criteria andDifferenceGrossProfitNotIn(List<BigDecimal> values) {
            addCriterion("difference_gross_profit not in", values, "differenceGrossProfit");
            return (Criteria) this;
        }

        public Criteria andDifferenceGrossProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("difference_gross_profit between", value1, value2, "differenceGrossProfit");
            return (Criteria) this;
        }

        public Criteria andDifferenceGrossProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("difference_gross_profit not between", value1, value2, "differenceGrossProfit");
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