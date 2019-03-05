package com.unicdata.entity.boutique;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoutiqueOutboundDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BoutiqueOutboundDetailExample() {
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

        public Criteria andOutboundIdIsNull() {
            addCriterion("outbound_id is null");
            return (Criteria) this;
        }

        public Criteria andOutboundIdIsNotNull() {
            addCriterion("outbound_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutboundIdEqualTo(Integer value) {
            addCriterion("outbound_id =", value, "outboundId");
            return (Criteria) this;
        }

        public Criteria andOutboundIdNotEqualTo(Integer value) {
            addCriterion("outbound_id <>", value, "outboundId");
            return (Criteria) this;
        }

        public Criteria andOutboundIdGreaterThan(Integer value) {
            addCriterion("outbound_id >", value, "outboundId");
            return (Criteria) this;
        }

        public Criteria andOutboundIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("outbound_id >=", value, "outboundId");
            return (Criteria) this;
        }

        public Criteria andOutboundIdLessThan(Integer value) {
            addCriterion("outbound_id <", value, "outboundId");
            return (Criteria) this;
        }

        public Criteria andOutboundIdLessThanOrEqualTo(Integer value) {
            addCriterion("outbound_id <=", value, "outboundId");
            return (Criteria) this;
        }

        public Criteria andOutboundIdIn(List<Integer> values) {
            addCriterion("outbound_id in", values, "outboundId");
            return (Criteria) this;
        }

        public Criteria andOutboundIdNotIn(List<Integer> values) {
            addCriterion("outbound_id not in", values, "outboundId");
            return (Criteria) this;
        }

        public Criteria andOutboundIdBetween(Integer value1, Integer value2) {
            addCriterion("outbound_id between", value1, value2, "outboundId");
            return (Criteria) this;
        }

        public Criteria andOutboundIdNotBetween(Integer value1, Integer value2) {
            addCriterion("outbound_id not between", value1, value2, "outboundId");
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

        public Criteria andBoutiqueConstructionIsNull() {
            addCriterion("boutique_construction is null");
            return (Criteria) this;
        }

        public Criteria andBoutiqueConstructionIsNotNull() {
            addCriterion("boutique_construction is not null");
            return (Criteria) this;
        }

        public Criteria andBoutiqueConstructionEqualTo(Integer value) {
            addCriterion("boutique_construction =", value, "boutiqueConstruction");
            return (Criteria) this;
        }

        public Criteria andBoutiqueConstructionNotEqualTo(Integer value) {
            addCriterion("boutique_construction <>", value, "boutiqueConstruction");
            return (Criteria) this;
        }

        public Criteria andBoutiqueConstructionGreaterThan(Integer value) {
            addCriterion("boutique_construction >", value, "boutiqueConstruction");
            return (Criteria) this;
        }

        public Criteria andBoutiqueConstructionGreaterThanOrEqualTo(Integer value) {
            addCriterion("boutique_construction >=", value, "boutiqueConstruction");
            return (Criteria) this;
        }

        public Criteria andBoutiqueConstructionLessThan(Integer value) {
            addCriterion("boutique_construction <", value, "boutiqueConstruction");
            return (Criteria) this;
        }

        public Criteria andBoutiqueConstructionLessThanOrEqualTo(Integer value) {
            addCriterion("boutique_construction <=", value, "boutiqueConstruction");
            return (Criteria) this;
        }

        public Criteria andBoutiqueConstructionIn(List<Integer> values) {
            addCriterion("boutique_construction in", values, "boutiqueConstruction");
            return (Criteria) this;
        }

        public Criteria andBoutiqueConstructionNotIn(List<Integer> values) {
            addCriterion("boutique_construction not in", values, "boutiqueConstruction");
            return (Criteria) this;
        }

        public Criteria andBoutiqueConstructionBetween(Integer value1, Integer value2) {
            addCriterion("boutique_construction between", value1, value2, "boutiqueConstruction");
            return (Criteria) this;
        }

        public Criteria andBoutiqueConstructionNotBetween(Integer value1, Integer value2) {
            addCriterion("boutique_construction not between", value1, value2, "boutiqueConstruction");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdIsNull() {
            addCriterion("boutique_id is null");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdIsNotNull() {
            addCriterion("boutique_id is not null");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdEqualTo(Integer value) {
            addCriterion("boutique_id =", value, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdNotEqualTo(Integer value) {
            addCriterion("boutique_id <>", value, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdGreaterThan(Integer value) {
            addCriterion("boutique_id >", value, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("boutique_id >=", value, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdLessThan(Integer value) {
            addCriterion("boutique_id <", value, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdLessThanOrEqualTo(Integer value) {
            addCriterion("boutique_id <=", value, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdIn(List<Integer> values) {
            addCriterion("boutique_id in", values, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdNotIn(List<Integer> values) {
            addCriterion("boutique_id not in", values, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdBetween(Integer value1, Integer value2) {
            addCriterion("boutique_id between", value1, value2, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andBoutiqueIdNotBetween(Integer value1, Integer value2) {
            addCriterion("boutique_id not between", value1, value2, "boutiqueId");
            return (Criteria) this;
        }

        public Criteria andNumerIsNull() {
            addCriterion("numer is null");
            return (Criteria) this;
        }

        public Criteria andNumerIsNotNull() {
            addCriterion("numer is not null");
            return (Criteria) this;
        }

        public Criteria andNumerEqualTo(Integer value) {
            addCriterion("numer =", value, "numer");
            return (Criteria) this;
        }

        public Criteria andNumerNotEqualTo(Integer value) {
            addCriterion("numer <>", value, "numer");
            return (Criteria) this;
        }

        public Criteria andNumerGreaterThan(Integer value) {
            addCriterion("numer >", value, "numer");
            return (Criteria) this;
        }

        public Criteria andNumerGreaterThanOrEqualTo(Integer value) {
            addCriterion("numer >=", value, "numer");
            return (Criteria) this;
        }

        public Criteria andNumerLessThan(Integer value) {
            addCriterion("numer <", value, "numer");
            return (Criteria) this;
        }

        public Criteria andNumerLessThanOrEqualTo(Integer value) {
            addCriterion("numer <=", value, "numer");
            return (Criteria) this;
        }

        public Criteria andNumerIn(List<Integer> values) {
            addCriterion("numer in", values, "numer");
            return (Criteria) this;
        }

        public Criteria andNumerNotIn(List<Integer> values) {
            addCriterion("numer not in", values, "numer");
            return (Criteria) this;
        }

        public Criteria andNumerBetween(Integer value1, Integer value2) {
            addCriterion("numer between", value1, value2, "numer");
            return (Criteria) this;
        }

        public Criteria andNumerNotBetween(Integer value1, Integer value2) {
            addCriterion("numer not between", value1, value2, "numer");
            return (Criteria) this;
        }

        public Criteria andPickerIsNull() {
            addCriterion("picker is null");
            return (Criteria) this;
        }

        public Criteria andPickerIsNotNull() {
            addCriterion("picker is not null");
            return (Criteria) this;
        }

        public Criteria andPickerEqualTo(String value) {
            addCriterion("picker =", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerNotEqualTo(String value) {
            addCriterion("picker <>", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerGreaterThan(String value) {
            addCriterion("picker >", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerGreaterThanOrEqualTo(String value) {
            addCriterion("picker >=", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerLessThan(String value) {
            addCriterion("picker <", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerLessThanOrEqualTo(String value) {
            addCriterion("picker <=", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerLike(String value) {
            addCriterion("picker like", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerNotLike(String value) {
            addCriterion("picker not like", value, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerIn(List<String> values) {
            addCriterion("picker in", values, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerNotIn(List<String> values) {
            addCriterion("picker not in", values, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerBetween(String value1, String value2) {
            addCriterion("picker between", value1, value2, "picker");
            return (Criteria) this;
        }

        public Criteria andPickerNotBetween(String value1, String value2) {
            addCriterion("picker not between", value1, value2, "picker");
            return (Criteria) this;
        }

        public Criteria andOutboundDateIsNull() {
            addCriterion("outbound_date is null");
            return (Criteria) this;
        }

        public Criteria andOutboundDateIsNotNull() {
            addCriterion("outbound_date is not null");
            return (Criteria) this;
        }

        public Criteria andOutboundDateEqualTo(Date value) {
            addCriterion("outbound_date =", value, "outboundDate");
            return (Criteria) this;
        }

        public Criteria andOutboundDateNotEqualTo(Date value) {
            addCriterion("outbound_date <>", value, "outboundDate");
            return (Criteria) this;
        }

        public Criteria andOutboundDateGreaterThan(Date value) {
            addCriterion("outbound_date >", value, "outboundDate");
            return (Criteria) this;
        }

        public Criteria andOutboundDateGreaterThanOrEqualTo(Date value) {
            addCriterion("outbound_date >=", value, "outboundDate");
            return (Criteria) this;
        }

        public Criteria andOutboundDateLessThan(Date value) {
            addCriterion("outbound_date <", value, "outboundDate");
            return (Criteria) this;
        }

        public Criteria andOutboundDateLessThanOrEqualTo(Date value) {
            addCriterion("outbound_date <=", value, "outboundDate");
            return (Criteria) this;
        }

        public Criteria andOutboundDateIn(List<Date> values) {
            addCriterion("outbound_date in", values, "outboundDate");
            return (Criteria) this;
        }

        public Criteria andOutboundDateNotIn(List<Date> values) {
            addCriterion("outbound_date not in", values, "outboundDate");
            return (Criteria) this;
        }

        public Criteria andOutboundDateBetween(Date value1, Date value2) {
            addCriterion("outbound_date between", value1, value2, "outboundDate");
            return (Criteria) this;
        }

        public Criteria andOutboundDateNotBetween(Date value1, Date value2) {
            addCriterion("outbound_date not between", value1, value2, "outboundDate");
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

        public Criteria andTimeStampIsNull() {
            addCriterion("time_stamp is null");
            return (Criteria) this;
        }

        public Criteria andTimeStampIsNotNull() {
            addCriterion("time_stamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimeStampEqualTo(Date value) {
            addCriterion("time_stamp =", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampNotEqualTo(Date value) {
            addCriterion("time_stamp <>", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampGreaterThan(Date value) {
            addCriterion("time_stamp >", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampGreaterThanOrEqualTo(Date value) {
            addCriterion("time_stamp >=", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampLessThan(Date value) {
            addCriterion("time_stamp <", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampLessThanOrEqualTo(Date value) {
            addCriterion("time_stamp <=", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampIn(List<Date> values) {
            addCriterion("time_stamp in", values, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampNotIn(List<Date> values) {
            addCriterion("time_stamp not in", values, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampBetween(Date value1, Date value2) {
            addCriterion("time_stamp between", value1, value2, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampNotBetween(Date value1, Date value2) {
            addCriterion("time_stamp not between", value1, value2, "timeStamp");
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