/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-12 13:41:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogger_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `label_id` int(11) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '0',
  `title` varchar(32) NOT NULL DEFAULT '',
  `content` text,
  `summary` varchar(400) NOT NULL DEFAULT '',
  `key_word` varchar(200) NOT NULL DEFAULT '',
  `release_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `blogger_id` (`blogger_id`),
  KEY `category_id` (`category_id`),
  KEY `label_id` (`label_id`),
  CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`blogger_id`) REFERENCES `blogger` (`id`),
  CONSTRAINT `blog_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `blog_category` (`id`),
  CONSTRAINT `blog_ibfk_3` FOREIGN KEY (`label_id`) REFERENCES `blog_label` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '1', '1', '1', '0', '', null, '', '', '2018-03-31 16:03:02', '2018-03-31 16:03:02');

-- ----------------------------
-- Table structure for `blogger`
-- ----------------------------
DROP TABLE IF EXISTS `blogger`;
CREATE TABLE `blogger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL DEFAULT '',
  `password` varchar(16) NOT NULL DEFAULT '',
  `email` varchar(32) NOT NULL DEFAULT '',
  `type` int(11) NOT NULL DEFAULT '0',
  `code` varchar(11) NOT NULL DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blogger
-- ----------------------------
INSERT INTO `blogger` VALUES ('1', 'admin', 'admin', 'admin@163.com', '1', 'admin', '2018-03-31 15:32:59', '2018-03-31 15:33:44', '2018-03-31 15:34:43');

-- ----------------------------
-- Table structure for `blogge_info`
-- ----------------------------
DROP TABLE IF EXISTS `blogge_info`;
CREATE TABLE `blogge_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogger_id` int(11) NOT NULL,
  `phone` varchar(11) NOT NULL DEFAULT '13888888888',
  `about` varchar(400) NOT NULL DEFAULT '',
  `intro` varchar(400) NOT NULL DEFAULT '' COMMENT '简介',
  `nickname` varchar(32) NOT NULL DEFAULT '',
  `avatar_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `blogger_id` (`blogger_id`),
  KEY `avatar_id` (`avatar_id`),
  CONSTRAINT `blogge_info_ibfk_1` FOREIGN KEY (`blogger_id`) REFERENCES `blogger` (`id`),
  CONSTRAINT `blogge_info_ibfk_2` FOREIGN KEY (`avatar_id`) REFERENCES `blog_picture` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blogge_info
-- ----------------------------
INSERT INTO `blogge_info` VALUES ('1', '1', '13888888888', '', '', '', '1');

-- ----------------------------
-- Table structure for `blog_admire`
-- ----------------------------
DROP TABLE IF EXISTS `blog_admire`;
CREATE TABLE `blog_admire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_id` int(11) NOT NULL,
  `pay_id` int(11) NOT NULL,
  `money` decimal(4,2) NOT NULL DEFAULT '0.00',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `blog_id` (`blog_id`),
  KEY `pay_id` (`pay_id`),
  CONSTRAINT `blog_admire_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`),
  CONSTRAINT `blog_admire_ibfk_2` FOREIGN KEY (`pay_id`) REFERENCES `blogger` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_admire
-- ----------------------------
INSERT INTO `blog_admire` VALUES ('1', '1', '1', '0.00', '2018-03-31 16:07:32');

-- ----------------------------
-- Table structure for `blog_category`
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon_id` int(11) NOT NULL,
  `title` varchar(40) NOT NULL DEFAULT '',
  `description` varchar(100) NOT NULL DEFAULT '',
  `blogger_id` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `blogger_id` (`blogger_id`),
  KEY `icon_id` (`icon_id`),
  CONSTRAINT `blog_category_ibfk_1` FOREIGN KEY (`blogger_id`) REFERENCES `blogger` (`id`),
  CONSTRAINT `blog_category_ibfk_2` FOREIGN KEY (`icon_id`) REFERENCES `blog_picture` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_category
-- ----------------------------
INSERT INTO `blog_category` VALUES ('1', '1', '', '', '1', '2018-03-31 15:54:27');

-- ----------------------------
-- Table structure for `blog_collect`
-- ----------------------------
DROP TABLE IF EXISTS `blog_collect`;
CREATE TABLE `blog_collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_id` int(11) NOT NULL,
  `collector_id` int(11) NOT NULL,
  `reason` varchar(400) NOT NULL DEFAULT '',
  `category_id` int(11) NOT NULL,
  `collect_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `blog_id` (`blog_id`),
  KEY `collector_id` (`collector_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `blog_collect_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`),
  CONSTRAINT `blog_collect_ibfk_2` FOREIGN KEY (`collector_id`) REFERENCES `blogger` (`id`),
  CONSTRAINT `blog_collect_ibfk_3` FOREIGN KEY (`category_id`) REFERENCES `blog_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_collect
-- ----------------------------
INSERT INTO `blog_collect` VALUES ('1', '1', '1', '', '1', '2018-03-31 16:42:20');

-- ----------------------------
-- Table structure for `blog_comment`
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_id` int(11) NOT NULL,
  `spokesman_id` int(11) NOT NULL,
  `listener_id` int(11) NOT NULL,
  `content` text,
  `state` int(11) NOT NULL DEFAULT '0',
  `release_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `blog_id` (`blog_id`),
  KEY `spokesman_id` (`spokesman_id`),
  KEY `listener_id` (`listener_id`),
  CONSTRAINT `blog_comment_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`),
  CONSTRAINT `blog_comment_ibfk_2` FOREIGN KEY (`spokesman_id`) REFERENCES `blogger` (`id`),
  CONSTRAINT `blog_comment_ibfk_3` FOREIGN KEY (`listener_id`) REFERENCES `blogger` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_comment
