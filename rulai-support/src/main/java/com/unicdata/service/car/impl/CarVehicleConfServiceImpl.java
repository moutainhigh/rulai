package com.unicdata.service.car.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.unicdata.base.util.BigDecimalUtils;
import com.unicdata.entity.car.CarFamily;
import com.unicdata.service.car.CarFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.enu.ResultCodeEnum;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.base.util.StringUtil;
import com.unicdata.dao.car.CarVehicleConfMapper;
import com.unicdata.entity.car.CarVehicleConf;
import com.unicdata.entity.car.CarVehicleConfExample;
import com.unicdata.entity.letprice.MonthPlanDetail;
import com.unicdata.service.car.CarVehicleConfService;
import com.unicdata.service.letprice.MonthPlanDetailService;

@Service
public class CarVehicleConfServiceImpl implements CarVehicleConfService {

	@Autowired
	private CarVehicleConfMapper carVehicleConfMapper;
	@Autowired
	private MonthPlanDetailService monthPlanDetailService;
	@Autowired
	private CarFamilyService carFamilyService;

	public int insertSelective(CarVehicleConf record) {
		return carVehicleConfMapper.insertSelective(record);
	}

	@Override
	public List<CarVehicleConf> selectByExample(CarVehicleConfExample example) {
		return carVehicleConfMapper.selectByExample(example);
	}

