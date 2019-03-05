package com.unicdata.entity.car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarGoodInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarGoodInfoExample() {
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

        public Criteria andCarOrderIdIsNull() {
            addCriterion("car_order_id is null");
            return (Criteria) this;
        }

        public Criteria andCarOrderIdIsNotNull() {
            addCriterion("car_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarOrderIdEqualTo(Integer value) {
            addCriterion("car_order_id =", value, "carOrderId");
            return (Criteria) this;
        }

        public Criteria andCarOrderIdNotEqualTo(Integer value) {
            addCriterion("car_order_id <>", value, "carOrderId");
            return (Criteria) this;
        }

        public Criteria andCarOrderIdGreaterThan(Integer value) {
            addCriterion("car_order_id >", value, "carOrderId");
            return (Criteria) this;
        }

        public Criteria andCarOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_order_id >=", value, "carOrderId");
            return (Criteria) this;
        }

        public Criteria andCarOrderIdLessThan(Integer value) {
            addCriterion("car_order_id <", value, "carOrderId");
            return (Criteria) this;
        }

        public Criteria andCarOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_order_id <=", value, "carOrderId");
            return (Criteria) this;
        }

        public Criteria andCarOrderIdIn(List<Integer> values) {
            addCriterion("car_order_id in", values, "carOrderId");
            return (Criteria) this;
        }

        public Criteria andCarOrderIdNotIn(List<Integer> values) {
            addCriterion("car_order_id not in", values, "carOrderId");
            return (Criteria) this;
        }

        public Criteria andCarOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("car_order_id between", value1, value2, "carOrderId");
            return (Criteria) this;
        }

        public Criteria andCarOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_order_id not between", value1, value2, "carOrderId");
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

        public Criteria andVinIsNull() {
            addCriterion("vin is null");
            return (Criteria) this;
        }

        public Criteria andVinIsNotNull() {
            addCriterion("vin is not null");
            return (Criteria) this;
        }

        public Criteria andVinEqualTo(String value) {
            addCriterion("vin =", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotEqualTo(String value) {
            addCriterion("vin <>", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThan(String value) {
            addCriterion("vin >", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThanOrEqualTo(String value) {
            addCriterion("vin >=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThan(String value) {
            addCriterion("vin <", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThanOrEqualTo(String value) {
            addCriterion("vin <=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLike(String value) {
            addCriterion("vin like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotLike(String value) {
            addCriterion("vin not like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinIn(List<String> values) {
            addCriterion("vin in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotIn(List<String> values) {
            addCriterion("vin not in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinBetween(String value1, String value2) {
            addCriterion("vin between", value1, value2, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotBetween(String value1, String value2) {
            addCriterion("vin not between", value1, value2, "vin");
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

        public Criteria andFundPropertyIsNull() {
            addCriterion("fund_property is null");
            return (Criteria) this;
        }

        public Criteria andFundPropertyIsNotNull() {
            addCriterion("fund_property is not null");
            return (Criteria) this;
        }

        public Criteria andFundPropertyEqualTo(Integer value) {
            addCriterion("fund_property =", value, "fundProperty");
            return (Criteria) this;
        }

        public Criteria andFundPropertyNotEqualTo(Integer value) {
            addCriterion("fund_property <>", value, "fundProperty");
            return (Criteria) this;
        }

        public Criteria andFundPropertyGreaterThan(Integer value) {
            addCriterion("fund_property >", value, "fundProperty");
            return (Criteria) this;
        }

        public Criteria andFundPropertyGreaterThanOrEqualTo(Integer value) {
            addCriterion("fund_property >=", value, "fundProperty");
            return (Criteria) this;
        }

        public Criteria andFundPropertyLessThan(Integer value) {
            addCriterion("fund_property <", value, "fundProperty");
            return (Criteria) this;
        }

        public Criteria andFundPropertyLessThanOrEqualTo(Integer value) {
            addCriterion("fund_property <=", value, "fundProperty");
            return (Criteria) this;
        }

        public Criteria andFundPropertyIn(List<Integer> values) {
            addCriterion("fund_property in", values, "fundProperty");
            return (Criteria) this;
        }

        public Criteria andFundPropertyNotIn(List<Integer> values) {
            addCriterion("fund_property not in", values, "fundProperty");
            return (Criteria) this;
        }

        public Criteria andFundPropertyBetween(Integer value1, Integer value2) {
            addCriterion("fund_property between", value1, value2, "fundProperty");
            return (Criteria) this;
        }

        public Criteria andFundPropertyNotBetween(Integer value1, Integer value2) {
            addCriterion("fund_property not between", value1, value2, "fundProperty");
            return (Criteria) this;
        }

        public Criteria andEngineNameIsNull() {
            addCriterion("engine_name is null");
            return (Criteria) this;
        }

        public Criteria andEngineNameIsNotNull() {
            addCriterion("engine_name is not null");
            return (Criteria) this;
        }

        public Criteria andEngineNameEqualTo(String value) {
            addCriterion("engine_name =", value, "engineName");
            return (Criteria) this;
        }

        public Criteria andEngineNameNotEqualTo(String value) {
            addCriterion("engine_name <>", value, "engineName");
            return (Criteria) this;
        }

        public Criteria andEngineNameGreaterThan(String value) {
            addCriterion("engine_name >", value, "engineName");
            return (Criteria) this;
        }

        public Criteria andEngineNameGreaterThanOrEqualTo(String value) {
            addCriterion("engine_name >=", value, "engineName");
            return (Criteria) this;
        }

        public Criteria andEngineNameLessThan(String value) {
            addCriterion("engine_name <", value, "engineName");
            return (Criteria) this;
        }

        public Criteria andEngineNameLessThanOrEqualTo(String value) {
            addCriterion("engine_name <=", value, "engineName");
            return (Criteria) this;
        }

        public Criteria andEngineNameLike(String value) {
            addCriterion("engine_name like", value, "engineName");
            return (Criteria) this;
        }

        public Criteria andEngineNameNotLike(String value) {
            addCriterion("engine_name not like", value, "engineName");
            return (Criteria) this;
        }

        public Criteria andEngineNameIn(List<String> values) {
            addCriterion("engine_name in", values, "engineName");
            return (Criteria) this;
        }

        public Criteria andEngineNameNotIn(List<String> values) {
            addCriterion("engine_name not in", values, "engineName");
            return (Criteria) this;
        }

        public Criteria andEngineNameBetween(String value1, String value2) {
            addCriterion("engine_name between", value1, value2, "engineName");
            return (Criteria) this;
        }

        public Criteria andEngineNameNotBetween(String value1, String value2) {
            addCriterion("engine_name not between", value1, value2, "engineName");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutIdIsNull() {
            addCriterion("decorations_out_id is null");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutIdIsNotNull() {
            addCriterion("decorations_out_id is not null");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutIdEqualTo(Integer value) {
            addCriterion("decorations_out_id =", value, "decorationsOutId");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutIdNotEqualTo(Integer value) {
            addCriterion("decorations_out_id <>", value, "decorationsOutId");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutIdGreaterThan(Integer value) {
            addCriterion("decorations_out_id >", value, "decorationsOutId");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("decorations_out_id >=", value, "decorationsOutId");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutIdLessThan(Integer value) {
            addCriterion("decorations_out_id <", value, "decorationsOutId");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutIdLessThanOrEqualTo(Integer value) {
            addCriterion("decorations_out_id <=", value, "decorationsOutId");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutIdIn(List<Integer> values) {
            addCriterion("decorations_out_id in", values, "decorationsOutId");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutIdNotIn(List<Integer> values) {
            addCriterion("decorations_out_id not in", values, "decorationsOutId");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutIdBetween(Integer value1, Integer value2) {
            addCriterion("decorations_out_id between", value1, value2, "decorationsOutId");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutIdNotBetween(Integer value1, Integer value2) {
            addCriterion("decorations_out_id not between", value1, value2, "decorationsOutId");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameIsNull() {
            addCriterion("decorations_out_name is null");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameIsNotNull() {
            addCriterion("decorations_out_name is not null");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameEqualTo(String value) {
            addCriterion("decorations_out_name =", value, "decorationsOutName");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameNotEqualTo(String value) {
            addCriterion("decorations_out_name <>", value, "decorationsOutName");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameGreaterThan(String value) {
            addCriterion("decorations_out_name >", value, "decorationsOutName");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameGreaterThanOrEqualTo(String value) {
            addCriterion("decorations_out_name >=", value, "decorationsOutName");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameLessThan(String value) {
            addCriterion("decorations_out_name <", value, "decorationsOutName");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameLessThanOrEqualTo(String value) {
            addCriterion("decorations_out_name <=", value, "decorationsOutName");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameLike(String value) {
            addCriterion("decorations_out_name like", value, "decorationsOutName");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameNotLike(String value) {
            addCriterion("decorations_out_name not like", value, "decorationsOutName");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameIn(List<String> values) {
            addCriterion("decorations_out_name in", values, "decorationsOutName");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameNotIn(List<String> values) {
            addCriterion("decorations_out_name not in", values, "decorationsOutName");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameBetween(String value1, String value2) {
            addCriterion("decorations_out_name between", value1, value2, "decorationsOutName");
            return (Criteria) this;
        }

        public Criteria andDecorationsOutNameNotBetween(String value1, String value2) {
            addCriterion("decorations_out_name not between", value1, value2, "decorationsOutName");
            return (Criteria) this;
        }

        public Criteria andDecorationsInIdIsNull() {
            addCriterion("decorations_in_id is null");
            return (Criteria) this;
        }

        public Criteria andDecorationsInIdIsNotNull() {
            addCriterion("decorations_in_id is not null");
            return (Criteria) this;
        }

        public Criteria andDecorationsInIdEqualTo(Integer value) {
            addCriterion("decorations_in_id =", value, "decorationsInId");
            return (Criteria) this;
        }

        public Criteria andDecorationsInIdNotEqualTo(Integer value) {
            addCriterion("decorations_in_id <>", value, "decorationsInId");
            return (Criteria) this;
        }

        public Criteria andDecorationsInIdGreaterThan(Integer value) {
            addCriterion("decorations_in_id >", value, "decorationsInId");
            return (Criteria) this;
        }

        public Criteria andDecorationsInIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("decorations_in_id >=", value, "decorationsInId");
            return (Criteria) this;
        }

        public Criteria andDecorationsInIdLessThan(Integer value) {
            addCriterion("decorations_in_id <", value, "decorationsInId");
            return (Criteria) this;
        }

        public Criteria andDecorationsInIdLessThanOrEqualTo(Integer value) {
            addCriterion("decorations_in_id <=", value, "decorationsInId");
            return (Criteria) this;
        }

        public Criteria andDecorationsInIdIn(List<Integer> values) {
            addCriterion("decorations_in_id in", values, "decorationsInId");
            return (Criteria) this;
        }

        public Criteria andDecorationsInIdNotIn(List<Integer> values) {
            addCriterion("decorations_in_id not in", values, "decorationsInId");
            return (Criteria) this;
        }

        public Criteria andDecorationsInIdBetween(Integer value1, Integer value2) {
            addCriterion("decorations_in_id between", value1, value2, "decorationsInId");
            return (Criteria) this;
        }

        public Criteria andDecorationsInIdNotBetween(Integer value1, Integer value2) {
            addCriterion("decorations_in_id not between", value1, value2, "decorationsInId");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameIsNull() {
            addCriterion("decorations_in_name is null");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameIsNotNull() {
            addCriterion("decorations_in_name is not null");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameEqualTo(String value) {
            addCriterion("decorations_in_name =", value, "decorationsInName");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameNotEqualTo(String value) {
            addCriterion("decorations_in_name <>", value, "decorationsInName");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameGreaterThan(String value) {
            addCriterion("decorations_in_name >", value, "decorationsInName");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameGreaterThanOrEqualTo(String value) {
            addCriterion("decorations_in_name >=", value, "decorationsInName");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameLessThan(String value) {
            addCriterion("decorations_in_name <", value, "decorationsInName");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameLessThanOrEqualTo(String value) {
            addCriterion("decorations_in_name <=", value, "decorationsInName");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameLike(String value) {
            addCriterion("decorations_in_name like", value, "decorationsInName");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameNotLike(String value) {
            addCriterion("decorations_in_name not like", value, "decorationsInName");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameIn(List<String> values) {
            addCriterion("decorations_in_name in", values, "decorationsInName");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameNotIn(List<String> values) {
            addCriterion("decorations_in_name not in", values, "decorationsInName");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameBetween(String value1, String value2) {
            addCriterion("decorations_in_name between", value1, value2, "decorationsInName");
            return (Criteria) this;
        }

        public Criteria andDecorationsInNameNotBetween(String value1, String value2) {
            addCriterion("decorations_in_name not between", value1, value2, "decorationsInName");
            return (Criteria) this;
        }

        public Criteria andEngineNumIsNull() {
            addCriterion("engine_num is null");
            return (Criteria) this;
        }

        public Criteria andEngineNumIsNotNull() {
            addCriterion("engine_num is not null");
            return (Criteria) this;
        }

        public Criteria andEngineNumEqualTo(String value) {
            addCriterion("engine_num =", value, "engineNum");
            return (Criteria) this;
        }

        public Criteria andEngineNumNotEqualTo(String value) {
            addCriterion("engine_num <>", value, "engineNum");
            return (Criteria) this;
        }

        public Criteria andEngineNumGreaterThan(String value) {
            addCriterion("engine_num >", value, "engineNum");
            return (Criteria) this;
        }

        public Criteria andEngineNumGreaterThanOrEqualTo(String value) {
            addCriterion("engine_num >=", value, "engineNum");
            return (Criteria) this;
        }

        public Criteria andEngineNumLessThan(String value) {
            addCriterion("engine_num <", value, "engineNum");
            return (Criteria) this;
        }

        public Criteria andEngineNumLessThanOrEqualTo(String value) {
            addCriterion("engine_num <=", value, "engineNum");
            return (Criteria) this;
        }

        public Criteria andEngineNumLike(String value) {
            addCriterion("engine_num like", value, "engineNum");
            return (Criteria) this;
        }

        public Criteria andEngineNumNotLike(String value) {
            addCriterion("engine_num not like", value, "engineNum");
            return (Criteria) this;
        }

        public Criteria andEngineNumIn(List<String> values) {
            addCriterion("engine_num in", values, "engineNum");
            return (Criteria) this;
        }

        public Criteria andEngineNumNotIn(List<String> values) {
            addCriterion("engine_num not in", values, "engineNum");
            return (Criteria) this;
        }

        public Criteria andEngineNumBetween(String value1, String value2) {
            addCriterion("engine_num between", value1, value2, "engineNum");
            return (Criteria) this;
        }

        public Criteria andEngineNumNotBetween(String value1, String value2) {
            addCriterion("engine_num not between", value1, value2, "engineNum");
            return (Criteria) this;
        }

        public Criteria andKeyNumIsNull() {
            addCriterion("key_num is null");
            return (Criteria) this;
        }

        public Criteria andKeyNumIsNotNull() {
            addCriterion("key_num is not null");
            return (Criteria) this;
        }

        public Criteria andKeyNumEqualTo(String value) {
            addCriterion("key_num =", value, "keyNum");
            return (Criteria) this;
        }

        public Criteria andKeyNumNotEqualTo(String value) {
            addCriterion("key_num <>", value, "keyNum");
            return (Criteria) this;
        }

        public Criteria andKeyNumGreaterThan(String value) {
            addCriterion("key_num >", value, "keyNum");
            return (Criteria) this;
        }

        public Criteria andKeyNumGreaterThanOrEqualTo(String value) {
            addCriterion("key_num >=", value, "keyNum");
            return (Criteria) this;
        }

        public Criteria andKeyNumLessThan(String value) {
            addCriterion("key_num <", value, "keyNum");
            return (Criteria) this;
        }

        public Criteria andKeyNumLessThanOrEqualTo(String value) {
            addCriterion("key_num <=", value, "keyNum");
            return (Criteria) this;
        }

        public Criteria andKeyNumLike(String value) {
            addCriterion("key_num like", value, "keyNum");
            return (Criteria) this;
        }

        public Criteria andKeyNumNotLike(String value) {
            addCriterion("key_num not like", value, "keyNum");
            return (Criteria) this;
        }

        public Criteria andKeyNumIn(List<String> values) {
            addCriterion("key_num in", values, "keyNum");
            return (Criteria) this;
        }

        public Criteria andKeyNumNotIn(List<String> values) {
            addCriterion("key_num not in", values, "keyNum");
            return (Criteria) this;
        }

        public Criteria andKeyNumBetween(String value1, String value2) {
            addCriterion("key_num between", value1, value2, "keyNum");
            return (Criteria) this;
        }

        public Criteria andKeyNumNotBetween(String value1, String value2) {
            addCriterion("key_num not between", value1, value2, "keyNum");
            return (Criteria) this;
        }

        public Criteria andCertificationNumIsNull() {
            addCriterion("certification_num is null");
            return (Criteria) this;
        }

        public Criteria andCertificationNumIsNotNull() {
            addCriterion("certification_num is not null");
            return (Criteria) this;
        }

        public Criteria andCertificationNumEqualTo(String value) {
            addCriterion("certification_num =", value, "certificationNum");
            return (Criteria) this;
        }

        public Criteria andCertificationNumNotEqualTo(String value) {
            addCriterion("certification_num <>", value, "certificationNum");
            return (Criteria) this;
        }

        public Criteria andCertificationNumGreaterThan(String value) {
            addCriterion("certification_num >", value, "certificationNum");
            return (Criteria) this;
        }

        public Criteria andCertificationNumGreaterThanOrEqualTo(String value) {
            addCriterion("certification_num >=", value, "certificationNum");
            return (Criteria) this;
        }

        public Criteria andCertificationNumLessThan(String value) {
            addCriterion("certification_num <", value, "certificationNum");
            return (Criteria) this;
        }

        public Criteria andCertificationNumLessThanOrEqualTo(String value) {
            addCriterion("certification_num <=", value, "certificationNum");
            return (Criteria) this;
        }

        public Criteria andCertificationNumLike(String value) {
            addCriterion("certification_num like", value, "certificationNum");
            return (Criteria) this;
        }

        public Criteria andCertificationNumNotLike(String value) {
            addCriterion("certification_num not like", value, "certificationNum");
            return (Criteria) this;
        }

        public Criteria andCertificationNumIn(List<String> values) {
            addCriterion("certification_num in", values, "certificationNum");
            return (Criteria) this;
        }

        public Criteria andCertificationNumNotIn(List<String> values) {
            addCriterion("certification_num not in", values, "certificationNum");
            return (Criteria) this;
        }

        public Criteria andCertificationNumBetween(String value1, String value2) {
            addCriterion("certification_num between", value1, value2, "certificationNum");
            return (Criteria) this;
        }

        public Criteria andCertificationNumNotBetween(String value1, String value2) {
            addCriterion("certification_num not between", value1, value2, "certificationNum");
            return (Criteria) this;
        }

        public Criteria andImportNumIsNull() {
            addCriterion("import_num is null");
            return (Criteria) this;
        }

        public Criteria andImportNumIsNotNull() {
            addCriterion("import_num is not null");
            return (Criteria) this;
        }

        public Criteria andImportNumEqualTo(String value) {
            addCriterion("import_num =", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumNotEqualTo(String value) {
            addCriterion("import_num <>", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumGreaterThan(String value) {
            addCriterion("import_num >", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumGreaterThanOrEqualTo(String value) {
            addCriterion("import_num >=", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumLessThan(String value) {
            addCriterion("import_num <", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumLessThanOrEqualTo(String value) {
            addCriterion("import_num <=", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumLike(String value) {
            addCriterion("import_num like", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumNotLike(String value) {
            addCriterion("import_num not like", value, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumIn(List<String> values) {
            addCriterion("import_num in", values, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumNotIn(List<String> values) {
            addCriterion("import_num not in", values, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumBetween(String value1, String value2) {
            addCriterion("import_num between", value1, value2, "importNum");
            return (Criteria) this;
        }

        public Criteria andImportNumNotBetween(String value1, String value2) {
            addCriterion("import_num not between", value1, value2, "importNum");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumIsNull() {
            addCriterion("warranty_num is null");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumIsNotNull() {
            addCriterion("warranty_num is not null");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumEqualTo(String value) {
            addCriterion("warranty_num =", value, "warrantyNum");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumNotEqualTo(String value) {
            addCriterion("warranty_num <>", value, "warrantyNum");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumGreaterThan(String value) {
            addCriterion("warranty_num >", value, "warrantyNum");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumGreaterThanOrEqualTo(String value) {
            addCriterion("warranty_num >=", value, "warrantyNum");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumLessThan(String value) {
            addCriterion("warranty_num <", value, "warrantyNum");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumLessThanOrEqualTo(String value) {
            addCriterion("warranty_num <=", value, "warrantyNum");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumLike(String value) {
            addCriterion("warranty_num like", value, "warrantyNum");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumNotLike(String value) {
            addCriterion("warranty_num not like", value, "warrantyNum");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumIn(List<String> values) {
            addCriterion("warranty_num in", values, "warrantyNum");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumNotIn(List<String> values) {
            addCriterion("warranty_num not in", values, "warrantyNum");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumBetween(String value1, String value2) {
            addCriterion("warranty_num between", value1, value2, "warrantyNum");
            return (Criteria) this;
        }

        public Criteria andWarrantyNumNotBetween(String value1, String value2) {
            addCriterion("warranty_num not between", value1, value2, "warrantyNum");
            return (Criteria) this;
        }

        public Criteria andInspectionNumIsNull() {
            addCriterion("inspection_num is null");
            return (Criteria) this;
        }

        public Criteria andInspectionNumIsNotNull() {
            addCriterion("inspection_num is not null");
            return (Criteria) this;
        }

        public Criteria andInspectionNumEqualTo(String value) {
            addCriterion("inspection_num =", value, "inspectionNum");
            return (Criteria) this;
        }

        public Criteria andInspectionNumNotEqualTo(String value) {
            addCriterion("inspection_num <>", value, "inspectionNum");
            return (Criteria) this;
        }

        public Criteria andInspectionNumGreaterThan(String value) {
            addCriterion("inspection_num >", value, "inspectionNum");
            return (Criteria) this;
        }

        public Criteria andInspectionNumGreaterThanOrEqualTo(String value) {
            addCriterion("inspection_num >=", value, "inspectionNum");
            return (Criteria) this;
        }

        public Criteria andInspectionNumLessThan(String value) {
            addCriterion("inspection_num <", value, "inspectionNum");
            return (Criteria) this;
        }

        public Criteria andInspectionNumLessThanOrEqualTo(String value) {
            addCriterion("inspection_num <=", value, "inspectionNum");
            return (Criteria) this;
        }

        public Criteria andInspectionNumLike(String value) {
            addCriterion("inspection_num like", value, "inspectionNum");
            return (Criteria) this;
        }

        public Criteria andInspectionNumNotLike(String value) {
            addCriterion("inspection_num not like", value, "inspectionNum");
            return (Criteria) this;
        }

        public Criteria andInspectionNumIn(List<String> values) {
            addCriterion("inspection_num in", values, "inspectionNum");
            return (Criteria) this;
        }

        public Criteria andInspectionNumNotIn(List<String> values) {
            addCriterion("inspection_num not in", values, "inspectionNum");
            return (Criteria) this;
        }

        public Criteria andInspectionNumBetween(String value1, String value2) {
            addCriterion("inspection_num between", value1, value2, "inspectionNum");
            return (Criteria) this;
        }

        public Criteria andInspectionNumNotBetween(String value1, String value2) {
            addCriterion("inspection_num not between", value1, value2, "inspectionNum");
            return (Criteria) this;
        }

        public Criteria andStandardPriceIsNull() {
            addCriterion("standard_price is null");
            return (Criteria) this;
        }

        public Criteria andStandardPriceIsNotNull() {
            addCriterion("standard_price is not null");
            return (Criteria) this;
        }

        public Criteria andStandardPriceEqualTo(BigDecimal value) {
            addCriterion("standard_price =", value, "standardPrice");
            return (Criteria) this;
        }

        public Criteria andStandardPriceNotEqualTo(BigDecimal value) {
            addCriterion("standard_price <>", value, "standardPrice");
            return (Criteria) this;
        }

        public Criteria andStandardPriceGreaterThan(BigDecimal value) {
            addCriterion("standard_price >", value, "standardPrice");
            return (Criteria) this;
        }

        public Criteria andStandardPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("standard_price >=", value, "standardPrice");
            return (Criteria) this;
        }

        public Criteria andStandardPriceLessThan(BigDecimal value) {
            addCriterion("standard_price <", value, "standardPrice");
            return (Criteria) this;
        }

        public Criteria andStandardPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("standard_price <=", value, "standardPrice");
            return (Criteria) this;
        }

        public Criteria andStandardPriceIn(List<BigDecimal> values) {
            addCriterion("standard_price in", values, "standardPrice");
            return (Criteria) this;
        }

        public Criteria andStandardPriceNotIn(List<BigDecimal> values) {
            addCriterion("standard_price not in", values, "standardPrice");
            return (Criteria) this;
        }

        public Criteria andStandardPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("standard_price between", value1, value2, "standardPrice");
            return (Criteria) this;
        }

        public Criteria andStandardPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("standard_price not between", value1, value2, "standardPrice");
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

        public Criteria andPurchasePricePioIsNull() {
            addCriterion("purchase_price_pio is null");
            return (Criteria) this;
        }

        public Criteria andPurchasePricePioIsNotNull() {
            addCriterion("purchase_price_pio is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasePricePioEqualTo(BigDecimal value) {
            addCriterion("purchase_price_pio =", value, "purchasePricePio");
            return (Criteria) this;
        }

        public Criteria andPurchasePricePioNotEqualTo(BigDecimal value) {
            addCriterion("purchase_price_pio <>", value, "purchasePricePio");
            return (Criteria) this;
        }

        public Criteria andPurchasePricePioGreaterThan(BigDecimal value) {
            addCriterion("purchase_price_pio >", value, "purchasePricePio");
            return (Criteria) this;
        }

        public Criteria andPurchasePricePioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_price_pio >=", value, "purchasePricePio");
            return (Criteria) this;
        }

        public Criteria andPurchasePricePioLessThan(BigDecimal value) {
            addCriterion("purchase_price_pio <", value, "purchasePricePio");
            return (Criteria) this;
        }

        public Criteria andPurchasePricePioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_price_pio <=", value, "purchasePricePio");
            return (Criteria) this;
        }

        public Criteria andPurchasePricePioIn(List<BigDecimal> values) {
            addCriterion("purchase_price_pio in", values, "purchasePricePio");
            return (Criteria) this;
        }

        public Criteria andPurchasePricePioNotIn(List<BigDecimal> values) {
            addCriterion("purchase_price_pio not in", values, "purchasePricePio");
            return (Criteria) this;
        }

        public Criteria andPurchasePricePioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_price_pio between", value1, value2, "purchasePricePio");
            return (Criteria) this;
        }

        public Criteria andPurchasePricePioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_price_pio not between", value1, value2, "purchasePricePio");
            return (Criteria) this;
        }

        public Criteria andFreightChargeIsNull() {
            addCriterion("freight_charge is null");
            return (Criteria) this;
        }

        public Criteria andFreightChargeIsNotNull() {
            addCriterion("freight_charge is not null");
            return (Criteria) this;
        }

        public Criteria andFreightChargeEqualTo(BigDecimal value) {
            addCriterion("freight_charge =", value, "freightCharge");
            return (Criteria) this;
        }

        public Criteria andFreightChargeNotEqualTo(BigDecimal value) {
            addCriterion("freight_charge <>", value, "freightCharge");
            return (Criteria) this;
        }

        public Criteria andFreightChargeGreaterThan(BigDecimal value) {
            addCriterion("freight_charge >", value, "freightCharge");
            return (Criteria) this;
        }

        public Criteria andFreightChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freight_charge >=", value, "freightCharge");
            return (Criteria) this;
        }

        public Criteria andFreightChargeLessThan(BigDecimal value) {
            addCriterion("freight_charge <", value, "freightCharge");
            return (Criteria) this;
        }

        public Criteria andFreightChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freight_charge <=", value, "freightCharge");
            return (Criteria) this;
        }

        public Criteria andFreightChargeIn(List<BigDecimal> values) {
            addCriterion("freight_charge in", values, "freightCharge");
            return (Criteria) this;
        }

        public Criteria andFreightChargeNotIn(List<BigDecimal> values) {
            addCriterion("freight_charge not in", values, "freightCharge");
            return (Criteria) this;
        }

        public Criteria andFreightChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight_charge between", value1, value2, "freightCharge");
            return (Criteria) this;
        }

        public Criteria andFreightChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight_charge not between", value1, value2, "freightCharge");
            return (Criteria) this;
        }

        public Criteria andEntirePurchasePriceIsNull() {
            addCriterion("entire_purchase_price is null");
            return (Criteria) this;
        }

        public Criteria andEntirePurchasePriceIsNotNull() {
            addCriterion("entire_purchase_price is not null");
            return (Criteria) this;
        }

        public Criteria andEntirePurchasePriceEqualTo(BigDecimal value) {
            addCriterion("entire_purchase_price =", value, "entirePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andEntirePurchasePriceNotEqualTo(BigDecimal value) {
            addCriterion("entire_purchase_price <>", value, "entirePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andEntirePurchasePriceGreaterThan(BigDecimal value) {
            addCriterion("entire_purchase_price >", value, "entirePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andEntirePurchasePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("entire_purchase_price >=", value, "entirePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andEntirePurchasePriceLessThan(BigDecimal value) {
            addCriterion("entire_purchase_price <", value, "entirePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andEntirePurchasePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("entire_purchase_price <=", value, "entirePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andEntirePurchasePriceIn(List<BigDecimal> values) {
            addCriterion("entire_purchase_price in", values, "entirePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andEntirePurchasePriceNotIn(List<BigDecimal> values) {
            addCriterion("entire_purchase_price not in", values, "entirePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andEntirePurchasePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("entire_purchase_price between", value1, value2, "entirePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andEntirePurchasePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("entire_purchase_price not between", value1, value2, "entirePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andIncludeBoutiquePriceIsNull() {
            addCriterion("include_boutique_price is null");
            return (Criteria) this;
        }

        public Criteria andIncludeBoutiquePriceIsNotNull() {
            addCriterion("include_boutique_price is not null");
            return (Criteria) this;
        }

        public Criteria andIncludeBoutiquePriceEqualTo(BigDecimal value) {
            addCriterion("include_boutique_price =", value, "includeBoutiquePrice");
            return (Criteria) this;
        }

        public Criteria andIncludeBoutiquePriceNotEqualTo(BigDecimal value) {
            addCriterion("include_boutique_price <>", value, "includeBoutiquePrice");
            return (Criteria) this;
        }

        public Criteria andIncludeBoutiquePriceGreaterThan(BigDecimal value) {
            addCriterion("include_boutique_price >", value, "includeBoutiquePrice");
            return (Criteria) this;
        }

        public Criteria andIncludeBoutiquePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("include_boutique_price >=", value, "includeBoutiquePrice");
            return (Criteria) this;
        }

        public Criteria andIncludeBoutiquePriceLessThan(BigDecimal value) {
            addCriterion("include_boutique_price <", value, "includeBoutiquePrice");
            return (Criteria) this;
        }

        public Criteria andIncludeBoutiquePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("include_boutique_price <=", value, "includeBoutiquePrice");
            return (Criteria) this;
        }

        public Criteria andIncludeBoutiquePriceIn(List<BigDecimal> values) {
            addCriterion("include_boutique_price in", values, "includeBoutiquePrice");
            return (Criteria) this;
        }

        public Criteria andIncludeBoutiquePriceNotIn(List<BigDecimal> values) {
            addCriterion("include_boutique_price not in", values, "includeBoutiquePrice");
            return (Criteria) this;
        }

        public Criteria andIncludeBoutiquePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("include_boutique_price between", value1, value2, "includeBoutiquePrice");
            return (Criteria) this;
        }

        public Criteria andIncludeBoutiquePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("include_boutique_price not between", value1, value2, "includeBoutiquePrice");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateIsNull() {
            addCriterion("purchase_date is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateIsNotNull() {
            addCriterion("purchase_date is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateEqualTo(Date value) {
            addCriterion("purchase_date =", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateNotEqualTo(Date value) {
            addCriterion("purchase_date <>", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateGreaterThan(Date value) {
            addCriterion("purchase_date >", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateGreaterThanOrEqualTo(Date value) {
            addCriterion("purchase_date >=", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateLessThan(Date value) {
            addCriterion("purchase_date <", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateLessThanOrEqualTo(Date value) {
            addCriterion("purchase_date <=", value, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateIn(List<Date> values) {
            addCriterion("purchase_date in", values, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateNotIn(List<Date> values) {
            addCriterion("purchase_date not in", values, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateBetween(Date value1, Date value2) {
            addCriterion("purchase_date between", value1, value2, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andPurchaseDateNotBetween(Date value1, Date value2) {
            addCriterion("purchase_date not between", value1, value2, "purchaseDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateIsNull() {
            addCriterion("produce_date is null");
            return (Criteria) this;
        }

        public Criteria andProduceDateIsNotNull() {
            addCriterion("produce_date is not null");
            return (Criteria) this;
        }

        public Criteria andProduceDateEqualTo(Date value) {
            addCriterion("produce_date =", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateNotEqualTo(Date value) {
            addCriterion("produce_date <>", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateGreaterThan(Date value) {
            addCriterion("produce_date >", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateGreaterThanOrEqualTo(Date value) {
            addCriterion("produce_date >=", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateLessThan(Date value) {
            addCriterion("produce_date <", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateLessThanOrEqualTo(Date value) {
            addCriterion("produce_date <=", value, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateIn(List<Date> values) {
            addCriterion("produce_date in", values, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateNotIn(List<Date> values) {
            addCriterion("produce_date not in", values, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateBetween(Date value1, Date value2) {
            addCriterion("produce_date between", value1, value2, "produceDate");
            return (Criteria) this;
        }

        public Criteria andProduceDateNotBetween(Date value1, Date value2) {
            addCriterion("produce_date not between", value1, value2, "produceDate");
            return (Criteria) this;
        }

        public Criteria andOfflineDateIsNull() {
            addCriterion("offline_date is null");
            return (Criteria) this;
        }

        public Criteria andOfflineDateIsNotNull() {
            addCriterion("offline_date is not null");
            return (Criteria) this;
        }

        public Criteria andOfflineDateEqualTo(Date value) {
            addCriterion("offline_date =", value, "offlineDate");
            return (Criteria) this;
        }

        public Criteria andOfflineDateNotEqualTo(Date value) {
            addCriterion("offline_date <>", value, "offlineDate");
            return (Criteria) this;
        }

        public Criteria andOfflineDateGreaterThan(Date value) {
            addCriterion("offline_date >", value, "offlineDate");
            return (Criteria) this;
        }

        public Criteria andOfflineDateGreaterThanOrEqualTo(Date value) {
            addCriterion("offline_date >=", value, "offlineDate");
            return (Criteria) this;
        }

        public Criteria andOfflineDateLessThan(Date value) {
            addCriterion("offline_date <", value, "offlineDate");
            return (Criteria) this;
        }

        public Criteria andOfflineDateLessThanOrEqualTo(Date value) {
            addCriterion("offline_date <=", value, "offlineDate");
            return (Criteria) this;
        }

        public Criteria andOfflineDateIn(List<Date> values) {
            addCriterion("offline_date in", values, "offlineDate");
            return (Criteria) this;
        }

        public Criteria andOfflineDateNotIn(List<Date> values) {
            addCriterion("offline_date not in", values, "offlineDate");
            return (Criteria) this;
        }

        public Criteria andOfflineDateBetween(Date value1, Date value2) {
            addCriterion("offline_date between", value1, value2, "offlineDate");
            return (Criteria) this;
        }

        public Criteria andOfflineDateNotBetween(Date value1, Date value2) {
            addCriterion("offline_date not between", value1, value2, "offlineDate");
            return (Criteria) this;
        }

        public Criteria andInterestFreeDayIsNull() {
            addCriterion("interest_free_day is null");
            return (Criteria) this;
        }

        public Criteria andInterestFreeDayIsNotNull() {
            addCriterion("interest_free_day is not null");
            return (Criteria) this;
        }

        public Criteria andInterestFreeDayEqualTo(Integer value) {
            addCriterion("interest_free_day =", value, "interestFreeDay");
            return (Criteria) this;
        }

        public Criteria andInterestFreeDayNotEqualTo(Integer value) {
            addCriterion("interest_free_day <>", value, "interestFreeDay");
            return (Criteria) this;
        }

        public Criteria andInterestFreeDayGreaterThan(Integer value) {
            addCriterion("interest_free_day >", value, "interestFreeDay");
            return (Criteria) this;
        }

        public Criteria andInterestFreeDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("interest_free_day >=", value, "interestFreeDay");
            return (Criteria) this;
        }

        public Criteria andInterestFreeDayLessThan(Integer value) {
            addCriterion("interest_free_day <", value, "interestFreeDay");
            return (Criteria) this;
        }

        public Criteria andInterestFreeDayLessThanOrEqualTo(Integer value) {
            addCriterion("interest_free_day <=", value, "interestFreeDay");
            return (Criteria) this;
        }

        public Criteria andInterestFreeDayIn(List<Integer> values) {
            addCriterion("interest_free_day in", values, "interestFreeDay");
            return (Criteria) this;
        }

        public Criteria andInterestFreeDayNotIn(List<Integer> values) {
            addCriterion("interest_free_day not in", values, "interestFreeDay");
            return (Criteria) this;
        }

        public Criteria andInterestFreeDayBetween(Integer value1, Integer value2) {
            addCriterion("interest_free_day between", value1, value2, "interestFreeDay");
            return (Criteria) this;
        }

        public Criteria andInterestFreeDayNotBetween(Integer value1, Integer value2) {
            addCriterion("interest_free_day not between", value1, value2, "interestFreeDay");
            return (Criteria) this;
        }

        public Criteria andOptionalPackageStatusIsNull() {
            addCriterion("optional_package_status is null");
            return (Criteria) this;
        }

        public Criteria andOptionalPackageStatusIsNotNull() {
            addCriterion("optional_package_status is not null");
            return (Criteria) this;
        }

        public Criteria andOptionalPackageStatusEqualTo(Integer value) {
            addCriterion("optional_package_status =", value, "optionalPackageStatus");
            return (Criteria) this;
        }

        public Criteria andOptionalPackageStatusNotEqualTo(Integer value) {
            addCriterion("optional_package_status <>", value, "optionalPackageStatus");
            return (Criteria) this;
        }

        public Criteria andOptionalPackageStatusGreaterThan(Integer value) {
            addCriterion("optional_package_status >", value, "optionalPackageStatus");
            return (Criteria) this;
        }

        public Criteria andOptionalPackageStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("optional_package_status >=", value, "optionalPackageStatus");
            return (Criteria) this;
        }

        public Criteria andOptionalPackageStatusLessThan(Integer value) {
            addCriterion("optional_package_status <", value, "optionalPackageStatus");
            return (Criteria) this;
        }

        public Criteria andOptionalPackageStatusLessThanOrEqualTo(Integer value) {
            addCriterion("optional_package_status <=", value, "optionalPackageStatus");
            return (Criteria) this;
        }

        public Criteria andOptionalPackageStatusIn(List<Integer> values) {
            addCriterion("optional_package_status in", values, "optionalPackageStatus");
            return (Criteria) this;
        }

        public Criteria andOptionalPackageStatusNotIn(List<Integer> values) {
            addCriterion("optional_package_status not in", values, "optionalPackageStatus");
            return (Criteria) this;
        }

        public Criteria andOptionalPackageStatusBetween(Integer value1, Integer value2) {
            addCriterion("optional_package_status between", value1, value2, "optionalPackageStatus");
            return (Criteria) this;
        }

        public Criteria andOptionalPackageStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("optional_package_status not between", value1, value2, "optionalPackageStatus");
            return (Criteria) this;
        }

        public Criteria andGuarantyStatusIsNull() {
            addCriterion("guaranty_status is null");
            return (Criteria) this;
        }

        public Criteria andGuarantyStatusIsNotNull() {
            addCriterion("guaranty_status is not null");
            return (Criteria) this;
        }

        public Criteria andGuarantyStatusEqualTo(Integer value) {
            addCriterion("guaranty_status =", value, "guarantyStatus");
            return (Criteria) this;
        }

        public Criteria andGuarantyStatusNotEqualTo(Integer value) {
            addCriterion("guaranty_status <>", value, "guarantyStatus");
            return (Criteria) this;
        }

        public Criteria andGuarantyStatusGreaterThan(Integer value) {
            addCriterion("guaranty_status >", value, "guarantyStatus");
            return (Criteria) this;
        }

        public Criteria andGuarantyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("guaranty_status >=", value, "guarantyStatus");
            return (Criteria) this;
        }

        public Criteria andGuarantyStatusLessThan(Integer value) {
            addCriterion("guaranty_status <", value, "guarantyStatus");
            return (Criteria) this;
        }

        public Criteria andGuarantyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("guaranty_status <=", value, "guarantyStatus");
            return (Criteria) this;
        }

        public Criteria andGuarantyStatusIn(List<Integer> values) {
            addCriterion("guaranty_status in", values, "guarantyStatus");
            return (Criteria) this;
        }

        public Criteria andGuarantyStatusNotIn(List<Integer> values) {
            addCriterion("guaranty_status not in", values, "guarantyStatus");
            return (Criteria) this;
        }

        public Criteria andGuarantyStatusBetween(Integer value1, Integer value2) {
            addCriterion("guaranty_status between", value1, value2, "guarantyStatus");
            return (Criteria) this;
        }

        public Criteria andGuarantyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("guaranty_status not between", value1, value2, "guarantyStatus");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyIdIsNull() {
            addCriterion("finance_company_id is null");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyIdIsNotNull() {
            addCriterion("finance_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyIdEqualTo(Integer value) {
            addCriterion("finance_company_id =", value, "financeCompanyId");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyIdNotEqualTo(Integer value) {
            addCriterion("finance_company_id <>", value, "financeCompanyId");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyIdGreaterThan(Integer value) {
            addCriterion("finance_company_id >", value, "financeCompanyId");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("finance_company_id >=", value, "financeCompanyId");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyIdLessThan(Integer value) {
            addCriterion("finance_company_id <", value, "financeCompanyId");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("finance_company_id <=", value, "financeCompanyId");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyIdIn(List<Integer> values) {
            addCriterion("finance_company_id in", values, "financeCompanyId");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyIdNotIn(List<Integer> values) {
            addCriterion("finance_company_id not in", values, "financeCompanyId");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("finance_company_id between", value1, value2, "financeCompanyId");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("finance_company_id not between", value1, value2, "financeCompanyId");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameIsNull() {
            addCriterion("finance_company_name is null");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameIsNotNull() {
            addCriterion("finance_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameEqualTo(String value) {
            addCriterion("finance_company_name =", value, "financeCompanyName");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameNotEqualTo(String value) {
            addCriterion("finance_company_name <>", value, "financeCompanyName");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameGreaterThan(String value) {
            addCriterion("finance_company_name >", value, "financeCompanyName");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("finance_company_name >=", value, "financeCompanyName");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameLessThan(String value) {
            addCriterion("finance_company_name <", value, "financeCompanyName");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("finance_company_name <=", value, "financeCompanyName");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameLike(String value) {
            addCriterion("finance_company_name like", value, "financeCompanyName");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameNotLike(String value) {
            addCriterion("finance_company_name not like", value, "financeCompanyName");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameIn(List<String> values) {
            addCriterion("finance_company_name in", values, "financeCompanyName");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameNotIn(List<String> values) {
            addCriterion("finance_company_name not in", values, "financeCompanyName");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameBetween(String value1, String value2) {
            addCriterion("finance_company_name between", value1, value2, "financeCompanyName");
            return (Criteria) this;
        }

        public Criteria andFinanceCompanyNameNotBetween(String value1, String value2) {
            addCriterion("finance_company_name not between", value1, value2, "financeCompanyName");
            return (Criteria) this;
        }

        public Criteria andStorageStatusIsNull() {
            addCriterion("storage_status is null");
            return (Criteria) this;
        }

        public Criteria andStorageStatusIsNotNull() {
            addCriterion("storage_status is not null");
            return (Criteria) this;
        }

        public Criteria andStorageStatusEqualTo(Integer value) {
            addCriterion("storage_status =", value, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusNotEqualTo(Integer value) {
            addCriterion("storage_status <>", value, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusGreaterThan(Integer value) {
            addCriterion("storage_status >", value, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("storage_status >=", value, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusLessThan(Integer value) {
            addCriterion("storage_status <", value, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusLessThanOrEqualTo(Integer value) {
            addCriterion("storage_status <=", value, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusIn(List<Integer> values) {
            addCriterion("storage_status in", values, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusNotIn(List<Integer> values) {
            addCriterion("storage_status not in", values, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusBetween(Integer value1, Integer value2) {
            addCriterion("storage_status between", value1, value2, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andStorageStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("storage_status not between", value1, value2, "storageStatus");
            return (Criteria) this;
        }

        public Criteria andInStorageDateIsNull() {
            addCriterion("in_storage_date is null");
            return (Criteria) this;
        }

        public Criteria andInStorageDateIsNotNull() {
            addCriterion("in_storage_date is not null");
            return (Criteria) this;
        }

        public Criteria andInStorageDateEqualTo(Date value) {
            addCriterion("in_storage_date =", value, "inStorageDate");
            return (Criteria) this;
        }

        public Criteria andInStorageDateNotEqualTo(Date value) {
            addCriterion("in_storage_date <>", value, "inStorageDate");
            return (Criteria) this;
        }

        public Criteria andInStorageDateGreaterThan(Date value) {
            addCriterion("in_storage_date >", value, "inStorageDate");
            return (Criteria) this;
        }

        public Criteria andInStorageDateGreaterThanOrEqualTo(Date value) {
            addCriterion("in_storage_date >=", value, "inStorageDate");
            return (Criteria) this;
        }

        public Criteria andInStorageDateLessThan(Date value) {
            addCriterion("in_storage_date <", value, "inStorageDate");
            return (Criteria) this;
        }

        public Criteria andInStorageDateLessThanOrEqualTo(Date value) {
            addCriterion("in_storage_date <=", value, "inStorageDate");
            return (Criteria) this;
        }

        public Criteria andInStorageDateIn(List<Date> values) {
            addCriterion("in_storage_date in", values, "inStorageDate");
            return (Criteria) this;
        }

        public Criteria andInStorageDateNotIn(List<Date> values) {
            addCriterion("in_storage_date not in", values, "inStorageDate");
            return (Criteria) this;
        }

        public Criteria andInStorageDateBetween(Date value1, Date value2) {
            addCriterion("in_storage_date between", value1, value2, "inStorageDate");
            return (Criteria) this;
        }

        public Criteria andInStorageDateNotBetween(Date value1, Date value2) {
            addCriterion("in_storage_date not between", value1, value2, "inStorageDate");
            return (Criteria) this;
        }

        public Criteria andOutStorageDateIsNull() {
            addCriterion("out_storage_date is null");
            return (Criteria) this;
        }

        public Criteria andOutStorageDateIsNotNull() {
            addCriterion("out_storage_date is not null");
            return (Criteria) this;
        }

        public Criteria andOutStorageDateEqualTo(Date value) {
            addCriterion("out_storage_date =", value, "outStorageDate");
            return (Criteria) this;
        }

        public Criteria andOutStorageDateNotEqualTo(Date value) {
            addCriterion("out_storage_date <>", value, "outStorageDate");
            return (Criteria) this;
        }

        public Criteria andOutStorageDateGreaterThan(Date value) {
            addCriterion("out_storage_date >", value, "outStorageDate");
            return (Criteria) this;
        }

        public Criteria andOutStorageDateGreaterThanOrEqualTo(Date value) {
            addCriterion("out_storage_date >=", value, "outStorageDate");
            return (Criteria) this;
        }

        public Criteria andOutStorageDateLessThan(Date value) {
            addCriterion("out_storage_date <", value, "outStorageDate");
            return (Criteria) this;
        }

        public Criteria andOutStorageDateLessThanOrEqualTo(Date value) {
            addCriterion("out_storage_date <=", value, "outStorageDate");
            return (Criteria) this;
        }

        public Criteria andOutStorageDateIn(List<Date> values) {
            addCriterion("out_storage_date in", values, "outStorageDate");
            return (Criteria) this;
        }

        public Criteria andOutStorageDateNotIn(List<Date> values) {
            addCriterion("out_storage_date not in", values, "outStorageDate");
            return (Criteria) this;
        }

        public Criteria andOutStorageDateBetween(Date value1, Date value2) {
            addCriterion("out_storage_date between", value1, value2, "outStorageDate");
            return (Criteria) this;
        }

        public Criteria andOutStorageDateNotBetween(Date value1, Date value2) {
            addCriterion("out_storage_date not between", value1, value2, "outStorageDate");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIsNull() {
            addCriterion("warehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIsNotNull() {
            addCriterion("warehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdEqualTo(Integer value) {
            addCriterion("warehouse_id =", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotEqualTo(Integer value) {
            addCriterion("warehouse_id <>", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdGreaterThan(Integer value) {
            addCriterion("warehouse_id >", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("warehouse_id >=", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLessThan(Integer value) {
            addCriterion("warehouse_id <", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdLessThanOrEqualTo(Integer value) {
            addCriterion("warehouse_id <=", value, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdIn(List<Integer> values) {
            addCriterion("warehouse_id in", values, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotIn(List<Integer> values) {
            addCriterion("warehouse_id not in", values, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdBetween(Integer value1, Integer value2) {
            addCriterion("warehouse_id between", value1, value2, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andWarehouseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("warehouse_id not between", value1, value2, "warehouseId");
            return (Criteria) this;
        }

        public Criteria andStorageIdIsNull() {
            addCriterion("storage_id is null");
            return (Criteria) this;
        }

        public Criteria andStorageIdIsNotNull() {
            addCriterion("storage_id is not null");
            return (Criteria) this;
        }

        public Criteria andStorageIdEqualTo(Integer value) {
            addCriterion("storage_id =", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotEqualTo(Integer value) {
            addCriterion("storage_id <>", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdGreaterThan(Integer value) {
            addCriterion("storage_id >", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("storage_id >=", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdLessThan(Integer value) {
            addCriterion("storage_id <", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdLessThanOrEqualTo(Integer value) {
            addCriterion("storage_id <=", value, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdIn(List<Integer> values) {
            addCriterion("storage_id in", values, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotIn(List<Integer> values) {
            addCriterion("storage_id not in", values, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdBetween(Integer value1, Integer value2) {
            addCriterion("storage_id between", value1, value2, "storageId");
            return (Criteria) this;
        }

        public Criteria andStorageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("storage_id not between", value1, value2, "storageId");
            return (Criteria) this;
        }

        public Criteria andCarSupplyStatusIsNull() {
            addCriterion("car_supply_status is null");
            return (Criteria) this;
        }

        public Criteria andCarSupplyStatusIsNotNull() {
            addCriterion("car_supply_status is not null");
            return (Criteria) this;
        }

        public Criteria andCarSupplyStatusEqualTo(Integer value) {
            addCriterion("car_supply_status =", value, "carSupplyStatus");
            return (Criteria) this;
        }

        public Criteria andCarSupplyStatusNotEqualTo(Integer value) {
            addCriterion("car_supply_status <>", value, "carSupplyStatus");
            return (Criteria) this;
        }

        public Criteria andCarSupplyStatusGreaterThan(Integer value) {
            addCriterion("car_supply_status >", value, "carSupplyStatus");
            return (Criteria) this;
        }

        public Criteria andCarSupplyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_supply_status >=", value, "carSupplyStatus");
            return (Criteria) this;
        }

        public Criteria andCarSupplyStatusLessThan(Integer value) {
            addCriterion("car_supply_status <", value, "carSupplyStatus");
            return (Criteria) this;
        }

        public Criteria andCarSupplyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("car_supply_status <=", value, "carSupplyStatus");
            return (Criteria) this;
        }

        public Criteria andCarSupplyStatusIn(List<Integer> values) {
            addCriterion("car_supply_status in", values, "carSupplyStatus");
            return (Criteria) this;
        }

        public Criteria andCarSupplyStatusNotIn(List<Integer> values) {
            addCriterion("car_supply_status not in", values, "carSupplyStatus");
            return (Criteria) this;
        }

        public Criteria andCarSupplyStatusBetween(Integer value1, Integer value2) {
            addCriterion("car_supply_status between", value1, value2, "carSupplyStatus");
            return (Criteria) this;
        }

        public Criteria andCarSupplyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("car_supply_status not between", value1, value2, "carSupplyStatus");
            return (Criteria) this;
        }

        public Criteria andFactoryReportStatusIsNull() {
            addCriterion("factory_report_status is null");
            return (Criteria) this;
        }

        public Criteria andFactoryReportStatusIsNotNull() {
            addCriterion("factory_report_status is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryReportStatusEqualTo(Integer value) {
            addCriterion("factory_report_status =", value, "factoryReportStatus");
            return (Criteria) this;
        }

        public Criteria andFactoryReportStatusNotEqualTo(Integer value) {
            addCriterion("factory_report_status <>", value, "factoryReportStatus");
            return (Criteria) this;
        }

        public Criteria andFactoryReportStatusGreaterThan(Integer value) {
            addCriterion("factory_report_status >", value, "factoryReportStatus");
            return (Criteria) this;
        }

        public Criteria andFactoryReportStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("factory_report_status >=", value, "factoryReportStatus");
            return (Criteria) this;
        }

        public Criteria andFactoryReportStatusLessThan(Integer value) {
            addCriterion("factory_report_status <", value, "factoryReportStatus");
            return (Criteria) this;
        }

        public Criteria andFactoryReportStatusLessThanOrEqualTo(Integer value) {
            addCriterion("factory_report_status <=", value, "factoryReportStatus");
            return (Criteria) this;
        }

        public Criteria andFactoryReportStatusIn(List<Integer> values) {
            addCriterion("factory_report_status in", values, "factoryReportStatus");
            return (Criteria) this;
        }

        public Criteria andFactoryReportStatusNotIn(List<Integer> values) {
            addCriterion("factory_report_status not in", values, "factoryReportStatus");
            return (Criteria) this;
        }

        public Criteria andFactoryReportStatusBetween(Integer value1, Integer value2) {
            addCriterion("factory_report_status between", value1, value2, "factoryReportStatus");
            return (Criteria) this;
        }

        public Criteria andFactoryReportStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("factory_report_status not between", value1, value2, "factoryReportStatus");
            return (Criteria) this;
        }

        public Criteria andVirtualRecordStatusIsNull() {
            addCriterion("virtual_record_status is null");
            return (Criteria) this;
        }

        public Criteria andVirtualRecordStatusIsNotNull() {
            addCriterion("virtual_record_status is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualRecordStatusEqualTo(Integer value) {
            addCriterion("virtual_record_status =", value, "virtualRecordStatus");
            return (Criteria) this;
        }

        public Criteria andVirtualRecordStatusNotEqualTo(Integer value) {
            addCriterion("virtual_record_status <>", value, "virtualRecordStatus");
            return (Criteria) this;
        }

        public Criteria andVirtualRecordStatusGreaterThan(Integer value) {
            addCriterion("virtual_record_status >", value, "virtualRecordStatus");
            return (Criteria) this;
        }

        public Criteria andVirtualRecordStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("virtual_record_status >=", value, "virtualRecordStatus");
            return (Criteria) this;
        }

        public Criteria andVirtualRecordStatusLessThan(Integer value) {
            addCriterion("virtual_record_status <", value, "virtualRecordStatus");
            return (Criteria) this;
        }

        public Criteria andVirtualRecordStatusLessThanOrEqualTo(Integer value) {
            addCriterion("virtual_record_status <=", value, "virtualRecordStatus");
            return (Criteria) this;
        }

        public Criteria andVirtualRecordStatusIn(List<Integer> values) {
            addCriterion("virtual_record_status in", values, "virtualRecordStatus");
            return (Criteria) this;
        }

        public Criteria andVirtualRecordStatusNotIn(List<Integer> values) {
            addCriterion("virtual_record_status not in", values, "virtualRecordStatus");
            return (Criteria) this;
        }

        public Criteria andVirtualRecordStatusBetween(Integer value1, Integer value2) {
            addCriterion("virtual_record_status between", value1, value2, "virtualRecordStatus");
            return (Criteria) this;
        }

        public Criteria andVirtualRecordStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("virtual_record_status not between", value1, value2, "virtualRecordStatus");
            return (Criteria) this;
        }

        public Criteria andDeceiveReportStatusIsNull() {
            addCriterion("deceive_report_status is null");
            return (Criteria) this;
        }

        public Criteria andDeceiveReportStatusIsNotNull() {
            addCriterion("deceive_report_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeceiveReportStatusEqualTo(Integer value) {
            addCriterion("deceive_report_status =", value, "deceiveReportStatus");
            return (Criteria) this;
        }

        public Criteria andDeceiveReportStatusNotEqualTo(Integer value) {
            addCriterion("deceive_report_status <>", value, "deceiveReportStatus");
            return (Criteria) this;
        }

        public Criteria andDeceiveReportStatusGreaterThan(Integer value) {
            addCriterion("deceive_report_status >", value, "deceiveReportStatus");
            return (Criteria) this;
        }

        public Criteria andDeceiveReportStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("deceive_report_status >=", value, "deceiveReportStatus");
            return (Criteria) this;
        }

        public Criteria andDeceiveReportStatusLessThan(Integer value) {
            addCriterion("deceive_report_status <", value, "deceiveReportStatus");
            return (Criteria) this;
        }

        public Criteria andDeceiveReportStatusLessThanOrEqualTo(Integer value) {
            addCriterion("deceive_report_status <=", value, "deceiveReportStatus");
            return (Criteria) this;
        }

        public Criteria andDeceiveReportStatusIn(List<Integer> values) {
            addCriterion("deceive_report_status in", values, "deceiveReportStatus");
            return (Criteria) this;
        }

        public Criteria andDeceiveReportStatusNotIn(List<Integer> values) {
            addCriterion("deceive_report_status not in", values, "deceiveReportStatus");
            return (Criteria) this;
        }

        public Criteria andDeceiveReportStatusBetween(Integer value1, Integer value2) {
            addCriterion("deceive_report_status between", value1, value2, "deceiveReportStatus");
            return (Criteria) this;
        }

        public Criteria andDeceiveReportStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("deceive_report_status not between", value1, value2, "deceiveReportStatus");
            return (Criteria) this;
        }

        public Criteria andNewBoutiqueStatusIsNull() {
            addCriterion("new_boutique_status is null");
            return (Criteria) this;
        }

        public Criteria andNewBoutiqueStatusIsNotNull() {
            addCriterion("new_boutique_status is not null");
            return (Criteria) this;
        }

        public Criteria andNewBoutiqueStatusEqualTo(Integer value) {
            addCriterion("new_boutique_status =", value, "newBoutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andNewBoutiqueStatusNotEqualTo(Integer value) {
            addCriterion("new_boutique_status <>", value, "newBoutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andNewBoutiqueStatusGreaterThan(Integer value) {
            addCriterion("new_boutique_status >", value, "newBoutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andNewBoutiqueStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_boutique_status >=", value, "newBoutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andNewBoutiqueStatusLessThan(Integer value) {
            addCriterion("new_boutique_status <", value, "newBoutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andNewBoutiqueStatusLessThanOrEqualTo(Integer value) {
            addCriterion("new_boutique_status <=", value, "newBoutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andNewBoutiqueStatusIn(List<Integer> values) {
            addCriterion("new_boutique_status in", values, "newBoutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andNewBoutiqueStatusNotIn(List<Integer> values) {
            addCriterion("new_boutique_status not in", values, "newBoutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andNewBoutiqueStatusBetween(Integer value1, Integer value2) {
            addCriterion("new_boutique_status between", value1, value2, "newBoutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andNewBoutiqueStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("new_boutique_status not between", value1, value2, "newBoutiqueStatus");
            return (Criteria) this;
        }

        public Criteria andSellDateIsNull() {
            addCriterion("sell_date is null");
            return (Criteria) this;
        }

        public Criteria andSellDateIsNotNull() {
            addCriterion("sell_date is not null");
            return (Criteria) this;
        }

        public Criteria andSellDateEqualTo(Date value) {
            addCriterion("sell_date =", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateNotEqualTo(Date value) {
            addCriterion("sell_date <>", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateGreaterThan(Date value) {
            addCriterion("sell_date >", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateGreaterThanOrEqualTo(Date value) {
            addCriterion("sell_date >=", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateLessThan(Date value) {
            addCriterion("sell_date <", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateLessThanOrEqualTo(Date value) {
            addCriterion("sell_date <=", value, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateIn(List<Date> values) {
            addCriterion("sell_date in", values, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateNotIn(List<Date> values) {
            addCriterion("sell_date not in", values, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateBetween(Date value1, Date value2) {
            addCriterion("sell_date between", value1, value2, "sellDate");
            return (Criteria) this;
        }

        public Criteria andSellDateNotBetween(Date value1, Date value2) {
            addCriterion("sell_date not between", value1, value2, "sellDate");
            return (Criteria) this;
        }

        public Criteria andForecastProfitIsNull() {
            addCriterion("forecast_profit is null");
            return (Criteria) this;
        }

        public Criteria andForecastProfitIsNotNull() {
            addCriterion("forecast_profit is not null");
            return (Criteria) this;
        }

        public Criteria andForecastProfitEqualTo(BigDecimal value) {
            addCriterion("forecast_profit =", value, "forecastProfit");
            return (Criteria) this;
        }

        public Criteria andForecastProfitNotEqualTo(BigDecimal value) {
            addCriterion("forecast_profit <>", value, "forecastProfit");
            return (Criteria) this;
        }

        public Criteria andForecastProfitGreaterThan(BigDecimal value) {
            addCriterion("forecast_profit >", value, "forecastProfit");
            return (Criteria) this;
        }

        public Criteria andForecastProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("forecast_profit >=", value, "forecastProfit");
            return (Criteria) this;
        }

        public Criteria andForecastProfitLessThan(BigDecimal value) {
            addCriterion("forecast_profit <", value, "forecastProfit");
            return (Criteria) this;
        }

        public Criteria andForecastProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("forecast_profit <=", value, "forecastProfit");
            return (Criteria) this;
        }

        public Criteria andForecastProfitIn(List<BigDecimal> values) {
            addCriterion("forecast_profit in", values, "forecastProfit");
            return (Criteria) this;
        }

        public Criteria andForecastProfitNotIn(List<BigDecimal> values) {
            addCriterion("forecast_profit not in", values, "forecastProfit");
            return (Criteria) this;
        }

        public Criteria andForecastProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("forecast_profit between", value1, value2, "forecastProfit");
            return (Criteria) this;
        }

        public Criteria andForecastProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("forecast_profit not between", value1, value2, "forecastProfit");
            return (Criteria) this;
        }

        public Criteria andCountProfitIsNull() {
            addCriterion("count_profit is null");
            return (Criteria) this;
        }

        public Criteria andCountProfitIsNotNull() {
            addCriterion("count_profit is not null");
            return (Criteria) this;
        }

        public Criteria andCountProfitEqualTo(BigDecimal value) {
            addCriterion("count_profit =", value, "countProfit");
            return (Criteria) this;
        }

        public Criteria andCountProfitNotEqualTo(BigDecimal value) {
            addCriterion("count_profit <>", value, "countProfit");
            return (Criteria) this;
        }

        public Criteria andCountProfitGreaterThan(BigDecimal value) {
            addCriterion("count_profit >", value, "countProfit");
            return (Criteria) this;
        }

        public Criteria andCountProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("count_profit >=", value, "countProfit");
            return (Criteria) this;
        }

        public Criteria andCountProfitLessThan(BigDecimal value) {
            addCriterion("count_profit <", value, "countProfit");
            return (Criteria) this;
        }

        public Criteria andCountProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("count_profit <=", value, "countProfit");
            return (Criteria) this;
        }

        public Criteria andCountProfitIn(List<BigDecimal> values) {
            addCriterion("count_profit in", values, "countProfit");
            return (Criteria) this;
        }

        public Criteria andCountProfitNotIn(List<BigDecimal> values) {
            addCriterion("count_profit not in", values, "countProfit");
            return (Criteria) this;
        }

        public Criteria andCountProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("count_profit between", value1, value2, "countProfit");
            return (Criteria) this;
        }

        public Criteria andCountProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("count_profit not between", value1, value2, "countProfit");
            return (Criteria) this;
        }

        public Criteria andHotStatusIsNull() {
            addCriterion("hot_status is null");
            return (Criteria) this;
        }

        public Criteria andHotStatusIsNotNull() {
            addCriterion("hot_status is not null");
            return (Criteria) this;
        }

        public Criteria andHotStatusEqualTo(Integer value) {
            addCriterion("hot_status =", value, "hotStatus");
            return (Criteria) this;
        }

        public Criteria andHotStatusNotEqualTo(Integer value) {
            addCriterion("hot_status <>", value, "hotStatus");
            return (Criteria) this;
        }

        public Criteria andHotStatusGreaterThan(Integer value) {
            addCriterion("hot_status >", value, "hotStatus");
            return (Criteria) this;
        }

        public Criteria andHotStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("hot_status >=", value, "hotStatus");
            return (Criteria) this;
        }

        public Criteria andHotStatusLessThan(Integer value) {
            addCriterion("hot_status <", value, "hotStatus");
            return (Criteria) this;
        }

        public Criteria andHotStatusLessThanOrEqualTo(Integer value) {
            addCriterion("hot_status <=", value, "hotStatus");
            return (Criteria) this;
        }

        public Criteria andHotStatusIn(List<Integer> values) {
            addCriterion("hot_status in", values, "hotStatus");
            return (Criteria) this;
        }

        public Criteria andHotStatusNotIn(List<Integer> values) {
            addCriterion("hot_status not in", values, "hotStatus");
            return (Criteria) this;
        }

        public Criteria andHotStatusBetween(Integer value1, Integer value2) {
            addCriterion("hot_status between", value1, value2, "hotStatus");
            return (Criteria) this;
        }

        public Criteria andHotStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("hot_status not between", value1, value2, "hotStatus");
            return (Criteria) this;
        }

        public Criteria andForwardCarStatusIsNull() {
            addCriterion("forward_car_status is null");
            return (Criteria) this;
        }

        public Criteria andForwardCarStatusIsNotNull() {
            addCriterion("forward_car_status is not null");
            return (Criteria) this;
        }

        public Criteria andForwardCarStatusEqualTo(Integer value) {
            addCriterion("forward_car_status =", value, "forwardCarStatus");
            return (Criteria) this;
        }

        public Criteria andForwardCarStatusNotEqualTo(Integer value) {
            addCriterion("forward_car_status <>", value, "forwardCarStatus");
            return (Criteria) this;
        }

        public Criteria andForwardCarStatusGreaterThan(Integer value) {
            addCriterion("forward_car_status >", value, "forwardCarStatus");
            return (Criteria) this;
        }

        public Criteria andForwardCarStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("forward_car_status >=", value, "forwardCarStatus");
            return (Criteria) this;
        }

        public Criteria andForwardCarStatusLessThan(Integer value) {
            addCriterion("forward_car_status <", value, "forwardCarStatus");
            return (Criteria) this;
        }

        public Criteria andForwardCarStatusLessThanOrEqualTo(Integer value) {
            addCriterion("forward_car_status <=", value, "forwardCarStatus");
            return (Criteria) this;
        }

        public Criteria andForwardCarStatusIn(List<Integer> values) {
            addCriterion("forward_car_status in", values, "forwardCarStatus");
            return (Criteria) this;
        }

        public Criteria andForwardCarStatusNotIn(List<Integer> values) {
            addCriterion("forward_car_status not in", values, "forwardCarStatus");
            return (Criteria) this;
        }

        public Criteria andForwardCarStatusBetween(Integer value1, Integer value2) {
            addCriterion("forward_car_status between", value1, value2, "forwardCarStatus");
            return (Criteria) this;
        }

        public Criteria andForwardCarStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("forward_car_status not between", value1, value2, "forwardCarStatus");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateIsNull() {
            addCriterion("first_dms_date is null");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateIsNotNull() {
            addCriterion("first_dms_date is not null");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateEqualTo(Date value) {
            addCriterion("first_dms_date =", value, "firstDmsDate");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateNotEqualTo(Date value) {
            addCriterion("first_dms_date <>", value, "firstDmsDate");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateGreaterThan(Date value) {
            addCriterion("first_dms_date >", value, "firstDmsDate");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateGreaterThanOrEqualTo(Date value) {
            addCriterion("first_dms_date >=", value, "firstDmsDate");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateGreaterThanOrEqualTo(String value) {
            addCriterion("first_dms_date >=", value, "firstDmsDate");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateLessThan(Date value) {
            addCriterion("first_dms_date <", value, "firstDmsDate");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateLessThanOrEqualTo(Date value) {
            addCriterion("first_dms_date <=", value, "firstDmsDate");
            return (Criteria) this;
        }
        public Criteria andFirstDmsDateLessThanOrEqualTo(String value) {
            addCriterion("first_dms_date <=", value, "firstDmsDate");
            return (Criteria) this;
        }
        public Criteria andFirstDmsDateIn(List<Date> values) {
            addCriterion("first_dms_date in", values, "firstDmsDate");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateNotIn(List<Date> values) {
            addCriterion("first_dms_date not in", values, "firstDmsDate");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateBetween(Date value1, Date value2) {
            addCriterion("first_dms_date between", value1, value2, "firstDmsDate");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateBetween(String value1, String value2) {
            addCriterion("first_dms_date between", value1, value2, "firstDmsDate");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateNotBetween(Date value1, Date value2) {
            addCriterion("first_dms_date not between", value1, value2, "firstDmsDate");
            return (Criteria) this;
        }

        public Criteria andFirstDmsDateBetweenOrIsNull(String value1, String value2) {
            addCriterion("(first_dms_date between '"+ value1 +"' and '" + value2 +"' or first_dms_date is null)");
            return (Criteria) this;
        }
        public Criteria andFullPayDateBetweenOrFirstDmsDateBetween(String value1, String value2) {
            addCriterion("( first_dms_date between '"+value1+"' and '"+value2+"' or full_pay_date between '"+value1+"' and '"+value2+"'  )");
            return (Criteria) this;
        }

        public Criteria andBatchRebateEqualTo(Integer value) {
            addCriterion("batch_rebate =", value, "batchRebate");
            return (Criteria) this;
        }

        public Criteria andRetailRebateEqualTo(Integer value) {
            addCriterion("retail_rebate =", value, "retailRebate");
            return (Criteria) this;
        }

        public Criteria andRealDmsDateIsNull() {
            addCriterion("real_dms_date is null");
            return (Criteria) this;
        }

        public Criteria andRealDmsDateIsNotNull() {
            addCriterion("real_dms_date is not null");
            return (Criteria) this;
        }

        public Criteria andRealDmsDateEqualTo(Date value) {
            addCriterion("real_dms_date =", value, "realDmsDate");
            return (Criteria) this;
        }

        public Criteria andRealDmsDateNotEqualTo(Date value) {
            addCriterion("real_dms_date <>", value, "realDmsDate");
            return (Criteria) this;
        }

        public Criteria andRealDmsDateGreaterThan(Date value) {
            addCriterion("real_dms_date >", value, "realDmsDate");
            return (Criteria) this;
        }

        public Criteria andRealDmsDateGreaterThanOrEqualTo(Date value) {
            addCriterion("real_dms_date >=", value, "realDmsDate");
            return (Criteria) this;
        }

        public Criteria andRealDmsDateLessThan(Date value) {
            addCriterion("real_dms_date <", value, "realDmsDate");
            return (Criteria) this;
        }

        public Criteria andRealDmsDateLessThanOrEqualTo(Date value) {
            addCriterion("real_dms_date <=", value, "realDmsDate");
            return (Criteria) this;
        }

        public Criteria andRealDmsDateIn(List<Date> values) {
            addCriterion("real_dms_date in", values, "realDmsDate");
            return (Criteria) this;
        }

        public Criteria andRealDmsDateNotIn(List<Date> values) {
            addCriterion("real_dms_date not in", values, "realDmsDate");
            return (Criteria) this;
        }

        public Criteria andRealDmsDateBetween(Date value1, Date value2) {
            addCriterion("real_dms_date between", value1, value2, "realDmsDate");
            return (Criteria) this;
        }

        public Criteria andRealDmsDateNotBetween(Date value1, Date value2) {
            addCriterion("real_dms_date not between", value1, value2, "realDmsDate");
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
        public Criteria andCreateDateBetween(String value1, String value2) {
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

        public Criteria andTwoDimensionalCodeIsNull() {
            addCriterion("two_dimensional_code is null");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionalCodeIsNotNull() {
            addCriterion("two_dimensional_code is not null");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionalCodeEqualTo(String value) {
            addCriterion("two_dimensional_code =", value, "twoDimensionalCode");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionalCodeNotEqualTo(String value) {
            addCriterion("two_dimensional_code <>", value, "twoDimensionalCode");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionalCodeGreaterThan(String value) {
            addCriterion("two_dimensional_code >", value, "twoDimensionalCode");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("two_dimensional_code >=", value, "twoDimensionalCode");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionalCodeLessThan(String value) {
            addCriterion("two_dimensional_code <", value, "twoDimensionalCode");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionalCodeLessThanOrEqualTo(String value) {
            addCriterion("two_dimensional_code <=", value, "twoDimensionalCode");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionalCodeLike(String value) {
            addCriterion("two_dimensional_code like", value, "twoDimensionalCode");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionalCodeNotLike(String value) {
            addCriterion("two_dimensional_code not like", value, "twoDimensionalCode");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionalCodeIn(List<String> values) {
            addCriterion("two_dimensional_code in", values, "twoDimensionalCode");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionalCodeNotIn(List<String> values) {
            addCriterion("two_dimensional_code not in", values, "twoDimensionalCode");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionalCodeBetween(String value1, String value2) {
            addCriterion("two_dimensional_code between", value1, value2, "twoDimensionalCode");
            return (Criteria) this;
        }

        public Criteria andTwoDimensionalCodeNotBetween(String value1, String value2) {
            addCriterion("two_dimensional_code not between", value1, value2, "twoDimensionalCode");
            return (Criteria) this;
        }

        public Criteria andDetectionStatusIsNull() {
            addCriterion("detection_status is null");
            return (Criteria) this;
        }

        public Criteria andDetectionStatusIsNotNull() {
            addCriterion("detection_status is not null");
            return (Criteria) this;
        }

        public Criteria andDetectionStatusEqualTo(Byte value) {
            addCriterion("detection_status =", value, "detectionStatus");
            return (Criteria) this;
        }

        public Criteria andDetectionStatusNotEqualTo(Byte value) {
            addCriterion("detection_status <>", value, "detectionStatus");
            return (Criteria) this;
        }

        public Criteria andDetectionStatusGreaterThan(Byte value) {
            addCriterion("detection_status >", value, "detectionStatus");
            return (Criteria) this;
        }

        public Criteria andDetectionStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("detection_status >=", value, "detectionStatus");
            return (Criteria) this;
        }

        public Criteria andDetectionStatusLessThan(Byte value) {
            addCriterion("detection_status <", value, "detectionStatus");
            return (Criteria) this;
        }

        public Criteria andDetectionStatusLessThanOrEqualTo(Byte value) {
            addCriterion("detection_status <=", value, "detectionStatus");
            return (Criteria) this;
        }

        public Criteria andDetectionStatusIn(List<Byte> values) {
            addCriterion("detection_status in", values, "detectionStatus");
            return (Criteria) this;
        }

        public Criteria andDetectionStatusNotIn(List<Byte> values) {
            addCriterion("detection_status not in", values, "detectionStatus");
            return (Criteria) this;
        }

        public Criteria andDetectionStatusBetween(Byte value1, Byte value2) {
            addCriterion("detection_status between", value1, value2, "detectionStatus");
            return (Criteria) this;
        }

        public Criteria andDetectionStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("detection_status not between", value1, value2, "detectionStatus");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationIsNull() {
            addCriterion("exception_declaration is null");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationIsNotNull() {
            addCriterion("exception_declaration is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationEqualTo(String value) {
            addCriterion("exception_declaration =", value, "exceptionDeclaration");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationNotEqualTo(String value) {
            addCriterion("exception_declaration <>", value, "exceptionDeclaration");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationGreaterThan(String value) {
            addCriterion("exception_declaration >", value, "exceptionDeclaration");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationGreaterThanOrEqualTo(String value) {
            addCriterion("exception_declaration >=", value, "exceptionDeclaration");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationLessThan(String value) {
            addCriterion("exception_declaration <", value, "exceptionDeclaration");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationLessThanOrEqualTo(String value) {
            addCriterion("exception_declaration <=", value, "exceptionDeclaration");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationLike(String value) {
            addCriterion("exception_declaration like", value, "exceptionDeclaration");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationNotLike(String value) {
            addCriterion("exception_declaration not like", value, "exceptionDeclaration");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationIn(List<String> values) {
            addCriterion("exception_declaration in", values, "exceptionDeclaration");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationNotIn(List<String> values) {
            addCriterion("exception_declaration not in", values, "exceptionDeclaration");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationBetween(String value1, String value2) {
            addCriterion("exception_declaration between", value1, value2, "exceptionDeclaration");
            return (Criteria) this;
        }

        public Criteria andExceptionDeclarationNotBetween(String value1, String value2) {
            addCriterion("exception_declaration not between", value1, value2, "exceptionDeclaration");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoIsNull() {
            addCriterion("detection_photo is null");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoIsNotNull() {
            addCriterion("detection_photo is not null");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoEqualTo(String value) {
            addCriterion("detection_photo =", value, "detectionPhoto");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoNotEqualTo(String value) {
            addCriterion("detection_photo <>", value, "detectionPhoto");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoGreaterThan(String value) {
            addCriterion("detection_photo >", value, "detectionPhoto");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("detection_photo >=", value, "detectionPhoto");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoLessThan(String value) {
            addCriterion("detection_photo <", value, "detectionPhoto");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoLessThanOrEqualTo(String value) {
            addCriterion("detection_photo <=", value, "detectionPhoto");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoLike(String value) {
            addCriterion("detection_photo like", value, "detectionPhoto");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoNotLike(String value) {
            addCriterion("detection_photo not like", value, "detectionPhoto");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoIn(List<String> values) {
            addCriterion("detection_photo in", values, "detectionPhoto");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoNotIn(List<String> values) {
            addCriterion("detection_photo not in", values, "detectionPhoto");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoBetween(String value1, String value2) {
            addCriterion("detection_photo between", value1, value2, "detectionPhoto");
            return (Criteria) this;
        }

        public Criteria andDetectionPhotoNotBetween(String value1, String value2) {
            addCriterion("detection_photo not between", value1, value2, "detectionPhoto");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoIsNull() {
            addCriterion("exception_photo is null");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoIsNotNull() {
            addCriterion("exception_photo is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoEqualTo(String value) {
            addCriterion("exception_photo =", value, "exceptionPhoto");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoNotEqualTo(String value) {
            addCriterion("exception_photo <>", value, "exceptionPhoto");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoGreaterThan(String value) {
            addCriterion("exception_photo >", value, "exceptionPhoto");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("exception_photo >=", value, "exceptionPhoto");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoLessThan(String value) {
            addCriterion("exception_photo <", value, "exceptionPhoto");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoLessThanOrEqualTo(String value) {
            addCriterion("exception_photo <=", value, "exceptionPhoto");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoLike(String value) {
            addCriterion("exception_photo like", value, "exceptionPhoto");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoNotLike(String value) {
            addCriterion("exception_photo not like", value, "exceptionPhoto");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoIn(List<String> values) {
            addCriterion("exception_photo in", values, "exceptionPhoto");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoNotIn(List<String> values) {
            addCriterion("exception_photo not in", values, "exceptionPhoto");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoBetween(String value1, String value2) {
            addCriterion("exception_photo between", value1, value2, "exceptionPhoto");
            return (Criteria) this;
        }

        public Criteria andExceptionPhotoNotBetween(String value1, String value2) {
            addCriterion("exception_photo not between", value1, value2, "exceptionPhoto");
            return (Criteria) this;
        }

        public Criteria andStockCountIsNull() {
            addCriterion("stock_count is null");
            return (Criteria) this;
        }

        public Criteria andStockCountIsNotNull() {
            addCriterion("stock_count is not null");
            return (Criteria) this;
        }

        public Criteria andStockCountEqualTo(Boolean value) {
            addCriterion("stock_count =", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountNotEqualTo(Boolean value) {
            addCriterion("stock_count <>", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountGreaterThan(Boolean value) {
            addCriterion("stock_count >", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountGreaterThanOrEqualTo(Boolean value) {
            addCriterion("stock_count >=", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountLessThan(Boolean value) {
            addCriterion("stock_count <", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountLessThanOrEqualTo(Boolean value) {
            addCriterion("stock_count <=", value, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountIn(List<Boolean> values) {
            addCriterion("stock_count in", values, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountNotIn(List<Boolean> values) {
            addCriterion("stock_count not in", values, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountBetween(Boolean value1, Boolean value2) {
            addCriterion("stock_count between", value1, value2, "stockCount");
            return (Criteria) this;
        }

        public Criteria andStockCountNotBetween(Boolean value1, Boolean value2) {
            addCriterion("stock_count not between", value1, value2, "stockCount");
            return (Criteria) this;
        }

        public Criteria andDepotCheckIdIsNull() {
            addCriterion("depot_check_id is null");
            return (Criteria) this;
        }

        public Criteria andDepotCheckIdIsNotNull() {
            addCriterion("depot_check_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepotCheckIdEqualTo(Integer value) {
            addCriterion("depot_check_id =", value, "depotCheckId");
            return (Criteria) this;
        }

        public Criteria andDepotCheckIdNotEqualTo(Integer value) {
            addCriterion("depot_check_id <>", value, "depotCheckId");
            return (Criteria) this;
        }

        public Criteria andDepotCheckIdGreaterThan(Integer value) {
            addCriterion("depot_check_id >", value, "depotCheckId");
            return (Criteria) this;
        }

        public Criteria andDepotCheckIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("depot_check_id >=", value, "depotCheckId");
            return (Criteria) this;
        }

        public Criteria andDepotCheckIdLessThan(Integer value) {
            addCriterion("depot_check_id <", value, "depotCheckId");
            return (Criteria) this;
        }

        public Criteria andDepotCheckIdLessThanOrEqualTo(Integer value) {
            addCriterion("depot_check_id <=", value, "depotCheckId");
            return (Criteria) this;
        }

        public Criteria andDepotCheckIdIn(List<Integer> values) {
            addCriterion("depot_check_id in", values, "depotCheckId");
            return (Criteria) this;
        }

        public Criteria andDepotCheckIdNotIn(List<Integer> values) {
            addCriterion("depot_check_id not in", values, "depotCheckId");
            return (Criteria) this;
        }

        public Criteria andDepotCheckIdBetween(Integer value1, Integer value2) {
            addCriterion("depot_check_id between", value1, value2, "depotCheckId");
            return (Criteria) this;
        }

        public Criteria andDepotCheckIdNotBetween(Integer value1, Integer value2) {
            addCriterion("depot_check_id not between", value1, value2, "depotCheckId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Integer orderStatus) {
            addCriterion("order_status = "+orderStatus);
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