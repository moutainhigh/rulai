package com.unicdata.service;

import com.unicdata.entity.counter.Counter;
import com.unicdata.entity.counter.CounterExample;

import java.util.List;

/**
 * 业务自定义code 生成service
 * Created by shenyong on 2018/5/31.
 */
public interface CounterService {
    int insert(Counter record);

    int insertSelective(Counter record);

    List<Counter> selectByExample(CounterExample example);

    /**
     * 业务自定义code生成器<br/>
     * 使用时请在 Counter.java 中为codePrefix定义常量并写好注释
     * @param codePrefix 传入前缀，根据各自业务调整（唯一键）必传字段
     * @param dateFormat 时间格式 如：yyMM （默认null）
     * @param number 位数（默认6位）
     * @return 如：codePrefix + new SimpleDateFormat(dateFormat) + number位数的自增计数值（数值前面补0） 如：KH1805000001
     */
    String generateCode(String codePrefix,String dateFormat ,Integer number) ;

	String generateCodeBoutique(String codePrefix, Integer number);

}
