package com.unicdata.entity.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderInsuranceExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderInsuranceExample() {
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

		public Criteria andOrderIdIsNull() {
			addCriterion("order_id is null");
			return (Criteria) this;
		}

		public Criteria andOrderIdIsNotNull() {
			addCriterion("order_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrderIdEqualTo(Integer value) {
			addCriterion("order_id =", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotEqualTo(Integer value) {
			addCriterion("order_id <>", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThan(Integer value) {
			addCriterion("order_id >", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_id >=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThan(Integer value) {
			addCriterion("order_id <", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
			addCriterion("order_id <=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdIn(List<Integer> values) {
			addCriterion("order_id in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotIn(List<Integer> values) {
			addCriterion("order_id not in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdBetween(Integer value1, Integer value2) {
			addCriterion("order_id between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
			addCriterion("order_id not between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andInsuranceCompanyIdIsNull() {
			addCriterion("insurance_company_id is null");
			return (Criteria) this;
		}

		public Criteria andInsuranceCompanyIdIsNotNull() {
			addCriterion("insurance_company_id is not null");
			return (Criteria) this;
		}

		public Criteria andInsuranceCompanyIdEqualTo(Integer value) {
			addCriterion("insurance_company_id =", value, "insuranceCompanyId");
			return (Criteria) this;
		}

		public Criteria andInsuranceCompanyIdNotEqualTo(Integer value) {
			addCriterion("insurance_company_id <>", value, "insuranceCompanyId");
			return (Criteria) this;
		}

		public Criteria andInsuranceCompanyIdGreaterThan(Integer value) {
			addCriterion("insurance_company_id >", value, "insuranceCompanyId");
			return (Criteria) this;
		}

		public Criteria andInsuranceCompanyIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("insurance_company_id >=", value, "insuranceCompanyId");
			return (Criteria) this;
		}

		public Criteria andInsuranceCompanyIdLessThan(Integer value) {
			addCriterion("insurance_company_id <", value, "insuranceCompanyId");
			return (Criteria) this;
		}

		public Criteria andInsuranceCompanyIdLessThanOrEqualTo(Integer value) {
			addCriterion("insurance_company_id <=", value, "insuranceCompanyId");
			return (Criteria) this;
		}

		public Criteria andInsuranceCompanyIdIn(List<Integer> values) {
			addCriterion("insurance_company_id in", values, "insuranceCompanyId");
			return (Criteria) this;
		}

		public Criteria andInsuranceCompanyIdNotIn(List<Integer> values) {
			addCriterion("insurance_company_id not in", values, "insuranceCompanyId");
			return (Criteria) this;
		}

		public Criteria andInsuranceCompanyIdBetween(Integer value1, Integer value2) {
			addCriterion("insurance_company_id between", value1, value2, "insuranceCompanyId");
			return (Criteria) this;
		}

		public Criteria andInsuranceCompanyIdNotBetween(Integer value1, Integer value2) {
			addCriterion("insurance_company_id not between", value1, value2, "insuranceCompanyId");
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

		public Criteria andSumMoneyIsNull() {
			addCriterion("sum_money is null");
			return (Criteria) this;
		}

		public Criteria andSumMoneyIsNotNull() {
			addCriterion("sum_money is not null");
			return (Criteria) this;
		}

		public Criteria andSumMoneyEqualTo(BigDecimal value) {
			addCriterion("sum_money =", value, "sumMoney");
			return (Criteria) this;
		}

		public Criteria andSumMoneyNotEqualTo(BigDecimal value) {
			addCriterion("sum_money <>", value, "sumMoney");
			return (Criteria) this;
		}

		public Criteria andSumMoneyGreaterThan(BigDecimal value) {
			addCriterion("sum_money >", value, "sumMoney");
			return (Criteria) this;
		}

		public Criteria andSumMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("sum_money >=", value, "sumMoney");
			return (Criteria) this;
		}

		public Criteria andSumMoneyLessThan(BigDecimal value) {
			addCriterion("sum_money <", value, "sumMoney");
			return (Criteria) this;
		}

		public Criteria andSumMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("sum_money <=", value, "sumMoney");
			return (Criteria) this;
		}

		public Criteria andSumMoneyIn(List<BigDecimal> values) {
			addCriterion("sum_money in", values, "sumMoney");
			return (Criteria) this;
		}

		public Criteria andSumMoneyNotIn(List<BigDecimal> values) {
			addCriterion("sum_money not in", values, "sumMoney");
			return (Criteria) this;
		}

		public Criteria andSumMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("sum_money between", value1, value2, "sumMoney");
			return (Criteria) this;
		}

		public Criteria andSumMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("sum_money not between", value1, value2, "sumMoney");
			return (Criteria) this;
		}

		public Criteria andDonationAmountIsNull() {
			addCriterion("donation_amount is null");
			return (Criteria) this;
		}

		public Criteria andDonationAmountIsNotNull() {
			addCriterion("donation_amount is not null");
			return (Criteria) this;
		}

		public Criteria andDonationAmountEqualTo(BigDecimal value) {
			addCriterion("donation_amount =", value, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountNotEqualTo(BigDecimal value) {
			addCriterion("donation_amount <>", value, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountGreaterThan(BigDecimal value) {
			addCriterion("donation_amount >", value, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("donation_amount >=", value, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountLessThan(BigDecimal value) {
			addCriterion("donation_amount <", value, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("donation_amount <=", value, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountIn(List<BigDecimal> values) {
			addCriterion("donation_amount in", values, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountNotIn(List<BigDecimal> values) {
			addCriterion("donation_amount not in", values, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("donation_amount between", value1, value2, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("donation_amount not between", value1, value2, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountIsNull() {
			addCriterion("total_amount is null");
			return (Criteria) this;
		}

		public Criteria andTotalAmountIsNotNull() {
			addCriterion("total_amount is not null");
			return (Criteria) this;
		}

		public Criteria andTotalAmountEqualTo(BigDecimal value) {
			addCriterion("total_amount =", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
			addCriterion("total_amount <>", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountGreaterThan(BigDecimal value) {
			addCriterion("total_amount >", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("total_amount >=", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountLessThan(BigDecimal value) {
			addCriterion("total_amount <", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("total_amount <=", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountIn(List<BigDecimal> values) {
			addCriterion("total_amount in", values, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
			addCriterion("total_amount not in", values, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total_amount between", value1, value2, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total_amount not between", value1, value2, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andMarginIsNull() {
			addCriterion("margin is null");
			return (Criteria) this;
		}

		public Criteria andMarginIsNotNull() {
			addCriterion("margin is not null");
			return (Criteria) this;
		}

		public Criteria andMarginEqualTo(BigDecimal value) {
			addCriterion("margin =", value, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginNotEqualTo(BigDecimal value) {
			addCriterion("margin <>", value, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginGreaterThan(BigDecimal value) {
			addCriterion("margin >", value, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("margin >=", value, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginLessThan(BigDecimal value) {
			addCriterion("margin <", value, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginLessThanOrEqualTo(BigDecimal value) {
			addCriterion("margin <=", value, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginIn(List<BigDecimal> values) {
			addCriterion("margin in", values, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginNotIn(List<BigDecimal> values) {
			addCriterion("margin not in", values, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("margin between", value1, value2, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("margin not between", value1, value2, "margin");
			return (Criteria) this;
		}

		public Criteria andIsRenewalIsNull() {
			addCriterion("is_renewal is null");
			return (Criteria) this;
		}

		public Criteria andIsRenewalIsNotNull() {
			addCriterion("is_renewal is not null");
			return (Criteria) this;
		}

		public Criteria andIsRenewalEqualTo(Integer value) {
			addCriterion("is_renewal =", value, "isRenewal");
			return (Criteria) this;
		}

		public Criteria andIsRenewalNotEqualTo(Integer value) {
			addCriterion("is_renewal <>", value, "isRenewal");
			return (Criteria) this;
		}

		public Criteria andIsRenewalGreaterThan(Integer value) {
			addCriterion("is_renewal >", value, "isRenewal");
			return (Criteria) this;
		}

		public Criteria andIsRenewalGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_renewal >=", value, "isRenewal");
			return (Criteria) this;
		}

		public Criteria andIsRenewalLessThan(Integer value) {
			addCriterion("is_renewal <", value, "isRenewal");
			return (Criteria) this;
		}

		public Criteria andIsRenewalLessThanOrEqualTo(Integer value) {
			addCriterion("is_renewal <=", value, "isRenewal");
			return (Criteria) this;
		}

		public Criteria andIsRenewalIn(List<Integer> values) {
			addCriterion("is_renewal in", values, "isRenewal");
			return (Criteria) this;
		}

		public Criteria andIsRenewalNotIn(List<Integer> values) {
			addCriterion("is_renewal not in", values, "isRenewal");
			return (Criteria) this;
		}

		public Criteria andIsRenewalBetween(Integer value1, Integer value2) {
			addCriterion("is_renewal between", value1, value2, "isRenewal");
			return (Criteria) this;
		}

		public Criteria andIsRenewalNotBetween(Integer value1, Integer value2) {
			addCriterion("is_renewal not between", value1, value2, "isRenewal");
			return (Criteria) this;
		}

		public Criteria andRenewalYearsIsNull() {
			addCriterion("renewal_years is null");
			return (Criteria) this;
		}

		public Criteria andRenewalYearsIsNotNull() {
			addCriterion("renewal_years is not null");
			return (Criteria) this;
		}

		public Criteria andRenewalYearsEqualTo(Integer value) {
			addCriterion("renewal_years =", value, "renewalYears");
			return (Criteria) this;
		}

		public Criteria andRenewalYearsNotEqualTo(Integer value) {
			addCriterion("renewal_years <>", value, "renewalYears");
			return (Criteria) this;
		}

		public Criteria andRenewalYearsGreaterThan(Integer value) {
			addCriterion("renewal_years >", value, "renewalYears");
			return (Criteria) this;
		}

		public Criteria andRenewalYearsGreaterThanOrEqualTo(Integer value) {
			addCriterion("renewal_years >=", value, "renewalYears");
			return (Criteria) this;
		}

		public Criteria andRenewalYearsLessThan(Integer value) {
			addCriterion("renewal_years <", value, "renewalYears");
			return (Criteria) this;
		}

		public Criteria andRenewalYearsLessThanOrEqualTo(Integer value) {
			addCriterion("renewal_years <=", value, "renewalYears");
			return (Criteria) this;
		}

		public Criteria andRenewalYearsIn(List<Integer> values) {
			addCriterion("renewal_years in", values, "renewalYears");
			return (Criteria) this;
		}

		public Criteria andRenewalYearsNotIn(List<Integer> values) {
			addCriterion("renewal_years not in", values, "renewalYears");
			return (Criteria) this;
		}

		public Criteria andRenewalYearsBetween(Integer value1, Integer value2) {
			addCriterion("renewal_years between", value1, value2, "renewalYears");
			return (Criteria) this;
		}

		public Criteria andRenewalYearsNotBetween(Integer value1, Integer value2) {
			addCriterion("renewal_years not between", value1, value2, "renewalYears");
			return (Criteria) this;
		}

		public Criteria andRenewalBalanceIsNull() {
			addCriterion("renewal_balance is null");
			return (Criteria) this;
		}

		public Criteria andRenewalBalanceIsNotNull() {
			addCriterion("renewal_balance is not null");
			return (Criteria) this;
		}

		public Criteria andRenewalBalanceEqualTo(BigDecimal value) {
			addCriterion("renewal_balance =", value, "renewalBalance");
			return (Criteria) this;
		}

		public Criteria andRenewalBalanceNotEqualTo(BigDecimal value) {
			addCriterion("renewal_balance <>", value, "renewalBalance");
			return (Criteria) this;
		}

		public Criteria andRenewalBalanceGreaterThan(BigDecimal value) {
			addCriterion("renewal_balance >", value, "renewalBalance");
			return (Criteria) this;
		}

		public Criteria andRenewalBalanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("renewal_balance >=", value, "renewalBalance");
			return (Criteria) this;
		}

		public Criteria andRenewalBalanceLessThan(BigDecimal value) {
			addCriterion("renewal_balance <", value, "renewalBalance");
			return (Criteria) this;
		}

		public Criteria andRenewalBalanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("renewal_balance <=", value, "renewalBalance");
			return (Criteria) this;
		}

		public Criteria andRenewalBalanceIn(List<BigDecimal> values) {
			addCriterion("renewal_balance in", values, "renewalBalance");
			return (Criteria) this;
		}

		public Criteria andRenewalBalanceNotIn(List<BigDecimal> values) {
			addCriterion("renewal_balance not in", values, "renewalBalance");
			return (Criteria) this;
		}

		public Criteria andRenewalBalanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("renewal_balance between", value1, value2, "renewalBalance");
			return (Criteria) this;
		}

		public Criteria andRenewalBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("renewal_balance not between", value1, value2, "renewalBalance");
			return (Criteria) this;
		}

		public Criteria andMortgageIsNull() {
			addCriterion("mortgage is null");
			return (Criteria) this;
		}

		public Criteria andMortgageIsNotNull() {
			addCriterion("mortgage is not null");
			return (Criteria) this;
		}

		public Criteria andMortgageEqualTo(Long value) {
			addCriterion("mortgage =", value, "mortgage");
			return (Criteria) this;
		}

		public Criteria andMortgageNotEqualTo(Long value) {
			addCriterion("mortgage <>", value, "mortgage");
			return (Criteria) this;
		}

		public Criteria andMortgageGreaterThan(Long value) {
			addCriterion("mortgage >", value, "mortgage");
			return (Criteria) this;
		}

		public Criteria andMortgageGreaterThanOrEqualTo(Long value) {
			addCriterion("mortgage >=", value, "mortgage");
			return (Criteria) this;
		}

		public Criteria andMortgageLessThan(Long value) {
			addCriterion("mortgage <", value, "mortgage");
			return (Criteria) this;
		}

		public Criteria andMortgageLessThanOrEqualTo(Long value) {
			addCriterion("mortgage <=", value, "mortgage");
			return (Criteria) this;
		}

		public Criteria andMortgageIn(List<Long> values) {
			addCriterion("mortgage in", values, "mortgage");
			return (Criteria) this;
		}

		public Criteria andMortgageNotIn(List<Long> values) {
			addCriterion("mortgage not in", values, "mortgage");
			return (Criteria) this;
		}

		public Criteria andMortgageBetween(Long value1, Long value2) {
			addCriterion("mortgage between", value1, value2, "mortgage");
			return (Criteria) this;
		}

		public Criteria andMortgageNotBetween(Long value1, Long value2) {
			addCriterion("mortgage not between", value1, value2, "mortgage");
			return (Criteria) this;
		}

		public Criteria andIsGiftIsNull() {
			addCriterion("is_gift is null");
			return (Criteria) this;
		}

		public Criteria andIsGiftIsNotNull() {
			addCriterion("is_gift is not null");
			return (Criteria) this;
		}

		public Criteria andIsGiftEqualTo(Integer value) {
			addCriterion("is_gift =", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftNotEqualTo(Integer value) {
			addCriterion("is_gift <>", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftGreaterThan(Integer value) {
			addCriterion("is_gift >", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_gift >=", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftLessThan(Integer value) {
			addCriterion("is_gift <", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftLessThanOrEqualTo(Integer value) {
			addCriterion("is_gift <=", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftIn(List<Integer> values) {
			addCriterion("is_gift in", values, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftNotIn(List<Integer> values) {
			addCriterion("is_gift not in", values, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftBetween(Integer value1, Integer value2) {
			addCriterion("is_gift between", value1, value2, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftNotBetween(Integer value1, Integer value2) {
			addCriterion("is_gift not between", value1, value2, "isGift");
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

		public Criteria andStateIsNull() {
			addCriterion("state is null");
			return (Criteria) this;
		}

		public Criteria andStateIsNotNull() {
			addCriterion("state is not null");
			return (Criteria) this;
		}

		public Criteria andStateEqualTo(Integer value) {
			addCriterion("state =", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotEqualTo(Integer value) {
			addCriterion("state <>", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThan(Integer value) {
			addCriterion("state >", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("state >=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThan(Integer value) {
			addCriterion("state <", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThanOrEqualTo(Integer value) {
			addCriterion("state <=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateIn(List<Integer> values) {
			addCriterion("state in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotIn(List<Integer> values) {
			addCriterion("state not in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateBetween(Integer value1, Integer value2) {
			addCriterion("state between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotBetween(Integer value1, Integer value2) {
			addCriterion("state not between", value1, value2, "state");
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