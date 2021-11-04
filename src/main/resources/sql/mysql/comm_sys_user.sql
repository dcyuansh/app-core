/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 80012
Source Host           : 106.14.202.126:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-11-04 10:13:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comm_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `comm_sys_user`;
CREATE TABLE `comm_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `id_type` varchar(20) DEFAULT NULL,
  `id_no` varchar(18) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address_id` varchar(50) DEFAULT NULL,
  `role_cd` varchar(50) DEFAULT NULL,
  `state` varchar(16) DEFAULT NULL COMMENT 'state:ACITVE/DEACITVE/FROZEN',
  `remarks` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `indx_user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
