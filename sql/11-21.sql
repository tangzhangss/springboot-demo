-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.23 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 springboot_demo 的数据库结构
CREATE DATABASE IF NOT EXISTS `springboot_demo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `springboot_demo`;


-- 导出  表 springboot_demo.tbl_student 结构
CREATE TABLE IF NOT EXISTS `tbl_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(4) DEFAULT '1' COMMENT '性别 1 男  2女',
  `age` int(100) DEFAULT '18' COMMENT '年龄',
  `descr` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8 COMMENT='学生信息表';

-- 正在导出表  springboot_demo.tbl_student 的数据：~4 rows (大约)
DELETE FROM `tbl_student`;
/*!40000 ALTER TABLE `tbl_student` DISABLE KEYS */;
INSERT INTO `tbl_student` (`id`, `name`, `sex`, `age`, `descr`) VALUES
	(10000, '张三', 2, 18, '我是漳卅...'),
	(10002, '李四', 1, 25, '我是李四....'),
	(10003, '麻子', 1, 26, '我是麻子.....'),
	(10005, '王二', 1, 10, '我是麻子哦。。。');
/*!40000 ALTER TABLE `tbl_student` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
