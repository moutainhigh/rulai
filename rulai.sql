/*
Navicat MySQL Data Transfer

Source Server         : rulai
Source Server Version : 50635
Source Host           : 192.168.1.191:3306
Source Database       : rulai

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2018-06-01 16:35:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for approval_cus
-- ----------------------------
CREATE TABLE `approval_cus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) DEFAULT NULL COMMENT '客户id',
  `approval_type` tinyint(4) DEFAULT NULL COMMENT '审批类型 1:休眠审批 2:战败审批',
  `apply_reason` varchar(255) DEFAULT NULL COMMENT '申请原因',
  `apply_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `approval_status` tinyint(4) DEFAULT NULL COMMENT '审批状态',
  `approval_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '审批时间',
  `employee_id` int(11) DEFAULT NULL COMMENT '审批人id',
  `data_status` tinyint(4) DEFAULT '1' COMMENT '状态: 0:删除 1:正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='退订、战败客户审批表';

-- ----------------------------
-- Records of approval_cus
-- ----------------------------

-- ----------------------------
-- Table structure for approval_order
-- ----------------------------
CREATE TABLE `approval_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单号',
  `order_status` int(11) DEFAULT NULL COMMENT '订单状态',
  `cus_id` int(11) DEFAULT NULL COMMENT '客户id',
  `approval_type` tinyint(4) DEFAULT '1' COMMENT '订单审批类型 1:订单审批 2:退订审批',
  `approval_status` tinyint(4) DEFAULT '0' COMMENT '审批状态 0:待审批 1:通过 2:不通过',
  `unsubscribe_reason` varchar(255) DEFAULT NULL COMMENT '退订原因，订单审批为空',
  `apply_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `data_status` tinyint(4) DEFAULT '1' COMMENT '状态: 0:删除 1:正常',
  `employee_id` int(11) DEFAULT NULL COMMENT '审批人id',
  `approval_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '审批时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单、退订审批表';

-- ----------------------------
-- Records of approval_order
-- ----------------------------

-- ----------------------------
-- Table structure for approval_replace
-- ----------------------------
CREATE TABLE `approval_replace` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `replace_model_id` int(11) DEFAULT NULL COMMENT '要更换的车型id',
  `apply_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `approval_status` tinyint(4) DEFAULT NULL COMMENT '审批状态',
  `approval_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '审批时间',
  `employee_id` int(11) DEFAULT NULL COMMENT '审批人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='换车申请审批表';

-- ----------------------------
-- Records of approval_replace
-- ----------------------------

-- ----------------------------
-- Table structure for arrive_bill_list
-- ----------------------------
CREATE TABLE `arrive_bill_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rebate_project_id` int(11) NOT NULL COMMENT '返利项目表id',
  `employee_id` int(11) DEFAULT '0' COMMENT '操作人',
  `create_date` datetime NOT NULL COMMENT '数据创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='到账单';

-- ----------------------------
-- Records of arrive_bill_list
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_brand
-- ----------------------------
CREATE TABLE `boutique_brand` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT '' COMMENT '精品品牌',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品品牌';

-- ----------------------------
-- Records of boutique_brand
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_classify
-- ----------------------------
CREATE TABLE `boutique_classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classify` varchar(70) DEFAULT '' COMMENT '分类名称',
  `level` int(11) DEFAULT NULL COMMENT '级别(第几级菜单）',
  `have_son` tinyint(4) DEFAULT NULL COMMENT '是否存在下级菜单( 0 不存在 ； 1 存在)',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品分类';

-- ----------------------------
-- Records of boutique_classify
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_information
-- ----------------------------
CREATE TABLE `boutique_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT '' COMMENT '精品编号',
  `name` varchar(255) DEFAULT '' COMMENT '精品名称',
  `warehouse_id` int(11) DEFAULT NULL COMMENT '仓库id',
  `position_id` int(11) DEFAULT NULL COMMENT '库位id',
  `classify` varchar(255) DEFAULT '' COMMENT '精品分类id组合 （父级id - 子级id- 子级id- 子级id）',
  `car_classify` varchar(255) DEFAULT '' COMMENT '车型分类',
  `brand_id` int(11) DEFAULT NULL COMMENT '精品品牌id',
  `company` varchar(255) DEFAULT '' COMMENT '单位',
  `construction_node` varchar(255) DEFAULT '' COMMENT '施工节点',
  `supplier_id` int(11) DEFAULT NULL COMMENT '供应商id',
  `cost` decimal(20,0) DEFAULT NULL COMMENT '含税成本',
  `coefficient` decimal(20,0) DEFAULT NULL COMMENT '精品系数',
  `unitprice` decimal(20,0) DEFAULT NULL COMMENT '精品单价',
  `workinghours` double(20,0) DEFAULT NULL COMMENT '工时',
  `safety_stock` int(11) DEFAULT NULL COMMENT '安全库存',
  `picture` varchar(255) DEFAULT '' COMMENT '图片位置',
  `remark` text COMMENT '备注',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态(0 下架； 1 上架)',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='精品信息库';

-- ----------------------------
-- Records of boutique_information
-- ----------------------------
INSERT INTO `boutique_information` VALUES ('1', '123456', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '2018-06-01 14:58:16');
INSERT INTO `boutique_information` VALUES ('2', 'eqwe123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '2018-06-01 15:05:57');

-- ----------------------------
-- Table structure for boutique_install
-- ----------------------------
CREATE TABLE `boutique_install` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expected_delivery` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '预计交车时间',
  `expected_complete` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '预计完成时间',
  `actual_delivery` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '实际完成时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态( 0 - 未开始 ； 1- 已开始 ； 2 - 已完成)',
  `code` varchar(255) DEFAULT '' COMMENT '排程单号',
  `employee_id` int(11) DEFAULT NULL COMMENT '员工id',
  `customer_name` varchar(255) DEFAULT '' COMMENT '客户姓名',
  `vin` varchar(255) DEFAULT '' COMMENT 'VIN码',
  `license_plate` varchar(255) DEFAULT '' COMMENT '车牌',
  `model` varchar(255) DEFAULT '' COMMENT '车型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品加装排程';

-- ----------------------------
-- Records of boutique_install
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_install_project
-- ----------------------------
CREATE TABLE `boutique_install_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `install_id` int(11) DEFAULT NULL COMMENT '精品加装排程id',
  `boutique_project` varchar(255) DEFAULT '' COMMENT '精品施工项目(精品名称)',
  `workinghours` double(20,0) DEFAULT NULL COMMENT '标准工时',
  `start_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `end_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '完成时间',
  `workinghours_use` double(20,0) DEFAULT NULL COMMENT '实际工时',
  `principal` varchar(255) DEFAULT '' COMMENT '项目负责人',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态( 0 - 未开始 ； 1- 已开始 ； 2 - 已完成)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品加装排程施工项目';

-- ----------------------------
-- Records of boutique_install_project
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_outbound
-- ----------------------------
CREATE TABLE `boutique_outbound` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salve_no` varchar(255) DEFAULT '' COMMENT '销售订单号',
  `boutique_no` varchar(255) DEFAULT '' COMMENT '精品单号',
  `vin` varchar(255) DEFAULT '' COMMENT 'VIN码',
  `car_model` varchar(255) DEFAULT '' COMMENT '车型',
  `employee_name` varchar(255) DEFAULT '' COMMENT '员工姓名',
  `customer_name` varchar(255) DEFAULT '' COMMENT '客户姓名',
  `apply_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '申请日期',
  `status` tinyint(4) DEFAULT NULL COMMENT '单据状态（ 0 - 未出料 ； 1 - 部分出料 ； 2- 全部出料）',
  `type` tinyint(4) DEFAULT NULL COMMENT '来源(销售出库 - 0 , 维修出库 - 1，精品零售 - 2)',
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品出库订单 ， 该表是施工精品表的主表';

-- ----------------------------
-- Records of boutique_outbound
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_outbound_detail
-- ----------------------------
CREATE TABLE `boutique_outbound_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `boutique_order_id` int(11) DEFAULT NULL COMMENT '精品订单id',
  `boutique_construction` tinyint(4) DEFAULT NULL COMMENT '施工节点( 0 不施工 ； 1-交车前施工 ； 2 - 交车后施工)',
  `boutique_id` int(6) DEFAULT NULL COMMENT '精品id',
  `numer` int(11) DEFAULT NULL COMMENT '精品数量',
  `picker` varchar(255) DEFAULT '' COMMENT '领料人',
  `outbound_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '出库时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否出库默认未出库( 0 - 未出库 ； 1- 出库)',
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同一精品销售订单下，需出库的不同施工节点精品。\r\n同一订单下的精品都未出库时，订单为未出料状态(0)，；同一订单下有部分精品出库，订单为部分出料状态(1)；同一订单下所有精品出库，订单为全部出料状态(2)';

-- ----------------------------
-- Records of boutique_outbound_detail
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_package
-- ----------------------------
CREATE TABLE `boutique_package` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '' COMMENT '礼包套餐名称',
  `salve_value` decimal(20,0) DEFAULT NULL COMMENT '销售价格',
  `car_id` int(11) DEFAULT NULL COMMENT '适用车型id',
  `picture` varchar(255) DEFAULT '' COMMENT '礼包套餐图片位置',
  `include_num` int(11) DEFAULT NULL COMMENT '礼包包含精品件数',
  `status` tinyint(4) DEFAULT NULL COMMENT '是否上架(0-下架 ； 1 -上架)',
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品礼包';

-- ----------------------------
-- Records of boutique_package
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_package_include
-- ----------------------------
CREATE TABLE `boutique_package_include` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `package_id` int(11) DEFAULT NULL COMMENT '精品礼包id',
  `information_id` int(11) DEFAULT NULL COMMENT '精品id',
  `information_num` int(11) DEFAULT NULL COMMENT '精品数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品礼包中的精品及精品数量';

-- ----------------------------
-- Records of boutique_package_include
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_proceeds_record
-- ----------------------------
CREATE TABLE `boutique_proceeds_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `payer_name` varchar(20) DEFAULT '' COMMENT '付款人名称',
  `pay_type` int(2) DEFAULT NULL COMMENT '付款方式',
  `proceeds_type` int(2) DEFAULT NULL COMMENT '收款类型',
  `proceeds_num` decimal(10,2) DEFAULT NULL COMMENT '收款数目',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品收款记录';

-- ----------------------------
-- Records of boutique_proceeds_record
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_push_warehouse
-- ----------------------------
CREATE TABLE `boutique_push_warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `push_code` varchar(255) DEFAULT '' COMMENT '入库编号',
  `push_name` varchar(255) DEFAULT '' COMMENT '入库名称',
  `push_date` timestamp NULL DEFAULT NULL COMMENT '操作时间（入库时间）',
  `boutique_id` int(11) DEFAULT NULL COMMENT '精品id',
  `boutique_code` varchar(255) DEFAULT '' COMMENT '精品编号(对应fine_information表中的code)',
  `boutique_name` varchar(255) DEFAULT '' COMMENT '精品名称',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `tax_unit_price` decimal(20,0) DEFAULT NULL COMMENT '含税单价',
  `tax_cost` decimal(20,0) DEFAULT NULL COMMENT '含税成本',
  `sales_cost` decimal(20,0) DEFAULT NULL COMMENT '销售单价',
  `sales_type` varchar(255) DEFAULT '' COMMENT '售卖类型',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品入库';

-- ----------------------------
-- Records of boutique_push_warehouse
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_reconciliation
-- ----------------------------
CREATE TABLE `boutique_reconciliation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier_id` int(11) DEFAULT NULL COMMENT '精品供应商id',
  `boutique_id` int(11) DEFAULT NULL COMMENT '精品id',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `construction_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '施工时间',
  `value` decimal(20,0) DEFAULT NULL COMMENT '金额',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态( 0 - 未核对 ； 1 - 已核对)',
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品对账';

-- ----------------------------
-- Records of boutique_reconciliation
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_retail
-- ----------------------------
CREATE TABLE `boutique_retail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT '' COMMENT '精品零售单号',
  `customer` varchar(255) DEFAULT '' COMMENT '客户/企业名称',
  `employee_id` int(11) DEFAULT NULL COMMENT '员工id',
  `phone` varchar(255) DEFAULT '' COMMENT '手机号码',
  `project` varchar(255) DEFAULT '' COMMENT '项目名称',
  `sale_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '销售日期',
  `sale_num` int(11) DEFAULT NULL COMMENT '购买数量',
  `sale_count` decimal(20,0) DEFAULT NULL COMMENT '销售总价',
  `apply_count` decimal(20,0) DEFAULT NULL COMMENT '申请总价',
  `type` tinyint(4) DEFAULT NULL COMMENT '精品订单状态(0 - 待审批 ； 1 - 审批不通过 ； 2 - 审批通过)',
  `invoice` tinyint(4) DEFAULT NULL COMMENT '是否开发票( 0 - 未开发票 ； 1- 开发票)',
  `reason` varchar(255) DEFAULT '' COMMENT '原因',
  `source` tinyint(4) DEFAULT NULL COMMENT '来源(销售订单-0 ， 售后订单 - 1,精品零售订单 - 2)',
  `status` tinyint(4) DEFAULT NULL COMMENT '订单状态（ 0 -删除 ； 1- 正常）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品订单 。 精品订单审批通过后，需要插入一条数据到boutique_order表中，做精品出库';

-- ----------------------------
-- Records of boutique_retail
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_retail_customer
-- ----------------------------
CREATE TABLE `boutique_retail_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '精品零售客户/企业名称',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品零售客户';

-- ----------------------------
-- Records of boutique_retail_customer
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_retail_include
-- ----------------------------
CREATE TABLE `boutique_retail_include` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `retail_id` int(11) DEFAULT NULL COMMENT '精品订单id',
  `information_or_pack_id` int(11) DEFAULT NULL COMMENT '精品单品或礼包id',
  `information_or_pack_num` int(11) DEFAULT NULL COMMENT '精品单品或礼包数量',
  `sale_value` decimal(20,0) DEFAULT NULL COMMENT '精品销售单价',
  `apply_value` decimal(20,0) DEFAULT NULL COMMENT '精品申请单价',
  `is_package` tinyint(4) DEFAULT NULL COMMENT '是否是精品礼包 ( 0 - 不是 ； 1 - 是)',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态(0 - 删除 ； 1- 正常)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boutique_retail_include
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_retail_record
-- ----------------------------
CREATE TABLE `boutique_retail_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `boutique_id` int(11) DEFAULT NULL COMMENT '精品订单id',
  `employee_id` int(11) DEFAULT NULL COMMENT '审批人id',
  `type` tinyint(4) DEFAULT NULL COMMENT '审批状态(0 - 待审批 ； 1 - 审批不通过 ； 2 - 审批通过)',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `create_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品订单审批记录';

-- ----------------------------
-- Records of boutique_retail_record
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_supplier
-- ----------------------------
CREATE TABLE `boutique_supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '供应商名称',
  `fine_brand_id` int(11) DEFAULT NULL COMMENT '精品品牌id',
  `company_tel` varchar(255) DEFAULT NULL COMMENT '公司电话',
  `contacts_one` varchar(255) DEFAULT NULL COMMENT '联系人1名字',
  `contacts_one_phone` varchar(255) DEFAULT NULL COMMENT '联系人1手机号码',
  `contacts_two` varchar(255) DEFAULT NULL COMMENT '联系人2名字',
  `contacts_two_phone` varchar(255) DEFAULT NULL COMMENT '联系人2电话',
  `address` varchar(255) DEFAULT NULL COMMENT '供应商地址',
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商';

-- ----------------------------
-- Records of boutique_supplier
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_target
-- ----------------------------
CREATE TABLE `boutique_target` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_group_id` int(11) DEFAULT NULL COMMENT '部门id',
  `project` varchar(255) DEFAULT '' COMMENT '项目名称',
  `income_play` decimal(20,0) DEFAULT NULL COMMENT '收入计划',
  `profit_play` decimal(20,0) DEFAULT NULL COMMENT '毛利计划',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='目标设定';

-- ----------------------------
-- Records of boutique_target
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_warehouse
-- ----------------------------
CREATE TABLE `boutique_warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL COMMENT '仓库编号',
  `name` varchar(255) DEFAULT NULL COMMENT '仓库名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品仓库表';

-- ----------------------------
-- Records of boutique_warehouse
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_warehouse_change
-- ----------------------------
CREATE TABLE `boutique_warehouse_change` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emplyoee_id` int(11) DEFAULT NULL COMMENT '员工id',
  `apply_name` varchar(255) DEFAULT NULL COMMENT '申请名称',
  `apply_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '申请时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `time_stamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓库和库位变更';

-- ----------------------------
-- Records of boutique_warehouse_change
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_warehouse_change_detail
-- ----------------------------
CREATE TABLE `boutique_warehouse_change_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) DEFAULT NULL COMMENT '操作节点(  0 - 变更前 ; 1 - 变更后 )',
  `boutique_id` int(11) DEFAULT NULL,
  `warehouse_id` int(11) DEFAULT NULL COMMENT '精品仓库id',
  `position_id` int(11) DEFAULT NULL COMMENT '精品仓库库位id',
  `stock` int(11) DEFAULT NULL COMMENT '库存数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓库和库位变更操作明细';

-- ----------------------------
-- Records of boutique_warehouse_change_detail
-- ----------------------------

-- ----------------------------
-- Table structure for boutique_warehouse_position
-- ----------------------------
CREATE TABLE `boutique_warehouse_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL COMMENT '库位编号',
  `name` varchar(255) DEFAULT NULL COMMENT '库位名称',
  `warehouse_id` int(11) DEFAULT NULL COMMENT '仓库id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='精品库 库位表';

-- ----------------------------
-- Records of boutique_warehouse_position
-- ----------------------------

-- ----------------------------
-- Table structure for car_boutique_binding
-- ----------------------------
CREATE TABLE `car_boutique_binding` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_id` int(11) DEFAULT NULL COMMENT '车辆id',
  `boutique_id` int(11) DEFAULT NULL COMMENT '精品id',
  `boutique_num` int(11) DEFAULT NULL COMMENT '精品数量',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆精品绑定表';

-- ----------------------------
-- Records of car_boutique_binding
-- ----------------------------

-- ----------------------------
-- Table structure for car_brand
-- ----------------------------
CREATE TABLE `car_brand` (
  `id` int(11) NOT NULL,
  `distributor_store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `name` varchar(20) DEFAULT '' COMMENT '品牌名称',
  `factory_name` varchar(30) DEFAULT NULL COMMENT '主机厂商名称',
  `picture` varchar(50) DEFAULT '' COMMENT '图片地址',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品牌';

-- ----------------------------
-- Records of car_brand
-- ----------------------------

-- ----------------------------
-- Table structure for car_color
-- ----------------------------
CREATE TABLE `car_color` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT '' COMMENT '颜色名称',
  `family_id` int(11) DEFAULT NULL COMMENT '车系id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='颜色';

-- ----------------------------
-- Records of car_color
-- ----------------------------

-- ----------------------------
-- Table structure for car_family
-- ----------------------------
CREATE TABLE `car_family` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distributor_store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌id',
  `factory_id` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT '' COMMENT '名称',
  `source_id` int(2) DEFAULT NULL COMMENT '来源id',
  `year` varchar(10) DEFAULT '' COMMENT '年款',
  `finance_company_id` int(11) DEFAULT NULL COMMENT '金融公司id',
  `interest_free_day` int(11) DEFAULT NULL COMMENT '免息天数',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车系';

-- ----------------------------
-- Records of car_family
-- ----------------------------

-- ----------------------------
-- Table structure for car_good_info
-- ----------------------------
CREATE TABLE `car_good_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_order_id` int(11) DEFAULT NULL COMMENT '所属整车采购订单id',
  `distributor_store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `vin` varchar(30) DEFAULT '' COMMENT '车架号',
  `year` varchar(10) DEFAULT '' COMMENT '年款',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌id',
  `family_id` int(11) DEFAULT NULL COMMENT '车系id',
  `vehicle_id` int(11) DEFAULT NULL COMMENT '车型配置id',
  `fund_property` int(2) DEFAULT NULL COMMENT '资金属性(1 金融 2 自采)',
  `engine_name` varchar(30) DEFAULT '' COMMENT '供应商名称',
  `decorations_out_id` int(11) DEFAULT NULL COMMENT '车身颜色id',
  `decorations_out_name` varchar(20) DEFAULT '' COMMENT '车身颜色',
  `decorations_in_id` int(11) DEFAULT NULL COMMENT '内饰颜色id',
  `decorations_in_name` varchar(20) DEFAULT '' COMMENT '内饰颜色名称',
  `engine_num` varchar(30) DEFAULT '' COMMENT '发动机号',
  `key_num` varchar(30) DEFAULT '' COMMENT '钥匙号',
  `certification_num` varchar(30) DEFAULT '' COMMENT '合格证号',
  `import_num` varchar(30) DEFAULT '' COMMENT '进口单号',
  `warranty_num` varchar(30) DEFAULT '' COMMENT '保修卡号',
  `inspection_num` varchar(30) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '厂家商检号',
  `standard_price` decimal(20,2) DEFAULT NULL COMMENT '标准指导价',
  `purchase_price` decimal(10,2) DEFAULT NULL COMMENT '实际采购价',
  `purchase_price_pio` decimal(10,2) DEFAULT NULL COMMENT '采购金额PIO',
  `freight_charge` decimal(10,2) DEFAULT NULL COMMENT '运费',
  `entire_purchase_price` decimal(10,2) DEFAULT NULL COMMENT '整车采购价格(运费+采购+PIO）',
  `include_boutique_price` decimal(10,2) DEFAULT NULL COMMENT '含精品指导价',
  `purchase_date` timestamp NULL DEFAULT NULL,
  `produce_date` timestamp NULL DEFAULT NULL COMMENT '生产日期',
  `offline_date` timestamp NULL DEFAULT NULL COMMENT '下线日期',
  `interest_free_day` int(11) DEFAULT NULL COMMENT '免息天数',
  `optional_package_status` int(11) DEFAULT '2' COMMENT '是否有选装包（1 是 2 否）',
  `guaranty_status` int(11) DEFAULT NULL COMMENT '是否抵押（1 是 2 否）',
  `finance_company_id` int(11) DEFAULT NULL COMMENT '抵押金融公司id',
  `finance_company_name` varchar(30) DEFAULT '' COMMENT '抵押金融公司名称',
  `car_data` text COMMENT '随车资料',
  `remark` text COMMENT '备注',
  `storage_status` varchar(2) DEFAULT '' COMMENT '库存状态',
  `in_storage_date` timestamp NULL DEFAULT NULL COMMENT '入库时间',
  `out_storage_date` timestamp NULL DEFAULT NULL COMMENT '出库时间',
  `warehouse_id` int(11) DEFAULT NULL COMMENT '仓库id',
  `storage_id` int(11) DEFAULT NULL COMMENT '库位id',
  `car_supply_status` int(2) DEFAULT NULL COMMENT '配车状态',
  `factory_report_status` int(2) DEFAULT NULL COMMENT '厂家上报状态',
  `virtual_record_status` int(2) DEFAULT NULL COMMENT '是否虚录',
  `deceive_report_status` int(2) DEFAULT NULL COMMENT '是否瞒报',
  `new_boutique_status` int(2) DEFAULT NULL COMMENT '是否新增精品',
  `sell_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '付款时间',
  `forecast_profit` decimal(10,2) DEFAULT NULL COMMENT '预估返利',
  `count_profit` decimal(10,2) DEFAULT NULL COMMENT '计提返利',
  `hot_status` int(2) DEFAULT NULL COMMENT '是否热门车型',
  `first_dms_date` timestamp NULL DEFAULT NULL COMMENT '首次dms时间',
  `real_dms_date` timestamp NULL DEFAULT NULL COMMENT '实际dms时间',
  `operator_id` int(11) DEFAULT NULL COMMENT '入库人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  `two_dimensional_code` varchar(50) DEFAULT '' COMMENT '二维码地址(两张图片 逗号分隔)',
  `detection_status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '检验状态 0未检测 1检测OK  2整备 3拒收',
  `exception_declaration` varchar(255) DEFAULT '' COMMENT '检测异常说明',
  `detection_photo` varchar(255) DEFAULT '' COMMENT '检测单留档照片',
  `exception_photo` varchar(255) DEFAULT '' COMMENT '异常照片',
  `stock_count` tinyint(1) DEFAULT '0' COMMENT '盘点状态 0未核 1已核',
  `depot_check_id` int(11) DEFAULT '0' COMMENT '盘点ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆信息';

-- ----------------------------
-- Records of car_good_info
-- ----------------------------

-- ----------------------------
-- Table structure for car_insurance_record
-- ----------------------------
CREATE TABLE `car_insurance_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_car_id` int(11) DEFAULT NULL COMMENT '试驾车id',
  `insurer_id` int(11) DEFAULT NULL COMMENT '保险公司id',
  `insurance_type_id` int(11) DEFAULT NULL COMMENT '险种id',
  `price` decimal(10,2) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试驾车保险登记';

-- ----------------------------
-- Records of car_insurance_record
-- ----------------------------

-- ----------------------------
-- Table structure for car_interest_rule
-- ----------------------------
CREATE TABLE `car_interest_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distributor_store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `family_id` int(11) DEFAULT NULL COMMENT '所属车系',
  `min_num` int(5) DEFAULT NULL COMMENT '开始数值',
  `max_num` int(5) DEFAULT NULL COMMENT '结束数值',
  `coefficient` double(2,2) DEFAULT NULL COMMENT '系数',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='利息规则';

-- ----------------------------
-- Records of car_interest_rule
-- ----------------------------

-- ----------------------------
-- Table structure for car_maintain_record
-- ----------------------------
CREATE TABLE `car_maintain_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_car_id` int(11) DEFAULT NULL COMMENT '试驾车id',
  `work_order_num` varchar(50) DEFAULT NULL COMMENT '工单号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试驾车维护记录';

-- ----------------------------
-- Records of car_maintain_record
-- ----------------------------

-- ----------------------------
-- Table structure for car_optional_package
-- ----------------------------
CREATE TABLE `car_optional_package` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vin` varchar(30) DEFAULT '' COMMENT 'vin码',
  `code` varchar(30) DEFAULT '' COMMENT '选装件代码',
  `name` varchar(30) DEFAULT '' COMMENT '选装件名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='选装件';

-- ----------------------------
-- Records of car_optional_package
-- ----------------------------

-- ----------------------------
-- Table structure for car_out
-- ----------------------------
CREATE TABLE `car_out` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distributor_store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `application_id` int(11) DEFAULT NULL COMMENT '外出订单id',
  `car_good_id` int(11) DEFAULT NULL COMMENT '商品车id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外车车辆';

-- ----------------------------
-- Records of car_out
-- ----------------------------

-- ----------------------------
-- Table structure for car_out_application
-- ----------------------------
CREATE TABLE `car_out_application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distributor_store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `code` varchar(30) DEFAULT '' COMMENT '申请单号',
  `name` varchar(30) DEFAULT '' COMMENT '名称',
  `applicate_num` int(11) DEFAULT NULL COMMENT '申请数量',
  `applicate_date` timestamp NULL DEFAULT NULL COMMENT '申请时间',
  `plan_out_date` timestamp NULL DEFAULT NULL COMMENT '计划外出时间',
  `plan_return_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '计划返回时间',
  `destination` varchar(50) DEFAULT '' COMMENT '目的地',
  `type` int(2) DEFAULT NULL COMMENT '类型 ',
  `applicate_status` int(2) DEFAULT NULL COMMENT '申请状态',
  `remark` text COMMENT '备注',
  `operator_id` int(11) DEFAULT NULL COMMENT '申请人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  `approval_status` tinyint(4) DEFAULT NULL COMMENT '审批状态',
  `employee_id` tinyint(4) DEFAULT NULL COMMENT '审批人id',
  `approval_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '审批时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车辆外出申请';

-- ----------------------------
-- Records of car_out_application
-- ----------------------------

-- ----------------------------
-- Table structure for car_purchase_order
-- ----------------------------
CREATE TABLE `car_purchase_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distributor_store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `code` varchar(30) DEFAULT '' COMMENT '清单编号',
  `name` varchar(30) DEFAULT '',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌id',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `fund_property` int(2) DEFAULT NULL COMMENT '资金属性(1 金融 2 自采)',
  `engine_name` varchar(30) DEFAULT '' COMMENT '供应商名称',
  `operate_date` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `standard_price` decimal(10,2) DEFAULT NULL COMMENT '指导价总金额',
  `perchase_price` decimal(10,2) DEFAULT NULL COMMENT '实际购买总金额',
  `order_status` int(2) DEFAULT NULL COMMENT '单据状态',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='整车采购订单';

-- ----------------------------
-- Records of car_purchase_order
-- ----------------------------

-- ----------------------------
-- Table structure for car_refuel_record
-- ----------------------------
CREATE TABLE `car_refuel_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_car_id` int(11) DEFAULT NULL COMMENT '试驾车id',
  `fuel_capacity` double DEFAULT NULL COMMENT '油量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `gasoline_coupon` varchar(50) DEFAULT NULL COMMENT '油票',
  `remark` varchar(100) DEFAULT NULL,
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试驾车加油记录表';

-- ----------------------------
-- Records of car_refuel_record
-- ----------------------------

-- ----------------------------
-- Table structure for car_storage
-- ----------------------------
CREATE TABLE `car_storage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distributor_store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `name` varchar(30) DEFAULT '',
  `warehouse_id` int(11) DEFAULT NULL COMMENT '仓库id',
  `picture` varchar(50) DEFAULT '' COMMENT '图片地址',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库位';

-- ----------------------------
-- Records of car_storage
-- ----------------------------

-- ----------------------------
-- Table structure for car_test_info
-- ----------------------------
CREATE TABLE `car_test_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distributor_store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `vin` varchar(30) DEFAULT '' COMMENT '车架号',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌id',
  `family_id` int(11) DEFAULT NULL,
  `vehicle_id` int(11) DEFAULT NULL COMMENT '车型配置',
  `year` varchar(10) DEFAULT '' COMMENT '年款',
  `decorations_out_id` int(11) DEFAULT NULL COMMENT '车身颜色id',
  `decorations_out_name` varchar(20) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '车身颜色名称',
  `decorations_in_id` int(11) DEFAULT NULL COMMENT '内饰颜色id',
  `decorations_in_name` varchar(20) DEFAULT '' COMMENT '内饰颜色名称',
  `engine_num` varchar(30) DEFAULT '' COMMENT '发动机号',
  `test_car_status` int(2) DEFAULT NULL COMMENT '试驾车状态',
  `miles` int(11) DEFAULT NULL COMMENT '公里数',
  `license_num` varchar(30) DEFAULT '' COMMENT '车牌号',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试乘试驾车';

-- ----------------------------
-- Records of car_test_info
-- ----------------------------

-- ----------------------------
-- Table structure for car_vehicle_conf
-- ----------------------------
CREATE TABLE `car_vehicle_conf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distributor_store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `name` varchar(30) DEFAULT '' COMMENT '名称',
  `brand_id` int(11) DEFAULT NULL,
  `factory_id` int(11) DEFAULT NULL,
  `family_id` int(11) DEFAULT NULL COMMENT '车系id',
  `picture` varchar(50) DEFAULT '' COMMENT '图片地址',
  `guide_price` decimal(10,2) DEFAULT NULL COMMENT '指导价格',
  `purchase_price` decimal(10,2) DEFAULT NULL COMMENT '采购价',
  `level_one` decimal(10,2) DEFAULT NULL COMMENT '第一级别报价',
  `level_two` decimal(10,2) DEFAULT NULL COMMENT '第二级别报价',
  `level_three` decimal(10,2) DEFAULT NULL COMMENT '第三级别报价',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='车型';

-- ----------------------------
-- Records of car_vehicle_conf
-- ----------------------------

-- ----------------------------
-- Table structure for car_warehouse
-- ----------------------------
CREATE TABLE `car_warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distributor_store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `name` varchar(30) DEFAULT '' COMMENT '名称',
  `picture` varchar(50) DEFAULT '' COMMENT '图片地址',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓库';

-- ----------------------------
-- Records of car_warehouse
-- ----------------------------

-- ----------------------------
-- Table structure for car_warehouse_change_record
-- ----------------------------
CREATE TABLE `car_warehouse_change_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `distributor_store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `code` varchar(30) DEFAULT '' COMMENT '移库编号',
  `name` varchar(30) DEFAULT '' COMMENT '名称',
  `operate_date` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `before_warehouse_id` int(11) DEFAULT NULL COMMENT '变更前仓库',
  `after_warehouse_id` int(11) DEFAULT NULL COMMENT '变更后仓库',
  `before_storage_id` int(11) DEFAULT NULL COMMENT '变更前库位',
  `after_storage_id` int(11) DEFAULT NULL COMMENT '变更后库位',
  `remark` text COMMENT '备注',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car_warehouse_change_record
-- ----------------------------

-- ----------------------------
-- Table structure for car_wash
-- ----------------------------
CREATE TABLE `car_wash` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `employee_id` int(11) NOT NULL COMMENT '员工ID',
  `customer_id` int(11) NOT NULL COMMENT '客户ID',
  `customer_name` varchar(255) NOT NULL DEFAULT '' COMMENT '客户名',
  `car_number` varchar(255) DEFAULT '' COMMENT '车牌号',
  `vin_code` varchar(255) NOT NULL DEFAULT '' COMMENT 'vin码',
  `state` tinyint(1) NOT NULL COMMENT '状态（1：未洗车，0：洗车中，2，已完成）',
  `apply_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '申请时间',
  `begin_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '完成时间',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `operator_id` int(11) NOT NULL COMMENT '操作人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='洗车排程表';

-- ----------------------------
-- Records of car_wash
-- ----------------------------

-- ----------------------------
-- Table structure for check_item
-- ----------------------------
CREATE TABLE `check_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `check_id` int(11) NOT NULL COMMENT '盘点单ID',
  `boutique_id` int(11) NOT NULL COMMENT '盘点项ID(精品ID)',
  `physical_count_quantity` decimal(10,2) NOT NULL COMMENT '账面数量',
  `physical_inventory` decimal(10,2) NOT NULL COMMENT '盘点数量',
  `difference_quantity` decimal(10,2) NOT NULL COMMENT '盈亏数量',
  `difference_money` decimal(10,2) NOT NULL COMMENT '盈亏金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存盘点项表';

-- ----------------------------
-- Records of check_item
-- ----------------------------

-- ----------------------------
-- Table structure for city
-- ----------------------------
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(255) DEFAULT NULL COMMENT '全称',
  `pinyin` varchar(255) DEFAULT NULL COMMENT '拼音',
  `order_by` char(2) DEFAULT NULL,
  `province_id` int(11) DEFAULT NULL COMMENT '所属省份id',
  `level` int(11) DEFAULT NULL COMMENT '城市级别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=412 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '北京市', 'beijing', 'B', '1', '1');
INSERT INTO `city` VALUES ('2', '天津市', 'tianjin', 'T', '2', '1');
INSERT INTO `city` VALUES ('3', '石家庄市', 'shijiazhuang', 'S', '3', '2');
INSERT INTO `city` VALUES ('4', '唐山市', 'tangshan', 'T', '3', '2');
INSERT INTO `city` VALUES ('5', '秦皇岛市', 'qinhuangdao', 'Q', '3', '3');
INSERT INTO `city` VALUES ('6', '邯郸市', 'handan', 'H', '3', '3');
INSERT INTO `city` VALUES ('7', '邢台市', 'xingtai', 'X', '3', '3');
INSERT INTO `city` VALUES ('8', '保定市', 'baoding', 'B', '3', '2');
INSERT INTO `city` VALUES ('9', '张家口市', 'zhangjiakou', 'Z', '3', '3');
INSERT INTO `city` VALUES ('10', '承德市', 'chengde', 'C', '3', '4');
INSERT INTO `city` VALUES ('11', '沧州市', 'cangzhou', 'C', '3', '3');
INSERT INTO `city` VALUES ('12', '廊坊市', 'langfang', 'L', '3', '3');
INSERT INTO `city` VALUES ('13', '衡水市', 'hengshui', 'H', '3', '3');
INSERT INTO `city` VALUES ('14', '定州市', 'dingzhou', 'D', '3', '4');
INSERT INTO `city` VALUES ('15', '辛集市', 'xinji', 'X', '3', '4');
INSERT INTO `city` VALUES ('16', '太原市', 'taiyuan', 'T', '4', '2');
INSERT INTO `city` VALUES ('17', '大同市', 'datong', 'D', '4', '3');
INSERT INTO `city` VALUES ('18', '阳泉市', 'yangquan', 'Y', '4', '4');
INSERT INTO `city` VALUES ('19', '长治市', 'changzhi', 'C', '4', '3');
INSERT INTO `city` VALUES ('20', '晋城市', 'jincheng', 'J', '4', '4');
INSERT INTO `city` VALUES ('21', '朔州市', 'shuozhou', 'S', '4', '4');
INSERT INTO `city` VALUES ('22', '晋中市', 'jinzhong', 'J', '4', '3');
INSERT INTO `city` VALUES ('23', '运城市', 'yuncheng', 'Y', '4', '3');
INSERT INTO `city` VALUES ('24', '忻州市', 'xinzhou', 'X', '4', '4');
INSERT INTO `city` VALUES ('25', '临汾市', 'linfen', 'L', '4', '3');
INSERT INTO `city` VALUES ('26', '吕梁市', 'lvliang', 'L', '4', '4');
INSERT INTO `city` VALUES ('27', '呼和浩特市', 'huhehaote', 'H', '5', '3');
INSERT INTO `city` VALUES ('28', '包头市', 'baotou', 'B', '5', '3');
INSERT INTO `city` VALUES ('29', '乌海市', 'wuhai', 'W', '5', '5');
INSERT INTO `city` VALUES ('30', '赤峰市', 'chifeng', 'C', '5', '3');
INSERT INTO `city` VALUES ('31', '通辽市', 'tongliao', 'T', '5', '4');
INSERT INTO `city` VALUES ('32', '鄂尔多斯市', 'eerduosi', 'E', '5', '3');
INSERT INTO `city` VALUES ('33', '呼伦贝尔市', 'hulunbeier', 'H', '5', '4');
INSERT INTO `city` VALUES ('34', '巴彦淖尔市', 'bayannaoer', 'B', '5', '4');
INSERT INTO `city` VALUES ('35', '乌兰察布市', 'wulanchabu', 'W', '5', '4');
INSERT INTO `city` VALUES ('36', '兴安盟', 'xingan', 'X', '5', '5');
INSERT INTO `city` VALUES ('37', '锡林郭勒盟', 'xilinguole', 'X', '5', '4');
INSERT INTO `city` VALUES ('38', '阿拉善盟', 'alashan', 'A', '5', '5');
INSERT INTO `city` VALUES ('39', '沈阳市', 'shenyang', 'S', '6', '2');
INSERT INTO `city` VALUES ('40', '大连市', 'dalian', 'D', '6', '2');
INSERT INTO `city` VALUES ('41', '鞍山市', 'anshan', 'A', '6', '3');
INSERT INTO `city` VALUES ('42', '抚顺市', 'fushun', 'F', '6', '4');
INSERT INTO `city` VALUES ('43', '本溪市', 'benxi', 'B', '6', '5');
INSERT INTO `city` VALUES ('44', '丹东市', 'dandong', 'D', '6', '5');
INSERT INTO `city` VALUES ('45', '锦州市', 'jinzhou', 'J', '6', '4');
INSERT INTO `city` VALUES ('46', '营口市', 'yingkou', 'Y', '6', '4');
INSERT INTO `city` VALUES ('47', '阜新市', 'fuxin', 'F', '6', '4');
INSERT INTO `city` VALUES ('48', '辽阳市', 'liaoyang', 'L', '6', '4');
INSERT INTO `city` VALUES ('49', '盘锦市', 'panjin', 'P', '6', '4');
INSERT INTO `city` VALUES ('50', '铁岭市', 'tieling', 'T', '6', '4');
INSERT INTO `city` VALUES ('51', '朝阳市', 'chaoyang', 'C', '6', '4');
INSERT INTO `city` VALUES ('52', '葫芦岛市', 'huludao', 'H', '6', '4');
INSERT INTO `city` VALUES ('53', '长春市', 'changchun', 'C', '7', '2');
INSERT INTO `city` VALUES ('54', '吉林市', 'jilin', 'J', '7', '3');
INSERT INTO `city` VALUES ('55', '四平市', 'siping', 'S', '7', '4');
INSERT INTO `city` VALUES ('56', '辽源市', 'liaoyuan', 'L', '7', '5');
INSERT INTO `city` VALUES ('57', '通化市', 'tonghua', 'T', '7', '5');
INSERT INTO `city` VALUES ('58', '白山市', 'baishan', 'B', '7', '5');
INSERT INTO `city` VALUES ('59', '松原市', 'songyuan', 'S', '7', '4');
INSERT INTO `city` VALUES ('60', '白城市', 'baicheng', 'B', '7', '5');
INSERT INTO `city` VALUES ('61', '延边朝鲜族自治州', 'yanbian', 'Y', '7', '5');
INSERT INTO `city` VALUES ('62', '哈尔滨市', 'haerbin', 'H', '8', '2');
INSERT INTO `city` VALUES ('63', '齐齐哈尔市', 'qiqihaer', 'Q', '8', '4');
INSERT INTO `city` VALUES ('64', '鸡西市', 'jixi', 'J', '8', '5');
INSERT INTO `city` VALUES ('65', '鹤岗市', 'hegang', 'H', '8', '5');
INSERT INTO `city` VALUES ('66', '双鸭山市', 'shuangyashan', 'S', '8', '5');
INSERT INTO `city` VALUES ('67', '大庆市', 'daqing', 'D', '8', '3');
INSERT INTO `city` VALUES ('68', '伊春市', 'yichun', 'Y', '8', '5');
INSERT INTO `city` VALUES ('69', '佳木斯市', 'jiamusi', 'J', '8', '4');
INSERT INTO `city` VALUES ('70', '七台河市', 'qitaihe', 'Q', '8', '5');
INSERT INTO `city` VALUES ('71', '牡丹江市', 'mudanjiang', 'M', '8', '4');
INSERT INTO `city` VALUES ('72', '黑河市', 'heihe', 'H', '8', '5');
INSERT INTO `city` VALUES ('73', '绥化市', 'suihua', 'S', '8', '4');
INSERT INTO `city` VALUES ('74', '大兴安岭地区', 'daxinganling', 'D', '8', '5');
INSERT INTO `city` VALUES ('75', '上海市', 'shanghai', 'S', '9', '1');
INSERT INTO `city` VALUES ('76', '南京市', 'nanjing', 'N', '10', '2');
INSERT INTO `city` VALUES ('77', '无锡市', 'wuxi', 'W', '10', '2');
INSERT INTO `city` VALUES ('78', '徐州市', 'xuzhou', 'X', '10', '3');
INSERT INTO `city` VALUES ('79', '常州市', 'changzhou', 'C', '10', '3');
INSERT INTO `city` VALUES ('80', '苏州市', 'suzhou', 'S', '10', '1');
INSERT INTO `city` VALUES ('81', '南通市', 'nantong', 'N', '10', '2');
INSERT INTO `city` VALUES ('82', '连云港市', 'lianyungang', 'L', '10', '4');
INSERT INTO `city` VALUES ('83', '淮安市', 'huaian', 'H', '10', '3');
INSERT INTO `city` VALUES ('84', '盐城市', 'yancheng', 'Y', '10', '3');
INSERT INTO `city` VALUES ('85', '扬州市', 'yangzhou', 'Y', '10', '3');
INSERT INTO `city` VALUES ('86', '镇江市', 'zhenjiang', 'Z', '10', '3');
INSERT INTO `city` VALUES ('87', '泰州市', 'taizhou', 'T', '10', '3');
INSERT INTO `city` VALUES ('88', '宿迁市', 'suqian', 'S', '10', '3');
INSERT INTO `city` VALUES ('89', '杭州市', 'hangzhou', 'H', '11', '1');
INSERT INTO `city` VALUES ('90', '宁波市', 'ningbo', 'N', '11', '2');
INSERT INTO `city` VALUES ('91', '温州市', 'wenzhou', 'W', '11', '2');
INSERT INTO `city` VALUES ('92', '嘉兴市', 'jiaxing', 'J', '11', '3');
INSERT INTO `city` VALUES ('93', '湖州市', 'huzhou', 'H', '11', '3');
INSERT INTO `city` VALUES ('94', '绍兴市', 'shaoxing', 'S', '11', '3');
INSERT INTO `city` VALUES ('95', '金华市', 'jinhua', 'J', '11', '3');
INSERT INTO `city` VALUES ('96', '衢州市', 'quzhou', 'Q', '11', '4');
INSERT INTO `city` VALUES ('97', '舟山市', 'zhoushan', 'Z', '11', '5');
INSERT INTO `city` VALUES ('98', '台州市', 'taizhou', 'T', '11', '3');
INSERT INTO `city` VALUES ('99', '丽水市', 'lishui', 'L', '11', '4');
INSERT INTO `city` VALUES ('100', '合肥市', 'hefei', 'H', '12', '2');
INSERT INTO `city` VALUES ('101', '芜湖市', 'wuhu', 'W', '12', '3');
INSERT INTO `city` VALUES ('102', '蚌埠市', 'bengbu', 'B', '12', '4');
INSERT INTO `city` VALUES ('103', '淮南市', 'huainan', 'H', '12', '4');
INSERT INTO `city` VALUES ('104', '马鞍山市', 'maanshan', 'M', '12', '4');
INSERT INTO `city` VALUES ('105', '淮北市', 'huaibei', 'H', '12', '4');
INSERT INTO `city` VALUES ('106', '铜陵市', 'tongling', 'T', '12', '5');
INSERT INTO `city` VALUES ('107', '安庆市', 'anqing', 'A', '12', '4');
INSERT INTO `city` VALUES ('108', '黄山市', 'huangshan', 'H', '12', '5');
INSERT INTO `city` VALUES ('109', '滁州市', 'chuzhou', 'C', '12', '4');
INSERT INTO `city` VALUES ('110', '阜阳市', 'fuyang', 'F', '12', '4');
INSERT INTO `city` VALUES ('111', '宿州市', 'suzhou', 'S', '12', '4');
INSERT INTO `city` VALUES ('112', '六安市', 'liuan', 'L', '12', '4');
INSERT INTO `city` VALUES ('113', '亳州市', 'bozhou', 'B', '12', '4');
INSERT INTO `city` VALUES ('114', '池州市', 'chizhou', 'C', '12', '5');
INSERT INTO `city` VALUES ('115', '宣城市', 'xuancheng', 'X', '12', '4');
INSERT INTO `city` VALUES ('116', '福州市', 'fuzhou', 'F', '13', '2');
INSERT INTO `city` VALUES ('117', '厦门市', 'xiamen', 'X', '13', '3');
INSERT INTO `city` VALUES ('118', '莆田市', 'putian', 'P', '13', '4');
INSERT INTO `city` VALUES ('119', '三明市', 'sanming', 'S', '13', '4');
INSERT INTO `city` VALUES ('120', '泉州市', 'quanzhou', 'Q', '13', '3');
INSERT INTO `city` VALUES ('121', '漳州市', 'zhangzhou', 'Z', '13', '4');
INSERT INTO `city` VALUES ('122', '南平市', 'nanping', 'N', '13', '5');
INSERT INTO `city` VALUES ('123', '龙岩市', 'longyan', 'L', '13', '4');
INSERT INTO `city` VALUES ('124', '宁德市', 'ningde', 'N', '13', '5');
INSERT INTO `city` VALUES ('125', '南昌市', 'nanchang', 'N', '14', '3');
INSERT INTO `city` VALUES ('126', '景德镇市', 'jingdezhen', 'J', '14', '4');
INSERT INTO `city` VALUES ('127', '萍乡市', 'pingxiang', 'P', '14', '5');
INSERT INTO `city` VALUES ('128', '九江市', 'jiujiang', 'J', '14', '4');
INSERT INTO `city` VALUES ('129', '新余市', 'xinyu', 'X', '14', '5');
INSERT INTO `city` VALUES ('130', '鹰潭市', 'yingtan', 'Y', '14', '5');
INSERT INTO `city` VALUES ('131', '赣州市', 'ganzhou', 'G', '14', '3');
INSERT INTO `city` VALUES ('132', '吉安市', 'jian', 'J', '14', '4');
INSERT INTO `city` VALUES ('133', '宜春市', 'yichun', 'Y', '14', '4');
INSERT INTO `city` VALUES ('134', '抚州市', 'fuzhou', 'F', '14', '4');
INSERT INTO `city` VALUES ('135', '上饶市', 'shangrao', 'S', '14', '4');
INSERT INTO `city` VALUES ('136', '济南市', 'jinan', 'J', '15', '2');
INSERT INTO `city` VALUES ('137', '青岛市', 'qingdao', 'Q', '15', '2');
INSERT INTO `city` VALUES ('138', '淄博市', 'zibo', 'Z', '15', '3');
INSERT INTO `city` VALUES ('139', '枣庄市', 'zaozhuang', 'Z', '15', '4');
INSERT INTO `city` VALUES ('140', '东营市', 'dongying', 'D', '15', '3');
INSERT INTO `city` VALUES ('141', '烟台市', 'yantai', 'Y', '15', '3');
INSERT INTO `city` VALUES ('142', '潍坊市', 'weifang', 'W', '15', '2');
INSERT INTO `city` VALUES ('143', '济宁市', 'jining', 'J', '15', '3');
INSERT INTO `city` VALUES ('144', '泰安市', 'taian', 'T', '15', '3');
INSERT INTO `city` VALUES ('145', '威海市', 'weihai', 'W', '15', '3');
INSERT INTO `city` VALUES ('146', '日照市', 'rizhao', 'R', '15', '3');
INSERT INTO `city` VALUES ('147', '莱芜市', 'laiwu', 'L', '15', '4');
INSERT INTO `city` VALUES ('148', '临沂市', 'linyi', 'L', '15', '2');
INSERT INTO `city` VALUES ('149', '德州市', 'dezhou', 'D', '15', '3');
INSERT INTO `city` VALUES ('150', '聊城市', 'liaocheng', 'L', '15', '3');
INSERT INTO `city` VALUES ('151', '滨州市', 'binzhou', 'B', '15', '3');
INSERT INTO `city` VALUES ('152', '菏泽市', 'heze', 'H', '15', '3');
INSERT INTO `city` VALUES ('153', '郑州市', 'zhengzhou', 'Z', '16', '2');
INSERT INTO `city` VALUES ('154', '开封市', 'kaifeng', 'K', '16', '4');
INSERT INTO `city` VALUES ('155', '洛阳市', 'luoyang', 'L', '16', '3');
INSERT INTO `city` VALUES ('156', '平顶山市', 'pingdingshan', 'P', '16', '4');
INSERT INTO `city` VALUES ('157', '安阳市', 'anyang', 'A', '16', '4');
INSERT INTO `city` VALUES ('158', '鹤壁市', 'hebi', 'H', '16', '5');
INSERT INTO `city` VALUES ('159', '新乡市', 'xinxiang', 'X', '16', '3');
INSERT INTO `city` VALUES ('160', '焦作市', 'jiaozuo', 'J', '16', '4');
INSERT INTO `city` VALUES ('161', '濮阳市', 'puyang', 'P', '16', '4');
INSERT INTO `city` VALUES ('162', '许昌市', 'xuchang', 'X', '16', '4');
INSERT INTO `city` VALUES ('163', '漯河市', 'luohe', 'L', '16', '5');
INSERT INTO `city` VALUES ('164', '三门峡市', 'sanmenxia', 'S', '16', '4');
INSERT INTO `city` VALUES ('165', '南阳市', 'nanyang', 'N', '16', '3');
INSERT INTO `city` VALUES ('166', '商丘市', 'shangqiu', 'S', '16', '3');
INSERT INTO `city` VALUES ('167', '信阳市', 'xinyang', 'X', '16', '4');
INSERT INTO `city` VALUES ('168', '周口市', 'zhoukou', 'Z', '16', '4');
INSERT INTO `city` VALUES ('169', '驻马店市', 'zhumadian', 'Z', '16', '4');
INSERT INTO `city` VALUES ('170', '济源市', 'jiyuan', 'J', '16', '5');
INSERT INTO `city` VALUES ('171', '武汉市', 'wuhan', 'W', '17', '2');
INSERT INTO `city` VALUES ('172', '黄石市', 'huangshi', 'H', '17', '4');
INSERT INTO `city` VALUES ('173', '十堰市', 'shiyan', 'S', '17', '4');
INSERT INTO `city` VALUES ('174', '宜昌市', 'yichang', 'Y', '17', '3');
INSERT INTO `city` VALUES ('175', '襄阳市', 'xiangyang', 'X', '17', '3');
INSERT INTO `city` VALUES ('176', '鄂州市', 'ezhou', 'E', '17', '5');
INSERT INTO `city` VALUES ('177', '荆门市', 'jingmen', 'J', '17', '4');
INSERT INTO `city` VALUES ('178', '孝感市', 'xiaogan', 'X', '17', '4');
INSERT INTO `city` VALUES ('179', '荆州市', 'jingzhou', 'J', '17', '4');
INSERT INTO `city` VALUES ('180', '黄冈市', 'huanggang', 'H', '17', '4');
INSERT INTO `city` VALUES ('181', '咸宁市', 'xianning', 'X', '17', '5');
INSERT INTO `city` VALUES ('182', '随州市', 'suizhou', 'S', '17', '5');
INSERT INTO `city` VALUES ('183', '恩施土家族苗族自治州', 'enshi', 'E', '17', '4');
INSERT INTO `city` VALUES ('184', '仙桃市', 'xiantao', 'X', '17', '5');
INSERT INTO `city` VALUES ('185', '潜江市', 'qianjiang', 'Q', '17', '5');
INSERT INTO `city` VALUES ('186', '天门市', 'tianmen', 'T', '17', '5');
INSERT INTO `city` VALUES ('187', '神农架林区', 'shennongjia', 'S', '17', '5');
INSERT INTO `city` VALUES ('188', '长沙市', 'changsha', 'C', '18', '2');
INSERT INTO `city` VALUES ('189', '株洲市', 'zhuzhou', 'Z', '18', '4');
INSERT INTO `city` VALUES ('190', '湘潭市', 'xiangtan', 'X', '18', '4');
INSERT INTO `city` VALUES ('191', '衡阳市', 'hengyang', 'H', '18', '4');
INSERT INTO `city` VALUES ('192', '邵阳市', 'shaoyang', 'S', '18', '4');
INSERT INTO `city` VALUES ('193', '岳阳市', 'yueyang', 'Y', '18', '4');
INSERT INTO `city` VALUES ('194', '常德市', 'changde', 'C', '18', '4');
INSERT INTO `city` VALUES ('195', '张家界市', 'zhangjiajie', 'Z', '18', '5');
INSERT INTO `city` VALUES ('196', '益阳市', 'yiyang', 'Y', '18', '4');
INSERT INTO `city` VALUES ('197', '郴州市', 'chenzhou', 'C', '18', '4');
INSERT INTO `city` VALUES ('198', '永州市', 'yongzhou', 'Y', '18', '4');
INSERT INTO `city` VALUES ('199', '怀化市', 'huaihua', 'H', '18', '4');
INSERT INTO `city` VALUES ('200', '娄底市', 'loudi', 'L', '18', '4');
INSERT INTO `city` VALUES ('201', '湘西土家族苗族自治州', 'xiangxi', 'X', '18', '5');
INSERT INTO `city` VALUES ('202', '广州市', 'guangzhou', 'G', '19', '1');
INSERT INTO `city` VALUES ('203', '韶关市', 'shaoguan', 'S', '19', '5');
INSERT INTO `city` VALUES ('204', '深圳市', 'shenzhen', 'S', '19', '1');
INSERT INTO `city` VALUES ('205', '珠海市', 'zhuhai', 'Z', '19', '3');
INSERT INTO `city` VALUES ('206', '汕头市', 'shantou', 'S', '19', '3');
INSERT INTO `city` VALUES ('207', '佛山市', 'foshan', 'F', '19', '2');
INSERT INTO `city` VALUES ('208', '江门市', 'jiangmen', 'J', '19', '3');
INSERT INTO `city` VALUES ('209', '湛江市', 'zhanjiang', 'Z', '19', '4');
INSERT INTO `city` VALUES ('210', '茂名市', 'maoming', 'M', '19', '4');
INSERT INTO `city` VALUES ('211', '肇庆市', 'zhaoqing', 'Z', '19', '4');
INSERT INTO `city` VALUES ('212', '惠州市', 'huizhou', 'H', '19', '3');
INSERT INTO `city` VALUES ('213', '梅州市', 'meizhou', 'M', '19', '4');
INSERT INTO `city` VALUES ('214', '汕尾市', 'shanwei', 'S', '19', '5');
INSERT INTO `city` VALUES ('215', '河源市', 'heyuan', 'H', '19', '5');
INSERT INTO `city` VALUES ('216', '阳江市', 'yangjiang', 'Y', '19', '4');
INSERT INTO `city` VALUES ('217', '清远市', 'qingyuan', 'Q', '19', '4');
INSERT INTO `city` VALUES ('218', '东莞市', 'dongguan', 'D', '19', '2');
INSERT INTO `city` VALUES ('219', '中山市', 'zhongshan', 'Z', '19', '3');
INSERT INTO `city` VALUES ('220', '潮州市', 'chaozhou', 'C', '19', '5');
INSERT INTO `city` VALUES ('221', '揭阳市', 'jieyang', 'J', '19', '4');
INSERT INTO `city` VALUES ('222', '云浮市', 'yunfu', 'Y', '19', '5');
INSERT INTO `city` VALUES ('223', '南宁市', 'nanning', 'N', '20', '3');
INSERT INTO `city` VALUES ('224', '柳州市', 'liuzhou', 'L', '20', '3');
INSERT INTO `city` VALUES ('225', '桂林市', 'guilin', 'G', '20', '4');
INSERT INTO `city` VALUES ('226', '梧州市', 'wuzhou', 'W', '20', '5');
INSERT INTO `city` VALUES ('227', '北海市', 'beihai', 'B', '20', '5');
INSERT INTO `city` VALUES ('228', '防城港市', 'fangchenggang', 'F', '20', '5');
INSERT INTO `city` VALUES ('229', '钦州市', 'qinzhou', 'Q', '20', '5');
INSERT INTO `city` VALUES ('230', '贵港市', 'guigang', 'G', '20', '5');
INSERT INTO `city` VALUES ('231', '玉林市', 'yulin', 'Y', '20', '4');
INSERT INTO `city` VALUES ('232', '百色市', 'baise', 'B', '20', '5');
INSERT INTO `city` VALUES ('233', '贺州市', 'hezhou', 'H', '20', '5');
INSERT INTO `city` VALUES ('234', '河池市', 'hechi', 'H', '20', '5');
INSERT INTO `city` VALUES ('235', '来宾市', 'laibin', 'L', '20', '5');
INSERT INTO `city` VALUES ('236', '崇左市', 'chongzuo', 'C', '20', '5');
INSERT INTO `city` VALUES ('237', '海口市', 'haikou', 'H', '21', '3');
INSERT INTO `city` VALUES ('238', '三亚市', 'sanya', 'S', '21', '4');
INSERT INTO `city` VALUES ('239', '三沙市', 'sansha', 'S', '21', '5');
INSERT INTO `city` VALUES ('240', '儋州市', 'danzhou', 'D', '21', '4');
INSERT INTO `city` VALUES ('241', '五指山市', 'wuzhishan', 'W', '21', '4');
INSERT INTO `city` VALUES ('242', '琼海市', 'qionghai', 'Q', '21', '4');
INSERT INTO `city` VALUES ('243', '文昌市', 'wenchang', 'W', '21', '4');
INSERT INTO `city` VALUES ('244', '万宁市', 'wanning', 'W', '21', '4');
INSERT INTO `city` VALUES ('245', '东方市', 'dongfang', 'D', '21', '4');
INSERT INTO `city` VALUES ('246', '定安县', 'dingan', 'D', '21', '4');
INSERT INTO `city` VALUES ('247', '屯昌县', 'tunchang', 'T', '21', '4');
INSERT INTO `city` VALUES ('248', '澄迈县', 'chengmai', 'C', '21', '4');
INSERT INTO `city` VALUES ('249', '临高县', 'lingao', 'L', '21', '4');
INSERT INTO `city` VALUES ('250', '白沙黎族自治县', 'baisha', 'B', '21', '4');
INSERT INTO `city` VALUES ('251', '昌江黎族自治县', 'changjiang', 'C', '21', '4');
INSERT INTO `city` VALUES ('252', '乐东黎族自治县', 'ledong', 'L', '21', '4');
INSERT INTO `city` VALUES ('253', '陵水黎族自治县', 'lingshui', 'L', '21', '4');
INSERT INTO `city` VALUES ('254', '保亭黎族苗族自治县', 'baoting', 'B', '21', '4');
INSERT INTO `city` VALUES ('255', '琼中黎族苗族自治县', 'qiongzhong', 'Q', '21', '4');
INSERT INTO `city` VALUES ('256', '重庆市', 'chongqing', 'C', '22', '1');
INSERT INTO `city` VALUES ('257', '成都市', 'chengdu', 'C', '23', '1');
INSERT INTO `city` VALUES ('258', '自贡市', 'zigong', 'Z', '23', '5');
INSERT INTO `city` VALUES ('259', '攀枝花市', 'panzhihua', 'P', '23', '5');
INSERT INTO `city` VALUES ('260', '泸州市', 'luzhou', 'L', '23', '4');
INSERT INTO `city` VALUES ('261', '德阳市', 'deyang', 'D', '23', '4');
INSERT INTO `city` VALUES ('262', '绵阳市', 'mianyang', 'M', '23', '4');
INSERT INTO `city` VALUES ('263', '广元市', 'guangyuan', 'G', '23', '5');
INSERT INTO `city` VALUES ('264', '遂宁市', 'suining', 'S', '23', '5');
INSERT INTO `city` VALUES ('265', '内江市', 'neijiang', 'N', '23', '5');
INSERT INTO `city` VALUES ('266', '乐山市', 'leshan', 'L', '23', '4');
INSERT INTO `city` VALUES ('267', '南充市', 'nanchong', 'N', '23', '4');
INSERT INTO `city` VALUES ('268', '眉山市', 'meishan', 'M', '23', '4');
INSERT INTO `city` VALUES ('269', '宜宾市', 'yibin', 'Y', '23', '4');
INSERT INTO `city` VALUES ('270', '广安市', 'guangan', 'G', '23', '5');
INSERT INTO `city` VALUES ('271', '达州市', 'dazhou', 'D', '23', '5');
INSERT INTO `city` VALUES ('272', '雅安市', 'yaan', 'Y', '23', '5');
INSERT INTO `city` VALUES ('273', '巴中市', 'bazhong', 'B', '23', '5');
INSERT INTO `city` VALUES ('274', '资阳市', 'ziyang', 'Z', '23', '5');
INSERT INTO `city` VALUES ('275', '阿坝藏族羌族自治州', 'aba', 'A', '23', '5');
INSERT INTO `city` VALUES ('276', '甘孜藏族自治州', 'ganzi', 'G', '23', '5');
INSERT INTO `city` VALUES ('277', '凉山彝族自治州', 'liangshan', 'L', '23', '5');
INSERT INTO `city` VALUES ('278', '贵阳市', 'guiyang', 'G', '24', '3');
INSERT INTO `city` VALUES ('279', '六盘水市', 'liupanshui', 'L', '24', '5');
INSERT INTO `city` VALUES ('280', '遵义市', 'zunyi', 'Z', '24', '4');
INSERT INTO `city` VALUES ('281', '安顺市', 'anshun', 'A', '24', '5');
INSERT INTO `city` VALUES ('282', '毕节市', 'bijie', 'B', '24', '4');
INSERT INTO `city` VALUES ('283', '铜仁市', 'tongren', 'T', '24', '4');
INSERT INTO `city` VALUES ('284', '黔西南布依族苗族自治州', 'qianxinan', 'Q', '24', '5');
INSERT INTO `city` VALUES ('285', '黔东南苗族侗族自治州', 'qiandongnan', 'Q', '24', '5');
INSERT INTO `city` VALUES ('286', '黔南布依族苗族自治州', 'qiannan', 'Q', '24', '5');
INSERT INTO `city` VALUES ('287', '昆明市', 'kunming', 'K', '25', '2');
INSERT INTO `city` VALUES ('288', '曲靖市', 'qujing', 'Q', '25', '4');
INSERT INTO `city` VALUES ('289', '玉溪市', 'yuxi', 'Y', '25', '4');
INSERT INTO `city` VALUES ('290', '保山市', 'baoshan', 'B', '25', '5');
INSERT INTO `city` VALUES ('291', '昭通市', 'zhaotong', 'Z', '25', '5');
INSERT INTO `city` VALUES ('292', '丽江市', 'lijiang', 'L', '25', '5');
INSERT INTO `city` VALUES ('293', '普洱市', 'puer', 'P', '25', '5');
INSERT INTO `city` VALUES ('294', '临沧市', 'lincang', 'L', '25', '5');
INSERT INTO `city` VALUES ('295', '楚雄彝族自治州', 'chuxiong', 'C', '25', '5');
INSERT INTO `city` VALUES ('296', '红河哈尼族彝族自治州', 'honghe', 'H', '25', '4');
INSERT INTO `city` VALUES ('297', '文山壮族苗族自治州', 'wenshan', 'W', '25', '5');
INSERT INTO `city` VALUES ('298', '西双版纳傣族自治州', 'xishuangbanna', 'X', '25', '5');
INSERT INTO `city` VALUES ('299', '大理白族自治州', 'dali', 'D', '25', '5');
INSERT INTO `city` VALUES ('300', '德宏傣族景颇族自治州', 'dehong', 'D', '25', '5');
INSERT INTO `city` VALUES ('301', '怒江傈僳族自治州', 'nujiang', 'N', '25', '5');
INSERT INTO `city` VALUES ('302', '迪庆藏族自治州', 'diqing', 'D', '25', '5');
INSERT INTO `city` VALUES ('303', '拉萨市', 'lasa', 'L', '26', '5');
INSERT INTO `city` VALUES ('304', '日喀则市', 'rikaze', 'R', '26', '4');
INSERT INTO `city` VALUES ('305', '昌都市', 'changdu', 'C', '26', '4');
INSERT INTO `city` VALUES ('306', '林芝市', 'linzhi', 'L', '26', '4');
INSERT INTO `city` VALUES ('307', '山南市', 'shannan', 'S', '26', '4');
INSERT INTO `city` VALUES ('308', '那曲地区', 'naqu', 'N', '26', '5');
INSERT INTO `city` VALUES ('309', '阿里地区', 'ali', 'A', '26', '5');
INSERT INTO `city` VALUES ('310', '西安市', 'xian', 'X', '27', '2');
INSERT INTO `city` VALUES ('311', '铜川市', 'tongchuan', 'T', '27', '5');
INSERT INTO `city` VALUES ('312', '宝鸡市', 'baoji', 'B', '27', '4');
INSERT INTO `city` VALUES ('313', '咸阳市', 'xianyang', 'X', '27', '4');
INSERT INTO `city` VALUES ('314', '渭南市', 'weinan', 'W', '27', '4');
INSERT INTO `city` VALUES ('315', '延安市', 'yanan', 'Y', '27', '4');
INSERT INTO `city` VALUES ('316', '汉中市', 'hanzhong', 'H', '27', '4');
INSERT INTO `city` VALUES ('317', '榆林市', 'yulin', 'Y', '27', '3');
INSERT INTO `city` VALUES ('318', '安康市', 'ankang', 'A', '27', '5');
INSERT INTO `city` VALUES ('319', '商洛市', 'shangluo', 'S', '27', '5');
INSERT INTO `city` VALUES ('320', '兰州市', 'lanzhou', 'L', '28', '3');
INSERT INTO `city` VALUES ('321', '嘉峪关市', 'jiayuguan', 'J', '28', '5');
INSERT INTO `city` VALUES ('322', '金昌市', 'jinchang', 'J', '28', '5');
INSERT INTO `city` VALUES ('323', '白银市', 'baiyin', 'B', '28', '5');
INSERT INTO `city` VALUES ('324', '天水市', 'tianshui', 'T', '28', '5');
INSERT INTO `city` VALUES ('325', '武威市', 'wuwei', 'W', '28', '5');
INSERT INTO `city` VALUES ('326', '张掖市', 'zhangye', 'Z', '28', '5');
INSERT INTO `city` VALUES ('327', '平凉市', 'pingliang', 'P', '28', '5');
INSERT INTO `city` VALUES ('328', '酒泉市', 'jiuquan', 'J', '28', '5');
INSERT INTO `city` VALUES ('329', '庆阳市', 'qingyang', 'Q', '28', '5');
INSERT INTO `city` VALUES ('330', '定西市', 'dingxi', 'D', '28', '5');
INSERT INTO `city` VALUES ('331', '陇南市', 'longnan', 'L', '28', '5');
INSERT INTO `city` VALUES ('332', '临夏回族自治州', 'linxia', 'L', '28', '5');
INSERT INTO `city` VALUES ('333', '甘南藏族自治州', 'gannan', 'G', '28', '5');
INSERT INTO `city` VALUES ('334', '西宁市', 'xining', 'X', '29', '3');
INSERT INTO `city` VALUES ('335', '海东市', 'haidong', 'H', '29', '4');
INSERT INTO `city` VALUES ('336', '海北藏族自治州', 'haibei', 'H', '29', '5');
INSERT INTO `city` VALUES ('337', '黄南藏族自治州', 'huangnan', 'H', '29', '5');
INSERT INTO `city` VALUES ('338', '海南藏族自治州', 'hainan', 'H', '29', '5');
INSERT INTO `city` VALUES ('339', '果洛藏族自治州', 'guoluo', 'G', '29', '5');
INSERT INTO `city` VALUES ('340', '玉树藏族自治州', 'yushu', 'Y', '29', '5');
INSERT INTO `city` VALUES ('341', '海西蒙古族藏族自治州', 'haixi', 'H', '29', '5');
INSERT INTO `city` VALUES ('342', '银川市', 'yinchuan', 'Y', '30', '3');
INSERT INTO `city` VALUES ('343', '石嘴山市', 'shizuishan', 'S', '30', '5');
INSERT INTO `city` VALUES ('344', '吴忠市', 'wuzhong', 'W', '30', '5');
INSERT INTO `city` VALUES ('345', '固原市', 'guyuan', 'G', '30', '5');
INSERT INTO `city` VALUES ('346', '中卫市', 'zhongwei', 'Z', '30', '5');
INSERT INTO `city` VALUES ('347', '乌鲁木齐市', 'wulumuqi', 'W', '31', '3');
INSERT INTO `city` VALUES ('348', '克拉玛依市', 'kelamayi', 'K', '31', '5');
INSERT INTO `city` VALUES ('349', '吐鲁番市', 'tulufan', 'T', '31', '4');
INSERT INTO `city` VALUES ('350', '哈密市', 'hami', 'H', '31', '4');
INSERT INTO `city` VALUES ('351', '昌吉回族自治州', 'changji', 'C', '31', '5');
INSERT INTO `city` VALUES ('352', '博尔塔拉蒙古自治州', 'bozhou', 'B', '31', '5');
INSERT INTO `city` VALUES ('353', '巴音郭楞蒙古自治州', 'bazhou', 'B', '31', '5');
INSERT INTO `city` VALUES ('354', '阿克苏地区', 'akesu', 'A', '31', '4');
INSERT INTO `city` VALUES ('355', '克孜勒苏柯尔克孜自治州', 'kezhou', 'K', '31', '5');
INSERT INTO `city` VALUES ('356', '喀什地区', 'kashi', 'K', '31', '5');
INSERT INTO `city` VALUES ('357', '和田地区', 'hetian', 'H', '31', '5');
INSERT INTO `city` VALUES ('358', '伊犁哈萨克自治州', 'yili', 'Y', '31', '4');
INSERT INTO `city` VALUES ('359', '塔城地区', 'tacheng', 'T', '31', '5');
INSERT INTO `city` VALUES ('360', '阿勒泰地区', 'aletai', 'A', '31', '5');
INSERT INTO `city` VALUES ('361', '石河子市', 'shihezi', 'S', '31', '5');
INSERT INTO `city` VALUES ('362', '阿拉尔市', 'alaer', 'A', '31', '4');
INSERT INTO `city` VALUES ('363', '图木舒克市', 'tumushuke', 'T', '31', '4');
INSERT INTO `city` VALUES ('364', '五家渠市', 'wujiaqu', 'W', '31', '4');
INSERT INTO `city` VALUES ('365', '北屯市', 'beitun', 'B', '31', '4');
INSERT INTO `city` VALUES ('366', '铁门关市', 'tiemenguan', 'T', '31', '4');
INSERT INTO `city` VALUES ('367', '双河市', 'shuanghe', 'S', '31', '4');
INSERT INTO `city` VALUES ('368', '可克达拉市', 'kekedala', 'K', '31', '4');
INSERT INTO `city` VALUES ('369', '昆玉市', 'kunyu', 'K', '31', '4');
INSERT INTO `city` VALUES ('370', '台北市', 'taibei', 'T', '32', '4');
INSERT INTO `city` VALUES ('371', '高雄市', 'gaoxiong', 'G', '32', '4');
INSERT INTO `city` VALUES ('372', '台南市', 'tainan', 'T', '32', '4');
INSERT INTO `city` VALUES ('373', '台中市', 'taizhong', 'T', '32', '4');
INSERT INTO `city` VALUES ('374', '南投县', 'nantou', 'N', '32', '4');
INSERT INTO `city` VALUES ('375', '基隆市', 'jilong', 'J', '32', '4');
INSERT INTO `city` VALUES ('376', '新竹市', 'xinzhu', 'X', '32', '4');
INSERT INTO `city` VALUES ('377', '嘉义市', 'jiayi', 'J', '32', '4');
INSERT INTO `city` VALUES ('378', '新北市', 'xinbei', 'X', '32', '4');
INSERT INTO `city` VALUES ('379', '宜兰县', 'yilan', 'Y', '32', '4');
INSERT INTO `city` VALUES ('380', '新竹县', 'xinzhu', 'X', '32', '4');
INSERT INTO `city` VALUES ('381', '桃园市', 'taoyuan', 'T', '32', '4');
INSERT INTO `city` VALUES ('382', '苗栗县', 'miaoli', 'M', '32', '4');
INSERT INTO `city` VALUES ('383', '彰化县', 'zhanghua', 'Z', '32', '4');
INSERT INTO `city` VALUES ('384', '嘉义县', 'jiayi', 'J', '32', '4');
INSERT INTO `city` VALUES ('385', '云林县', 'yunlin', 'Y', '32', '4');
INSERT INTO `city` VALUES ('386', '屏东县', 'pingdong', 'P', '32', '4');
INSERT INTO `city` VALUES ('387', '台东县', 'taidong', 'T', '32', '4');
INSERT INTO `city` VALUES ('388', '花莲县', 'hualian', 'H', '32', '4');
INSERT INTO `city` VALUES ('389', '澎湖县', 'penghu', 'P', '32', '4');
INSERT INTO `city` VALUES ('390', '中西区', 'zhongxiqu', 'Z', '33', '4');
INSERT INTO `city` VALUES ('391', '东区', 'dongqu', 'D', '33', '4');
INSERT INTO `city` VALUES ('392', '九龙城区', 'jiulong', 'J', '33', '4');
INSERT INTO `city` VALUES ('393', '观塘区', 'guantangqu', 'G', '33', '4');
INSERT INTO `city` VALUES ('394', '南区', 'nanqu', 'N', '33', '4');
INSERT INTO `city` VALUES ('395', '深水埗区', 'shenshuibuqu', 'S', '33', '4');
INSERT INTO `city` VALUES ('396', '湾仔区', 'wanziqu', 'W', '33', '4');
INSERT INTO `city` VALUES ('397', '黄大仙区', 'huangdaxianqu', 'H', '33', '4');
INSERT INTO `city` VALUES ('398', '油尖旺区', 'youjianwangqu', 'Y', '33', '4');
INSERT INTO `city` VALUES ('399', '离岛区', 'lidaoqu', 'L', '33', '4');
INSERT INTO `city` VALUES ('400', '葵青区', 'kuiqingqu', 'K', '33', '4');
INSERT INTO `city` VALUES ('401', '北区', 'beiqu', 'B', '33', '4');
INSERT INTO `city` VALUES ('402', '西贡区', 'xigongqu', 'X', '33', '4');
INSERT INTO `city` VALUES ('403', '沙田区', 'shatianqu', 'S', '33', '4');
INSERT INTO `city` VALUES ('404', '屯门区', 'tunmenqu', 'T', '33', '4');
INSERT INTO `city` VALUES ('405', '大埔区', 'dapuqu', 'D', '33', '4');
INSERT INTO `city` VALUES ('406', '荃湾区', 'quanwanqu', 'Q', '33', '4');
INSERT INTO `city` VALUES ('407', '元朗区', 'yuanlangqu', 'Y', '33', '4');
INSERT INTO `city` VALUES ('408', '澳门半岛', 'aomenbandao', 'A', '34', '4');
INSERT INTO `city` VALUES ('409', '凼仔', 'dangzi', 'D', '34', '4');
INSERT INTO `city` VALUES ('410', '路凼城', 'ludangcheng', 'L', '34', '4');
INSERT INTO `city` VALUES ('411', '路环', 'luhuan', 'L', '34', '4');

-- ----------------------------
-- Table structure for commerce_policy
-- ----------------------------
CREATE TABLE `commerce_policy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `policy_code` varchar(12) NOT NULL COMMENT '政策编号',
  `policy_name` varchar(25) NOT NULL COMMENT '政策名称',
  `policy_create_date` datetime NOT NULL COMMENT '政策创建时间',
  `create_date` datetime NOT NULL COMMENT '数据创建时间',
  `update_date` datetime NOT NULL COMMENT '数据修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商务政策表';

-- ----------------------------
-- Records of commerce_policy
-- ----------------------------

-- ----------------------------
-- Table structure for counter
-- ----------------------------

CREATE TABLE `counter` (
  `code_prefix` varchar(12) DEFAULT '' COMMENT '业务系统生成编号的前缀 如：客户编号 KH',
  `counter` int(11) DEFAULT '0' COMMENT '计数',
  UNIQUE KEY `uni_type` (`code_prefix`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务系统生成编号计数器表';

-- ----------------------------
-- Records of counter
-- ----------------------------

-- ----------------------------
-- Table structure for customer
-- ----------------------------

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `passenger_id` int(11) DEFAULT NULL COMMENT '客流ID',
  `category` tinyint(1) NOT NULL DEFAULT '1' COMMENT '客户分类(默认潜客)',
  `type` tinyint(1) DEFAULT NULL COMMENT '客户类型',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `phone` varchar(11) NOT NULL DEFAULT '' COMMENT '客户手机号',
  `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别 0：男，1：女',
  `number` varchar(8) NOT NULL DEFAULT '' COMMENT '客户编号',
  `owned_cars` varchar(255) DEFAULT '' COMMENT '原有车辆(车辆1型号，车牌；车辆2型号，车牌  .......)',
  `province_id` int(11) DEFAULT NULL COMMENT '省',
  `city_id` int(11) DEFAULT NULL COMMENT '市',
  `district_id` int(11) DEFAULT NULL COMMENT '区',
  `channel` int(3) DEFAULT NULL COMMENT '渠道来源',
  `level` int(3) NOT NULL COMMENT '客户级别',
  `contact_time` int(3) DEFAULT NULL COMMENT '适合联系时段 ',
  `relation_customer` int(3) DEFAULT NULL COMMENT '关系客户',
  `origin` int(3) NOT NULL COMMENT '客户来源',
  `intention_vehicle_id` int(11) NOT NULL COMMENT '意向车型id',
  `usage` int(3) DEFAULT NULL COMMENT '新车用途',
  `user` int(3) DEFAULT NULL COMMENT '用车人',
  `user_sex` tinyint(1) DEFAULT NULL COMMENT '用车人性别',
  `attention_point` int(3) DEFAULT NULL COMMENT '关注点',
  `budget` decimal(10,2) DEFAULT NULL COMMENT '购车预算',
  `expect_buy_time` date DEFAULT NULL COMMENT '预计购车时间',
  `buy_type` tinyint(1) DEFAULT NULL COMMENT '购买方式（1：一次性，2贷款）',
  `attention_car_one` varchar(255) DEFAULT '' COMMENT '关注竞品一',
  `attention_car_two` varchar(255) DEFAULT '' COMMENT '关注竞品二',
  `attention_car_three` varchar(255) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '关注竞品三',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `employee_id` int(11) NOT NULL COMMENT '员工ID',
  `store_id` int(11) NOT NULL COMMENT '门店ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for customer_sms
-- ----------------------------

CREATE TABLE `customer_sms` (
  `id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `cus_id` int(11) DEFAULT NULL COMMENT '客户id',
  `iphone` varchar(15) DEFAULT '' COMMENT '手机号码',
  `content` varchar(30) DEFAULT '' COMMENT '短信内容',
  `create_id` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户短信表';

-- ----------------------------
-- Records of customer_sms
-- ----------------------------

-- ----------------------------
-- Table structure for customer_sms_model
-- ----------------------------

CREATE TABLE `customer_sms_model` (
  `id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT '' COMMENT '模板名称',
  `content` varchar(30) DEFAULT '' COMMENT '模板内容',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户短信模板表';

-- ----------------------------
-- Records of customer_sms_model
-- ----------------------------

-- ----------------------------
-- Table structure for deliver_car
-- ----------------------------

CREATE TABLE `deliver_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) DEFAULT NULL COMMENT '客户id',
  `car_id` int(11) DEFAULT NULL COMMENT '车辆id',
  `deliver_time` date DEFAULT NULL COMMENT '交车时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '交车状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交车表';

-- ----------------------------
-- Records of deliver_car
-- ----------------------------

-- ----------------------------
-- Table structure for depot_check
-- ----------------------------

CREATE TABLE `depot_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `number` varchar(255) NOT NULL DEFAULT '' COMMENT '盘点单号',
  `check_name` varchar(255) DEFAULT '' COMMENT '盘点单名称',
  `check_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '盘点时间',
  `warehouse_id` int(11) NOT NULL COMMENT '仓库ID',
  `warehouse_name` varchar(255) DEFAULT NULL COMMENT '仓库名称',
  `state` tinyint(1) NOT NULL COMMENT '盘点单状态（0：已确认，1：已作废，2.以保存）',
  `checker` varchar(255) NOT NULL COMMENT '盘点人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `gain` decimal(10,2) DEFAULT '0.00' COMMENT '盈',
  `loss` decimal(10,2) DEFAULT '0.00' COMMENT '亏',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存盘点表';

-- ----------------------------
-- Records of depot_check
-- ----------------------------

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------

CREATE TABLE `dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用 1启用，2停用',
  `type` int(11) NOT NULL COMMENT '资源类型',
  `type_desc` varchar(255) NOT NULL COMMENT '资源描述',
  `resource_key` int(11) DEFAULT NULL COMMENT 'key',
  `resource_value` varchar(255) DEFAULT '' COMMENT '内容(多个内容用；隔开)',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('1', '1', '1', '客户类型', '1', '首次购车', '2018-05-31 17:02:50', '2018-05-31 17:02:55');
INSERT INTO `dictionary` VALUES ('2', '1', '1', '客户类型', '2', '本品牌换购', '2018-05-31 17:03:25', '2018-05-31 17:03:27');
INSERT INTO `dictionary` VALUES ('3', '1', '1', '客户类型', '3', '他品牌换购', '2018-05-31 17:03:50', '2018-05-31 17:03:53');
INSERT INTO `dictionary` VALUES ('4', '1', '1', '客户类型', '4', '本品牌增购', '2018-05-31 17:04:21', '2018-05-31 17:04:23');
INSERT INTO `dictionary` VALUES ('5', '1', '1', '客户类型', '5', '他品牌增购', '2018-05-31 17:04:32', '2018-05-31 17:04:32');
INSERT INTO `dictionary` VALUES ('6', '1', '1', '客户类型', '6', '其他', '2018-05-31 17:05:30', '2018-05-31 17:05:32');
INSERT INTO `dictionary` VALUES ('7', '1', '2', '关系客户', '1', '老客户转介绍', '2018-05-31 17:06:26', '2018-05-31 17:06:28');
INSERT INTO `dictionary` VALUES ('8', '1', '2', '关系客户', '2', '员工介绍', '2018-05-31 17:07:17', '2018-05-31 17:07:20');
INSERT INTO `dictionary` VALUES ('9', '1', '2', '关系客户', '3', '媒体介绍', '2018-05-31 17:08:21', '2018-05-31 17:08:24');
INSERT INTO `dictionary` VALUES ('10', '1', '2', '关系客户', '4', 'VIP介绍', '2018-06-01 15:09:51', '2018-06-01 15:09:53');
INSERT INTO `dictionary` VALUES ('11', '1', '2', '关系客户', '5', '关系单位介绍', '2018-06-01 15:10:28', '2018-06-01 15:10:30');
INSERT INTO `dictionary` VALUES ('12', '1', '2', '关系客户', '6', '其他介绍', '2018-06-01 15:11:42', '2018-06-01 15:11:46');
INSERT INTO `dictionary` VALUES ('13', '1', '2', '关系客户', '7', '大客户', '2018-06-01 15:12:07', '2018-06-01 15:12:10');
INSERT INTO `dictionary` VALUES ('14', '1', '3', '客户来源', '1', '自然进店', '2018-06-01 15:13:13', '2018-06-01 15:13:17');
INSERT INTO `dictionary` VALUES ('15', '1', '3', '客户来源', '2', '网络线索', '2018-06-01 15:13:51', '2018-06-01 15:13:54');
INSERT INTO `dictionary` VALUES ('16', '1', '3', '客户来源', '3', '展厅来电', '2018-06-01 15:14:31', '2018-06-01 15:14:33');
INSERT INTO `dictionary` VALUES ('17', '1', '3', '客户来源', '4', '异业', '2018-06-01 15:14:59', '2018-06-01 15:15:01');
INSERT INTO `dictionary` VALUES ('18', '1', '3', '客户来源', '5', '其他主动出击', '2018-06-01 15:15:21', '2018-06-01 15:15:24');
INSERT INTO `dictionary` VALUES ('19', '1', '3', '客户来源', '6', '外展', '2018-06-01 15:16:01', '2018-06-01 15:16:04');
INSERT INTO `dictionary` VALUES ('20', '1', '3', '客户来源', '7', '再购线索', '2018-06-01 15:16:25', '2018-06-01 15:16:27');
INSERT INTO `dictionary` VALUES ('21', '1', '3', '客户来源', '8', 'CRM', '2018-06-01 15:16:52', '2018-06-01 15:16:54');
INSERT INTO `dictionary` VALUES ('22', '1', '3', '客户来源', '9', '大数据', '2018-06-01 15:17:16', '2018-06-01 15:17:18');
INSERT INTO `dictionary` VALUES ('23', '1', '3', '客户来源', '10', '车展', '2018-06-01 15:17:46', '2018-06-01 15:17:49');
INSERT INTO `dictionary` VALUES ('24', '1', '4', '渠道来源', '1', '汽车之家', '2018-06-01 15:19:42', '2018-06-01 15:19:46');
INSERT INTO `dictionary` VALUES ('25', '1', '4', '渠道来源', '2', '易车', '2018-06-01 15:20:10', '2018-06-01 15:20:13');
INSERT INTO `dictionary` VALUES ('26', '1', '4', '渠道来源', '3', '太平洋', '2018-06-01 15:20:34', '2018-06-01 15:20:36');
INSERT INTO `dictionary` VALUES ('27', '1', '4', '渠道来源', '4', '爱卡', '2018-06-01 15:21:03', '2018-06-01 15:21:06');
INSERT INTO `dictionary` VALUES ('28', '1', '4', '渠道来源', '5', '搜狐汽车', '2018-06-01 15:21:31', '2018-06-01 15:21:33');
INSERT INTO `dictionary` VALUES ('29', '1', '4', '渠道来源', '6', '新浪汽车', '2018-06-01 15:21:54', '2018-06-01 15:21:56');
INSERT INTO `dictionary` VALUES ('30', '1', '4', '渠道来源', '7', '腾讯汽车', '2018-06-01 15:22:18', '2018-06-01 15:22:20');
INSERT INTO `dictionary` VALUES ('31', '1', '4', '渠道来源', '8', '汽车点评网', '2018-06-01 15:22:47', '2018-06-01 15:22:49');
INSERT INTO `dictionary` VALUES ('32', '1', '4', '渠道来源', '9', '微信', '2018-06-01 15:23:10', '2018-06-01 15:23:12');
INSERT INTO `dictionary` VALUES ('33', '1', '4', '渠道来源', '10', '微博', '2018-06-01 15:23:47', '2018-06-01 15:23:41');
INSERT INTO `dictionary` VALUES ('34', '1', '4', '渠道来源', '11', '其他网络', '2018-06-01 15:24:05', '2018-06-01 15:24:07');
INSERT INTO `dictionary` VALUES ('35', '1', '5', '客户级别', '1', 'O', '2018-06-01 15:24:39', '2018-06-01 15:24:41');
INSERT INTO `dictionary` VALUES ('36', '1', '5', '客户级别', '2', 'H', '2018-06-01 15:25:13', '2018-06-01 15:25:16');
INSERT INTO `dictionary` VALUES ('37', '1', '5', '客户级别', '3', 'A', '2018-06-01 15:25:32', '2018-06-01 15:25:34');
INSERT INTO `dictionary` VALUES ('38', '1', '5', '客户级别', '4', 'B', '2018-06-01 15:25:56', '2018-06-01 15:25:59');
INSERT INTO `dictionary` VALUES ('39', '1', '5', '客户级别', '5', 'C', '2018-06-01 15:26:20', '2018-06-01 15:26:22');
INSERT INTO `dictionary` VALUES ('40', '1', '5', '客户级别', '6', 'W', '2018-06-01 15:26:45', '2018-06-01 15:26:47');
INSERT INTO `dictionary` VALUES ('41', '1', '6', '适合联系时段', '1', '08:00~10:00', '2018-06-01 15:31:20', '2018-06-01 15:31:20');
INSERT INTO `dictionary` VALUES ('42', '1', '6', '适合联系时段', '2', '10:00~12:00', '2018-06-01 15:31:48', '2018-06-01 15:31:48');
INSERT INTO `dictionary` VALUES ('43', '1', '6', '适合联系时段', '3', '12:00~14:00', '2018-06-01 15:32:19', '2018-06-01 15:32:21');
INSERT INTO `dictionary` VALUES ('44', '1', '6', '适合联系时段', '4', '14:00~16:00', '2018-06-01 15:32:52', '2018-06-01 15:32:55');
INSERT INTO `dictionary` VALUES ('45', '1', '6', '适合联系时段', '5', '16:00~18:00', '2018-06-01 15:33:35', '2018-06-01 15:33:38');
INSERT INTO `dictionary` VALUES ('46', '1', '6', '适合联系时段', '6', '18:00~20:00', '2018-06-01 15:34:25', '2018-06-01 15:34:27');
INSERT INTO `dictionary` VALUES ('47', '1', '6', '适合联系时段', '7', '20:00以后', '2018-06-01 15:35:06', '2018-06-01 15:35:08');
INSERT INTO `dictionary` VALUES ('48', '1', '7', '新车用途', '1', '自用', '2018-06-01 15:36:08', '2018-06-01 15:36:09');
INSERT INTO `dictionary` VALUES ('49', '1', '7', '新车用途', '2', '公司配车', '2018-06-01 15:36:35', '2018-06-01 15:36:37');
INSERT INTO `dictionary` VALUES ('50', '1', '7', '新车用途', '3', '公司用车', '2018-06-01 15:37:07', '2018-06-01 15:37:09');
INSERT INTO `dictionary` VALUES ('51', '1', '7', '新车用途', '4', '奖励员工', '2018-06-01 15:37:46', '2018-06-01 15:37:48');
INSERT INTO `dictionary` VALUES ('52', '1', '7', '新车用途', '5', '代购', '2018-06-01 15:38:12', '2018-06-01 15:38:15');
INSERT INTO `dictionary` VALUES ('53', '1', '7', '新车用途', '6', '运营用车', '2018-06-01 15:38:40', '2018-06-01 15:38:42');
INSERT INTO `dictionary` VALUES ('54', '1', '7', '新车用途', '7', '其他', '2018-06-01 15:39:00', '2018-06-01 15:39:02');
INSERT INTO `dictionary` VALUES ('55', '1', '8', '用车人', '1', '父母', '2018-06-01 15:52:23', '2018-06-01 15:52:23');
INSERT INTO `dictionary` VALUES ('56', '1', '8', '用车人', '2', '配偶', '2018-06-01 15:52:23', '2018-06-01 15:52:23');
INSERT INTO `dictionary` VALUES ('57', '1', '8', '用车人', '3', '子女', '2018-06-01 15:52:23', '2018-06-01 15:52:23');
INSERT INTO `dictionary` VALUES ('58', '1', '8', '用车人', '4', '亲友', '2018-06-01 15:52:23', '2018-06-01 15:52:23');
INSERT INTO `dictionary` VALUES ('59', '1', '8', '用车人', '5', '同事', '2018-06-01 15:52:23', '2018-06-01 15:52:23');
INSERT INTO `dictionary` VALUES ('60', '1', '8', '用车人', '6', '其他', '2018-06-01 15:52:23', '2018-06-01 15:52:23');
INSERT INTO `dictionary` VALUES ('61', '1', '9', '关注点', '1', '舒适性', '2018-06-01 15:57:00', '2018-06-01 15:57:00');
INSERT INTO `dictionary` VALUES ('62', '1', '9', '关注点', '2', '安全性', '2018-06-01 15:57:00', '2018-06-01 15:57:00');
INSERT INTO `dictionary` VALUES ('63', '1', '9', '关注点', '3', '动力性', '2018-06-01 15:57:00', '2018-06-01 15:57:00');
INSERT INTO `dictionary` VALUES ('64', '1', '9', '关注点', '4', '科技感', '2018-06-01 15:57:00', '2018-06-01 15:57:00');
INSERT INTO `dictionary` VALUES ('65', '1', '9', '关注点', '5', '外型', '2018-06-01 15:57:00', '2018-06-01 15:57:00');
INSERT INTO `dictionary` VALUES ('66', '1', '9', '关注点', '6', '内饰', '2018-06-01 15:57:00', '2018-06-01 15:57:00');
INSERT INTO `dictionary` VALUES ('67', '1', '9', '关注点', '7', '空间', '2018-06-01 15:57:00', '2018-06-01 15:57:00');
INSERT INTO `dictionary` VALUES ('68', '1', '9', '关注点', '8', '配置', '2018-06-01 15:57:00', '2018-06-01 15:57:00');
INSERT INTO `dictionary` VALUES ('69', '1', '9', '关注点', '9', '品牌', '2018-06-01 15:57:00', '2018-06-01 15:57:00');
INSERT INTO `dictionary` VALUES ('70', '1', '9', '关注点', '10', '价格', '2018-06-01 15:57:00', '2018-06-01 15:57:00');
INSERT INTO `dictionary` VALUES ('71', '1', '9', '关注点', '11', '油耗', '2018-06-01 15:57:00', '2018-06-01 15:57:00');
INSERT INTO `dictionary` VALUES ('72', '1', '9', '关注点', '12', '经济性', '2018-06-01 15:57:01', '2018-06-01 15:57:01');
INSERT INTO `dictionary` VALUES ('73', '1', '9', '关注点', '13', '售后服务', '2018-06-01 15:57:01', '2018-06-01 15:57:01');
INSERT INTO `dictionary` VALUES ('74', '1', '9', '关注点', '14', '促销方式', '2018-06-01 15:57:01', '2018-06-01 15:57:01');
INSERT INTO `dictionary` VALUES ('75', '1', '9', '关注点', '15', '口碑', '2018-06-01 15:57:01', '2018-06-01 15:57:01');

-- ----------------------------
-- Table structure for distributor
-- ----------------------------

CREATE TABLE `distributor` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '经销商名称',
  `logo_icon` varchar(100) DEFAULT NULL COMMENT 'logo图标',
  `addresss` varchar(100) DEFAULT NULL COMMENT '地址',
  `telephone` varchar(50) DEFAULT NULL COMMENT '电话',
  `appid` varchar(70) DEFAULT '' COMMENT '微信公众号appid',
  `appsecret` varchar(70) DEFAULT NULL COMMENT '微信公众号密钥',
  `encrypt_strings` varchar(50) DEFAULT NULL COMMENT '加密字符串',
  `switch_flag` int(11) DEFAULT '1' COMMENT '积分商城开关1开2关',
  `data_status` tinyint(4) DEFAULT '1' COMMENT '数据状态 0:已删除  1:正常',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='集团信息';

-- ----------------------------
-- Records of distributor
-- ----------------------------
INSERT INTO `distributor` VALUES ('1', '百事佳集团', '555d55d.jpg', '上海市杨浦区', '13521121121', '', null, null, '1', '1', '2018-06-01 00:00:00', '2018-06-01 00:00:00');

-- ----------------------------
-- Table structure for distributor_store_info
-- ----------------------------

CREATE TABLE `distributor_store_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `distributor_id` int(10) DEFAULT NULL COMMENT '集团id',
  `name` varchar(100) NOT NULL COMMENT '门店名称',
  `code` varchar(50) NOT NULL COMMENT '经销商code',
  `picture_url` varchar(100) DEFAULT NULL COMMENT '门店图片',
  `abbreviation` varchar(50) DEFAULT NULL COMMENT '门店简称',
  `province` varchar(20) NOT NULL COMMENT '门店省份',
  `province_id` int(11) NOT NULL COMMENT '省份id',
  `city` varchar(20) NOT NULL COMMENT '门店城市',
  `city_id` int(11) NOT NULL COMMENT '城市id',
  `street` varchar(200) NOT NULL COMMENT '门店街道地址',
  `longitude` varchar(20) NOT NULL COMMENT '经度',
  `latitude` varchar(20) NOT NULL COMMENT '纬度',
  `landline` varchar(20) DEFAULT NULL COMMENT '门店号码',
  `iphone` varchar(11) DEFAULT NULL COMMENT '门店手机号码(暂时废置)',
  `summary` varchar(150) DEFAULT NULL COMMENT '门店简介',
  `service` varchar(150) DEFAULT NULL COMMENT '特殊服务',
  `business_start_date` varchar(20) DEFAULT NULL COMMENT '营业开始时间',
  `business_stop_date` varchar(20) DEFAULT NULL COMMENT '营业结束时间',
  `shopowner` int(10) DEFAULT NULL COMMENT '门店店长',
  `store_status` tinyint(4) DEFAULT '1' COMMENT '门店状态  1:上架  2:下架',
  `data_status` tinyint(4) DEFAULT '1' COMMENT '数据状态 0:已删除  1:正常',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门店信息';

-- ----------------------------
-- Records of distributor_store_info
-- ----------------------------

-- ----------------------------
-- Table structure for district
-- ----------------------------

CREATE TABLE `district` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `district_name` varchar(255) DEFAULT NULL COMMENT '全称',
  `city_id` int(11) DEFAULT NULL COMMENT '所属城市id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of district
-- ----------------------------
INSERT INTO `district` VALUES ('1', '长安区', '3');
INSERT INTO `district` VALUES ('2', '桥西区', '3');
INSERT INTO `district` VALUES ('3', '新华区', '3');
INSERT INTO `district` VALUES ('4', '井陉矿区', '3');
INSERT INTO `district` VALUES ('5', '裕华区', '3');
INSERT INTO `district` VALUES ('6', '藁城区', '3');
INSERT INTO `district` VALUES ('7', '鹿泉区', '3');
INSERT INTO `district` VALUES ('8', '栾城区', '3');
INSERT INTO `district` VALUES ('9', '井陉县', '3');
INSERT INTO `district` VALUES ('10', '正定县', '3');
INSERT INTO `district` VALUES ('11', '行唐县', '3');
INSERT INTO `district` VALUES ('12', '灵寿县', '3');
INSERT INTO `district` VALUES ('13', '高邑县', '3');
INSERT INTO `district` VALUES ('14', '深泽县', '3');
INSERT INTO `district` VALUES ('15', '赞皇县', '3');
INSERT INTO `district` VALUES ('16', '无极县', '3');
INSERT INTO `district` VALUES ('17', '平山县', '3');
INSERT INTO `district` VALUES ('18', '元氏县', '3');
INSERT INTO `district` VALUES ('19', '赵县', '3');
INSERT INTO `district` VALUES ('20', '晋州市', '3');
INSERT INTO `district` VALUES ('21', '新乐市', '3');
INSERT INTO `district` VALUES ('22', '路南区', '4');
INSERT INTO `district` VALUES ('23', '路北区', '4');
INSERT INTO `district` VALUES ('24', '古冶区', '4');
INSERT INTO `district` VALUES ('25', '开平区', '4');
INSERT INTO `district` VALUES ('26', '丰南区', '4');
INSERT INTO `district` VALUES ('27', '丰润区', '4');
INSERT INTO `district` VALUES ('28', '曹妃甸区', '4');
INSERT INTO `district` VALUES ('29', '滦县', '4');
INSERT INTO `district` VALUES ('30', '滦南县', '4');
INSERT INTO `district` VALUES ('31', '乐亭县', '4');
INSERT INTO `district` VALUES ('32', '迁西县', '4');
INSERT INTO `district` VALUES ('33', '玉田县', '4');
INSERT INTO `district` VALUES ('34', '遵化市', '4');
INSERT INTO `district` VALUES ('35', '迁安市', '4');
INSERT INTO `district` VALUES ('36', '海港区', '5');
INSERT INTO `district` VALUES ('37', '山海关区', '5');
INSERT INTO `district` VALUES ('38', '北戴河区', '5');
INSERT INTO `district` VALUES ('39', '抚宁区', '5');
INSERT INTO `district` VALUES ('40', '青龙满族自治县', '5');
INSERT INTO `district` VALUES ('41', '昌黎县', '5');
INSERT INTO `district` VALUES ('42', '卢龙县', '5');
INSERT INTO `district` VALUES ('43', '邯山区', '6');
INSERT INTO `district` VALUES ('44', '丛台区', '6');
INSERT INTO `district` VALUES ('45', '复兴区', '6');
INSERT INTO `district` VALUES ('46', '峰峰矿区', '6');
INSERT INTO `district` VALUES ('47', '肥乡区', '6');
INSERT INTO `district` VALUES ('48', '永年区', '6');
INSERT INTO `district` VALUES ('49', '临漳县', '6');
INSERT INTO `district` VALUES ('50', '成安县', '6');
INSERT INTO `district` VALUES ('51', '大名县', '6');
INSERT INTO `district` VALUES ('52', '涉县', '6');
INSERT INTO `district` VALUES ('53', '磁县', '6');
INSERT INTO `district` VALUES ('54', '邱县', '6');
INSERT INTO `district` VALUES ('55', '鸡泽县', '6');
INSERT INTO `district` VALUES ('56', '广平县', '6');
INSERT INTO `district` VALUES ('57', '馆陶县', '6');
INSERT INTO `district` VALUES ('58', '魏县', '6');
INSERT INTO `district` VALUES ('59', '曲周县', '6');
INSERT INTO `district` VALUES ('60', '武安市', '6');
INSERT INTO `district` VALUES ('61', '桥东区', '7');
INSERT INTO `district` VALUES ('62', '桥西区', '7');
INSERT INTO `district` VALUES ('63', '邢台县', '7');
INSERT INTO `district` VALUES ('64', '临城县', '7');
INSERT INTO `district` VALUES ('65', '内丘县', '7');
INSERT INTO `district` VALUES ('66', '柏乡县', '7');
INSERT INTO `district` VALUES ('67', '隆尧县', '7');
INSERT INTO `district` VALUES ('68', '任县', '7');
INSERT INTO `district` VALUES ('69', '南和县', '7');
INSERT INTO `district` VALUES ('70', '宁晋县', '7');
INSERT INTO `district` VALUES ('71', '巨鹿县', '7');
INSERT INTO `district` VALUES ('72', '新河县', '7');
INSERT INTO `district` VALUES ('73', '广宗县', '7');
INSERT INTO `district` VALUES ('74', '平乡县', '7');
INSERT INTO `district` VALUES ('75', '威县', '7');
INSERT INTO `district` VALUES ('76', '清河县', '7');
INSERT INTO `district` VALUES ('77', '临西县', '7');
INSERT INTO `district` VALUES ('78', '南宫市', '7');
INSERT INTO `district` VALUES ('79', '沙河市', '7');
INSERT INTO `district` VALUES ('80', '竞秀区', '8');
INSERT INTO `district` VALUES ('81', '莲池区', '8');
INSERT INTO `district` VALUES ('82', '满城区', '8');
INSERT INTO `district` VALUES ('83', '清苑区', '8');
INSERT INTO `district` VALUES ('84', '徐水区', '8');
INSERT INTO `district` VALUES ('85', '涞水县', '8');
INSERT INTO `district` VALUES ('86', '阜平县', '8');
INSERT INTO `district` VALUES ('87', '定兴县', '8');
INSERT INTO `district` VALUES ('88', '唐县', '8');
INSERT INTO `district` VALUES ('89', '高阳县', '8');
INSERT INTO `district` VALUES ('90', '容城县', '8');
INSERT INTO `district` VALUES ('91', '涞源县', '8');
INSERT INTO `district` VALUES ('92', '望都县', '8');
INSERT INTO `district` VALUES ('93', '安新县', '8');
INSERT INTO `district` VALUES ('94', '易县', '8');
INSERT INTO `district` VALUES ('95', '曲阳县', '8');
INSERT INTO `district` VALUES ('96', '蠡县', '8');
INSERT INTO `district` VALUES ('97', '顺平县', '8');
INSERT INTO `district` VALUES ('98', '博野县', '8');
INSERT INTO `district` VALUES ('99', '雄县', '8');
INSERT INTO `district` VALUES ('100', '涿州市', '8');
INSERT INTO `district` VALUES ('101', '安国市', '8');
INSERT INTO `district` VALUES ('102', '高碑店市', '8');
INSERT INTO `district` VALUES ('103', '桥东区', '9');
INSERT INTO `district` VALUES ('104', '桥西区', '9');
INSERT INTO `district` VALUES ('105', '宣化区', '9');
INSERT INTO `district` VALUES ('106', '下花园区', '9');
INSERT INTO `district` VALUES ('107', '万全区', '9');
INSERT INTO `district` VALUES ('108', '崇礼区', '9');
INSERT INTO `district` VALUES ('109', '张北县', '9');
INSERT INTO `district` VALUES ('110', '康保县', '9');
INSERT INTO `district` VALUES ('111', '沽源县', '9');
INSERT INTO `district` VALUES ('112', '尚义县', '9');
INSERT INTO `district` VALUES ('113', '蔚县', '9');
INSERT INTO `district` VALUES ('114', '阳原县', '9');
INSERT INTO `district` VALUES ('115', '怀安县', '9');
INSERT INTO `district` VALUES ('116', '怀来县', '9');
INSERT INTO `district` VALUES ('117', '涿鹿县', '9');
INSERT INTO `district` VALUES ('118', '赤城县', '9');
INSERT INTO `district` VALUES ('119', '双桥区', '10');
INSERT INTO `district` VALUES ('120', '双滦区', '10');
INSERT INTO `district` VALUES ('121', '鹰手营子矿区', '10');
INSERT INTO `district` VALUES ('122', '承德县', '10');
INSERT INTO `district` VALUES ('123', '兴隆县', '10');
INSERT INTO `district` VALUES ('124', '滦平县', '10');
INSERT INTO `district` VALUES ('125', '隆化县', '10');
INSERT INTO `district` VALUES ('126', '丰宁满族自治县', '10');
INSERT INTO `district` VALUES ('127', '宽城满族自治县', '10');
INSERT INTO `district` VALUES ('128', '围场满族蒙古族自治县', '10');
INSERT INTO `district` VALUES ('129', '平泉市', '10');
INSERT INTO `district` VALUES ('130', '新华区', '11');
INSERT INTO `district` VALUES ('131', '运河区', '11');
INSERT INTO `district` VALUES ('132', '沧县', '11');
INSERT INTO `district` VALUES ('133', '青县', '11');
INSERT INTO `district` VALUES ('134', '东光县', '11');
INSERT INTO `district` VALUES ('135', '海兴县', '11');
INSERT INTO `district` VALUES ('136', '盐山县', '11');
INSERT INTO `district` VALUES ('137', '肃宁县', '11');
INSERT INTO `district` VALUES ('138', '南皮县', '11');
INSERT INTO `district` VALUES ('139', '吴桥县', '11');
INSERT INTO `district` VALUES ('140', '献县', '11');
INSERT INTO `district` VALUES ('141', '孟村回族自治县', '11');
INSERT INTO `district` VALUES ('142', '泊头市', '11');
INSERT INTO `district` VALUES ('143', '任丘市', '11');
INSERT INTO `district` VALUES ('144', '黄骅市', '11');
INSERT INTO `district` VALUES ('145', '河间市', '11');
INSERT INTO `district` VALUES ('146', '安次区', '12');
INSERT INTO `district` VALUES ('147', '广阳区', '12');
INSERT INTO `district` VALUES ('148', '固安县', '12');
INSERT INTO `district` VALUES ('149', '永清县', '12');
INSERT INTO `district` VALUES ('150', '香河县', '12');
INSERT INTO `district` VALUES ('151', '大城县', '12');
INSERT INTO `district` VALUES ('152', '文安县', '12');
INSERT INTO `district` VALUES ('153', '大厂回族自治县', '12');
INSERT INTO `district` VALUES ('154', '霸州市', '12');
INSERT INTO `district` VALUES ('155', '三河市', '12');
INSERT INTO `district` VALUES ('156', '桃城区', '13');
INSERT INTO `district` VALUES ('157', '冀州区', '13');
INSERT INTO `district` VALUES ('158', '枣强县', '13');
INSERT INTO `district` VALUES ('159', '武邑县', '13');
INSERT INTO `district` VALUES ('160', '武强县', '13');
INSERT INTO `district` VALUES ('161', '饶阳县', '13');
INSERT INTO `district` VALUES ('162', '安平县', '13');
INSERT INTO `district` VALUES ('163', '故城县', '13');
INSERT INTO `district` VALUES ('164', '景县', '13');
INSERT INTO `district` VALUES ('165', '阜城县', '13');
INSERT INTO `district` VALUES ('166', '深州市', '13');
INSERT INTO `district` VALUES ('167', '小店区', '16');
INSERT INTO `district` VALUES ('168', '迎泽区', '16');
INSERT INTO `district` VALUES ('169', '杏花岭区', '16');
INSERT INTO `district` VALUES ('170', '尖草坪区', '16');
INSERT INTO `district` VALUES ('171', '万柏林区', '16');
INSERT INTO `district` VALUES ('172', '晋源区', '16');
INSERT INTO `district` VALUES ('173', '清徐县', '16');
INSERT INTO `district` VALUES ('174', '阳曲县', '16');
INSERT INTO `district` VALUES ('175', '娄烦县', '16');
INSERT INTO `district` VALUES ('176', '古交市', '16');
INSERT INTO `district` VALUES ('177', '城区', '17');
INSERT INTO `district` VALUES ('178', '矿区', '17');
INSERT INTO `district` VALUES ('179', '南郊区', '17');
INSERT INTO `district` VALUES ('180', '新荣区', '17');
INSERT INTO `district` VALUES ('181', '阳高县', '17');
INSERT INTO `district` VALUES ('182', '天镇县', '17');
INSERT INTO `district` VALUES ('183', '广灵县', '17');
INSERT INTO `district` VALUES ('184', '灵丘县', '17');
INSERT INTO `district` VALUES ('185', '浑源县', '17');
INSERT INTO `district` VALUES ('186', '左云县', '17');
INSERT INTO `district` VALUES ('187', '大同县', '17');
INSERT INTO `district` VALUES ('188', '城区', '18');
INSERT INTO `district` VALUES ('189', '矿区', '18');
INSERT INTO `district` VALUES ('190', '郊区', '18');
INSERT INTO `district` VALUES ('191', '平定县', '18');
INSERT INTO `district` VALUES ('192', '盂县', '18');
INSERT INTO `district` VALUES ('193', '城区', '19');
INSERT INTO `district` VALUES ('194', '郊区', '19');
INSERT INTO `district` VALUES ('195', '长治县', '19');
INSERT INTO `district` VALUES ('196', '襄垣县', '19');
INSERT INTO `district` VALUES ('197', '屯留县', '19');
INSERT INTO `district` VALUES ('198', '平顺县', '19');
INSERT INTO `district` VALUES ('199', '黎城县', '19');
INSERT INTO `district` VALUES ('200', '壶关县', '19');
INSERT INTO `district` VALUES ('201', '长子县', '19');
INSERT INTO `district` VALUES ('202', '武乡县', '19');
INSERT INTO `district` VALUES ('203', '沁县', '19');
INSERT INTO `district` VALUES ('204', '沁源县', '19');
INSERT INTO `district` VALUES ('205', '潞城市', '19');
INSERT INTO `district` VALUES ('206', '城区', '20');
INSERT INTO `district` VALUES ('207', '沁水县', '20');
INSERT INTO `district` VALUES ('208', '阳城县', '20');
INSERT INTO `district` VALUES ('209', '陵川县', '20');
INSERT INTO `district` VALUES ('210', '泽州县', '20');
INSERT INTO `district` VALUES ('211', '高平市', '20');
INSERT INTO `district` VALUES ('212', '朔城区', '21');
INSERT INTO `district` VALUES ('213', '平鲁区', '21');
INSERT INTO `district` VALUES ('214', '山阴县', '21');
INSERT INTO `district` VALUES ('215', '应县', '21');
INSERT INTO `district` VALUES ('216', '右玉县', '21');
INSERT INTO `district` VALUES ('217', '怀仁县', '21');
INSERT INTO `district` VALUES ('218', '榆次区', '22');
INSERT INTO `district` VALUES ('219', '榆社县', '22');
INSERT INTO `district` VALUES ('220', '左权县', '22');
INSERT INTO `district` VALUES ('221', '和顺县', '22');
INSERT INTO `district` VALUES ('222', '昔阳县', '22');
INSERT INTO `district` VALUES ('223', '寿阳县', '22');
INSERT INTO `district` VALUES ('224', '太谷县', '22');
INSERT INTO `district` VALUES ('225', '祁县', '22');
INSERT INTO `district` VALUES ('226', '平遥县', '22');
INSERT INTO `district` VALUES ('227', '灵石县', '22');
INSERT INTO `district` VALUES ('228', '介休市', '22');
INSERT INTO `district` VALUES ('229', '盐湖区', '23');
INSERT INTO `district` VALUES ('230', '临猗县', '23');
INSERT INTO `district` VALUES ('231', '万荣县', '23');
INSERT INTO `district` VALUES ('232', '闻喜县', '23');
INSERT INTO `district` VALUES ('233', '稷山县', '23');
INSERT INTO `district` VALUES ('234', '新绛县', '23');
INSERT INTO `district` VALUES ('235', '绛县', '23');
INSERT INTO `district` VALUES ('236', '垣曲县', '23');
INSERT INTO `district` VALUES ('237', '夏县', '23');
INSERT INTO `district` VALUES ('238', '平陆县', '23');
INSERT INTO `district` VALUES ('239', '芮城县', '23');
INSERT INTO `district` VALUES ('240', '永济市', '23');
INSERT INTO `district` VALUES ('241', '河津市', '23');
INSERT INTO `district` VALUES ('242', '忻府区', '24');
INSERT INTO `district` VALUES ('243', '定襄县', '24');
INSERT INTO `district` VALUES ('244', '五台县', '24');
INSERT INTO `district` VALUES ('245', '代县', '24');
INSERT INTO `district` VALUES ('246', '繁峙县', '24');
INSERT INTO `district` VALUES ('247', '宁武县', '24');
INSERT INTO `district` VALUES ('248', '静乐县', '24');
INSERT INTO `district` VALUES ('249', '神池县', '24');
INSERT INTO `district` VALUES ('250', '五寨县', '24');
INSERT INTO `district` VALUES ('251', '岢岚县', '24');
INSERT INTO `district` VALUES ('252', '河曲县', '24');
INSERT INTO `district` VALUES ('253', '保德县', '24');
INSERT INTO `district` VALUES ('254', '偏关县', '24');
INSERT INTO `district` VALUES ('255', '原平市', '24');
INSERT INTO `district` VALUES ('256', '尧都区', '25');
INSERT INTO `district` VALUES ('257', '曲沃县', '25');
INSERT INTO `district` VALUES ('258', '翼城县', '25');
INSERT INTO `district` VALUES ('259', '襄汾县', '25');
INSERT INTO `district` VALUES ('260', '洪洞县', '25');
INSERT INTO `district` VALUES ('261', '古县', '25');
INSERT INTO `district` VALUES ('262', '安泽县', '25');
INSERT INTO `district` VALUES ('263', '浮山县', '25');
INSERT INTO `district` VALUES ('264', '吉县', '25');
INSERT INTO `district` VALUES ('265', '乡宁县', '25');
INSERT INTO `district` VALUES ('266', '大宁县', '25');
INSERT INTO `district` VALUES ('267', '隰县', '25');
INSERT INTO `district` VALUES ('268', '永和县', '25');
INSERT INTO `district` VALUES ('269', '蒲县', '25');
INSERT INTO `district` VALUES ('270', '汾西县', '25');
INSERT INTO `district` VALUES ('271', '侯马市', '25');
INSERT INTO `district` VALUES ('272', '霍州市', '25');
INSERT INTO `district` VALUES ('273', '离石区', '26');
INSERT INTO `district` VALUES ('274', '文水县', '26');
INSERT INTO `district` VALUES ('275', '交城县', '26');
INSERT INTO `district` VALUES ('276', '兴县', '26');
INSERT INTO `district` VALUES ('277', '临县', '26');
INSERT INTO `district` VALUES ('278', '柳林县', '26');
INSERT INTO `district` VALUES ('279', '石楼县', '26');
INSERT INTO `district` VALUES ('280', '岚县', '26');
INSERT INTO `district` VALUES ('281', '方山县', '26');
INSERT INTO `district` VALUES ('282', '中阳县', '26');
INSERT INTO `district` VALUES ('283', '交口县', '26');
INSERT INTO `district` VALUES ('284', '孝义市', '26');
INSERT INTO `district` VALUES ('285', '汾阳市', '26');
INSERT INTO `district` VALUES ('286', '新城区', '27');
INSERT INTO `district` VALUES ('287', '回民区', '27');
INSERT INTO `district` VALUES ('288', '玉泉区', '27');
INSERT INTO `district` VALUES ('289', '赛罕区', '27');
INSERT INTO `district` VALUES ('290', '土默特左旗', '27');
INSERT INTO `district` VALUES ('291', '托克托县', '27');
INSERT INTO `district` VALUES ('292', '和林格尔县', '27');
INSERT INTO `district` VALUES ('293', '清水河县', '27');
INSERT INTO `district` VALUES ('294', '武川县', '27');
INSERT INTO `district` VALUES ('295', '东河区', '28');
INSERT INTO `district` VALUES ('296', '昆都仑区', '28');
INSERT INTO `district` VALUES ('297', '青山区', '28');
INSERT INTO `district` VALUES ('298', '石拐区', '28');
INSERT INTO `district` VALUES ('299', '白云鄂博矿区', '28');
INSERT INTO `district` VALUES ('300', '九原区', '28');
INSERT INTO `district` VALUES ('301', '土默特右旗', '28');
INSERT INTO `district` VALUES ('302', '固阳县', '28');
INSERT INTO `district` VALUES ('303', '达尔罕茂明安联合旗', '28');
INSERT INTO `district` VALUES ('304', '海勃湾区', '29');
INSERT INTO `district` VALUES ('305', '海南区', '29');
INSERT INTO `district` VALUES ('306', '乌达区', '29');
INSERT INTO `district` VALUES ('307', '红山区', '30');
INSERT INTO `district` VALUES ('308', '元宝山区', '30');
INSERT INTO `district` VALUES ('309', '松山区', '30');
INSERT INTO `district` VALUES ('310', '阿鲁科尔沁旗', '30');
INSERT INTO `district` VALUES ('311', '巴林左旗', '30');
INSERT INTO `district` VALUES ('312', '巴林右旗', '30');
INSERT INTO `district` VALUES ('313', '林西县', '30');
INSERT INTO `district` VALUES ('314', '克什克腾旗', '30');
INSERT INTO `district` VALUES ('315', '翁牛特旗', '30');
INSERT INTO `district` VALUES ('316', '喀喇沁旗', '30');
INSERT INTO `district` VALUES ('317', '宁城县', '30');
INSERT INTO `district` VALUES ('318', '敖汉旗', '30');
INSERT INTO `district` VALUES ('319', '科尔沁区', '31');
INSERT INTO `district` VALUES ('320', '科尔沁左翼中旗', '31');
INSERT INTO `district` VALUES ('321', '科尔沁左翼后旗', '31');
INSERT INTO `district` VALUES ('322', '开鲁县', '31');
INSERT INTO `district` VALUES ('323', '库伦旗', '31');
INSERT INTO `district` VALUES ('324', '奈曼旗', '31');
INSERT INTO `district` VALUES ('325', '扎鲁特旗', '31');
INSERT INTO `district` VALUES ('326', '霍林郭勒市', '31');
INSERT INTO `district` VALUES ('327', '东胜区', '32');
INSERT INTO `district` VALUES ('328', '康巴什区', '32');
INSERT INTO `district` VALUES ('329', '达拉特旗', '32');
INSERT INTO `district` VALUES ('330', '准格尔旗', '32');
INSERT INTO `district` VALUES ('331', '鄂托克前旗', '32');
INSERT INTO `district` VALUES ('332', '鄂托克旗', '32');
INSERT INTO `district` VALUES ('333', '杭锦旗', '32');
INSERT INTO `district` VALUES ('334', '乌审旗', '32');
INSERT INTO `district` VALUES ('335', '伊金霍洛旗', '32');
INSERT INTO `district` VALUES ('336', '海拉尔区', '33');
INSERT INTO `district` VALUES ('337', '扎赉诺尔区', '33');
INSERT INTO `district` VALUES ('338', '阿荣旗', '33');
INSERT INTO `district` VALUES ('339', '莫力达瓦达斡尔族自治旗', '33');
INSERT INTO `district` VALUES ('340', '鄂伦春自治旗', '33');
INSERT INTO `district` VALUES ('341', '鄂温克族自治旗', '33');
INSERT INTO `district` VALUES ('342', '陈巴尔虎旗', '33');
INSERT INTO `district` VALUES ('343', '新巴尔虎左旗', '33');
INSERT INTO `district` VALUES ('344', '新巴尔虎右旗', '33');
INSERT INTO `district` VALUES ('345', '满洲里市', '33');
INSERT INTO `district` VALUES ('346', '牙克石市', '33');
INSERT INTO `district` VALUES ('347', '扎兰屯市', '33');
INSERT INTO `district` VALUES ('348', '额尔古纳市', '33');
INSERT INTO `district` VALUES ('349', '根河市', '33');
INSERT INTO `district` VALUES ('350', '临河区', '34');
INSERT INTO `district` VALUES ('351', '五原县', '34');
INSERT INTO `district` VALUES ('352', '磴口县', '34');
INSERT INTO `district` VALUES ('353', '乌拉特前旗', '34');
INSERT INTO `district` VALUES ('354', '乌拉特中旗', '34');
INSERT INTO `district` VALUES ('355', '乌拉特后旗', '34');
INSERT INTO `district` VALUES ('356', '杭锦后旗', '34');
INSERT INTO `district` VALUES ('357', '集宁区', '35');
INSERT INTO `district` VALUES ('358', '卓资县', '35');
INSERT INTO `district` VALUES ('359', '化德县', '35');
INSERT INTO `district` VALUES ('360', '商都县', '35');
INSERT INTO `district` VALUES ('361', '兴和县', '35');
INSERT INTO `district` VALUES ('362', '凉城县', '35');
INSERT INTO `district` VALUES ('363', '察哈尔右翼前旗', '35');
INSERT INTO `district` VALUES ('364', '察哈尔右翼中旗', '35');
INSERT INTO `district` VALUES ('365', '察哈尔右翼后旗', '35');
INSERT INTO `district` VALUES ('366', '四子王旗', '35');
INSERT INTO `district` VALUES ('367', '丰镇市', '35');
INSERT INTO `district` VALUES ('368', '乌兰浩特市', '36');
INSERT INTO `district` VALUES ('369', '阿尔山市', '36');
INSERT INTO `district` VALUES ('370', '科尔沁右翼前旗', '36');
INSERT INTO `district` VALUES ('371', '科尔沁右翼中旗', '36');
INSERT INTO `district` VALUES ('372', '扎赉特旗', '36');
INSERT INTO `district` VALUES ('373', '突泉县', '36');
INSERT INTO `district` VALUES ('374', '二连浩特市', '37');
INSERT INTO `district` VALUES ('375', '锡林浩特市', '37');
INSERT INTO `district` VALUES ('376', '阿巴嘎旗', '37');
INSERT INTO `district` VALUES ('377', '苏尼特左旗', '37');
INSERT INTO `district` VALUES ('378', '苏尼特右旗', '37');
INSERT INTO `district` VALUES ('379', '东乌珠穆沁旗', '37');
INSERT INTO `district` VALUES ('380', '西乌珠穆沁旗', '37');
INSERT INTO `district` VALUES ('381', '太仆寺旗', '37');
INSERT INTO `district` VALUES ('382', '镶黄旗', '37');
INSERT INTO `district` VALUES ('383', '正镶白旗', '37');
INSERT INTO `district` VALUES ('384', '正蓝旗', '37');
INSERT INTO `district` VALUES ('385', '多伦县', '37');
INSERT INTO `district` VALUES ('386', '阿拉善左旗', '38');
INSERT INTO `district` VALUES ('387', '阿拉善右旗', '38');
INSERT INTO `district` VALUES ('388', '额济纳旗', '38');
INSERT INTO `district` VALUES ('389', '和平区', '39');
INSERT INTO `district` VALUES ('390', '沈河区', '39');
INSERT INTO `district` VALUES ('391', '大东区', '39');
INSERT INTO `district` VALUES ('392', '皇姑区', '39');
INSERT INTO `district` VALUES ('393', '铁西区', '39');
INSERT INTO `district` VALUES ('394', '苏家屯区', '39');
INSERT INTO `district` VALUES ('395', '浑南区', '39');
INSERT INTO `district` VALUES ('396', '沈北新区', '39');
INSERT INTO `district` VALUES ('397', '于洪区', '39');
INSERT INTO `district` VALUES ('398', '辽中区', '39');
INSERT INTO `district` VALUES ('399', '康平县', '39');
INSERT INTO `district` VALUES ('400', '法库县', '39');
INSERT INTO `district` VALUES ('401', '新民市', '39');
INSERT INTO `district` VALUES ('402', '中山区', '40');
INSERT INTO `district` VALUES ('403', '西岗区', '40');
INSERT INTO `district` VALUES ('404', '沙河口区', '40');
INSERT INTO `district` VALUES ('405', '甘井子区', '40');
INSERT INTO `district` VALUES ('406', '旅顺口区', '40');
INSERT INTO `district` VALUES ('407', '金州区', '40');
INSERT INTO `district` VALUES ('408', '普兰店区', '40');
INSERT INTO `district` VALUES ('409', '长海县', '40');
INSERT INTO `district` VALUES ('410', '瓦房店市', '40');
INSERT INTO `district` VALUES ('411', '庄河市', '40');
INSERT INTO `district` VALUES ('412', '铁东区', '41');
INSERT INTO `district` VALUES ('413', '铁西区', '41');
INSERT INTO `district` VALUES ('414', '立山区', '41');
INSERT INTO `district` VALUES ('415', '千山区', '41');
INSERT INTO `district` VALUES ('416', '台安县', '41');
INSERT INTO `district` VALUES ('417', '岫岩满族自治县', '41');
INSERT INTO `district` VALUES ('418', '海城市', '41');
INSERT INTO `district` VALUES ('419', '新抚区', '42');
INSERT INTO `district` VALUES ('420', '东洲区', '42');
INSERT INTO `district` VALUES ('421', '望花区', '42');
INSERT INTO `district` VALUES ('422', '顺城区', '42');
INSERT INTO `district` VALUES ('423', '抚顺县', '42');
INSERT INTO `district` VALUES ('424', '新宾满族自治县', '42');
INSERT INTO `district` VALUES ('425', '清原满族自治县', '42');
INSERT INTO `district` VALUES ('426', '平山区', '43');
INSERT INTO `district` VALUES ('427', '溪湖区', '43');
INSERT INTO `district` VALUES ('428', '明山区', '43');
INSERT INTO `district` VALUES ('429', '南芬区', '43');
INSERT INTO `district` VALUES ('430', '本溪满族自治县', '43');
INSERT INTO `district` VALUES ('431', '桓仁满族自治县', '43');
INSERT INTO `district` VALUES ('432', '元宝区', '44');
INSERT INTO `district` VALUES ('433', '振兴区', '44');
INSERT INTO `district` VALUES ('434', '振安区', '44');
INSERT INTO `district` VALUES ('435', '宽甸满族自治县', '44');
INSERT INTO `district` VALUES ('436', '东港市', '44');
INSERT INTO `district` VALUES ('437', '凤城市', '44');
INSERT INTO `district` VALUES ('438', '古塔区', '45');
INSERT INTO `district` VALUES ('439', '凌河区', '45');
INSERT INTO `district` VALUES ('440', '太和区', '45');
INSERT INTO `district` VALUES ('441', '黑山县', '45');
INSERT INTO `district` VALUES ('442', '义县', '45');
INSERT INTO `district` VALUES ('443', '凌海市', '45');
INSERT INTO `district` VALUES ('444', '北镇市', '45');
INSERT INTO `district` VALUES ('445', '站前区', '46');
INSERT INTO `district` VALUES ('446', '西市区', '46');
INSERT INTO `district` VALUES ('447', '鲅鱼圈区', '46');
INSERT INTO `district` VALUES ('448', '老边区', '46');
INSERT INTO `district` VALUES ('449', '盖州市', '46');
INSERT INTO `district` VALUES ('450', '大石桥市', '46');
INSERT INTO `district` VALUES ('451', '海州区', '47');
INSERT INTO `district` VALUES ('452', '新邱区', '47');
INSERT INTO `district` VALUES ('453', '太平区', '47');
INSERT INTO `district` VALUES ('454', '清河门区', '47');
INSERT INTO `district` VALUES ('455', '细河区', '47');
INSERT INTO `district` VALUES ('456', '阜新蒙古族自治县', '47');
INSERT INTO `district` VALUES ('457', '彰武县', '47');
INSERT INTO `district` VALUES ('458', '白塔区', '48');
INSERT INTO `district` VALUES ('459', '文圣区', '48');
INSERT INTO `district` VALUES ('460', '宏伟区', '48');
INSERT INTO `district` VALUES ('461', '弓长岭区', '48');
INSERT INTO `district` VALUES ('462', '太子河区', '48');
INSERT INTO `district` VALUES ('463', '辽阳县', '48');
INSERT INTO `district` VALUES ('464', '灯塔市', '48');
INSERT INTO `district` VALUES ('465', '双台子区', '49');
INSERT INTO `district` VALUES ('466', '兴隆台区', '49');
INSERT INTO `district` VALUES ('467', '大洼区', '49');
INSERT INTO `district` VALUES ('468', '盘山县', '49');
INSERT INTO `district` VALUES ('469', '银州区', '50');
INSERT INTO `district` VALUES ('470', '清河区', '50');
INSERT INTO `district` VALUES ('471', '铁岭县', '50');
INSERT INTO `district` VALUES ('472', '西丰县', '50');
INSERT INTO `district` VALUES ('473', '昌图县', '50');
INSERT INTO `district` VALUES ('474', '调兵山市', '50');
INSERT INTO `district` VALUES ('475', '开原市', '50');
INSERT INTO `district` VALUES ('476', '双塔区', '51');
INSERT INTO `district` VALUES ('477', '龙城区', '51');
INSERT INTO `district` VALUES ('478', '朝阳县', '51');
INSERT INTO `district` VALUES ('479', '建平县', '51');
INSERT INTO `district` VALUES ('480', '喀喇沁左翼蒙古族自治县', '51');
INSERT INTO `district` VALUES ('481', '北票市', '51');
INSERT INTO `district` VALUES ('482', '凌源市', '51');
INSERT INTO `district` VALUES ('483', '连山区', '52');
INSERT INTO `district` VALUES ('484', '龙港区', '52');
INSERT INTO `district` VALUES ('485', '南票区', '52');
INSERT INTO `district` VALUES ('486', '绥中县', '52');
INSERT INTO `district` VALUES ('487', '建昌县', '52');
INSERT INTO `district` VALUES ('488', '兴城市', '52');
INSERT INTO `district` VALUES ('489', '南关区', '53');
INSERT INTO `district` VALUES ('490', '宽城区', '53');
INSERT INTO `district` VALUES ('491', '朝阳区', '53');
INSERT INTO `district` VALUES ('492', '二道区', '53');
INSERT INTO `district` VALUES ('493', '绿园区', '53');
INSERT INTO `district` VALUES ('494', '双阳区', '53');
INSERT INTO `district` VALUES ('495', '九台区', '53');
INSERT INTO `district` VALUES ('496', '农安县', '53');
INSERT INTO `district` VALUES ('497', '榆树市', '53');
INSERT INTO `district` VALUES ('498', '德惠市', '53');
INSERT INTO `district` VALUES ('499', '昌邑区', '54');
INSERT INTO `district` VALUES ('500', '龙潭区', '54');
INSERT INTO `district` VALUES ('501', '船营区', '54');
INSERT INTO `district` VALUES ('502', '丰满区', '54');
INSERT INTO `district` VALUES ('503', '永吉县', '54');
INSERT INTO `district` VALUES ('504', '蛟河市', '54');
INSERT INTO `district` VALUES ('505', '桦甸市', '54');
INSERT INTO `district` VALUES ('506', '舒兰市', '54');
INSERT INTO `district` VALUES ('507', '磐石市', '54');
INSERT INTO `district` VALUES ('508', '铁西区', '55');
INSERT INTO `district` VALUES ('509', '铁东区', '55');
INSERT INTO `district` VALUES ('510', '梨树县', '55');
INSERT INTO `district` VALUES ('511', '伊通满族自治县', '55');
INSERT INTO `district` VALUES ('512', '公主岭市', '55');
INSERT INTO `district` VALUES ('513', '双辽市', '55');
INSERT INTO `district` VALUES ('514', '龙山区', '56');
INSERT INTO `district` VALUES ('515', '西安区', '56');
INSERT INTO `district` VALUES ('516', '东丰县', '56');
INSERT INTO `district` VALUES ('517', '东辽县', '56');
INSERT INTO `district` VALUES ('518', '东昌区', '57');
INSERT INTO `district` VALUES ('519', '二道江区', '57');
INSERT INTO `district` VALUES ('520', '通化县', '57');
INSERT INTO `district` VALUES ('521', '辉南县', '57');
INSERT INTO `district` VALUES ('522', '柳河县', '57');
INSERT INTO `district` VALUES ('523', '梅河口市', '57');
INSERT INTO `district` VALUES ('524', '集安市', '57');
INSERT INTO `district` VALUES ('525', '浑江区', '58');
INSERT INTO `district` VALUES ('526', '江源区', '58');
INSERT INTO `district` VALUES ('527', '抚松县', '58');
INSERT INTO `district` VALUES ('528', '靖宇县', '58');
INSERT INTO `district` VALUES ('529', '长白朝鲜族自治县', '58');
INSERT INTO `district` VALUES ('530', '临江市', '58');
INSERT INTO `district` VALUES ('531', '宁江区', '59');
INSERT INTO `district` VALUES ('532', '前郭尔罗斯蒙古族自治县', '59');
INSERT INTO `district` VALUES ('533', '长岭县', '59');
INSERT INTO `district` VALUES ('534', '乾安县', '59');
INSERT INTO `district` VALUES ('535', '扶余市', '59');
INSERT INTO `district` VALUES ('536', '洮北区', '60');
INSERT INTO `district` VALUES ('537', '镇赉县', '60');
INSERT INTO `district` VALUES ('538', '通榆县', '60');
INSERT INTO `district` VALUES ('539', '洮南市', '60');
INSERT INTO `district` VALUES ('540', '大安市', '60');
INSERT INTO `district` VALUES ('541', '延吉市', '61');
INSERT INTO `district` VALUES ('542', '图们市', '61');
INSERT INTO `district` VALUES ('543', '敦化市', '61');
INSERT INTO `district` VALUES ('544', '珲春市', '61');
INSERT INTO `district` VALUES ('545', '龙井市', '61');
INSERT INTO `district` VALUES ('546', '和龙市', '61');
INSERT INTO `district` VALUES ('547', '汪清县', '61');
INSERT INTO `district` VALUES ('548', '安图县', '61');
INSERT INTO `district` VALUES ('549', '道里区', '62');
INSERT INTO `district` VALUES ('550', '南岗区', '62');
INSERT INTO `district` VALUES ('551', '道外区', '62');
INSERT INTO `district` VALUES ('552', '平房区', '62');
INSERT INTO `district` VALUES ('553', '松北区', '62');
INSERT INTO `district` VALUES ('554', '香坊区', '62');
INSERT INTO `district` VALUES ('555', '呼兰区', '62');
INSERT INTO `district` VALUES ('556', '阿城区', '62');
INSERT INTO `district` VALUES ('557', '双城区', '62');
INSERT INTO `district` VALUES ('558', '依兰县', '62');
INSERT INTO `district` VALUES ('559', '方正县', '62');
INSERT INTO `district` VALUES ('560', '宾县', '62');
INSERT INTO `district` VALUES ('561', '巴彦县', '62');
INSERT INTO `district` VALUES ('562', '木兰县', '62');
INSERT INTO `district` VALUES ('563', '通河县', '62');
INSERT INTO `district` VALUES ('564', '延寿县', '62');
INSERT INTO `district` VALUES ('565', '尚志市', '62');
INSERT INTO `district` VALUES ('566', '五常市', '62');
INSERT INTO `district` VALUES ('567', '龙沙区', '63');
INSERT INTO `district` VALUES ('568', '建华区', '63');
INSERT INTO `district` VALUES ('569', '铁锋区', '63');
INSERT INTO `district` VALUES ('570', '昂昂溪区', '63');
INSERT INTO `district` VALUES ('571', '富拉尔基区', '63');
INSERT INTO `district` VALUES ('572', '碾子山区', '63');
INSERT INTO `district` VALUES ('573', '梅里斯达斡尔族区', '63');
INSERT INTO `district` VALUES ('574', '龙江县', '63');
INSERT INTO `district` VALUES ('575', '依安县', '63');
INSERT INTO `district` VALUES ('576', '泰来县', '63');
INSERT INTO `district` VALUES ('577', '甘南县', '63');
INSERT INTO `district` VALUES ('578', '富裕县', '63');
INSERT INTO `district` VALUES ('579', '克山县', '63');
INSERT INTO `district` VALUES ('580', '克东县', '63');
INSERT INTO `district` VALUES ('581', '拜泉县', '63');
INSERT INTO `district` VALUES ('582', '讷河市', '63');
INSERT INTO `district` VALUES ('583', '鸡冠区', '64');
INSERT INTO `district` VALUES ('584', '恒山区', '64');
INSERT INTO `district` VALUES ('585', '滴道区', '64');
INSERT INTO `district` VALUES ('586', '梨树区', '64');
INSERT INTO `district` VALUES ('587', '城子河区', '64');
INSERT INTO `district` VALUES ('588', '麻山区', '64');
INSERT INTO `district` VALUES ('589', '鸡东县', '64');
INSERT INTO `district` VALUES ('590', '虎林市', '64');
INSERT INTO `district` VALUES ('591', '密山市', '64');
INSERT INTO `district` VALUES ('592', '向阳区', '65');
INSERT INTO `district` VALUES ('593', '工农区', '65');
INSERT INTO `district` VALUES ('594', '南山区', '65');
INSERT INTO `district` VALUES ('595', '兴安区', '65');
INSERT INTO `district` VALUES ('596', '东山区', '65');
INSERT INTO `district` VALUES ('597', '兴山区', '65');
INSERT INTO `district` VALUES ('598', '萝北县', '65');
INSERT INTO `district` VALUES ('599', '绥滨县', '65');
INSERT INTO `district` VALUES ('600', '尖山区', '66');
INSERT INTO `district` VALUES ('601', '岭东区', '66');
INSERT INTO `district` VALUES ('602', '四方台区', '66');
INSERT INTO `district` VALUES ('603', '宝山区', '66');
INSERT INTO `district` VALUES ('604', '集贤县', '66');
INSERT INTO `district` VALUES ('605', '友谊县', '66');
INSERT INTO `district` VALUES ('606', '宝清县', '66');
INSERT INTO `district` VALUES ('607', '饶河县', '66');
INSERT INTO `district` VALUES ('608', '萨尔图区', '67');
INSERT INTO `district` VALUES ('609', '龙凤区', '67');
INSERT INTO `district` VALUES ('610', '让胡路区', '67');
INSERT INTO `district` VALUES ('611', '红岗区', '67');
INSERT INTO `district` VALUES ('612', '大同区', '67');
INSERT INTO `district` VALUES ('613', '肇州县', '67');
INSERT INTO `district` VALUES ('614', '肇源县', '67');
INSERT INTO `district` VALUES ('615', '林甸县', '67');
INSERT INTO `district` VALUES ('616', '杜尔伯特蒙古族自治县', '67');
INSERT INTO `district` VALUES ('617', '伊春区', '68');
INSERT INTO `district` VALUES ('618', '南岔区', '68');
INSERT INTO `district` VALUES ('619', '友好区', '68');
INSERT INTO `district` VALUES ('620', '西林区', '68');
INSERT INTO `district` VALUES ('621', '翠峦区', '68');
INSERT INTO `district` VALUES ('622', '新青区', '68');
INSERT INTO `district` VALUES ('623', '美溪区', '68');
INSERT INTO `district` VALUES ('624', '金山屯区', '68');
INSERT INTO `district` VALUES ('625', '五营区', '68');
INSERT INTO `district` VALUES ('626', '乌马河区', '68');
INSERT INTO `district` VALUES ('627', '汤旺河区', '68');
INSERT INTO `district` VALUES ('628', '带岭区', '68');
INSERT INTO `district` VALUES ('629', '乌伊岭区', '68');
INSERT INTO `district` VALUES ('630', '红星区', '68');
INSERT INTO `district` VALUES ('631', '上甘岭区', '68');
INSERT INTO `district` VALUES ('632', '嘉荫县', '68');
INSERT INTO `district` VALUES ('633', '铁力市', '68');
INSERT INTO `district` VALUES ('634', '向阳区', '69');
INSERT INTO `district` VALUES ('635', '前进区', '69');
INSERT INTO `district` VALUES ('636', '东风区', '69');
INSERT INTO `district` VALUES ('637', '郊区', '69');
INSERT INTO `district` VALUES ('638', '桦南县', '69');
INSERT INTO `district` VALUES ('639', '桦川县', '69');
INSERT INTO `district` VALUES ('640', '汤原县', '69');
INSERT INTO `district` VALUES ('641', '同江市', '69');
INSERT INTO `district` VALUES ('642', '富锦市', '69');
INSERT INTO `district` VALUES ('643', '抚远市', '69');
INSERT INTO `district` VALUES ('644', '新兴区', '70');
INSERT INTO `district` VALUES ('645', '桃山区', '70');
INSERT INTO `district` VALUES ('646', '茄子河区', '70');
INSERT INTO `district` VALUES ('647', '勃利县', '70');
INSERT INTO `district` VALUES ('648', '东安区', '71');
INSERT INTO `district` VALUES ('649', '阳明区', '71');
INSERT INTO `district` VALUES ('650', '爱民区', '71');
INSERT INTO `district` VALUES ('651', '西安区', '71');
INSERT INTO `district` VALUES ('652', '林口县', '71');
INSERT INTO `district` VALUES ('653', '绥芬河市', '71');
INSERT INTO `district` VALUES ('654', '海林市', '71');
INSERT INTO `district` VALUES ('655', '宁安市', '71');
INSERT INTO `district` VALUES ('656', '穆棱市', '71');
INSERT INTO `district` VALUES ('657', '东宁市', '71');
INSERT INTO `district` VALUES ('658', '爱辉区', '72');
INSERT INTO `district` VALUES ('659', '嫩江县', '72');
INSERT INTO `district` VALUES ('660', '逊克县', '72');
INSERT INTO `district` VALUES ('661', '孙吴县', '72');
INSERT INTO `district` VALUES ('662', '北安市', '72');
INSERT INTO `district` VALUES ('663', '五大连池市', '72');
INSERT INTO `district` VALUES ('664', '北林区', '73');
INSERT INTO `district` VALUES ('665', '望奎县', '73');
INSERT INTO `district` VALUES ('666', '兰西县', '73');
INSERT INTO `district` VALUES ('667', '青冈县', '73');
INSERT INTO `district` VALUES ('668', '庆安县', '73');
INSERT INTO `district` VALUES ('669', '明水县', '73');
INSERT INTO `district` VALUES ('670', '绥棱县', '73');
INSERT INTO `district` VALUES ('671', '安达市', '73');
INSERT INTO `district` VALUES ('672', '肇东市', '73');
INSERT INTO `district` VALUES ('673', '海伦市', '73');
INSERT INTO `district` VALUES ('674', '加格达奇区', '74');
INSERT INTO `district` VALUES ('675', '呼玛县', '74');
INSERT INTO `district` VALUES ('676', '塔河县', '74');
INSERT INTO `district` VALUES ('677', '漠河县', '74');
INSERT INTO `district` VALUES ('678', '玄武区', '76');
INSERT INTO `district` VALUES ('679', '秦淮区', '76');
INSERT INTO `district` VALUES ('680', '建邺区', '76');
INSERT INTO `district` VALUES ('681', '鼓楼区', '76');
INSERT INTO `district` VALUES ('682', '浦口区', '76');
INSERT INTO `district` VALUES ('683', '栖霞区', '76');
INSERT INTO `district` VALUES ('684', '雨花台区', '76');
INSERT INTO `district` VALUES ('685', '江宁区', '76');
INSERT INTO `district` VALUES ('686', '六合区', '76');
INSERT INTO `district` VALUES ('687', '溧水区', '76');
INSERT INTO `district` VALUES ('688', '高淳区', '76');
INSERT INTO `district` VALUES ('689', '锡山区', '77');
INSERT INTO `district` VALUES ('690', '惠山区', '77');
INSERT INTO `district` VALUES ('691', '滨湖区', '77');
INSERT INTO `district` VALUES ('692', '梁溪区', '77');
INSERT INTO `district` VALUES ('693', '新吴区', '77');
INSERT INTO `district` VALUES ('694', '江阴市', '77');
INSERT INTO `district` VALUES ('695', '宜兴市', '77');
INSERT INTO `district` VALUES ('696', '鼓楼区', '78');
INSERT INTO `district` VALUES ('697', '云龙区', '78');
INSERT INTO `district` VALUES ('698', '贾汪区', '78');
INSERT INTO `district` VALUES ('699', '泉山区', '78');
INSERT INTO `district` VALUES ('700', '铜山区', '78');
INSERT INTO `district` VALUES ('701', '丰县', '78');
INSERT INTO `district` VALUES ('702', '沛县', '78');
INSERT INTO `district` VALUES ('703', '睢宁县', '78');
INSERT INTO `district` VALUES ('704', '新沂市', '78');
INSERT INTO `district` VALUES ('705', '邳州市', '78');
INSERT INTO `district` VALUES ('706', '天宁区', '79');
INSERT INTO `district` VALUES ('707', '钟楼区', '79');
INSERT INTO `district` VALUES ('708', '新北区', '79');
INSERT INTO `district` VALUES ('709', '武进区', '79');
INSERT INTO `district` VALUES ('710', '金坛区', '79');
INSERT INTO `district` VALUES ('711', '溧阳市', '79');
INSERT INTO `district` VALUES ('712', '虎丘区', '80');
INSERT INTO `district` VALUES ('713', '吴中区', '80');
INSERT INTO `district` VALUES ('714', '相城区', '80');
INSERT INTO `district` VALUES ('715', '姑苏区', '80');
INSERT INTO `district` VALUES ('716', '吴江区', '80');
INSERT INTO `district` VALUES ('717', '常熟市', '80');
INSERT INTO `district` VALUES ('718', '张家港市', '80');
INSERT INTO `district` VALUES ('719', '昆山市', '80');
INSERT INTO `district` VALUES ('720', '太仓市', '80');
INSERT INTO `district` VALUES ('721', '崇川区', '81');
INSERT INTO `district` VALUES ('722', '港闸区', '81');
INSERT INTO `district` VALUES ('723', '通州区', '81');
INSERT INTO `district` VALUES ('724', '海安县', '81');
INSERT INTO `district` VALUES ('725', '如东县', '81');
INSERT INTO `district` VALUES ('726', '启东市', '81');
INSERT INTO `district` VALUES ('727', '如皋市', '81');
INSERT INTO `district` VALUES ('728', '海门市', '81');
INSERT INTO `district` VALUES ('729', '连云区', '82');
INSERT INTO `district` VALUES ('730', '海州区', '82');
INSERT INTO `district` VALUES ('731', '赣榆区', '82');
INSERT INTO `district` VALUES ('732', '东海县', '82');
INSERT INTO `district` VALUES ('733', '灌云县', '82');
INSERT INTO `district` VALUES ('734', '灌南县', '82');
INSERT INTO `district` VALUES ('735', '淮安区', '83');
INSERT INTO `district` VALUES ('736', '淮阴区', '83');
INSERT INTO `district` VALUES ('737', '清江浦区', '83');
INSERT INTO `district` VALUES ('738', '洪泽区', '83');
INSERT INTO `district` VALUES ('739', '涟水县', '83');
INSERT INTO `district` VALUES ('740', '盱眙县', '83');
INSERT INTO `district` VALUES ('741', '金湖县', '83');
INSERT INTO `district` VALUES ('742', '亭湖区', '84');
INSERT INTO `district` VALUES ('743', '盐都区', '84');
INSERT INTO `district` VALUES ('744', '大丰区', '84');
INSERT INTO `district` VALUES ('745', '响水县', '84');
INSERT INTO `district` VALUES ('746', '滨海县', '84');
INSERT INTO `district` VALUES ('747', '阜宁县', '84');
INSERT INTO `district` VALUES ('748', '射阳县', '84');
INSERT INTO `district` VALUES ('749', '建湖县', '84');
INSERT INTO `district` VALUES ('750', '东台市', '84');
INSERT INTO `district` VALUES ('751', '广陵区', '85');
INSERT INTO `district` VALUES ('752', '邗江区', '85');
INSERT INTO `district` VALUES ('753', '江都区', '85');
INSERT INTO `district` VALUES ('754', '宝应县', '85');
INSERT INTO `district` VALUES ('755', '仪征市', '85');
INSERT INTO `district` VALUES ('756', '高邮市', '85');
INSERT INTO `district` VALUES ('757', '京口区', '86');
INSERT INTO `district` VALUES ('758', '润州区', '86');
INSERT INTO `district` VALUES ('759', '丹徒区', '86');
INSERT INTO `district` VALUES ('760', '丹阳市', '86');
INSERT INTO `district` VALUES ('761', '扬中市', '86');
INSERT INTO `district` VALUES ('762', '句容市', '86');
INSERT INTO `district` VALUES ('763', '海陵区', '87');
INSERT INTO `district` VALUES ('764', '高港区', '87');
INSERT INTO `district` VALUES ('765', '姜堰区', '87');
INSERT INTO `district` VALUES ('766', '兴化市', '87');
INSERT INTO `district` VALUES ('767', '靖江市', '87');
INSERT INTO `district` VALUES ('768', '泰兴市', '87');
INSERT INTO `district` VALUES ('769', '宿城区', '88');
INSERT INTO `district` VALUES ('770', '宿豫区', '88');
INSERT INTO `district` VALUES ('771', '沭阳县', '88');
INSERT INTO `district` VALUES ('772', '泗阳县', '88');
INSERT INTO `district` VALUES ('773', '泗洪县', '88');
INSERT INTO `district` VALUES ('774', '上城区', '89');
INSERT INTO `district` VALUES ('775', '下城区', '89');
INSERT INTO `district` VALUES ('776', '江干区', '89');
INSERT INTO `district` VALUES ('777', '拱墅区', '89');
INSERT INTO `district` VALUES ('778', '西湖区', '89');
INSERT INTO `district` VALUES ('779', '滨江区', '89');
INSERT INTO `district` VALUES ('780', '萧山区', '89');
INSERT INTO `district` VALUES ('781', '余杭区', '89');
INSERT INTO `district` VALUES ('782', '富阳区', '89');
INSERT INTO `district` VALUES ('783', '桐庐县', '89');
INSERT INTO `district` VALUES ('784', '淳安县', '89');
INSERT INTO `district` VALUES ('785', '建德市', '89');
INSERT INTO `district` VALUES ('786', '临安市', '89');
INSERT INTO `district` VALUES ('787', '海曙区', '90');
INSERT INTO `district` VALUES ('788', '江北区', '90');
INSERT INTO `district` VALUES ('789', '北仑区', '90');
INSERT INTO `district` VALUES ('790', '镇海区', '90');
INSERT INTO `district` VALUES ('791', '鄞州区', '90');
INSERT INTO `district` VALUES ('792', '奉化区', '90');
INSERT INTO `district` VALUES ('793', '象山县', '90');
INSERT INTO `district` VALUES ('794', '宁海县', '90');
INSERT INTO `district` VALUES ('795', '余姚市', '90');
INSERT INTO `district` VALUES ('796', '慈溪市', '90');
INSERT INTO `district` VALUES ('797', '鹿城区', '91');
INSERT INTO `district` VALUES ('798', '龙湾区', '91');
INSERT INTO `district` VALUES ('799', '瓯海区', '91');
INSERT INTO `district` VALUES ('800', '洞头区', '91');
INSERT INTO `district` VALUES ('801', '永嘉县', '91');
INSERT INTO `district` VALUES ('802', '平阳县', '91');
INSERT INTO `district` VALUES ('803', '苍南县', '91');
INSERT INTO `district` VALUES ('804', '文成县', '91');
INSERT INTO `district` VALUES ('805', '泰顺县', '91');
INSERT INTO `district` VALUES ('806', '瑞安市', '91');
INSERT INTO `district` VALUES ('807', '乐清市', '91');
INSERT INTO `district` VALUES ('808', '南湖区', '92');
INSERT INTO `district` VALUES ('809', '秀洲区', '92');
INSERT INTO `district` VALUES ('810', '嘉善县', '92');
INSERT INTO `district` VALUES ('811', '海盐县', '92');
INSERT INTO `district` VALUES ('812', '海宁市', '92');
INSERT INTO `district` VALUES ('813', '平湖市', '92');
INSERT INTO `district` VALUES ('814', '桐乡市', '92');
INSERT INTO `district` VALUES ('815', '吴兴区', '93');
INSERT INTO `district` VALUES ('816', '南浔区', '93');
INSERT INTO `district` VALUES ('817', '德清县', '93');
INSERT INTO `district` VALUES ('818', '长兴县', '93');
INSERT INTO `district` VALUES ('819', '安吉县', '93');
INSERT INTO `district` VALUES ('820', '越城区', '94');
INSERT INTO `district` VALUES ('821', '柯桥区', '94');
INSERT INTO `district` VALUES ('822', '上虞区', '94');
INSERT INTO `district` VALUES ('823', '新昌县', '94');
INSERT INTO `district` VALUES ('824', '诸暨市', '94');
INSERT INTO `district` VALUES ('825', '嵊州市', '94');
INSERT INTO `district` VALUES ('826', '婺城区', '95');
INSERT INTO `district` VALUES ('827', '金东区', '95');
INSERT INTO `district` VALUES ('828', '武义县', '95');
INSERT INTO `district` VALUES ('829', '浦江县', '95');
INSERT INTO `district` VALUES ('830', '磐安县', '95');
INSERT INTO `district` VALUES ('831', '兰溪市', '95');
INSERT INTO `district` VALUES ('832', '义乌市', '95');
INSERT INTO `district` VALUES ('833', '东阳市', '95');
INSERT INTO `district` VALUES ('834', '永康市', '95');
INSERT INTO `district` VALUES ('835', '柯城区', '96');
INSERT INTO `district` VALUES ('836', '衢江区', '96');
INSERT INTO `district` VALUES ('837', '常山县', '96');
INSERT INTO `district` VALUES ('838', '开化县', '96');
INSERT INTO `district` VALUES ('839', '龙游县', '96');
INSERT INTO `district` VALUES ('840', '江山市', '96');
INSERT INTO `district` VALUES ('841', '定海区', '97');
INSERT INTO `district` VALUES ('842', '普陀区', '97');
INSERT INTO `district` VALUES ('843', '岱山县', '97');
INSERT INTO `district` VALUES ('844', '嵊泗县', '97');
INSERT INTO `district` VALUES ('845', '椒江区', '98');
INSERT INTO `district` VALUES ('846', '黄岩区', '98');
INSERT INTO `district` VALUES ('847', '路桥区', '98');
INSERT INTO `district` VALUES ('848', '三门县', '98');
INSERT INTO `district` VALUES ('849', '天台县', '98');
INSERT INTO `district` VALUES ('850', '仙居县', '98');
INSERT INTO `district` VALUES ('851', '温岭市', '98');
INSERT INTO `district` VALUES ('852', '临海市', '98');
INSERT INTO `district` VALUES ('853', '玉环市', '98');
INSERT INTO `district` VALUES ('854', '莲都区', '99');
INSERT INTO `district` VALUES ('855', '青田县', '99');
INSERT INTO `district` VALUES ('856', '缙云县', '99');
INSERT INTO `district` VALUES ('857', '遂昌县', '99');
INSERT INTO `district` VALUES ('858', '松阳县', '99');
INSERT INTO `district` VALUES ('859', '云和县', '99');
INSERT INTO `district` VALUES ('860', '庆元县', '99');
INSERT INTO `district` VALUES ('861', '景宁畲族自治县', '99');
INSERT INTO `district` VALUES ('862', '龙泉市', '99');
INSERT INTO `district` VALUES ('863', '瑶海区', '100');
INSERT INTO `district` VALUES ('864', '庐阳区', '100');
INSERT INTO `district` VALUES ('865', '蜀山区', '100');
INSERT INTO `district` VALUES ('866', '包河区', '100');
INSERT INTO `district` VALUES ('867', '长丰县', '100');
INSERT INTO `district` VALUES ('868', '肥东县', '100');
INSERT INTO `district` VALUES ('869', '肥西县', '100');
INSERT INTO `district` VALUES ('870', '庐江县', '100');
INSERT INTO `district` VALUES ('871', '巢湖市', '100');
INSERT INTO `district` VALUES ('872', '镜湖区', '101');
INSERT INTO `district` VALUES ('873', '弋江区', '101');
INSERT INTO `district` VALUES ('874', '鸠江区', '101');
INSERT INTO `district` VALUES ('875', '三山区', '101');
INSERT INTO `district` VALUES ('876', '芜湖县', '101');
INSERT INTO `district` VALUES ('877', '繁昌县', '101');
INSERT INTO `district` VALUES ('878', '南陵县', '101');
INSERT INTO `district` VALUES ('879', '无为县', '101');
INSERT INTO `district` VALUES ('880', '龙子湖区', '102');
INSERT INTO `district` VALUES ('881', '蚌山区', '102');
INSERT INTO `district` VALUES ('882', '禹会区', '102');
INSERT INTO `district` VALUES ('883', '淮上区', '102');
INSERT INTO `district` VALUES ('884', '怀远县', '102');
INSERT INTO `district` VALUES ('885', '五河县', '102');
INSERT INTO `district` VALUES ('886', '固镇县', '102');
INSERT INTO `district` VALUES ('887', '大通区', '103');
INSERT INTO `district` VALUES ('888', '田家庵区', '103');
INSERT INTO `district` VALUES ('889', '谢家集区', '103');
INSERT INTO `district` VALUES ('890', '八公山区', '103');
INSERT INTO `district` VALUES ('891', '潘集区', '103');
INSERT INTO `district` VALUES ('892', '凤台县', '103');
INSERT INTO `district` VALUES ('893', '寿县', '103');
INSERT INTO `district` VALUES ('894', '花山区', '104');
INSERT INTO `district` VALUES ('895', '雨山区', '104');
INSERT INTO `district` VALUES ('896', '博望区', '104');
INSERT INTO `district` VALUES ('897', '当涂县', '104');
INSERT INTO `district` VALUES ('898', '含山县', '104');
INSERT INTO `district` VALUES ('899', '和县', '104');
INSERT INTO `district` VALUES ('900', '杜集区', '105');
INSERT INTO `district` VALUES ('901', '相山区', '105');
INSERT INTO `district` VALUES ('902', '烈山区', '105');
INSERT INTO `district` VALUES ('903', '濉溪县', '105');
INSERT INTO `district` VALUES ('904', '铜官区', '106');
INSERT INTO `district` VALUES ('905', '义安区', '106');
INSERT INTO `district` VALUES ('906', '郊区', '106');
INSERT INTO `district` VALUES ('907', '枞阳县', '106');
INSERT INTO `district` VALUES ('908', '迎江区', '107');
INSERT INTO `district` VALUES ('909', '大观区', '107');
INSERT INTO `district` VALUES ('910', '宜秀区', '107');
INSERT INTO `district` VALUES ('911', '怀宁县', '107');
INSERT INTO `district` VALUES ('912', '潜山县', '107');
INSERT INTO `district` VALUES ('913', '太湖县', '107');
INSERT INTO `district` VALUES ('914', '宿松县', '107');
INSERT INTO `district` VALUES ('915', '望江县', '107');
INSERT INTO `district` VALUES ('916', '岳西县', '107');
INSERT INTO `district` VALUES ('917', '桐城市', '107');
INSERT INTO `district` VALUES ('918', '屯溪区', '108');
INSERT INTO `district` VALUES ('919', '黄山区', '108');
INSERT INTO `district` VALUES ('920', '徽州区', '108');
INSERT INTO `district` VALUES ('921', '歙县', '108');
INSERT INTO `district` VALUES ('922', '休宁县', '108');
INSERT INTO `district` VALUES ('923', '黟县', '108');
INSERT INTO `district` VALUES ('924', '祁门县', '108');
INSERT INTO `district` VALUES ('925', '琅琊区', '109');
INSERT INTO `district` VALUES ('926', '南谯区', '109');
INSERT INTO `district` VALUES ('927', '来安县', '109');
INSERT INTO `district` VALUES ('928', '全椒县', '109');
INSERT INTO `district` VALUES ('929', '定远县', '109');
INSERT INTO `district` VALUES ('930', '凤阳县', '109');
INSERT INTO `district` VALUES ('931', '天长市', '109');
INSERT INTO `district` VALUES ('932', '明光市', '109');
INSERT INTO `district` VALUES ('933', '颍州区', '110');
INSERT INTO `district` VALUES ('934', '颍东区', '110');
INSERT INTO `district` VALUES ('935', '颍泉区', '110');
INSERT INTO `district` VALUES ('936', '临泉县', '110');
INSERT INTO `district` VALUES ('937', '太和县', '110');
INSERT INTO `district` VALUES ('938', '阜南县', '110');
INSERT INTO `district` VALUES ('939', '颍上县', '110');
INSERT INTO `district` VALUES ('940', '界首市', '110');
INSERT INTO `district` VALUES ('941', '埇桥区', '111');
INSERT INTO `district` VALUES ('942', '砀山县', '111');
INSERT INTO `district` VALUES ('943', '萧县', '111');
INSERT INTO `district` VALUES ('944', '灵璧县', '111');
INSERT INTO `district` VALUES ('945', '泗县', '111');
INSERT INTO `district` VALUES ('946', '金安区', '112');
INSERT INTO `district` VALUES ('947', '裕安区', '112');
INSERT INTO `district` VALUES ('948', '叶集区', '112');
INSERT INTO `district` VALUES ('949', '霍邱县', '112');
INSERT INTO `district` VALUES ('950', '舒城县', '112');
INSERT INTO `district` VALUES ('951', '金寨县', '112');
INSERT INTO `district` VALUES ('952', '霍山县', '112');
INSERT INTO `district` VALUES ('953', '谯城区', '113');
INSERT INTO `district` VALUES ('954', '涡阳县', '113');
INSERT INTO `district` VALUES ('955', '蒙城县', '113');
INSERT INTO `district` VALUES ('956', '利辛县', '113');
INSERT INTO `district` VALUES ('957', '贵池区', '114');
INSERT INTO `district` VALUES ('958', '东至县', '114');
INSERT INTO `district` VALUES ('959', '石台县', '114');
INSERT INTO `district` VALUES ('960', '青阳县', '114');
INSERT INTO `district` VALUES ('961', '宣州区', '115');
INSERT INTO `district` VALUES ('962', '郎溪县', '115');
INSERT INTO `district` VALUES ('963', '广德县', '115');
INSERT INTO `district` VALUES ('964', '泾县', '115');
INSERT INTO `district` VALUES ('965', '绩溪县', '115');
INSERT INTO `district` VALUES ('966', '旌德县', '115');
INSERT INTO `district` VALUES ('967', '宁国市', '115');
INSERT INTO `district` VALUES ('968', '鼓楼区', '116');
INSERT INTO `district` VALUES ('969', '台江区', '116');
INSERT INTO `district` VALUES ('970', '仓山区', '116');
INSERT INTO `district` VALUES ('971', '马尾区', '116');
INSERT INTO `district` VALUES ('972', '晋安区', '116');
INSERT INTO `district` VALUES ('973', '闽侯县', '116');
INSERT INTO `district` VALUES ('974', '连江县', '116');
INSERT INTO `district` VALUES ('975', '罗源县', '116');
INSERT INTO `district` VALUES ('976', '闽清县', '116');
INSERT INTO `district` VALUES ('977', '永泰县', '116');
INSERT INTO `district` VALUES ('978', '平潭县', '116');
INSERT INTO `district` VALUES ('979', '福清市', '116');
INSERT INTO `district` VALUES ('980', '长乐市', '116');
INSERT INTO `district` VALUES ('981', '思明区', '117');
INSERT INTO `district` VALUES ('982', '海沧区', '117');
INSERT INTO `district` VALUES ('983', '湖里区', '117');
INSERT INTO `district` VALUES ('984', '集美区', '117');
INSERT INTO `district` VALUES ('985', '同安区', '117');
INSERT INTO `district` VALUES ('986', '翔安区', '117');
INSERT INTO `district` VALUES ('987', '城厢区', '118');
INSERT INTO `district` VALUES ('988', '涵江区', '118');
INSERT INTO `district` VALUES ('989', '荔城区', '118');
INSERT INTO `district` VALUES ('990', '秀屿区', '118');
INSERT INTO `district` VALUES ('991', '仙游县', '118');
INSERT INTO `district` VALUES ('992', '梅列区', '119');
INSERT INTO `district` VALUES ('993', '三元区', '119');
INSERT INTO `district` VALUES ('994', '明溪县', '119');
INSERT INTO `district` VALUES ('995', '清流县', '119');
INSERT INTO `district` VALUES ('996', '宁化县', '119');
INSERT INTO `district` VALUES ('997', '大田县', '119');
INSERT INTO `district` VALUES ('998', '尤溪县', '119');
INSERT INTO `district` VALUES ('999', '沙县', '119');
INSERT INTO `district` VALUES ('1000', '将乐县', '119');
INSERT INTO `district` VALUES ('1001', '泰宁县', '119');
INSERT INTO `district` VALUES ('1002', '建宁县', '119');
INSERT INTO `district` VALUES ('1003', '永安市', '119');
INSERT INTO `district` VALUES ('1004', '鲤城区', '120');
INSERT INTO `district` VALUES ('1005', '丰泽区', '120');
INSERT INTO `district` VALUES ('1006', '洛江区', '120');
INSERT INTO `district` VALUES ('1007', '泉港区', '120');
INSERT INTO `district` VALUES ('1008', '惠安县', '120');
INSERT INTO `district` VALUES ('1009', '安溪县', '120');
INSERT INTO `district` VALUES ('1010', '永春县', '120');
INSERT INTO `district` VALUES ('1011', '德化县', '120');
INSERT INTO `district` VALUES ('1012', '金门县', '120');
INSERT INTO `district` VALUES ('1013', '石狮市', '120');
INSERT INTO `district` VALUES ('1014', '晋江市', '120');
INSERT INTO `district` VALUES ('1015', '南安市', '120');
INSERT INTO `district` VALUES ('1016', '芗城区', '121');
INSERT INTO `district` VALUES ('1017', '龙文区', '121');
INSERT INTO `district` VALUES ('1018', '云霄县', '121');
INSERT INTO `district` VALUES ('1019', '漳浦县', '121');
INSERT INTO `district` VALUES ('1020', '诏安县', '121');
INSERT INTO `district` VALUES ('1021', '长泰县', '121');
INSERT INTO `district` VALUES ('1022', '东山县', '121');
INSERT INTO `district` VALUES ('1023', '南靖县', '121');
INSERT INTO `district` VALUES ('1024', '平和县', '121');
INSERT INTO `district` VALUES ('1025', '华安县', '121');
INSERT INTO `district` VALUES ('1026', '龙海市', '121');
INSERT INTO `district` VALUES ('1027', '延平区', '122');
INSERT INTO `district` VALUES ('1028', '建阳区', '122');
INSERT INTO `district` VALUES ('1029', '顺昌县', '122');
INSERT INTO `district` VALUES ('1030', '浦城县', '122');
INSERT INTO `district` VALUES ('1031', '光泽县', '122');
INSERT INTO `district` VALUES ('1032', '松溪县', '122');
INSERT INTO `district` VALUES ('1033', '政和县', '122');
INSERT INTO `district` VALUES ('1034', '邵武市', '122');
INSERT INTO `district` VALUES ('1035', '武夷山市', '122');
INSERT INTO `district` VALUES ('1036', '建瓯市', '122');
INSERT INTO `district` VALUES ('1037', '新罗区', '123');
INSERT INTO `district` VALUES ('1038', '永定区', '123');
INSERT INTO `district` VALUES ('1039', '长汀县', '123');
INSERT INTO `district` VALUES ('1040', '上杭县', '123');
INSERT INTO `district` VALUES ('1041', '武平县', '123');
INSERT INTO `district` VALUES ('1042', '连城县', '123');
INSERT INTO `district` VALUES ('1043', '漳平市', '123');
INSERT INTO `district` VALUES ('1044', '蕉城区', '124');
INSERT INTO `district` VALUES ('1045', '霞浦县', '124');
INSERT INTO `district` VALUES ('1046', '古田县', '124');
INSERT INTO `district` VALUES ('1047', '屏南县', '124');
INSERT INTO `district` VALUES ('1048', '寿宁县', '124');
INSERT INTO `district` VALUES ('1049', '周宁县', '124');
INSERT INTO `district` VALUES ('1050', '柘荣县', '124');
INSERT INTO `district` VALUES ('1051', '福安市', '124');
INSERT INTO `district` VALUES ('1052', '福鼎市', '124');
INSERT INTO `district` VALUES ('1053', '东湖区', '125');
INSERT INTO `district` VALUES ('1054', '西湖区', '125');
INSERT INTO `district` VALUES ('1055', '青云谱区', '125');
INSERT INTO `district` VALUES ('1056', '湾里区', '125');
INSERT INTO `district` VALUES ('1057', '青山湖区', '125');
INSERT INTO `district` VALUES ('1058', '新建区', '125');
INSERT INTO `district` VALUES ('1059', '南昌县', '125');
INSERT INTO `district` VALUES ('1060', '安义县', '125');
INSERT INTO `district` VALUES ('1061', '进贤县', '125');
INSERT INTO `district` VALUES ('1062', '昌江区', '126');
INSERT INTO `district` VALUES ('1063', '珠山区', '126');
INSERT INTO `district` VALUES ('1064', '浮梁县', '126');
INSERT INTO `district` VALUES ('1065', '乐平市', '126');
INSERT INTO `district` VALUES ('1066', '安源区', '127');
INSERT INTO `district` VALUES ('1067', '湘东区', '127');
INSERT INTO `district` VALUES ('1068', '莲花县', '127');
INSERT INTO `district` VALUES ('1069', '上栗县', '127');
INSERT INTO `district` VALUES ('1070', '芦溪县', '127');
INSERT INTO `district` VALUES ('1071', '濂溪区', '128');
INSERT INTO `district` VALUES ('1072', '浔阳区', '128');
INSERT INTO `district` VALUES ('1073', '九江县', '128');
INSERT INTO `district` VALUES ('1074', '武宁县', '128');
INSERT INTO `district` VALUES ('1075', '修水县', '128');
INSERT INTO `district` VALUES ('1076', '永修县', '128');
INSERT INTO `district` VALUES ('1077', '德安县', '128');
INSERT INTO `district` VALUES ('1078', '都昌县', '128');
INSERT INTO `district` VALUES ('1079', '湖口县', '128');
INSERT INTO `district` VALUES ('1080', '彭泽县', '128');
INSERT INTO `district` VALUES ('1081', '瑞昌市', '128');
INSERT INTO `district` VALUES ('1082', '共青城市', '128');
INSERT INTO `district` VALUES ('1083', '庐山市', '128');
INSERT INTO `district` VALUES ('1084', '渝水区', '129');
INSERT INTO `district` VALUES ('1085', '分宜县', '129');
INSERT INTO `district` VALUES ('1086', '月湖区', '130');
INSERT INTO `district` VALUES ('1087', '余江县', '130');
INSERT INTO `district` VALUES ('1088', '贵溪市', '130');
INSERT INTO `district` VALUES ('1089', '章贡区', '131');
INSERT INTO `district` VALUES ('1090', '南康区', '131');
INSERT INTO `district` VALUES ('1091', '赣县区', '131');
INSERT INTO `district` VALUES ('1092', '信丰县', '131');
INSERT INTO `district` VALUES ('1093', '大余县', '131');
INSERT INTO `district` VALUES ('1094', '上犹县', '131');
INSERT INTO `district` VALUES ('1095', '崇义县', '131');
INSERT INTO `district` VALUES ('1096', '安远县', '131');
INSERT INTO `district` VALUES ('1097', '龙南县', '131');
INSERT INTO `district` VALUES ('1098', '定南县', '131');
INSERT INTO `district` VALUES ('1099', '全南县', '131');
INSERT INTO `district` VALUES ('1100', '宁都县', '131');
INSERT INTO `district` VALUES ('1101', '于都县', '131');
INSERT INTO `district` VALUES ('1102', '兴国县', '131');
INSERT INTO `district` VALUES ('1103', '会昌县', '131');
INSERT INTO `district` VALUES ('1104', '寻乌县', '131');
INSERT INTO `district` VALUES ('1105', '石城县', '131');
INSERT INTO `district` VALUES ('1106', '瑞金市', '131');
INSERT INTO `district` VALUES ('1107', '吉州区', '132');
INSERT INTO `district` VALUES ('1108', '青原区', '132');
INSERT INTO `district` VALUES ('1109', '吉安县', '132');
INSERT INTO `district` VALUES ('1110', '吉水县', '132');
INSERT INTO `district` VALUES ('1111', '峡江县', '132');
INSERT INTO `district` VALUES ('1112', '新干县', '132');
INSERT INTO `district` VALUES ('1113', '永丰县', '132');
INSERT INTO `district` VALUES ('1114', '泰和县', '132');
INSERT INTO `district` VALUES ('1115', '遂川县', '132');
INSERT INTO `district` VALUES ('1116', '万安县', '132');
INSERT INTO `district` VALUES ('1117', '安福县', '132');
INSERT INTO `district` VALUES ('1118', '永新县', '132');
INSERT INTO `district` VALUES ('1119', '井冈山市', '132');
INSERT INTO `district` VALUES ('1120', '袁州区', '133');
INSERT INTO `district` VALUES ('1121', '奉新县', '133');
INSERT INTO `district` VALUES ('1122', '万载县', '133');
INSERT INTO `district` VALUES ('1123', '上高县', '133');
INSERT INTO `district` VALUES ('1124', '宜丰县', '133');
INSERT INTO `district` VALUES ('1125', '靖安县', '133');
INSERT INTO `district` VALUES ('1126', '铜鼓县', '133');
INSERT INTO `district` VALUES ('1127', '丰城市', '133');
INSERT INTO `district` VALUES ('1128', '樟树市', '133');
INSERT INTO `district` VALUES ('1129', '高安市', '133');
INSERT INTO `district` VALUES ('1130', '临川区', '134');
INSERT INTO `district` VALUES ('1131', '东乡区', '134');
INSERT INTO `district` VALUES ('1132', '南城县', '134');
INSERT INTO `district` VALUES ('1133', '黎川县', '134');
INSERT INTO `district` VALUES ('1134', '南丰县', '134');
INSERT INTO `district` VALUES ('1135', '崇仁县', '134');
INSERT INTO `district` VALUES ('1136', '乐安县', '134');
INSERT INTO `district` VALUES ('1137', '宜黄县', '134');
INSERT INTO `district` VALUES ('1138', '金溪县', '134');
INSERT INTO `district` VALUES ('1139', '资溪县', '134');
INSERT INTO `district` VALUES ('1140', '广昌县', '134');
INSERT INTO `district` VALUES ('1141', '信州区', '135');
INSERT INTO `district` VALUES ('1142', '广丰区', '135');
INSERT INTO `district` VALUES ('1143', '上饶县', '135');
INSERT INTO `district` VALUES ('1144', '玉山县', '135');
INSERT INTO `district` VALUES ('1145', '铅山县', '135');
INSERT INTO `district` VALUES ('1146', '横峰县', '135');
INSERT INTO `district` VALUES ('1147', '弋阳县', '135');
INSERT INTO `district` VALUES ('1148', '余干县', '135');
INSERT INTO `district` VALUES ('1149', '鄱阳县', '135');
INSERT INTO `district` VALUES ('1150', '万年县', '135');
INSERT INTO `district` VALUES ('1151', '婺源县', '135');
INSERT INTO `district` VALUES ('1152', '德兴市', '135');
INSERT INTO `district` VALUES ('1153', '历下区', '136');
INSERT INTO `district` VALUES ('1154', '市中区', '136');
INSERT INTO `district` VALUES ('1155', '槐荫区', '136');
INSERT INTO `district` VALUES ('1156', '天桥区', '136');
INSERT INTO `district` VALUES ('1157', '历城区', '136');
INSERT INTO `district` VALUES ('1158', '长清区', '136');
INSERT INTO `district` VALUES ('1159', '章丘区', '136');
INSERT INTO `district` VALUES ('1160', '平阴县', '136');
INSERT INTO `district` VALUES ('1161', '济阳县', '136');
INSERT INTO `district` VALUES ('1162', '商河县', '136');
INSERT INTO `district` VALUES ('1163', '市南区', '137');
INSERT INTO `district` VALUES ('1164', '市北区', '137');
INSERT INTO `district` VALUES ('1165', '黄岛区', '137');
INSERT INTO `district` VALUES ('1166', '崂山区', '137');
INSERT INTO `district` VALUES ('1167', '李沧区', '137');
INSERT INTO `district` VALUES ('1168', '城阳区', '137');
INSERT INTO `district` VALUES ('1169', '胶州市', '137');
INSERT INTO `district` VALUES ('1170', '即墨市', '137');
INSERT INTO `district` VALUES ('1171', '平度市', '137');
INSERT INTO `district` VALUES ('1172', '莱西市', '137');
INSERT INTO `district` VALUES ('1173', '淄川区', '138');
INSERT INTO `district` VALUES ('1174', '张店区', '138');
INSERT INTO `district` VALUES ('1175', '博山区', '138');
INSERT INTO `district` VALUES ('1176', '临淄区', '138');
INSERT INTO `district` VALUES ('1177', '周村区', '138');
INSERT INTO `district` VALUES ('1178', '桓台县', '138');
INSERT INTO `district` VALUES ('1179', '高青县', '138');
INSERT INTO `district` VALUES ('1180', '沂源县', '138');
INSERT INTO `district` VALUES ('1181', '市中区', '139');
INSERT INTO `district` VALUES ('1182', '薛城区', '139');
INSERT INTO `district` VALUES ('1183', '峄城区', '139');
INSERT INTO `district` VALUES ('1184', '台儿庄区', '139');
INSERT INTO `district` VALUES ('1185', '山亭区', '139');
INSERT INTO `district` VALUES ('1186', '滕州市', '139');
INSERT INTO `district` VALUES ('1187', '东营区', '140');
INSERT INTO `district` VALUES ('1188', '河口区', '140');
INSERT INTO `district` VALUES ('1189', '垦利区', '140');
INSERT INTO `district` VALUES ('1190', '利津县', '140');
INSERT INTO `district` VALUES ('1191', '广饶县', '140');
INSERT INTO `district` VALUES ('1192', '芝罘区', '141');
INSERT INTO `district` VALUES ('1193', '福山区', '141');
INSERT INTO `district` VALUES ('1194', '牟平区', '141');
INSERT INTO `district` VALUES ('1195', '莱山区', '141');
INSERT INTO `district` VALUES ('1196', '长岛县', '141');
INSERT INTO `district` VALUES ('1197', '龙口市', '141');
INSERT INTO `district` VALUES ('1198', '莱阳市', '141');
INSERT INTO `district` VALUES ('1199', '莱州市', '141');
INSERT INTO `district` VALUES ('1200', '蓬莱市', '141');
INSERT INTO `district` VALUES ('1201', '招远市', '141');
INSERT INTO `district` VALUES ('1202', '栖霞市', '141');
INSERT INTO `district` VALUES ('1203', '海阳市', '141');
INSERT INTO `district` VALUES ('1204', '潍城区', '142');
INSERT INTO `district` VALUES ('1205', '寒亭区', '142');
INSERT INTO `district` VALUES ('1206', '坊子区', '142');
INSERT INTO `district` VALUES ('1207', '奎文区', '142');
INSERT INTO `district` VALUES ('1208', '临朐县', '142');
INSERT INTO `district` VALUES ('1209', '昌乐县', '142');
INSERT INTO `district` VALUES ('1210', '青州市', '142');
INSERT INTO `district` VALUES ('1211', '诸城市', '142');
INSERT INTO `district` VALUES ('1212', '寿光市', '142');
INSERT INTO `district` VALUES ('1213', '安丘市', '142');
INSERT INTO `district` VALUES ('1214', '高密市', '142');
INSERT INTO `district` VALUES ('1215', '昌邑市', '142');
INSERT INTO `district` VALUES ('1216', '任城区', '143');
INSERT INTO `district` VALUES ('1217', '兖州区', '143');
INSERT INTO `district` VALUES ('1218', '微山县', '143');
INSERT INTO `district` VALUES ('1219', '鱼台县', '143');
INSERT INTO `district` VALUES ('1220', '金乡县', '143');
INSERT INTO `district` VALUES ('1221', '嘉祥县', '143');
INSERT INTO `district` VALUES ('1222', '汶上县', '143');
INSERT INTO `district` VALUES ('1223', '泗水县', '143');
INSERT INTO `district` VALUES ('1224', '梁山县', '143');
INSERT INTO `district` VALUES ('1225', '曲阜市', '143');
INSERT INTO `district` VALUES ('1226', '邹城市', '143');
INSERT INTO `district` VALUES ('1227', '泰山区', '144');
INSERT INTO `district` VALUES ('1228', '岱岳区', '144');
INSERT INTO `district` VALUES ('1229', '宁阳县', '144');
INSERT INTO `district` VALUES ('1230', '东平县', '144');
INSERT INTO `district` VALUES ('1231', '新泰市', '144');
INSERT INTO `district` VALUES ('1232', '肥城市', '144');
INSERT INTO `district` VALUES ('1233', '环翠区', '145');
INSERT INTO `district` VALUES ('1234', '文登区', '145');
INSERT INTO `district` VALUES ('1235', '荣成市', '145');
INSERT INTO `district` VALUES ('1236', '乳山市', '145');
INSERT INTO `district` VALUES ('1237', '东港区', '146');
INSERT INTO `district` VALUES ('1238', '岚山区', '146');
INSERT INTO `district` VALUES ('1239', '五莲县', '146');
INSERT INTO `district` VALUES ('1240', '莒县', '146');
INSERT INTO `district` VALUES ('1241', '莱城区', '147');
INSERT INTO `district` VALUES ('1242', '钢城区', '147');
INSERT INTO `district` VALUES ('1243', '兰山区', '148');
INSERT INTO `district` VALUES ('1244', '罗庄区', '148');
INSERT INTO `district` VALUES ('1245', '河东区', '148');
INSERT INTO `district` VALUES ('1246', '沂南县', '148');
INSERT INTO `district` VALUES ('1247', '郯城县', '148');
INSERT INTO `district` VALUES ('1248', '沂水县', '148');
INSERT INTO `district` VALUES ('1249', '兰陵县', '148');
INSERT INTO `district` VALUES ('1250', '费县', '148');
INSERT INTO `district` VALUES ('1251', '平邑县', '148');
INSERT INTO `district` VALUES ('1252', '莒南县', '148');
INSERT INTO `district` VALUES ('1253', '蒙阴县', '148');
INSERT INTO `district` VALUES ('1254', '临沭县', '148');
INSERT INTO `district` VALUES ('1255', '德城区', '149');
INSERT INTO `district` VALUES ('1256', '陵城区', '149');
INSERT INTO `district` VALUES ('1257', '宁津县', '149');
INSERT INTO `district` VALUES ('1258', '庆云县', '149');
INSERT INTO `district` VALUES ('1259', '临邑县', '149');
INSERT INTO `district` VALUES ('1260', '齐河县', '149');
INSERT INTO `district` VALUES ('1261', '平原县', '149');
INSERT INTO `district` VALUES ('1262', '夏津县', '149');
INSERT INTO `district` VALUES ('1263', '武城县', '149');
INSERT INTO `district` VALUES ('1264', '乐陵市', '149');
INSERT INTO `district` VALUES ('1265', '禹城市', '149');
INSERT INTO `district` VALUES ('1266', '东昌府区', '150');
INSERT INTO `district` VALUES ('1267', '阳谷县', '150');
INSERT INTO `district` VALUES ('1268', '莘县', '150');
INSERT INTO `district` VALUES ('1269', '茌平县', '150');
INSERT INTO `district` VALUES ('1270', '东阿县', '150');
INSERT INTO `district` VALUES ('1271', '冠县', '150');
INSERT INTO `district` VALUES ('1272', '高唐县', '150');
INSERT INTO `district` VALUES ('1273', '临清市', '150');
INSERT INTO `district` VALUES ('1274', '滨城区', '151');
INSERT INTO `district` VALUES ('1275', '沾化区', '151');
INSERT INTO `district` VALUES ('1276', '惠民县', '151');
INSERT INTO `district` VALUES ('1277', '阳信县', '151');
INSERT INTO `district` VALUES ('1278', '无棣县', '151');
INSERT INTO `district` VALUES ('1279', '博兴县', '151');
INSERT INTO `district` VALUES ('1280', '邹平县', '151');
INSERT INTO `district` VALUES ('1281', '牡丹区', '152');
INSERT INTO `district` VALUES ('1282', '定陶区', '152');
INSERT INTO `district` VALUES ('1283', '曹县', '152');
INSERT INTO `district` VALUES ('1284', '单县', '152');
INSERT INTO `district` VALUES ('1285', '成武县', '152');
INSERT INTO `district` VALUES ('1286', '巨野县', '152');
INSERT INTO `district` VALUES ('1287', '郓城县', '152');
INSERT INTO `district` VALUES ('1288', '鄄城县', '152');
INSERT INTO `district` VALUES ('1289', '东明县', '152');
INSERT INTO `district` VALUES ('1290', '中原区', '153');
INSERT INTO `district` VALUES ('1291', '二七区', '153');
INSERT INTO `district` VALUES ('1292', '管城回族区', '153');
INSERT INTO `district` VALUES ('1293', '金水区', '153');
INSERT INTO `district` VALUES ('1294', '上街区', '153');
INSERT INTO `district` VALUES ('1295', '惠济区', '153');
INSERT INTO `district` VALUES ('1296', '中牟县', '153');
INSERT INTO `district` VALUES ('1297', '巩义市', '153');
INSERT INTO `district` VALUES ('1298', '荥阳市', '153');
INSERT INTO `district` VALUES ('1299', '新密市', '153');
INSERT INTO `district` VALUES ('1300', '新郑市', '153');
INSERT INTO `district` VALUES ('1301', '登封市', '153');
INSERT INTO `district` VALUES ('1302', '龙亭区', '154');
INSERT INTO `district` VALUES ('1303', '顺河回族区', '154');
INSERT INTO `district` VALUES ('1304', '鼓楼区', '154');
INSERT INTO `district` VALUES ('1305', '禹王台区', '154');
INSERT INTO `district` VALUES ('1306', '祥符区', '154');
INSERT INTO `district` VALUES ('1307', '杞县', '154');
INSERT INTO `district` VALUES ('1308', '通许县', '154');
INSERT INTO `district` VALUES ('1309', '尉氏县', '154');
INSERT INTO `district` VALUES ('1310', '兰考县', '154');
INSERT INTO `district` VALUES ('1311', '老城区', '155');
INSERT INTO `district` VALUES ('1312', '西工区', '155');
INSERT INTO `district` VALUES ('1313', '瀍河回族区', '155');
INSERT INTO `district` VALUES ('1314', '涧西区', '155');
INSERT INTO `district` VALUES ('1315', '吉利区', '155');
INSERT INTO `district` VALUES ('1316', '洛龙区', '155');
INSERT INTO `district` VALUES ('1317', '孟津县', '155');
INSERT INTO `district` VALUES ('1318', '新安县', '155');
INSERT INTO `district` VALUES ('1319', '栾川县', '155');
INSERT INTO `district` VALUES ('1320', '嵩县', '155');
INSERT INTO `district` VALUES ('1321', '汝阳县', '155');
INSERT INTO `district` VALUES ('1322', '宜阳县', '155');
INSERT INTO `district` VALUES ('1323', '洛宁县', '155');
INSERT INTO `district` VALUES ('1324', '伊川县', '155');
INSERT INTO `district` VALUES ('1325', '偃师市', '155');
INSERT INTO `district` VALUES ('1326', '新华区', '156');
INSERT INTO `district` VALUES ('1327', '卫东区', '156');
INSERT INTO `district` VALUES ('1328', '石龙区', '156');
INSERT INTO `district` VALUES ('1329', '湛河区', '156');
INSERT INTO `district` VALUES ('1330', '宝丰县', '156');
INSERT INTO `district` VALUES ('1331', '叶县', '156');
INSERT INTO `district` VALUES ('1332', '鲁山县', '156');
INSERT INTO `district` VALUES ('1333', '郏县', '156');
INSERT INTO `district` VALUES ('1334', '舞钢市', '156');
INSERT INTO `district` VALUES ('1335', '汝州市', '156');
INSERT INTO `district` VALUES ('1336', '文峰区', '157');
INSERT INTO `district` VALUES ('1337', '北关区', '157');
INSERT INTO `district` VALUES ('1338', '殷都区', '157');
INSERT INTO `district` VALUES ('1339', '龙安区', '157');
INSERT INTO `district` VALUES ('1340', '安阳县', '157');
INSERT INTO `district` VALUES ('1341', '汤阴县', '157');
INSERT INTO `district` VALUES ('1342', '滑县', '157');
INSERT INTO `district` VALUES ('1343', '内黄县', '157');
INSERT INTO `district` VALUES ('1344', '林州市', '157');
INSERT INTO `district` VALUES ('1345', '鹤山区', '158');
INSERT INTO `district` VALUES ('1346', '山城区', '158');
INSERT INTO `district` VALUES ('1347', '淇滨区', '158');
INSERT INTO `district` VALUES ('1348', '浚县', '158');
INSERT INTO `district` VALUES ('1349', '淇县', '158');
INSERT INTO `district` VALUES ('1350', '红旗区', '159');
INSERT INTO `district` VALUES ('1351', '卫滨区', '159');
INSERT INTO `district` VALUES ('1352', '凤泉区', '159');
INSERT INTO `district` VALUES ('1353', '牧野区', '159');
INSERT INTO `district` VALUES ('1354', '新乡县', '159');
INSERT INTO `district` VALUES ('1355', '获嘉县', '159');
INSERT INTO `district` VALUES ('1356', '原阳县', '159');
INSERT INTO `district` VALUES ('1357', '延津县', '159');
INSERT INTO `district` VALUES ('1358', '封丘县', '159');
INSERT INTO `district` VALUES ('1359', '长垣县', '159');
INSERT INTO `district` VALUES ('1360', '卫辉市', '159');
INSERT INTO `district` VALUES ('1361', '辉县市', '159');
INSERT INTO `district` VALUES ('1362', '解放区', '160');
INSERT INTO `district` VALUES ('1363', '中站区', '160');
INSERT INTO `district` VALUES ('1364', '马村区', '160');
INSERT INTO `district` VALUES ('1365', '山阳区', '160');
INSERT INTO `district` VALUES ('1366', '修武县', '160');
INSERT INTO `district` VALUES ('1367', '博爱县', '160');
INSERT INTO `district` VALUES ('1368', '武陟县', '160');
INSERT INTO `district` VALUES ('1369', '温县', '160');
INSERT INTO `district` VALUES ('1370', '沁阳市', '160');
INSERT INTO `district` VALUES ('1371', '孟州市', '160');
INSERT INTO `district` VALUES ('1372', '华龙区', '161');
INSERT INTO `district` VALUES ('1373', '清丰县', '161');
INSERT INTO `district` VALUES ('1374', '南乐县', '161');
INSERT INTO `district` VALUES ('1375', '范县', '161');
INSERT INTO `district` VALUES ('1376', '台前县', '161');
INSERT INTO `district` VALUES ('1377', '濮阳县', '161');
INSERT INTO `district` VALUES ('1378', '魏都区', '162');
INSERT INTO `district` VALUES ('1379', '建安区', '162');
INSERT INTO `district` VALUES ('1380', '鄢陵县', '162');
INSERT INTO `district` VALUES ('1381', '襄城县', '162');
INSERT INTO `district` VALUES ('1382', '禹州市', '162');
INSERT INTO `district` VALUES ('1383', '长葛市', '162');
INSERT INTO `district` VALUES ('1384', '源汇区', '163');
INSERT INTO `district` VALUES ('1385', '郾城区', '163');
INSERT INTO `district` VALUES ('1386', '召陵区', '163');
INSERT INTO `district` VALUES ('1387', '舞阳县', '163');
INSERT INTO `district` VALUES ('1388', '临颍县', '163');
INSERT INTO `district` VALUES ('1389', '湖滨区', '164');
INSERT INTO `district` VALUES ('1390', '陕州区', '164');
INSERT INTO `district` VALUES ('1391', '渑池县', '164');
INSERT INTO `district` VALUES ('1392', '卢氏县', '164');
INSERT INTO `district` VALUES ('1393', '义马市', '164');
INSERT INTO `district` VALUES ('1394', '灵宝市', '164');
INSERT INTO `district` VALUES ('1395', '宛城区', '165');
INSERT INTO `district` VALUES ('1396', '卧龙区', '165');
INSERT INTO `district` VALUES ('1397', '南召县', '165');
INSERT INTO `district` VALUES ('1398', '方城县', '165');
INSERT INTO `district` VALUES ('1399', '西峡县', '165');
INSERT INTO `district` VALUES ('1400', '镇平县', '165');
INSERT INTO `district` VALUES ('1401', '内乡县', '165');
INSERT INTO `district` VALUES ('1402', '淅川县', '165');
INSERT INTO `district` VALUES ('1403', '社旗县', '165');
INSERT INTO `district` VALUES ('1404', '唐河县', '165');
INSERT INTO `district` VALUES ('1405', '新野县', '165');
INSERT INTO `district` VALUES ('1406', '桐柏县', '165');
INSERT INTO `district` VALUES ('1407', '邓州市', '165');
INSERT INTO `district` VALUES ('1408', '梁园区', '166');
INSERT INTO `district` VALUES ('1409', '睢阳区', '166');
INSERT INTO `district` VALUES ('1410', '民权县', '166');
INSERT INTO `district` VALUES ('1411', '睢县', '166');
INSERT INTO `district` VALUES ('1412', '宁陵县', '166');
INSERT INTO `district` VALUES ('1413', '柘城县', '166');
INSERT INTO `district` VALUES ('1414', '虞城县', '166');
INSERT INTO `district` VALUES ('1415', '夏邑县', '166');
INSERT INTO `district` VALUES ('1416', '永城市', '166');
INSERT INTO `district` VALUES ('1417', '浉河区', '167');
INSERT INTO `district` VALUES ('1418', '平桥区', '167');
INSERT INTO `district` VALUES ('1419', '罗山县', '167');
INSERT INTO `district` VALUES ('1420', '光山县', '167');
INSERT INTO `district` VALUES ('1421', '新县', '167');
INSERT INTO `district` VALUES ('1422', '商城县', '167');
INSERT INTO `district` VALUES ('1423', '固始县', '167');
INSERT INTO `district` VALUES ('1424', '潢川县', '167');
INSERT INTO `district` VALUES ('1425', '淮滨县', '167');
INSERT INTO `district` VALUES ('1426', '息县', '167');
INSERT INTO `district` VALUES ('1427', '川汇区', '168');
INSERT INTO `district` VALUES ('1428', '扶沟县', '168');
INSERT INTO `district` VALUES ('1429', '西华县', '168');
INSERT INTO `district` VALUES ('1430', '商水县', '168');
INSERT INTO `district` VALUES ('1431', '沈丘县', '168');
INSERT INTO `district` VALUES ('1432', '郸城县', '168');
INSERT INTO `district` VALUES ('1433', '淮阳县', '168');
INSERT INTO `district` VALUES ('1434', '太康县', '168');
INSERT INTO `district` VALUES ('1435', '鹿邑县', '168');
INSERT INTO `district` VALUES ('1436', '项城市', '168');
INSERT INTO `district` VALUES ('1437', '驿城区', '169');
INSERT INTO `district` VALUES ('1438', '西平县', '169');
INSERT INTO `district` VALUES ('1439', '上蔡县', '169');
INSERT INTO `district` VALUES ('1440', '平舆县', '169');
INSERT INTO `district` VALUES ('1441', '正阳县', '169');
INSERT INTO `district` VALUES ('1442', '确山县', '169');
INSERT INTO `district` VALUES ('1443', '泌阳县', '169');
INSERT INTO `district` VALUES ('1444', '汝南县', '169');
INSERT INTO `district` VALUES ('1445', '遂平县', '169');
INSERT INTO `district` VALUES ('1446', '新蔡县', '169');
INSERT INTO `district` VALUES ('1447', '江岸区', '171');
INSERT INTO `district` VALUES ('1448', '江汉区', '171');
INSERT INTO `district` VALUES ('1449', '硚口区', '171');
INSERT INTO `district` VALUES ('1450', '汉阳区', '171');
INSERT INTO `district` VALUES ('1451', '武昌区', '171');
INSERT INTO `district` VALUES ('1452', '青山区', '171');
INSERT INTO `district` VALUES ('1453', '洪山区', '171');
INSERT INTO `district` VALUES ('1454', '东西湖区', '171');
INSERT INTO `district` VALUES ('1455', '汉南区', '171');
INSERT INTO `district` VALUES ('1456', '蔡甸区', '171');
INSERT INTO `district` VALUES ('1457', '江夏区', '171');
INSERT INTO `district` VALUES ('1458', '黄陂区', '171');
INSERT INTO `district` VALUES ('1459', '新洲区', '171');
INSERT INTO `district` VALUES ('1460', '黄石港区', '172');
INSERT INTO `district` VALUES ('1461', '西塞山区', '172');
INSERT INTO `district` VALUES ('1462', '下陆区', '172');
INSERT INTO `district` VALUES ('1463', '铁山区', '172');
INSERT INTO `district` VALUES ('1464', '阳新县', '172');
INSERT INTO `district` VALUES ('1465', '大冶市', '172');
INSERT INTO `district` VALUES ('1466', '茅箭区', '173');
INSERT INTO `district` VALUES ('1467', '张湾区', '173');
INSERT INTO `district` VALUES ('1468', '郧阳区', '173');
INSERT INTO `district` VALUES ('1469', '郧西县', '173');
INSERT INTO `district` VALUES ('1470', '竹山县', '173');
INSERT INTO `district` VALUES ('1471', '竹溪县', '173');
INSERT INTO `district` VALUES ('1472', '房县', '173');
INSERT INTO `district` VALUES ('1473', '丹江口市', '173');
INSERT INTO `district` VALUES ('1474', '西陵区', '174');
INSERT INTO `district` VALUES ('1475', '伍家岗区', '174');
INSERT INTO `district` VALUES ('1476', '点军区', '174');
INSERT INTO `district` VALUES ('1477', '猇亭区', '174');
INSERT INTO `district` VALUES ('1478', '夷陵区', '174');
INSERT INTO `district` VALUES ('1479', '远安县', '174');
INSERT INTO `district` VALUES ('1480', '兴山县', '174');
INSERT INTO `district` VALUES ('1481', '秭归县', '174');
INSERT INTO `district` VALUES ('1482', '长阳土家族自治县', '174');
INSERT INTO `district` VALUES ('1483', '五峰土家族自治县', '174');
INSERT INTO `district` VALUES ('1484', '宜都市', '174');
INSERT INTO `district` VALUES ('1485', '当阳市', '174');
INSERT INTO `district` VALUES ('1486', '枝江市', '174');
INSERT INTO `district` VALUES ('1487', '襄城区', '175');
INSERT INTO `district` VALUES ('1488', '樊城区', '175');
INSERT INTO `district` VALUES ('1489', '襄州区', '175');
INSERT INTO `district` VALUES ('1490', '南漳县', '175');
INSERT INTO `district` VALUES ('1491', '谷城县', '175');
INSERT INTO `district` VALUES ('1492', '保康县', '175');
INSERT INTO `district` VALUES ('1493', '老河口市', '175');
INSERT INTO `district` VALUES ('1494', '枣阳市', '175');
INSERT INTO `district` VALUES ('1495', '宜城市', '175');
INSERT INTO `district` VALUES ('1496', '梁子湖区', '176');
INSERT INTO `district` VALUES ('1497', '华容区', '176');
INSERT INTO `district` VALUES ('1498', '鄂城区', '176');
INSERT INTO `district` VALUES ('1499', '东宝区', '177');
INSERT INTO `district` VALUES ('1500', '掇刀区', '177');
INSERT INTO `district` VALUES ('1501', '京山县', '177');
INSERT INTO `district` VALUES ('1502', '沙洋县', '177');
INSERT INTO `district` VALUES ('1503', '钟祥市', '177');
INSERT INTO `district` VALUES ('1504', '孝南区', '178');
INSERT INTO `district` VALUES ('1505', '孝昌县', '178');
INSERT INTO `district` VALUES ('1506', '大悟县', '178');
INSERT INTO `district` VALUES ('1507', '云梦县', '178');
INSERT INTO `district` VALUES ('1508', '应城市', '178');
INSERT INTO `district` VALUES ('1509', '安陆市', '178');
INSERT INTO `district` VALUES ('1510', '汉川市', '178');
INSERT INTO `district` VALUES ('1511', '沙市区', '179');
INSERT INTO `district` VALUES ('1512', '荆州区', '179');
INSERT INTO `district` VALUES ('1513', '公安县', '179');
INSERT INTO `district` VALUES ('1514', '监利县', '179');
INSERT INTO `district` VALUES ('1515', '江陵县', '179');
INSERT INTO `district` VALUES ('1516', '石首市', '179');
INSERT INTO `district` VALUES ('1517', '洪湖市', '179');
INSERT INTO `district` VALUES ('1518', '松滋市', '179');
INSERT INTO `district` VALUES ('1519', '黄州区', '180');
INSERT INTO `district` VALUES ('1520', '团风县', '180');
INSERT INTO `district` VALUES ('1521', '红安县', '180');
INSERT INTO `district` VALUES ('1522', '罗田县', '180');
INSERT INTO `district` VALUES ('1523', '英山县', '180');
INSERT INTO `district` VALUES ('1524', '浠水县', '180');
INSERT INTO `district` VALUES ('1525', '蕲春县', '180');
INSERT INTO `district` VALUES ('1526', '黄梅县', '180');
INSERT INTO `district` VALUES ('1527', '麻城市', '180');
INSERT INTO `district` VALUES ('1528', '武穴市', '180');
INSERT INTO `district` VALUES ('1529', '咸安区', '181');
INSERT INTO `district` VALUES ('1530', '嘉鱼县', '181');
INSERT INTO `district` VALUES ('1531', '通城县', '181');
INSERT INTO `district` VALUES ('1532', '崇阳县', '181');
INSERT INTO `district` VALUES ('1533', '通山县', '181');
INSERT INTO `district` VALUES ('1534', '赤壁市', '181');
INSERT INTO `district` VALUES ('1535', '曾都区', '182');
INSERT INTO `district` VALUES ('1536', '随县', '182');
INSERT INTO `district` VALUES ('1537', '广水市', '182');
INSERT INTO `district` VALUES ('1538', '恩施市', '183');
INSERT INTO `district` VALUES ('1539', '利川市', '183');
INSERT INTO `district` VALUES ('1540', '建始县', '183');
INSERT INTO `district` VALUES ('1541', '巴东县', '183');
INSERT INTO `district` VALUES ('1542', '宣恩县', '183');
INSERT INTO `district` VALUES ('1543', '咸丰县', '183');
INSERT INTO `district` VALUES ('1544', '来凤县', '183');
INSERT INTO `district` VALUES ('1545', '鹤峰县', '183');
INSERT INTO `district` VALUES ('1546', '芙蓉区', '188');
INSERT INTO `district` VALUES ('1547', '天心区', '188');
INSERT INTO `district` VALUES ('1548', '岳麓区', '188');
INSERT INTO `district` VALUES ('1549', '开福区', '188');
INSERT INTO `district` VALUES ('1550', '雨花区', '188');
INSERT INTO `district` VALUES ('1551', '望城区', '188');
INSERT INTO `district` VALUES ('1552', '长沙县', '188');
INSERT INTO `district` VALUES ('1553', '浏阳市', '188');
INSERT INTO `district` VALUES ('1554', '宁乡市', '188');
INSERT INTO `district` VALUES ('1555', '荷塘区', '189');
INSERT INTO `district` VALUES ('1556', '芦淞区', '189');
INSERT INTO `district` VALUES ('1557', '石峰区', '189');
INSERT INTO `district` VALUES ('1558', '天元区', '189');
INSERT INTO `district` VALUES ('1559', '株洲县', '189');
INSERT INTO `district` VALUES ('1560', '攸县', '189');
INSERT INTO `district` VALUES ('1561', '茶陵县', '189');
INSERT INTO `district` VALUES ('1562', '炎陵县', '189');
INSERT INTO `district` VALUES ('1563', '醴陵市', '189');
INSERT INTO `district` VALUES ('1564', '雨湖区', '190');
INSERT INTO `district` VALUES ('1565', '岳塘区', '190');
INSERT INTO `district` VALUES ('1566', '湘潭县', '190');
INSERT INTO `district` VALUES ('1567', '湘乡市', '190');
INSERT INTO `district` VALUES ('1568', '韶山市', '190');
INSERT INTO `district` VALUES ('1569', '珠晖区', '191');
INSERT INTO `district` VALUES ('1570', '雁峰区', '191');
INSERT INTO `district` VALUES ('1571', '石鼓区', '191');
INSERT INTO `district` VALUES ('1572', '蒸湘区', '191');
INSERT INTO `district` VALUES ('1573', '南岳区', '191');
INSERT INTO `district` VALUES ('1574', '衡阳县', '191');
INSERT INTO `district` VALUES ('1575', '衡南县', '191');
INSERT INTO `district` VALUES ('1576', '衡山县', '191');
INSERT INTO `district` VALUES ('1577', '衡东县', '191');
INSERT INTO `district` VALUES ('1578', '祁东县', '191');
INSERT INTO `district` VALUES ('1579', '耒阳市', '191');
INSERT INTO `district` VALUES ('1580', '常宁市', '191');
INSERT INTO `district` VALUES ('1581', '双清区', '192');
INSERT INTO `district` VALUES ('1582', '大祥区', '192');
INSERT INTO `district` VALUES ('1583', '北塔区', '192');
INSERT INTO `district` VALUES ('1584', '邵东县', '192');
INSERT INTO `district` VALUES ('1585', '新邵县', '192');
INSERT INTO `district` VALUES ('1586', '邵阳县', '192');
INSERT INTO `district` VALUES ('1587', '隆回县', '192');
INSERT INTO `district` VALUES ('1588', '洞口县', '192');
INSERT INTO `district` VALUES ('1589', '绥宁县', '192');
INSERT INTO `district` VALUES ('1590', '新宁县', '192');
INSERT INTO `district` VALUES ('1591', '城步苗族自治县', '192');
INSERT INTO `district` VALUES ('1592', '武冈市', '192');
INSERT INTO `district` VALUES ('1593', '岳阳楼区', '193');
INSERT INTO `district` VALUES ('1594', '云溪区', '193');
INSERT INTO `district` VALUES ('1595', '君山区', '193');
INSERT INTO `district` VALUES ('1596', '岳阳县', '193');
INSERT INTO `district` VALUES ('1597', '华容县', '193');
INSERT INTO `district` VALUES ('1598', '湘阴县', '193');
INSERT INTO `district` VALUES ('1599', '平江县', '193');
INSERT INTO `district` VALUES ('1600', '汨罗市', '193');
INSERT INTO `district` VALUES ('1601', '临湘市', '193');
INSERT INTO `district` VALUES ('1602', '武陵区', '194');
INSERT INTO `district` VALUES ('1603', '鼎城区', '194');
INSERT INTO `district` VALUES ('1604', '安乡县', '194');
INSERT INTO `district` VALUES ('1605', '汉寿县', '194');
INSERT INTO `district` VALUES ('1606', '澧县', '194');
INSERT INTO `district` VALUES ('1607', '临澧县', '194');
INSERT INTO `district` VALUES ('1608', '桃源县', '194');
INSERT INTO `district` VALUES ('1609', '石门县', '194');
INSERT INTO `district` VALUES ('1610', '津市市', '194');
INSERT INTO `district` VALUES ('1611', '永定区', '195');
INSERT INTO `district` VALUES ('1612', '武陵源区', '195');
INSERT INTO `district` VALUES ('1613', '慈利县', '195');
INSERT INTO `district` VALUES ('1614', '桑植县', '195');
INSERT INTO `district` VALUES ('1615', '资阳区', '196');
INSERT INTO `district` VALUES ('1616', '赫山区', '196');
INSERT INTO `district` VALUES ('1617', '南县', '196');
INSERT INTO `district` VALUES ('1618', '桃江县', '196');
INSERT INTO `district` VALUES ('1619', '安化县', '196');
INSERT INTO `district` VALUES ('1620', '沅江市', '196');
INSERT INTO `district` VALUES ('1621', '北湖区', '197');
INSERT INTO `district` VALUES ('1622', '苏仙区', '197');
INSERT INTO `district` VALUES ('1623', '桂阳县', '197');
INSERT INTO `district` VALUES ('1624', '宜章县', '197');
INSERT INTO `district` VALUES ('1625', '永兴县', '197');
INSERT INTO `district` VALUES ('1626', '嘉禾县', '197');
INSERT INTO `district` VALUES ('1627', '临武县', '197');
INSERT INTO `district` VALUES ('1628', '汝城县', '197');
INSERT INTO `district` VALUES ('1629', '桂东县', '197');
INSERT INTO `district` VALUES ('1630', '安仁县', '197');
INSERT INTO `district` VALUES ('1631', '资兴市', '197');
INSERT INTO `district` VALUES ('1632', '零陵区', '198');
INSERT INTO `district` VALUES ('1633', '冷水滩区', '198');
INSERT INTO `district` VALUES ('1634', '祁阳县', '198');
INSERT INTO `district` VALUES ('1635', '东安县', '198');
INSERT INTO `district` VALUES ('1636', '双牌县', '198');
INSERT INTO `district` VALUES ('1637', '道县', '198');
INSERT INTO `district` VALUES ('1638', '江永县', '198');
INSERT INTO `district` VALUES ('1639', '宁远县', '198');
INSERT INTO `district` VALUES ('1640', '蓝山县', '198');
INSERT INTO `district` VALUES ('1641', '新田县', '198');
INSERT INTO `district` VALUES ('1642', '江华瑶族自治县', '198');
INSERT INTO `district` VALUES ('1643', '鹤城区', '199');
INSERT INTO `district` VALUES ('1644', '中方县', '199');
INSERT INTO `district` VALUES ('1645', '沅陵县', '199');
INSERT INTO `district` VALUES ('1646', '辰溪县', '199');
INSERT INTO `district` VALUES ('1647', '溆浦县', '199');
INSERT INTO `district` VALUES ('1648', '会同县', '199');
INSERT INTO `district` VALUES ('1649', '麻阳苗族自治县', '199');
INSERT INTO `district` VALUES ('1650', '新晃侗族自治县', '199');
INSERT INTO `district` VALUES ('1651', '芷江侗族自治县', '199');
INSERT INTO `district` VALUES ('1652', '靖州苗族侗族自治县', '199');
INSERT INTO `district` VALUES ('1653', '通道侗族自治县', '199');
INSERT INTO `district` VALUES ('1654', '洪江市', '199');
INSERT INTO `district` VALUES ('1655', '娄星区', '200');
INSERT INTO `district` VALUES ('1656', '双峰县', '200');
INSERT INTO `district` VALUES ('1657', '新化县', '200');
INSERT INTO `district` VALUES ('1658', '冷水江市', '200');
INSERT INTO `district` VALUES ('1659', '涟源市', '200');
INSERT INTO `district` VALUES ('1660', '吉首市', '201');
INSERT INTO `district` VALUES ('1661', '泸溪县', '201');
INSERT INTO `district` VALUES ('1662', '凤凰县', '201');
INSERT INTO `district` VALUES ('1663', '花垣县', '201');
INSERT INTO `district` VALUES ('1664', '保靖县', '201');
INSERT INTO `district` VALUES ('1665', '古丈县', '201');
INSERT INTO `district` VALUES ('1666', '永顺县', '201');
INSERT INTO `district` VALUES ('1667', '龙山县', '201');
INSERT INTO `district` VALUES ('1668', '荔湾区', '202');
INSERT INTO `district` VALUES ('1669', '越秀区', '202');
INSERT INTO `district` VALUES ('1670', '海珠区', '202');
INSERT INTO `district` VALUES ('1671', '天河区', '202');
INSERT INTO `district` VALUES ('1672', '白云区', '202');
INSERT INTO `district` VALUES ('1673', '黄埔区', '202');
INSERT INTO `district` VALUES ('1674', '番禺区', '202');
INSERT INTO `district` VALUES ('1675', '花都区', '202');
INSERT INTO `district` VALUES ('1676', '南沙区', '202');
INSERT INTO `district` VALUES ('1677', '从化区', '202');
INSERT INTO `district` VALUES ('1678', '增城区', '202');
INSERT INTO `district` VALUES ('1679', '武江区', '203');
INSERT INTO `district` VALUES ('1680', '浈江区', '203');
INSERT INTO `district` VALUES ('1681', '曲江区', '203');
INSERT INTO `district` VALUES ('1682', '始兴县', '203');
INSERT INTO `district` VALUES ('1683', '仁化县', '203');
INSERT INTO `district` VALUES ('1684', '翁源县', '203');
INSERT INTO `district` VALUES ('1685', '乳源瑶族自治县', '203');
INSERT INTO `district` VALUES ('1686', '新丰县', '203');
INSERT INTO `district` VALUES ('1687', '乐昌市', '203');
INSERT INTO `district` VALUES ('1688', '南雄市', '203');
INSERT INTO `district` VALUES ('1689', '罗湖区', '204');
INSERT INTO `district` VALUES ('1690', '福田区', '204');
INSERT INTO `district` VALUES ('1691', '南山区', '204');
INSERT INTO `district` VALUES ('1692', '宝安区', '204');
INSERT INTO `district` VALUES ('1693', '龙岗区', '204');
INSERT INTO `district` VALUES ('1694', '盐田区', '204');
INSERT INTO `district` VALUES ('1695', '龙华区', '204');
INSERT INTO `district` VALUES ('1696', '坪山区', '204');
INSERT INTO `district` VALUES ('1697', '香洲区', '205');
INSERT INTO `district` VALUES ('1698', '斗门区', '205');
INSERT INTO `district` VALUES ('1699', '金湾区', '205');
INSERT INTO `district` VALUES ('1700', '香洲区(由澳门特别行政区实施管辖)', '205');
INSERT INTO `district` VALUES ('1701', '龙湖区', '206');
INSERT INTO `district` VALUES ('1702', '金平区', '206');
INSERT INTO `district` VALUES ('1703', '濠江区', '206');
INSERT INTO `district` VALUES ('1704', '潮阳区', '206');
INSERT INTO `district` VALUES ('1705', '潮南区', '206');
INSERT INTO `district` VALUES ('1706', '澄海区', '206');
INSERT INTO `district` VALUES ('1707', '南澳县', '206');
INSERT INTO `district` VALUES ('1708', '禅城区', '207');
INSERT INTO `district` VALUES ('1709', '南海区', '207');
INSERT INTO `district` VALUES ('1710', '顺德区', '207');
INSERT INTO `district` VALUES ('1711', '三水区', '207');
INSERT INTO `district` VALUES ('1712', '高明区', '207');
INSERT INTO `district` VALUES ('1713', '蓬江区', '208');
INSERT INTO `district` VALUES ('1714', '江海区', '208');
INSERT INTO `district` VALUES ('1715', '新会区', '208');
INSERT INTO `district` VALUES ('1716', '台山市', '208');
INSERT INTO `district` VALUES ('1717', '开平市', '208');
INSERT INTO `district` VALUES ('1718', '鹤山市', '208');
INSERT INTO `district` VALUES ('1719', '恩平市', '208');
INSERT INTO `district` VALUES ('1720', '赤坎区', '209');
INSERT INTO `district` VALUES ('1721', '霞山区', '209');
INSERT INTO `district` VALUES ('1722', '坡头区', '209');
INSERT INTO `district` VALUES ('1723', '麻章区', '209');
INSERT INTO `district` VALUES ('1724', '遂溪县', '209');
INSERT INTO `district` VALUES ('1725', '徐闻县', '209');
INSERT INTO `district` VALUES ('1726', '廉江市', '209');
INSERT INTO `district` VALUES ('1727', '雷州市', '209');
INSERT INTO `district` VALUES ('1728', '吴川市', '209');
INSERT INTO `district` VALUES ('1729', '茂南区', '210');
INSERT INTO `district` VALUES ('1730', '电白区', '210');
INSERT INTO `district` VALUES ('1731', '高州市', '210');
INSERT INTO `district` VALUES ('1732', '化州市', '210');
INSERT INTO `district` VALUES ('1733', '信宜市', '210');
INSERT INTO `district` VALUES ('1734', '端州区', '211');
INSERT INTO `district` VALUES ('1735', '鼎湖区', '211');
INSERT INTO `district` VALUES ('1736', '高要区', '211');
INSERT INTO `district` VALUES ('1737', '广宁县', '211');
INSERT INTO `district` VALUES ('1738', '怀集县', '211');
INSERT INTO `district` VALUES ('1739', '封开县', '211');
INSERT INTO `district` VALUES ('1740', '德庆县', '211');
INSERT INTO `district` VALUES ('1741', '四会市', '211');
INSERT INTO `district` VALUES ('1742', '惠城区', '212');
INSERT INTO `district` VALUES ('1743', '惠阳区', '212');
INSERT INTO `district` VALUES ('1744', '博罗县', '212');
INSERT INTO `district` VALUES ('1745', '惠东县', '212');
INSERT INTO `district` VALUES ('1746', '龙门县', '212');
INSERT INTO `district` VALUES ('1747', '梅江区', '213');
INSERT INTO `district` VALUES ('1748', '梅县区', '213');
INSERT INTO `district` VALUES ('1749', '大埔县', '213');
INSERT INTO `district` VALUES ('1750', '丰顺县', '213');
INSERT INTO `district` VALUES ('1751', '五华县', '213');
INSERT INTO `district` VALUES ('1752', '平远县', '213');
INSERT INTO `district` VALUES ('1753', '蕉岭县', '213');
INSERT INTO `district` VALUES ('1754', '兴宁市', '213');
INSERT INTO `district` VALUES ('1755', '城区', '214');
INSERT INTO `district` VALUES ('1756', '海丰县', '214');
INSERT INTO `district` VALUES ('1757', '陆河县', '214');
INSERT INTO `district` VALUES ('1758', '陆丰市', '214');
INSERT INTO `district` VALUES ('1759', '源城区', '215');
INSERT INTO `district` VALUES ('1760', '紫金县', '215');
INSERT INTO `district` VALUES ('1761', '龙川县', '215');
INSERT INTO `district` VALUES ('1762', '连平县', '215');
INSERT INTO `district` VALUES ('1763', '和平县', '215');
INSERT INTO `district` VALUES ('1764', '东源县', '215');
INSERT INTO `district` VALUES ('1765', '江城区', '216');
INSERT INTO `district` VALUES ('1766', '阳东区', '216');
INSERT INTO `district` VALUES ('1767', '阳西县', '216');
INSERT INTO `district` VALUES ('1768', '阳春市', '216');
INSERT INTO `district` VALUES ('1769', '清城区', '217');
INSERT INTO `district` VALUES ('1770', '清新区', '217');
INSERT INTO `district` VALUES ('1771', '佛冈县', '217');
INSERT INTO `district` VALUES ('1772', '阳山县', '217');
INSERT INTO `district` VALUES ('1773', '连山壮族瑶族自治县', '217');
INSERT INTO `district` VALUES ('1774', '连南瑶族自治县', '217');
INSERT INTO `district` VALUES ('1775', '英德市', '217');
INSERT INTO `district` VALUES ('1776', '连州市', '217');
INSERT INTO `district` VALUES ('1777', '东莞市', '218');
INSERT INTO `district` VALUES ('1778', '中山市', '219');
INSERT INTO `district` VALUES ('1779', '湘桥区', '220');
INSERT INTO `district` VALUES ('1780', '潮安区', '220');
INSERT INTO `district` VALUES ('1781', '饶平县', '220');
INSERT INTO `district` VALUES ('1782', '榕城区', '221');
INSERT INTO `district` VALUES ('1783', '揭东区', '221');
INSERT INTO `district` VALUES ('1784', '揭西县', '221');
INSERT INTO `district` VALUES ('1785', '惠来县', '221');
INSERT INTO `district` VALUES ('1786', '普宁市', '221');
INSERT INTO `district` VALUES ('1787', '云城区', '222');
INSERT INTO `district` VALUES ('1788', '云安区', '222');
INSERT INTO `district` VALUES ('1789', '新兴县', '222');
INSERT INTO `district` VALUES ('1790', '郁南县', '222');
INSERT INTO `district` VALUES ('1791', '罗定市', '222');
INSERT INTO `district` VALUES ('1792', '兴宁区', '223');
INSERT INTO `district` VALUES ('1793', '青秀区', '223');
INSERT INTO `district` VALUES ('1794', '江南区', '223');
INSERT INTO `district` VALUES ('1795', '西乡塘区', '223');
INSERT INTO `district` VALUES ('1796', '良庆区', '223');
INSERT INTO `district` VALUES ('1797', '邕宁区', '223');
INSERT INTO `district` VALUES ('1798', '武鸣区', '223');
INSERT INTO `district` VALUES ('1799', '隆安县', '223');
INSERT INTO `district` VALUES ('1800', '马山县', '223');
INSERT INTO `district` VALUES ('1801', '上林县', '223');
INSERT INTO `district` VALUES ('1802', '宾阳县', '223');
INSERT INTO `district` VALUES ('1803', '横县', '223');
INSERT INTO `district` VALUES ('1804', '城中区', '224');
INSERT INTO `district` VALUES ('1805', '鱼峰区', '224');
INSERT INTO `district` VALUES ('1806', '柳南区', '224');
INSERT INTO `district` VALUES ('1807', '柳北区', '224');
INSERT INTO `district` VALUES ('1808', '柳江区', '224');
INSERT INTO `district` VALUES ('1809', '柳城县', '224');
INSERT INTO `district` VALUES ('1810', '鹿寨县', '224');
INSERT INTO `district` VALUES ('1811', '融安县', '224');
INSERT INTO `district` VALUES ('1812', '融水苗族自治县', '224');
INSERT INTO `district` VALUES ('1813', '三江侗族自治县', '224');
INSERT INTO `district` VALUES ('1814', '秀峰区', '225');
INSERT INTO `district` VALUES ('1815', '叠彩区', '225');
INSERT INTO `district` VALUES ('1816', '象山区', '225');
INSERT INTO `district` VALUES ('1817', '七星区', '225');
INSERT INTO `district` VALUES ('1818', '雁山区', '225');
INSERT INTO `district` VALUES ('1819', '临桂区', '225');
INSERT INTO `district` VALUES ('1820', '阳朔县', '225');
INSERT INTO `district` VALUES ('1821', '灵川县', '225');
INSERT INTO `district` VALUES ('1822', '全州县', '225');
INSERT INTO `district` VALUES ('1823', '兴安县', '225');
INSERT INTO `district` VALUES ('1824', '永福县', '225');
INSERT INTO `district` VALUES ('1825', '灌阳县', '225');
INSERT INTO `district` VALUES ('1826', '龙胜各族自治县', '225');
INSERT INTO `district` VALUES ('1827', '资源县', '225');
INSERT INTO `district` VALUES ('1828', '平乐县', '225');
INSERT INTO `district` VALUES ('1829', '荔浦县', '225');
INSERT INTO `district` VALUES ('1830', '恭城瑶族自治县', '225');
INSERT INTO `district` VALUES ('1831', '万秀区', '226');
INSERT INTO `district` VALUES ('1832', '长洲区', '226');
INSERT INTO `district` VALUES ('1833', '龙圩区', '226');
INSERT INTO `district` VALUES ('1834', '苍梧县', '226');
INSERT INTO `district` VALUES ('1835', '藤县', '226');
INSERT INTO `district` VALUES ('1836', '蒙山县', '226');
INSERT INTO `district` VALUES ('1837', '岑溪市', '226');
INSERT INTO `district` VALUES ('1838', '海城区', '227');
INSERT INTO `district` VALUES ('1839', '银海区', '227');
INSERT INTO `district` VALUES ('1840', '铁山港区', '227');
INSERT INTO `district` VALUES ('1841', '合浦县', '227');
INSERT INTO `district` VALUES ('1842', '港口区', '228');
INSERT INTO `district` VALUES ('1843', '防城区', '228');
INSERT INTO `district` VALUES ('1844', '上思县', '228');
INSERT INTO `district` VALUES ('1845', '东兴市', '228');
INSERT INTO `district` VALUES ('1846', '钦南区', '229');
INSERT INTO `district` VALUES ('1847', '钦北区', '229');
INSERT INTO `district` VALUES ('1848', '灵山县', '229');
INSERT INTO `district` VALUES ('1849', '浦北县', '229');
INSERT INTO `district` VALUES ('1850', '港北区', '230');
INSERT INTO `district` VALUES ('1851', '港南区', '230');
INSERT INTO `district` VALUES ('1852', '覃塘区', '230');
INSERT INTO `district` VALUES ('1853', '平南县', '230');
INSERT INTO `district` VALUES ('1854', '桂平市', '230');
INSERT INTO `district` VALUES ('1855', '玉州区', '231');
INSERT INTO `district` VALUES ('1856', '福绵区', '231');
INSERT INTO `district` VALUES ('1857', '容县', '231');
INSERT INTO `district` VALUES ('1858', '陆川县', '231');
INSERT INTO `district` VALUES ('1859', '博白县', '231');
INSERT INTO `district` VALUES ('1860', '兴业县', '231');
INSERT INTO `district` VALUES ('1861', '北流市', '231');
INSERT INTO `district` VALUES ('1862', '右江区', '232');
INSERT INTO `district` VALUES ('1863', '田阳县', '232');
INSERT INTO `district` VALUES ('1864', '田东县', '232');
INSERT INTO `district` VALUES ('1865', '平果县', '232');
INSERT INTO `district` VALUES ('1866', '德保县', '232');
INSERT INTO `district` VALUES ('1867', '那坡县', '232');
INSERT INTO `district` VALUES ('1868', '凌云县', '232');
INSERT INTO `district` VALUES ('1869', '乐业县', '232');
INSERT INTO `district` VALUES ('1870', '田林县', '232');
INSERT INTO `district` VALUES ('1871', '西林县', '232');
INSERT INTO `district` VALUES ('1872', '隆林各族自治县', '232');
INSERT INTO `district` VALUES ('1873', '靖西市', '232');
INSERT INTO `district` VALUES ('1874', '八步区', '233');
INSERT INTO `district` VALUES ('1875', '平桂区', '233');
INSERT INTO `district` VALUES ('1876', '昭平县', '233');
INSERT INTO `district` VALUES ('1877', '钟山县', '233');
INSERT INTO `district` VALUES ('1878', '富川瑶族自治县', '233');
INSERT INTO `district` VALUES ('1879', '金城江区', '234');
INSERT INTO `district` VALUES ('1880', '宜州区', '234');
INSERT INTO `district` VALUES ('1881', '南丹县', '234');
INSERT INTO `district` VALUES ('1882', '天峨县', '234');
INSERT INTO `district` VALUES ('1883', '凤山县', '234');
INSERT INTO `district` VALUES ('1884', '东兰县', '234');
INSERT INTO `district` VALUES ('1885', '罗城仫佬族自治县', '234');
INSERT INTO `district` VALUES ('1886', '环江毛南族自治县', '234');
INSERT INTO `district` VALUES ('1887', '巴马瑶族自治县', '234');
INSERT INTO `district` VALUES ('1888', '都安瑶族自治县', '234');
INSERT INTO `district` VALUES ('1889', '大化瑶族自治县', '234');
INSERT INTO `district` VALUES ('1890', '兴宾区', '235');
INSERT INTO `district` VALUES ('1891', '忻城县', '235');
INSERT INTO `district` VALUES ('1892', '象州县', '235');
INSERT INTO `district` VALUES ('1893', '武宣县', '235');
INSERT INTO `district` VALUES ('1894', '金秀瑶族自治县', '235');
INSERT INTO `district` VALUES ('1895', '合山市', '235');
INSERT INTO `district` VALUES ('1896', '江州区', '236');
INSERT INTO `district` VALUES ('1897', '扶绥县', '236');
INSERT INTO `district` VALUES ('1898', '宁明县', '236');
INSERT INTO `district` VALUES ('1899', '龙州县', '236');
INSERT INTO `district` VALUES ('1900', '大新县', '236');
INSERT INTO `district` VALUES ('1901', '天等县', '236');
INSERT INTO `district` VALUES ('1902', '凭祥市', '236');
INSERT INTO `district` VALUES ('1903', '秀英区', '237');
INSERT INTO `district` VALUES ('1904', '龙华区', '237');
INSERT INTO `district` VALUES ('1905', '琼山区', '237');
INSERT INTO `district` VALUES ('1906', '美兰区', '237');
INSERT INTO `district` VALUES ('1907', '海棠区', '238');
INSERT INTO `district` VALUES ('1908', '吉阳区', '238');
INSERT INTO `district` VALUES ('1909', '天涯区', '238');
INSERT INTO `district` VALUES ('1910', '崖州区', '238');
INSERT INTO `district` VALUES ('1911', '西沙群岛', '239');
INSERT INTO `district` VALUES ('1912', '南沙群岛', '239');
INSERT INTO `district` VALUES ('1913', '中沙群岛的岛礁及其海域', '239');
INSERT INTO `district` VALUES ('1914', '儋州市', '240');
INSERT INTO `district` VALUES ('1915', '锦江区', '257');
INSERT INTO `district` VALUES ('1916', '青羊区', '257');
INSERT INTO `district` VALUES ('1917', '金牛区', '257');
INSERT INTO `district` VALUES ('1918', '武侯区', '257');
INSERT INTO `district` VALUES ('1919', '成华区', '257');
INSERT INTO `district` VALUES ('1920', '龙泉驿区', '257');
INSERT INTO `district` VALUES ('1921', '青白江区', '257');
INSERT INTO `district` VALUES ('1922', '新都区', '257');
INSERT INTO `district` VALUES ('1923', '温江区', '257');
INSERT INTO `district` VALUES ('1924', '双流区', '257');
INSERT INTO `district` VALUES ('1925', '郫都区', '257');
INSERT INTO `district` VALUES ('1926', '金堂县', '257');
INSERT INTO `district` VALUES ('1927', '大邑县', '257');
INSERT INTO `district` VALUES ('1928', '蒲江县', '257');
INSERT INTO `district` VALUES ('1929', '新津县', '257');
INSERT INTO `district` VALUES ('1930', '都江堰市', '257');
INSERT INTO `district` VALUES ('1931', '彭州市', '257');
INSERT INTO `district` VALUES ('1932', '邛崃市', '257');
INSERT INTO `district` VALUES ('1933', '崇州市', '257');
INSERT INTO `district` VALUES ('1934', '简阳市', '257');
INSERT INTO `district` VALUES ('1935', '自流井区', '258');
INSERT INTO `district` VALUES ('1936', '贡井区', '258');
INSERT INTO `district` VALUES ('1937', '大安区', '258');
INSERT INTO `district` VALUES ('1938', '沿滩区', '258');
INSERT INTO `district` VALUES ('1939', '荣县', '258');
INSERT INTO `district` VALUES ('1940', '富顺县', '258');
INSERT INTO `district` VALUES ('1941', '东区', '259');
INSERT INTO `district` VALUES ('1942', '西区', '259');
INSERT INTO `district` VALUES ('1943', '仁和区', '259');
INSERT INTO `district` VALUES ('1944', '米易县', '259');
INSERT INTO `district` VALUES ('1945', '盐边县', '259');
INSERT INTO `district` VALUES ('1946', '江阳区', '260');
INSERT INTO `district` VALUES ('1947', '纳溪区', '260');
INSERT INTO `district` VALUES ('1948', '龙马潭区', '260');
INSERT INTO `district` VALUES ('1949', '泸县', '260');
INSERT INTO `district` VALUES ('1950', '合江县', '260');
INSERT INTO `district` VALUES ('1951', '叙永县', '260');
INSERT INTO `district` VALUES ('1952', '古蔺县', '260');
INSERT INTO `district` VALUES ('1953', '旌阳区', '261');
INSERT INTO `district` VALUES ('1954', '中江县', '261');
INSERT INTO `district` VALUES ('1955', '罗江县', '261');
INSERT INTO `district` VALUES ('1956', '广汉市', '261');
INSERT INTO `district` VALUES ('1957', '什邡市', '261');
INSERT INTO `district` VALUES ('1958', '绵竹市', '261');
INSERT INTO `district` VALUES ('1959', '涪城区', '262');
INSERT INTO `district` VALUES ('1960', '游仙区', '262');
INSERT INTO `district` VALUES ('1961', '安州区', '262');
INSERT INTO `district` VALUES ('1962', '三台县', '262');
INSERT INTO `district` VALUES ('1963', '盐亭县', '262');
INSERT INTO `district` VALUES ('1964', '梓潼县', '262');
INSERT INTO `district` VALUES ('1965', '北川羌族自治县', '262');
INSERT INTO `district` VALUES ('1966', '平武县', '262');
INSERT INTO `district` VALUES ('1967', '江油市', '262');
INSERT INTO `district` VALUES ('1968', '利州区', '263');
INSERT INTO `district` VALUES ('1969', '昭化区', '263');
INSERT INTO `district` VALUES ('1970', '朝天区', '263');
INSERT INTO `district` VALUES ('1971', '旺苍县', '263');
INSERT INTO `district` VALUES ('1972', '青川县', '263');
INSERT INTO `district` VALUES ('1973', '剑阁县', '263');
INSERT INTO `district` VALUES ('1974', '苍溪县', '263');
INSERT INTO `district` VALUES ('1975', '船山区', '264');
INSERT INTO `district` VALUES ('1976', '安居区', '264');
INSERT INTO `district` VALUES ('1977', '蓬溪县', '264');
INSERT INTO `district` VALUES ('1978', '射洪县', '264');
INSERT INTO `district` VALUES ('1979', '大英县', '264');
INSERT INTO `district` VALUES ('1980', '市中区', '265');
INSERT INTO `district` VALUES ('1981', '东兴区', '265');
INSERT INTO `district` VALUES ('1982', '威远县', '265');
INSERT INTO `district` VALUES ('1983', '资中县', '265');
INSERT INTO `district` VALUES ('1984', '隆昌市', '265');
INSERT INTO `district` VALUES ('1985', '市中区', '266');
INSERT INTO `district` VALUES ('1986', '沙湾区', '266');
INSERT INTO `district` VALUES ('1987', '五通桥区', '266');
INSERT INTO `district` VALUES ('1988', '金口河区', '266');
INSERT INTO `district` VALUES ('1989', '犍为县', '266');
INSERT INTO `district` VALUES ('1990', '井研县', '266');
INSERT INTO `district` VALUES ('1991', '夹江县', '266');
INSERT INTO `district` VALUES ('1992', '沐川县', '266');
INSERT INTO `district` VALUES ('1993', '峨边彝族自治县', '266');
INSERT INTO `district` VALUES ('1994', '马边彝族自治县', '266');
INSERT INTO `district` VALUES ('1995', '峨眉山市', '266');
INSERT INTO `district` VALUES ('1996', '顺庆区', '267');
INSERT INTO `district` VALUES ('1997', '高坪区', '267');
INSERT INTO `district` VALUES ('1998', '嘉陵区', '267');
INSERT INTO `district` VALUES ('1999', '南部县', '267');
INSERT INTO `district` VALUES ('2000', '营山县', '267');
INSERT INTO `district` VALUES ('2001', '蓬安县', '267');
INSERT INTO `district` VALUES ('2002', '仪陇县', '267');
INSERT INTO `district` VALUES ('2003', '西充县', '267');
INSERT INTO `district` VALUES ('2004', '阆中市', '267');
INSERT INTO `district` VALUES ('2005', '东坡区', '268');
INSERT INTO `district` VALUES ('2006', '彭山区', '268');
INSERT INTO `district` VALUES ('2007', '仁寿县', '268');
INSERT INTO `district` VALUES ('2008', '洪雅县', '268');
INSERT INTO `district` VALUES ('2009', '丹棱县', '268');
INSERT INTO `district` VALUES ('2010', '青神县', '268');
INSERT INTO `district` VALUES ('2011', '翠屏区', '269');
INSERT INTO `district` VALUES ('2012', '南溪区', '269');
INSERT INTO `district` VALUES ('2013', '宜宾县', '269');
INSERT INTO `district` VALUES ('2014', '江安县', '269');
INSERT INTO `district` VALUES ('2015', '长宁县', '269');
INSERT INTO `district` VALUES ('2016', '高县', '269');
INSERT INTO `district` VALUES ('2017', '珙县', '269');
INSERT INTO `district` VALUES ('2018', '筠连县', '269');
INSERT INTO `district` VALUES ('2019', '兴文县', '269');
INSERT INTO `district` VALUES ('2020', '屏山县', '269');
INSERT INTO `district` VALUES ('2021', '广安区', '270');
INSERT INTO `district` VALUES ('2022', '前锋区', '270');
INSERT INTO `district` VALUES ('2023', '岳池县', '270');
INSERT INTO `district` VALUES ('2024', '武胜县', '270');
INSERT INTO `district` VALUES ('2025', '邻水县', '270');
INSERT INTO `district` VALUES ('2026', '华蓥市', '270');
INSERT INTO `district` VALUES ('2027', '通川区', '271');
INSERT INTO `district` VALUES ('2028', '达川区', '271');
INSERT INTO `district` VALUES ('2029', '宣汉县', '271');
INSERT INTO `district` VALUES ('2030', '开江县', '271');
INSERT INTO `district` VALUES ('2031', '大竹县', '271');
INSERT INTO `district` VALUES ('2032', '渠县', '271');
INSERT INTO `district` VALUES ('2033', '万源市', '271');
INSERT INTO `district` VALUES ('2034', '雨城区', '272');
INSERT INTO `district` VALUES ('2035', '名山区', '272');
INSERT INTO `district` VALUES ('2036', '荥经县', '272');
INSERT INTO `district` VALUES ('2037', '汉源县', '272');
INSERT INTO `district` VALUES ('2038', '石棉县', '272');
INSERT INTO `district` VALUES ('2039', '天全县', '272');
INSERT INTO `district` VALUES ('2040', '芦山县', '272');
INSERT INTO `district` VALUES ('2041', '宝兴县', '272');
INSERT INTO `district` VALUES ('2042', '巴州区', '273');
INSERT INTO `district` VALUES ('2043', '恩阳区', '273');
INSERT INTO `district` VALUES ('2044', '通江县', '273');
INSERT INTO `district` VALUES ('2045', '南江县', '273');
INSERT INTO `district` VALUES ('2046', '平昌县', '273');
INSERT INTO `district` VALUES ('2047', '雁江区', '274');
INSERT INTO `district` VALUES ('2048', '安岳县', '274');
INSERT INTO `district` VALUES ('2049', '乐至县', '274');
INSERT INTO `district` VALUES ('2050', '马尔康市', '275');
INSERT INTO `district` VALUES ('2051', '汶川县', '275');
INSERT INTO `district` VALUES ('2052', '理县', '275');
INSERT INTO `district` VALUES ('2053', '茂县', '275');
INSERT INTO `district` VALUES ('2054', '松潘县', '275');
INSERT INTO `district` VALUES ('2055', '九寨沟县', '275');
INSERT INTO `district` VALUES ('2056', '金川县', '275');
INSERT INTO `district` VALUES ('2057', '小金县', '275');
INSERT INTO `district` VALUES ('2058', '黑水县', '275');
INSERT INTO `district` VALUES ('2059', '壤塘县', '275');
INSERT INTO `district` VALUES ('2060', '阿坝县', '275');
INSERT INTO `district` VALUES ('2061', '若尔盖县', '275');
INSERT INTO `district` VALUES ('2062', '红原县', '275');
INSERT INTO `district` VALUES ('2063', '康定市', '276');
INSERT INTO `district` VALUES ('2064', '泸定县', '276');
INSERT INTO `district` VALUES ('2065', '丹巴县', '276');
INSERT INTO `district` VALUES ('2066', '九龙县', '276');
INSERT INTO `district` VALUES ('2067', '雅江县', '276');
INSERT INTO `district` VALUES ('2068', '道孚县', '276');
INSERT INTO `district` VALUES ('2069', '炉霍县', '276');
INSERT INTO `district` VALUES ('2070', '甘孜县', '276');
INSERT INTO `district` VALUES ('2071', '新龙县', '276');
INSERT INTO `district` VALUES ('2072', '德格县', '276');
INSERT INTO `district` VALUES ('2073', '白玉县', '276');
INSERT INTO `district` VALUES ('2074', '石渠县', '276');
INSERT INTO `district` VALUES ('2075', '色达县', '276');
INSERT INTO `district` VALUES ('2076', '理塘县', '276');
INSERT INTO `district` VALUES ('2077', '巴塘县', '276');
INSERT INTO `district` VALUES ('2078', '乡城县', '276');
INSERT INTO `district` VALUES ('2079', '稻城县', '276');
INSERT INTO `district` VALUES ('2080', '得荣县', '276');
INSERT INTO `district` VALUES ('2081', '西昌市', '277');
INSERT INTO `district` VALUES ('2082', '木里藏族自治县', '277');
INSERT INTO `district` VALUES ('2083', '盐源县', '277');
INSERT INTO `district` VALUES ('2084', '德昌县', '277');
INSERT INTO `district` VALUES ('2085', '会理县', '277');
INSERT INTO `district` VALUES ('2086', '会东县', '277');
INSERT INTO `district` VALUES ('2087', '宁南县', '277');
INSERT INTO `district` VALUES ('2088', '普格县', '277');
INSERT INTO `district` VALUES ('2089', '布拖县', '277');
INSERT INTO `district` VALUES ('2090', '金阳县', '277');
INSERT INTO `district` VALUES ('2091', '昭觉县', '277');
INSERT INTO `district` VALUES ('2092', '喜德县', '277');
INSERT INTO `district` VALUES ('2093', '冕宁县', '277');
INSERT INTO `district` VALUES ('2094', '越西县', '277');
INSERT INTO `district` VALUES ('2095', '甘洛县', '277');
INSERT INTO `district` VALUES ('2096', '美姑县', '277');
INSERT INTO `district` VALUES ('2097', '雷波县', '277');
INSERT INTO `district` VALUES ('2098', '南明区', '278');
INSERT INTO `district` VALUES ('2099', '云岩区', '278');
INSERT INTO `district` VALUES ('2100', '花溪区', '278');
INSERT INTO `district` VALUES ('2101', '乌当区', '278');
INSERT INTO `district` VALUES ('2102', '白云区', '278');
INSERT INTO `district` VALUES ('2103', '观山湖区', '278');
INSERT INTO `district` VALUES ('2104', '开阳县', '278');
INSERT INTO `district` VALUES ('2105', '息烽县', '278');
INSERT INTO `district` VALUES ('2106', '修文县', '278');
INSERT INTO `district` VALUES ('2107', '清镇市', '278');
INSERT INTO `district` VALUES ('2108', '钟山区', '279');
INSERT INTO `district` VALUES ('2109', '六枝特区', '279');
INSERT INTO `district` VALUES ('2110', '水城县', '279');
INSERT INTO `district` VALUES ('2111', '盘州市', '279');
INSERT INTO `district` VALUES ('2112', '红花岗区', '280');
INSERT INTO `district` VALUES ('2113', '汇川区', '280');
INSERT INTO `district` VALUES ('2114', '播州区', '280');
INSERT INTO `district` VALUES ('2115', '桐梓县', '280');
INSERT INTO `district` VALUES ('2116', '绥阳县', '280');
INSERT INTO `district` VALUES ('2117', '正安县', '280');
INSERT INTO `district` VALUES ('2118', '道真仡佬族苗族自治县', '280');
INSERT INTO `district` VALUES ('2119', '务川仡佬族苗族自治县', '280');
INSERT INTO `district` VALUES ('2120', '凤冈县', '280');
INSERT INTO `district` VALUES ('2121', '湄潭县', '280');
INSERT INTO `district` VALUES ('2122', '余庆县', '280');
INSERT INTO `district` VALUES ('2123', '习水县', '280');
INSERT INTO `district` VALUES ('2124', '赤水市', '280');
INSERT INTO `district` VALUES ('2125', '仁怀市', '280');
INSERT INTO `district` VALUES ('2126', '西秀区', '281');
INSERT INTO `district` VALUES ('2127', '平坝区', '281');
INSERT INTO `district` VALUES ('2128', '普定县', '281');
INSERT INTO `district` VALUES ('2129', '镇宁布依族苗族自治县', '281');
INSERT INTO `district` VALUES ('2130', '关岭布依族苗族自治县', '281');
INSERT INTO `district` VALUES ('2131', '紫云苗族布依族自治县', '281');
INSERT INTO `district` VALUES ('2132', '七星关区', '282');
INSERT INTO `district` VALUES ('2133', '大方县', '282');
INSERT INTO `district` VALUES ('2134', '黔西县', '282');
INSERT INTO `district` VALUES ('2135', '金沙县', '282');
INSERT INTO `district` VALUES ('2136', '织金县', '282');
INSERT INTO `district` VALUES ('2137', '纳雍县', '282');
INSERT INTO `district` VALUES ('2138', '威宁彝族回族苗族自治县', '282');
INSERT INTO `district` VALUES ('2139', '赫章县', '282');
INSERT INTO `district` VALUES ('2140', '碧江区', '283');
INSERT INTO `district` VALUES ('2141', '万山区', '283');
INSERT INTO `district` VALUES ('2142', '江口县', '283');
INSERT INTO `district` VALUES ('2143', '玉屏侗族自治县', '283');
INSERT INTO `district` VALUES ('2144', '石阡县', '283');
INSERT INTO `district` VALUES ('2145', '思南县', '283');
INSERT INTO `district` VALUES ('2146', '印江土家族苗族自治县', '283');
INSERT INTO `district` VALUES ('2147', '德江县', '283');
INSERT INTO `district` VALUES ('2148', '沿河土家族自治县', '283');
INSERT INTO `district` VALUES ('2149', '松桃苗族自治县', '283');
INSERT INTO `district` VALUES ('2150', '兴义市', '284');
INSERT INTO `district` VALUES ('2151', '兴仁县', '284');
INSERT INTO `district` VALUES ('2152', '普安县', '284');
INSERT INTO `district` VALUES ('2153', '晴隆县', '284');
INSERT INTO `district` VALUES ('2154', '贞丰县', '284');
INSERT INTO `district` VALUES ('2155', '望谟县', '284');
INSERT INTO `district` VALUES ('2156', '册亨县', '284');
INSERT INTO `district` VALUES ('2157', '安龙县', '284');
INSERT INTO `district` VALUES ('2158', '凯里市', '285');
INSERT INTO `district` VALUES ('2159', '黄平县', '285');
INSERT INTO `district` VALUES ('2160', '施秉县', '285');
INSERT INTO `district` VALUES ('2161', '三穗县', '285');
INSERT INTO `district` VALUES ('2162', '镇远县', '285');
INSERT INTO `district` VALUES ('2163', '岑巩县', '285');
INSERT INTO `district` VALUES ('2164', '天柱县', '285');
INSERT INTO `district` VALUES ('2165', '锦屏县', '285');
INSERT INTO `district` VALUES ('2166', '剑河县', '285');
INSERT INTO `district` VALUES ('2167', '台江县', '285');
INSERT INTO `district` VALUES ('2168', '黎平县', '285');
INSERT INTO `district` VALUES ('2169', '榕江县', '285');
INSERT INTO `district` VALUES ('2170', '从江县', '285');
INSERT INTO `district` VALUES ('2171', '雷山县', '285');
INSERT INTO `district` VALUES ('2172', '麻江县', '285');
INSERT INTO `district` VALUES ('2173', '丹寨县', '285');
INSERT INTO `district` VALUES ('2174', '都匀市', '286');
INSERT INTO `district` VALUES ('2175', '福泉市', '286');
INSERT INTO `district` VALUES ('2176', '荔波县', '286');
INSERT INTO `district` VALUES ('2177', '贵定县', '286');
INSERT INTO `district` VALUES ('2178', '瓮安县', '286');
INSERT INTO `district` VALUES ('2179', '独山县', '286');
INSERT INTO `district` VALUES ('2180', '平塘县', '286');
INSERT INTO `district` VALUES ('2181', '罗甸县', '286');
INSERT INTO `district` VALUES ('2182', '长顺县', '286');
INSERT INTO `district` VALUES ('2183', '龙里县', '286');
INSERT INTO `district` VALUES ('2184', '惠水县', '286');
INSERT INTO `district` VALUES ('2185', '三都水族自治县', '286');
INSERT INTO `district` VALUES ('2186', '五华区', '287');
INSERT INTO `district` VALUES ('2187', '盘龙区', '287');
INSERT INTO `district` VALUES ('2188', '官渡区', '287');
INSERT INTO `district` VALUES ('2189', '西山区', '287');
INSERT INTO `district` VALUES ('2190', '东川区', '287');
INSERT INTO `district` VALUES ('2191', '呈贡区', '287');
INSERT INTO `district` VALUES ('2192', '晋宁区', '287');
INSERT INTO `district` VALUES ('2193', '富民县', '287');
INSERT INTO `district` VALUES ('2194', '宜良县', '287');
INSERT INTO `district` VALUES ('2195', '石林彝族自治县', '287');
INSERT INTO `district` VALUES ('2196', '嵩明县', '287');
INSERT INTO `district` VALUES ('2197', '禄劝彝族苗族自治县', '287');
INSERT INTO `district` VALUES ('2198', '寻甸回族彝族自治县', '287');
INSERT INTO `district` VALUES ('2199', '安宁市', '287');
INSERT INTO `district` VALUES ('2200', '麒麟区', '288');
INSERT INTO `district` VALUES ('2201', '沾益区', '288');
INSERT INTO `district` VALUES ('2202', '马龙县', '288');
INSERT INTO `district` VALUES ('2203', '陆良县', '288');
INSERT INTO `district` VALUES ('2204', '师宗县', '288');
INSERT INTO `district` VALUES ('2205', '罗平县', '288');
INSERT INTO `district` VALUES ('2206', '富源县', '288');
INSERT INTO `district` VALUES ('2207', '会泽县', '288');
INSERT INTO `district` VALUES ('2208', '宣威市', '288');
INSERT INTO `district` VALUES ('2209', '红塔区', '289');
INSERT INTO `district` VALUES ('2210', '江川区', '289');
INSERT INTO `district` VALUES ('2211', '澄江县', '289');
INSERT INTO `district` VALUES ('2212', '通海县', '289');
INSERT INTO `district` VALUES ('2213', '华宁县', '289');
INSERT INTO `district` VALUES ('2214', '易门县', '289');
INSERT INTO `district` VALUES ('2215', '峨山彝族自治县', '289');
INSERT INTO `district` VALUES ('2216', '新平彝族傣族自治县', '289');
INSERT INTO `district` VALUES ('2217', '元江哈尼族彝族傣族自治县', '289');
INSERT INTO `district` VALUES ('2218', '隆阳区', '290');
INSERT INTO `district` VALUES ('2219', '施甸县', '290');
INSERT INTO `district` VALUES ('2220', '龙陵县', '290');
INSERT INTO `district` VALUES ('2221', '昌宁县', '290');
INSERT INTO `district` VALUES ('2222', '腾冲市', '290');
INSERT INTO `district` VALUES ('2223', '昭阳区', '291');
INSERT INTO `district` VALUES ('2224', '鲁甸县', '291');
INSERT INTO `district` VALUES ('2225', '巧家县', '291');
INSERT INTO `district` VALUES ('2226', '盐津县', '291');
INSERT INTO `district` VALUES ('2227', '大关县', '291');
INSERT INTO `district` VALUES ('2228', '永善县', '291');
INSERT INTO `district` VALUES ('2229', '绥江县', '291');
INSERT INTO `district` VALUES ('2230', '镇雄县', '291');
INSERT INTO `district` VALUES ('2231', '彝良县', '291');
INSERT INTO `district` VALUES ('2232', '威信县', '291');
INSERT INTO `district` VALUES ('2233', '水富县', '291');
INSERT INTO `district` VALUES ('2234', '古城区', '292');
INSERT INTO `district` VALUES ('2235', '玉龙纳西族自治县', '292');
INSERT INTO `district` VALUES ('2236', '永胜县', '292');
INSERT INTO `district` VALUES ('2237', '华坪县', '292');
INSERT INTO `district` VALUES ('2238', '宁蒗彝族自治县', '292');
INSERT INTO `district` VALUES ('2239', '思茅区', '293');
INSERT INTO `district` VALUES ('2240', '宁洱哈尼族彝族自治县', '293');
INSERT INTO `district` VALUES ('2241', '墨江哈尼族自治县', '293');
INSERT INTO `district` VALUES ('2242', '景东彝族自治县', '293');
INSERT INTO `district` VALUES ('2243', '景谷傣族彝族自治县', '293');
INSERT INTO `district` VALUES ('2244', '镇沅彝族哈尼族拉祜族自治县', '293');
INSERT INTO `district` VALUES ('2245', '江城哈尼族彝族自治县', '293');
INSERT INTO `district` VALUES ('2246', '孟连傣族拉祜族佤族自治县', '293');
INSERT INTO `district` VALUES ('2247', '澜沧拉祜族自治县', '293');
INSERT INTO `district` VALUES ('2248', '西盟佤族自治县', '293');
INSERT INTO `district` VALUES ('2249', '临翔区', '294');
INSERT INTO `district` VALUES ('2250', '凤庆县', '294');
INSERT INTO `district` VALUES ('2251', '云县', '294');
INSERT INTO `district` VALUES ('2252', '永德县', '294');
INSERT INTO `district` VALUES ('2253', '镇康县', '294');
INSERT INTO `district` VALUES ('2254', '双江拉祜族佤族布朗族傣族自治县', '294');
INSERT INTO `district` VALUES ('2255', '耿马傣族佤族自治县', '294');
INSERT INTO `district` VALUES ('2256', '沧源佤族自治县', '294');
INSERT INTO `district` VALUES ('2257', '楚雄市', '295');
INSERT INTO `district` VALUES ('2258', '双柏县', '295');
INSERT INTO `district` VALUES ('2259', '牟定县', '295');
INSERT INTO `district` VALUES ('2260', '南华县', '295');
INSERT INTO `district` VALUES ('2261', '姚安县', '295');
INSERT INTO `district` VALUES ('2262', '大姚县', '295');
INSERT INTO `district` VALUES ('2263', '永仁县', '295');
INSERT INTO `district` VALUES ('2264', '元谋县', '295');
INSERT INTO `district` VALUES ('2265', '武定县', '295');
INSERT INTO `district` VALUES ('2266', '禄丰县', '295');
INSERT INTO `district` VALUES ('2267', '个旧市', '296');
INSERT INTO `district` VALUES ('2268', '开远市', '296');
INSERT INTO `district` VALUES ('2269', '蒙自市', '296');
INSERT INTO `district` VALUES ('2270', '弥勒市', '296');
INSERT INTO `district` VALUES ('2271', '屏边苗族自治县', '296');
INSERT INTO `district` VALUES ('2272', '建水县', '296');
INSERT INTO `district` VALUES ('2273', '石屏县', '296');
INSERT INTO `district` VALUES ('2274', '泸西县', '296');
INSERT INTO `district` VALUES ('2275', '元阳县', '296');
INSERT INTO `district` VALUES ('2276', '红河县', '296');
INSERT INTO `district` VALUES ('2277', '金平苗族瑶族傣族自治县', '296');
INSERT INTO `district` VALUES ('2278', '绿春县', '296');
INSERT INTO `district` VALUES ('2279', '河口瑶族自治县', '296');
INSERT INTO `district` VALUES ('2280', '文山市', '297');
INSERT INTO `district` VALUES ('2281', '砚山县', '297');
INSERT INTO `district` VALUES ('2282', '西畴县', '297');
INSERT INTO `district` VALUES ('2283', '麻栗坡县', '297');
INSERT INTO `district` VALUES ('2284', '马关县', '297');
INSERT INTO `district` VALUES ('2285', '丘北县', '297');
INSERT INTO `district` VALUES ('2286', '广南县', '297');
INSERT INTO `district` VALUES ('2287', '富宁县', '297');
INSERT INTO `district` VALUES ('2288', '景洪市', '298');
INSERT INTO `district` VALUES ('2289', '勐海县', '298');
INSERT INTO `district` VALUES ('2290', '勐腊县', '298');
INSERT INTO `district` VALUES ('2291', '大理市', '299');
INSERT INTO `district` VALUES ('2292', '漾濞彝族自治县', '299');
INSERT INTO `district` VALUES ('2293', '祥云县', '299');
INSERT INTO `district` VALUES ('2294', '宾川县', '299');
INSERT INTO `district` VALUES ('2295', '弥渡县', '299');
INSERT INTO `district` VALUES ('2296', '南涧彝族自治县', '299');
INSERT INTO `district` VALUES ('2297', '巍山彝族回族自治县', '299');
INSERT INTO `district` VALUES ('2298', '永平县', '299');
INSERT INTO `district` VALUES ('2299', '云龙县', '299');
INSERT INTO `district` VALUES ('2300', '洱源县', '299');
INSERT INTO `district` VALUES ('2301', '剑川县', '299');
INSERT INTO `district` VALUES ('2302', '鹤庆县', '299');
INSERT INTO `district` VALUES ('2303', '瑞丽市', '300');
INSERT INTO `district` VALUES ('2304', '芒市', '300');
INSERT INTO `district` VALUES ('2305', '梁河县', '300');
INSERT INTO `district` VALUES ('2306', '盈江县', '300');
INSERT INTO `district` VALUES ('2307', '陇川县', '300');
INSERT INTO `district` VALUES ('2308', '泸水市', '301');
INSERT INTO `district` VALUES ('2309', '福贡县', '301');
INSERT INTO `district` VALUES ('2310', '贡山独龙族怒族自治县', '301');
INSERT INTO `district` VALUES ('2311', '兰坪白族普米族自治县', '301');
INSERT INTO `district` VALUES ('2312', '香格里拉市', '302');
INSERT INTO `district` VALUES ('2313', '德钦县', '302');
INSERT INTO `district` VALUES ('2314', '维西傈僳族自治县', '302');
INSERT INTO `district` VALUES ('2315', '城关区', '303');
INSERT INTO `district` VALUES ('2316', '堆龙德庆区', '303');
INSERT INTO `district` VALUES ('2317', '林周县', '303');
INSERT INTO `district` VALUES ('2318', '当雄县', '303');
INSERT INTO `district` VALUES ('2319', '尼木县', '303');
INSERT INTO `district` VALUES ('2320', '曲水县', '303');
INSERT INTO `district` VALUES ('2321', '达孜县', '303');
INSERT INTO `district` VALUES ('2322', '墨竹工卡县', '303');
INSERT INTO `district` VALUES ('2323', '桑珠孜区', '304');
INSERT INTO `district` VALUES ('2324', '南木林县', '304');
INSERT INTO `district` VALUES ('2325', '江孜县', '304');
INSERT INTO `district` VALUES ('2326', '定日县', '304');
INSERT INTO `district` VALUES ('2327', '萨迦县', '304');
INSERT INTO `district` VALUES ('2328', '拉孜县', '304');
INSERT INTO `district` VALUES ('2329', '昂仁县', '304');
INSERT INTO `district` VALUES ('2330', '谢通门县', '304');
INSERT INTO `district` VALUES ('2331', '白朗县', '304');
INSERT INTO `district` VALUES ('2332', '仁布县', '304');
INSERT INTO `district` VALUES ('2333', '康马县', '304');
INSERT INTO `district` VALUES ('2334', '定结县', '304');
INSERT INTO `district` VALUES ('2335', '仲巴县', '304');
INSERT INTO `district` VALUES ('2336', '亚东县', '304');
INSERT INTO `district` VALUES ('2337', '吉隆县', '304');
INSERT INTO `district` VALUES ('2338', '聂拉木县', '304');
INSERT INTO `district` VALUES ('2339', '萨嘎县', '304');
INSERT INTO `district` VALUES ('2340', '岗巴县', '304');
INSERT INTO `district` VALUES ('2341', '卡若区', '305');
INSERT INTO `district` VALUES ('2342', '江达县', '305');
INSERT INTO `district` VALUES ('2343', '贡觉县', '305');
INSERT INTO `district` VALUES ('2344', '类乌齐县', '305');
INSERT INTO `district` VALUES ('2345', '丁青县', '305');
INSERT INTO `district` VALUES ('2346', '察雅县', '305');
INSERT INTO `district` VALUES ('2347', '八宿县', '305');
INSERT INTO `district` VALUES ('2348', '左贡县', '305');
INSERT INTO `district` VALUES ('2349', '芒康县', '305');
INSERT INTO `district` VALUES ('2350', '洛隆县', '305');
INSERT INTO `district` VALUES ('2351', '边坝县', '305');
INSERT INTO `district` VALUES ('2352', '巴宜区', '306');
INSERT INTO `district` VALUES ('2353', '工布江达县', '306');
INSERT INTO `district` VALUES ('2354', '米林县', '306');
INSERT INTO `district` VALUES ('2355', '墨脱县', '306');
INSERT INTO `district` VALUES ('2356', '波密县', '306');
INSERT INTO `district` VALUES ('2357', '察隅县', '306');
INSERT INTO `district` VALUES ('2358', '朗县', '306');
INSERT INTO `district` VALUES ('2359', '乃东区', '307');
INSERT INTO `district` VALUES ('2360', '扎囊县', '307');
INSERT INTO `district` VALUES ('2361', '贡嘎县', '307');
INSERT INTO `district` VALUES ('2362', '桑日县', '307');
INSERT INTO `district` VALUES ('2363', '琼结县', '307');
INSERT INTO `district` VALUES ('2364', '曲松县', '307');
INSERT INTO `district` VALUES ('2365', '措美县', '307');
INSERT INTO `district` VALUES ('2366', '洛扎县', '307');
INSERT INTO `district` VALUES ('2367', '加查县', '307');
INSERT INTO `district` VALUES ('2368', '隆子县', '307');
INSERT INTO `district` VALUES ('2369', '错那县', '307');
INSERT INTO `district` VALUES ('2370', '浪卡子县', '307');
INSERT INTO `district` VALUES ('2371', '那曲县', '308');
INSERT INTO `district` VALUES ('2372', '嘉黎县', '308');
INSERT INTO `district` VALUES ('2373', '比如县', '308');
INSERT INTO `district` VALUES ('2374', '聂荣县', '308');
INSERT INTO `district` VALUES ('2375', '安多县', '308');
INSERT INTO `district` VALUES ('2376', '申扎县', '308');
INSERT INTO `district` VALUES ('2377', '索县', '308');
INSERT INTO `district` VALUES ('2378', '班戈县', '308');
INSERT INTO `district` VALUES ('2379', '巴青县', '308');
INSERT INTO `district` VALUES ('2380', '尼玛县', '308');
INSERT INTO `district` VALUES ('2381', '双湖县', '308');
INSERT INTO `district` VALUES ('2382', '普兰县', '309');
INSERT INTO `district` VALUES ('2383', '札达县', '309');
INSERT INTO `district` VALUES ('2384', '噶尔县', '309');
INSERT INTO `district` VALUES ('2385', '日土县', '309');
INSERT INTO `district` VALUES ('2386', '革吉县', '309');
INSERT INTO `district` VALUES ('2387', '改则县', '309');
INSERT INTO `district` VALUES ('2388', '措勤县', '309');
INSERT INTO `district` VALUES ('2389', '新城区', '310');
INSERT INTO `district` VALUES ('2390', '碑林区', '310');
INSERT INTO `district` VALUES ('2391', '莲湖区', '310');
INSERT INTO `district` VALUES ('2392', '灞桥区', '310');
INSERT INTO `district` VALUES ('2393', '未央区', '310');
INSERT INTO `district` VALUES ('2394', '雁塔区', '310');
INSERT INTO `district` VALUES ('2395', '阎良区', '310');
INSERT INTO `district` VALUES ('2396', '临潼区', '310');
INSERT INTO `district` VALUES ('2397', '长安区', '310');
INSERT INTO `district` VALUES ('2398', '高陵区', '310');
INSERT INTO `district` VALUES ('2399', '鄠邑区', '310');
INSERT INTO `district` VALUES ('2400', '蓝田县', '310');
INSERT INTO `district` VALUES ('2401', '周至县', '310');
INSERT INTO `district` VALUES ('2402', '王益区', '311');
INSERT INTO `district` VALUES ('2403', '印台区', '311');
INSERT INTO `district` VALUES ('2404', '耀州区', '311');
INSERT INTO `district` VALUES ('2405', '宜君县', '311');
INSERT INTO `district` VALUES ('2406', '渭滨区', '312');
INSERT INTO `district` VALUES ('2407', '金台区', '312');
INSERT INTO `district` VALUES ('2408', '陈仓区', '312');
INSERT INTO `district` VALUES ('2409', '凤翔县', '312');
INSERT INTO `district` VALUES ('2410', '岐山县', '312');
INSERT INTO `district` VALUES ('2411', '扶风县', '312');
INSERT INTO `district` VALUES ('2412', '眉县', '312');
INSERT INTO `district` VALUES ('2413', '陇县', '312');
INSERT INTO `district` VALUES ('2414', '千阳县', '312');
INSERT INTO `district` VALUES ('2415', '麟游县', '312');
INSERT INTO `district` VALUES ('2416', '凤县', '312');
INSERT INTO `district` VALUES ('2417', '太白县', '312');
INSERT INTO `district` VALUES ('2418', '秦都区', '313');
INSERT INTO `district` VALUES ('2419', '杨陵区', '313');
INSERT INTO `district` VALUES ('2420', '渭城区', '313');
INSERT INTO `district` VALUES ('2421', '三原县', '313');
INSERT INTO `district` VALUES ('2422', '泾阳县', '313');
INSERT INTO `district` VALUES ('2423', '乾县', '313');
INSERT INTO `district` VALUES ('2424', '礼泉县', '313');
INSERT INTO `district` VALUES ('2425', '永寿县', '313');
INSERT INTO `district` VALUES ('2426', '彬县', '313');
INSERT INTO `district` VALUES ('2427', '长武县', '313');
INSERT INTO `district` VALUES ('2428', '旬邑县', '313');
INSERT INTO `district` VALUES ('2429', '淳化县', '313');
INSERT INTO `district` VALUES ('2430', '武功县', '313');
INSERT INTO `district` VALUES ('2431', '兴平市', '313');
INSERT INTO `district` VALUES ('2432', '临渭区', '314');
INSERT INTO `district` VALUES ('2433', '华州区', '314');
INSERT INTO `district` VALUES ('2434', '潼关县', '314');
INSERT INTO `district` VALUES ('2435', '大荔县', '314');
INSERT INTO `district` VALUES ('2436', '合阳县', '314');
INSERT INTO `district` VALUES ('2437', '澄城县', '314');
INSERT INTO `district` VALUES ('2438', '蒲城县', '314');
INSERT INTO `district` VALUES ('2439', '白水县', '314');
INSERT INTO `district` VALUES ('2440', '富平县', '314');
INSERT INTO `district` VALUES ('2441', '韩城市', '314');
INSERT INTO `district` VALUES ('2442', '华阴市', '314');
INSERT INTO `district` VALUES ('2443', '宝塔区', '315');
INSERT INTO `district` VALUES ('2444', '安塞区', '315');
INSERT INTO `district` VALUES ('2445', '延长县', '315');
INSERT INTO `district` VALUES ('2446', '延川县', '315');
INSERT INTO `district` VALUES ('2447', '子长县', '315');
INSERT INTO `district` VALUES ('2448', '志丹县', '315');
INSERT INTO `district` VALUES ('2449', '吴起县', '315');
INSERT INTO `district` VALUES ('2450', '甘泉县', '315');
INSERT INTO `district` VALUES ('2451', '富县', '315');
INSERT INTO `district` VALUES ('2452', '洛川县', '315');
INSERT INTO `district` VALUES ('2453', '宜川县', '315');
INSERT INTO `district` VALUES ('2454', '黄龙县', '315');
INSERT INTO `district` VALUES ('2455', '黄陵县', '315');
INSERT INTO `district` VALUES ('2456', '汉台区', '316');
INSERT INTO `district` VALUES ('2457', '南郑县', '316');
INSERT INTO `district` VALUES ('2458', '城固县', '316');
INSERT INTO `district` VALUES ('2459', '洋县', '316');
INSERT INTO `district` VALUES ('2460', '西乡县', '316');
INSERT INTO `district` VALUES ('2461', '勉县', '316');
INSERT INTO `district` VALUES ('2462', '宁强县', '316');
INSERT INTO `district` VALUES ('2463', '略阳县', '316');
INSERT INTO `district` VALUES ('2464', '镇巴县', '316');
INSERT INTO `district` VALUES ('2465', '留坝县', '316');
INSERT INTO `district` VALUES ('2466', '佛坪县', '316');
INSERT INTO `district` VALUES ('2467', '榆阳区', '317');
INSERT INTO `district` VALUES ('2468', '横山区', '317');
INSERT INTO `district` VALUES ('2469', '府谷县', '317');
INSERT INTO `district` VALUES ('2470', '靖边县', '317');
INSERT INTO `district` VALUES ('2471', '定边县', '317');
INSERT INTO `district` VALUES ('2472', '绥德县', '317');
INSERT INTO `district` VALUES ('2473', '米脂县', '317');
INSERT INTO `district` VALUES ('2474', '佳县', '317');
INSERT INTO `district` VALUES ('2475', '吴堡县', '317');
INSERT INTO `district` VALUES ('2476', '清涧县', '317');
INSERT INTO `district` VALUES ('2477', '子洲县', '317');
INSERT INTO `district` VALUES ('2478', '神木市', '317');
INSERT INTO `district` VALUES ('2479', '汉滨区', '318');
INSERT INTO `district` VALUES ('2480', '汉阴县', '318');
INSERT INTO `district` VALUES ('2481', '石泉县', '318');
INSERT INTO `district` VALUES ('2482', '宁陕县', '318');
INSERT INTO `district` VALUES ('2483', '紫阳县', '318');
INSERT INTO `district` VALUES ('2484', '岚皋县', '318');
INSERT INTO `district` VALUES ('2485', '平利县', '318');
INSERT INTO `district` VALUES ('2486', '镇坪县', '318');
INSERT INTO `district` VALUES ('2487', '旬阳县', '318');
INSERT INTO `district` VALUES ('2488', '白河县', '318');
INSERT INTO `district` VALUES ('2489', '商州区', '319');
INSERT INTO `district` VALUES ('2490', '洛南县', '319');
INSERT INTO `district` VALUES ('2491', '丹凤县', '319');
INSERT INTO `district` VALUES ('2492', '商南县', '319');
INSERT INTO `district` VALUES ('2493', '山阳县', '319');
INSERT INTO `district` VALUES ('2494', '镇安县', '319');
INSERT INTO `district` VALUES ('2495', '柞水县', '319');
INSERT INTO `district` VALUES ('2496', '城关区', '320');
INSERT INTO `district` VALUES ('2497', '七里河区', '320');
INSERT INTO `district` VALUES ('2498', '西固区', '320');
INSERT INTO `district` VALUES ('2499', '安宁区', '320');
INSERT INTO `district` VALUES ('2500', '红古区', '320');
INSERT INTO `district` VALUES ('2501', '永登县', '320');
INSERT INTO `district` VALUES ('2502', '皋兰县', '320');
INSERT INTO `district` VALUES ('2503', '榆中县', '320');
INSERT INTO `district` VALUES ('2504', '嘉峪关市', '321');
INSERT INTO `district` VALUES ('2505', '嘉峪关市', '321');
INSERT INTO `district` VALUES ('2506', '金川区', '322');
INSERT INTO `district` VALUES ('2507', '永昌县', '322');
INSERT INTO `district` VALUES ('2508', '白银区', '323');
INSERT INTO `district` VALUES ('2509', '平川区', '323');
INSERT INTO `district` VALUES ('2510', '靖远县', '323');
INSERT INTO `district` VALUES ('2511', '会宁县', '323');
INSERT INTO `district` VALUES ('2512', '景泰县', '323');
INSERT INTO `district` VALUES ('2513', '秦州区', '324');
INSERT INTO `district` VALUES ('2514', '麦积区', '324');
INSERT INTO `district` VALUES ('2515', '清水县', '324');
INSERT INTO `district` VALUES ('2516', '秦安县', '324');
INSERT INTO `district` VALUES ('2517', '甘谷县', '324');
INSERT INTO `district` VALUES ('2518', '武山县', '324');
INSERT INTO `district` VALUES ('2519', '张家川回族自治县', '324');
INSERT INTO `district` VALUES ('2520', '凉州区', '325');
INSERT INTO `district` VALUES ('2521', '民勤县', '325');
INSERT INTO `district` VALUES ('2522', '古浪县', '325');
INSERT INTO `district` VALUES ('2523', '天祝藏族自治县', '325');
INSERT INTO `district` VALUES ('2524', '甘州区', '326');
INSERT INTO `district` VALUES ('2525', '肃南裕固族自治县', '326');
INSERT INTO `district` VALUES ('2526', '民乐县', '326');
INSERT INTO `district` VALUES ('2527', '临泽县', '326');
INSERT INTO `district` VALUES ('2528', '高台县', '326');
INSERT INTO `district` VALUES ('2529', '山丹县', '326');
INSERT INTO `district` VALUES ('2530', '崆峒区', '327');
INSERT INTO `district` VALUES ('2531', '泾川县', '327');
INSERT INTO `district` VALUES ('2532', '灵台县', '327');
INSERT INTO `district` VALUES ('2533', '崇信县', '327');
INSERT INTO `district` VALUES ('2534', '华亭县', '327');
INSERT INTO `district` VALUES ('2535', '庄浪县', '327');
INSERT INTO `district` VALUES ('2536', '静宁县', '327');
INSERT INTO `district` VALUES ('2537', '肃州区', '328');
INSERT INTO `district` VALUES ('2538', '金塔县', '328');
INSERT INTO `district` VALUES ('2539', '瓜州县', '328');
INSERT INTO `district` VALUES ('2540', '肃北蒙古族自治县', '328');
INSERT INTO `district` VALUES ('2541', '阿克塞哈萨克族自治县', '328');
INSERT INTO `district` VALUES ('2542', '玉门市', '328');
INSERT INTO `district` VALUES ('2543', '敦煌市', '328');
INSERT INTO `district` VALUES ('2544', '西峰区', '329');
INSERT INTO `district` VALUES ('2545', '庆城县', '329');
INSERT INTO `district` VALUES ('2546', '环县', '329');
INSERT INTO `district` VALUES ('2547', '华池县', '329');
INSERT INTO `district` VALUES ('2548', '合水县', '329');
INSERT INTO `district` VALUES ('2549', '正宁县', '329');
INSERT INTO `district` VALUES ('2550', '宁县', '329');
INSERT INTO `district` VALUES ('2551', '镇原县', '329');
INSERT INTO `district` VALUES ('2552', '安定区', '330');
INSERT INTO `district` VALUES ('2553', '通渭县', '330');
INSERT INTO `district` VALUES ('2554', '陇西县', '330');
INSERT INTO `district` VALUES ('2555', '渭源县', '330');
INSERT INTO `district` VALUES ('2556', '临洮县', '330');
INSERT INTO `district` VALUES ('2557', '漳县', '330');
INSERT INTO `district` VALUES ('2558', '岷县', '330');
INSERT INTO `district` VALUES ('2559', '武都区', '331');
INSERT INTO `district` VALUES ('2560', '成县', '331');
INSERT INTO `district` VALUES ('2561', '文县', '331');
INSERT INTO `district` VALUES ('2562', '宕昌县', '331');
INSERT INTO `district` VALUES ('2563', '康县', '331');
INSERT INTO `district` VALUES ('2564', '西和县', '331');
INSERT INTO `district` VALUES ('2565', '礼县', '331');
INSERT INTO `district` VALUES ('2566', '徽县', '331');
INSERT INTO `district` VALUES ('2567', '两当县', '331');
INSERT INTO `district` VALUES ('2568', '临夏市', '332');
INSERT INTO `district` VALUES ('2569', '临夏县', '332');
INSERT INTO `district` VALUES ('2570', '康乐县', '332');
INSERT INTO `district` VALUES ('2571', '永靖县', '332');
INSERT INTO `district` VALUES ('2572', '广河县', '332');
INSERT INTO `district` VALUES ('2573', '和政县', '332');
INSERT INTO `district` VALUES ('2574', '东乡族自治县', '332');
INSERT INTO `district` VALUES ('2575', '积石山保安族东乡族撒拉族自治县', '332');
INSERT INTO `district` VALUES ('2576', '合作市', '333');
INSERT INTO `district` VALUES ('2577', '临潭县', '333');
INSERT INTO `district` VALUES ('2578', '卓尼县', '333');
INSERT INTO `district` VALUES ('2579', '舟曲县', '333');
INSERT INTO `district` VALUES ('2580', '迭部县', '333');
INSERT INTO `district` VALUES ('2581', '玛曲县', '333');
INSERT INTO `district` VALUES ('2582', '碌曲县', '333');
INSERT INTO `district` VALUES ('2583', '夏河县', '333');
INSERT INTO `district` VALUES ('2584', '城东区', '334');
INSERT INTO `district` VALUES ('2585', '城中区', '334');
INSERT INTO `district` VALUES ('2586', '城西区', '334');
INSERT INTO `district` VALUES ('2587', '城北区', '334');
INSERT INTO `district` VALUES ('2588', '大通回族土族自治县', '334');
INSERT INTO `district` VALUES ('2589', '湟中县', '334');
INSERT INTO `district` VALUES ('2590', '湟源县', '334');
INSERT INTO `district` VALUES ('2591', '乐都区', '335');
INSERT INTO `district` VALUES ('2592', '平安区', '335');
INSERT INTO `district` VALUES ('2593', '民和回族土族自治县', '335');
INSERT INTO `district` VALUES ('2594', '互助土族自治县', '335');
INSERT INTO `district` VALUES ('2595', '化隆回族自治县', '335');
INSERT INTO `district` VALUES ('2596', '循化撒拉族自治县', '335');
INSERT INTO `district` VALUES ('2597', '门源回族自治县', '336');
INSERT INTO `district` VALUES ('2598', '祁连县', '336');
INSERT INTO `district` VALUES ('2599', '海晏县', '336');
INSERT INTO `district` VALUES ('2600', '刚察县', '336');
INSERT INTO `district` VALUES ('2601', '同仁县', '337');
INSERT INTO `district` VALUES ('2602', '尖扎县', '337');
INSERT INTO `district` VALUES ('2603', '泽库县', '337');
INSERT INTO `district` VALUES ('2604', '河南蒙古族自治县', '337');
INSERT INTO `district` VALUES ('2605', '共和县', '338');
INSERT INTO `district` VALUES ('2606', '同德县', '338');
INSERT INTO `district` VALUES ('2607', '贵德县', '338');
INSERT INTO `district` VALUES ('2608', '兴海县', '338');
INSERT INTO `district` VALUES ('2609', '贵南县', '338');
INSERT INTO `district` VALUES ('2610', '玛沁县', '339');
INSERT INTO `district` VALUES ('2611', '班玛县', '339');
INSERT INTO `district` VALUES ('2612', '甘德县', '339');
INSERT INTO `district` VALUES ('2613', '达日县', '339');
INSERT INTO `district` VALUES ('2614', '久治县', '339');
INSERT INTO `district` VALUES ('2615', '玛多县', '339');
INSERT INTO `district` VALUES ('2616', '玉树市', '340');
INSERT INTO `district` VALUES ('2617', '杂多县', '340');
INSERT INTO `district` VALUES ('2618', '称多县', '340');
INSERT INTO `district` VALUES ('2619', '治多县', '340');
INSERT INTO `district` VALUES ('2620', '囊谦县', '340');
INSERT INTO `district` VALUES ('2621', '曲麻莱县', '340');
INSERT INTO `district` VALUES ('2622', '格尔木市', '341');
INSERT INTO `district` VALUES ('2623', '德令哈市', '341');
INSERT INTO `district` VALUES ('2624', '乌兰县', '341');
INSERT INTO `district` VALUES ('2625', '都兰县', '341');
INSERT INTO `district` VALUES ('2626', '天峻县', '341');
INSERT INTO `district` VALUES ('2627', '冷湖行政区', '341');
INSERT INTO `district` VALUES ('2628', '大柴旦行政区', '341');
INSERT INTO `district` VALUES ('2629', '茫崖行政区', '341');
INSERT INTO `district` VALUES ('2630', '兴庆区', '342');
INSERT INTO `district` VALUES ('2631', '西夏区', '342');
INSERT INTO `district` VALUES ('2632', '金凤区', '342');
INSERT INTO `district` VALUES ('2633', '永宁县', '342');
INSERT INTO `district` VALUES ('2634', '贺兰县', '342');
INSERT INTO `district` VALUES ('2635', '灵武市', '342');
INSERT INTO `district` VALUES ('2636', '大武口区', '343');
INSERT INTO `district` VALUES ('2637', '惠农区', '343');
INSERT INTO `district` VALUES ('2638', '平罗县', '343');
INSERT INTO `district` VALUES ('2639', '利通区', '344');
INSERT INTO `district` VALUES ('2640', '红寺堡区', '344');
INSERT INTO `district` VALUES ('2641', '盐池县', '344');
INSERT INTO `district` VALUES ('2642', '同心县', '344');
INSERT INTO `district` VALUES ('2643', '青铜峡市', '344');
INSERT INTO `district` VALUES ('2644', '原州区', '345');
INSERT INTO `district` VALUES ('2645', '西吉县', '345');
INSERT INTO `district` VALUES ('2646', '隆德县', '345');
INSERT INTO `district` VALUES ('2647', '泾源县', '345');
INSERT INTO `district` VALUES ('2648', '彭阳县', '345');
INSERT INTO `district` VALUES ('2649', '沙坡头区', '346');
INSERT INTO `district` VALUES ('2650', '中宁县', '346');
INSERT INTO `district` VALUES ('2651', '海原县', '346');
INSERT INTO `district` VALUES ('2652', '天山区', '347');
INSERT INTO `district` VALUES ('2653', '沙依巴克区', '347');
INSERT INTO `district` VALUES ('2654', '新市区', '347');
INSERT INTO `district` VALUES ('2655', '水磨沟区', '347');
INSERT INTO `district` VALUES ('2656', '头屯河区', '347');
INSERT INTO `district` VALUES ('2657', '达坂城区', '347');
INSERT INTO `district` VALUES ('2658', '米东区', '347');
INSERT INTO `district` VALUES ('2659', '乌鲁木齐县', '347');
INSERT INTO `district` VALUES ('2660', '独山子区', '348');
INSERT INTO `district` VALUES ('2661', '克拉玛依区', '348');
INSERT INTO `district` VALUES ('2662', '白碱滩区', '348');
INSERT INTO `district` VALUES ('2663', '乌尔禾区', '348');
INSERT INTO `district` VALUES ('2664', '高昌区', '349');
INSERT INTO `district` VALUES ('2665', '鄯善县', '349');
INSERT INTO `district` VALUES ('2666', '托克逊县', '349');
INSERT INTO `district` VALUES ('2667', '伊州区', '350');
INSERT INTO `district` VALUES ('2668', '巴里坤哈萨克自治县', '350');
INSERT INTO `district` VALUES ('2669', '伊吾县', '350');
INSERT INTO `district` VALUES ('2670', '昌吉市', '351');
INSERT INTO `district` VALUES ('2671', '阜康市', '351');
INSERT INTO `district` VALUES ('2672', '呼图壁县', '351');
INSERT INTO `district` VALUES ('2673', '玛纳斯县', '351');
INSERT INTO `district` VALUES ('2674', '奇台县', '351');
INSERT INTO `district` VALUES ('2675', '吉木萨尔县', '351');
INSERT INTO `district` VALUES ('2676', '木垒哈萨克自治县', '351');
INSERT INTO `district` VALUES ('2677', '博乐市', '352');
INSERT INTO `district` VALUES ('2678', '阿拉山口市', '352');
INSERT INTO `district` VALUES ('2679', '精河县', '352');
INSERT INTO `district` VALUES ('2680', '温泉县', '352');
INSERT INTO `district` VALUES ('2681', '库尔勒市', '353');
INSERT INTO `district` VALUES ('2682', '轮台县', '353');
INSERT INTO `district` VALUES ('2683', '尉犁县', '353');
INSERT INTO `district` VALUES ('2684', '若羌县', '353');
INSERT INTO `district` VALUES ('2685', '且末县', '353');
INSERT INTO `district` VALUES ('2686', '焉耆回族自治县', '353');
INSERT INTO `district` VALUES ('2687', '和静县', '353');
INSERT INTO `district` VALUES ('2688', '和硕县', '353');
INSERT INTO `district` VALUES ('2689', '博湖县', '353');
INSERT INTO `district` VALUES ('2690', '阿克苏市', '354');
INSERT INTO `district` VALUES ('2691', '温宿县', '354');
INSERT INTO `district` VALUES ('2692', '库车县', '354');
INSERT INTO `district` VALUES ('2693', '沙雅县', '354');
INSERT INTO `district` VALUES ('2694', '新和县', '354');
INSERT INTO `district` VALUES ('2695', '拜城县', '354');
INSERT INTO `district` VALUES ('2696', '乌什县', '354');
INSERT INTO `district` VALUES ('2697', '阿瓦提县', '354');
INSERT INTO `district` VALUES ('2698', '柯坪县', '354');
INSERT INTO `district` VALUES ('2699', '阿图什市', '355');
INSERT INTO `district` VALUES ('2700', '阿克陶县', '355');
INSERT INTO `district` VALUES ('2701', '阿合奇县', '355');
INSERT INTO `district` VALUES ('2702', '乌恰县', '355');
INSERT INTO `district` VALUES ('2703', '喀什市', '356');
INSERT INTO `district` VALUES ('2704', '疏附县', '356');
INSERT INTO `district` VALUES ('2705', '疏勒县', '356');
INSERT INTO `district` VALUES ('2706', '英吉沙县', '356');
INSERT INTO `district` VALUES ('2707', '泽普县', '356');
INSERT INTO `district` VALUES ('2708', '莎车县', '356');
INSERT INTO `district` VALUES ('2709', '叶城县', '356');
INSERT INTO `district` VALUES ('2710', '麦盖提县', '356');
INSERT INTO `district` VALUES ('2711', '岳普湖县', '356');
INSERT INTO `district` VALUES ('2712', '伽师县', '356');
INSERT INTO `district` VALUES ('2713', '巴楚县', '356');
INSERT INTO `district` VALUES ('2714', '塔什库尔干塔吉克自治县', '356');
INSERT INTO `district` VALUES ('2715', '和田市', '357');
INSERT INTO `district` VALUES ('2716', '和田县', '357');
INSERT INTO `district` VALUES ('2717', '墨玉县', '357');
INSERT INTO `district` VALUES ('2718', '皮山县', '357');
INSERT INTO `district` VALUES ('2719', '洛浦县', '357');
INSERT INTO `district` VALUES ('2720', '策勒县', '357');
INSERT INTO `district` VALUES ('2721', '于田县', '357');
INSERT INTO `district` VALUES ('2722', '民丰县', '357');
INSERT INTO `district` VALUES ('2723', '伊宁市', '358');
INSERT INTO `district` VALUES ('2724', '奎屯市', '358');
INSERT INTO `district` VALUES ('2725', '霍尔果斯市', '358');
INSERT INTO `district` VALUES ('2726', '伊宁县', '358');
INSERT INTO `district` VALUES ('2727', '察布查尔锡伯自治县', '358');
INSERT INTO `district` VALUES ('2728', '霍城县', '358');
INSERT INTO `district` VALUES ('2729', '巩留县', '358');
INSERT INTO `district` VALUES ('2730', '新源县', '358');
INSERT INTO `district` VALUES ('2731', '昭苏县', '358');
INSERT INTO `district` VALUES ('2732', '特克斯县', '358');
INSERT INTO `district` VALUES ('2733', '尼勒克县', '358');
INSERT INTO `district` VALUES ('2734', '塔城市', '359');
INSERT INTO `district` VALUES ('2735', '乌苏市', '359');
INSERT INTO `district` VALUES ('2736', '额敏县', '359');
INSERT INTO `district` VALUES ('2737', '沙湾县', '359');
INSERT INTO `district` VALUES ('2738', '托里县', '359');
INSERT INTO `district` VALUES ('2739', '裕民县', '359');
INSERT INTO `district` VALUES ('2740', '和布克赛尔蒙古自治县', '359');
INSERT INTO `district` VALUES ('2741', '阿勒泰市', '360');
INSERT INTO `district` VALUES ('2742', '布尔津县', '360');
INSERT INTO `district` VALUES ('2743', '富蕴县', '360');
INSERT INTO `district` VALUES ('2744', '福海县', '360');
INSERT INTO `district` VALUES ('2745', '哈巴河县', '360');
INSERT INTO `district` VALUES ('2746', '青河县', '360');
INSERT INTO `district` VALUES ('2747', '吉木乃县', '360');
INSERT INTO `district` VALUES ('2748', '中正区', '370');
INSERT INTO `district` VALUES ('2749', '大同区', '370');
INSERT INTO `district` VALUES ('2750', '中山区', '370');
INSERT INTO `district` VALUES ('2751', '松山区', '370');
INSERT INTO `district` VALUES ('2752', '大安区', '370');
INSERT INTO `district` VALUES ('2753', '万华区', '370');
INSERT INTO `district` VALUES ('2754', '信义区', '370');
INSERT INTO `district` VALUES ('2755', '士林区', '370');
INSERT INTO `district` VALUES ('2756', '北投区', '370');
INSERT INTO `district` VALUES ('2757', '内湖区', '370');
INSERT INTO `district` VALUES ('2758', '南港区', '370');
INSERT INTO `district` VALUES ('2759', '文山区', '370');
INSERT INTO `district` VALUES ('2760', '新兴区', '371');
INSERT INTO `district` VALUES ('2761', '前金区', '371');
INSERT INTO `district` VALUES ('2762', '苓雅区', '371');
INSERT INTO `district` VALUES ('2763', '盐埕区', '371');
INSERT INTO `district` VALUES ('2764', '鼓山区', '371');
INSERT INTO `district` VALUES ('2765', '旗津区', '371');
INSERT INTO `district` VALUES ('2766', '前镇区', '371');
INSERT INTO `district` VALUES ('2767', '三民区', '371');
INSERT INTO `district` VALUES ('2768', '左营区', '371');
INSERT INTO `district` VALUES ('2769', '楠梓区', '371');
INSERT INTO `district` VALUES ('2770', '小港区', '371');
INSERT INTO `district` VALUES ('2771', '仁武区', '371');
INSERT INTO `district` VALUES ('2772', '大社区', '371');
INSERT INTO `district` VALUES ('2773', '冈山区', '371');
INSERT INTO `district` VALUES ('2774', '路竹区', '371');
INSERT INTO `district` VALUES ('2775', '阿莲区', '371');
INSERT INTO `district` VALUES ('2776', '田寮区', '371');
INSERT INTO `district` VALUES ('2777', '燕巢区', '371');
INSERT INTO `district` VALUES ('2778', '桥头区', '371');
INSERT INTO `district` VALUES ('2779', '梓官区', '371');
INSERT INTO `district` VALUES ('2780', '弥陀区', '371');
INSERT INTO `district` VALUES ('2781', '永安区', '371');
INSERT INTO `district` VALUES ('2782', '湖内区', '371');
INSERT INTO `district` VALUES ('2783', '凤山区', '371');
INSERT INTO `district` VALUES ('2784', '大寮区', '371');
INSERT INTO `district` VALUES ('2785', '林园区', '371');
INSERT INTO `district` VALUES ('2786', '鸟松区', '371');
INSERT INTO `district` VALUES ('2787', '大树区', '371');
INSERT INTO `district` VALUES ('2788', '旗山区', '371');
INSERT INTO `district` VALUES ('2789', '美浓区', '371');
INSERT INTO `district` VALUES ('2790', '六龟区', '371');
INSERT INTO `district` VALUES ('2791', '内门区', '371');
INSERT INTO `district` VALUES ('2792', '杉林区', '371');
INSERT INTO `district` VALUES ('2793', '甲仙区', '371');
INSERT INTO `district` VALUES ('2794', '桃源区', '371');
INSERT INTO `district` VALUES ('2795', '那玛夏区', '371');
INSERT INTO `district` VALUES ('2796', '茂林区', '371');
INSERT INTO `district` VALUES ('2797', '茄萣区', '371');
INSERT INTO `district` VALUES ('2798', '中西区', '372');
INSERT INTO `district` VALUES ('2799', '东区', '372');
INSERT INTO `district` VALUES ('2800', '南区', '372');
INSERT INTO `district` VALUES ('2801', '北区', '372');
INSERT INTO `district` VALUES ('2802', '安平区', '372');
INSERT INTO `district` VALUES ('2803', '安南区', '372');
INSERT INTO `district` VALUES ('2804', '永康区', '372');
INSERT INTO `district` VALUES ('2805', '归仁区', '372');
INSERT INTO `district` VALUES ('2806', '新化区', '372');
INSERT INTO `district` VALUES ('2807', '左镇区', '372');
INSERT INTO `district` VALUES ('2808', '玉井区', '372');
INSERT INTO `district` VALUES ('2809', '楠西区', '372');
INSERT INTO `district` VALUES ('2810', '南化区', '372');
INSERT INTO `district` VALUES ('2811', '仁德区', '372');
INSERT INTO `district` VALUES ('2812', '关庙区', '372');
INSERT INTO `district` VALUES ('2813', '龙崎区', '372');
INSERT INTO `district` VALUES ('2814', '官田区', '372');
INSERT INTO `district` VALUES ('2815', '麻豆区', '372');
INSERT INTO `district` VALUES ('2816', '佳里区', '372');
INSERT INTO `district` VALUES ('2817', '西港区', '372');
INSERT INTO `district` VALUES ('2818', '七股区', '372');
INSERT INTO `district` VALUES ('2819', '将军区', '372');
INSERT INTO `district` VALUES ('2820', '学甲区', '372');
INSERT INTO `district` VALUES ('2821', '北门区', '372');
INSERT INTO `district` VALUES ('2822', '新营区', '372');
INSERT INTO `district` VALUES ('2823', '后壁区', '372');
INSERT INTO `district` VALUES ('2824', '白河区', '372');
INSERT INTO `district` VALUES ('2825', '东山区', '372');
INSERT INTO `district` VALUES ('2826', '六甲区', '372');
INSERT INTO `district` VALUES ('2827', '下营区', '372');
INSERT INTO `district` VALUES ('2828', '柳营区', '372');
INSERT INTO `district` VALUES ('2829', '盐水区', '372');
INSERT INTO `district` VALUES ('2830', '善化区', '372');
INSERT INTO `district` VALUES ('2831', '大内区', '372');
INSERT INTO `district` VALUES ('2832', '山上区', '372');
INSERT INTO `district` VALUES ('2833', '新市区', '372');
INSERT INTO `district` VALUES ('2834', '安定区', '372');
INSERT INTO `district` VALUES ('2835', '中区', '373');
INSERT INTO `district` VALUES ('2836', '东区', '373');
INSERT INTO `district` VALUES ('2837', '南区', '373');
INSERT INTO `district` VALUES ('2838', '西区', '373');
INSERT INTO `district` VALUES ('2839', '北区', '373');
INSERT INTO `district` VALUES ('2840', '北屯区', '373');
INSERT INTO `district` VALUES ('2841', '西屯区', '373');
INSERT INTO `district` VALUES ('2842', '南屯区', '373');
INSERT INTO `district` VALUES ('2843', '太平区', '373');
INSERT INTO `district` VALUES ('2844', '大里区', '373');
INSERT INTO `district` VALUES ('2845', '雾峰区', '373');
INSERT INTO `district` VALUES ('2846', '乌日区', '373');
INSERT INTO `district` VALUES ('2847', '丰原区', '373');
INSERT INTO `district` VALUES ('2848', '后里区', '373');
INSERT INTO `district` VALUES ('2849', '石冈区', '373');
INSERT INTO `district` VALUES ('2850', '东势区', '373');
INSERT INTO `district` VALUES ('2851', '和平区', '373');
INSERT INTO `district` VALUES ('2852', '新社区', '373');
INSERT INTO `district` VALUES ('2853', '潭子区', '373');
INSERT INTO `district` VALUES ('2854', '大雅区', '373');
INSERT INTO `district` VALUES ('2855', '神冈区', '373');
INSERT INTO `district` VALUES ('2856', '大肚区', '373');
INSERT INTO `district` VALUES ('2857', '沙鹿区', '373');
INSERT INTO `district` VALUES ('2858', '龙井区', '373');
INSERT INTO `district` VALUES ('2859', '梧栖区', '373');
INSERT INTO `district` VALUES ('2860', '清水区', '373');
INSERT INTO `district` VALUES ('2861', '大甲区', '373');
INSERT INTO `district` VALUES ('2862', '外埔区', '373');
INSERT INTO `district` VALUES ('2863', '大安区', '373');
INSERT INTO `district` VALUES ('2864', '南投市', '374');
INSERT INTO `district` VALUES ('2865', '中寮乡', '374');
INSERT INTO `district` VALUES ('2866', '草屯镇', '374');
INSERT INTO `district` VALUES ('2867', '国姓乡', '374');
INSERT INTO `district` VALUES ('2868', '埔里镇', '374');
INSERT INTO `district` VALUES ('2869', '仁爱乡', '374');
INSERT INTO `district` VALUES ('2870', '名间乡', '374');
INSERT INTO `district` VALUES ('2871', '集集镇', '374');
INSERT INTO `district` VALUES ('2872', '水里乡', '374');
INSERT INTO `district` VALUES ('2873', '鱼池乡', '374');
INSERT INTO `district` VALUES ('2874', '信义乡', '374');
INSERT INTO `district` VALUES ('2875', '竹山镇', '374');
INSERT INTO `district` VALUES ('2876', '鹿谷乡', '374');
INSERT INTO `district` VALUES ('2877', '仁爱区', '375');
INSERT INTO `district` VALUES ('2878', '信义区', '375');
INSERT INTO `district` VALUES ('2879', '中正区', '375');
INSERT INTO `district` VALUES ('2880', '中山区', '375');
INSERT INTO `district` VALUES ('2881', '安乐区', '375');
INSERT INTO `district` VALUES ('2882', '暖暖区', '375');
INSERT INTO `district` VALUES ('2883', '七堵区', '375');
INSERT INTO `district` VALUES ('2884', '东区', '376');
INSERT INTO `district` VALUES ('2885', '北区', '376');
INSERT INTO `district` VALUES ('2886', '香山区', '376');
INSERT INTO `district` VALUES ('2887', '东区', '377');
INSERT INTO `district` VALUES ('2888', '西区', '377');
INSERT INTO `district` VALUES ('2889', '万里区', '378');
INSERT INTO `district` VALUES ('2890', '金山区', '378');
INSERT INTO `district` VALUES ('2891', '板桥区', '378');
INSERT INTO `district` VALUES ('2892', '汐止区', '378');
INSERT INTO `district` VALUES ('2893', '深坑区', '378');
INSERT INTO `district` VALUES ('2894', '石碇区', '378');
INSERT INTO `district` VALUES ('2895', '瑞芳区', '378');
INSERT INTO `district` VALUES ('2896', '平溪区', '378');
INSERT INTO `district` VALUES ('2897', '双溪区', '378');
INSERT INTO `district` VALUES ('2898', '贡寮区', '378');
INSERT INTO `district` VALUES ('2899', '新店区', '378');
INSERT INTO `district` VALUES ('2900', '坪林区', '378');
INSERT INTO `district` VALUES ('2901', '乌来区', '378');
INSERT INTO `district` VALUES ('2902', '永和区', '378');
INSERT INTO `district` VALUES ('2903', '中和区', '378');
INSERT INTO `district` VALUES ('2904', '土城区', '378');
INSERT INTO `district` VALUES ('2905', '三峡区', '378');
INSERT INTO `district` VALUES ('2906', '树林区', '378');
INSERT INTO `district` VALUES ('2907', '莺歌区', '378');
INSERT INTO `district` VALUES ('2908', '三重区', '378');
INSERT INTO `district` VALUES ('2909', '新庄区', '378');
INSERT INTO `district` VALUES ('2910', '泰山区', '378');
INSERT INTO `district` VALUES ('2911', '林口区', '378');
INSERT INTO `district` VALUES ('2912', '芦洲区', '378');
INSERT INTO `district` VALUES ('2913', '五股区', '378');
INSERT INTO `district` VALUES ('2914', '八里区', '378');
INSERT INTO `district` VALUES ('2915', '淡水区', '378');
INSERT INTO `district` VALUES ('2916', '三芝区', '378');
INSERT INTO `district` VALUES ('2917', '石门区', '378');
INSERT INTO `district` VALUES ('2918', '宜兰市', '379');
INSERT INTO `district` VALUES ('2919', '头城镇', '379');
INSERT INTO `district` VALUES ('2920', '礁溪乡', '379');
INSERT INTO `district` VALUES ('2921', '壮围乡', '379');
INSERT INTO `district` VALUES ('2922', '员山乡', '379');
INSERT INTO `district` VALUES ('2923', '罗东镇', '379');
INSERT INTO `district` VALUES ('2924', '三星乡', '379');
INSERT INTO `district` VALUES ('2925', '大同乡', '379');
INSERT INTO `district` VALUES ('2926', '五结乡', '379');
INSERT INTO `district` VALUES ('2927', '冬山乡', '379');
INSERT INTO `district` VALUES ('2928', '苏澳镇', '379');
INSERT INTO `district` VALUES ('2929', '南澳乡', '379');
INSERT INTO `district` VALUES ('2930', '竹北市', '380');
INSERT INTO `district` VALUES ('2931', '湖口乡', '380');
INSERT INTO `district` VALUES ('2932', '新丰乡', '380');
INSERT INTO `district` VALUES ('2933', '新埔镇', '380');
INSERT INTO `district` VALUES ('2934', '关西镇', '380');
INSERT INTO `district` VALUES ('2935', '芎林乡', '380');
INSERT INTO `district` VALUES ('2936', '宝山乡', '380');
INSERT INTO `district` VALUES ('2937', '竹东镇', '380');
INSERT INTO `district` VALUES ('2938', '五峰乡', '380');
INSERT INTO `district` VALUES ('2939', '横山乡', '380');
INSERT INTO `district` VALUES ('2940', '尖石乡', '380');
INSERT INTO `district` VALUES ('2941', '北埔乡', '380');
INSERT INTO `district` VALUES ('2942', '峨眉乡', '380');
INSERT INTO `district` VALUES ('2943', '中坜区', '381');
INSERT INTO `district` VALUES ('2944', '平镇区', '381');
INSERT INTO `district` VALUES ('2945', '龙潭区', '381');
INSERT INTO `district` VALUES ('2946', '杨梅区', '381');
INSERT INTO `district` VALUES ('2947', '新屋区', '381');
INSERT INTO `district` VALUES ('2948', '观音区', '381');
INSERT INTO `district` VALUES ('2949', '桃园区', '381');
INSERT INTO `district` VALUES ('2950', '龟山区', '381');
INSERT INTO `district` VALUES ('2951', '八德区', '381');
INSERT INTO `district` VALUES ('2952', '大溪区', '381');
INSERT INTO `district` VALUES ('2953', '复兴区', '381');
INSERT INTO `district` VALUES ('2954', '大园区', '381');
INSERT INTO `district` VALUES ('2955', '芦竹区', '381');
INSERT INTO `district` VALUES ('2956', '竹南镇', '382');
INSERT INTO `district` VALUES ('2957', '头份市', '382');
INSERT INTO `district` VALUES ('2958', '三湾乡', '382');
INSERT INTO `district` VALUES ('2959', '南庄乡', '382');
INSERT INTO `district` VALUES ('2960', '狮潭乡', '382');
INSERT INTO `district` VALUES ('2961', '后龙镇', '382');
INSERT INTO `district` VALUES ('2962', '通霄镇', '382');
INSERT INTO `district` VALUES ('2963', '苑里镇', '382');
INSERT INTO `district` VALUES ('2964', '苗栗市', '382');
INSERT INTO `district` VALUES ('2965', '造桥乡', '382');
INSERT INTO `district` VALUES ('2966', '头屋乡', '382');
INSERT INTO `district` VALUES ('2967', '公馆乡', '382');
INSERT INTO `district` VALUES ('2968', '大湖乡', '382');
INSERT INTO `district` VALUES ('2969', '泰安乡', '382');
INSERT INTO `district` VALUES ('2970', '铜锣乡', '382');
INSERT INTO `district` VALUES ('2971', '三义乡', '382');
INSERT INTO `district` VALUES ('2972', '西湖乡', '382');
INSERT INTO `district` VALUES ('2973', '卓兰镇', '382');
INSERT INTO `district` VALUES ('2974', '彰化市', '383');
INSERT INTO `district` VALUES ('2975', '芬园乡', '383');
INSERT INTO `district` VALUES ('2976', '花坛乡', '383');
INSERT INTO `district` VALUES ('2977', '秀水乡', '383');
INSERT INTO `district` VALUES ('2978', '鹿港镇', '383');
INSERT INTO `district` VALUES ('2979', '福兴乡', '383');
INSERT INTO `district` VALUES ('2980', '线西乡', '383');
INSERT INTO `district` VALUES ('2981', '和美镇', '383');
INSERT INTO `district` VALUES ('2982', '伸港乡', '383');
INSERT INTO `district` VALUES ('2983', '员林市', '383');
INSERT INTO `district` VALUES ('2984', '社头乡', '383');
INSERT INTO `district` VALUES ('2985', '永靖乡', '383');
INSERT INTO `district` VALUES ('2986', '埔心乡', '383');
INSERT INTO `district` VALUES ('2987', '溪湖镇', '383');
INSERT INTO `district` VALUES ('2988', '大村乡', '383');
INSERT INTO `district` VALUES ('2989', '埔盐乡', '383');
INSERT INTO `district` VALUES ('2990', '田中镇', '383');
INSERT INTO `district` VALUES ('2991', '北斗镇', '383');
INSERT INTO `district` VALUES ('2992', '田尾乡', '383');
INSERT INTO `district` VALUES ('2993', '埤头乡', '383');
INSERT INTO `district` VALUES ('2994', '溪州乡', '383');
INSERT INTO `district` VALUES ('2995', '竹塘乡', '383');
INSERT INTO `district` VALUES ('2996', '二林镇', '383');
INSERT INTO `district` VALUES ('2997', '大城乡', '383');
INSERT INTO `district` VALUES ('2998', '芳苑乡', '383');
INSERT INTO `district` VALUES ('2999', '二水乡', '383');
INSERT INTO `district` VALUES ('3000', '番路乡', '384');
INSERT INTO `district` VALUES ('3001', '梅山乡', '384');
INSERT INTO `district` VALUES ('3002', '竹崎乡', '384');
INSERT INTO `district` VALUES ('3003', '阿里山乡', '384');
INSERT INTO `district` VALUES ('3004', '中埔乡', '384');
INSERT INTO `district` VALUES ('3005', '大埔乡', '384');
INSERT INTO `district` VALUES ('3006', '水上乡', '384');
INSERT INTO `district` VALUES ('3007', '鹿草乡', '384');
INSERT INTO `district` VALUES ('3008', '太保市', '384');
INSERT INTO `district` VALUES ('3009', '朴子市', '384');
INSERT INTO `district` VALUES ('3010', '东石乡', '384');
INSERT INTO `district` VALUES ('3011', '六脚乡', '384');
INSERT INTO `district` VALUES ('3012', '新港乡', '384');
INSERT INTO `district` VALUES ('3013', '民雄乡', '384');
INSERT INTO `district` VALUES ('3014', '大林镇', '384');
INSERT INTO `district` VALUES ('3015', '溪口乡', '384');
INSERT INTO `district` VALUES ('3016', '义竹乡', '384');
INSERT INTO `district` VALUES ('3017', '布袋镇', '384');
INSERT INTO `district` VALUES ('3018', '斗南镇', '385');
INSERT INTO `district` VALUES ('3019', '大埤乡', '385');
INSERT INTO `district` VALUES ('3020', '虎尾镇', '385');
INSERT INTO `district` VALUES ('3021', '土库镇', '385');
INSERT INTO `district` VALUES ('3022', '褒忠乡', '385');
INSERT INTO `district` VALUES ('3023', '东势乡', '385');
INSERT INTO `district` VALUES ('3024', '台西乡', '385');
INSERT INTO `district` VALUES ('3025', '仑背乡', '385');
INSERT INTO `district` VALUES ('3026', '麦寮乡', '385');
INSERT INTO `district` VALUES ('3027', '斗六市', '385');
INSERT INTO `district` VALUES ('3028', '林内乡', '385');
INSERT INTO `district` VALUES ('3029', '古坑乡', '385');
INSERT INTO `district` VALUES ('3030', '莿桐乡', '385');
INSERT INTO `district` VALUES ('3031', '西螺镇', '385');
INSERT INTO `district` VALUES ('3032', '二仑乡', '385');
INSERT INTO `district` VALUES ('3033', '北港镇', '385');
INSERT INTO `district` VALUES ('3034', '水林乡', '385');
INSERT INTO `district` VALUES ('3035', '口湖乡', '385');
INSERT INTO `district` VALUES ('3036', '四湖乡', '385');
INSERT INTO `district` VALUES ('3037', '元长乡', '385');
INSERT INTO `district` VALUES ('3038', '屏东市', '386');
INSERT INTO `district` VALUES ('3039', '三地门乡', '386');
INSERT INTO `district` VALUES ('3040', '雾台乡', '386');
INSERT INTO `district` VALUES ('3041', '玛家乡', '386');
INSERT INTO `district` VALUES ('3042', '九如乡', '386');
INSERT INTO `district` VALUES ('3043', '里港乡', '386');
INSERT INTO `district` VALUES ('3044', '高树乡', '386');
INSERT INTO `district` VALUES ('3045', '盐埔乡', '386');
INSERT INTO `district` VALUES ('3046', '长治乡', '386');
INSERT INTO `district` VALUES ('3047', '麟洛乡', '386');
INSERT INTO `district` VALUES ('3048', '竹田乡', '386');
INSERT INTO `district` VALUES ('3049', '内埔乡', '386');
INSERT INTO `district` VALUES ('3050', '万丹乡', '386');
INSERT INTO `district` VALUES ('3051', '潮州镇', '386');
INSERT INTO `district` VALUES ('3052', '泰武乡', '386');
INSERT INTO `district` VALUES ('3053', '来义乡', '386');
INSERT INTO `district` VALUES ('3054', '万峦乡', '386');
INSERT INTO `district` VALUES ('3055', '崁顶乡', '386');
INSERT INTO `district` VALUES ('3056', '新埤乡', '386');
INSERT INTO `district` VALUES ('3057', '南州乡', '386');
INSERT INTO `district` VALUES ('3058', '林边乡', '386');
INSERT INTO `district` VALUES ('3059', '东港镇', '386');
INSERT INTO `district` VALUES ('3060', '琉球乡', '386');
INSERT INTO `district` VALUES ('3061', '佳冬乡', '386');
INSERT INTO `district` VALUES ('3062', '新园乡', '386');
INSERT INTO `district` VALUES ('3063', '枋寮乡', '386');
INSERT INTO `district` VALUES ('3064', '枋山乡', '386');
INSERT INTO `district` VALUES ('3065', '春日乡', '386');
INSERT INTO `district` VALUES ('3066', '狮子乡', '386');
INSERT INTO `district` VALUES ('3067', '车城乡', '386');
INSERT INTO `district` VALUES ('3068', '牡丹乡', '386');
INSERT INTO `district` VALUES ('3069', '恒春镇', '386');
INSERT INTO `district` VALUES ('3070', '满州乡', '386');
INSERT INTO `district` VALUES ('3071', '台东市', '387');
INSERT INTO `district` VALUES ('3072', '绿岛乡', '387');
INSERT INTO `district` VALUES ('3073', '兰屿乡', '387');
INSERT INTO `district` VALUES ('3074', '延平乡', '387');
INSERT INTO `district` VALUES ('3075', '卑南乡', '387');
INSERT INTO `district` VALUES ('3076', '鹿野乡', '387');
INSERT INTO `district` VALUES ('3077', '关山镇', '387');
INSERT INTO `district` VALUES ('3078', '海端乡', '387');
INSERT INTO `district` VALUES ('3079', '池上乡', '387');
INSERT INTO `district` VALUES ('3080', '东河乡', '387');
INSERT INTO `district` VALUES ('3081', '成功镇', '387');
INSERT INTO `district` VALUES ('3082', '长滨乡', '387');
INSERT INTO `district` VALUES ('3083', '金峰乡', '387');
INSERT INTO `district` VALUES ('3084', '大武乡', '387');
INSERT INTO `district` VALUES ('3085', '达仁乡', '387');
INSERT INTO `district` VALUES ('3086', '太麻里乡', '387');
INSERT INTO `district` VALUES ('3087', '花莲市', '388');
INSERT INTO `district` VALUES ('3088', '新城乡', '388');
INSERT INTO `district` VALUES ('3089', '秀林乡', '388');
INSERT INTO `district` VALUES ('3090', '吉安乡', '388');
INSERT INTO `district` VALUES ('3091', '寿丰乡', '388');
INSERT INTO `district` VALUES ('3092', '凤林镇', '388');
INSERT INTO `district` VALUES ('3093', '光复乡', '388');
INSERT INTO `district` VALUES ('3094', '丰滨乡', '388');
INSERT INTO `district` VALUES ('3095', '瑞穗乡', '388');
INSERT INTO `district` VALUES ('3096', '万荣乡', '388');
INSERT INTO `district` VALUES ('3097', '玉里镇', '388');
INSERT INTO `district` VALUES ('3098', '卓溪乡', '388');
INSERT INTO `district` VALUES ('3099', '富里乡', '388');
INSERT INTO `district` VALUES ('3100', '马公市', '389');
INSERT INTO `district` VALUES ('3101', '西屿乡', '389');
INSERT INTO `district` VALUES ('3102', '望安乡', '389');
INSERT INTO `district` VALUES ('3103', '七美乡', '389');
INSERT INTO `district` VALUES ('3104', '白沙乡', '389');
INSERT INTO `district` VALUES ('3105', '湖西乡', '389');

-- ----------------------------
-- Table structure for employee
-- ----------------------------

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_num` varchar(20) DEFAULT NULL COMMENT '职工编号',
  `login_name` varchar(40) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(60) DEFAULT NULL COMMENT '密码',
  `full_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `phone_num` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `cust_mail` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `group_id` int(11) DEFAULT NULL COMMENT '集团id',
  `store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `user_status` tinyint(4) DEFAULT '1' COMMENT '1启用 0 禁用',
  `data_status` tinyint(4) DEFAULT '1' COMMENT '数据状态 1在用 0删除',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `subjection_type` tinyint(4) DEFAULT '1' COMMENT '隶属类型  1集团 2 门店',
  `department_id` tinyint(4) DEFAULT '0' COMMENT '部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', null, '1', '1', '1', '1', null, null, '1', '1', '1', '2018-06-01 16:29:54', '2018-06-01 16:29:54', '1', '0');

-- ----------------------------
-- Table structure for employee_group
-- ----------------------------

CREATE TABLE `employee_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组织id',
  `group_name` varchar(50) DEFAULT NULL COMMENT '组织名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级组织id',
  `sortno` int(11) DEFAULT NULL COMMENT '排序',
  `group_type` tinyint(4) DEFAULT '1' COMMENT '组织类别 1集团 2门店',
  `data_status` tinyint(4) DEFAULT '1' COMMENT '数据状态 1在用 0删除',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织结构表';

-- ----------------------------
-- Records of employee_group
-- ----------------------------

-- ----------------------------
-- Table structure for employee_role
-- ----------------------------

CREATE TABLE `employee_role` (
  `employee_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工_角色_中间表';

-- ----------------------------
-- Records of employee_role
-- ----------------------------

-- ----------------------------
-- Table structure for employee_state
-- ----------------------------

CREATE TABLE `employee_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `employee_id` int(11) DEFAULT NULL COMMENT '员工id',
  `type` tinyint(11) DEFAULT NULL COMMENT '状态0空闲1忙碌',
  `contact_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售顾问状态表（空闲、忙碌）';

-- ----------------------------
-- Records of employee_state
-- ----------------------------

-- ----------------------------
-- Table structure for employee_target
-- ----------------------------

CREATE TABLE `employee_target` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL COMMENT '员工id',
  `target_order` int(11) DEFAULT NULL COMMENT '订单目标',
  `target_deliver` int(11) DEFAULT NULL COMMENT '交车目标',
  `target_cus` int(11) DEFAULT NULL COMMENT '客流目标',
  `target_record` int(11) DEFAULT NULL COMMENT '建档目标',
  `target_time` varchar(10) DEFAULT NULL COMMENT '目标周期',
  `target_drive` int(11) DEFAULT NULL COMMENT '试驾目标',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '数据状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='员工目标表';

-- ----------------------------
-- Records of employee_target
-- ----------------------------
INSERT INTO `employee_target` VALUES ('1', '1', '10', '10', null, null, '2018-06', null, '2018-06-01 15:27:08', '1');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------

CREATE TABLE `equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `cus_id` int(11) DEFAULT NULL COMMENT '配车员工id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配车记录表';

-- ----------------------------
-- Records of equipment
-- ----------------------------

-- ----------------------------
-- Table structure for extension_insurance_company
-- ----------------------------

CREATE TABLE `extension_insurance_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) DEFAULT '' COMMENT '公司名称',
  `address` varchar(255) DEFAULT NULL COMMENT '公司地址',
  `contactor` varchar(255) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `operator_id` int(11) NOT NULL COMMENT '操作人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='延保公司表';

-- ----------------------------
-- Records of extension_insurance_company
-- ----------------------------

-- ----------------------------
-- Table structure for finance_company
-- ----------------------------

CREATE TABLE `finance_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `contactor` varchar(255) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) DEFAULT NULL COMMENT '公司地址',
  `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效（0：无效，1：有效）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `operator_id` int(11) NOT NULL COMMENT '操作人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='金融公司表';

-- ----------------------------
-- Records of finance_company
-- ----------------------------

-- ----------------------------
-- Table structure for holle_world
-- ----------------------------

CREATE TABLE `holle_world` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `context` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of holle_world
-- ----------------------------
INSERT INTO `holle_world` VALUES ('1', 'holleworld');

-- ----------------------------
-- Table structure for insurance_connection
-- ----------------------------

CREATE TABLE `insurance_connection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `insurer_id` int(11) NOT NULL COMMENT '保险公司ID',
  `insurance_id` int(11) NOT NULL COMMENT '险种ID',
  `ratio` decimal(10,2) NOT NULL COMMENT '系数',
  `insurance_name` varchar(255) NOT NULL COMMENT '险种名称',
  `insurer_name` varchar(255) NOT NULL COMMENT '保险公司名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保险公司-险种关联表';

-- ----------------------------
-- Records of insurance_connection
-- ----------------------------

-- ----------------------------
-- Table structure for insurance_extension
-- ----------------------------

CREATE TABLE `insurance_extension` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `extension_company_id` int(11) NOT NULL COMMENT '延保公司ID',
  `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用（0：不启用，1：启用）',
  `name` varchar(255) NOT NULL COMMENT '延保名称',
  `price` decimal(10,2) NOT NULL COMMENT '延保金额',
  `operator_id` int(11) NOT NULL COMMENT '操作人ID',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `years` int(11) NOT NULL COMMENT '延保时间（年）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='延保表';

-- ----------------------------
-- Records of insurance_extension
-- ----------------------------

-- ----------------------------
-- Table structure for insurance_extension_item
-- ----------------------------

CREATE TABLE `insurance_extension_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `extension_id` int(11) NOT NULL COMMENT '延保ID',
  `name` varchar(255) DEFAULT NULL COMMENT '延保项名称',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `employee_id` int(11) DEFAULT NULL COMMENT '操作人ID',
  `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用',
  `operator_id` int(11) NOT NULL COMMENT '操作人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='延保项表';

-- ----------------------------
-- Records of insurance_extension_item
-- ----------------------------

-- ----------------------------
-- Table structure for insurance_type
-- ----------------------------

CREATE TABLE `insurance_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '险种名称',
  `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效（0：无效，1：有效）',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `operator_id` int(255) NOT NULL COMMENT '操作人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='险种表';

-- ----------------------------
-- Records of insurance_type
-- ----------------------------

-- ----------------------------
-- Table structure for insurer
-- ----------------------------

CREATE TABLE `insurer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
  `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效（0：无效 ，1：有效）',
  `contactor` varchar(255) NOT NULL DEFAULT '' COMMENT '联系人',
  `phone` varchar(255) DEFAULT '' COMMENT '手机号',
  `address` varchar(255) DEFAULT '' COMMENT '公司地址',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `operator_id` int(11) NOT NULL COMMENT '操作人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='保险公司表';

-- ----------------------------
-- Records of insurer
-- ----------------------------

-- ----------------------------
-- Table structure for list_exception
-- ----------------------------

CREATE TABLE `list_exception` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rebate_project_id` int(11) NOT NULL COMMENT '返利项目表id',
  `list_type` tinyint(1) NOT NULL COMMENT '1 到账单 ，2核对单 限制list_id关联不同的表',
  `list_id` int(11) NOT NULL COMMENT '到账单或者核对单的id',
  `vin` varchar(30) NOT NULL COMMENT 'vin',
  `money` decimal(8,2) NOT NULL COMMENT '到账单或者核对单的金额',
  `create_date` datetime NOT NULL COMMENT '数据创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='核对单/对账单异常数据表';

-- ----------------------------
-- Records of list_exception
-- ----------------------------

-- ----------------------------
-- Table structure for model
-- ----------------------------

CREATE TABLE `model` (
  `id` int(11) NOT NULL,
  `name_en` varchar(30) DEFAULT '' COMMENT '字段英文名',
  `name_ch` varchar(30) DEFAULT '' COMMENT '字段中文名',
  `belong_id` int(11) DEFAULT NULL COMMENT '所属模板id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` int(2) DEFAULT '1' COMMENT '数据状态 1 正常 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of model
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------

CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(50) DEFAULT NULL COMMENT '单据号',
  `cus_id` int(11) DEFAULT NULL COMMENT '客户id',
  `cus_name` varchar(20) DEFAULT '' COMMENT '客户姓名',
  `cus_iphone` varchar(20) DEFAULT '' COMMENT '客户手机',
  `use_name` varchar(20) DEFAULT '' COMMENT '使用人',
  `use_iphone` varchar(20) DEFAULT '' COMMENT '使用人手机',
  `use_type` tinyint(4) DEFAULT '1' COMMENT '使用人类型 1:个人 2公司',
  `card_type` tinyint(4) DEFAULT NULL COMMENT '证件类型',
  `number` varchar(50) DEFAULT '' COMMENT '号码',
  `delivery_date` date DEFAULT NULL COMMENT '预计交车日期',
  `car_id` int(11) DEFAULT NULL COMMENT '车辆id',
  `sale_price` decimal(10,0) DEFAULT NULL COMMENT '车辆销售价',
  `amount` decimal(10,0) DEFAULT NULL COMMENT '订单总额',
  `deposit` decimal(10,0) DEFAULT NULL COMMENT '定金',
  `status` tinyint(4) DEFAULT '0' COMMENT '订单状态',
  `car_status` tinyint(4) DEFAULT '0' COMMENT '整车状态',
  `boutique_status` tinyint(4) DEFAULT '0' COMMENT '精品状态',
  `insurer_status` tinyint(4) DEFAULT '0' COMMENT '保险状态',
  `extension_status` tinyint(4) DEFAULT '0' COMMENT '延保状态',
  `finance_status` tinyint(4) DEFAULT '0' COMMENT '金融状态',
  `other_status` tinyint(4) DEFAULT '0' COMMENT '其他状态',
  `margin` decimal(10,0) DEFAULT NULL COMMENT '订单毛利',
  `service_id` int(11) DEFAULT NULL COMMENT '售后服务人员id',
  `create_id` int(11) DEFAULT NULL COMMENT '销售顾问id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for order_extension
-- ----------------------------

CREATE TABLE `order_extension` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `extension_id` int(11) DEFAULT NULL COMMENT '延保套餐id',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `state` tinyint(1) NOT NULL COMMENT '延保单状态',
  `deadline` date DEFAULT NULL COMMENT '延保到期日',
  `insurance_date` date DEFAULT NULL COMMENT '投保日期',
  `number` varchar(255) DEFAULT '' COMMENT '延保单号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单——延保信息';

-- ----------------------------
-- Records of order_extension
-- ----------------------------

-- ----------------------------
-- Table structure for order_file
-- ----------------------------

CREATE TABLE `order_file` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_id` int(20) DEFAULT NULL COMMENT '订单id',
  `img_url` varchar(200) DEFAULT '' COMMENT '文件地址',
  `type` tinyint(4) DEFAULT '1' COMMENT '类型: 1:交车 2:其他',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `data_status` tinyint(4) DEFAULT '1' COMMENT '状态: 0:删除 1:正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单文件表';

-- ----------------------------
-- Records of order_file
-- ----------------------------

-- ----------------------------
-- Table structure for order_finance
-- ----------------------------

CREATE TABLE `order_finance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `finance_id` int(11) DEFAULT NULL COMMENT '金融公司id',
  `loan_amount` decimal(10,0) DEFAULT NULL COMMENT '贷款金额',
  `down_payment` decimal(10,0) DEFAULT NULL COMMENT '首付',
  `loan_rate` decimal(10,0) DEFAULT NULL COMMENT '利率',
  `loan_term` int(11) DEFAULT NULL COMMENT '贷款期限（月）',
  `bond` decimal(10,0) DEFAULT NULL COMMENT '保证金',
  `charge` decimal(10,0) DEFAULT NULL COMMENT '服务费',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `loan_status` tinyint(4) DEFAULT NULL COMMENT '贷款状态',
  `loan_date` date DEFAULT NULL COMMENT '放款日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单-金融服务';

-- ----------------------------
-- Records of order_finance
-- ----------------------------

-- ----------------------------
-- Table structure for order_insurance
-- ----------------------------

CREATE TABLE `order_insurance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `insurance_company_id` int(11) DEFAULT NULL COMMENT '保险公司id',
  `insurance_id` int(11) DEFAULT NULL COMMENT '险种id',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `sum_money` decimal(10,0) DEFAULT NULL COMMENT '金额',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `collection_state` tinyint(1) NOT NULL COMMENT '收款状态',
  `state` tinyint(1) NOT NULL COMMENT '保险单状态',
  `deadline` date DEFAULT NULL COMMENT '保险到期日',
  `number` varchar(255) DEFAULT '' COMMENT '保险单号',
  `insurance_date` date DEFAULT NULL COMMENT '投保日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单-保险表';

-- ----------------------------
-- Records of order_insurance
-- ----------------------------

-- ----------------------------
-- Table structure for order_quoted_price
-- ----------------------------

CREATE TABLE `order_quoted_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_id` int(11) NOT NULL COMMENT '订单ID',
  `boutique_order_id` int(11) DEFAULT NULL,
  `number` varchar(255) NOT NULL COMMENT '报价单号',
  `vehicle_name` varchar(255) DEFAULT '' COMMENT '车型名称',
  `vehicle_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '车型售价',
  `boutique_price` decimal(10,2) DEFAULT '0.00' COMMENT '精品售价',
  `order_sum_price` decimal(10,2) NOT NULL COMMENT '订单总额',
  `pay_first` decimal(10,2) DEFAULT NULL COMMENT '定金',
  `profit` decimal(10,2) NOT NULL COMMENT '综合毛利',
  `apply_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '申请时间',
  `state` tinyint(1) NOT NULL COMMENT '审批状态',
  `creat_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报价表';

-- ----------------------------
-- Records of order_quoted_price
-- ----------------------------

-- ----------------------------
-- Table structure for order_service
-- ----------------------------

CREATE TABLE `order_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `service_id` varchar(255) DEFAULT NULL COMMENT '服务项名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单-其他服务';

-- ----------------------------
-- Records of order_service
-- ----------------------------

-- ----------------------------
-- Table structure for passenger_flow
-- ----------------------------

CREATE TABLE `passenger_flow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `employee_id` int(11) DEFAULT NULL COMMENT '销售员工id',
  `replace_employee_id` int(11) DEFAULT NULL COMMENT '替岗销售id',
  `cus_id` int(11) DEFAULT NULL COMMENT '客户id',
  `type` tinyint(4) DEFAULT '1' COMMENT '客流到店类型 1:首次 2:再次',
  `isleave` tinyint(4) DEFAULT '1' COMMENT '是否离店 1:在店 2:离店',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint(4) DEFAULT '1' COMMENT '客流状态 1:未接待 2:未留档 3:完成',
  `data_status` tinyint(4) DEFAULT '1' COMMENT '数据状态 0:已删除  1:正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='客流表';

-- ----------------------------
-- Records of passenger_flow
-- ----------------------------
INSERT INTO `passenger_flow` VALUES ('1', '1', '1', '2', '1', '1', '1', '2018-06-01 14:36:14', '1', '1');
INSERT INTO `passenger_flow` VALUES ('2', '2', '2', '2', '2', '1', '1', '2018-06-01 16:04:32', '2', '1');
INSERT INTO `passenger_flow` VALUES ('3', '3', '3', '3', '3', '1', '1', '2018-06-01 16:04:50', '3', '1');
INSERT INTO `passenger_flow` VALUES ('4', '1', '1', '2', '1', '2', '1', '2018-06-01 16:31:11', '1', '2');
INSERT INTO `passenger_flow` VALUES ('5', '1', '1', '1', null, '2', '1', '2018-06-01 16:33:34', '1', '2');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------

CREATE TABLE `permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `permission_desc` varchar(50) DEFAULT NULL COMMENT '权限描述',
  `type` tinyint(4) DEFAULT '1' COMMENT '权限类型 1菜单 2页面 3按钮',
  `url` varchar(300) DEFAULT NULL COMMENT '权限url',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级id',
  `sort_no` int(11) DEFAULT NULL COMMENT '排序',
  `status` tinyint(4) DEFAULT NULL COMMENT '0启用 1禁用',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `icon_url` varchar(128) DEFAULT '' COMMENT '图标链接',
  `data_status` tinyint(4) DEFAULT '1' COMMENT '数据状态 0已删除 1正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of permissions
-- ----------------------------

-- ----------------------------
-- Table structure for plan_extraction
-- ----------------------------

CREATE TABLE `plan_extraction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_id` int(11) NOT NULL COMMENT '车辆id',
  `vin` varchar(30) NOT NULL COMMENT 'vin',
  `plan_extraction_date` varchar(10) DEFAULT NULL COMMENT '计提年月',
  `employee_id` int(11) DEFAULT '0' COMMENT '操作人',
  `create_date` datetime NOT NULL COMMENT '数据创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计提表';

-- ----------------------------
-- Records of plan_extraction
-- ----------------------------

-- ----------------------------
-- Table structure for proofreader_list
-- ----------------------------

CREATE TABLE `proofreader_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rebate_project_id` int(11) NOT NULL COMMENT '返利项目表id',
  `employee_id` int(11) DEFAULT '0' COMMENT '操作人',
  `create_date` datetime NOT NULL COMMENT '数据创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='核对单';

-- ----------------------------
-- Records of proofreader_list
-- ----------------------------

-- ----------------------------
-- Table structure for province
-- ----------------------------

CREATE TABLE `province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province_name` varchar(255) DEFAULT NULL COMMENT '全称',
  `pinyin` varchar(40) DEFAULT NULL COMMENT '拼音',
  `order_by` char(2) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `short_province_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('1', '北京市', 'beijing', 'B', '1', '');
INSERT INTO `province` VALUES ('2', '天津市', 'tianjin', 'T', '1', null);
INSERT INTO `province` VALUES ('3', '河北省', 'hebei', 'H', '1', null);
INSERT INTO `province` VALUES ('4', '山西省', 'shanxi', 'S', '1', null);
INSERT INTO `province` VALUES ('5', '内蒙古自治区', 'neimenggu', 'N', '1', null);
INSERT INTO `province` VALUES ('6', '辽宁省', 'liaoning', 'L', '1', null);
INSERT INTO `province` VALUES ('7', '吉林省', 'jilin', 'J', '1', null);
INSERT INTO `province` VALUES ('8', '黑龙江省', 'heilongjiang', 'H', '1', null);
INSERT INTO `province` VALUES ('9', '上海市', 'shanghai', 'S', '1', null);
INSERT INTO `province` VALUES ('10', '江苏省', 'jiangsu', 'J', '1', null);
INSERT INTO `province` VALUES ('11', '浙江省', 'zhejiang', 'Z', '1', null);
INSERT INTO `province` VALUES ('12', '安徽省', 'anhui', 'A', '1', null);
INSERT INTO `province` VALUES ('13', '福建省', 'fujian', 'F', '1', null);
INSERT INTO `province` VALUES ('14', '江西省', 'jiangxi', 'J', '1', null);
INSERT INTO `province` VALUES ('15', '山东省', 'shandong', 'S', '1', null);
INSERT INTO `province` VALUES ('16', '河南省', 'henan', 'H', '1', null);
INSERT INTO `province` VALUES ('17', '湖北省', 'hubei', 'H', '1', null);
INSERT INTO `province` VALUES ('18', '湖南省', 'hunan', 'H', '1', null);
INSERT INTO `province` VALUES ('19', '广东省', 'guangdong', 'G', '1', null);
INSERT INTO `province` VALUES ('20', '广西壮族自治区', 'guangxi', 'G', '1', null);
INSERT INTO `province` VALUES ('21', '海南省', 'hainan', 'H', '1', null);
INSERT INTO `province` VALUES ('22', '重庆市', 'chongqing', 'C', '1', null);
INSERT INTO `province` VALUES ('23', '四川省', 'sichuan', 'S', '1', null);
INSERT INTO `province` VALUES ('24', '贵州省', 'guizhou', 'G', '1', null);
INSERT INTO `province` VALUES ('25', '云南省', 'yunnan', 'Y', '1', null);
INSERT INTO `province` VALUES ('26', '西藏自治区', 'xizang', 'X', '1', null);
INSERT INTO `province` VALUES ('27', '陕西省', 'shanxi', 'S', '1', null);
INSERT INTO `province` VALUES ('28', '甘肃省', 'gansu', 'G', '1', null);
INSERT INTO `province` VALUES ('29', '青海省', 'qinghai', 'Q', '1', null);
INSERT INTO `province` VALUES ('30', '宁夏回族自治区', 'ningxia', 'N', '1', null);
INSERT INTO `province` VALUES ('31', '新疆维吾尔自治区', 'xinjiang', 'X', '1', null);
INSERT INTO `province` VALUES ('32', '台湾省', 'taiwan', 'T', '0', null);
INSERT INTO `province` VALUES ('33', '香港特别行政区', 'xianggang', 'X', '0', null);
INSERT INTO `province` VALUES ('34', '澳门特别行政区', 'aomen', 'A', '0', null);

-- ----------------------------
-- Table structure for rebate_car
-- ----------------------------

CREATE TABLE `rebate_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rebate_project_id` int(11) NOT NULL COMMENT '返利项目表id',
  `car_id` int(11) NOT NULL COMMENT '车辆id',
  `vin` varchar(30) NOT NULL COMMENT 'vin',
  `first_estimate_rebate` decimal(8,2) DEFAULT '0.00' COMMENT '首次预估返利',
  `estimate_adjust` decimal(8,2) DEFAULT '0.00' COMMENT '预估调整',
  `plan_extraction` decimal(8,2) DEFAULT '0.00' COMMENT '计提金额',
  `plan_extraction_adjust` decimal(8,2) DEFAULT '0.00' COMMENT '计提调整',
  `is_plan_extraction` tinyint(3) DEFAULT '0' COMMENT '财务是否确定计提 0待确认，1已确认',
  `plan_extraction_date` datetime DEFAULT NULL COMMENT '计提时间',
  `proofreader_id` int(11) DEFAULT NULL COMMENT '核对单id',
  `proofreader_money` decimal(8,2) DEFAULT '0.00' COMMENT '核对金额',
  `proofreader_date` datetime DEFAULT NULL COMMENT '核对时间',
  `arrive_bill_id` int(11) DEFAULT NULL COMMENT '到账单id',
  `arrive_bill_money` decimal(8,2) DEFAULT '0.00' COMMENT '到账金额',
  `arrive_bill_date` datetime DEFAULT NULL COMMENT '到账时间',
  `employee_id` int(11) DEFAULT '0' COMMENT '操作人',
  `create_date` datetime NOT NULL COMMENT '数据创建时间',
  `update_date` datetime NOT NULL COMMENT '数据修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='返利车辆关联表';

-- ----------------------------
-- Records of rebate_car
-- ----------------------------

-- ----------------------------
-- Table structure for rebate_project
-- ----------------------------

CREATE TABLE `rebate_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rebate_code` varchar(12) NOT NULL COMMENT '返利项目编号',
  `policy_id` int(11) NOT NULL COMMENT '商务政策表id commerce_policy.id',
  `rebate_name` varchar(25) NOT NULL COMMENT '返利项目名称',
  `rebate_project_type` tinyint(3) DEFAULT '0' COMMENT '返利项目类型 1固定折让 ，2车型折让',
  `report_material_requirements` tinyint(3) DEFAULT '0' COMMENT '上报材料要求 1DMS日期/开票日期，2入库日期',
  `rebate_start_date` datetime NOT NULL COMMENT '返利开始时间',
  `rebate_end_date` datetime NOT NULL COMMENT '返利结束时间',
  `rebate_type` tinyint(3) NOT NULL COMMENT '返利类型 1百分比 ，2 金额',
  `rebate_type_value` decimal(8,4) DEFAULT '0.0000' COMMENT '返利类型数值',
  `rebate_number` int(11) DEFAULT '0' COMMENT '返利台数',
  `first_estimate_total` decimal(8,2) DEFAULT '0.00' COMMENT '首次预估返利总计（计算改返利项目下所有车的首次预估返利）',
  `estimate_adjust_total` decimal(8,2) DEFAULT '0.00' COMMENT '预估调整总计',
  `plan_extraction_total` decimal(8,2) DEFAULT '0.00' COMMENT '计提金额总计',
  `plan_extraction_adjust_total` decimal(8,2) DEFAULT '0.00' COMMENT '计提调整总计',
  `status` int(11) DEFAULT '1' COMMENT '状态  0暂存，1生效',
  `employee_id` int(11) DEFAULT '0' COMMENT '操作人',
  `create_date` datetime NOT NULL COMMENT '数据创建时间',
  `update_date` datetime NOT NULL COMMENT '数据修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='返利项目表';

-- ----------------------------
-- Records of rebate_project
-- ----------------------------

-- ----------------------------
-- Table structure for receipt
-- ----------------------------

CREATE TABLE `receipt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `pay_name` varchar(255) DEFAULT NULL COMMENT '付款人',
  `pay_type` int(11) DEFAULT NULL COMMENT '付款方式',
  `receipt_type` varchar(255) DEFAULT NULL COMMENT '业务类型',
  `amount` decimal(10,0) DEFAULT NULL COMMENT '付款总额',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '付款状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='付款表';

-- ----------------------------
-- Records of receipt
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT '' COMMENT '角色名称',
  `role_desc` varchar(50) DEFAULT '' COMMENT '角色描述',
  `status` tinyint(4) DEFAULT '0' COMMENT '数据状态 0 启用 1禁用',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------

CREATE TABLE `role_permission` (
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '按钮id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色_按钮_权限表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for set_meal
-- ----------------------------

CREATE TABLE `set_meal` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '类型（1.套餐 2:代金券）',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
  `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效（0：无效 1：有效）',
  `money` decimal(10,2) NOT NULL COMMENT '金额/面额',
  `img_url` varchar(255) DEFAULT '' COMMENT '图片',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `deadline` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '过期时间',
  `product_names` varchar(255) DEFAULT '' COMMENT '商品名称（用，隔开）',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `operator_id` int(11) NOT NULL COMMENT '操作人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='套餐-代金券表';

-- ----------------------------
-- Records of set_meal
-- ----------------------------

-- ----------------------------
-- Table structure for store_service
-- ----------------------------

CREATE TABLE `store_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_name` varchar(255) DEFAULT NULL COMMENT '服务名称',
  `service_price` decimal(10,0) DEFAULT NULL COMMENT '服务价格',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `employee_id` int(11) DEFAULT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门店服务表';

-- ----------------------------
-- Records of store_service
-- ----------------------------

-- ----------------------------
-- Table structure for task_follow_up
-- ----------------------------

CREATE TABLE `task_follow_up` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `order_status` int(11) DEFAULT NULL COMMENT '订单状态',
  `customer_id` int(11) NOT NULL COMMENT '客户id',
  `chennel` int(3) NOT NULL COMMENT '跟进方式',
  `content` int(3) NOT NULL COMMENT '内容',
  `arrive_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '到店时间',
  `hand_over_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '交付时间',
  `remark` varchar(255) DEFAULT '' COMMENT '反馈',
  `this_date` date NOT NULL COMMENT '本次跟进时间',
  `next_date` date DEFAULT NULL COMMENT '下次跟进日期',
  `next_chennel` int(255) DEFAULT NULL COMMENT '下次跟进方式',
  `next_content` int(3) DEFAULT NULL COMMENT '下次跟进内容',
  `next_remark` varchar(255) DEFAULT '' COMMENT '下次跟进备注',
  `task_type` tinyint(4) DEFAULT '0' COMMENT '任务类型 1:潜客跟进 2:潜客邀约 3:订单跟进 4:今日交车 5:后续服务',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户跟进表';

-- ----------------------------
-- Records of task_follow_up
-- ----------------------------

-- ----------------------------
-- Table structure for test_drive
-- ----------------------------

CREATE TABLE `test_drive` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) DEFAULT NULL COMMENT '客户id',
  `employee_id` int(11) DEFAULT NULL COMMENT '员工id',
  `car_id` int(11) DEFAULT NULL COMMENT '试驾车id',
  `drive_time` int(11) DEFAULT '0' COMMENT '试驾时间',
  `purpose` varchar(255) DEFAULT NULL COMMENT '用途',
  `drive_mileage` int(11) DEFAULT '0' COMMENT '试驾里程',
  `end_mileage` int(11) DEFAULT NULL COMMENT '结束里程',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '试驾状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试乘试驾';

-- ----------------------------
-- Records of test_drive
-- ----------------------------

-- ----------------------------
-- Table structure for transact_customer
-- ----------------------------

CREATE TABLE `transact_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `phone_num` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `duty_name` varchar(20) DEFAULT NULL COMMENT '责任人',
  `cause` varchar(255) DEFAULT NULL COMMENT '事由',
  `license_plate` varchar(20) DEFAULT NULL COMMENT '车牌',
  `group_id` int(11) DEFAULT NULL COMMENT '集团id',
  `store_id` int(11) DEFAULT NULL COMMENT '门店id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `data_status` tinyint(4) DEFAULT '1' COMMENT '数据状态 1在用 0删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='办事人员';

-- ----------------------------
-- Records of transact_customer
-- ----------------------------
