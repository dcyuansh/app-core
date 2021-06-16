/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-06-16 17:52:40
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_task
-- ----------------------------
INSERT INTO `pms_task` VALUES ('19', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', '1.00', '10.00', 'admin', 'AD', null, 'ReOpen', null, null, '2020-08-07 15:11:20', '2021-03-22 11:35:43');
INSERT INTO `pms_task` VALUES ('20', 'ITSR100002', 'Request', '测试新建任务1', '测试新建任务1', 'Saas', '8.00', '16.00', 'admin', 'admin', 'Hight', 'InProgress', null, null, '2020-11-26 16:37:56', '2021-04-02 15:22:01');
INSERT INTO `pms_task` VALUES ('21', 'ITSR100003', 'CR', '测试任务二', '测试获取当前用户是否成功', 'Saas', '1.00', '10.00', 'yuandechun', 'yuandechun', 'Hight', 'InProgress', null, null, '2020-11-27 13:49:01', '2021-03-23 12:59:35');
INSERT INTO `pms_task` VALUES ('22', 'ITSR100004', 'Defect', '测试用户信息', '测试用户信息', 'Saas', '10.00', '8.00', 'yuandechun', 'yuandechun', 'Hight', 'InProgress', null, null, '2021-03-22 00:00:00', '2021-03-23 12:59:52');
