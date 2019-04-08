
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `user` */

-- 用户表
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(36) NOT NULL COMMENT '用户id',
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `password` varchar(36) DEFAULT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL COMMENT '用户年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert  into `user`(`id`,`username`,`password`,`age`) values ('1','admin','123456',22),('2','test','123456',22),('f7bf2ffa-b27f-11e8-9b7d-00ffbcd4c063','QWE','qwe',18);
-- 角色表
DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleid` varchar(36) NOT NULL COMMENT '角色id',
  `rolename` varchar(45) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(36) DEFAULT NULL COMMENT '角色类型',
  `desc` int(11) DEFAULT NULL COMMENT '说明'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


