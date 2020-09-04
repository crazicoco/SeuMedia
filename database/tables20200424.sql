/* 01 sysy_log 日志表*/
create table sys_log(
	id bigint(40) not null auto_increment,		/*主键*/
	ip varchar(20) not null,					/*操作地址ip*/
	create_by timestamp not null default now(),	/*操作时间*/   
	remark varchar(255) not null,				/*操作内容*/
	operate_url varchar(50) not null,			/*操作的访问地址*/
	operate_by varchar(20) not null,			/*操作的浏览器*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;


/* 02 tbl_user 用户表*/
CREATE TABLE `tbl_user` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,		/*主键(用户id)*/
  `username` varchar(20) DEFAULT NULL,				/*用户名*/
  `password` varchar(255) DEFAULT NULL,			/*用户登录密码(哈希)*/
  `email` varchar(50) DEFAULT NULL,					/*登录邮箱*/
  `phone` varchar(20) DEFAULT NULL,					/*登录手机号*/
  `create_by` datetime DEFAULT CURRENT_TIMESTAMP,			/*操作时间*/
  `modified_by` datetime DEFAULT NULL,						/*修改时间*/
  `idDeleted` tinyint(1) DEFAULT '0',						/*删除标志位*/
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8


/* 03 tbl_user_info 用户信息表*/
CREATE TABLE `tbl_user_info` (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,		/*主键*/
  `user_id` bigint(40) NOT NULL,				/*用户id*/
  `real_name` varchar(20) DEFAULT NULL,						/*真实姓名*/
  `gender` tinyint(1) DEFAULT NULL,							/*性别*/
  `birthday` date DEFAULT NULL,								/*出生日期*/
  `id_number` varchar(20) DEFAULT NULL,						/*身份证号*/
  `head_portrait` varchar(50) DEFAULT NULL,   				/*头像url*/
  `description` varchar(255) DEFAULT NULL,					/*账号描述*/
  `create_by` datetime DEFAULT CURRENT_TIMESTAMP,			/*操作时间*/
  `modified_by` datetime DEFAULT NULL,						/*修改时间*/
  `idDeleted` tinyint(1) DEFAULT '0',						/*删除标志位*/
  PRIMARY KEY (`id`),
  KEY `id_userId` (`user_id`),
  CONSTRAINT `id_userId` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8

/* 04 tbl_role_authentication 用户角色认证表*/
create table if not exists tbl_role_authentication(
	id bigint(40) not null auto_increment,		/*主键*/
	user_id bigint(40) not null,				/*用户id*/
	role tinyint(1) not null,					/*认证角色*/
	certificate_id bigint(40),					/*认证材料id*/
	auth_status tinyint(1),						/*认证状态*/
	create_by timestamp default now(),			/*创建时间*/
	idDeleted tinyint(1) default 0,				/*删除标志位*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 05 tbl_certificate 认证材料表*/
create table if not exists tbl_certificate(
	id bigint(40) not null auto_increment,		/*主键*/
	user_id bigint(40) not null,				/*用户id*/
	field tinyint(2) not null,					/*媒体领域*/
	name varchar(20) not null,					/*机构名称*/
	description varchar(255),					/*机构描述*/
	head_portrait varchar(50),					/*机构头像*/
	operate_name varchar(20),					/*运营者姓名*/
	id_number varchar(20) not null,				/*身份证号*/
	enterprise_name varchar(20) not null,		/*企业/机构名称*/
	enterprise_number varchar(50) not null,		/*营业执照编号或代码*/
	license_picture varchar(50) not null,		/*营业执照照片url*/
	internet_permit_picture varchar(50) not null,/*互联网服务许可证*/
	create_by timestamp default now(),			/*创建时间*/
	modified_by timestamp,						/*修改时间*/
	idDeleted tinyint(1) default 0,				/*删除标志位*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 06 tbl_article_info文章信息表*/
create table if not exists tbl_article_info(
	id bigint(40) not null,		/*文章id*原先递增去掉*/  
	title varchar(50),							/*文章标题*/
	version bigint(40),                         /*版本信息 我后加的记得更新*/
	user_id	bigint(40) not null,				/*文章发布用户id*/
	level tinyint(1) not null,					/*稿件等级*/
	status tinyint(2),							/*审核状态*/
	create_by timestamp default now(),			/*创建时间*/
	modified_by	timestamp,						/*修改时间*/
	commited_by	timestamp,						/*提交时间*/
	published_by timestamp,						/*出版时间*/
	idDeleted tinyint(1) default 0,				/*删除标志位*/
	primary key(id,version)
)engine=innodb default charset=utf8;  /*自动递增去除*/

/* 07 tbl_article_detail文章详情表*/
create table if not exists tbl_article_detail(
	id bigint(40) not null auto_increment,		/*主键*/
	article_id bigint(40) not null,				/*文章id*/
	article_version bigint(40),                 /*版本信息 我后加的记得更新*/
	title varchar(50),							/*标题*/
	author_id bigint(40) not null,				/*作者id*/
	abstracts varchar(255),						/*摘要*/
	keywords varchar(50),						/*关键字*/
	content	text,								/*正文*/
	source varchar(10),							/*内容来源*/
	category varchar(10),						/*一级类别*/
	subcategory	varchar(10),					/*二级类别*/
	topic varchar(10),							/*话题*/
	copyright varchar(255),						/*版权信息*/
	originality	varchar(255),					/*原创声明*/
	idDeleted tinyint(1) default 0,				/*删除标志位*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 08 tbl_comment 评论表*/
create table if not exists tbl_comment(
	id bigint(40) not null auto_increment,		/*主键*/
	content	varchar(255),						/*评论内容*/
	author_id bigint(40) not null,				/*作者id*/
	ip varchar(50),								/*评论ip*/
	create_by timestamp default now(),			/*创建时间*/
	modified_by	timestamp,						/*修改时间*/
	is_effective tinyint(1) default 1,			/*是否有效*/
	idDeleted tinyint(1) default 0,				/*删除标志位*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 09 tbl_article_comment文章评论表*/
create table if not exists tbl_article_comment(
	id bigint(40) not null auto_increment,		/*主键*/
	article_id bigint(40) not null,				/*文章id*/		
	comment_id	bigint(40) not null,			/*评论id*/			
	create_by timestamp default now(),			/*创建时间*/
	idDeleted tinyint(1) default 0,				/*删除标志位*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 10 tbl_article_picture 文章题图表 */
create table if not exists tbl_article_picture(
	id bigint(40) not null auto_increment,		/*主键*/
	title varchar(50),							/*图片标题*/
	author_id bigint(40),						/*作者id*/
	article_version bigint(40) not null,                 /*版本信息 我后加的记得更新*/
	article_id bigint(40) not null,				/*文章id*/
	type tinyint(1),							/*图片类型*/
	height int(5),								/*高度*/
	weight int(5),								/*宽度*/
	size int(5),								/*大小*/
	save_url varchar(50),						/*存储地址*/
	idDeleted tinyint(1) default 0,				/*删除标志位*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 11 tbl_article_vedio 文章视频表*/
create table if not exists tbl_article_vedio(
	id bigint(40) not null auto_increment,		/*主键*/
	title varchar(50),							/*图片标题*/
	author_id bigint(40),						/*作者id*/
	article_id bigint(40) not null,				/*文章id*/
	article_version bigint(40),                 /*版本信息 我后加的记得更新*/
	duration int(10),							/*视频时长*/
	mime_type tinyint(2),						/*封装格式*/
	height int(5),								/*高度*/
	weight int(5),								/*宽度*/
	size int(10),								/*大小*/
	save_url varchar(50),						/*存储地址*/
	frame_url varchar(50),						/*封面地址*/
	vbit int(10),								/*视频码率*/
	frame_rate decimal,							/*视频帧率*/
	idDeleted tinyint(1) default 0,				/*删除标志位*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 12 tbl_userinfo_review 用户信息审核表*/
create table if not exists tbl_userinfo_review(
	id bigint(40) not null auto_increment,		/*主键*/
	authentication_id bigint(40) not null,		/*认证申请id*/
	reviewer_id	bigint(40) not null,			/*审核员id*/
	is_feedback	tinyint(1),						/*是否反馈*/
	create_by timestamp default now(),			/*创建时间*/
	idDeleted tinyint(1) default 0,				/*删除标志位*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 13 tbl_article_review 文章审核表*/
create table if not exists tbl_article_review(
	id bigint(40) not null auto_increment,		/*主键*/
	article_id bigint(40) not null,				/*文章id*/
	reviewer_id	bigint(40) not null,			/*审核员id*/
	is_feedback	tinyint(1),						/*是否反馈*/
	create_by timestamp default now(),			/*创建时间*/
	idDeleted tinyint(1) default 0,				/*删除标志位*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 14 tbl_user_message 用户消息通知表*/
create table if not exists tbl_user_message(
	id bigint(40) not null auto_increment,		/*主键*/
	user_id	bigint(40) not null,				/*用户id*/
	message_type tinyint(1),					/*消息类型*/
	message_content	text,						/*消息内容*/
	create_by timestamp default now(),			/*创建时间*/
	idDeleted tinyint(1) default 0,				/*删除标志位*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 15 tbl_article_collect文章收藏表*/
create table if not exists tbl_article_collect(
	id bigint(40) not null auto_increment,		/*主键*/
	user_id	bigint(40) not null,				/*用户id*/
	article_id bigint(40) not null,				/*文章id*/
	article_title varchar(50),					/*文章标题*/
	create_by timestamp default now(),			/*创建时间*/
	idDeleted tinyint(1) default 0,				/*删除标志位*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 16 tbl_user_follow用户关注表*/
create table if not exists tbl_user_follow(
	id bigint(40) not null auto_increment,		/*主键*/
	user_id	bigint(40) not null,				/*用户id*/
	follower_id	bigint(40) not null,			/*关注用户id*/
	create_by timestamp default now(),			/*创建时间*/
	idDeleted tinyint(1) default 0,				/*删除标志位*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

