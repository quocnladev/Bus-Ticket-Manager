-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2022 at 04:28 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.0.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bus_station`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_tickets`
--

CREATE TABLE `book_tickets` (
  `id` int(11) NOT NULL,
  `idEmployee` int(11) NOT NULL,
  `idCar` int(11) DEFAULT NULL,
  `type` varchar(45) NOT NULL DEFAULT 'local' COMMENT 'local - tại bến\nonline - đặt online',
  `status` varchar(45) NOT NULL DEFAULT 'unpaid' COMMENT 'unpaid - chưa thanh toán\npaid - đã thanh toán',
  `orderDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `payDate` timestamp NULL DEFAULT NULL,
  `paidAmount` bigint(20) DEFAULT 0,
  `totalAmount` bigint(20) NOT NULL DEFAULT 0,
  `idCustomer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book_tickets`
--

INSERT INTO `book_tickets` (`id`, `idEmployee`, `idCar`, `type`, `status`, `orderDate`, `payDate`, `paidAmount`, `totalAmount`, `idCustomer`) VALUES
(1, 1, 2, 'local', 'paid', '2022-11-25 01:12:31', NULL, 600000, 600000, 1),
(2, 1, 3, 'online', 'paid', '2022-11-25 10:23:40', NULL, 240000, 240000, 2),
(3, 1, 1, 'local', 'paid', '2022-11-30 15:18:09', NULL, 7500000, 7500000, 3);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `phoneNumber`, `name`, `address`, `birthday`) VALUES
(1, '0911175581', 'Quoc', 'Tay Ninh', '2000-04-09 10:00:00'),
(2, '0911175581', 'Linh', 'TPHCM', '2000-09-16 10:00:00'),
(3, '0911175581', 'Duc', 'Binh Thuan', '2000-04-09 22:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `startDate` timestamp NULL DEFAULT NULL,
  `salary` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`id`, `name`, `phoneNumber`, `address`, `startDate`, `salary`) VALUES
(1, 'Quocc', '099999999', 'Tây Ninh', '2000-02-12 22:00:00', 600000),
(2, 'toàn', '099999999', 'Binh Thuan', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `startDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `permission` varchar(50) NOT NULL COMMENT 'manager-quản lý\r\nstaff-nhân viên\r\ninactive-nghỉ việc',
  `salary` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `username`, `password`, `name`, `phoneNumber`, `startDate`, `permission`, `salary`) VALUES
