package com.unicdata.entity.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeAuthorizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeAuthorizeExample() {
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

        public Criteria andEmployeePostIsNull() {
            addCriterion("employee_post is null");
            return (Criteria) this;
        }

        public Criteria andEmployeePostIsNotNull() {
            addCriterion("employee_post is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeePostEqualTo(String value) {
            addCriterion("employee_post =", value, "employeePost");
            return (Criteria) this;
        }

        public Criteria andEmployeePostNotEqualTo(String value) {
            addCriterion("employee_post <>", value, "employeePost");
            return (Criteria) this;
        }

        public Criteria andEmployeePostGreaterThan(String value) {
            addCriterion("employee_post >", value, "employeePost");
            return (Criteria) this;
        }

        public Criteria andEmployeePostGreaterThanOrEqualTo(String value) {
            addCriterion("employee_post >=", value, "employeePost");
            return (Criteria) this;
        }

        public Criteria andEmployeePostLessThan(String value) {
            addCriterion("employee_post <", value, "employeePost");
            return (Criteria) this;
        }

        public Criteria andEmployeePostLessThanOrEqualTo(String value) {
            addCriterion("employee_post <=", value, "employeePost");
            return (Criteria) this;
        }

        public Criteria andEmployeePostLike(String value) {
            addCriterion("employee_post like", value, "employeePost");
            return (Criteria) this;
        }

        public Criteria andEmployeePostNotLike(String value) {
            addCriterion("employee_post not like", value, "employeePost");
            return (Criteria) this;
        }

        public Criteria andEmployeePostIn(List<String> values) {
            addCriterion("employee_post in", values, "employeePost");
            return (Criteria) this;
        }

        public Criteria andEmployeePostNotIn(List<String> values) {
            addCriterion("employee_post not in", values, "employeePost");
            return (Criteria) this;
        }

        public Criteria andEmployeePostBetween(String value1, String value2) {
            addCriterion("employee_post between", value1, value2, "employeePost");
            return (Criteria) this;
        }

        public Criteria andEmployeePostNotBetween(String value1, String value2) {
            addCriterion("employee_post not between", value1, value2, "employeePost");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIdIsNull() {
            addCriterion("authorizer_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIdIsNotNull() {
            addCriterion("authorizer_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIdEqualTo(Integer value) {
            addCriterion("authorizer_id =", value, "authorizerId");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIdNotEqualTo(Integer value) {
            addCriterion("authorizer_id <>", value, "authorizerId");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIdGreaterThan(Integer value) {
            addCriterion("authorizer_id >", value, "authorizerId");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("authorizer_id >=", value, "authorizerId");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIdLessThan(Integer value) {
            addCriterion("authorizer_id <", value, "authorizerId");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIdLessThanOrEqualTo(Integer value) {
            addCriterion("authorizer_id <=", value, "authorizerId");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIdIn(List<Integer> values) {
            addCriterion("authorizer_id in", values, "authorizerId");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIdNotIn(List<Integer> values) {
            addCriterion("authorizer_id not in", values, "authorizerId");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIdBetween(Integer value1, Integer value2) {
            addCriterion("authorizer_id between", value1, value2, "authorizerId");
            return (Criteria) this;
        }

        public Criteria andAuthorizerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("authorizer_id not between", value1, value2, "authorizerId");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostIsNull() {
            addCriterion("authorizer_post is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostIsNotNull() {
            addCriterion("authorizer_post is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostEqualTo(String value) {
            addCriterion("authorizer_post =", value, "authorizerPost");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostNotEqualTo(String value) {
            addCriterion("authorizer_post <>", value, "authorizerPost");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostGreaterThan(String value) {
            addCriterion("authorizer_post >", value, "authorizerPost");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostGreaterThanOrEqualTo(String value) {
            addCriterion("authorizer_post >=", value, "authorizerPost");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostLessThan(String value) {
            addCriterion("authorizer_post <", value, "authorizerPost");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostLessThanOrEqualTo(String value) {
            addCriterion("authorizer_post <=", value, "authorizerPost");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostLike(String value) {
            addCriterion("authorizer_post like", value, "authorizerPost");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostNotLike(String value) {
            addCriterion("authorizer_post not like", value, "authorizerPost");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostIn(List<String> values) {
            addCriterion("authorizer_post in", values, "authorizerPost");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostNotIn(List<String> values) {
            addCriterion("authorizer_post not in", values, "authorizerPost");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostBetween(String value1, String value2) {
            addCriterion("authorizer_post between", value1, value2, "authorizerPost");
            return (Criteria) this;
        }

        public Criteria andAuthorizerPostNotBetween(String value1, String value2) {
            addCriterion("authorizer_post not between", value1, value2, "authorizerPost");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionIsNull() {
            addCriterion("authorize_function is null");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionIsNotNull() {
            addCriterion("authorize_function is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionEqualTo(String value) {
            addCriterion("authorize_function =", value, "authorizeFunction");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionNotEqualTo(String value) {
            addCriterion("authorize_function <>", value, "authorizeFunction");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionGreaterThan(String value) {
            addCriterion("authorize_function >", value, "authorizeFunction");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("authorize_function >=", value, "authorizeFunction");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionLessThan(String value) {
            addCriterion("authorize_function <", value, "authorizeFunction");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionLessThanOrEqualTo(String value) {
            addCriterion("authorize_function <=", value, "authorizeFunction");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionLike(String value) {
            addCriterion("authorize_function like", value, "authorizeFunction");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionNotLike(String value) {
            addCriterion("authorize_function not like", value, "authorizeFunction");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionIn(List<String> values) {
            addCriterion("authorize_function in", values, "authorizeFunction");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionNotIn(List<String> values) {
            addCriterion("authorize_function not in", values, "authorizeFunction");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionBetween(String value1, String value2) {
            addCriterion("authorize_function between", value1, value2, "authorizeFunction");
            return (Criteria) this;
        }

        public Criteria andAuthorizeFunctionNotBetween(String value1, String value2) {
            addCriterion("authorize_function not between", value1, value2, "authorizeFunction");
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