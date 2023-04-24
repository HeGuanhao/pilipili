/*
Navicat MySQL Data Transfer

Source Server         : mysql1
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : pachong1

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2021-07-18 17:24:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `mid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `face` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `sign` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `fans` varchar(255) DEFAULT NULL,
  `attention` varchar(255) DEFAULT NULL,
  `coin` varchar(255) DEFAULT NULL,
  `vip_type` varchar(255) DEFAULT NULL,
  `due_date` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', 'https://wx3.sinaimg.cn/mw690/0067jsxlgy1gsl5vd7ixuj605k05kwec02.jpg', null, null, null, '0', '0', null, null, null, '2021-07-18 16:10:24', '2021-07-18 16:10:24');
INSERT INTO `user` VALUES ('12', '何大浩', '12', 'https://wx3.sinaimg.cn/mw690/0067jsxlgy1gsl5vd7ixuj605k05kwec02.jpg', null, null, null, '0', '0', null, null, null, '2021-07-18 15:28:11', '2021-07-18 15:28:11');
INSERT INTO `user` VALUES ('123', '何冠皓', '123', 'https://wx3.sinaimg.cn/mw690/0067jsxlgy1gsl5vd7ixuj605k05kwec02.jpg', null, null, null, '0', '0', null, null, null, '2021-07-18 15:10:14', '2021-07-18 15:10:14');
INSERT INTO `user` VALUES ('12345', '12345', '12345', 'https://wx3.sinaimg.cn/mw690/0067jsxlgy1gsl5vd7ixuj605k05kwec02.jpg', null, null, null, null, null, null, null, null, '2021-07-18 16:19:54', '2021-07-18 16:19:54');
INSERT INTO `user` VALUES ('321', '321', '321', 'https://wx3.sinaimg.cn/mw690/0067jsxlgy1gsl5vd7ixuj605k05kwec02.jpg', null, null, null, null, null, null, null, null, '2021-07-18 16:57:52', '2021-07-18 16:57:52');
