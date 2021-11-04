/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 80012
Source Host           : 106.14.202.126:3306
Source Database       : itech

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-11-04 10:12:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comm_country
-- ----------------------------
DROP TABLE IF EXISTS `comm_country`;
CREATE TABLE `comm_country` (
  `country_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `country_name` varchar(50) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`country_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comm_country
-- ----------------------------
INSERT INTO `comm_country` VALUES ('ABW', '阿鲁巴', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('AFG', '阿富汗', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('AGO', '安哥拉', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('AIA', '安圭拉', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ALB', '阿尔巴尼亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('AND', '安道尔', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ANT', '荷属安的列斯', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ARE', '阿联酋', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ARG', '阿根廷', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ARM', '亚美尼亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ASM', '美属萨摩亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ATA', '南极洲', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ATF', '法属南部领土', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ATG', '安提瓜和巴布达', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('AUS', '澳大利亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('AUT', '奥地利', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('AZE', '阿塞拜疆', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BDI', '布隆迪', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BEL', '比利时', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BEN', '贝宁', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BFA', '布基纳法索', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BGD', '孟加拉国', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BGR', '保加利亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BHR', '巴林', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BHS', '巴哈马', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BIH', '波黑', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BLR', '白俄罗斯', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BLZ', '伯利兹', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BMU', '百慕大', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BOL', '玻利维亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BRA', '巴西', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BRB', '巴巴多斯', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BRN', '文莱', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BTN', '不丹', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BVT', '布维岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('BWA', '博茨瓦纳', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CAF', '中非', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CAN', '加拿大', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CCK', '科科斯(基林)群岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CHE', '瑞士', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CHL', '智利', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CHN', '中国', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CIV', '科特迪瓦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CMR', '喀麦隆', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('COD', '刚果(金)', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('COG', '刚果(布)', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('COK', '库克群岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('COL', '哥伦比亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('COM', '科摩罗', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CPV', '佛得角', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CRI', '哥斯达黎加', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CSR', '圣诞岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CUB', '古巴', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CYM', '开曼群岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CYP', '塞浦路斯', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('CZE', '捷克', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('DEU', '德国', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('DJI', '吉布提', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('DMA', '多米尼克', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('DNK', '丹麦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('DOM', '多米尼加共和国', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('DZA', '阿尔及利亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ECU', '厄瓜多尔', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('EGY', '埃及', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ERI', '厄立特里亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ESH', '西撒哈拉', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ESP', '西班牙', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('EST', '爱沙尼亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ETH', '埃塞俄比亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('FIN', '芬兰', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('FJI', '斐济', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('FLK', '福克兰群岛(马尔维纳斯)', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('FRA', '法国', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('FRO', '法罗群岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('FSM', '密克罗尼西亚联邦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GAB', '加蓬', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GBR', '英国', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GEO', '格鲁吉亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GHA', '加纳', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GIB', '直布罗陀', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GIN', '几内亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GLP', '瓜德罗普', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GMB', '冈比亚Gambia', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GNB', '几内亚比绍', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GNQ', '赤道几内亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GRC', '希腊', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GRD', '格林纳达', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GRL', '格陵兰', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GTM', '危地马拉', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GUF', '法属圭亚那', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GUM', '关岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('GUY', '圭亚那', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('HMD', '赫德岛和麦克唐纳岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('HND', '洪都拉斯', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('HRV', '克罗地亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('HTI', '海地', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('HUN', '匈牙利', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('IDN', '印度尼西亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('IND', '印度', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('IOT', '英属印度洋领土', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('IRL', '爱尔兰', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('IRN', '伊朗', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('IRQ', '伊拉克', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ISL', '冰岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ISR', '以色列', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ITA', '意大利', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('JAM', '牙买加', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('JOR', '约旦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('JPN', '日本', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('KAZ', '哈萨克斯坦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('KEN', '肯尼亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('KGZ', '吉尔吉斯斯坦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('KHM', '柬埔寨', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('KIR', '基里巴斯', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('KNA', '圣基茨和尼维斯', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('KOR', '韩国', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('KWT', '科威特', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('LAO', '老挝', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('LBN', '黎巴嫩', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('LBR', '利比里亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('LBY', '利比亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('LCA', '圣卢西亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('LIE', '列支敦士登', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('LKA', '斯里兰卡', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('LSO', '莱索托', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('LTU', '立陶宛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('LUX', '卢森堡', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('LVA', '拉脱维亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MAR', '摩洛哥', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MCO', '摩纳哥', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MDA', '摩尔多瓦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MDG', '马达加斯加', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MDV', '马尔代夫', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MEX', '墨西哥', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MHL', '马绍尔群岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MKD', '前南马其顿', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MLI', '马里', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MLT', '马耳他', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MMR', '缅甸', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MNG', '蒙古', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MNP', '北马里亚纳', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MOZ', '莫桑比克', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MRT', '毛里塔尼亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MSR', '蒙特塞拉特', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MTQ', '马提尼克', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MUS', '毛里求斯', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MWI', '马拉维', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MYS', '马来西亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('MYT', '马约特', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('NAM', '纳米比亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('NCL', '新喀里多尼亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('NER', '尼日尔', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('NFK', '诺福克岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('NGA', '尼日利亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('NIC', '尼加拉瓜', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('NIU', '纽埃', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('NLD', '荷兰', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('NOR', '挪威', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('NPL', '尼泊尔', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('NRU', '瑙鲁', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('NZL', '新西兰', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('OMN', '阿曼', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('PAK', '巴基斯坦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('PAN', '巴拿马', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('PCN', '皮特凯恩群岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('PER', '秘鲁', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('PHL', '菲律宾', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('PLW', '帕劳', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('PNG', '巴布亚新几内亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('POL', '波兰', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('PRI', '波多黎各', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('PRK', '朝鲜', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('PRT', '葡萄牙', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('PRY', '巴拉圭', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('PST', '巴勒斯坦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('PYF', '法属波利尼西亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('QAT', '卡塔尔', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('REU', '留尼汪', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ROM', '罗马尼亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('RUS', '俄罗斯联邦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('RWA', '卢旺达', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SAU', '沙特阿拉伯', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SDN', '苏丹', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SEN', '塞内加尔', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SGP', '新加坡', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SGS', '南乔治亚岛和南桑德韦奇岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SHN', '圣赫勒拿', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SJM', '斯瓦尔巴群岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SLB', '所罗门群岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SLE', '塞拉利昂', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SLV', '萨尔瓦多', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SMR', '圣马力诺', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SOM', '索马里', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SPM', '圣皮埃尔和密克隆', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('STp', '圣多美和普林西比', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SUR', '苏里南', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SVK', '斯洛伐克', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SVN', '斯洛文尼亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SWE', '瑞典', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SWZ', '斯威士兰', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SYC', '塞舌尔', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('SYR', '叙利亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('TCA', '特克斯科斯群岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('TCD', '乍得', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('TGO', '多哥', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('THA', '泰国', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('TJK', '塔吉克斯坦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('TKL', '托克劳', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('TKM', '土库曼斯坦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('TMP', '东帝汶', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('TON', '汤加', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('TTO', '特立尼达和多巴哥', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('TUN', '突尼斯', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('TUR', '土耳其', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('TUV', '图瓦卢', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('TZA', '坦桑尼亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('UGA', '乌干达', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('UKR', '乌克兰', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('UMI', '美国本土外小岛屿', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('URY', '乌拉圭', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('USA', '美国', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('UZB', '乌兹别克斯坦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('VAT', '梵蒂冈', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('VCT', '圣文森特和格林纳丁斯', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('VEN', '委内瑞拉', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('VGB', '英属维尔京群岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('VIR', '美属维尔京群岛', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('VNM', '越南', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('VUT', '瓦努阿图', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('WLF', '瓦利斯和富图纳', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('WSM', '萨摩亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('XXX', '其他', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('YEM', '也门', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('YUG', '南斯拉夫', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ZAF', '南非', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ZMB', '赞比亚', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
INSERT INTO `comm_country` VALUES ('ZWE', '津巴布韦', null, '2021-05-28 08:41:51', '2021-05-28 08:41:51');
