CREATE DATABASE  IF NOT EXISTS `gestionproyectosfotograficos`;
USE `gestionproyectosfotograficos`;


-- Table structure for table `clientes`

CREATE TABLE `clientes` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nombreCliente` varchar(255) NOT NULL,
  `apellidoCliente` varchar(45) NOT NULL,
  `emailCliente` varchar(255) NOT NULL,
  `telefonoCliente` int DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
INSERT INTO `clientes` VALUES (1,'Cliente Uno','','cliente1@example.com',111222333),(2,'Cliente Dos','','cliente2@example.com',444555666),(3,'Cliente Tres','','cliente3@example.com',777888999),(4,'er','','wy',NULL),(5,'pep','','flksdjflkas',123456678),(6,'fdg','sdfg','sdfg',234),(7,'asd','asdasd','asdasdasd',123456),(8,'Emanuel','Torres','manutorres@gmail.com',123454554),(9,'Mateo','Molins','lsdkfjsl',2354279);
UNLOCK TABLES;


-- Table structure for table `fotografos`
CREATE TABLE `fotografos` (
  `idFotografo` int NOT NULL AUTO_INCREMENT,
  `nombreFotografo` varchar(255) NOT NULL,
  `emailFotografo` varchar(255) NOT NULL,
  `telefonoFotografo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idFotografo`)
) ;

-- Dumping data for table `fotografos`
LOCK TABLES `fotografos` WRITE;
INSERT INTO `fotografos` VALUES (1,'Juan Pérez','juan.perez@example.com','123456789'),(2,'María Gómez','maria.gomez@example.com','987654321');
UNLOCK TABLES;

-- Table structure for table `fotos
CREATE TABLE `fotos` (
  `idFoto` int NOT NULL AUTO_INCREMENT,
  `nombreFoto` varchar(255) NOT NULL,
  `fechaCaptura` date DEFAULT NULL,
  `rutaFoto` varchar(255) NOT NULL,
  `proyectoId` int DEFAULT NULL,
  PRIMARY KEY (`idFoto`),
  KEY `proyectoId` (`proyectoId`),
  CONSTRAINT `fotos_ibfk_1` FOREIGN KEY (`proyectoId`) REFERENCES `proyectos` (`idProyecto`)
) ;

-- Dumping data for table `fotos`

LOCK TABLES `fotos` WRITE;
INSERT INTO `fotos` VALUES (1,'foto1_cliente1.jpg','2024-10-01','/ruta/foto1_cliente1.jpg',1),(2,'foto2_cliente1.jpg','2024-10-02','/ruta/foto2_cliente1.jpg',1),(3,'foto3_cliente1.jpg','2024-10-03','/ruta/foto3_cliente1.jpg',1),(4,'foto4_cliente1.jpg','2024-10-04','/ruta/foto4_cliente1.jpg',1),(5,'foto5_cliente1.jpg','2024-10-05','/ruta/foto5_cliente1.jpg',1),(6,'foto6_cliente1.jpg','2024-10-06','/ruta/foto6_cliente1.jpg',1),(7,'foto7_cliente1.jpg','2024-10-07','/ruta/foto7_cliente1.jpg',1),(8,'foto8_cliente1.jpg','2024-10-08','/ruta/foto8_cliente1.jpg',1),(9,'foto9_cliente1.jpg','2024-10-09','/ruta/foto9_cliente1.jpg',1),(10,'foto10_cliente1.jpg','2024-10-10','/ruta/foto10_cliente1.jpg',1),(11,'foto1_cliente2.jpg','2024-10-01','/ruta/foto1_cliente2.jpg',2),(12,'foto2_cliente2.jpg','2024-10-02','/ruta/foto2_cliente2.jpg',2),(13,'foto3_cliente2.jpg','2024-10-03','/ruta/foto3_cliente2.jpg',2),(14,'foto4_cliente2.jpg','2024-10-04','/ruta/foto4_cliente2.jpg',2),(15,'foto5_cliente2.jpg','2024-10-05','/ruta/foto5_cliente2.jpg',2),(16,'foto6_cliente2.jpg','2024-10-06','/ruta/foto6_cliente2.jpg',2),(17,'foto7_cliente2.jpg','2024-10-07','/ruta/foto7_cliente2.jpg',2),(18,'foto8_cliente2.jpg','2024-10-08','/ruta/foto8_cliente2.jpg',2),(19,'foto9_cliente2.jpg','2024-10-09','/ruta/foto9_cliente2.jpg',2),(20,'foto10_cliente2.jpg','2024-10-10','/ruta/foto10_cliente2.jpg',2),(21,'foto1_cliente3.jpg','2024-10-01','/ruta/foto1_cliente3.jpg',3),(22,'foto2_cliente3.jpg','2024-10-02','/ruta/foto2_cliente3.jpg',3),(23,'foto3_cliente3.jpg','2024-10-03','/ruta/foto3_cliente3.jpg',3),(24,'foto4_cliente3.jpg','2024-10-04','/ruta/foto4_cliente3.jpg',3),(25,'foto5_cliente3.jpg','2024-10-05','/ruta/foto5_cliente3.jpg',3),(26,'foto6_cliente3.jpg','2024-10-06','/ruta/foto6_cliente3.jpg',3),(27,'foto7_cliente3.jpg','2024-10-07','/ruta/foto7_cliente3.jpg',3),(28,'foto8_cliente3.jpg','2024-10-08','/ruta/foto8_cliente3.jpg',3),(29,'foto9_cliente3.jpg','2024-10-09','/ruta/foto9_cliente3.jpg',3),(30,'foto10_cliente3.jpg','2024-10-10','/ruta/foto10_cliente3.jpg',3),(31,'Captura de pantalla 2024-11-13 163503.jpg','2024-11-16','D:\\Captura de pantalla 2024-11-13 163503.jpg',9);
UNLOCK TABLES;


