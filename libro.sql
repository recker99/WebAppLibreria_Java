-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2024 a las 21:06:37
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `libreria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `id_libro` bigint(20) NOT NULL,
  `ISBN` varchar(20) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `editorial` varchar(100) NOT NULL,
  `precio` int(11) NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id_libro`, `ISBN`, `titulo`, `autor`, `editorial`, `precio`, `fecha_registro`) VALUES
(1, '978-0140449136', 'The Odyssey', 'Homer', 'Penguin Classics', 1500, '2024-11-01 13:30:00'),
(2, '978-0192833983', 'The Iliad', 'Homer', 'Oxford University Press', 1600, '2024-11-02 15:45:00'),
(3, '978-0679783275', 'Pride and Prejudice', 'Jane Austen', 'Modern Library', 1200, '2024-11-03 17:15:00'),
(4, '978-0451524935', '1984', 'George Orwell', 'Signet Classics', 1800, '2024-11-04 12:00:00'),
(5, '978-0743273565', 'The Great Gatsby', 'F. Scott Fitzgerald', 'Scribner', 1400, '2024-11-05 14:20:00'),
(6, '978-0307277671', 'To Kill a Mockingbird', 'Harper Lee', 'Harper Perennial', 1300, '2024-11-06 18:30:00'),
(7, '978-0385490818', 'Beloved', 'Toni Morrison', 'Vintage', 1700, '2024-11-07 16:50:00'),
(8, '978-0142437230', 'Moby-Dick', 'Herman Melville', 'Penguin Classics', 1900, '2024-11-08 19:40:00'),
(9, '978-0486280615', 'The Picture of Dorian Gray', 'Oscar Wilde', 'Dover Publications', 1100, '2024-11-09 20:00:00'),
(10, '978-0143128540', 'Jane Eyre', 'Charlotte Brontë', 'Penguin Classics', 1500, '2024-11-10 22:25:00'),
(13, '878-0140449136', 'geometria', 'Baldor', 'Editorial ivrea', 5000, '2024-11-18 16:03:46'),
(14, '9788420471839', 'Aylen', 'Julio Cortázar', 'ivrea', 1000, '2024-11-18 16:09:33'),
(15, '123456789', 'josecito', 'josecito', 'planeta', 10000, '2024-11-18 16:12:28'),
(16, '9876543210', 'ciencias', 'Ivan', 'hasbro', 10000, '2024-11-18 19:34:03');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id_libro`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `id_libro` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
