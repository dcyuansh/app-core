/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-06-16 17:52:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pms_timesheet
-- ----------------------------
DROP TABLE IF EXISTS `pms_timesheet`;
CREATE TABLE `pms_timesheet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `work_day` date DEFAULT NULL,
  `actual_effort` decimal(12,2) DEFAULT NULL,
  `task_no` varchar(50) DEFAULT NULL,
  `task_type` varchar(50) DEFAULT NULL,
  `task_subject` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `task_content` text,
  `system_name` varchar(100) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_timesheet
-- ----------------------------
INSERT INTO `pms_timesheet` VALUES ('1', 'yuandechun', '2020-12-04', '8.00', 'ITSR100003', 'CR', '测试任务二', '测试获取当前用户是否成功', 'Saas', '下拉框好了', '2020-12-04 00:00:00', '2020-12-09 12:36:07');
INSERT INTO `pms_timesheet` VALUES ('2', 'yuandechun', '2020-12-08', '8.00', 'ITSR100002', 'Request', '测试新建任务1', '测试新建任务1', 'Saas', '测试', '2020-12-09 00:00:00', '2020-12-09 12:22:40');
INSERT INTO `pms_timesheet` VALUES ('3', 'yuandechun', '2020-12-09', '12.00', 'ITSR100002', 'Request', '测试新建任务1', '测试新建任务1', 'Saas', '开发测试', '2020-12-09 00:00:00', '2020-12-09 12:24:08');
INSERT INTO `pms_timesheet` VALUES ('7', 'yuandechun', '2020-12-02', '4.00', 'ITSR100003', 'CR', '测试任务二', '测试获取当前用户是否成功', 'Saas', '阿斯顿发送到', '2020-12-09 00:00:00', '2020-12-14 10:55:53');
INSERT INTO `pms_timesheet` VALUES ('9', 'yuandechun', '2020-12-02', '8.00', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', '测试insert date', '2020-12-10 14:50:04', '2020-12-10 14:50:04');
INSERT INTO `pms_timesheet` VALUES ('10', 'yuandechun', '2020-12-03', '8.00', 'ITSR100002', 'Request', '测试新建任务1', '测试新建任务1', 'Saas', 'insert date', '2020-12-10 14:50:53', '2020-12-10 14:50:53');
INSERT INTO `pms_timesheet` VALUES ('11', 'yuandechun', '2020-12-10', '8.00', 'ITSR100001', 'Defect', '测试TC001，页面没有下载按钮', '页面没有下载按钮，没法下载报表', 'Saas', 'circ 自动化，年报，分析', '2020-12-10 15:10:54', '2021-02-05 16:08:31');
