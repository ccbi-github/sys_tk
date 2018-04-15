--
--
--
DROP DATABASE IF EXISTS tk_sys;
CREATE DATABASE tk_sys default character set utf8;
USE tk_sys;
-------课程表-------
DROP TABLE IF EXISTS tk_course;
create table tk_course(
id int primary key auto_increment comment'课程id',
name varchar(50) unique not null  comment'课程名',
price bigint not null  comment'价格',
description varchar(300)  comment'描述',
type tinyint comment'四种类型,1,2,3,4分别对应PHP,前端,Java,安卓',
state tinyint comment'两种状态,分别对应,上架和下架',
picUrl varchar(200) comment'图片保存的路径',
level varchar(50) comment'课程等级',
stuNum int comment'学生报名数量,可以理解为热度',
createdUser varchar(50),
modifiedUser varchar(50),
createdTime datetime,
modifiedTime datetime
)engine=innoDB,charset=utf8;

-------测试数据-----------
insert into tk_course
(id,name,price,description,type,state,picUrl,level,stuNum,createdTime,modifiedTime,createdUser,modifiedUser) values
(null,'PhpStorm的基本应用',300,'PhpStorm是PHP集成开发工具，能提高我们的开发效率，提供智能代码补全，快速导航以及即时错误检查。',1,1,null,'初级',1200,now(),now(),'admin','admin'),
(null,'CDN与智能DNS原理和应用',400,'CDN是内容分发网络，利用部署大量网络节点，通过服务器缓存加速，让用户可以就近同运营商网络，更快的访问到我们的互联网产品，可以简单快速的让我们的互联网产品支持海量的并发请求。',1,1,null,'高级',3000,now(),now(),"admin","admin"),
(null,'ES6快速入门',200,'本课程通过ES3、ES5、ES6的对比去实现同一个问题。',2,1,null,'初级',500,now(),now(),"admin","admin"),
(null,'ajax跨域完全讲解',500,'通过讲解什么是跨域问题，从系统最常见的部署结构上分析跨域解决的思路，详细讲解jsonp的工作机制，http协议如何支持跨域，以及http服务器nginx和apache的2种不同解决思路，让大家知其然并知其所以然，快速掌握问题本质和分析问题的方法。',2,1,null,'中级',3000,now(),now(),"admin","admin"),
(null,'SpringBoot+MyBatis搭建迷你小程序',500,'微信小程序作为目前炙手可热的应用，很有可能在未来占据轻应用的市场。本门课程的主要目的是将两者结合起来，同时希望作为入门翔仔之前实战课的一个更低门槛的课程进行讲解。',3,1,null,'初级',6000,now(),now(),"admin","admin"),
(null,'SpringBoot开发常用技术整合',300,'本课程通过详细的对springboot的各个技能点逐一介绍与演示，可以很迅速的熟悉整个springboot框架体系，并且与springmvc有效的进行对比，理解异同，这样对于后续的springboot开发会非常迅速。',3,1,null,'中级',8000,now(),now(),"admin","admin"),
(null,'MyCAT入门及应用',550,'本课程从实际生产环境应用MyCAT入手，讲解MyCAT的基础知识和MyCAT的基本应用操作，本课程的目标就是“看得懂、学得会、做得出”，为后续的学习打下夯实的基础。',4,1,null,'初级',1000,now(),now(),"admin","admin"),
(null,'MySQL5.7版本新特性',600,'据说最好的MySQL版本已经到来，主从复制数据不丢失、sys库的加入。原生JSON格式的支持等优化都将MySQL5.7推向了一个崭新的高度。本课程分别从服务器、Replication、InnoDB引擎及安全和管理等四个方面带你了解全新的MySQL5.7。',4,1,null,'高级',2500,now(),now(),"admin","admin");

-------用户课程关系表---梁朝恩----
drop table if exists tk_user_course;
create table tk_user_course(
id  		     int(11) not null primary key auto_increment   COMMENT '用户课程id',
user_id          int(11) not null   COMMENT '用户id', 
course_id        int(11) not null   COMMENT '课程id',
validity     	 int   COMMENT '课程有效期,以秒为单位',
buyingTime       datetime   COMMENT '购买课程时间'
)engine=innodb charset=utf8;

-------测试数据-----梁朝恩------
INSERT INTO tk_user_course
(user_id,course_id,validity,buyingTime)VALUES
(1,34,5453,now()),
(2,434,4522,now()),
(244,2,45346,now()),
(32,42,45634,now()),
(56,14,54634,now()),
(3,56,45546,now());

-------销售记录表---罗章理----
drop table if exists tk_salesRecord;
create table tk_salesRecord (
id		 int(11) not null primary key auto_increment   COMMENT '销售记录id',
course_id      int(11) not null  COMMENT '课程id',
user_id 	int(11) not null  COMMENT '用户id',
price 		decimal(10,2)  COMMENT '售价',
buyingTime     datetime   COMMENT '购买课程时间',
createdTime  datetime  COMMENT '课程创建时间',
modifiedTime datetime  COMMENT '修改课程时间',
createdUser    varchar(50)  COMMENT '创建课程者',
modifiedUser   varchar(50)   COMMENT '修改课程者'
)engine=innodb charset=utf8;

