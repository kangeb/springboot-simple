/*
Navicat MySQL Data Transfer

Source Server         : jeefast
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-03-21 15:17:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `city`
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `province_id` int(10) unsigned NOT NULL COMMENT '省份编号',
  `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
  `description` varchar(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '1', '温岭市', 'BYSocket 的家在温岭。');

-- ----------------------------
-- Table structure for `log_inf`
-- ----------------------------
DROP TABLE IF EXISTS `log_inf`;
CREATE TABLE `log_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `msg` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log_inf
-- ----------------------------
INSERT INTO `log_inf` VALUES ('1', '2017-06-22 13:54:15', '用户 rico 注册成功...');
INSERT INTO `log_inf` VALUES ('2', '2017-06-22 13:54:42', 'rico登录成功...');
INSERT INTO `log_inf` VALUES ('3', '2017-06-22 15:32:14', 'rico登录成功...');
INSERT INTO `log_inf` VALUES ('4', '2017-06-22 15:33:55', '用户 shudaizi 注册成功...');
INSERT INTO `log_inf` VALUES ('5', '2017-06-22 15:34:04', 'shudaizi登录成功...');
INSERT INTO `log_inf` VALUES ('6', '2017-06-27 08:36:31', 'rico登录成功...');
INSERT INTO `log_inf` VALUES ('7', '2017-06-27 08:37:09', '用户 林建睿 注册成功...');
INSERT INTO `log_inf` VALUES ('8', '2017-06-27 08:37:19', '林建睿登录成功...');
INSERT INTO `log_inf` VALUES ('9', '2017-06-27 15:49:42', '存在ID为 3 的用户，查询成功...');
INSERT INTO `log_inf` VALUES ('10', '2017-06-27 15:51:08', '存在ID为 3 的用户，查询成功...');
INSERT INTO `log_inf` VALUES ('11', '2017-06-27 15:52:18', '存在ID为 3 的用户，查询成功...');
INSERT INTO `log_inf` VALUES ('12', '2017-06-30 08:23:43', '存在ID为 3 的用户，查询成功...');

-- ----------------------------
-- Table structure for `ssmapi_agenda`
-- ----------------------------
DROP TABLE IF EXISTS `ssmapi_agenda`;
CREATE TABLE `ssmapi_agenda` (
  `uuid` varchar(255) NOT NULL COMMENT 'uuid主键\r\n',
  `title` varchar(255) NOT NULL,
  `details` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssmapi_agenda
-- ----------------------------
INSERT INTO `ssmapi_agenda` VALUES ('77f424ae-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('7b1f6d8f-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('7bdf8a3c-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('7bdffaf8-0eef-11e8-b894-00ffa8a5f50c', '浇花', '浇所有的花', '2018-01-12', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('7c7bccc8-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('7d009266-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('7dccbb02-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('7e51bd9f-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('7ed87329-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('7f5b17d5-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('7fd83491-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('80aaed99-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('83fe6fd8-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('846e2fdf-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('84cbd39d-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('85139434-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('855710ff-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('859f1bf5-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('85dfb7ea-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('861a04c7-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('865024f4-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('86860e7a-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('86bc1790-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('86ea3a27-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('87176d14-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('87520133-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('878d4805-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('87beb0c5-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('87f4824f-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('88275512-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('88725535-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('88a9b30a-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('88e2a63d-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('890fd448-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('8943db0f-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('8973ed01-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');
INSERT INTO `ssmapi_agenda` VALUES ('89a98e58-1929-11e8-acaa-00ffa8a5f50c', '代码', '写BUG', '2018-02-01', null, '康尔宝');

-- ----------------------------
-- Table structure for `ssmapi_user`
-- ----------------------------
DROP TABLE IF EXISTS `ssmapi_user`;
CREATE TABLE `ssmapi_user` (
  `uuid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssmapi_user
-- ----------------------------
INSERT INTO `ssmapi_user` VALUES ('f565136a-4f3f-43be-b926-b5fe1f31fd87', 'admin', 'admin', '13624053637', null, null);
INSERT INTO `ssmapi_user` VALUES ('f565136a-4f3f-43be-b926-b5fe1f31fd88', '康尔宝', '123456', null, null, null);

-- ----------------------------
-- Table structure for `user_inf`
-- ----------------------------
DROP TABLE IF EXISTS `user_inf`;
CREATE TABLE `user_inf` (
  `uuid` varchar(255) NOT NULL,
  `uname` varchar(30) DEFAULT NULL,
  `passwd` varchar(30) DEFAULT NULL,
  `gentle` varchar(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_inf
-- ----------------------------
INSERT INTO `user_inf` VALUES ('1', 'rico', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('2', 'shudaizi', '123', 'nan', 'ahah', 'beijing');
INSERT INTO `user_inf` VALUES ('3', '林建睿', '123', '男', 'rico_betterme@163.com', '大同');
INSERT INTO `user_inf` VALUES ('36', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('37', 'shudaizi', '123', '男', 'shudaizi@tju.edu.cn', '沈阳');
INSERT INTO `user_inf` VALUES ('38', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('39', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('40', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('41', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('42', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('43', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('44', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('45', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('46', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('47', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('48', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('49', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('50', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('51', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('52', 'ricoo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('53', 'oo', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('54', 'o', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('55', 'shudaizi', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('56', 'shudaizi', '123', '男', 'rico@tju.edu.cn', '天津');
INSERT INTO `user_inf` VALUES ('57', 'shudaizi', '123', '男', 'rico@tju.edu.cn', '天津');
