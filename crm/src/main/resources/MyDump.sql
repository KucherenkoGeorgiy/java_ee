CREATE DATABASE  IF NOT EXISTS `schema_orders`;
USE `schema_orders`;

DROP TABLE IF EXISTS `order_product`;

CREATE TABLE `order_product` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `product_id_idx` (`product_id`),
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `order_product` WRITE;
INSERT INTO `order_product` VALUES (3,3,1),(4,2,2),(6,4,2),(21,2,100),(22,2,100),(24,2,100),(25,2,200),(30,2,3),(32,4,5),(33,2,6),(34,2,1),(39,2,500),(40,2,1000),(41,2,2000),(42,2,4000),(43,2,8000),(46,1,10),(47,1,10),(48,2,1),(49,2,2),(56,2,8),(57,2,12),(58,2,24),(76,1,6),(77,1,10),(79,1,3),(80,1,3),(81,1,3),(82,1,3),(83,1,3),(84,1,3),(85,1,3),(86,1,3),(88,1,3),(89,1,6),(91,1,12);
UNLOCK TABLES;

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `orders` WRITE;

INSERT INTO `orders` VALUES (3,'2022-09-17'),(4,'2022-08-30'),(6,'2022-09-23'),(10,'2022-09-23'),(14,'2022-09-24'),(21,'2022-09-28'),(22,'2022-09-28'),(24,'2022-09-28'),(25,'2022-09-28'),(30,'2022-09-30'),(32,'2022-10-02'),(33,'2022-10-03'),(34,'2022-10-04'),(39,'2022-09-28'),(40,'2022-09-28'),(41,'2022-09-28'),(42,'2022-09-28'),(43,'2022-09-28'),(46,'2022-10-02'),(47,'2022-10-03'),(48,'2022-10-04'),(49,'2022-10-04'),(56,'2022-10-04'),(57,'2022-10-04'),(58,'2022-10-04'),(76,'2022-10-06'),(77,'2022-10-06'),(79,'2022-10-07'),(80,'2022-10-08'),(81,'2022-10-09'),(82,'2022-10-10'),(83,'2022-10-11'),(84,'2022-10-12'),(85,'2022-10-13'),(86,'2022-10-14'),(88,'2022-10-14'),(89,'2022-10-14'),(91,'2022-10-14');

UNLOCK TABLES;

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `describing` varchar(255) NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `product_name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `product` WRITE;

INSERT INTO `product` VALUES (1,'Cola','cold drink Coca-Cola',2),(2,'Fanta','cold drink Fanta',3),(3,'Sprite','cold drink Sprite',4),(4,'Vodka','Absolute',9);

UNLOCK TABLES;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `user` WRITE;

INSERT INTO `user` VALUES (1,'admin-user','12345','ADMIN'),(2,'regular-user','12345','USER');

UNLOCK TABLES;