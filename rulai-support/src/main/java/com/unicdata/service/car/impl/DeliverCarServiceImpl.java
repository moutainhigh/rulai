package com.unicdata.service.car.impl;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.unicdata.base.util.FileUtil;
import com.unicdata.dao.order.DeliverCarMapper;
import com.unicdata.entity.order.DeliverCar;
import com.unicdata.service.car.DeliverCarService;

/**
 * Created by lenovo on 2018/6/5.
 */
@Service
public class DeliverCarServiceImpl implements DeliverCarService {
    @Autowired
    private DeliverCarMapper deliverCarMapper;


    @Override
    public int getMothDeliverCarNumByStoreId(Map<String, Object> map) {
        return deliverCarMapper.getMothDeliverCarNumByStoreId(map);
    }

    @Override
	public int addDeliverCar(DeliverCar record,MultipartFile file) {
    	if(null != file && StringUtils.isNotBlank(file.getOriginalFilename())){
			String fileName = file.getOriginalFilename();//文件名
			try {
				String address = FileUtil.uploadFile(file.getInputStream(),fileName,UUID.randomUUID().toString(),"rulai","D:/");
				record.setDeliverImg(address);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return deliverCarMapper.insertSelective(record);
	}
}
