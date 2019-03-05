package com.unicdata.entity.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PassengerFlowExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PassengerFlowExample() {
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

		public Criteria andReplaceEmployeeIdIsNull() {
			addCriterion("replace_employee_id is null");
			return (Criteria) this;
		}

		public Criteria andReplaceEmployeeIdIsNotNull() {
			addCriterion("replace_employee_id is not null");
			return (Criteria) this;
		}

		public Criteria andReplaceEmployeeIdEqualTo(Integer value) {
			addCriterion("replace_employee_id =", value, "replaceEmployeeId");
			return (Criteria) this;
		}

		public Criteria andReplaceEmployeeIdNotEqualTo(Integer value) {
			addCriterion("replace_employee_id <>", value, "replaceEmployeeId");
			return (Criteria) this;
		}

		public Criteria andReplaceEmployeeIdGreaterThan(Integer value) {
			addCriterion("replace_employee_id >", value, "replaceEmployeeId");
			return (Criteria) this;
		}

		public Criteria andReplaceEmployeeIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("replace_employee_id >=", value, "replaceEmployeeId");
			return (Criteria) this;
		}

		public Criteria andReplaceEmployeeIdLessThan(Integer value) {
			addCriterion("replace_employee_id <", value, "replaceEmployeeId");
			return (Criteria) this;
		}

		public Criteria andReplaceEmployeeIdLessThanOrEqualTo(Integer value) {
			addCriterion("replace_employee_id <=", value, "replaceEmployeeId");
			return (Criteria) this;
		}

		public Criteria andReplaceEmployeeIdIn(List<Integer> values) {
			addCriterion("replace_employee_id in", values, "replaceEmployeeId");
			return (Criteria) this;
		}

		public Criteria andReplaceEmployeeIdNotIn(List<Integer> values) {
			addCriterion("replace_employee_id not in", values, "replaceEmployeeId");
			return (Criteria) this;
		}

		public Criteria andReplaceEmployeeIdBetween(Integer value1, Integer value2) {
			addCriterion("replace_employee_id between", value1, value2, "replaceEmployeeId");
			return (Criteria) this;
		}

		public Criteria andReplaceEmployeeIdNotBetween(Integer value1, Integer value2) {
			addCriterion("replace_employee_id not between", value1, value2, "replaceEmployeeId");
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

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(Byte value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Byte value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Byte value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Byte value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Byte value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Byte> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Byte> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Byte value1, Byte value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andOwnedCarIsNull() {
			addCriterion("owned_car is null");
			return (Criteria) this;
		}

		public Criteria andOwnedCarIsNotNull() {
			addCriterion("owned_car is not null");
			return (Criteria) this;
		}

		public Criteria andOwnedCarEqualTo(String value) {
			addCriterion("owned_car =", value, "ownedCar");
			return (Criteria) this;
		}

		public Criteria andOwnedCarNotEqualTo(String value) {
			addCriterion("owned_car <>", value, "ownedCar");
			return (Criteria) this;
		}

		public Criteria andOwnedCarGreaterThan(String value) {
			addCriterion("owned_car >", value, "ownedCar");
			return (Criteria) this;
		}

		public Criteria andOwnedCarGreaterThanOrEqualTo(String value) {
			addCriterion("owned_car >=", value, "ownedCar");
			return (Criteria) this;
		}

		public Criteria andOwnedCarLessThan(String value) {
			addCriterion("owned_car <", value, "ownedCar");
			return (Criteria) this;
		}

		public Criteria andOwnedCarLessThanOrEqualTo(String value) {
			addCriterion("owned_car <=", value, "ownedCar");
			return (Criteria) this;
		}

		public Criteria andOwnedCarLike(String value) {
			addCriterion("owned_car like", value, "ownedCar");
			return (Criteria) this;
		}

		public Criteria andOwnedCarNotLike(String value) {
			addCriterion("owned_car not like", value, "ownedCar");
			return (Criteria) this;
		}

		public Criteria andOwnedCarIn(List<String> values) {
			addCriterion("owned_car in", values, "ownedCar");
			return (Criteria) this;
		}

		public Criteria andOwnedCarNotIn(List<String> values) {
			addCriterion("owned_car not in", values, "ownedCar");
			return (Criteria) this;
		}

		public Criteria andOwnedCarBetween(String value1, String value2) {
			addCriterion("owned_car between", value1, value2, "ownedCar");
			return (Criteria) this;
		}

		public Criteria andOwnedCarNotBetween(String value1, String value2) {
			addCriterion("owned_car not between", value1, value2, "ownedCar");
			return (Criteria) this;
		}

		public Criteria andLicensePlateIsNull() {
			addCriterion("license_plate is null");
			return (Criteria) this;
		}

		public Criteria andLicensePlateIsNotNull() {
			addCriterion("license_plate is not null");
			return (Criteria) this;
		}

		public Criteria andLicensePlateEqualTo(String value) {
			addCriterion("license_plate =", value, "licensePlate");
			return (Criteria) this;
		}

		public Criteria andLicensePlateNotEqualTo(String value) {
			addCriterion("license_plate <>", value, "licensePlate");
			return (Criteria) this;
		}

		public Criteria andLicensePlateGreaterThan(String value) {
			addCriterion("license_plate >", value, "licensePlate");
			return (Criteria) this;
		}

		public Criteria andLicensePlateGreaterThanOrEqualTo(String value) {
			addCriterion("license_plate >=", value, "licensePlate");
			return (Criteria) this;
		}

		public Criteria andLicensePlateLessThan(String value) {
			addCriterion("license_plate <", value, "licensePlate");
			return (Criteria) this;
		}

		public Criteria andLicensePlateLessThanOrEqualTo(String value) {
			addCriterion("license_plate <=", value, "licensePlate");
			return (Criteria) this;
		}

		public Criteria andLicensePlateLike(String value) {
			addCriterion("license_plate like", value, "licensePlate");
			return (Criteria) this;
		}

		public Criteria andLicensePlateNotLike(String value) {
			addCriterion("license_plate not like", value, "licensePlate");
			return (Criteria) this;
		}

		public Criteria andLicensePlateIn(List<String> values) {
			addCriterion("license_plate in", values, "licensePlate");
			return (Criteria) this;
		}

		public Criteria andLicensePlateNotIn(List<String> values) {
			addCriterion("license_plate not in", values, "licensePlate");
			return (Criteria) this;
		}

		public Criteria andLicensePlateBetween(String value1, String value2) {
			addCriterion("license_plate between", value1, value2, "licensePlate");
			return (Criteria) this;
		}

		public Criteria andLicensePlateNotBetween(String value1, String value2) {
			addCriterion("license_plate not between", value1, value2, "licensePlate");
			return (Criteria) this;
		}

		public Criteria andLeaveTimeIsNull() {
			addCriterion("leave_time is null");
			return (Criteria) this;
		}

		public Criteria andLeaveTimeIsNotNull() {
			addCriterion("leave_time is not null");
			return (Criteria) this;
		}

		public Criteria andLeaveTimeEqualTo(Date value) {
			addCriterion("leave_time =", value, "leaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaveTimeNotEqualTo(Date value) {
			addCriterion("leave_time <>", value, "leaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaveTimeGreaterThan(Date value) {
			addCriterion("leave_time >", value, "leaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaveTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("leave_time >=", value, "leaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaveTimeLessThan(Date value) {
			addCriterion("leave_time <", value, "leaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaveTimeLessThanOrEqualTo(Date value) {
			addCriterion("leave_time <=", value, "leaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaveTimeIn(List<Date> values) {
			addCriterion("leave_time in", values, "leaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaveTimeNotIn(List<Date> values) {
			addCriterion("leave_time not in", values, "leaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaveTimeBetween(Date value1, Date value2) {
			addCriterion("leave_time between", value1, value2, "leaveTime");
			return (Criteria) this;
		}

		public Criteria andLeaveTimeNotBetween(Date value1, Date value2) {
			addCriterion("leave_time not between", value1, value2, "leaveTime");
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

		public Criteria andIsArchivesIsNull() {
			addCriterion("is_archives is null");
			return (Criteria) this;
		}

		public Criteria andIsArchivesIsNotNull() {
			addCriterion("is_archives is not null");
			return (Criteria) this;
		}

		public Criteria andIsArchivesEqualTo(Byte value) {
			addCriterion("is_archives =", value, "isArchives");
			return (Criteria) this;
		}

		public Criteria andIsArchivesNotEqualTo(Byte value) {
			addCriterion("is_archives <>", value, "isArchives");
			return (Criteria) this;
		}

		public Criteria andIsArchivesGreaterThan(Byte value) {
			addCriterion("is_archives >", value, "isArchives");
			return (Criteria) this;
		}

		public Criteria andIsArchivesGreaterThanOrEqualTo(Byte value) {
			addCriterion("is_archives >=", value, "isArchives");
			return (Criteria) this;
		}

		public Criteria andIsArchivesLessThan(Byte value) {
			addCriterion("is_archives <", value, "isArchives");
			return (Criteria) this;
		}

		public Criteria andIsArchivesLessThanOrEqualTo(Byte value) {
			addCriterion("is_archives <=", value, "isArchives");
			return (Criteria) this;
		}

		public Criteria andIsArchivesIn(List<Byte> values) {
			addCriterion("is_archives in", values, "isArchives");
			return (Criteria) this;
		}

		public Criteria andIsArchivesNotIn(List<Byte> values) {
			addCriterion("is_archives not in", values, "isArchives");
			return (Criteria) this;
		}

		public Criteria andIsArchivesBetween(Byte value1, Byte value2) {
			addCriterion("is_archives between", value1, value2, "isArchives");
			return (Criteria) this;
		}

		public Criteria andIsArchivesNotBetween(Byte value1, Byte value2) {
			addCriterion("is_archives not between", value1, value2, "isArchives");
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

		public Criteria andStatusEqualTo(Byte value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Byte value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Byte value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Byte value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Byte value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Byte> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Byte> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Byte value1, Byte value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("status not between", value1, value2, "status");
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