CREATE DATABASE  IF NOT EXISTS `empresa_a` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `empresa_a`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: empresa_a
-- ------------------------------------------------------
-- Server version	5.5.23

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
-- Table structure for table `producto_a`
--

DROP TABLE IF EXISTS `producto_a`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto_a` (
  `idproductoA` int(15) NOT NULL AUTO_INCREMENT,
  `nombre_productoA` varchar(45) NOT NULL,
  `cantidad_existencias_a` int(15) DEFAULT NULL,
  `longitud_a` decimal(10,2) DEFAULT NULL,
  `diametro_a` decimal(10,2) DEFAULT NULL,
  `precio_a` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idproductoA`)
) ENGINE=InnoDB AUTO_INCREMENT=926 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_a`
--

LOCK TABLES `producto_a` WRITE;
/*!40000 ALTER TABLE `producto_a` DISABLE KEYS */;
INSERT INTO `producto_a` VALUES (906,'ultimo1',10700,11.00,11.00,11.00),(907,'calentito',12,22.00,22.00,22.00),(908,'desde cliente',33,33.00,33.00,33.00),(909,'22ññww',2221,22.00,22.00,22.00),(911,'eeeeeuuuu',33,33.00,33.00,33.00);
/*!40000 ALTER TABLE `producto_a` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_a`
--

DROP TABLE IF EXISTS `usuario_a`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_a` (
  `idusuarios_a` int(15) NOT NULL AUTO_INCREMENT,
  `dni_nif_a` varchar(10) NOT NULL,
  `login_usuario_a` varchar(15) NOT NULL,
  `password_a` varchar(10) NOT NULL,
  `nombre_a` varchar(256) NOT NULL,
  `apellidos_a` varchar(256) DEFAULT NULL,
  `email_a` varchar(256) NOT NULL,
  `AUTHORITY` enum('UNKNOWN','ROLE_CLIENTE','ROLE_ADMIN') DEFAULT 'ROLE_CLIENTE',
  `ENABLED` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idusuarios_a`),
  UNIQUE KEY `login_usuario_a_UNIQUE` (`login_usuario_a`)
) ENGINE=InnoDB AUTO_INCREMENT=180 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_a`
--

LOCK TABLES `usuario_a` WRITE;
/*!40000 ALTER TABLE `usuario_a` DISABLE KEYS */;
INSERT INTO `usuario_a` VALUES (143,'23456789','jefe','jefe','jefon','nofej','jefe@llls.com','ROLE_ADMIN',1),(172,'12121212','vvvv','vvvv','creoUnoVario2','petito','rory133@gmail.com','ROLE_CLIENTE',1),(173,'12345678','eeee','eeee','assdghh','asds','rory133@gmail.com','ROLE_CLIENTE',1),(174,'21234567','jjjj','jjjj','jjjjj','jjjjj','jdjdj@glgl.com','ROLE_ADMIN',1),(175,'12345678','paco','paco','paco','mer','rory133@gmail.com','ROLE_ADMIN',1),(176,'55544433G','maki','maki','maki','navaja','rory133@gmail.com','ROLE_CLIENTE',1),(178,'12345678','ffff','ffff','jjjj','jjj','rory133@gmail.com','ROLE_CLIENTE',1),(179,'12345678','oooo','oooo','desdeOtro','Otro','juan-ma@telefonica.net','ROLE_CLIENTE',1);
/*!40000 ALTER TABLE `usuario_a` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_a`
--

