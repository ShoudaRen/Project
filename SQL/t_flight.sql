/*
 Navicat Premium Data Transfer

 Source Server         : graduateProject
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : airline

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 17/12/2021 06:00:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_flight
-- ----------------------------
DROP TABLE IF EXISTS `t_flight`;
CREATE TABLE `t_flight`  (
  `flightId` int NOT NULL AUTO_INCREMENT,
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flightDay` date NULL DEFAULT NULL,
  `flightName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `takeOffTime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fallingOffTime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `duration` int NULL DEFAULT NULL,
  `fromLocation` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `toLocation` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `StayCity` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `AdultNum` int NULL DEFAULT NULL COMMENT 'ticket amount 剩余的票数量',
  `childrenNum` int NULL DEFAULT NULL,
  `infantsNum` int NULL DEFAULT NULL,
  `disableNum` int NULL DEFAULT NULL,
  `EcoPrice` int NULL DEFAULT NULL,
  `businessPrice` int NULL DEFAULT NULL,
  `FirstPrice` int NULL DEFAULT NULL,
  `ChildPrice` int NULL DEFAULT NULL,
  `infantPrice` int NULL DEFAULT NULL,
  `disablePrice` int NULL DEFAULT NULL,
  `entertainment` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '娱乐包 免费可以选择',
  `isDelete` int NULL DEFAULT NULL,
  `Onsale` int NULL DEFAULT NULL COMMENT '1 sale 0 no',
  `created_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created_time` datetime NULL DEFAULT NULL,
  `modified_user` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modified_time` time NULL DEFAULT NULL,
  PRIMARY KEY (`flightId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_flight
-- ----------------------------
INSERT INTO `t_flight` VALUES (2, 'BA', '2021-11-19', 'GK123', '10:00AM', '01:00PM', 2, 'GLASGOW', 'EDINBURGH', 'None', '', 999, 0, 0, 0, 100, 200, 300, 100, 0, 0, 'normal', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_flight` VALUES (3, 'Airchina', '2021-11-06', 'EV435', '05:00AM', '07:00AM', 2, 'BEIJING', 'SHANGHAI', 'None', NULL, 246, 12, 12, 2, 100, 200, 300, 0, 0, 0, 'normal', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_flight` VALUES (4, 'Finnair', '2021-11-25', 'QA123', '04:00PM', '06:00PM', 2, 'GERMANY', 'FINLAND', 'None', NULL, 298, NULL, NULL, NULL, 30, 50, 100, NULL, NULL, NULL, 'normal', NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `t_flight` VALUES (5, 'Birtish AirWay', '2021-11-20', 'PO213', '09:30AM', '10:30AM', 1, 'LONDON', 'GLASGOW', 'None', NULL, 297, NULL, NULL, NULL, 15, 30, 70, NULL, NULL, NULL, 'normal', NULL, 1, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
