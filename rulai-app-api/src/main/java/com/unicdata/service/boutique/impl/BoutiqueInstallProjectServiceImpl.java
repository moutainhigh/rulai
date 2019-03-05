package com.unicdata.service.boutique.impl;

import com.unicdata.constant.BoutiqueEnum;
import com.unicdata.constant.CarEnum;
import com.unicdata.dao.boutique.BoutiqueInstallProjectMapper;
import com.unicdata.service.boutique.BoutiqueInstallProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/7.
 */
@Service
public class BoutiqueInstallProjectServiceImpl implements BoutiqueInstallProjectService {
    @Autowired
    private BoutiqueInstallProjectMapper boutiqueInstallProjectMapper;


    @Override
    public Double getBoutiqueWorkHoursByStoreId(Map<String, Object> map) {
        return boutiqueInstallProjectMapper.getBoutiqueWorkHoursByStoreId(map);
    }

    @Override
    public List<Map<String, Object>> selectMouthProjectSum(Map<String, Object> map) {
        List<Map<String, Object>> mapList = boutiqueInstallProjectMapper.selectMouthProjectSum(map);
        for (Map<String, Object> objectMap : mapList) {
            Object o = objectMap.get("expected_complete");
            if (o != null) {
                String format1 = o.toString();
                objectMap.put("expected_complete", format1.substring(0, 10));
            }
            Object a = objectMap.get("expected_delivery");
            if (a != null) {
                String format2 = a.toString();
                objectMap.put("expected_delivery", format2.substring(0, 10));
            }
            Object b = objectMap.get("follow_up");
            if (b != null) {
                String format2 = b.toString();
                objectMap.put("follow_up", format2.substring(0, 10));
            }
            Object source = objectMap.get("source");
            if (source != null) {
                Integer s = Integer.valueOf(source.toString());
                BoutiqueEnum.BoutiqueSource[] values = BoutiqueEnum.BoutiqueSource.values();
                String reason = values[s].getReason();
                objectMap.put("source", reason);
            }
            Object status = objectMap.get("status");
            if (status != null) {
                Integer s = Integer.valueOf(status.toString());
                BoutiqueEnum.IntsallType[] values = BoutiqueEnum.IntsallType.values();
                String reason = values[s].getReason();
                objectMap.put("status", reason);
            }
            Object expect_workinghours = objectMap.get("expect_workinghours");
            objectMap.put("expect_workinghours", expect_workinghours == null ? "" : expect_workinghours.toString() + "H");
        }
        return mapList;
    }

    @Override
    public List<Map<String, Object>> selectMouthProjectGroupDaySum(Map<String, Object> map) {
        return boutiqueInstallProjectMapper.selectMouthProjectGroupDaySum(map);
    }

    @Override
    public List<Map<String, Object>> selectMouthProjectGroupDaySumTwo(Map<String, Object> map) {
        return boutiqueInstallProjectMapper.selectMouthProjectGroupDaySumTwo(map);
    }

    @Override
    public List<Map<String, Object>> selectBoutiqueInstallDetail(Map<String, Object> map) {
        List<Map<String, Object>> mapList = boutiqueInstallProjectMapper.selectBoutiqueInstallDetail(map);
        for (Map<String, Object> objectMap : mapList) {
            Object a = objectMap.get("expected_delivery");
            if (a != null) {
                String format2 = a.toString();
                objectMap.put("expected_delivery", format2.substring(0, 10));
            }
            Object o = objectMap.get("expected_complete");
            if (o != null) {
                String format1 = o.toString();
                objectMap.put("expected_complete", format1.substring(0, 10));
            }
            Object b = objectMap.get("follow_up");
            if (b != null) {
                String format2 = b.toString();
                objectMap.put("follow_up", format2.substring(0, 10));
            }
            Object status = objectMap.get("status");
            if (status != null) {
                Integer s = Integer.valueOf(status.toString());
                BoutiqueEnum.IntsallType[] values = BoutiqueEnum.IntsallType.values();
                String reason = values[s].getReason();
                objectMap.put("status", reason);
            }
            Object source = objectMap.get("source");
            if (source != null) {
                Integer s = Integer.valueOf(source.toString());
                BoutiqueEnum.BoutiqueSource[] values = BoutiqueEnum.BoutiqueSource.values();
                String reason = values[s].getReason();
                objectMap.put("source", reason);
            }
        }
        return mapList;
    }

    @Override
    public List<Map<String, Object>> selectBoutiqueProjectDetail(Map<String, Object> map) {
        List<Map<String, Object>> mapList = boutiqueInstallProjectMapper.selectBoutiqueProjectDetail(map);
        for (Map<String, Object> objectMap : mapList) {
            Object status = objectMap.get("status");
            if (status != null) {
                Integer s = Integer.valueOf(status.toString());
                BoutiqueEnum.IntsallType[] values = BoutiqueEnum.IntsallType.values();
                String reason = values[s].getReason();
                objectMap.put("status", reason);
            }
        }
        return mapList;
    }
}
