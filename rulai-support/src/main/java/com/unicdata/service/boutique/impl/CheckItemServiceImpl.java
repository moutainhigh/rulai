package com.unicdata.service.boutique.impl;

import com.unicdata.dao.boutique.CheckItemMapper;
import com.unicdata.entity.boutique.CheckItem;
import com.unicdata.service.boutique.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemMapper checkItemMapper;

}
