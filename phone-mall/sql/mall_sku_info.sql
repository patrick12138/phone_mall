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

 Date: 19/11/2022 17:09:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_sku_info
-- ----------------------------
DROP TABLE IF EXISTS `mall_sku_info`;
CREATE TABLE `mall_sku_info`  (
  `sku_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'skuId',
  `spu_id` bigint NULL DEFAULT NULL COMMENT 'spuId',
  `sku_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'sku名称',
  `sku_desc` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'sku介绍描述',
  `catalog_id` bigint NULL DEFAULT NULL COMMENT '所属分类id',
  `brand_id` bigint NULL DEFAULT NULL COMMENT '品牌id',
  `sku_default_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '默认图片',
  `sku_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `sku_subtitle` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '副标题',
  `price` decimal(18, 4) NULL DEFAULT NULL COMMENT '价格',
  `sale_count` bigint NULL DEFAULT NULL COMMENT '销量',
  PRIMARY KEY (`sku_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10013 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'sku信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mall_sku_info
-- ----------------------------
INSERT INTO `mall_sku_info` VALUES (10010, 101, '华为 HUAWEI Mate 10', '', 111, 123, 'https://gcore.jsdelivr.net/gh/zsxwz/tuchuang2@latest/2022/11/14/fa16cee4769f8a1d829df20514463968.png', '华为 HUAWEI Mate 10 6GB+128GB 亮黑色 移动联通电信4G手机 双卡双待', ' 华为 HUAWEI Mate 10 Pro 10:08 限时限量抢！', 4499.0000, 100);
INSERT INTO `mall_sku_info` VALUES (10011, 101, 'HUAWEI nova 8 SE 6400万高清四摄 支持66W超级快充 6.5英寸OLED大屏', 'HUAWEI nova 8 SE 6400万高清四摄', 111, 123, 'https://gcore.jsdelivr.net/gh/zsxwz/tuchuang2@latest/2022/11/15/f9ef2a595d7eb0e3bed1dc3d5ea8dc81.png', 'HUAWEI nova 8 SE 6400万高清四摄 支持66W超级快充 6.5英寸OLED大屏', 'HUAWEI nova 8 SE 6400万高清四摄', 1800.0000, 500);
INSERT INTO `mall_sku_info` VALUES (10012, 101, '荣耀8 4GB+64GB 全网通4G手机 魅海蓝', 'HUAWEI nova 8 SE 6400万高清四摄', 111, 123, '/search/img/59bf3c47N91d65c73.jpg', '荣耀8 4GB+64GB 全网通4G手机 魅海蓝', '荣耀8 4GB+64GB 全网通4G手机 魅海蓝', 1699.0000, 5000);
INSERT INTO `mall_sku_info` VALUES (10013, 101, 'Apple iPhone 7 Plus (A1661) 32G 黑色 移动联通电信4G手机', 'HUAWEI nova 8 SE 6400万高清四摄', 111, 123, '/search/img/57d0d400Nfd249af4.jpg', 'Apple iPhone 7 Plus (A1661) 32G 黑色 移动联通电信4G手机', 'Apple iPhone 7 Plus (A1661) 32G', 5199.0000, 1000);

SET FOREIGN_KEY_CHECKS = 1;
