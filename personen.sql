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
-- Tabellenstruktur für Tabelle `personen`
--

CREATE TABLE `personen` (
  `ID` int(11) NOT NULL,
  `Vorname` varchar(25) NOT NULL,
  `Nachname` varchar(25) NOT NULL,
  `Status` varchar(1) NOT NULL,
  `Passwort` varchar(10) NOT NULL,
  `Benutzername` varchar(10) NOT NULL,
  `GerichtMo` int(11) NOT NULL,
  `GerichtDi` int(11) NOT NULL,
  `GerichtMi` int(11) NOT NULL,
  `GerichtDo` int(11) NOT NULL,
  `GerichtFr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `personen`
--

INSERT INTO `personen` (`ID`, `Vorname`, `Nachname`, `Status`, `Passwort`, `Benutzername`, `GerichtMo`, `GerichtDi`, `GerichtMi`, `GerichtDo`, `GerichtFr`) VALUES
(1, 'Michael', 'Muster', 'M', '1', 'Max1', 3, 0, 0, 0, 0),
(11, 'Klara', 'Meyer', 'S', 'erkr1', 'Klara', 2, 0, 0, 0, 0),
(10, 'Michael', 'Muster', 'M', '2kkr1', 'Max', 1, 0, 0, 0, 0),
(2, 'Hans', 'Meyer', 'S', 'erkr1', 'Hans', 2, 0, 0, 0, 0),
(3, 'Luisa', 'Berger ', 'M', 'owexf', 'Luisa', 0, 1, 1, 2, 0),
(4, 'Carolin', 'Marcelo', 'S', 'erkl3', 'Carolin', 1, 1, 0, 1, 0),
(5, 'Jens', 'Hausner', 'S', '42ker', 'Jens', 2, 2, 1, 0, 1),
(6, 'Ulrike', 'Bauer', 'S', 'kk34i', 'Ulrike', 0, 1, 2, 2, 2),
(7, 'Felix', 'Gro?', 'S', '8k43k', 'Felix', 2, 1, 1, 1, 2),
(8, 'Werner', 'Hacker', 'S', 'nmlse', 'Werner', 0, 1, 2, 2, 2),
(9, 'Nils', 'Dorp', 'S', '3k4ow', 'Nils', 2, 1, 1, 1, 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
