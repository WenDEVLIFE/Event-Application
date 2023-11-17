-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2023 at 01:57 PM
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
-- Table structure for table `participants_table`
--

CREATE TABLE `participants_table` (
  `ParticipantID` int(255) NOT NULL,
  `Firstname` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `Phone` int(255) NOT NULL,
  `Team_ID` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pwc_event_table`
--

CREATE TABLE `pwc_event_table` (
  `Event_ID` int(255) NOT NULL,
  `Event_Name` varchar(255) NOT NULL,
  `Event_Date` varchar(255) NOT NULL,
  `Event_Type` varchar(255) NOT NULL,
  `Location` varchar(255) NOT NULL,
  `Max_Participants` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pwc_event_table`
--

INSERT INTO `pwc_event_table` (`Event_ID`, `Event_Name`, `Event_Date`, `Event_Type`, `Location`, `Max_Participants`) VALUES
(1, 'BasketBall', '10/10/2023', 'Intrams', 'Pavillion', '10');

-- --------------------------------------------------------

--
-- Table structure for table `score_table`
--

CREATE TABLE `score_table` (
  `ScoreID` int(255) NOT NULL,
  `Event_ID` int(255) NOT NULL,
  `ParticipantID` int(255) NOT NULL,
  `Score` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `team_table`
--

CREATE TABLE `team_table` (
  `Team_ID` int(255) NOT NULL,
  `Team_Name` varchar(255) NOT NULL,
  `CaptainID/PLayer_ID` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(2, 'Wenwencat', '2b7c98fdf98b3dd38134333c74388bfa7ebec9ec61e274e1bb7ce3bcb5093e14', 0xd033e32da25a684ddec50290135ce800, 'Admin'),
(3, 'Wenwenmeow', 'c6bbb6bae121ca43a281eda5a826e0507637b300d7ca435f954de877eada8985', 0x45629cc1a2ee3d8ecc935dbed7b9be4a, 'Admin'),
(4, 'Wenwen458', '89e1b895c5b2805551ed037f48a3b989171c2d6c0eba67b44d6541aff78075b4', 0x8b5199533577b9a7de51c7dea8d5654c, 'Admin'),
(5, 'CATTY', 'c8a11d2848c4925d80ac35fb5dce42474ab8f3580369d44f1ba95b3e5565685a', 0x8635354d08e7cd384bc86cf74dd6e498, 'Admin'),
(6, 'hehe', '85b78754d280c0a6c439f5a3feefa363a1264b690bdc18ae07124ed9954c7ba3', 0x704bab9a8a464670c763ecad0aa2ff6f, 'Admin'),
(8, 'WENWENWEN', '8ec83c38ef2568b8d536fc4991001b00d93c2469b4c0c9cbc66e68c85c7b1637', 0x3b51259e414a7f4d05029ad12d91f7c2, 'Admin'),
(9, 'DAVE', '5ebe764f19d590d30437b874f479f6c66460846a109ac793d624969cc152d54a', 0xeffa408c2e0a0cd2ad56d415916b0cca, 'Admin'),
(10, '@Ccattydog', 'fbb2c8d035e3184b73c8dee3ae8954bb3022bae78d5aa918760e66448d6c4cf5', 0x700bf9ab32b3ae7acc1821daf38dd9db, 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `participants_table`
--
ALTER TABLE `participants_table`
  ADD PRIMARY KEY (`ParticipantID`),
  ADD KEY `idx_Team_ID` (`Team_ID`);

--
-- Indexes for table `pwc_event_table`
--
ALTER TABLE `pwc_event_table`
  ADD PRIMARY KEY (`Event_ID`);

--
-- Indexes for table `score_table`
--
ALTER TABLE `score_table`
  ADD PRIMARY KEY (`ScoreID`),
  ADD KEY `fk_Event_ID` (`Event_ID`),
  ADD KEY `fk_ParticipantID` (`ParticipantID`);

--
-- Indexes for table `team_table`
--
ALTER TABLE `team_table`
  ADD PRIMARY KEY (`Team_ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `participants_table`
--
ALTER TABLE `participants_table`
  MODIFY `ParticipantID` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pwc_event_table`
--
ALTER TABLE `pwc_event_table`
  MODIFY `Event_ID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `score_table`
--
ALTER TABLE `score_table`
  ADD CONSTRAINT `fk_Event_ID` FOREIGN KEY (`Event_ID`) REFERENCES `pwc_event_table` (`Event_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_ParticipantID` FOREIGN KEY (`ParticipantID`) REFERENCES `participants_table` (`ParticipantID`) ON DELETE CASCADE;

--
-- Constraints for table `team_table`
--
ALTER TABLE `team_table`
  ADD CONSTRAINT `fk_Team_ID` FOREIGN KEY (`Team_ID`) REFERENCES `participants_table` (`Team_ID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
