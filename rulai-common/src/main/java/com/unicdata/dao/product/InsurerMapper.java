package com.unicdata.dao.product;

import com.github.pagehelper.Page;
import com.unicdata.entity.product.Insurer;
import com.unicdata.entity.product.InsurerExample;
import java.util.List;
import java.util.Map;

public interface InsurerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Insurer record);

    int insertSelective(Insurer record);

    List<Insurer> selectByExample(InsurerExample example);

    Insurer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Insurer record);

    int updateByPrimaryKey(Insurer record);

    /**
     * 根据参数获取分页列表
     * @param params
     * @return
     */
    Page<Map<String, Object>> selectListByParams(Map<String,Object> params);
    //获取保险公司列表 wp
    List<Insurer> selectInsure(Integer storeId);
    //获取保险公司下的险种 wp
    List<Map<String, Object>> selectInsurerType(Map<String, Object> map);
    //保险公司及险种 wp
    List<Insurer> selectInsurerAndType();
}