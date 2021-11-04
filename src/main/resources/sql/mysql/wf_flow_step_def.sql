/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 80012
Source Host           : 106.14.202.126:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-11-04 10:14:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wf_flow_step_def
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_step_def`;
CREATE TABLE `wf_flow_step_def` (
  `flow_step_id` int(11) NOT NULL AUTO_INCREMENT,
  `wf_code` varchar(255) NOT NULL,
  `step_code` varchar(255) NOT NULL,
  `state` varchar(20) NOT NULL,
  `assignee` varchar(100) DEFAULT NULL,
  `assignee_group` varchar(100) DEFAULT NULL,
  `step_type` varchar(10) NOT NULL,
  `step_repeat_no` int(11) DEFAULT NULL,
  `order_no` int(11) NOT NULL,
  `from_step_code` varchar(255) DEFAULT NULL,
  `to_step_code` varchar(255) DEFAULT NULL,
  `flow_step_desc` varchar(500) DEFAULT NULL,
  `is_multi` varchar(10) DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`flow_step_id`),
  UNIQUE KEY `indx_flow_step_def` (`wf_code`,`step_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wf_flow_step_def
-- ----------------------------
