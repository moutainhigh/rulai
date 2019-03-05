package com.unicdata.service.boutique.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.constant.CarEnum;
import com.unicdata.dao.boutique.CarWashMapper;
import com.unicdata.entity.boutique.CarWash;
import com.unicdata.entity.boutique.CarWashExample;
import com.unicdata.service.boutique.CarWashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class CarWashServiceImpl implements CarWashService {

    @Autowired
    private CarWashMapper carWashMapper;

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return carWashMapper.selectListByParams(params).toPageInfo();
    }

    @Transactional(readOnly = false)
    @Override
    public void stateChange(CarWash carWash) {
        //如果变成洗车中
        if (Objects.equals(carWash.getState(), CarEnum.CarWashStates.WASHING.getCode())) {
            carWash.setBeginTime(new Date());
        } else if (Objects.equals(carWash.getState(), CarEnum.CarWashStates.FINISHED.getCode())) {
            carWash.setEndTime(new Date());
        }
        carWashMapper.updateByPrimaryKeySelective(carWash);
    }

    @Override
    public CarWash getCarWashById(Integer id) {
        return carWashMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void prior(CarWash carWash) {
        //获取最大的排序值
        Integer lastSort = carWashMapper.getMaxSort();
        Integer thisSort = (lastSort == null ? 1 : lastSort + 1);
        carWash.setSort(thisSort);
        carWashMapper.updateByPrimaryKeySelective(carWash);
    }

	@Override
	public List<CarWash> selectByExample(CarWashExample map) {
		return carWashMapper.selectByExample(map);
	}
}
