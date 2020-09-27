/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50132
Source Host           : localhost:3306
Source Database       : wangzu

Target Server Type    : MYSQL
Target Server Version : 50132
File Encoding         : 65001

Date: 2020-06-28 18:57:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `aid` varchar(50) NOT NULL COMMENT '管理员id',
  `aname` varchar(20) NOT NULL COMMENT '管理员账号',
  `apwd` varchar(20) NOT NULL COMMENT '管理员密码',
  `rid` int(1) NOT NULL DEFAULT '3' COMMENT '角色',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'spring', '123', '1');
INSERT INTO `t_admin` VALUES ('2', 'cherry', '123', '1');
INSERT INTO `t_admin` VALUES ('3', 'qwe', '123', '2');
INSERT INTO `t_admin` VALUES ('cd164705dfe149b191e88f62157569ab', 'xxx', '123', '1');

-- ----------------------------
-- Table structure for `t_collect`
-- ----------------------------
DROP TABLE IF EXISTS `t_collect`;
CREATE TABLE `t_collect` (
  `uid` varchar(32) NOT NULL,
  `hid` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_collect
-- ----------------------------
INSERT INTO `t_collect` VALUES ('17ef131643cc43bfa6bc726df2d245d3', '53b8b9336c8494693010a67bb45d9562');
INSERT INTO `t_collect` VALUES ('17ef131643cc43bfa6bc726df2d245d3', '7247f122f82264064c71b1df18bf9242');
INSERT INTO `t_collect` VALUES ('17ef131643cc43bfa6bc726df2d245d3', 'ee50984acdb60917596fed106828090c');

-- ----------------------------
-- Table structure for `t_history`
-- ----------------------------
DROP TABLE IF EXISTS `t_history`;
CREATE TABLE `t_history` (
  `uid` varchar(32) NOT NULL,
  `hid` varchar(32) NOT NULL,
  `htype` int(1) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_history
-- ----------------------------

-- ----------------------------
-- Table structure for `t_house`
-- ----------------------------
DROP TABLE IF EXISTS `t_house`;
CREATE TABLE `t_house` (
  `hid` varchar(32) NOT NULL COMMENT '房屋id',
  `hname` varchar(50) DEFAULT NULL COMMENT '房子标题',
  `hprice` int(6) DEFAULT NULL COMMENT '房屋价格',
  `htype` int(1) NOT NULL DEFAULT '1' COMMENT '房屋类型(0:短租1:长租2:售卖)',
  `harea` int(8) DEFAULT NULL COMMENT '房屋面积',
  `hmodel` varchar(16) DEFAULT NULL COMMENT '房屋类型',
  `hfloor` varchar(16) DEFAULT NULL COMMENT '楼层',
  `hposition` varchar(64) DEFAULT NULL COMMENT '所处区域',
  `hsubway` varchar(255) DEFAULT NULL COMMENT '临近地铁',
  `htele` varchar(11) DEFAULT NULL COMMENT '房屋联系方式',
  `himg` varchar(256) DEFAULT NULL COMMENT '房屋图片',
  `hdesc` varchar(120) DEFAULT NULL COMMENT '房屋详细介绍120字以内',
  `hstate` int(1) DEFAULT NULL COMMENT '是否出租',
  `hbelong` varchar(32) DEFAULT NULL,
  `hclick` int(255) DEFAULT NULL,
  `hdate` varchar(20) NOT NULL COMMENT '生成日期',
  `haddress` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_house
-- ----------------------------
INSERT INTO `t_house` VALUES ('0f8eaff0341f47cea3ecb186430f4dd7', '测试1', '1430000', '2', '120', '3室', null, '南昌', null, '15932901186', '/images/house/main/083e674565c74c928423c6486b2265e0.jpg', '精装修，入住不满4年。急出售', '0', null, '3', '2020-06', '南昌县金沙二路幸福时光3期18栋301');
INSERT INTO `t_house` VALUES ('1c9848623892926f70c97fb3256af76a', '测试5', '760000', '2', '150', '3室', null, '鹰潭', null, '15932901186', '/images/house/main/d04613afad2d49d99654bd63eb8d5938.jpg', '低价卖', '0', null, '3', '2020-06', '信江新区滨江路8号');
INSERT INTO `t_house` VALUES ('53b8b9336c8494693010a67bb45d9562', '测试4', '150', '3', '60', '1室', null, '上饶', null, '15932901186', '/images/house/main/e8f52217bff24893ae426a1a32070731.jpg', '快来！！！', '0', null, '5', '2020-06', '江西省上饶市上饶县经济开发区旭日片区武夷山大道15号');
INSERT INTO `t_house` VALUES ('7247f122f82264064c71b1df18bf9242', '测试6', '1600', '1', '60', '2室', null, '鹰潭', null, '15932901186', '/images/house/main/a1079f5ebe8e4c30804aaffedf577d30.jpg', '快来！！', '0', '64856344eae84d8eadb84507415e755b', '4', '2020-06', '鹰潭市月湖区天洁东大道11号');
INSERT INTO `t_house` VALUES ('92527ec22db740d49f247048fb04a5ac', '测试2', '1400', '1', '40', '1室', null, '南昌', null, '15932901186', '/images/house/main/1fa2340f3e1e48c2be569a41cab1bc78.jpg', '离万达广场10分钟路程，仅限男生入住', '0', '64856344eae84d8eadb84507415e755b', '64', '2020-06', '红谷滩区丽景路卫东花园3期4栋601');
INSERT INTO `t_house` VALUES ('b4d213a3a6d2c50a606ac8ae487eb512', '测试3', '120', '3', '40', '1室', null, '南昌', null, '15932901186', '/images/house/main/f9743198f8a44b25b71788d76a34cb4a.jpg', '民宿，离学校近。', '0', null, '16', '2020-06', '南昌县金沙二路幸福时光3期17栋602');
INSERT INTO `t_house` VALUES ('ee50984acdb60917596fed106828090c', '测试7', '1200', '1', '80', '1室', null, '九江', null, '15932901186', '/images/house/main/cbe01ee67a284be680d425e22234aaeb.jpg', '合租', '0', null, '7', '2020-06', '开发区九瑞大道136号');

-- ----------------------------
-- Table structure for `t_img`
-- ----------------------------
DROP TABLE IF EXISTS `t_img`;
CREATE TABLE `t_img` (
  `iid` varchar(32) NOT NULL,
  `iimg` varchar(256) DEFAULT NULL,
  `hid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_img
-- ----------------------------
INSERT INTO `t_img` VALUES ('01d70fdd177242ac90c296b6811988c7', '/images/house/about/01d70fdd177242ac90c296b6811988c7.jpg', '92527ec22db740d49f247048fb04a5ac');
INSERT INTO `t_img` VALUES ('07856c35c24948ce95bae401002a13cb', '/images/house/about/07856c35c24948ce95bae401002a13cb.jpg', '53b8b9336c8494693010a67bb45d9562');
INSERT INTO `t_img` VALUES ('096f59faec3449b9bbd20c616f9813fc', '/images/house/about/096f59faec3449b9bbd20c616f9813fc.jpg', '1c9848623892926f70c97fb3256af76a');
INSERT INTO `t_img` VALUES ('0ed531585c8645df94a7e1296f7c9918', '/images/house/about/0ed531585c8645df94a7e1296f7c9918.jpg', 'ee50984acdb60917596fed106828090c');
INSERT INTO `t_img` VALUES ('136274b0b01d49e09fdb3d6dfb4f3175', '/images/house/about/136274b0b01d49e09fdb3d6dfb4f3175.jpg', 'b4d213a3a6d2c50a606ac8ae487eb512');
INSERT INTO `t_img` VALUES ('2a64f021e6ee4547af7584aac8e627b7', '/images/house/about/2a64f021e6ee4547af7584aac8e627b7.jpg', '0f8eaff0341f47cea3ecb186430f4dd7');
INSERT INTO `t_img` VALUES ('39c5ad4afae340609306f0288424d0a8', '/images/house/about/39c5ad4afae340609306f0288424d0a8.jpg', '1c9848623892926f70c97fb3256af76a');
INSERT INTO `t_img` VALUES ('5e1486f8a52541598c1b23417b95d3bf', '/images/house/about/5e1486f8a52541598c1b23417b95d3bf.jpg', 'b4d213a3a6d2c50a606ac8ae487eb512');
INSERT INTO `t_img` VALUES ('6017127c2f3c41078be9ac94dabab917', '/images/house/about/6017127c2f3c41078be9ac94dabab917.jpg', '0f8eaff0341f47cea3ecb186430f4dd7');
INSERT INTO `t_img` VALUES ('64c56f0ffb124ba294218d2692bba303', '/images/house/about/64c56f0ffb124ba294218d2692bba303.jpg', 'ee50984acdb60917596fed106828090c');
INSERT INTO `t_img` VALUES ('74a6d9117b014cbd9041653ea883ffb5', '/images/house/about/74a6d9117b014cbd9041653ea883ffb5.jpg', '1c9848623892926f70c97fb3256af76a');
INSERT INTO `t_img` VALUES ('7695d14ad0554e3ca856b64a60d6e772', '/images/house/about/7695d14ad0554e3ca856b64a60d6e772.jpg', '53b8b9336c8494693010a67bb45d9562');
INSERT INTO `t_img` VALUES ('91009ab8db444ff6bb3192a09b90d4f0', '/images/house/about/91009ab8db444ff6bb3192a09b90d4f0.jpg', '7247f122f82264064c71b1df18bf9242');
INSERT INTO `t_img` VALUES ('a3385bed36404388bc71edec26e641f9', '/images/house/about/a3385bed36404388bc71edec26e641f9.jpg', '0f8eaff0341f47cea3ecb186430f4dd7');
INSERT INTO `t_img` VALUES ('b2c4d53c65ff45e290c1a00b9a50f752', '/images/house/about/b2c4d53c65ff45e290c1a00b9a50f752.jpg', '7247f122f82264064c71b1df18bf9242');
INSERT INTO `t_img` VALUES ('b4a8db49c3784679ae354821f5605020', '/images/house/about/b4a8db49c3784679ae354821f5605020.jpg', '1c9848623892926f70c97fb3256af76a');
INSERT INTO `t_img` VALUES ('b8bf4d6a73c745f5901e190fb4ca3e4d', '/images/house/about/b8bf4d6a73c745f5901e190fb4ca3e4d.jpg', 'ee50984acdb60917596fed106828090c');
INSERT INTO `t_img` VALUES ('cac04ef54de147db82384bc0d6faab66', '/images/house/about/cac04ef54de147db82384bc0d6faab66.jpg', '7247f122f82264064c71b1df18bf9242');
INSERT INTO `t_img` VALUES ('cc5fd96f7b744fa6990750f1b5a8e620', '/images/house/about/cc5fd96f7b744fa6990750f1b5a8e620.jpg', '92527ec22db740d49f247048fb04a5ac');
INSERT INTO `t_img` VALUES ('cee639acde534f2e9e92244d352cced7', '/images/house/about/cee639acde534f2e9e92244d352cced7.jpg', '92527ec22db740d49f247048fb04a5ac');
INSERT INTO `t_img` VALUES ('d2702b95c4e4491288f1ca7faae9bad8', '/images/house/about/d2702b95c4e4491288f1ca7faae9bad8.jpg', 'b4d213a3a6d2c50a606ac8ae487eb512');
INSERT INTO `t_img` VALUES ('d82dc71775e441dd92735f119109f3bb', '/images/house/about/d82dc71775e441dd92735f119109f3bb.jpg', '53b8b9336c8494693010a67bb45d9562');
INSERT INTO `t_img` VALUES ('e32a73d65f4a4f539a13ae22401d6076', '/images/house/about/e32a73d65f4a4f539a13ae22401d6076.jpg', '0f8eaff0341f47cea3ecb186430f4dd7');

-- ----------------------------
-- Table structure for `t_landlord`
-- ----------------------------
DROP TABLE IF EXISTS `t_landlord`;
CREATE TABLE `t_landlord` (
  `lid` varchar(32) NOT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `ltel` varchar(11) DEFAULT NULL,
  `hid` varchar(32) DEFAULT NULL,
  `idCard` varchar(20) DEFAULT NULL,
  `lpwd` varchar(20) DEFAULT NULL,
  `ldate` varchar(20) NOT NULL COMMENT '生成时间',
  `rid` int(1) NOT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_landlord
-- ----------------------------
INSERT INTO `t_landlord` VALUES ('3b89f9348e7240f2abe6234cf0ca07b1', 'vvv', '15932901186', null, '362330200001101159', '123', '', '5');
INSERT INTO `t_landlord` VALUES ('64856344eae84d8eadb84507415e755b', 'xzc', '15932901186', '', '362330200001101159', '123456', '2020-04', '5');
INSERT INTO `t_landlord` VALUES ('6f2f2f91e11f4e6a9ff321818c6b31fe', 'vvvv', '15932901186', null, '362330200001101159', '123', '', '5');
INSERT INTO `t_landlord` VALUES ('d3c5297ef47a4926827f1f743b70fbd2', 'cccc', '15932901186', null, '362330200001101159', '123', '', '5');

-- ----------------------------
-- Table structure for `t_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `lid` varchar(32) DEFAULT NULL,
  `ltype` varchar(10) DEFAULT NULL,
  `ltitle` varchar(32) DEFAULT NULL,
  `lremoteAddr` varchar(64) DEFAULT NULL,
  `lrequestUri` varchar(64) DEFAULT NULL,
  `lmethod` varchar(10) DEFAULT NULL,
  `lparams` varchar(500) DEFAULT NULL,
  `lexception` varchar(256) DEFAULT NULL,
  `loperateDate` varchar(64) DEFAULT NULL,
  `ltimeout` varchar(64) DEFAULT NULL,
  `aid` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_log
-- ----------------------------
INSERT INTO `t_log` VALUES ('dce5a8236944409e8401e01687475775', 'info', '更新指定的房源信息 ', '0:0:0:0:0:0:0:1', '/admin/update', 'POST', '', null, '2019-12-23 19:59:21', '0:0:0.22', '1');
INSERT INTO `t_log` VALUES ('fffa3c3b91c6483cbccdd5c2885207ce', 'info', '更新指定的房源信息 ', '0:0:0:0:0:0:0:1', '/admin/update', 'POST', '', null, '2019-12-23 19:59:32', '0:0:0.14', '1');
INSERT INTO `t_log` VALUES ('91b5be7506804820b52e01eb16b17e16', 'info', '更新指定的房源信息 ', '0:0:0:0:0:0:0:1', '/admin/update', 'POST', '', null, '2019-12-23 20:00:07', '0:0:0.10', '1');
INSERT INTO `t_log` VALUES ('70fa259f91694a0d872ed7497692b1a4', 'info', '更新指定的房源信息 ', '0:0:0:0:0:0:0:1', '/admin/update', 'POST', '', null, '2019-12-23 20:00:10', '0:0:0.12', '1');
INSERT INTO `t_log` VALUES ('038129726f1945f49646734b84a8772f', 'info', '更新指定的房源信息 ', '0:0:0:0:0:0:0:1', '/admin/update', 'POST', '', null, '2019-12-23 20:00:26', '0:0:0.14', '1');
INSERT INTO `t_log` VALUES ('a919bb130157499a90358cf0bdd1dd5f', 'info', '更新指定的房源信息 ', '0:0:0:0:0:0:0:1', '/admin/update', 'POST', '', null, '2019-12-23 20:08:27', '0:0:0.223', '1');
INSERT INTO `t_log` VALUES ('90a8b53eebf54098a61734f80e82df37', 'info', '更新指定的房源信息 ', '0:0:0:0:0:0:0:1', '/admin/update', 'POST', '', null, '2019-12-23 20:12:05', '0:0:0.99', '1');

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `mid` int(2) NOT NULL COMMENT '功能id',
  `mname` varchar(12) NOT NULL COMMENT '菜单',
  `url` varchar(50) NOT NULL COMMENT '地址',
  `rmid` int(2) NOT NULL COMMENT '角色权限ID',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '管理员表', '/adminList', '1');
INSERT INTO `t_menu` VALUES ('2', '房东表', '/landlordList', '2');
INSERT INTO `t_menu` VALUES ('3', '用户表', '/userList', '3');
INSERT INTO `t_menu` VALUES ('4', '房屋表', '/houseList', '4');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `uid` varchar(32) NOT NULL,
  `hid` varchar(32) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `rid` int(1) NOT NULL,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员');
INSERT INTO `t_role` VALUES ('2', '用户管理员');
INSERT INTO `t_role` VALUES ('3', '房屋管理员');
INSERT INTO `t_role` VALUES ('4', '合同管理员');
INSERT INTO `t_role` VALUES ('5', '房东');

-- ----------------------------
-- Table structure for `t_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `rmid` int(2) NOT NULL,
  `rid` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES ('1', '1');
INSERT INTO `t_role_menu` VALUES ('2', '1');
INSERT INTO `t_role_menu` VALUES ('3', '1');
INSERT INTO `t_role_menu` VALUES ('4', '1');
INSERT INTO `t_role_menu` VALUES ('5', '1');
INSERT INTO `t_role_menu` VALUES ('6', '1');
INSERT INTO `t_role_menu` VALUES ('3', '2');
INSERT INTO `t_role_menu` VALUES ('4', '3');
INSERT INTO `t_role_menu` VALUES ('4', '5');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` varchar(50) NOT NULL COMMENT '用户id',
  `uname` varchar(50) NOT NULL COMMENT '用户名',
  `upwd` varchar(50) NOT NULL COMMENT '用户密码',
  `utel` varchar(30) NOT NULL COMMENT '用户电话号码',
  `email` varchar(50) DEFAULT NULL COMMENT '用户email',
  `udate` varchar(20) NOT NULL COMMENT '生成时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1584bb9c732e46ebba0f69cd633d35a1', '测试', '123456', '15932901186', '1819669614@qq.com', '2020-06');
INSERT INTO `t_user` VALUES ('17ef131643cc43bfa6bc726df2d245d3', 'cherry', '123', '15932901186', 'cherry@cherry.com', '2020-01');
INSERT INTO `t_user` VALUES ('44664837e90c46f7b1704c82cd692029', 'autom', '123', '15932901186', 'xzc@qq.com', '2020-02');
INSERT INTO `t_user` VALUES ('4dbcaf6b22e44648aba2c77176e72256', 'fds', '123', '15932901186', '1819669614@qq.com', '2020-06');
INSERT INTO `t_user` VALUES ('6882187ad8cd43aeb72d76976fc6d33d', 'yyy', '123456', '15932901186', '1819669614@qq.com', '2020-06');
INSERT INTO `t_user` VALUES ('6f421b9ac3a94651a59b28bfc3386a55', 'qwefd', '123456', '15932901186', 'x1819669614@163.com', '2020-06');
INSERT INTO `t_user` VALUES ('8aa9fd4b00844d22916d98840f3b3253', 'spider', '123456', '15932901186', 'spider@admin.com', '2020-02');
INSERT INTO `t_user` VALUES ('9cd3a49763414d61acf13e03fe942648', 'xzc', '123456', '12345678910', '1819669614@qq.com', '2020-03');
INSERT INTO `t_user` VALUES ('aaf4edddebc84d1b813d7b12683e4e7d', 'ppp', '123456', '15932901186', 'xzc@qq.com', '2020-06');
INSERT INTO `t_user` VALUES ('b4fa43f6c44f421980ccca673aae3ec7', 'poi', '123456', '12345612341', 'cherry@cherry.com', '2020-06');
INSERT INTO `t_user` VALUES ('ba78384f932d42519a7bcaa6ce58b58b', 'iron', '123456', '15932901186', '1233@qq.com', '2020-04');
INSERT INTO `t_user` VALUES ('c38f40d9cbc846b4b97bc1b7e361b7cc', 'ttt', '123456', '15932901186', '1819669614@qq.com', '2020-03');
INSERT INTO `t_user` VALUES ('d764c63c627b407fbefbe4fd73c885f0', 'qherry', '123456', '15932901186', '1819669614@qq.com', '2020-05');
INSERT INTO `t_user` VALUES ('e6cf908f57124979abbbe52f8086ab50', 'yzh', '123456', '18279021156', '2576061295@qq.com', '2020-04');
INSERT INTO `t_user` VALUES ('f47026b401684b8fb47cbc2e21df47a6', 'yui', '123456', '14725836910', 'xzc@qq.com', '2020-06');
