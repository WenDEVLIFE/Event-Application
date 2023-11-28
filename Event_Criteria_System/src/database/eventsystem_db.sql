-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2023 at 06:22 PM
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
  `Phone` varchar(255) NOT NULL,
  `Team_ID` int(255) NOT NULL,
  `Event_ID` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `participants_table`
--

INSERT INTO `participants_table` (`ParticipantID`, `Firstname`, `LastName`, `email`, `Phone`, `Team_ID`, `Event_ID`) VALUES
(1, 'Frouen', 'Medina Jr.', 'frouenmedinajr@gmail.com', '09912093870', 1, 1),
(2, 'Kev', 'Carriedo', 'kev@gmail.com', '098778963', 2, 1);

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
(1, 'BasketBall', '10/10/2023', 'Intrams', 'Pavillion', '10'),
(2, 'Mobile Legends Esports', '11/10/2023', 'Intramurals', 'Mandaya', '10'),
(3, 'CSGO', '12/01/2023', 'ESPORTS', 'COMLAB', '10');

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

--
-- Dumping data for table `score_table`
--

INSERT INTO `score_table` (`ScoreID`, `Event_ID`, `ParticipantID`, `Score`) VALUES
(1, 1, 1, 89),
(2, 1, 2, 90);

-- --------------------------------------------------------

--
-- Table structure for table `team_table`
--

CREATE TABLE `team_table` (
  `Team_ID` int(255) NOT NULL,
  `Team_Name` varchar(255) NOT NULL,
  `CaptainDorPLayer_ID` int(255) NOT NULL,
  `Event_ID` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `team_table`
--

INSERT INTO `team_table` (`Team_ID`, `Team_Name`, `CaptainDorPLayer_ID`, `Event_ID`) VALUES
(1, 'BSIT', 1, 1),
(2, 'BSIT', 2, 1);

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
(1, 'WenDEVLIFE', '87d61be3fa55ac46094c18fbaf0866694f66d6394319c9485924df638822228d', 0x3daacee0fc27c1ba96c59035a1223891, 'Admin'),
(2, 'WenwenGaming', '11f261070a256889a03771712921aea63eb72aafd3a8ccaa118c762bb41c23e5', 0xf081dbd2cfe36d0a957955016e68d3de, 'Admin'),
(3, 'Wenjudge', '88eece60f096dbe29883ec974c5e318521ee1174f6ee66a809a314e5060b537f', 0x79f93e257a25541317638497684d3239, 'Judge');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `participants_table`
--
ALTER TABLE `participants_table`
  ADD PRIMARY KEY (`ParticipantID`),
  ADD KEY `idx_Team_ID` (`Team_ID`),
  ADD KEY `fk_participants_table` (`Event_ID`);

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
  ADD PRIMARY KEY (`Team_ID`),
  ADD KEY `fk_team_table` (`Event_ID`);

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
  MODIFY `ParticipantID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

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
-- Constraints for table `participants_table`
--
ALTER TABLE `participants_table`
  ADD CONSTRAINT `fk_participants_event` FOREIGN KEY (`Event_ID`) REFERENCES `pwc_event_table` (`Event_ID`),
  ADD CONSTRAINT `fk_participants_table` FOREIGN KEY (`Event_ID`) REFERENCES `pwc_event_table` (`Event_ID`);

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
  ADD CONSTRAINT `fk_Team_ID` FOREIGN KEY (`Team_ID`) REFERENCES `participants_table` (`Team_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_team_table` FOREIGN KEY (`Event_ID`) REFERENCES `pwc_event_table` (`Event_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
