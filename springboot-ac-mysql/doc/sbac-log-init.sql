
--  SQL init for MySql
--
--  @author lazycece
--  @date 2019/4/18


DROP DATABASE IF EXISTS `sbac_log`;

CREATE SCHEMA IF NOT EXISTS `sbac_log` DEFAULT CHARACTER SET utf8;

USE sbac_log;

CREATE TABLE IF NOT EXISTS system_log (
    id BIGINT UNSIGNED AUTO_INCREMENT,
    create_time DATETIME NOT NULL COMMENT '创建时间',
    editor VARCHAR(20) NOT NULL COMMENT '编辑者',
    operation VARCHAR(255) NOT NULL COMMENT '操作行为',
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;