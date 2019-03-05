package com.unicdata.entity.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderSetMealExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderSetMealExample() {
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

		public Criteria andSetMealIdIsNull() {
			addCriterion("set_meal_id is null");
			return (Criteria) this;
		}

		public Criteria andSetMealIdIsNotNull() {
			addCriterion("set_meal_id is not null");
			return (Criteria) this;
		}

		public Criteria andSetMealIdEqualTo(Integer value) {
			addCriterion("set_meal_id =", value, "setMealId");
			return (Criteria) this;
		}

		public Criteria andSetMealIdNotEqualTo(Integer value) {
			addCriterion("set_meal_id <>", value, "setMealId");
			return (Criteria) this;
		}

		public Criteria andSetMealIdGreaterThan(Integer value) {
			addCriterion("set_meal_id >", value, "setMealId");
			return (Criteria) this;
		}

		public Criteria andSetMealIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("set_meal_id >=", value, "setMealId");
			return (Criteria) this;
		}

		public Criteria andSetMealIdLessThan(Integer value) {
			addCriterion("set_meal_id <", value, "setMealId");
			return (Criteria) this;
		}

		public Criteria andSetMealIdLessThanOrEqualTo(Integer value) {
			addCriterion("set_meal_id <=", value, "setMealId");
			return (Criteria) this;
		}

		public Criteria andSetMealIdIn(List<Integer> values) {
			addCriterion("set_meal_id in", values, "setMealId");
			return (Criteria) this;
		}

		public Criteria andSetMealIdNotIn(List<Integer> values) {
			addCriterion("set_meal_id not in", values, "setMealId");
			return (Criteria) this;
		}

		public Criteria andSetMealIdBetween(Integer value1, Integer value2) {
			addCriterion("set_meal_id between", value1, value2, "setMealId");
			return (Criteria) this;
		}

		public Criteria andSetMealIdNotBetween(Integer value1, Integer value2) {
			addCriterion("set_meal_id not between", value1, value2, "setMealId");
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

		public Criteria andTypeEqualTo(Byte value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Byte value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Byte value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Byte value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Byte value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Byte> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Byte> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Byte value1, Byte value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("type not between", value1, value2, "type");
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

		public Criteria andIsGiftIsNull() {
			addCriterion("is_gift is null");
			return (Criteria) this;
		}

		public Criteria andIsGiftIsNotNull() {
			addCriterion("is_gift is not null");
			return (Criteria) this;
		}

		public Criteria andIsGiftEqualTo(Byte value) {
			addCriterion("is_gift =", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftNotEqualTo(Byte value) {
			addCriterion("is_gift <>", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftGreaterThan(Byte value) {
			addCriterion("is_gift >", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftGreaterThanOrEqualTo(Byte value) {
			addCriterion("is_gift >=", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftLessThan(Byte value) {
			addCriterion("is_gift <", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftLessThanOrEqualTo(Byte value) {
			addCriterion("is_gift <=", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftIn(List<Byte> values) {
			addCriterion("is_gift in", values, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftNotIn(List<Byte> values) {
			addCriterion("is_gift not in", values, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftBetween(Byte value1, Byte value2) {
			addCriterion("is_gift between", value1, value2, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftNotBetween(Byte value1, Byte value2) {
			addCriterion("is_gift not between", value1, value2, "isGift");
			return (Criteria) this;
		}

		public Criteria andBuyNumIsNull() {
			addCriterion("buy_num is null");
			return (Criteria) this;
		}

		public Criteria andBuyNumIsNotNull() {
			addCriterion("buy_num is not null");
			return (Criteria) this;
		}

		public Criteria andBuyNumEqualTo(Integer value) {
			addCriterion("buy_num =", value, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumNotEqualTo(Integer value) {
			addCriterion("buy_num <>", value, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumGreaterThan(Integer value) {
			addCriterion("buy_num >", value, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("buy_num >=", value, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumLessThan(Integer value) {
			addCriterion("buy_num <", value, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumLessThanOrEqualTo(Integer value) {
			addCriterion("buy_num <=", value, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumIn(List<Integer> values) {
			addCriterion("buy_num in", values, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumNotIn(List<Integer> values) {
			addCriterion("buy_num not in", values, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumBetween(Integer value1, Integer value2) {
			addCriterion("buy_num between", value1, value2, "buyNum");
			return (Criteria) this;
		}

		public Criteria andBuyNumNotBetween(Integer value1, Integer value2) {
			addCriterion("buy_num not between", value1, value2, "buyNum");
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

		public Criteria andSumMealPriceIsNull() {
			addCriterion("sum_meal_price is null");
			return (Criteria) this;
		}

		public Criteria andSumMealPriceIsNotNull() {
			addCriterion("sum_meal_price is not null");
			return (Criteria) this;
		}

		public Criteria andSumMealPriceEqualTo(BigDecimal value) {
			addCriterion("sum_meal_price =", value, "sumMealPrice");
			return (Criteria) this;
		}

		public Criteria andSumMealPriceNotEqualTo(BigDecimal value) {
			addCriterion("sum_meal_price <>", value, "sumMealPrice");
			return (Criteria) this;
		}

		public Criteria andSumMealPriceGreaterThan(BigDecimal value) {
			addCriterion("sum_meal_price >", value, "sumMealPrice");
			return (Criteria) this;
		}

		public Criteria andSumMealPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("sum_meal_price >=", value, "sumMealPrice");
			return (Criteria) this;
		}

		public Criteria andSumMealPriceLessThan(BigDecimal value) {
			addCriterion("sum_meal_price <", value, "sumMealPrice");
			return (Criteria) this;
		}

		public Criteria andSumMealPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("sum_meal_price <=", value, "sumMealPrice");
			return (Criteria) this;
		}

		public Criteria andSumMealPriceIn(List<BigDecimal> values) {
			addCriterion("sum_meal_price in", values, "sumMealPrice");
			return (Criteria) this;
		}

		public Criteria andSumMealPriceNotIn(List<BigDecimal> values) {
			addCriterion("sum_meal_price not in", values, "sumMealPrice");
			return (Criteria) this;
		}

		public Criteria andSumMealPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("sum_meal_price between", value1, value2, "sumMealPrice");
			return (Criteria) this;
		}

		public Criteria andSumMealPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("sum_meal_price not between", value1, value2, "sumMealPrice");
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

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Byte value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Byte value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Byte value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Byte value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Byte value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Byte> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Byte> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Byte value1, Byte value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("status not between", value1, value2, "status");
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