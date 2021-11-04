/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 80012
Source Host           : 106.14.202.126:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-11-04 10:13:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comm_reftab
-- ----------------------------
DROP TABLE IF EXISTS `comm_reftab`;
CREATE TABLE `comm_reftab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `element_type` varchar(100) DEFAULT NULL,
  `element_cd` varchar(100) DEFAULT NULL,
  `element_name` varchar(200) DEFAULT NULL,
  `language_id` varchar(20) DEFAULT NULL,
  `ref_cd` varchar(100) DEFAULT NULL,
  `ref_desc` varchar(500) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `indx_reference` (`element_type`,`element_cd`,`element_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comm_reftab
-- ----------------------------
