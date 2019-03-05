package com.unicdata.service.insurer.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicdata.dao.car.CarInsuranceRecordMapper;
import com.unicdata.dao.product.InsuranceTypeMapper;
import com.unicdata.dao.product.InsurerMapper;
import com.unicdata.entity.car.CarInsuranceRecord;
import com.unicdata.entity.product.InsuranceType;
import com.unicdata.entity.product.Insurer;
import com.unicdata.service.insurer.InsurerServiece;
@Service
public class InsurerServiceImpl implements InsurerServiece {

	@Autowired
	private InsurerMapper insurerMapper;
	@Autowired
	private CarInsuranceRecordMapper carInsuranceRecordMapper;
	@Autowired
	private InsuranceTypeMapper insuranceTypeMapper;
	/**
	 * 保险公司 wp
	 */
	@Override
	public List<Insurer> selectInsure(Integer storeId) {
		return insurerMapper.selectInsure(storeId);
	}
	/**
	 * 保险公司下的险种 wp
	 
	@Override
	public List<Map<String, Object>> selectInsurerType(Map<String, Object> map) {
		return insurerMapper.selectInsurerType(map);
	}
	*/
	/**
	 * 试驾车保险记录 wp
	 */
	@Override
	public List<Map<String, Object>> selectInsurRecordList(Integer testCarId) {
		return carInsuranceRecordMapper.selectInsurRecordList(testCarId);
		
	}
	/**
	 * 试驾车保险登记 wp
	 */
	@Override
	@Transactional
	public int insertInsurerRecord(Integer testCarId,
    		Integer insurerId,
    		List<Integer> insuranceTypeId,
    		Double price,
    		Date endTime,
    		Integer employeeID,
    		List<Map<String, Object>> listmap
			) {
		//登记前将车辆之前的保险登记状态status变更为2（删除）
		CarInsuranceRecord carInsuranceRecord=new CarInsuranceRecord();
		carInsuranceRecord.setTestCarId(testCarId);
		carInsuranceRecord.setInsurerId(insurerId);
		int i=0;
		int i1=0;
		int iu=0;
		for (Integer integer : insuranceTypeId) {
			carInsuranceRecord.setInsuranceTypeId(integer);
			//查是否有登记记录，有则变更status为2
			List<Map<String, Object>> list=carInsuranceRecordMapper.selectExsitRecord(carInsuranceRecord);
			if (null != list && list.size()!=0) {
				//变更之前的记录
				carInsuranceRecord.setUpdateDate(new Date());
				carInsuranceRecord.setStatus(2);//数据状态为删除
				i=carInsuranceRecordMapper.updateByCarIdSelective(carInsuranceRecord);
			}
		}
		for (Integer integer : insuranceTypeId) {
			//然后添加新的保险登记
			carInsuranceRecord.setInsuranceTypeId(integer);
			carInsuranceRecord.setPrice(price);
			carInsuranceRecord.setUpdateDate(new Date());
			carInsuranceRecord.setCreateDate(new Date());
			carInsuranceRecord.setEndTime(new  Date());
			carInsuranceRecord.setOperatorId(employeeID);
			carInsuranceRecord.setStatus(1);//数据状态为正常
			i1=carInsuranceRecordMapper.insertSelective(carInsuranceRecord);
		}
		//添加保额(更新)
		if (listmap!=null&&listmap.size()>0&&!listmap.isEmpty()) {
			for (Map<String, Object> map2 : listmap) {
				System.out.println(map2.get("insuranceMoney"));
				System.out.println(map2.get("testCarId"));
				System.out.println(map2.get("insurerId"));
				System.out.println(map2.get("insuranceType"));
				iu=carInsuranceRecordMapper.updateInsurerMoney(map2);
			}
		}
		int i2=0;
		if (i1>0) {
			i2=1;
		}
		return i2;
	}
	/**
	 * 子保险 wp
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectChildTypes(Integer insurerId,Integer storeId) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("insurerId", insurerId);
		map.put("storeId", storeId);
		List<Map<String, Object>> list=insurerMapper.selectInsurerType(map);
		List<Map<String, Object>> listr=new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map2 : list) {
			Integer parent_id=(Integer) map2.get("parent_id");
			if (parent_id==null) {
				//有可能存在子保险 有就添加子保险 
				Integer parentId=(Integer) map2.get("id");
				System.out.println(parentId);
				List<Map<String, Object>> list2=insuranceTypeMapper.selectChildTypes(parentId);
				if(list2!=null) {
					map2.put("childs",list2 );
				}
			}
			listr.add(map2);
		}
		return listr;
	}
	/**
	 * 公司及险种 wp
	 */
	@Override
	public List<Insurer> selectInsurerAndType() {
		return insurerMapper.selectInsurerAndType();
	}
	/**
	 * 子保险 wp
	 */
	@Override
	public List<Map<String, Object>> selectChildInsuranceTypes(Integer parentId) {
		return insuranceTypeMapper.selectChildTypes(parentId);
	}
	/**
     * 查父险种 wp
     * @return
     */
    public List<Map<String, Object>> selectTypes(){
    	return insuranceTypeMapper.selectTypes();
    }
    /**
     * 试驾车保险登记 wp
     */
	@Override
	public int addInsureRecord(CarInsuranceRecord carInsuranceRecord) {
		return carInsuranceRecordMapper.insertSelective(carInsuranceRecord);
		
	}
	@Override
	public List<Map<String, Object>> selectChildTypeList(Map<String, Object> params) {
		return insuranceTypeMapper.selectChildTypeList(params);
	}
	@Override
	public List<Map<String, Object>> selectInsuredAmounts(Map<String, Object> params) {
		return insuranceTypeMapper.selectInsuredAmounts(params);
	}
	
	
}
