CREATE DATABASE  IF NOT EXISTS `javageneration` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `javageneration`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: javageneration
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargos` (
  `idcargo` int NOT NULL AUTO_INCREMENT,
  `cargo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idcargo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargos`
--

LOCK TABLES `cargos` WRITE;
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` VALUES (1,'CEO'),(2,'Head of Development'),(3,'IT Manager'),(4,'Communications Manager'),(5,'FullStack Developer'),(6,'Master del Universo');
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `logo` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Cliente1','1','1'),(2,'cliente2','2','2'),(3,'cliente3','3','3');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `idpersona` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `resumen` varchar(512) DEFAULT NULL,
  `foto` varchar(128) DEFAULT NULL,
  `idcargo` int DEFAULT NULL,
  PRIMARY KEY (`idpersona`),
  KEY `car_fk_cargos` (`idcargo`),
  CONSTRAINT `car_fk_cargo` FOREIGN KEY (`idcargo`) REFERENCES `cargos` (`idcargo`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (1,'Óscar','Estrada','Fundador de la empresa, una persona ordenada, diligente y muy positiva de cara al futuro. Siempre está animando a su equipo para dar el 100% en cada trabajo. Su paciencia y persistencia ante las dificultades le hacen alguien en quien confiar.','fotos/oscar.png',1),(2,'Usoa','Larrate','Encargada del área de desarrollo, es autodidacta, trabajadora, muy responsable y social. Cuando tenemos un nuevo trabajo ella es la que mejor se adapta para que el producto satisfaga las necesidades del cliente. Una persona fuerte y decidida.','fotos/usoa.png',2),(3,'Noemí','De la Mata','Especialista DevOps. Una persona muy agradable y animada que siempre da el 200% en cada uno de los proyectos. Ordenada, proactiva y siempre preparada para investigar y aprender todo lo necesario para asegurar el éxito de los proyectos.','fotos/noemi.png',3),(4,'Silvia','López','Directora de comunicación de la empresa con varios años de experiencia en diversas consultoras. Puntual, responsable, educada, una fuente de inspiración para los demás trabajadores de la empresa.','fotos/silvia.png',4),(5,'Javier','Jiménez','Experto en Cyberseguridad. Es el programador que a todo equipo le gustaría tener. Polivalente, perseverante y muy positivo que no se rinde ante los problemas y siempre muestra su mejor cara.','fotos/javi.png',5),(6,'Antonio','Santos','Cualquier cosa que pretendas hacer, ÉL ya la ha hecho. Pese a sus 29 años, lleva trabajando en el mundo IT más de 15 y ha colaborado con las mejores empresas del sector. En sus ratos libres es Youtuber.','fotos/antonio.png',6);
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectos`
--

DROP TABLE IF EXISTS `proyectos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyectos` (
  `idproyecto` int NOT NULL AUTO_INCREMENT,
  `proyecto` varchar(45) DEFAULT NULL,
  `fechafin` varchar(45) DEFAULT NULL,
  `resumen` varchar(200) DEFAULT NULL,
  `descripcion` varchar(1024) DEFAULT NULL,
  `imagen` varchar(128) DEFAULT NULL,
  `empresa` int DEFAULT NULL,
  PRIMARY KEY (`idproyecto`),
  KEY `cli_fk_clientes` (`empresa`),
  CONSTRAINT `cli_fk_clientes` FOREIGN KEY (`empresa`) REFERENCES `clientes` (`idcliente`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectos`
--

LOCK TABLES `proyectos` WRITE;
/*!40000 ALTER TABLE `proyectos` DISABLE KEYS */;
INSERT INTO `proyectos` VALUES (1,'proyecto1','1','1','1 JKRGVjvdbñobdOIÑBV´pdnvovpb´WDHGDGÑAOIEOIAH<FEIGÑHSÑAo HITÑAD NFLÄEHOG ÑawiTPLZSDK GHÑOEZIGN<J`P','1',3),(2,'proyecto2','2','2','2','2',2),(3,'proyecto3','3','3','3','3',1);
/*!40000 ALTER TABLE `proyectos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-16 19:39:07
