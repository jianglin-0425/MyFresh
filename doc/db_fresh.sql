/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : db_fresh

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2021-06-17 22:50:49
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `addrinfo`
-- ----------------------------
DROP TABLE IF EXISTS `addrinfo`;
CREATE TABLE `addrinfo` (
  `ano` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '',
  `mno` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `tel` varchar(15) COLLATE utf8_bin NOT NULL,
  `province` varchar(100) COLLATE utf8_bin NOT NULL,
  `city` varchar(100) COLLATE utf8_bin NOT NULL,
  `area` varchar(100) COLLATE utf8_bin NOT NULL,
  `addr` varchar(100) COLLATE utf8_bin NOT NULL,
  `flag` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`ano`),
  KEY `FK_addrInfo_mno` (`mno`),
  CONSTRAINT `FK_addrInfo_mno` FOREIGN KEY (`mno`) REFERENCES `menberinfo` (`mno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of addrinfo
-- ----------------------------
INSERT INTO addrinfo VALUES ('1', '1', 'Lydia', '1825675530', '安徽省', '亳州市', '涡阳县', '青疃镇', '1', '1');

-- ----------------------------
-- Table structure for `admininfo`
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(100) COLLATE utf8_bin NOT NULL,
  `pwd` varchar(100) COLLATE utf8_bin NOT NULL,
  `tel` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`aid`),
  UNIQUE KEY `aname` (`aname`),
  UNIQUE KEY `tel` (`tel`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO admininfo VALUES ('1', 'navy', '202cb962ac59075b964b07152d234b70', '15096098010');
INSERT INTO admininfo VALUES ('2', 'jl', '0cc175b9c0f1b6a831c399e269772661', '18256752530');

-- ----------------------------
-- Table structure for `cartinfo`
-- ----------------------------
DROP TABLE IF EXISTS `cartinfo`;
CREATE TABLE `cartinfo` (
  `cno` int(11) NOT NULL AUTO_INCREMENT,
  `mno` int(11) DEFAULT NULL,
  `gno` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`cno`),
  KEY `FK_cartInfo_mno` (`mno`),
  KEY `FK_cartInfo_gno` (`gno`),
  CONSTRAINT `FK_cartInfo_gno` FOREIGN KEY (`gno`) REFERENCES `goodsinfo` (`gno`),
  CONSTRAINT `FK_cartInfo_mno` FOREIGN KEY (`mno`) REFERENCES `menberinfo` (`mno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of cartinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `goodsinfo`
-- ----------------------------
DROP TABLE IF EXISTS `goodsinfo`;
CREATE TABLE `goodsinfo` (
  `gno` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(100) COLLATE utf8_bin NOT NULL,
  `tno` int(11) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `intro` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `pics` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `unit` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `qperied` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `weight` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `descr` text COLLATE utf8_bin,
  PRIMARY KEY (`gno`),
  KEY `FK_goodsInfo_tno` (`tno`),
  CONSTRAINT `FK_goodsInfo_tno` FOREIGN KEY (`tno`) REFERENCES `goodstype` (`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of goodsinfo
-- ----------------------------
INSERT INTO goodsinfo VALUES ('7', '葡萄', '1', '3.20', '好吃', '200', '../fresh_images/5c381dd0-74c0-4630-bea7-0c8a8d012ffee0effcf8a3a723f0bef1133b9f8d7105_dFwBAAAAAAAA&bo=3AWsAQAAAAAFF0A!&rf=viewer_4.jpg', '斤', '2020-04-30', '1', 0xE5A5BDE5969D);
INSERT INTO goodsinfo VALUES ('8', '海带', '2', '2.30', '也很好吃', '200', '../fresh_images/f47f49d2-a44b-4f34-8c32-afc6c3c42dd29221795823a28c3978db39cdd3adb8dc_dHIBAAAAAAAA&bo=iAOAAgAAAAAFJw0!&rf=viewer_4.jpg', '斤', '2022-04-30', '1', 0xE4B99FE5BE88E5A5BDE5969D);
INSERT INTO goodsinfo VALUES ('9', '海苔', '2', '2.30', '也很好吃', '200', '../fresh_images/e8863a8c-138e-42a6-bb7e-6163af07c8cc9221795823a28c3978db39cdd3adb8dc_dHIBAAAAAAAA&bo=iAOAAgAAAAAFJw0!&rf=viewer_4.jpg', '斤', '2022-04-30', '1', 0xE4B99FE5BE88E5A5BDE5969D);
INSERT INTO goodsinfo VALUES ('10', '内蒙古羊肉', '3', '58.00', 'very Good', '200', '../fresh_images/0adddeec-4392-4474-bd30-dbdb80a5b560F296CEE65806FA85115AD226CC21C3B3.png', 'kg', '2020-04-30', '1', 0xE5B0B1E698AFE5A5BDE59083);
INSERT INTO goodsinfo VALUES ('11', '内蒙古牛肉', '3', '58.00', 'very Good', '200', '../fresh_images/1d74d3ce-065f-4e2e-878e-6f49c9d58212F296CEE65806FA85115AD226CC21C3B3.png', 'kg', '2020-04-30', '1', 0xE5B0B1E698AFE5A5BDE59083);
INSERT INTO goodsinfo VALUES ('12', '菠萝', '1', '5.00', '吃的', '100', '../fresh_images/612f2531-b7d2-4d6b-b7c6-440db81ae5d8BEDE9CF2418870BD4459A542B1E520B4.png', '斤', '2020-04-30', '1', 0xE5969DE79A84);
INSERT INTO goodsinfo VALUES ('13', '橘子', '1', '2.00', '甜', '300', '../fresh_images/10c3e7c5-0307-4407-a83e-e978a38ae7abIMG_20150722_173624.jpg', '斤', '2020-04-30', '1', 0xE5BE88E7949C);
INSERT INTO goodsinfo VALUES ('14', '水狗', '1', '10.00', '好', '1111', '../fresh_images/5173a6b6-50b5-4105-bad4-e75c44e05bfdBEDE9CF2418870BD4459A542B1E520B4.png', '斤', '2020-06-19', '12', 0xE5A5BD);
INSERT INTO goodsinfo VALUES ('15', '水狗', '1', '10.00', '好', '1111', '../fresh_images/39796c8f-d6ad-4626-89df-04fd9f0bf056BEDE9CF2418870BD4459A542B1E520B4.png', '斤', '2020-06-19', '12', 0xE5A5BD);
INSERT INTO goodsinfo VALUES ('16', '水狗', '1', '10.00', '好', '1111', '../fresh_images/74b863d8-a10f-4316-b68f-4db4f85276edBEDE9CF2418870BD4459A542B1E520B4.png', '斤', '2020-06-19', '12', 0xE5A5BD);
INSERT INTO goodsinfo VALUES ('17', '水狗', '1', '10.00', '好', '1111', '../fresh_images/3dbf29a4-5a5f-4cab-9e00-811ca35d6795BEDE9CF2418870BD4459A542B1E520B4.png', '斤', '2020-06-19', '12', 0xE5A5BD);
INSERT INTO goodsinfo VALUES ('18', '水狗', '1', '10.00', '好', '1111', '../fresh_images/d8fa9d0e-f79c-40df-b860-52794346b187BEDE9CF2418870BD4459A542B1E520B4.png', '斤', '2020-06-19', '12', 0xE5A5BD);
INSERT INTO goodsinfo VALUES ('19', '水狗', '1', '10.00', '好', '1111', '../fresh_images/158f9878-1c57-4fb3-b59c-2d48ec13245aBEDE9CF2418870BD4459A542B1E520B4.png', '斤', '2020-06-19', '12', 0xE5A5BD);
INSERT INTO goodsinfo VALUES ('20', '水狗', '1', '10.00', '好', '1111', '../fresh_images/efa5bba1-81a1-49e4-b6a9-6256774459a5BEDE9CF2418870BD4459A542B1E520B4.png', '斤', '2020-06-19', '12', 0xE5A5BD);
INSERT INTO goodsinfo VALUES ('21', '水狗', '1', '10.00', '好', '1111', '../fresh_images/023f56f4-b11d-4752-a12f-a76ac7323b01BEDE9CF2418870BD4459A542B1E520B4.png', '斤', '2020-06-19', '12', 0xE5A5BD);
INSERT INTO goodsinfo VALUES ('22', '水狗', '1', '10.00', '好', '1111', '../fresh_images/dbccb49d-a3aa-4cc6-af59-1072163323ebBEDE9CF2418870BD4459A542B1E520B4.png', '斤', '2020-06-19', '12', 0xE5A5BD);
INSERT INTO goodsinfo VALUES ('23', '水狗', '1', '10.00', '好', '1111', '../fresh_images/f40bd505-c6a0-448a-b60d-c78ddc5b8535BEDE9CF2418870BD4459A542B1E520B4.png', '斤', '2020-06-19', '12', 0xE5A5BD);
INSERT INTO goodsinfo VALUES ('24', '水狗', '1', '10.00', '好', '1111', '../fresh_images/6d2bbb3d-5a5b-4aa4-876b-578b3a8b5663BEDE9CF2418870BD4459A542B1E520B4.png', '斤', '2020-06-19', '12', 0xE5A5BD);
INSERT INTO goodsinfo VALUES ('30', '玄幻', '1', '1.00', '1', '1', '', '1', '2021-06-01', '1', 0x31);
INSERT INTO goodsinfo VALUES ('31', '玄幻', '1', '1.00', 'a', '1', 'fresh_imagesf00aabdc-35c0-4cec-985f-b9455ea01d66fpics', '1', '2021-06-01', '1', 0x61);
INSERT INTO goodsinfo VALUES ('32', '玄幻', '1', '1.00', '1', '1', 'fresh_images8931ee55-7cd8-4479-8480-58f9a1436091fpics', '1', '2021-06-01', '1', 0x31);
INSERT INTO goodsinfo VALUES ('33', '玄幻', '1', '1.00', '1', '1', '', '1', '2021-06-01', '1', 0x31);
INSERT INTO goodsinfo VALUES ('34', '玄幻', '1', '1.00', '1', '1', '', '1', '2021-06-01', '1', 0x31);
INSERT INTO goodsinfo VALUES ('35', '玄幻', '1', '1.00', '1', '1', '', '1', '2021-06-02', '1', 0x31);
INSERT INTO goodsinfo VALUES ('36', '玄幻', '1', '1.00', '1', '1', '', '1', '2021-06-09', '1', 0x31);
INSERT INTO goodsinfo VALUES ('37', '玄幻', '1', '1.00', '1', '1', 'fresh_images1b179bea-d3d2-4808-9ab0-0fa973e09916院校.PNG', '1', '2021-06-01', '1', 0x31);
INSERT INTO goodsinfo VALUES ('38', '玄幻', '1', '1.00', '1', '1', 'shoe_images/a5f692d8-c528-4c9b-b5a0-71462d96766f院校.PNG', '1', '2021-06-01', '1', 0x31);
INSERT INTO goodsinfo VALUES ('39', '玄幻', '1', '1.00', '1', '1', 'shoe_images/5b49c3a9-8ee8-4282-aa6b-0d19df76889e院校.PNG', '1', '2021-06-03', '1', 0x31);
INSERT INTO goodsinfo VALUES ('40', '玄幻', '1', '1.00', '1', '1', 'shoe_images/2bf107d7-6439-43b8-8ec4-3be1c71defeb院校.PNG', '1', '2021-06-08', '1', 0x31);

-- ----------------------------
-- Table structure for `goodstype`
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `tno` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(100) COLLATE utf8_bin NOT NULL,
  `pic` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO goodstype VALUES ('1', '新鲜水果', null, '1');
INSERT INTO goodstype VALUES ('2', '海鲜水产', null, '1');
INSERT INTO goodstype VALUES ('3', '猪牛羊肉', null, '1');
INSERT INTO goodstype VALUES ('4', '禽类蛋品', null, '1');
INSERT INTO goodstype VALUES ('5', '新鲜蔬菜', null, '1');
INSERT INTO goodstype VALUES ('6', '速冻食品', null, '1');

-- ----------------------------
-- Table structure for `menberinfo`
-- ----------------------------
DROP TABLE IF EXISTS `menberinfo`;
CREATE TABLE `menberinfo` (
  `mno` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(100) COLLATE utf8_bin NOT NULL,
  `realName` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `pwd` varchar(100) COLLATE utf8_bin NOT NULL,
  `tel` varchar(15) COLLATE utf8_bin NOT NULL,
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `photo` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `regDate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`mno`),
  UNIQUE KEY `nickName` (`nickName`),
  UNIQUE KEY `tel` (`tel`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of menberinfo
-- ----------------------------
INSERT INTO menberinfo VALUES ('1', 'Lydia', 'Lydia', '0cc175b9c0f1b6a831c399e269772661', '18256752530', '123@qq.com', null, null, '1');

-- ----------------------------
-- Table structure for `orderinfo`
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `ono` varchar(100) COLLATE utf8_bin NOT NULL,
  `odate` datetime DEFAULT NULL,
  `ano` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `sdate` datetime DEFAULT NULL,
  `rdate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `invoice` int(11) DEFAULT NULL,
  `mno` int(11) NOT NULL,
  PRIMARY KEY (`ono`),
  KEY `FK_orderInfo_ano` (`ano`),
  CONSTRAINT `FK_orderInfo_ano` FOREIGN KEY (`ano`) REFERENCES `addrinfo` (`ano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO orderinfo VALUES ('202005072026390411', '2020-05-07 20:26:39', null, null, null, '1', '5.20', '0', '1');
INSERT INTO orderinfo VALUES ('202010051433195861', '2020-10-05 14:33:19', null, null, null, '1', '30.00', '0', '1');

-- ----------------------------
-- Table structure for `orderiteminfo`
-- ----------------------------
DROP TABLE IF EXISTS `orderiteminfo`;
CREATE TABLE `orderiteminfo` (
  `ino` int(11) NOT NULL AUTO_INCREMENT,
  `ono` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `gno` int(11) DEFAULT NULL,
  `nums` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`ino`),
  KEY `FK_orderItemInfo_gno` (`gno`),
  KEY `FK_orderItemInfo_ono` (`ono`),
  CONSTRAINT `FK_orderItemInfo_gno` FOREIGN KEY (`gno`) REFERENCES `goodsinfo` (`gno`),
  CONSTRAINT `FK_orderItemInfo_ono` FOREIGN KEY (`ono`) REFERENCES `orderinfo` (`ono`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of orderiteminfo
-- ----------------------------
INSERT INTO orderiteminfo VALUES ('18', '202005072026390411', '7', '1', '3.20', '1');
INSERT INTO orderiteminfo VALUES ('19', '202005072026390411', '13', '1', '2.00', '1');
INSERT INTO orderiteminfo VALUES ('20', '202010051433195861', '14', '3', '10.00', '1');
