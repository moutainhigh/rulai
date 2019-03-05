package com.unicdata.entity.boutique;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoutiquePushWarehouseDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BoutiquePushWarehouseDetailExample() {
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

        public Criteria andPushIdIsNull() {
            addCriterion("push_id is null");
            return (Criteria) this;
        }

        public Criteria andPushIdIsNotNull() {
            addCriterion("push_id is not null");
            return (Criteria) this;
        }

        public Criteria andPushIdEqualTo(String value) {
            addCriterion("push_id =", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdNotEqualTo(String value) {
            addCriterion("push_id <>", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdGreaterThan(String value) {
            addCriterion("push_id >", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdGreaterThanOrEqualTo(String value) {
            addCriterion("push_id >=", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdLessThan(String value) {
            addCriterion("push_id <", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdLessThanOrEqualTo(String value) {
            addCriterion("push_id <=", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdLike(String value) {
            addCriterion("push_id like", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdNotLike(String value) {
            addCriterion("push_id not like", value, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdIn(List<String> values) {
            addCriterion("push_id in", values, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdNotIn(List<String> values) {
            addCriterion("push_id not in", values, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdBetween(String value1, String value2) {
            addCriterion("push_id between", value1, value2, "pushId");
            return (Criteria) this;
        }

        public Criteria andPushIdNotBetween(String value1, String value2) {
            addCriterion("push_id not between", value1, value2, "pushId");
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

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceIsNull() {
            addCriterion("tax_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceIsNotNull() {
            addCriterion("tax_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price =", value, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price <>", value, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("tax_unit_price >", value, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price >=", value, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceLessThan(BigDecimal value) {
            addCriterion("tax_unit_price <", value, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price <=", value, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceIn(List<BigDecimal> values) {
            addCriterion("tax_unit_price in", values, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("tax_unit_price not in", values, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_unit_price between", value1, value2, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_unit_price not between", value1, value2, "taxUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTaxCostIsNull() {
            addCriterion("tax_cost is null");
            return (Criteria) this;
        }

        public Criteria andTaxCostIsNotNull() {
            addCriterion("tax_cost is not null");
            return (Criteria) this;
        }

        public Criteria andTaxCostEqualTo(BigDecimal value) {
            addCriterion("tax_cost =", value, "taxCost");
            return (Criteria) this;
        }

        public Criteria andTaxCostNotEqualTo(BigDecimal value) {
            addCriterion("tax_cost <>", value, "taxCost");
            return (Criteria) this;
        }

        public Criteria andTaxCostGreaterThan(BigDecimal value) {
            addCriterion("tax_cost >", value, "taxCost");
            return (Criteria) this;
        }

        public Criteria andTaxCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_cost >=", value, "taxCost");
            return (Criteria) this;
        }

        public Criteria andTaxCostLessThan(BigDecimal value) {
            addCriterion("tax_cost <", value, "taxCost");
            return (Criteria) this;
        }

        public Criteria andTaxCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_cost <=", value, "taxCost");
            return (Criteria) this;
        }

        public Criteria andTaxCostIn(List<BigDecimal> values) {
            addCriterion("tax_cost in", values, "taxCost");
            return (Criteria) this;
        }

        public Criteria andTaxCostNotIn(List<BigDecimal> values) {
            addCriterion("tax_cost not in", values, "taxCost");
            return (Criteria) this;
        }

        public Criteria andTaxCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_cost between", value1, value2, "taxCost");
            return (Criteria) this;
        }

        public Criteria andTaxCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_cost not between", value1, value2, "taxCost");
            return (Criteria) this;
        }

        public Criteria andSalesCostIsNull() {
            addCriterion("sales_cost is null");
            return (Criteria) this;
        }

        public Criteria andSalesCostIsNotNull() {
            addCriterion("sales_cost is not null");
            return (Criteria) this;
        }

        public Criteria andSalesCostEqualTo(BigDecimal value) {
            addCriterion("sales_cost =", value, "salesCost");
            return (Criteria) this;
        }

        public Criteria andSalesCostNotEqualTo(BigDecimal value) {
            addCriterion("sales_cost <>", value, "salesCost");
            return (Criteria) this;
        }

        public Criteria andSalesCostGreaterThan(BigDecimal value) {
            addCriterion("sales_cost >", value, "salesCost");
            return (Criteria) this;
        }

        public Criteria andSalesCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_cost >=", value, "salesCost");
            return (Criteria) this;
        }

        public Criteria andSalesCostLessThan(BigDecimal value) {
            addCriterion("sales_cost <", value, "salesCost");
            return (Criteria) this;
        }

        public Criteria andSalesCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_cost <=", value, "salesCost");
            return (Criteria) this;
        }

        public Criteria andSalesCostIn(List<BigDecimal> values) {
            addCriterion("sales_cost in", values, "salesCost");
            return (Criteria) this;
        }

        public Criteria andSalesCostNotIn(List<BigDecimal> values) {
            addCriterion("sales_cost not in", values, "salesCost");
            return (Criteria) this;
        }

        public Criteria andSalesCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_cost between", value1, value2, "salesCost");
            return (Criteria) this;
        }

        public Criteria andSalesCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_cost not between", value1, value2, "salesCost");
            return (Criteria) this;
        }

        public Criteria andSalesTypeIsNull() {
            addCriterion("sales_type is null");
            return (Criteria) this;
        }

        public Criteria andSalesTypeIsNotNull() {
            addCriterion("sales_type is not null");
            return (Criteria) this;
        }

        public Criteria andSalesTypeEqualTo(String value) {
            addCriterion("sales_type =", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeNotEqualTo(String value) {
            addCriterion("sales_type <>", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeGreaterThan(String value) {
            addCriterion("sales_type >", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sales_type >=", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeLessThan(String value) {
            addCriterion("sales_type <", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeLessThanOrEqualTo(String value) {
            addCriterion("sales_type <=", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeLike(String value) {
            addCriterion("sales_type like", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeNotLike(String value) {
            addCriterion("sales_type not like", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeIn(List<String> values) {
            addCriterion("sales_type in", values, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeNotIn(List<String> values) {
            addCriterion("sales_type not in", values, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeBetween(String value1, String value2) {
            addCriterion("sales_type between", value1, value2, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeNotBetween(String value1, String value2) {
            addCriterion("sales_type not between", value1, value2, "salesType");
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

        public Criteria andTimestampIsNull() {
            addCriterion("timestamp is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(Date value) {
            addCriterion("timestamp =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(Date value) {
            addCriterion("timestamp <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(Date value) {
            addCriterion("timestamp >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("timestamp >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(Date value) {
            addCriterion("timestamp <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(Date value) {
            addCriterion("timestamp <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<Date> values) {
            addCriterion("timestamp in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<Date> values) {
            addCriterion("timestamp not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(Date value1, Date value2) {
            addCriterion("timestamp between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(Date value1, Date value2) {
            addCriterion("timestamp not between", value1, value2, "timestamp");
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