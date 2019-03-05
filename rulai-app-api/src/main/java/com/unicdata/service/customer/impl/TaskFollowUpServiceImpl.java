package com.unicdata.service.customer.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.DictionaryTypeEnum.taskTypes;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.util.DateUtil;
import com.unicdata.constant.ConstantEnum.nextTaskContent;
import com.unicdata.constant.SettleEnum.OrderStatus;
import com.unicdata.dao.customer.TaskFollowUpMapper;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.entity.customer.TaskFollowUp;
import com.unicdata.entity.customer.TaskFollowUpExample;
import com.unicdata.entity.order.Order;
import com.unicdata.service.customer.TaskFollowUpService;

/**
 * 任务跟进服务层
 *
 * @author admin
 */
@Service
public class TaskFollowUpServiceImpl implements TaskFollowUpService {

    @Autowired
    private TaskFollowUpMapper taskFollowUpMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Transactional(readOnly = true)
    public PageInfo selectListByExample(Integer pageNum, Integer pageSize, TaskFollowUp taskFollowUp) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        TaskFollowUpExample example = new TaskFollowUpExample();
        TaskFollowUpExample.Criteria criteria = example.createCriteria();
        criteria.andNextContentEqualTo(1);
        List<TaskFollowUp> list = taskFollowUpMapper.selectByExample(example);
        //封装分页信息
        PageInfo<TaskFollowUp> pageInfo = new PageInfo<TaskFollowUp>(list);
        return pageInfo;
    }

    @Transactional(readOnly = true)
    public Map<String, Object> getTaskNumByEmployee(Integer employeeId) {
        return taskFollowUpMapper.getTaskNumByEmployee(employeeId);
    }

    @Override
    public TaskFollowUp selectTaskByMap(Map<String, Object> map) {
        return taskFollowUpMapper.selectTaskByMap(map);
    }

    @Transactional
    public int addTaskFollowUpRecord(TaskFollowUp taskFollowUp) {
        //修改上次跟进状态为已完成
        taskFollowUpMapper.completeTask(taskFollowUp);
        //新增跟进
        int res = taskFollowUpMapper.insertSelective(taskFollowUp);
        return res;
    }

    @Override
    public PageInfo selectTaskList(Integer pageNum, Integer pageSize, Map<String, Object> map) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = taskFollowUpMapper.selectTaskList(map);
        String currentDate = DateUtil.dateFormat(new Date(), "yyyy-MM-dd");
        int nextContent = Integer.valueOf(String.valueOf(map.get("nextContent")));
        for (Map<String, Object> order : list) {
            //任务跟进
            String nextDate = String.valueOf(order.get("nextDate"));
            int res = DateUtil.daysBetween(currentDate, nextDate);
            String nextDateStr = "";
            String otherDate = "";
            if (nextTaskContent.潜客邀约.getCode() == nextContent) {//预约到店时间
                otherDate = "预约到店：";
            } else if (nextTaskContent.订单跟进.getCode() == nextContent) {
                otherDate = "预计交车：";
            }
            if (res == 0) {
                nextDateStr = "今日跟进";
                otherDate += "今日";
            } else if (res > 0) {
                String dstr = nextDate.substring(5);
                nextDateStr = dstr + "跟进";
                otherDate += dstr;
            } else {
                nextDateStr = "逾期" + (-res) + "天";
                otherDate += "逾期" + (-res) + "天";
            }
            order.put("nextDate", nextDateStr);
            order.put("otherDate", otherDate);
            //建档时间
            String cusCreateTime = String.valueOf(order.get("cusCreateTime"));
            int curRes = DateUtil.daysBetween(cusCreateTime, currentDate);
            if (curRes > 0) {
                cusCreateTime = "建档" + curRes + "天";
            } else {
                cusCreateTime = cusCreateTime.substring(5, 10);
            }
            order.put("cusCreateTime", cusCreateTime);
        }
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        return pageInfo;
    }

    @Override
    public List<Map<String, Object>> selectTaskDateList(Integer cusId) {
        TaskFollowUpExample example = new TaskFollowUpExample();
        TaskFollowUpExample.Criteria criteria = example.createCriteria();
        criteria.andCustomerIdEqualTo(cusId);
        criteria.andThisDateLessThanOrEqualTo(new Date());
        example.setOrderByClause("this_date DESC");
        List<TaskFollowUp> list = taskFollowUpMapper.selectByExample(example);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        String tempStr = "";
        for (TaskFollowUp task : list) {
            String datestr = DateUtil.dateFormat(task.getThisDate(), "MM-dd");
            if (!tempStr.equals(datestr)) {
                map = new HashMap<String, Object>();
                map.put("date", datestr);
                mapList.add(map);
                tempStr = datestr;
            }

        }
        return mapList;
    }

    @Override
    public int selectCountByStore(Map<String, Object> params) {
        return taskFollowUpMapper.selectCountByStore(params);
    }
}
