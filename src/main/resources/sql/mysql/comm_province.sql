/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-06-16 17:52:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comm_province
-- ----------------------------
DROP TABLE IF EXISTS `comm_province`;
CREATE TABLE `comm_province` (
  `country_cd` varchar(20) NOT NULL,
  `province_cd` varchar(20) NOT NULL,
  `province_name` varchar(50) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`country_cd`,`province_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comm_province
-- ----------------------------
INSERT INTO `comm_province` VALUES ('CHN', '110000', '北京市', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '120000', '天津市', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '130000', '河北省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '140000', '山西省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '150000', '内蒙古自治区', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '210000', '辽宁省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '220000', '吉林省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '230000', '黑龙江省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '310000', '上海市', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '320000', '江苏省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '330000', '浙江省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '340000', '安徽省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '350000', '福建省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '360000', '江西省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '370000', '山东省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '410000', '河南省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '420000', '湖北省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '430000', '湖南省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '440000', '广东省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '450000', '广西壮族自治区', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '460000', '海南省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '500000', '重庆市', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '510000', '四川省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '520000', '贵州省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '530000', '云南省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '540000', '西藏自治区', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '610000', '陕西省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '620000', '甘肃省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '630000', '青海省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '640000', '宁夏回族自治区', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '650000', '新疆维吾尔自治区', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '710000', '台湾省', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '810000', '香港特别行政区', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '820000', '澳门特别行政区', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
INSERT INTO `comm_province` VALUES ('CHN', '990000', '未知', null, '2021-05-28 08:57:41', '2021-05-28 08:57:41');
