package com.unicdata.entity.carInfo;

import java.util.ArrayList;
import java.util.List;

public class UnicdataVehicleMoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UnicdataVehicleMoreExample() {
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

        public Criteria andCarstructureIsNull() {
            addCriterion("carstructure is null");
            return (Criteria) this;
        }

        public Criteria andCarstructureIsNotNull() {
            addCriterion("carstructure is not null");
            return (Criteria) this;
        }

        public Criteria andCarstructureEqualTo(String value) {
            addCriterion("carstructure =", value, "carstructure");
            return (Criteria) this;
        }

        public Criteria andCarstructureNotEqualTo(String value) {
            addCriterion("carstructure <>", value, "carstructure");
            return (Criteria) this;
        }

        public Criteria andCarstructureGreaterThan(String value) {
            addCriterion("carstructure >", value, "carstructure");
            return (Criteria) this;
        }

        public Criteria andCarstructureGreaterThanOrEqualTo(String value) {
            addCriterion("carstructure >=", value, "carstructure");
            return (Criteria) this;
        }

        public Criteria andCarstructureLessThan(String value) {
            addCriterion("carstructure <", value, "carstructure");
            return (Criteria) this;
        }

        public Criteria andCarstructureLessThanOrEqualTo(String value) {
            addCriterion("carstructure <=", value, "carstructure");
            return (Criteria) this;
        }

        public Criteria andCarstructureLike(String value) {
            addCriterion("carstructure like", value, "carstructure");
            return (Criteria) this;
        }

        public Criteria andCarstructureNotLike(String value) {
            addCriterion("carstructure not like", value, "carstructure");
            return (Criteria) this;
        }

        public Criteria andCarstructureIn(List<String> values) {
            addCriterion("carstructure in", values, "carstructure");
            return (Criteria) this;
        }

        public Criteria andCarstructureNotIn(List<String> values) {
            addCriterion("carstructure not in", values, "carstructure");
            return (Criteria) this;
        }

        public Criteria andCarstructureBetween(String value1, String value2) {
            addCriterion("carstructure between", value1, value2, "carstructure");
            return (Criteria) this;
        }

        public Criteria andCarstructureNotBetween(String value1, String value2) {
            addCriterion("carstructure not between", value1, value2, "carstructure");
            return (Criteria) this;
        }

        public Criteria andLengthIsNull() {
            addCriterion("length is null");
            return (Criteria) this;
        }

        public Criteria andLengthIsNotNull() {
            addCriterion("length is not null");
            return (Criteria) this;
        }

