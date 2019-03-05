package com.unicdata.dao.system;

import com.github.pagehelper.Page;
import com.unicdata.entity.system.DistributorStoreInfo;
import com.unicdata.entity.system.DistributorStoreInfoExample;
import java.util.List;

public interface DistributorStoreInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DistributorStoreInfo record);

    int insertSelective(DistributorStoreInfo record);

    List<DistributorStoreInfo> selectByExample(DistributorStoreInfoExample example);

    DistributorStoreInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DistributorStoreInfo record);

    int updateByPrimaryKey(DistributorStoreInfo record);

    Page<DistributorStoreInfo> selectPageByDistributor(Integer distributorId);

    List<DistributorStoreInfo> selectByDistributor(Integer distributorId);

    List<DistributorStoreInfo> selectByDistributors(Integer distributorId);

    List<Integer> selectIdsByDistributor(Integer distributorId);

    DistributorStoreInfo getByDistributorAndCode(DistributorStoreInfo record);

    List<DistributorStoreInfo> selectcitylsit(Integer distributorId);




}