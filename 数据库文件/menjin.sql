/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : menjin

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-17 22:01:31
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_daka
-- ----------------------------
INSERT INTO `t_daka` VALUES ('3', '150302153201', '2018-04-17 21:58:20');

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
  `yuanquID` varchar(12) NOT NULL,
  `louhaoID` varchar(12) NOT NULL,
  `qinshihao` varchar(12) NOT NULL,
  PRIMARY KEY (`stuID`),
  KEY `classID` (`classID`),
  KEY `yuanquID` (`yuanquID`),
  CONSTRAINT `t_student_ibfk_1` FOREIGN KEY (`yuanquID`) REFERENCES `t_yuanqu` (`yuanquID`),
  CONSTRAINT `t_student_ibfk_2` FOREIGN KEY (`classID`) REFERENCES `t_class` (`classID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('150302153201', '张三', '1532', 'true', '101', '一号楼', '103');

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
INSERT INTO `t_yuanqu` VALUES ('101', '立业园');
INSERT INTO `t_yuanqu` VALUES ('102', '立德园');
