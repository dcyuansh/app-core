/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-06-16 17:53:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wf_def
-- ----------------------------
DROP TABLE IF EXISTS `wf_def`;
CREATE TABLE `wf_def` (
  `wf_id` int(11) NOT NULL AUTO_INCREMENT,
  `wf_code` varchar(255) NOT NULL,
  `wf_name` varchar(255) NOT NULL,
  `state` varchar(20) DEFAULT NULL,
  `wf_desc` varchar(500) DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`wf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wf_def
-- ----------------------------
