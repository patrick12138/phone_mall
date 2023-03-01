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

 Date: 19/11/2022 17:09:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_sku_images
-- ----------------------------
DROP TABLE IF EXISTS `mall_sku_images`;
CREATE TABLE `mall_sku_images`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_id` bigint NULL DEFAULT NULL COMMENT 'sku_id',
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `img_sort` int NULL DEFAULT NULL COMMENT '排序',
  `default_img` int NULL DEFAULT NULL COMMENT '默认图[0 - 不是默认图，1 - 是默认图]',
  index(sku_id),
  FOREIGN KEY (sku_id) REFERENCES mall_sku_info(sku_id) ON DELETE CASCADE,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 123 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'sku图片' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mall_sku_images
-- ----------------------------
INSERT INTO `mall_sku_images` VALUES (1, 10010, 'https://gcore.jsdelivr.net/gh/zsxwz/tuchuang2@latest/2022/11/14/fa16cee4769f8a1d829df20514463968.png', 0, 1);
INSERT INTO `mall_sku_images` VALUES (2, 10010, 'https://gcore.jsdelivr.net/gh/zsxwz/tuchuang2@latest/2022/11/14/ac932ba130664358ba8c952a77e7995b.png', 0, 1);
INSERT INTO `mall_sku_images` VALUES (3, 10010, 'https://gcore.jsdelivr.net/gh/zsxwz/tuchuang2@latest/2022/11/14/01a97de8a2b4f4cb5b1918c83e8aff54.png', 0, 0);
INSERT INTO `mall_sku_images` VALUES (4, 10011, 'https://gcore.jsdelivr.net/gh/zsxwz/tuchuang2@latest/2022/11/15/f9ef2a595d7eb0e3bed1dc3d5ea8dc81.png', 0, 1);
INSERT INTO `mall_sku_images` VALUES (5, 10013, '/search/img/57d0d400Nfd249af4.jpg', 0, 1);
INSERT INTO `mall_sku_images` VALUES (6, 10013, '	/search/img/57d11c33N5cd57490.jpg', 0, 1);
INSERT INTO `mall_sku_images` VALUES (7, 10012, '/search/img/59bf38e4N886f54b1.jpg', 0, 1);
INSERT INTO `mall_sku_images` VALUES (8, 10012, '/search/img/59bf3c47N91d65c73.jpg', 0, 1);
INSERT INTO `mall_sku_images` VALUES (9, 10011, '/search/img/59bf3c47N91d65c73.jpg', 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
