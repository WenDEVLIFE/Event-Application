-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 31, 2023 at 09:39 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eventsystem_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` binary(16) DEFAULT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `salt`, `role`) VALUES
(1, 'WenDEVLIFE', '48597edd810dbb9d17c69df47badcc800e20eab9aa35c8777c24254f40d6de4b', 0xc6a0e12a8085b939b62d0c547e6c2f44, 'Admin'),
(2, 'Wenwencat', '2b7c98fdf98b3dd38134333c74388bfa7ebec9ec61e274e1bb7ce3bcb5093e14', 0xd033e32da25a684ddec50290135ce800, 'Admin'),
(3, 'Wenwenmeow', 'c6bbb6bae121ca43a281eda5a826e0507637b300d7ca435f954de877eada8985', 0x45629cc1a2ee3d8ecc935dbed7b9be4a, 'Admin'),
(4, 'Wenwen45', '2a4228ae6684916e3091fe69213ff6464cfab55f987183b9763c349305872d13', 0x0c4a3e588c09deebdd6868c6ac38c394, 'Admin'),
(5, 'CATTY', 'c8a11d2848c4925d80ac35fb5dce42474ab8f3580369d44f1ba95b3e5565685a', 0x8635354d08e7cd384bc86cf74dd6e498, 'Admin'),
(6, 'hehe', '85b78754d280c0a6c439f5a3feefa363a1264b690bdc18ae07124ed9954c7ba3', 0x704bab9a8a464670c763ecad0aa2ff6f, 'Admin'),
(7, 'Meow245', '7342e33a3990d1bb1813308aeb0e2c3b7765055bb30351b9148c11152d30fe60', 0x7ec57cc3a3d4f1bea895d28fd94903f8, 'Admin'),
(8, 'WENWENWEN', '8ec83c38ef2568b8d536fc4991001b00d93c2469b4c0c9cbc66e68c85c7b1637', 0x3b51259e414a7f4d05029ad12d91f7c2, 'Admin'),
(9, 'DAVE', '5ebe764f19d590d30437b874f479f6c66460846a109ac793d624969cc152d54a', 0xeffa408c2e0a0cd2ad56d415916b0cca, 'Admin'),
(10, '@Ccattydog', 'fbb2c8d035e3184b73c8dee3ae8954bb3022bae78d5aa918760e66448d6c4cf5', 0x700bf9ab32b3ae7acc1821daf38dd9db, 'Admin'),
(11, 'ewewewewe', '7a2035de1e1542e58141f7ebb1cf3909d170358ecec8ad694a0509fe4fe82be9', 0x6f045e0837164440eda68105fa0ca126, 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
