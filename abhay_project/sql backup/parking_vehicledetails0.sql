-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: parking
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `vehicledetails`
--

DROP TABLE IF EXISTS `vehicledetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicledetails` (
  `parkingid` int NOT NULL AUTO_INCREMENT,
  `checkinstaffid` varchar(45) NOT NULL,
  `tokenid` int NOT NULL,
  `vehicletype` varchar(45) NOT NULL,
  `vehiclenumber` varchar(45) NOT NULL,
  `indate` date NOT NULL,
  `intime` time NOT NULL,
  `checkoutstaffid` varchar(45) DEFAULT NULL,
  `outdate` date DEFAULT NULL,
  `outtime` time DEFAULT NULL,
  `charge` int DEFAULT NULL,
  `time` varchar(15) DEFAULT NULL,
  `status` varchar(45) DEFAULT 'checkin',
  PRIMARY KEY (`parkingid`)
) ENGINE=InnoDB AUTO_INCREMENT=100020 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicledetails`
--

LOCK TABLES `vehicledetails` WRITE;
/*!40000 ALTER TABLE `vehicledetails` DISABLE KEYS */;
INSERT INTO `vehicledetails` VALUES (100001,'1002',1,'bike','teg45','2020-07-10','20:50:49','1003','2020-07-12','01:52:35',110,'1d : 6','checkout'),(100002,'1002',2,'bike','up32 hf 6812','2020-07-11','03:44:23','1003','2020-07-12','02:12:50',80,'0d : 23','checkout'),(100003,'1002',3,'car','b78g99','2020-07-12','04:40:01','1003','2020-07-12','04:56:49',10,'0d : 00','checkout'),(100004,'1002',2,'bike','se576','2020-07-12','07:11:03','1003','2020-07-12','07:11:31',5,'0d : 00','checkout'),(100005,'1002',3,'scooty','up42se1004','2020-07-11','21:00:42','1003','2020-07-12','08:49:12',90,'0d : 12','checkout'),(100006,'1002',100,'car','up41es0000','2020-07-08','23:00:00','1003','2020-07-16','17:31:58',890,'8d : 19','checkout'),(100007,'1002',4,'bike',' bx','2020-07-12','08:01:25','1003','2020-07-14','13:44:09',125,'2d : 05','checkout'),(100008,'1002',57,'bike','eb23ef2323','2020-07-12','17:20:06','1003','2020-07-12','17:21:57',5,'0d : 00','checkout'),(100009,'1002',82,'scooty','up32hf1668','2020-07-12','17:44:52','1003','2020-07-12','17:46:34',5,'0d : 00','checkout'),(100010,'1002',50,'bike','up32fg3498','2020-07-14','13:42:37','1003','2020-07-14','13:43:26',5,'0d : 00','checkout'),(100011,'1002',1,'scooty','y79y','2020-07-14','14:55:50',NULL,NULL,NULL,NULL,NULL,'checkin'),(100012,'1002',2,'bike','83j2l2','2020-07-16','11:43:43',NULL,NULL,NULL,NULL,NULL,'checkin'),(100013,'1002',3,'car','weij2;m2','2020-07-16','11:43:43','1003','2020-07-16','15:31:43',30,'0d : 03','checkout'),(100014,'1002',4,'scooty','y3uj2322','2020-07-16','11:43:43','1003','2020-07-16','11:45:00',5,'0d : 00','checkout'),(100015,'1002',4,'car','ad86bb7677','2020-07-16','15:30:51','1003','2020-07-16','17:31:15',20,'0d : 02','checkout'),(100016,'1002',3,'bike','ftuf768','2020-07-16','17:26:53',NULL,NULL,NULL,NULL,NULL,'checkin'),(100017,'1002',5,'bike','vht798','2020-07-16','17:26:53','1003','2020-07-16','17:31:28',5,'0d : 00','checkout'),(100018,'1006',4,'car','ghb89','2020-07-16','17:36:52','1003','2020-07-17','12:45:45',100,'1d : 20','checkout'),(100019,'1002',5,'bike','up41fe4321','2020-07-17','12:44:52','1003','2020-07-17','12:45:39',5,'0d : 00','checkout');
/*!40000 ALTER TABLE `vehicledetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-20 15:36:22
