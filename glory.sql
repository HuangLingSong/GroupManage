/*
Navicat MySQL Data Transfer

Source Server         : localhost_for_mysql
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : glory

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-12-02 22:49:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_acl
-- ----------------------------
DROP TABLE IF EXISTS `t_acl`;
CREATE TABLE `t_acl` (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `childmodule_id` int(11) NOT NULL COMMENT '子模块id',
  PRIMARY KEY (`role_id`,`childmodule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录时间',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '活动开始时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `content` text COLLATE utf8_unicode_ci NOT NULL COMMENT '文章内容',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `user_id` int(11) NOT NULL COMMENT '创建者id',
  `role_id` int(11) NOT NULL COMMENT '基于角色权限级别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_book_list
-- ----------------------------
DROP TABLE IF EXISTS `t_book_list`;
CREATE TABLE `t_book_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `book_review` text COLLATE utf8_unicode_ci,
  `craete_by` int(11) NOT NULL COMMENT '创建者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_chat
-- ----------------------------
DROP TABLE IF EXISTS `t_chat`;
CREATE TABLE `t_chat` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `content` text COLLATE utf8_unicode_ci COMMENT '内容 ',
  `create_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `user_id` int(11) NOT NULL COMMENT '发送者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_child_module
-- ----------------------------
DROP TABLE IF EXISTS `t_child_module`;
CREATE TABLE `t_child_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '子模块id',
  `module_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '子模块名称',
  `url` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT 'url',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级模块id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_parent_module
-- ----------------------------
DROP TABLE IF EXISTS `t_parent_module`;
CREATE TABLE `t_parent_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '父级模块id',
  `module_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '父级模块名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project`;
CREATE TABLE `t_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `project_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '项目名',
  `group_id` int(11) NOT NULL COMMENT '组id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_rating
-- ----------------------------
DROP TABLE IF EXISTS `t_rating`;
CREATE TABLE `t_rating` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `part_1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `part_2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `part_3` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `project_id` int(11) NOT NULL COMMENT '项目id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_recommend
-- ----------------------------
DROP TABLE IF EXISTS `t_recommend`;
CREATE TABLE `t_recommend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '最佳者id',
  `best_id` int(11) NOT NULL,
  `referrer_id` int(11) NOT NULL COMMENT '推荐者id',
  `votes` int(11) NOT NULL DEFAULT '0' COMMENT '得票数',
  `activity_id` int(11) NOT NULL COMMENT '活动id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
-- Table structure for t_task
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `content` text COLLATE utf8_unicode_ci NOT NULL COMMENT '任务内容',
  `status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '任务状态',
  `receiver_id` int(11) NOT NULL COMMENT '接受者id',
  `post_id` int(11) NOT NULL COMMENT '发布者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
SET FOREIGN_KEY_CHECKS=1;
