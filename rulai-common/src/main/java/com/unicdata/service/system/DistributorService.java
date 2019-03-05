package com.unicdata.service.system;

import com.unicdata.entity.system.Distributor;
import com.unicdata.entity.system.DistributorExample;

import java.util.List;

/**
 * Created by myMsi on 2018/6/1.
 */
public interface DistributorService {
    int deleteByPrimaryKey(Integer id);

    int insert(Distributor record);

    int insertSelective(Distributor record);

    List<Distributor> selectByExample(DistributorExample example);

    Distributor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Distributor record);

    int updateByPrimaryKey(Distributor record);

    Distributor select(Distributor distributor);

    Distributor selectByDistributor(Distributor distributor);
}