-----------用户表---汪鹏------
drop table if exists tk_user;
create table tk_user(
id      int(11) not null primary key auto_increment,
username   	varchar(100) not null unique key  COMMENT '用户名',
password  	varchar(200) not null  COMMENT '用户密码',
salt 		varchar(200)  COMMENT '盐  密码加密时前缀，使加密后的值不同',
address     	varchar(200) not null  COMMENT '用户地址',
phone          varchar(50) not null  COMMENT '用户电话',
email          varchar(50) not null  COMMENT '用户邮箱',
valid        tinyint(4) DEFAULT NULL COMMENT '状态 0:禁用  1: 正常  默认值:1',
createdTime  datetime  COMMENT '课程创建时间',
modifiedTime datetime  COMMENT '修改课程时间',
createdUser    varchar(50)  COMMENT '创建课程者',
modifiedUser   varchar(50)   COMMENT '修改课程者'
)engine=innodb charset=utf8;

-----------用户表初始化插入语句----------

insert into tk_user  values
(NULL,'admin','168bbb56b81e8e244aeb2a47d924cfe6','c099b82f-cb83-465c-9354-aa81c7c96a90','SZ','13999999999','admin@tedu.cn',1,'2018-03-27 17:08:39','2018-03-27 17:08:39',NULL,NULL),
(NULL,'chenchuangbi','b107c95814b8ce200673266da8b4be7f','6b8d0a92-a721-442b-8b2d-209328c01d71','SZ','13425468753','chenchuangbi@tedu.cn',1,'2018-03-27 17:15:47','2018-03-27 17:15:47',NULL,NULL),
(NULL,'chenyihong','3c763c91a85c1d2a2573ff52a9e9f50e','9e94c8dd-dc4c-4f62-80e5-0f3453048f33','SZ','13425468753','chenyihong@tedu.cn',1,'2018-03-27 17:22:06','2018-03-27 17:22:06',NULL,NULL),
(NULL,'jianyun','8bb118527e052ea2f88b9a82ebd77571','2dded1a4-77aa-4fc3-afc9-34a697f6f54f','SZ','13425468753','jianyun@tedu.cn',1,'2018-03-27 17:22:26','2018-03-27 17:22:26',NULL,NULL),
(NULL,'hezhongwen','c482b106ae3c9b6d87d804ae01637238','17d1e4ea-9512-494a-b7b2-5f99f173896f','SZ','13425468753','hezhongwen@tedu.cn',1,'2018-03-27 10:41:32',NULL,'admin','admin'),
(NULL,'wangdu','4a54258b34566f6f594a65820a633caa ','5b530a2f-65df-4c96-be3b-a56ad3406eba','SZ','13321546957','wangdu@tedu.cn',1,'2018-03-27 10:41:32',NULL,'admin',NULL),
(NULL,'liangchaoen','4f5ee45ebdf8fcb6b21f7fb101d11060','9cbb08a3-8c01-492c-a7ea-a2cd0418326f','SZ','13824672159','liangchaoen@tedu.cn',1,'2018-03-27 10:55:32',NULL,'admin',NULL),
(NULL,'wangpeng','53d159e31b69a0f47467ae3e4fc7ad06','22b911c2-ed44-4f81-86d5-ed46c7c33342','SZ','13790903653','wangpeng@tedu.cn',1,'2018-03-27 12:36:32',NULL,'admin',NULL),
(NULL,'chenzhiwei','e4c84c660aad33946246d11f09e6bf52','8f54ec7f-327e-4f03-8b21-eddf4793cf65','SZ','13521463285','chenzhiwei@tedu.cn',1,'2018-03-26 13:41:32',NULL,'admin',NULL),
(NULL,'zhouwengeng','cc8176f730250e7ec55da02ab84fa7f1','76221b65-4573-45d8-9d15-d9344f3c5cea','SZ','13512654865','zhouwengeng@tedu.cn',1,'2018-03-22 10:45:32',NULL,'admin',NULL),
(NULL,'luozhangli','ab2975e03b0d964a59d9600e652ed872','bef50f2d-1859-4b80-86bf-c67de4264ca3','SZ','13512654865','luozhangli@tedu.cn',1,'2018-03-22 10:45:32',NULL,'admin',NULL);

-------vip表----汪鹏---
drop table if exists tk_vip;
create table tk_vip(
id             int(11) not null primary key auto_increment COMMENT 'vip的id',
validity       int COMMENT 'vip有效期',
buyingTime     datetime COMMENT 'vip购买时间',
vipLevel       tinyint(4) DEFAULT NULL COMMENT '值  0:管理员  1:普通   2:初级   3：中级  4：高级  默认值:1',
createdTime  datetime  COMMENT '课程创建时间',
modifiedTime datetime  COMMENT '修改课程时间',
createdUser    varchar(50)  COMMENT '创建课程者',
modifiedUser   varchar(50)   COMMENT '修改课程者'
)engine=innodb charset=utf8;

