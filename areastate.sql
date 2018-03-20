/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50551
Source Host           : localhost:3306
Source Database       : areastate

Target Server Type    : MYSQL
Target Server Version : 50551
File Encoding         : 65001

Date: 2018-03-20 16:16:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for anouncement
-- ----------------------------
DROP TABLE IF EXISTS `anouncement`;
CREATE TABLE `anouncement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anouncementTitle` varchar(255) DEFAULT NULL,
  `anouncementContent` varchar(10000) DEFAULT NULL,
  `inputDate` datetime DEFAULT NULL,
  `publishDate` datetime DEFAULT NULL,
  `anouncementState` varchar(255) DEFAULT NULL,
  `urgency` varchar(255) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of anouncement
-- ----------------------------
INSERT INTO `anouncement` VALUES ('11', '创青春', '<p style=\"text-align: center;\">《重要通知》</p><p style=\"line-height:32px\"><span style=\"font-family: 宋体, SimSun; font-size: 16px;\">各有关单位：</span></p><p style=\"text-indent:37px;line-height:32px\"><span style=\"font-family: 宋体, SimSun; font-size: 16px;\">为进一步深化我校校园科技文化活动，营造良好的大学生创新创业氛围，强化我校学生的创新创业理念，提高青年学生的综合素质，培养具有创新意识、实践能力和创业精神的复合型、创造型人才，同时也为了广泛动员组织我校学生参加2018年“创青春”全国大学生创业大赛，现将有关事项预通知如下：</span></p><p><br/></p>', '2018-01-23 17:33:47', '2018-01-24 14:50:44', '可发布', '常规', '14');
INSERT INTO `anouncement` VALUES ('24', '测试公告', '<p style=\"margin-top: 1em; margin-bottom: 1em; color: rgb(51, 51, 51); font-family: &quot;Lucida Grande&quot;, &quot;Microsoft JhengHei&quot;, &quot;Microsoft YaHei&quot;; font-size: 20px; white-space: normal;\"><a href=\"https://github.com/jonrohan/ZeroClipboard/\" style=\"text-decoration-line: none; border-bottom: 1px dashed black;\">&nbsp;&nbsp;&nbsp;&nbsp;ZeroClipboard</a>是在桌面电脑的浏览器上，通过flash技术实现“复制到剪切板”功能的一个程序。它的好处是可以兼容所有浏览器，完成剪切板的操作。</p><p style=\"margin-top: 1em; margin-bottom: 1em; color: rgb(51, 51, 51); font-family: &quot;Lucida Grande&quot;, &quot;Microsoft JhengHei&quot;, &quot;Microsoft YaHei&quot;; font-size: 20px; white-space: normal;\">我们在使用的时候主要就用到两个文件：一个是js文件<code style=\"font-family: Monaco, Consolas, &quot;Courier New&quot;; font-size: 17px; background: rgb(250, 250, 250); border-radius: 5px;\">ZeroClipboard.js</code>，用来引用在网页中；另一个则是swf文件<code style=\"font-family: Monaco, Consolas, &quot;Courier New&quot;; font-size: 17px; background: rgb(250, 250, 250); border-radius: 5px;\">ZeroClipboard.swf</code>，它无需我们在代码里引用，而是被之前的那个<code style=\"font-family: Monaco, Consolas, &quot;Courier New&quot;; font-size: 17px; background: rgb(250, 250, 250); border-radius: 5px;\">ZeroClipboard.js</code>二次调用的。</p><p style=\"margin-top: 1em; margin-bottom: 1em; color: rgb(51, 51, 51); font-family: &quot;Lucida Grande&quot;, &quot;Microsoft JhengHei&quot;, &quot;Microsoft YaHei&quot;; font-size: 20px; white-space: normal;\">ZeroClipboard的工作原理大概是，在网页的“复制”按钮上层遮罩一个透明的flash，这个flash在被点击之后，会调用其的剪切板处理功能，完成对特定文本的复制。这里有几件事需要我们来完成：</p><ol style=\"margin-top: 1em; margin-bottom: 1em; padding: 0px 0px 0px 40px; color: rgb(51, 51, 51); font-family: &quot;Lucida Grande&quot;, &quot;Microsoft JhengHei&quot;, &quot;Microsoft YaHei&quot;; font-size: 20px; white-space: normal;\" class=\" list-paddingleft-2\"><li><p>创建一个透明的flash</p></li><li><p>将这个flash浮在按钮上层</p></li><li><p>确定要复制的文本是什么</p></li><li><p>监听这个透明flash的鼠标点击事件</p></li><li><p>该flash被点击之后，完成剪切板处理</p></li></ol><p style=\"margin-top: 1em; margin-bottom: 1em; color: rgb(51, 51, 51); font-family: &quot;Lucida Grande&quot;, &quot;Microsoft JhengHei&quot;, &quot;Microsoft YaHei&quot;; font-size: 20px; white-space: normal;\">对于这几件事，ZeroClipboard分别提供了不同的api，来完成整个需求。</p>', '2018-01-24 11:24:18', '2018-01-24 14:29:43', '可发布', '特急', '14');
INSERT INTO `anouncement` VALUES ('25', '​单点登录SSO', '<p style=\"margin-top: 1em; margin-bottom: 1em; font-size: 15px; word-break: break-word; white-space: pre-wrap; word-wrap: break-word; line-height: 1.7em; overflow: auto; color: rgb(51, 51, 51); font-family: &quot;Helvetica Neue&quot;, &quot;Luxi Sans&quot;, &quot;DejaVu Sans&quot;, Tahoma, &quot;Hiragino Sans GB&quot;, STHeiti, sans-serif; background-color: rgb(255, 255, 255);\">&nbsp;&nbsp;&nbsp;&nbsp;单点登录SSO（Single Sign On）说得简单点就是在一个多系统共存的环境下，用户在一处登录后，就不用在其他系统中登录，也就是用户的一次登录能得到其他所有系统的信任。单点登录在大型网站里使用得非常频繁，例如像阿里巴巴这样的网站，在网站的背后是成百上千的子系统，用户一次操作或交易可能涉及到几十个子系统的协作，如果每个子系统都需要用户认证，不仅用户会疯掉，各子系统也会为这种重复认证授权的逻辑搞疯掉。实现单点登录说到底就是要解决如何产生和存储那个信任，再就是其他系统如何验证这个信任的有效性，因此要点也就以下两个：</p><ul style=\"padding: 0px; margin-bottom: 10px; margin-left: 25px; color: rgb(51, 51, 51); font-family: &quot;Helvetica Neue&quot;, &quot;Luxi Sans&quot;, &quot;DejaVu Sans&quot;, Tahoma, &quot;Hiragino Sans GB&quot;, STHeiti, sans-serif; font-size: 14px; white-space: normal; background-color: rgb(255, 255, 255);\" class=\" list-paddingleft-2\"><li><p>存储信任</p></li><li><p>验证信任</p></li></ul><p style=\"margin-top: 1em; margin-bottom: 1em; font-size: 15px; word-break: break-word; white-space: pre-wrap; word-wrap: break-word; line-height: 1.7em; overflow: auto; color: rgb(51, 51, 51); font-family: &quot;Helvetica Neue&quot;, &quot;Luxi Sans&quot;, &quot;DejaVu Sans&quot;, Tahoma, &quot;Hiragino Sans GB&quot;, STHeiti, sans-serif; background-color: rgb(255, 255, 255);\">如果一个系统做到了开头所讲的效果，也就算单点登录，单点登录有不同的实现方式，本文就罗列我开发中所遇见过的实现方式。</p><p><br/></p>', '2018-01-24 16:13:16', '2018-01-24 16:13:16', '已发布', '特急', '15');

