package com.unicdata.service.customer.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.dao.customer.TaskFollowUpMapper;
import com.unicdata.entity.customer.TaskFollowUp;
import com.unicdata.entity.customer.TaskFollowUpExample;
import com.unicdata.service.customer.TaskFollowUpService;
import com.unicdata.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class TaskFollowUpServiceImpl implements TaskFollowUpService {

    @Autowired
    private TaskFollowUpMapper taskFollowUpMapper;

    @Override
    public List<TaskFollowUp> getTaskFollowUpsBy(Integer customerId ,String date) {
        TaskFollowUpExample example = new TaskFollowUpExample();
        TaskFollowUpExample.Criteria criteria = example.createCriteria();
        if (customerId != null) {
            criteria.andCustomerIdEqualTo(customerId);
        }
        if (StringUtils.isNotBlank(date)) {
            Date todayBegin = DateUtil.stringToDate(date + " 00:00:00", DateUtil.sdf1);
            Date todayEnd = DateUtil.stringToDate(date + " 23:59:59", DateUtil.sdf1);
            criteria.andNextDateBetween(todayBegin, todayEnd);
        }
        example.setOrderByClause("id desc");
        List<TaskFollowUp> list = taskFollowUpMapper.selectByExample(example);
        return list;
    }

    @Override
    public String getLastFollowTime(Integer customerId) {
        List<TaskFollowUp> follows = getTaskFollowUpsBy(customerId,null);
        if (follows == null || follows.isEmpty()) {
            return "";
        }
        TaskFollowUp follow = follows.get(0);
        String nextDate = follow.getNextDate() == null ? "" : DateUtil.dateFormat(follow.getNextDate(), DateUtil.sdf2);
        return nextDate;
    }

    @Transactional(readOnly = false)
    @Override
    public void save(TaskFollowUp taskFollowUp) {
        if (taskFollowUp.getId() == null) {
            taskFollowUpMapper.insertSelective(taskFollowUp);
        } else {
            taskFollowUpMapper.updateByPrimaryKeySelective(taskFollowUp);
        }
    }

    @Override
    public PageInfo<Map<String, Object>> getListByParams(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return taskFollowUpMapper.selectListByParams(params).toPageInfo();
    }

    @Override
    public PageInfo<Map<String, Object>> getListByParams2(Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        return taskFollowUpMapper.selectListByParams2(params).toPageInfo();
    }

	@Override
	public int selectCountByStore(Map<String, Object> params) {
		return taskFollowUpMapper.selectCountByStore(params);
	}
}
