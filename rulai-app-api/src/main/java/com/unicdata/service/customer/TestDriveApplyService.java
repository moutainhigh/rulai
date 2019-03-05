package com.unicdata.service.customer;

import com.unicdata.entity.customer.TestDriveApply;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/15.
 */
public interface TestDriveApplyService {
    //试驾车申请分页查询
    List<Map<String, Object>> testDriveApplyList(Map<String, Object> params);

    int insertSelective(TestDriveApply record);
}
