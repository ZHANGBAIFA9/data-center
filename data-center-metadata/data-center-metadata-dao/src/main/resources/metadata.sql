CREATE TABLE `metadata_datasource`
(
    `id`                  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `datasource_name`     varchar(128) NOT NULL COMMENT '数据源名称',
    `engine_type`         int(2) NOT NULL COMMENT '数据源类型(2:hive 1:MySQL 3:spark 4:presto 5:clickhouse )',
    `jdbc_url`            varchar(256) NOT NULL COMMENT '数据源连接',
    `user_name`           varchar(128) DEFAULT NULL,
    `password`            varchar(128) DEFAULT NULL,
    `test_connect_status` int(2) DEFAULT NULL COMMENT '测试连接状态(1: 链接可用 0:链接异常 )',
    `datasource_desc`     varchar(256) DEFAULT NULL COMMENT '数据源描述',
    `account_type`        int(2) NOT NULL COMMENT '账户类型：0 普通账户 1 通用账户',
    `region_id`           bigint(20) DEFAULT NULL COMMENT '集群地址id',
    `engine_version`      bigint(2) DEFAULT NULL COMMENT '引擎版本',
    `app_id`              bigint(2) DEFAULT NULL COMMENT '应用id',
    `collect_status`      int(2) NOT NULL COMMENT '采集状态(0 ：待采集 1：采集中 ，2；采集成功 3：采集失败)',
    `last_collect_time`   datetime(6) DEFAULT NULL COMMENT '最后一次采集开始时间',
    `version`             bigint(20) NOT NULL COMMENT '版本号',
    `is_del`              tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 未删除 默认，1已删除',
    `created_at`          datetime(6) NOT NULL COMMENT '创建时间',
    `created_by`          varchar(20)  NOT NULL COMMENT '创建人工号',
    `updated_at`          datetime(6) NOT NULL COMMENT '修改时间',
    `updated_by`          varchar(20)  NOT NULL COMMENT '修改人工号',
    `last_updated_at`     datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP (6) ON UPDATE CURRENT_TIMESTAMP (6) COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `UIDX_URL_USER_PASS` (`jdbc_url`,`user_name`,`password`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='数据源';

CREATE TABLE `metadata_region`(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `city`            varchar(20) NOT NULL COMMENT '集群所在城市',
    `computer_room`   varchar(20) NOT NULL COMMENT '集群所在机房',
    `cluster`         varchar(20) NOT NULL COMMENT '集群名称',
    `version`         bigint(20) NOT NULL COMMENT '版本号',
    `is_del`          tinyint(1) NOT NULL DEFAULT '0' COMMENT '0 未删除 默认，1已删除',
    `created_at`      datetime(6) NOT NULL COMMENT '创建时间',
    `created_by`      varchar(20) NOT NULL COMMENT '创建人工号',
    `updated_at`      datetime(6) NOT NULL COMMENT '修改时间',
    `updated_by`      varchar(20) NOT NULL COMMENT '修改人工号',
    `last_updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP (6) ON UPDATE CURRENT_TIMESTAMP (6) COMMENT '最后修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COMMENT='集群地址信息';