-- Table structure for table `prioridades`
CREATE TABLE `prioridades` (
  `idPrioridad` int NOT NULL AUTO_INCREMENT,
  `nivelPrioridad` varchar(50) NOT NULL,
  `descripcionPrioridad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPrioridad`)
);


-- Dumping data for table `prioridades`
--

LOCK TABLES `prioridades` WRITE;
INSERT INTO `prioridades` VALUES (1,'Alta','Prioridad alta para proyectos urgentes'),(2,'Media','Prioridad media para proyectos estándar'),(3,'Baja','Prioridad baja para proyectos a largo plazo');
UNLOCK TABLES;

--
-- Table structure for table `proyectos`
CREATE TABLE `proyectos` (
  `idProyecto` int NOT NULL AUTO_INCREMENT,
  `nombreProyecto` varchar(255) NOT NULL,
  `descripcion` text,
  `fechaInicio` date DEFAULT NULL,
  `fechaEntrega` date DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `clienteId` int DEFAULT NULL,
  `prioridadId` int DEFAULT NULL,
  PRIMARY KEY (`idProyecto`),
  KEY `clienteId` (`clienteId`),
  KEY `prioridadId` (`prioridadId`),
  CONSTRAINT `proyectos_ibfk_1` FOREIGN KEY (`clienteId`) REFERENCES `clientes` (`idCliente`),
  CONSTRAINT `proyectos_ibfk_2` FOREIGN KEY (`prioridadId`) REFERENCES `prioridades` (`idPrioridad`)
) ;

--
-- Dumping data for table `proyectos`
--

LOCK TABLES `proyectos` WRITE;
INSERT INTO `proyectos` VALUES (1,'Proyecto A','Descripción del Proyecto A','2024-10-01','2024-10-31',NULL,1,1),(2,'Proyecto B','Descripción del Proyecto B','2024-10-02','2024-11-01',NULL,2,2),(3,'Proyecto C','Descripción del Proyecto C','2024-10-03','2024-11-02',NULL,3,3),(4,'bigua','No iniciado','2024-11-30','2024-12-30',NULL,8,2),(8,'sdfas','sdfasdf','2024-10-28','2024-11-30','No iniciado',8,1),(9,'foto mate','dsjfhlskd','2024-10-31','2024-11-30','No iniciado',9,2),(10,'pacifico','juego 1 pacifico vs espanol','2024-10-30','2024-11-30','En proceso',8,2);
UNLOCK TABLES;

--
-- Table structure for table `proyectosfotografos`
CREATE TABLE `proyectosfotografos` (
  `proyectoId` int NOT NULL,
  `fotografoId` int NOT NULL,
  PRIMARY KEY (`proyectoId`,`fotografoId`),
  KEY `fotografoId` (`fotografoId`),
  CONSTRAINT `proyectosfotografos_ibfk_1` FOREIGN KEY (`proyectoId`) REFERENCES `proyectos` (`idProyecto`),
  CONSTRAINT `proyectosfotografos_ibfk_2` FOREIGN KEY (`fotografoId`) REFERENCES `fotografos` (`idFotografo`)
) ;

--
-- Dumping data for table `proyectosfotografos`

LOCK TABLES `proyectosfotografos` WRITE;
INSERT INTO `proyectosfotografos` VALUES (1,1),(3,1),(2,2);
UNLOCK TABLES;

