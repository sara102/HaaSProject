-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 20, 2016 at 03:52 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `haasdb`
--
CREATE DATABASE IF NOT EXISTS `haasdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `haasdb`;

-- --------------------------------------------------------

--
-- Table structure for table `device`
--

CREATE TABLE IF NOT EXISTS `device` (
  `serial_number` varchar(100) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`serial_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `device_connect_device`
--

CREATE TABLE IF NOT EXISTS `device_connect_device` (
  `host_serial_number` varchar(100) NOT NULL,
  `ghest_serial_number` varchar(100) NOT NULL,
  `start_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_timestamp` timestamp NULL DEFAULT NULL,
  `consumed_mb` double NOT NULL,
  KEY `host_serial_number_FK` (`host_serial_number`),
  KEY `ghest_serial_number_FK` (`ghest_serial_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `email` varchar(100) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `golden_coins` double NOT NULL,
  `silver_coins` double NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_transfer_coins_user`
--

CREATE TABLE IF NOT EXISTS `user_transfer_coins_user` (
  `borrower_email` varchar(100) NOT NULL,
  `lender_email` varchar(100) NOT NULL,
  `transaction_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `coins_amount` int(11) NOT NULL,
  KEY `borrower_FK` (`borrower_email`),
  KEY `lender_FK` (`lender_email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_uses_device`
--

CREATE TABLE IF NOT EXISTS `user_uses_device` (
  `serial_number` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `start_using_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `end_using_timestamp` timestamp NULL DEFAULT NULL,
  KEY `user_FK` (`email`),
  KEY `device_FK` (`serial_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `device_connect_device`
--
ALTER TABLE `device_connect_device`
  ADD CONSTRAINT `ghest_serial_number_FK` FOREIGN KEY (`ghest_serial_number`) REFERENCES `device` (`serial_number`),
  ADD CONSTRAINT `host_serial_number_FK` FOREIGN KEY (`host_serial_number`) REFERENCES `device` (`serial_number`);

--
-- Constraints for table `user_transfer_coins_user`
--
ALTER TABLE `user_transfer_coins_user`
  ADD CONSTRAINT `lender_FK` FOREIGN KEY (`lender_email`) REFERENCES `user` (`email`),
  ADD CONSTRAINT `borrower_FK` FOREIGN KEY (`borrower_email`) REFERENCES `user` (`email`);

--
-- Constraints for table `user_uses_device`
--
ALTER TABLE `user_uses_device`
  ADD CONSTRAINT `device_FK` FOREIGN KEY (`serial_number`) REFERENCES `device` (`serial_number`),
  ADD CONSTRAINT `user_FK` FOREIGN KEY (`email`) REFERENCES `user` (`email`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
