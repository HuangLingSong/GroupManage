/*
Navicat MySQL Data Transfer

Source Server         : localhost_for_mysql
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : glory

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-11-16 21:38:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `group` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
SET FOREIGN_KEY_CHECKS=1;

-- ----------------------------
-- Table structure for t_roles
-- ----------------------------
DROP TABLE IF EXISTS `t_roles`;
CREATE TABLE `t_roles` (
  `id` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `role` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
SET FOREIGN_KEY_CHECKS=1;

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role_id` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `group_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Ref31` (`role_id`),
  KEY `Ref26` (`group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
SET FOREIGN_KEY_CHECKS=1;
