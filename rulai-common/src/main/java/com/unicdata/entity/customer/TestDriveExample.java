package com.unicdata.entity.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDriveExample {
	protected String orderByClause;
	protected boolean distinct;
	protected List<Criteria> oredCriteria;

	public TestDriveExample() {
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

		public Criteria andCusIdIsNull() {
			addCriterion("cus_id is null");
			return (Criteria) this;
		}

		public Criteria andCusIdIsNotNull() {
			addCriterion("cus_id is not null");
			return (Criteria) this;
		}

		public Criteria andCusIdEqualTo(Integer value) {
			addCriterion("cus_id =", value, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdNotEqualTo(Integer value) {
			addCriterion("cus_id <>", value, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdGreaterThan(Integer value) {
			addCriterion("cus_id >", value, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("cus_id >=", value, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdLessThan(Integer value) {
			addCriterion("cus_id <", value, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdLessThanOrEqualTo(Integer value) {
			addCriterion("cus_id <=", value, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdIn(List<Integer> values) {
			addCriterion("cus_id in", values, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdNotIn(List<Integer> values) {
			addCriterion("cus_id not in", values, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdBetween(Integer value1, Integer value2) {
			addCriterion("cus_id between", value1, value2, "cusId");
			return (Criteria) this;
		}

		public Criteria andCusIdNotBetween(Integer value1, Integer value2) {
			addCriterion("cus_id not between", value1, value2, "cusId");
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

		public Criteria andDriveTimeIsNull() {
			addCriterion("drive_time is null");
			return (Criteria) this;
		}

		public Criteria andDriveTimeIsNotNull() {
			addCriterion("drive_time is not null");
			return (Criteria) this;
		}

		public Criteria andDriveTimeEqualTo(Integer value) {
			addCriterion("drive_time =", value, "driveTime");
			return (Criteria) this;
		}

		public Criteria andDriveTimeNotEqualTo(Integer value) {
			addCriterion("drive_time <>", value, "driveTime");
			return (Criteria) this;
		}

		public Criteria andDriveTimeGreaterThan(Integer value) {
			addCriterion("drive_time >", value, "driveTime");
			return (Criteria) this;
		}

		public Criteria andDriveTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("drive_time >=", value, "driveTime");
			return (Criteria) this;
		}

		public Criteria andDriveTimeLessThan(Integer value) {
			addCriterion("drive_time <", value, "driveTime");
			return (Criteria) this;
		}

		public Criteria andDriveTimeLessThanOrEqualTo(Integer value) {
			addCriterion("drive_time <=", value, "driveTime");
			return (Criteria) this;
		}

		public Criteria andDriveTimeIn(List<Integer> values) {
			addCriterion("drive_time in", values, "driveTime");
			return (Criteria) this;
		}

		public Criteria andDriveTimeNotIn(List<Integer> values) {
			addCriterion("drive_time not in", values, "driveTime");
			return (Criteria) this;
		}

		public Criteria andDriveTimeBetween(Integer value1, Integer value2) {
			addCriterion("drive_time between", value1, value2, "driveTime");
			return (Criteria) this;
		}

		public Criteria andDriveTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("drive_time not between", value1, value2, "driveTime");
			return (Criteria) this;
		}

		public Criteria andPurposeIsNull() {
			addCriterion("purpose is null");
			return (Criteria) this;
		}

		public Criteria andPurposeIsNotNull() {
			addCriterion("purpose is not null");
			return (Criteria) this;
		}

		public Criteria andPurposeEqualTo(String value) {
			addCriterion("purpose =", value, "purpose");
			return (Criteria) this;
		}

		public Criteria andPurposeNotEqualTo(String value) {
			addCriterion("purpose <>", value, "purpose");
			return (Criteria) this;
		}

		public Criteria andPurposeGreaterThan(String value) {
			addCriterion("purpose >", value, "purpose");
			return (Criteria) this;
		}

		public Criteria andPurposeGreaterThanOrEqualTo(String value) {
			addCriterion("purpose >=", value, "purpose");
			return (Criteria) this;
		}

		public Criteria andPurposeLessThan(String value) {
			addCriterion("purpose <", value, "purpose");
			return (Criteria) this;
		}

		public Criteria andPurposeLessThanOrEqualTo(String value) {
			addCriterion("purpose <=", value, "purpose");
			return (Criteria) this;
		}

		public Criteria andPurposeLike(String value) {
			addCriterion("purpose like", value, "purpose");
			return (Criteria) this;
		}

		public Criteria andPurposeNotLike(String value) {
			addCriterion("purpose not like", value, "purpose");
			return (Criteria) this;
		}

		public Criteria andPurposeIn(List<String> values) {
			addCriterion("purpose in", values, "purpose");
			return (Criteria) this;
		}

		public Criteria andPurposeNotIn(List<String> values) {
			addCriterion("purpose not in", values, "purpose");
			return (Criteria) this;
		}

		public Criteria andPurposeBetween(String value1, String value2) {
			addCriterion("purpose between", value1, value2, "purpose");
			return (Criteria) this;
		}

		public Criteria andPurposeNotBetween(String value1, String value2) {
			addCriterion("purpose not between", value1, value2, "purpose");
			return (Criteria) this;
		}

		public Criteria andDriveMileageIsNull() {
			addCriterion("drive_mileage is null");
			return (Criteria) this;
		}

		public Criteria andDriveMileageIsNotNull() {
			addCriterion("drive_mileage is not null");
			return (Criteria) this;
		}

		public Criteria andDriveMileageEqualTo(Integer value) {
			addCriterion("drive_mileage =", value, "driveMileage");
			return (Criteria) this;
		}

		public Criteria andDriveMileageNotEqualTo(Integer value) {
			addCriterion("drive_mileage <>", value, "driveMileage");
			return (Criteria) this;
		}

		public Criteria andDriveMileageGreaterThan(Integer value) {
			addCriterion("drive_mileage >", value, "driveMileage");
			return (Criteria) this;
		}

		public Criteria andDriveMileageGreaterThanOrEqualTo(Integer value) {
			addCriterion("drive_mileage >=", value, "driveMileage");
			return (Criteria) this;
		}

		public Criteria andDriveMileageLessThan(Integer value) {
			addCriterion("drive_mileage <", value, "driveMileage");
			return (Criteria) this;
		}

		public Criteria andDriveMileageLessThanOrEqualTo(Integer value) {
			addCriterion("drive_mileage <=", value, "driveMileage");
			return (Criteria) this;
		}

		public Criteria andDriveMileageIn(List<Integer> values) {
			addCriterion("drive_mileage in", values, "driveMileage");
			return (Criteria) this;
		}

		public Criteria andDriveMileageNotIn(List<Integer> values) {
			addCriterion("drive_mileage not in", values, "driveMileage");
			return (Criteria) this;
		}

		public Criteria andDriveMileageBetween(Integer value1, Integer value2) {
			addCriterion("drive_mileage between", value1, value2, "driveMileage");
			return (Criteria) this;
		}

		public Criteria andDriveMileageNotBetween(Integer value1, Integer value2) {
			addCriterion("drive_mileage not between", value1, value2, "driveMileage");
			return (Criteria) this;
		}

		public Criteria andEndMileageIsNull() {
			addCriterion("end_mileage is null");
			return (Criteria) this;
		}

		public Criteria andEndMileageIsNotNull() {
			addCriterion("end_mileage is not null");
			return (Criteria) this;
		}

		public Criteria andEndMileageEqualTo(Integer value) {
			addCriterion("end_mileage =", value, "endMileage");
			return (Criteria) this;
		}

		public Criteria andEndMileageNotEqualTo(Integer value) {
			addCriterion("end_mileage <>", value, "endMileage");
			return (Criteria) this;
		}

		public Criteria andEndMileageGreaterThan(Integer value) {
			addCriterion("end_mileage >", value, "endMileage");
			return (Criteria) this;
		}

		public Criteria andEndMileageGreaterThanOrEqualTo(Integer value) {
			addCriterion("end_mileage >=", value, "endMileage");
			return (Criteria) this;
		}

		public Criteria andEndMileageLessThan(Integer value) {
			addCriterion("end_mileage <", value, "endMileage");
			return (Criteria) this;
		}

		public Criteria andEndMileageLessThanOrEqualTo(Integer value) {
			addCriterion("end_mileage <=", value, "endMileage");
			return (Criteria) this;
		}

		public Criteria andEndMileageIn(List<Integer> values) {
			addCriterion("end_mileage in", values, "endMileage");
			return (Criteria) this;
		}

		public Criteria andEndMileageNotIn(List<Integer> values) {
			addCriterion("end_mileage not in", values, "endMileage");
			return (Criteria) this;
		}

		public Criteria andEndMileageBetween(Integer value1, Integer value2) {
			addCriterion("end_mileage between", value1, value2, "endMileage");
			return (Criteria) this;
		}

		public Criteria andEndMileageNotBetween(Integer value1, Integer value2) {
			addCriterion("end_mileage not between", value1, value2, "endMileage");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
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

		public Criteria andDriversLicenseIsNull() {
			addCriterion("drivers_license is null");
			return (Criteria) this;
		}

		public Criteria andDriversLicenseIsNotNull() {
			addCriterion("drivers_license is not null");
			return (Criteria) this;
		}

		public Criteria andDriversLicenseEqualTo(String value) {
			addCriterion("drivers_license =", value, "driversLicense");
			return (Criteria) this;
		}

		public Criteria andDriversLicenseNotEqualTo(String value) {
			addCriterion("drivers_license <>", value, "driversLicense");
			return (Criteria) this;
		}

		public Criteria andDriversLicenseGreaterThan(String value) {
			addCriterion("drivers_license >", value, "driversLicense");
			return (Criteria) this;
		}

		public Criteria andDriversLicenseGreaterThanOrEqualTo(String value) {
			addCriterion("drivers_license >=", value, "driversLicense");
			return (Criteria) this;
		}

		public Criteria andDriversLicenseLessThan(String value) {
			addCriterion("drivers_license <", value, "driversLicense");
			return (Criteria) this;
		}

		public Criteria andDriversLicenseLessThanOrEqualTo(String value) {
			addCriterion("drivers_license <=", value, "driversLicense");
			return (Criteria) this;
		}

		public Criteria andDriversLicenseLike(String value) {
			addCriterion("drivers_license like", value, "driversLicense");
			return (Criteria) this;
		}

		public Criteria andDriversLicenseNotLike(String value) {
			addCriterion("drivers_license not like", value, "driversLicense");
			return (Criteria) this;
		}

		public Criteria andDriversLicenseIn(List<String> values) {
			addCriterion("drivers_license in", values, "driversLicense");
			return (Criteria) this;
		}

		public Criteria andDriversLicenseNotIn(List<String> values) {
			addCriterion("drivers_license not in", values, "driversLicense");
			return (Criteria) this;
		}

		public Criteria andDriversLicenseBetween(String value1, String value2) {
			addCriterion("drivers_license between", value1, value2, "driversLicense");
			return (Criteria) this;
		}

		public Criteria andDriversLicenseNotBetween(String value1, String value2) {
			addCriterion("drivers_license not between", value1, value2, "driversLicense");
			return (Criteria) this;
		}

		public Criteria andAgreementIsNull() {
			addCriterion("agreement is null");
			return (Criteria) this;
		}

		public Criteria andAgreementIsNotNull() {
			addCriterion("agreement is not null");
			return (Criteria) this;
		}

		public Criteria andAgreementEqualTo(String value) {
			addCriterion("agreement =", value, "agreement");
			return (Criteria) this;
		}

		public Criteria andAgreementNotEqualTo(String value) {
			addCriterion("agreement <>", value, "agreement");
			return (Criteria) this;
		}

		public Criteria andAgreementGreaterThan(String value) {
			addCriterion("agreement >", value, "agreement");
			return (Criteria) this;
		}

		public Criteria andAgreementGreaterThanOrEqualTo(String value) {
			addCriterion("agreement >=", value, "agreement");
			return (Criteria) this;
		}

		public Criteria andAgreementLessThan(String value) {
			addCriterion("agreement <", value, "agreement");
			return (Criteria) this;
		}

		public Criteria andAgreementLessThanOrEqualTo(String value) {
			addCriterion("agreement <=", value, "agreement");
			return (Criteria) this;
		}

		public Criteria andAgreementLike(String value) {
			addCriterion("agreement like", value, "agreement");
			return (Criteria) this;
		}

		public Criteria andAgreementNotLike(String value) {
			addCriterion("agreement not like", value, "agreement");
			return (Criteria) this;
		}

		public Criteria andAgreementIn(List<String> values) {
			addCriterion("agreement in", values, "agreement");
			return (Criteria) this;
		}

		public Criteria andAgreementNotIn(List<String> values) {
			addCriterion("agreement not in", values, "agreement");
			return (Criteria) this;
		}

		public Criteria andAgreementBetween(String value1, String value2) {
			addCriterion("agreement between", value1, value2, "agreement");
			return (Criteria) this;
		}

		public Criteria andAgreementNotBetween(String value1, String value2) {
			addCriterion("agreement not between", value1, value2, "agreement");
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

		public Criteria andVehicleNameIsNull() {
			addCriterion("vehicle_name is null");
			return (Criteria) this;
		}

		public Criteria andVehicleNameIsNotNull() {
			addCriterion("vehicle_name is not null");
			return (Criteria) this;
		}

		public Criteria andVehicleNameEqualTo(String value) {
			addCriterion("vehicle_name =", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameNotEqualTo(String value) {
			addCriterion("vehicle_name <>", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameGreaterThan(String value) {
			addCriterion("vehicle_name >", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameGreaterThanOrEqualTo(String value) {
			addCriterion("vehicle_name >=", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameLessThan(String value) {
			addCriterion("vehicle_name <", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameLessThanOrEqualTo(String value) {
			addCriterion("vehicle_name <=", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameLike(String value) {
			addCriterion("vehicle_name like", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameNotLike(String value) {
			addCriterion("vehicle_name not like", value, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameIn(List<String> values) {
			addCriterion("vehicle_name in", values, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameNotIn(List<String> values) {
			addCriterion("vehicle_name not in", values, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameBetween(String value1, String value2) {
			addCriterion("vehicle_name between", value1, value2, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andVehicleNameNotBetween(String value1, String value2) {
			addCriterion("vehicle_name not between", value1, value2, "vehicleName");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNull() {
			addCriterion("end_time is null");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("end_time is not null");
			return (Criteria) this;
		}

		public Criteria andEndTimeEqualTo(Date value) {
			addCriterion("end_time =", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotEqualTo(Date value) {
			addCriterion("end_time <>", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThan(Date value) {
			addCriterion("end_time >", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("end_time >=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThan(Date value) {
			addCriterion("end_time <", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("end_time <=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIn(List<Date> values) {
			addCriterion("end_time in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotIn(List<Date> values) {
			addCriterion("end_time not in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeBetween(Date value1, Date value2) {
			addCriterion("end_time between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("end_time not between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andPerfectStateIsNull() {
			addCriterion("perfect_state is null");
			return (Criteria) this;
		}

		public Criteria andPerfectStateIsNotNull() {
			addCriterion("perfect_state is not null");
			return (Criteria) this;
		}

		public Criteria andPerfectStateEqualTo(Integer value) {
			addCriterion("perfect_state =", value, "perfectState");
			return (Criteria) this;
		}

		public Criteria andPerfectStateNotEqualTo(Integer value) {
			addCriterion("perfect_state <>", value, "perfectState");
			return (Criteria) this;
		}

		public Criteria andPerfectStateGreaterThan(Integer value) {
			addCriterion("perfect_state >", value, "perfectState");
			return (Criteria) this;
		}

		public Criteria andPerfectStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("perfect_state >=", value, "perfectState");
			return (Criteria) this;
		}

		public Criteria andPerfectStateLessThan(Integer value) {
			addCriterion("perfect_state <", value, "perfectState");
			return (Criteria) this;
		}

		public Criteria andPerfectStateLessThanOrEqualTo(Integer value) {
			addCriterion("perfect_state <=", value, "perfectState");
			return (Criteria) this;
		}

		public Criteria andPerfectStateIn(List<Integer> values) {
			addCriterion("perfect_state in", values, "perfectState");
			return (Criteria) this;
		}

		public Criteria andPerfectStateNotIn(List<Integer> values) {
			addCriterion("perfect_state not in", values, "perfectState");
			return (Criteria) this;
		}

		public Criteria andPerfectStateBetween(Integer value1, Integer value2) {
			addCriterion("perfect_state between", value1, value2, "perfectState");
			return (Criteria) this;
		}

		public Criteria andPerfectStateNotBetween(Integer value1, Integer value2) {
			addCriterion("perfect_state not between", value1, value2, "perfectState");
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