/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 80012
Source Host           : 106.14.202.126:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-11-04 10:13:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comm_sys_param
-- ----------------------------
DROP TABLE IF EXISTS `comm_sys_param`;
CREATE TABLE `comm_sys_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `param_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `param_value` varchar(200) NOT NULL,
  `param_desc` varchar(500) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comm_sys_param
-- ----------------------------
INSERT INTO `comm_sys_param` VALUES ('17', 'sys_name', 'iTech', '系统名称', null, '2021-06-08 15:04:16', '2021-06-08 15:04:16');
INSERT INTO `comm_sys_param` VALUES ('18', 'java_version', 'java_11', 'OpenJDK_11', null, '2021-06-08 15:04:16', '2021-06-08 15:04:16');