DROP TABLE IF EXISTS `cliente_a`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_a` (
  `idusuarios_a` int(15) NOT NULL,
  `fecha_alta_a` date DEFAULT NULL,
  `direccion_a` varchar(75) DEFAULT NULL,
  `provincia_a` varchar(45) DEFAULT NULL,
  `codigopostal_a` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusuarios_a`),
  KEY `cliente_ibfk_1` (`idusuarios_a`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idusuarios_a`) REFERENCES `usuario_a` (`idusuarios_a`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_a`
--

LOCK TABLES `cliente_a` WRITE;
/*!40000 ALTER TABLE `cliente_a` DISABLE KEYS */;
INSERT INTO `cliente_a` VALUES (172,'2012-10-24','eww','Alava','12345'),(173,'2012-10-24','ssss','Alava','12345'),(176,'2012-10-24','33l2l2ll','Cordoba','12345'),(178,'2012-10-24','sdfsf','Alava','12345'),(179,'2012-10-24','2233','Barcelona','12345');
/*!40000 ALTER TABLE `cliente_a` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_aseleccionado`
--

DROP TABLE IF EXISTS `producto_aseleccionado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto_aseleccionado` (
  `idproductoA` int(15) NOT NULL,
  `idcarro_a` int(15) NOT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `idproductoSeleccionado` int(11) NOT NULL AUTO_INCREMENT,
  `subTotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idproductoSeleccionado`,`idcarro_a`,`idproductoA`),
  KEY `fk_idproductoA` (`idproductoA`),
  KEY `fk_idcarro_a` (`idcarro_a`),
  CONSTRAINT `fk_idproductoA` FOREIGN KEY (`idproductoA`) REFERENCES `producto_a` (`idproductoA`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_idcarro_a` FOREIGN KEY (`idcarro_a`) REFERENCES `carro_a` (`idcarro_a`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_aseleccionado`
--

LOCK TABLES `producto_aseleccionado` WRITE;
/*!40000 ALTER TABLE `producto_aseleccionado` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_aseleccionado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrador_a`
--

DROP TABLE IF EXISTS `administrador_a`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador_a` (
  `idusuarios_a` int(15) NOT NULL,
  `cargo_a` varchar(150) DEFAULT NULL,
  `matricula_a` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusuarios_a`),
  KEY `administrador_ibfk_1` (`idusuarios_a`),
  CONSTRAINT `administrador_a_ibfk_1` FOREIGN KEY (`idusuarios_a`) REFERENCES `usuario_a` (`idusuarios_a`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador_a`
--

LOCK TABLES `administrador_a` WRITE;
/*!40000 ALTER TABLE `administrador_a` DISABLE KEYS */;
INSERT INTO `administrador_a` VALUES (143,'jefe','12334'),(174,'jjjj','jjjjj'),(175,'do','12345');
/*!40000 ALTER TABLE `administrador_a` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carro_a`
--

DROP TABLE IF EXISTS `carro_a`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carro_a` (
  `idcarro_a` int(15) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `pagado` tinyint(1) DEFAULT '0',
  `idcliente` int(15) DEFAULT NULL,
  `enviado` tinyint(1) DEFAULT '0',
  `total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idcarro_a`),
  KEY `id_cliente_FK` (`idcliente`),
  CONSTRAINT `id_cliente_FK` FOREIGN KEY (`idcliente`) REFERENCES `cliente_a` (`idusuarios_a`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro_a`
--

LOCK TABLES `carro_a` WRITE;
/*!40000 ALTER TABLE `carro_a` DISABLE KEYS */;
INSERT INTO `carro_a` VALUES (50,'2012-10-23',0,173,0,-660.00),(51,'2012-10-23',0,173,0,0.00),(53,'2012-10-23',0,173,0,0.00),(54,'2012-10-23',0,173,0,0.00),(55,'2012-10-23',0,173,0,0.00),(56,'2012-10-23',0,173,0,0.00),(57,'2012-10-23',0,173,0,0.00),(58,'2012-10-23',0,173,0,0.00),(59,'2012-10-23',0,173,0,33.00),(60,'2012-10-23',0,173,0,0.00),(61,'2012-10-23',0,173,0,0.00),(62,'2012-10-23',0,173,0,33.00),(63,'2012-10-23',0,173,0,495.00);
/*!40000 ALTER TABLE `carro_a` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-24 12:42:57
