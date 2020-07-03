-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 18, 2019 at 07:47 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lms`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `bookId` varchar(32) NOT NULL,
  `bookName` varchar(32) NOT NULL,
  `authorName` varchar(32) NOT NULL,
  `publishYear` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookId`, `bookName`, `authorName`, `publishYear`) VALUES
('1', 'frfrfrrr', '5055', '2013'),
('10', 'sgsg', 'gsgrg', '2424'),
('11', 'xxv', 'bgb', '2255'),
('12', 'hhhh', 'nnnnn', '2222'),
('13', 'jjjj', 'nnn', '2221'),
('14', 'yyyyyyyyy', 'uuuuuuuuuuuu', '4444'),
('2', 'bbhbhh', 'fccccccccc', '2014'),
('3', 'hp', 'jk', '1996'),
('4', 'hp2', 'jk', '1997'),
('6', 'gfd', 'dfg', '2424'),
('7', 'fnfnf', 'fnfnccn', '6868'),
('8', 'fnnf', 'cncnc', '1022'),
('9', 'hfh', 'hf', '2222');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentId` varchar(20) NOT NULL,
  `studentName` varchar(32) NOT NULL,
  `studentPass` varchar(20) NOT NULL,
  `studentDept` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentId`, `studentName`, `studentPass`, `studentDept`) VALUES
('1', 'hossain', '257', 'cse'),
('2', 'anu', '585', 'cs'),
('3', 'shihab', '159', 'cse'),
('4', 'prodhan', '813', 'cse'),
('5', 'islam', '111', 'cse');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bookId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
