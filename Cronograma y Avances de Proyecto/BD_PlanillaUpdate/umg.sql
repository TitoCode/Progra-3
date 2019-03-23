-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-03-2019 a las 08:44:02
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `umg`
--
CREATE DATABASE IF NOT EXISTS `umg` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `umg`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto`
--

DROP TABLE IF EXISTS `concepto`;
CREATE TABLE IF NOT EXISTS `concepto` (
  `codigo_concepto` varchar(20) NOT NULL,
  `nombre_concepto` varchar(60) DEFAULT NULL,
  `Valor_concepto` float(10,5) NOT NULL,
  `efecto_concepto` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`codigo_concepto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `concepto`
--

INSERT INTO `concepto` (`codigo_concepto`, `nombre_concepto`, `Valor_concepto`, `efecto_concepto`) VALUES
('C1', 'IGSS', 0.04830, 'Deducción'),
('C2', 'Ninguno', 0.00000, 'Neutro'),
('C3', 'ISR 3%', 0.03000, 'Deducción'),
('C4', 'ISR 5%', 0.05000, 'Deducción'),
('C5', 'ISR 10%', 0.10000, 'Deducción');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE IF NOT EXISTS `departamento` (
  `codigo_departamento` varchar(10) NOT NULL,
  `nombre_departamento` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`codigo_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`codigo_departamento`, `nombre_departamento`) VALUES
('D1', 'Proyectos'),
('D2', 'Informatica'),
('D3', 'Capacitación y Desarrollo'),
('D4', 'Reclutamiento y Selección'),
('D5', 'Nominas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_nomina`
--

DROP TABLE IF EXISTS `detalle_nomina`;
CREATE TABLE IF NOT EXISTS `detalle_nomina` (
  `codigo_nomina` varchar(20) NOT NULL,
  `codigo_empleado` varchar(10) NOT NULL,
  `codigo_concepto` varchar(20) NOT NULL,
  `valor_nominadetalle` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`codigo_nomina`,`codigo_empleado`,`codigo_concepto`),
  KEY `FK_empleadodetallenomina` (`codigo_empleado`),
  KEY `FK_codigoconceptodetallenomina` (`codigo_concepto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detalle_nomina`
--

INSERT INTO `detalle_nomina` (`codigo_nomina`, `codigo_empleado`, `codigo_concepto`, `valor_nominadetalle`) VALUES
('Nomina2018', 'Emp1', 'C1', 15000.00),
('Nomina2018', 'Emp1', 'C3', 1200.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `codigo_empleado` varchar(10) NOT NULL,
  `nombre_empleado` varchar(60) NOT NULL,
  `sueldo_empleado` float DEFAULT NULL,
  `IGSS` tinyint(1) NOT NULL,
  `codigo_puesto` varchar(10) NOT NULL,
  `codigo_departamento` varchar(10) NOT NULL,
  PRIMARY KEY (`codigo_empleado`),
  KEY `FK_puestoempleado` (`codigo_puesto`),
  KEY `FK_departamentoempleado` (`codigo_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`codigo_empleado`, `nombre_empleado`, `sueldo_empleado`, `IGSS`, `codigo_puesto`, `codigo_departamento`) VALUES
('Emp1', 'Carlos Rodas', 5000, 0, 'P1', 'D1'),
('Emp2', 'Manuel García', 88000, 1, 'P3', 'D2'),
('Emp3', 'Sthefany Campos', 7000, 0, 'P5', 'D2'),
('Emp4', 'Alexander Sandoval', 3000, 0, 'P6', 'D4'),
('Emp5', 'Jaime Viñals', 6000, 1, 'P7', 'D5'),
('Emp6', 'Julia Cruz', 4500, 1, 'P3', 'D2'),
('Emp7', 'Amy Houston', 8500, 0, 'P2', 'D5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encabezado_nomina`
--

DROP TABLE IF EXISTS `encabezado_nomina`;
CREATE TABLE IF NOT EXISTS `encabezado_nomina` (
  `codigo_nomina` varchar(20) NOT NULL,
  `FechaInicial_Nomina` date DEFAULT NULL,
  `FechaFinal_Nomina` date DEFAULT NULL,
  `Valor_Nomina` float DEFAULT NULL,
  PRIMARY KEY (`codigo_nomina`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `encabezado_nomina`
--

INSERT INTO `encabezado_nomina` (`codigo_nomina`, `FechaInicial_Nomina`, `FechaFinal_Nomina`, `Valor_Nomina`) VALUES
('Nomina2018', '2018-01-01', '2018-12-31', 15107.5),
('Nomina2019', '2019-01-01', '2019-12-31', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puesto`
--

DROP TABLE IF EXISTS `puesto`;
CREATE TABLE IF NOT EXISTS `puesto` (
  `codigo_puesto` varchar(10) NOT NULL,
  `nombre_puesto` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`codigo_puesto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `puesto`
--

INSERT INTO `puesto` (`codigo_puesto`, `nombre_puesto`) VALUES
('P1', 'Gerente'),
('P2', 'Supervisor'),
('P3', 'Contador'),
('P4', 'Reclutador '),
('P5', 'Programador'),
('P6', 'Técnico'),
('P7', 'Planificador'),
('P8', 'Programador Junior');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `codigo_usuario` varchar(5) NOT NULL,
  `nombre_usuario` varchar(60) DEFAULT NULL,
  `clave_usuario` varchar(20) DEFAULT NULL,
  `estado_usuario` tinyint(1) NOT NULL,
  `codigo_empleado` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codigo_usuario`),
  KEY `FK_codigoempleadousuario` (`codigo_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`codigo_usuario`, `nombre_usuario`, `clave_usuario`, `estado_usuario`, `codigo_empleado`) VALUES
('100', 'Yisus', '123', 1, 'Emp1'),
('88', 'Man', '88', 0, 'Emp2');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_nomina`
--
ALTER TABLE `detalle_nomina`
  ADD CONSTRAINT `FK_codigoconceptodetallenomina` FOREIGN KEY (`codigo_concepto`) REFERENCES `concepto` (`codigo_concepto`),
  ADD CONSTRAINT `FK_empleadodetallenomina` FOREIGN KEY (`codigo_empleado`) REFERENCES `empleado` (`codigo_empleado`),
  ADD CONSTRAINT `FK_encabezadodetallenomina` FOREIGN KEY (`codigo_nomina`) REFERENCES `encabezado_nomina` (`codigo_nomina`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `FK_departamentoempleado` FOREIGN KEY (`codigo_departamento`) REFERENCES `departamento` (`codigo_departamento`),
  ADD CONSTRAINT `FK_puestoempleado` FOREIGN KEY (`codigo_puesto`) REFERENCES `puesto` (`codigo_puesto`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_codigoempleadousuario` FOREIGN KEY (`codigo_empleado`) REFERENCES `empleado` (`codigo_empleado`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
