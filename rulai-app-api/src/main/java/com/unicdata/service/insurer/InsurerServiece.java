package com.unicdata.service.insurer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.unicdata.entity.car.CarInsuranceRecord;
import com.unicdata.entity.product.InsuranceType;
import com.unicdata.entity.product.Insurer;

public interface InsurerServiece {

	/**
	 * 保险公司列 wp
	 * @param storeId
	 * @return
	 */
	List<Insurer> selectInsure(Integer storeId);
	/**
	 * 保险公司下的险种 wp
	 * @param map
	 * @return
	 
	List<Map<String, Object>> selectInsurerType(Map<String, Object> map);
	*/
	/**
	 * 试驾车保险记录 wp
	 * @param testCarId
	 * @return
	 */
	List<Map<String, Object>> selectInsurRecordList(Integer testCarId);
	/**
	 * 试驾车保险登记 wp
	 * @param carInsuranceRecord
	 * @return
	 */
	int insertInsurerRecord(
			Integer testCarId,
    		Integer insurerId,
    		List<Integer> insuranceTypeId,
    		Double price,
    		Date endTime,
    		Integer employeeID,
    		List<Map<String, Object>> list
			);
	/**
	 * 子保险 wp
	 * @return
	 */
	List<Map<String, Object>> selectChildTypes(Integer insurerId,Integer storeId);
	
	/**保险公司及险种 wp
	 * @return
	 */
    List<Insurer> selectInsurerAndType();
    
    /**
     *险种下的子保险 wp  new
     */
    List<Map<String, Object>> selectChildInsuranceTypes(Integer parentId);
    /**
     * 查父险种 wp
     * @return
     */
    List<Map<String, Object>> selectTypes();
    //试驾车添加保险登记，修改后 wp
    int addInsureRecord(CarInsuranceRecord carInsuranceRecord);
    
    List<Map<String, Object>> selectChildTypeList(Map<String, Object> params);
    List<Map<String, Object>> selectInsuredAmounts(Map<String, Object> params);
}
