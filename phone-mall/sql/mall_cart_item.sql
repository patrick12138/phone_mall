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

 Date: 19/11/2022 17:08:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_cart_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_cart_item`;
CREATE TABLE `mall_cart_item`  (
  `sku_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'skuId',
  `checked` int NULL DEFAULT NULL COMMENT '默认选中[0 - 不是，1 - 是]',
  `title` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `image` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sku_attr` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` decimal(18, 4) NULL DEFAULT NULL COMMENT '价格',
  `count` int NULL DEFAULT NULL,
  `total_price` decimal(18, 4) NULL DEFAULT NULL COMMENT '总价格',
  PRIMARY KEY (`sku_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10013 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '购物车商品信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mall_cart_item
-- ----------------------------
INSERT INTO `mall_cart_item` VALUES (10013, 0, 'Apple iPhone 7 Plus (A1661) 32G 黑色 移动联通电信4G手机', '/search/img/57d0d400Nfd249af4.jpg', '手机', 5199.0000, 1, 5199.0000);

SET FOREIGN_KEY_CHECKS = 1;