-- ----------------------------
-- Table structure for land
-- ----------------------------
DROP TABLE IF EXISTS `land`;
CREATE TABLE `land` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `landName` varchar(255) DEFAULT NULL,
  `landAreas` double DEFAULT NULL,
  `landState` varchar(255) DEFAULT NULL,
  `inputDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of land
-- ----------------------------
INSERT INTO `land` VALUES ('1', 'LAND1514465344101', '篮球场', '23.6', '启用', null);
INSERT INTO `land` VALUES ('2', 'LAND1514478787619', '跆拳道馆', '23.3', '启用', null);
INSERT INTO `land` VALUES ('3', 'LAND1514478813720', '游泳池', '44.7', '禁用', null);
INSERT INTO `land` VALUES ('9', 'LAND1514706632454', '活动中心A区域', '45.6', '禁用', null);
INSERT INTO `land` VALUES ('10', 'LAND1514706668699', '活动中心B区', '26.7', '禁用', null);
INSERT INTO `land` VALUES ('11', 'LAND1514706692314', '活动中心C区', '45.6', '启用', null);
INSERT INTO `land` VALUES ('12', 'LAND1514706745394', '活动中心D区', '12.6', '禁用', null);
INSERT INTO `land` VALUES ('14', 'LAND1514706771586', '第一教学楼B112会议室', '34.7', '禁用', null);

-- ----------------------------
-- Table structure for lockingrecord
-- ----------------------------
DROP TABLE IF EXISTS `lockingrecord`;
CREATE TABLE `lockingrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `lockDate` datetime DEFAULT NULL,
  `timeQuantum` varchar(255) DEFAULT NULL,
  `landId` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `submitDate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lockingrecord
-- ----------------------------
INSERT INTO `lockingrecord` VALUES ('75', '14', '2018-01-21 21:48:56', '晚上', '1', '已废除', '2018-01-21 21:49:16', '1516542557119');
INSERT INTO `lockingrecord` VALUES ('76', '14', '2018-01-22 21:48:56', '晚上', '1', '已废除', '2018-01-21 21:49:16', '1516542557119');
INSERT INTO `lockingrecord` VALUES ('77', '14', '2018-01-23 21:48:56', '下午', '1', '已废除', '2018-01-21 21:49:16', '1516542557119');
INSERT INTO `lockingrecord` VALUES ('78', '14', '2018-01-24 22:22:47', '晚上', '1', '已废除', '2018-01-21 22:22:53', '1516544574041');
INSERT INTO `lockingrecord` VALUES ('79', '14', '2018-01-24 22:22:47', '下午', '1', '已废除', '2018-01-21 22:22:53', '1516544574041');
INSERT INTO `lockingrecord` VALUES ('80', '14', '2018-01-25 22:22:47', '下午', '1', '已废除', '2018-01-21 22:22:53', '1516544574041');
INSERT INTO `lockingrecord` VALUES ('81', '14', '2018-01-22 22:27:15', '晚上', '1', '已废除', '2018-01-21 22:27:47', '1516544867637');
INSERT INTO `lockingrecord` VALUES ('82', '14', '2018-01-23 22:27:15', '下午', '1', '已废除', '2018-01-21 22:27:47', '1516544867637');
INSERT INTO `lockingrecord` VALUES ('83', '14', '2018-01-24 22:27:15', '上午', '1', '已废除', '2018-01-21 22:27:47', '1516544867637');
INSERT INTO `lockingrecord` VALUES ('84', '14', '2018-01-24 22:27:15', '下午', '1', '已废除', '2018-01-21 22:27:47', '1516544867637');
INSERT INTO `lockingrecord` VALUES ('85', '14', '2018-01-24 22:27:15', '晚上', '1', '已废除', '2018-01-21 22:27:47', '1516544867637');
INSERT INTO `lockingrecord` VALUES ('86', '14', '2018-01-25 22:27:15', '下午', '1', '已废除', '2018-01-21 22:27:47', '1516544867637');
INSERT INTO `lockingrecord` VALUES ('87', '14', '2018-01-26 22:27:15', '下午', '1', '已废除', '2018-01-21 22:27:47', '1516544867637');
INSERT INTO `lockingrecord` VALUES ('88', '14', '2018-01-27 22:27:15', '晚上', '1', '已废除', '2018-01-21 22:27:47', '1516544867637');
INSERT INTO `lockingrecord` VALUES ('89', '14', '2018-01-26 22:27:15', '晚上', '1', '已废除', '2018-01-21 22:27:47', '1516544867637');
INSERT INTO `lockingrecord` VALUES ('90', '15', '2018-01-22 00:01:13', '上午', '1', '已废除', '2018-01-22 00:01:22', '1516550482990');
INSERT INTO `lockingrecord` VALUES ('91', '15', '2018-01-23 00:01:13', '下午', '1', '已废除', '2018-01-22 00:01:22', '1516550482990');
INSERT INTO `lockingrecord` VALUES ('92', '15', '2018-01-23 00:01:13', '晚上', '1', '已废除', '2018-01-22 00:01:22', '1516550482990');
INSERT INTO `lockingrecord` VALUES ('93', '15', '2018-01-24 00:01:13', '晚上', '1', '已废除', '2018-01-22 00:01:22', '1516550482990');
INSERT INTO `lockingrecord` VALUES ('94', '15', '2018-01-25 00:01:13', '下午', '1', '已废除', '2018-01-22 00:01:22', '1516550482990');
INSERT INTO `lockingrecord` VALUES ('95', '14', '2018-01-22 00:54:27', '晚上', '1', '已废除', '2018-01-22 00:54:42', '1516553683090');
INSERT INTO `lockingrecord` VALUES ('96', '14', '2018-01-23 00:54:27', '下午', '1', '已废除', '2018-01-22 00:54:42', '1516553683090');
INSERT INTO `lockingrecord` VALUES ('97', '14', '2018-01-25 00:54:43', '上午', '1', '已废除', '2018-01-22 00:55:07', '1516553707757');
INSERT INTO `lockingrecord` VALUES ('98', '14', '2018-01-25 00:54:43', '下午', '1', '已废除', '2018-01-22 00:55:07', '1516553707757');
INSERT INTO `lockingrecord` VALUES ('99', '14', '2018-01-27 00:58:46', '下午', '1', '已废除', '2018-01-22 00:58:50', '1516553931202');
INSERT INTO `lockingrecord` VALUES ('100', '14', '2018-01-26 00:58:46', '晚上', '1', '已废除', '2018-01-22 00:58:50', '1516553931202');
INSERT INTO `lockingrecord` VALUES ('101', '14', '2018-01-24 01:04:41', '下午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('102', '14', '2018-01-25 01:04:41', '晚上', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('103', '14', '2018-01-26 01:04:41', '晚上', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('104', '14', '2018-01-26 01:04:41', '下午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('105', '14', '2018-01-25 01:04:41', '下午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('106', '14', '2018-01-24 01:04:41', '晚上', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('107', '14', '2018-01-23 01:04:41', '晚上', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('108', '14', '2018-01-22 01:04:41', '晚上', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('109', '14', '2018-01-22 01:04:41', '下午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('110', '14', '2018-01-23 01:04:41', '下午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('111', '14', '2018-01-27 01:04:41', '晚上', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('112', '14', '2018-01-28 01:04:41', '晚上', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('113', '14', '2018-01-29 01:04:41', '晚上', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('114', '14', '2018-01-30 01:04:41', '晚上', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('115', '14', '2018-01-31 01:04:41', '晚上', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('116', '14', '2018-01-31 01:04:41', '下午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('117', '14', '2018-01-30 01:04:41', '下午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('118', '14', '2018-01-29 01:04:41', '下午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('119', '14', '2018-01-28 01:04:41', '下午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('120', '14', '2018-01-27 01:04:41', '下午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('121', '14', '2018-01-29 01:04:41', '上午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('122', '14', '2018-01-30 01:04:41', '上午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('123', '14', '2018-01-31 01:04:41', '上午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('124', '14', '2018-01-28 01:04:41', '上午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('125', '14', '2018-01-27 01:04:41', '上午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('126', '14', '2018-01-25 01:04:41', '上午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('127', '14', '2018-01-26 01:04:41', '上午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('128', '14', '2018-01-24 01:04:41', '上午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('129', '14', '2018-01-23 01:04:41', '上午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('130', '14', '2018-01-22 01:04:41', '上午', '11', '已废除', '2018-01-22 01:05:56', '1516554356359');
INSERT INTO `lockingrecord` VALUES ('131', '14', '2018-01-25 10:05:52', '晚上', '1', '已废除', '2018-01-22 10:06:31', '1516586792009');
INSERT INTO `lockingrecord` VALUES ('132', '14', '2018-01-22 19:16:40', '晚上', '1', '已废除', '2018-01-22 19:21:31', '1516620091859');
INSERT INTO `lockingrecord` VALUES ('133', '14', '2018-01-23 19:16:40', '晚上', '1', '已废除', '2018-01-22 19:21:31', '1516620091859');
INSERT INTO `lockingrecord` VALUES ('134', '14', '2018-01-23 19:16:40', '下午', '1', '已废除', '2018-01-22 19:21:31', '1516620091859');
INSERT INTO `lockingrecord` VALUES ('135', '14', '2018-01-22 08:00:00', '上午', '1', '已废除', '2018-01-22 21:31:18', '1516627878292');
INSERT INTO `lockingrecord` VALUES ('136', '15', '2018-01-23 22:02:19', '晚上', '1', '已废除', '2018-01-22 22:03:31', '1516629811248');
INSERT INTO `lockingrecord` VALUES ('137', '15', '2018-01-24 22:02:19', '晚上', '1', '已废除', '2018-01-22 22:03:31', '1516629811248');
INSERT INTO `lockingrecord` VALUES ('138', '15', '2018-01-22 22:04:08', '上午', '1', '已废除', '2018-01-22 22:04:11', '1516629851493');
INSERT INTO `lockingrecord` VALUES ('139', '15', '2018-01-25 22:04:08', '上午', '1', '已废除', '2018-01-22 22:04:11', '1516629851493');
INSERT INTO `lockingrecord` VALUES ('140', '14', '2018-01-23 21:05:47', '晚上', '1', '已废除', '2018-01-23 21:05:51', '1516712751686');
INSERT INTO `lockingrecord` VALUES ('141', '14', '2018-01-23 21:05:47', '下午', '1', '已废除', '2018-01-23 21:05:51', '1516712751686');
INSERT INTO `lockingrecord` VALUES ('142', '15', '2018-01-25 13:55:01', '下午', '1', '已废除', '2018-01-24 13:55:11', '1516773312165');
INSERT INTO `lockingrecord` VALUES ('143', '15', '2018-01-25 13:55:01', '上午', '1', '已废除', '2018-01-24 13:55:11', '1516773312165');
INSERT INTO `lockingrecord` VALUES ('144', '15', '2018-01-24 13:55:01', '下午', '1', '已废除', '2018-01-24 13:55:11', '1516773312165');
INSERT INTO `lockingrecord` VALUES ('145', '16', '2018-01-27 15:20:13', '下午', '1', '已废除', '2018-01-24 15:20:19', '1516778419344');
INSERT INTO `lockingrecord` VALUES ('146', '16', '2018-01-26 15:20:13', '下午', '1', '已废除', '2018-01-24 15:20:19', '1516778419344');
INSERT INTO `lockingrecord` VALUES ('147', '16', '2018-01-27 15:20:13', '上午', '1', '已废除', '2018-01-24 15:20:19', '1516778419344');
INSERT INTO `lockingrecord` VALUES ('148', '16', '2018-01-28 15:20:13', '上午', '1', '已废除', '2018-01-24 15:20:19', '1516778419344');
INSERT INTO `lockingrecord` VALUES ('149', '14', '2018-01-24 08:00:00', '上午', '1', '已废除', '2018-01-24 15:30:21', '1516779021753');
INSERT INTO `lockingrecord` VALUES ('150', '15', '2018-01-26 16:21:31', '上午', '1', '已废除', '2018-01-24 16:21:37', '1516782097816');
INSERT INTO `lockingrecord` VALUES ('151', '15', '2018-01-26 16:21:31', '晚上', '1', '已废除', '2018-01-24 16:21:37', '1516782097816');
INSERT INTO `lockingrecord` VALUES ('152', '16', '2018-03-01 16:31:30', '下午', '1', '锁定', '2018-03-01 16:31:59', '1519893119155');
INSERT INTO `lockingrecord` VALUES ('153', '16', '2018-03-02 16:31:30', '晚上', '1', '锁定', '2018-03-01 16:31:59', '1519893119155');
INSERT INTO `lockingrecord` VALUES ('154', '16', '2018-03-04 16:31:30', '晚上', '1', '锁定', '2018-03-01 16:31:59', '1519893119155');
INSERT INTO `lockingrecord` VALUES ('155', '16', '2018-03-04 16:31:30', '下午', '1', '锁定', '2018-03-01 16:31:59', '1519893119155');
INSERT INTO `lockingrecord` VALUES ('156', '16', '2018-03-04 16:31:30', '上午', '1', '锁定', '2018-03-01 16:31:59', '1519893119155');
INSERT INTO `lockingrecord` VALUES ('157', '16', '2018-03-06 16:31:30', '上午', '1', '锁定', '2018-03-01 16:31:59', '1519893119155');
INSERT INTO `lockingrecord` VALUES ('158', '16', '2018-03-09 16:31:30', '上午', '1', '锁定', '2018-03-01 16:31:59', '1519893119155');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operateUser` int(11) DEFAULT NULL,
  `operateDate` datetime DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `log_ibfk_1` (`operateUser`),
  CONSTRAINT `log_ibfk_1` FOREIGN KEY (`operateUser`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for sysconfig
-- ----------------------------
DROP TABLE IF EXISTS `sysconfig`;
CREATE TABLE `sysconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `property` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `deleteable` varchar(255) DEFAULT NULL,
  `inputDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysconfig
-- ----------------------------
INSERT INTO `sysconfig` VALUES ('7', '数值型', '展示用地状态数据天数', '30', '0', '2017-12-31 22:53:07');
INSERT INTO `sysconfig` VALUES ('8', '数值型', '场地锁定失效时长（小时计算）', '20', 'false', '2018-01-20 14:58:12');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` bigint(20) DEFAULT NULL,
  `loginNo` varchar(255) DEFAULT NULL,
  `loginPwd` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `employeeNo` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `noReadAnouncementId` int(11) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('14', '1515826987602', '15310444798', '22222', null, '15310444798', null, null, null, 'user', null, '普通用户');
INSERT INTO `user` VALUES ('15', '1515899106013', '11503080217', 'liqiao55', null, '11503080217', null, null, null, 'admin', null, '管理员');
INSERT INTO `user` VALUES ('16', '1516766798005', '18723030500', 'liqiao55', null, '18723030500', null, null, null, 'admin', null, '管理员');

-- ----------------------------
-- Event structure for updatelockstate
-- ----------------------------
DROP EVENT IF EXISTS `updatelockstate`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` EVENT `updatelockstate` ON SCHEDULE EVERY 60 SECOND STARTS '2018-01-15 00:22:11' ON COMPLETION NOT PRESERVE ENABLE DO update lockingrecord set lockingrecord.state = '已废除' where TIMESTAMPDIFF(second,lockingrecord.submitDate,now()) > (SELECT sysconfig.`value` FROM sysconfig WHERE sysconfig.property = '场地锁定失效时长') * 60 * 60 and lockingrecord.state <> '已废除' and lockingrecord.state <> '已分配'and lockingrecord.state <> '已过期'
;;
DELIMITER ;
