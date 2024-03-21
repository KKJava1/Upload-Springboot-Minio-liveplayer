/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.33
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 192.168.0.33:3306
 Source Schema         : minio-upload

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 25/08/2022 18:54:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_upload_task
-- ----------------------------
DROP TABLE IF EXISTS `sys_upload_task`;
CREATE TABLE `sys_upload_task` (
  `id` bigint NOT NULL,
  `upload_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分片上传的uploadId',
  `file_identifier` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件唯一标识（md5）',
  `file_name` varchar(500) COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件名',
  `bucket_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所属桶名',
  `object_key` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件的key',
  `total_size` bigint NOT NULL COMMENT '文件大小（byte）',
  `chunk_size` bigint NOT NULL COMMENT '每个分片大小（byte）',
  `chunk_num` int NOT NULL COMMENT '分片数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_file_identifier` (`file_identifier`) USING BTREE,
  UNIQUE KEY `uq_upload_id` (`upload_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='分片上传-分片任务记录';

SET FOREIGN_KEY_CHECKS = 1;
