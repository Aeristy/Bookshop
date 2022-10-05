-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2021 at 01:52 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `danhmuc`
--

CREATE TABLE `danhmuc` (
  `ID` int(11) NOT NULL,
  `ten` varchar(200) NOT NULL,
  `mota` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `danhmuc`
--

INSERT INTO `danhmuc` (`ID`, `ten`, `mota`) VALUES
(1, 'Drama', 'Drama theo phiên âm tiếng anh là /drɑː.mə/, thường mang hình thái diễn tả về các thể loại phim có nội dung đa chiều, đa nghĩa, thể hiện quá trình hình thành phát triển nội tâm, suy nghĩ của nhân vật khi đối diện trước nghịch cảnh. Đối với các thể loại chính kịch này thì nhân vật trung tâm có thể là một người hoặc cả một tập thể, đồng đội, những người phải đối mặt với sự thách thức giới hạn trong cuộc sống.');

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `ID` int(11) NOT NULL,
  `ten` varchar(200) NOT NULL,
  `tacgia` varchar(200) NOT NULL,
  `theloai` varchar(200) NOT NULL,
  `nhaxuatban` varchar(200) NOT NULL,
  `giaban` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`ID`, `ten`, `tacgia`, `theloai`, `nhaxuatban`, `giaban`) VALUES
(3, 'a', 'a', 'a', 'a', 12),
(4, 'b', 'b', 'b', 'b', 543243),
(5, 'gfd', 'asfsa', 'Drama', 'gfgf', 321);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danhmuc`
--
ALTER TABLE `danhmuc`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danhmuc`
--
ALTER TABLE `danhmuc`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sach`
--
ALTER TABLE `sach`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
