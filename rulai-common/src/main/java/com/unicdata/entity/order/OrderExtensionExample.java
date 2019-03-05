package com.unicdata.entity.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.math.BigDecimal;

public class OrderExtensionExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderExtensionExample() {
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

		public Criteria andExtensionIdIsNull() {
			addCriterion("extension_id is null");
			return (Criteria) this;
		}

		public Criteria andExtensionIdIsNotNull() {
			addCriterion("extension_id is not null");
			return (Criteria) this;
		}

		public Criteria andExtensionIdEqualTo(Integer value) {
			addCriterion("extension_id =", value, "extensionId");
			return (Criteria) this;
		}

		public Criteria andExtensionIdNotEqualTo(Integer value) {
			addCriterion("extension_id <>", value, "extensionId");
			return (Criteria) this;
		}

		public Criteria andExtensionIdGreaterThan(Integer value) {
			addCriterion("extension_id >", value, "extensionId");
			return (Criteria) this;
		}

		public Criteria andExtensionIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("extension_id >=", value, "extensionId");
			return (Criteria) this;
		}

		public Criteria andExtensionIdLessThan(Integer value) {
			addCriterion("extension_id <", value, "extensionId");
			return (Criteria) this;
		}

		public Criteria andExtensionIdLessThanOrEqualTo(Integer value) {
			addCriterion("extension_id <=", value, "extensionId");
			return (Criteria) this;
		}

		public Criteria andExtensionIdIn(List<Integer> values) {
			addCriterion("extension_id in", values, "extensionId");
			return (Criteria) this;
		}

		public Criteria andExtensionIdNotIn(List<Integer> values) {
			addCriterion("extension_id not in", values, "extensionId");
			return (Criteria) this;
		}

		public Criteria andExtensionIdBetween(Integer value1, Integer value2) {
			addCriterion("extension_id between", value1, value2, "extensionId");
			return (Criteria) this;
		}

		public Criteria andExtensionIdNotBetween(Integer value1, Integer value2) {
			addCriterion("extension_id not between", value1, value2, "extensionId");
			return (Criteria) this;
		}

		public Criteria andSumPriceIsNull() {
			addCriterion("sum_price is null");
			return (Criteria) this;
		}

		public Criteria andSumPriceIsNotNull() {
			addCriterion("sum_price is not null");
			return (Criteria) this;
		}

		public Criteria andSumPriceEqualTo(BigDecimal value) {
			addCriterion("sum_price =", value, "sumPrice");
			return (Criteria) this;
		}

		public Criteria andSumPriceNotEqualTo(BigDecimal value) {
			addCriterion("sum_price <>", value, "sumPrice");
			return (Criteria) this;
		}

		public Criteria andSumPriceGreaterThan(BigDecimal value) {
			addCriterion("sum_price >", value, "sumPrice");
			return (Criteria) this;
		}

		public Criteria andSumPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("sum_price >=", value, "sumPrice");
			return (Criteria) this;
		}

		public Criteria andSumPriceLessThan(BigDecimal value) {
			addCriterion("sum_price <", value, "sumPrice");
			return (Criteria) this;
		}

		public Criteria andSumPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("sum_price <=", value, "sumPrice");
			return (Criteria) this;
		}

		public Criteria andSumPriceIn(List<BigDecimal> values) {
			addCriterion("sum_price in", values, "sumPrice");
			return (Criteria) this;
		}

		public Criteria andSumPriceNotIn(List<BigDecimal> values) {
			addCriterion("sum_price not in", values, "sumPrice");
			return (Criteria) this;
		}

		public Criteria andSumPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("sum_price between", value1, value2, "sumPrice");
			return (Criteria) this;
		}

		public Criteria andSumPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("sum_price not between", value1, value2, "sumPrice");
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