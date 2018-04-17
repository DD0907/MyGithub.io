/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : menjin

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-17 21:23:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `classID` int(11) NOT NULL,
  `className` varchar(16) NOT NULL,
  `isUse` enum('true','false') DEFAULT 'true',
  PRIMARY KEY (`classID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('1532', '计算机1532', 'true');
INSERT INTO `t_class` VALUES ('1533', '计算机1533', 'true');

-- ----------------------------
-- Table structure for `t_daka`
-- ----------------------------
DROP TABLE IF EXISTS `t_daka`;
CREATE TABLE `t_daka` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuID` varchar(12) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `stuID` (`stuID`),
  CONSTRAINT `t_daka_ibfk_1` FOREIGN KEY (`stuID`) REFERENCES `t_student` (`stuID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_daka
-- ----------------------------
INSERT INTO `t_daka` VALUES ('1', '150302153254', '2018-04-17 15:05:16');
INSERT INTO `t_daka` VALUES ('2', '150302153332', '2018-04-26 15:09:37');

-- ----------------------------
-- Table structure for `t_login`
-- ----------------------------
DROP TABLE IF EXISTS `t_login`;
CREATE TABLE `t_login` (
  `username` varchar(16) NOT NULL DEFAULT 'admin',
  `password` varchar(32) NOT NULL DEFAULT '12345678',
  `isUse` enum('true','false') NOT NULL DEFAULT 'true',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_login
-- ----------------------------
INSERT INTO `t_login` VALUES ('admin', '12345678', 'true');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `stuID` varchar(12) NOT NULL,
  `stuName` varchar(16) NOT NULL,
  `classID` int(11) NOT NULL,
  `isUse` enum('false','true') NOT NULL DEFAULT 'true',
  `yuanquID` varchar(2) NOT NULL,
  `louhaoID` varchar(2) NOT NULL,
  `qinshihao` varchar(3) NOT NULL,
  PRIMARY KEY (`stuID`),
  KEY `classID` (`classID`),
  CONSTRAINT `t_student_ibfk_1` FOREIGN KEY (`classID`) REFERENCES `t_class` (`classID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('150302153254', '李小龙', '1532', 'true', '1', '2', '118');
INSERT INTO `t_student` VALUES ('150302153332', '王可可', '1533', 'true', '2', '2', '301');

-- ----------------------------
-- Table structure for `t_xibie`
-- ----------------------------
DROP TABLE IF EXISTS `t_xibie`;
CREATE TABLE `t_xibie` (
  `xibieID` bigint(12) NOT NULL,
  `xibieName` varchar(16) NOT NULL,
  `isUse` enum('true','false') NOT NULL DEFAULT 'true',
  PRIMARY KEY (`xibieID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xibie
-- ----------------------------
INSERT INTO `t_xibie` VALUES ('1', '经贸管理', 'true');
INSERT INTO `t_xibie` VALUES ('2', '信息技术', 'true');
INSERT INTO `t_xibie` VALUES ('3', '国际教育', 'true');
INSERT INTO `t_xibie` VALUES ('4', '人文社科', 'true');

-- ----------------------------
-- Table structure for `t_yuanqu`
-- ----------------------------
DROP TABLE IF EXISTS `t_yuanqu`;
CREATE TABLE `t_yuanqu` (
  `yuanquID` varchar(3) NOT NULL DEFAULT '',
  `yuanquName` varchar(16) NOT NULL,
  PRIMARY KEY (`yuanquID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_yuanqu
-- ----------------------------
INSERT INTO `t_yuanqu` VALUES ('2', '立德园');
INSERT INTO `t_yuanqu` VALUES ('3', '立志园');
