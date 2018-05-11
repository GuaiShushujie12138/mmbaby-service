#用户表(管理员)
DROP TABLE if exists `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '管理员姓名',
  `mobile` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `head_picture` varchar(128) NOT NULL DEFAULT '' COMMENT '用户头像',
  `password` VARCHAR (60) NOT NULL COMMENT '用户密码(md5加密)',
  `sex` int(2) unsigned NOT NULL DEFAULT '10' COMMENT '性别: 10-男;20-女',
  `role` int(2) unsigned NOT NULL DEFAULT '0' COMMENT '角色: 0-普通的管理员(没有修改权限), 10-超级管理员, 20-商品管理员, 30-资讯管理员',
  `validity` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效, 0-无效,1-有效',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '信息更新时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `address` varchar(128) not null DEFAULT '' COMMENT '地址',
  `country` int(2) unsigned not null DEFAULT '1' COMMENT '国家',
  `province` int(2) unsigned not null DEFAULT '1' COMMENT '省份',
  `city` int(2) unsigned not null DEFAULT '1' COMMENT '城市',
  primary key (`id`),
  KEY `idx_username` (`user_name`),
  KEY `idx_user_mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COMMENT='内部管理员表';

#客户表(会员)
DROP TABLE if exists `customer`;
CREATE TABLE `customer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `customer_name` varchar(50) NOT NULL DEFAULT '' COMMENT '客户姓名',
  `mobile` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `email` varchar(80) NOT NULL DEFAULT '' COMMENT '邮箱',
  `head_picture` varchar(128) NOT NULL DEFAULT '' COMMENT '用户头像',
  `password` VARCHAR (60) NOT NULL COMMENT '用户密码(md5加密)',
  `sex` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '性别: 0 女;1 男',
  `validity` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否有效, 0-无效,1-有效',
  `register_ip` varchar(50) NOT NULL DEFAULT '127.0.0.1' COMMENT '注册IP',
  `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '信息更新时间',
  `points` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户积分',
  `last_logintime` timestamp NOT NULL DEFAULT '1971-01-01 00:00:00' COMMENT '最后登录时间',
  `update_id` varchar(30) NOT NULL DEFAULT 'sys' COMMENT '更新客户的userId',
  `customer_level` int(2) unsigned NOT NULL DEFAULT '0' COMMENT '客户等级，0普通客户， 1种子客户， 2VIP客户',
  `address` varchar(128) not null DEFAULT '' COMMENT '地址',
  `country` int(2) unsigned not null DEFAULT '1' COMMENT '国家',
  `province` int(2) unsigned not null DEFAULT '1' COMMENT '省份',
  `city` int(2) unsigned not null DEFAULT '1' COMMENT '城市',
  PRIMARY KEY (`id`),
  KEY `idx_customername` (`customer_name`),
  KEY `idx_mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT = 10000 DEFAULT CHARSET=utf8 COMMENT='用户表';

#商品表
DROP TABLE if exists `product`;
CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `shop_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '卖家编号',
  `inventory` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '库存',
  `price` double(10, 2) NOT NULL DEFAULT '0.00' COMMENT'单价',
  `discount_price` double(10, 2) NOT NULL DEFAULT '0.00' COMMENT'打折价',
  `discount` int(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否打折: 0-否，1-是',
  `hot` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否热卖 1-是 0-不是',
  `recommend` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否推荐 1-是 0-不是',
  `sales` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '销量',
  `pic` varchar(120) NOT NULL DEFAULT '' COMMENT '商品图片',
  `price_region` int(3) unsigned NOT NULL DEFAULT '10' COMMENT '商品价格区间, 0-60 : 10, 61-100 : 20, 101-200 : 30, 201-400 : 40, 401-1000 : 50, 1000- : 60',
  `type` int(3) unsigned NOT NULL DEFAULT '1' COMMENT '商品大类型 1-婴儿, 2-妈妈',
  `sex` int(3) unsigned NOT NULL DEFAULT '1' COMMENT '商品适用的性别, 1-女, 2-男',
  `age_region` int(3) unsigned NOT NULL DEFAULT '10' COMMENT '商品适合的婴儿年龄区间(只有商品适用于婴儿时才有), 10 : 0-6个月宝宝, 20 : 6-12个月宝宝, 30 : 1-3岁， 40 : 4-6岁, 50 : 7-9岁, 60 : 10岁及以上',
  `category` int(5) unsigned NOT NULL DEFAULT '10' COMMENT '商品的小类型 10-纸尿裤, 20-婴儿车, 30-婴儿奶粉, 40-安全座椅, 50-玩具, 60-衣服, 70-童鞋, 80-婴儿食品, 90-喂养, 100-宝宝健康; 300-保健品， 310-个人护理, 320-卫生用品, 330-孕期/产后营养, 340-辣妈衣装',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `validity` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '有效性 1.有效 0. 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='商品表';

#商家表
DROP TABLE if exists `shop`;
CREATE TABLE `shop` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '商家ID',
  `name` varchar(60) NOT NULL DEFAULT '怪蜀黍母婴' COMMENT '商家名称',
  `country` int(2) unsigned not null DEFAULT '1' COMMENT '国家',
  `province` int(2) unsigned not null DEFAULT '1' COMMENT '省份',
  `city` int(2) unsigned not null DEFAULT '1' COMMENT '城市',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `validity` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '有效性 1.有效 0. 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='商家表';

#订单表
DROP TABLE if exists `order`;
CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `customer_id` int(10) unsigned NOT NULL DEFAULT '10000' COMMENT '客户ID',
  `amount` double(12, 2) NOT NULL DEFAULT '0.00' COMMENT '订单总额',
  `number` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '订单商品总数',
  `freight` double(8, 2) NOT NULL DEFAULT '0.00' COMMENT '运费',
  `leave_message` varchar(60) NOT NULL DEFAULT '' COMMENT '买家留言',
  `logistics` int(10) unsigned NOT NULL DEFAULT '10' COMMENT '物流, 10-顺丰速递，20-EMS速递，30-德邦快运，40-任意物流',
  `address_id` int(10) unsigned NOT NULL DEFAULT '1000' COMMENT '收货地址id',
  `status` int(3) unsigned NOT NULL DEFAULT '10' COMMENT '订单状态: 10-待支付,20-待收货,30-待评价,40-完成,100-取消',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `validity` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '有效性 1.有效 0. 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='订单表';

#收货地址表
DROP TABLE if exists `address`;
CREATE TABLE `address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `customer_id` int(10) unsigned NOT NULL DEFAULT '10000' COMMENT '客户ID',
  `receive_name` varchar(40) NOT NULL DEFAULT '' COMMENT '收货人姓名',
  `mobile` varchar(11) NOT NULL DEFAULT '' COMMENT '联系手机',
  `zip` varchar(6) NOT NULL DEFAULT '' COMMENT '邮编',
  `default_address` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT ' 是否默认地址.1-默认 0-不默认',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `validity` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '有效性 1.有效 0. 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='收货地址表';

#订单项表
DROP TABLE if exists `order_line`;
CREATE TABLE `order_line` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单项id',
  `item_id` int(10) unsigned NOT NULL DEFAULT '10000' COMMENT '商品id',
  `order_id` int(10) unsigned NOT NULL DEFAULT '10000' COMMENT '订单id',
  `amount` double(12, 2) NOT NULL DEFAULT '0.00' COMMENT '订单项总额',
  `number` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '订单项商品总数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `validity` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '有效性 1.有效 0. 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='订单表';

#地区表
DROP TABLE if exists `region`;
CREATE TABLE `region` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '地区id',
  `country` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '国家id',
  `province` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '省份id',
  `city` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '城市id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `validity` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '有效性 1.有效 0. 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='地区表';

#评论表
DROP TABLE if exists `comment`;
CREATE TABLE `comment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `customer_id` int(10) unsigned NOT NULL DEFAULT '10000' COMMENT '相关的客户id',
  `item_id` int(10) unsigned NOT NULL DEFAULT '10000' COMMENT '相关的商品id',
  `content` varchar(225) NOT NULL DEFAULT '' COMMENT '评论的内容',
  `star` int(3) unsigned NOT NULL DEFAULT '5' COMMENT '满意星级',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `validity` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '有效性 1.有效 0. 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='评论表';

#资讯表
DROP TABLE if exists `information`;
CREATE TABLE `information` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '资讯id',
  `content` varchar(250) NOT NULL DEFAULT '' COMMENT '咨询内容',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '创建人',
  `update_id` varchar(80) NOT NULL DEFAULT 'sys' COMMENT '修改人',
  `validity` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '有效性 1.有效 0. 无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='资讯表';