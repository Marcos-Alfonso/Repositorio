-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.40-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para ahorcado
CREATE DATABASE IF NOT EXISTS `ahorcado` /*!40100 DEFAULT CHARACTER SET utf16 COLLATE utf16_spanish2_ci */;
USE `ahorcado`;

-- Volcando estructura para tabla ahorcado.palabra
CREATE TABLE IF NOT EXISTS `palabra` (
  `palabra` varchar(50) COLLATE utf16_spanish2_ci NOT NULL,
  `categoria` varchar(50) COLLATE utf16_spanish2_ci NOT NULL,
  PRIMARY KEY (`palabra`,`categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish2_ci;

-- Volcando datos para la tabla ahorcado.palabra: ~6 rows (aproximadamente)
INSERT INTO `palabra` (`palabra`, `categoria`) VALUES
	('BADMINTON', 'DEPORTES'),
	('BALONMANO', 'DEPORTES'),
	('DURAZNO', 'FRUTA'),
	('ERIZO', 'ANIMALES'),
	('FURBO', 'DEPORTES'),
	('MANZANA', 'FRUTA'),
	('MELECOTON', 'FRUTA'),
	('NARANJA', 'FRUTA'),
	('PANTERA', 'ANIMALES'),
	('PERRO', 'ANIMALES'),
	('PLATANO', 'FRUTA'),
	('TENIS', 'DEPORTES');

-- Volcando estructura para tabla ahorcado.partida
CREATE TABLE IF NOT EXISTS `partida` (
  `usuario` varchar(50) COLLATE utf16_spanish2_ci DEFAULT NULL,
  `tiempo` time DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL,
  KEY `usuario` (`usuario`),
  CONSTRAINT `usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish2_ci;

-- Volcando datos para la tabla ahorcado.partida: ~5 rows (aproximadamente)
INSERT INTO `partida` (`usuario`, `tiempo`, `puntos`) VALUES
	('root', '13:03:29', 123),
	('root', '00:00:12', 14),
	('root', '00:00:36', 17),
	('root', '00:00:13', 22);

-- Volcando estructura para tabla ahorcado.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `nombre` varchar(50) COLLATE utf16_spanish2_ci NOT NULL,
  `pass` varchar(50) COLLATE utf16_spanish2_ci NOT NULL,
  `rol` varchar(2) COLLATE utf16_spanish2_ci NOT NULL DEFAULT 'JG',
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish2_ci;

-- Volcando datos para la tabla ahorcado.usuario: ~4 rows (aproximadamente)
INSERT INTO `usuario` (`nombre`, `pass`, `rol`) VALUES
	('antonio', '123', 'AD'),
	('marcos', '123', 'JG'),
	('ree', '213', 'JG'),
	('root', 'root', 'AD');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
