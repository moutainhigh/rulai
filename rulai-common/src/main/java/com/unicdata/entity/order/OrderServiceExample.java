package com.unicdata.entity.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderServiceExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderServiceExample() {
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

		public Criteria andOrderIdIsNull() {
			addCriterion("order_id is null");
			return (Criteria) this;
		}

		public Criteria andOrderIdIsNotNull() {
			addCriterion("order_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrderIdEqualTo(Integer value) {
			addCriterion("order_id =", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotEqualTo(Integer value) {
			addCriterion("order_id <>", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThan(Integer value) {
			addCriterion("order_id >", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_id >=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThan(Integer value) {
			addCriterion("order_id <", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
			addCriterion("order_id <=", value, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdIn(List<Integer> values) {
			addCriterion("order_id in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotIn(List<Integer> values) {
			addCriterion("order_id not in", values, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdBetween(Integer value1, Integer value2) {
			addCriterion("order_id between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
			addCriterion("order_id not between", value1, value2, "orderId");
			return (Criteria) this;
		}

		public Criteria andServiceIdIsNull() {
			addCriterion("service_id is null");
			return (Criteria) this;
		}

		public Criteria andServiceIdIsNotNull() {
			addCriterion("service_id is not null");
			return (Criteria) this;
		}

		public Criteria andServiceIdEqualTo(Integer value) {
			addCriterion("service_id =", value, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdNotEqualTo(Integer value) {
			addCriterion("service_id <>", value, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdGreaterThan(Integer value) {
			addCriterion("service_id >", value, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("service_id >=", value, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdLessThan(Integer value) {
			addCriterion("service_id <", value, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdLessThanOrEqualTo(Integer value) {
			addCriterion("service_id <=", value, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdIn(List<Integer> values) {
			addCriterion("service_id in", values, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdNotIn(List<Integer> values) {
			addCriterion("service_id not in", values, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdBetween(Integer value1, Integer value2) {
			addCriterion("service_id between", value1, value2, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdNotBetween(Integer value1, Integer value2) {
			addCriterion("service_id not between", value1, value2, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServicePriceIsNull() {
			addCriterion("service_price is null");
			return (Criteria) this;
		}

		public Criteria andServicePriceIsNotNull() {
			addCriterion("service_price is not null");
			return (Criteria) this;
		}

		public Criteria andServicePriceEqualTo(BigDecimal value) {
			addCriterion("service_price =", value, "servicePrice");
			return (Criteria) this;
		}

		public Criteria andServicePriceNotEqualTo(BigDecimal value) {
			addCriterion("service_price <>", value, "servicePrice");
			return (Criteria) this;
		}

		public Criteria andServicePriceGreaterThan(BigDecimal value) {
			addCriterion("service_price >", value, "servicePrice");
			return (Criteria) this;
		}

		public Criteria andServicePriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("service_price >=", value, "servicePrice");
			return (Criteria) this;
		}

		public Criteria andServicePriceLessThan(BigDecimal value) {
			addCriterion("service_price <", value, "servicePrice");
			return (Criteria) this;
		}

		public Criteria andServicePriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("service_price <=", value, "servicePrice");
			return (Criteria) this;
		}

		public Criteria andServicePriceIn(List<BigDecimal> values) {
			addCriterion("service_price in", values, "servicePrice");
			return (Criteria) this;
		}

		public Criteria andServicePriceNotIn(List<BigDecimal> values) {
			addCriterion("service_price not in", values, "servicePrice");
			return (Criteria) this;
		}

		public Criteria andServicePriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("service_price between", value1, value2, "servicePrice");
			return (Criteria) this;
		}

		public Criteria andServicePriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("service_price not between", value1, value2, "servicePrice");
			return (Criteria) this;
		}

		public Criteria andIsGiftIsNull() {
			addCriterion("is_gift is null");
			return (Criteria) this;
		}

		public Criteria andIsGiftIsNotNull() {
			addCriterion("is_gift is not null");
			return (Criteria) this;
		}

		public Criteria andIsGiftEqualTo(Byte value) {
			addCriterion("is_gift =", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftNotEqualTo(Byte value) {
			addCriterion("is_gift <>", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftGreaterThan(Byte value) {
			addCriterion("is_gift >", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftGreaterThanOrEqualTo(Byte value) {
			addCriterion("is_gift >=", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftLessThan(Byte value) {
			addCriterion("is_gift <", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftLessThanOrEqualTo(Byte value) {
			addCriterion("is_gift <=", value, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftIn(List<Byte> values) {
			addCriterion("is_gift in", values, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftNotIn(List<Byte> values) {
			addCriterion("is_gift not in", values, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftBetween(Byte value1, Byte value2) {
			addCriterion("is_gift between", value1, value2, "isGift");
			return (Criteria) this;
		}

		public Criteria andIsGiftNotBetween(Byte value1, Byte value2) {
			addCriterion("is_gift not between", value1, value2, "isGift");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionIsNull() {
			addCriterion("license_plate_region is null");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionIsNotNull() {
			addCriterion("license_plate_region is not null");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionEqualTo(String value) {
			addCriterion("license_plate_region =", value, "licensePlateRegion");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionNotEqualTo(String value) {
			addCriterion("license_plate_region <>", value, "licensePlateRegion");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionGreaterThan(String value) {
			addCriterion("license_plate_region >", value, "licensePlateRegion");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionGreaterThanOrEqualTo(String value) {
			addCriterion("license_plate_region >=", value, "licensePlateRegion");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionLessThan(String value) {
			addCriterion("license_plate_region <", value, "licensePlateRegion");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionLessThanOrEqualTo(String value) {
			addCriterion("license_plate_region <=", value, "licensePlateRegion");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionLike(String value) {
			addCriterion("license_plate_region like", value, "licensePlateRegion");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionNotLike(String value) {
			addCriterion("license_plate_region not like", value, "licensePlateRegion");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionIn(List<String> values) {
			addCriterion("license_plate_region in", values, "licensePlateRegion");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionNotIn(List<String> values) {
			addCriterion("license_plate_region not in", values, "licensePlateRegion");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionBetween(String value1, String value2) {
			addCriterion("license_plate_region between", value1, value2, "licensePlateRegion");
			return (Criteria) this;
		}

		public Criteria andLicensePlateRegionNotBetween(String value1, String value2) {
			addCriterion("license_plate_region not between", value1, value2, "licensePlateRegion");
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

		public Criteria andSumOtherPriceIsNull() {
			addCriterion("sum_other_price is null");
			return (Criteria) this;
		}

		public Criteria andSumOtherPriceIsNotNull() {
			addCriterion("sum_other_price is not null");
			return (Criteria) this;
		}

		public Criteria andSumOtherPriceEqualTo(BigDecimal value) {
			addCriterion("sum_other_price =", value, "sumOtherPrice");
			return (Criteria) this;
		}

		public Criteria andSumOtherPriceNotEqualTo(BigDecimal value) {
			addCriterion("sum_other_price <>", value, "sumOtherPrice");
			return (Criteria) this;
		}

		public Criteria andSumOtherPriceGreaterThan(BigDecimal value) {
			addCriterion("sum_other_price >", value, "sumOtherPrice");
			return (Criteria) this;
		}

		public Criteria andSumOtherPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("sum_other_price >=", value, "sumOtherPrice");
			return (Criteria) this;
		}

		public Criteria andSumOtherPriceLessThan(BigDecimal value) {
			addCriterion("sum_other_price <", value, "sumOtherPrice");
			return (Criteria) this;
		}

		public Criteria andSumOtherPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("sum_other_price <=", value, "sumOtherPrice");
			return (Criteria) this;
		}

		public Criteria andSumOtherPriceIn(List<BigDecimal> values) {
			addCriterion("sum_other_price in", values, "sumOtherPrice");
			return (Criteria) this;
		}

		public Criteria andSumOtherPriceNotIn(List<BigDecimal> values) {
			addCriterion("sum_other_price not in", values, "sumOtherPrice");
			return (Criteria) this;
		}

		public Criteria andSumOtherPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("sum_other_price between", value1, value2, "sumOtherPrice");
			return (Criteria) this;
		}

		public Criteria andSumOtherPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("sum_other_price not between", value1, value2, "sumOtherPrice");
			return (Criteria) this;
		}

		public Criteria andDonationAmountIsNull() {
			addCriterion("donation_amount is null");
			return (Criteria) this;
		}

		public Criteria andDonationAmountIsNotNull() {
			addCriterion("donation_amount is not null");
			return (Criteria) this;
		}

		public Criteria andDonationAmountEqualTo(BigDecimal value) {
			addCriterion("donation_amount =", value, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountNotEqualTo(BigDecimal value) {
			addCriterion("donation_amount <>", value, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountGreaterThan(BigDecimal value) {
			addCriterion("donation_amount >", value, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("donation_amount >=", value, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountLessThan(BigDecimal value) {
			addCriterion("donation_amount <", value, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("donation_amount <=", value, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountIn(List<BigDecimal> values) {
			addCriterion("donation_amount in", values, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountNotIn(List<BigDecimal> values) {
			addCriterion("donation_amount not in", values, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("donation_amount between", value1, value2, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andDonationAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("donation_amount not between", value1, value2, "donationAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountIsNull() {
			addCriterion("total_amount is null");
			return (Criteria) this;
		}

		public Criteria andTotalAmountIsNotNull() {
			addCriterion("total_amount is not null");
			return (Criteria) this;
		}

		public Criteria andTotalAmountEqualTo(BigDecimal value) {
			addCriterion("total_amount =", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
			addCriterion("total_amount <>", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountGreaterThan(BigDecimal value) {
			addCriterion("total_amount >", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("total_amount >=", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountLessThan(BigDecimal value) {
			addCriterion("total_amount <", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("total_amount <=", value, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountIn(List<BigDecimal> values) {
			addCriterion("total_amount in", values, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
			addCriterion("total_amount not in", values, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total_amount between", value1, value2, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total_amount not between", value1, value2, "totalAmount");
			return (Criteria) this;
		}

		public Criteria andMarginIsNull() {
			addCriterion("margin is null");
			return (Criteria) this;
		}

		public Criteria andMarginIsNotNull() {
			addCriterion("margin is not null");
			return (Criteria) this;
		}

		public Criteria andMarginEqualTo(BigDecimal value) {
			addCriterion("margin =", value, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginNotEqualTo(BigDecimal value) {
			addCriterion("margin <>", value, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginGreaterThan(BigDecimal value) {
			addCriterion("margin >", value, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("margin >=", value, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginLessThan(BigDecimal value) {
			addCriterion("margin <", value, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginLessThanOrEqualTo(BigDecimal value) {
			addCriterion("margin <=", value, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginIn(List<BigDecimal> values) {
			addCriterion("margin in", values, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginNotIn(List<BigDecimal> values) {
			addCriterion("margin not in", values, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("margin between", value1, value2, "margin");
			return (Criteria) this;
		}

		public Criteria andMarginNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("margin not between", value1, value2, "margin");
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