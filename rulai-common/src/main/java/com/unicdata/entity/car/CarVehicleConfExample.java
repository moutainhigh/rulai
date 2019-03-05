package com.unicdata.entity.car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarVehicleConfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarVehicleConfExample() {
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

        public Criteria andDistributorStoreIdIsNull() {
            addCriterion("distributor_store_id is null");
            return (Criteria) this;
        }

        public Criteria andDistributorStoreIdIsNotNull() {
            addCriterion("distributor_store_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistributorStoreIdEqualTo(Integer value) {
            addCriterion("distributor_store_id =", value, "distributorStoreId");
            return (Criteria) this;
        }

        public Criteria andDistributorStoreIdNotEqualTo(Integer value) {
            addCriterion("distributor_store_id <>", value, "distributorStoreId");
            return (Criteria) this;
        }

        public Criteria andDistributorStoreIdGreaterThan(Integer value) {
            addCriterion("distributor_store_id >", value, "distributorStoreId");
            return (Criteria) this;
        }

        public Criteria andDistributorStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("distributor_store_id >=", value, "distributorStoreId");
            return (Criteria) this;
        }

        public Criteria andDistributorStoreIdLessThan(Integer value) {
            addCriterion("distributor_store_id <", value, "distributorStoreId");
            return (Criteria) this;
        }

        public Criteria andDistributorStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("distributor_store_id <=", value, "distributorStoreId");
            return (Criteria) this;
        }

        public Criteria andDistributorStoreIdIn(List<Integer> values) {
            addCriterion("distributor_store_id in", values, "distributorStoreId");
            return (Criteria) this;
        }

        public Criteria andDistributorStoreIdNotIn(List<Integer> values) {
            addCriterion("distributor_store_id not in", values, "distributorStoreId");
            return (Criteria) this;
        }

        public Criteria andDistributorStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("distributor_store_id between", value1, value2, "distributorStoreId");
            return (Criteria) this;
        }

        public Criteria andDistributorStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("distributor_store_id not between", value1, value2, "distributorStoreId");
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

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdIsNull() {
            addCriterion("factory_id is null");
            return (Criteria) this;
        }

        public Criteria andFactoryIdIsNotNull() {
            addCriterion("factory_id is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryIdEqualTo(Integer value) {
            addCriterion("factory_id =", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdNotEqualTo(Integer value) {
            addCriterion("factory_id <>", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdGreaterThan(Integer value) {
            addCriterion("factory_id >", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("factory_id >=", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdLessThan(Integer value) {
            addCriterion("factory_id <", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("factory_id <=", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdIn(List<Integer> values) {
            addCriterion("factory_id in", values, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdNotIn(List<Integer> values) {
            addCriterion("factory_id not in", values, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdBetween(Integer value1, Integer value2) {
            addCriterion("factory_id between", value1, value2, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("factory_id not between", value1, value2, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdIsNull() {
            addCriterion("family_id is null");
            return (Criteria) this;
        }

        public Criteria andFamilyIdIsNotNull() {
            addCriterion("family_id is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyIdEqualTo(Integer value) {
            addCriterion("family_id =", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdNotEqualTo(Integer value) {
            addCriterion("family_id <>", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdGreaterThan(Integer value) {
            addCriterion("family_id >", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("family_id >=", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdLessThan(Integer value) {
            addCriterion("family_id <", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdLessThanOrEqualTo(Integer value) {
            addCriterion("family_id <=", value, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdIn(List<Integer> values) {
            addCriterion("family_id in", values, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdNotIn(List<Integer> values) {
            addCriterion("family_id not in", values, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdBetween(Integer value1, Integer value2) {
            addCriterion("family_id between", value1, value2, "familyId");
            return (Criteria) this;
        }

        public Criteria andFamilyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("family_id not between", value1, value2, "familyId");
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

        public Criteria andGuidePriceIsNull() {
            addCriterion("guide_price is null");
            return (Criteria) this;
        }

        public Criteria andGuidePriceIsNotNull() {
            addCriterion("guide_price is not null");
            return (Criteria) this;
        }

        public Criteria andGuidePriceEqualTo(BigDecimal value) {
            addCriterion("guide_price =", value, "guidePrice");
            return (Criteria) this;
        }

        public Criteria andGuidePriceNotEqualTo(BigDecimal value) {
            addCriterion("guide_price <>", value, "guidePrice");
            return (Criteria) this;
        }

        public Criteria andGuidePriceGreaterThan(BigDecimal value) {
            addCriterion("guide_price >", value, "guidePrice");
            return (Criteria) this;
        }

        public Criteria andGuidePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("guide_price >=", value, "guidePrice");
            return (Criteria) this;
        }

        public Criteria andGuidePriceLessThan(BigDecimal value) {
            addCriterion("guide_price <", value, "guidePrice");
            return (Criteria) this;
        }

        public Criteria andGuidePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("guide_price <=", value, "guidePrice");
            return (Criteria) this;
        }

        public Criteria andGuidePriceIn(List<BigDecimal> values) {
            addCriterion("guide_price in", values, "guidePrice");
            return (Criteria) this;
        }

        public Criteria andGuidePriceNotIn(List<BigDecimal> values) {
            addCriterion("guide_price not in", values, "guidePrice");
            return (Criteria) this;
        }

        public Criteria andGuidePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("guide_price between", value1, value2, "guidePrice");
            return (Criteria) this;
        }

        public Criteria andGuidePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("guide_price not between", value1, value2, "guidePrice");
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

        public Criteria andLevelOneIsNull() {
            addCriterion("level_one is null");
            return (Criteria) this;
        }

        public Criteria andLevelOneIsNotNull() {
            addCriterion("level_one is not null");
            return (Criteria) this;
        }

        public Criteria andLevelOneEqualTo(BigDecimal value) {
            addCriterion("level_one =", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneNotEqualTo(BigDecimal value) {
            addCriterion("level_one <>", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneGreaterThan(BigDecimal value) {
            addCriterion("level_one >", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("level_one >=", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneLessThan(BigDecimal value) {
            addCriterion("level_one <", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneLessThanOrEqualTo(BigDecimal value) {
            addCriterion("level_one <=", value, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneIn(List<BigDecimal> values) {
            addCriterion("level_one in", values, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneNotIn(List<BigDecimal> values) {
            addCriterion("level_one not in", values, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_one between", value1, value2, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelOneNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_one not between", value1, value2, "levelOne");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsNull() {
            addCriterion("level_two is null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIsNotNull() {
            addCriterion("level_two is not null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoEqualTo(BigDecimal value) {
            addCriterion("level_two =", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoNotEqualTo(BigDecimal value) {
            addCriterion("level_two <>", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoGreaterThan(BigDecimal value) {
            addCriterion("level_two >", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("level_two >=", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoLessThan(BigDecimal value) {
            addCriterion("level_two <", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("level_two <=", value, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoIn(List<BigDecimal> values) {
            addCriterion("level_two in", values, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoNotIn(List<BigDecimal> values) {
            addCriterion("level_two not in", values, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_two between", value1, value2, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelTwoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_two not between", value1, value2, "levelTwo");
            return (Criteria) this;
        }

        public Criteria andLevelThreeIsNull() {
            addCriterion("level_three is null");
            return (Criteria) this;
        }

        public Criteria andLevelThreeIsNotNull() {
            addCriterion("level_three is not null");
            return (Criteria) this;
        }

        public Criteria andLevelThreeEqualTo(BigDecimal value) {
            addCriterion("level_three =", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeNotEqualTo(BigDecimal value) {
            addCriterion("level_three <>", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeGreaterThan(BigDecimal value) {
            addCriterion("level_three >", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("level_three >=", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeLessThan(BigDecimal value) {
            addCriterion("level_three <", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("level_three <=", value, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeIn(List<BigDecimal> values) {
            addCriterion("level_three in", values, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeNotIn(List<BigDecimal> values) {
            addCriterion("level_three not in", values, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_three between", value1, value2, "levelThree");
            return (Criteria) this;
        }

        public Criteria andLevelThreeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_three not between", value1, value2, "levelThree");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(Integer value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(Integer value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(Integer value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(Integer value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<Integer> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<Integer> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(Integer value1, Integer value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andSellStatusIsNull() {
            addCriterion("sell_status is null");
            return (Criteria) this;
        }

        public Criteria andSellStatusIsNotNull() {
            addCriterion("sell_status is not null");
            return (Criteria) this;
        }

        public Criteria andSellStatusEqualTo(Integer value) {
            addCriterion("sell_status =", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusNotEqualTo(Integer value) {
            addCriterion("sell_status <>", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusGreaterThan(Integer value) {
            addCriterion("sell_status >", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_status >=", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusLessThan(Integer value) {
            addCriterion("sell_status <", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sell_status <=", value, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusIn(List<Integer> values) {
            addCriterion("sell_status in", values, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusNotIn(List<Integer> values) {
            addCriterion("sell_status not in", values, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusBetween(Integer value1, Integer value2) {
            addCriterion("sell_status between", value1, value2, "sellStatus");
            return (Criteria) this;
        }

        public Criteria andSellStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_status not between", value1, value2, "sellStatus");
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

        public Criteria andLevelOneAdjustIsNull() {
            addCriterion("level_one_adjust is null");
            return (Criteria) this;
        }

        public Criteria andLevelOneAdjustIsNotNull() {
            addCriterion("level_one_adjust is not null");
            return (Criteria) this;
        }

        public Criteria andLevelOneAdjustEqualTo(BigDecimal value) {
            addCriterion("level_one_adjust =", value, "levelOneAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelOneAdjustNotEqualTo(BigDecimal value) {
            addCriterion("level_one_adjust <>", value, "levelOneAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelOneAdjustGreaterThan(BigDecimal value) {
            addCriterion("level_one_adjust >", value, "levelOneAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelOneAdjustGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("level_one_adjust >=", value, "levelOneAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelOneAdjustLessThan(BigDecimal value) {
            addCriterion("level_one_adjust <", value, "levelOneAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelOneAdjustLessThanOrEqualTo(BigDecimal value) {
            addCriterion("level_one_adjust <=", value, "levelOneAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelOneAdjustIn(List<BigDecimal> values) {
            addCriterion("level_one_adjust in", values, "levelOneAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelOneAdjustNotIn(List<BigDecimal> values) {
            addCriterion("level_one_adjust not in", values, "levelOneAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelOneAdjustBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_one_adjust between", value1, value2, "levelOneAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelOneAdjustNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_one_adjust not between", value1, value2, "levelOneAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelTwoAdjustIsNull() {
            addCriterion("level_two_adjust is null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoAdjustIsNotNull() {
            addCriterion("level_two_adjust is not null");
            return (Criteria) this;
        }

        public Criteria andLevelTwoAdjustEqualTo(BigDecimal value) {
            addCriterion("level_two_adjust =", value, "levelTwoAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelTwoAdjustNotEqualTo(BigDecimal value) {
            addCriterion("level_two_adjust <>", value, "levelTwoAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelTwoAdjustGreaterThan(BigDecimal value) {
            addCriterion("level_two_adjust >", value, "levelTwoAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelTwoAdjustGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("level_two_adjust >=", value, "levelTwoAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelTwoAdjustLessThan(BigDecimal value) {
            addCriterion("level_two_adjust <", value, "levelTwoAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelTwoAdjustLessThanOrEqualTo(BigDecimal value) {
            addCriterion("level_two_adjust <=", value, "levelTwoAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelTwoAdjustIn(List<BigDecimal> values) {
            addCriterion("level_two_adjust in", values, "levelTwoAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelTwoAdjustNotIn(List<BigDecimal> values) {
            addCriterion("level_two_adjust not in", values, "levelTwoAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelTwoAdjustBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_two_adjust between", value1, value2, "levelTwoAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelTwoAdjustNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_two_adjust not between", value1, value2, "levelTwoAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelThreeAdjustIsNull() {
            addCriterion("level_three_adjust is null");
            return (Criteria) this;
        }

        public Criteria andLevelThreeAdjustIsNotNull() {
            addCriterion("level_three_adjust is not null");
            return (Criteria) this;
        }

        public Criteria andLevelThreeAdjustEqualTo(BigDecimal value) {
            addCriterion("level_three_adjust =", value, "levelThreeAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelThreeAdjustNotEqualTo(BigDecimal value) {
            addCriterion("level_three_adjust <>", value, "levelThreeAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelThreeAdjustGreaterThan(BigDecimal value) {
            addCriterion("level_three_adjust >", value, "levelThreeAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelThreeAdjustGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("level_three_adjust >=", value, "levelThreeAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelThreeAdjustLessThan(BigDecimal value) {
            addCriterion("level_three_adjust <", value, "levelThreeAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelThreeAdjustLessThanOrEqualTo(BigDecimal value) {
            addCriterion("level_three_adjust <=", value, "levelThreeAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelThreeAdjustIn(List<BigDecimal> values) {
            addCriterion("level_three_adjust in", values, "levelThreeAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelThreeAdjustNotIn(List<BigDecimal> values) {
            addCriterion("level_three_adjust not in", values, "levelThreeAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelThreeAdjustBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_three_adjust between", value1, value2, "levelThreeAdjust");
            return (Criteria) this;
        }

        public Criteria andLevelThreeAdjustNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("level_three_adjust not between", value1, value2, "levelThreeAdjust");
            return (Criteria) this;
        }

        public Criteria andAdjustStatusIsNull() {
            addCriterion("adjust_status is null");
            return (Criteria) this;
        }

        public Criteria andAdjustStatusIsNotNull() {
            addCriterion("adjust_status is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustStatusEqualTo(Integer value) {
            addCriterion("adjust_status =", value, "adjustStatus");
            return (Criteria) this;
        }

        public Criteria andAdjustStatusNotEqualTo(Integer value) {
            addCriterion("adjust_status <>", value, "adjustStatus");
            return (Criteria) this;
        }

        public Criteria andAdjustStatusGreaterThan(Integer value) {
            addCriterion("adjust_status >", value, "adjustStatus");
            return (Criteria) this;
        }

        public Criteria andAdjustStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("adjust_status >=", value, "adjustStatus");
            return (Criteria) this;
        }

        public Criteria andAdjustStatusLessThan(Integer value) {
            addCriterion("adjust_status <", value, "adjustStatus");
            return (Criteria) this;
        }

        public Criteria andAdjustStatusLessThanOrEqualTo(Integer value) {
            addCriterion("adjust_status <=", value, "adjustStatus");
            return (Criteria) this;
        }

        public Criteria andAdjustStatusIn(List<Integer> values) {
            addCriterion("adjust_status in", values, "adjustStatus");
            return (Criteria) this;
        }

        public Criteria andAdjustStatusNotIn(List<Integer> values) {
            addCriterion("adjust_status not in", values, "adjustStatus");
            return (Criteria) this;
        }

        public Criteria andAdjustStatusBetween(Integer value1, Integer value2) {
            addCriterion("adjust_status between", value1, value2, "adjustStatus");
            return (Criteria) this;
        }

        public Criteria andAdjustStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("adjust_status not between", value1, value2, "adjustStatus");
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