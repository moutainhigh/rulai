package com.unicdata.entity.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderFinanceExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderFinanceExample() {
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

		public Criteria andLoanAmountIsNull() {
			addCriterion("loan_amount is null");
			return (Criteria) this;
		}

		public Criteria andLoanAmountIsNotNull() {
			addCriterion("loan_amount is not null");
			return (Criteria) this;
		}

		public Criteria andLoanAmountEqualTo(BigDecimal value) {
			addCriterion("loan_amount =", value, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountNotEqualTo(BigDecimal value) {
			addCriterion("loan_amount <>", value, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountGreaterThan(BigDecimal value) {
			addCriterion("loan_amount >", value, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("loan_amount >=", value, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountLessThan(BigDecimal value) {
			addCriterion("loan_amount <", value, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("loan_amount <=", value, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountIn(List<BigDecimal> values) {
			addCriterion("loan_amount in", values, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountNotIn(List<BigDecimal> values) {
			addCriterion("loan_amount not in", values, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("loan_amount between", value1, value2, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("loan_amount not between", value1, value2, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andPaymentRatioIsNull() {
			addCriterion("payment_ratio is null");
			return (Criteria) this;
		}

		public Criteria andPaymentRatioIsNotNull() {
			addCriterion("payment_ratio is not null");
			return (Criteria) this;
		}

		public Criteria andPaymentRatioEqualTo(BigDecimal value) {
			addCriterion("payment_ratio =", value, "paymentRatio");
			return (Criteria) this;
		}

		public Criteria andPaymentRatioNotEqualTo(BigDecimal value) {
			addCriterion("payment_ratio <>", value, "paymentRatio");
			return (Criteria) this;
		}

		public Criteria andPaymentRatioGreaterThan(BigDecimal value) {
			addCriterion("payment_ratio >", value, "paymentRatio");
			return (Criteria) this;
		}

		public Criteria andPaymentRatioGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("payment_ratio >=", value, "paymentRatio");
			return (Criteria) this;
		}

		public Criteria andPaymentRatioLessThan(BigDecimal value) {
			addCriterion("payment_ratio <", value, "paymentRatio");
			return (Criteria) this;
		}

		public Criteria andPaymentRatioLessThanOrEqualTo(BigDecimal value) {
			addCriterion("payment_ratio <=", value, "paymentRatio");
			return (Criteria) this;
		}

		public Criteria andPaymentRatioIn(List<BigDecimal> values) {
			addCriterion("payment_ratio in", values, "paymentRatio");
			return (Criteria) this;
		}

		public Criteria andPaymentRatioNotIn(List<BigDecimal> values) {
			addCriterion("payment_ratio not in", values, "paymentRatio");
			return (Criteria) this;
		}

		public Criteria andPaymentRatioBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("payment_ratio between", value1, value2, "paymentRatio");
			return (Criteria) this;
		}

		public Criteria andPaymentRatioNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("payment_ratio not between", value1, value2, "paymentRatio");
			return (Criteria) this;
		}

		public Criteria andDownPaymentIsNull() {
			addCriterion("down_payment is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentIsNotNull() {
			addCriterion("down_payment is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentEqualTo(BigDecimal value) {
			addCriterion("down_payment =", value, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentNotEqualTo(BigDecimal value) {
			addCriterion("down_payment <>", value, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentGreaterThan(BigDecimal value) {
			addCriterion("down_payment >", value, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("down_payment >=", value, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentLessThan(BigDecimal value) {
			addCriterion("down_payment <", value, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentLessThanOrEqualTo(BigDecimal value) {
			addCriterion("down_payment <=", value, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentIn(List<BigDecimal> values) {
			addCriterion("down_payment in", values, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentNotIn(List<BigDecimal> values) {
			addCriterion("down_payment not in", values, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("down_payment between", value1, value2, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("down_payment not between", value1, value2, "downPayment");
			return (Criteria) this;
		}

		public Criteria andLoanRateIsNull() {
			addCriterion("loan_rate is null");
			return (Criteria) this;
		}

		public Criteria andLoanRateIsNotNull() {
			addCriterion("loan_rate is not null");
			return (Criteria) this;
		}

		public Criteria andLoanRateEqualTo(BigDecimal value) {
			addCriterion("loan_rate =", value, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateNotEqualTo(BigDecimal value) {
			addCriterion("loan_rate <>", value, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateGreaterThan(BigDecimal value) {
			addCriterion("loan_rate >", value, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("loan_rate >=", value, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateLessThan(BigDecimal value) {
			addCriterion("loan_rate <", value, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("loan_rate <=", value, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateIn(List<BigDecimal> values) {
			addCriterion("loan_rate in", values, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateNotIn(List<BigDecimal> values) {
			addCriterion("loan_rate not in", values, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("loan_rate between", value1, value2, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("loan_rate not between", value1, value2, "loanRate");
			return (Criteria) this;
		}

		public Criteria andInterestIsNull() {
			addCriterion("interest is null");
			return (Criteria) this;
		}

		public Criteria andInterestIsNotNull() {
			addCriterion("interest is not null");
			return (Criteria) this;
		}

		public Criteria andInterestEqualTo(BigDecimal value) {
			addCriterion("interest =", value, "interest");
			return (Criteria) this;
		}

		public Criteria andInterestNotEqualTo(BigDecimal value) {
			addCriterion("interest <>", value, "interest");
			return (Criteria) this;
		}

		public Criteria andInterestGreaterThan(BigDecimal value) {
			addCriterion("interest >", value, "interest");
			return (Criteria) this;
		}

		public Criteria andInterestGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("interest >=", value, "interest");
			return (Criteria) this;
		}

		public Criteria andInterestLessThan(BigDecimal value) {
			addCriterion("interest <", value, "interest");
			return (Criteria) this;
		}

		public Criteria andInterestLessThanOrEqualTo(BigDecimal value) {
			addCriterion("interest <=", value, "interest");
			return (Criteria) this;
		}

		public Criteria andInterestIn(List<BigDecimal> values) {
			addCriterion("interest in", values, "interest");
			return (Criteria) this;
		}

		public Criteria andInterestNotIn(List<BigDecimal> values) {
			addCriterion("interest not in", values, "interest");
			return (Criteria) this;
		}

		public Criteria andInterestBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("interest between", value1, value2, "interest");
			return (Criteria) this;
		}

		public Criteria andInterestNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("interest not between", value1, value2, "interest");
			return (Criteria) this;
		}

		public Criteria andLoanTermIsNull() {
			addCriterion("loan_term is null");
			return (Criteria) this;
		}

		public Criteria andLoanTermIsNotNull() {
			addCriterion("loan_term is not null");
			return (Criteria) this;
		}

		public Criteria andLoanTermEqualTo(Integer value) {
			addCriterion("loan_term =", value, "loanTerm");
			return (Criteria) this;
		}

		public Criteria andLoanTermNotEqualTo(Integer value) {
			addCriterion("loan_term <>", value, "loanTerm");
			return (Criteria) this;
		}

		public Criteria andLoanTermGreaterThan(Integer value) {
			addCriterion("loan_term >", value, "loanTerm");
			return (Criteria) this;
		}

		public Criteria andLoanTermGreaterThanOrEqualTo(Integer value) {
			addCriterion("loan_term >=", value, "loanTerm");
			return (Criteria) this;
		}

		public Criteria andLoanTermLessThan(Integer value) {
			addCriterion("loan_term <", value, "loanTerm");
			return (Criteria) this;
		}

		public Criteria andLoanTermLessThanOrEqualTo(Integer value) {
			addCriterion("loan_term <=", value, "loanTerm");
			return (Criteria) this;
		}

		public Criteria andLoanTermIn(List<Integer> values) {
			addCriterion("loan_term in", values, "loanTerm");
			return (Criteria) this;
		}

		public Criteria andLoanTermNotIn(List<Integer> values) {
			addCriterion("loan_term not in", values, "loanTerm");
			return (Criteria) this;
		}

		public Criteria andLoanTermBetween(Integer value1, Integer value2) {
			addCriterion("loan_term between", value1, value2, "loanTerm");
			return (Criteria) this;
		}

		public Criteria andLoanTermNotBetween(Integer value1, Integer value2) {
			addCriterion("loan_term not between", value1, value2, "loanTerm");
			return (Criteria) this;
		}

		public Criteria andMonthlySupplyIsNull() {
			addCriterion("monthly_supply is null");
			return (Criteria) this;
		}

		public Criteria andMonthlySupplyIsNotNull() {
			addCriterion("monthly_supply is not null");
			return (Criteria) this;
		}

		public Criteria andMonthlySupplyEqualTo(BigDecimal value) {
			addCriterion("monthly_supply =", value, "monthlySupply");
			return (Criteria) this;
		}

		public Criteria andMonthlySupplyNotEqualTo(BigDecimal value) {
			addCriterion("monthly_supply <>", value, "monthlySupply");
			return (Criteria) this;
		}

		public Criteria andMonthlySupplyGreaterThan(BigDecimal value) {
			addCriterion("monthly_supply >", value, "monthlySupply");
			return (Criteria) this;
		}

		public Criteria andMonthlySupplyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("monthly_supply >=", value, "monthlySupply");
			return (Criteria) this;
		}

		public Criteria andMonthlySupplyLessThan(BigDecimal value) {
			addCriterion("monthly_supply <", value, "monthlySupply");
			return (Criteria) this;
		}

		public Criteria andMonthlySupplyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("monthly_supply <=", value, "monthlySupply");
			return (Criteria) this;
		}

		public Criteria andMonthlySupplyIn(List<BigDecimal> values) {
			addCriterion("monthly_supply in", values, "monthlySupply");
			return (Criteria) this;
		}

		public Criteria andMonthlySupplyNotIn(List<BigDecimal> values) {
			addCriterion("monthly_supply not in", values, "monthlySupply");
			return (Criteria) this;
		}

		public Criteria andMonthlySupplyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("monthly_supply between", value1, value2, "monthlySupply");
			return (Criteria) this;
		}

		public Criteria andMonthlySupplyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("monthly_supply not between", value1, value2, "monthlySupply");
			return (Criteria) this;
		}

		public Criteria andIsSubsidyIsNull() {
			addCriterion("is_subsidy is null");
			return (Criteria) this;
		}

		public Criteria andIsSubsidyIsNotNull() {
			addCriterion("is_subsidy is not null");
			return (Criteria) this;
		}

		public Criteria andIsSubsidyEqualTo(Integer value) {
			addCriterion("is_subsidy =", value, "isSubsidy");
			return (Criteria) this;
		}

		public Criteria andIsSubsidyNotEqualTo(Integer value) {
			addCriterion("is_subsidy <>", value, "isSubsidy");
			return (Criteria) this;
		}

		public Criteria andIsSubsidyGreaterThan(Integer value) {
			addCriterion("is_subsidy >", value, "isSubsidy");
			return (Criteria) this;
		}

		public Criteria andIsSubsidyGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_subsidy >=", value, "isSubsidy");
			return (Criteria) this;
		}

		public Criteria andIsSubsidyLessThan(Integer value) {
			addCriterion("is_subsidy <", value, "isSubsidy");
			return (Criteria) this;
		}

		public Criteria andIsSubsidyLessThanOrEqualTo(Integer value) {
			addCriterion("is_subsidy <=", value, "isSubsidy");
			return (Criteria) this;
		}

		public Criteria andIsSubsidyIn(List<Integer> values) {
			addCriterion("is_subsidy in", values, "isSubsidy");
			return (Criteria) this;
		}

		public Criteria andIsSubsidyNotIn(List<Integer> values) {
			addCriterion("is_subsidy not in", values, "isSubsidy");
			return (Criteria) this;
		}

		public Criteria andIsSubsidyBetween(Integer value1, Integer value2) {
			addCriterion("is_subsidy between", value1, value2, "isSubsidy");
			return (Criteria) this;
		}

		public Criteria andIsSubsidyNotBetween(Integer value1, Integer value2) {
			addCriterion("is_subsidy not between", value1, value2, "isSubsidy");
			return (Criteria) this;
		}

		public Criteria andSubsidyInterestIsNull() {
			addCriterion("subsidy_interest is null");
			return (Criteria) this;
		}

		public Criteria andSubsidyInterestIsNotNull() {
			addCriterion("subsidy_interest is not null");
			return (Criteria) this;
		}

		public Criteria andSubsidyInterestEqualTo(Long value) {
			addCriterion("subsidy_interest =", value, "subsidyInterest");
			return (Criteria) this;
		}

		public Criteria andSubsidyInterestNotEqualTo(Long value) {
			addCriterion("subsidy_interest <>", value, "subsidyInterest");
			return (Criteria) this;
		}

		public Criteria andSubsidyInterestGreaterThan(Long value) {
			addCriterion("subsidy_interest >", value, "subsidyInterest");
			return (Criteria) this;
		}

		public Criteria andSubsidyInterestGreaterThanOrEqualTo(Long value) {
			addCriterion("subsidy_interest >=", value, "subsidyInterest");
			return (Criteria) this;
		}

		public Criteria andSubsidyInterestLessThan(Long value) {
			addCriterion("subsidy_interest <", value, "subsidyInterest");
			return (Criteria) this;
		}

		public Criteria andSubsidyInterestLessThanOrEqualTo(Long value) {
			addCriterion("subsidy_interest <=", value, "subsidyInterest");
			return (Criteria) this;
		}

		public Criteria andSubsidyInterestIn(List<Long> values) {
			addCriterion("subsidy_interest in", values, "subsidyInterest");
			return (Criteria) this;
		}

		public Criteria andSubsidyInterestNotIn(List<Long> values) {
			addCriterion("subsidy_interest not in", values, "subsidyInterest");
			return (Criteria) this;
		}

		public Criteria andSubsidyInterestBetween(Long value1, Long value2) {
			addCriterion("subsidy_interest between", value1, value2, "subsidyInterest");
			return (Criteria) this;
		}

		public Criteria andSubsidyInterestNotBetween(Long value1, Long value2) {
			addCriterion("subsidy_interest not between", value1, value2, "subsidyInterest");
			return (Criteria) this;
		}

		public Criteria andBondIsNull() {
			addCriterion("bond is null");
			return (Criteria) this;
		}

		public Criteria andBondIsNotNull() {
			addCriterion("bond is not null");
			return (Criteria) this;
		}

		public Criteria andBondEqualTo(BigDecimal value) {
			addCriterion("bond =", value, "bond");
			return (Criteria) this;
		}

		public Criteria andBondNotEqualTo(BigDecimal value) {
			addCriterion("bond <>", value, "bond");
			return (Criteria) this;
		}

		public Criteria andBondGreaterThan(BigDecimal value) {
			addCriterion("bond >", value, "bond");
			return (Criteria) this;
		}

		public Criteria andBondGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("bond >=", value, "bond");
			return (Criteria) this;
		}

		public Criteria andBondLessThan(BigDecimal value) {
			addCriterion("bond <", value, "bond");
			return (Criteria) this;
		}

		public Criteria andBondLessThanOrEqualTo(BigDecimal value) {
			addCriterion("bond <=", value, "bond");
			return (Criteria) this;
		}

		public Criteria andBondIn(List<BigDecimal> values) {
			addCriterion("bond in", values, "bond");
			return (Criteria) this;
		}

		public Criteria andBondNotIn(List<BigDecimal> values) {
			addCriterion("bond not in", values, "bond");
			return (Criteria) this;
		}

		public Criteria andBondBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("bond between", value1, value2, "bond");
			return (Criteria) this;
		}

		public Criteria andBondNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("bond not between", value1, value2, "bond");
			return (Criteria) this;
		}

		public Criteria andChargeTypeIsNull() {
			addCriterion("charge_type is null");
			return (Criteria) this;
		}

		public Criteria andChargeTypeIsNotNull() {
			addCriterion("charge_type is not null");
			return (Criteria) this;
		}

		public Criteria andChargeTypeEqualTo(Byte value) {
			addCriterion("charge_type =", value, "chargeType");
			return (Criteria) this;
		}

		public Criteria andChargeTypeNotEqualTo(Byte value) {
			addCriterion("charge_type <>", value, "chargeType");
			return (Criteria) this;
		}

		public Criteria andChargeTypeGreaterThan(Byte value) {
			addCriterion("charge_type >", value, "chargeType");
			return (Criteria) this;
		}

		public Criteria andChargeTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("charge_type >=", value, "chargeType");
			return (Criteria) this;
		}

		public Criteria andChargeTypeLessThan(Byte value) {
			addCriterion("charge_type <", value, "chargeType");
			return (Criteria) this;
		}

		public Criteria andChargeTypeLessThanOrEqualTo(Byte value) {
			addCriterion("charge_type <=", value, "chargeType");
			return (Criteria) this;
		}

		public Criteria andChargeTypeIn(List<Byte> values) {
			addCriterion("charge_type in", values, "chargeType");
			return (Criteria) this;
		}

		public Criteria andChargeTypeNotIn(List<Byte> values) {
			addCriterion("charge_type not in", values, "chargeType");
			return (Criteria) this;
		}

		public Criteria andChargeTypeBetween(Byte value1, Byte value2) {
			addCriterion("charge_type between", value1, value2, "chargeType");
			return (Criteria) this;
		}

		public Criteria andChargeTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("charge_type not between", value1, value2, "chargeType");
			return (Criteria) this;
		}

		public Criteria andChargeRatioIsNull() {
			addCriterion("charge_ratio is null");
			return (Criteria) this;
		}

		public Criteria andChargeRatioIsNotNull() {
			addCriterion("charge_ratio is not null");
			return (Criteria) this;
		}

		public Criteria andChargeRatioEqualTo(BigDecimal value) {
			addCriterion("charge_ratio =", value, "chargeRatio");
			return (Criteria) this;
		}

		public Criteria andChargeRatioNotEqualTo(BigDecimal value) {
			addCriterion("charge_ratio <>", value, "chargeRatio");
			return (Criteria) this;
		}

		public Criteria andChargeRatioGreaterThan(BigDecimal value) {
			addCriterion("charge_ratio >", value, "chargeRatio");
			return (Criteria) this;
		}

		public Criteria andChargeRatioGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("charge_ratio >=", value, "chargeRatio");
			return (Criteria) this;
		}

		public Criteria andChargeRatioLessThan(BigDecimal value) {
			addCriterion("charge_ratio <", value, "chargeRatio");
			return (Criteria) this;
		}

		public Criteria andChargeRatioLessThanOrEqualTo(BigDecimal value) {
			addCriterion("charge_ratio <=", value, "chargeRatio");
			return (Criteria) this;
		}

		public Criteria andChargeRatioIn(List<BigDecimal> values) {
			addCriterion("charge_ratio in", values, "chargeRatio");
			return (Criteria) this;
		}

		public Criteria andChargeRatioNotIn(List<BigDecimal> values) {
			addCriterion("charge_ratio not in", values, "chargeRatio");
			return (Criteria) this;
		}

		public Criteria andChargeRatioBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("charge_ratio between", value1, value2, "chargeRatio");
			return (Criteria) this;
		}

		public Criteria andChargeRatioNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("charge_ratio not between", value1, value2, "chargeRatio");
			return (Criteria) this;
		}

		public Criteria andChargeIsNull() {
			addCriterion("charge is null");
			return (Criteria) this;
		}

		public Criteria andChargeIsNotNull() {
			addCriterion("charge is not null");
			return (Criteria) this;
		}

		public Criteria andChargeEqualTo(BigDecimal value) {
			addCriterion("charge =", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeNotEqualTo(BigDecimal value) {
			addCriterion("charge <>", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeGreaterThan(BigDecimal value) {
			addCriterion("charge >", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("charge >=", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeLessThan(BigDecimal value) {
			addCriterion("charge <", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("charge <=", value, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeIn(List<BigDecimal> values) {
			addCriterion("charge in", values, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeNotIn(List<BigDecimal> values) {
			addCriterion("charge not in", values, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("charge between", value1, value2, "charge");
			return (Criteria) this;
		}

		public Criteria andChargeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("charge not between", value1, value2, "charge");
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

		public Criteria andLoanStatusIsNull() {
			addCriterion("loan_status is null");
			return (Criteria) this;
		}

		public Criteria andLoanStatusIsNotNull() {
			addCriterion("loan_status is not null");
			return (Criteria) this;
		}

		public Criteria andLoanStatusEqualTo(Integer value) {
			addCriterion("loan_status =", value, "loanStatus");
			return (Criteria) this;
		}

		public Criteria andLoanStatusNotEqualTo(Integer value) {
			addCriterion("loan_status <>", value, "loanStatus");
			return (Criteria) this;
		}

		public Criteria andLoanStatusGreaterThan(Integer value) {
			addCriterion("loan_status >", value, "loanStatus");
			return (Criteria) this;
		}

		public Criteria andLoanStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("loan_status >=", value, "loanStatus");
			return (Criteria) this;
		}

		public Criteria andLoanStatusLessThan(Integer value) {
			addCriterion("loan_status <", value, "loanStatus");
			return (Criteria) this;
		}

		public Criteria andLoanStatusLessThanOrEqualTo(Integer value) {
			addCriterion("loan_status <=", value, "loanStatus");
			return (Criteria) this;
		}

		public Criteria andLoanStatusIn(List<Integer> values) {
			addCriterion("loan_status in", values, "loanStatus");
			return (Criteria) this;
		}

		public Criteria andLoanStatusNotIn(List<Integer> values) {
			addCriterion("loan_status not in", values, "loanStatus");
			return (Criteria) this;
		}

		public Criteria andLoanStatusBetween(Integer value1, Integer value2) {
			addCriterion("loan_status between", value1, value2, "loanStatus");
			return (Criteria) this;
		}

		public Criteria andLoanStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("loan_status not between", value1, value2, "loanStatus");
			return (Criteria) this;
		}

		public Criteria andLoanDateIsNull() {
			addCriterion("loan_date is null");
			return (Criteria) this;
		}

		public Criteria andLoanDateIsNotNull() {
			addCriterion("loan_date is not null");
			return (Criteria) this;
		}

		public Criteria andLoanDateEqualTo(Date value) {
			addCriterionForJDBCDate("loan_date =", value, "loanDate");
			return (Criteria) this;
		}

		public Criteria andLoanDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("loan_date <>", value, "loanDate");
			return (Criteria) this;
		}

		public Criteria andLoanDateGreaterThan(Date value) {
			addCriterionForJDBCDate("loan_date >", value, "loanDate");
			return (Criteria) this;
		}

		public Criteria andLoanDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("loan_date >=", value, "loanDate");
			return (Criteria) this;
		}

		public Criteria andLoanDateLessThan(Date value) {
			addCriterionForJDBCDate("loan_date <", value, "loanDate");
			return (Criteria) this;
		}

		public Criteria andLoanDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("loan_date <=", value, "loanDate");
			return (Criteria) this;
		}

		public Criteria andLoanDateIn(List<Date> values) {
			addCriterionForJDBCDate("loan_date in", values, "loanDate");
			return (Criteria) this;
		}

		public Criteria andLoanDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("loan_date not in", values, "loanDate");
			return (Criteria) this;
		}

		public Criteria andLoanDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("loan_date between", value1, value2, "loanDate");
			return (Criteria) this;
		}

		public Criteria andLoanDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("loan_date not between", value1, value2, "loanDate");
			return (Criteria) this;
		}

		public Criteria andApplyDateIsNull() {
			addCriterion("apply_date is null");
			return (Criteria) this;
		}

		public Criteria andApplyDateIsNotNull() {
			addCriterion("apply_date is not null");
			return (Criteria) this;
		}

		public Criteria andApplyDateEqualTo(Date value) {
			addCriterionForJDBCDate("apply_date =", value, "applyDate");
			return (Criteria) this;
		}

		public Criteria andApplyDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("apply_date <>", value, "applyDate");
			return (Criteria) this;
		}

		public Criteria andApplyDateGreaterThan(Date value) {
			addCriterionForJDBCDate("apply_date >", value, "applyDate");
			return (Criteria) this;
		}

		public Criteria andApplyDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("apply_date >=", value, "applyDate");
			return (Criteria) this;
		}

		public Criteria andApplyDateLessThan(Date value) {
			addCriterionForJDBCDate("apply_date <", value, "applyDate");
			return (Criteria) this;
		}

		public Criteria andApplyDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("apply_date <=", value, "applyDate");
			return (Criteria) this;
		}

		public Criteria andApplyDateIn(List<Date> values) {
			addCriterionForJDBCDate("apply_date in", values, "applyDate");
			return (Criteria) this;
		}

		public Criteria andApplyDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("apply_date not in", values, "applyDate");
			return (Criteria) this;
		}

		public Criteria andApplyDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("apply_date between", value1, value2, "applyDate");
			return (Criteria) this;
		}

		public Criteria andApplyDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("apply_date not between", value1, value2, "applyDate");
			return (Criteria) this;
		}

		public Criteria andMortgageCostIsNull() {
			addCriterion("mortgage_cost is null");
			return (Criteria) this;
		}

		public Criteria andMortgageCostIsNotNull() {
			addCriterion("mortgage_cost is not null");
			return (Criteria) this;
		}

		public Criteria andMortgageCostEqualTo(BigDecimal value) {
			addCriterion("mortgage_cost =", value, "mortgageCost");
			return (Criteria) this;
		}

		public Criteria andMortgageCostNotEqualTo(BigDecimal value) {
			addCriterion("mortgage_cost <>", value, "mortgageCost");
			return (Criteria) this;
		}

		public Criteria andMortgageCostGreaterThan(BigDecimal value) {
			addCriterion("mortgage_cost >", value, "mortgageCost");
			return (Criteria) this;
		}

		public Criteria andMortgageCostGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("mortgage_cost >=", value, "mortgageCost");
			return (Criteria) this;
		}

		public Criteria andMortgageCostLessThan(BigDecimal value) {
			addCriterion("mortgage_cost <", value, "mortgageCost");
			return (Criteria) this;
		}

		public Criteria andMortgageCostLessThanOrEqualTo(BigDecimal value) {
			addCriterion("mortgage_cost <=", value, "mortgageCost");
			return (Criteria) this;
		}

		public Criteria andMortgageCostIn(List<BigDecimal> values) {
			addCriterion("mortgage_cost in", values, "mortgageCost");
			return (Criteria) this;
		}

		public Criteria andMortgageCostNotIn(List<BigDecimal> values) {
			addCriterion("mortgage_cost not in", values, "mortgageCost");
			return (Criteria) this;
		}

		public Criteria andMortgageCostBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("mortgage_cost between", value1, value2, "mortgageCost");
			return (Criteria) this;
		}

		public Criteria andMortgageCostNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("mortgage_cost not between", value1, value2, "mortgageCost");
			return (Criteria) this;
		}

		public Criteria andMortgageChargeIsNull() {
			addCriterion("mortgage_charge is null");
			return (Criteria) this;
		}

		public Criteria andMortgageChargeIsNotNull() {
			addCriterion("mortgage_charge is not null");
			return (Criteria) this;
		}

		public Criteria andMortgageChargeEqualTo(BigDecimal value) {
			addCriterion("mortgage_charge =", value, "mortgageCharge");
			return (Criteria) this;
		}

		public Criteria andMortgageChargeNotEqualTo(BigDecimal value) {
			addCriterion("mortgage_charge <>", value, "mortgageCharge");
			return (Criteria) this;
		}

		public Criteria andMortgageChargeGreaterThan(BigDecimal value) {
			addCriterion("mortgage_charge >", value, "mortgageCharge");
			return (Criteria) this;
		}

		public Criteria andMortgageChargeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("mortgage_charge >=", value, "mortgageCharge");
			return (Criteria) this;
		}

		public Criteria andMortgageChargeLessThan(BigDecimal value) {
			addCriterion("mortgage_charge <", value, "mortgageCharge");
			return (Criteria) this;
		}

		public Criteria andMortgageChargeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("mortgage_charge <=", value, "mortgageCharge");
			return (Criteria) this;
		}

		public Criteria andMortgageChargeIn(List<BigDecimal> values) {
			addCriterion("mortgage_charge in", values, "mortgageCharge");
			return (Criteria) this;
		}

		public Criteria andMortgageChargeNotIn(List<BigDecimal> values) {
			addCriterion("mortgage_charge not in", values, "mortgageCharge");
			return (Criteria) this;
		}

		public Criteria andMortgageChargeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("mortgage_charge between", value1, value2, "mortgageCharge");
			return (Criteria) this;
		}

		public Criteria andMortgageChargeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("mortgage_charge not between", value1, value2, "mortgageCharge");
			return (Criteria) this;
		}

		public Criteria andSumFinancePriceIsNull() {
			addCriterion("sum_finance_price is null");
			return (Criteria) this;
		}

		public Criteria andSumFinancePriceIsNotNull() {
			addCriterion("sum_finance_price is not null");
			return (Criteria) this;
		}

		public Criteria andSumFinancePriceEqualTo(BigDecimal value) {
			addCriterion("sum_finance_price =", value, "sumFinancePrice");
			return (Criteria) this;
		}

		public Criteria andSumFinancePriceNotEqualTo(BigDecimal value) {
			addCriterion("sum_finance_price <>", value, "sumFinancePrice");
			return (Criteria) this;
		}

		public Criteria andSumFinancePriceGreaterThan(BigDecimal value) {
			addCriterion("sum_finance_price >", value, "sumFinancePrice");
			return (Criteria) this;
		}

		public Criteria andSumFinancePriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("sum_finance_price >=", value, "sumFinancePrice");
			return (Criteria) this;
		}

		public Criteria andSumFinancePriceLessThan(BigDecimal value) {
			addCriterion("sum_finance_price <", value, "sumFinancePrice");
			return (Criteria) this;
		}

		public Criteria andSumFinancePriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("sum_finance_price <=", value, "sumFinancePrice");
			return (Criteria) this;
		}

		public Criteria andSumFinancePriceIn(List<BigDecimal> values) {
			addCriterion("sum_finance_price in", values, "sumFinancePrice");
			return (Criteria) this;
		}

		public Criteria andSumFinancePriceNotIn(List<BigDecimal> values) {
			addCriterion("sum_finance_price not in", values, "sumFinancePrice");
			return (Criteria) this;
		}

		public Criteria andSumFinancePriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("sum_finance_price between", value1, value2, "sumFinancePrice");
			return (Criteria) this;
		}

		public Criteria andSumFinancePriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("sum_finance_price not between", value1, value2, "sumFinancePrice");
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

		public Criteria andIsGpsIsNull() {
			addCriterion("is_gps is null");
			return (Criteria) this;
		}

		public Criteria andIsGpsIsNotNull() {
			addCriterion("is_gps is not null");
			return (Criteria) this;
		}

		public Criteria andIsGpsEqualTo(Integer value) {
			addCriterion("is_gps =", value, "isGps");
			return (Criteria) this;
		}

		public Criteria andIsGpsNotEqualTo(Integer value) {
			addCriterion("is_gps <>", value, "isGps");
			return (Criteria) this;
		}

		public Criteria andIsGpsGreaterThan(Integer value) {
			addCriterion("is_gps >", value, "isGps");
			return (Criteria) this;
		}

		public Criteria andIsGpsGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_gps >=", value, "isGps");
			return (Criteria) this;
		}

		public Criteria andIsGpsLessThan(Integer value) {
			addCriterion("is_gps <", value, "isGps");
			return (Criteria) this;
		}

		public Criteria andIsGpsLessThanOrEqualTo(Integer value) {
			addCriterion("is_gps <=", value, "isGps");
			return (Criteria) this;
		}

		public Criteria andIsGpsIn(List<Integer> values) {
			addCriterion("is_gps in", values, "isGps");
			return (Criteria) this;
		}

		public Criteria andIsGpsNotIn(List<Integer> values) {
			addCriterion("is_gps not in", values, "isGps");
			return (Criteria) this;
		}

		public Criteria andIsGpsBetween(Integer value1, Integer value2) {
			addCriterion("is_gps between", value1, value2, "isGps");
			return (Criteria) this;
		}

		public Criteria andIsGpsNotBetween(Integer value1, Integer value2) {
			addCriterion("is_gps not between", value1, value2, "isGps");
			return (Criteria) this;
		}

		public Criteria andFinanceChargeIsNull() {
			addCriterion("finance_charge is null");
			return (Criteria) this;
		}

		public Criteria andFinanceChargeIsNotNull() {
			addCriterion("finance_charge is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceChargeEqualTo(BigDecimal value) {
			addCriterion("finance_charge =", value, "financeCharge");
			return (Criteria) this;
		}

		public Criteria andFinanceChargeNotEqualTo(BigDecimal value) {
			addCriterion("finance_charge <>", value, "financeCharge");
			return (Criteria) this;
		}

		public Criteria andFinanceChargeGreaterThan(BigDecimal value) {
			addCriterion("finance_charge >", value, "financeCharge");
			return (Criteria) this;
		}

		public Criteria andFinanceChargeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("finance_charge >=", value, "financeCharge");
			return (Criteria) this;
		}

		public Criteria andFinanceChargeLessThan(BigDecimal value) {
			addCriterion("finance_charge <", value, "financeCharge");
			return (Criteria) this;
		}

		public Criteria andFinanceChargeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("finance_charge <=", value, "financeCharge");
			return (Criteria) this;
		}

		public Criteria andFinanceChargeIn(List<BigDecimal> values) {
			addCriterion("finance_charge in", values, "financeCharge");
			return (Criteria) this;
		}

		public Criteria andFinanceChargeNotIn(List<BigDecimal> values) {
			addCriterion("finance_charge not in", values, "financeCharge");
			return (Criteria) this;
		}

		public Criteria andFinanceChargeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("finance_charge between", value1, value2, "financeCharge");
			return (Criteria) this;
		}

		public Criteria andFinanceChargeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("finance_charge not between", value1, value2, "financeCharge");
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