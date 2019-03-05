package com.unicdata.dao.boutique;

import com.github.pagehelper.Page;
import com.unicdata.condition.BoutiqueRetailCondition;
import com.unicdata.condition.RetailSettleCondition;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.boutique.BoutiqueRetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BoutiqueRetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BoutiqueRetail record);

    int insertSelective(BoutiqueRetail record);

    List<BoutiqueRetail> selectByExample(BoutiqueRetailExample example);

    BoutiqueRetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BoutiqueRetail record);

    int updateByPrimaryKey(BoutiqueRetail record);

    Page<Map<String, Object>> selectListByCondition(RetailSettleCondition retailSettleCondition);

    BoutiqueRetail selectByCondition(BoutiqueRetail record);

    List<Map<String, Object>> getMouthBoutiqueRetailByStoreId(Map<String, Object> map);

    List<Map<String, Object>> getBoutiqueEetailRecordByMouthId(Map<String, Object> map);

    List<Map<String, Object>> getBoutiqueOrderId(Integer orderId);

    List<Map<String, Object>> getBoutiqueRetailByOId(Integer orderId);

    Integer getBoutiqueDeliverCarByStoreId(Map<String, Object> map);

    Double getMouthCostSumByisPackage(Map<String, Object> map);

    int insertUseGeneratedKeys(BoutiqueRetail retail);

    List<Map<String, Object>> getBoutiqueInformationOrderId(Integer orderId);

    List<Map<String, Object>> getBoutiquePackageOrderId(Integer orderId);

    BoutiqueRetail selectBoutiqueRetailDetailById(Integer id);

    Page<Map<String, Object>> selectBoutiqueRetailPage(BoutiqueRetailCondition condition);

    BoutiqueRetail selectBoutiqueRetailDetailByOrderId(@Param("orderId") Integer orderId);

    int approvalRetail(@Param("reatilId") Integer reatilId, @Param("type") Integer type);

    //逻辑删除
    int delBoutiqueRetail(Map<String, Object> params);

    Page<Map<String, Object>> getMouthBoutiqueRetailByStoreIdPage(Map<String, Object> retail);

    int updateBoutiqueRetailByOrderId(Map<String, Object> params);
}