package com.unicdata.service.customer.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.util.StringUtil;
import com.unicdata.constant.ConstantEnum.enumIsOrNoStatus;
import com.unicdata.constant.ConstantEnum.enumPassengerFlowStatus;
import com.unicdata.constant.CustomerEnum;
import com.unicdata.constant.MessageCode;
import com.unicdata.constant.PushEnum;
import com.unicdata.dao.carInfo.UnicdataFamilyMapper;
import com.unicdata.dao.customer.*;
import com.unicdata.dao.system.EmployeeMapper;
import com.unicdata.entity.customer.*;
import com.unicdata.entity.system.Employee;
import com.unicdata.service.CounterService;
import com.unicdata.service.customer.CustomerService;
import com.unicdata.service.push.PushMessageService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 潜客服务层
 *
 * @author admin
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private PassengerFlowMapper passengerFlowMapper;
    @Autowired
    private TestDriveMapper testDriveMapper;
    @Autowired
    private TransactCustomerMapper transactCustomerMapper;
    @Autowired
    private TaskFollowUpMapper taskFollowUpMapper;
    @Autowired
    private CounterService counterService;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private UnicdataFamilyMapper unicdataFamilyMapper;
    @Autowired
    private PushMessageService pushMessageService;

    @Transactional
    public int updateCustomer(Customer record, MultipartFile file) {
        int res = 0;
        //用户图像
        if (null != file && StringUtils.isNotBlank(file.getOriginalFilename())) {
            /*String fileName = file.getOriginalFilename();//文件名
            try {
				String address = FileUtil.uploadFile(file.getInputStream(),fileName,UUID.randomUUID().toString(),"rulai","D:/");
				record.setImgUrl(address);
			} catch (IOException e) {
				e.printStackTrace();
			}*/
        }
        //保存用户信息
        if (record.getId() != null && record.getId() != 0) {
            //修改用户档案
            res = customerMapper.updateByPrimaryKeySelective(record);
            //计算客户资料完整度
            calcCustomerIntegrity(record.getId());
        } else {
            //预生成订单编号
            String customerNumber = counterService.generateCode("YFND", "", 7);
            record.setNumber(customerNumber);
            //验证手机号码时否已使用
            Customer tempParams = new Customer();
            tempParams.setPhone(record.getPhone());
            Customer customer = customerMapper.selectCustomer(tempParams);
            if (customer != null) {
                return -1;
            }
            //创建用户档案
            res = customerMapper.insertSelective(record);
            if (res > 0) {
                //计算客户资料完整度
                calcCustomerIntegrity(record.getId());
            }
            //关联客流表
            if (null != record.getPassengerId()) {
                PassengerFlow pf = new PassengerFlow();
                pf.setId(record.getPassengerId());
                pf.setCusId(record.getId());
                pf.setIsArchives(enumIsOrNoStatus.是.getId());
                PassengerFlow passengerFlow=passengerFlowMapper.selectByPrimaryKey(record.getPassengerId());
                Integer passInteger=passengerFlow.getStatus();//客流状态
                if (passInteger==enumPassengerFlowStatus.离店.getId()) {//客流离店不改变客流状态
                	 pf.setStatus(enumPassengerFlowStatus.离店.getId());
				}else {//客流状态变为接待中
					 pf.setStatus(enumPassengerFlowStatus.接待中.getId());
				}
                res = passengerFlowMapper.updateByPrimaryKeySelective(pf);
                if (res > 0) {//通知前台已处理
                    Employee employee = employeeMapper.selectByPrimaryKey(record.getEmployeeId());

                    //保存极光推送消息
                    List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
                    Map<String, Object> map = new HashMap<>();
//                    map.put("urlId", "");
                    map.put("employeeId", passengerFlow.getCreateEmployeeId());
                    map.put("terminal", 2);
                    mapList.add(map);
                    String content = MessageCode.resultCodeMap.get(MessageCode.MESSAGE_PASSENGER_CREATEARCHIVES);
                    content = content.replace("XXX", employee.getFullName());
                    pushMessageService.createPushMessage(PushEnum.PushType.CUSTOMER_INFO_INTEGRITY.getCode(), PushEnum.PushType.CUSTOMER_INFO_INTEGRITY.getDesc(), content, employee.getId(), mapList);
                }
            }
        }
        return res;
    }

    @Transactional(readOnly = true)
    public Customer selectCustomer(Customer record) {
        return customerMapper.selectCustomer(record);
    }

    @Transactional(readOnly = true)
    public Map<String, Object> selectCustomerMap(Customer record) {
        Map<String, Object> map = customerMapper.selectCustomerMap(record);
        if (map != null) {
            //原有车辆
            Integer ownCarId = map.get("ownedCar") != null ? Integer.valueOf(map.get("ownedCar").toString()) : 0;
            Map<String, Object> mapo = unicdataFamilyMapper.selectBFNameByFamilyId(ownCarId);
            map.put("ownedCarName", mapo != null && mapo.get("name") != null ? mapo.get("name").toString() : "");
            //关注竞品一
            Integer attentionCarOneId = map.get("attentionCarOne") != null ? Integer.valueOf(map.get("attentionCarOne").toString()) : 0;
            Map<String, Object> map1 = unicdataFamilyMapper.selectBFNameByFamilyId(attentionCarOneId);
            map.put("attentionCarOneName", map1 != null && map1.get("name") != null ? map1.get("name").toString() : "");
            //关注竞品二
            Integer attentionCarTwoId = map.get("attentionCarTwo") != null ? Integer.valueOf(map.get("attentionCarTwo").toString()) : 0;
            Map<String, Object> map2 = unicdataFamilyMapper.selectBFNameByFamilyId(attentionCarTwoId);
            map.put("attentionCarTwoName", map2 != null && map2.get("name") != null ? map2.get("name").toString() : "");
            //关注竞品三
            Integer attentionCarThreeId = map.get("attentionCarThree") != null ? Integer.valueOf(map.get("attentionCarThree").toString()) : 0;
            Map<String, Object> map3 = unicdataFamilyMapper.selectBFNameByFamilyId(attentionCarThreeId);
            map.put("attentionCarThreeName", map3 != null && map3.get("name") != null ? map3.get("name").toString() : "");
        }
        return map;
    }

    /**
     * 客户列表
     */
    /*@Transactional(readOnly = true)
    public PageInfo selectCustomersList(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        return customerMapper.selectListByParams(params).toPageInfo();
    }*/

    /**
     * 客户列表
     */
    @Transactional(readOnly = true)
    public PageInfo selectCustomersList(Integer pageNum, Integer pageSize, Customer customer) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        if (null != customer.getStoreId())
            criteria.andStoreIdEqualTo(customer.getStoreId());
        if (null != customer.getEmployeeId())
            criteria.andEmployeeIdEqualTo(customer.getEmployeeId());
        if (StringUtil.isNotBlank(customer.getName()))
            criteria.andNameLike("%" + customer.getName() + "%");
        if (StringUtil.isNotBlank(customer.getPhone()))
            criteria.andPhoneLike("%" + customer.getPhone() + "%");
        example.setOrderByClause("create_time DESC");
        List<Customer> list = customerMapper.selectByExample(example);
        //封装分页信息
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(list);
        return pageInfo;
    }


    /**
     * 更新客户信息
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        int res = customerMapper.updateByPrimaryKeySelective(record);
        if(res>0){
        	//计算客户资料完整度
            calcCustomerIntegrity(record.getId());
        }
        return res;
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @Override
    public Customer selectByPrimaryKey(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    /**
     * 订单和交车状态的客户信息
     *
     * @param record
     * @return
     */
    @Override
    public PageInfo selectOrderCusByParams(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = customerMapper.selectOrderCusByParams(params);
        List<Map<String, Object>> maps = new ArrayList<>();
        for (Map<String, Object> objectMap : list) {
            Object cus_id = objectMap.get("id");
            //设置跟进时间
            if (cus_id != null) {
                List<TaskFollowUp> followUps = taskFollowUpMapper.selectByCustomerId(Integer.valueOf(cus_id.toString()));
                if (followUps.size() > 0) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String format1 = format.format(new Date());
                    Date nextDate = followUps.get(0).getNextDate();
                    if (nextDate != null) {
                        String format2 = format.format(nextDate);
                        if (format1.equals(format2)) {
                            objectMap.put("thisDate", "今日跟进");
                        } else {
                            objectMap.put("thisDate", format2);
                        }
                    }
                }
            }

            //订单流程节点
            objectMap.put("processNode", objectMap.get("status") == null ? "" : objectMap.get("status"));

            //客户级别
            Object level = objectMap.get("level");
            if (level != null) {
                Integer s = Integer.valueOf(level.toString());
                CustomerEnum.Level[] values = CustomerEnum.Level.values();
                if (s < values.length) {
                    String reason = values[s].getReason();
                    objectMap.put("levelStr", reason);
                }
            }

            //车辆用途
            Object usage = objectMap.get("usage");
            if (usage != null) {
                Integer s = Integer.valueOf(usage.toString());
                CustomerEnum.Usage[] values = CustomerEnum.Usage.values();
                String reason = values[s].getReason();
                objectMap.put("usage", reason);
            }

            //设置建档时间
            Object numberDays = objectMap.get("numberDays");
            Object create_time = objectMap.get("create_time");
            if (numberDays != null && create_time != null) {
                String s = numberDays.toString();
                if (s.equals("0")) {
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                    String format1 = format.format(create_time);
                    objectMap.put("createTime", format1);
                } else {
                    objectMap.put("createTime", "建档" + numberDays + "天");
                }
            }
            maps.add(objectMap);
        }
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(maps);
        return pageInfo;
    }

    /**
     * 潜客，休眠，战败状态的客户信息
     *
     * @param record
     * @return
     */
    @Override
    public PageInfo selectCusByStatus(Integer pageNum, Integer pageSize, Customer customer) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = customerMapper.selectCusByStatus(customer);
        for (Map<String, Object> objectMap : list) {
            Object cus_id = objectMap.get("id");
            //设置跟进时间
            if (cus_id != null) {
                List<TaskFollowUp> followUps = taskFollowUpMapper.selectByCustomerId(Integer.valueOf(cus_id.toString()));
                if (followUps.size() > 0) {
                    SimpleDateFormat format = new SimpleDateFormat("MM/dd");
                    String format1 = format.format(new Date());
                    Date nextDate = followUps.get(0).getNextDate();
                    if (nextDate != null) {
                        String format2 = format.format(nextDate);
                        if (format1.equals(format2)) {
                            objectMap.put("thisDate", "今日跟进");
                        } else {
                            objectMap.put("thisDate", format2 + "跟进");
                        }
                    }
                }
            }

            //设置建档时间
            Object numberDays = objectMap.get("numberDays");
            Object create_time = objectMap.get("create_time");
            if (numberDays != null && create_time != null) {
                String s = numberDays.toString();
                if (s.equals("0")) {
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                    String format1 = format.format(create_time);
                    objectMap.put("createTime", format1);
                } else {
                    objectMap.put("createTime", "建档" + numberDays + "天");
                }
            }

            //客户级别
            Object level = objectMap.get("level");
            if (level != null) {
                Integer s = Integer.valueOf(level.toString());
                CustomerEnum.Level[] values = CustomerEnum.Level.values();
                if (s < values.length) {
                    String reason = values[s].getReason();
                    objectMap.put("levelStr", reason);
                }
            }

            //获取客户试驾车型及时间
            TestDriveExample example = new TestDriveExample();
            TestDriveExample.Criteria criteria = example.createCriteria();
            criteria.andCusIdEqualTo(Integer.valueOf(cus_id.toString()));
            example.setOrderByClause("id desc");
            List<TestDrive> list2 = testDriveMapper.selectByExample(example);
            if (list2 != null && list2.size() > 0) {
                TestDrive testDrive = list2.get(0);
                SimpleDateFormat format = new SimpleDateFormat("MM-dd");
                String format1 = format.format(testDrive.getCreateTime());
                String vehicleName = testDrive.getVehicleName();
                String substring = "";
                if (vehicleName == null && vehicleName.indexOf("") > 0) {
                    substring = vehicleName.substring(vehicleName.indexOf(""), vehicleName.length());
                } else {
                    substring = vehicleName;
                }
                objectMap.put("drive", substring.trim() + "/" + format1);
            } else {
                objectMap.put("drive", "");
            }
        }
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        return pageInfo;
    }

    /**
     * 办事人员信息列表 wp
     */
    public PageInfo selectTransactCustomer(Integer pageNum, Integer pageSize, Map<String, Object> map) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = transactCustomerMapper.selectTransactCustomer(map);
        //封装分页信息
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        return pageInfo;
    }

    /**
     * 登记办事人员
     *
     * @param transactCustomer
     * @return
     */
    public int insertSelective(TransactCustomer transactCustomer) {
        return transactCustomerMapper.insertSelective(transactCustomer);
    }

    /**
     * 条件查询客户 wp
     */
    @Override
    public PageInfo selectCustomers(Integer pageNum, Integer pageSize, Map<String, Object> map) {
        pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
        //传入参数不能超过最大分页大小
        pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE ? PageConstant.MAX_PAGE_SIZE : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = customerMapper.selectCustomersList(map);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 计算客户信息完整度
     *
     * @param customer
     * @return
     */
    public int calcCustomerIntegrity(Integer id) {
    	int res = 0;
        Map<String, Object> map = customerMapper.calcCustomerIntegrity(id);
        if (map != null) {
            double total = 0;
            double count = 0;
            for (Object o : map.keySet()) {
                String a = String.valueOf(map.get(o));
                if (!"-1".equals(a)) {
                    total++;
                    if ("0".equals(a)) {//不为空
                        count++;
                    }
                }
            }
            if (total > 0) {
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format(count / total * 100);
                Customer tempCustomer = new Customer();
                tempCustomer.setId(id);
                tempCustomer.setIntegrity(Double.valueOf(result));
                //修改用户档案
                res = customerMapper.updateByPrimaryKeySelective(tempCustomer);
            }
        }
        return res;
    }

    /**
     * 客户列表 wp
     */
    @Override
    public Map<String, Object> testInfo(Map<String, Object> map) {
        return customerMapper.testInfo(map);

    }

}
