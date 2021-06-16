/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-06-16 17:51:59
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comm_number_generate
-- ----------------------------
INSERT INTO `comm_number_generate` VALUES ('4', 'taskNo', '4', '1', 'ticket no自增长序号,从1开始，每次增加span。', '2020-11-27 13:49:01', '2021-03-22 11:36:14');
