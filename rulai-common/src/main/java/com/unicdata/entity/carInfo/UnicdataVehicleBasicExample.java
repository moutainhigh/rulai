package com.unicdata.entity.carInfo;

import java.util.ArrayList;
import java.util.List;

public class UnicdataVehicleBasicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UnicdataVehicleBasicExample() {
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

        public Criteria andRowNamesIsNull() {
            addCriterion("row_names is null");
            return (Criteria) this;
        }

        public Criteria andRowNamesIsNotNull() {
            addCriterion("row_names is not null");
            return (Criteria) this;
        }

        public Criteria andRowNamesEqualTo(Integer value) {
            addCriterion("row_names =", value, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesNotEqualTo(Integer value) {
            addCriterion("row_names <>", value, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesGreaterThan(Integer value) {
            addCriterion("row_names >", value, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesGreaterThanOrEqualTo(Integer value) {
            addCriterion("row_names >=", value, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesLessThan(Integer value) {
            addCriterion("row_names <", value, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesLessThanOrEqualTo(Integer value) {
            addCriterion("row_names <=", value, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesIn(List<Integer> values) {
            addCriterion("row_names in", values, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesNotIn(List<Integer> values) {
            addCriterion("row_names not in", values, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesBetween(Integer value1, Integer value2) {
            addCriterion("row_names between", value1, value2, "rowNames");
            return (Criteria) this;
        }

        public Criteria andRowNamesNotBetween(Integer value1, Integer value2) {
            addCriterion("row_names not between", value1, value2, "rowNames");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyIsNull() {
            addCriterion("unicdatakey is null");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyIsNotNull() {
            addCriterion("unicdatakey is not null");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyEqualTo(String value) {
            addCriterion("unicdatakey =", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyNotEqualTo(String value) {
            addCriterion("unicdatakey <>", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyGreaterThan(String value) {
            addCriterion("unicdatakey >", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyGreaterThanOrEqualTo(String value) {
            addCriterion("unicdatakey >=", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyLessThan(String value) {
            addCriterion("unicdatakey <", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyLessThanOrEqualTo(String value) {
            addCriterion("unicdatakey <=", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyLike(String value) {
            addCriterion("unicdatakey like", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyNotLike(String value) {
            addCriterion("unicdatakey not like", value, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyIn(List<String> values) {
            addCriterion("unicdatakey in", values, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyNotIn(List<String> values) {
            addCriterion("unicdatakey not in", values, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyBetween(String value1, String value2) {
            addCriterion("unicdatakey between", value1, value2, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andUnicdatakeyNotBetween(String value1, String value2) {
            addCriterion("unicdatakey not between", value1, value2, "unicdatakey");
            return (Criteria) this;
        }

        public Criteria andBrandnameIsNull() {
            addCriterion("brandname is null");
            return (Criteria) this;
        }

        public Criteria andBrandnameIsNotNull() {
            addCriterion("brandname is not null");
            return (Criteria) this;
        }

        public Criteria andBrandnameEqualTo(String value) {
            addCriterion("brandname =", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotEqualTo(String value) {
            addCriterion("brandname <>", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameGreaterThan(String value) {
            addCriterion("brandname >", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameGreaterThanOrEqualTo(String value) {
            addCriterion("brandname >=", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLessThan(String value) {
            addCriterion("brandname <", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLessThanOrEqualTo(String value) {
            addCriterion("brandname <=", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLike(String value) {
            addCriterion("brandname like", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotLike(String value) {
            addCriterion("brandname not like", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameIn(List<String> values) {
            addCriterion("brandname in", values, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotIn(List<String> values) {
            addCriterion("brandname not in", values, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameBetween(String value1, String value2) {
            addCriterion("brandname between", value1, value2, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotBetween(String value1, String value2) {
            addCriterion("brandname not between", value1, value2, "brandname");
            return (Criteria) this;
        }

        public Criteria andFactorynameIsNull() {
            addCriterion("factoryname is null");
            return (Criteria) this;
        }

        public Criteria andFactorynameIsNotNull() {
            addCriterion("factoryname is not null");
            return (Criteria) this;
        }

        public Criteria andFactorynameEqualTo(String value) {
            addCriterion("factoryname =", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameNotEqualTo(String value) {
            addCriterion("factoryname <>", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameGreaterThan(String value) {
            addCriterion("factoryname >", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameGreaterThanOrEqualTo(String value) {
            addCriterion("factoryname >=", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameLessThan(String value) {
            addCriterion("factoryname <", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameLessThanOrEqualTo(String value) {
            addCriterion("factoryname <=", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameLike(String value) {
            addCriterion("factoryname like", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameNotLike(String value) {
            addCriterion("factoryname not like", value, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameIn(List<String> values) {
            addCriterion("factoryname in", values, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameNotIn(List<String> values) {
            addCriterion("factoryname not in", values, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameBetween(String value1, String value2) {
            addCriterion("factoryname between", value1, value2, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFactorynameNotBetween(String value1, String value2) {
            addCriterion("factoryname not between", value1, value2, "factoryname");
            return (Criteria) this;
        }

        public Criteria andFamilynameIsNull() {
            addCriterion("familyname is null");
            return (Criteria) this;
        }

        public Criteria andFamilynameIsNotNull() {
            addCriterion("familyname is not null");
            return (Criteria) this;
        }

        public Criteria andFamilynameEqualTo(String value) {
            addCriterion("familyname =", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotEqualTo(String value) {
            addCriterion("familyname <>", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameGreaterThan(String value) {
            addCriterion("familyname >", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameGreaterThanOrEqualTo(String value) {
            addCriterion("familyname >=", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameLessThan(String value) {
            addCriterion("familyname <", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameLessThanOrEqualTo(String value) {
            addCriterion("familyname <=", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameLike(String value) {
            addCriterion("familyname like", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotLike(String value) {
            addCriterion("familyname not like", value, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameIn(List<String> values) {
            addCriterion("familyname in", values, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotIn(List<String> values) {
            addCriterion("familyname not in", values, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameBetween(String value1, String value2) {
            addCriterion("familyname between", value1, value2, "familyname");
            return (Criteria) this;
        }

        public Criteria andFamilynameNotBetween(String value1, String value2) {
            addCriterion("familyname not between", value1, value2, "familyname");
            return (Criteria) this;
        }

        public Criteria andBrandidIsNull() {
            addCriterion("brandid is null");
            return (Criteria) this;
        }

        public Criteria andBrandidIsNotNull() {
            addCriterion("brandid is not null");
            return (Criteria) this;
        }

        public Criteria andBrandidEqualTo(Double value) {
            addCriterion("brandid =", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidNotEqualTo(Double value) {
            addCriterion("brandid <>", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidGreaterThan(Double value) {
            addCriterion("brandid >", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidGreaterThanOrEqualTo(Double value) {
            addCriterion("brandid >=", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidLessThan(Double value) {
            addCriterion("brandid <", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidLessThanOrEqualTo(Double value) {
            addCriterion("brandid <=", value, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidIn(List<Double> values) {
            addCriterion("brandid in", values, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidNotIn(List<Double> values) {
            addCriterion("brandid not in", values, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidBetween(Double value1, Double value2) {
            addCriterion("brandid between", value1, value2, "brandid");
            return (Criteria) this;
        }

        public Criteria andBrandidNotBetween(Double value1, Double value2) {
            addCriterion("brandid not between", value1, value2, "brandid");
            return (Criteria) this;
        }

        public Criteria andFactoryidIsNull() {
            addCriterion("factoryid is null");
            return (Criteria) this;
        }

        public Criteria andFactoryidIsNotNull() {
            addCriterion("factoryid is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryidEqualTo(Double value) {
            addCriterion("factoryid =", value, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidNotEqualTo(Double value) {
            addCriterion("factoryid <>", value, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidGreaterThan(Double value) {
            addCriterion("factoryid >", value, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidGreaterThanOrEqualTo(Double value) {
            addCriterion("factoryid >=", value, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidLessThan(Double value) {
            addCriterion("factoryid <", value, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidLessThanOrEqualTo(Double value) {
            addCriterion("factoryid <=", value, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidIn(List<Double> values) {
            addCriterion("factoryid in", values, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidNotIn(List<Double> values) {
            addCriterion("factoryid not in", values, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidBetween(Double value1, Double value2) {
            addCriterion("factoryid between", value1, value2, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidNotBetween(Double value1, Double value2) {
            addCriterion("factoryid not between", value1, value2, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFamilyidIsNull() {
            addCriterion("familyid is null");
            return (Criteria) this;
        }

        public Criteria andFamilyidIsNotNull() {
            addCriterion("familyid is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyidEqualTo(Double value) {
            addCriterion("familyid =", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidNotEqualTo(Double value) {
            addCriterion("familyid <>", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidGreaterThan(Double value) {
            addCriterion("familyid >", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidGreaterThanOrEqualTo(Double value) {
            addCriterion("familyid >=", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidLessThan(Double value) {
            addCriterion("familyid <", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidLessThanOrEqualTo(Double value) {
            addCriterion("familyid <=", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidIn(List<Double> values) {
            addCriterion("familyid in", values, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidNotIn(List<Double> values) {
            addCriterion("familyid not in", values, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidBetween(Double value1, Double value2) {
            addCriterion("familyid between", value1, value2, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidNotBetween(Double value1, Double value2) {
            addCriterion("familyid not between", value1, value2, "familyid");
            return (Criteria) this;
        }

        public Criteria andMakeyearIsNull() {
            addCriterion("makeyear is null");
            return (Criteria) this;
        }

        public Criteria andMakeyearIsNotNull() {
            addCriterion("makeyear is not null");
            return (Criteria) this;
        }

        public Criteria andMakeyearEqualTo(String value) {
            addCriterion("makeyear =", value, "makeyear");
            return (Criteria) this;
        }

        public Criteria andMakeyearNotEqualTo(String value) {
            addCriterion("makeyear <>", value, "makeyear");
            return (Criteria) this;
        }

        public Criteria andMakeyearGreaterThan(String value) {
            addCriterion("makeyear >", value, "makeyear");
            return (Criteria) this;
        }

        public Criteria andMakeyearGreaterThanOrEqualTo(String value) {
            addCriterion("makeyear >=", value, "makeyear");
            return (Criteria) this;
        }

        public Criteria andMakeyearLessThan(String value) {
            addCriterion("makeyear <", value, "makeyear");
            return (Criteria) this;
        }

        public Criteria andMakeyearLessThanOrEqualTo(String value) {
            addCriterion("makeyear <=", value, "makeyear");
            return (Criteria) this;
        }

        public Criteria andMakeyearLike(String value) {
            addCriterion("makeyear like", value, "makeyear");
            return (Criteria) this;
        }

        public Criteria andMakeyearNotLike(String value) {
            addCriterion("makeyear not like", value, "makeyear");
            return (Criteria) this;
        }

        public Criteria andMakeyearIn(List<String> values) {
            addCriterion("makeyear in", values, "makeyear");
            return (Criteria) this;
        }

        public Criteria andMakeyearNotIn(List<String> values) {
            addCriterion("makeyear not in", values, "makeyear");
            return (Criteria) this;
        }

        public Criteria andMakeyearBetween(String value1, String value2) {
            addCriterion("makeyear between", value1, value2, "makeyear");
            return (Criteria) this;
        }

        public Criteria andMakeyearNotBetween(String value1, String value2) {
            addCriterion("makeyear not between", value1, value2, "makeyear");
            return (Criteria) this;
        }

        public Criteria andOutputIsNull() {
            addCriterion("output is null");
            return (Criteria) this;
        }

        public Criteria andOutputIsNotNull() {
            addCriterion("output is not null");
            return (Criteria) this;
        }

        public Criteria andOutputEqualTo(Double value) {
            addCriterion("output =", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotEqualTo(Double value) {
            addCriterion("output <>", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputGreaterThan(Double value) {
            addCriterion("output >", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputGreaterThanOrEqualTo(Double value) {
            addCriterion("output >=", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLessThan(Double value) {
            addCriterion("output <", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputLessThanOrEqualTo(Double value) {
            addCriterion("output <=", value, "output");
            return (Criteria) this;
        }

        public Criteria andOutputIn(List<Double> values) {
            addCriterion("output in", values, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotIn(List<Double> values) {
            addCriterion("output not in", values, "output");
            return (Criteria) this;
        }

        public Criteria andOutputBetween(Double value1, Double value2) {
            addCriterion("output between", value1, value2, "output");
            return (Criteria) this;
        }

        public Criteria andOutputNotBetween(Double value1, Double value2) {
            addCriterion("output not between", value1, value2, "output");
            return (Criteria) this;
        }

        public Criteria andGeartypeIsNull() {
            addCriterion("geartype is null");
            return (Criteria) this;
        }

        public Criteria andGeartypeIsNotNull() {
            addCriterion("geartype is not null");
            return (Criteria) this;
        }

        public Criteria andGeartypeEqualTo(String value) {
            addCriterion("geartype =", value, "geartype");
            return (Criteria) this;
        }

        public Criteria andGeartypeNotEqualTo(String value) {
            addCriterion("geartype <>", value, "geartype");
            return (Criteria) this;
        }

        public Criteria andGeartypeGreaterThan(String value) {
            addCriterion("geartype >", value, "geartype");
            return (Criteria) this;
        }

        public Criteria andGeartypeGreaterThanOrEqualTo(String value) {
            addCriterion("geartype >=", value, "geartype");
            return (Criteria) this;
        }

        public Criteria andGeartypeLessThan(String value) {
            addCriterion("geartype <", value, "geartype");
            return (Criteria) this;
        }

        public Criteria andGeartypeLessThanOrEqualTo(String value) {
            addCriterion("geartype <=", value, "geartype");
            return (Criteria) this;
        }

        public Criteria andGeartypeLike(String value) {
            addCriterion("geartype like", value, "geartype");
            return (Criteria) this;
        }

        public Criteria andGeartypeNotLike(String value) {
            addCriterion("geartype not like", value, "geartype");
            return (Criteria) this;
        }

        public Criteria andGeartypeIn(List<String> values) {
            addCriterion("geartype in", values, "geartype");
            return (Criteria) this;
        }

        public Criteria andGeartypeNotIn(List<String> values) {
            addCriterion("geartype not in", values, "geartype");
            return (Criteria) this;
        }

        public Criteria andGeartypeBetween(String value1, String value2) {
            addCriterion("geartype between", value1, value2, "geartype");
            return (Criteria) this;
        }

        public Criteria andGeartypeNotBetween(String value1, String value2) {
            addCriterion("geartype not between", value1, value2, "geartype");
            return (Criteria) this;
        }

        public Criteria andSalesdescIsNull() {
            addCriterion("salesdesc is null");
            return (Criteria) this;
        }

        public Criteria andSalesdescIsNotNull() {
            addCriterion("salesdesc is not null");
            return (Criteria) this;
        }

        public Criteria andSalesdescEqualTo(String value) {
            addCriterion("salesdesc =", value, "salesdesc");
            return (Criteria) this;
        }

        public Criteria andSalesdescNotEqualTo(String value) {
            addCriterion("salesdesc <>", value, "salesdesc");
            return (Criteria) this;
        }

        public Criteria andSalesdescGreaterThan(String value) {
            addCriterion("salesdesc >", value, "salesdesc");
            return (Criteria) this;
        }

        public Criteria andSalesdescGreaterThanOrEqualTo(String value) {
            addCriterion("salesdesc >=", value, "salesdesc");
            return (Criteria) this;
        }

        public Criteria andSalesdescLessThan(String value) {
            addCriterion("salesdesc <", value, "salesdesc");
            return (Criteria) this;
        }

        public Criteria andSalesdescLessThanOrEqualTo(String value) {
            addCriterion("salesdesc <=", value, "salesdesc");
            return (Criteria) this;
        }

        public Criteria andSalesdescLike(String value) {
            addCriterion("salesdesc like", value, "salesdesc");
            return (Criteria) this;
        }

        public Criteria andSalesdescNotLike(String value) {
            addCriterion("salesdesc not like", value, "salesdesc");
            return (Criteria) this;
        }

        public Criteria andSalesdescIn(List<String> values) {
            addCriterion("salesdesc in", values, "salesdesc");
            return (Criteria) this;
        }

        public Criteria andSalesdescNotIn(List<String> values) {
            addCriterion("salesdesc not in", values, "salesdesc");
            return (Criteria) this;
        }

        public Criteria andSalesdescBetween(String value1, String value2) {
            addCriterion("salesdesc between", value1, value2, "salesdesc");
            return (Criteria) this;
        }

        public Criteria andSalesdescNotBetween(String value1, String value2) {
            addCriterion("salesdesc not between", value1, value2, "salesdesc");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andSaleyearIsNull() {
            addCriterion("saleyear is null");
            return (Criteria) this;
        }

        public Criteria andSaleyearIsNotNull() {
            addCriterion("saleyear is not null");
            return (Criteria) this;
        }

        public Criteria andSaleyearEqualTo(String value) {
            addCriterion("saleyear =", value, "saleyear");
            return (Criteria) this;
        }

        public Criteria andSaleyearNotEqualTo(String value) {
            addCriterion("saleyear <>", value, "saleyear");
            return (Criteria) this;
        }

        public Criteria andSaleyearGreaterThan(String value) {
            addCriterion("saleyear >", value, "saleyear");
            return (Criteria) this;
        }

        public Criteria andSaleyearGreaterThanOrEqualTo(String value) {
            addCriterion("saleyear >=", value, "saleyear");
            return (Criteria) this;
        }

        public Criteria andSaleyearLessThan(String value) {
            addCriterion("saleyear <", value, "saleyear");
            return (Criteria) this;
        }

        public Criteria andSaleyearLessThanOrEqualTo(String value) {
            addCriterion("saleyear <=", value, "saleyear");
            return (Criteria) this;
        }

        public Criteria andSaleyearLike(String value) {
            addCriterion("saleyear like", value, "saleyear");
            return (Criteria) this;
        }

        public Criteria andSaleyearNotLike(String value) {
            addCriterion("saleyear not like", value, "saleyear");
            return (Criteria) this;
        }

        public Criteria andSaleyearIn(List<String> values) {
            addCriterion("saleyear in", values, "saleyear");
            return (Criteria) this;
        }

        public Criteria andSaleyearNotIn(List<String> values) {
            addCriterion("saleyear not in", values, "saleyear");
            return (Criteria) this;
        }

        public Criteria andSaleyearBetween(String value1, String value2) {
            addCriterion("saleyear between", value1, value2, "saleyear");
            return (Criteria) this;
        }

        public Criteria andSaleyearNotBetween(String value1, String value2) {
            addCriterion("saleyear not between", value1, value2, "saleyear");
            return (Criteria) this;
        }

        public Criteria andSalemonthIsNull() {
            addCriterion("salemonth is null");
            return (Criteria) this;
        }

        public Criteria andSalemonthIsNotNull() {
            addCriterion("salemonth is not null");
            return (Criteria) this;
        }

        public Criteria andSalemonthEqualTo(String value) {
            addCriterion("salemonth =", value, "salemonth");
            return (Criteria) this;
        }

        public Criteria andSalemonthNotEqualTo(String value) {
            addCriterion("salemonth <>", value, "salemonth");
            return (Criteria) this;
        }

        public Criteria andSalemonthGreaterThan(String value) {
            addCriterion("salemonth >", value, "salemonth");
            return (Criteria) this;
        }

        public Criteria andSalemonthGreaterThanOrEqualTo(String value) {
            addCriterion("salemonth >=", value, "salemonth");
            return (Criteria) this;
        }

        public Criteria andSalemonthLessThan(String value) {
            addCriterion("salemonth <", value, "salemonth");
            return (Criteria) this;
        }

        public Criteria andSalemonthLessThanOrEqualTo(String value) {
            addCriterion("salemonth <=", value, "salemonth");
            return (Criteria) this;
        }

        public Criteria andSalemonthLike(String value) {
            addCriterion("salemonth like", value, "salemonth");
            return (Criteria) this;
        }

        public Criteria andSalemonthNotLike(String value) {
            addCriterion("salemonth not like", value, "salemonth");
            return (Criteria) this;
        }

        public Criteria andSalemonthIn(List<String> values) {
            addCriterion("salemonth in", values, "salemonth");
            return (Criteria) this;
        }

        public Criteria andSalemonthNotIn(List<String> values) {
            addCriterion("salemonth not in", values, "salemonth");
            return (Criteria) this;
        }

        public Criteria andSalemonthBetween(String value1, String value2) {
            addCriterion("salemonth between", value1, value2, "salemonth");
            return (Criteria) this;
        }

        public Criteria andSalemonthNotBetween(String value1, String value2) {
            addCriterion("salemonth not between", value1, value2, "salemonth");
            return (Criteria) this;
        }

        public Criteria andProduceyearIsNull() {
            addCriterion("produceyear is null");
            return (Criteria) this;
        }

        public Criteria andProduceyearIsNotNull() {
            addCriterion("produceyear is not null");
            return (Criteria) this;
        }

        public Criteria andProduceyearEqualTo(String value) {
            addCriterion("produceyear =", value, "produceyear");
            return (Criteria) this;
        }

        public Criteria andProduceyearNotEqualTo(String value) {
            addCriterion("produceyear <>", value, "produceyear");
            return (Criteria) this;
        }

        public Criteria andProduceyearGreaterThan(String value) {
            addCriterion("produceyear >", value, "produceyear");
            return (Criteria) this;
        }

        public Criteria andProduceyearGreaterThanOrEqualTo(String value) {
            addCriterion("produceyear >=", value, "produceyear");
            return (Criteria) this;
        }

        public Criteria andProduceyearLessThan(String value) {
            addCriterion("produceyear <", value, "produceyear");
            return (Criteria) this;
        }

        public Criteria andProduceyearLessThanOrEqualTo(String value) {
            addCriterion("produceyear <=", value, "produceyear");
            return (Criteria) this;
        }

        public Criteria andProduceyearLike(String value) {
            addCriterion("produceyear like", value, "produceyear");
            return (Criteria) this;
        }

        public Criteria andProduceyearNotLike(String value) {
            addCriterion("produceyear not like", value, "produceyear");
            return (Criteria) this;
        }

        public Criteria andProduceyearIn(List<String> values) {
            addCriterion("produceyear in", values, "produceyear");
            return (Criteria) this;
        }

        public Criteria andProduceyearNotIn(List<String> values) {
            addCriterion("produceyear not in", values, "produceyear");
            return (Criteria) this;
        }

        public Criteria andProduceyearBetween(String value1, String value2) {
            addCriterion("produceyear between", value1, value2, "produceyear");
            return (Criteria) this;
        }

        public Criteria andProduceyearNotBetween(String value1, String value2) {
            addCriterion("produceyear not between", value1, value2, "produceyear");
            return (Criteria) this;
        }

        public Criteria andStopyearIsNull() {
            addCriterion("stopyear is null");
            return (Criteria) this;
        }

        public Criteria andStopyearIsNotNull() {
            addCriterion("stopyear is not null");
            return (Criteria) this;
        }

        public Criteria andStopyearEqualTo(String value) {
            addCriterion("stopyear =", value, "stopyear");
            return (Criteria) this;
        }

        public Criteria andStopyearNotEqualTo(String value) {
            addCriterion("stopyear <>", value, "stopyear");
            return (Criteria) this;
        }

        public Criteria andStopyearGreaterThan(String value) {
            addCriterion("stopyear >", value, "stopyear");
            return (Criteria) this;
        }

        public Criteria andStopyearGreaterThanOrEqualTo(String value) {
            addCriterion("stopyear >=", value, "stopyear");
            return (Criteria) this;
        }

        public Criteria andStopyearLessThan(String value) {
            addCriterion("stopyear <", value, "stopyear");
            return (Criteria) this;
        }

        public Criteria andStopyearLessThanOrEqualTo(String value) {
            addCriterion("stopyear <=", value, "stopyear");
            return (Criteria) this;
        }

        public Criteria andStopyearLike(String value) {
            addCriterion("stopyear like", value, "stopyear");
            return (Criteria) this;
        }

        public Criteria andStopyearNotLike(String value) {
            addCriterion("stopyear not like", value, "stopyear");
            return (Criteria) this;
        }

        public Criteria andStopyearIn(List<String> values) {
            addCriterion("stopyear in", values, "stopyear");
            return (Criteria) this;
        }

        public Criteria andStopyearNotIn(List<String> values) {
            addCriterion("stopyear not in", values, "stopyear");
            return (Criteria) this;
        }

        public Criteria andStopyearBetween(String value1, String value2) {
            addCriterion("stopyear between", value1, value2, "stopyear");
            return (Criteria) this;
        }

        public Criteria andStopyearNotBetween(String value1, String value2) {
            addCriterion("stopyear not between", value1, value2, "stopyear");
            return (Criteria) this;
        }

        public Criteria andProducestatusIsNull() {
            addCriterion("producestatus is null");
            return (Criteria) this;
        }

        public Criteria andProducestatusIsNotNull() {
            addCriterion("producestatus is not null");
            return (Criteria) this;
        }

        public Criteria andProducestatusEqualTo(String value) {
            addCriterion("producestatus =", value, "producestatus");
            return (Criteria) this;
        }

        public Criteria andProducestatusNotEqualTo(String value) {
            addCriterion("producestatus <>", value, "producestatus");
            return (Criteria) this;
        }

        public Criteria andProducestatusGreaterThan(String value) {
            addCriterion("producestatus >", value, "producestatus");
            return (Criteria) this;
        }

        public Criteria andProducestatusGreaterThanOrEqualTo(String value) {
            addCriterion("producestatus >=", value, "producestatus");
            return (Criteria) this;
        }

        public Criteria andProducestatusLessThan(String value) {
            addCriterion("producestatus <", value, "producestatus");
            return (Criteria) this;
        }

        public Criteria andProducestatusLessThanOrEqualTo(String value) {
            addCriterion("producestatus <=", value, "producestatus");
            return (Criteria) this;
        }

        public Criteria andProducestatusLike(String value) {
            addCriterion("producestatus like", value, "producestatus");
            return (Criteria) this;
        }

        public Criteria andProducestatusNotLike(String value) {
            addCriterion("producestatus not like", value, "producestatus");
            return (Criteria) this;
        }

        public Criteria andProducestatusIn(List<String> values) {
            addCriterion("producestatus in", values, "producestatus");
            return (Criteria) this;
        }

        public Criteria andProducestatusNotIn(List<String> values) {
            addCriterion("producestatus not in", values, "producestatus");
            return (Criteria) this;
        }

        public Criteria andProducestatusBetween(String value1, String value2) {
            addCriterion("producestatus between", value1, value2, "producestatus");
            return (Criteria) this;
        }

        public Criteria andProducestatusNotBetween(String value1, String value2) {
            addCriterion("producestatus not between", value1, value2, "producestatus");
            return (Criteria) this;
        }

        public Criteria andBigtypeIsNull() {
            addCriterion("bigtype is null");
            return (Criteria) this;
        }

        public Criteria andBigtypeIsNotNull() {
            addCriterion("bigtype is not null");
            return (Criteria) this;
        }

        public Criteria andBigtypeEqualTo(String value) {
            addCriterion("bigtype =", value, "bigtype");
            return (Criteria) this;
        }

        public Criteria andBigtypeNotEqualTo(String value) {
            addCriterion("bigtype <>", value, "bigtype");
            return (Criteria) this;
        }

        public Criteria andBigtypeGreaterThan(String value) {
            addCriterion("bigtype >", value, "bigtype");
            return (Criteria) this;
        }

        public Criteria andBigtypeGreaterThanOrEqualTo(String value) {
            addCriterion("bigtype >=", value, "bigtype");
            return (Criteria) this;
        }

        public Criteria andBigtypeLessThan(String value) {
            addCriterion("bigtype <", value, "bigtype");
            return (Criteria) this;
        }

        public Criteria andBigtypeLessThanOrEqualTo(String value) {
            addCriterion("bigtype <=", value, "bigtype");
            return (Criteria) this;
        }

        public Criteria andBigtypeLike(String value) {
            addCriterion("bigtype like", value, "bigtype");
            return (Criteria) this;
        }

        public Criteria andBigtypeNotLike(String value) {
            addCriterion("bigtype not like", value, "bigtype");
            return (Criteria) this;
        }

        public Criteria andBigtypeIn(List<String> values) {
            addCriterion("bigtype in", values, "bigtype");
            return (Criteria) this;
        }

        public Criteria andBigtypeNotIn(List<String> values) {
            addCriterion("bigtype not in", values, "bigtype");
            return (Criteria) this;
        }

        public Criteria andBigtypeBetween(String value1, String value2) {
            addCriterion("bigtype between", value1, value2, "bigtype");
            return (Criteria) this;
        }

        public Criteria andBigtypeNotBetween(String value1, String value2) {
            addCriterion("bigtype not between", value1, value2, "bigtype");
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

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNull() {
            addCriterion("property is null");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNotNull() {
            addCriterion("property is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyEqualTo(String value) {
            addCriterion("property =", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotEqualTo(String value) {
            addCriterion("property <>", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThan(String value) {
            addCriterion("property >", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("property >=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThan(String value) {
            addCriterion("property <", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThanOrEqualTo(String value) {
            addCriterion("property <=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLike(String value) {
            addCriterion("property like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotLike(String value) {
            addCriterion("property not like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyIn(List<String> values) {
            addCriterion("property in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotIn(List<String> values) {
            addCriterion("property not in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyBetween(String value1, String value2) {
            addCriterion("property between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotBetween(String value1, String value2) {
            addCriterion("property not between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPetrolIsNull() {
            addCriterion("petrol is null");
            return (Criteria) this;
        }

        public Criteria andPetrolIsNotNull() {
            addCriterion("petrol is not null");
            return (Criteria) this;
        }

        public Criteria andPetrolEqualTo(String value) {
            addCriterion("petrol =", value, "petrol");
            return (Criteria) this;
        }

        public Criteria andPetrolNotEqualTo(String value) {
            addCriterion("petrol <>", value, "petrol");
            return (Criteria) this;
        }

        public Criteria andPetrolGreaterThan(String value) {
            addCriterion("petrol >", value, "petrol");
            return (Criteria) this;
        }

        public Criteria andPetrolGreaterThanOrEqualTo(String value) {
            addCriterion("petrol >=", value, "petrol");
            return (Criteria) this;
        }

        public Criteria andPetrolLessThan(String value) {
            addCriterion("petrol <", value, "petrol");
            return (Criteria) this;
        }

        public Criteria andPetrolLessThanOrEqualTo(String value) {
            addCriterion("petrol <=", value, "petrol");
            return (Criteria) this;
        }

        public Criteria andPetrolLike(String value) {
            addCriterion("petrol like", value, "petrol");
            return (Criteria) this;
        }

        public Criteria andPetrolNotLike(String value) {
            addCriterion("petrol not like", value, "petrol");
            return (Criteria) this;
        }

        public Criteria andPetrolIn(List<String> values) {
            addCriterion("petrol in", values, "petrol");
            return (Criteria) this;
        }

        public Criteria andPetrolNotIn(List<String> values) {
            addCriterion("petrol not in", values, "petrol");
            return (Criteria) this;
        }

        public Criteria andPetrolBetween(String value1, String value2) {
            addCriterion("petrol between", value1, value2, "petrol");
            return (Criteria) this;
        }

        public Criteria andPetrolNotBetween(String value1, String value2) {
            addCriterion("petrol not between", value1, value2, "petrol");
            return (Criteria) this;
        }

        public Criteria andAccelerateIsNull() {
            addCriterion("accelerate is null");
            return (Criteria) this;
        }

        public Criteria andAccelerateIsNotNull() {
            addCriterion("accelerate is not null");
            return (Criteria) this;
        }

        public Criteria andAccelerateEqualTo(Double value) {
            addCriterion("accelerate =", value, "accelerate");
            return (Criteria) this;
        }

        public Criteria andAccelerateNotEqualTo(Double value) {
            addCriterion("accelerate <>", value, "accelerate");
            return (Criteria) this;
        }

        public Criteria andAccelerateGreaterThan(Double value) {
            addCriterion("accelerate >", value, "accelerate");
            return (Criteria) this;
        }

        public Criteria andAccelerateGreaterThanOrEqualTo(Double value) {
            addCriterion("accelerate >=", value, "accelerate");
            return (Criteria) this;
        }

        public Criteria andAccelerateLessThan(Double value) {
            addCriterion("accelerate <", value, "accelerate");
            return (Criteria) this;
        }

        public Criteria andAccelerateLessThanOrEqualTo(Double value) {
            addCriterion("accelerate <=", value, "accelerate");
            return (Criteria) this;
        }

        public Criteria andAccelerateIn(List<Double> values) {
            addCriterion("accelerate in", values, "accelerate");
            return (Criteria) this;
        }

        public Criteria andAccelerateNotIn(List<Double> values) {
            addCriterion("accelerate not in", values, "accelerate");
            return (Criteria) this;
        }

        public Criteria andAccelerateBetween(Double value1, Double value2) {
            addCriterion("accelerate between", value1, value2, "accelerate");
            return (Criteria) this;
        }

        public Criteria andAccelerateNotBetween(Double value1, Double value2) {
            addCriterion("accelerate not between", value1, value2, "accelerate");
            return (Criteria) this;
        }

        public Criteria andMasspeedIsNull() {
            addCriterion("masspeed is null");
            return (Criteria) this;
        }

        public Criteria andMasspeedIsNotNull() {
            addCriterion("masspeed is not null");
            return (Criteria) this;
        }

        public Criteria andMasspeedEqualTo(String value) {
            addCriterion("masspeed =", value, "masspeed");
            return (Criteria) this;
        }

        public Criteria andMasspeedNotEqualTo(String value) {
            addCriterion("masspeed <>", value, "masspeed");
            return (Criteria) this;
        }

        public Criteria andMasspeedGreaterThan(String value) {
            addCriterion("masspeed >", value, "masspeed");
            return (Criteria) this;
        }

        public Criteria andMasspeedGreaterThanOrEqualTo(String value) {
            addCriterion("masspeed >=", value, "masspeed");
            return (Criteria) this;
        }

        public Criteria andMasspeedLessThan(String value) {
            addCriterion("masspeed <", value, "masspeed");
            return (Criteria) this;
        }

        public Criteria andMasspeedLessThanOrEqualTo(String value) {
            addCriterion("masspeed <=", value, "masspeed");
            return (Criteria) this;
        }

        public Criteria andMasspeedLike(String value) {
            addCriterion("masspeed like", value, "masspeed");
            return (Criteria) this;
        }

        public Criteria andMasspeedNotLike(String value) {
            addCriterion("masspeed not like", value, "masspeed");
            return (Criteria) this;
        }

        public Criteria andMasspeedIn(List<String> values) {
            addCriterion("masspeed in", values, "masspeed");
            return (Criteria) this;
        }

        public Criteria andMasspeedNotIn(List<String> values) {
            addCriterion("masspeed not in", values, "masspeed");
            return (Criteria) this;
        }

        public Criteria andMasspeedBetween(String value1, String value2) {
            addCriterion("masspeed between", value1, value2, "masspeed");
            return (Criteria) this;
        }

        public Criteria andMasspeedNotBetween(String value1, String value2) {
            addCriterion("masspeed not between", value1, value2, "masspeed");
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

        public Criteria andStatusEqualTo(Double value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Double value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Double value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Double value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Double value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Double value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Double> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Double> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Double value1, Double value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Double value1, Double value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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