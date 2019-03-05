package com.unicdata.entity.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TaskFollowUpExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TaskFollowUpExample() {
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

		public Criteria andOrderStatusIsNull() {
			addCriterion("order_status is null");
			return (Criteria) this;
		}

		public Criteria andOrderStatusIsNotNull() {
			addCriterion("order_status is not null");
			return (Criteria) this;
		}

		public Criteria andOrderStatusEqualTo(Integer value) {
			addCriterion("order_status =", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusNotEqualTo(Integer value) {
			addCriterion("order_status <>", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusGreaterThan(Integer value) {
			addCriterion("order_status >", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_status >=", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusLessThan(Integer value) {
			addCriterion("order_status <", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
			addCriterion("order_status <=", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusIn(List<Integer> values) {
			addCriterion("order_status in", values, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusNotIn(List<Integer> values) {
			addCriterion("order_status not in", values, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
			addCriterion("order_status between", value1, value2, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("order_status not between", value1, value2, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIsNull() {
			addCriterion("customer_id is null");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIsNotNull() {
			addCriterion("customer_id is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerIdEqualTo(Integer value) {
			addCriterion("customer_id =", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotEqualTo(Integer value) {
			addCriterion("customer_id <>", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdGreaterThan(Integer value) {
			addCriterion("customer_id >", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("customer_id >=", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdLessThan(Integer value) {
			addCriterion("customer_id <", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
			addCriterion("customer_id <=", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIn(List<Integer> values) {
			addCriterion("customer_id in", values, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotIn(List<Integer> values) {
			addCriterion("customer_id not in", values, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
			addCriterion("customer_id between", value1, value2, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("customer_id not between", value1, value2, "customerId");
			return (Criteria) this;
		}

		public Criteria andChennelIsNull() {
			addCriterion("chennel is null");
			return (Criteria) this;
		}

		public Criteria andChennelIsNotNull() {
			addCriterion("chennel is not null");
			return (Criteria) this;
		}

		public Criteria andChennelEqualTo(Integer value) {
			addCriterion("chennel =", value, "chennel");
			return (Criteria) this;
		}

		public Criteria andChennelNotEqualTo(Integer value) {
			addCriterion("chennel <>", value, "chennel");
			return (Criteria) this;
		}

		public Criteria andChennelGreaterThan(Integer value) {
			addCriterion("chennel >", value, "chennel");
			return (Criteria) this;
		}

		public Criteria andChennelGreaterThanOrEqualTo(Integer value) {
			addCriterion("chennel >=", value, "chennel");
			return (Criteria) this;
		}

		public Criteria andChennelLessThan(Integer value) {
			addCriterion("chennel <", value, "chennel");
			return (Criteria) this;
		}

		public Criteria andChennelLessThanOrEqualTo(Integer value) {
			addCriterion("chennel <=", value, "chennel");
			return (Criteria) this;
		}

		public Criteria andChennelIn(List<Integer> values) {
			addCriterion("chennel in", values, "chennel");
			return (Criteria) this;
		}

		public Criteria andChennelNotIn(List<Integer> values) {
			addCriterion("chennel not in", values, "chennel");
			return (Criteria) this;
		}

		public Criteria andChennelBetween(Integer value1, Integer value2) {
			addCriterion("chennel between", value1, value2, "chennel");
			return (Criteria) this;
		}

		public Criteria andChennelNotBetween(Integer value1, Integer value2) {
			addCriterion("chennel not between", value1, value2, "chennel");
			return (Criteria) this;
		}

		public Criteria andContentIsNull() {
			addCriterion("content is null");
			return (Criteria) this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("content is not null");
			return (Criteria) this;
		}

		public Criteria andContentEqualTo(Integer value) {
			addCriterion("content =", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotEqualTo(Integer value) {
			addCriterion("content <>", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThan(Integer value) {
			addCriterion("content >", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThanOrEqualTo(Integer value) {
			addCriterion("content >=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThan(Integer value) {
			addCriterion("content <", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThanOrEqualTo(Integer value) {
			addCriterion("content <=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentIn(List<Integer> values) {
			addCriterion("content in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotIn(List<Integer> values) {
			addCriterion("content not in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentBetween(Integer value1, Integer value2) {
			addCriterion("content between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotBetween(Integer value1, Integer value2) {
			addCriterion("content not between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andThisDateIsNull() {
			addCriterion("this_date is null");
			return (Criteria) this;
		}

		public Criteria andThisDateIsNotNull() {
			addCriterion("this_date is not null");
			return (Criteria) this;
		}

		public Criteria andThisDateEqualTo(Date value) {
			addCriterionForJDBCDate("this_date =", value, "thisDate");
			return (Criteria) this;
		}

		public Criteria andThisDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("this_date <>", value, "thisDate");
			return (Criteria) this;
		}

		public Criteria andThisDateGreaterThan(Date value) {
			addCriterionForJDBCDate("this_date >", value, "thisDate");
			return (Criteria) this;
		}

		public Criteria andThisDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("this_date >=", value, "thisDate");
			return (Criteria) this;
		}

		public Criteria andThisDateLessThan(Date value) {
			addCriterionForJDBCDate("this_date <", value, "thisDate");
			return (Criteria) this;
		}

		public Criteria andThisDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("this_date <=", value, "thisDate");
			return (Criteria) this;
		}

		public Criteria andThisDateIn(List<Date> values) {
			addCriterionForJDBCDate("this_date in", values, "thisDate");
			return (Criteria) this;
		}

		public Criteria andThisDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("this_date not in", values, "thisDate");
			return (Criteria) this;
		}

		public Criteria andThisDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("this_date between", value1, value2, "thisDate");
			return (Criteria) this;
		}

		public Criteria andThisDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("this_date not between", value1, value2, "thisDate");
			return (Criteria) this;
		}

		public Criteria andNextDateIsNull() {
			addCriterion("next_date is null");
			return (Criteria) this;
		}

		public Criteria andNextDateIsNotNull() {
			addCriterion("next_date is not null");
			return (Criteria) this;
		}

		public Criteria andNextDateEqualTo(Date value) {
			addCriterionForJDBCDate("next_date =", value, "nextDate");
			return (Criteria) this;
		}

		public Criteria andNextDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("next_date <>", value, "nextDate");
			return (Criteria) this;
		}

		public Criteria andNextDateGreaterThan(Date value) {
			addCriterionForJDBCDate("next_date >", value, "nextDate");
			return (Criteria) this;
		}

		public Criteria andNextDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("next_date >=", value, "nextDate");
			return (Criteria) this;
		}

		public Criteria andNextDateLessThan(Date value) {
			addCriterionForJDBCDate("next_date <", value, "nextDate");
			return (Criteria) this;
		}

		public Criteria andNextDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("next_date <=", value, "nextDate");
			return (Criteria) this;
		}

		public Criteria andNextDateIn(List<Date> values) {
			addCriterionForJDBCDate("next_date in", values, "nextDate");
			return (Criteria) this;
		}

		public Criteria andNextDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("next_date not in", values, "nextDate");
			return (Criteria) this;
		}

		public Criteria andNextDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("next_date between", value1, value2, "nextDate");
			return (Criteria) this;
		}

		public Criteria andNextDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("next_date not between", value1, value2, "nextDate");
			return (Criteria) this;
		}

		public Criteria andNextChennelIsNull() {
			addCriterion("next_chennel is null");
			return (Criteria) this;
		}

		public Criteria andNextChennelIsNotNull() {
			addCriterion("next_chennel is not null");
			return (Criteria) this;
		}

		public Criteria andNextChennelEqualTo(Integer value) {
			addCriterion("next_chennel =", value, "nextChennel");
			return (Criteria) this;
		}

		public Criteria andNextChennelNotEqualTo(Integer value) {
			addCriterion("next_chennel <>", value, "nextChennel");
			return (Criteria) this;
		}

		public Criteria andNextChennelGreaterThan(Integer value) {
			addCriterion("next_chennel >", value, "nextChennel");
			return (Criteria) this;
		}

		public Criteria andNextChennelGreaterThanOrEqualTo(Integer value) {
			addCriterion("next_chennel >=", value, "nextChennel");
			return (Criteria) this;
		}

		public Criteria andNextChennelLessThan(Integer value) {
			addCriterion("next_chennel <", value, "nextChennel");
			return (Criteria) this;
		}

		public Criteria andNextChennelLessThanOrEqualTo(Integer value) {
			addCriterion("next_chennel <=", value, "nextChennel");
			return (Criteria) this;
		}

		public Criteria andNextChennelIn(List<Integer> values) {
			addCriterion("next_chennel in", values, "nextChennel");
			return (Criteria) this;
		}

		public Criteria andNextChennelNotIn(List<Integer> values) {
			addCriterion("next_chennel not in", values, "nextChennel");
			return (Criteria) this;
		}

		public Criteria andNextChennelBetween(Integer value1, Integer value2) {
			addCriterion("next_chennel between", value1, value2, "nextChennel");
			return (Criteria) this;
		}

		public Criteria andNextChennelNotBetween(Integer value1, Integer value2) {
			addCriterion("next_chennel not between", value1, value2, "nextChennel");
			return (Criteria) this;
		}

		public Criteria andNextContentIsNull() {
			addCriterion("next_content is null");
			return (Criteria) this;
		}

		public Criteria andNextContentIsNotNull() {
			addCriterion("next_content is not null");
			return (Criteria) this;
		}

		public Criteria andNextContentEqualTo(Integer value) {
			addCriterion("next_content =", value, "nextContent");
			return (Criteria) this;
		}

		public Criteria andNextContentNotEqualTo(Integer value) {
			addCriterion("next_content <>", value, "nextContent");
			return (Criteria) this;
		}

		public Criteria andNextContentGreaterThan(Integer value) {
			addCriterion("next_content >", value, "nextContent");
			return (Criteria) this;
		}

		public Criteria andNextContentGreaterThanOrEqualTo(Integer value) {
			addCriterion("next_content >=", value, "nextContent");
			return (Criteria) this;
		}

		public Criteria andNextContentLessThan(Integer value) {
			addCriterion("next_content <", value, "nextContent");
			return (Criteria) this;
		}

		public Criteria andNextContentLessThanOrEqualTo(Integer value) {
			addCriterion("next_content <=", value, "nextContent");
			return (Criteria) this;
		}

		public Criteria andNextContentIn(List<Integer> values) {
			addCriterion("next_content in", values, "nextContent");
			return (Criteria) this;
		}

		public Criteria andNextContentNotIn(List<Integer> values) {
			addCriterion("next_content not in", values, "nextContent");
			return (Criteria) this;
		}

		public Criteria andNextContentBetween(Integer value1, Integer value2) {
			addCriterion("next_content between", value1, value2, "nextContent");
			return (Criteria) this;
		}

		public Criteria andNextContentNotBetween(Integer value1, Integer value2) {
			addCriterion("next_content not between", value1, value2, "nextContent");
			return (Criteria) this;
		}

		public Criteria andNextServiceItemIsNull() {
			addCriterion("next_service_item is null");
			return (Criteria) this;
		}

		public Criteria andNextServiceItemIsNotNull() {
			addCriterion("next_service_item is not null");
			return (Criteria) this;
		}

		public Criteria andNextServiceItemEqualTo(Byte value) {
			addCriterion("next_service_item =", value, "nextServiceItem");
			return (Criteria) this;
		}

		public Criteria andNextServiceItemNotEqualTo(Byte value) {
			addCriterion("next_service_item <>", value, "nextServiceItem");
			return (Criteria) this;
		}

		public Criteria andNextServiceItemGreaterThan(Byte value) {
			addCriterion("next_service_item >", value, "nextServiceItem");
			return (Criteria) this;
		}

		public Criteria andNextServiceItemGreaterThanOrEqualTo(Byte value) {
			addCriterion("next_service_item >=", value, "nextServiceItem");
			return (Criteria) this;
		}

		public Criteria andNextServiceItemLessThan(Byte value) {
			addCriterion("next_service_item <", value, "nextServiceItem");
			return (Criteria) this;
		}

		public Criteria andNextServiceItemLessThanOrEqualTo(Byte value) {
			addCriterion("next_service_item <=", value, "nextServiceItem");
			return (Criteria) this;
		}

		public Criteria andNextServiceItemIn(List<Byte> values) {
			addCriterion("next_service_item in", values, "nextServiceItem");
			return (Criteria) this;
		}

		public Criteria andNextServiceItemNotIn(List<Byte> values) {
			addCriterion("next_service_item not in", values, "nextServiceItem");
			return (Criteria) this;
		}

		public Criteria andNextServiceItemBetween(Byte value1, Byte value2) {
			addCriterion("next_service_item between", value1, value2, "nextServiceItem");
			return (Criteria) this;
		}

		public Criteria andNextServiceItemNotBetween(Byte value1, Byte value2) {
			addCriterion("next_service_item not between", value1, value2, "nextServiceItem");
			return (Criteria) this;
		}

		public Criteria andNextRemarkIsNull() {
			addCriterion("next_remark is null");
			return (Criteria) this;
		}

		public Criteria andNextRemarkIsNotNull() {
			addCriterion("next_remark is not null");
			return (Criteria) this;
		}

		public Criteria andNextRemarkEqualTo(String value) {
			addCriterion("next_remark =", value, "nextRemark");
			return (Criteria) this;
		}

		public Criteria andNextRemarkNotEqualTo(String value) {
			addCriterion("next_remark <>", value, "nextRemark");
			return (Criteria) this;
		}

		public Criteria andNextRemarkGreaterThan(String value) {
			addCriterion("next_remark >", value, "nextRemark");
			return (Criteria) this;
		}

		public Criteria andNextRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("next_remark >=", value, "nextRemark");
			return (Criteria) this;
		}

		public Criteria andNextRemarkLessThan(String value) {
			addCriterion("next_remark <", value, "nextRemark");
			return (Criteria) this;
		}

		public Criteria andNextRemarkLessThanOrEqualTo(String value) {
			addCriterion("next_remark <=", value, "nextRemark");
			return (Criteria) this;
		}

		public Criteria andNextRemarkLike(String value) {
			addCriterion("next_remark like", value, "nextRemark");
			return (Criteria) this;
		}

		public Criteria andNextRemarkNotLike(String value) {
			addCriterion("next_remark not like", value, "nextRemark");
			return (Criteria) this;
		}

		public Criteria andNextRemarkIn(List<String> values) {
			addCriterion("next_remark in", values, "nextRemark");
			return (Criteria) this;
		}

		public Criteria andNextRemarkNotIn(List<String> values) {
			addCriterion("next_remark not in", values, "nextRemark");
			return (Criteria) this;
		}

		public Criteria andNextRemarkBetween(String value1, String value2) {
			addCriterion("next_remark between", value1, value2, "nextRemark");
			return (Criteria) this;
		}

		public Criteria andNextRemarkNotBetween(String value1, String value2) {
			addCriterion("next_remark not between", value1, value2, "nextRemark");
			return (Criteria) this;
		}

		public Criteria andCreateIdIsNull() {
			addCriterion("create_id is null");
			return (Criteria) this;
		}

		public Criteria andCreateIdIsNotNull() {
			addCriterion("create_id is not null");
			return (Criteria) this;
		}

		public Criteria andCreateIdEqualTo(Integer value) {
			addCriterion("create_id =", value, "createId");
			return (Criteria) this;
		}

		public Criteria andCreateIdNotEqualTo(Integer value) {
			addCriterion("create_id <>", value, "createId");
			return (Criteria) this;
		}

		public Criteria andCreateIdGreaterThan(Integer value) {
			addCriterion("create_id >", value, "createId");
			return (Criteria) this;
		}

		public Criteria andCreateIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("create_id >=", value, "createId");
			return (Criteria) this;
		}

		public Criteria andCreateIdLessThan(Integer value) {
			addCriterion("create_id <", value, "createId");
			return (Criteria) this;
		}

		public Criteria andCreateIdLessThanOrEqualTo(Integer value) {
			addCriterion("create_id <=", value, "createId");
			return (Criteria) this;
		}

		public Criteria andCreateIdIn(List<Integer> values) {
			addCriterion("create_id in", values, "createId");
			return (Criteria) this;
		}

		public Criteria andCreateIdNotIn(List<Integer> values) {
			addCriterion("create_id not in", values, "createId");
			return (Criteria) this;
		}

		public Criteria andCreateIdBetween(Integer value1, Integer value2) {
			addCriterion("create_id between", value1, value2, "createId");
			return (Criteria) this;
		}

		public Criteria andCreateIdNotBetween(Integer value1, Integer value2) {
			addCriterion("create_id not between", value1, value2, "createId");
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

		public Criteria andDataStatusIsNull() {
			addCriterion("data_status is null");
			return (Criteria) this;
		}

		public Criteria andDataStatusIsNotNull() {
			addCriterion("data_status is not null");
			return (Criteria) this;
		}

		public Criteria andDataStatusEqualTo(Byte value) {
			addCriterion("data_status =", value, "dataStatus");
			return (Criteria) this;
		}

		public Criteria andDataStatusNotEqualTo(Byte value) {
			addCriterion("data_status <>", value, "dataStatus");
			return (Criteria) this;
		}

		public Criteria andDataStatusGreaterThan(Byte value) {
			addCriterion("data_status >", value, "dataStatus");
			return (Criteria) this;
		}

		public Criteria andDataStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("data_status >=", value, "dataStatus");
			return (Criteria) this;
		}

		public Criteria andDataStatusLessThan(Byte value) {
			addCriterion("data_status <", value, "dataStatus");
			return (Criteria) this;
		}

		public Criteria andDataStatusLessThanOrEqualTo(Byte value) {
			addCriterion("data_status <=", value, "dataStatus");
			return (Criteria) this;
		}

		public Criteria andDataStatusIn(List<Byte> values) {
			addCriterion("data_status in", values, "dataStatus");
			return (Criteria) this;
		}

		public Criteria andDataStatusNotIn(List<Byte> values) {
			addCriterion("data_status not in", values, "dataStatus");
			return (Criteria) this;
		}

		public Criteria andDataStatusBetween(Byte value1, Byte value2) {
			addCriterion("data_status between", value1, value2, "dataStatus");
			return (Criteria) this;
		}

		public Criteria andDataStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("data_status not between", value1, value2, "dataStatus");
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