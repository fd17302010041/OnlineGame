/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : onlinegame

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-12-05 15:58:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `gameId` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `grade` int(11) NOT NULL DEFAULT '0',
  `date` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game` (
  `gameId` int(11) NOT NULL AUTO_INCREMENT,
  `gamename` varchar(255) DEFAULT NULL,
  `grade` int(11) DEFAULT '0',
  PRIMARY KEY (`gameId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES ('1', 'game', '0');

-- ----------------------------
-- Table structure for rank
-- ----------------------------
DROP TABLE IF EXISTS `rank`;
CREATE TABLE `rank` (
  `gameId` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '0',
  `date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('Jack', '123456', '123@qq.com', '123456');
INSERT INTO `user` VALUES ('Jerry', '654321', '456@qq.com', '654321');
INSERT INTO `user` VALUES ('Rose', '123456', '123@qq.com', '123456');
INSERT INTO `user` VALUES ('Tom', '123456', '123@qq.com', '123456');
INSERT INTO `user` VALUES ('XiaoMing', '123456', '123@qq.com', '123456');
