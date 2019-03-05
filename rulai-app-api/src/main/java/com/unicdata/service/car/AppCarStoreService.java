package com.unicdata.service.car;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.unicdata.entity.boutique.CarWash;
import com.unicdata.entity.car.CarCheckRecord;
import com.unicdata.entity.car.CarDepotCheck;
import com.unicdata.entity.car.CarGoodInfo;
import com.unicdata.entity.car.CarMaintainRecord;
import com.unicdata.entity.car.CarOutApplication;
import com.unicdata.entity.car.CarOutstorgeRecord;
import com.unicdata.entity.car.CarPurchaseOrder;
import com.unicdata.entity.car.CarRefuelRecord;
import com.unicdata.entity.car.CarStorage;
import com.unicdata.entity.car.CarTestInfo;
import com.unicdata.entity.car.CarWarehouse;
import com.unicdata.entity.car.CarWeihuRecord;
import com.unicdata.entity.car.CarZhengbeiRecord;
import com.unicdata.entity.order.DeliverCar;
import com.unicdata.entity.system.Employee;

public interface AppCarStoreService {

	 //交车列表 wp
	 PageInfo selectDeliverCarList(Map<String, Object> map,Integer pageNum,Integer pageSize);
	 //外出列表 wp
	 PageInfo selectCarOutList(Map<String, Object> map,Integer pageNum,Integer pageSize);
	 //商品车列表wp
	 PageInfo selectCarList(Map<String, Object> map,Integer pageNum,Integer pageSize);
	 //试驾车列 wp
	 PageInfo selectTestCarList(Map<String, Object> map,Integer pageNum,Integer pageSize);
	 //车详情wp
	 Map<String, Object> carDetailInfo(Map<String, Object> map);
	 //试驾车详情 wp
	 Map<String, Object> carTestDetailInfo(Map<String, Object> map);
	 //加油记录 wp
	 List<CarRefuelRecord> selectListByTestCar(Integer testCarId);
	 //添加加油记录 wp
	 int insertSelective(CarRefuelRecord record);
	 //今日调拨 wp
	 PageInfo carAllotList(Map<String, Object> map,Integer pageNum,Integer pageSize);
	 //整备列 wp
	 PageInfo detectionCarList(Map<String, Object> map,Integer pageNum,Integer pageSize); 
	 //扫一扫wp
	 Map<String, Object> carScan(String vin);
	 //入库录单 wp
	 PageInfo carRukuList(Map<String, Object> map,Integer pageNum,Integer pageSize);
	 //试驾车维修登记 wp
	 int weixiuRecord(CarMaintainRecord carMaintainRecord);
	 //试驾车维修记录 wp
	 List<CarMaintainRecord> selectMaintanList(Integer testCarId);
	 //商品车维护登记 wp
	 int weihuRecord(CarWeihuRecord carWeihuRecord);
	 //商品车维护记录 wp
	 List<Map<String, Object>> selectByCarId(Integer carId);
	 //扫一扫 wp
	 Map<String, Object> carTestScan(String vin);
	 //入库检查 wp
	 int insertCheckRecord(CarCheckRecord carCheckRecord);
	 //汽车表变更在库、处理状态
	 int updateCarStatus(CarGoodInfo record);
	 //门店仓库 wp
	 List<CarWarehouse> selectCarWarehouseByStore(Integer storeId);
	 //仓库下的库位 wp
	 List<Map<String, Object>> selectCarStoreByWarehouse(Integer warehouseId);
	 //仓库下的汽车 wp
	 List<Map<String, Object>> selectCarInStore(Map<String, Object> map);
	 //盘点汽车登记 wp
	 int insertDepotCheckRecord(CarDepotCheck carDepotCheck);
	 //盘点历史 wp
	 List<Map<String, Object>> depotCheckHistory(Map<String, Object> map);
	 //盘亏列表 wp
	 List<Map<String, Object>> depotCheckLossList(Map<String, Object> map);
	 //盘亏number下的汽车列表 wp
	 List<Map<String,Object>> depotCheckLossCars(Map<String, Object> map);
	 //创建整备工单wp 
	 int insertWorkPage(CarZhengbeiRecord carZhengbeiRecord,CarGoodInfo carGoodInfo);
	 //待送修、维修中、维修完成 wp
	 int updateZhengBeiStatus(CarZhengbeiRecord carZhengbeiRecord);
	 //保险提醒 wp
	 PageInfo selectInsurerRemind(Integer pageNum,Integer pageSize,Integer storeId);
	 //采购单列表 wp
	 public PageInfo carPurchaseList(Map<String, Object> map,Integer pageNum,Integer pageSize); 
	 //采购单下的汽车 wp
	 PageInfo selectCarByPurchaseId(Integer carOrderId,Integer pageNum,Integer pageSize);
	 //汽车入库登记 wp
	 int carCheckInStore(Integer carOrderId,CarGoodInfo carGoodInfo);
	 //汽车洗车登记 wp
	 int carWashRecord(CarWash carWash);
	 //洗车是否关联订单 wp
	 Map<String, Object> carOrderWash(Integer carId);
	 //查车系 wp
	 List<Map<String, Object>> selectCarFamily(Map<String, Object> map);
	 //查车型配置 wp
	 List<Map<String, Object>> selectCarConfByFamily(Map<String, Object> map);
	 //查外出申请单列 wp
	 List<Map<String, Object>> selectCarOutApply(Map<String, Object> map);
	 //外出单下的汽车 wp
	 List<Map<String, Object>> selectCarListByApply(Map<String, Object> map);
	 //变更汽车外出出库状态 wp
	 int updateByOutApplication(Integer storageStatus, Integer applicationId);
	 //盘点单状态 wp
	 List<Map<String, Object>>  selectPanDianDanStatus(String number);
	 //通过ID查仓库名称
	 CarWarehouse selectByPrimaryKey(Integer id);
	 //调拨申请单列表 wp
	 List<Map<String, Object>> selectAllotApplication(Map<String, Object> map);
	 //调拨申请单下的汽车 wp
	 List<Map<String, Object>> selectCarListByAllot(Map<String , Object> map); 
	 //入库历史 wp
	 List<Map<String, Object>> ruKuHistoryList(Map<String , Object> map);
	 //通过汽车ID查盘点记录 wp
	 Integer selectDepotByCarId(Integer carId);
	 //确认提交实盘 wp
	 int updateCheckDepot(CarDepotCheck carDepotCheck);
	 //盘点人员的列表 wp
	 List<Employee> selectPanDianEmps(Map<String, Object> map);
 	 //库管我的加油记录 wp
	 List<CarRefuelRecord> selectRefuleListByOperator(Map<String, Object> map);
	 //库管我的维修记录 wp
	 List<CarMaintainRecord> selectMaintainListByOperator(Map<String, Object> map);
	 //汽车调拨变更汽车在库状态 wp
	 int updateCarStoregStatusByAllot(Map<String, Object> map);
	 //检测后返回汽车信息 wp
	 Map<String, Object> selectCheckAfterCarInfo(Map<String, Object> map);
	 //添加出库记录 wp
	 int insertCarOutStoreRecord(CarOutstorgeRecord carOutstorgeRecord);
	 //变更我的状态 wp
	 int updateEmpStatus(Map<String, Object> map);
	 //我的信息 wp
	 Map<String, Object> myInfo(Map<String, Object> map);
	 //变更检测记录信息 wp
	 int updateCheckRecord(CarCheckRecord carCheckRecord,Integer carOrderId);
	 //变更外出申请单状态 wp
	 int updateCarOutAppliStatus(CarOutApplication carOutApplication);
	 //整备创建整备记录 wp
	 int insertZhengbeiRecord(CarZhengbeiRecord carZhengbeiRecord);
	 //获取整备类型 wp
	 CarZhengbeiRecord selectCarZhengbeiRecord(Integer zhengbeiId);
	 //获取今日交车洗车记录 wp
     Map<String, Object> selectCarWashRecord(Map<String, Object> map);
     //获取今日交车pdi检测记录 wp
     Map<String, Object> selectCarCheckRecord(Map<String, Object> map);
     //采购清单汽车检测状态 wp
 	 Map<String, Object> checkStatus(Map<String, Object> map);
	 //改变采购订单状态 wp
 	 int updateCarOrderState(CarPurchaseOrder carPurchaseOrder);
 	 //暂收整备处理状态 wp
 	 Map<String, Object> zanshouZhengbeiStatus(Map<String, Object> map);
 	 //变更汽车在库状态 wp
 	 int carCheckInStoreStatus(CarGoodInfo carGoodInfo);
 	 //是否存在车辆盘点信息 wp
 	 List<Map<String, Object>>selectIsExistCar(Map<String, Object> map);
}
