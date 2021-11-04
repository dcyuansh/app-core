/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 80012
Source Host           : 106.14.202.126:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-11-04 10:14:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wf_proc
-- ----------------------------
DROP TABLE IF EXISTS `wf_proc`;
CREATE TABLE `wf_proc` (
  `proc_id` int(11) NOT NULL AUTO_INCREMENT,
  `wf_code` varchar(255) NOT NULL,
  `step_code` varchar(255) NOT NULL,
  `business_id` varchar(100) DEFAULT NULL,
  `state` varchar(20) NOT NULL,
  `assignee` varchar(100) DEFAULT NULL,
  `assignee_group` varchar(100) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `owner_id` varchar(100) NOT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`proc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wf_proc
-- ----------------------------
