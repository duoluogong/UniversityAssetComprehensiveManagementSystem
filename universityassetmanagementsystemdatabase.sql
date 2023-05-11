/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : universityassetmanagementsystemdatabase

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 12/05/2023 00:08:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for academy
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '学院ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学院名称',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for asset_details
-- ----------------------------
DROP TABLE IF EXISTS `asset_details`;
CREATE TABLE `asset_details`  (
  `asset_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `asset_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
  `category_id` int(0) NULL DEFAULT 1 COMMENT '类别ID',
  `academy_id` int(0) NULL DEFAULT NULL COMMENT '所属学院ID',
  `warehousing_time` datetime(0) NOT NULL COMMENT '入库时间',
  `inventory` int(0) NOT NULL DEFAULT 1 COMMENT '库存',
  `surplus` int(0) NOT NULL DEFAULT 1 COMMENT '余量',
  `repairing` int(0) NOT NULL DEFAULT 0 COMMENT '修理中',
  `state` int(0) NOT NULL DEFAULT 1 COMMENT '状态',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`asset_id`) USING BTREE,
  INDEX `surplus`(`surplus`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  INDEX `academy_id`(`academy_id`) USING BTREE,
  CONSTRAINT `asset_details_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `asset_details_ibfk_2` FOREIGN KEY (`academy_id`) REFERENCES `academy` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for leaseform
-- ----------------------------
DROP TABLE IF EXISTS `leaseform`;
CREATE TABLE `leaseform`  (
  `leaseform_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `user_id` int(0) NOT NULL COMMENT '调用人ID',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '调用人姓名',
  `uacademy_id` int(0) NULL DEFAULT NULL COMMENT '调用人所属学院ID',
  `user_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '调用人联系电话',
  `asset_id` int(0) NOT NULL COMMENT '调用资产ID',
  `asset_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资产名称',
  `academy_id` int(0) NULL DEFAULT NULL COMMENT '资产所属学院ID',
  `category_id` int(0) NULL DEFAULT NULL COMMENT '资产所属分类ID',
  `surplus` int(0) NULL DEFAULT NULL COMMENT '资产库存',
  `lease_num` int(0) NOT NULL COMMENT '调用数量',
  `return_date` datetime(0) NULL DEFAULT NULL COMMENT '资产归还时间',
  `lease_date` datetime(6) NOT NULL COMMENT '调用起始时间',
  `state` int(0) NOT NULL COMMENT '调用进展',
  PRIMARY KEY (`leaseform_id`) USING BTREE,
  INDEX `surplus`(`surplus`) USING BTREE,
  CONSTRAINT `leaseform_ibfk_1` FOREIGN KEY (`surplus`) REFERENCES `asset_details` (`surplus`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `m_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员ID',
  `m_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员姓名',
  `m_pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员密码',
  `m_sex` int(0) NOT NULL COMMENT '性别：0为女；1为男',
  `m_phone` int(0) NOT NULL COMMENT '管理员联系电话',
  `m_academy_id` int(0) NOT NULL COMMENT '管理员所属学院ID',
  `m_power` int(0) NOT NULL DEFAULT 2 COMMENT '管理员权限',
  `m_note` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '备注',
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for procure
-- ----------------------------
DROP TABLE IF EXISTS `procure`;
CREATE TABLE `procure`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `user_id` int(0) NOT NULL COMMENT '申请人ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '资产名称',
  `uacademy_id` int(0) NULL DEFAULT NULL COMMENT '资产申请所在学院ID',
  `category_id` int(0) NULL DEFAULT NULL COMMENT '资产所属类型ID',
  `num` int(0) NOT NULL DEFAULT 1 COMMENT '数量',
  `price` int(0) NOT NULL COMMENT '单价',
  `total` int(0) NOT NULL COMMENT '总价',
  `state` int(0) NOT NULL DEFAULT 1 COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户姓名',
  `user_pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `academy_id` int(0) NOT NULL COMMENT '所属学院的ID',
  `user_power` int(0) NOT NULL DEFAULT 0 COMMENT '用户权限',
  `user_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户联系电话',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 191377 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
