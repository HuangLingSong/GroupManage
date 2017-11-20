/*
Navicat MySQL Data Transfer

Source Server         : localhost_for_mysql
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : glory

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-11-20 13:08:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_groups
-- ----------------------------
DROP TABLE IF EXISTS `t_groups`;
CREATE TABLE `t_groups` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '组编号',
  `group_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '组名',
  `leader` int(10) NOT NULL,
  `create_at` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '消息编号',
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '消息内容',
  `type` int(10) DEFAULT NULL COMMENT '消息类型',
  `status` int(10) DEFAULT NULL COMMENT '状态(0：已处理，1：处理)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_roles
-- ----------------------------
DROP TABLE IF EXISTS `t_roles`;
CREATE TABLE `t_roles` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_users
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `email` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户邮箱',
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `role_id` int(10) NOT NULL DEFAULT '3' COMMENT '用户角色编号',
  `group_id` int(10) DEFAULT '0' COMMENT '用户属组编号',
  `create_at` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `Ref31` (`role_id`),
  KEY `Ref26` (`group_id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
SET FOREIGN_KEY_CHECKS=1;
