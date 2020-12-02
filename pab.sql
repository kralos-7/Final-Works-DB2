-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2020 at 06:48 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `psychopedagogy_appointment_book`
--
DROP DATABASE IF EXISTS `psychopedagogy_appointment_book`;
CREATE DATABASE IF NOT EXISTS `psychopedagogy_appointment_book` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `psychopedagogy_appointment_book`;

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `_idTrabajador` varchar(4) COLLATE utf8_spanish_ci NOT NULL,
  `_nombre` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `_apellidos` varchar(80) COLLATE utf8_spanish_ci NOT NULL,
  `_telefono` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `_correo` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `_idCita` int(11) NOT NULL,
  `_idPaciente` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `_idEspecialista` varchar(4) COLLATE utf8_spanish_ci NOT NULL,
  `_asunto` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `_fecha` date NOT NULL,
  `_hora_inicio` time NOT NULL,
  `_hora_termino` time NOT NULL,
  `_estatus` varchar(15) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `_matricula` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `_nombre` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `_apellidos` varchar(80) COLLATE utf8_spanish_ci NOT NULL,
  `_sexo` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `_fecha_nacimiento` date NOT NULL,
  `_grupo` varchar(4) COLLATE utf8_spanish_ci NOT NULL,
  `_telefono` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `_correo` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `_idUser` int(11) NOT NULL,
  `_login` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `_password` varchar(32) COLLATE utf8_spanish_ci NOT NULL,
  `_privileges` varchar(13) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`_idUser`, `_login`, `_password`, `_privileges`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'administrador'),
(2, '2020202020', '7b7a53e239400a13bd6be6c91c4f6c4e', 'estudiante');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`_idTrabajador`);

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`_idCita`),
  ADD KEY `_idPaciente` (`_idPaciente`),
  ADD KEY `_idEspecialista` (`_idEspecialista`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`_matricula`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`_idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `_idCita` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `_idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`_idEspecialista`) REFERENCES `administrator` (`_idTrabajador`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`_idPaciente`) REFERENCES `student` (`_matricula`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