	public CarVehicleConf selectByPrimaryKey(Integer id) {
		return carVehicleConfMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(CarVehicleConf record) {
		return carVehicleConfMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public PageInfo<Map<String, Object>> selectListByStore(Integer distributorStoreId, Integer pageSize,
			Integer pageNum) {
		if (null != pageSize && null != pageSize) {
			PageHelper.startPage(pageNum, pageSize);
		}
		return carVehicleConfMapper.selectListByStore(distributorStoreId).toPageInfo();
	}

	@Override
	public List<CarVehicleConf> selectVehicleByBrand(Integer familyId) {
		return carVehicleConfMapper.selectVehicleByBrand(familyId);
	}

	@Override
	public CarVehicleConf selectByNameAndYear(Integer storeId, Integer familyId, String name, String year) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("familyId", familyId);
		params.put("name", name);
		params.put("year", year);
		return carVehicleConfMapper.selectByNameAndYear(params);
	}
	
	@Override
	public List<String> selectYearByVehicle(Integer storeId, Integer vehicleId) {
		Map<String, Object> params = new HashMap<>();
		params.put("storeId", storeId);
		params.put("vehicleId", vehicleId);
		return carVehicleConfMapper.selectYearByVehicle(params);
	}

	@Override
	public PageInfo<CarVehicleConf> selectVehicleList(CarVehicleConf carVehicleConf, Integer pageSize, Integer pageNum) {
		pageNum = (null == pageNum || pageNum < 1 ? 1 : pageNum);
		pageSize = null == pageSize || pageSize.intValue() > 100 ? 100 : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		CarVehicleConfExample ex = new CarVehicleConfExample();
		CarVehicleConfExample.Criteria criteria = ex.createCriteria().andStatusEqualTo(1);
		if(carVehicleConf.getDistributorStoreId() != null && carVehicleConf.getDistributorStoreId() > 0) {
			criteria.andDistributorStoreIdEqualTo(carVehicleConf.getDistributorStoreId());
		}
		if(carVehicleConf.getAdjustStatus() != null && carVehicleConf.getAdjustStatus() >= 0){
			criteria.andAdjustStatusEqualTo(carVehicleConf.getAdjustStatus());
		}
		if(carVehicleConf.getBrandId() != null && carVehicleConf.getBrandId() > 0){
			criteria.andBrandIdEqualTo(carVehicleConf.getBrandId());
		}
		if(carVehicleConf.getFamilyId() != null && carVehicleConf.getFamilyId() > 0){
			criteria.andFamilyIdEqualTo(carVehicleConf.getFamilyId());
		}
		List<CarVehicleConf> carVehicleConfs = carVehicleConfMapper.selectByExample(ex);
		carVehicleConfs.forEach(vehicle -> {
			Map map = carVehicleConfMapper.selectVehicleRebateAvgPrice(vehicle.getId());
			if(map != null){
				////平均返利预估
				BigDecimal avgForecastProfit = (BigDecimal) map.getOrDefault("avgForecastProfit", 0);
				if(avgForecastProfit == null)
					avgForecastProfit = BigDecimal.ZERO;
				if (vehicle.getLevelTwo() == null)
					vehicle.setLevelTwo(BigDecimal.ZERO);
				if (vehicle.getPurchasePrice() == null )
					vehicle.setPurchasePrice(BigDecimal.ZERO);
				//库存数量
				Long stockQuantity = (Long) map.getOrDefault("stockQuantity", 0);
				vehicle.setStockQuantity(stockQuantity);
				vehicle.setAvgForecastProfit(BigDecimalUtils.format(avgForecastProfit,2));
				//平均毛利预估
				BigDecimal avgGrossProfit = vehicle.getLevelTwo().subtract(vehicle.getPurchasePrice()).add(vehicle.getAvgForecastProfit());
				vehicle.setAvgGrossProfit(avgGrossProfit);
				//整车毛利总额
				BigDecimal vehicleGrossProfit = avgGrossProfit.multiply(BigDecimal.valueOf(stockQuantity));
				vehicle.setVehicleGrossProfit(vehicleGrossProfit);
			}
			CarFamily carFamily = carFamilyService.selectByPrimaryKey(vehicle.getFamilyId());
			if(carFamily != null){
				vehicle.setCarFamily(carFamily);
			}
		});
		return new PageInfo<>(carVehicleConfs);
	}

	public ApiReturnInfo priceEdit(CarVehicleConf vehicle) {
		ApiReturnInfo ar = new ApiReturnInfo();
		if(vehicle.getId() == null || vehicle.getId() <= 0 || vehicle.getLevelOneAdjust() == null || vehicle.getLevelThreeAdjust() == null || vehicle.getLevelThreeAdjust() == null){
			ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
			ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
			return ar;
		}
		if(vehicle.getLevelOneAdjust().compareTo(vehicle.getLevelTwoAdjust()) < 0){
			ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
			ar.setMessage("销售顾问金额不可小于销售经理");
			return ar;
		}
		if(vehicle.getLevelTwoAdjust().compareTo(vehicle.getLevelThreeAdjust()) < 0){
			ar.setCode(ResultCodeEnum.RESULT_CODE_ERROR.getCode());
			ar.setMessage("销售经理金额不可小于总经理");
			return ar;
		}
		CarVehicleConf car = new CarVehicleConf();
		car.setId(vehicle.getId());
		car.setLevelOneAdjust(vehicle.getLevelOneAdjust());
		car.setLevelTwoAdjust(vehicle.getLevelTwoAdjust());
		car.setLevelThreeAdjust(vehicle.getLevelThreeAdjust());
		car.setAdjustStatus(1);
		car.setUpdateDate(new Date());
		this.updateByPrimaryKeySelective(car);
		return ar;
	}

	@Override
	@Transactional
	public ApiReturnInfo chageStatus(Integer adjustStatus, String ids) {
		ApiReturnInfo ar = new ApiReturnInfo();
		switch (adjustStatus) {
			case 1:
				//撤销
				if(StringUtil.isNotBlank(ids)) {
					Integer id = Integer.valueOf(ids);
					CarVehicleConf carVehicleConf = this.selectByPrimaryKey(id);
					if (carVehicleConf != null && carVehicleConf.getAdjustStatus() == 1) {
						CarVehicleConf c = new CarVehicleConf();
						c.setId(id);
						c.setLevelOneAdjust(BigDecimal.ZERO);
						c.setLevelTwoAdjust(BigDecimal.ZERO);
						c.setLevelThreeAdjust(BigDecimal.ZERO);
						c.setAdjustStatus(0);
						c.setUpdateDate(new Date());
						this.updateByPrimaryKeySelective(c);
					} else {
						ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
						ar.setMessage("该状态下不可执行撤销动作！");
					}
				}else {
					ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
					ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
				}
				return ar;
			case 2:
				//全部报备
				CarVehicleConfExample ex = new CarVehicleConfExample();
				ex.createCriteria().andAdjustStatusEqualTo(1);
				List<CarVehicleConf> carVehicleConfs = this.selectByExample(ex);
				for(CarVehicleConf c : carVehicleConfs){
					c.setAdjustStatus(2);
					c.setUpdateDate(new Date());
					this.updateByPrimaryKeySelective(c);
				}
				break;
			case 3:
				//审批
				if(StringUtil.isNotBlank(ids)){
					String[] carIds = ids.split(",");
					for(String carId :carIds){
						CarVehicleConf v = this.selectByPrimaryKey(Integer.valueOf(carId));
						if(v.getAdjustStatus() == 2) {
							updateCarVehicle(v);
							updateVehicleMonthPlan(v.getId());
						}
					}
				}else {
					ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
					ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
				}
				break;
			case 4:
				//全部审批
				CarVehicleConfExample ex4 = new CarVehicleConfExample();
				ex4.createCriteria().andAdjustStatusEqualTo(2);
				List<CarVehicleConf> carVehicleConfs4 = this.selectByExample(ex4);
				for(CarVehicleConf c : carVehicleConfs4){
					updateCarVehicle(c);
					updateVehicleMonthPlan(c.getId());
				}
				break;
			case 5:
				//驳回
				if(StringUtil.isNotBlank(ids)){
					Integer bhId = Integer.valueOf(ids);
					CarVehicleConf v = this.selectByPrimaryKey(bhId);
					if(v.getAdjustStatus() == 2){
						v.setAdjustStatus(4);
						v.setUpdateDate(new Date());
						this.updateByPrimaryKeySelective(v);
					}
				}else {
					ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
					ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
				}
				break;
			default:
				ar.setCode(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getCode());
				ar.setMessage(ResultCodeEnum.RESULT_CODE_PARAM_KEY_MISS.getMessage());
				break;
		}
		return ar;
	}

	private void updateCarVehicle(CarVehicleConf v) {
		v.setLevelOne(v.getLevelOneAdjust());
		v.setLevelTwo(v.getLevelTwoAdjust());
		v.setLevelThree(v.getLevelThreeAdjust());
		v.setLevelOneAdjust(BigDecimal.ZERO);
		v.setLevelTwoAdjust(BigDecimal.ZERO);
		v.setLevelThreeAdjust(BigDecimal.ZERO);
		v.setAdjustStatus(3);
		v.setUpdateDate(new Date());
		this.updateByPrimaryKeySelective(v);
	}

	/**
	 * 车型修改报备价格审核通过时修改月度计划管理对应的车辆销售价格
	 */
	@Transactional
	public void updateVehicleMonthPlan(Integer carId){
		Map<Integer ,Integer> monthPlanMap = new HashMap<>();
		CarVehicleConf vehicle = this.selectByPrimaryKey(carId);
		List<Map> monthPlanDetailIds = monthPlanDetailService.selectVehicleMonthPlanDetail(carId);
		//处理车型对应的月度计划管理详情数据
		monthPlanDetailIds.forEach(map->{
			Integer id = (Integer) map.get("id");
			monthPlanMap.put(id,id);
			Integer detailId = (Integer) map.get("detailId");
			MonthPlanDetail mpd = new MonthPlanDetail();
			mpd.setId(detailId);
			mpd.setLevelOne(vehicle.getLevelOne());
			mpd.setLevelTwo(vehicle.getLevelTwo());
			mpd.setLevelThree(vehicle.getLevelThree());
//			mpd.setStatus(3);
			mpd.setUpdateDate(new Date());
			monthPlanDetailService.updateByPrimaryKeySelective(mpd);
		});
		//处理月度计划数据
		monthPlanMap.forEach((k,v)->{
			monthPlanDetailService.calcMonthPlanData(k);
		});


	}
}
