package com.unicdata.dao.system;

import com.unicdata.entity.system.ShowroomManagerRole;
import com.unicdata.entity.system.ShowroomManagerRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShowroomManagerRoleMapper {
    int countByExample(ShowroomManagerRoleExample example);

    int deleteByExample(ShowroomManagerRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShowroomManagerRole record);

    int insertSelective(ShowroomManagerRole record);

    List<ShowroomManagerRole> selectByExample(ShowroomManagerRoleExample example);

    ShowroomManagerRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShowroomManagerRole record, @Param("example") ShowroomManagerRoleExample example);

    int updateByExample(@Param("record") ShowroomManagerRole record, @Param("example") ShowroomManagerRoleExample example);

    int updateByPrimaryKeySelective(ShowroomManagerRole record);

    int updateByPrimaryKey(ShowroomManagerRole record);
}