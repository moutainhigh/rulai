package com.unicdata.entity.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderQuotedPriceExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderQuotedPriceExample() {
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

		public Criteria andBoutiqueOrderIdIsNull() {
			addCriterion("boutique_order_id is null");
			return (Criteria) this;
		}

		public Criteria andBoutiqueOrderIdIsNotNull() {
			addCriterion("boutique_order_id is not null");
			return (Criteria) this;
		}

		public Criteria andBoutiqueOrderIdEqualTo(Integer value) {
			addCriterion("boutique_order_id =", value, "boutiqueOrderId");
			return (Criteria) this;
		}

		public Criteria andBoutiqueOrderIdNotEqualTo(Integer value) {
			addCriterion("boutique_order_id <>", value, "boutiqueOrderId");
			return (Criteria) this;
		}

		public Criteria andBoutiqueOrderIdGreaterThan(Integer value) {
			addCriterion("boutique_order_id >", value, "boutiqueOrderId");
			return (Criteria) this;
		}

		public Criteria andBoutiqueOrderIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("boutique_order_id >=", value, "boutiqueOrderId");
			return (Criteria) this;
		}

		public Criteria andBoutiqueOrderIdLessThan(Integer value) {
			addCriterion("boutique_order_id <", value, "boutiqueOrderId");
			return (Criteria) this;
		}

		public Criteria andBoutiqueOrderIdLessThanOrEqualTo(Integer value) {
			addCriterion("boutique_order_id <=", value, "boutiqueOrderId");
			return (Criteria) this;
		}

		public Criteria andBoutiqueOrderIdIn(List<Integer> values) {
			addCriterion("boutique_order_id in", values, "boutiqueOrderId");
			return (Criteria) this;
		}

		public Criteria andBoutiqueOrderIdNotIn(List<Integer> values) {
			addCriterion("boutique_order_id not in", values, "boutiqueOrderId");
			return (Criteria) this;
		}

		public Criteria andBoutiqueOrderIdBetween(Integer value1, Integer value2) {
			addCriterion("boutique_order_id between", value1, value2, "boutiqueOrderId");
			return (Criteria) this;
		}

		public Criteria andBoutiqueOrderIdNotBetween(Integer value1, Integer value2) {
			addCriterion("boutique_order_id not between", value1, value2, "boutiqueOrderId");
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

		public Criteria andVehicleNameIsNull() {
			addCriterion("vehicle_name is null");
			return (Criteria) this;
		}

		public Criteria andVehicleNameIsNotNull() {
			addCriterion("vehicle_name is not null");
			return (Criteria) this;
		}

		public Criteria andVehicleNameEqualTo(String value) {
			addCriterion("vehicle_name =", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameNotEqualTo(String value) {
			addCriterion("vehicle_name <>", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameGreaterThan(String value) {
			addCriterion("vehicle_name >", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameGreaterThanOrEqualTo(String value) {
			addCriterion("vehicle_name >=", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameLessThan(String value) {
			addCriterion("vehicle_name <", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameLessThanOrEqualTo(String value) {
			addCriterion("vehicle_name <=", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameLike(String value) {
			addCriterion("vehicle_name like", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameNotLike(String value) {
			addCriterion("vehicle_name not like", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameIn(List<String> values) {
			addCriterion("vehicle_name in", values, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameNotIn(List<String> values) {
			addCriterion("vehicle_name not in", values, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameBetween(String value1, String value2) {
			addCriterion("vehicle_name between", value1, value2, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameNotBetween(String value1, String value2) {
			addCriterion("vehicle_name not between", value1, value2, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehiclePriceIsNull() {
			addCriterion("vehicle_price is null");
			return (Criteria) this;
		}

		public Criteria andVehiclePriceIsNotNull() {
			addCriterion("vehicle_price is not null");
			return (Criteria) this;
		}

		public Criteria andVehiclePriceEqualTo(BigDecimal value) {
			addCriterion("vehicle_price =", value, "vehiclePrice");
			return (Criteria) this;
		}

		public Criteria andVehiclePriceNotEqualTo(BigDecimal value) {
			addCriterion("vehicle_price <>", value, "vehiclePrice");
			return (Criteria) this;
		}

		public Criteria andVehiclePriceGreaterThan(BigDecimal value) {
			addCriterion("vehicle_price >", value, "vehiclePrice");
			return (Criteria) this;
		}

		public Criteria andVehiclePriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("vehicle_price >=", value, "vehiclePrice");
			return (Criteria) this;
		}

		public Criteria andVehiclePriceLessThan(BigDecimal value) {
			addCriterion("vehicle_price <", value, "vehiclePrice");
			return (Criteria) this;
		}

		public Criteria andVehiclePriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("vehicle_price <=", value, "vehiclePrice");
			return (Criteria) this;
		}

		public Criteria andVehiclePriceIn(List<BigDecimal> values) {
			addCriterion("vehicle_price in", values, "vehiclePrice");
			return (Criteria) this;
		}

		public Criteria andVehiclePriceNotIn(List<BigDecimal> values) {
			addCriterion("vehicle_price not in", values, "vehiclePrice");
			return (Criteria) this;
		}

		public Criteria andVehiclePriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("vehicle_price between", value1, value2, "vehiclePrice");
			return (Criteria) this;
		}

		public Criteria andVehiclePriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("vehicle_price not between", value1, value2, "vehiclePrice");
			return (Criteria) this;
		}

		public Criteria andBoutiquePriceIsNull() {
			addCriterion("boutique_price is null");
			return (Criteria) this;
		}

		public Criteria andBoutiquePriceIsNotNull() {
			addCriterion("boutique_price is not null");
			return (Criteria) this;
		}

		public Criteria andBoutiquePriceEqualTo(BigDecimal value) {
			addCriterion("boutique_price =", value, "boutiquePrice");
			return (Criteria) this;
		}

		public Criteria andBoutiquePriceNotEqualTo(BigDecimal value) {
			addCriterion("boutique_price <>", value, "boutiquePrice");
			return (Criteria) this;
		}

		public Criteria andBoutiquePriceGreaterThan(BigDecimal value) {
			addCriterion("boutique_price >", value, "boutiquePrice");
			return (Criteria) this;
		}

		public Criteria andBoutiquePriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("boutique_price >=", value, "boutiquePrice");
			return (Criteria) this;
		}

		public Criteria andBoutiquePriceLessThan(BigDecimal value) {
			addCriterion("boutique_price <", value, "boutiquePrice");
			return (Criteria) this;
		}

		public Criteria andBoutiquePriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("boutique_price <=", value, "boutiquePrice");
			return (Criteria) this;
		}

		public Criteria andBoutiquePriceIn(List<BigDecimal> values) {
			addCriterion("boutique_price in", values, "boutiquePrice");
			return (Criteria) this;
		}

		public Criteria andBoutiquePriceNotIn(List<BigDecimal> values) {
			addCriterion("boutique_price not in", values, "boutiquePrice");
			return (Criteria) this;
		}

		public Criteria andBoutiquePriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("boutique_price between", value1, value2, "boutiquePrice");
			return (Criteria) this;
		}

		public Criteria andBoutiquePriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("boutique_price not between", value1, value2, "boutiquePrice");
			return (Criteria) this;
		}

		public Criteria andOrderSumPriceIsNull() {
			addCriterion("order_sum_price is null");
			return (Criteria) this;
		}

		public Criteria andOrderSumPriceIsNotNull() {
			addCriterion("order_sum_price is not null");
			return (Criteria) this;
		}

		public Criteria andOrderSumPriceEqualTo(BigDecimal value) {
			addCriterion("order_sum_price =", value, "orderSumPrice");
			return (Criteria) this;
		}

		public Criteria andOrderSumPriceNotEqualTo(BigDecimal value) {
			addCriterion("order_sum_price <>", value, "orderSumPrice");
			return (Criteria) this;
		}

		public Criteria andOrderSumPriceGreaterThan(BigDecimal value) {
			addCriterion("order_sum_price >", value, "orderSumPrice");
			return (Criteria) this;
		}

		public Criteria andOrderSumPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("order_sum_price >=", value, "orderSumPrice");
			return (Criteria) this;
		}

		public Criteria andOrderSumPriceLessThan(BigDecimal value) {
			addCriterion("order_sum_price <", value, "orderSumPrice");
			return (Criteria) this;
		}

		public Criteria andOrderSumPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("order_sum_price <=", value, "orderSumPrice");
			return (Criteria) this;
		}

		public Criteria andOrderSumPriceIn(List<BigDecimal> values) {
			addCriterion("order_sum_price in", values, "orderSumPrice");
			return (Criteria) this;
		}

		public Criteria andOrderSumPriceNotIn(List<BigDecimal> values) {
			addCriterion("order_sum_price not in", values, "orderSumPrice");
			return (Criteria) this;
		}

		public Criteria andOrderSumPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("order_sum_price between", value1, value2, "orderSumPrice");
			return (Criteria) this;
		}

		public Criteria andOrderSumPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("order_sum_price not between", value1, value2, "orderSumPrice");
			return (Criteria) this;
		}

		public Criteria andPayFirstIsNull() {
			addCriterion("pay_first is null");
			return (Criteria) this;
		}

		public Criteria andPayFirstIsNotNull() {
			addCriterion("pay_first is not null");
			return (Criteria) this;
		}

		public Criteria andPayFirstEqualTo(BigDecimal value) {
			addCriterion("pay_first =", value, "payFirst");
			return (Criteria) this;
		}

		public Criteria andPayFirstNotEqualTo(BigDecimal value) {
			addCriterion("pay_first <>", value, "payFirst");
			return (Criteria) this;
		}

		public Criteria andPayFirstGreaterThan(BigDecimal value) {
			addCriterion("pay_first >", value, "payFirst");
			return (Criteria) this;
		}

		public Criteria andPayFirstGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("pay_first >=", value, "payFirst");
			return (Criteria) this;
		}

		public Criteria andPayFirstLessThan(BigDecimal value) {
			addCriterion("pay_first <", value, "payFirst");
			return (Criteria) this;
		}

		public Criteria andPayFirstLessThanOrEqualTo(BigDecimal value) {
			addCriterion("pay_first <=", value, "payFirst");
			return (Criteria) this;
		}

		public Criteria andPayFirstIn(List<BigDecimal> values) {
			addCriterion("pay_first in", values, "payFirst");
			return (Criteria) this;
		}

		public Criteria andPayFirstNotIn(List<BigDecimal> values) {
			addCriterion("pay_first not in", values, "payFirst");
			return (Criteria) this;
		}

		public Criteria andPayFirstBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("pay_first between", value1, value2, "payFirst");
			return (Criteria) this;
		}

		public Criteria andPayFirstNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("pay_first not between", value1, value2, "payFirst");
			return (Criteria) this;
		}

		public Criteria andProfitIsNull() {
			addCriterion("profit is null");
			return (Criteria) this;
		}

		public Criteria andProfitIsNotNull() {
			addCriterion("profit is not null");
			return (Criteria) this;
		}

		public Criteria andProfitEqualTo(BigDecimal value) {
			addCriterion("profit =", value, "profit");
			return (Criteria) this;
		}

		public Criteria andProfitNotEqualTo(BigDecimal value) {
			addCriterion("profit <>", value, "profit");
			return (Criteria) this;
		}

		public Criteria andProfitGreaterThan(BigDecimal value) {
			addCriterion("profit >", value, "profit");
			return (Criteria) this;
		}

		public Criteria andProfitGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("profit >=", value, "profit");
			return (Criteria) this;
		}

		public Criteria andProfitLessThan(BigDecimal value) {
			addCriterion("profit <", value, "profit");
			return (Criteria) this;
		}

		public Criteria andProfitLessThanOrEqualTo(BigDecimal value) {
			addCriterion("profit <=", value, "profit");
			return (Criteria) this;
		}

		public Criteria andProfitIn(List<BigDecimal> values) {
			addCriterion("profit in", values, "profit");
			return (Criteria) this;
		}

		public Criteria andProfitNotIn(List<BigDecimal> values) {
			addCriterion("profit not in", values, "profit");
			return (Criteria) this;
		}

		public Criteria andProfitBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("profit between", value1, value2, "profit");
			return (Criteria) this;
		}

		public Criteria andProfitNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("profit not between", value1, value2, "profit");
			return (Criteria) this;
		}

		public Criteria andApplyTimeIsNull() {
			addCriterion("apply_time is null");
			return (Criteria) this;
		}

		public Criteria andApplyTimeIsNotNull() {
			addCriterion("apply_time is not null");
			return (Criteria) this;
		}

		public Criteria andApplyTimeEqualTo(Date value) {
			addCriterion("apply_time =", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeNotEqualTo(Date value) {
			addCriterion("apply_time <>", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeGreaterThan(Date value) {
			addCriterion("apply_time >", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("apply_time >=", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeLessThan(Date value) {
			addCriterion("apply_time <", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
			addCriterion("apply_time <=", value, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeIn(List<Date> values) {
			addCriterion("apply_time in", values, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeNotIn(List<Date> values) {
			addCriterion("apply_time not in", values, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeBetween(Date value1, Date value2) {
			addCriterion("apply_time between", value1, value2, "applyTime");
			return (Criteria) this;
		}

		public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
			addCriterion("apply_time not between", value1, value2, "applyTime");
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

		public Criteria andCreatTimeIsNull() {
			addCriterion("creat_time is null");
			return (Criteria) this;
		}

		public Criteria andCreatTimeIsNotNull() {
			addCriterion("creat_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreatTimeEqualTo(Date value) {
			addCriterion("creat_time =", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeNotEqualTo(Date value) {
			addCriterion("creat_time <>", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeGreaterThan(Date value) {
			addCriterion("creat_time >", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("creat_time >=", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeLessThan(Date value) {
			addCriterion("creat_time <", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
			addCriterion("creat_time <=", value, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeIn(List<Date> values) {
			addCriterion("creat_time in", values, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeNotIn(List<Date> values) {
			addCriterion("creat_time not in", values, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeBetween(Date value1, Date value2) {
			addCriterion("creat_time between", value1, value2, "creatTime");
			return (Criteria) this;
		}

		public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
			addCriterion("creat_time not between", value1, value2, "creatTime");
			return (Criteria) this;
		}

		public Criteria andVehicleIdIsNull() {
			addCriterion("vehicle_id is null");
			return (Criteria) this;
		}

		public Criteria andVehicleIdIsNotNull() {
			addCriterion("vehicle_id is not null");
			return (Criteria) this;
		}

		public Criteria andVehicleIdEqualTo(Integer value) {
			addCriterion("vehicle_id =", value, "vehicleId");
			return (Criteria) this;
		}

		public Criteria andVehicleIdNotEqualTo(Integer value) {
			addCriterion("vehicle_id <>", value, "vehicleId");
			return (Criteria) this;
		}

		public Criteria andVehicleIdGreaterThan(Integer value) {
			addCriterion("vehicle_id >", value, "vehicleId");
			return (Criteria) this;
		}

		public Criteria andVehicleIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("vehicle_id >=", value, "vehicleId");
			return (Criteria) this;
		}

		public Criteria andVehicleIdLessThan(Integer value) {
			addCriterion("vehicle_id <", value, "vehicleId");
			return (Criteria) this;
		}

		public Criteria andVehicleIdLessThanOrEqualTo(Integer value) {
			addCriterion("vehicle_id <=", value, "vehicleId");
			return (Criteria) this;
		}

		public Criteria andVehicleIdIn(List<Integer> values) {
			addCriterion("vehicle_id in", values, "vehicleId");
			return (Criteria) this;
		}

		public Criteria andVehicleIdNotIn(List<Integer> values) {
			addCriterion("vehicle_id not in", values, "vehicleId");
			return (Criteria) this;
		}

		public Criteria andVehicleIdBetween(Integer value1, Integer value2) {
			addCriterion("vehicle_id between", value1, value2, "vehicleId");
			return (Criteria) this;
		}

		public Criteria andVehicleIdNotBetween(Integer value1, Integer value2) {
			addCriterion("vehicle_id not between", value1, value2, "vehicleId");
			return (Criteria) this;
		}

		public Criteria andCusIdIsNull() {
			addCriterion("cus_id is null");
			return (Criteria) this;
		}

		public Criteria andCusIdIsNotNull() {
			addCriterion("cus_id is not null");
			return (Criteria) this;
		}

		public Criteria andCusIdEqualTo(Integer value) {
			addCriterion("cus_id =", value, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdNotEqualTo(Integer value) {
			addCriterion("cus_id <>", value, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdGreaterThan(Integer value) {
			addCriterion("cus_id >", value, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("cus_id >=", value, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdLessThan(Integer value) {
			addCriterion("cus_id <", value, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdLessThanOrEqualTo(Integer value) {
			addCriterion("cus_id <=", value, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdIn(List<Integer> values) {
			addCriterion("cus_id in", values, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdNotIn(List<Integer> values) {
			addCriterion("cus_id not in", values, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdBetween(Integer value1, Integer value2) {
			addCriterion("cus_id between", value1, value2, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdNotBetween(Integer value1, Integer value2) {
			addCriterion("cus_id not between", value1, value2, "cusId");
			return (Criteria) this;
		}

		public Criteria andQuotedStatusIsNull() {
			addCriterion("quoted_status is null");
			return (Criteria) this;
		}

		public Criteria andQuotedStatusIsNotNull() {
			addCriterion("quoted_status is not null");
			return (Criteria) this;
		}

		public Criteria andQuotedStatusEqualTo(Byte value) {
			addCriterion("quoted_status =", value, "quotedStatus");
			return (Criteria) this;
		}

		public Criteria andQuotedStatusNotEqualTo(Byte value) {
			addCriterion("quoted_status <>", value, "quotedStatus");
			return (Criteria) this;
		}

		public Criteria andQuotedStatusGreaterThan(Byte value) {
			addCriterion("quoted_status >", value, "quotedStatus");
			return (Criteria) this;
		}

		public Criteria andQuotedStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("quoted_status >=", value, "quotedStatus");
			return (Criteria) this;
		}

		public Criteria andQuotedStatusLessThan(Byte value) {
			addCriterion("quoted_status <", value, "quotedStatus");
			return (Criteria) this;
		}

		public Criteria andQuotedStatusLessThanOrEqualTo(Byte value) {
			addCriterion("quoted_status <=", value, "quotedStatus");
			return (Criteria) this;
		}

		public Criteria andQuotedStatusIn(List<Byte> values) {
			addCriterion("quoted_status in", values, "quotedStatus");
			return (Criteria) this;
		}

		public Criteria andQuotedStatusNotIn(List<Byte> values) {
			addCriterion("quoted_status not in", values, "quotedStatus");
			return (Criteria) this;
		}

		public Criteria andQuotedStatusBetween(Byte value1, Byte value2) {
			addCriterion("quoted_status between", value1, value2, "quotedStatus");
			return (Criteria) this;
		}

		public Criteria andQuotedStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("quoted_status not between", value1, value2, "quotedStatus");
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