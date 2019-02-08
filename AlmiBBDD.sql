-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-02-2019 a las 14:41:58
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sara_baras`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnoasignatura`
--

CREATE TABLE `alumnoasignatura` (
  `idAlumnoAsignatura` int(11) NOT NULL,
  `alumno` int(11) NOT NULL,
  `asignatura` int(11) NOT NULL,
  `faltas` int(11) NOT NULL,
  `notas` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumnoasignatura`
--

INSERT INTO `alumnoasignatura` (`idAlumnoAsignatura`, `alumno`, `asignatura`, `faltas`, `notas`) VALUES
(1, 22, 6, 83, 1),
(2, 29, 1, 47, 1),
(3, 39, 6, 87, 4),
(4, 33, 4, 122, 10),
(5, 15, 2, 55, 2),
(6, 47, 4, 18, 9),
(7, 40, 7, 30, 8),
(8, 36, 2, 51, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnomatricula`
--

CREATE TABLE `alumnomatricula` (
  `idAlumnoMatricula` int(11) NOT NULL,
  `alumno` int(11) NOT NULL,
  `matricula` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumnomatricula`
--

INSERT INTO `alumnomatricula` (`idAlumnoMatricula`, `alumno`, `matricula`) VALUES
(1, 10, 'a542'),
(2, 11, 'a543'),
(3, 12, 'a544'),
(4, 13, 'a545'),
(5, 14, 'a546'),
(6, 15, 'a547'),
(7, 16, 'a548'),
(8, 17, 'a549'),
(9, 18, 'a550'),
(10, 19, 'a551'),
(11, 20, 'a552'),
(12, 21, 'a553'),
(13, 22, 'a554'),
(14, 23, 'a555'),
(15, 24, 'a556'),
(16, 25, 'a557'),
(17, 26, 'a558'),
(18, 27, 'a559'),
(19, 28, 'a560'),
(20, 29, 'a561'),
(21, 30, 'a562'),
(22, 31, 'a563'),
(23, 32, 'a564'),
(24, 33, 'a565'),
(25, 34, 'a566'),
(26, 35, 'a567'),
(27, 36, 'a568'),
(28, 37, 'a569'),
(29, 38, 'a570'),
(30, 39, 'a571'),
(31, 40, 'a572'),
(32, 41, 'a573'),
(33, 42, 'a574'),
(34, 43, 'a575'),
(35, 44, 'a576'),
(36, 45, 'a577'),
(37, 46, 'a578'),
(38, 47, 'a579'),
(39, 48, 'a580'),
(40, 49, 'a581'),
(41, 50, 'a582');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE `asignatura` (
  `idAsignatura` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `docente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`idAsignatura`, `nombre`, `docente`) VALUES
(1, 'Base de datos', 1),
(2, 'programacion', 2),
(3, 'ingles', 3),
(4, 'fol', 4),
(5, 'entornos de desarrollo', 5),
(6, 'lenguaje de marcas', 6),
(7, 'sistemas', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulas`
--

CREATE TABLE `aulas` (
  `idAula` int(11) NOT NULL,
  `nombre` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aulas`
--

INSERT INTO `aulas` (`idAula`, `nombre`) VALUES
(1, 'aula 1'),
(2, 'aula 2'),
(3, 'aula 3'),
(4, 'aula 4'),
(5, 'aula 5'),
(6, 'aula 6'),
(7, 'aula 7');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursoasignatura`
--

CREATE TABLE `cursoasignatura` (
  `idCursoAsignatura` int(11) NOT NULL,
  `curso` int(11) NOT NULL,
  `asignatura` int(11) NOT NULL,
  `dia` int(11) NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cursoasignatura`
--

INSERT INTO `cursoasignatura` (`idCursoAsignatura`, `curso`, `asignatura`, `dia`, `hora`) VALUES
(1, 1, 1, 5, '11:29:00'),
(2, 2, 2, 1, '01:56:00'),
(3, 3, 3, 5, '01:31:00'),
(4, 4, 4, 4, '08:06:00'),
(5, 5, 5, 1, '01:26:00'),
(6, 6, 6, 6, '01:13:00'),
(7, 7, 7, 1, '12:42:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `idCurso` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `precio` float NOT NULL,
  `comienzo` date NOT NULL,
  `fin` date NOT NULL,
  `horas` int(11) NOT NULL,
  `modalidad` int(11) NOT NULL,
  `aula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`idCurso`, `nombre`, `precio`, `comienzo`, `fin`, `horas`, `modalidad`, `aula`) VALUES
(1, 'Desarrollo de aplicaciones multiplataforma 1', 500, '2018-09-07', '2019-05-29', 960, 3, 1),
(2, 'Desarrollo de aplicaciones multiplataforma 2', 500, '2018-09-07', '2019-05-29', 1040, 3, 2),
(3, 'Gestión Administrativa 1', 500, '2018-09-07', '2019-05-29', 990, 2, 3),
(4, 'Cuidados Auxiliares de Enfermería 1', 500, '2018-09-07', '2019-05-29', 694, 2, 4),
(5, 'Sistemas Microinformáticos y Redes 1', 500, '2018-09-07', '2019-05-29', 990, 2, 5),
(6, 'Laboratorio Clínico y Biomédico 1', 500, '2018-09-07', '2019-05-29', 990, 3, 5),
(7, 'Integración Social 1', 500, '2018-09-07', '2019-05-29', 990, 3, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dias`
--

CREATE TABLE `dias` (
  `idDia` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `dias`
--

INSERT INTO `dias` (`idDia`, `nombre`) VALUES
(1, 'Lunes'),
(2, 'Martes'),
(3, 'Miercoles'),
(4, 'Jueves'),
(5, 'Viernes'),
(6, 'Sabado'),
(7, 'Domingo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `idHorario` int(11) NOT NULL,
  `cursoAsignatura` int(11) NOT NULL,
  `dia` int(11) NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`idHorario`, `cursoAsignatura`, `dia`, `hora`) VALUES
(1, 1, 1, '08:32:00'),
(2, 2, 2, '12:33:00'),
(3, 3, 3, '12:55:00'),
(4, 4, 4, '08:51:00'),
(5, 5, 5, '12:01:00'),
(6, 6, 6, '09:04:00'),
(7, 7, 7, '10:31:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modalidades`
--

CREATE TABLE `modalidades` (
  `idModalidad` int(11) NOT NULL,
  `nombre` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `modalidades`
--

INSERT INTO `modalidades` (`idModalidad`, `nombre`) VALUES
(1, 'Formación Profesional Básica'),
(2, 'Ciclos Formativos de Grado Medio'),
(3, 'Ciclos Formativos de Grado Superior'),
(4, 'Formación para el empleo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE `perfiles` (
  `idPerfil` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `apellido` text NOT NULL,
  `dni` text NOT NULL,
  `nacimiento` date NOT NULL,
  `provincia` int(11) NOT NULL,
  `genero` varchar(4000) NOT NULL,
  `telefono` int(11) NOT NULL,
  `calle` varchar(4000) NOT NULL,
  `avatar` mediumtext NOT NULL,
  `docente` tinyint(1) NOT NULL,
  `alumno` tinyint(1) NOT NULL,
  `delegado` tinyint(1) NOT NULL,
  `tutor` tinyint(1) NOT NULL,
  `sueldo` float DEFAULT NULL,
  `usuario` text,
  `password` text,
  `email` varchar(4545) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `perfiles`
--

INSERT INTO `perfiles` (`idPerfil`, `tipo`, `nombre`, `apellido`, `dni`, `nacimiento`, `provincia`, `genero`, `telefono`, `calle`, `avatar`, `docente`, `alumno`, `delegado`, `tutor`, `sueldo`, `usuario`, `password`, `email`) VALUES
(1, 2, 'Virginia', 'Aleksashin', '78945451R', '0000-00-00', 1, 'F', 286, '162 Delaware Court', 'https://robohash.org/etreiciendisomnis.png?size=500x500&set=set1', 1, 0, 1, 0, 1500, 'VirAlmi', 'Almi123', 'VirAlmi@almi.eus'),
(2, 2, 'Rober', 'Joint', '98545451R', '0000-00-00', 2, 'M', 811, '62135 Rutledge Lane', 'https://robohash.org/quiaveniamiste.png?size=500x500&set=set1', 1, 0, 1, 0, 1500, 'RobAlmi', 'Almi123', 'RobAlmi@almi.eus'),
(3, 2, 'Maria', 'Putten', '48945451R', '0000-00-00', 3, 'F', 757, '5 Glendale Terrace', 'https://robohash.org/architectoesteos.png?size=500x500&set=set1', 1, 0, 1, 0, 1500, 'MarAlmi', 'Almi123', 'MarAlmi@almi.eus'),
(4, 2, 'Ander', 'Brunstan', '55545451R', '0000-00-00', 4, 'F', 560, '8 Mallard Road', 'https://robohash.org/etdignissimossed.png?size=500x500&set=set1', 1, 0, 1, 1, 1500, 'AndAlmi', 'Almi123', 'AndAlmi@almi.eus'),
(5, 2, 'Iñigo', 'Lumbly', '78945571R', '0000-00-00', 5, 'F', 573, '253 Mayer Point', 'https://robohash.org/utrecusandaenihil.png?size=500x500&set=set1', 1, 0, 1, 1, 1500, 'IñAlmi', 'Almi123', 'IñAlmi@almi.eus'),
(6, 2, 'Sergio', 'Digger', '78984451R', '0000-00-00', 1, 'F', 745, '2346 Warrior Drive', 'https://robohash.org/remteneturquo.png?size=500x500&set=set1', 1, 0, 1, 1, 1500, 'SerAlmi', 'Almi123', 'SerAlmi@almi.eus'),
(7, 2, 'Maite', 'Mum', '18945451R', '0000-00-00', 2, 'M', 753, '9 Mendota Hill', 'https://robohash.org/voluptasnamharum.png?size=500x500&set=set1', 1, 0, 1, 1, 1500, 'MaiAlmi', 'Almi123', 'MaiAlmi@almi.eus'),
(8, 3, 'Dion', 'Firebrace', '22945451R', '0000-00-00', 3, 'F', 151, '8 Hollow Ridge Way', 'https://robohash.org/voluptatibusmaioresquae.png?size=500x500&set=set1', 0, 0, 0, 0, 2500, 'direcAlmi', 'Almi123', 'direcAlmi@almi.eus'),
(9, 4, 'Rodie', 'Lokier', '78955451R', '0000-00-00', 4, 'F', 260, '4850 Hanson Parkway', 'https://robohash.org/remexet.png?size=500x500&set=set1', 0, 0, 0, 0, 2000, 'subdAlmi', 'Almi123', 'subdAlmi@almi.eus'),
(10, 1, 'Ethelyn', 'Philipeau', '88945451R', '0000-00-00', 5, 'F', 943, '98404 Jenna Crossing', 'https://robohash.org/consecteturinnecessitatibus.png?size=500x500&set=set1', 0, 1, 1, 0, 0, 'alumno523', 'alumnado123', 'ephilipeau9@apache.org'),
(11, 1, 'Zola', 'Shills', '78945451R', '0000-00-00', 1, 'F', 192, '60 Oxford Junction', 'https://robohash.org/adquiaut.png?size=500x500&set=set1', 0, 1, 1, 0, 0, 'alumno524', 'alumnado124', 'zshillsa@amazon.co.jp'),
(12, 1, 'Cointon', 'Bester', '78945451R', '0000-00-00', 2, 'M', 784, '07 Muir Hill', 'https://robohash.org/ealaborumsed.png?size=500x500&set=set1', 0, 1, 1, 0, 0, 'alumno525', 'alumnado125', 'cbesterb@lycos.com'),
(13, 1, 'Gil', 'Batrop', '78945451R', '0000-00-00', 3, 'M', 930, '74685 Cherokee Alley', 'https://robohash.org/adipiscirationequae.png?size=500x500&set=set1', 0, 1, 1, 0, 0, 'alumno526', 'alumnado126', 'gbatropc@deviantart.com'),
(14, 1, 'Ruperto', 'Bridgestock', '78945451R', '0000-00-00', 4, 'M', 831, '1039 Autumn Leaf Park', 'https://robohash.org/excepturiassumendavoluptates.png?size=500x500&set=set1', 0, 1, 1, 0, 0, 'alumno527', 'alumnado127', 'rbridgestockd@slideshare.net'),
(15, 1, 'Alli', 'Klimpke', '78945451R', '0000-00-00', 5, 'F', 624, '914 Anzinger Trail', 'https://robohash.org/delenitivoluptatesmolestias.png?size=500x500&set=set1', 0, 1, 1, 0, 0, 'alumno528', 'alumnado128', 'aklimpkee@rakuten.co.jp'),
(16, 1, 'Patrice', 'Szymonowicz', '78945451R', '0000-00-00', 1, 'F', 397, '9105 Manitowish Plaza', 'https://robohash.org/perferendisadaut.png?size=500x500&set=set1', 0, 1, 1, 0, 0, 'alumno529', 'alumnado129', 'pszymonowiczf@unc.edu'),
(17, 1, 'Emmet', 'MacRierie', '78945451R', '0000-00-00', 2, 'M', 452, '1138 Sunfield Circle', 'https://robohash.org/exercitationemsitperferendis.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno530', 'alumnado130', 'emacrierieg@shop-pro.jp'),
(18, 1, 'Ashien', 'Longbottom', '78945451R', '0000-00-00', 3, 'F', 406, '51990 Scofield Center', 'https://robohash.org/quiestet.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno431', 'alumnado131', 'alongbottomh@edublogs.org'),
(19, 1, 'Marion', 'Bysshe', '78945451R', '0000-00-00', 4, 'M', 529, '53 Hanover Hill', 'https://robohash.org/cumqueremquia.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno432', 'alumnado132', 'mbysshei@google.com.au'),
(20, 1, 'Odey', 'Cruces', '78945451R', '0000-00-00', 5, 'M', 701, '1122 Delladonna Alley', 'https://robohash.org/consequaturmagnimaiores.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno433', 'alumnado133', 'ocrucesj@google.com.br'),
(21, 1, 'Lelia', 'Chavey', '78945451R', '0000-00-00', 1, 'F', 261, '596 Erie Terrace', 'https://robohash.org/autemundeminima.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno434', 'alumnado134', 'lchaveyk@oracle.com'),
(22, 1, 'Hendrick', 'Hazel', '78945451R', '0000-00-00', 2, 'M', 240, '03 Luster Parkway', 'https://robohash.org/voluptasetrerum.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno435', 'alumnado135', 'hhazell@hatena.ne.jp'),
(23, 1, 'Rosabelle', 'Dubose', '78945451R', '0000-00-00', 3, 'F', 267, '90 Lakeland Way', 'https://robohash.org/inventorearchitectoiure.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno436', 'alumnado136', 'rdubosem@macromedia.com'),
(24, 1, 'Lucretia', 'Runacres', '78945451R', '0000-00-00', 4, 'F', 779, '24 American Plaza', 'https://robohash.org/etdebitisut.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno437', 'alumnado137', 'lrunacresn@toplist.cz'),
(25, 1, 'Alf', 'Sarah', '78945451R', '0000-00-00', 5, 'M', 878, '68 Maple Wood Street', 'https://robohash.org/nihilestvel.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno438', 'alumnado138', 'asaraho@google.cn'),
(26, 1, 'Aylmar', 'Fawcus', '78945451R', '0000-00-00', 1, 'M', 332, '43923 John Wall Circle', 'https://robohash.org/itaqueharumet.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno439', 'alumnado139', 'afawcusp@google.com.au'),
(27, 1, 'Myles', 'O\'Scollain', '78945451R', '0000-00-00', 2, 'M', 634, '196 Sauthoff Lane', 'https://robohash.org/occaecatilaudantiumquis.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno440', 'alumnado140', 'moscollainq@liveinternet.ru'),
(28, 1, 'Ruthann', 'Poulsum', '78945451R', '0000-00-00', 3, 'F', 508, '14873 Rockefeller Plaza', 'https://robohash.org/sitipsamad.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno441', 'alumnado141', 'rpoulsumr@tumblr.com'),
(29, 1, 'Sigismund', 'Ewington', '78945451R', '0000-00-00', 4, 'M', 682, '96 Carpenter Center', 'https://robohash.org/harumveritatissint.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno442', 'alumnado142', 'sewingtons@guardian.co.uk'),
(30, 1, 'Colet', 'Zellner', '78945451R', '0000-00-00', 5, 'M', 470, '84 Roth Alley', 'https://robohash.org/nequeetdistinctio.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno222', 'alumnado143', 'czellnert@imdb.com'),
(31, 1, 'Humbert', 'Shivlin', '78945451R', '0000-00-00', 1, 'M', 446, '471 Eagan Junction', 'https://robohash.org/facerevitaead.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno223', 'alumnado144', 'hshivlinu@wikipedia.org'),
(32, 1, 'Montague', 'Levens', '78945451R', '0000-00-00', 2, 'M', 289, '58 Green Crossing', 'https://robohash.org/beataeestprovident.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno224', 'alumnado145', 'mlevensv@narod.ru'),
(33, 1, 'Cairistiona', 'Mallinar', '78945451R', '0000-00-00', 3, 'F', 664, '9 Heffernan Way', 'https://robohash.org/enimoditqui.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno225', 'alumnado146', 'cmallinarw@addtoany.com'),
(34, 1, 'Jandy', 'Browett', '78945451R', '0000-00-00', 4, 'F', 989, '1205 Brentwood Trail', 'https://robohash.org/repellatodiovel.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno226', 'alumnado147', 'jbrowettx@dyndns.org'),
(35, 1, 'Aubrette', 'Reaveley', '78945451R', '0000-00-00', 5, 'F', 818, '74761 Superior Alley', 'https://robohash.org/placeatmodidignissimos.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno227', 'alumnado148', 'areaveleyy@telegraph.co.uk'),
(36, 1, 'Faber', 'Real', '78945451R', '0000-00-00', 1, 'M', 454, '3861 Division Road', 'https://robohash.org/iustositmolestiae.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno228', 'alumnado149', 'frealz@huffingtonpost.com'),
(37, 1, 'Veradis', 'Brotherwood', '78945451R', '0000-00-00', 2, 'F', 934, '9287 Barnett Plaza', 'https://robohash.org/excepturisuntarchitecto.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno229', 'alumnado150', 'vbrotherwood10@ow.ly'),
(38, 1, 'Lenard', 'Mogra', '78945451R', '0000-00-00', 3, 'M', 686, '4520 Almo Drive', 'https://robohash.org/quibusdamquasilaboriosam.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno230', 'alumnado151', 'lmogra11@wikimedia.org'),
(39, 1, 'Tamra', 'Bilston', '78945451R', '0000-00-00', 4, 'F', 811, '03983 Dawn Hill', 'https://robohash.org/omnisestbeatae.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'alumno230', 'alumnado152', 'tbilston12@nsw.gov.au'),
(40, 1, 'Jolee', 'Gillice', '78945451R', '0000-00-00', 5, 'F', 895, '4949 Brown Pass', 'https://robohash.org/undererumcupiditate.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'jgillice13', 'alumnado153', 'jgillice13@themeforest.net'),
(41, 1, 'Stafani', 'Bartelot', '78945451R', '0000-00-00', 1, 'F', 541, '85713 Troy Plaza', 'https://robohash.org/etestaperiam.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'sbartelot14', 'alumnado154', 'sbartelot14@utexas.edu'),
(42, 1, 'Risa', 'Halfacre', '78945451R', '0000-00-00', 2, 'F', 339, '2573 Vidon Point', 'https://robohash.org/molestiaeiurevoluptates.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'rhalfacre15', 'alumnado155', 'cbrunt17@usda.gov'),
(43, 1, 'Nicola', 'Whibley', '78945451R', '0000-00-00', 3, 'F', 294, '38631 Rutledge Avenue', 'https://robohash.org/nonaliquamrerum.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'nwhibley16', 'alumnado156', 'wkwietak4w@shareasale.com'),
(44, 1, 'Corella', 'Brunt', '78945451R', '0000-00-00', 4, 'F', 816, '78472 Trailsway Junction', 'https://robohash.org/officiispossimusincidunt.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'cbrunt17', 'alumnado157', 'amayhew4x@weebly.com'),
(45, 1, 'Allard', 'Restall', '78945451R', '0000-00-00', 5, 'M', 839, '13 Vernon Street', 'https://robohash.org/architectoquasiipsam.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'arestall18', 'alumnado158', 'lfeehery4y@instagram.com'),
(46, 1, 'Beck', 'Ruppele', '78945451R', '0000-00-00', 1, 'M', 894, '41 Center Junction', 'https://robohash.org/ipsamquodet.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'bruppele19', 'alumnado159', 'rwaith4z@google.com.hk'),
(47, 1, 'Jakie', 'Simkin', '78945451R', '0000-00-00', 2, 'M', 742, '106 Manitowish Drive', 'https://robohash.org/cupiditateetducimus.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'jsimkin1a', 'alumnado160', 'fswyer50@mediafire.com'),
(48, 1, 'Glennie', 'Grimmert', '78945451R', '0000-00-00', 3, 'F', 604, '06278 Grover Avenue', 'https://robohash.org/omnisinciduntaliquid.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'ggrimmert1b', 'alumnado161', 'tcramp51@cocolog-nifty.com'),
(49, 1, 'Benedetta', 'Depport', '78945451R', '0000-00-00', 4, 'F', 959, '9 Carey Court', 'https://robohash.org/ipsacorruptiodit.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'bdepport1c', 'alumnado162', 'xmoret52@w3.org'),
(50, 1, 'Sidoney', 'De Caville', '78945451R', '0000-00-00', 5, 'F', 326, '45097 Cordelia Alley', 'https://robohash.org/perspiciatiseteligendi.png?size=500x500&set=set1', 0, 1, 0, 0, 0, 'sdecaville1d', 'alumnado163', 'ekitchiner53@yale.edu');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincias`
--

CREATE TABLE `provincias` (
  `idProvincia` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `provincias`
--

INSERT INTO `provincias` (`idProvincia`, `nombre`) VALUES
(1, 'Bizkaia'),
(2, 'Araba'),
(3, 'Gipuzkoa'),
(4, 'Nafarroa'),
(5, 'Nafarroa Behera'),
(6, 'Lapurdi'),
(7, 'Zuberoa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiposdeperfil`
--

CREATE TABLE `tiposdeperfil` (
  `idTipoDePerfil` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tiposdeperfil`
--

INSERT INTO `tiposdeperfil` (`idTipoDePerfil`, `nombre`) VALUES
(1, 'alumno'),
(2, 'docente'),
(3, 'director'),
(4, 'subdirector'),
(5, 'mantenimiento');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnoasignatura`
--
ALTER TABLE `alumnoasignatura`
  ADD PRIMARY KEY (`idAlumnoAsignatura`),
  ADD KEY `alumno` (`alumno`,`asignatura`),
  ADD KEY `asignatura` (`asignatura`);

--
-- Indices de la tabla `alumnomatricula`
--
ALTER TABLE `alumnomatricula`
  ADD PRIMARY KEY (`idAlumnoMatricula`),
  ADD KEY `alumno` (`alumno`,`matricula`),
  ADD KEY `matricula` (`matricula`);

--
-- Indices de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD PRIMARY KEY (`idAsignatura`),
  ADD KEY `profesor` (`docente`);

--
-- Indices de la tabla `aulas`
--
ALTER TABLE `aulas`
  ADD PRIMARY KEY (`idAula`);

--
-- Indices de la tabla `cursoasignatura`
--
ALTER TABLE `cursoasignatura`
  ADD PRIMARY KEY (`idCursoAsignatura`),
  ADD KEY `dia` (`dia`),
  ADD KEY `curso` (`curso`,`asignatura`),
  ADD KEY `asignatura` (`asignatura`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`idCurso`),
  ADD KEY `modalidad` (`modalidad`,`aula`),
  ADD KEY `aula` (`aula`);

--
-- Indices de la tabla `dias`
--
ALTER TABLE `dias`
  ADD PRIMARY KEY (`idDia`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`idHorario`),
  ADD KEY `dia` (`dia`),
  ADD KEY `cursoAsignatura` (`cursoAsignatura`);

--
-- Indices de la tabla `modalidades`
--
ALTER TABLE `modalidades`
  ADD PRIMARY KEY (`idModalidad`);

--
-- Indices de la tabla `perfiles`
--
ALTER TABLE `perfiles`
  ADD PRIMARY KEY (`idPerfil`),
  ADD KEY `tipo` (`tipo`,`provincia`),
  ADD KEY `provincia` (`provincia`);

--
-- Indices de la tabla `provincias`
--
ALTER TABLE `provincias`
  ADD PRIMARY KEY (`idProvincia`);

--
-- Indices de la tabla `tiposdeperfil`
--
ALTER TABLE `tiposdeperfil`
  ADD PRIMARY KEY (`idTipoDePerfil`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnoasignatura`
--
ALTER TABLE `alumnoasignatura`
  MODIFY `idAlumnoAsignatura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `alumnomatricula`
--
ALTER TABLE `alumnomatricula`
  MODIFY `idAlumnoMatricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  MODIFY `idAsignatura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `aulas`
--
ALTER TABLE `aulas`
  MODIFY `idAula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `cursoasignatura`
--
ALTER TABLE `cursoasignatura`
  MODIFY `idCursoAsignatura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `cursos`
--
ALTER TABLE `cursos`
  MODIFY `idCurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `dias`
--
ALTER TABLE `dias`
  MODIFY `idDia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `idHorario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `modalidades`
--
ALTER TABLE `modalidades`
  MODIFY `idModalidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `perfiles`
--
ALTER TABLE `perfiles`
  MODIFY `idPerfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT de la tabla `provincias`
--
ALTER TABLE `provincias`
  MODIFY `idProvincia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tiposdeperfil`
--
ALTER TABLE `tiposdeperfil`
  MODIFY `idTipoDePerfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnoasignatura`
--
ALTER TABLE `alumnoasignatura`
  ADD CONSTRAINT `alumnoasignatura_ibfk_1` FOREIGN KEY (`asignatura`) REFERENCES `asignatura` (`idAsignatura`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `alumnoasignatura_ibfk_2` FOREIGN KEY (`alumno`) REFERENCES `perfiles` (`idPerfil`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `alumnomatricula`
--
ALTER TABLE `alumnomatricula`
  ADD CONSTRAINT `alumnomatricula_ibfk_2` FOREIGN KEY (`alumno`) REFERENCES `perfiles` (`idPerfil`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `cursoasignatura`
--
ALTER TABLE `cursoasignatura`
  ADD CONSTRAINT `cursoasignatura_ibfk_1` FOREIGN KEY (`dia`) REFERENCES `dias` (`idDia`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cursoasignatura_ibfk_2` FOREIGN KEY (`asignatura`) REFERENCES `asignatura` (`idAsignatura`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cursoasignatura_ibfk_3` FOREIGN KEY (`curso`) REFERENCES `cursos` (`idCurso`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`aula`) REFERENCES `aulas` (`idAula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cursos_ibfk_2` FOREIGN KEY (`modalidad`) REFERENCES `modalidades` (`idModalidad`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`dia`) REFERENCES `dias` (`idDia`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `horarios_ibfk_2` FOREIGN KEY (`cursoAsignatura`) REFERENCES `cursoasignatura` (`idCursoAsignatura`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `perfiles`
--
ALTER TABLE `perfiles`
  ADD CONSTRAINT `perfiles_ibfk_1` FOREIGN KEY (`provincia`) REFERENCES `provincias` (`idProvincia`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `perfiles_ibfk_2` FOREIGN KEY (`tipo`) REFERENCES `tiposdeperfil` (`idTipoDePerfil`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
