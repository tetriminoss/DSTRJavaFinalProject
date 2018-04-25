-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2018 at 08:58 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `printmarketing`
--

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `agentId` int(11) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `streetNumber` int(20) NOT NULL,
  `streetName` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `province` varchar(50) NOT NULL,
  `postalCode` varchar(20) NOT NULL,
  `telOffice` varchar(20) NOT NULL,
  `telCell` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `company` varchar(50) NOT NULL,
  `companyType` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`id`, `agentId`, `firstName`, `lastName`, `streetNumber`, `streetName`, `city`, `province`, `postalCode`, `telOffice`, `telCell`, `email`, `company`, `companyType`) VALUES
(1, 11, 'Jamessss', 'Smith', 99, 'Nine Street', 'Mississauga', 'Ontario', 'M7A 1F6', '905-555-9999', '905-666-7777', 'james@email.com', 'James Tech', 'Technology'),
(3, 16, 'Jimbo', 'Jimms', 878, 'Fake Street', 'Vaughan', 'Ontario', 'M7C 9U9', '416-999-6666', '647-280-5454', 'jimbo@hotmail.com', 'Jimbo Corp', 'Food Service'),
(5, 16, 'Jane', 'Plane', 99, 'Nine Avenue', 'Montreal', 'QC', 'L4L 5F6', '287-999-6655', '289-999-9999', 'planeJane@hotmail.com', 'Plane Inc', 'Landscaping'),
(6, 16, 'Adel', 'Adel', 22, 'Adel', 'Toronto', 'Ontario', 'm9v1n5', '222222', '222222', 'adel@mail.com', 'News', 'News');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `locationName` varchar(100) NOT NULL,
  `distributionCapacity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id`, `locationName`, `distributionCapacity`) VALUES
(2, 'Toronto', 555),
(3, 'Durham Region', 555),
(4, 'Mississauga', 4000),
(5, 'York Region', 555);

-- --------------------------------------------------------

--
-- Table structure for table `locationxorders`
--

CREATE TABLE `locationxorders` (
  `id` int(11) NOT NULL,
  `orderId` int(11) NOT NULL,
  `locationId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `locationxorders`
--

INSERT INTO `locationxorders` (`id`, `orderId`, `locationId`) VALUES
(1, 3, 2),
(2, 4, 4),
(9, 5, 3),
(14, 12, 2),
(15, 7, 3);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(50) NOT NULL,
  `agentId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `userName`, `password`, `role`, `agentId`) VALUES
(1, 'Ryan', 'Ryan', 'admin', 11),
(2, 'Adel', 'Adel', 'admin', 13),
(3, 'Michael', 'Michael', 'admin', 14),
(4, 'Jason', 'Jason', 'admin', 15),
(5, 'John', 'John', 'agent', 16),
(8, 'Jane', 'Jane', 'agent', 17),
(9, 'Nancy', 'Nancy', 'agent', 18),
(11, 'Jon', 'Jo', 'agent', 18),
(12, 'Jim', 'Jim', 'agent', 14);

-- --------------------------------------------------------

--
-- Table structure for table `marketingagent`
--

CREATE TABLE `marketingagent` (
  `id` int(11) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `phoneNo` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `marketingagent`
--

INSERT INTO `marketingagent` (`id`, `firstName`, `lastName`, `phoneNo`, `email`) VALUES
(11, 'Ryan', 'Ryans', '416-999-9999', 'ryan@ryans.com'),
(13, 'Adel', 'Adels', '666', 'adel@email.com'),
(14, 'Michael', 'Michaels', '999', 'mike@email.com'),
(15, 'Jason', 'Jasons', '888', 'jason@hotmail.com'),
(16, 'John', 'Johns', '905-999-6666', 'john@email.com'),
(17, 'Jane', 'Janes', '905-999-9999', 'jane@email.com'),
(18, 'Nancy', 'Nancys', '905-666-7777', 'nancy@email.com');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `agentId` int(11) NOT NULL,
  `clientId` int(11) NOT NULL,
  `flyerQty` int(11) NOT NULL,
  `flyerLayout` varchar(50) NOT NULL,
  `flyerImg` blob NOT NULL,
  `personalCopy` int(11) NOT NULL,
  `paymentInformation` varchar(100) NOT NULL,
  `invoiceNumber` varchar(100) NOT NULL,
  `comments` varchar(200) NOT NULL,
  `isFlyerArtApproved` tinyint(1) NOT NULL,
  `isPaymentReceived` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `agentId`, `clientId`, `flyerQty`, `flyerLayout`, `flyerImg`, `personalCopy`, `paymentInformation`, `invoiceNumber`, `comments`, `isFlyerArtApproved`, `isPaymentReceived`) VALUES
(3, 16, 1, 55, 'Portrait', 0x706b2e706e67, 5, '4506552293891177 11/09 553', '203', 'this is a test', 0, 0),
(4, 16, 3, 999, 'Landscape', 0x77702e706e67, 77, '4505 5559 9999 4411 12/21 335', '675', 'this is a test again', 0, 0),
(5, 16, 3, 555, 'Landscape', 0x706b2e706e67, 55, '4554545646456464 11/25 555', '239', 'comment', 1, 1),
(7, 16, 3, 555, 'Both', 0x706b2e706e67, 55, '4505 5555 9999 7 77 12 19 ', '518', 'this is a comment', 1, 0),
(12, 16, 3, 555, 'Portrait', 0x77702e706e67, 66, '4505555522221111 11/22 333', '542', 'comm', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `clients_agentId` (`agentId`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `locationxorders`
--
ALTER TABLE `locationxorders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `locationXordersOrderId` (`orderId`),
  ADD KEY `locationXordersLocationId` (`locationId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `userName` (`userName`),
  ADD KEY `agentId` (`agentId`);

--
-- Indexes for table `marketingagent`
--
ALTER TABLE `marketingagent`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ordersAgentId` (`agentId`),
  ADD KEY `ordersClientId` (`clientId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `locationxorders`
--
ALTER TABLE `locationxorders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `marketingagent`
--
ALTER TABLE `marketingagent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `clientsAgentId` FOREIGN KEY (`agentId`) REFERENCES `marketingagent` (`id`);

--
-- Constraints for table `locationxorders`
--
ALTER TABLE `locationxorders`
  ADD CONSTRAINT `locationXordersLocationId` FOREIGN KEY (`locationId`) REFERENCES `location` (`id`),
  ADD CONSTRAINT `locationXordersOrderId` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`);

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `loginAgentId` FOREIGN KEY (`agentId`) REFERENCES `marketingagent` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `ordersAgentId` FOREIGN KEY (`agentId`) REFERENCES `marketingagent` (`id`),
  ADD CONSTRAINT `ordersClienttId` FOREIGN KEY (`clientId`) REFERENCES `clients` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
