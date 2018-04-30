#用户表(管理员)
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '管理员姓名',
  `mobile` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `head_picture` varchar(128) NOT NULL DEFAULT '' COMMENT '用户头像',
  `password` VARCHAR (60) NOT NULL COMMENT '用户密码(md5加密)',
  `sex` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '性别: 0 男;1 女',
  `validity` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效, 0-无效,1-有效',
  `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '信息更新时间',
  `address` varchar(128) not null DEFAULT '' COMMENT '地址',
  `country` tinyint(2) not null DEFAULT '1' COMMENT '国家',
  `province` tinyint(2) not null DEFAULT '1' COMMENT '省份',
  `city` tinyint(2) not null DEFAULT '1' COMMENT '城市'
) ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COMMENT='内部管理员表';

#客户表(会员)
CREATE TABLE `customer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `customer_name` varchar(50) NOT NULL DEFAULT '' COMMENT '客户姓名',
  `mobile` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(80) NOT NULL DEFAULT '' COMMENT '邮箱',
  `head_picture` varchar(128) NOT NULL DEFAULT '' COMMENT '用户头像',
  `password` VARCHAR (60) NOT NULL COMMENT '用户密码(md5加密)',
  `sex` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '性别: 0 男;1 女',
  `validity` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效, 0-无效,1-有效',
  `register_ip` varchar(50) NOT NULL DEFAULT '127.0.0.1' COMMENT '注册IP',
  `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '信息更新时间',
  `points` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户积分',
  `last_logintime` timestamp NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '最后登录时间',
  `update_id` varchar(30) NOT NULL DEFAULT 'sys' COMMENT '更新客户的userId',
  `customer_level` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '客户等级，0普通客户， 1种子客户， 2VIP客户',
  `address` varchar(128) not null DEFAULT '' COMMENT '地址',
  `country` tinyint(2) not null DEFAULT '1' COMMENT '国家',
  `province` tinyint(2) not null DEFAULT '1' COMMENT '省份',
  `city` tinyint(2) not null DEFAULT '1' COMMENT '城市',
  PRIMARY KEY (`id`),
  KEY `idx_customername` (`customer_name`),
  KEY `idx_mobile` (`mobile`),
  KEY `idx_email` (`email`),
) ENGINE=InnoDB AUTO_INCREMENT = 10000 DEFAULT CHARSET=utf8 COMMENT='用户表';

#商品表
CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `validity` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '有效性 1.有效 0. 无效',
  `shop_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '卖家编号',
  `inventory` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '库存',
  `price` double(10, 2) NOT NULL DEFAULT '0.00' COMMENT'单价'
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='商品表';

#商家表
CREATE TABLE `shop` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商家ID',
  `name` varchar(60) NOT NULL DEFAULT '怪蜀黍母婴' COMMENT '商家名称',
  `country` tinyint(2) not null DEFAULT '1' COMMENT '国家',
  `province` tinyint(2) not null DEFAULT '1' COMMENT '省份',
  `city` tinyint(2) not null DEFAULT '1' COMMENT '城市',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `validity` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '有效性 1.有效 0. 无效'
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='商家表';

#订单表
CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `customer_id` int(10) unsigned NOT NULL DEFAULT '10000' COMMENT '客户ID',
  `amount` double(12, 2) NOT NULL DEFAULT '0.00' COMMENT '订单总额',
  `number` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '订单商品总数',
  `freight` double(8, 2) NOT NULL DEFAULT '0.00' COMMENT '运费',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `validity` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '有效性 1.有效 0. 无效'
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='订单表';

#订单项表
CREATE TABLE `order_line` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单项id',
  `item_id` int(10) unsigned NOT NULL DEFAULT '10000' COMMENT '商品id',
  `amount` double(12, 2) NOT NULL DEFAULT '0.00' COMMENT '订单项总额',
  `number` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '订单项商品总数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `validity` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '有效性 1.有效 0. 无效'
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='订单表';


#地区表
CREATE TABLE `region` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '地区id',
  `country` int()
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `validity` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '有效性 1.有效 0. 无效',
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='地区表';