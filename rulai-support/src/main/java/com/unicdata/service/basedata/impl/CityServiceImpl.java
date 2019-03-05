package com.unicdata.service.basedata.impl;

import com.unicdata.service.basedata.CityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cityService")
@Transactional(readOnly = true)
public class CityServiceImpl implements CityService {
}
