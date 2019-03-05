package com.unicdata.service.passengerflow.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.Constant;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.MessageCode;
import com.unicdata.dao.customer.CustomerMapper;
import com.unicdata.dao.customer.EntranceGuardRemindMapper;
import com.unicdata.dao.customer.PassengerFlowMapper;
import com.unicdata.dao.system.EmployeeMapper;
import com.unicdata.entity.customer.Customer;
import com.unicdata.entity.customer.EntranceGuardRemind;
import com.unicdata.entity.customer.PassengerFlow;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.customer.CustomerService;
import com.unicdata.service.passengerflow.PassengerFlowService;
import com.unicdata.util.JPushUtils;
import com.unicdata.util.PageResult;

/**
 * 客流服务层
 * @author Administrator
 *
 */
@Service
public class PassengerFlowServiceImpl implements PassengerFlowService{
	@Autowired
    private PassengerFlowMapper passengerFlowMapper;
	@Autowired
    private CustomerMapper customerMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private EntranceGuardRemindMapper entranceGuardRemindMapper;
	
	@Override
	public Map<String,Object> getPassengerFlowList(Integer pageNum, Integer pageSize,PassengerFlow record) {
		Map<String,Object> map = new HashMap<String, Object>();
		pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = passengerFlowMapper.getPassengerFlowList(record);
		//封装分页信息
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		//自定义封装数据返回
		//统计客流条数
		int firstNum = 0;
		int againNum = 0;
		for(Map<String, Object> pf:list){
			String nextDate = String.valueOf(pf.get("nextDate"));
			if(StringUtil.isNotBlank(nextDate)){
				pf.put("nextDate", nextDate.substring(5)+"跟进");
			}
			String type = String.valueOf(pf.get("type"));
			if("1".equals(type)){
				firstNum++;
			}else{
				againNum++;
			}
		}
		//返回的数据
		map.put("firstNum", firstNum);
		map.put("againNum", againNum);
		map.put("list", list);
		PageResult page = new PageResult();
		BeanUtils.copyProperties(pageInfo,page);
		map.put("pageResult",page);
		return map;
	}
	/**
	 * 客流数量信息wp
	 */
	public List<PassengerFlow> selectPassengerFlowMes(PassengerFlow passengerFlow){
		return passengerFlowMapper.selectPassengerFlowMes(passengerFlow);
	}
	
	/**
     * 添加客流信息wp
     */
    public int addPassengerFlow(PassengerFlow passengerFlow) {
    	passengerFlow.setCreateTime(new Date());
    	return passengerFlowMapper.insertSelective(passengerFlow);
    }

	@Override
	public int updateByPrimaryKey(PassengerFlow record) {
		return passengerFlowMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 替岗换销售wp
     */
    public int changeSellMan(PassengerFlow passengerFlow) {
    	return passengerFlowMapper.changeSellMan(passengerFlow);
    }


	@Override
	public int updateByPrimaryKeySelective(PassengerFlow record) {
		return passengerFlowMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int getMouthPassengerFlowList(Map<String, Object> map) {
		return passengerFlowMapper.getMouthPassengerFlowList(map);
	}
	/**
     * 根据车牌号获取顾客信息 wp
     * @param licensePlate
     * @return
     */
	@Override
	public Map<String, Object> selectCustomerByLicensePlate(Map<String, Object> map) {
		return passengerFlowMapper.selectCustomerByLicensePlate(map);
		
	}
	
	@Override
	public Map<String, Object> selectByCondition(PassengerFlow record) {
		return passengerFlowMapper.selectByCondition(record);
	}
	
	@Transactional
	public int updateLeaveShop(PassengerFlow record) {
		//更新客流
		int res = passengerFlowMapper.updateByPrimaryKeySelective(record);
		if(record.getCusId()!=null){
			//更新客户信息
		    Customer customer = new Customer();
		    customer.setId(record.getCusId());
		    customer.setOwnedCar(record.getOwnedCar());
		    customer.setLicensePlate(record.getLicensePlate());
		    customer.setModifyTime(new Date());
		    res = customerMapper.updateByPrimaryKeySelective(customer);
		}
		//离店后变更客流对应的员工状态（改为空闲）
        Map<String, Object> map = new HashMap<>();
		map.put("employeeId", record.getEmployeeId());
        map.put("type", 0); //状态0空闲（1忙碌）2休假3培训
	    res = employeeMapper.updateEmpStatus(map);
	    //变更员工操作时间，用于前台销售顾问排序
	    Employee employee=new Employee();
	    employee.setId(record.getEmployeeId());
	    employee.setOperationTime(new Date());
	    res=employeeMapper.updateByPrimaryKeySelective(employee);
		return res;
	}
	/**
	 * 获取未接待、正接待的客流 wp
	 */
	@Override
	public List<Map<String, Object>> selectDoingPassengerFlow(Map<String, Object> map) {
		return passengerFlowMapper.selectDoingPassengerFlow(map);
	}
	/**
	 * 通过Id查客流信息 wp
	 */
	@Override
	public PassengerFlow getPassengerFlowById(Integer id) {
		return passengerFlowMapper.selectByPrimaryKey(id);
	}
	/**
	 * 换岗为null wp
	 */
	@Override
	public int changeRepalceNull(PassengerFlow passengerFlow) {
		return passengerFlowMapper.changeRepalceNull(passengerFlow);
	}
	
	@Override
	public PassengerFlow selectByPrimaryKey(Integer id) {
		return passengerFlowMapper.selectByPrimaryKey(id);
	}
	/**
	 * 获取门禁信息（提醒销售顾问） wp
	 */
	@Override
	public List<Map<String, Object>> selectDoorRemindMes(Map<String, Object> map) {
		return entranceGuardRemindMapper.selectDoorRemindMes(map);
	}
	/**
	 * 将门禁信息存入门禁表 wp
	 */
	@Override
	public int insertDoorRemindMes(EntranceGuardRemind entranceGuardRemind) {
		return entranceGuardRemindMapper.insertSelective(entranceGuardRemind);
	}
	/**
	 * 客户意向车型 wp
	 */
	@Override
	public Map<String, Object> selectAttentionCarFamily(Map<String, Object> map) {
		return customerMapper.selectAttentionCarFamily(map);
		
	}
	@Override
	public int updateReplacePostData(PassengerFlow passengerFlow) {
		//修改 customer employee_id
		Map<String,Object> params = new HashMap<>();
		params.put("employeeId", passengerFlow.getEmployeeId());
		params.put("replaceEmployeeId", passengerFlow.getReplaceEmployeeId());
		params.put("customerId", passengerFlow.getCusId());
		return passengerFlowMapper.updateReplacePostData(params);
	}
	@Override
	public Map<String, Object> testStatus(Map<String, Object> map) {
		return passengerFlowMapper.testStatus(map);
	}
	/**
	 * 变更替岗、换销售后的员工Id
	 */
	@Override
	public int updateCustomerEmp(Customer customer) {
		return customerMapper.updateByPrimaryKeySelective(customer);
	}
}
