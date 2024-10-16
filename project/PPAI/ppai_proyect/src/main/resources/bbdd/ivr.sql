CREATE DATABASE  IF NOT EXISTS `ivr` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ivr`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: ivr
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
-- Table structure for table `acciones`
--

DROP TABLE IF EXISTS `acciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acciones` (
  `id_accion` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `descripcion` longtext COMMENT 'TRIAL',
  PRIMARY KEY (`id_accion`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acciones`
--

LOCK TABLES `acciones` WRITE;
/*!40000 ALTER TABLE `acciones` DISABLE KEYS */;
INSERT INTO `acciones` VALUES (1,'estafa priamidal'),(2,'vender su tarjeta'),(3,'matar'),(4,'comprar'),(5,'llamar a dios'),(6,'safasdfasdfasdf');
/*!40000 ALTER TABLE `acciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cambios_estado`
--

DROP TABLE IF EXISTS `cambios_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cambios_estado` (
  `id_cambio_estado` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `fecha_hora_inicio` longtext COMMENT 'TRIAL',
  `id_estado` int DEFAULT NULL COMMENT 'TRIAL',
  `id_llamada` int DEFAULT NULL COMMENT 'TRIAL',
  PRIMARY KEY (`id_cambio_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cambios_estado`
--

LOCK TABLES `cambios_estado` WRITE;
/*!40000 ALTER TABLE `cambios_estado` DISABLE KEYS */;
INSERT INTO `cambios_estado` VALUES (1,'2023-15-12T15:15:15',1,1),(4,'2023-14-12T15:15:15',1,2),(5,'2023-14-12T15:15:15',1,3),(6,'2023-14-12T15:15:15',1,4),(7,'2023-14-12T15:15:15',1,5),(8,'2023-14-12T15:15:15',1,6),(9,'2023-14-12T15:15:15',1,7),(10,'2023-14-12T15:15:15',1,8),(11,'2023-14-12T15:15:15',1,9),(12,'2023-14-12T15:15:15',1,10),(13,'2023-14-12T15:15:15',1,11),(111,'2023-11-18T17:39:55',2,6),(152,'2023-11-18T21:34:33',2,7),(153,'2023-11-18T21:34:56',3,7);
/*!40000 ALTER TABLE `cambios_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias_llamada`
--

DROP TABLE IF EXISTS `categorias_llamada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias_llamada` (
  `id_categoria_llamada` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `audio_mensaje_opciones` longtext COMMENT 'TRIAL',
  `mensaje_opciones` longtext COMMENT 'TRIAL',
  `nombre` longtext COMMENT 'TRIAL',
  `nro_orden` int DEFAULT NULL COMMENT 'TRIAL',
  PRIMARY KEY (`id_categoria_llamada`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias_llamada`
--

LOCK TABLES `categorias_llamada` WRITE;
/*!40000 ALTER TABLE `categorias_llamada` DISABLE KEYS */;
INSERT INTO `categorias_llamada` VALUES (1,'categoria 1','aaaaaaaaaa','denuncia',1),(2,'categoria 2','aaaaaaaaaa','solicitud',2),(6,'categoria 3','aaaaaaaaaa','informacion',3);
/*!40000 ALTER TABLE `categorias_llamada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `dni` int NOT NULL COMMENT 'TRIAL',
  `nombre_completo` longtext COMMENT 'TRIAL',
  `nro_celular` longtext COMMENT 'TRIAL',
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (464646,'Martin Palermo','123456'),(2248697,'Roman Riquelme','548798');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encuestas`
--

DROP TABLE IF EXISTS `encuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `encuestas` (
  `id_encuesta` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `descripcion` longtext COMMENT 'TRIAL',
  `fecha_fin_vigencia` longtext COMMENT 'TRIAL',
  PRIMARY KEY (`id_encuesta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encuestas`
--

LOCK TABLES `encuestas` WRITE;
/*!40000 ALTER TABLE `encuestas` DISABLE KEYS */;
/*!40000 ALTER TABLE `encuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estados` (
  `id_estado` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `nombre` longtext COMMENT 'TRIAL',
  `entity_type` longtext COMMENT 'TRIAL',
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'iniciada','INICIADA'),(2,'en curso','EN_CURSO'),(3,'finalizada','FINALIZADA'),(4,'cancelada','CANCELADA');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informaciones_cliente`
--

DROP TABLE IF EXISTS `informaciones_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informaciones_cliente` (
  `id_informacion_cliente` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `dato_a_validar` longtext COMMENT 'TRIAL',
  `id_tipo_informacion` int DEFAULT NULL COMMENT 'TRIAL',
  `id_validacion` int DEFAULT NULL COMMENT 'TRIAL',
  `id_cliente` int DEFAULT NULL COMMENT 'TRIAL',
  `id_opcion_correcta` int DEFAULT NULL COMMENT 'TRIAL',
  PRIMARY KEY (`id_informacion_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informaciones_cliente`
--

LOCK TABLES `informaciones_cliente` WRITE;
/*!40000 ALTER TABLE `informaciones_cliente` DISABLE KEYS */;
INSERT INTO `informaciones_cliente` VALUES (1,'fecha de nacimiento',5,4,2248697,12),(2,'cantidad de hijos',1,1,2248697,4),(3,'cantidad de hermanos',2,3,2248697,19),(4,'nombre de su perro',3,5,2248697,16),(5,'Universidad en la que estudio',4,2,464646,6),(6,'fecha en que se caso',6,6,464646,22),(7,'nombre de su primer hijo',7,7,464646,27),(8,'fulbo',8,8,464646,29);
/*!40000 ALTER TABLE `informaciones_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `llamadas`
--

DROP TABLE IF EXISTS `llamadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `llamadas` (
  `id_llamada` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `descripcion_operador` longtext COMMENT 'TRIAL',
  `detalle_accion_requerida` longtext COMMENT 'TRIAL',
  `duracion` float DEFAULT NULL COMMENT 'TRIAL',
  `encuesta_enviada` int DEFAULT NULL COMMENT 'TRIAL',
  `observacion_auditor` longtext COMMENT 'TRIAL',
  `id_operador` int DEFAULT NULL COMMENT 'TRIAL',
  `id_auditor` int DEFAULT NULL COMMENT 'TRIAL',
  `id_opcion_seleccionada` int DEFAULT NULL COMMENT 'TRIAL',
  `id_sub_opcion_seleccionada` int DEFAULT NULL COMMENT 'TRIAL',
  `id_respuesta_de_encuesta` int DEFAULT NULL COMMENT 'TRIAL',
  `dni_cliente` int DEFAULT NULL COMMENT 'TRIAL',
  `id_accion_requerida` int DEFAULT NULL COMMENT 'TRIAL',
  PRIMARY KEY (`id_llamada`),
  KEY `llamadas_acciones_id_accion_fk` (`id_accion_requerida`),
  KEY `llamadas_ususarios_id_usuario_fk` (`id_operador`),
  KEY `llamadas_ususarios_id_usuario_fk2` (`id_auditor`),
  KEY `llamadas_opciones_llamada_id_opcion_llamada_fk` (`id_opcion_seleccionada`),
  KEY `llamadas_subopciones_llamada_id_sub_opcion_llamada_fk` (`id_sub_opcion_seleccionada`),
  KEY `llamadas_respuestas_de_clientes_id_respuesta_de_cliente_fk` (`id_respuesta_de_encuesta`),
  KEY `llamadas_clientes_dni_fk` (`dni_cliente`),
  CONSTRAINT `llamadas_acciones_id_accion_fk` FOREIGN KEY (`id_accion_requerida`) REFERENCES `acciones` (`id_accion`),
  CONSTRAINT `llamadas_clientes_dni_fk` FOREIGN KEY (`dni_cliente`) REFERENCES `clientes` (`dni`),
  CONSTRAINT `llamadas_opciones_llamada_id_opcion_llamada_fk` FOREIGN KEY (`id_opcion_seleccionada`) REFERENCES `opciones_llamada` (`id_opcion_llamada`),
  CONSTRAINT `llamadas_respuestas_de_clientes_id_respuesta_de_cliente_fk` FOREIGN KEY (`id_respuesta_de_encuesta`) REFERENCES `respuestas_de_clientes` (`id_respuesta_de_cliente`),
  CONSTRAINT `llamadas_subopciones_llamada_id_sub_opcion_llamada_fk` FOREIGN KEY (`id_sub_opcion_seleccionada`) REFERENCES `subopciones_llamada` (`id_sub_opcion_llamada`),
  CONSTRAINT `llamadas_ususarios_id_usuario_fk` FOREIGN KEY (`id_operador`) REFERENCES `ususarios` (`id_usuario`),
  CONSTRAINT `llamadas_ususarios_id_usuario_fk2` FOREIGN KEY (`id_auditor`) REFERENCES `ususarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `llamadas`
--

LOCK TABLES `llamadas` WRITE;
/*!40000 ALTER TABLE `llamadas` DISABLE KEYS */;
INSERT INTO `llamadas` VALUES (2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,464646,NULL),(3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,464646,NULL),(7,'\"avion\"',NULL,23,NULL,NULL,NULL,NULL,NULL,6,NULL,2248697,2),(8,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2248697,NULL),(11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,464646,NULL);
/*!40000 ALTER TABLE `llamadas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opciones_llamada`
--

DROP TABLE IF EXISTS `opciones_llamada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opciones_llamada` (
  `id_opcion_llamada` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `audio_mensaje_sub_opcion_llamada` longtext COMMENT 'TRIAL',
  `mesaje_subopciones` longtext COMMENT 'TRIAL',
  `nombre` longtext COMMENT 'TRIAL',
  `nro_orden` int DEFAULT NULL COMMENT 'TRIAL',
  `id_categoria` int DEFAULT NULL COMMENT 'TRIAL',
  PRIMARY KEY (`id_opcion_llamada`),
  KEY `opciones_llamada_categorias_llamada_id_categoria_llamada_fk` (`id_categoria`),
  CONSTRAINT `opciones_llamada_categorias_llamada_id_categoria_llamada_fk` FOREIGN KEY (`id_categoria`) REFERENCES `categorias_llamada` (`id_categoria_llamada`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opciones_llamada`
--

LOCK TABLES `opciones_llamada` WRITE;
/*!40000 ALTER TABLE `opciones_llamada` DISABLE KEYS */;
INSERT INTO `opciones_llamada` VALUES (1,NULL,'denunciar robo','denunciar robo',1,1),(2,NULL,'informacion del servicio','informacion del servicio',2,6),(3,NULL,'solicitud nueva tarjeta','solicitud nueva tarjeta',3,2),(4,NULL,'solicitud baja tarjeta','solicitud baja tarjeta',4,2);
/*!40000 ALTER TABLE `opciones_llamada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opciones_validacion`
--

DROP TABLE IF EXISTS `opciones_validacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opciones_validacion` (
  `id_opciones_validacion` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `correcta` int DEFAULT NULL COMMENT 'TRIAL',
  `descripcion` longtext COMMENT 'TRIAL',
  `id_validacion` int DEFAULT NULL COMMENT 'TRIAL',
  PRIMARY KEY (`id_opciones_validacion`),
  KEY `opciones_validacion_validaciones_id_validacion_fk` (`id_validacion`),
  CONSTRAINT `opciones_validacion_validaciones_id_validacion_fk` FOREIGN KEY (`id_validacion`) REFERENCES `validaciones` (`id_validacion`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opciones_validacion`
--

LOCK TABLES `opciones_validacion` WRITE;
/*!40000 ALTER TABLE `opciones_validacion` DISABLE KEYS */;
INSERT INTO `opciones_validacion` VALUES (1,0,'5',1),(2,0,'3',1),(3,0,'2',1),(4,1,'1',1),(5,0,'4',1),(6,1,'UTN',2),(7,0,'UNC',2),(8,0,'CATOLICA',2),(9,0,'FMAF',2),(10,0,'11/4/12',4),(11,0,'3/8/92',4),(12,1,'9/9/99',4),(13,0,'14/12/20',4),(14,0,'manchas',5),(15,0,'cacao',5),(16,1,'terminator 3000',5),(17,0,'mi bebe precioso',5),(18,0,'1',3),(19,1,'0',3),(20,0,'2',3),(21,0,'3',3),(22,1,'12/10/2002',6),(23,0,'15/02/2001',6),(24,0,'09/11/2000',6),(25,0,'Fernando',7),(26,0,'Luis',7),(27,1,'River Plate',7),(28,0,'Fabian',7),(29,1,'Real Madrid',8),(30,0,'Milan',8),(31,0,'Barcelona',8);
/*!40000 ALTER TABLE `opciones_validacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfieslypermisos`
--

DROP TABLE IF EXISTS `perfieslypermisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfieslypermisos` (
  `id_permiso` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `id_perfil` int NOT NULL COMMENT 'TRIAL',
  PRIMARY KEY (`id_permiso`,`id_perfil`),
  KEY `perfieslypermisos_perfiles_id_perfil_fk` (`id_perfil`),
  CONSTRAINT `perfieslypermisos_perfiles_id_perfil_fk` FOREIGN KEY (`id_perfil`) REFERENCES `perfiles` (`id_perfil`),
  CONSTRAINT `perfieslypermisos_permisos_id_permiso_fk` FOREIGN KEY (`id_permiso`) REFERENCES `permisos` (`id_permiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfieslypermisos`
--

LOCK TABLES `perfieslypermisos` WRITE;
/*!40000 ALTER TABLE `perfieslypermisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfieslypermisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfiles` (
  `id_perfil` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `descripcion` longtext COMMENT 'TRIAL',
  `nombre` longtext COMMENT 'TRIAL',
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfiles`
--

LOCK TABLES `perfiles` WRITE;
/*!40000 ALTER TABLE `perfiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permisos` (
  `id_permiso` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `descripcion` longtext COMMENT 'TRIAL',
  `nombre` longtext COMMENT 'TRIAL',
  PRIMARY KEY (`id_permiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preguntas` (
  `id_preguntas` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `pregunta` longtext COMMENT 'TRIAL',
  PRIMARY KEY (`id_preguntas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntas`
--

LOCK TABLES `preguntas` WRITE;
/*!40000 ALTER TABLE `preguntas` DISABLE KEYS */;
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preguntasyencuestas`
--

DROP TABLE IF EXISTS `preguntasyencuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preguntasyencuestas` (
  `id_encuesta` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `id_pregunta` int NOT NULL COMMENT 'TRIAL',
  PRIMARY KEY (`id_encuesta`,`id_pregunta`),
  KEY `preguntasyencuestas_preguntas_id_preguntas_fk` (`id_pregunta`),
  CONSTRAINT `preguntasyencuestas_encuestas_id_encuesta_fk` FOREIGN KEY (`id_encuesta`) REFERENCES `encuestas` (`id_encuesta`),
  CONSTRAINT `preguntasyencuestas_preguntas_id_preguntas_fk` FOREIGN KEY (`id_pregunta`) REFERENCES `preguntas` (`id_preguntas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntasyencuestas`
--

LOCK TABLES `preguntasyencuestas` WRITE;
/*!40000 ALTER TABLE `preguntasyencuestas` DISABLE KEYS */;
/*!40000 ALTER TABLE `preguntasyencuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestas_de_clientes`
--

DROP TABLE IF EXISTS `respuestas_de_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respuestas_de_clientes` (
  `id_respuesta_de_cliente` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `fecha_encuesta` longtext COMMENT 'TRIAL',
  `id_respuesta_seleccionada` int DEFAULT NULL COMMENT 'TRIAL',
  PRIMARY KEY (`id_respuesta_de_cliente`),
  KEY `respuestas_de_clientes_respuestas_posibles_i_fk` (`id_respuesta_seleccionada`),
  CONSTRAINT `respuestas_de_clientes_respuestas_posibles_i_fk` FOREIGN KEY (`id_respuesta_seleccionada`) REFERENCES `respuestas_posibles` (`id_respuesta_posible`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestas_de_clientes`
