package com.unicdata.service.system;

import com.unicdata.entity.system.ShowroomManagerRole;
import com.unicdata.entity.system.ShowroomManagerRoleExample;

import java.util.List;

/**
 * Created by lenovo on 2018/6/4.
 */
public interface ShowroomManagerRoleService {
    int insertSelective(ShowroomManagerRole record);

    int updateByPrimaryKeySelective(ShowroomManagerRole record);

    List<ShowroomManagerRole> selectByExample(ShowroomManagerRoleExample example);
}
