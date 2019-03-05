package com.unicdata.service.system;

import com.github.pagehelper.PageInfo;
import com.unicdata.entity.system.DistributorStoreInfo;
import com.unicdata.entity.system.DistributorStoreInfoExample;

import java.util.List;

/**
 * Created by shenyong on 2018/6/1.
 */
public interface DistributorStoreInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(DistributorStoreInfo record);

    int insertSelective(DistributorStoreInfo record);

    List<DistributorStoreInfo> selectByExample(DistributorStoreInfoExample example);

    DistributorStoreInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DistributorStoreInfo record);

    int updateByPrimaryKey(DistributorStoreInfo record);

    PageInfo<DistributorStoreInfo> selectPageByDistributor(Integer distributorId, Integer pageSize, Integer pageNum);

    List<DistributorStoreInfo> selectByDistributor(Integer distributorId);

    List<DistributorStoreInfo> selectByDistributors(Integer distributorId);

    List<Integer> selectIdsByDistributor(Integer distributorId);

    DistributorStoreInfo getByDistributorAndCode(DistributorStoreInfo record);

    DistributorStoreInfo getById(Integer storeId);

    List<DistributorStoreInfo> selectcitylsit(Integer distributorId);

}
