CREATE DATABASE  IF NOT EXISTS `schema_orders`;
USE `schema_orders`;

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `order` WRITE;
INSERT INTO `order` VALUES (47,'2022-10-31'),(48,'2022-10-31'),(50,'2022-10-31'),(51,'2022-11-01'),(52,'2022-11-02'),(53,'2022-10-31'),(55,'2022-10-31');
UNLOCK TABLES;


DROP TABLE IF EXISTS `order_recordsoforder`;
CREATE TABLE `order_recordsoforder` (
  `Order_id` int NOT NULL,
  `recordsOfOrder_id` int NOT NULL,
  UNIQUE KEY `UK_fdi8beju7ji9f02l6vv4otfwa` (`recordsOfOrder_id`),
  KEY `FK3ghr26xght8xiixagor31urcc` (`Order_id`),
  CONSTRAINT `FK3ghr26xght8xiixagor31urcc` FOREIGN KEY (`Order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `FKbmvn782anvh2fs41akoro4nr3` FOREIGN KEY (`recordsOfOrder_id`) REFERENCES `recordsoforder` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `order_recordsoforder` WRITE;
INSERT INTO `order_recordsoforder` VALUES (47,2091),(48,2092),(50,2094),(51,2095),(52,2096),(53,2097),(55,2099);
UNLOCK TABLES;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `describing` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `product` WRITE;
INSERT INTO `product` VALUES (1,'cool Coca-Cola','Cola',1),(2,'fresh Fanta','Fanta',3),(3,'cold Sprite','Sprite',2);
UNLOCK TABLES;

DROP TABLE IF EXISTS `recordsoforder`;
CREATE TABLE `recordsoforder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantityOfProduct` int NOT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK10k5000jtha7o8kinf42v48jo` (`product_id`),
  CONSTRAINT `FK10k5000jtha7o8kinf42v48jo` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `recordsoforder` WRITE;
INSERT INTO `recordsoforder` VALUES (2091,160,3),(2092,320,3),(2094,5,3),(2095,10,1),(2096,7,2),(2097,485,3),(2099,970,3);
UNLOCK TABLES;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `iD` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userRole` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iD`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'admin','admin','ADMIN'),(2,'user','user','USER');
UNLOCK TABLES;