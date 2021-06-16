/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-06-16 17:52:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comm_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `comm_sys_role`;
CREATE TABLE `comm_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_cd` varchar(50) NOT NULL,
  `role_name` varchar(200) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `indx_role_cd` (`role_cd`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comm_sys_role
-- ----------------------------
