-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 
-- Версия на сървъра: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `chat`
--

-- --------------------------------------------------------

--
-- Структура на таблица `massage`
--

CREATE TABLE IF NOT EXISTS `massage` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_sender` int(10) NOT NULL,
  `user_retriever` int(10) NOT NULL,
  `date` date DEFAULT NULL,
  `read_id` int(11) NOT NULL,
  `msg` varchar(50) NOT NULL,
  `friend_ship_id` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `mas_retriever` (`user_retriever`),
  KEY `mas_sender` (`user_sender`),
  KEY `ch_f` (`read_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=75 ;

--
-- Схема на данните от таблица `massage`
--

INSERT INTO `massage` (`id`, `user_sender`, `user_retriever`, `date`, `read_id`, `msg`, `friend_ship_id`) VALUES
(37, 93, 92, NULL, 1, 'd', 0),
(38, 92, 92, NULL, 1, 'wa', 0),
(39, 92, 92, NULL, 1, 'xs', 0),
(40, 93, 92, NULL, 1, 'a', 0),
(41, 93, 92, NULL, 1, 'ds', 0),
(42, 93, 92, NULL, 1, 'dfdfd', 0),
(43, 92, 93, NULL, 1, 'w', 0),
(44, 93, 92, NULL, 1, 'bh', 0),
(46, 93, 94, NULL, 1, 'dovre', 187),
(50, 93, 94, NULL, 1, 'ss', 187),
(51, 93, 93, NULL, 1, 's', 186),
(52, 94, 93, NULL, 1, 'efs', 187),
(53, 94, 93, NULL, 1, 'fuck you', 187),
(54, 94, 93, NULL, 1, 'ds', 187),
(55, 94, 93, NULL, 1, 'ei pederas', 187),
(56, 93, 94, NULL, 1, 'ww', 187),
(57, 93, 94, NULL, 1, 'da', 187),
(58, 93, 94, NULL, 1, 'ei ramadane', 187),
(59, 94, 93, NULL, 1, 'ko staaa', 187),
(60, 93, 94, NULL, 1, 'elaa', 187),
(61, 93, 94, NULL, 1, 'xz', 187),
(65, 94, 93, NULL, 1, 'wa', 187),
(66, 94, 93, NULL, 1, 'ds', 187),
(67, 93, 94, NULL, 1, 'ko staa ramadane', 187),
(68, 94, 93, '2016-10-16', 1, 'er', 187),
(70, 94, 93, '2016-10-16', 1, 'ew davad da da ca', 187),
(71, 96, 95, '2016-10-16', 1, 'obicham te', 191),
(72, 95, 96, '2016-10-16', 1, 'i az', 191),
(73, 96, 95, '2016-10-16', 1, 'ok', 191),
(74, 95, 94, '2016-10-16', 1, 'ko ramadene', 189);

--
-- Ограничения за дъмпнати таблици
--

--
-- Ограничения за таблица `massage`
--
ALTER TABLE `massage`
  ADD CONSTRAINT `ch_f` FOREIGN KEY (`read_id`) REFERENCES `haveread` (`id`),
  ADD CONSTRAINT `massage_ibfk_1` FOREIGN KEY (`user_retriever`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `massage_ibfk_2` FOREIGN KEY (`user_sender`) REFERENCES `user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
