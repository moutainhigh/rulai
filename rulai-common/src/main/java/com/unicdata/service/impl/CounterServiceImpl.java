package com.unicdata.service.impl;

import com.unicdata.base.util.StringUtil;
import com.unicdata.dao.counter.CounterMapper;
import com.unicdata.entity.counter.Counter;
import com.unicdata.entity.counter.CounterExample;
import com.unicdata.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by shenyong on 2018/5/31.
 */
@Service
public class CounterServiceImpl implements CounterService{

    @Autowired
    private CounterMapper counterMapper;

    @Override
    public int insert(Counter record) {
        return counterMapper.insert(record);
    }

    @Override
    public int insertSelective(Counter record) {
        return counterMapper.insertSelective(record);
    }

    @Override
    public List<Counter> selectByExample(CounterExample example) {
        return counterMapper.selectByExample(example);
    }

    /**
     * 业务自定义code生成器<br/>
     * 使用时请在 Counter.java 中为codePrefix定义常量并写好注释
     * @param codePrefix 传入前缀，根据各自业务调整（唯一键）必传字段
     * @param dateFormat 时间格式 如：yyMM （默认null）
     * @param number 位数（默认6位）
     * @return 如：codePrefix + new SimpleDateFormat(dateFormat) + number位数的自增计数值（数值前面补0） 如：KH1805000001
     */
    @Override
    public synchronized String generateCode(String codePrefix,String dateFormat ,Integer number) {
        if(StringUtil.isBlank(codePrefix)){
            return null;
        }
        String code = codePrefix ;
        if(StringUtil.isNotBlank(dateFormat)) {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            code += sdf.format(System.currentTimeMillis());
        }
        number = (number == null || number <=0 ? 6 : number);
        Integer counterCode = counterMapper.findCounterCode(codePrefix);
        if (counterCode == null || counterCode <= 0) {
            Counter counter = new Counter();
            counter.setCodePrefix(codePrefix);
            counter.setCounter(2);
            counterMapper.insert(counter);
            code += String.format("%0"+number+"d", 1);
        } else {
            if(String.valueOf(counterCode).length() > number)
                number = number+1;
            counterMapper.updCounterCode(codePrefix);
            code += String.format("%0"+number+"d", counterCode);
        }

        return code;
    }
    
    /**
     * 业务自定义code生成器<br/>
     * 使用时请在 Counter.java 中为codePrefix定义常量并写好注释
     * @param codePrefix 传入前缀，根据各自业务调整（唯一键）必传字段
     * @param number 位数（默认6位）
     * @return 如：codePrefix + new SimpleDateFormat(dateFormat) + number位数的自增计数值（数值前面补0） 如：KH1805000001
     */
    @Override
    public synchronized String generateCodeBoutique(String codePrefix,Integer number) {
    	if(StringUtil.isBlank(codePrefix)){
    		return null;
    	}
    	String code = "";

    	number = (number == null || number <=0 ? 6 : number);
    	Integer counterCode = counterMapper.findCounterCode(codePrefix);
    	if (counterCode == null || counterCode <= 0) {
    		Counter counter = new Counter();
    		counter.setCodePrefix(codePrefix);
    		counter.setCounter(2);
    		counterMapper.insert(counter);
    		code += String.format("%0"+number+"d", 1);
    	} else {
    		if(String.valueOf(counterCode).length() > number)
    			number = number+1;
    		counterMapper.updCounterCode(codePrefix);
    		code += String.format("%0"+number+"d", counterCode);
    	}
    	
    	return code;
    }
}
