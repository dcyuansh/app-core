/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-06-16 17:52:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pms_task_his
-- ----------------------------
DROP TABLE IF EXISTS `pms_task_his`;
CREATE TABLE `pms_task_his` (
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_task_his
-- ----------------------------
INSERT INTO `pms_task_his` VALUES ('31', 'ITSR100001', 'Defect', 'tests bug', '测试错误', 'Saas', '1.00', null, 'admin', 'yuandechun', null, 'NotStart', null, null, '2020-08-07 15:11:20', '2020-08-07 15:11:20');
INSERT INTO `pms_task_his` VALUES ('32', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', '1.00', null, 'admin', 'yuandechun', null, 'NotStart', null, null, '2020-08-07 22:15:51', '2020-08-07 22:15:51');
INSERT INTO `pms_task_his` VALUES ('33', 'ITSR100002', 'Request', '测试新建任务1', '测试新建任务1', 'Saas', '8.00', null, 'admin', 'yuandechun', 'Hight', 'NotStart', null, null, '2020-11-26 16:37:57', '2020-11-26 16:37:57');
INSERT INTO `pms_task_his` VALUES ('34', 'ITSR100002', 'Request', '测试新建任务1', '测试新建任务1', 'Saas', '8.00', null, 'admin', 'suichengbin', 'Hight', 'NotStart', null, null, '2020-11-26 16:38:07', '2020-11-26 16:38:07');
INSERT INTO `pms_task_his` VALUES ('35', 'ITSR100002', 'Request', '测试新建任务1', '测试新建任务1', 'Saas', '8.00', '1.00', 'admin', 'suichengbin', 'Hight', 'InProgress', null, null, '2020-11-26 16:38:20', '2020-11-26 16:38:20');
INSERT INTO `pms_task_his` VALUES ('36', 'ITSR100002', 'Request', '测试新建任务1', '测试新建任务1', 'Saas', '8.00', '2.00', 'yuandechun', 'suichengbin', 'Hight', 'InProgress', null, null, '2020-11-27 13:43:02', '2020-11-27 13:43:02');
INSERT INTO `pms_task_his` VALUES ('37', 'ITSR100003', 'Enhancement', '测试任务二', '测试获取当前用户是否成功', 'Saas', '1.00', null, 'yuandechun', 'yuandechun', 'Hight', 'NotStart', null, null, '2020-11-27 13:49:01', '2020-11-27 13:49:01');
INSERT INTO `pms_task_his` VALUES ('38', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', '1.00', '1.00', 'yuandechun', 'yuandechun', null, 'InProgress', null, null, '2020-11-27 13:49:31', '2020-11-27 13:49:31');
INSERT INTO `pms_task_his` VALUES ('39', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', '1.00', '1.00', 'yuandechun', 'yuandechun', null, 'Resolve', null, null, '2020-11-27 13:49:36', '2020-11-27 13:49:36');
INSERT INTO `pms_task_his` VALUES ('40', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', '1.00', '1.00', 'yuandechun', 'yuandechun', null, 'Closed', null, null, '2020-12-01 17:30:15', '2020-12-01 17:30:15');
INSERT INTO `pms_task_his` VALUES ('41', 'ITSR100003', 'CR', '测试任务二', '测试获取当前用户是否成功', 'Saas', '1.00', null, 'yuandechun', 'yuandechun', 'Hight', 'NotStart', null, null, '2020-12-08 17:03:00', '2020-12-08 17:03:00');
INSERT INTO `pms_task_his` VALUES ('42', 'ITSR100003', 'CR', '测试任务二', '测试获取当前用户是否成功', 'Saas', '1.00', '2.00', 'yuandechun', 'yuandechun', 'Hight', 'NotStart', null, null, '2020-12-08 17:16:24', '2020-12-08 17:16:24');
INSERT INTO `pms_task_his` VALUES ('43', 'ITSR100002', 'Request', '测试新建任务1', '测试新建任务1', 'Saas', '8.00', '4.00', 'yuandechun', 'suichengbin', 'Hight', 'InProgress', null, null, '2020-12-08 17:19:30', '2020-12-08 17:19:30');
INSERT INTO `pms_task_his` VALUES ('44', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', '1.00', '1.00', 'yuandechun', 'yuandechun', null, 'ReOpen', null, null, '2020-12-08 17:25:05', '2020-12-08 17:25:05');
INSERT INTO `pms_task_his` VALUES ('45', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', '1.00', '1.00', 'yuandechun', 'AD', null, 'ReOpen', null, null, '2020-12-09 14:35:24', '2020-12-09 14:35:24');
INSERT INTO `pms_task_his` VALUES ('46', 'ITSR100003', 'CR', '测试任务二', '测试获取当前用户是否成功', 'Saas', '1.00', '2.00', 'yuandechun', 'yuandechun', 'Hight', 'InProgress', null, null, '2020-12-10 15:04:11', '2020-12-10 15:04:11');
INSERT INTO `pms_task_his` VALUES ('47', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', '1.00', '2.00', 'yuandechun', 'AD', null, 'ReOpen', null, null, null, null);
INSERT INTO `pms_task_his` VALUES ('48', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', '1.00', '4.00', 'yuandechun', 'AD', null, 'ReOpen', null, null, null, null);
INSERT INTO `pms_task_his` VALUES ('49', 'ITSR100003', 'CR', '测试任务二', '测试获取当前用户是否成功', 'Saas', '1.00', '8.00', 'yuandechun', 'yuandechun', 'Hight', 'InProgress', null, null, null, null);
INSERT INTO `pms_task_his` VALUES ('50', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', '1.00', '16.00', 'yuandechun', 'AD', null, 'ReOpen', null, null, null, null);
INSERT INTO `pms_task_his` VALUES ('51', 'ITSR100002', 'Request', '测试新建任务1', '测试新建任务1', 'Saas', '8.00', '16.00', 'yuandechun', 'suichengbin', 'Hight', 'InProgress', null, null, null, null);
INSERT INTO `pms_task_his` VALUES ('52', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', '1.00', '6.00', 'yuandechun', 'AD', null, 'ReOpen', null, null, null, null);
INSERT INTO `pms_task_his` VALUES ('53', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', '1.00', '10.00', 'yuandechun', 'AD', null, 'ReOpen', null, null, null, null);
INSERT INTO `pms_task_his` VALUES ('54', 'ITSR100004', 'Defect', '测试用户信息', '测试用户信息', 'Saas', '10.00', null, 'yuandechun', null, 'Hight', 'NotStart', null, null, null, null);
INSERT INTO `pms_task_his` VALUES ('55', 'ITSR100004', 'Defect', '测试用户信息', '测试用户信息', 'Saas', '10.00', null, 'yuandechun', 'AD', 'Hight', 'NotStart', null, null, '2021-03-22 16:21:51', '2021-03-22 16:21:51');
INSERT INTO `pms_task_his` VALUES ('56', 'ITSR100004', 'Defect', '测试用户信息', '测试用户信息', 'Saas', '10.00', null, 'yuandechun', 'AD', 'Hight', 'InProgress', null, null, '2021-03-22 16:22:09', '2021-03-22 16:22:09');
INSERT INTO `pms_task_his` VALUES ('57', 'ITSR100004', 'Defect', '测试用户信息', '测试用户信息', 'Saas', '10.00', '12.00', 'yuandechun', 'AD', 'Hight', 'InProgress', null, null, '2021-03-22 17:05:58', '2021-03-22 17:05:58');
INSERT INTO `pms_task_his` VALUES ('58', 'ITSR100004', 'Defect', '测试用户信息', '测试用户信息', 'Saas', '10.00', '12.00', 'yuandechun', 'AD', 'Hight', 'InProgress', null, null, '2021-03-22 17:10:33', '2021-03-22 17:10:33');
INSERT INTO `pms_task_his` VALUES ('59', 'ITSR100003', 'CR', '测试任务二', '测试获取当前用户是否成功', 'Saas', '1.00', '10.00', 'yuandechun', 'yuandechun', 'Hight', 'InProgress', null, null, '2021-03-22 17:10:45', '2021-03-22 17:10:45');
INSERT INTO `pms_task_his` VALUES ('60', 'ITSR100003', 'CR', '测试任务二', '测试获取当前用户是否成功', 'Saas', '1.00', '10.00', 'yuandechun', 'AD', 'Hight', 'InProgress', null, null, '2021-03-23 12:59:25', '2021-03-23 12:59:25');
INSERT INTO `pms_task_his` VALUES ('61', 'ITSR100003', 'CR', '测试任务二', '测试获取当前用户是否成功', 'Saas', '1.00', '10.00', 'yuandechun', 'yuandechun', 'Hight', 'InProgress', null, null, '2021-03-23 12:59:35', '2021-03-23 12:59:35');
INSERT INTO `pms_task_his` VALUES ('62', 'ITSR100004', 'Defect', '测试用户信息', '测试用户信息', 'Saas', '10.00', '12.00', 'yuandechun', 'yuandechun', 'Hight', 'InProgress', null, null, '2021-03-23 12:59:41', '2021-03-23 12:59:41');
INSERT INTO `pms_task_his` VALUES ('63', 'ITSR100004', 'Defect', '测试用户信息', '测试用户信息', 'Saas', '10.00', '8.00', 'yuandechun', 'yuandechun', 'Hight', 'InProgress', null, null, '2021-03-23 12:59:52', '2021-03-23 12:59:52');
INSERT INTO `pms_task_his` VALUES ('64', 'ITSR100002', 'Request', '测试新建任务1', '测试新建任务1', 'Saas', '8.00', '16.00', 'anonymousUser', 'admin', 'Hight', 'InProgress', null, null, '2021-04-02 15:22:01', '2021-04-02 15:22:01');
