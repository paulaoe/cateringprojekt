-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 01. Apr 2020 um 13:25
-- Server-Version: 10.4.11-MariaDB
-- PHP-Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `catering`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `gerichte`
--

CREATE TABLE `gerichte` (
  `Nr` int(11) NOT NULL,
  `Mo` varchar(25) NOT NULL,
  `Di` varchar(25) NOT NULL,
  `Mi` varchar(25) NOT NULL,
  `Do` varchar(25) NOT NULL,
  `Fr` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `gerichte`
--

INSERT INTO `gerichte` (`Nr`, `Mo`, `Di`, `Mi`, `Do`, `Fr`) VALUES
(1, 'Spargel mit Kartoffeln un', 'Kaiserschmarrn mit Apfelm', 'Spaghetti mit Tomatensoße', 'Gemüselasagne', 'Kartoffelpuffer mit Apfel'),
(2, 'Wiener Schnitzel', 'Karpfen mit Kartoffeln', 'Pizza ', 'Fischstäbchen mit Kartoff', 'Gnocci mit Pilzsoße');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
