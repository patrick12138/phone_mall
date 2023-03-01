/*
 Navicat Premium Data Transfer

 Source Server         : win10_mysql8.0
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 19/11/2022 17:08:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_order_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_item`;
CREATE TABLE `mall_order_item`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` bigint NOT NULL,
  `order_time` datetime(0) NOT NULL,
  `sku_id` bigint NULL DEFAULT NULL COMMENT '商品sku编号',
  `title` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `count` int NULL DEFAULT NULL,
  `image` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `total_price` decimal(18, 4) NULL DEFAULT NULL COMMENT '总价格',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id_delete`(`order_id`) USING BTREE,
  CONSTRAINT `order_id_delete` FOREIGN KEY (`order_id`) REFERENCES `mall_order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mall_order_item
-- ----------------------------
INSERT INTO `mall_order_item` VALUES (22, 1367120514048000, '2022-11-19 00:00:00', 10013, 'Apple iPhone 7 Plus (A1661) 32G 黑色 移动联通电信4G手机', 7, '/search/img/57d0d400Nfd249af4.jpg', 36393.0000);

SET FOREIGN_KEY_CHECKS = 1;
