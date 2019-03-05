package com.unicdata.service.car.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.condition.CarGoodsCondition;
import com.unicdata.constant.CarEnum;
import com.unicdata.dao.car.CarGoodInfoMapper;
import com.unicdata.dao.car.CarOptionalPackageMapper;
import com.unicdata.dao.car.CarTestInfoMapper;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarGoodInfoExample;
import com.unicdata.entity.car.CarGoodInfoWithBLOBs;
import com.unicdata.service.car.AppCarGoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/2.
 */
@Service
public class AppCarGoodInfoServiceImpl implements AppCarGoodInfoService {
    @Autowired
    CarGoodInfoMapper carGoodInfoMapper;
    @Autowired
    CarOptionalPackageMapper carOptionalPackageMapper;
    @Autowired
    private CarTestInfoMapper carTestInfoMapper;

    /**
     * 仓库分页查询-通过车型，车系，名称，颜色
     *
     * @param map
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo selectByManyConditions(Map<String, Object> map, Integer pageNum, Integer pageSize) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> maps = carGoodInfoMapper.selectByManyConditions(map);
        for (Map<String, Object> objectMap : maps) {
            //选装品和经
            Object optional_package_status1 = objectMap.get("optional_package_status");
            if (optional_package_status1 != null) {
                String optional_package_status = optional_package_status1.toString();
                optional_package_status = "1".equals(optional_package_status) ? "有" : "无";
                objectMap.put("optional_package_status", optional_package_status);
            } else {
                objectMap.put("optional_package_status", "无");
            }
            Object new_boutique_status1 = objectMap.get("new_boutique_status");
            if (new_boutique_status1 != null) {
                String new_boutique_status = new_boutique_status1.toString();
                new_boutique_status = "1".equals(new_boutique_status) ? "有" : "无";
                objectMap.put("new_boutique_status", new_boutique_status);
            } else {
                objectMap.put("new_boutique_status", "无");
            }
            //日期格式转换
            Object sell_date = objectMap.get("sell_date");
            if (sell_date != null) {
                String s = sell_date.toString();
                if (s.length() > 10) {
                    String substring = s.substring(0, 10);
                    objectMap.put("sell_date", substring);
                } else {
                    objectMap.put("sell_date", "-");
                }
            } else {
                objectMap.put("sell_date", "-");
            }
            Object produce_date = objectMap.get("produce_date");
            if (produce_date != null) {
                String s = produce_date.toString();
                if (s.length() > 10) {
                    String substring = s.substring(0, 10);
                    objectMap.put("produce_date", substring);
                } else {
                    objectMap.put("produce_date", "-");
                }
            } else {
                objectMap.put("produce_date", "-");
            }
            Object storage_status = objectMap.get("storage_status");
            if (storage_status != null) {
                Integer s = Integer.valueOf(storage_status.toString())-1;
                CarEnum.CarStorageStatus[] values = CarEnum.CarStorageStatus.values();
                if (s >= 0 && s < values.length) {
                    String reason = values[s].getReason();
                    objectMap.put("storage_status", reason);
                } else {
                    objectMap.put("storage_status", "-");
                }
            } else {
                objectMap.put("storage_status", "-");
            }
        }
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(maps);
        return pageInfo;
    }

    /**
     * 车型
     */
    public List<Map<String, Object>> selectCarConf(Map<String, Object> map) {
        List<Map<String, Object>> list = carGoodInfoMapper.selectCarConf(map);
        return list;
    }

    /**
     * 试驾车车型 wp
     */
    @Override
    public List<Map<String, Object>> carTestConf(Map<String, Object> map) {
        return carTestInfoMapper.carTestConf(map);
    }

    @Override
    public List<Map<String, Object>> selectByManyConditions(Map<String, Object> map) {
        return carGoodInfoMapper.selectByManyConditions(map);
    }

    @Override
    public Map<String, Object> getCarDetailById(Integer carId) {
        return carGoodInfoMapper.getCarDetailById(carId);
    }

	@Override
	public List<CarGoodInfo> getCarListByVehicleId(Integer vehicleId) {
		return carGoodInfoMapper.getCarListByVehicleId(vehicleId);
	}

	@Override
	public int updateCarGoodInfo(CarGoodInfoWithBLOBs record) {
		return carGoodInfoMapper.updateByPrimaryKeySelective(record);
	}

    @Override
    public List<CarGoodInfo> selectByExample(CarGoodInfoExample example) {
        return carGoodInfoMapper.selectByExample(example);
    }

    @Override
    public int updateByPrimaryKey(CarGoodInfo record) {
        return carGoodInfoMapper.updateByPrimaryKey(record);
    }
    /**
     * 试驾车状态处理 wp
     */
	@Override
	public Map<String, Object> isDrive(Map<String, Object> map) {
		return carGoodInfoMapper.isDrive(map);
	}

    @Override
    public PageInfo<Map<String, Object>> selectListByStoreSimplify(CarGoodsCondition carGoodsCondition) {
        if(null != carGoodsCondition.getPageNum() && null != carGoodsCondition.getPageSize()){
            PageHelper.startPage(carGoodsCondition.getPageNum(), carGoodsCondition.getPageSize());
        }
        return carGoodInfoMapper.selectListByStoreSimplify(carGoodsCondition).toPageInfo();
    }
}
