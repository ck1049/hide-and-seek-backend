-- hide_and_seek.`role` definition

CREATE TABLE `role` (
                        `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                        `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
                        `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '角色描述',
                        `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0：是；1：否',
                        PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色表';

INSERT INTO hide_and_seek.`role`
(role_id, role_name, description)
VALUES(1, 'admin', '管理员');
INSERT INTO hide_and_seek.`role`
(role_id, role_name, description)
VALUES(2, 'user', '普通用户');
INSERT INTO hide_and_seek.`role`
(role_id, role_name, description)
VALUES(3, 'vip', 'vip用户');


-- hide_and_seek.user_role definition

CREATE TABLE `user_role` (
                             `user_id` int NOT NULL COMMENT '用户ID',
                             `role_id` int NOT NULL COMMENT '角色ID',
                             `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                             `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0：是；1：否',
                             PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户角色关联表';


-- hide_and_seek.users definition

CREATE TABLE `users` (
                         `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                         `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
                         `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
                         `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '电子邮件',
                         `first_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名字',
                         `last_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓氏',
                         `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '电话号码',
                         `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '地址',
                         `city` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '城市',
                         `state` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '州/省份',
                         `country` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '国家',
                         `postal_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '邮政编码',
                         `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                         `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                         `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0：是；1：否',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户信息表';


-- hide_and_seek.users_token definition

CREATE TABLE `users_token` (
                               `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                               `token_id` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '短期tokenId',
                               `token` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '长期token',
                               `expire` bigint DEFAULT NULL COMMENT '有效期',
                               `expire_unit` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '有效期单位',
                               `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
                               `used` tinyint NOT NULL DEFAULT '0' COMMENT '使用次数',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='token使用记录';