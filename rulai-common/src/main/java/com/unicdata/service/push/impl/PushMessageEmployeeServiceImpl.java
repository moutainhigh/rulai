package com.unicdata.service.push.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.unicdata.constant.PushEnum;
import com.unicdata.dao.push.PushMessageEmployeeMapper;
import com.unicdata.dao.push.PushMessageMapper;
import com.unicdata.entity.push.PushMessage;
import com.unicdata.entity.push.PushMessageEmployee;
import com.unicdata.entity.push.PushMessageEmployeeExample;
import com.unicdata.entity.push.PushMessageExample;
import com.unicdata.service.push.PushMessageEmployeeService;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class PushMessageEmployeeServiceImpl implements PushMessageEmployeeService {

    @Autowired
    private PushMessageMapper pushMessageMapper;

    @Autowired
    private PushMessageEmployeeMapper pushMessageEmployeeMapper;

    @Override
    public List<Map<String, Object>> listByEmployeeId(Integer employeeId) {
        PushMessageEmployeeExample pushMessageEmployeeExample = new PushMessageEmployeeExample();
        PushMessageEmployeeExample.Criteria criteria = pushMessageEmployeeExample.createCriteria();
        criteria.andEmployeeIdEqualTo(employeeId);
        //当前用户未查阅的消息
        criteria.andViewStateEqualTo(PushEnum.ViewStates.NO_VIEW.getCode());
        //pc端和双端都需要推送的消息
        criteria.andTerminalIn(new ArrayList(Arrays.asList(PushEnum.PushTerminal.PC.getCode(),PushEnum.PushTerminal.BOTH)));
        List<PushMessageEmployee> pmes = pushMessageEmployeeMapper.selectByExample(pushMessageEmployeeExample);
        if (pmes == null || pmes.isEmpty()) {
            return Lists.newArrayList();
        }
        //key:消息ID value:跳转地址ID
        Map<Integer, Integer> myMessages = Maps.newHashMap();
        for (PushMessageEmployee entity : pmes) {
            myMessages.put(entity.getMessageId(), entity.getUrlId());
        }
        List<Map<String, Object>> result = Lists.newArrayList();
        PushMessageExample pushMessageExample = new PushMessageExample();
        PushMessageExample.Criteria criteria2 = pushMessageExample.createCriteria();
        criteria2.andIdIn(Lists.<Integer>newArrayList(myMessages.keySet()));
        pushMessageExample.setOrderByClause("create_time ASC");
        List<PushMessage> messages = pushMessageMapper.selectByExample(pushMessageExample);
        for (PushMessage message : messages) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("messageId", message.getId());
            map.put("title", message.getTitle());
            map.put("content", message.getContent());
            map.put("url", myMessages.get(message.getId()));
            result.add(map);
        }
        return result;
    }

    @Override
    public PushMessageEmployee getByEmployeeIdAndMessageId(Integer messageId, Integer employeeId) {
        PushMessageEmployeeExample example = new PushMessageEmployeeExample();
        PushMessageEmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmployeeIdEqualTo(employeeId);
        criteria.andMessageIdEqualTo(messageId);
        return pushMessageEmployeeMapper.selectByExample(example) == null ? null : pushMessageEmployeeMapper.selectByExample(example).get(0);
    }

    @Transactional(readOnly = false)
    @Override
    public int updateSelective(PushMessageEmployee pushMessageEmployee) {
        int result = pushMessageEmployeeMapper.updateByPrimaryKeySelective(pushMessageEmployee);
        return result;
    }

}
