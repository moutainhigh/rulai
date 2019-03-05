package com.unicdata.service.boutique.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.constant.BoutiqueEnum;
import com.unicdata.dao.boutique.BoutiqueInformationMapper;
import com.unicdata.dao.boutique.CheckItemMapper;
import com.unicdata.dao.boutique.DepotCheckMapper;
import com.unicdata.dao.car.CarFamilyMapper;
import com.unicdata.entity.boutique.BoutiqueInformation;
import com.unicdata.entity.boutique.CheckItem;
import com.unicdata.entity.boutique.DepotCheck;
import com.unicdata.service.CounterService;
import com.unicdata.service.boutique.DepotCheckService;
import com.unicdata.util.NumberGenerateUtil;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class DepotCheckServiceImpl implements DepotCheckService {

    @Autowired
    private DepotCheckMapper depotCheckMapper;

    @Autowired
    private BoutiqueInformationMapper boutiqueInformationMapper;

    @Autowired
    private CheckItemMapper checkItemMapper;

    @Autowired
    private CarFamilyMapper carFamilyMapper;

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return depotCheckMapper.selectListByParams(params).toPageInfo();
    }

    @Override
    public DepotCheck getCheckById(Integer checkId) {
        return depotCheckMapper.selectByPrimaryKey(checkId);
    }

    @Override
    public List<Map<String, Object>> getCheckItemsByCheckId(Integer checkId) {
        return checkItemMapper.getCheckItemsByParams(checkId, null);
    }

    @Override
    public List<Map<String, Object>> getCheckItemsByWarehouseIds(String warehouseIds) {
        List<Integer> ids = Lists.newArrayList();
        String[] idStrs = warehouseIds.split(",");
        for (String id : idStrs) {
            ids.add(Integer.valueOf(id));
        }
        return boutiqueInformationMapper.getBoutiquesByWarehouseId(ids);
    }

    @Transactional(readOnly = false)
    @Override
    public int save(DepotCheck depotCheck) {
        //盘点单ID
        Integer checkId = depotCheck.getId();
        //如果是新增
        if (checkId == null) {
            //盘点单编号生成
            depotCheck.setNumber(NumberGenerateUtil.getDepotNumber());
            depotCheck.setAdjusted(Boolean.FALSE);
            //盘点时间
            depotCheck.setCheckTime(new Date());
            //保存盘点单
            depotCheckMapper.insert(depotCheck);
            checkId = depotCheck.getId();

        } else {//如果是修改
            depotCheckMapper.updateByPrimaryKeySelective(depotCheck);
            //删除盘点项
            checkItemMapper.deleteByCheckId(checkId);
        }
        List<CheckItem> items = depotCheck.getCheckItems();
        //盘点单盈
        BigDecimal gain = BigDecimal.ZERO;
        //盘点单亏
        BigDecimal loss = BigDecimal.ZERO;
        for (CheckItem item : items) {
            if (item.getPhysicalInventory() != null && item.getPhysicalCountQuantity() != null) {
                BigDecimal differenceQuantity = item.getPhysicalInventory().subtract(item.getPhysicalCountQuantity());
                //插入盈亏数量
                item.setDifferenceQuantity(differenceQuantity);
            }
            item.setCheckId(checkId);
            //如果是盘点确认那么计算盈亏金额（保存为草稿先不计算）
            if (Objects.equals(depotCheck.getState(), BoutiqueEnum.DepotCheckStates.CONFIRMED.getCode())) {
                //盈亏金额
                BigDecimal differentMoney = item.getDifferenceQuantity().multiply(item.getCost());
                item.setDifferenceMoney(differentMoney);
                //盘点单盈亏
                if (differentMoney.doubleValue() > 0D) {
                    gain = gain.add(differentMoney);
                } else if (differentMoney.doubleValue() < 0D) {
                    loss = loss.add(differentMoney);
                }
            }
            checkItemMapper.insertSelective(item);
        }
        depotCheck.setGain(gain);
        depotCheck.setLoss(loss);
        //同步盘点单中的盈亏金额
        depotCheckMapper.updateByPrimaryKeySelective(depotCheck);
        return checkId;
    }

    @Transactional(readOnly = false)
    @Override
    public void scrap(DepotCheck check) {
        depotCheckMapper.updateByPrimaryKeySelective(check);
    }

    @Override
    public DepotCheck getCheckByNumber(String number) {
        return depotCheckMapper.getCheckByNumber(number);
    }

    @Override
    public Map<String, Object> getDifferenceByCheckId(Integer checkId) {
        Map<String, Object> result = Maps.newHashMap();
        DepotCheck check = depotCheckMapper.selectByPrimaryKey(checkId);
        List<Map<String, Object>> gain = checkItemMapper.getCheckItemsByParams(checkId, true);
        //插入车系分类
        for (Map<String, Object> map : gain) {
            if (map.get("familyIds") != null && StringUtils.isNotBlank(map.get("familyIds").toString())) {
                map.put("vehicleName", carFamilyMapper.getNamesByIds(map.get("familyIds").toString()));
            } else {
                map.put("vehicleName", "");
            }
        }
        List<Map<String, Object>> loss = checkItemMapper.getCheckItemsByParams(checkId, false);
        //插入车系分类
        for (Map<String, Object> map : loss) {
            if (map.get("familyIds") != null && StringUtils.isNotBlank(map.get("familyIds").toString())) {
                map.put("vehicleName", carFamilyMapper.getNamesByIds(map.get("familyIds").toString()));
            } else {
                map.put("vehicleName", "");
            }
        }
        result.put("gain", gain == null ? Lists.newArrayList() : gain);
        result.put("loss", loss == null ? Lists.newArrayList() : loss);
        result.put("gainSum", check.getGain());
        result.put("lossSum", check.getLoss());
        result.put("adjusted", check.getAdjusted());
        return result;
    }

    @Transactional(readOnly = false)
    @Override
    public void updateDepot(List<CheckItem> items) throws Exception {
        //调整库存
        for (CheckItem item : items) {
            BoutiqueInformation bi = boutiqueInformationMapper.selectByPrimaryKey(item.getBoutiqueId());
            bi.setStock(item.getPhysicalInventory().intValue());
            bi.setTaxCost(bi.getTaxPrice().multiply(item.getPhysicalInventory()));
            //乐观锁更新库存，更新3次不成功提示更新库存失败
            int result = 0;
            for (int i = 0; i < 3; i++) {
                result = boutiqueInformationMapper.updateStock(bi);
                if (result == 1) {
                    break;
                }
            }
            if (result == 0) {
                throw new RuntimeException("更新库存失败");
            }
        }
        //如果存在差异项，将盘点单状态改变为已调整
        if (!items.isEmpty()) {
            Integer checkId = items.get(0).getCheckId();
            DepotCheck check = depotCheckMapper.selectByPrimaryKey(checkId);
            check.setAdjusted(Boolean.TRUE);
            depotCheckMapper.updateByPrimaryKeySelective(check);
        }
    }


}
