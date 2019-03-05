package com.unicdata.entity.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(String value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLike(String value) {
            addCriterion("order_num like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotLike(String value) {
            addCriterion("order_num not like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
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

        public Criteria andCusNameIsNull() {
            addCriterion("cus_name is null");
            return (Criteria) this;
        }

        public Criteria andCusNameIsNotNull() {
            addCriterion("cus_name is not null");
            return (Criteria) this;
        }

        public Criteria andCusNameEqualTo(String value) {
            addCriterion("cus_name =", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotEqualTo(String value) {
            addCriterion("cus_name <>", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameGreaterThan(String value) {
            addCriterion("cus_name >", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameGreaterThanOrEqualTo(String value) {
            addCriterion("cus_name >=", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameLessThan(String value) {
            addCriterion("cus_name <", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameLessThanOrEqualTo(String value) {
            addCriterion("cus_name <=", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameLike(String value) {
            addCriterion("cus_name like", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotLike(String value) {
            addCriterion("cus_name not like", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameIn(List<String> values) {
            addCriterion("cus_name in", values, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotIn(List<String> values) {
            addCriterion("cus_name not in", values, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameBetween(String value1, String value2) {
            addCriterion("cus_name between", value1, value2, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotBetween(String value1, String value2) {
            addCriterion("cus_name not between", value1, value2, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusIphoneIsNull() {
            addCriterion("cus_iphone is null");
            return (Criteria) this;
        }

        public Criteria andCusIphoneIsNotNull() {
            addCriterion("cus_iphone is not null");
            return (Criteria) this;
        }

        public Criteria andCusIphoneEqualTo(String value) {
            addCriterion("cus_iphone =", value, "cusIphone");
            return (Criteria) this;
        }

        public Criteria andCusIphoneNotEqualTo(String value) {
            addCriterion("cus_iphone <>", value, "cusIphone");
            return (Criteria) this;
        }

        public Criteria andCusIphoneGreaterThan(String value) {
            addCriterion("cus_iphone >", value, "cusIphone");
            return (Criteria) this;
        }

        public Criteria andCusIphoneGreaterThanOrEqualTo(String value) {
            addCriterion("cus_iphone >=", value, "cusIphone");
            return (Criteria) this;
        }

        public Criteria andCusIphoneLessThan(String value) {
            addCriterion("cus_iphone <", value, "cusIphone");
            return (Criteria) this;
        }

        public Criteria andCusIphoneLessThanOrEqualTo(String value) {
            addCriterion("cus_iphone <=", value, "cusIphone");
            return (Criteria) this;
        }

        public Criteria andCusIphoneLike(String value) {
            addCriterion("cus_iphone like", value, "cusIphone");
            return (Criteria) this;
        }

        public Criteria andCusIphoneNotLike(String value) {
            addCriterion("cus_iphone not like", value, "cusIphone");
            return (Criteria) this;
        }

        public Criteria andCusIphoneIn(List<String> values) {
            addCriterion("cus_iphone in", values, "cusIphone");
            return (Criteria) this;
        }

        public Criteria andCusIphoneNotIn(List<String> values) {
            addCriterion("cus_iphone not in", values, "cusIphone");
            return (Criteria) this;
        }

        public Criteria andCusIphoneBetween(String value1, String value2) {
            addCriterion("cus_iphone between", value1, value2, "cusIphone");
            return (Criteria) this;
        }

        public Criteria andCusIphoneNotBetween(String value1, String value2) {
            addCriterion("cus_iphone not between", value1, value2, "cusIphone");
            return (Criteria) this;
        }

        public Criteria andUseNameIsNull() {
            addCriterion("use_name is null");
            return (Criteria) this;
        }

        public Criteria andUseNameIsNotNull() {
            addCriterion("use_name is not null");
            return (Criteria) this;
        }

        public Criteria andUseNameEqualTo(String value) {
            addCriterion("use_name =", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameNotEqualTo(String value) {
            addCriterion("use_name <>", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameGreaterThan(String value) {
            addCriterion("use_name >", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameGreaterThanOrEqualTo(String value) {
            addCriterion("use_name >=", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameLessThan(String value) {
            addCriterion("use_name <", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameLessThanOrEqualTo(String value) {
            addCriterion("use_name <=", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameLike(String value) {
            addCriterion("use_name like", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameNotLike(String value) {
            addCriterion("use_name not like", value, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameIn(List<String> values) {
            addCriterion("use_name in", values, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameNotIn(List<String> values) {
            addCriterion("use_name not in", values, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameBetween(String value1, String value2) {
            addCriterion("use_name between", value1, value2, "useName");
            return (Criteria) this;
        }

        public Criteria andUseNameNotBetween(String value1, String value2) {
            addCriterion("use_name not between", value1, value2, "useName");
            return (Criteria) this;
        }

        public Criteria andUseIphoneIsNull() {
            addCriterion("use_iphone is null");
            return (Criteria) this;
        }

        public Criteria andUseIphoneIsNotNull() {
            addCriterion("use_iphone is not null");
            return (Criteria) this;
        }

        public Criteria andUseIphoneEqualTo(String value) {
            addCriterion("use_iphone =", value, "useIphone");
            return (Criteria) this;
        }

        public Criteria andUseIphoneNotEqualTo(String value) {
            addCriterion("use_iphone <>", value, "useIphone");
            return (Criteria) this;
        }

        public Criteria andUseIphoneGreaterThan(String value) {
            addCriterion("use_iphone >", value, "useIphone");
            return (Criteria) this;
        }

        public Criteria andUseIphoneGreaterThanOrEqualTo(String value) {
            addCriterion("use_iphone >=", value, "useIphone");
            return (Criteria) this;
        }

        public Criteria andUseIphoneLessThan(String value) {
            addCriterion("use_iphone <", value, "useIphone");
            return (Criteria) this;
        }

        public Criteria andUseIphoneLessThanOrEqualTo(String value) {
            addCriterion("use_iphone <=", value, "useIphone");
            return (Criteria) this;
        }

        public Criteria andUseIphoneLike(String value) {
            addCriterion("use_iphone like", value, "useIphone");
            return (Criteria) this;
        }

        public Criteria andUseIphoneNotLike(String value) {
            addCriterion("use_iphone not like", value, "useIphone");
            return (Criteria) this;
        }

        public Criteria andUseIphoneIn(List<String> values) {
            addCriterion("use_iphone in", values, "useIphone");
            return (Criteria) this;
        }

        public Criteria andUseIphoneNotIn(List<String> values) {
            addCriterion("use_iphone not in", values, "useIphone");
            return (Criteria) this;
        }

        public Criteria andUseIphoneBetween(String value1, String value2) {
            addCriterion("use_iphone between", value1, value2, "useIphone");
            return (Criteria) this;
        }

        public Criteria andUseIphoneNotBetween(String value1, String value2) {
            addCriterion("use_iphone not between", value1, value2, "useIphone");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNull() {
            addCriterion("use_type is null");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNotNull() {
            addCriterion("use_type is not null");
            return (Criteria) this;
        }

        public Criteria andUseTypeEqualTo(Byte value) {
            addCriterion("use_type =", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotEqualTo(Byte value) {
            addCriterion("use_type <>", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThan(Byte value) {
            addCriterion("use_type >", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("use_type >=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThan(Byte value) {
            addCriterion("use_type <", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThanOrEqualTo(Byte value) {
            addCriterion("use_type <=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeIn(List<Byte> values) {
            addCriterion("use_type in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotIn(List<Byte> values) {
            addCriterion("use_type not in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeBetween(Byte value1, Byte value2) {
            addCriterion("use_type between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("use_type not between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(Byte value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(Byte value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(Byte value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(Byte value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(Byte value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<Byte> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<Byte> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(Byte value1, Byte value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
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

        public Criteria andDeliveryDateIsNull() {
            addCriterion("delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNotNull() {
            addCriterion("delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateEqualTo(Date value) {
            addCriterionForJDBCDate("delivery_date =", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("delivery_date <>", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThan(Date value) {
            addCriterionForJDBCDate("delivery_date >", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("delivery_date >=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThan(Date value) {
            addCriterionForJDBCDate("delivery_date <", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("delivery_date <=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIn(List<Date> values) {
            addCriterionForJDBCDate("delivery_date in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("delivery_date not in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("delivery_date between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("delivery_date not between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Integer value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Integer value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Integer value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Integer value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Integer> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Integer> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Integer value1, Integer value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andMatchingCarIdIsNull() {
            addCriterion("matching_car_id is null");
            return (Criteria) this;
        }

        public Criteria andMatchingCarIdIsNotNull() {
            addCriterion("matching_car_id is not null");
            return (Criteria) this;
        }

        public Criteria andMatchingCarIdEqualTo(Integer value) {
            addCriterion("matching_car_id =", value, "matchingCarId");
            return (Criteria) this;
        }

        public Criteria andMatchingCarIdNotEqualTo(Integer value) {
            addCriterion("matching_car_id <>", value, "matchingCarId");
            return (Criteria) this;
        }

        public Criteria andMatchingCarIdGreaterThan(Integer value) {
            addCriterion("matching_car_id >", value, "matchingCarId");
            return (Criteria) this;
        }

        public Criteria andMatchingCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("matching_car_id >=", value, "matchingCarId");
            return (Criteria) this;
        }

        public Criteria andMatchingCarIdLessThan(Integer value) {
            addCriterion("matching_car_id <", value, "matchingCarId");
            return (Criteria) this;
        }

        public Criteria andMatchingCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("matching_car_id <=", value, "matchingCarId");
            return (Criteria) this;
        }

        public Criteria andMatchingCarIdIn(List<Integer> values) {
            addCriterion("matching_car_id in", values, "matchingCarId");
            return (Criteria) this;
        }

        public Criteria andMatchingCarIdNotIn(List<Integer> values) {
            addCriterion("matching_car_id not in", values, "matchingCarId");
            return (Criteria) this;
        }

        public Criteria andMatchingCarIdBetween(Integer value1, Integer value2) {
            addCriterion("matching_car_id between", value1, value2, "matchingCarId");
            return (Criteria) this;
        }

        public Criteria andMatchingCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("matching_car_id not between", value1, value2, "matchingCarId");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNull() {
            addCriterion("sale_price is null");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNotNull() {
            addCriterion("sale_price is not null");
            return (Criteria) this;
        }

        public Criteria andSalePriceEqualTo(BigDecimal value) {
            addCriterion("sale_price =", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("sale_price <>", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThan(BigDecimal value) {
            addCriterion("sale_price >", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price >=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThan(BigDecimal value) {
            addCriterion("sale_price <", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price <=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceIn(List<BigDecimal> values) {
            addCriterion("sale_price in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("sale_price not in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price not between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIsNull() {
            addCriterion("purchase_price is null");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIsNotNull() {
            addCriterion("purchase_price is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceEqualTo(BigDecimal value) {
            addCriterion("purchase_price =", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotEqualTo(BigDecimal value) {
            addCriterion("purchase_price <>", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceGreaterThan(BigDecimal value) {
            addCriterion("purchase_price >", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_price >=", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceLessThan(BigDecimal value) {
            addCriterion("purchase_price <", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_price <=", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIn(List<BigDecimal> values) {
            addCriterion("purchase_price in", values, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotIn(List<BigDecimal> values) {
            addCriterion("purchase_price not in", values, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_price between", value1, value2, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_price not between", value1, value2, "purchasePrice");
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

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andDepositIsNull() {
            addCriterion("deposit is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("deposit is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(BigDecimal value) {
            addCriterion("deposit =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(BigDecimal value) {
            addCriterion("deposit <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(BigDecimal value) {
            addCriterion("deposit >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(BigDecimal value) {
            addCriterion("deposit <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<BigDecimal> values) {
            addCriterion("deposit in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<BigDecimal> values) {
            addCriterion("deposit not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit not between", value1, value2, "deposit");
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

        public Criteria andCarPriceStatusIsNull() {
            addCriterion("car_price_status is null");
            return (Criteria) this;
        }

        public Criteria andCarPriceStatusIsNotNull() {
            addCriterion("car_price_status is not null");
            return (Criteria) this;
        }

        public Criteria andCarPriceStatusEqualTo(Byte value) {
            addCriterion("car_price_status =", value, "carPriceStatus");
            return (Criteria) this;
        }

        public Criteria andCarPriceStatusNotEqualTo(Byte value) {
            addCriterion("car_price_status <>", value, "carPriceStatus");
            return (Criteria) this;
        }

        public Criteria andCarPriceStatusGreaterThan(Byte value) {
            addCriterion("car_price_status >", value, "carPriceStatus");
            return (Criteria) this;
        }

        public Criteria andCarPriceStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("car_price_status >=", value, "carPriceStatus");
            return (Criteria) this;
        }

        public Criteria andCarPriceStatusLessThan(Byte value) {
            addCriterion("car_price_status <", value, "carPriceStatus");
            return (Criteria) this;
        }

        public Criteria andCarPriceStatusLessThanOrEqualTo(Byte value) {
            addCriterion("car_price_status <=", value, "carPriceStatus");
            return (Criteria) this;
        }

        public Criteria andCarPriceStatusIn(List<Byte> values) {
            addCriterion("car_price_status in", values, "carPriceStatus");
            return (Criteria) this;
        }

        public Criteria andCarPriceStatusNotIn(List<Byte> values) {
            addCriterion("car_price_status not in", values, "carPriceStatus");
            return (Criteria) this;
        }

        public Criteria andCarPriceStatusBetween(Byte value1, Byte value2) {
            addCriterion("car_price_status between", value1, value2, "carPriceStatus");
            return (Criteria) this;
        }

        public Criteria andCarPriceStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("car_price_status not between", value1, value2, "carPriceStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiquePriceStatusIsNull() {
            addCriterion("boutique_price_status is null");
            return (Criteria) this;
        }

        public Criteria andBoutiquePriceStatusIsNotNull() {
            addCriterion("boutique_price_status is not null");
            return (Criteria) this;
        }

        public Criteria andBoutiquePriceStatusEqualTo(Byte value) {
            addCriterion("boutique_price_status =", value, "boutiquePriceStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiquePriceStatusNotEqualTo(Byte value) {
            addCriterion("boutique_price_status <>", value, "boutiquePriceStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiquePriceStatusGreaterThan(Byte value) {
            addCriterion("boutique_price_status >", value, "boutiquePriceStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiquePriceStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("boutique_price_status >=", value, "boutiquePriceStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiquePriceStatusLessThan(Byte value) {
            addCriterion("boutique_price_status <", value, "boutiquePriceStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiquePriceStatusLessThanOrEqualTo(Byte value) {
            addCriterion("boutique_price_status <=", value, "boutiquePriceStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiquePriceStatusIn(List<Byte> values) {
            addCriterion("boutique_price_status in", values, "boutiquePriceStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiquePriceStatusNotIn(List<Byte> values) {
            addCriterion("boutique_price_status not in", values, "boutiquePriceStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiquePriceStatusBetween(Byte value1, Byte value2) {
            addCriterion("boutique_price_status between", value1, value2, "boutiquePriceStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiquePriceStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("boutique_price_status not between", value1, value2, "boutiquePriceStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusIsNull() {
            addCriterion("car_status is null");
            return (Criteria) this;
        }

        public Criteria andCarStatusIsNotNull() {
            addCriterion("car_status is not null");
            return (Criteria) this;
        }

        public Criteria andCarStatusEqualTo(Byte value) {
            addCriterion("car_status =", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotEqualTo(Byte value) {
            addCriterion("car_status <>", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusGreaterThan(Byte value) {
            addCriterion("car_status >", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("car_status >=", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLessThan(Byte value) {
            addCriterion("car_status <", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLessThanOrEqualTo(Byte value) {
            addCriterion("car_status <=", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusIn(List<Byte> values) {
            addCriterion("car_status in", values, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotIn(List<Byte> values) {
            addCriterion("car_status not in", values, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusBetween(Byte value1, Byte value2) {
            addCriterion("car_status between", value1, value2, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("car_status not between", value1, value2, "carStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiqueStatusIsNull() {
            addCriterion("boutique_status is null");
            return (Criteria) this;
        }

        public Criteria andBoutiqueStatusIsNotNull() {
            addCriterion("boutique_status is not null");
            return (Criteria) this;
        }

        public Criteria andBoutiqueStatusEqualTo(Byte value) {
            addCriterion("boutique_status =", value, "boutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiqueStatusNotEqualTo(Byte value) {
            addCriterion("boutique_status <>", value, "boutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiqueStatusGreaterThan(Byte value) {
            addCriterion("boutique_status >", value, "boutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiqueStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("boutique_status >=", value, "boutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiqueStatusLessThan(Byte value) {
            addCriterion("boutique_status <", value, "boutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiqueStatusLessThanOrEqualTo(Byte value) {
            addCriterion("boutique_status <=", value, "boutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiqueStatusIn(List<Byte> values) {
            addCriterion("boutique_status in", values, "boutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiqueStatusNotIn(List<Byte> values) {
            addCriterion("boutique_status not in", values, "boutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiqueStatusBetween(Byte value1, Byte value2) {
            addCriterion("boutique_status between", value1, value2, "boutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andBoutiqueStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("boutique_status not between", value1, value2, "boutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andInsurerStatusIsNull() {
            addCriterion("insurer_status is null");
            return (Criteria) this;
        }

        public Criteria andInsurerStatusIsNotNull() {
            addCriterion("insurer_status is not null");
            return (Criteria) this;
        }

        public Criteria andInsurerStatusEqualTo(Byte value) {
            addCriterion("insurer_status =", value, "insurerStatus");
            return (Criteria) this;
        }

        public Criteria andInsurerStatusNotEqualTo(Byte value) {
            addCriterion("insurer_status <>", value, "insurerStatus");
            return (Criteria) this;
        }

        public Criteria andInsurerStatusGreaterThan(Byte value) {
            addCriterion("insurer_status >", value, "insurerStatus");
            return (Criteria) this;
        }

        public Criteria andInsurerStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("insurer_status >=", value, "insurerStatus");
            return (Criteria) this;
        }

        public Criteria andInsurerStatusLessThan(Byte value) {
            addCriterion("insurer_status <", value, "insurerStatus");
            return (Criteria) this;
        }

        public Criteria andInsurerStatusLessThanOrEqualTo(Byte value) {
            addCriterion("insurer_status <=", value, "insurerStatus");
            return (Criteria) this;
        }

        public Criteria andInsurerStatusIn(List<Byte> values) {
            addCriterion("insurer_status in", values, "insurerStatus");
            return (Criteria) this;
        }

        public Criteria andInsurerStatusNotIn(List<Byte> values) {
            addCriterion("insurer_status not in", values, "insurerStatus");
            return (Criteria) this;
        }

        public Criteria andInsurerStatusBetween(Byte value1, Byte value2) {
            addCriterion("insurer_status between", value1, value2, "insurerStatus");
            return (Criteria) this;
        }

        public Criteria andInsurerStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("insurer_status not between", value1, value2, "insurerStatus");
            return (Criteria) this;
        }

        public Criteria andExtensionStatusIsNull() {
            addCriterion("extension_status is null");
            return (Criteria) this;
        }

        public Criteria andExtensionStatusIsNotNull() {
            addCriterion("extension_status is not null");
            return (Criteria) this;
        }

        public Criteria andExtensionStatusEqualTo(Byte value) {
            addCriterion("extension_status =", value, "extensionStatus");
            return (Criteria) this;
        }

        public Criteria andExtensionStatusNotEqualTo(Byte value) {
            addCriterion("extension_status <>", value, "extensionStatus");
            return (Criteria) this;
        }

        public Criteria andExtensionStatusGreaterThan(Byte value) {
            addCriterion("extension_status >", value, "extensionStatus");
            return (Criteria) this;
        }

        public Criteria andExtensionStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("extension_status >=", value, "extensionStatus");
            return (Criteria) this;
        }

        public Criteria andExtensionStatusLessThan(Byte value) {
            addCriterion("extension_status <", value, "extensionStatus");
            return (Criteria) this;
        }

        public Criteria andExtensionStatusLessThanOrEqualTo(Byte value) {
            addCriterion("extension_status <=", value, "extensionStatus");
            return (Criteria) this;
        }

        public Criteria andExtensionStatusIn(List<Byte> values) {
            addCriterion("extension_status in", values, "extensionStatus");
            return (Criteria) this;
        }

        public Criteria andExtensionStatusNotIn(List<Byte> values) {
            addCriterion("extension_status not in", values, "extensionStatus");
            return (Criteria) this;
        }

        public Criteria andExtensionStatusBetween(Byte value1, Byte value2) {
            addCriterion("extension_status between", value1, value2, "extensionStatus");
            return (Criteria) this;
        }

        public Criteria andExtensionStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("extension_status not between", value1, value2, "extensionStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusIsNull() {
            addCriterion("finance_status is null");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusIsNotNull() {
            addCriterion("finance_status is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusEqualTo(Byte value) {
            addCriterion("finance_status =", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusNotEqualTo(Byte value) {
            addCriterion("finance_status <>", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusGreaterThan(Byte value) {
            addCriterion("finance_status >", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("finance_status >=", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusLessThan(Byte value) {
            addCriterion("finance_status <", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusLessThanOrEqualTo(Byte value) {
            addCriterion("finance_status <=", value, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusIn(List<Byte> values) {
            addCriterion("finance_status in", values, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusNotIn(List<Byte> values) {
            addCriterion("finance_status not in", values, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusBetween(Byte value1, Byte value2) {
            addCriterion("finance_status between", value1, value2, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("finance_status not between", value1, value2, "financeStatus");
            return (Criteria) this;
        }

        public Criteria andOtherStatusIsNull() {
            addCriterion("other_status is null");
            return (Criteria) this;
        }

        public Criteria andOtherStatusIsNotNull() {
            addCriterion("other_status is not null");
            return (Criteria) this;
        }

        public Criteria andOtherStatusEqualTo(Byte value) {
            addCriterion("other_status =", value, "otherStatus");
            return (Criteria) this;
        }

        public Criteria andOtherStatusNotEqualTo(Byte value) {
            addCriterion("other_status <>", value, "otherStatus");
            return (Criteria) this;
        }

        public Criteria andOtherStatusGreaterThan(Byte value) {
            addCriterion("other_status >", value, "otherStatus");
            return (Criteria) this;
        }

        public Criteria andOtherStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("other_status >=", value, "otherStatus");
            return (Criteria) this;
        }

        public Criteria andOtherStatusLessThan(Byte value) {
            addCriterion("other_status <", value, "otherStatus");
            return (Criteria) this;
        }

        public Criteria andOtherStatusLessThanOrEqualTo(Byte value) {
            addCriterion("other_status <=", value, "otherStatus");
            return (Criteria) this;
        }

        public Criteria andOtherStatusIn(List<Byte> values) {
            addCriterion("other_status in", values, "otherStatus");
            return (Criteria) this;
        }

        public Criteria andOtherStatusNotIn(List<Byte> values) {
            addCriterion("other_status not in", values, "otherStatus");
            return (Criteria) this;
        }

        public Criteria andOtherStatusBetween(Byte value1, Byte value2) {
            addCriterion("other_status between", value1, value2, "otherStatus");
            return (Criteria) this;
        }

        public Criteria andOtherStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("other_status not between", value1, value2, "otherStatus");
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

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(Integer value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(Integer value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(Integer value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(Integer value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<Integer> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<Integer> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(Integer value1, Integer value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
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

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Byte value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Byte value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Byte value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Byte value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Byte value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Byte> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Byte> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Byte value1, Byte value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
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

        public Criteria andDoneTimeIsNull() {
            addCriterion("done_time is null");
            return (Criteria) this;
        }

        public Criteria andDoneTimeIsNotNull() {
            addCriterion("done_time is not null");
            return (Criteria) this;
        }

        public Criteria andDoneTimeEqualTo(Date value) {
            addCriterion("done_time =", value, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeNotEqualTo(Date value) {
            addCriterion("done_time <>", value, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeGreaterThan(Date value) {
            addCriterion("done_time >", value, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("done_time >=", value, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeLessThan(Date value) {
            addCriterion("done_time <", value, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeLessThanOrEqualTo(Date value) {
            addCriterion("done_time <=", value, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeIn(List<Date> values) {
            addCriterion("done_time in", values, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeNotIn(List<Date> values) {
            addCriterion("done_time not in", values, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeBetween(Date value1, Date value2) {
            addCriterion("done_time between", value1, value2, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeNotBetween(Date value1, Date value2) {
            addCriterion("done_time not between", value1, value2, "doneTime");
            return (Criteria) this;
        }

        public Criteria andIfEquipmentIsNull() {
            addCriterion("if_equipment is null");
            return (Criteria) this;
        }

        public Criteria andIfEquipmentIsNotNull() {
            addCriterion("if_equipment is not null");
            return (Criteria) this;
        }

        public Criteria andIfEquipmentEqualTo(Byte value) {
            addCriterion("if_equipment =", value, "ifEquipment");
            return (Criteria) this;
        }

        public Criteria andIfEquipmentNotEqualTo(Byte value) {
            addCriterion("if_equipment <>", value, "ifEquipment");
            return (Criteria) this;
        }

        public Criteria andIfEquipmentGreaterThan(Byte value) {
            addCriterion("if_equipment >", value, "ifEquipment");
            return (Criteria) this;
        }

        public Criteria andIfEquipmentGreaterThanOrEqualTo(Byte value) {
            addCriterion("if_equipment >=", value, "ifEquipment");
            return (Criteria) this;
        }

        public Criteria andIfEquipmentLessThan(Byte value) {
            addCriterion("if_equipment <", value, "ifEquipment");
            return (Criteria) this;
        }

        public Criteria andIfEquipmentLessThanOrEqualTo(Byte value) {
            addCriterion("if_equipment <=", value, "ifEquipment");
            return (Criteria) this;
        }

        public Criteria andIfEquipmentIn(List<Byte> values) {
            addCriterion("if_equipment in", values, "ifEquipment");
            return (Criteria) this;
        }

        public Criteria andIfEquipmentNotIn(List<Byte> values) {
            addCriterion("if_equipment not in", values, "ifEquipment");
            return (Criteria) this;
        }

        public Criteria andIfEquipmentBetween(Byte value1, Byte value2) {
            addCriterion("if_equipment between", value1, value2, "ifEquipment");
            return (Criteria) this;
        }

        public Criteria andIfEquipmentNotBetween(Byte value1, Byte value2) {
            addCriterion("if_equipment not between", value1, value2, "ifEquipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentTimeIsNull() {
            addCriterion("equipment_time is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTimeIsNotNull() {
            addCriterion("equipment_time is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentTimeEqualTo(Date value) {
            addCriterion("equipment_time =", value, "equipmentTime");
            return (Criteria) this;
        }

        public Criteria andEquipmentTimeNotEqualTo(Date value) {
            addCriterion("equipment_time <>", value, "equipmentTime");
            return (Criteria) this;
        }

        public Criteria andEquipmentTimeGreaterThan(Date value) {
            addCriterion("equipment_time >", value, "equipmentTime");
            return (Criteria) this;
        }

        public Criteria andEquipmentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("equipment_time >=", value, "equipmentTime");
            return (Criteria) this;
        }

        public Criteria andEquipmentTimeLessThan(Date value) {
            addCriterion("equipment_time <", value, "equipmentTime");
            return (Criteria) this;
        }

        public Criteria andEquipmentTimeLessThanOrEqualTo(Date value) {
            addCriterion("equipment_time <=", value, "equipmentTime");
            return (Criteria) this;
        }

        public Criteria andEquipmentTimeIn(List<Date> values) {
            addCriterion("equipment_time in", values, "equipmentTime");
            return (Criteria) this;
        }

        public Criteria andEquipmentTimeNotIn(List<Date> values) {
            addCriterion("equipment_time not in", values, "equipmentTime");
            return (Criteria) this;
        }

        public Criteria andEquipmentTimeBetween(Date value1, Date value2) {
            addCriterion("equipment_time between", value1, value2, "equipmentTime");
            return (Criteria) this;
        }

        public Criteria andEquipmentTimeNotBetween(Date value1, Date value2) {
            addCriterion("equipment_time not between", value1, value2, "equipmentTime");
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