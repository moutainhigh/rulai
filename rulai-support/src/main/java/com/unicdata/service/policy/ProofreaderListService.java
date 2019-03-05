package com.unicdata.service.policy;

import com.unicdata.entity.policy.ProofreaderList;
import com.unicdata.entity.policy.ProofreaderListExample;
import com.unicdata.entity.system.Employee;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 核对单service
 * Created by shenyong on 2018/6/3.
 */
public interface ProofreaderListService {

    int deleteByPrimaryKey(Integer id);

    int insert(ProofreaderList record);

    int insertSelective(ProofreaderList record);

    List<ProofreaderList> selectByExample(ProofreaderListExample example);

    ProofreaderList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProofreaderList record);

    int updateByPrimaryKey(ProofreaderList record);

    /**
     * 核对单导入
     * @param employee
     * @param mfile
     * @param rebateId
     * @return
     */
    Map importProofreader(Employee employee, MultipartFile mfile, Integer rebateId );

    Map selectImportProofreader(MultipartFile mfile, Integer rebateId);
}
