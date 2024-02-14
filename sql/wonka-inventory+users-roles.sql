CREATE DATABASE  IF NOT EXISTS wonka_inventory;
USE wonka_inventory;

DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `origin` varchar(45) DEFAULT NULL,
  `format` varchar(45) DEFAULT NULL,
  `weight` double DEFAULT NULL, -- weight in grams
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Authentication & RBAC
CREATE TABLE `members` (
    `user_id` varchar(50) NOT NULL,
    `pw` char(68) NOT NULL,
    `active` tinyint NOT NULL,
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- BCrypt passwords generation tool: https://bcrypt-generator.com
CREATE TABLE `roles` (
    `user_id` varchar(50) NOT NULL,
    `role` varchar(50) NOT NULL,
    UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
    CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `product` VALUES
    (1,'Lemon Nougatine Bar','Single origin 45% milk chocolate made with cocoa beans from Piura in Peru','Peru','bar',60),
    (2,'Maple & Fir','Single origin 70% dark chocolate made with beans from the Ucayali region of Peru','Peru','bar',25),
    (3,'Passion fruit','70% dark chocolate made from cocoa beans of various origins, with crunchy nibs infused with passion fruit','various','bar',60),
    (4,'Hot Chocolate','Hot Chocolate - Spices','Guatemala','spread',180),
    (5,'Lingots','Fine chocolats to share and to offer','various','lingots',140);

-- user_id - pw
-- user    - user
-- admin   - admin
INSERT INTO `members` VALUES
    ('user','{bcrypt}$2a$12$boMS6eYPB1ks4x5Q5P2xh.6M/ui1DP4XZv6oGj4SNz9G7RvhB9DoK',1),
    ('admin','{bcrypt}$2a$12$l2/kE0nvdmKFHa2vWQwRoOIt6ymazgLCgkaBXyt3OClBLedf2K8cK',1);

INSERT INTO `roles` VALUES
    ('user','ROLE_USER'),
    ('admin','ROLE_USER'),
    ('admin','ROLE_ADMIN');
