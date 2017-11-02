-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hostel
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `idrooms` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `idowner` smallint(6) unsigned DEFAULT NULL,
  `number` smallint(6) unsigned NOT NULL,
  `animal_type` enum('DOG','CAT','HAMSTER','TURTLE','SNAKE') NOT NULL,
  `date_beg` date DEFAULT NULL,
  `date_end` date DEFAULT NULL,
  `cost` smallint(6) unsigned NOT NULL,
  PRIMARY KEY (`idrooms`),
  UNIQUE KEY `number_UNIQUE` (`number`),
  UNIQUE KEY `idrooms_UNIQUE` (`idrooms`),
  KEY `fk_idguest_idx` (`idowner`),
  CONSTRAINT `fk_idowner` FOREIGN KEY (`idowner`) REFERENCES `owner` (`idowner`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (14,NULL,1,'DOG',NULL,NULL,100),(15,NULL,2,'CAT',NULL,NULL,100),(16,NULL,3,'DOG',NULL,NULL,200),(17,NULL,5,'DOG','2017-09-15','2017-09-14',100),(18,NULL,6,'DOG',NULL,NULL,150),(19,NULL,4,'DOG','2016-12-21','2016-12-25',170),(20,NULL,7,'HAMSTER',NULL,NULL,150);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-02 19:12:30
