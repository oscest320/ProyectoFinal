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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Movieflix','1','1'),(2,'Java Generatión','2','2'),(3,'We Are Fiber','3','3'),(4,'Neutrales','4','4'),(5,'El Corte Ingés','5','5'),(6,'PwC','6','6'),(7,'Telecinco','7','7'),(8,'Porcelanosa','8','8'),(9,'Santander','9','9');
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
-- Table structure for table `mensajes`
--

DROP TABLE IF EXISTS `mensajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensajes` (
  `idmensaje` int NOT NULL AUTO_INCREMENT,
  `from` varchar(100) DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `mensaje` varchar(512) DEFAULT NULL,
  `respuesta` varchar(512) DEFAULT NULL,
  `respondido` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idmensaje`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensajes`
--

LOCK TABLES `mensajes` WRITE;
/*!40000 ALTER TABLE `mensajes` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensajes` ENABLE KEYS */;
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
  `link` varchar(128) DEFAULT NULL,
  `imagen` varchar(128) DEFAULT NULL,
  `empresa` int DEFAULT NULL,
  PRIMARY KEY (`idproyecto`),
  KEY `cli_fk_clientes` (`empresa`),
  CONSTRAINT `cli_fk_clientes` FOREIGN KEY (`empresa`) REFERENCES `clientes` (`idcliente`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectos`
--

LOCK TABLES `proyectos` WRITE;
/*!40000 ALTER TABLE `proyectos` DISABLE KEYS */;
INSERT INTO `proyectos` VALUES (1,'MOVIEFLIX','22-02-2021','Desarrollo App Multiplataforma de gestión de películas.<a class=\"nav-link\" href=\"/proyectos/movieflix\">Ver más</a>','MovieFlix es un servicio gestor de streaming que ofrece una amplia variedad de películas en miles de dispositivos conectados a internet. Los usuarios podrán ver todo el contenido que quieran y cuando quieran',null,'movieflix',1),(2,'JAVA GENERATION: LANDING PAGE','15-03-2021','Landing page para captación de clientes','',null,'landing',2),(3,'WE ARE FIBER','05-01-2021','Desarrollo y diseño de la nueva página web de la compañía.','Empezamos con el diseño y el desarrollo de la página web, nos dedicamos a la creación e implementación de una estrategia de posicionamiento y reputación del negocio. ¿Qué es lo que hicimos en este sentido? Generar una reputación de marca en el canal online para poder posicionarla en Google para varios idiomas y países, añadir elementos a la web para que fuera más usable y atractiva, por ejemplo, creando contenido e insertar un bot para mejorar el servicio con los clientes.',null,'fiber',3),(4,'NEUTRALES','13-11-2020','Diseño y Desarrollo de la web.','Neutrales inicia su actividad en Barcelona con una nueva identidad corporativa y una página web diseñada y programada por nuestra empresa, para convertirse en referente de la mediación de conflictos en España.  Neutrales es una compañía especializada en la resolución de conflictos (especialmente comerciales y mercantiles) a través de la mediación como alternativa a la vía judicial.',null,'neutrales',4),(5,' EL CORTE INGLÉS ','02-04-2021','Desarrollo App iOS, Android y UWP','Aplicación desarrollada para clientes Business de la compañía. Permite la opción de contratación, seguimiento e información de viajes a empleados.  ',null,'corte',5),(6,'PWC ','24-09-2020','Desarrollo de una App de RRHH  nativa en iOS para facilitar la comunicación entre sus empleados','La aplicación se integra con los sistemas Microsoft del cliente, con el más alto nivel de seguridad, permitiendo la recepción de mensajes push, noticias así como la recepción y lectura de comunicaciones internas. Además, llevamos a cabo un exhaustivo análisis previo de capacidades e integración dentro de sus sistemas.',null,'pwc',6),(7,'TELECINCO ','04-02-2020','Desarrollo App de contenidos multimedia a la carta para iPhone.','Aplicación muy sencilla, útil e intuitiva para el usuario. La estética está totalmente integrada con la imagen corporativa del canal de televisión; además buscamos un aire sofisticado y elegante para acentuar su carácter moderno y actual. La aplicación ofrece la posibilidad de consultar la programación de la cadena, ver los programas que más le interesen al usuario tanto en directo como para descargar y también tiene una tienda a través de la cual se pueden comprar «los productos de la tele».',null,'telecinco',7),(8,'PORCELANOSA','31-08-2020','Desarrollo App de catálogo interactivo de Porcelanosa para iPad.','Es una herramienta concebida tanto para profesionales del mundo de la arquitectura y diseño de interiores, como para usuarios interesados en los productos y materiales del grupo.  La aplicación ha sido desarrollada para hacer de forma interactiva la consulta y elección del mejor material para proyectos de construcción. Navegando a través de todos los productos de una manera intuitiva y consultando todas sus características técnicas y fotos en calidad mejorada.  Una solución móvil de acuerdo a la calidad de sus productos, donde el diseño es tan importante como la usabilidad.',null,'porcelanosa',8),(9,'SANTANDER','10-05-2020','Clásico juego de preguntas y respuestas del mundo del fútbol.','Santander Fútbol Pasión, ganador del \"Guinness World Record\" por el concurso deportivo con mayor participación de la historia.',null,'santander',9);
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

-- Dump completed on 2021-05-19 22:37:01
