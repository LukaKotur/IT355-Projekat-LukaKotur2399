-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2017 at 04:30 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `i355-projekat`
--

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `ID` int(11) NOT NULL,
  `ZANR_ID` int(11) DEFAULT NULL,
  `NAZIV` varchar(255) DEFAULT NULL,
  `TRAJANJE` int(11) DEFAULT NULL,
  `GODINA` int(11) DEFAULT NULL,
  `OCENA` int(11) DEFAULT NULL,
  `IMDB_LINK` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`ID`, `ZANR_ID`, `NAZIV`, `TRAJANJE`, `GODINA`, `OCENA`, `IMDB_LINK`) VALUES
(11, 8, 'The Shawshank Redemption', 144, 1994, 9, 'http://www.imdb.com/title/tt0111161/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042102&pf_rd_r=1GXA4ZFXRP6CEB5CJ9AJ&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_1'),
(12, 8, 'The Godfather', 175, 1972, 9, 'http://www.imdb.com/title/tt0068646/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042102&pf_rd_r=1GXA4ZFXRP6CEB5CJ9AJ&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_2'),
(13, 8, 'The Godfather II', 202, 1975, 9, 'http://www.imdb.com/title/tt0071562/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042102&pf_rd_r=1GXA4ZFXRP6CEB5CJ9AJ&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_3'),
(14, 9, 'The Dark Knight', 152, 2008, 9, 'http://www.imdb.com/title/tt0468569/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042102&pf_rd_r=1GXA4ZFXRP6CEB5CJ9AJ&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_4'),
(15, 8, '12 Angry Men ', 96, 1957, 8, 'http://www.imdb.com/title/tt0050083/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042102&pf_rd_r=1GXA4ZFXRP6CEB5CJ9AJ&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_5'),
(16, 10, 'Schindler''s List', 195, 1993, 8, 'http://www.imdb.com/title/tt0108052/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042102&pf_rd_r=1GXA4ZFXRP6CEB5CJ9AJ&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_6');

-- --------------------------------------------------------

--
-- Table structure for table `serija`
--

CREATE TABLE `serija` (
  `SERIJAID` int(11) NOT NULL,
  `ZANRID` int(11) DEFAULT NULL,
  `NAZIV` varchar(255) DEFAULT NULL,
  `TRAJANJE` int(11) DEFAULT NULL,
  `IMDB_LINK` varchar(255) DEFAULT NULL,
  `GODINA` int(11) DEFAULT NULL,
  `OCENA` int(11) DEFAULT NULL,
  `BROJ_EPIZODA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `serija`
--

INSERT INTO `serija` (`SERIJAID`, `ZANRID`, `NAZIV`, `TRAJANJE`, `IMDB_LINK`, `GODINA`, `OCENA`, `BROJ_EPIZODA`) VALUES
(3, 8, 'Game of Thrones', 56, 'http://www.imdb.com/title/tt0944947/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042182&pf_rd_r=0S73AQP9KWMJ256F3546&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=toptv&ref_=chttvtp_tt_4', 2011, 9, 73),
(4, 11, 'Breaking Bad ', 49, 'http://www.imdb.com/title/tt0903747/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042182&pf_rd_r=0S73AQP9KWMJ256F3546&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=toptv&ref_=chttvtp_tt_5', 2008, 9, 62),
(5, 11, 'The Wire', 59, 'http://www.imdb.com/title/tt0306414/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042182&pf_rd_r=0S73AQP9KWMJ256F3546&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=toptv&ref_=chttvtp_tt_6', 2002, 9, 60),
(6, 12, 'Rick and Morty ', 22, 'http://www.imdb.com/title/tt2861424/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042182&pf_rd_r=0S73AQP9KWMJ256F3546&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=toptv&ref_=chttvtp_tt_8', 2013, 9, 35),
(7, 11, 'The Sopranos ', 55, 'http://www.imdb.com/title/tt0141842/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=2398042182&pf_rd_r=0S73AQP9KWMJ256F3546&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=toptv&ref_=chttvtp_tt_10', 1999, 9, 86);

-- --------------------------------------------------------

--
-- Table structure for table `zanr`
--

CREATE TABLE `zanr` (
  `ID` int(11) NOT NULL,
  `NAZIV` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `zanr`
--

INSERT INTO `zanr` (`ID`, `NAZIV`) VALUES
(8, 'Drama'),
(9, 'Akcija'),
(10, 'Biografija'),
(11, 'Triler'),
(12, 'Komedija');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_filmzanr` (`ZANR_ID`);

--
-- Indexes for table `serija`
--
ALTER TABLE `serija`
  ADD PRIMARY KEY (`SERIJAID`),
  ADD KEY `fk_serijazanr` (`ZANRID`);

--
-- Indexes for table `zanr`
--
ALTER TABLE `zanr`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `serija`
--
ALTER TABLE `serija`
  MODIFY `SERIJAID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `zanr`
--
ALTER TABLE `zanr`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `fk_filmzanr` FOREIGN KEY (`ZANR_ID`) REFERENCES `zanr` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `serija`
--
ALTER TABLE `serija`
  ADD CONSTRAINT `fk_serijazanr` FOREIGN KEY (`ZANRID`) REFERENCES `zanr` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
