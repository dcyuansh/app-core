/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 80012
Source Host           : 106.14.202.126:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-11-04 10:12:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comm_mail_template
-- ----------------------------
DROP TABLE IF EXISTS `comm_mail_template`;
CREATE TABLE `comm_mail_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `template_name` varchar(200) NOT NULL,
  `template_title` text,
  `template_desc` text,
  `mail_subject` text,
  `mail_sender` text,
  `mail_recievers` text,
  `mail_cc_recievers` text,
  `mail_body` text,
  `remarks` varchar(500) DEFAULT '',
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comm_mail_template
-- ----------------------------
