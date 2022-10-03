/*
 Navicat Premium Data Transfer

 Source Server         : mysql-ROOT
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : stu_manager

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 03/10/2022 22:15:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int(11) NOT NULL COMMENT '课程号',
  `course_name` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '课程名',
  `hours` int(11) NULL DEFAULT NULL COMMENT '学时',
  `credit` int(11) NULL DEFAULT NULL COMMENT '学分',
  `version` int(255) NULL DEFAULT NULL COMMENT '锁同步',
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (101, '计算机基础', 80, 5, NULL);
INSERT INTO `course` VALUES (102, '程序设计与语言', 68, 4, NULL);
INSERT INTO `course` VALUES (206, '离散数学', 68, 4, NULL);
INSERT INTO `course` VALUES (208, '数据结构', 68, 4, NULL);
INSERT INTO `course` VALUES (209, '操作系统', 68, 4, NULL);
INSERT INTO `course` VALUES (210, '计算机原理', 85, 5, NULL);
INSERT INTO `course` VALUES (212, '数据库原理', 68, 4, NULL);
INSERT INTO `course` VALUES (301, '计算机网络', 51, 3, NULL);
INSERT INTO `course` VALUES (302, '软件工程', 51, 3, NULL);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `student_id` int(11) NOT NULL COMMENT '学号',
  `course_id` int(11) NOT NULL COMMENT '课程号',
  `score` int(11) NULL DEFAULT 0 COMMENT '成绩',
  `version` int(11) NULL DEFAULT 0 COMMENT '锁同步',
  PRIMARY KEY (`student_id`, `course_id`) USING BTREE,
  INDEX `fk_cou_id`(`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (12345, 208, 99, 0);
INSERT INTO `score` VALUES (81101, 101, 80, 0);
INSERT INTO `score` VALUES (81101, 102, 78, 0);
INSERT INTO `score` VALUES (81101, 206, 76, 0);
INSERT INTO `score` VALUES (81102, 101, 65, 0);
INSERT INTO `score` VALUES (81102, 102, 78, 0);
INSERT INTO `score` VALUES (81102, 206, 78, 0);
INSERT INTO `score` VALUES (81103, 101, 62, 0);
INSERT INTO `score` VALUES (81103, 102, 70, 0);
INSERT INTO `score` VALUES (81103, 206, 81, 0);
INSERT INTO `score` VALUES (81104, 101, 90, 0);
INSERT INTO `score` VALUES (81104, 102, 84, 0);
INSERT INTO `score` VALUES (81104, 206, 65, 0);
INSERT INTO `score` VALUES (81105, 101, 85, 0);
INSERT INTO `score` VALUES (81105, 102, 98, 0);
INSERT INTO `score` VALUES (81105, 206, 74, 0);
INSERT INTO `score` VALUES (81105, 208, 78, 0);
INSERT INTO `score` VALUES (81106, 101, 65, 0);
INSERT INTO `score` VALUES (81106, 102, 71, 0);
INSERT INTO `score` VALUES (81106, 206, 80, 0);
INSERT INTO `score` VALUES (81107, 101, 78, 0);
INSERT INTO `score` VALUES (81107, 102, 80, 0);
INSERT INTO `score` VALUES (81107, 206, 68, 0);
INSERT INTO `score` VALUES (81108, 101, 85, 0);
INSERT INTO `score` VALUES (81108, 102, 64, 0);
INSERT INTO `score` VALUES (81108, 206, 87, 0);
INSERT INTO `score` VALUES (81109, 101, 66, 0);
INSERT INTO `score` VALUES (81109, 102, 83, 0);
INSERT INTO `score` VALUES (81109, 206, 70, 0);
INSERT INTO `score` VALUES (81110, 101, 95, 0);
INSERT INTO `score` VALUES (81110, 102, 90, 0);
INSERT INTO `score` VALUES (81110, 206, 89, 0);

-- ----------------------------
-- Table structure for specialty
-- ----------------------------
DROP TABLE IF EXISTS `specialty`;
CREATE TABLE `specialty`  (
  `id` int(11) NOT NULL COMMENT '专业ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '专业名',
  `num` int(11) NULL DEFAULT NULL COMMENT '人数',
  `teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '老师',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of specialty
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` int(11) NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生时间',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '住址',
  `professional_id` int(11) NULL DEFAULT NULL COMMENT '专业ID',
  `total_credits` int(11) NULL DEFAULT NULL COMMENT '总学分',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `deleted` int(11) NULL DEFAULT 0 COMMENT '逻辑删除',
  `version` int(11) NULL DEFAULT 0 COMMENT '锁同步',
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 81111 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (12345, '李明', 1, '2022-10-26', '北京市朝阳区', 2, 52, '无', 0, 0);
INSERT INTO `student` VALUES (81101, '王林', 1, '1990-02-09', '北京市朝阳区', 1, 50, '无', 0, 0);
INSERT INTO `student` VALUES (81102, '程明', 1, '1991-08-20', '北京市朝阳区', 1, 50, '无', 0, 0);
INSERT INTO `student` VALUES (81103, '王燕', 0, '1992-10-05', '北京市朝阳区', 1, 50, '无', 0, 0);
INSERT INTO `student` VALUES (81104, '魏萍萍', 0, '1993-08-25', '北京市朝阳区', 1, 50, '无', 0, 0);
INSERT INTO `student` VALUES (81105, '李芳芳', 0, '1994-11-19', '北京市朝阳区', 1, 50, '无', 0, 0);
INSERT INTO `student` VALUES (81106, '赵琳', 1, '1995-04-30', '北京市朝阳区', 1, 54, '提前修完“数据结构”，并获得学分', 0, 0);
INSERT INTO `student` VALUES (81107, '林一凡', 1, '1996-08-04', '北京市朝阳区', 1, 52, '提前修完一门课', 0, 0);
INSERT INTO `student` VALUES (81108, '张强明', 1, '1997-08-10', '北京市朝阳区', 1, 38, '多次旷课，五门不及格', 0, 0);
INSERT INTO `student` VALUES (81109, '张维', 1, '1998-07-21', '北京市朝阳区', 1, 50, '三好生', 0, 0);
INSERT INTO `student` VALUES (81110, '赵琳', 0, '1999-03-17', '北京市朝阳区', 1, 45, '无', 0, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1661521937 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '123', '123');
INSERT INTO `user` VALUES (2, '456', '456');

SET FOREIGN_KEY_CHECKS = 1;