--

LOCK TABLES `respuestas_de_clientes` WRITE;
/*!40000 ALTER TABLE `respuestas_de_clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuestas_de_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestas_posibles`
--

DROP TABLE IF EXISTS `respuestas_posibles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respuestas_posibles` (
  `id_respuesta_posible` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `descripcion` longtext COMMENT 'TRIAL',
  `valor` int DEFAULT NULL COMMENT 'TRIAL',
  `id_pregunta` int DEFAULT NULL,
  PRIMARY KEY (`id_respuesta_posible`),
  KEY `respuestas_posibles_preguntas_id_preguntas_fk` (`id_pregunta`),
  CONSTRAINT `respuestas_posibles_preguntas_id_preguntas_fk` FOREIGN KEY (`id_pregunta`) REFERENCES `preguntas` (`id_preguntas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestas_posibles`
--

LOCK TABLES `respuestas_posibles` WRITE;
/*!40000 ALTER TABLE `respuestas_posibles` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuestas_posibles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sqlite_sequence`
--

DROP TABLE IF EXISTS `sqlite_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sqlite_sequence` (
  `name` longtext COMMENT 'TRIAL',
  `seq` longtext COMMENT 'TRIAL'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sqlite_sequence`
--

LOCK TABLES `sqlite_sequence` WRITE;
/*!40000 ALTER TABLE `sqlite_sequence` DISABLE KEYS */;
INSERT INTO `sqlite_sequence` VALUES ('CambioEstados','29'),('OpcionesLlamadas','4'),('CategoriasLlamadas','6'),('Acciones','6'),('Estados','23'),('SubOpcionesLlamadas','7'),('Validaciones','8'),('TiposInformacion','8'),('OpcionesValidaciones','31'),('Llamadas','12'),('cambioestados','7'),('InformacionesCliente','8');
/*!40000 ALTER TABLE `sqlite_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subopciones_llamada`
--

DROP TABLE IF EXISTS `subopciones_llamada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subopciones_llamada` (
  `id_sub_opcion_llamada` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `nombre` longtext COMMENT 'TRIAL',
  `nro_orden` int DEFAULT NULL COMMENT 'TRIAL',
  `id_opcion_llamada` int DEFAULT NULL COMMENT 'TRIAL',
  PRIMARY KEY (`id_sub_opcion_llamada`),
  KEY `subopciones_llamada_opciones_llamada_id_opcion_llamada_fk` (`id_opcion_llamada`),
  CONSTRAINT `subopciones_llamada_opciones_llamada_id_opcion_llamada_fk` FOREIGN KEY (`id_opcion_llamada`) REFERENCES `opciones_llamada` (`id_opcion_llamada`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subopciones_llamada`
--

LOCK TABLES `subopciones_llamada` WRITE;
/*!40000 ALTER TABLE `subopciones_llamada` DISABLE KEYS */;
INSERT INTO `subopciones_llamada` VALUES (1,'solicitud nueva tarjeta debito',1,3),(2,'solicitud nueva tarjeta credito',2,3),(4,'solcitud baja tarjeta de credito',3,4),(5,'solicitud baja de tarjeta debito',4,4),(6,'anular tarjeta',5,1),(7,'anular tarjeta',6,1);
/*!40000 ALTER TABLE `subopciones_llamada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_informacion`
--

DROP TABLE IF EXISTS `tipos_informacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_informacion` (
  `id_tipo_informacion` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `descripcion` longtext COMMENT 'TRIAL',
  PRIMARY KEY (`id_tipo_informacion`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_informacion`
--

LOCK TABLES `tipos_informacion` WRITE;
/*!40000 ALTER TABLE `tipos_informacion` DISABLE KEYS */;
INSERT INTO `tipos_informacion` VALUES (1,'cantidad de hijos'),(2,'cantidad de hermanos'),(3,'nombre mascota'),(4,'Estudios universitarios'),(5,'fecha de nacimiento'),(6,'fecha de casamiento'),(7,'nombre hijo'),(8,'fulbo');
/*!40000 ALTER TABLE `tipos_informacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ususarios`
--

DROP TABLE IF EXISTS `ususarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ususarios` (
  `activo` int DEFAULT NULL COMMENT 'TRIAL',
  `password` longtext COMMENT 'TRIAL',
  `nombre_usuario` longtext COMMENT 'TRIAL',
  `perfil` int DEFAULT NULL COMMENT 'TRIAL',
  `id_usuario` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ususarios`
--

LOCK TABLES `ususarios` WRITE;
/*!40000 ALTER TABLE `ususarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `ususarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `validaciones`
--

DROP TABLE IF EXISTS `validaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `validaciones` (
  `id_validacion` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `nombre` longtext COMMENT 'TRIAL',
  `nro_orden` int DEFAULT NULL COMMENT 'TRIAL',
  `id_tipo` int DEFAULT NULL COMMENT 'TRIAL',
  PRIMARY KEY (`id_validacion`),
  KEY `validaciones_tipos_informacion_id_tipo_informacion_fk` (`id_tipo`),
  CONSTRAINT `validaciones_tipos_informacion_id_tipo_informacion_fk` FOREIGN KEY (`id_tipo`) REFERENCES `tipos_informacion` (`id_tipo_informacion`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `validaciones`
--

LOCK TABLES `validaciones` WRITE;
/*!40000 ALTER TABLE `validaciones` DISABLE KEYS */;
INSERT INTO `validaciones` VALUES (1,'cantidad de hijos',1,1),(2,'universidad que estudio',2,4),(3,'cantidad de hermanos',3,2),(4,'fecha nacimiento',4,5),(5,'nombre de su mascota',5,3),(6,'fecha de casamiento',6,6),(7,'nombre del hermano mayor',7,7),(8,'boca campeon 2000',8,8);
/*!40000 ALTER TABLE `validaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `validaciones_opciones`
--

DROP TABLE IF EXISTS `validaciones_opciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `validaciones_opciones` (
  `id_opcion_llamada` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `id_validacion` int NOT NULL COMMENT 'TRIAL',
  PRIMARY KEY (`id_opcion_llamada`,`id_validacion`),
  KEY `validaciones_opciones_validaciones_id_validacion_fk` (`id_validacion`),
  CONSTRAINT `validaciones_opciones_opciones_llamada_id_opcion_llamada_fk` FOREIGN KEY (`id_opcion_llamada`) REFERENCES `opciones_llamada` (`id_opcion_llamada`),
  CONSTRAINT `validaciones_opciones_validaciones_id_validacion_fk` FOREIGN KEY (`id_validacion`) REFERENCES `validaciones` (`id_validacion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `validaciones_opciones`
--

LOCK TABLES `validaciones_opciones` WRITE;
/*!40000 ALTER TABLE `validaciones_opciones` DISABLE KEYS */;
INSERT INTO `validaciones_opciones` VALUES (2,1),(2,2),(2,3),(2,5),(2,7),(2,8);
/*!40000 ALTER TABLE `validaciones_opciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `validaciones_subopciones`
--

DROP TABLE IF EXISTS `validaciones_subopciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `validaciones_subopciones` (
  `id_validacion` int NOT NULL AUTO_INCREMENT COMMENT 'TRIAL',
  `id_sub_opcion_llamada` int NOT NULL COMMENT 'TRIAL',
  PRIMARY KEY (`id_validacion`,`id_sub_opcion_llamada`),
  KEY `validaciones_subopciones_subopciones_llamada_i_fk` (`id_sub_opcion_llamada`),
  CONSTRAINT `validaciones_subopciones_subopciones_llamada_i_fk` FOREIGN KEY (`id_sub_opcion_llamada`) REFERENCES `subopciones_llamada` (`id_sub_opcion_llamada`),
  CONSTRAINT `validaciones_subopciones_validaciones_id_validacion_fk` FOREIGN KEY (`id_validacion`) REFERENCES `validaciones` (`id_validacion`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COMMENT='TRIAL';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `validaciones_subopciones`
--

LOCK TABLES `validaciones_subopciones` WRITE;
/*!40000 ALTER TABLE `validaciones_subopciones` DISABLE KEYS */;
INSERT INTO `validaciones_subopciones` VALUES (1,1),(2,1),(3,1),(4,1),(6,1),(7,1),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(1,4),(2,4),(4,4),(5,4),(7,4),(8,4),(1,5),(2,5),(3,5),(4,5),(7,5),(8,5),(2,6),(3,6),(4,6),(5,6),(6,6),(7,6),(1,7),(2,7),(4,7),(5,7),(6,7),(8,7);
/*!40000 ALTER TABLE `validaciones_subopciones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-19  1:55:55
