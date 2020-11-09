-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 01, 2020 at 04:00 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doanbandienthoai`
--

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `ten` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `ngaysinh` int(20) NOT NULL,
  `gioitinh` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `luong` float DEFAULT NULL,
  `diachi` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `ho` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `chucvu` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `kinhnghiem` int(11) NOT NULL,
  `phongban` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `ten`, `ngaysinh`, `gioitinh`, `luong`, `diachi`, `ho`, `chucvu`, `kinhnghiem`, `phongban`) VALUES
('001', 'Phàm', 123, 'Nam', 50000000, '123 xyz', 'mạc', 'Chủ phần mền quản lý', 321, 'Kế toán'),
('002', 'tuyết', 123, 'Nam', 50000000, '123 xyz', 'mục', 'Chủ phần mền quản lý', 321, 'jcvd'),
('003', 'Thiên', 1996, 'Nam', 5000000, '140 Hùng Vương Q1', 'dfd', 'Chủ phần mền quản lý', 20, '3'),
('004', 'min', 1999, 'Nam', 5110000, 'tthanh', 'dfd', 'Nhân viên', 20, '25'),
('005', 't', 1, 'Nam', 1000, 'abc', 'j', 'Chủ phần mền quản lý', 1, 'fvgsv'),
('006', 'adsfa', 23432, 'Nam', 134, 'dfcds', 'dâds', 'Chủ phần mền quản lý', 11, 'fvgsd'),
('111', '32hjxcxz', 3231, 'Nam', 2321230, '313', 'sdf', 'Nhân Viên', 5, '21'),
('12', '32hj', 32321, 'Nam', 232123, '3', 'sdf', 'Nhân Viên', 5, '3'),
('1321', '32', 32321, 'Nam', 232123, '3', 'ds', 'Nhân Viên', 4, '23'),
('21', '123', 123, 'Nam', 213, '123', '21ncdxiuasbhgfic', 'Nhân Viên', 4545445, 'fvds'),
('21313', '32', 32321, 'Nam', 232123, '3', 'ds', 'Nhân Viên', 4, '12'),
('2237', '32', 32321, 'Nam', 232123, '3', 'sdf', 'Nhân Viên', 4, '23'),
('35413', '15315', 1531, 'Khác', 5131150, '11531', '152311531', 'Chủ phần mền quản lý', 1315, '531');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manv`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