(1, 'admin', '1', 'Admin', '0911175581', '2020-11-23 17:00:00', 'manager', 10600000),
(2, 'nhanvien', '1', 'Quoc', '0999999999', '2020-11-24 05:15:08', 'staff', 200000),
(3, 'quoc24', '1', 'quoc', '12213123', '2022-11-12 01:27:51', 'manager', 100000),
(4, 'toan', '1', 'toan', '123', '2022-11-30 15:25:23', 'staff', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `list_bus`
--

CREATE TABLE `list_bus` (
  `id` int(11) NOT NULL,
  `bienxe` varchar(11) NOT NULL,
  `nhaxe` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL DEFAULT 'seat' COMMENT 'seat - ghế gồi\nbed - giường nằm',
  `price` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `idDriver` int(11) DEFAULT NULL,
  `idRoute` int(11) DEFAULT NULL,
  `idTime` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `list_bus`
--

INSERT INTO `list_bus` (`id`, `bienxe`, `nhaxe`, `type`, `price`, `number`, `idDriver`, `idRoute`, `idTime`) VALUES
(1, '51K - 12345', 'Đồng Phước', 'bed', 300000, 20, 2, 3, 3),
(2, '51Y - 54321', 'Phương Trang', 'bed', 2500000, 20, 1, 2, 5),
(3, '70F - 98989', 'lmao', 'seat', 120000, 45, 1, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE `route` (
  `id` int(11) NOT NULL,
  `depart` varchar(50) NOT NULL,
  `destination` varchar(50) NOT NULL,
  `length` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`id`, `depart`, `destination`, `length`) VALUES
(1, 'TP HCM', 'Đà Lạt', '400km'),
(2, 'Tây Ninh', 'Cần Thơ', '300km'),
(3, 'Cao Bằng', 'Hà Nội', '200km');

-- --------------------------------------------------------

--
-- Table structure for table `session`
--

CREATE TABLE `session` (
  `id` int(11) NOT NULL,
  `idEmployee` int(11) NOT NULL,
  `startTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `endTime` timestamp NULL DEFAULT NULL,
  `message` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `session`
--

INSERT INTO `session` (`id`, `idEmployee`, `startTime`, `endTime`, `message`) VALUES
(1, 1, '2022-11-10 09:48:38', NULL, 'login'),
(2, 1, '2022-11-24 22:04:29', '2022-11-24 22:05:10', 'logout'),
(3, 1, '2022-11-24 22:05:18', '2022-11-24 22:06:01', 'logout'),
(4, 1, '2022-11-24 22:06:05', '2022-11-24 22:07:47', 'logout'),
(5, 1, '2022-11-24 23:08:57', '2022-11-24 23:12:19', 'logout'),
(6, 1, '2022-11-24 23:12:25', '2022-11-24 23:15:48', 'logout'),
(7, 1, '2022-11-24 23:19:27', '2022-11-24 23:23:20', 'logout'),
(8, 1, '2022-11-24 23:43:25', '2022-11-24 23:43:45', 'logout'),
(9, 1, '2022-11-24 23:43:55', '2022-11-24 23:44:31', 'logout'),
(10, 1, '2022-11-24 23:44:37', '2022-11-24 23:44:43', 'logout'),
(11, 1, '2022-11-24 23:44:56', '2022-11-24 23:46:00', 'logout'),
(12, 1, '2022-11-24 23:46:10', '2022-11-24 23:46:20', 'logout'),
(13, 1, '2022-11-24 23:46:39', '2022-11-24 23:46:47', 'logout'),
(14, 1, '2022-11-24 23:53:02', '2022-11-24 23:53:14', 'logout'),
(15, 1, '2022-11-24 23:53:30', '2022-11-24 23:53:40', 'logout'),
(16, 1, '2022-11-24 23:54:07', '2022-11-24 23:54:21', 'logout'),
(17, 1, '2022-11-24 23:54:35', '2022-11-24 23:54:51', 'logout'),
(18, 1, '2022-11-24 23:58:09', '2022-11-24 23:58:20', 'logout'),
(19, 1, '2022-11-24 23:59:07', NULL, 'login'),
(20, 1, '2022-11-24 23:59:13', '2022-11-24 23:59:43', 'logout'),
(21, 1, '2022-11-24 23:59:49', '2022-11-25 00:00:00', 'logout'),
(22, 1, '2022-11-25 00:01:46', '2022-11-25 00:02:02', 'logout'),
(23, 1, '2022-11-25 00:02:07', '2022-11-25 00:02:22', 'logout'),
(24, 1, '2022-11-25 00:11:00', '2022-11-25 00:12:09', 'logout'),
(25, 1, '2022-11-25 00:37:04', '2022-11-25 00:37:24', 'logout'),
(26, 1, '2022-11-25 00:39:40', '2022-11-25 00:39:59', 'logout'),
(27, 1, '2022-11-25 00:51:13', '2022-11-25 00:51:30', 'logout'),
(28, 1, '2022-11-25 01:07:28', '2022-11-25 01:08:30', 'logout'),
(29, 1, '2022-11-25 01:08:51', '2022-11-25 01:09:05', 'logout'),
(30, 1, '2022-11-25 01:11:54', '2022-11-25 01:12:34', 'logout'),
(31, 1, '2022-11-25 01:14:37', '2022-11-25 01:15:25', 'logout'),
(32, 1, '2022-11-25 02:02:16', '2022-11-25 02:03:29', 'logout'),
(33, 1, '2022-11-25 02:02:17', '2022-11-25 02:02:42', 'logout'),
(34, 1, '2022-11-25 02:12:19', '2022-11-25 02:13:17', 'logout'),
(35, 1, '2022-11-25 02:13:20', '2022-11-25 02:13:38', 'logout'),
(36, 1, '2022-11-25 02:14:27', '2022-11-25 02:15:03', 'logout'),
(37, 1, '2022-11-25 02:15:08', '2022-11-25 02:17:00', 'logout'),
(38, 1, '2022-11-25 02:17:04', '2022-11-25 02:18:43', 'logout'),
(39, 1, '2022-11-25 02:23:41', '2022-11-25 02:25:21', 'logout'),
(40, 1, '2022-11-25 02:49:39', '2022-11-25 03:04:06', 'logout'),
(41, 1, '2022-11-25 03:23:17', '2022-11-25 03:24:52', 'logout'),
(42, 1, '2022-11-25 03:24:57', '2022-11-25 03:25:07', 'logout'),
(43, 1, '2022-11-27 07:11:32', '2022-11-27 07:11:49', 'logout'),
(44, 1, '2022-11-27 07:13:16', '2022-11-27 07:13:24', 'logout'),
(45, 1, '2022-11-27 09:26:02', '2022-11-27 09:27:13', 'logout'),
(46, 1, '2022-11-27 10:10:43', '2022-11-27 10:10:55', 'logout'),
(47, 1, '2022-11-27 10:17:50', '2022-11-27 10:19:42', 'logout'),
(48, 1, '2022-11-30 07:50:45', '2022-11-30 07:52:53', 'logout'),
(49, 1, '2022-11-30 07:53:57', '2022-11-30 07:54:18', 'logout'),
(50, 2, '2022-11-30 07:54:25', '2022-11-30 07:57:45', 'logout'),
(51, 2, '2022-11-30 07:58:07', '2022-11-30 07:58:17', 'logout'),
(52, 1, '2022-11-30 07:58:41', '2022-11-30 07:58:54', 'logout'),
(53, 1, '2022-11-30 07:59:17', '2022-11-30 07:59:28', 'logout'),
(54, 1, '2022-11-30 08:03:38', '2022-11-30 08:04:18', 'logout'),
(55, 1, '2022-11-30 08:06:33', '2022-11-30 08:10:02', 'logout'),
(56, 1, '2022-11-30 08:10:40', '2022-11-30 08:12:46', 'logout'),
(57, 1, '2022-11-30 08:12:52', '2022-11-30 08:13:00', 'logout'),
(58, 1, '2022-11-30 08:13:49', '2022-11-30 08:16:19', 'logout'),
(59, 1, '2022-11-30 08:16:21', '2022-11-30 08:16:38', 'logout'),
(60, 1, '2022-11-30 08:16:50', '2022-11-30 08:26:57', 'logout');

-- --------------------------------------------------------

--
-- Table structure for table `time`
--

CREATE TABLE `time` (
  `id` int(11) NOT NULL,
  `startTime` timestamp NOT NULL DEFAULT current_timestamp(),
  `endTime` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `time`
--

INSERT INTO `time` (`id`, `startTime`, `endTime`) VALUES
(1, '2022-11-30 17:08:59', '2000-04-09 22:00:00'),
(2, '2022-12-10 17:08:59', '2000-04-09 22:00:00'),
(3, '2000-04-09 22:00:00', '2000-04-09 22:00:00'),
(4, '2000-04-09 22:00:00', '2000-04-09 22:00:00'),
(5, '2000-04-09 22:00:00', '2000-04-09 22:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_tickets`
--
ALTER TABLE `book_tickets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_employee_book_tickets` (`idEmployee`),
  ADD KEY `fk_book_tickets_customer` (`idCustomer`),
  ADD KEY `fk_book_tickets_list_bus` (`idCar`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `list_bus`
--
ALTER TABLE `list_bus`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `bienxe` (`bienxe`),
  ADD KEY `fk_bus_driver` (`idDriver`),
  ADD KEY `fk_bus_route` (`idRoute`),
  ADD KEY `fk_bus_time` (`idTime`);

--
-- Indexes for table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_session` (`idEmployee`);

--
-- Indexes for table `time`
--
ALTER TABLE `time`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book_tickets`
--
ALTER TABLE `book_tickets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `driver`
--
ALTER TABLE `driver`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `list_bus`
--
ALTER TABLE `list_bus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `route`
--
ALTER TABLE `route`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `session`
--
ALTER TABLE `session`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT for table `time`
--
ALTER TABLE `time`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book_tickets`
--
ALTER TABLE `book_tickets`
  ADD CONSTRAINT `fk_book_tickets_customer` FOREIGN KEY (`idCustomer`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `fk_book_tickets_list_bus` FOREIGN KEY (`idCar`) REFERENCES `list_bus` (`id`),
  ADD CONSTRAINT `fk_employee_book_tickets` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`id`);

--
-- Constraints for table `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `fk_session` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
