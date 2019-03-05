package com.unicdata.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.dao.system.DistributorStoreInfoMapper;
import com.unicdata.entity.system.DistributorStoreInfo;
import com.unicdata.entity.system.DistributorStoreInfoExample;
import com.unicdata.service.system.DistributorStoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by myMsi on 2018/6/1.
 */
@Service
public class DistributorStoreInfoServiceImpl implements DistributorStoreInfoService {

    @Autowired
    private DistributorStoreInfoMapper distributorStoreInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return distributorStoreInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DistributorStoreInfo record) {
        return distributorStoreInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(DistributorStoreInfo record) {
        return distributorStoreInfoMapper.insertSelective(record);
    }

    @Override
    public List<DistributorStoreInfo> selectByExample(DistributorStoreInfoExample example) {
        return distributorStoreInfoMapper.selectByExample(example);
    }

    @Override
    public DistributorStoreInfo selectByPrimaryKey(Integer id) {
        return distributorStoreInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DistributorStoreInfo record) {
        return distributorStoreInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DistributorStoreInfo record) {
        return distributorStoreInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<DistributorStoreInfo> selectPageByDistributor(Integer distributorId, Integer pageSize, Integer pageNum) {
        pageNum = null == pageNum || pageNum < 1 ?  1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? Integer.MAX_VALUE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        return distributorStoreInfoMapper.selectPageByDistributor(distributorId).toPageInfo() ;
    }

    @Override
    public List<DistributorStoreInfo> selectByDistributor(Integer distributorId) {
        return distributorStoreInfoMapper.selectByDistributor( distributorId);
    }

    @Override
    public List<DistributorStoreInfo> selectByDistributors(Integer distributorId) {
        return distributorStoreInfoMapper.selectByDistributors( distributorId);
    }

    @Override
    public List<Integer> selectIdsByDistributor(Integer distributorId) {
        return distributorStoreInfoMapper.selectIdsByDistributor(distributorId) ;
    }

    @Override
    public DistributorStoreInfo getByDistributorAndCode(DistributorStoreInfo record) {
        return distributorStoreInfoMapper.getByDistributorAndCode(record) ;
    }

    @Override
    public DistributorStoreInfo getById(Integer storeId) {
        return distributorStoreInfoMapper.selectByPrimaryKey( storeId) ;
    }

    @Override
    public List<DistributorStoreInfo> selectcitylsit(Integer distributorId) {
        return distributorStoreInfoMapper.selectcitylsit(distributorId);
    }
}
