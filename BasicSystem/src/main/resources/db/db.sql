CREATE SCHEMA `exam_system` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE `sys_user` (
                            `id` varchar(50) NOT NULL,
                            `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
                            `gender` int DEFAULT NULL COMMENT '性别',
                            `age` int DEFAULT NULL COMMENT '年龄',
                            `birth_date` varchar(45) DEFAULT NULL COMMENT '生日',
                            `real_name` varchar(45) DEFAULT NULL COMMENT '真实姓名',
                            `id_card` varchar(45) DEFAULT NULL COMMENT '身份证号',
                            `phone` varchar(45) DEFAULT NULL COMMENT '联系方式',
                            `img` varchar(45) DEFAULT NULL COMMENT '照片',
                            `status` int DEFAULT NULL COMMENT '状态',
                            `del_flag` varchar(45) DEFAULT '0' COMMENT '0-未删除，1-删除',
                            `create_time` varchar(45) DEFAULT NULL COMMENT '创建时间',
                            `create_by` varchar(45) DEFAULT NULL COMMENT '创建人',
                            `update_time` varchar(45) DEFAULT NULL COMMENT '更新时间',
                            `update_by` varchar(45) DEFAULT NULL COMMENT '更新人',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `sys_role` (
                            `id` int NOT NULL,
                            `name` varchar(45) DEFAULT NULL COMMENT '角色名',
                            `role_identify` varchar(45) DEFAULT NULL COMMENT '角色标识',
                            `permission_range` varchar(45) DEFAULT NULL COMMENT '权限范围',
                            `role_type` int DEFAULT NULL COMMENT '角色类型',
                            `del_flag` int DEFAULT NULL COMMENT '0-未删除，1-删除',
                            `create_time` varchar(45) DEFAULT NULL,
                            `create_by` varchar(45) DEFAULT NULL,
                            `update_time` varchar(45) DEFAULT NULL,
                            `update_by` varchar(45) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `ref_user_role` (
                                 `user_id` varchar(50) NOT NULL COMMENT '用户id',
                                 `role_id` varchar(45) NOT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;