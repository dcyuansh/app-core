/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 80012
Source Host           : 106.14.202.126:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-11-04 10:13:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pms_task
-- ----------------------------
DROP TABLE IF EXISTS `pms_task`;
CREATE TABLE `pms_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_no` varchar(50) NOT NULL,
  `task_type` varchar(50) DEFAULT NULL,
  `task_subject` varchar(200) DEFAULT NULL,
  `task_content` text,
  `system_name` varchar(100) DEFAULT NULL,
  `estimated_effort` decimal(12,2) DEFAULT NULL,
  `actual_effort` decimal(12,2) DEFAULT NULL,
  `created_by` varchar(150) DEFAULT NULL,
  `assignee` varchar(150) DEFAULT NULL,
  `severity` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `attached_id` varchar(20) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `indx_task_no` (`task_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_task
-- ----------------------------
INSERT INTO `pms_task` VALUES ('27', 'ITSR100001', 'Request', 'RDM ETL抽取goald中的表tpbldg', 'RDM ETL抽取goald中的表tpbldg', 'East Plus', '8.00', '8.00', 'yuandechun', 'yuandechun', 'Hight', 'Resolve', null, null, '2021-07-19 14:16:40', '2021-07-21 17:20:18');
INSERT INTO `pms_task` VALUES ('28', 'ITSR100002', 'Request', 'ETL抽取Fars表fars_MISC_AR_OPEN_ITEM', 'ETL抽取Fars表fars_MISC_AR_OPEN_ITEM', 'East Plus', '8.00', null, 'yuandechun', 'yuandechun', 'Hight', 'NotStart', null, null, '2021-07-19 14:17:22', '2021-07-21 18:09:50');
INSERT INTO `pms_task` VALUES ('29', 'ITSR100003', 'Request', 'ETL，内科数据库FARpt，中抓取全量表CIRCReportMap', 'ETL，内科数据库FARpt，中抓取全量表CIRCReportMap', 'East Plus', '8.00', '8.00', 'yuandechun', 'yuandechun', 'Hight', 'Resolve', null, null, '2021-07-20 11:01:44', '2021-07-20 18:54:26');
INSERT INTO `pms_task` VALUES ('30', 'ITSR100004', 'Request', '修改eLite的mapping文档', '修改eLite的mapping文档', 'East Plus', '8.00', '8.00', 'yuandechun', 'yuandechun', 'Hight', 'Resolve', null, null, '2021-07-20 12:44:25', '2021-07-20 14:24:27');
INSERT INTO `pms_task` VALUES ('31', 'ITSR100005', 'Request', 'East创建历史job', '给east创建历史job抽取3年的eLite，Ledger数据', 'East Plus', '8.00', '8.00', 'yuandechun', 'yuandechun', 'Hight', 'Resolve', null, null, '2021-07-21 11:28:48', '2021-07-21 11:29:21');
INSERT INTO `pms_task` VALUES ('32', 'ITSR100006', 'Request', 'ETL抽取goald表TCLMVOUCH', 'ETL抽取goald表TCLMVOUCH', 'East Plus', '8.00', '8.00', 'yuandechun', 'yuandechun', 'Hight', 'Resolve', null, null, '2021-07-21 15:19:24', '2021-07-21 17:20:29');
INSERT INTO `pms_task` VALUES ('33', 'ITSR100007', 'Defect', ' SP_EAST_VOUCHER_INFO调度中，SP应该没有参数', '错误内容:Procedure SP_EAST_VOUCHER_INFO has no parameters and arguments were supplied.', 'East Plus', '11.00', '11.00', 'fanjianbo', 'yuandechun', 'Hight', 'Resolve', null, null, '2021-07-21 17:28:23', '2021-07-27 10:09:54');
INSERT INTO `pms_task` VALUES ('34', 'ITSR100008', 'Defect', 'sp_east_policy_Business_interruption类型转换报错', 'sp_east_policy_Business_interruption:Error converting data type varchar to numeric.', 'East Plus', '8.00', '8.00', 'yuandechun', 'yuandechun', 'Hight', 'Resolve', null, null, '2021-07-21 17:39:36', '2021-07-27 10:10:01');
INSERT INTO `pms_task` VALUES ('35', 'ITSR100009', 'Defect', 'dbo.SP_East_ClaimExtent内容截取掉了，报错', 'dbo.SP_East_ClaimExtent：String or binary data would be truncated.', 'East Plus', '8.00', '8.00', 'yuandechun', 'yuandechun', 'Hight', 'Resolve', null, null, '2021-07-21 17:46:43', '2021-07-27 10:09:46');
INSERT INTO `pms_task` VALUES ('36', 'ITSR100010', 'Defect', 'East数据库中rdm.CLAIM_ACCHLT表中缺少pd_degree字段', 'dbo.dbo.SP_RDM_II_CLAIM_ACCHLT：Invalid column name \'pd_degree\'', 'East Plus', '8.00', '8.00', 'yuandechun', 'yuandechun', 'Hight', 'Resolve', null, '不是问题，是由于刷RDM数据库库的时候SIT环境更生成环境不一致导致的问题。', '2021-07-21 17:56:21', '2021-07-27 10:09:08');
INSERT INTO `pms_task` VALUES ('37', 'ITSR100011', 'Request', 'East RTM文档', '写East Plus的RTM文档', 'East Plus', '24.00', '4.00', 'yuandechun', 'yuandechun', 'Hight', 'InProgress', null, null, '2021-07-22 14:42:59', '2021-07-22 16:02:40');
INSERT INTO `pms_task` VALUES ('38', 'ITSR100012', 'Request', 'East CAD文档', '写East Plus项目CAD文档', 'East Plus', '40.00', '24.00', 'yuandechun', 'yuandechun', 'Hight', 'InProgress', null, null, '2021-07-22 16:01:50', '2021-07-22 16:02:09');
INSERT INTO `pms_task` VALUES ('39', 'ITSR100013', 'Defect', '保单基本信息表相关问题', '保单基本信息表相关问题', 'East Plus', '8.00', null, 'yuandechun', 'lixiong', 'Hight', 'Resolve', null, '不是问题，测试团队的问题，他们不太会关联查询数据查询数据', '2021-07-23 11:04:55', '2021-07-23 13:09:25');
INSERT INTO `pms_task` VALUES ('40', 'ITSR100014', 'Defect', '意健险赔案扩展信息表相关问题', '意健险赔案扩展信息表相关问题', 'East Plus', '8.00', null, 'yuandechun', 'liulei', 'Hight', 'Resolve', null, '不是问题，新加的字段为空，SIT环境没有新做数据，所以新加的字段为空', '2021-07-23 11:05:20', '2021-07-23 13:10:14');
INSERT INTO `pms_task` VALUES ('41', 'ITSR100015', 'Request', 'intranet-ETL', '收付费表里加了一段从intranet抽数的逻辑,附件就是intrnaet这次新增字段', 'East Plus', '8.00', null, 'yuandechun', 'yuandechun', 'Hight', 'NotStart', null, null, '2021-07-27 15:20:10', '2021-07-27 15:22:11');
