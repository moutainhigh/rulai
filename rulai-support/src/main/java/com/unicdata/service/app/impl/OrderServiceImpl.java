package com.unicdata.service.app.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicdata.base.constant.PageConstant;
import com.unicdata.base.util.DateUtil;
import com.unicdata.dao.order.OrderMapper;
import com.unicdata.entity.order.Order;
import com.unicdata.service.app.OrderService;

/**
 * 订单服务层
 *
 * @author admin
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional(readOnly=true)
	public PageInfo selectOrderList(Integer pageNum, Integer pageSize,Map<String,Object> map) {
    	pageNum = null == pageNum || pageNum < 1 ? pageNum = 1 : pageNum;
		//传入参数不能超过最大分页大小
		pageSize = null == pageSize || pageSize.intValue() > PageConstant.MAX_PAGE_SIZE? PageConstant.MAX_PAGE_SIZE : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = orderMapper.selectOrderList(map);
		String currentDate = DateUtil.dateFormat(new Date(), "yyyy-MM-dd");
		for(Map<String, Object> order:list){
			String nextDate = String.valueOf(order.get("nextDate"));
			int res = DateUtil.daysBetween(currentDate,nextDate);
			if(res == 0){
				nextDate = "今日跟进";
			}else if(res>0){
				nextDate = nextDate.substring(5)+"跟进";
			}else{
				nextDate = "逾期"+(-res)+"天";
			}
			String cusCreateTime = String.valueOf(order.get("cusCreateTime"));
			int curRes = DateUtil.daysBetween(cusCreateTime,currentDate);
			if(curRes>0){
				cusCreateTime = "建档"+curRes+"天";
			}else{
				cusCreateTime = cusCreateTime.substring(0,10);
			}
			order.put("cusCreateTime", cusCreateTime);
			order.put("nextDate", nextDate);
		}
		//封装分页信息
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
		return pageInfo;
	}

    @Transactional(readOnly = true)
    public Order selectOrderbyId(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int getCurrentMothOrderNum(Integer employeeId, Integer status) {
        Order record = new Order();
        record.setCreateId(employeeId);
        record.setStatus(status);
        return orderMapper.getCurrentMothOrderNum(record);
    }

    /**
     * 本月订单数
     *
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> getMothOrderNumByStoreId(Map<String, Object> map) {
        return orderMapper.getMothOrderNumByStoreId(map);
    }

    @Override
    public Map<String, Object> orderDetail(Integer orderId) {
        return orderMapper.orderDetail(orderId);
    }

    @Override
    public List<Order> selectByCusId(Integer cusId) {
        return orderMapper.selectByCusId(cusId);
    }

	@Override
	public int createOrder(Order order) {
		return orderMapper.insertSelective(order);
	}
}
