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
-- Table structure for table `tokenid`
--

DROP TABLE IF EXISTS `tokenid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tokenid` (
  `idtokenid` int NOT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'checkin',
  PRIMARY KEY (`idtokenid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokenid`
--

LOCK TABLES `tokenid` WRITE;
/*!40000 ALTER TABLE `tokenid` DISABLE KEYS */;
INSERT INTO `tokenid` VALUES (1,'checkin'),(2,'checkin'),(3,'checkin'),(4,'checkout'),(5,'checkout'),(6,'checkout'),(7,'checkout'),(8,'checkout'),(9,'checkout'),(10,'checkout'),(11,'checkout'),(12,'checkout'),(13,'checkout'),(14,'checkout'),(15,'checkout'),(16,'checkout'),(17,'checkout'),(18,'checkout'),(19,'checkout'),(20,'checkout'),(21,'checkout'),(22,'checkout'),(23,'checkout'),(24,'checkout'),(25,'checkout'),(26,'checkout'),(27,'checkout'),(28,'checkout'),(29,'checkout'),(30,'checkout'),(31,'checkout'),(32,'checkout'),(33,'checkout'),(34,'checkout'),(35,'checkout'),(36,'checkout'),(37,'checkout'),(38,'checkout'),(39,'checkout'),(40,'checkout'),(41,'checkout'),(42,'checkout'),(43,'checkout'),(44,'checkout'),(45,'checkout'),(46,'checkout'),(47,'checkout'),(48,'checkout'),(49,'checkout'),(50,'checkout'),(51,'checkout'),(52,'checkout'),(53,'checkout'),(54,'checkout'),(55,'checkout'),(56,'checkout'),(57,'checkout'),(58,'checkout'),(59,'checkout'),(60,'checkout'),(61,'checkout'),(62,'checkout'),(63,'checkout'),(64,'checkout'),(65,'checkout'),(66,'checkout'),(67,'checkout'),(68,'checkout'),(69,'checkout'),(70,'checkout'),(71,'checkout'),(72,'checkout'),(73,'checkout'),(74,'checkout'),(75,'checkout'),(76,'checkout'),(77,'checkout'),(78,'checkout'),(79,'checkout'),(80,'checkout'),(81,'checkout'),(82,'checkout'),(83,'checkout'),(84,'checkout'),(85,'checkout'),(86,'checkout'),(87,'checkout'),(88,'checkout'),(89,'checkout'),(90,'checkout'),(91,'checkout'),(92,'checkout'),(93,'checkout'),(94,'checkout'),(95,'checkout'),(96,'checkout'),(97,'checkout'),(98,'checkout'),(99,'checkout'),(100,'checkout');
/*!40000 ALTER TABLE `tokenid` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-20 15:36:21
