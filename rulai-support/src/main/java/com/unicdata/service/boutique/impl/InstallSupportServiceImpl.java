package com.unicdata.service.boutique.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.unicdata.dao.order.ReceiptMapper;
import com.unicdata.entity.order.Receipt;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicdata.base.util.DateUtil;
import com.unicdata.constant.BoutiqueEnum;
import com.unicdata.constant.BoutiqueEnum.IntsallType;
import com.unicdata.dao.boutique.BoutiqueInstallMapper;
import com.unicdata.dao.boutique.BoutiqueInstallProjectMapper;
import com.unicdata.entity.boutique.BoutiqueInstall;
import com.unicdata.entity.boutique.BoutiqueInstallProject;
import com.unicdata.entity.order.Order;
import com.unicdata.service.boutique.InstallSupportService;
import com.unicdata.service.order.SaleOrderService;

@Service
public class InstallSupportServiceImpl extends BoutiqueInstallServiceImpl implements InstallSupportService {

    @Autowired
    private BoutiqueInstallProjectMapper boutiqueInstallProjectMapper;

    @Autowired
    private BoutiqueInstallMapper boutiqueInstallMapper;

    @Autowired
    private SaleOrderService saleOrderService;


    @Override
    public Double getBoutiqueWorkHoursByStoreId(Map<String, Object> map) {
        return boutiqueInstallProjectMapper.getBoutiqueWorkHoursByStoreId(map);
    }

    @Override
    @Transactional
    public int updateInstallByProjectId(Integer projectId, Integer status) {
        BoutiqueInstallProject project = boutiqueInstallProjectMapper.selectByPrimaryKey(projectId);

        Date startTime = null;
        Date endTime = null;

        switch (status) {
            case (2): {
                startTime = new Date();
                project.setWorkinghoursUse(null);
                break;
            }
            case (3): {
                endTime = new Date();
                startTime = project.getStartTime();
                long use = endTime.getTime() - startTime.getTime();
                project.setWorkinghoursUse(Double.parseDouble((use / 3600000f) + ""));
                break;
            }
            default: {
                return 0;
            }
        }

        int update = boutiqueInstallProjectMapper.updateInstallByProjectId(projectId, status, startTime, endTime, project.getWorkinghoursUse());
        if (update >= 1) {
            Map<String, Integer> countMap = boutiqueInstallProjectMapper.selectCountByInstallId(project.getInstallId());
            int allInstall = Integer.parseInt(countMap.get("allInstall") + "");//总加装数
            int isInstall = Integer.parseInt(countMap.get("isInstall") + "");//已完成加装数
            Integer installId = project.getInstallId();

            BoutiqueInstall boutiqueInstall = boutiqueInstallMapper.selectByPrimaryKey(installId);
            Order order = saleOrderService.selectByPrimaryKey(boutiqueInstall.getOrderId());
            int code = BoutiqueEnum.IntsallType.PART.getCode();
            if (allInstall == isInstall) {
                code = BoutiqueEnum.IntsallType.ALL.getCode();
                order.setBoutiqueStatus(3);
            } else if (isInstall == 0) {
                order.setBoutiqueStatus(2);
            }
            boutiqueInstallMapper.updateStatusById(installId, code, startTime, endTime);
            saleOrderService.updateOrder(order);
        }
        return update;
    }

    @Override
    public PageInfo<Map<String, Object>> selectListByParams2(List<Integer> retailIds, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return boutiqueInstallMapper.selectListByParams2((retailIds == null || retailIds.isEmpty()) ? null : retailIds).toPageInfo();
    }

    @Override
    public Map<Integer, BigDecimal> getSaleQuantityByboutiqueIds(Map<String, Object> params) {
        Map<Integer, BigDecimal> result = Maps.newHashMap();
        List<Map<String, Object>> list = boutiqueInstallMapper.getSaleQuantityByboutiqueIds(params);
        if (list == null || list.isEmpty()) {
            return result;
        }
        for (Map<String, Object> map : list) {
            result.put((Integer) map.get("informationId"), (BigDecimal) map.get("quantity"));
        }
        return result;
    }

    @Override
    public BigDecimal getSumSaleAmount2(List<Integer> retailIds) {
        return boutiqueInstallMapper.getSumSaleAmount2((retailIds == null || retailIds.isEmpty()) ? null : retailIds);
    }

    @Override
    public BigDecimal getSumCost2(List<Integer> retailIds) {
        return boutiqueInstallMapper.getSumCost2((retailIds == null || retailIds.isEmpty()) ? null : retailIds);
    }

    @Override
    public List<Map<String, Object>> getDecorationsByIds2(Map<String, Object> params) {
        return boutiqueInstallMapper.getDecorationsByIds2(params);
    }

    @Override
    public List<Map<String, Object>> getSumOrderByBoutiqueIds2(Map<String, Object> params) {
        return boutiqueInstallMapper.getSumOrderByBoutiqueIds2(params);
    }

    @Override
    public Map<Integer, BigDecimal> getSalePriceByboutiqueIds(Map<String, Object> params) {
        Map<Integer, BigDecimal> result = Maps.newHashMap();
        List<Map<String, Object>> list = boutiqueInstallMapper.getSaleQuantityByboutiqueIds(params);
        if (list == null || list.isEmpty()) {
            return result;
        }
        for (Map<String, Object> map : list) {
            result.put((Integer) map.get("informationId"), (BigDecimal) map.get("saleAmount"));
        }
        return result;
    }
}
