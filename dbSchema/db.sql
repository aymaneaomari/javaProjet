CREATE DATABASE  IF NOT EXISTS `systemedegestioneducative` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `systemedegestioneducative`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: systemedegestioneducative
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'aymaneaomariadmin','0000');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departement`
--

DROP TABLE IF EXISTS `departement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departement` (
  `id` int NOT NULL,
  `nom` varchar(20) NOT NULL,
  `chefdep` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `nom` (`nom`),
  KEY `chefdep_fk` (`chefdep`),
  CONSTRAINT `chefdep_fk` FOREIGN KEY (`chefdep`) REFERENCES `ensaignant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departement`
--

LOCK TABLES `departement` WRITE;
/*!40000 ALTER TABLE `departement` DISABLE KEYS */;
INSERT INTO `departement` VALUES (1,'informatique',1),(2,'électrique',2);
/*!40000 ALTER TABLE `departement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ensaignant`
--

DROP TABLE IF EXISTS `ensaignant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ensaignant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Prenom` varchar(20) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `grade` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `email_2` (`email`),
  UNIQUE KEY `email_3` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ensaignant`
--

LOCK TABLES `ensaignant` WRITE;
/*!40000 ALTER TABLE `ensaignant` DISABLE KEYS */;
INSERT INTO `ensaignant` VALUES (1,'ayman','aomari','aomariaymane06@gmail.com',3),(2,'nizar','abdelkarim','nizaeabelkarim@gmail.com',3),(5,'aomari','nisrrine','nissrineaomari@gmail.com',4),(6,'benbahi','ismail','ismailbenbahi@gmail.com',3),(8,'moudnib','Chaymae','chaymaemoudnib@gmail.com',4);
/*!40000 ALTER TABLE `ensaignant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etudiant` (
  `apoge` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `filiere` int NOT NULL,
  PRIMARY KEY (`apoge`),
  UNIQUE KEY `apoge` (`apoge`),
  UNIQUE KEY `email` (`email`),
  KEY `filiere_fk` (`filiere`),
  CONSTRAINT `filiere_fk` FOREIGN KEY (`filiere`) REFERENCES `filiere` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etudiant`
--

LOCK TABLES `etudiant` WRITE;
/*!40000 ALTER TABLE `etudiant` DISABLE KEYS */;
INSERT INTO `etudiant` VALUES (1,'asban','simo','asbansimo@gmail.com',2),(2,'ismail','benba','ismail@gmail.com',3),(3,'imad','zouin','imad@gmail.com',2),(5,'imad','zouin','iamd@gmail.com',1);
/*!40000 ALTER TABLE `etudiant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filiere`
--

DROP TABLE IF EXISTS `filiere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `filiere` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `responsable` int NOT NULL,
  `departement` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `nom` (`nom`),
  KEY `respo_fk` (`responsable`),
  KEY `departement_fk` (`departement`),
  CONSTRAINT `departement_fk` FOREIGN KEY (`departement`) REFERENCES `departement` (`id`),
  CONSTRAINT `respo_fk` FOREIGN KEY (`responsable`) REFERENCES `ensaignant` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filiere`
--

LOCK TABLES `filiere` WRITE;
/*!40000 ALTER TABLE `filiere` DISABLE KEYS */;
INSERT INTO `filiere` VALUES (1,'sitd',1,1),(2,'gesa',2,2),(3,'gi',1,1);
/*!40000 ALTER TABLE `filiere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modules`
--

DROP TABLE IF EXISTS `modules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modules` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(40) NOT NULL,
  `Ensaignant` int NOT NULL,
  `filiere` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `Ensaignant_fk` (`Ensaignant`),
  KEY `filier_fk` (`filiere`),
  CONSTRAINT `Ensaignant_fk` FOREIGN KEY (`Ensaignant`) REFERENCES `ensaignant` (`id`),
  CONSTRAINT `filier_fk` FOREIGN KEY (`filiere`) REFERENCES `filiere` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modules`
--

LOCK TABLES `modules` WRITE;
/*!40000 ALTER TABLE `modules` DISABLE KEYS */;
INSERT INTO `modules` VALUES (1,'java',1,1),(2,'base de donne',1,2);
/*!40000 ALTER TABLE `modules` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-23 20:19:54
