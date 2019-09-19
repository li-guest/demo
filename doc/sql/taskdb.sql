DROP table if EXISTS `task`;

CREATE table `task` (
    `id` int(11) NOT NULL auto_increment,
    `taskName` varchar(256) NOT null COMMENT '任务名称',
    `publicUser` varchar(128) NOT null COMMENT '发布者',
    `status` int(4) Not null COMMENT '任务状态',
    `startDate` datetime default null COMMENT '开始时间',
    `endDate` datetime default null COMMENT '结束时间',
    `reponsible` varchar(128) NOT null COMMNET '负责人',
    primary key (`id`)
)ENGINE =InnoDB DEFAULT CHARSET=utf8;

insert  into `task`(`id`,`taskName`,`publicUser`,`status`,`startDate`,`endDate`,`reponsible`)
values (41,'1111','admin',2,'2018-02-27','2018-02-29','user1'),
(42,'2222','admin',2,'2018-03-02','2018-03-04','user2'),
(43,'3333','admin',3,'2018-03-04','2018-03-05','user3'),
(45,'4444','admin',2,'2018-03-04','2018-03-07','user4'),
(46,'5555','admin',4,'2018-03-07','2018-03-08','user4'),
(48,'6666','admin',2,'2018-03-08','2018-03-09','user5');
