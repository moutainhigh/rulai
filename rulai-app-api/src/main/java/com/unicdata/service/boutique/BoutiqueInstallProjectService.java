package com.unicdata.service.boutique;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/7.
 */
public interface BoutiqueInstallProjectService {
    /**
     * 某日洗车完成数
     *
     * @param map
     * @return
     */
    Double getBoutiqueWorkHoursByStoreId(Map<String, Object> map);

    /**
     * 某日某月排程分页
     *
     * @param map
     * @return
     */
    List<Map<String, Object>> selectMouthProjectSum(Map<String, Object> map);

    /**
     * 按日分组，统计数量2
     *
     * @param map
     * @return
     */
    List<Map<String, Object>> selectMouthProjectGroupDaySumTwo(Map<String, Object> map);

    /**
     * 按日分组，统计数量分支2
     *
     * @param map
     * @return
     */
    List<Map<String, Object>> selectMouthProjectGroupDaySum(Map<String, Object> map);

    /**
     * 精品排程详情，根据 id查询
     * @param map
     * @return
     */
    List<Map<String, Object>> selectBoutiqueInstallDetail(Map<String,Object> map);

    /**
     * 精品项目排程详情，根据 id查询
     * @param map
     * @return
     */
    List<Map<String, Object>> selectBoutiqueProjectDetail(Map<String,Object> map);
}
