package com.unicdata.service.product.impl;

import com.unicdata.dao.product.MealItemMapper;
import com.unicdata.service.product.MealItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MealItemServiceImpl implements MealItemService {

    @Autowired
    private MealItemMapper mealItemMapper;

}
