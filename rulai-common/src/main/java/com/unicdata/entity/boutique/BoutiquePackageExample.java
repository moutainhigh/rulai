package com.unicdata.entity.boutique;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoutiquePackageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BoutiquePackageExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSalveValueIsNull() {
            addCriterion("salve_value is null");
            return (Criteria) this;
        }

        public Criteria andSalveValueIsNotNull() {
            addCriterion("salve_value is not null");
            return (Criteria) this;
        }

        public Criteria andSalveValueEqualTo(BigDecimal value) {
            addCriterion("salve_value =", value, "salveValue");
            return (Criteria) this;
        }

        public Criteria andSalveValueNotEqualTo(BigDecimal value) {
            addCriterion("salve_value <>", value, "salveValue");
            return (Criteria) this;
        }

        public Criteria andSalveValueGreaterThan(BigDecimal value) {
            addCriterion("salve_value >", value, "salveValue");
            return (Criteria) this;
        }

        public Criteria andSalveValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("salve_value >=", value, "salveValue");
            return (Criteria) this;
        }

        public Criteria andSalveValueLessThan(BigDecimal value) {
            addCriterion("salve_value <", value, "salveValue");
            return (Criteria) this;
        }

        public Criteria andSalveValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("salve_value <=", value, "salveValue");
            return (Criteria) this;
        }

        public Criteria andSalveValueIn(List<BigDecimal> values) {
            addCriterion("salve_value in", values, "salveValue");
            return (Criteria) this;
        }

        public Criteria andSalveValueNotIn(List<BigDecimal> values) {
            addCriterion("salve_value not in", values, "salveValue");
            return (Criteria) this;
        }

        public Criteria andSalveValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salve_value between", value1, value2, "salveValue");
            return (Criteria) this;
        }

        public Criteria andSalveValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salve_value not between", value1, value2, "salveValue");
            return (Criteria) this;
        }

        public Criteria andCarIdsIsNull() {
            addCriterion("car_ids is null");
            return (Criteria) this;
        }

        public Criteria andCarIdsIsNotNull() {
            addCriterion("car_ids is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdsEqualTo(String value) {
            addCriterion("car_ids =", value, "carIds");
            return (Criteria) this;
        }

        public Criteria andCarIdsNotEqualTo(String value) {
            addCriterion("car_ids <>", value, "carIds");
            return (Criteria) this;
        }

        public Criteria andCarIdsGreaterThan(String value) {
            addCriterion("car_ids >", value, "carIds");
            return (Criteria) this;
        }

        public Criteria andCarIdsGreaterThanOrEqualTo(String value) {
            addCriterion("car_ids >=", value, "carIds");
            return (Criteria) this;
        }

        public Criteria andCarIdsLessThan(String value) {
            addCriterion("car_ids <", value, "carIds");
            return (Criteria) this;
        }

        public Criteria andCarIdsLessThanOrEqualTo(String value) {
            addCriterion("car_ids <=", value, "carIds");
            return (Criteria) this;
        }

        public Criteria andCarIdsLike(String value) {
            addCriterion("car_ids like", value, "carIds");
            return (Criteria) this;
        }

        public Criteria andCarIdsNotLike(String value) {
            addCriterion("car_ids not like", value, "carIds");
            return (Criteria) this;
        }

        public Criteria andCarIdsIn(List<String> values) {
            addCriterion("car_ids in", values, "carIds");
            return (Criteria) this;
        }

        public Criteria andCarIdsNotIn(List<String> values) {
            addCriterion("car_ids not in", values, "carIds");
            return (Criteria) this;
        }

        public Criteria andCarIdsBetween(String value1, String value2) {
            addCriterion("car_ids between", value1, value2, "carIds");
            return (Criteria) this;
        }

        public Criteria andCarIdsNotBetween(String value1, String value2) {
            addCriterion("car_ids not between", value1, value2, "carIds");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andIncludeNumIsNull() {
            addCriterion("include_num is null");
            return (Criteria) this;
        }

        public Criteria andIncludeNumIsNotNull() {
            addCriterion("include_num is not null");
            return (Criteria) this;
        }

        public Criteria andIncludeNumEqualTo(Integer value) {
            addCriterion("include_num =", value, "includeNum");
            return (Criteria) this;
        }

        public Criteria andIncludeNumNotEqualTo(Integer value) {
            addCriterion("include_num <>", value, "includeNum");
            return (Criteria) this;
        }

        public Criteria andIncludeNumGreaterThan(Integer value) {
            addCriterion("include_num >", value, "includeNum");
            return (Criteria) this;
        }

        public Criteria andIncludeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("include_num >=", value, "includeNum");
            return (Criteria) this;
        }

        public Criteria andIncludeNumLessThan(Integer value) {
            addCriterion("include_num <", value, "includeNum");
            return (Criteria) this;
        }

        public Criteria andIncludeNumLessThanOrEqualTo(Integer value) {
            addCriterion("include_num <=", value, "includeNum");
            return (Criteria) this;
        }

        public Criteria andIncludeNumIn(List<Integer> values) {
            addCriterion("include_num in", values, "includeNum");
            return (Criteria) this;
        }

        public Criteria andIncludeNumNotIn(List<Integer> values) {
            addCriterion("include_num not in", values, "includeNum");
            return (Criteria) this;
        }

        public Criteria andIncludeNumBetween(Integer value1, Integer value2) {
            addCriterion("include_num between", value1, value2, "includeNum");
            return (Criteria) this;
        }

        public Criteria andIncludeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("include_num not between", value1, value2, "includeNum");
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

        public Criteria andTypeLiveIsNull() {
            addCriterion("type_live is null");
            return (Criteria) this;
        }

        public Criteria andTypeLiveIsNotNull() {
            addCriterion("type_live is not null");
            return (Criteria) this;
        }

        public Criteria andTypeLiveEqualTo(Byte value) {
            addCriterion("type_live =", value, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveNotEqualTo(Byte value) {
            addCriterion("type_live <>", value, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveGreaterThan(Byte value) {
            addCriterion("type_live >", value, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveGreaterThanOrEqualTo(Byte value) {
            addCriterion("type_live >=", value, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveLessThan(Byte value) {
            addCriterion("type_live <", value, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveLessThanOrEqualTo(Byte value) {
            addCriterion("type_live <=", value, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveIn(List<Byte> values) {
            addCriterion("type_live in", values, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveNotIn(List<Byte> values) {
            addCriterion("type_live not in", values, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveBetween(Byte value1, Byte value2) {
            addCriterion("type_live between", value1, value2, "typeLive");
            return (Criteria) this;
        }

        public Criteria andTypeLiveNotBetween(Byte value1, Byte value2) {
            addCriterion("type_live not between", value1, value2, "typeLive");
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