-- ----------------------------
INSERT INTO `blog_comment` VALUES ('1', '1', '1', '1', null, '0', '2018-03-31 16:48:21');

-- ----------------------------
-- Table structure for `blog_complain`
-- ----------------------------
DROP TABLE IF EXISTS `blog_complain`;
CREATE TABLE `blog_complain` (
  `id` int(11) NOT NULL,
  `complainer_id` int(11) NOT NULL,
  `blog_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `state` int(11) NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `complainer_id` (`complainer_id`),
  KEY `blog_id` (`blog_id`),
  CONSTRAINT `blog_complain_ibfk_1` FOREIGN KEY (`complainer_id`) REFERENCES `blogger` (`id`),
  CONSTRAINT `blog_complain_ibfk_2` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_complain
-- ----------------------------

-- ----------------------------
-- Table structure for `blog_label`
-- ----------------------------
DROP TABLE IF EXISTS `blog_label`;
CREATE TABLE `blog_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogger_id` int(11) NOT NULL,
  `title` varchar(32) NOT NULL DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `blogger_id` (`blogger_id`),
  CONSTRAINT `blog_label_ibfk_1` FOREIGN KEY (`blogger_id`) REFERENCES `blogger` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_label
-- ----------------------------
INSERT INTO `blog_label` VALUES ('1', '1', '', '2018-03-31 15:56:36');

-- ----------------------------
-- Table structure for `blog_like`
-- ----------------------------
DROP TABLE IF EXISTS `blog_like`;
CREATE TABLE `blog_like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `like_id` int(11) NOT NULL,
  `blog_id` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `complainer_id` (`like_id`),
  KEY `blog_id` (`blog_id`),
  CONSTRAINT `blog_like_ibfk_1` FOREIGN KEY (`like_id`) REFERENCES `blogger` (`id`),
  CONSTRAINT `blog_like_ibfk_2` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_like
-- ----------------------------
INSERT INTO `blog_like` VALUES ('1', '1', '1', '2018-03-31 16:53:38');

-- ----------------------------
-- Table structure for `blog_link`
-- ----------------------------
DROP TABLE IF EXISTS `blog_link`;
CREATE TABLE `blog_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogger_id` int(11) NOT NULL,
  `url` varchar(100) NOT NULL DEFAULT '',
  `description` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `blogger_id` (`blogger_id`),
  CONSTRAINT `blog_link_ibfk_1` FOREIGN KEY (`blogger_id`) REFERENCES `blogger` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_link
-- ----------------------------
INSERT INTO `blog_link` VALUES ('1', '1', '', '');

-- ----------------------------
-- Table structure for `blog_picture`
-- ----------------------------
DROP TABLE IF EXISTS `blog_picture`;
CREATE TABLE `blog_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blogger_id` int(11) NOT NULL,
  `category` int(11) NOT NULL DEFAULT '0',
  `path` varchar(100) NOT NULL DEFAULT '',
  `description` varchar(100) NOT NULL DEFAULT '',
  `upload_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `blogger_id` (`blogger_id`),
  CONSTRAINT `blog_picture_ibfk_1` FOREIGN KEY (`blogger_id`) REFERENCES `blogger` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_picture
-- ----------------------------
INSERT INTO `blog_picture` VALUES ('1', '1', '0', '', '', '2018-03-31 15:49:14');

-- ----------------------------
-- Table structure for `blog_statistics`
-- ----------------------------
DROP TABLE IF EXISTS `blog_statistics`;
CREATE TABLE `blog_statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_id` int(11) NOT NULL,
  `comment_count` int(11) NOT NULL DEFAULT '0',
  `view_count` int(11) NOT NULL DEFAULT '0',
  `reply_comment_count` int(11) NOT NULL DEFAULT '0',
  `collect_count` int(11) NOT NULL DEFAULT '0',
  `share_count` int(11) NOT NULL DEFAULT '0',
  `admire_count` int(11) NOT NULL DEFAULT '0',
  `like_count` int(11) NOT NULL DEFAULT '0',
  `release_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `blog_id` (`blog_id`),
  CONSTRAINT `blog_statistics_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_statistics
-- ----------------------------
INSERT INTO `blog_statistics` VALUES ('1', '1', '0', '0', '0', '0', '0', '0', '0', '2018-03-31 17:00:05');
