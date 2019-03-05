package com.unicdata.service.policy;

import com.unicdata.entity.policy.ArriveBillList;
import com.unicdata.entity.policy.ArriveBillListExample;
import com.unicdata.entity.system.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 到账单service
 * Created by shenyong on 2018/6/3.
 */
public interface ArriveBillListService {

    int deleteByPrimaryKey(Integer id);

    int insert(ArriveBillList record);

    int insertSelective(ArriveBillList record);

    List<ArriveBillList> selectByExample(ArriveBillListExample example);

    ArriveBillList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArriveBillList record);

    int updateByPrimaryKey(ArriveBillList record);

    Map importArriveBill(Employee employee, MultipartFile mfile, Integer rebateId);

    Map selectImportProofreader(MultipartFile mfile, Integer rebateId);
}
