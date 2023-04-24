/*
Navicat MySQL Data Transfer

Source Server         : mysql1
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : pachong1

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2021-07-18 17:24:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `rpid` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '自增1',
  `oid` varchar(255) DEFAULT NULL,
  `mid` varchar(255) DEFAULT NULL,
  `root` varchar(255) DEFAULT NULL,
  `ctime` varchar(255) DEFAULT NULL,
  `like` varchar(255) DEFAULT NULL,
  `floor` varchar(255) DEFAULT NULL,
  `rcount` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rpid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('6', '12015446', '123', null, null, null, null, null, '2021-07-18 15:11:18', '2021-07-18 15:11:18', '好看');
INSERT INTO `comment` VALUES ('7', '12015446', '12', null, null, null, null, null, '2021-07-18 15:28:33', '2021-07-18 15:28:33', '还行');
INSERT INTO `comment` VALUES ('8', '12015446', '12345', null, null, null, null, null, '2021-07-18 16:21:54', '2021-07-18 16:21:54', '1234');
