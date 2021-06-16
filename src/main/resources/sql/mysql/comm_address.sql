/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-06-16 17:51:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comm_address
-- ----------------------------
DROP TABLE IF EXISTS `comm_address`;
CREATE TABLE `comm_address` (
  `address_id` varchar(50) NOT NULL,
  `addr_seq_no` int(11) DEFAULT '1',
  `country_cd` varchar(20) DEFAULT NULL,
  `country_name` varchar(50) DEFAULT NULL,
  `province_cd` varchar(20) DEFAULT NULL,
  `province_name` varchar(50) DEFAULT NULL,
  `city_cd` varchar(20) DEFAULT NULL,
  `city_name` varchar(50) DEFAULT NULL,
  `county_cd` varchar(20) DEFAULT NULL,
  `county_name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `post_cd` varchar(20) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comm_address
-- ----------------------------
