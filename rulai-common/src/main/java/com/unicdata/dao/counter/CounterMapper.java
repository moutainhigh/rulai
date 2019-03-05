package com.unicdata.dao.counter;

import com.unicdata.entity.counter.Counter;
import com.unicdata.entity.counter.CounterExample;
import java.util.List;

public interface CounterMapper {
    int insert(Counter record);

    int insertSelective(Counter record);

    List<Counter> selectByExample(CounterExample example);

    Integer findCounterCode(String codePrefix);

    int updCounterCode(String codePrefix);
}