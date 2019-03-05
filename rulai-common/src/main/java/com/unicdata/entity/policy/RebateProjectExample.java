package com.unicdata.entity.policy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RebateProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RebateProjectExample() {
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

        public Criteria andRebateCodeIsNull() {
            addCriterion("rebate_code is null");
            return (Criteria) this;
        }

        public Criteria andRebateCodeIsNotNull() {
            addCriterion("rebate_code is not null");
            return (Criteria) this;
        }

        public Criteria andRebateCodeEqualTo(String value) {
            addCriterion("rebate_code =", value, "rebateCode");
            return (Criteria) this;
        }

        public Criteria andRebateCodeNotEqualTo(String value) {
            addCriterion("rebate_code <>", value, "rebateCode");
            return (Criteria) this;
        }

        public Criteria andRebateCodeGreaterThan(String value) {
            addCriterion("rebate_code >", value, "rebateCode");
            return (Criteria) this;
        }

        public Criteria andRebateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("rebate_code >=", value, "rebateCode");
            return (Criteria) this;
        }

        public Criteria andRebateCodeLessThan(String value) {
            addCriterion("rebate_code <", value, "rebateCode");
            return (Criteria) this;
        }

        public Criteria andRebateCodeLessThanOrEqualTo(String value) {
            addCriterion("rebate_code <=", value, "rebateCode");
            return (Criteria) this;
        }

        public Criteria andRebateCodeLike(String value) {
            addCriterion("rebate_code like", value, "rebateCode");
            return (Criteria) this;
        }

        public Criteria andRebateCodeNotLike(String value) {
            addCriterion("rebate_code not like", value, "rebateCode");
            return (Criteria) this;
        }

        public Criteria andRebateCodeIn(List<String> values) {
            addCriterion("rebate_code in", values, "rebateCode");
            return (Criteria) this;
        }

        public Criteria andRebateCodeNotIn(List<String> values) {
            addCriterion("rebate_code not in", values, "rebateCode");
            return (Criteria) this;
        }

        public Criteria andRebateCodeBetween(String value1, String value2) {
            addCriterion("rebate_code between", value1, value2, "rebateCode");
            return (Criteria) this;
        }

        public Criteria andRebateCodeNotBetween(String value1, String value2) {
            addCriterion("rebate_code not between", value1, value2, "rebateCode");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIsNull() {
            addCriterion("policy_id is null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIsNotNull() {
            addCriterion("policy_id is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdEqualTo(Integer value) {
            addCriterion("policy_id =", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotEqualTo(Integer value) {
            addCriterion("policy_id <>", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThan(Integer value) {
            addCriterion("policy_id >", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("policy_id >=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThan(Integer value) {
            addCriterion("policy_id <", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThanOrEqualTo(Integer value) {
            addCriterion("policy_id <=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIn(List<Integer> values) {
            addCriterion("policy_id in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotIn(List<Integer> values) {
            addCriterion("policy_id not in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdBetween(Integer value1, Integer value2) {
            addCriterion("policy_id between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("policy_id not between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andRebateNameIsNull() {
            addCriterion("rebate_name is null");
            return (Criteria) this;
        }

        public Criteria andRebateNameIsNotNull() {
            addCriterion("rebate_name is not null");
            return (Criteria) this;
        }

        public Criteria andRebateNameEqualTo(String value) {
            addCriterion("rebate_name =", value, "rebateName");
            return (Criteria) this;
        }

        public Criteria andRebateNameNotEqualTo(String value) {
            addCriterion("rebate_name <>", value, "rebateName");
            return (Criteria) this;
        }

        public Criteria andRebateNameGreaterThan(String value) {
            addCriterion("rebate_name >", value, "rebateName");
            return (Criteria) this;
        }

        public Criteria andRebateNameGreaterThanOrEqualTo(String value) {
            addCriterion("rebate_name >=", value, "rebateName");
            return (Criteria) this;
        }

        public Criteria andRebateNameLessThan(String value) {
            addCriterion("rebate_name <", value, "rebateName");
            return (Criteria) this;
        }

        public Criteria andRebateNameLessThanOrEqualTo(String value) {
            addCriterion("rebate_name <=", value, "rebateName");
            return (Criteria) this;
        }

        public Criteria andRebateNameLike(String value) {
            addCriterion("rebate_name like", value, "rebateName");
            return (Criteria) this;
        }

        public Criteria andRebateNameNotLike(String value) {
            addCriterion("rebate_name not like", value, "rebateName");
            return (Criteria) this;
        }

        public Criteria andRebateNameIn(List<String> values) {
            addCriterion("rebate_name in", values, "rebateName");
            return (Criteria) this;
        }

        public Criteria andRebateNameNotIn(List<String> values) {
            addCriterion("rebate_name not in", values, "rebateName");
            return (Criteria) this;
        }

        public Criteria andRebateNameBetween(String value1, String value2) {
            addCriterion("rebate_name between", value1, value2, "rebateName");
            return (Criteria) this;
        }

        public Criteria andRebateNameNotBetween(String value1, String value2) {
            addCriterion("rebate_name not between", value1, value2, "rebateName");
            return (Criteria) this;
        }

        public Criteria andRebateProjectTypeIsNull() {
            addCriterion("rebate_project_type is null");
            return (Criteria) this;
        }

        public Criteria andRebateProjectTypeIsNotNull() {
            addCriterion("rebate_project_type is not null");
            return (Criteria) this;
        }

        public Criteria andRebateProjectTypeEqualTo(Byte value) {
            addCriterion("rebate_project_type =", value, "rebateProjectType");
            return (Criteria) this;
        }

        public Criteria andRebateProjectTypeNotEqualTo(Byte value) {
            addCriterion("rebate_project_type <>", value, "rebateProjectType");
            return (Criteria) this;
        }

        public Criteria andRebateProjectTypeGreaterThan(Byte value) {
            addCriterion("rebate_project_type >", value, "rebateProjectType");
            return (Criteria) this;
        }

        public Criteria andRebateProjectTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("rebate_project_type >=", value, "rebateProjectType");
            return (Criteria) this;
        }

        public Criteria andRebateProjectTypeLessThan(Byte value) {
            addCriterion("rebate_project_type <", value, "rebateProjectType");
            return (Criteria) this;
        }

        public Criteria andRebateProjectTypeLessThanOrEqualTo(Byte value) {
            addCriterion("rebate_project_type <=", value, "rebateProjectType");
            return (Criteria) this;
        }

        public Criteria andRebateProjectTypeIn(List<Byte> values) {
            addCriterion("rebate_project_type in", values, "rebateProjectType");
            return (Criteria) this;
        }

        public Criteria andRebateProjectTypeNotIn(List<Byte> values) {
            addCriterion("rebate_project_type not in", values, "rebateProjectType");
            return (Criteria) this;
        }

        public Criteria andRebateProjectTypeBetween(Byte value1, Byte value2) {
            addCriterion("rebate_project_type between", value1, value2, "rebateProjectType");
            return (Criteria) this;
        }

        public Criteria andRebateProjectTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("rebate_project_type not between", value1, value2, "rebateProjectType");
            return (Criteria) this;
        }

        public Criteria andReportMaterialRequirementsIsNull() {
            addCriterion("report_material_requirements is null");
            return (Criteria) this;
        }

        public Criteria andReportMaterialRequirementsIsNotNull() {
            addCriterion("report_material_requirements is not null");
            return (Criteria) this;
        }

        public Criteria andReportMaterialRequirementsEqualTo(Byte value) {
            addCriterion("report_material_requirements =", value, "reportMaterialRequirements");
            return (Criteria) this;
        }

        public Criteria andReportMaterialRequirementsNotEqualTo(Byte value) {
            addCriterion("report_material_requirements <>", value, "reportMaterialRequirements");
            return (Criteria) this;
        }

        public Criteria andReportMaterialRequirementsGreaterThan(Byte value) {
            addCriterion("report_material_requirements >", value, "reportMaterialRequirements");
            return (Criteria) this;
        }

        public Criteria andReportMaterialRequirementsGreaterThanOrEqualTo(Byte value) {
            addCriterion("report_material_requirements >=", value, "reportMaterialRequirements");
            return (Criteria) this;
        }

        public Criteria andReportMaterialRequirementsLessThan(Byte value) {
            addCriterion("report_material_requirements <", value, "reportMaterialRequirements");
            return (Criteria) this;
        }

        public Criteria andReportMaterialRequirementsLessThanOrEqualTo(Byte value) {
            addCriterion("report_material_requirements <=", value, "reportMaterialRequirements");
            return (Criteria) this;
        }

        public Criteria andReportMaterialRequirementsIn(List<Byte> values) {
            addCriterion("report_material_requirements in", values, "reportMaterialRequirements");
            return (Criteria) this;
        }

        public Criteria andReportMaterialRequirementsNotIn(List<Byte> values) {
            addCriterion("report_material_requirements not in", values, "reportMaterialRequirements");
            return (Criteria) this;
        }

        public Criteria andReportMaterialRequirementsBetween(Byte value1, Byte value2) {
            addCriterion("report_material_requirements between", value1, value2, "reportMaterialRequirements");
            return (Criteria) this;
        }

        public Criteria andReportMaterialRequirementsNotBetween(Byte value1, Byte value2) {
            addCriterion("report_material_requirements not between", value1, value2, "reportMaterialRequirements");
            return (Criteria) this;
        }

        public Criteria andRebateStartDateIsNull() {
            addCriterion("rebate_start_date is null");
            return (Criteria) this;
        }

        public Criteria andRebateStartDateIsNotNull() {
            addCriterion("rebate_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andRebateStartDateEqualTo(Date value) {
            addCriterion("rebate_start_date =", value, "rebateStartDate");
            return (Criteria) this;
        }

        public Criteria andRebateStartDateNotEqualTo(Date value) {
            addCriterion("rebate_start_date <>", value, "rebateStartDate");
            return (Criteria) this;
        }

        public Criteria andRebateStartDateGreaterThan(Date value) {
            addCriterion("rebate_start_date >", value, "rebateStartDate");
            return (Criteria) this;
        }

        public Criteria andRebateStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("rebate_start_date >=", value, "rebateStartDate");
            return (Criteria) this;
        }

        public Criteria andRebateStartDateLessThan(Date value) {
            addCriterion("rebate_start_date <", value, "rebateStartDate");
            return (Criteria) this;
        }

        public Criteria andRebateStartDateLessThanOrEqualTo(Date value) {
            addCriterion("rebate_start_date <=", value, "rebateStartDate");
            return (Criteria) this;
        }

        public Criteria andRebateStartDateIn(List<Date> values) {
            addCriterion("rebate_start_date in", values, "rebateStartDate");
            return (Criteria) this;
        }

        public Criteria andRebateStartDateNotIn(List<Date> values) {
            addCriterion("rebate_start_date not in", values, "rebateStartDate");
            return (Criteria) this;
        }

        public Criteria andRebateStartDateBetween(Date value1, Date value2) {
            addCriterion("rebate_start_date between", value1, value2, "rebateStartDate");
            return (Criteria) this;
        }

        public Criteria andRebateStartDateNotBetween(Date value1, Date value2) {
            addCriterion("rebate_start_date not between", value1, value2, "rebateStartDate");
            return (Criteria) this;
        }

        public Criteria andRebateEndDateIsNull() {
            addCriterion("rebate_end_date is null");
            return (Criteria) this;
        }

        public Criteria andRebateEndDateIsNotNull() {
            addCriterion("rebate_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andRebateEndDateEqualTo(Date value) {
            addCriterion("rebate_end_date =", value, "rebateEndDate");
            return (Criteria) this;
        }

        public Criteria andRebateEndDateNotEqualTo(Date value) {
            addCriterion("rebate_end_date <>", value, "rebateEndDate");
            return (Criteria) this;
        }

        public Criteria andRebateEndDateGreaterThan(Date value) {
            addCriterion("rebate_end_date >", value, "rebateEndDate");
            return (Criteria) this;
        }

        public Criteria andRebateEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("rebate_end_date >=", value, "rebateEndDate");
            return (Criteria) this;
        }

        public Criteria andRebateEndDateLessThan(Date value) {
            addCriterion("rebate_end_date <", value, "rebateEndDate");
            return (Criteria) this;
        }

        public Criteria andRebateEndDateLessThanOrEqualTo(Date value) {
            addCriterion("rebate_end_date <=", value, "rebateEndDate");
            return (Criteria) this;
        }

        public Criteria andRebateEndDateIn(List<Date> values) {
            addCriterion("rebate_end_date in", values, "rebateEndDate");
            return (Criteria) this;
        }

        public Criteria andRebateEndDateNotIn(List<Date> values) {
            addCriterion("rebate_end_date not in", values, "rebateEndDate");
            return (Criteria) this;
        }

        public Criteria andRebateEndDateBetween(Date value1, Date value2) {
            addCriterion("rebate_end_date between", value1, value2, "rebateEndDate");
            return (Criteria) this;
        }

        public Criteria andRebateEndDateNotBetween(Date value1, Date value2) {
            addCriterion("rebate_end_date not between", value1, value2, "rebateEndDate");
            return (Criteria) this;
        }

        public Criteria andRebateTypeIsNull() {
            addCriterion("rebate_type is null");
            return (Criteria) this;
        }

        public Criteria andRebateTypeIsNotNull() {
            addCriterion("rebate_type is not null");
            return (Criteria) this;
        }

        public Criteria andRebateTypeEqualTo(Byte value) {
            addCriterion("rebate_type =", value, "rebateType");
            return (Criteria) this;
        }

        public Criteria andRebateTypeNotEqualTo(Byte value) {
            addCriterion("rebate_type <>", value, "rebateType");
            return (Criteria) this;
        }

        public Criteria andRebateTypeGreaterThan(Byte value) {
            addCriterion("rebate_type >", value, "rebateType");
            return (Criteria) this;
        }

        public Criteria andRebateTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("rebate_type >=", value, "rebateType");
            return (Criteria) this;
        }

        public Criteria andRebateTypeLessThan(Byte value) {
            addCriterion("rebate_type <", value, "rebateType");
            return (Criteria) this;
        }

        public Criteria andRebateTypeLessThanOrEqualTo(Byte value) {
            addCriterion("rebate_type <=", value, "rebateType");
            return (Criteria) this;
        }

        public Criteria andRebateTypeIn(List<Byte> values) {
            addCriterion("rebate_type in", values, "rebateType");
            return (Criteria) this;
        }

        public Criteria andRebateTypeNotIn(List<Byte> values) {
            addCriterion("rebate_type not in", values, "rebateType");
            return (Criteria) this;
        }

        public Criteria andRebateTypeBetween(Byte value1, Byte value2) {
            addCriterion("rebate_type between", value1, value2, "rebateType");
            return (Criteria) this;
        }

        public Criteria andRebateTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("rebate_type not between", value1, value2, "rebateType");
            return (Criteria) this;
        }

        public Criteria andRebateTypeValueIsNull() {
            addCriterion("rebate_type_value is null");
            return (Criteria) this;
        }

        public Criteria andRebateTypeValueIsNotNull() {
            addCriterion("rebate_type_value is not null");
            return (Criteria) this;
        }

        public Criteria andRebateTypeValueEqualTo(BigDecimal value) {
            addCriterion("rebate_type_value =", value, "rebateTypeValue");
            return (Criteria) this;
        }

        public Criteria andRebateTypeValueNotEqualTo(BigDecimal value) {
            addCriterion("rebate_type_value <>", value, "rebateTypeValue");
            return (Criteria) this;
        }

        public Criteria andRebateTypeValueGreaterThan(BigDecimal value) {
            addCriterion("rebate_type_value >", value, "rebateTypeValue");
            return (Criteria) this;
        }

        public Criteria andRebateTypeValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rebate_type_value >=", value, "rebateTypeValue");
            return (Criteria) this;
        }

        public Criteria andRebateTypeValueLessThan(BigDecimal value) {
            addCriterion("rebate_type_value <", value, "rebateTypeValue");
            return (Criteria) this;
        }

        public Criteria andRebateTypeValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rebate_type_value <=", value, "rebateTypeValue");
            return (Criteria) this;
        }

        public Criteria andRebateTypeValueIn(List<BigDecimal> values) {
            addCriterion("rebate_type_value in", values, "rebateTypeValue");
            return (Criteria) this;
        }

        public Criteria andRebateTypeValueNotIn(List<BigDecimal> values) {
            addCriterion("rebate_type_value not in", values, "rebateTypeValue");
            return (Criteria) this;
        }

        public Criteria andRebateTypeValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rebate_type_value between", value1, value2, "rebateTypeValue");
            return (Criteria) this;
        }

        public Criteria andRebateTypeValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rebate_type_value not between", value1, value2, "rebateTypeValue");
            return (Criteria) this;
        }

        public Criteria andRebateNumberIsNull() {
            addCriterion("rebate_number is null");
            return (Criteria) this;
        }

        public Criteria andRebateNumberIsNotNull() {
            addCriterion("rebate_number is not null");
            return (Criteria) this;
        }

        public Criteria andRebateNumberEqualTo(Integer value) {
            addCriterion("rebate_number =", value, "rebateNumber");
            return (Criteria) this;
        }

        public Criteria andRebateNumberNotEqualTo(Integer value) {
            addCriterion("rebate_number <>", value, "rebateNumber");
            return (Criteria) this;
        }

        public Criteria andRebateNumberGreaterThan(Integer value) {
            addCriterion("rebate_number >", value, "rebateNumber");
            return (Criteria) this;
        }

        public Criteria andRebateNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("rebate_number >=", value, "rebateNumber");
            return (Criteria) this;
        }

        public Criteria andRebateNumberLessThan(Integer value) {
            addCriterion("rebate_number <", value, "rebateNumber");
            return (Criteria) this;
        }

        public Criteria andRebateNumberLessThanOrEqualTo(Integer value) {
            addCriterion("rebate_number <=", value, "rebateNumber");
            return (Criteria) this;
        }

        public Criteria andRebateNumberIn(List<Integer> values) {
            addCriterion("rebate_number in", values, "rebateNumber");
            return (Criteria) this;
        }

        public Criteria andRebateNumberNotIn(List<Integer> values) {
            addCriterion("rebate_number not in", values, "rebateNumber");
            return (Criteria) this;
        }

        public Criteria andRebateNumberBetween(Integer value1, Integer value2) {
            addCriterion("rebate_number between", value1, value2, "rebateNumber");
            return (Criteria) this;
        }

        public Criteria andRebateNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("rebate_number not between", value1, value2, "rebateNumber");
            return (Criteria) this;
        }

        public Criteria andRebateStandardNumberIsNull() {
            addCriterion("rebate_standard_number is null");
            return (Criteria) this;
        }

        public Criteria andRebateStandardNumberIsNotNull() {
            addCriterion("rebate_standard_number is not null");
            return (Criteria) this;
        }

        public Criteria andRebateStandardNumberEqualTo(Integer value) {
            addCriterion("rebate_standard_number =", value, "rebateStandardNumber");
            return (Criteria) this;
        }

        public Criteria andRebateStandardNumberNotEqualTo(Integer value) {
            addCriterion("rebate_standard_number <>", value, "rebateStandardNumber");
            return (Criteria) this;
        }

        public Criteria andRebateStandardNumberGreaterThan(Integer value) {
            addCriterion("rebate_standard_number >", value, "rebateStandardNumber");
            return (Criteria) this;
        }

        public Criteria andRebateStandardNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("rebate_standard_number >=", value, "rebateStandardNumber");
            return (Criteria) this;
        }

        public Criteria andRebateStandardNumberLessThan(Integer value) {
            addCriterion("rebate_standard_number <", value, "rebateStandardNumber");
            return (Criteria) this;
        }

        public Criteria andRebateStandardNumberLessThanOrEqualTo(Integer value) {
            addCriterion("rebate_standard_number <=", value, "rebateStandardNumber");
            return (Criteria) this;
        }

        public Criteria andRebateStandardNumberIn(List<Integer> values) {
            addCriterion("rebate_standard_number in", values, "rebateStandardNumber");
            return (Criteria) this;
        }

        public Criteria andRebateStandardNumberNotIn(List<Integer> values) {
            addCriterion("rebate_standard_number not in", values, "rebateStandardNumber");
            return (Criteria) this;
        }

        public Criteria andRebateStandardNumberBetween(Integer value1, Integer value2) {
            addCriterion("rebate_standard_number between", value1, value2, "rebateStandardNumber");
            return (Criteria) this;
        }

        public Criteria andRebateStandardNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("rebate_standard_number not between", value1, value2, "rebateStandardNumber");
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

        public Criteria andFirstEstimateTotalIsNull() {
            addCriterion("first_estimate_total is null");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateTotalIsNotNull() {
            addCriterion("first_estimate_total is not null");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateTotalEqualTo(BigDecimal value) {
            addCriterion("first_estimate_total =", value, "firstEstimateTotal");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateTotalNotEqualTo(BigDecimal value) {
            addCriterion("first_estimate_total <>", value, "firstEstimateTotal");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateTotalGreaterThan(BigDecimal value) {
            addCriterion("first_estimate_total >", value, "firstEstimateTotal");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_estimate_total >=", value, "firstEstimateTotal");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateTotalLessThan(BigDecimal value) {
            addCriterion("first_estimate_total <", value, "firstEstimateTotal");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_estimate_total <=", value, "firstEstimateTotal");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateTotalIn(List<BigDecimal> values) {
            addCriterion("first_estimate_total in", values, "firstEstimateTotal");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateTotalNotIn(List<BigDecimal> values) {
            addCriterion("first_estimate_total not in", values, "firstEstimateTotal");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_estimate_total between", value1, value2, "firstEstimateTotal");
            return (Criteria) this;
        }

        public Criteria andFirstEstimateTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_estimate_total not between", value1, value2, "firstEstimateTotal");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustTotalIsNull() {
            addCriterion("estimate_adjust_total is null");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustTotalIsNotNull() {
            addCriterion("estimate_adjust_total is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustTotalEqualTo(BigDecimal value) {
            addCriterion("estimate_adjust_total =", value, "estimateAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustTotalNotEqualTo(BigDecimal value) {
            addCriterion("estimate_adjust_total <>", value, "estimateAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustTotalGreaterThan(BigDecimal value) {
            addCriterion("estimate_adjust_total >", value, "estimateAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("estimate_adjust_total >=", value, "estimateAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustTotalLessThan(BigDecimal value) {
            addCriterion("estimate_adjust_total <", value, "estimateAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("estimate_adjust_total <=", value, "estimateAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustTotalIn(List<BigDecimal> values) {
            addCriterion("estimate_adjust_total in", values, "estimateAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustTotalNotIn(List<BigDecimal> values) {
            addCriterion("estimate_adjust_total not in", values, "estimateAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("estimate_adjust_total between", value1, value2, "estimateAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andEstimateAdjustTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("estimate_adjust_total not between", value1, value2, "estimateAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionTotalIsNull() {
            addCriterion("plan_extraction_total is null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionTotalIsNotNull() {
            addCriterion("plan_extraction_total is not null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionTotalEqualTo(BigDecimal value) {
            addCriterion("plan_extraction_total =", value, "planExtractionTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionTotalNotEqualTo(BigDecimal value) {
            addCriterion("plan_extraction_total <>", value, "planExtractionTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionTotalGreaterThan(BigDecimal value) {
            addCriterion("plan_extraction_total >", value, "planExtractionTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_extraction_total >=", value, "planExtractionTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionTotalLessThan(BigDecimal value) {
            addCriterion("plan_extraction_total <", value, "planExtractionTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_extraction_total <=", value, "planExtractionTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionTotalIn(List<BigDecimal> values) {
            addCriterion("plan_extraction_total in", values, "planExtractionTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionTotalNotIn(List<BigDecimal> values) {
            addCriterion("plan_extraction_total not in", values, "planExtractionTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_extraction_total between", value1, value2, "planExtractionTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_extraction_total not between", value1, value2, "planExtractionTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustTotalIsNull() {
            addCriterion("plan_extraction_adjust_total is null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustTotalIsNotNull() {
            addCriterion("plan_extraction_adjust_total is not null");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustTotalEqualTo(BigDecimal value) {
            addCriterion("plan_extraction_adjust_total =", value, "planExtractionAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustTotalNotEqualTo(BigDecimal value) {
            addCriterion("plan_extraction_adjust_total <>", value, "planExtractionAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustTotalGreaterThan(BigDecimal value) {
            addCriterion("plan_extraction_adjust_total >", value, "planExtractionAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_extraction_adjust_total >=", value, "planExtractionAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustTotalLessThan(BigDecimal value) {
            addCriterion("plan_extraction_adjust_total <", value, "planExtractionAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_extraction_adjust_total <=", value, "planExtractionAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustTotalIn(List<BigDecimal> values) {
            addCriterion("plan_extraction_adjust_total in", values, "planExtractionAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustTotalNotIn(List<BigDecimal> values) {
            addCriterion("plan_extraction_adjust_total not in", values, "planExtractionAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_extraction_adjust_total between", value1, value2, "planExtractionAdjustTotal");
            return (Criteria) this;
        }

        public Criteria andPlanExtractionAdjustTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_extraction_adjust_total not between", value1, value2, "planExtractionAdjustTotal");
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