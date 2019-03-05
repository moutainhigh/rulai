package com.unicdata.service.push.impl;

import com.alibaba.fastjson.JSON;
import com.unicdata.constant.PushEnum;
import com.unicdata.dao.push.PushMessageEmployeeMapper;
import com.unicdata.dao.push.PushMessageMapper;
import com.unicdata.entity.push.PushMessage;
import com.unicdata.entity.push.PushMessageEmployee;
import com.unicdata.service.push.PushMessageService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private PushMessageMapper pushMessageMapper;

    @Autowired
    private PushMessageEmployeeMapper pushMessageEmployeeMapper;


    @Transactional(readOnly = false)
    @Override
    public int createPushMessage(Integer type, String title, String content, Integer createId, List<Map<String, Object>> receivers) {
        PushMessage message = new PushMessage();
        message.setType(type);
        if (StringUtils.isNotBlank(title)) {
            message.setTitle(title);
        }
        if (content != null) {
            message.setContent(content);
        }
        message.setCreaterId(createId);
        message.setCreateTime(new Date());
        //初始为未发送
        message.setSend(PushEnum.SendStates.NO_SEND.getCode());
        int result = pushMessageMapper.insertSelective(message);
        Integer messageId = message.getId();
        if (receivers != null) {
            for (Map<String, Object> receiver : receivers) {
                PushMessageEmployee messageEmployee = new PushMessageEmployee();
                messageEmployee.setMessageId(messageId);
                //初始化为未查看
                messageEmployee.setViewState(PushEnum.ViewStates.NO_VIEW.getCode());
                messageEmployee.setEmployeeId(receiver.get("employeeId") != null ? (Integer) receiver.get("employeeId") : null);
                messageEmployee.setUrlId(receiver.get("urlId") != null ? (Integer) receiver.get("urlId") : null);
                messageEmployee.setTerminal(receiver.get("terminal") != null ? (Integer) receiver.get("terminal") : null);
                pushMessageEmployeeMapper.insertSelective(messageEmployee);
            }
        }
        return result;
    }
}
