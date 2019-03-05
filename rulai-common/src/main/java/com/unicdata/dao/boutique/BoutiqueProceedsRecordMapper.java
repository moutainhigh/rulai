package com.unicdata.dao.boutique;

import com.unicdata.entity.boutique.BoutiqueProceedsRecord;
import com.unicdata.entity.boutique.BoutiqueProceedsRecordExample;
import java.util.List;
import java.util.Map;

public interface BoutiqueProceedsRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueProceedsRecord record);

    int insertSelective(BoutiqueProceedsRecord record);

    List<BoutiqueProceedsRecord> selectByExample(BoutiqueProceedsRecordExample example);

    BoutiqueProceedsRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueProceedsRecord record);

    int updateByPrimaryKey(BoutiqueProceedsRecord record);

	Map<String, Object> selectByRetail(Map<String, Object> param);
}