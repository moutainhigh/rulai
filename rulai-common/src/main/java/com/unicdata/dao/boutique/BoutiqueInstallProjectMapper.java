package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueInstallProject;
import com.unicdata.entity.boutique.BoutiqueInstallProjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BoutiqueInstallProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueInstallProject record);

    int insertSelective(BoutiqueInstallProject record);

    List<BoutiqueInstallProject> selectByExample(BoutiqueInstallProjectExample example);

    BoutiqueInstallProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueInstallProject record);

    int updateByPrimaryKey(BoutiqueInstallProject record);

    Double getBoutiqueWorkHoursByStoreId(Map<String, Object> map);

    List<Map<String, Object>> selectMouthProjectSum(Map<String,Object> map);

    List<Map<String, Object>> selectMouthProjectGroupDaySum(Map<String,Object> map);

    List<Map<String, Object>> selectMouthProjectGroupDaySumTwo(Map<String,Object> map);

    List<Map<String, Object>> selectBoutiqueInstallDetail(Map<String,Object> map);

    List<Map<String, Object>> selectBoutiqueProjectDetail(Map<String,Object> map);

	void insertBatch(List<BoutiqueInstallProject> installProjects);

	List<BoutiqueInstallProject> selectByInstallId(Integer id);

	int updateInstallByProjectId(@Param("projectId")Integer projectId,@Param("status") Integer status,
			@Param("startTime")Date startTime ,@Param("endTime")Date endTime,@Param("workinghoursUse") Double workinghoursUse);

	Map<String, Integer> selectCountByInstallId(@Param("installId")Integer installId);

}