/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 80012
Source Host           : 106.14.202.126:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-11-04 10:12:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comm_id_card
-- ----------------------------
DROP TABLE IF EXISTS `comm_id_card`;
CREATE TABLE `comm_id_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `id_type` varchar(20) DEFAULT NULL,
  `id_card` varchar(18) NOT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `nation` varchar(20) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `eff_date` date DEFAULT NULL,
  `exp_date` date DEFAULT NULL,
  `sign_office` varchar(200) DEFAULT NULL,
  `state` varchar(16) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `indx_id_card` (`id_card`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comm_id_card
-- ----------------------------
