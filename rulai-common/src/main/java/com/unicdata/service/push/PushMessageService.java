package com.unicdata.service.push;

import java.util.List;
import java.util.Map;

public interface PushMessageService {

    /**
     * 创建消息推送
     *
     * @param type        推送业务类型(PushEnum,如果缺少自己加)
     * @param title       标题
     * @param content     内容
     * @param createId    创建人ID
     * @param receivers   接收人ID和跳转地址ID集合  key1：employeeId(接收人ID),  key2:urlId(参照枚举类)  key3:terminal(根据接收人岗位判断接收端，具体值见推送枚举)
     */
    int createPushMessage(Integer type, String title, String content, Integer createId, List<Map<String,Object>> receivers);
}
