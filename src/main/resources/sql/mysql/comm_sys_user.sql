/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-06-16 17:52:34
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

-- ----------------------------
-- Records of comm_sys_user
-- ----------------------------
INSERT INTO `comm_sys_user` VALUES ('11', 'admin', '$2a$10$3wXxTAbFsBHrM2OB.D.xku8duvAXTZXqYosYQjgwnASd00C6HkLiW', null, null, null, null, null, null, null, null, null, '2021-06-02 14:52:37', '2021-06-02 14:52:37');
INSERT INTO `comm_sys_user` VALUES ('12', 'tests1', '$2a$10$IZ8wF7R4AiOVR/jjXeY3R.pyQlCS2gUIy4agB6c/s9A6GonEnUixW', null, null, null, null, null, null, null, null, null, '2021-06-07 16:19:50', '2021-06-07 16:19:50');
INSERT INTO `comm_sys_user` VALUES ('13', 'yuandechun', '$2a$10$R4Zi6GPZ0UFRnkekH6ZmpeLjWY7kINPOWhBC/5n2xhSN/M/i2BbbK', null, null, null, null, null, null, null, null, null, '2021-06-07 16:22:34', '2021-06-07 16:22:34');
INSERT INTO `comm_sys_user` VALUES ('14', 'test2', '$2a$10$EVj4Lj48C1c81LSUz2FQ3uccAHYoKwquY.E1nDrw7PGpLsI8.rLoy', null, null, null, null, null, null, null, null, null, '2021-06-07 16:24:49', '2021-06-07 16:24:49');
INSERT INTO `comm_sys_user` VALUES ('15', 'test3', '$2a$10$2CTUgq0KFZzqNymJlG4Gtu3Gzrx2DX.RAc.x1iH42E1vTEkS.LeCm', null, null, null, null, null, null, null, null, null, '2021-06-07 16:29:27', '2021-06-07 16:29:27');
