package com.unicdata.service.employee.impl;

import com.unicdata.constant.PushEnum;
import com.unicdata.dao.system.EmployeeMapper;
import com.unicdata.entity.holleworld.HolleWorldExample;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.employee.AppEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppEmployeeServiceImpl implements AppEmployeeService {
    /**
     * 财务部经理
     */
    @Value("${FINANCIAL_MANAGER}")
    public String FINANCIAL_MANAGER;
    /**
     * 销售信息员
     */
    @Value("${SALES_INFORMATION_OFFICER}")
    public String SALES_INFORMATION_OFFICER;
    /**
     * 精品信息员
     */
    @Value("${BOUTIQUE_INFORMATION_OFFICER}")
    public String BOUTIQUE_INFORMATION_OFFICER;
    /**
	 * 销售经理
	 */
	@Value("${SALES_MANAGER_POSITION}")
	public String SALES_MANAGER_POSITION;
	/**
	 * 展厅经理
	 */
	@Value("${SHOWROOM_MANAGER_POSITION}")
	public String SHOWROOM_MANAGER_POSITION;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Object> selectListByExample(HolleWorldExample example) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 获取前台员工信息 wp
     */
    @Override
    public List<Map<String, Object>> selectEmployeAndGroup(Map<String, Object> map) {
        List<Map<String, Object>> list = employeeMapper.selectEmployeAndGroup(map);
        return list;
    }

    /**
     * 根据岗位名称获取销售顾问
     */
    @Override
    public List<Map<String, Object>> selectEmployeByPostName(Map<String, Object> map) {
        List<Map<String, Object>> list = employeeMapper.selectEmployeByPostName(map);
        return list;
    }

    /**
     * 根据岗位名称获取销售顾问ID集合
     */
    @Override
    public List<Map<String, Object>> selectEmployeIdByPostName(Map<String, Object> map) {
        //n=1：订单审批通过 2：订单提交审核 5：精品订单审批通过
    	// 
        Integer n = map.get("n") != null ? Integer.valueOf(map.get("n").toString()) : 0;
        List<Map<String, Object>> list = employeeMapper.selectEmployeByPostName(map);
        List<Map<String, Object>> receiverIds = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : list) {
            HashMap<String, Object> objectHashMap = new HashMap<>();
            String eid = stringObjectMap.get("eid") != null ? stringObjectMap.get("eid").toString() : "0";
            objectHashMap.put("employeeId", Integer.valueOf(eid));
            String post_name = stringObjectMap.get("post_name") != null ? stringObjectMap.get("post_name").toString() : "";
            if (FINANCIAL_MANAGER.equals(post_name)) {//财务部经理
                objectHashMap.put("terminal", 1);
                if(n==1){
                    objectHashMap.put("urlId", PushEnum.UrlWeb.ORDER_AUDITED_FINANCE.getCode());
                }else if(n==5){
                    objectHashMap.put("urlId", PushEnum.UrlWeb.ORDER_AUDITED_FINANCE_BOUTIQUE.getCode());
                }else {
                    objectHashMap.put("urlId", -1);
                }
            } else if (SALES_INFORMATION_OFFICER.equals(post_name)) {//销售信息员
                objectHashMap.put("terminal", 1);
                if(n==1){
                    objectHashMap.put("urlId", PushEnum.UrlWeb.ORDER_PASS_INFO.getCode());
                }else if(n==2){
                    objectHashMap.put("urlId", PushEnum.UrlWeb.ORDER_SUBMIT_INFO.getCode());
                }else {
                    objectHashMap.put("urlId", -1);
                }
            } else if (BOUTIQUE_INFORMATION_OFFICER.equals(post_name)) {//精品信息员
                objectHashMap.put("terminal", 1);
                if(n==1){
                    objectHashMap.put("urlId", PushEnum.UrlWeb.ORDER_PASS_INFO.getCode());
                }else if(n==5){
                    objectHashMap.put("urlId", PushEnum.UrlWeb.ORDER_PASS_INFO_BOUTIQUE.getCode());
                }else {
                    objectHashMap.put("urlId", -1);
                }
            }else if (SALES_MANAGER_POSITION.equals(post_name)) {//销售经理
                objectHashMap.put("terminal", 3);
                if(n==2){
                    objectHashMap.put("urlId", -1);
                }
            }else if (SHOWROOM_MANAGER_POSITION.equals(post_name)) {//展厅经理
                objectHashMap.put("terminal", 3);
                if(n==3){
                    objectHashMap.put("urlId", -1);
                }
            }
            /*switch (n) {
                case 1:
                    if (FINANCIAL_MANAGER.equals(post_name)) {
                        objectHashMap.put("urlId", PushEnum.UrlWeb.ORDER_AUDITED_FINANCE.getCode());
                    } else if (SALES_INFORMATION_OFFICER.equals(post_name)) {
                        objectHashMap.put("urlId", PushEnum.UrlWeb.ORDER_PASS_INFO.getCode());
                    } else {
                        objectHashMap.put("urlId", -1);
                    }
                    break;
                case 5:
                    if (FINANCIAL_MANAGER.equals(post_name)) {
                        objectHashMap.put("urlId", PushEnum.UrlWeb.ORDER_AUDITED_FINANCE_BOUTIQUE.getCode());
                    } else if (BOUTIQUE_INFORMATION_OFFICER.equals(post_name)) {
                        objectHashMap.put("urlId", PushEnum.UrlWeb.ORDER_PASS_INFO_BOUTIQUE.getCode());
                    } else {
                        objectHashMap.put("urlId", -1);
                    }
                    break;
            }*/
            receiverIds.add(objectHashMap);
        }
        return receiverIds;
    }

    /**
     * 更新客户表
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(Employee record) {
        return employeeMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 通过客户id查询
     *
     * @param employeeId
     * @return
     */
    @Override
    public Employee findEmployeeRole(Integer employeeId) {
        return employeeMapper.findEmployeeRole(employeeId);
    }

    /**
     * 根据roleid和门店id获取工作人员
     *
     * @param map
     * @return
     */
    @Override
    public List<Employee> selectCustomersByRoleId(Map<String, Object> map) {
        return employeeMapper.selectCustomersByRoleId(map);
    }

    /**
     * 获取员工姓名 wp
     */
    @Override
    public Employee selectEmployeeById(Integer cusId) {
        return employeeMapper.selectByPrimaryKey(cusId);

    }

    /**
     * 获取员工姓名 wp
     */
    @Override
    public Employee selectEmployee(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);

    }

    /**
     * 变更员工状态 wp
     */
    @Override
    public int updateEmpStatus(Map<String, Object> map) {
        return employeeMapper.updateEmpStatus(map);
    }

    /**
     * 根据名字获取销售顾问
     *
     * @param map
     * @return
     */
    @Override
    public List<Map<String, Object>> selectEmployeByName(Map<String, Object> map) {
        return employeeMapper.selectEmployeAndGroup(map);
    }

    @Override
    public int updateEmpStatusByPostName(String postName) {
        return employeeMapper.updateEmpStatusByPostName(postName);
    }
}
