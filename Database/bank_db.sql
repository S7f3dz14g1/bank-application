-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 15 Maj 2020, 15:21
-- Wersja serwera: 10.1.26-MariaDB
-- Wersja PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `bank_db`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `clients`
--

CREATE TABLE `clients` (
  `id` int(10) NOT NULL,
  `nick` varchar(12) COLLATE utf8_polish_ci NOT NULL,
  `first_name` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `last_name` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(12) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `phone` varchar(12) COLLATE utf8_polish_ci NOT NULL,
  `money` decimal(13,2) DEFAULT NULL,
  `account_number` varchar(12) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `clients`
--

INSERT INTO `clients` (`id`, `nick`, `first_name`, `last_name`, `password`, `email`, `phone`, `money`, `account_number`) VALUES
(1, 'Adam55', 'Adam', 'Kowalski', '1234admin', 'kowal@gmail.com', '123456789', '128857.00', 'PL4900012990'),
(2, 'Panda', 'Marian', 'Paździoch', 'Marian123', 'marian@gmail.com', '111222333', '128640.00', 'PL4954706070'),
(3, 'z0sia', 'Marta', 'Bęcwałók', 'łók12345', 'marta@gmail.com', '222333444', '100000.00', 'PL4916242468');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
