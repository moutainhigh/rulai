package com.unicdata.service.car.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.unicdata.dao.order.DeliverCarMapper;
import com.unicdata.entity.order.DeliverCar;
import com.unicdata.service.car.AppDeliverCarService;

/**
 * Created by lenovo on 2018/6/5.
 */
@Service
public class AppDeliverCarServiceImpl implements AppDeliverCarService {
	// 文件上传路径
	@Value("${upload.file.path}")
	private String uploadFilePath;
    @Autowired
    private DeliverCarMapper deliverCarMapper;


    @Override
    public int getMothDeliverCarNumByStoreId(Map<String, Object> map) {
        return deliverCarMapper.getMothDeliverCarNumByStoreId(map);
    }

    @Override
	public int addDeliverCar(DeliverCar record) {
		return deliverCarMapper.insertSelective(record);
	}
}
