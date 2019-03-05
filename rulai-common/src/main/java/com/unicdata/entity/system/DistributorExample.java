package com.unicdata.entity.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DistributorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DistributorExample() {
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

        public Criteria andLogoIconIsNull() {
            addCriterion("logo_icon is null");
            return (Criteria) this;
        }

        public Criteria andLogoIconIsNotNull() {
            addCriterion("logo_icon is not null");
            return (Criteria) this;
        }

        public Criteria andLogoIconEqualTo(String value) {
            addCriterion("logo_icon =", value, "logoIcon");
            return (Criteria) this;
        }

        public Criteria andLogoIconNotEqualTo(String value) {
            addCriterion("logo_icon <>", value, "logoIcon");
            return (Criteria) this;
        }

        public Criteria andLogoIconGreaterThan(String value) {
            addCriterion("logo_icon >", value, "logoIcon");
            return (Criteria) this;
        }

        public Criteria andLogoIconGreaterThanOrEqualTo(String value) {
            addCriterion("logo_icon >=", value, "logoIcon");
            return (Criteria) this;
        }

        public Criteria andLogoIconLessThan(String value) {
            addCriterion("logo_icon <", value, "logoIcon");
            return (Criteria) this;
        }

        public Criteria andLogoIconLessThanOrEqualTo(String value) {
            addCriterion("logo_icon <=", value, "logoIcon");
            return (Criteria) this;
        }

        public Criteria andLogoIconLike(String value) {
            addCriterion("logo_icon like", value, "logoIcon");
            return (Criteria) this;
        }

        public Criteria andLogoIconNotLike(String value) {
            addCriterion("logo_icon not like", value, "logoIcon");
            return (Criteria) this;
        }

        public Criteria andLogoIconIn(List<String> values) {
            addCriterion("logo_icon in", values, "logoIcon");
            return (Criteria) this;
        }

        public Criteria andLogoIconNotIn(List<String> values) {
            addCriterion("logo_icon not in", values, "logoIcon");
            return (Criteria) this;
        }

        public Criteria andLogoIconBetween(String value1, String value2) {
            addCriterion("logo_icon between", value1, value2, "logoIcon");
            return (Criteria) this;
        }

        public Criteria andLogoIconNotBetween(String value1, String value2) {
            addCriterion("logo_icon not between", value1, value2, "logoIcon");
            return (Criteria) this;
        }

        public Criteria andAddresssIsNull() {
            addCriterion("addresss is null");
            return (Criteria) this;
        }

        public Criteria andAddresssIsNotNull() {
            addCriterion("addresss is not null");
            return (Criteria) this;
        }

        public Criteria andAddresssEqualTo(String value) {
            addCriterion("addresss =", value, "addresss");
            return (Criteria) this;
        }

        public Criteria andAddresssNotEqualTo(String value) {
            addCriterion("addresss <>", value, "addresss");
            return (Criteria) this;
        }

        public Criteria andAddresssGreaterThan(String value) {
            addCriterion("addresss >", value, "addresss");
            return (Criteria) this;
        }

        public Criteria andAddresssGreaterThanOrEqualTo(String value) {
            addCriterion("addresss >=", value, "addresss");
            return (Criteria) this;
        }

        public Criteria andAddresssLessThan(String value) {
            addCriterion("addresss <", value, "addresss");
            return (Criteria) this;
        }

        public Criteria andAddresssLessThanOrEqualTo(String value) {
            addCriterion("addresss <=", value, "addresss");
            return (Criteria) this;
        }

        public Criteria andAddresssLike(String value) {
            addCriterion("addresss like", value, "addresss");
            return (Criteria) this;
        }

        public Criteria andAddresssNotLike(String value) {
            addCriterion("addresss not like", value, "addresss");
            return (Criteria) this;
        }

        public Criteria andAddresssIn(List<String> values) {
            addCriterion("addresss in", values, "addresss");
            return (Criteria) this;
        }

        public Criteria andAddresssNotIn(List<String> values) {
            addCriterion("addresss not in", values, "addresss");
            return (Criteria) this;
        }

        public Criteria andAddresssBetween(String value1, String value2) {
            addCriterion("addresss between", value1, value2, "addresss");
            return (Criteria) this;
        }

        public Criteria andAddresssNotBetween(String value1, String value2) {
            addCriterion("addresss not between", value1, value2, "addresss");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appid like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appid not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appid not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppsecretIsNull() {
            addCriterion("appsecret is null");
            return (Criteria) this;
        }

        public Criteria andAppsecretIsNotNull() {
            addCriterion("appsecret is not null");
            return (Criteria) this;
        }

        public Criteria andAppsecretEqualTo(String value) {
            addCriterion("appsecret =", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotEqualTo(String value) {
            addCriterion("appsecret <>", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretGreaterThan(String value) {
            addCriterion("appsecret >", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretGreaterThanOrEqualTo(String value) {
            addCriterion("appsecret >=", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretLessThan(String value) {
            addCriterion("appsecret <", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretLessThanOrEqualTo(String value) {
            addCriterion("appsecret <=", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretLike(String value) {
            addCriterion("appsecret like", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotLike(String value) {
            addCriterion("appsecret not like", value, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretIn(List<String> values) {
            addCriterion("appsecret in", values, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotIn(List<String> values) {
            addCriterion("appsecret not in", values, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretBetween(String value1, String value2) {
            addCriterion("appsecret between", value1, value2, "appsecret");
            return (Criteria) this;
        }

        public Criteria andAppsecretNotBetween(String value1, String value2) {
            addCriterion("appsecret not between", value1, value2, "appsecret");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsIsNull() {
            addCriterion("encrypt_strings is null");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsIsNotNull() {
            addCriterion("encrypt_strings is not null");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsEqualTo(String value) {
            addCriterion("encrypt_strings =", value, "encryptStrings");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsNotEqualTo(String value) {
            addCriterion("encrypt_strings <>", value, "encryptStrings");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsGreaterThan(String value) {
            addCriterion("encrypt_strings >", value, "encryptStrings");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsGreaterThanOrEqualTo(String value) {
            addCriterion("encrypt_strings >=", value, "encryptStrings");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsLessThan(String value) {
            addCriterion("encrypt_strings <", value, "encryptStrings");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsLessThanOrEqualTo(String value) {
            addCriterion("encrypt_strings <=", value, "encryptStrings");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsLike(String value) {
            addCriterion("encrypt_strings like", value, "encryptStrings");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsNotLike(String value) {
            addCriterion("encrypt_strings not like", value, "encryptStrings");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsIn(List<String> values) {
            addCriterion("encrypt_strings in", values, "encryptStrings");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsNotIn(List<String> values) {
            addCriterion("encrypt_strings not in", values, "encryptStrings");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsBetween(String value1, String value2) {
            addCriterion("encrypt_strings between", value1, value2, "encryptStrings");
            return (Criteria) this;
        }

        public Criteria andEncryptStringsNotBetween(String value1, String value2) {
            addCriterion("encrypt_strings not between", value1, value2, "encryptStrings");
            return (Criteria) this;
        }

        public Criteria andSwitchFlagIsNull() {
            addCriterion("switch_flag is null");
            return (Criteria) this;
        }

        public Criteria andSwitchFlagIsNotNull() {
            addCriterion("switch_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSwitchFlagEqualTo(Integer value) {
            addCriterion("switch_flag =", value, "switchFlag");
            return (Criteria) this;
        }

        public Criteria andSwitchFlagNotEqualTo(Integer value) {
            addCriterion("switch_flag <>", value, "switchFlag");
            return (Criteria) this;
        }

        public Criteria andSwitchFlagGreaterThan(Integer value) {
            addCriterion("switch_flag >", value, "switchFlag");
            return (Criteria) this;
        }

        public Criteria andSwitchFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("switch_flag >=", value, "switchFlag");
            return (Criteria) this;
        }

        public Criteria andSwitchFlagLessThan(Integer value) {
            addCriterion("switch_flag <", value, "switchFlag");
            return (Criteria) this;
        }

        public Criteria andSwitchFlagLessThanOrEqualTo(Integer value) {
            addCriterion("switch_flag <=", value, "switchFlag");
            return (Criteria) this;
        }

        public Criteria andSwitchFlagIn(List<Integer> values) {
            addCriterion("switch_flag in", values, "switchFlag");
            return (Criteria) this;
        }

        public Criteria andSwitchFlagNotIn(List<Integer> values) {
            addCriterion("switch_flag not in", values, "switchFlag");
            return (Criteria) this;
        }

        public Criteria andSwitchFlagBetween(Integer value1, Integer value2) {
            addCriterion("switch_flag between", value1, value2, "switchFlag");
            return (Criteria) this;
        }

        public Criteria andSwitchFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("switch_flag not between", value1, value2, "switchFlag");
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