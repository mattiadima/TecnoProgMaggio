-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 18, 2025 alle 23:17
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `terminal`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `admin`
--

CREATE TABLE `admin` (
  `mail` varchar(64) NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `admin`
--

INSERT INTO `admin` (`mail`, `password`) VALUES
('a', 'a');

-- --------------------------------------------------------

--
-- Struttura della tabella `autista`
--

CREATE TABLE `autista` (
  `ID` int(11) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `autista`
--

INSERT INTO `autista` (`ID`, `nome`, `username`, `password`) VALUES
(3, 'asd', 'asd', 'asd');

-- --------------------------------------------------------

--
-- Struttura della tabella `buono`
--

CREATE TABLE `buono` (
  `ID` int(11) NOT NULL,
  `data` date NOT NULL,
  `polizza` int(11) DEFAULT NULL,
  `peso` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `buono`
--

INSERT INTO `buono` (`ID`, `data`, `polizza`, `peso`) VALUES
(1, '2025-05-06', 1, 123),
(2, '2025-05-09', 1, 123);

-- --------------------------------------------------------

--
-- Struttura della tabella `camion`
--

CREATE TABLE `camion` (
  `targa` varchar(8) NOT NULL,
  `modello` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `camion`
--

INSERT INTO `camion` (`targa`, `modello`) VALUES
('asdasd', 'asdasdasd');

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `ID` int(11) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `cognome` varchar(64) NOT NULL,
  `indirizzo` varchar(256) DEFAULT NULL,
  `tel` varchar(16) DEFAULT NULL,
  `mail` varchar(64) NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`ID`, `nome`, `cognome`, `indirizzo`, `tel`, `mail`, `password`) VALUES
(1, 'c', 'c', NULL, NULL, 'c', 'c');

-- --------------------------------------------------------

--
-- Struttura della tabella `fornitore`
--

CREATE TABLE `fornitore` (
  `ID` int(11) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `cognome` varchar(64) NOT NULL,
  `password` varchar(32) NOT NULL,
  `tel` varchar(16) DEFAULT NULL,
  `mail` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `fornitore`
--

INSERT INTO `fornitore` (`ID`, `nome`, `cognome`, `password`, `tel`, `mail`) VALUES
(1, 'b', 'b', 'b', NULL, 'b');

-- --------------------------------------------------------

--
-- Struttura della tabella `nave`
--

CREATE TABLE `nave` (
  `ID` int(11) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `tipo` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `nave`
--

INSERT INTO `nave` (`ID`, `nome`, `tipo`) VALUES
(3, 'DVZXCV', 'DVSZV'),
(4, 'asd', 'hvc jhc');

-- --------------------------------------------------------

--
-- Struttura della tabella `polizza`
--

CREATE TABLE `polizza` (
  `ID` int(11) NOT NULL,
  `viaggio` int(11) DEFAULT NULL,
  `peso` double NOT NULL,
  `data` date NOT NULL,
  `merce` varchar(16) NOT NULL,
  `cliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `polizza`
--

INSERT INTO `polizza` (`ID`, `viaggio`, `peso`, `data`, `merce`, `cliente`) VALUES
(1, 1, 1, '2025-05-08', 'ciao', 1),
(2, 1, 123123, '2025-05-16', 'ciao', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `porto`
--

CREATE TABLE `porto` (
  `ID` int(11) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `rotta` varchar(64) NOT NULL,
  `nazione` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `porto`
--

INSERT INTO `porto` (`ID`, `nome`, `rotta`, `nazione`) VALUES
(6, 'qw', 'qw', 'qw');

-- --------------------------------------------------------

--
-- Struttura della tabella `ritiro`
--

CREATE TABLE `ritiro` (
  `ID` int(11) NOT NULL,
  `targa` varchar(8) DEFAULT NULL,
  `autista` int(11) DEFAULT NULL,
  `peso` double NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `ritiro`
--

INSERT INTO `ritiro` (`ID`, `targa`, `autista`, `peso`, `data`) VALUES
(1, 'asdasd', 3, 123, '2017-01-11'),
(2, 'asdasd', 3, 1, '2025-05-09');

-- --------------------------------------------------------

--
-- Struttura della tabella `viaggio`
--

CREATE TABLE `viaggio` (
  `ID` int(11) NOT NULL,
  `fornitore` int(11) DEFAULT NULL,
  `porto_partenza` int(11) DEFAULT NULL,
  `porto_arrivo` int(11) DEFAULT NULL,
  `data_arrivo` date NOT NULL,
  `data_partenza` date NOT NULL,
  `nave` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `viaggio`
--

INSERT INTO `viaggio` (`ID`, `fornitore`, `porto_partenza`, `porto_arrivo`, `data_arrivo`, `data_partenza`, `nave`) VALUES
(1, 1, 6, 6, '2025-05-16', '2025-05-16', 3);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `admin`
--
ALTER TABLE `admin`
  ADD UNIQUE KEY `nome` (`mail`);

--
-- Indici per le tabelle `autista`
--
ALTER TABLE `autista`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indici per le tabelle `buono`
--
ALTER TABLE `buono`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `polizza` (`polizza`);

--
-- Indici per le tabelle `camion`
--
ALTER TABLE `camion`
  ADD PRIMARY KEY (`targa`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `mail` (`mail`);

--
-- Indici per le tabelle `fornitore`
--
ALTER TABLE `fornitore`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`,`tel`);

--
-- Indici per le tabelle `nave`
--
ALTER TABLE `nave`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `polizza`
--
ALTER TABLE `polizza`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `viaggio` (`viaggio`),
  ADD KEY `cliente` (`cliente`);

--
-- Indici per le tabelle `porto`
--
ALTER TABLE `porto`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `ritiro`
--
ALTER TABLE `ritiro`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `targa` (`targa`),
  ADD KEY `autista` (`autista`);

--
-- Indici per le tabelle `viaggio`
--
ALTER TABLE `viaggio`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fornitore` (`fornitore`),
  ADD KEY `porto_partenza` (`porto_partenza`),
  ADD KEY `porto_arrivo` (`porto_arrivo`),
  ADD KEY `nave` (`nave`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `autista`
--
ALTER TABLE `autista`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `buono`
--
ALTER TABLE `buono`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `fornitore`
--
ALTER TABLE `fornitore`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `nave`
--
ALTER TABLE `nave`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `polizza`
--
ALTER TABLE `polizza`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `porto`
--
ALTER TABLE `porto`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT per la tabella `ritiro`
--
ALTER TABLE `ritiro`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `viaggio`
--
ALTER TABLE `viaggio`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `buono`
--
ALTER TABLE `buono`
  ADD CONSTRAINT `buono_ibfk_1` FOREIGN KEY (`polizza`) REFERENCES `polizza` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Limiti per la tabella `polizza`
--
ALTER TABLE `polizza`
  ADD CONSTRAINT `polizza_ibfk_1` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `polizza_ibfk_2` FOREIGN KEY (`viaggio`) REFERENCES `viaggio` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Limiti per la tabella `ritiro`
--
ALTER TABLE `ritiro`
  ADD CONSTRAINT `ritiro_ibfk_1` FOREIGN KEY (`targa`) REFERENCES `camion` (`targa`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `ritiro_ibfk_2` FOREIGN KEY (`autista`) REFERENCES `autista` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Limiti per la tabella `viaggio`
--
ALTER TABLE `viaggio`
  ADD CONSTRAINT `viaggio_ibfk_1` FOREIGN KEY (`porto_partenza`) REFERENCES `porto` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `viaggio_ibfk_2` FOREIGN KEY (`porto_arrivo`) REFERENCES `porto` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `viaggio_ibfk_3` FOREIGN KEY (`nave`) REFERENCES `nave` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `viaggio_ibfk_4` FOREIGN KEY (`fornitore`) REFERENCES `fornitore` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
