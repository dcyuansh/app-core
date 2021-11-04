/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 80012
Source Host           : 106.14.202.126:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-11-04 10:13:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comm_number_generate
-- ----------------------------
DROP TABLE IF EXISTS `comm_number_generate`;
CREATE TABLE `comm_number_generate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number_name` varchar(200) DEFAULT NULL,
  `current_value` int(11) DEFAULT NULL,
  `span` int(11) DEFAULT '1',
  `number_desc` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `indx_number_generate` (`number_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comm_number_generate
-- ----------------------------
INSERT INTO `comm_number_generate` VALUES ('5', 'taskNo', '15', '1', '', '2021-07-19 14:16:40', '2021-07-27 15:20:10');
