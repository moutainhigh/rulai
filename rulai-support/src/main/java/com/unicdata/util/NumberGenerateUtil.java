package com.unicdata.util;

import com.unicdata.base.constant.Constant;
import com.unicdata.controller.HomeBaseController;
import com.unicdata.entity.system.DistributorStoreInfo;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.CounterService;
import com.unicdata.service.system.DistributorStoreInfoService;
import com.unicdata.service.system.EmployeeService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

//编号生成工具
@Component
public class NumberGenerateUtil extends HomeBaseController {

    @Autowired
    private CounterService counterService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DistributorStoreInfoService storeInfoService;

    private static NumberGenerateUtil numberGenerateUtil;

    @PostConstruct
    public void init() {
        numberGenerateUtil = this;
        numberGenerateUtil.employeeService = this.employeeService;
        numberGenerateUtil.storeInfoService = this.storeInfoService;
        numberGenerateUtil.counterService = this.counterService;
    }

    //盘点单编号前缀
    private static final String checkPrefix = "PD";

    /**
     * 生成库存盘点单编号
     *
     * @return
     */
    public static String getDepotNumber() {
        return numberGenerateUtil.counterService.generateCode(checkPrefix, DateUtil.sdf5, 4);
    }

    /**
     * 生成客户编号
     *
     * @param request
     * @return
     */
    public static String getCustomerNumber(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        if (null == employee) {
//			if(StringUtils.equals(springProfilesActive, "dev")){
            employee = numberGenerateUtil.employeeService.selectByPrimaryKey(1);
//			}else{
//				return null;
//			}
        }
        String checkPrefix = "";
        if (employee.getStoreId() != null) {
            DistributorStoreInfo store = numberGenerateUtil.storeInfoService.getById(employee.getStoreId());
            checkPrefix = PinyinUtil.getPYIndexStr((store != null && StringUtils.isNotBlank(store.getAbbreviation())) ? store.getAbbreviation() : "门店", Boolean.TRUE);
        }
        return numberGenerateUtil.counterService.generateCode(checkPrefix, null, 7);
    }

}
