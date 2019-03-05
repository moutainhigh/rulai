package com.unicdata.entity.boutique;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CheckItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckItemExample() {
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

        public Criteria andCheckIdIsNull() {
            addCriterion("check_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckIdIsNotNull() {
            addCriterion("check_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckIdEqualTo(Integer value) {
            addCriterion("check_id =", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotEqualTo(Integer value) {
            addCriterion("check_id <>", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThan(Integer value) {
            addCriterion("check_id >", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_id >=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThan(Integer value) {
            addCriterion("check_id <", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThanOrEqualTo(Integer value) {
            addCriterion("check_id <=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdIn(List<Integer> values) {
            addCriterion("check_id in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotIn(List<Integer> values) {
            addCriterion("check_id not in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdBetween(Integer value1, Integer value2) {
            addCriterion("check_id between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotBetween(Integer value1, Integer value2) {
            addCriterion("check_id not between", value1, value2, "checkId");
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

        public Criteria andPhysicalCountQuantityIsNull() {
            addCriterion("physical_count_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalCountQuantityIsNotNull() {
            addCriterion("physical_count_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalCountQuantityEqualTo(BigDecimal value) {
            addCriterion("physical_count_quantity =", value, "physicalCountQuantity");
            return (Criteria) this;
        }

        public Criteria andPhysicalCountQuantityNotEqualTo(BigDecimal value) {
            addCriterion("physical_count_quantity <>", value, "physicalCountQuantity");
            return (Criteria) this;
        }

        public Criteria andPhysicalCountQuantityGreaterThan(BigDecimal value) {
            addCriterion("physical_count_quantity >", value, "physicalCountQuantity");
            return (Criteria) this;
        }

        public Criteria andPhysicalCountQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("physical_count_quantity >=", value, "physicalCountQuantity");
            return (Criteria) this;
        }

        public Criteria andPhysicalCountQuantityLessThan(BigDecimal value) {
            addCriterion("physical_count_quantity <", value, "physicalCountQuantity");
            return (Criteria) this;
        }

        public Criteria andPhysicalCountQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("physical_count_quantity <=", value, "physicalCountQuantity");
            return (Criteria) this;
        }

        public Criteria andPhysicalCountQuantityIn(List<BigDecimal> values) {
            addCriterion("physical_count_quantity in", values, "physicalCountQuantity");
            return (Criteria) this;
        }

        public Criteria andPhysicalCountQuantityNotIn(List<BigDecimal> values) {
            addCriterion("physical_count_quantity not in", values, "physicalCountQuantity");
            return (Criteria) this;
        }

        public Criteria andPhysicalCountQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("physical_count_quantity between", value1, value2, "physicalCountQuantity");
            return (Criteria) this;
        }

        public Criteria andPhysicalCountQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("physical_count_quantity not between", value1, value2, "physicalCountQuantity");
            return (Criteria) this;
        }

        public Criteria andPhysicalInventoryIsNull() {
            addCriterion("physical_inventory is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalInventoryIsNotNull() {
            addCriterion("physical_inventory is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalInventoryEqualTo(BigDecimal value) {
            addCriterion("physical_inventory =", value, "physicalInventory");
            return (Criteria) this;
        }

        public Criteria andPhysicalInventoryNotEqualTo(BigDecimal value) {
            addCriterion("physical_inventory <>", value, "physicalInventory");
            return (Criteria) this;
        }

        public Criteria andPhysicalInventoryGreaterThan(BigDecimal value) {
            addCriterion("physical_inventory >", value, "physicalInventory");
            return (Criteria) this;
        }

        public Criteria andPhysicalInventoryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("physical_inventory >=", value, "physicalInventory");
            return (Criteria) this;
        }

        public Criteria andPhysicalInventoryLessThan(BigDecimal value) {
            addCriterion("physical_inventory <", value, "physicalInventory");
            return (Criteria) this;
        }

        public Criteria andPhysicalInventoryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("physical_inventory <=", value, "physicalInventory");
            return (Criteria) this;
        }

        public Criteria andPhysicalInventoryIn(List<BigDecimal> values) {
            addCriterion("physical_inventory in", values, "physicalInventory");
            return (Criteria) this;
        }

        public Criteria andPhysicalInventoryNotIn(List<BigDecimal> values) {
            addCriterion("physical_inventory not in", values, "physicalInventory");
            return (Criteria) this;
        }

        public Criteria andPhysicalInventoryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("physical_inventory between", value1, value2, "physicalInventory");
            return (Criteria) this;
        }

        public Criteria andPhysicalInventoryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("physical_inventory not between", value1, value2, "physicalInventory");
            return (Criteria) this;
        }

        public Criteria andDifferenceQuantityIsNull() {
            addCriterion("difference_quantity is null");
            return (Criteria) this;
        }

        public Criteria andDifferenceQuantityIsNotNull() {
            addCriterion("difference_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andDifferenceQuantityEqualTo(BigDecimal value) {
            addCriterion("difference_quantity =", value, "differenceQuantity");
            return (Criteria) this;
        }

        public Criteria andDifferenceQuantityNotEqualTo(BigDecimal value) {
            addCriterion("difference_quantity <>", value, "differenceQuantity");
            return (Criteria) this;
        }

        public Criteria andDifferenceQuantityGreaterThan(BigDecimal value) {
            addCriterion("difference_quantity >", value, "differenceQuantity");
            return (Criteria) this;
        }

        public Criteria andDifferenceQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("difference_quantity >=", value, "differenceQuantity");
            return (Criteria) this;
        }

        public Criteria andDifferenceQuantityLessThan(BigDecimal value) {
            addCriterion("difference_quantity <", value, "differenceQuantity");
            return (Criteria) this;
        }

        public Criteria andDifferenceQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("difference_quantity <=", value, "differenceQuantity");
            return (Criteria) this;
        }

        public Criteria andDifferenceQuantityIn(List<BigDecimal> values) {
            addCriterion("difference_quantity in", values, "differenceQuantity");
            return (Criteria) this;
        }

        public Criteria andDifferenceQuantityNotIn(List<BigDecimal> values) {
            addCriterion("difference_quantity not in", values, "differenceQuantity");
            return (Criteria) this;
        }

        public Criteria andDifferenceQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("difference_quantity between", value1, value2, "differenceQuantity");
            return (Criteria) this;
        }

        public Criteria andDifferenceQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("difference_quantity not between", value1, value2, "differenceQuantity");
            return (Criteria) this;
        }

        public Criteria andDifferenceMoneyIsNull() {
            addCriterion("difference_money is null");
            return (Criteria) this;
        }

        public Criteria andDifferenceMoneyIsNotNull() {
            addCriterion("difference_money is not null");
            return (Criteria) this;
        }

        public Criteria andDifferenceMoneyEqualTo(BigDecimal value) {
            addCriterion("difference_money =", value, "differenceMoney");
            return (Criteria) this;
        }

        public Criteria andDifferenceMoneyNotEqualTo(BigDecimal value) {
            addCriterion("difference_money <>", value, "differenceMoney");
            return (Criteria) this;
        }

        public Criteria andDifferenceMoneyGreaterThan(BigDecimal value) {
            addCriterion("difference_money >", value, "differenceMoney");
            return (Criteria) this;
        }

        public Criteria andDifferenceMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("difference_money >=", value, "differenceMoney");
            return (Criteria) this;
        }

        public Criteria andDifferenceMoneyLessThan(BigDecimal value) {
            addCriterion("difference_money <", value, "differenceMoney");
            return (Criteria) this;
        }

        public Criteria andDifferenceMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("difference_money <=", value, "differenceMoney");
            return (Criteria) this;
        }

        public Criteria andDifferenceMoneyIn(List<BigDecimal> values) {
            addCriterion("difference_money in", values, "differenceMoney");
            return (Criteria) this;
        }

        public Criteria andDifferenceMoneyNotIn(List<BigDecimal> values) {
            addCriterion("difference_money not in", values, "differenceMoney");
            return (Criteria) this;
        }

        public Criteria andDifferenceMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("difference_money between", value1, value2, "differenceMoney");
            return (Criteria) this;
        }

        public Criteria andDifferenceMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("difference_money not between", value1, value2, "differenceMoney");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost not between", value1, value2, "cost");
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