        public Criteria andLengthEqualTo(String value) {
            addCriterion("length =", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotEqualTo(String value) {
            addCriterion("length <>", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThan(String value) {
            addCriterion("length >", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThanOrEqualTo(String value) {
            addCriterion("length >=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThan(String value) {
            addCriterion("length <", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThanOrEqualTo(String value) {
            addCriterion("length <=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLike(String value) {
            addCriterion("length like", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotLike(String value) {
            addCriterion("length not like", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthIn(List<String> values) {
            addCriterion("length in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotIn(List<String> values) {
            addCriterion("length not in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthBetween(String value1, String value2) {
            addCriterion("length between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotBetween(String value1, String value2) {
            addCriterion("length not between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(String value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(String value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(String value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(String value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(String value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(String value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLike(String value) {
            addCriterion("width like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotLike(String value) {
            addCriterion("width not like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<String> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<String> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(String value1, String value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(String value1, String value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(String value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(String value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(String value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(String value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(String value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(String value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLike(String value) {
            addCriterion("height like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotLike(String value) {
            addCriterion("height not like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<String> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<String> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(String value1, String value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(String value1, String value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWheelbaseIsNull() {
            addCriterion("wheelbase is null");
            return (Criteria) this;
        }

        public Criteria andWheelbaseIsNotNull() {
            addCriterion("wheelbase is not null");
            return (Criteria) this;
        }

        public Criteria andWheelbaseEqualTo(String value) {
            addCriterion("wheelbase =", value, "wheelbase");
            return (Criteria) this;
        }

        public Criteria andWheelbaseNotEqualTo(String value) {
            addCriterion("wheelbase <>", value, "wheelbase");
            return (Criteria) this;
        }

        public Criteria andWheelbaseGreaterThan(String value) {
            addCriterion("wheelbase >", value, "wheelbase");
            return (Criteria) this;
        }

        public Criteria andWheelbaseGreaterThanOrEqualTo(String value) {
            addCriterion("wheelbase >=", value, "wheelbase");
            return (Criteria) this;
        }

        public Criteria andWheelbaseLessThan(String value) {
            addCriterion("wheelbase <", value, "wheelbase");
            return (Criteria) this;
        }

        public Criteria andWheelbaseLessThanOrEqualTo(String value) {
            addCriterion("wheelbase <=", value, "wheelbase");
            return (Criteria) this;
        }

        public Criteria andWheelbaseLike(String value) {
            addCriterion("wheelbase like", value, "wheelbase");
            return (Criteria) this;
        }

        public Criteria andWheelbaseNotLike(String value) {
            addCriterion("wheelbase not like", value, "wheelbase");
            return (Criteria) this;
        }

        public Criteria andWheelbaseIn(List<String> values) {
            addCriterion("wheelbase in", values, "wheelbase");
            return (Criteria) this;
        }

        public Criteria andWheelbaseNotIn(List<String> values) {
            addCriterion("wheelbase not in", values, "wheelbase");
            return (Criteria) this;
        }

        public Criteria andWheelbaseBetween(String value1, String value2) {
            addCriterion("wheelbase between", value1, value2, "wheelbase");
            return (Criteria) this;
        }

        public Criteria andWheelbaseNotBetween(String value1, String value2) {
            addCriterion("wheelbase not between", value1, value2, "wheelbase");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeIsNull() {
            addCriterion("frontgauge is null");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeIsNotNull() {
            addCriterion("frontgauge is not null");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeEqualTo(String value) {
            addCriterion("frontgauge =", value, "frontgauge");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeNotEqualTo(String value) {
            addCriterion("frontgauge <>", value, "frontgauge");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeGreaterThan(String value) {
            addCriterion("frontgauge >", value, "frontgauge");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeGreaterThanOrEqualTo(String value) {
            addCriterion("frontgauge >=", value, "frontgauge");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeLessThan(String value) {
            addCriterion("frontgauge <", value, "frontgauge");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeLessThanOrEqualTo(String value) {
            addCriterion("frontgauge <=", value, "frontgauge");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeLike(String value) {
            addCriterion("frontgauge like", value, "frontgauge");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeNotLike(String value) {
            addCriterion("frontgauge not like", value, "frontgauge");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeIn(List<String> values) {
            addCriterion("frontgauge in", values, "frontgauge");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeNotIn(List<String> values) {
            addCriterion("frontgauge not in", values, "frontgauge");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeBetween(String value1, String value2) {
            addCriterion("frontgauge between", value1, value2, "frontgauge");
            return (Criteria) this;
        }

        public Criteria andFrontgaugeNotBetween(String value1, String value2) {
            addCriterion("frontgauge not between", value1, value2, "frontgauge");
            return (Criteria) this;
        }

        public Criteria andBackgaugeIsNull() {
            addCriterion("backgauge is null");
            return (Criteria) this;
        }

        public Criteria andBackgaugeIsNotNull() {
            addCriterion("backgauge is not null");
            return (Criteria) this;
        }

        public Criteria andBackgaugeEqualTo(String value) {
            addCriterion("backgauge =", value, "backgauge");
            return (Criteria) this;
        }

        public Criteria andBackgaugeNotEqualTo(String value) {
            addCriterion("backgauge <>", value, "backgauge");
            return (Criteria) this;
        }

        public Criteria andBackgaugeGreaterThan(String value) {
            addCriterion("backgauge >", value, "backgauge");
            return (Criteria) this;
        }

        public Criteria andBackgaugeGreaterThanOrEqualTo(String value) {
            addCriterion("backgauge >=", value, "backgauge");
            return (Criteria) this;
        }

        public Criteria andBackgaugeLessThan(String value) {
            addCriterion("backgauge <", value, "backgauge");
            return (Criteria) this;
        }

        public Criteria andBackgaugeLessThanOrEqualTo(String value) {
            addCriterion("backgauge <=", value, "backgauge");
            return (Criteria) this;
        }

        public Criteria andBackgaugeLike(String value) {
            addCriterion("backgauge like", value, "backgauge");
            return (Criteria) this;
        }

        public Criteria andBackgaugeNotLike(String value) {
            addCriterion("backgauge not like", value, "backgauge");
            return (Criteria) this;
        }

        public Criteria andBackgaugeIn(List<String> values) {
            addCriterion("backgauge in", values, "backgauge");
            return (Criteria) this;
        }

        public Criteria andBackgaugeNotIn(List<String> values) {
            addCriterion("backgauge not in", values, "backgauge");
            return (Criteria) this;
        }

        public Criteria andBackgaugeBetween(String value1, String value2) {
            addCriterion("backgauge between", value1, value2, "backgauge");
            return (Criteria) this;
        }

        public Criteria andBackgaugeNotBetween(String value1, String value2) {
            addCriterion("backgauge not between", value1, value2, "backgauge");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(String value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(String value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(String value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(String value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(String value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(String value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLike(String value) {
            addCriterion("weight like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotLike(String value) {
            addCriterion("weight not like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<String> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<String> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(String value1, String value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(String value1, String value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andMaxloadIsNull() {
            addCriterion("maxload is null");
            return (Criteria) this;
        }

        public Criteria andMaxloadIsNotNull() {
            addCriterion("maxload is not null");
            return (Criteria) this;
        }

        public Criteria andMaxloadEqualTo(String value) {
            addCriterion("maxload =", value, "maxload");
            return (Criteria) this;
        }

        public Criteria andMaxloadNotEqualTo(String value) {
            addCriterion("maxload <>", value, "maxload");
            return (Criteria) this;
        }

        public Criteria andMaxloadGreaterThan(String value) {
            addCriterion("maxload >", value, "maxload");
            return (Criteria) this;
        }

        public Criteria andMaxloadGreaterThanOrEqualTo(String value) {
            addCriterion("maxload >=", value, "maxload");
            return (Criteria) this;
        }

        public Criteria andMaxloadLessThan(String value) {
            addCriterion("maxload <", value, "maxload");
            return (Criteria) this;
        }

        public Criteria andMaxloadLessThanOrEqualTo(String value) {
            addCriterion("maxload <=", value, "maxload");
            return (Criteria) this;
        }

        public Criteria andMaxloadLike(String value) {
            addCriterion("maxload like", value, "maxload");
            return (Criteria) this;
        }

        public Criteria andMaxloadNotLike(String value) {
            addCriterion("maxload not like", value, "maxload");
            return (Criteria) this;
        }

        public Criteria andMaxloadIn(List<String> values) {
            addCriterion("maxload in", values, "maxload");
            return (Criteria) this;
        }

        public Criteria andMaxloadNotIn(List<String> values) {
            addCriterion("maxload not in", values, "maxload");
            return (Criteria) this;
        }

        public Criteria andMaxloadBetween(String value1, String value2) {
            addCriterion("maxload between", value1, value2, "maxload");
            return (Criteria) this;
        }

        public Criteria andMaxloadNotBetween(String value1, String value2) {
            addCriterion("maxload not between", value1, value2, "maxload");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnIsNull() {
            addCriterion("fuelvolumn is null");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnIsNotNull() {
            addCriterion("fuelvolumn is not null");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnEqualTo(String value) {
            addCriterion("fuelvolumn =", value, "fuelvolumn");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnNotEqualTo(String value) {
            addCriterion("fuelvolumn <>", value, "fuelvolumn");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnGreaterThan(String value) {
            addCriterion("fuelvolumn >", value, "fuelvolumn");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnGreaterThanOrEqualTo(String value) {
            addCriterion("fuelvolumn >=", value, "fuelvolumn");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnLessThan(String value) {
            addCriterion("fuelvolumn <", value, "fuelvolumn");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnLessThanOrEqualTo(String value) {
            addCriterion("fuelvolumn <=", value, "fuelvolumn");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnLike(String value) {
            addCriterion("fuelvolumn like", value, "fuelvolumn");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnNotLike(String value) {
            addCriterion("fuelvolumn not like", value, "fuelvolumn");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnIn(List<String> values) {
            addCriterion("fuelvolumn in", values, "fuelvolumn");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnNotIn(List<String> values) {
            addCriterion("fuelvolumn not in", values, "fuelvolumn");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnBetween(String value1, String value2) {
            addCriterion("fuelvolumn between", value1, value2, "fuelvolumn");
            return (Criteria) this;
        }

        public Criteria andFuelvolumnNotBetween(String value1, String value2) {
            addCriterion("fuelvolumn not between", value1, value2, "fuelvolumn");
            return (Criteria) this;
        }

        public Criteria andBaggageIsNull() {
            addCriterion("baggage is null");
            return (Criteria) this;
        }

        public Criteria andBaggageIsNotNull() {
            addCriterion("baggage is not null");
            return (Criteria) this;
        }

        public Criteria andBaggageEqualTo(String value) {
            addCriterion("baggage =", value, "baggage");
            return (Criteria) this;
        }

        public Criteria andBaggageNotEqualTo(String value) {
            addCriterion("baggage <>", value, "baggage");
            return (Criteria) this;
        }

        public Criteria andBaggageGreaterThan(String value) {
            addCriterion("baggage >", value, "baggage");
            return (Criteria) this;
        }

        public Criteria andBaggageGreaterThanOrEqualTo(String value) {
            addCriterion("baggage >=", value, "baggage");
            return (Criteria) this;
        }

        public Criteria andBaggageLessThan(String value) {
            addCriterion("baggage <", value, "baggage");
            return (Criteria) this;
        }

        public Criteria andBaggageLessThanOrEqualTo(String value) {
            addCriterion("baggage <=", value, "baggage");
            return (Criteria) this;
        }

        public Criteria andBaggageLike(String value) {
            addCriterion("baggage like", value, "baggage");
            return (Criteria) this;
        }

        public Criteria andBaggageNotLike(String value) {
            addCriterion("baggage not like", value, "baggage");
            return (Criteria) this;
        }

        public Criteria andBaggageIn(List<String> values) {
            addCriterion("baggage in", values, "baggage");
            return (Criteria) this;
        }

        public Criteria andBaggageNotIn(List<String> values) {
            addCriterion("baggage not in", values, "baggage");
            return (Criteria) this;
        }

        public Criteria andBaggageBetween(String value1, String value2) {
            addCriterion("baggage between", value1, value2, "baggage");
            return (Criteria) this;
        }

        public Criteria andBaggageNotBetween(String value1, String value2) {
            addCriterion("baggage not between", value1, value2, "baggage");
            return (Criteria) this;
        }

        public Criteria andDoorsIsNull() {
            addCriterion("doors is null");
            return (Criteria) this;
        }

        public Criteria andDoorsIsNotNull() {
            addCriterion("doors is not null");
            return (Criteria) this;
        }

        public Criteria andDoorsEqualTo(String value) {
            addCriterion("doors =", value, "doors");
            return (Criteria) this;
        }

        public Criteria andDoorsNotEqualTo(String value) {
            addCriterion("doors <>", value, "doors");
            return (Criteria) this;
        }

        public Criteria andDoorsGreaterThan(String value) {
            addCriterion("doors >", value, "doors");
            return (Criteria) this;
        }

        public Criteria andDoorsGreaterThanOrEqualTo(String value) {
            addCriterion("doors >=", value, "doors");
            return (Criteria) this;
        }

        public Criteria andDoorsLessThan(String value) {
            addCriterion("doors <", value, "doors");
            return (Criteria) this;
        }

        public Criteria andDoorsLessThanOrEqualTo(String value) {
            addCriterion("doors <=", value, "doors");
            return (Criteria) this;
        }

        public Criteria andDoorsLike(String value) {
            addCriterion("doors like", value, "doors");
            return (Criteria) this;
        }

        public Criteria andDoorsNotLike(String value) {
            addCriterion("doors not like", value, "doors");
            return (Criteria) this;
        }

        public Criteria andDoorsIn(List<String> values) {
            addCriterion("doors in", values, "doors");
            return (Criteria) this;
        }

        public Criteria andDoorsNotIn(List<String> values) {
            addCriterion("doors not in", values, "doors");
            return (Criteria) this;
        }

        public Criteria andDoorsBetween(String value1, String value2) {
            addCriterion("doors between", value1, value2, "doors");
            return (Criteria) this;
        }

        public Criteria andDoorsNotBetween(String value1, String value2) {
            addCriterion("doors not between", value1, value2, "doors");
            return (Criteria) this;
        }

        public Criteria andSeatsIsNull() {
            addCriterion("seats is null");
            return (Criteria) this;
        }

        public Criteria andSeatsIsNotNull() {
            addCriterion("seats is not null");
            return (Criteria) this;
        }

        public Criteria andSeatsEqualTo(String value) {
            addCriterion("seats =", value, "seats");
            return (Criteria) this;
        }

        public Criteria andSeatsNotEqualTo(String value) {
            addCriterion("seats <>", value, "seats");
            return (Criteria) this;
        }

        public Criteria andSeatsGreaterThan(String value) {
            addCriterion("seats >", value, "seats");
            return (Criteria) this;
        }

        public Criteria andSeatsGreaterThanOrEqualTo(String value) {
            addCriterion("seats >=", value, "seats");
            return (Criteria) this;
        }

        public Criteria andSeatsLessThan(String value) {
            addCriterion("seats <", value, "seats");
            return (Criteria) this;
        }

        public Criteria andSeatsLessThanOrEqualTo(String value) {
            addCriterion("seats <=", value, "seats");
            return (Criteria) this;
        }

        public Criteria andSeatsLike(String value) {
            addCriterion("seats like", value, "seats");
            return (Criteria) this;
        }

        public Criteria andSeatsNotLike(String value) {
            addCriterion("seats not like", value, "seats");
            return (Criteria) this;
        }

        public Criteria andSeatsIn(List<String> values) {
            addCriterion("seats in", values, "seats");
            return (Criteria) this;
        }

        public Criteria andSeatsNotIn(List<String> values) {
            addCriterion("seats not in", values, "seats");
            return (Criteria) this;
        }

        public Criteria andSeatsBetween(String value1, String value2) {
            addCriterion("seats between", value1, value2, "seats");
            return (Criteria) this;
        }

        public Criteria andSeatsNotBetween(String value1, String value2) {
            addCriterion("seats not between", value1, value2, "seats");
            return (Criteria) this;
        }

        public Criteria andEmissionIsNull() {
            addCriterion("emission is null");
            return (Criteria) this;
        }

        public Criteria andEmissionIsNotNull() {
            addCriterion("emission is not null");
            return (Criteria) this;
        }

        public Criteria andEmissionEqualTo(String value) {
            addCriterion("emission =", value, "emission");
            return (Criteria) this;
        }

        public Criteria andEmissionNotEqualTo(String value) {
            addCriterion("emission <>", value, "emission");
            return (Criteria) this;
        }

        public Criteria andEmissionGreaterThan(String value) {
            addCriterion("emission >", value, "emission");
            return (Criteria) this;
        }

        public Criteria andEmissionGreaterThanOrEqualTo(String value) {
            addCriterion("emission >=", value, "emission");
            return (Criteria) this;
        }

        public Criteria andEmissionLessThan(String value) {
            addCriterion("emission <", value, "emission");
            return (Criteria) this;
        }

        public Criteria andEmissionLessThanOrEqualTo(String value) {
            addCriterion("emission <=", value, "emission");
            return (Criteria) this;
        }

        public Criteria andEmissionLike(String value) {
            addCriterion("emission like", value, "emission");
            return (Criteria) this;
        }

        public Criteria andEmissionNotLike(String value) {
            addCriterion("emission not like", value, "emission");
            return (Criteria) this;
        }

        public Criteria andEmissionIn(List<String> values) {
            addCriterion("emission in", values, "emission");
            return (Criteria) this;
        }

        public Criteria andEmissionNotIn(List<String> values) {
            addCriterion("emission not in", values, "emission");
            return (Criteria) this;
        }

        public Criteria andEmissionBetween(String value1, String value2) {
            addCriterion("emission between", value1, value2, "emission");
            return (Criteria) this;
        }

        public Criteria andEmissionNotBetween(String value1, String value2) {
            addCriterion("emission not between", value1, value2, "emission");
            return (Criteria) this;
        }

        public Criteria andCylinderIsNull() {
            addCriterion("cylinder is null");
            return (Criteria) this;
        }

        public Criteria andCylinderIsNotNull() {
            addCriterion("cylinder is not null");
            return (Criteria) this;
        }

        public Criteria andCylinderEqualTo(String value) {
            addCriterion("cylinder =", value, "cylinder");
            return (Criteria) this;
        }

        public Criteria andCylinderNotEqualTo(String value) {
            addCriterion("cylinder <>", value, "cylinder");
            return (Criteria) this;
        }

        public Criteria andCylinderGreaterThan(String value) {
            addCriterion("cylinder >", value, "cylinder");
            return (Criteria) this;
        }

        public Criteria andCylinderGreaterThanOrEqualTo(String value) {
            addCriterion("cylinder >=", value, "cylinder");
            return (Criteria) this;
        }

        public Criteria andCylinderLessThan(String value) {
            addCriterion("cylinder <", value, "cylinder");
            return (Criteria) this;
        }

        public Criteria andCylinderLessThanOrEqualTo(String value) {
            addCriterion("cylinder <=", value, "cylinder");
            return (Criteria) this;
        }

        public Criteria andCylinderLike(String value) {
            addCriterion("cylinder like", value, "cylinder");
            return (Criteria) this;
        }

        public Criteria andCylinderNotLike(String value) {
            addCriterion("cylinder not like", value, "cylinder");
            return (Criteria) this;
        }

        public Criteria andCylinderIn(List<String> values) {
            addCriterion("cylinder in", values, "cylinder");
            return (Criteria) this;
        }

        public Criteria andCylinderNotIn(List<String> values) {
            addCriterion("cylinder not in", values, "cylinder");
            return (Criteria) this;
        }

        public Criteria andCylinderBetween(String value1, String value2) {
            addCriterion("cylinder between", value1, value2, "cylinder");
            return (Criteria) this;
        }

        public Criteria andCylinderNotBetween(String value1, String value2) {
            addCriterion("cylinder not between", value1, value2, "cylinder");
            return (Criteria) this;
        }

        public Criteria andFueltypeIsNull() {
            addCriterion("fueltype is null");
            return (Criteria) this;
        }

        public Criteria andFueltypeIsNotNull() {
            addCriterion("fueltype is not null");
            return (Criteria) this;
        }

        public Criteria andFueltypeEqualTo(String value) {
            addCriterion("fueltype =", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeNotEqualTo(String value) {
            addCriterion("fueltype <>", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeGreaterThan(String value) {
            addCriterion("fueltype >", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeGreaterThanOrEqualTo(String value) {
            addCriterion("fueltype >=", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeLessThan(String value) {
            addCriterion("fueltype <", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeLessThanOrEqualTo(String value) {
            addCriterion("fueltype <=", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeLike(String value) {
            addCriterion("fueltype like", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeNotLike(String value) {
            addCriterion("fueltype not like", value, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeIn(List<String> values) {
            addCriterion("fueltype in", values, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeNotIn(List<String> values) {
            addCriterion("fueltype not in", values, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeBetween(String value1, String value2) {
            addCriterion("fueltype between", value1, value2, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFueltypeNotBetween(String value1, String value2) {
            addCriterion("fueltype not between", value1, value2, "fueltype");
            return (Criteria) this;
        }

        public Criteria andFuelnumberIsNull() {
            addCriterion("fuelnumber is null");
            return (Criteria) this;
        }

        public Criteria andFuelnumberIsNotNull() {
            addCriterion("fuelnumber is not null");
            return (Criteria) this;
        }

        public Criteria andFuelnumberEqualTo(String value) {
            addCriterion("fuelnumber =", value, "fuelnumber");
            return (Criteria) this;
        }

        public Criteria andFuelnumberNotEqualTo(String value) {
            addCriterion("fuelnumber <>", value, "fuelnumber");
            return (Criteria) this;
        }

        public Criteria andFuelnumberGreaterThan(String value) {
            addCriterion("fuelnumber >", value, "fuelnumber");
            return (Criteria) this;
        }

        public Criteria andFuelnumberGreaterThanOrEqualTo(String value) {
            addCriterion("fuelnumber >=", value, "fuelnumber");
            return (Criteria) this;
        }

        public Criteria andFuelnumberLessThan(String value) {
            addCriterion("fuelnumber <", value, "fuelnumber");
            return (Criteria) this;
        }

        public Criteria andFuelnumberLessThanOrEqualTo(String value) {
            addCriterion("fuelnumber <=", value, "fuelnumber");
            return (Criteria) this;
        }

        public Criteria andFuelnumberLike(String value) {
            addCriterion("fuelnumber like", value, "fuelnumber");
            return (Criteria) this;
        }

        public Criteria andFuelnumberNotLike(String value) {
            addCriterion("fuelnumber not like", value, "fuelnumber");
            return (Criteria) this;
        }

        public Criteria andFuelnumberIn(List<String> values) {
            addCriterion("fuelnumber in", values, "fuelnumber");
            return (Criteria) this;
        }

        public Criteria andFuelnumberNotIn(List<String> values) {
            addCriterion("fuelnumber not in", values, "fuelnumber");
            return (Criteria) this;
        }

        public Criteria andFuelnumberBetween(String value1, String value2) {
            addCriterion("fuelnumber between", value1, value2, "fuelnumber");
            return (Criteria) this;
        }

        public Criteria andFuelnumberNotBetween(String value1, String value2) {
            addCriterion("fuelnumber not between", value1, value2, "fuelnumber");
            return (Criteria) this;
        }

        public Criteria andLwvIsNull() {
            addCriterion("lwv is null");
            return (Criteria) this;
        }

        public Criteria andLwvIsNotNull() {
            addCriterion("lwv is not null");
            return (Criteria) this;
        }

        public Criteria andLwvEqualTo(String value) {
            addCriterion("lwv =", value, "lwv");
            return (Criteria) this;
        }

        public Criteria andLwvNotEqualTo(String value) {
            addCriterion("lwv <>", value, "lwv");
            return (Criteria) this;
        }

        public Criteria andLwvGreaterThan(String value) {
            addCriterion("lwv >", value, "lwv");
            return (Criteria) this;
        }

        public Criteria andLwvGreaterThanOrEqualTo(String value) {
            addCriterion("lwv >=", value, "lwv");
            return (Criteria) this;
        }

        public Criteria andLwvLessThan(String value) {
            addCriterion("lwv <", value, "lwv");
            return (Criteria) this;
        }

        public Criteria andLwvLessThanOrEqualTo(String value) {
            addCriterion("lwv <=", value, "lwv");
            return (Criteria) this;
        }

        public Criteria andLwvLike(String value) {
            addCriterion("lwv like", value, "lwv");
            return (Criteria) this;
        }

        public Criteria andLwvNotLike(String value) {
            addCriterion("lwv not like", value, "lwv");
            return (Criteria) this;
        }

        public Criteria andLwvIn(List<String> values) {
            addCriterion("lwv in", values, "lwv");
            return (Criteria) this;
        }

        public Criteria andLwvNotIn(List<String> values) {
            addCriterion("lwv not in", values, "lwv");
            return (Criteria) this;
        }

        public Criteria andLwvBetween(String value1, String value2) {
            addCriterion("lwv between", value1, value2, "lwv");
            return (Criteria) this;
        }

        public Criteria andLwvNotBetween(String value1, String value2) {
            addCriterion("lwv not between", value1, value2, "lwv");
            return (Criteria) this;
        }

        public Criteria andLwvnumberIsNull() {
            addCriterion("lwvnumber is null");
            return (Criteria) this;
        }

        public Criteria andLwvnumberIsNotNull() {
            addCriterion("lwvnumber is not null");
            return (Criteria) this;
        }

        public Criteria andLwvnumberEqualTo(String value) {
            addCriterion("lwvnumber =", value, "lwvnumber");
            return (Criteria) this;
        }

        public Criteria andLwvnumberNotEqualTo(String value) {
            addCriterion("lwvnumber <>", value, "lwvnumber");
            return (Criteria) this;
        }

        public Criteria andLwvnumberGreaterThan(String value) {
            addCriterion("lwvnumber >", value, "lwvnumber");
            return (Criteria) this;
        }

        public Criteria andLwvnumberGreaterThanOrEqualTo(String value) {
            addCriterion("lwvnumber >=", value, "lwvnumber");
            return (Criteria) this;
        }

        public Criteria andLwvnumberLessThan(String value) {
            addCriterion("lwvnumber <", value, "lwvnumber");
            return (Criteria) this;
        }

        public Criteria andLwvnumberLessThanOrEqualTo(String value) {
            addCriterion("lwvnumber <=", value, "lwvnumber");
            return (Criteria) this;
        }

        public Criteria andLwvnumberLike(String value) {
            addCriterion("lwvnumber like", value, "lwvnumber");
            return (Criteria) this;
        }

        public Criteria andLwvnumberNotLike(String value) {
            addCriterion("lwvnumber not like", value, "lwvnumber");
            return (Criteria) this;
        }

        public Criteria andLwvnumberIn(List<String> values) {
            addCriterion("lwvnumber in", values, "lwvnumber");
            return (Criteria) this;
        }

        public Criteria andLwvnumberNotIn(List<String> values) {
            addCriterion("lwvnumber not in", values, "lwvnumber");
            return (Criteria) this;
        }

        public Criteria andLwvnumberBetween(String value1, String value2) {
            addCriterion("lwvnumber between", value1, value2, "lwvnumber");
            return (Criteria) this;
        }

        public Criteria andLwvnumberNotBetween(String value1, String value2) {
            addCriterion("lwvnumber not between", value1, value2, "lwvnumber");
            return (Criteria) this;
        }

        public Criteria andValveIsNull() {
            addCriterion("valve is null");
            return (Criteria) this;
        }

        public Criteria andValveIsNotNull() {
            addCriterion("valve is not null");
            return (Criteria) this;
        }

        public Criteria andValveEqualTo(String value) {
            addCriterion("valve =", value, "valve");
            return (Criteria) this;
        }

        public Criteria andValveNotEqualTo(String value) {
            addCriterion("valve <>", value, "valve");
            return (Criteria) this;
        }

        public Criteria andValveGreaterThan(String value) {
            addCriterion("valve >", value, "valve");
            return (Criteria) this;
        }

        public Criteria andValveGreaterThanOrEqualTo(String value) {
            addCriterion("valve >=", value, "valve");
            return (Criteria) this;
        }

        public Criteria andValveLessThan(String value) {
            addCriterion("valve <", value, "valve");
            return (Criteria) this;
        }

        public Criteria andValveLessThanOrEqualTo(String value) {
            addCriterion("valve <=", value, "valve");
            return (Criteria) this;
        }

        public Criteria andValveLike(String value) {
            addCriterion("valve like", value, "valve");
            return (Criteria) this;
        }

        public Criteria andValveNotLike(String value) {
            addCriterion("valve not like", value, "valve");
            return (Criteria) this;
        }

        public Criteria andValveIn(List<String> values) {
            addCriterion("valve in", values, "valve");
            return (Criteria) this;
        }

        public Criteria andValveNotIn(List<String> values) {
            addCriterion("valve not in", values, "valve");
            return (Criteria) this;
        }

        public Criteria andValveBetween(String value1, String value2) {
            addCriterion("valve between", value1, value2, "valve");
            return (Criteria) this;
        }

        public Criteria andValveNotBetween(String value1, String value2) {
            addCriterion("valve not between", value1, value2, "valve");
            return (Criteria) this;
        }

        public Criteria andCompressIsNull() {
            addCriterion("compress is null");
            return (Criteria) this;
        }

        public Criteria andCompressIsNotNull() {
            addCriterion("compress is not null");
            return (Criteria) this;
        }

        public Criteria andCompressEqualTo(Double value) {
            addCriterion("compress =", value, "compress");
            return (Criteria) this;
        }

        public Criteria andCompressNotEqualTo(Double value) {
            addCriterion("compress <>", value, "compress");
            return (Criteria) this;
        }

        public Criteria andCompressGreaterThan(Double value) {
            addCriterion("compress >", value, "compress");
            return (Criteria) this;
        }

        public Criteria andCompressGreaterThanOrEqualTo(Double value) {
            addCriterion("compress >=", value, "compress");
            return (Criteria) this;
        }

        public Criteria andCompressLessThan(Double value) {
            addCriterion("compress <", value, "compress");
            return (Criteria) this;
        }

        public Criteria andCompressLessThanOrEqualTo(Double value) {
            addCriterion("compress <=", value, "compress");
            return (Criteria) this;
        }

        public Criteria andCompressIn(List<Double> values) {
            addCriterion("compress in", values, "compress");
            return (Criteria) this;
        }

        public Criteria andCompressNotIn(List<Double> values) {
            addCriterion("compress not in", values, "compress");
            return (Criteria) this;
        }

        public Criteria andCompressBetween(Double value1, Double value2) {
            addCriterion("compress between", value1, value2, "compress");
            return (Criteria) this;
        }

        public Criteria andCompressNotBetween(Double value1, Double value2) {
            addCriterion("compress not between", value1, value2, "compress");
            return (Criteria) this;
        }

        public Criteria andFuelmethodIsNull() {
            addCriterion("fuelmethod is null");
            return (Criteria) this;
        }

        public Criteria andFuelmethodIsNotNull() {
            addCriterion("fuelmethod is not null");
            return (Criteria) this;
        }

        public Criteria andFuelmethodEqualTo(String value) {
            addCriterion("fuelmethod =", value, "fuelmethod");
            return (Criteria) this;
        }

        public Criteria andFuelmethodNotEqualTo(String value) {
            addCriterion("fuelmethod <>", value, "fuelmethod");
            return (Criteria) this;
        }

        public Criteria andFuelmethodGreaterThan(String value) {
            addCriterion("fuelmethod >", value, "fuelmethod");
            return (Criteria) this;
        }

        public Criteria andFuelmethodGreaterThanOrEqualTo(String value) {
            addCriterion("fuelmethod >=", value, "fuelmethod");
            return (Criteria) this;
        }

        public Criteria andFuelmethodLessThan(String value) {
            addCriterion("fuelmethod <", value, "fuelmethod");
            return (Criteria) this;
        }

        public Criteria andFuelmethodLessThanOrEqualTo(String value) {
            addCriterion("fuelmethod <=", value, "fuelmethod");
            return (Criteria) this;
        }

        public Criteria andFuelmethodLike(String value) {
            addCriterion("fuelmethod like", value, "fuelmethod");
            return (Criteria) this;
        }

        public Criteria andFuelmethodNotLike(String value) {
            addCriterion("fuelmethod not like", value, "fuelmethod");
            return (Criteria) this;
        }

        public Criteria andFuelmethodIn(List<String> values) {
            addCriterion("fuelmethod in", values, "fuelmethod");
            return (Criteria) this;
        }

        public Criteria andFuelmethodNotIn(List<String> values) {
            addCriterion("fuelmethod not in", values, "fuelmethod");
            return (Criteria) this;
        }

        public Criteria andFuelmethodBetween(String value1, String value2) {
            addCriterion("fuelmethod between", value1, value2, "fuelmethod");
            return (Criteria) this;
        }

        public Criteria andFuelmethodNotBetween(String value1, String value2) {
            addCriterion("fuelmethod not between", value1, value2, "fuelmethod");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMaxpowerIsNull() {
            addCriterion("maxpower is null");
            return (Criteria) this;
        }

        public Criteria andMaxpowerIsNotNull() {
            addCriterion("maxpower is not null");
            return (Criteria) this;
        }

        public Criteria andMaxpowerEqualTo(String value) {
            addCriterion("maxpower =", value, "maxpower");
            return (Criteria) this;
        }

        public Criteria andMaxpowerNotEqualTo(String value) {
            addCriterion("maxpower <>", value, "maxpower");
            return (Criteria) this;
        }

        public Criteria andMaxpowerGreaterThan(String value) {
            addCriterion("maxpower >", value, "maxpower");
            return (Criteria) this;
        }

        public Criteria andMaxpowerGreaterThanOrEqualTo(String value) {
            addCriterion("maxpower >=", value, "maxpower");
            return (Criteria) this;
        }

        public Criteria andMaxpowerLessThan(String value) {
            addCriterion("maxpower <", value, "maxpower");
            return (Criteria) this;
        }

        public Criteria andMaxpowerLessThanOrEqualTo(String value) {
            addCriterion("maxpower <=", value, "maxpower");
            return (Criteria) this;
        }

        public Criteria andMaxpowerLike(String value) {
            addCriterion("maxpower like", value, "maxpower");
            return (Criteria) this;
        }

        public Criteria andMaxpowerNotLike(String value) {
            addCriterion("maxpower not like", value, "maxpower");
            return (Criteria) this;
        }

        public Criteria andMaxpowerIn(List<String> values) {
            addCriterion("maxpower in", values, "maxpower");
            return (Criteria) this;
        }

        public Criteria andMaxpowerNotIn(List<String> values) {
            addCriterion("maxpower not in", values, "maxpower");
            return (Criteria) this;
        }

        public Criteria andMaxpowerBetween(String value1, String value2) {
            addCriterion("maxpower between", value1, value2, "maxpower");
            return (Criteria) this;
        }

        public Criteria andMaxpowerNotBetween(String value1, String value2) {
            addCriterion("maxpower not between", value1, value2, "maxpower");
            return (Criteria) this;
        }

        public Criteria andMaxrpmIsNull() {
            addCriterion("maxrpm is null");
            return (Criteria) this;
        }

        public Criteria andMaxrpmIsNotNull() {
            addCriterion("maxrpm is not null");
            return (Criteria) this;
        }

        public Criteria andMaxrpmEqualTo(String value) {
            addCriterion("maxrpm =", value, "maxrpm");
            return (Criteria) this;
        }

        public Criteria andMaxrpmNotEqualTo(String value) {
            addCriterion("maxrpm <>", value, "maxrpm");
            return (Criteria) this;
        }

        public Criteria andMaxrpmGreaterThan(String value) {
            addCriterion("maxrpm >", value, "maxrpm");
            return (Criteria) this;
        }

        public Criteria andMaxrpmGreaterThanOrEqualTo(String value) {
            addCriterion("maxrpm >=", value, "maxrpm");
            return (Criteria) this;
        }

        public Criteria andMaxrpmLessThan(String value) {
            addCriterion("maxrpm <", value, "maxrpm");
            return (Criteria) this;
        }

        public Criteria andMaxrpmLessThanOrEqualTo(String value) {
            addCriterion("maxrpm <=", value, "maxrpm");
            return (Criteria) this;
        }

        public Criteria andMaxrpmLike(String value) {
            addCriterion("maxrpm like", value, "maxrpm");
            return (Criteria) this;
        }

        public Criteria andMaxrpmNotLike(String value) {
            addCriterion("maxrpm not like", value, "maxrpm");
            return (Criteria) this;
        }

        public Criteria andMaxrpmIn(List<String> values) {
            addCriterion("maxrpm in", values, "maxrpm");
            return (Criteria) this;
        }

        public Criteria andMaxrpmNotIn(List<String> values) {
            addCriterion("maxrpm not in", values, "maxrpm");
            return (Criteria) this;
        }

        public Criteria andMaxrpmBetween(String value1, String value2) {
            addCriterion("maxrpm between", value1, value2, "maxrpm");
            return (Criteria) this;
        }

        public Criteria andMaxrpmNotBetween(String value1, String value2) {
            addCriterion("maxrpm not between", value1, value2, "maxrpm");
            return (Criteria) this;
        }

        public Criteria andMaxnmIsNull() {
            addCriterion("maxnm is null");
            return (Criteria) this;
        }

        public Criteria andMaxnmIsNotNull() {
            addCriterion("maxnm is not null");
            return (Criteria) this;
        }

        public Criteria andMaxnmEqualTo(String value) {
            addCriterion("maxnm =", value, "maxnm");
            return (Criteria) this;
        }

        public Criteria andMaxnmNotEqualTo(String value) {
            addCriterion("maxnm <>", value, "maxnm");
            return (Criteria) this;
        }

        public Criteria andMaxnmGreaterThan(String value) {
            addCriterion("maxnm >", value, "maxnm");
            return (Criteria) this;
        }

        public Criteria andMaxnmGreaterThanOrEqualTo(String value) {
            addCriterion("maxnm >=", value, "maxnm");
            return (Criteria) this;
        }

        public Criteria andMaxnmLessThan(String value) {
            addCriterion("maxnm <", value, "maxnm");
            return (Criteria) this;
        }

        public Criteria andMaxnmLessThanOrEqualTo(String value) {
            addCriterion("maxnm <=", value, "maxnm");
            return (Criteria) this;
        }

        public Criteria andMaxnmLike(String value) {
            addCriterion("maxnm like", value, "maxnm");
            return (Criteria) this;
        }

        public Criteria andMaxnmNotLike(String value) {
            addCriterion("maxnm not like", value, "maxnm");
            return (Criteria) this;
        }

        public Criteria andMaxnmIn(List<String> values) {
            addCriterion("maxnm in", values, "maxnm");
            return (Criteria) this;
        }

        public Criteria andMaxnmNotIn(List<String> values) {
            addCriterion("maxnm not in", values, "maxnm");
            return (Criteria) this;
        }

        public Criteria andMaxnmBetween(String value1, String value2) {
            addCriterion("maxnm between", value1, value2, "maxnm");
            return (Criteria) this;
        }

        public Criteria andMaxnmNotBetween(String value1, String value2) {
            addCriterion("maxnm not between", value1, value2, "maxnm");
            return (Criteria) this;
        }

        public Criteria andMaxpsIsNull() {
            addCriterion("maxps is null");
            return (Criteria) this;
        }

        public Criteria andMaxpsIsNotNull() {
            addCriterion("maxps is not null");
            return (Criteria) this;
        }

        public Criteria andMaxpsEqualTo(String value) {
            addCriterion("maxps =", value, "maxps");
            return (Criteria) this;
        }

        public Criteria andMaxpsNotEqualTo(String value) {
            addCriterion("maxps <>", value, "maxps");
            return (Criteria) this;
        }

        public Criteria andMaxpsGreaterThan(String value) {
            addCriterion("maxps >", value, "maxps");
            return (Criteria) this;
        }

        public Criteria andMaxpsGreaterThanOrEqualTo(String value) {
            addCriterion("maxps >=", value, "maxps");
            return (Criteria) this;
        }

        public Criteria andMaxpsLessThan(String value) {
            addCriterion("maxps <", value, "maxps");
            return (Criteria) this;
        }

        public Criteria andMaxpsLessThanOrEqualTo(String value) {
            addCriterion("maxps <=", value, "maxps");
            return (Criteria) this;
        }

        public Criteria andMaxpsLike(String value) {
            addCriterion("maxps like", value, "maxps");
            return (Criteria) this;
        }

        public Criteria andMaxpsNotLike(String value) {
            addCriterion("maxps not like", value, "maxps");
            return (Criteria) this;
        }

        public Criteria andMaxpsIn(List<String> values) {
            addCriterion("maxps in", values, "maxps");
            return (Criteria) this;
        }

        public Criteria andMaxpsNotIn(List<String> values) {
            addCriterion("maxps not in", values, "maxps");
            return (Criteria) this;
        }

        public Criteria andMaxpsBetween(String value1, String value2) {
            addCriterion("maxps between", value1, value2, "maxps");
            return (Criteria) this;
        }

        public Criteria andMaxpsNotBetween(String value1, String value2) {
            addCriterion("maxps not between", value1, value2, "maxps");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueIsNull() {
            addCriterion("maxtorque is null");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueIsNotNull() {
            addCriterion("maxtorque is not null");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueEqualTo(String value) {
            addCriterion("maxtorque =", value, "maxtorque");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueNotEqualTo(String value) {
            addCriterion("maxtorque <>", value, "maxtorque");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueGreaterThan(String value) {
            addCriterion("maxtorque >", value, "maxtorque");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueGreaterThanOrEqualTo(String value) {
            addCriterion("maxtorque >=", value, "maxtorque");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueLessThan(String value) {
            addCriterion("maxtorque <", value, "maxtorque");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueLessThanOrEqualTo(String value) {
            addCriterion("maxtorque <=", value, "maxtorque");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueLike(String value) {
            addCriterion("maxtorque like", value, "maxtorque");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueNotLike(String value) {
            addCriterion("maxtorque not like", value, "maxtorque");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueIn(List<String> values) {
            addCriterion("maxtorque in", values, "maxtorque");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueNotIn(List<String> values) {
            addCriterion("maxtorque not in", values, "maxtorque");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueBetween(String value1, String value2) {
            addCriterion("maxtorque between", value1, value2, "maxtorque");
            return (Criteria) this;
        }

        public Criteria andMaxtorqueNotBetween(String value1, String value2) {
            addCriterion("maxtorque not between", value1, value2, "maxtorque");
            return (Criteria) this;
        }

        public Criteria andMotorTypeIsNull() {
            addCriterion("motor_type is null");
            return (Criteria) this;
        }

        public Criteria andMotorTypeIsNotNull() {
            addCriterion("motor_type is not null");
            return (Criteria) this;
        }

        public Criteria andMotorTypeEqualTo(String value) {
            addCriterion("motor_type =", value, "motorType");
            return (Criteria) this;
        }

        public Criteria andMotorTypeNotEqualTo(String value) {
            addCriterion("motor_type <>", value, "motorType");
            return (Criteria) this;
        }

        public Criteria andMotorTypeGreaterThan(String value) {
            addCriterion("motor_type >", value, "motorType");
            return (Criteria) this;
        }

        public Criteria andMotorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("motor_type >=", value, "motorType");
            return (Criteria) this;
        }

        public Criteria andMotorTypeLessThan(String value) {
            addCriterion("motor_type <", value, "motorType");
            return (Criteria) this;
        }

        public Criteria andMotorTypeLessThanOrEqualTo(String value) {
            addCriterion("motor_type <=", value, "motorType");
            return (Criteria) this;
        }

        public Criteria andMotorTypeLike(String value) {
            addCriterion("motor_type like", value, "motorType");
            return (Criteria) this;
        }

        public Criteria andMotorTypeNotLike(String value) {
            addCriterion("motor_type not like", value, "motorType");
            return (Criteria) this;
        }

        public Criteria andMotorTypeIn(List<String> values) {
            addCriterion("motor_type in", values, "motorType");
            return (Criteria) this;
        }

        public Criteria andMotorTypeNotIn(List<String> values) {
            addCriterion("motor_type not in", values, "motorType");
            return (Criteria) this;
        }

        public Criteria andMotorTypeBetween(String value1, String value2) {
            addCriterion("motor_type between", value1, value2, "motorType");
            return (Criteria) this;
        }

        public Criteria andMotorTypeNotBetween(String value1, String value2) {
            addCriterion("motor_type not between", value1, value2, "motorType");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvIsNull() {
            addCriterion("total_power_EV is null");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvIsNotNull() {
            addCriterion("total_power_EV is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvEqualTo(String value) {
            addCriterion("total_power_EV =", value, "totalPowerEv");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvNotEqualTo(String value) {
            addCriterion("total_power_EV <>", value, "totalPowerEv");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvGreaterThan(String value) {
            addCriterion("total_power_EV >", value, "totalPowerEv");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvGreaterThanOrEqualTo(String value) {
            addCriterion("total_power_EV >=", value, "totalPowerEv");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvLessThan(String value) {
            addCriterion("total_power_EV <", value, "totalPowerEv");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvLessThanOrEqualTo(String value) {
            addCriterion("total_power_EV <=", value, "totalPowerEv");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvLike(String value) {
            addCriterion("total_power_EV like", value, "totalPowerEv");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvNotLike(String value) {
            addCriterion("total_power_EV not like", value, "totalPowerEv");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvIn(List<String> values) {
            addCriterion("total_power_EV in", values, "totalPowerEv");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvNotIn(List<String> values) {
            addCriterion("total_power_EV not in", values, "totalPowerEv");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvBetween(String value1, String value2) {
            addCriterion("total_power_EV between", value1, value2, "totalPowerEv");
            return (Criteria) this;
        }

        public Criteria andTotalPowerEvNotBetween(String value1, String value2) {
            addCriterion("total_power_EV not between", value1, value2, "totalPowerEv");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvIsNull() {
            addCriterion("total_torque_EV is null");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvIsNotNull() {
            addCriterion("total_torque_EV is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvEqualTo(String value) {
            addCriterion("total_torque_EV =", value, "totalTorqueEv");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvNotEqualTo(String value) {
            addCriterion("total_torque_EV <>", value, "totalTorqueEv");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvGreaterThan(String value) {
            addCriterion("total_torque_EV >", value, "totalTorqueEv");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvGreaterThanOrEqualTo(String value) {
            addCriterion("total_torque_EV >=", value, "totalTorqueEv");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvLessThan(String value) {
            addCriterion("total_torque_EV <", value, "totalTorqueEv");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvLessThanOrEqualTo(String value) {
            addCriterion("total_torque_EV <=", value, "totalTorqueEv");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvLike(String value) {
            addCriterion("total_torque_EV like", value, "totalTorqueEv");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvNotLike(String value) {
            addCriterion("total_torque_EV not like", value, "totalTorqueEv");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvIn(List<String> values) {
            addCriterion("total_torque_EV in", values, "totalTorqueEv");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvNotIn(List<String> values) {
            addCriterion("total_torque_EV not in", values, "totalTorqueEv");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvBetween(String value1, String value2) {
            addCriterion("total_torque_EV between", value1, value2, "totalTorqueEv");
            return (Criteria) this;
        }

        public Criteria andTotalTorqueEvNotBetween(String value1, String value2) {
            addCriterion("total_torque_EV not between", value1, value2, "totalTorqueEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvIsNull() {
            addCriterion("front_peak_power_EV is null");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvIsNotNull() {
            addCriterion("front_peak_power_EV is not null");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvEqualTo(String value) {
            addCriterion("front_peak_power_EV =", value, "frontPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvNotEqualTo(String value) {
            addCriterion("front_peak_power_EV <>", value, "frontPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvGreaterThan(String value) {
            addCriterion("front_peak_power_EV >", value, "frontPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvGreaterThanOrEqualTo(String value) {
            addCriterion("front_peak_power_EV >=", value, "frontPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvLessThan(String value) {
            addCriterion("front_peak_power_EV <", value, "frontPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvLessThanOrEqualTo(String value) {
            addCriterion("front_peak_power_EV <=", value, "frontPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvLike(String value) {
            addCriterion("front_peak_power_EV like", value, "frontPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvNotLike(String value) {
            addCriterion("front_peak_power_EV not like", value, "frontPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvIn(List<String> values) {
            addCriterion("front_peak_power_EV in", values, "frontPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvNotIn(List<String> values) {
            addCriterion("front_peak_power_EV not in", values, "frontPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvBetween(String value1, String value2) {
            addCriterion("front_peak_power_EV between", value1, value2, "frontPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakPowerEvNotBetween(String value1, String value2) {
            addCriterion("front_peak_power_EV not between", value1, value2, "frontPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvIsNull() {
            addCriterion("front_peak_torque_EV is null");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvIsNotNull() {
            addCriterion("front_peak_torque_EV is not null");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvEqualTo(String value) {
            addCriterion("front_peak_torque_EV =", value, "frontPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvNotEqualTo(String value) {
            addCriterion("front_peak_torque_EV <>", value, "frontPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvGreaterThan(String value) {
            addCriterion("front_peak_torque_EV >", value, "frontPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvGreaterThanOrEqualTo(String value) {
            addCriterion("front_peak_torque_EV >=", value, "frontPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvLessThan(String value) {
            addCriterion("front_peak_torque_EV <", value, "frontPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvLessThanOrEqualTo(String value) {
            addCriterion("front_peak_torque_EV <=", value, "frontPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvLike(String value) {
            addCriterion("front_peak_torque_EV like", value, "frontPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvNotLike(String value) {
            addCriterion("front_peak_torque_EV not like", value, "frontPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvIn(List<String> values) {
            addCriterion("front_peak_torque_EV in", values, "frontPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvNotIn(List<String> values) {
            addCriterion("front_peak_torque_EV not in", values, "frontPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvBetween(String value1, String value2) {
            addCriterion("front_peak_torque_EV between", value1, value2, "frontPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andFrontPeakTorqueEvNotBetween(String value1, String value2) {
            addCriterion("front_peak_torque_EV not between", value1, value2, "frontPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvIsNull() {
            addCriterion("rear_peak_power_EV is null");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvIsNotNull() {
            addCriterion("rear_peak_power_EV is not null");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvEqualTo(String value) {
            addCriterion("rear_peak_power_EV =", value, "rearPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvNotEqualTo(String value) {
            addCriterion("rear_peak_power_EV <>", value, "rearPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvGreaterThan(String value) {
            addCriterion("rear_peak_power_EV >", value, "rearPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvGreaterThanOrEqualTo(String value) {
            addCriterion("rear_peak_power_EV >=", value, "rearPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvLessThan(String value) {
            addCriterion("rear_peak_power_EV <", value, "rearPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvLessThanOrEqualTo(String value) {
            addCriterion("rear_peak_power_EV <=", value, "rearPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvLike(String value) {
            addCriterion("rear_peak_power_EV like", value, "rearPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvNotLike(String value) {
            addCriterion("rear_peak_power_EV not like", value, "rearPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvIn(List<String> values) {
            addCriterion("rear_peak_power_EV in", values, "rearPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvNotIn(List<String> values) {
            addCriterion("rear_peak_power_EV not in", values, "rearPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvBetween(String value1, String value2) {
            addCriterion("rear_peak_power_EV between", value1, value2, "rearPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakPowerEvNotBetween(String value1, String value2) {
            addCriterion("rear_peak_power_EV not between", value1, value2, "rearPeakPowerEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvIsNull() {
            addCriterion("rear_peak_torque_EV is null");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvIsNotNull() {
            addCriterion("rear_peak_torque_EV is not null");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvEqualTo(String value) {
            addCriterion("rear_peak_torque_EV =", value, "rearPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvNotEqualTo(String value) {
            addCriterion("rear_peak_torque_EV <>", value, "rearPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvGreaterThan(String value) {
            addCriterion("rear_peak_torque_EV >", value, "rearPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvGreaterThanOrEqualTo(String value) {
            addCriterion("rear_peak_torque_EV >=", value, "rearPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvLessThan(String value) {
            addCriterion("rear_peak_torque_EV <", value, "rearPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvLessThanOrEqualTo(String value) {
            addCriterion("rear_peak_torque_EV <=", value, "rearPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvLike(String value) {
            addCriterion("rear_peak_torque_EV like", value, "rearPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvNotLike(String value) {
            addCriterion("rear_peak_torque_EV not like", value, "rearPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvIn(List<String> values) {
            addCriterion("rear_peak_torque_EV in", values, "rearPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvNotIn(List<String> values) {
            addCriterion("rear_peak_torque_EV not in", values, "rearPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvBetween(String value1, String value2) {
            addCriterion("rear_peak_torque_EV between", value1, value2, "rearPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andRearPeakTorqueEvNotBetween(String value1, String value2) {
            addCriterion("rear_peak_torque_EV not between", value1, value2, "rearPeakTorqueEv");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerIsNull() {
            addCriterion("vehicle_power is null");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerIsNotNull() {
            addCriterion("vehicle_power is not null");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerEqualTo(String value) {
            addCriterion("vehicle_power =", value, "vehiclePower");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerNotEqualTo(String value) {
            addCriterion("vehicle_power <>", value, "vehiclePower");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerGreaterThan(String value) {
            addCriterion("vehicle_power >", value, "vehiclePower");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_power >=", value, "vehiclePower");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerLessThan(String value) {
            addCriterion("vehicle_power <", value, "vehiclePower");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerLessThanOrEqualTo(String value) {
            addCriterion("vehicle_power <=", value, "vehiclePower");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerLike(String value) {
            addCriterion("vehicle_power like", value, "vehiclePower");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerNotLike(String value) {
            addCriterion("vehicle_power not like", value, "vehiclePower");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerIn(List<String> values) {
            addCriterion("vehicle_power in", values, "vehiclePower");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerNotIn(List<String> values) {
            addCriterion("vehicle_power not in", values, "vehiclePower");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerBetween(String value1, String value2) {
            addCriterion("vehicle_power between", value1, value2, "vehiclePower");
            return (Criteria) this;
        }

        public Criteria andVehiclePowerNotBetween(String value1, String value2) {
            addCriterion("vehicle_power not between", value1, value2, "vehiclePower");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueIsNull() {
            addCriterion("vehicle_torque is null");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueIsNotNull() {
            addCriterion("vehicle_torque is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueEqualTo(String value) {
            addCriterion("vehicle_torque =", value, "vehicleTorque");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueNotEqualTo(String value) {
            addCriterion("vehicle_torque <>", value, "vehicleTorque");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueGreaterThan(String value) {
            addCriterion("vehicle_torque >", value, "vehicleTorque");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_torque >=", value, "vehicleTorque");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueLessThan(String value) {
            addCriterion("vehicle_torque <", value, "vehicleTorque");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueLessThanOrEqualTo(String value) {
            addCriterion("vehicle_torque <=", value, "vehicleTorque");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueLike(String value) {
            addCriterion("vehicle_torque like", value, "vehicleTorque");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueNotLike(String value) {
            addCriterion("vehicle_torque not like", value, "vehicleTorque");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueIn(List<String> values) {
            addCriterion("vehicle_torque in", values, "vehicleTorque");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueNotIn(List<String> values) {
            addCriterion("vehicle_torque not in", values, "vehicleTorque");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueBetween(String value1, String value2) {
            addCriterion("vehicle_torque between", value1, value2, "vehicleTorque");
            return (Criteria) this;
        }

        public Criteria andVehicleTorqueNotBetween(String value1, String value2) {
            addCriterion("vehicle_torque not between", value1, value2, "vehicleTorque");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeIsNull() {
            addCriterion("battery_type is null");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeIsNotNull() {
            addCriterion("battery_type is not null");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeEqualTo(String value) {
            addCriterion("battery_type =", value, "batteryType");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeNotEqualTo(String value) {
            addCriterion("battery_type <>", value, "batteryType");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeGreaterThan(String value) {
            addCriterion("battery_type >", value, "batteryType");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("battery_type >=", value, "batteryType");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeLessThan(String value) {
            addCriterion("battery_type <", value, "batteryType");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeLessThanOrEqualTo(String value) {
            addCriterion("battery_type <=", value, "batteryType");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeLike(String value) {
            addCriterion("battery_type like", value, "batteryType");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeNotLike(String value) {
            addCriterion("battery_type not like", value, "batteryType");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeIn(List<String> values) {
            addCriterion("battery_type in", values, "batteryType");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeNotIn(List<String> values) {
            addCriterion("battery_type not in", values, "batteryType");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeBetween(String value1, String value2) {
            addCriterion("battery_type between", value1, value2, "batteryType");
            return (Criteria) this;
        }

        public Criteria andBatteryTypeNotBetween(String value1, String value2) {
            addCriterion("battery_type not between", value1, value2, "batteryType");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitIsNull() {
            addCriterion("battery_range_MIIT is null");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitIsNotNull() {
            addCriterion("battery_range_MIIT is not null");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitEqualTo(String value) {
            addCriterion("battery_range_MIIT =", value, "batteryRangeMiit");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitNotEqualTo(String value) {
            addCriterion("battery_range_MIIT <>", value, "batteryRangeMiit");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitGreaterThan(String value) {
            addCriterion("battery_range_MIIT >", value, "batteryRangeMiit");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitGreaterThanOrEqualTo(String value) {
            addCriterion("battery_range_MIIT >=", value, "batteryRangeMiit");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitLessThan(String value) {
            addCriterion("battery_range_MIIT <", value, "batteryRangeMiit");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitLessThanOrEqualTo(String value) {
            addCriterion("battery_range_MIIT <=", value, "batteryRangeMiit");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitLike(String value) {
            addCriterion("battery_range_MIIT like", value, "batteryRangeMiit");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitNotLike(String value) {
            addCriterion("battery_range_MIIT not like", value, "batteryRangeMiit");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitIn(List<String> values) {
            addCriterion("battery_range_MIIT in", values, "batteryRangeMiit");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitNotIn(List<String> values) {
            addCriterion("battery_range_MIIT not in", values, "batteryRangeMiit");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitBetween(String value1, String value2) {
            addCriterion("battery_range_MIIT between", value1, value2, "batteryRangeMiit");
            return (Criteria) this;
        }

        public Criteria andBatteryRangeMiitNotBetween(String value1, String value2) {
            addCriterion("battery_range_MIIT not between", value1, value2, "batteryRangeMiit");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityIsNull() {
            addCriterion("battery_capacity is null");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityIsNotNull() {
            addCriterion("battery_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityEqualTo(String value) {
            addCriterion("battery_capacity =", value, "batteryCapacity");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityNotEqualTo(String value) {
            addCriterion("battery_capacity <>", value, "batteryCapacity");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityGreaterThan(String value) {
            addCriterion("battery_capacity >", value, "batteryCapacity");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("battery_capacity >=", value, "batteryCapacity");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityLessThan(String value) {
            addCriterion("battery_capacity <", value, "batteryCapacity");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityLessThanOrEqualTo(String value) {
            addCriterion("battery_capacity <=", value, "batteryCapacity");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityLike(String value) {
            addCriterion("battery_capacity like", value, "batteryCapacity");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityNotLike(String value) {
            addCriterion("battery_capacity not like", value, "batteryCapacity");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityIn(List<String> values) {
            addCriterion("battery_capacity in", values, "batteryCapacity");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityNotIn(List<String> values) {
            addCriterion("battery_capacity not in", values, "batteryCapacity");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityBetween(String value1, String value2) {
            addCriterion("battery_capacity between", value1, value2, "batteryCapacity");
            return (Criteria) this;
        }

        public Criteria andBatteryCapacityNotBetween(String value1, String value2) {
            addCriterion("battery_capacity not between", value1, value2, "batteryCapacity");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionIsNull() {
            addCriterion("power_consumption is null");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionIsNotNull() {
            addCriterion("power_consumption is not null");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionEqualTo(String value) {
            addCriterion("power_consumption =", value, "powerConsumption");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionNotEqualTo(String value) {
            addCriterion("power_consumption <>", value, "powerConsumption");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionGreaterThan(String value) {
            addCriterion("power_consumption >", value, "powerConsumption");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionGreaterThanOrEqualTo(String value) {
            addCriterion("power_consumption >=", value, "powerConsumption");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionLessThan(String value) {
            addCriterion("power_consumption <", value, "powerConsumption");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionLessThanOrEqualTo(String value) {
            addCriterion("power_consumption <=", value, "powerConsumption");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionLike(String value) {
            addCriterion("power_consumption like", value, "powerConsumption");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionNotLike(String value) {
            addCriterion("power_consumption not like", value, "powerConsumption");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionIn(List<String> values) {
            addCriterion("power_consumption in", values, "powerConsumption");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionNotIn(List<String> values) {
            addCriterion("power_consumption not in", values, "powerConsumption");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionBetween(String value1, String value2) {
            addCriterion("power_consumption between", value1, value2, "powerConsumption");
            return (Criteria) this;
        }

        public Criteria andPowerConsumptionNotBetween(String value1, String value2) {
            addCriterion("power_consumption not between", value1, value2, "powerConsumption");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyIsNull() {
            addCriterion("battery_pack_warrenty is null");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyIsNotNull() {
            addCriterion("battery_pack_warrenty is not null");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyEqualTo(String value) {
            addCriterion("battery_pack_warrenty =", value, "batteryPackWarrenty");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyNotEqualTo(String value) {
            addCriterion("battery_pack_warrenty <>", value, "batteryPackWarrenty");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyGreaterThan(String value) {
            addCriterion("battery_pack_warrenty >", value, "batteryPackWarrenty");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyGreaterThanOrEqualTo(String value) {
            addCriterion("battery_pack_warrenty >=", value, "batteryPackWarrenty");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyLessThan(String value) {
            addCriterion("battery_pack_warrenty <", value, "batteryPackWarrenty");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyLessThanOrEqualTo(String value) {
            addCriterion("battery_pack_warrenty <=", value, "batteryPackWarrenty");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyLike(String value) {
            addCriterion("battery_pack_warrenty like", value, "batteryPackWarrenty");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyNotLike(String value) {
            addCriterion("battery_pack_warrenty not like", value, "batteryPackWarrenty");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyIn(List<String> values) {
            addCriterion("battery_pack_warrenty in", values, "batteryPackWarrenty");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyNotIn(List<String> values) {
            addCriterion("battery_pack_warrenty not in", values, "batteryPackWarrenty");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyBetween(String value1, String value2) {
            addCriterion("battery_pack_warrenty between", value1, value2, "batteryPackWarrenty");
            return (Criteria) this;
        }

        public Criteria andBatteryPackWarrentyNotBetween(String value1, String value2) {
            addCriterion("battery_pack_warrenty not between", value1, value2, "batteryPackWarrenty");
            return (Criteria) this;
        }

        public Criteria andChargingTimeIsNull() {
            addCriterion("charging_time is null");
            return (Criteria) this;
        }

        public Criteria andChargingTimeIsNotNull() {
            addCriterion("charging_time is not null");
            return (Criteria) this;
        }

        public Criteria andChargingTimeEqualTo(String value) {
            addCriterion("charging_time =", value, "chargingTime");
            return (Criteria) this;
        }

        public Criteria andChargingTimeNotEqualTo(String value) {
            addCriterion("charging_time <>", value, "chargingTime");
            return (Criteria) this;
        }

        public Criteria andChargingTimeGreaterThan(String value) {
            addCriterion("charging_time >", value, "chargingTime");
            return (Criteria) this;
        }

        public Criteria andChargingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("charging_time >=", value, "chargingTime");
            return (Criteria) this;
        }

        public Criteria andChargingTimeLessThan(String value) {
            addCriterion("charging_time <", value, "chargingTime");
            return (Criteria) this;
        }

        public Criteria andChargingTimeLessThanOrEqualTo(String value) {
            addCriterion("charging_time <=", value, "chargingTime");
            return (Criteria) this;
        }

        public Criteria andChargingTimeLike(String value) {
            addCriterion("charging_time like", value, "chargingTime");
            return (Criteria) this;
        }

        public Criteria andChargingTimeNotLike(String value) {
            addCriterion("charging_time not like", value, "chargingTime");
            return (Criteria) this;
        }

        public Criteria andChargingTimeIn(List<String> values) {
            addCriterion("charging_time in", values, "chargingTime");
            return (Criteria) this;
        }

        public Criteria andChargingTimeNotIn(List<String> values) {
            addCriterion("charging_time not in", values, "chargingTime");
            return (Criteria) this;
        }

        public Criteria andChargingTimeBetween(String value1, String value2) {
            addCriterion("charging_time between", value1, value2, "chargingTime");
            return (Criteria) this;
        }

        public Criteria andChargingTimeNotBetween(String value1, String value2) {
            addCriterion("charging_time not between", value1, value2, "chargingTime");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityIsNull() {
            addCriterion("fast_charge_electricity is null");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityIsNotNull() {
            addCriterion("fast_charge_electricity is not null");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityEqualTo(String value) {
            addCriterion("fast_charge_electricity =", value, "fastChargeElectricity");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityNotEqualTo(String value) {
            addCriterion("fast_charge_electricity <>", value, "fastChargeElectricity");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityGreaterThan(String value) {
            addCriterion("fast_charge_electricity >", value, "fastChargeElectricity");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityGreaterThanOrEqualTo(String value) {
            addCriterion("fast_charge_electricity >=", value, "fastChargeElectricity");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityLessThan(String value) {
            addCriterion("fast_charge_electricity <", value, "fastChargeElectricity");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityLessThanOrEqualTo(String value) {
            addCriterion("fast_charge_electricity <=", value, "fastChargeElectricity");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityLike(String value) {
            addCriterion("fast_charge_electricity like", value, "fastChargeElectricity");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityNotLike(String value) {
            addCriterion("fast_charge_electricity not like", value, "fastChargeElectricity");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityIn(List<String> values) {
            addCriterion("fast_charge_electricity in", values, "fastChargeElectricity");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityNotIn(List<String> values) {
            addCriterion("fast_charge_electricity not in", values, "fastChargeElectricity");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityBetween(String value1, String value2) {
            addCriterion("fast_charge_electricity between", value1, value2, "fastChargeElectricity");
            return (Criteria) this;
        }

        public Criteria andFastChargeElectricityNotBetween(String value1, String value2) {
            addCriterion("fast_charge_electricity not between", value1, value2, "fastChargeElectricity");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceIsNull() {
            addCriterion("charging_pile_price is null");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceIsNotNull() {
            addCriterion("charging_pile_price is not null");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceEqualTo(String value) {
            addCriterion("charging_pile_price =", value, "chargingPilePrice");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceNotEqualTo(String value) {
            addCriterion("charging_pile_price <>", value, "chargingPilePrice");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceGreaterThan(String value) {
            addCriterion("charging_pile_price >", value, "chargingPilePrice");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceGreaterThanOrEqualTo(String value) {
            addCriterion("charging_pile_price >=", value, "chargingPilePrice");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceLessThan(String value) {
            addCriterion("charging_pile_price <", value, "chargingPilePrice");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceLessThanOrEqualTo(String value) {
            addCriterion("charging_pile_price <=", value, "chargingPilePrice");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceLike(String value) {
            addCriterion("charging_pile_price like", value, "chargingPilePrice");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceNotLike(String value) {
            addCriterion("charging_pile_price not like", value, "chargingPilePrice");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceIn(List<String> values) {
            addCriterion("charging_pile_price in", values, "chargingPilePrice");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceNotIn(List<String> values) {
            addCriterion("charging_pile_price not in", values, "chargingPilePrice");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceBetween(String value1, String value2) {
            addCriterion("charging_pile_price between", value1, value2, "chargingPilePrice");
            return (Criteria) this;
        }

        public Criteria andChargingPilePriceNotBetween(String value1, String value2) {
            addCriterion("charging_pile_price not between", value1, value2, "chargingPilePrice");
            return (Criteria) this;
        }

        public Criteria andGeardescIsNull() {
            addCriterion("geardesc is null");
            return (Criteria) this;
        }

        public Criteria andGeardescIsNotNull() {
            addCriterion("geardesc is not null");
            return (Criteria) this;
        }

        public Criteria andGeardescEqualTo(String value) {
            addCriterion("geardesc =", value, "geardesc");
            return (Criteria) this;
        }

        public Criteria andGeardescNotEqualTo(String value) {
            addCriterion("geardesc <>", value, "geardesc");
            return (Criteria) this;
        }

        public Criteria andGeardescGreaterThan(String value) {
            addCriterion("geardesc >", value, "geardesc");
            return (Criteria) this;
        }

        public Criteria andGeardescGreaterThanOrEqualTo(String value) {
            addCriterion("geardesc >=", value, "geardesc");
            return (Criteria) this;
        }

        public Criteria andGeardescLessThan(String value) {
            addCriterion("geardesc <", value, "geardesc");
            return (Criteria) this;
        }

        public Criteria andGeardescLessThanOrEqualTo(String value) {
            addCriterion("geardesc <=", value, "geardesc");
            return (Criteria) this;
        }

        public Criteria andGeardescLike(String value) {
            addCriterion("geardesc like", value, "geardesc");
            return (Criteria) this;
        }

        public Criteria andGeardescNotLike(String value) {
            addCriterion("geardesc not like", value, "geardesc");
            return (Criteria) this;
        }

        public Criteria andGeardescIn(List<String> values) {
            addCriterion("geardesc in", values, "geardesc");
            return (Criteria) this;
        }

        public Criteria andGeardescNotIn(List<String> values) {
            addCriterion("geardesc not in", values, "geardesc");
            return (Criteria) this;
        }

        public Criteria andGeardescBetween(String value1, String value2) {
            addCriterion("geardesc between", value1, value2, "geardesc");
            return (Criteria) this;
        }

        public Criteria andGeardescNotBetween(String value1, String value2) {
            addCriterion("geardesc not between", value1, value2, "geardesc");
            return (Criteria) this;
        }

        public Criteria andGearnumberIsNull() {
            addCriterion("gearnumber is null");
            return (Criteria) this;
        }

        public Criteria andGearnumberIsNotNull() {
            addCriterion("gearnumber is not null");
            return (Criteria) this;
        }

        public Criteria andGearnumberEqualTo(String value) {
            addCriterion("gearnumber =", value, "gearnumber");
            return (Criteria) this;
        }

        public Criteria andGearnumberNotEqualTo(String value) {
            addCriterion("gearnumber <>", value, "gearnumber");
            return (Criteria) this;
        }

        public Criteria andGearnumberGreaterThan(String value) {
            addCriterion("gearnumber >", value, "gearnumber");
            return (Criteria) this;
        }

        public Criteria andGearnumberGreaterThanOrEqualTo(String value) {
            addCriterion("gearnumber >=", value, "gearnumber");
            return (Criteria) this;
        }

        public Criteria andGearnumberLessThan(String value) {
            addCriterion("gearnumber <", value, "gearnumber");
            return (Criteria) this;
        }

        public Criteria andGearnumberLessThanOrEqualTo(String value) {
            addCriterion("gearnumber <=", value, "gearnumber");
            return (Criteria) this;
        }

        public Criteria andGearnumberLike(String value) {
            addCriterion("gearnumber like", value, "gearnumber");
            return (Criteria) this;
        }

        public Criteria andGearnumberNotLike(String value) {
            addCriterion("gearnumber not like", value, "gearnumber");
            return (Criteria) this;
        }

        public Criteria andGearnumberIn(List<String> values) {
            addCriterion("gearnumber in", values, "gearnumber");
            return (Criteria) this;
        }

        public Criteria andGearnumberNotIn(List<String> values) {
            addCriterion("gearnumber not in", values, "gearnumber");
            return (Criteria) this;
        }

        public Criteria andGearnumberBetween(String value1, String value2) {
            addCriterion("gearnumber between", value1, value2, "gearnumber");
            return (Criteria) this;
        }

        public Criteria andGearnumberNotBetween(String value1, String value2) {
            addCriterion("gearnumber not between", value1, value2, "gearnumber");
            return (Criteria) this;
        }

        public Criteria andDrivewayIsNull() {
            addCriterion("driveway is null");
            return (Criteria) this;
        }

        public Criteria andDrivewayIsNotNull() {
            addCriterion("driveway is not null");
            return (Criteria) this;
        }

        public Criteria andDrivewayEqualTo(String value) {
            addCriterion("driveway =", value, "driveway");
            return (Criteria) this;
        }

        public Criteria andDrivewayNotEqualTo(String value) {
            addCriterion("driveway <>", value, "driveway");
            return (Criteria) this;
        }

        public Criteria andDrivewayGreaterThan(String value) {
            addCriterion("driveway >", value, "driveway");
            return (Criteria) this;
        }

        public Criteria andDrivewayGreaterThanOrEqualTo(String value) {
            addCriterion("driveway >=", value, "driveway");
            return (Criteria) this;
        }

        public Criteria andDrivewayLessThan(String value) {
            addCriterion("driveway <", value, "driveway");
            return (Criteria) this;
        }

        public Criteria andDrivewayLessThanOrEqualTo(String value) {
            addCriterion("driveway <=", value, "driveway");
            return (Criteria) this;
        }

        public Criteria andDrivewayLike(String value) {
            addCriterion("driveway like", value, "driveway");
            return (Criteria) this;
        }

        public Criteria andDrivewayNotLike(String value) {
            addCriterion("driveway not like", value, "driveway");
            return (Criteria) this;
        }

        public Criteria andDrivewayIn(List<String> values) {
            addCriterion("driveway in", values, "driveway");
            return (Criteria) this;
        }

        public Criteria andDrivewayNotIn(List<String> values) {
            addCriterion("driveway not in", values, "driveway");
            return (Criteria) this;
        }

        public Criteria andDrivewayBetween(String value1, String value2) {
            addCriterion("driveway between", value1, value2, "driveway");
            return (Criteria) this;
        }

        public Criteria andDrivewayNotBetween(String value1, String value2) {
            addCriterion("driveway not between", value1, value2, "driveway");
            return (Criteria) this;
        }

        public Criteria andFronthangIsNull() {
            addCriterion("fronthang is null");
            return (Criteria) this;
        }

        public Criteria andFronthangIsNotNull() {
            addCriterion("fronthang is not null");
            return (Criteria) this;
        }

        public Criteria andFronthangEqualTo(String value) {
            addCriterion("fronthang =", value, "fronthang");
            return (Criteria) this;
        }

        public Criteria andFronthangNotEqualTo(String value) {
            addCriterion("fronthang <>", value, "fronthang");
            return (Criteria) this;
        }

        public Criteria andFronthangGreaterThan(String value) {
            addCriterion("fronthang >", value, "fronthang");
            return (Criteria) this;
        }

        public Criteria andFronthangGreaterThanOrEqualTo(String value) {
            addCriterion("fronthang >=", value, "fronthang");
            return (Criteria) this;
        }

        public Criteria andFronthangLessThan(String value) {
            addCriterion("fronthang <", value, "fronthang");
            return (Criteria) this;
        }

        public Criteria andFronthangLessThanOrEqualTo(String value) {
            addCriterion("fronthang <=", value, "fronthang");
            return (Criteria) this;
        }

        public Criteria andFronthangLike(String value) {
            addCriterion("fronthang like", value, "fronthang");
            return (Criteria) this;
        }

        public Criteria andFronthangNotLike(String value) {
            addCriterion("fronthang not like", value, "fronthang");
            return (Criteria) this;
        }

        public Criteria andFronthangIn(List<String> values) {
            addCriterion("fronthang in", values, "fronthang");
            return (Criteria) this;
        }

        public Criteria andFronthangNotIn(List<String> values) {
            addCriterion("fronthang not in", values, "fronthang");
            return (Criteria) this;
        }

        public Criteria andFronthangBetween(String value1, String value2) {
            addCriterion("fronthang between", value1, value2, "fronthang");
            return (Criteria) this;
        }

        public Criteria andFronthangNotBetween(String value1, String value2) {
            addCriterion("fronthang not between", value1, value2, "fronthang");
            return (Criteria) this;
        }

        public Criteria andBackhangIsNull() {
            addCriterion("backhang is null");
            return (Criteria) this;
        }

        public Criteria andBackhangIsNotNull() {
            addCriterion("backhang is not null");
            return (Criteria) this;
        }

        public Criteria andBackhangEqualTo(String value) {
            addCriterion("backhang =", value, "backhang");
            return (Criteria) this;
        }

        public Criteria andBackhangNotEqualTo(String value) {
            addCriterion("backhang <>", value, "backhang");
            return (Criteria) this;
        }

        public Criteria andBackhangGreaterThan(String value) {
            addCriterion("backhang >", value, "backhang");
            return (Criteria) this;
        }

        public Criteria andBackhangGreaterThanOrEqualTo(String value) {
            addCriterion("backhang >=", value, "backhang");
            return (Criteria) this;
        }

        public Criteria andBackhangLessThan(String value) {
            addCriterion("backhang <", value, "backhang");
            return (Criteria) this;
        }

        public Criteria andBackhangLessThanOrEqualTo(String value) {
            addCriterion("backhang <=", value, "backhang");
            return (Criteria) this;
        }

        public Criteria andBackhangLike(String value) {
            addCriterion("backhang like", value, "backhang");
            return (Criteria) this;
        }

        public Criteria andBackhangNotLike(String value) {
            addCriterion("backhang not like", value, "backhang");
            return (Criteria) this;
        }

        public Criteria andBackhangIn(List<String> values) {
            addCriterion("backhang in", values, "backhang");
            return (Criteria) this;
        }

        public Criteria andBackhangNotIn(List<String> values) {
            addCriterion("backhang not in", values, "backhang");
            return (Criteria) this;
        }

        public Criteria andBackhangBetween(String value1, String value2) {
            addCriterion("backhang between", value1, value2, "backhang");
            return (Criteria) this;
        }

        public Criteria andBackhangNotBetween(String value1, String value2) {
            addCriterion("backhang not between", value1, value2, "backhang");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeIsNull() {
            addCriterion("assistanttype is null");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeIsNotNull() {
            addCriterion("assistanttype is not null");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeEqualTo(String value) {
            addCriterion("assistanttype =", value, "assistanttype");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeNotEqualTo(String value) {
            addCriterion("assistanttype <>", value, "assistanttype");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeGreaterThan(String value) {
            addCriterion("assistanttype >", value, "assistanttype");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeGreaterThanOrEqualTo(String value) {
            addCriterion("assistanttype >=", value, "assistanttype");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeLessThan(String value) {
            addCriterion("assistanttype <", value, "assistanttype");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeLessThanOrEqualTo(String value) {
            addCriterion("assistanttype <=", value, "assistanttype");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeLike(String value) {
            addCriterion("assistanttype like", value, "assistanttype");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeNotLike(String value) {
            addCriterion("assistanttype not like", value, "assistanttype");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeIn(List<String> values) {
            addCriterion("assistanttype in", values, "assistanttype");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeNotIn(List<String> values) {
            addCriterion("assistanttype not in", values, "assistanttype");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeBetween(String value1, String value2) {
            addCriterion("assistanttype between", value1, value2, "assistanttype");
            return (Criteria) this;
        }

        public Criteria andAssistanttypeNotBetween(String value1, String value2) {
            addCriterion("assistanttype not between", value1, value2, "assistanttype");
            return (Criteria) this;
        }

        public Criteria andSteeringboxIsNull() {
            addCriterion("steeringbox is null");
            return (Criteria) this;
        }

        public Criteria andSteeringboxIsNotNull() {
            addCriterion("steeringbox is not null");
            return (Criteria) this;
        }

        public Criteria andSteeringboxEqualTo(String value) {
            addCriterion("steeringbox =", value, "steeringbox");
            return (Criteria) this;
        }

        public Criteria andSteeringboxNotEqualTo(String value) {
            addCriterion("steeringbox <>", value, "steeringbox");
            return (Criteria) this;
        }

        public Criteria andSteeringboxGreaterThan(String value) {
            addCriterion("steeringbox >", value, "steeringbox");
            return (Criteria) this;
        }

        public Criteria andSteeringboxGreaterThanOrEqualTo(String value) {
            addCriterion("steeringbox >=", value, "steeringbox");
            return (Criteria) this;
        }

        public Criteria andSteeringboxLessThan(String value) {
            addCriterion("steeringbox <", value, "steeringbox");
            return (Criteria) this;
        }

        public Criteria andSteeringboxLessThanOrEqualTo(String value) {
            addCriterion("steeringbox <=", value, "steeringbox");
            return (Criteria) this;
        }

        public Criteria andSteeringboxLike(String value) {
            addCriterion("steeringbox like", value, "steeringbox");
            return (Criteria) this;
        }

        public Criteria andSteeringboxNotLike(String value) {
            addCriterion("steeringbox not like", value, "steeringbox");
            return (Criteria) this;
        }

        public Criteria andSteeringboxIn(List<String> values) {
            addCriterion("steeringbox in", values, "steeringbox");
            return (Criteria) this;
        }

        public Criteria andSteeringboxNotIn(List<String> values) {
            addCriterion("steeringbox not in", values, "steeringbox");
            return (Criteria) this;
        }

        public Criteria andSteeringboxBetween(String value1, String value2) {
            addCriterion("steeringbox between", value1, value2, "steeringbox");
            return (Criteria) this;
        }

        public Criteria andSteeringboxNotBetween(String value1, String value2) {
            addCriterion("steeringbox not between", value1, value2, "steeringbox");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeIsNull() {
            addCriterion("frontbrake is null");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeIsNotNull() {
            addCriterion("frontbrake is not null");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeEqualTo(String value) {
            addCriterion("frontbrake =", value, "frontbrake");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeNotEqualTo(String value) {
            addCriterion("frontbrake <>", value, "frontbrake");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeGreaterThan(String value) {
            addCriterion("frontbrake >", value, "frontbrake");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeGreaterThanOrEqualTo(String value) {
            addCriterion("frontbrake >=", value, "frontbrake");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeLessThan(String value) {
            addCriterion("frontbrake <", value, "frontbrake");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeLessThanOrEqualTo(String value) {
            addCriterion("frontbrake <=", value, "frontbrake");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeLike(String value) {
            addCriterion("frontbrake like", value, "frontbrake");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeNotLike(String value) {
            addCriterion("frontbrake not like", value, "frontbrake");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeIn(List<String> values) {
            addCriterion("frontbrake in", values, "frontbrake");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeNotIn(List<String> values) {
            addCriterion("frontbrake not in", values, "frontbrake");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeBetween(String value1, String value2) {
            addCriterion("frontbrake between", value1, value2, "frontbrake");
            return (Criteria) this;
        }

        public Criteria andFrontbrakeNotBetween(String value1, String value2) {
            addCriterion("frontbrake not between", value1, value2, "frontbrake");
            return (Criteria) this;
        }

        public Criteria andBackbrakeIsNull() {
            addCriterion("backbrake is null");
            return (Criteria) this;
        }

        public Criteria andBackbrakeIsNotNull() {
            addCriterion("backbrake is not null");
            return (Criteria) this;
        }

        public Criteria andBackbrakeEqualTo(String value) {
            addCriterion("backbrake =", value, "backbrake");
            return (Criteria) this;
        }

        public Criteria andBackbrakeNotEqualTo(String value) {
            addCriterion("backbrake <>", value, "backbrake");
            return (Criteria) this;
        }

        public Criteria andBackbrakeGreaterThan(String value) {
            addCriterion("backbrake >", value, "backbrake");
            return (Criteria) this;
        }

        public Criteria andBackbrakeGreaterThanOrEqualTo(String value) {
            addCriterion("backbrake >=", value, "backbrake");
            return (Criteria) this;
        }

        public Criteria andBackbrakeLessThan(String value) {
            addCriterion("backbrake <", value, "backbrake");
            return (Criteria) this;
        }

        public Criteria andBackbrakeLessThanOrEqualTo(String value) {
            addCriterion("backbrake <=", value, "backbrake");
            return (Criteria) this;
        }

        public Criteria andBackbrakeLike(String value) {
            addCriterion("backbrake like", value, "backbrake");
            return (Criteria) this;
        }

        public Criteria andBackbrakeNotLike(String value) {
            addCriterion("backbrake not like", value, "backbrake");
            return (Criteria) this;
        }

        public Criteria andBackbrakeIn(List<String> values) {
            addCriterion("backbrake in", values, "backbrake");
            return (Criteria) this;
        }

        public Criteria andBackbrakeNotIn(List<String> values) {
            addCriterion("backbrake not in", values, "backbrake");
            return (Criteria) this;
        }

        public Criteria andBackbrakeBetween(String value1, String value2) {
            addCriterion("backbrake between", value1, value2, "backbrake");
            return (Criteria) this;
        }

        public Criteria andBackbrakeNotBetween(String value1, String value2) {
            addCriterion("backbrake not between", value1, value2, "backbrake");
            return (Criteria) this;
        }

        public Criteria andFrontwheelIsNull() {
            addCriterion("frontwheel is null");
            return (Criteria) this;
        }

        public Criteria andFrontwheelIsNotNull() {
            addCriterion("frontwheel is not null");
            return (Criteria) this;
        }

        public Criteria andFrontwheelEqualTo(String value) {
            addCriterion("frontwheel =", value, "frontwheel");
            return (Criteria) this;
        }

        public Criteria andFrontwheelNotEqualTo(String value) {
            addCriterion("frontwheel <>", value, "frontwheel");
            return (Criteria) this;
        }

        public Criteria andFrontwheelGreaterThan(String value) {
            addCriterion("frontwheel >", value, "frontwheel");
            return (Criteria) this;
        }

        public Criteria andFrontwheelGreaterThanOrEqualTo(String value) {
            addCriterion("frontwheel >=", value, "frontwheel");
            return (Criteria) this;
        }

        public Criteria andFrontwheelLessThan(String value) {
            addCriterion("frontwheel <", value, "frontwheel");
            return (Criteria) this;
        }

        public Criteria andFrontwheelLessThanOrEqualTo(String value) {
            addCriterion("frontwheel <=", value, "frontwheel");
            return (Criteria) this;
        }

        public Criteria andFrontwheelLike(String value) {
            addCriterion("frontwheel like", value, "frontwheel");
            return (Criteria) this;
        }

        public Criteria andFrontwheelNotLike(String value) {
            addCriterion("frontwheel not like", value, "frontwheel");
            return (Criteria) this;
        }

        public Criteria andFrontwheelIn(List<String> values) {
            addCriterion("frontwheel in", values, "frontwheel");
            return (Criteria) this;
        }

        public Criteria andFrontwheelNotIn(List<String> values) {
            addCriterion("frontwheel not in", values, "frontwheel");
            return (Criteria) this;
        }

        public Criteria andFrontwheelBetween(String value1, String value2) {
            addCriterion("frontwheel between", value1, value2, "frontwheel");
            return (Criteria) this;
        }

        public Criteria andFrontwheelNotBetween(String value1, String value2) {
            addCriterion("frontwheel not between", value1, value2, "frontwheel");
            return (Criteria) this;
        }

        public Criteria andBackwheelIsNull() {
            addCriterion("backwheel is null");
            return (Criteria) this;
        }

        public Criteria andBackwheelIsNotNull() {
            addCriterion("backwheel is not null");
            return (Criteria) this;
        }

        public Criteria andBackwheelEqualTo(String value) {
            addCriterion("backwheel =", value, "backwheel");
            return (Criteria) this;
        }

        public Criteria andBackwheelNotEqualTo(String value) {
            addCriterion("backwheel <>", value, "backwheel");
            return (Criteria) this;
        }

        public Criteria andBackwheelGreaterThan(String value) {
            addCriterion("backwheel >", value, "backwheel");
            return (Criteria) this;
        }

        public Criteria andBackwheelGreaterThanOrEqualTo(String value) {
            addCriterion("backwheel >=", value, "backwheel");
            return (Criteria) this;
        }

        public Criteria andBackwheelLessThan(String value) {
            addCriterion("backwheel <", value, "backwheel");
            return (Criteria) this;
        }

        public Criteria andBackwheelLessThanOrEqualTo(String value) {
            addCriterion("backwheel <=", value, "backwheel");
            return (Criteria) this;
        }

        public Criteria andBackwheelLike(String value) {
            addCriterion("backwheel like", value, "backwheel");
            return (Criteria) this;
        }

        public Criteria andBackwheelNotLike(String value) {
            addCriterion("backwheel not like", value, "backwheel");
            return (Criteria) this;
        }

        public Criteria andBackwheelIn(List<String> values) {
            addCriterion("backwheel in", values, "backwheel");
            return (Criteria) this;
        }

        public Criteria andBackwheelNotIn(List<String> values) {
            addCriterion("backwheel not in", values, "backwheel");
            return (Criteria) this;
        }

        public Criteria andBackwheelBetween(String value1, String value2) {
            addCriterion("backwheel between", value1, value2, "backwheel");
            return (Criteria) this;
        }

        public Criteria andBackwheelNotBetween(String value1, String value2) {
            addCriterion("backwheel not between", value1, value2, "backwheel");
            return (Criteria) this;
        }

        public Criteria andFronthubIsNull() {
            addCriterion("fronthub is null");
            return (Criteria) this;
        }

        public Criteria andFronthubIsNotNull() {
            addCriterion("fronthub is not null");
            return (Criteria) this;
        }

        public Criteria andFronthubEqualTo(String value) {
            addCriterion("fronthub =", value, "fronthub");
            return (Criteria) this;
        }

        public Criteria andFronthubNotEqualTo(String value) {
            addCriterion("fronthub <>", value, "fronthub");
            return (Criteria) this;
        }

        public Criteria andFronthubGreaterThan(String value) {
            addCriterion("fronthub >", value, "fronthub");
            return (Criteria) this;
        }

        public Criteria andFronthubGreaterThanOrEqualTo(String value) {
            addCriterion("fronthub >=", value, "fronthub");
            return (Criteria) this;
        }

        public Criteria andFronthubLessThan(String value) {
            addCriterion("fronthub <", value, "fronthub");
            return (Criteria) this;
        }

        public Criteria andFronthubLessThanOrEqualTo(String value) {
            addCriterion("fronthub <=", value, "fronthub");
            return (Criteria) this;
        }

        public Criteria andFronthubLike(String value) {
            addCriterion("fronthub like", value, "fronthub");
            return (Criteria) this;
        }

        public Criteria andFronthubNotLike(String value) {
            addCriterion("fronthub not like", value, "fronthub");
            return (Criteria) this;
        }

        public Criteria andFronthubIn(List<String> values) {
            addCriterion("fronthub in", values, "fronthub");
            return (Criteria) this;
        }

        public Criteria andFronthubNotIn(List<String> values) {
            addCriterion("fronthub not in", values, "fronthub");
            return (Criteria) this;
        }

        public Criteria andFronthubBetween(String value1, String value2) {
            addCriterion("fronthub between", value1, value2, "fronthub");
            return (Criteria) this;
        }

        public Criteria andFronthubNotBetween(String value1, String value2) {
            addCriterion("fronthub not between", value1, value2, "fronthub");
            return (Criteria) this;
        }

        public Criteria andBackhubIsNull() {
            addCriterion("backhub is null");
            return (Criteria) this;
        }

        public Criteria andBackhubIsNotNull() {
            addCriterion("backhub is not null");
            return (Criteria) this;
        }

        public Criteria andBackhubEqualTo(String value) {
            addCriterion("backhub =", value, "backhub");
            return (Criteria) this;
        }

        public Criteria andBackhubNotEqualTo(String value) {
            addCriterion("backhub <>", value, "backhub");
            return (Criteria) this;
        }

        public Criteria andBackhubGreaterThan(String value) {
            addCriterion("backhub >", value, "backhub");
            return (Criteria) this;
        }

        public Criteria andBackhubGreaterThanOrEqualTo(String value) {
            addCriterion("backhub >=", value, "backhub");
            return (Criteria) this;
        }

        public Criteria andBackhubLessThan(String value) {
            addCriterion("backhub <", value, "backhub");
            return (Criteria) this;
        }

        public Criteria andBackhubLessThanOrEqualTo(String value) {
            addCriterion("backhub <=", value, "backhub");
            return (Criteria) this;
        }

        public Criteria andBackhubLike(String value) {
            addCriterion("backhub like", value, "backhub");
            return (Criteria) this;
        }

        public Criteria andBackhubNotLike(String value) {
            addCriterion("backhub not like", value, "backhub");
            return (Criteria) this;
        }

        public Criteria andBackhubIn(List<String> values) {
            addCriterion("backhub in", values, "backhub");
            return (Criteria) this;
        }

        public Criteria andBackhubNotIn(List<String> values) {
            addCriterion("backhub not in", values, "backhub");
            return (Criteria) this;
        }

        public Criteria andBackhubBetween(String value1, String value2) {
            addCriterion("backhub between", value1, value2, "backhub");
            return (Criteria) this;
        }

        public Criteria andBackhubNotBetween(String value1, String value2) {
            addCriterion("backhub not between", value1, value2, "backhub");
            return (Criteria) this;
        }

        public Criteria andHubtypeIsNull() {
            addCriterion("hubtype is null");
            return (Criteria) this;
        }

        public Criteria andHubtypeIsNotNull() {
            addCriterion("hubtype is not null");
            return (Criteria) this;
        }

        public Criteria andHubtypeEqualTo(String value) {
            addCriterion("hubtype =", value, "hubtype");
            return (Criteria) this;
        }

        public Criteria andHubtypeNotEqualTo(String value) {
            addCriterion("hubtype <>", value, "hubtype");
            return (Criteria) this;
        }

        public Criteria andHubtypeGreaterThan(String value) {
            addCriterion("hubtype >", value, "hubtype");
            return (Criteria) this;
        }

        public Criteria andHubtypeGreaterThanOrEqualTo(String value) {
            addCriterion("hubtype >=", value, "hubtype");
            return (Criteria) this;
        }

        public Criteria andHubtypeLessThan(String value) {
            addCriterion("hubtype <", value, "hubtype");
            return (Criteria) this;
        }

        public Criteria andHubtypeLessThanOrEqualTo(String value) {
            addCriterion("hubtype <=", value, "hubtype");
            return (Criteria) this;
        }

        public Criteria andHubtypeLike(String value) {
            addCriterion("hubtype like", value, "hubtype");
            return (Criteria) this;
        }

        public Criteria andHubtypeNotLike(String value) {
            addCriterion("hubtype not like", value, "hubtype");
            return (Criteria) this;
        }

        public Criteria andHubtypeIn(List<String> values) {
            addCriterion("hubtype in", values, "hubtype");
            return (Criteria) this;
        }

        public Criteria andHubtypeNotIn(List<String> values) {
            addCriterion("hubtype not in", values, "hubtype");
            return (Criteria) this;
        }

        public Criteria andHubtypeBetween(String value1, String value2) {
            addCriterion("hubtype between", value1, value2, "hubtype");
            return (Criteria) this;
        }

        public Criteria andHubtypeNotBetween(String value1, String value2) {
            addCriterion("hubtype not between", value1, value2, "hubtype");
            return (Criteria) this;
        }

        public Criteria andSparewheelIsNull() {
            addCriterion("sparewheel is null");
            return (Criteria) this;
        }

        public Criteria andSparewheelIsNotNull() {
            addCriterion("sparewheel is not null");
            return (Criteria) this;
        }

        public Criteria andSparewheelEqualTo(String value) {
            addCriterion("sparewheel =", value, "sparewheel");
            return (Criteria) this;
        }

        public Criteria andSparewheelNotEqualTo(String value) {
            addCriterion("sparewheel <>", value, "sparewheel");
            return (Criteria) this;
        }

        public Criteria andSparewheelGreaterThan(String value) {
            addCriterion("sparewheel >", value, "sparewheel");
            return (Criteria) this;
        }

        public Criteria andSparewheelGreaterThanOrEqualTo(String value) {
            addCriterion("sparewheel >=", value, "sparewheel");
            return (Criteria) this;
        }

        public Criteria andSparewheelLessThan(String value) {
            addCriterion("sparewheel <", value, "sparewheel");
            return (Criteria) this;
        }

        public Criteria andSparewheelLessThanOrEqualTo(String value) {
            addCriterion("sparewheel <=", value, "sparewheel");
            return (Criteria) this;
        }

        public Criteria andSparewheelLike(String value) {
            addCriterion("sparewheel like", value, "sparewheel");
            return (Criteria) this;
        }

        public Criteria andSparewheelNotLike(String value) {
            addCriterion("sparewheel not like", value, "sparewheel");
            return (Criteria) this;
        }

        public Criteria andSparewheelIn(List<String> values) {
            addCriterion("sparewheel in", values, "sparewheel");
            return (Criteria) this;
        }

        public Criteria andSparewheelNotIn(List<String> values) {
            addCriterion("sparewheel not in", values, "sparewheel");
            return (Criteria) this;
        }

        public Criteria andSparewheelBetween(String value1, String value2) {
            addCriterion("sparewheel between", value1, value2, "sparewheel");
            return (Criteria) this;
        }

        public Criteria andSparewheelNotBetween(String value1, String value2) {
            addCriterion("sparewheel not between", value1, value2, "sparewheel");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoIsNull() {
            addCriterion("factory_brand_info is null");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoIsNotNull() {
            addCriterion("factory_brand_info is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoEqualTo(String value) {
            addCriterion("factory_brand_info =", value, "factoryBrandInfo");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoNotEqualTo(String value) {
            addCriterion("factory_brand_info <>", value, "factoryBrandInfo");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoGreaterThan(String value) {
            addCriterion("factory_brand_info >", value, "factoryBrandInfo");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoGreaterThanOrEqualTo(String value) {
            addCriterion("factory_brand_info >=", value, "factoryBrandInfo");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoLessThan(String value) {
            addCriterion("factory_brand_info <", value, "factoryBrandInfo");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoLessThanOrEqualTo(String value) {
            addCriterion("factory_brand_info <=", value, "factoryBrandInfo");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoLike(String value) {
            addCriterion("factory_brand_info like", value, "factoryBrandInfo");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoNotLike(String value) {
            addCriterion("factory_brand_info not like", value, "factoryBrandInfo");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoIn(List<String> values) {
            addCriterion("factory_brand_info in", values, "factoryBrandInfo");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoNotIn(List<String> values) {
            addCriterion("factory_brand_info not in", values, "factoryBrandInfo");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoBetween(String value1, String value2) {
            addCriterion("factory_brand_info between", value1, value2, "factoryBrandInfo");
            return (Criteria) this;
        }

        public Criteria andFactoryBrandInfoNotBetween(String value1, String value2) {
            addCriterion("factory_brand_info not between", value1, value2, "factoryBrandInfo");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandIsNull() {
            addCriterion("vin_factory_brand is null");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandIsNotNull() {
            addCriterion("vin_factory_brand is not null");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandEqualTo(String value) {
            addCriterion("vin_factory_brand =", value, "vinFactoryBrand");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandNotEqualTo(String value) {
            addCriterion("vin_factory_brand <>", value, "vinFactoryBrand");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandGreaterThan(String value) {
            addCriterion("vin_factory_brand >", value, "vinFactoryBrand");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandGreaterThanOrEqualTo(String value) {
            addCriterion("vin_factory_brand >=", value, "vinFactoryBrand");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandLessThan(String value) {
            addCriterion("vin_factory_brand <", value, "vinFactoryBrand");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandLessThanOrEqualTo(String value) {
            addCriterion("vin_factory_brand <=", value, "vinFactoryBrand");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandLike(String value) {
            addCriterion("vin_factory_brand like", value, "vinFactoryBrand");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandNotLike(String value) {
            addCriterion("vin_factory_brand not like", value, "vinFactoryBrand");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandIn(List<String> values) {
            addCriterion("vin_factory_brand in", values, "vinFactoryBrand");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandNotIn(List<String> values) {
            addCriterion("vin_factory_brand not in", values, "vinFactoryBrand");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandBetween(String value1, String value2) {
            addCriterion("vin_factory_brand between", value1, value2, "vinFactoryBrand");
            return (Criteria) this;
        }

        public Criteria andVinFactoryBrandNotBetween(String value1, String value2) {
            addCriterion("vin_factory_brand not between", value1, value2, "vinFactoryBrand");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearIsNull() {
            addCriterion("vin_makeyear is null");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearIsNotNull() {
            addCriterion("vin_makeyear is not null");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearEqualTo(String value) {
            addCriterion("vin_makeyear =", value, "vinMakeyear");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearNotEqualTo(String value) {
            addCriterion("vin_makeyear <>", value, "vinMakeyear");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearGreaterThan(String value) {
            addCriterion("vin_makeyear >", value, "vinMakeyear");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearGreaterThanOrEqualTo(String value) {
            addCriterion("vin_makeyear >=", value, "vinMakeyear");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearLessThan(String value) {
            addCriterion("vin_makeyear <", value, "vinMakeyear");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearLessThanOrEqualTo(String value) {
            addCriterion("vin_makeyear <=", value, "vinMakeyear");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearLike(String value) {
            addCriterion("vin_makeyear like", value, "vinMakeyear");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearNotLike(String value) {
            addCriterion("vin_makeyear not like", value, "vinMakeyear");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearIn(List<String> values) {
            addCriterion("vin_makeyear in", values, "vinMakeyear");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearNotIn(List<String> values) {
            addCriterion("vin_makeyear not in", values, "vinMakeyear");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearBetween(String value1, String value2) {
            addCriterion("vin_makeyear between", value1, value2, "vinMakeyear");
            return (Criteria) this;
        }

        public Criteria andVinMakeyearNotBetween(String value1, String value2) {
            addCriterion("vin_makeyear not between", value1, value2, "vinMakeyear");
            return (Criteria) this;
        }

        public Criteria andVinFvsIsNull() {
            addCriterion("vin_fvs is null");
            return (Criteria) this;
        }

        public Criteria andVinFvsIsNotNull() {
            addCriterion("vin_fvs is not null");
            return (Criteria) this;
        }

        public Criteria andVinFvsEqualTo(String value) {
            addCriterion("vin_fvs =", value, "vinFvs");
            return (Criteria) this;
        }

        public Criteria andVinFvsNotEqualTo(String value) {
            addCriterion("vin_fvs <>", value, "vinFvs");
            return (Criteria) this;
        }

        public Criteria andVinFvsGreaterThan(String value) {
            addCriterion("vin_fvs >", value, "vinFvs");
            return (Criteria) this;
        }

        public Criteria andVinFvsGreaterThanOrEqualTo(String value) {
            addCriterion("vin_fvs >=", value, "vinFvs");
            return (Criteria) this;
        }

        public Criteria andVinFvsLessThan(String value) {
            addCriterion("vin_fvs <", value, "vinFvs");
            return (Criteria) this;
        }

        public Criteria andVinFvsLessThanOrEqualTo(String value) {
            addCriterion("vin_fvs <=", value, "vinFvs");
            return (Criteria) this;
        }

        public Criteria andVinFvsLike(String value) {
            addCriterion("vin_fvs like", value, "vinFvs");
            return (Criteria) this;
        }

        public Criteria andVinFvsNotLike(String value) {
            addCriterion("vin_fvs not like", value, "vinFvs");
            return (Criteria) this;
        }

        public Criteria andVinFvsIn(List<String> values) {
            addCriterion("vin_fvs in", values, "vinFvs");
            return (Criteria) this;
        }

        public Criteria andVinFvsNotIn(List<String> values) {
            addCriterion("vin_fvs not in", values, "vinFvs");
            return (Criteria) this;
        }

        public Criteria andVinFvsBetween(String value1, String value2) {
            addCriterion("vin_fvs between", value1, value2, "vinFvs");
            return (Criteria) this;
        }

        public Criteria andVinFvsNotBetween(String value1, String value2) {
            addCriterion("vin_fvs not between", value1, value2, "vinFvs");
            return (Criteria) this;
        }

        public Criteria andPriceLowIsNull() {
            addCriterion("Price_low is null");
            return (Criteria) this;
        }

        public Criteria andPriceLowIsNotNull() {
            addCriterion("Price_low is not null");
            return (Criteria) this;
        }

        public Criteria andPriceLowEqualTo(Double value) {
            addCriterion("Price_low =", value, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowNotEqualTo(Double value) {
            addCriterion("Price_low <>", value, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowGreaterThan(Double value) {
            addCriterion("Price_low >", value, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowGreaterThanOrEqualTo(Double value) {
            addCriterion("Price_low >=", value, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowLessThan(Double value) {
            addCriterion("Price_low <", value, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowLessThanOrEqualTo(Double value) {
            addCriterion("Price_low <=", value, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowIn(List<Double> values) {
            addCriterion("Price_low in", values, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowNotIn(List<Double> values) {
            addCriterion("Price_low not in", values, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowBetween(Double value1, Double value2) {
            addCriterion("Price_low between", value1, value2, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowNotBetween(Double value1, Double value2) {
            addCriterion("Price_low not between", value1, value2, "priceLow");
            return (Criteria) this;
        }

        public Criteria andVinPriceIsNull() {
            addCriterion("vin_price is null");
            return (Criteria) this;
        }

        public Criteria andVinPriceIsNotNull() {
            addCriterion("vin_price is not null");
            return (Criteria) this;
        }

        public Criteria andVinPriceEqualTo(String value) {
            addCriterion("vin_price =", value, "vinPrice");
            return (Criteria) this;
        }

        public Criteria andVinPriceNotEqualTo(String value) {
            addCriterion("vin_price <>", value, "vinPrice");
            return (Criteria) this;
        }

        public Criteria andVinPriceGreaterThan(String value) {
            addCriterion("vin_price >", value, "vinPrice");
            return (Criteria) this;
        }

        public Criteria andVinPriceGreaterThanOrEqualTo(String value) {
            addCriterion("vin_price >=", value, "vinPrice");
            return (Criteria) this;
        }

        public Criteria andVinPriceLessThan(String value) {
            addCriterion("vin_price <", value, "vinPrice");
            return (Criteria) this;
        }

        public Criteria andVinPriceLessThanOrEqualTo(String value) {
            addCriterion("vin_price <=", value, "vinPrice");
            return (Criteria) this;
        }

        public Criteria andVinPriceLike(String value) {
            addCriterion("vin_price like", value, "vinPrice");
            return (Criteria) this;
        }

        public Criteria andVinPriceNotLike(String value) {
            addCriterion("vin_price not like", value, "vinPrice");
            return (Criteria) this;
        }

        public Criteria andVinPriceIn(List<String> values) {
            addCriterion("vin_price in", values, "vinPrice");
            return (Criteria) this;
        }

        public Criteria andVinPriceNotIn(List<String> values) {
            addCriterion("vin_price not in", values, "vinPrice");
            return (Criteria) this;
        }

        public Criteria andVinPriceBetween(String value1, String value2) {
            addCriterion("vin_price between", value1, value2, "vinPrice");
            return (Criteria) this;
        }

        public Criteria andVinPriceNotBetween(String value1, String value2) {
            addCriterion("vin_price not between", value1, value2, "vinPrice");
            return (Criteria) this;
        }

        public Criteria andVinConfigIsNull() {
            addCriterion("vin_config is null");
            return (Criteria) this;
        }

        public Criteria andVinConfigIsNotNull() {
            addCriterion("vin_config is not null");
            return (Criteria) this;
        }

        public Criteria andVinConfigEqualTo(String value) {
            addCriterion("vin_config =", value, "vinConfig");
            return (Criteria) this;
        }

        public Criteria andVinConfigNotEqualTo(String value) {
            addCriterion("vin_config <>", value, "vinConfig");
            return (Criteria) this;
        }

        public Criteria andVinConfigGreaterThan(String value) {
            addCriterion("vin_config >", value, "vinConfig");
            return (Criteria) this;
        }

        public Criteria andVinConfigGreaterThanOrEqualTo(String value) {
            addCriterion("vin_config >=", value, "vinConfig");
            return (Criteria) this;
        }

        public Criteria andVinConfigLessThan(String value) {
            addCriterion("vin_config <", value, "vinConfig");
            return (Criteria) this;
        }

        public Criteria andVinConfigLessThanOrEqualTo(String value) {
            addCriterion("vin_config <=", value, "vinConfig");
            return (Criteria) this;
        }

        public Criteria andVinConfigLike(String value) {
            addCriterion("vin_config like", value, "vinConfig");
            return (Criteria) this;
        }

        public Criteria andVinConfigNotLike(String value) {
            addCriterion("vin_config not like", value, "vinConfig");
            return (Criteria) this;
        }

        public Criteria andVinConfigIn(List<String> values) {
            addCriterion("vin_config in", values, "vinConfig");
            return (Criteria) this;
        }

        public Criteria andVinConfigNotIn(List<String> values) {
            addCriterion("vin_config not in", values, "vinConfig");
            return (Criteria) this;
        }

        public Criteria andVinConfigBetween(String value1, String value2) {
            addCriterion("vin_config between", value1, value2, "vinConfig");
            return (Criteria) this;
        }

        public Criteria andVinConfigNotBetween(String value1, String value2) {
            addCriterion("vin_config not between", value1, value2, "vinConfig");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigIsNull() {
            addCriterion("vin_otherconfig is null");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigIsNotNull() {
            addCriterion("vin_otherconfig is not null");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigEqualTo(String value) {
            addCriterion("vin_otherconfig =", value, "vinOtherconfig");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigNotEqualTo(String value) {
            addCriterion("vin_otherconfig <>", value, "vinOtherconfig");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigGreaterThan(String value) {
            addCriterion("vin_otherconfig >", value, "vinOtherconfig");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigGreaterThanOrEqualTo(String value) {
            addCriterion("vin_otherconfig >=", value, "vinOtherconfig");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigLessThan(String value) {
            addCriterion("vin_otherconfig <", value, "vinOtherconfig");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigLessThanOrEqualTo(String value) {
            addCriterion("vin_otherconfig <=", value, "vinOtherconfig");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigLike(String value) {
            addCriterion("vin_otherconfig like", value, "vinOtherconfig");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigNotLike(String value) {
            addCriterion("vin_otherconfig not like", value, "vinOtherconfig");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigIn(List<String> values) {
            addCriterion("vin_otherconfig in", values, "vinOtherconfig");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigNotIn(List<String> values) {
            addCriterion("vin_otherconfig not in", values, "vinOtherconfig");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigBetween(String value1, String value2) {
            addCriterion("vin_otherconfig between", value1, value2, "vinOtherconfig");
            return (Criteria) this;
        }

        public Criteria andVinOtherconfigNotBetween(String value1, String value2) {
            addCriterion("vin_otherconfig not between", value1, value2, "vinOtherconfig");
            return (Criteria) this;
        }

        public Criteria andCarSourceIsNull() {
            addCriterion("car_source is null");
            return (Criteria) this;
        }

        public Criteria andCarSourceIsNotNull() {
            addCriterion("car_source is not null");
            return (Criteria) this;
        }

        public Criteria andCarSourceEqualTo(String value) {
            addCriterion("car_source =", value, "carSource");
            return (Criteria) this;
        }

        public Criteria andCarSourceNotEqualTo(String value) {
            addCriterion("car_source <>", value, "carSource");
            return (Criteria) this;
        }

        public Criteria andCarSourceGreaterThan(String value) {
            addCriterion("car_source >", value, "carSource");
            return (Criteria) this;
        }

        public Criteria andCarSourceGreaterThanOrEqualTo(String value) {
            addCriterion("car_source >=", value, "carSource");
            return (Criteria) this;
        }

        public Criteria andCarSourceLessThan(String value) {
            addCriterion("car_source <", value, "carSource");
            return (Criteria) this;
        }

        public Criteria andCarSourceLessThanOrEqualTo(String value) {
            addCriterion("car_source <=", value, "carSource");
            return (Criteria) this;
        }

        public Criteria andCarSourceLike(String value) {
            addCriterion("car_source like", value, "carSource");
            return (Criteria) this;
        }

        public Criteria andCarSourceNotLike(String value) {
            addCriterion("car_source not like", value, "carSource");
            return (Criteria) this;
        }

        public Criteria andCarSourceIn(List<String> values) {
            addCriterion("car_source in", values, "carSource");
            return (Criteria) this;
        }

        public Criteria andCarSourceNotIn(List<String> values) {
            addCriterion("car_source not in", values, "carSource");
            return (Criteria) this;
        }

        public Criteria andCarSourceBetween(String value1, String value2) {
            addCriterion("car_source between", value1, value2, "carSource");
            return (Criteria) this;
        }

        public Criteria andCarSourceNotBetween(String value1, String value2) {
            addCriterion("car_source not between", value1, value2, "carSource");
            return (Criteria) this;
        }

        public Criteria andSourceidIsNull() {
            addCriterion("sourceid is null");
            return (Criteria) this;
        }

        public Criteria andSourceidIsNotNull() {
            addCriterion("sourceid is not null");
            return (Criteria) this;
        }

        public Criteria andSourceidEqualTo(String value) {
            addCriterion("sourceid =", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidNotEqualTo(String value) {
            addCriterion("sourceid <>", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidGreaterThan(String value) {
            addCriterion("sourceid >", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidGreaterThanOrEqualTo(String value) {
            addCriterion("sourceid >=", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidLessThan(String value) {
            addCriterion("sourceid <", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidLessThanOrEqualTo(String value) {
            addCriterion("sourceid <=", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidLike(String value) {
            addCriterion("sourceid like", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidNotLike(String value) {
            addCriterion("sourceid not like", value, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidIn(List<String> values) {
            addCriterion("sourceid in", values, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidNotIn(List<String> values) {
            addCriterion("sourceid not in", values, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidBetween(String value1, String value2) {
            addCriterion("sourceid between", value1, value2, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourceidNotBetween(String value1, String value2) {
            addCriterion("sourceid not between", value1, value2, "sourceid");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidIsNull() {
            addCriterion("sourcefactoryid is null");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidIsNotNull() {
            addCriterion("sourcefactoryid is not null");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidEqualTo(String value) {
            addCriterion("sourcefactoryid =", value, "sourcefactoryid");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidNotEqualTo(String value) {
            addCriterion("sourcefactoryid <>", value, "sourcefactoryid");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidGreaterThan(String value) {
            addCriterion("sourcefactoryid >", value, "sourcefactoryid");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidGreaterThanOrEqualTo(String value) {
            addCriterion("sourcefactoryid >=", value, "sourcefactoryid");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidLessThan(String value) {
            addCriterion("sourcefactoryid <", value, "sourcefactoryid");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidLessThanOrEqualTo(String value) {
            addCriterion("sourcefactoryid <=", value, "sourcefactoryid");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidLike(String value) {
            addCriterion("sourcefactoryid like", value, "sourcefactoryid");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidNotLike(String value) {
            addCriterion("sourcefactoryid not like", value, "sourcefactoryid");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidIn(List<String> values) {
            addCriterion("sourcefactoryid in", values, "sourcefactoryid");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidNotIn(List<String> values) {
            addCriterion("sourcefactoryid not in", values, "sourcefactoryid");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidBetween(String value1, String value2) {
            addCriterion("sourcefactoryid between", value1, value2, "sourcefactoryid");
            return (Criteria) this;
        }

        public Criteria andSourcefactoryidNotBetween(String value1, String value2) {
            addCriterion("sourcefactoryid not between", value1, value2, "sourcefactoryid");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidIsNull() {
            addCriterion("sourcebrandid is null");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidIsNotNull() {
            addCriterion("sourcebrandid is not null");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidEqualTo(String value) {
            addCriterion("sourcebrandid =", value, "sourcebrandid");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidNotEqualTo(String value) {
            addCriterion("sourcebrandid <>", value, "sourcebrandid");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidGreaterThan(String value) {
            addCriterion("sourcebrandid >", value, "sourcebrandid");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidGreaterThanOrEqualTo(String value) {
            addCriterion("sourcebrandid >=", value, "sourcebrandid");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidLessThan(String value) {
            addCriterion("sourcebrandid <", value, "sourcebrandid");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidLessThanOrEqualTo(String value) {
            addCriterion("sourcebrandid <=", value, "sourcebrandid");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidLike(String value) {
            addCriterion("sourcebrandid like", value, "sourcebrandid");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidNotLike(String value) {
            addCriterion("sourcebrandid not like", value, "sourcebrandid");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidIn(List<String> values) {
            addCriterion("sourcebrandid in", values, "sourcebrandid");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidNotIn(List<String> values) {
            addCriterion("sourcebrandid not in", values, "sourcebrandid");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidBetween(String value1, String value2) {
            addCriterion("sourcebrandid between", value1, value2, "sourcebrandid");
            return (Criteria) this;
        }

        public Criteria andSourcebrandidNotBetween(String value1, String value2) {
            addCriterion("sourcebrandid not between", value1, value2, "sourcebrandid");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidIsNull() {
            addCriterion("sourcefamilyid is null");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidIsNotNull() {
            addCriterion("sourcefamilyid is not null");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidEqualTo(String value) {
            addCriterion("sourcefamilyid =", value, "sourcefamilyid");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidNotEqualTo(String value) {
            addCriterion("sourcefamilyid <>", value, "sourcefamilyid");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidGreaterThan(String value) {
            addCriterion("sourcefamilyid >", value, "sourcefamilyid");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidGreaterThanOrEqualTo(String value) {
            addCriterion("sourcefamilyid >=", value, "sourcefamilyid");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidLessThan(String value) {
            addCriterion("sourcefamilyid <", value, "sourcefamilyid");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidLessThanOrEqualTo(String value) {
            addCriterion("sourcefamilyid <=", value, "sourcefamilyid");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidLike(String value) {
            addCriterion("sourcefamilyid like", value, "sourcefamilyid");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidNotLike(String value) {
            addCriterion("sourcefamilyid not like", value, "sourcefamilyid");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidIn(List<String> values) {
            addCriterion("sourcefamilyid in", values, "sourcefamilyid");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidNotIn(List<String> values) {
            addCriterion("sourcefamilyid not in", values, "sourcefamilyid");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidBetween(String value1, String value2) {
            addCriterion("sourcefamilyid between", value1, value2, "sourcefamilyid");
            return (Criteria) this;
        }

        public Criteria andSourcefamilyidNotBetween(String value1, String value2) {
            addCriterion("sourcefamilyid not between", value1, value2, "sourcefamilyid");
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