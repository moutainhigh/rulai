package com.unicdata.service.approval.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.approval.ApprovalOrderMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.entity.approval.ApprovalOrder;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.order.Order;
import com.unicdata.service.approval.ApprovalOrderService;
import com.unicdata.service.boutique.RetailSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional(readOnly = false)
@Service
public class ApprovalOrderServiceImpl implements ApprovalOrderService {

    @Autowired
    private ApprovalOrderMapper approvalOrderMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RetailSupportService retailSupportService;

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return approvalOrderMapper.selectListByParams(params).toPageInfo();
    }

    @Override
    public PageInfo<Map<String, Object>> getListByParams2(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return approvalOrderMapper.selectListByParams2(params).toPageInfo();
    }

    @Override
    public void updateApprovalOrder(ApprovalOrder approvalOrder) {
        approvalOrderMapper.updateByPrimaryKeySelective(approvalOrder);
    }

    @Override
    public ApprovalOrder selectApprovalOrder(Integer approvalId) {
        return approvalOrderMapper.selectByPrimaryKey(approvalId);
    }

    @Override
    public boolean ifPass(Integer approvalId) {
        ApprovalOrder approvalOrder = selectApprovalOrder(approvalId);
        Order order = orderMapper.selectByPrimaryKey(approvalOrder.getOrderId());
        BoutiqueRetail boutiqueRetail = retailSupportService.selectBoutiqueRetailDetailByOrderId(order.getId());
        if (approvalOrder != null) {
            if (boutiqueRetail == null) {
                if (approvalOrder.getIfSaleApproval() == 1 && approvalOrder.getSaleApprovalResult() == 1) {
                    return true;
                }
            } else {
                if (approvalOrder.getIfBoutiqueApproval() == 1 && approvalOrder.getIfSaleApproval() == 1 && approvalOrder.getSaleApprovalResult() == 1 && approvalOrder.getBoutiqueApprovalResult() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

	@Override
	public ApprovalOrder selectApprovalByOrderId(Integer orderId) {
		return approvalOrderMapper.selectApprovalByOrderId(orderId);
	}
}