----------vip表初始化数据------------
insert into tk_vip values
(NULL,180,'2017-07-13 17:44:11',4,'2017-07-13 17:44:11','2017-08-29 14:28:45','admin','admin'),
(NULL,180,'2017-07-13 17:44:11',4,'2017-07-13 17:44:11','2017-08-29 14:28:45','admin','admin'),
(NULL,90,'2017-07-13 17:44:11',3,'2017-07-13 17:44:11','2017-08-29 14:28:45','admin','admin'),
(NULL,90,'2017-07-13 17:44:11',3,'2017-07-13 17:44:11','2017-08-29 14:28:45','admin','admin'),
(NULL,30,'2017-07-13 17:44:11',2,'2017-07-13 17:44:11','2017-08-29 14:28:45','admin','admin'),
(NULL,30,'2017-07-13 17:44:11',2,'2017-07-13 17:44:11','2017-08-29 14:28:45','admin','admin'),
(NULL,0,'2017-07-13 17:44:11',1,'2017-07-13 17:44:11','2017-08-29 14:28:45','admin','admin'),
(NULL,0,'2017-07-13 17:44:11',1,'2017-07-13 17:44:11','2017-08-29 14:28:45','admin','admin'),
(NULL,30,'2017-07-13 17:44:11',2,'2017-07-13 17:44:11','2017-08-29 14:28:45','admin','admin'),
(NULL,180,'2017-07-13 17:44:11',4,'2017-07-13 17:44:11','2017-08-29 14:28:45','admin','admin');

----------------------------------------

-------用户vip关系表---汪鹏----
drop table if exists tk_user_vip;
create table tk_user_vip(
id  	     int(11) not null primary key auto_increment  COMMENT '用户vip关系id',
user_id      int(11) not null  COMMENT '用户的id',
vip_id       int(11) not null  COMMENT 'vip的id',
createdTime  datetime  COMMENT '课程创建时间',
modifiedTime datetime  COMMENT '修改课程时间',
createdUser    varchar(50)  COMMENT '创建课程者',
modifiedUser   varchar(50)   COMMENT '修改课程者'
)engine=innodb charset=utf8;

----------user_vip表初始化数据----------
insert into tk_user_vip values
(NULL,1,1,'2017-07-13 17:44:11','2017-07-13 17:44:11',NULL,NULL),
(NULL,2,2,'2017-07-13 17:44:11','2017-07-13 17:44:11',NULL,NULL),
(NULL,3,3,'2017-07-13 17:44:11','2017-07-13 17:44:11',NULL,NULL),
(NULL,4,4,'2017-07-13 17:44:11','2017-07-13 17:44:11',NULL,NULL),
(NULL,5,5,'2017-07-13 17:44:11','2017-07-13 17:44:11',NULL,NULL),
(NULL,6,6,'2017-07-13 17:44:11','2017-07-13 17:44:11',NULL,NULL),
(NULL,7,7,'2017-07-13 17:44:11','2017-07-13 17:44:11',NULL,NULL),
(NULL,8,8,'2017-07-13 17:44:11','2017-07-13 17:44:11',NULL,NULL),
(NULL,9,9,'2017-07-13 17:44:11','2017-07-13 17:44:11',NULL,NULL),
(NULL,10,10,'2017-07-13 17:44:11','2017-07-13 17:44:11',NULL,NULL),
(NULL,11,11,'2017-07-13 17:44:11','2017-07-13 17:44:11',NULL,NULL);
--------------------

-------课程菜单表----何忠文----
drop table if exists tk_menus;
create table tk_menus(
id             int(11) not null primary key auto_increment  COMMENT '菜单id',
name           int(11) not null  COMMENT '菜单名',
parent_id      int(11)   COMMENT '父菜单id',
createdTime  datetime  COMMENT '课程创建时间',
modifiedTime datetime  COMMENT '修改课程时间',
createdUser    varchar(50)  COMMENT '创建课程者',
modifiedUser   varchar(50)   COMMENT '修改课程者'
)engine=innodb charset=utf8;
----
 
-------菜单课程关系表------何忠文--
drop table if exists tk_menus_course;

create table tk_menus_course (
id	    int(11) not null primary key auto_increment  COMMENT '菜单课程id',
meues_id    int(11) not null  COMMENT '菜单id',
courese_id  int(11) not null  COMMENT '课程id',
createdTime  datetime  COMMENT '课程创建时间',
modifiedTime datetime  COMMENT '修改课程时间',
createdUser    varchar(50)  COMMENT '创建课程者',
modifiedUser   varchar(50)   COMMENT '修改课程者'
)engine=innodb charset=utf8;

-------收藏夹表----周文耿----
drop table if exists tk_bookmarks;
create table tk_bookmarks(
id int primary key auto_increment  COMMENT '收藏id',
user_id int(11)   COMMENT '用户id',
course_id int(11) COMMENT '课程id',
createdTime Date   COMMENT '创建时间'
)engine=innoDB,charset=utf8;
---------------
---