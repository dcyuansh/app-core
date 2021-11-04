/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 80012
Source Host           : 106.14.202.126:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-11-04 10:11:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comm_address
-- ----------------------------
DROP TABLE IF EXISTS `comm_address`;
CREATE TABLE `comm_address` (
  `address_id` varchar(50) NOT NULL,
  `addr_seq_no` int(11) DEFAULT '1',
  `province_code` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `province_name` varchar(50) DEFAULT NULL,
  `city_code` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `city_name` varchar(50) DEFAULT NULL,
  `district_code` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `district_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `post_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comm_address
-- ----------------------------
