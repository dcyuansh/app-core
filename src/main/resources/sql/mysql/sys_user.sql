/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-06-16 17:53:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `id_type` varchar(20) DEFAULT NULL,
  `id_card` varchar(18) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `verify_ind` varchar(1) NOT NULL DEFAULT 'N',
  `pass_expire_date` datetime DEFAULT NULL,
  `login_wrong_times` int(11) DEFAULT '0',
  `lock_ind` char(1) DEFAULT 'N',
  `password_his` varchar(600) DEFAULT NULL,
  `lock_date` datetime DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `indx_user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('5', 'admin', '$2a$10$gGsZeepTQtkIul426IsKQ.VIfGg5XyW9TxErlWUESRngLhk5A2bDS', '身份证', '123456789012345678', 'yuandechunsh@163.com', '17602110973', 'M', 'N', null, '0', 'N', null, null, 'SH', null, '2020-08-07 00:00:00', '2020-08-07 00:00:00');
INSERT INTO `sys_user` VALUES ('6', 'yuandechun', '$2a$10$nZxEZQ/KluBmcVqMWDGF4eB0zYBSgKQcMXKUqm/5W0c6AwhZ1wEWq', '身份证', '12345689', 'yuandechunsh@163.com', '17602110973', 'M', 'N', null, '0', 'N', null, null, 'SH', null, '2020-12-11 00:00:00', '2020-08-07 00:00:00');
INSERT INTO `sys_user` VALUES ('7', 'AD', '$2a$10$zg7oaqa3/hg1/1fvM4tZceTWj7ilFqlO/jCS5N9KPMZytx8q00UEK', '其他', '121231231231', 'AD@163.com', '12345678912', 'M', 'N', null, '0', 'N', null, null, '上海杨浦区，政立路477号1号楼', null, '2020-12-11 00:00:00', '2020-08-07 00:00:00');
INSERT INTO `sys_user` VALUES ('8', 'ST', '$2a$10$bshfNEI1Ht.hCGcL7snIBup64DtlWUNpOTepv7f3BBlZmjdxlM9JC', '其他', '11111111', 'ST@163.com', '12121212121', 'F', 'N', null, '0', 'N', null, null, '上海杨浦区，政立路477号1号楼', null, '2020-12-14 00:00:00', '2021-02-04 11:23:10');
INSERT INTO `sys_user` VALUES ('9', 'PM', '$2a$10$BvzL/sxX8WPTgGjw.YA2dO0IX1kOM0nfUOT7kwonSQ4lXC7P44DvW', '其他', '1234567890', 'pm@163.com', '123456', 'M', 'N', null, '0', 'N', null, null, 'SH', null, '2020-12-29 16:09:08', '2021-03-01 17:59:23');
INSERT INTO `sys_user` VALUES ('11', 'test', '$2a$10$DEFqFuSSu/uQttvQPjCxE.TKkl36Lcseq2qh73MZjhwlenWTOVV4u', null, null, null, null, null, 'N', null, '0', 'N', null, null, null, null, '2021-06-03 12:26:01', '2021-06-03 12:26:01');
