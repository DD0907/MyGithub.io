/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : taobao

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-12 13:41:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `note` text NOT NULL,
  `pic_url` varchar(45) NOT NULL DEFAULT '',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '五一促銷', '测试修改', 'picurl', '0', '2018-04-03 13:51:50', '2018-04-03 13:51:50');
INSERT INTO `activity` VALUES ('2', '新店开业', '测试修改', 'picurl', '1', '2018-04-05 16:03:50', '2018-04-05 16:03:50');

-- ----------------------------
-- Table structure for `activity_item`
-- ----------------------------
DROP TABLE IF EXISTS `activity_item`;
CREATE TABLE `activity_item` (
  `activity_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `rank` int(11) NOT NULL DEFAULT '0',
  KEY `activity_id` (`activity_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `activity_item_ibfk_3` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`),
  CONSTRAINT `activity_item_ibfk_4` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_item
-- ----------------------------
INSERT INTO `activity_item` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `coupon`
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `full_price` decimal(6,2) NOT NULL DEFAULT '0.00',
  `discount_price` decimal(6,2) NOT NULL,
  `total_num` int(11) NOT NULL DEFAULT '0',
  `surplus` int(11) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon
-- ----------------------------
INSERT INTO `coupon` VALUES ('1', '美食10元购', '100.00', '90.00', '100', '60', '1', '2018-04-08 10:18:53', '2018-04-08 10:18:53');
INSERT INTO `coupon` VALUES ('2', '任意商品减50', '100.00', '50.00', '200', '100', '1', '2018-04-11 21:32:39', '2018-04-11 21:32:39');

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL DEFAULT '',
  `note` text NOT NULL,
  `price` decimal(5,2) NOT NULL DEFAULT '0.00',
  `origin_price` decimal(5,2) NOT NULL DEFAULT '0.00',
  `main_pic` varchar(400) NOT NULL DEFAULT '',
  `code` varchar(20) DEFAULT '',
  `shop_id` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `shop_id` (`shop_id`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '苹果手机', 'iphone9', '0.00', '0.00', 'http://img05.tooopen.com/images/20140328/sy_57865838889.jpg', '13090808088497', '1', '1');
INSERT INTO `item` VALUES ('2', '电脑', '苹果', '0.00', '0.00', 'class=\"text-center active\"', '1234324533', '2', '1');

-- ----------------------------
-- Table structure for `item_image`
-- ----------------------------
DROP TABLE IF EXISTS `item_image`;
CREATE TABLE `item_image` (
  `item_id` int(11) NOT NULL,
  `pic_url` varchar(45) NOT NULL DEFAULT '',
  `rank` int(11) NOT NULL,
  KEY `item_id` (`item_id`),
  CONSTRAINT `item_image_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_image
-- ----------------------------

-- ----------------------------
-- Table structure for `mall`
-- ----------------------------
DROP TABLE IF EXISTS `mall`;
CREATE TABLE `mall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL DEFAULT '',
  `log_url` varchar(45) NOT NULL DEFAULT '',
  `note` text NOT NULL,
  `url` varchar(20) NOT NULL DEFAULT '',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mall
-- ----------------------------
INSERT INTO `mall` VALUES ('1', '京东商城', 'www.JD.com', '测试修改', 'www.jingdong.com.cn', '0');

-- ----------------------------
-- Table structure for `mall_shop`
-- ----------------------------
DROP TABLE IF EXISTS `mall_shop`;
CREATE TABLE `mall_shop` (
  `mall_id` int(11) NOT NULL,
  `shop_id` int(11) NOT NULL,
  KEY `mall_id` (`mall_id`),
  KEY `shop_id` (`shop_id`),
  CONSTRAINT `mall_shop_ibfk_1` FOREIGN KEY (`mall_id`) REFERENCES `mall` (`id`),
  CONSTRAINT `mall_shop_ibfk_2` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mall_shop
-- ----------------------------

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL DEFAULT '',
  `status` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '管理员', '0');
INSERT INTO `permission` VALUES ('2', '一般用户', '1');
INSERT INTO `permission` VALUES ('3', '测试用户', '0');
INSERT INTO `permission` VALUES ('4', '超级管理员', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL DEFAULT '',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('4', '经理', '1');
INSERT INTO `role` VALUES ('5', '主管', '1');
INSERT INTO `role` VALUES ('28', '总经理', '1');
INSERT INTO `role` VALUES ('29', '组长', '1');

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `permission_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `role_permission_ibfk_3` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL DEFAULT '',
  `log_url` varchar(45) NOT NULL DEFAULT '',
  `note` text NOT NULL,
  `url` varchar(20) NOT NULL DEFAULT '',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '微软', '', '官方旗舰店', '', '0');
INSERT INTO `shop` VALUES ('2', '微软中国', '测试', '测试修改2', 'www.baidu.com', '0');
INSERT INTO `shop` VALUES ('3', '微测试', '测试', '测试', '测试', '1');
INSERT INTO `shop` VALUES ('4', '微商', '测试', '测试', '测试', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `phone` varchar(11) NOT NULL,
  `name` varchar(16) NOT NULL,
  `salt` varchar(45) NOT NULL,
  `hashpassword` varchar(45) NOT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('13666666666', '张立', '123456', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES ('13777777777', 'admin', 'admin', '21232f297a57a5a743894a0e4a801fc3');
INSERT INTO `user` VALUES ('13888888888', '123456', '123456', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES ('13999999999', 'admin', 'admin', '21232f297a57a5a743894a0e4a801fc3');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_phone` varchar(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `user_phone` (`user_phone`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_phone`) REFERENCES `user` (`phone`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
