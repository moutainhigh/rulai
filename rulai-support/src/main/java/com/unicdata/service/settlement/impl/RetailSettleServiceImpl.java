package com.unicdata.service.settlement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicdata.base.constant.ConstantEnumStatus;
import com.unicdata.base.respvo.ApiReturnInfo;
import com.unicdata.constant.BoutiqueEnum;
import com.unicdata.constant.SettleEnum;
import com.unicdata.entity.boutique.BoutiqueProceedsRecord;
import com.unicdata.entity.boutique.BoutiqueRetail;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.boutique.ProceedsRecordSupportService;
import com.unicdata.service.boutique.RetailSupportService;
import com.unicdata.service.settlement.RetailSettleService;

@Service
public class RetailSettleServiceImpl implements RetailSettleService {

	@Autowired
	private ProceedsRecordSupportService proceedsRecordSupportService;

	@Autowired
	private RetailSupportService retailSupportService;

	@Override
	@Transactional
	public ApiReturnInfo<String> addRecord(Employee employee, BoutiqueProceedsRecord boutiqueProceedsRecord) {
		ApiReturnInfo<String> result = new ApiReturnInfo<>();
		// 验证空值
		if (null == boutiqueProceedsRecord.getPayType()) {
			result.setCode(ConstantEnumStatus.PARAM_NULL.getCode());
			result.setMessage(ConstantEnumStatus.PARAM_NULL.getReason());
			return result;
		}
		boutiqueProceedsRecord.setOperatorId(employee.getId());
		boutiqueProceedsRecord.setStoreId(employee.getStoreId());
		int num = proceedsRecordSupportService.insertSelective(boutiqueProceedsRecord);
		if (num <= 0) {
			result.setCode(ConstantEnumStatus.FAIL.getCode());
			result.setMessage(ConstantEnumStatus.FAIL.getReason());
		} else {
			BoutiqueRetail boutiqueRetail = new BoutiqueRetail();
			boutiqueRetail.setId(boutiqueProceedsRecord.getOrderId());
			if (boutiqueProceedsRecord.getProceedsType() == SettleEnum.ProceedsType.EARN.getCode()) {
				// 收款
				boutiqueRetail.setType(BoutiqueEnum.BoutiqueType.FINISHED.getCode());
				retailSupportService.createOutboundByRetailId(boutiqueProceedsRecord.getOrderId());
			} else {
				// 退单
				boutiqueRetail.setType(BoutiqueEnum.BoutiqueType.BACK_PAYMENT.getCode());
			}
			retailSupportService.updateByPrimaryKeySelective(boutiqueRetail);
		}
		return result;

	}

}
