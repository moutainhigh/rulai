package com.unicdata.entity.boutique;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoutiqueSupplierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BoutiqueSupplierExample() {
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

        public Criteria andFineBrandIdIsNull() {
            addCriterion("fine_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andFineBrandIdIsNotNull() {
            addCriterion("fine_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andFineBrandIdEqualTo(Integer value) {
            addCriterion("fine_brand_id =", value, "fineBrandId");
            return (Criteria) this;
        }

        public Criteria andFineBrandIdNotEqualTo(Integer value) {
            addCriterion("fine_brand_id <>", value, "fineBrandId");
            return (Criteria) this;
        }

        public Criteria andFineBrandIdGreaterThan(Integer value) {
            addCriterion("fine_brand_id >", value, "fineBrandId");
            return (Criteria) this;
        }

        public Criteria andFineBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fine_brand_id >=", value, "fineBrandId");
            return (Criteria) this;
        }

        public Criteria andFineBrandIdLessThan(Integer value) {
            addCriterion("fine_brand_id <", value, "fineBrandId");
            return (Criteria) this;
        }

        public Criteria andFineBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("fine_brand_id <=", value, "fineBrandId");
            return (Criteria) this;
        }

        public Criteria andFineBrandIdIn(List<Integer> values) {
            addCriterion("fine_brand_id in", values, "fineBrandId");
            return (Criteria) this;
        }

        public Criteria andFineBrandIdNotIn(List<Integer> values) {
            addCriterion("fine_brand_id not in", values, "fineBrandId");
            return (Criteria) this;
        }

        public Criteria andFineBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("fine_brand_id between", value1, value2, "fineBrandId");
            return (Criteria) this;
        }

        public Criteria andFineBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fine_brand_id not between", value1, value2, "fineBrandId");
            return (Criteria) this;
        }

        public Criteria andCompanyTelIsNull() {
            addCriterion("company_tel is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTelIsNotNull() {
            addCriterion("company_tel is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTelEqualTo(String value) {
            addCriterion("company_tel =", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelNotEqualTo(String value) {
            addCriterion("company_tel <>", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelGreaterThan(String value) {
            addCriterion("company_tel >", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelGreaterThanOrEqualTo(String value) {
            addCriterion("company_tel >=", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelLessThan(String value) {
            addCriterion("company_tel <", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelLessThanOrEqualTo(String value) {
            addCriterion("company_tel <=", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelLike(String value) {
            addCriterion("company_tel like", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelNotLike(String value) {
            addCriterion("company_tel not like", value, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelIn(List<String> values) {
            addCriterion("company_tel in", values, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelNotIn(List<String> values) {
            addCriterion("company_tel not in", values, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelBetween(String value1, String value2) {
            addCriterion("company_tel between", value1, value2, "companyTel");
            return (Criteria) this;
        }

        public Criteria andCompanyTelNotBetween(String value1, String value2) {
            addCriterion("company_tel not between", value1, value2, "companyTel");
            return (Criteria) this;
        }

        public Criteria andContactsOneIsNull() {
            addCriterion("contacts_one is null");
            return (Criteria) this;
        }

        public Criteria andContactsOneIsNotNull() {
            addCriterion("contacts_one is not null");
            return (Criteria) this;
        }

        public Criteria andContactsOneEqualTo(String value) {
            addCriterion("contacts_one =", value, "contactsOne");
            return (Criteria) this;
        }

        public Criteria andContactsOneNotEqualTo(String value) {
            addCriterion("contacts_one <>", value, "contactsOne");
            return (Criteria) this;
        }

        public Criteria andContactsOneGreaterThan(String value) {
            addCriterion("contacts_one >", value, "contactsOne");
            return (Criteria) this;
        }

        public Criteria andContactsOneGreaterThanOrEqualTo(String value) {
            addCriterion("contacts_one >=", value, "contactsOne");
            return (Criteria) this;
        }

        public Criteria andContactsOneLessThan(String value) {
            addCriterion("contacts_one <", value, "contactsOne");
            return (Criteria) this;
        }

        public Criteria andContactsOneLessThanOrEqualTo(String value) {
            addCriterion("contacts_one <=", value, "contactsOne");
            return (Criteria) this;
        }

        public Criteria andContactsOneLike(String value) {
            addCriterion("contacts_one like", value, "contactsOne");
            return (Criteria) this;
        }

        public Criteria andContactsOneNotLike(String value) {
            addCriterion("contacts_one not like", value, "contactsOne");
            return (Criteria) this;
        }

        public Criteria andContactsOneIn(List<String> values) {
            addCriterion("contacts_one in", values, "contactsOne");
            return (Criteria) this;
        }

        public Criteria andContactsOneNotIn(List<String> values) {
            addCriterion("contacts_one not in", values, "contactsOne");
            return (Criteria) this;
        }

        public Criteria andContactsOneBetween(String value1, String value2) {
            addCriterion("contacts_one between", value1, value2, "contactsOne");
            return (Criteria) this;
        }

        public Criteria andContactsOneNotBetween(String value1, String value2) {
            addCriterion("contacts_one not between", value1, value2, "contactsOne");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneIsNull() {
            addCriterion("contacts_one_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneIsNotNull() {
            addCriterion("contacts_one_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneEqualTo(String value) {
            addCriterion("contacts_one_phone =", value, "contactsOnePhone");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneNotEqualTo(String value) {
            addCriterion("contacts_one_phone <>", value, "contactsOnePhone");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneGreaterThan(String value) {
            addCriterion("contacts_one_phone >", value, "contactsOnePhone");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contacts_one_phone >=", value, "contactsOnePhone");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneLessThan(String value) {
            addCriterion("contacts_one_phone <", value, "contactsOnePhone");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneLessThanOrEqualTo(String value) {
            addCriterion("contacts_one_phone <=", value, "contactsOnePhone");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneLike(String value) {
            addCriterion("contacts_one_phone like", value, "contactsOnePhone");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneNotLike(String value) {
            addCriterion("contacts_one_phone not like", value, "contactsOnePhone");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneIn(List<String> values) {
            addCriterion("contacts_one_phone in", values, "contactsOnePhone");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneNotIn(List<String> values) {
            addCriterion("contacts_one_phone not in", values, "contactsOnePhone");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneBetween(String value1, String value2) {
            addCriterion("contacts_one_phone between", value1, value2, "contactsOnePhone");
            return (Criteria) this;
        }

        public Criteria andContactsOnePhoneNotBetween(String value1, String value2) {
            addCriterion("contacts_one_phone not between", value1, value2, "contactsOnePhone");
            return (Criteria) this;
        }

        public Criteria andContactsTwoIsNull() {
            addCriterion("contacts_two is null");
            return (Criteria) this;
        }

        public Criteria andContactsTwoIsNotNull() {
            addCriterion("contacts_two is not null");
            return (Criteria) this;
        }

        public Criteria andContactsTwoEqualTo(String value) {
            addCriterion("contacts_two =", value, "contactsTwo");
            return (Criteria) this;
        }

        public Criteria andContactsTwoNotEqualTo(String value) {
            addCriterion("contacts_two <>", value, "contactsTwo");
            return (Criteria) this;
        }

        public Criteria andContactsTwoGreaterThan(String value) {
            addCriterion("contacts_two >", value, "contactsTwo");
            return (Criteria) this;
        }

        public Criteria andContactsTwoGreaterThanOrEqualTo(String value) {
            addCriterion("contacts_two >=", value, "contactsTwo");
            return (Criteria) this;
        }

        public Criteria andContactsTwoLessThan(String value) {
            addCriterion("contacts_two <", value, "contactsTwo");
            return (Criteria) this;
        }

        public Criteria andContactsTwoLessThanOrEqualTo(String value) {
            addCriterion("contacts_two <=", value, "contactsTwo");
            return (Criteria) this;
        }

        public Criteria andContactsTwoLike(String value) {
            addCriterion("contacts_two like", value, "contactsTwo");
            return (Criteria) this;
        }

        public Criteria andContactsTwoNotLike(String value) {
            addCriterion("contacts_two not like", value, "contactsTwo");
            return (Criteria) this;
        }

        public Criteria andContactsTwoIn(List<String> values) {
            addCriterion("contacts_two in", values, "contactsTwo");
            return (Criteria) this;
        }

        public Criteria andContactsTwoNotIn(List<String> values) {
            addCriterion("contacts_two not in", values, "contactsTwo");
            return (Criteria) this;
        }

        public Criteria andContactsTwoBetween(String value1, String value2) {
            addCriterion("contacts_two between", value1, value2, "contactsTwo");
            return (Criteria) this;
        }

        public Criteria andContactsTwoNotBetween(String value1, String value2) {
            addCriterion("contacts_two not between", value1, value2, "contactsTwo");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneIsNull() {
            addCriterion("contacts_two_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneIsNotNull() {
            addCriterion("contacts_two_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneEqualTo(String value) {
            addCriterion("contacts_two_phone =", value, "contactsTwoPhone");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneNotEqualTo(String value) {
            addCriterion("contacts_two_phone <>", value, "contactsTwoPhone");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneGreaterThan(String value) {
            addCriterion("contacts_two_phone >", value, "contactsTwoPhone");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contacts_two_phone >=", value, "contactsTwoPhone");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneLessThan(String value) {
            addCriterion("contacts_two_phone <", value, "contactsTwoPhone");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneLessThanOrEqualTo(String value) {
            addCriterion("contacts_two_phone <=", value, "contactsTwoPhone");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneLike(String value) {
            addCriterion("contacts_two_phone like", value, "contactsTwoPhone");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneNotLike(String value) {
            addCriterion("contacts_two_phone not like", value, "contactsTwoPhone");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneIn(List<String> values) {
            addCriterion("contacts_two_phone in", values, "contactsTwoPhone");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneNotIn(List<String> values) {
            addCriterion("contacts_two_phone not in", values, "contactsTwoPhone");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneBetween(String value1, String value2) {
            addCriterion("contacts_two_phone between", value1, value2, "contactsTwoPhone");
            return (Criteria) this;
        }

        public Criteria andContactsTwoPhoneNotBetween(String value1, String value2) {
            addCriterion("contacts_two_phone not between", value1, value2, "contactsTwoPhone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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