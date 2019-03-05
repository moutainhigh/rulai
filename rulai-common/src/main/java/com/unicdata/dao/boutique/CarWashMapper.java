package com.unicdata.dao.boutique;

import com.github.pagehelper.Page;
import com.unicdata.entity.boutique.CarWash;
import com.unicdata.entity.boutique.CarWashExample;
import java.util.List;
import java.util.Map;

public interface CarWashMapper {
    int countByExample(CarWashExample example);
    int deleteByPrimaryKey(Integer id);

    int insert(CarWash record);

    int insertSelective(CarWash record);

    List<CarWash> selectByExample(CarWashExample example);

    CarWash selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarWash record);

    int updateByPrimaryKey(CarWash record);

    int countByToDay(CarWash record);

    /**
     * 获取最大排序
     * @return
     */
    Integer getMaxSort();

    /**
     * 根据参数获取分页列表
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String,Object> params);

    List<Map<String, Object>> selectCarWashList(Map<String,Object> map);

    List<Map<String, Object>> selectMouthCarWashSum(Map<String,Object> map);


}