package com.unicdata.service.system.impl;

import com.unicdata.dao.system.DistributorMapper;
import com.unicdata.entity.system.Distributor;
import com.unicdata.entity.system.DistributorExample;
import com.unicdata.service.system.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by myMsi on 2018/6/1.
 */
@Service
public class DistributorServiceImpl implements DistributorService {


    @Value("${upload.access.path}")
    private String uploadAccessPath;//图片域名

    @Autowired
    private DistributorMapper distributorMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return distributorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Distributor record) {
        return distributorMapper.insert(record);
    }

    @Override
    public int insertSelective(Distributor record) {
        return distributorMapper.insertSelective(record);
    }

    @Override
    public List<Distributor> selectByExample(DistributorExample example) {
        return distributorMapper.selectByExample(example);
    }

    @Override
    public Distributor selectByPrimaryKey(Integer id) {
        return distributorMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Distributor record) {
        return distributorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Distributor record) {
        return distributorMapper.updateByPrimaryKey(record);
    }

    @Override
    public Distributor select(Distributor distributor) {
        return distributorMapper.select(distributor);
    }

    @Override
    public Distributor selectByDistributor(Distributor distributor) {
        Distributor selectByDistributor = distributorMapper.selectByDistributor(distributor);
        if(selectByDistributor != null){
            selectByDistributor.setLogoIcon(uploadAccessPath+selectByDistributor.getLogoIcon());
        }
        return  selectByDistributor;
    }
}
