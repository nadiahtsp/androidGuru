-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2019 at 12:07 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `maticeh`
--

-- --------------------------------------------------------

--
-- Table structure for table `absen`
--

CREATE TABLE `absen` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `id_pemesanan` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `absen`
--

INSERT INTO `absen` (`id`, `id_pemesanan`, `status`, `created_at`, `updated_at`) VALUES
(3, 4, 1, '2019-05-21 17:00:56', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `bahan_ajar`
--

CREATE TABLE `bahan_ajar` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `id_guru` int(11) NOT NULL,
  `id_mapel` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `bahan_ajar`
--

INSERT INTO `bahan_ajar` (`id`, `id_guru`, `id_mapel`, `created_at`, `updated_at`) VALUES
(1, 44, 1, NULL, NULL),
(2, 44, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `guru`
--

CREATE TABLE `guru` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `id_guru` int(11) NOT NULL,
  `institusi` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `direktori_cv` varchar(70) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `guru`
--

INSERT INTO `guru` (`id`, `id_guru`, `institusi`, `direktori_cv`, `created_at`, `updated_at`) VALUES
(1, 2, 'PNJ', NULL, '2019-04-30 17:00:00', NULL),
(2, 7, 'PNJ', 'cv\\_Ch4 Basic_classification_unlocked.pdf', NULL, NULL),
(3, 18, 'PNJ', '/assets/cv\\_Ch3 Data_exploration_unlocked.pdf', NULL, NULL),
(4, 19, 'PNJ', '\\assets\\cv\\_Ch3 Data_exploration_unlocked.pdf', NULL, NULL),
(5, 20, '', 'cv\\_Ch2 Data Prepocessing_unlocked.pdf', NULL, NULL),
(6, 21, '', 'cv\\_Ch2 Data_unlocked.pdf', NULL, NULL),
(7, 22, '', 'cv\\_Ch2 Data Prepocessing_unlocked.pdf', NULL, NULL),
(8, 24, '', 'cv\\_Ch3 Data_exploration_unlocked.pdf', NULL, NULL),
(9, 25, '', 'cv\\_Ch1 Introduction_unlocked.pdf', NULL, NULL),
(10, 27, '', 'cv\\CV Muhammad Reza Pahlevi Y.pdf', NULL, NULL),
(11, 28, '', 'cv\\CV_nadiah_tsamara_pratiwi.pdf', NULL, NULL),
(12, 29, '', 'cv\\CV Muhammad Reza Pahlevi Y.pdf', NULL, NULL),
(13, 30, '', 'cv\\CV Muhammad Reza Pahlevi Y.pdf', NULL, NULL),
(14, 31, '', 'cv\\CV Muhammad Reza Pahlevi Y.pdf', NULL, NULL),
(15, 32, '', 'cv\\CV Muhammad Reza Pahlevi Y.pdf', NULL, NULL),
(16, 33, '', 'cv\\CV_nadiah_tsamara_pratiwi.pdf', NULL, NULL),
(17, 34, '', 'cv\\CV Muhammad Reza Pahlevi Y.pdf', NULL, NULL),
(18, 36, 'Politeknik Negeri Jakarta', 'cv\\CV Muhammad Reza Pahlevi Y.pdf', NULL, NULL),
(19, 44, 'Politeknik Negeri Jakarta', 'cv\\CV Muhammad Reza Pahlevi Y.pdf', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `jadwal_available`
--

CREATE TABLE `jadwal_available` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `id_guru` int(11) NOT NULL,
  `hari` date NOT NULL,
  `sesi` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `mata_pelajaran`
--

CREATE TABLE `mata_pelajaran` (
  `id` int(11) NOT NULL,
  `nama_mapel` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jenjang` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `mata_pelajaran`
--

INSERT INTO `mata_pelajaran` (`id`, `nama_mapel`, `jenjang`) VALUES
(1, 'IPA SD', 'SD'),
(2, 'IPS SD', 'SD'),
(3, 'BAHASA INGGRIS SD', 'SD'),
(4, 'BAHASA INDONESIA SD', 'SD'),
(5, 'MATEMATIKA SD', 'SD'),
(6, 'BAHASA ARAB SD', 'SD'),
(7, 'KOMPUTER SD', 'SD'),
(8, 'KEWARGANEGARAAN SD', 'SD'),
(9, 'PENGETAHUAN UMUM SD', 'SD'),
(10, 'AGAMA ISLAM SD', 'SD'),
(11, 'AGAMA KRISTEN SD', 'SD'),
(12, 'AGAMA KATOLIK SD', 'SD'),
(13, 'AGAMA HINDU SD', 'SD'),
(14, 'AGAMA BUDHA SD', 'SD'),
(15, 'SENI RUPA SD', 'SD'),
(16, 'SENI MUSIK SD', 'SD'),
(17, 'SENI TARI SD', 'SD'),
(18, 'SENI SASTRA SD', 'SD'),
(19, 'SENI DRAMA SD', 'SD'),
(20, 'IPA SMP', 'SMP'),
(21, 'IPS SMP', 'SMP'),
(22, 'BAHASA INGGRIS SMP', 'SMP'),
(23, 'BAHASA INDONESIA SMP', 'SMP'),
(24, 'BAHASA ARAB SMP', 'SMP'),
(25, 'MATEMATIKA SMP', 'SMP'),
(26, 'FISIKA SMP', 'SMP'),
(27, 'BIOLOGI SMP', 'SMP'),
(28, 'KIMIA SMP', 'SMP'),
(29, 'KOMPUTER SMP', 'SMP'),
(30, 'KEWARGANEGARAAN SMP', 'SMP'),
(31, 'GEOGRAFI SMP', 'SMP'),
(32, 'EKONOMI SMP', 'SMP'),
(33, 'SEJARAH SMP', 'SMP'),
(34, 'SEJARAH ISLAM SMP', 'SMP'),
(35, 'FIQIH SMP', 'SMP'),
(36, 'TAFSIR HADITS SMP', 'SMP'),
(37, 'AQIDAH AKHLAK SMP', 'SMP'),
(38, 'AGAMA ISLAM SMP', 'SMP'),
(39, 'AGAMA KRISTEN SMP', 'SMP'),
(40, 'AGAMA KATOLIK SMP', 'SMP'),
(41, 'AGAMA HINDU SMP', 'SMP'),
(42, 'AGAMA BUDHA SMP', 'SMP'),
(43, 'SENI RUPA SMP', 'SMP'),
(44, 'SENI MUSIK SMP', 'SMP'),
(45, 'SENI TARI SMP', 'SMP'),
(46, 'SENI SASTRA SMP', 'SMP'),
(47, 'SENI DRAMA SMP', 'SMP'),
(48, 'TATA BUSANA SMP', 'SMP'),
(49, 'MATEMATIKA IPA SMA', 'SMA'),
(50, 'MATEMATIKA IPS SMA', 'SMA'),
(51, 'MATEMATIKA SMA', 'SMA'),
(52, 'MATEMATIKA FISIKA KIMIA SMA', 'SMA'),
(53, 'STATISTIKA SMA', 'SMA'),
(54, 'GEOGRAFI SMA', 'SMA'),
(55, 'EKONOMI SMA', 'SMA'),
(56, 'SOSIOLOGI SMA', 'SMA'),
(57, 'AKUNTANSI SMA', 'SMA'),
(58, 'ADMINISTRASI PERKANTORAN SMA', 'SMA'),
(59, 'FISIKA SMA', 'SMA'),
(60, 'BIOLOGI SMA', 'SMA'),
(61, 'KIMIA SMA', 'SMA'),
(62, 'ELEKTRONIKA/LISTRIK SMA', 'SMA'),
(63, 'TEKNIK OTOMOTIF SMA', 'SMA'),
(64, 'PENULISAN KARYA ILMIAH SMA', 'SMA'),
(65, 'BAHASA INGGRIS SMA', 'SMA'),
(66, 'BAHASA INDONESIA SMA', 'SMA'),
(67, 'BAHASA ARAB SMA', 'SMA'),
(68, 'BAHASA SPANYOL SMA', 'SMA'),
(69, 'BAHASA JEPANG SMA', 'SMA'),
(70, 'BAHASA JERMAN SMA', 'SMA'),
(71, 'BAHASA PERANCIS SMA', 'SMA'),
(72, 'BAHASA MANDARIN SMA', 'SMA'),
(73, 'KOMPUTER SMA', 'SMA'),
(74, 'KEWARGANEGARAAN SMA', 'SMA'),
(75, 'SEJARAH SMA', 'SMA'),
(76, 'SEJARAH ISLAM SMA', 'SMA'),
(77, 'FIQIH SMA', 'SMA'),
(78, 'TAFSIR HADITS SMA', 'SMA'),
(79, 'AQIDAH AKHLAK SMA', 'SMA'),
(80, 'AGAMA ISLAM SMA', 'SMA'),
(81, 'AGAMA KRISTEN SMA', 'SMA'),
(82, 'AGAMA KATOLIK SMA', 'SMA'),
(83, 'AGAMA HINDU SMA', 'SMA'),
(84, 'AGAMA BUDHA SMA', 'SMA'),
(85, 'SENI RUPA SMA', 'SMA'),
(86, 'SENI MUSIK SMA', 'SMA'),
(87, 'SENI TARI SMA', 'SMA'),
(88, 'SENI SASTRA SMA', 'SMA'),
(89, 'SENI DRAMA SMA', 'SMA'),
(90, 'MATEMATIKA SBMPTN SMA', 'SMA'),
(91, 'BAHASA INGGRIS SBMPTN SMA', 'SMA'),
(92, 'BAHASA INDONESIA SBMPTN SMA', 'SMA'),
(93, 'IPA TERPADU SBMPTN SMA', 'SMA'),
(94, 'IPS TERPADU SBMPTN SMA', 'SMA'),
(95, 'FISIKA SBMPTN SMA', 'SMA'),
(96, 'BIOLOGI SBMPTN SMA', 'SMA'),
(97, 'KIMIA SBMPTN SMA', 'SMA'),
(98, 'GEOGRAFI SBMPTN SMA', 'SMA'),
(99, 'EKONOMI SBMPTN SMA', 'SMA'),
(100, 'SOSIOLOGI SBMPTN SMA', 'SMA'),
(101, 'SEJARAH SBMPTN SMA', 'SMA'),
(102, 'MEMBACA TK/PAUD', 'TK/PAUD'),
(103, 'MENULIS TK/PAUD', 'TK/PAUD'),
(104, 'BERHITUNG TK/PAUD', 'TK/PAUD'),
(105, 'CALISTUNG TK/PAUD', 'TK/PAUD'),
(106, 'BAHASA INGGRIS TK/PAUD', 'TK/PAUD'),
(107, 'KOMPUTER TK/PAUD', 'TK/PAUD'),
(108, 'MEWARNAI TK/PAUD', 'TK/PAUD'),
(109, 'MENGGAMBAR TK/PAUD', 'TK/PAUD'),
(110, 'MENARI TK/PAUD', 'TK/PAUD'),
(111, 'AKUNTANSI', 'UNIVERSITAS'),
(112, 'TEKNIK SIPIL', 'UNIVERSITAS'),
(113, 'MANAJEMEN MAKANAN', 'UNIVERSITAS'),
(114, 'NUTRISI KLINIS', 'UNIVERSITAS'),
(115, 'MANAJEMEN KEUANGAN', 'UNIVERSITAS'),
(116, 'EKONOMI SYARIAH', 'UNIVERSITAS'),
(117, 'STATISTIKA', 'UNIVERSITAS'),
(118, 'PENDIDIKAN FISIKA', 'UNIVERSITAS'),
(119, 'PELATIHAN MIKROSKOPI', 'UNIVERSITAS'),
(120, 'FISIOLOGI TUBUH MANUSIA', 'UNIVERSITAS'),
(121, 'PEMERIKSAAN FISIK', 'UNIVERSITAS'),
(122, 'NEUROLOGI', 'UNIVERSITAS'),
(123, 'ELEKTROKARDIOGRAFI', 'UNIVERSITAS'),
(124, 'AUSKALTASI JANTUNG/PARU', 'UNIVERSITAS'),
(125, 'KETERAMPILAN KLINIK DASAR', 'UNIVERSITAS'),
(126, 'FIQIH', 'UNIVERSITAS'),
(127, 'TAFSIR HADITS', 'UNIVERSITAS'),
(128, 'AQIDAH AKHLAK', 'UNIVERSITAS'),
(129, 'SEJARAH ISLAM', 'UNIVERSITAS'),
(130, 'ILMU KOMUNIKASI', 'UNIVERSITAS'),
(131, 'ILMU SOSIAL', 'UNIVERSITAS'),
(132, 'ILMU FILSAFAT', 'UNIVERSITAS'),
(133, 'ILMU SOSIOLOGI', 'UNIVERSITAS'),
(134, 'ROBOTIKA DASAR', 'UNIVERSITAS'),
(135, 'ELEKTRONIKA', 'UNIVERSITAS'),
(136, 'PERPAJAKAN', 'UNIVERSITAS'),
(137, 'ILMU HUBUNGAN INTERNASIONAL', 'UNIVERSITAS'),
(138, 'GIZI MASYARAKAT', 'UNIVERSITAS'),
(139, 'MATEMATIKA', 'UNIVERSITAS'),
(140, 'FISIKA', 'UNIVERSITAS'),
(141, 'KIMIA', 'UNIVERSITAS'),
(142, 'BIOKIMIA', 'UNIVERSITAS'),
(143, 'MANAJEMEN SDM', 'UNIVERSITAS'),
(144, 'RISK MANAGEMENT', 'UNIVERSITAS'),
(145, 'MANAJEMEN SDA', 'UNIVERSITAS'),
(146, 'ILMU PERTANIAN', 'UNIVERSITAS'),
(147, 'ADMINISTRASI PERKANTORAN', 'UNIVERSITAS'),
(148, 'PENULISAN KARYA ILMIAH', 'UNIVERSITAS'),
(149, 'ANTROPOLOGI', 'UNIVERSITAS'),
(150, 'KRIMINOLOGI', 'UNIVERSITAS'),
(151, 'PSIKOLOGI', 'UNIVERSITAS'),
(152, 'MIKROBIOLOGI', 'UNIVERSITAS'),
(153, 'ARSITEKTUR', 'UNIVERSITAS'),
(154, 'EKONOMI', 'UNIVERSITAS'),
(155, 'TEKNIK KIMIA', 'UNIVERSITAS'),
(156, 'HUKUM', 'UNIVERSITAS'),
(157, 'ASTRONOMI', 'UNIVERSITAS'),
(158, 'GEOLOGI', 'UNIVERSITAS'),
(159, 'GENETIKA', 'UNIVERSITAS'),
(160, 'COMPUTER BASED TEST UJIAN KOMPETENSI MAHASISWA PROGRAM PROFESI DOKTER', 'UNIVERSITAS'),
(161, 'OSCE UJIAN KOMPETENSI MAHASISWA PROGRAM PROFESI DOKTER', 'UNIVERSITAS'),
(162, 'MENJAHIT UMUM', 'UMUM'),
(163, 'PRESENTASI UMUM', 'UMUM'),
(164, 'OTOMOTIF UMUM', 'UMUM'),
(165, 'MENYETIR MOBIL UMUM', 'UMUM'),
(166, 'KEWIRAUSAHAAN', 'UMUM'),
(167, 'MEMASAK UMUM', 'UMUM'),
(168, 'MERIAS UMUM', 'UMUM'),
(169, 'YOYO UMUM', 'UMUM'),
(170, 'SULAP UMUM', 'UMUM'),
(171, 'MENGAJI UMUM', 'UMUM'),
(172, 'PENULISAN JURNALISTIK TV UMUM', 'UMUM'),
(173, 'PRODUKSI TV UMUM', 'UMUM'),
(174, 'PENDIDIKAN  ANAK BERKEBUTUHAN KHUSUS UMUM', 'UMUM'),
(175, 'PUBLIC SPEAKING UMUM', 'UMUM'),
(176, 'ASUHAN KEBIDANAN UMUM', 'UMUM'),
(177, 'MEDITASI UMUM', 'UMUM'),
(178, 'GO | JAPANESE BOARD GAME UMUM', 'UMUM'),
(179, 'SHOGI | JAPANESE BOARD GAME UMUM', 'UMUM'),
(180, 'SOCIAL MEDIA MARKETING UMUM', 'UMUM'),
(181, 'PENGEMBANGAN KARIR UMUM', 'UMUM'),
(182, 'PELATIHAN TRADING FOREX UMUM', 'UMUM'),
(183, 'PELATIHAN ISO 9001:2008 UMUM', 'UMUM'),
(184, 'PERDAGANGAN INTERNASIONAL PELATIHAN UMUM', 'UMUM'),
(185, 'MANAJEMEN LOGISTIK PELATIHAN UMUM', 'UMUM'),
(186, 'OLIMPIADE MATEMATIKA UMUM', 'KOMPETISI/OLIMPIADE'),
(187, 'OLIMPIADE FISIKA UMUM', 'KOMPETISI/OLIMPIADE'),
(188, 'OLIMPIADE KIMIA UMUM', 'KOMPETISI/OLIMPIADE'),
(189, 'OLIMPIADE BIOLOGI UMUM', 'KOMPETISI/OLIMPIADE'),
(190, 'OLIMPIADE EKONOMI UMUM', 'KOMPETISI/OLIMPIADE'),
(191, 'ASTRONOMI UMUM', 'KOMPETISI/OLIMPIADE'),
(192, 'DEBAT UMUM', 'KOMPETISI/OLIMPIADE'),
(193, 'KOMPUTER UMUM', 'KOMPETISI/OLIMPIADE'),
(194, 'TOEFL ITP', 'BAHASA'),
(195, 'TOEFL IBT', 'BAHASA'),
(196, 'IELTS', 'BAHASA'),
(197, 'HSK', 'BAHASA'),
(198, 'BAHASA SPANYOL UMUM', 'BAHASA'),
(199, 'BAHASA JERMAN UMUM', 'BAHASA'),
(200, 'BAHASA PERANCIS UMUM', 'BAHASA'),
(201, 'BAHASA KOREA UMUM', 'BAHASA'),
(202, 'BAHASA RUSIA UMUM', 'BAHASA'),
(203, 'BAHASA JEPANG UMUM', 'BAHASA'),
(204, 'BAHASA INDONESIA UMUM', 'BAHASA'),
(205, 'BAHASA INGGRIS UMUM', 'BAHASA'),
(206, 'BAHASA BELANDA UMUM', 'BAHASA'),
(207, 'BAHASA THAILAND UMUM', 'BAHASA'),
(208, 'BAHASA MANDARIN UMUM', 'BAHASA'),
(209, 'BAHASA ARAB UMUM', 'BAHASA'),
(210, 'BAHASA JAWA UMUM', 'BAHASA'),
(211, 'BAHASA SUNDA UMUM', 'BAHASA'),
(212, 'BAHASA VIETNAM UMUM', 'BAHASA'),
(213, 'BAHASA ITALIA UMUM', 'BAHASA'),
(214, 'BAHASA TURKI UMUM', 'BAHASA'),
(215, 'BAHASA INDONESIA PENUTUR ASING UMUM', 'BAHASA'),
(216, 'BAHASA INGGRIS PERCAKAPAN', 'BAHASA'),
(217, 'ENGLISH FOR BUSINESS', 'BAHASA'),
(218, 'ENGLISH FOR DAILY CONVERSATION', 'BAHASA'),
(219, 'PIANO UMUM', 'SENI'),
(220, 'GITAR ELEKTRIK UMUM', 'SENI'),
(221, 'DRUM UMUM', 'SENI'),
(222, 'BIOLA UMUM', 'SENI'),
(223, 'VOKAL UMUM', 'SENI'),
(224, 'BASS GITAR UMUM', 'SENI'),
(225, 'MODELING UMUM', 'SENI'),
(226, 'KEYBOARD UMUM', 'SENI'),
(227, 'TARI MODERN UMUM', 'SENI'),
(228, 'TARI TRADISIONAL UMUM', 'SENI'),
(229, 'BALET UMUM', 'SENI'),
(230, 'MELUKIS UMUM', 'SENI'),
(231, 'FLUTE UMUM', 'SENI'),
(232, 'ACTING UMUM', 'SENI'),
(233, 'HARPA UMUM', 'SENI'),
(234, 'GITAR KLASIK UMUM', 'SENI'),
(235, 'FOTOGRAFI UMUM', 'SENI'),
(236, 'KALIGRAFI UMUM', 'SENI'),
(237, 'MOVIE MAKING UMUM', 'SENI'),
(238, 'DESAIN GRAFIS UMUM', 'SENI'),
(239, 'MEMBATIK UMUM', 'SENI'),
(240, 'MENYANYI UMUM', 'SENI'),
(241, 'TATA BUSANA UMUM', 'SENI'),
(242, 'UKULELE UMUM', 'SENI'),
(243, 'MENGGAMBAR UMUM', 'SENI'),
(244, 'AUDIO MUSIC UMUM', 'SENI'),
(245, 'OBOE UMUM', 'SENI'),
(246, 'DESAIN INTERIOR UMUM', 'SENI'),
(247, 'CAPOEIRA UMUM', 'SENI'),
(248, 'DANSA BRAZIL SAMBA UMUM', 'SENI'),
(249, 'CELLO UMUM', 'SENI'),
(250, 'SAXOPHONE UMUM', 'SENI'),
(251, 'DRUMBAND UMUM', 'SENI'),
(252, 'MARCHING BAND UMUM', 'SENI'),
(253, 'BEATBOX UMUM', 'SENI'),
(254, 'BREAKDANCE UMUM', 'SENI'),
(255, 'GRAFITTI UMUM', 'SENI'),
(256, 'MOVIE EDITING UMUM', 'SENI'),
(257, 'MERAJUT UMUM', 'SENI'),
(258, 'VISUAL EFFECT UMUM', 'SENI'),
(259, 'ADOBE PHOTOSHOP UMUM', 'KOMPUTER'),
(260, 'MICROSOFT OFFICE UMUM', 'KOMPUTER'),
(261, 'JAVA PROGRAMMING UMUM', 'KOMPUTER'),
(262, 'COREL DRAW UMUM', 'KOMPUTER'),
(263, 'ANIMASI UMUM', 'KOMPUTER'),
(264, 'C++ PROGRAMMING UMUM', 'KOMPUTER'),
(265, 'FLASH UMUM', 'KOMPUTER'),
(266, 'WEB DESIGN UMUM', 'KOMPUTER'),
(267, 'INTERNET UMUM', 'KOMPUTER'),
(268, 'DESAIN GRAFIS 3D UMUM', 'KOMPUTER'),
(269, 'VISUAL BASIC UMUM', 'KOMPUTER'),
(270, 'SQL SERVER UMUM', 'KOMPUTER'),
(271, 'MYSQL UMUM', 'KOMPUTER'),
(272, 'JARINGAN KOMPUTER UMUM', 'KOMPUTER'),
(273, 'TEKNISI KOMPUTER UMUM', 'KOMPUTER'),
(274, 'ADOE ILLUSTRATOR UMUM', 'KOMPUTER'),
(275, 'COMPUTER ASSISTED LANGUAGE LEARNING UMUM', 'KOMPUTER'),
(276, 'CAMERA RAW UMUM', 'KOMPUTER'),
(277, 'MENGETIK 10 JARI UMUM', 'KOMPUTER'),
(278, 'SPSS UMUM', 'KOMPUTER'),
(279, 'PAST UMUM', 'KOMPUTER'),
(280, 'PLS UMUM', 'KOMPUTER'),
(281, 'AUTOCAD UMUM', 'KOMPUTER'),
(282, 'PEMROGRAMAN GAME UMUM', 'KOMPUTER'),
(283, 'PHP WEB PEMROGRAMAN UMUM', 'KOMPUTER'),
(284, 'ANALISIS ALGORITMA UMUM', 'KOMPUTER'),
(285, 'HTML – CSS UMUM', 'KOMPUTER'),
(286, 'ANDROID PROGRAMMING UMUM', 'KOMPUTER'),
(287, 'IOS PROGRAMMING UMUM', 'KOMPUTER'),
(288, 'PEMROGRAMAN MICROCONTROLLER UMUM', 'KOMPUTER'),
(289, 'PHYTON PROGRAMMING UMUM', 'KOMPUTER'),
(290, 'DATA SCIENCE UMUM', 'KOMPUTER'),
(291, 'BERENANG UMUM', 'OLAHRAGA'),
(292, 'TENIS UMUM', 'OLAHRAGA'),
(293, 'TAEKWONDO UMUM', 'OLAHRAGA'),
(294, 'YOGA UMUM', 'OLAHRAGA'),
(295, 'KEBUGARAN UMUM', 'OLAHRAGA'),
(296, 'BULU TANGKIS UMUM', 'OLAHRAGA'),
(297, 'GOLF UMUM', 'OLAHRAGA'),
(298, 'KARATE UMUM', 'OLAHRAGA'),
(299, 'BOWLING UMUM', 'OLAHRAGA'),
(300, 'BERKUDA UMUM', 'OLAHRAGA'),
(301, 'DIVING UMUM', 'OLAHRAGA'),
(302, 'SURFING UMUM', 'OLAHRAGA'),
(303, 'SQUASH UMUM', 'OLAHRAGA'),
(304, 'BASKET UMUM', 'OLAHRAGA'),
(305, 'KUNGFU UMUM', 'OLAHRAGA'),
(306, 'PILATES UMUM', 'OLAHRAGA'),
(307, 'BASEBALL/SOFTBALL UMUM', 'OLAHRAGA'),
(308, 'PENCAK SILAT UMUM', 'OLAHRAGA'),
(309, 'MATHEMATICS', 'INTERNATIONAL SCHOOL'),
(310, 'CHEMISTRY', 'INTERNATIONAL SCHOOL'),
(311, 'ENGLISH', 'INTERNATIONAL SCHOOL'),
(312, 'BIOLOGY', 'INTERNATIONAL SCHOOL'),
(313, 'PHYSICS', 'INTERNATIONAL SCHOOL'),
(314, 'ECONOMICS', 'INTERNATIONAL SCHOOL'),
(315, 'MATH IB', 'INTERNATIONAL SCHOOL'),
(316, 'PHYSICS IB', 'INTERNATIONAL SCHOOL'),
(317, 'ENGLISH LITERATURE', 'INTERNATIONAL SCHOOL');

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2019_04_27_172727_create_absens_table', 1),
(2, '2019_04_27_170304_create_gurus_table', 2),
(3, '2019_04_27_172631_create_jadwal_availables_table', 3),
(4, '2019_04_27_172542_create_mata_pelajarans_table', 4),
(5, '2019_04_27_172707_create_pemesanans_table', 5);

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id` int(11) NOT NULL,
  `id_pemesan` int(11) NOT NULL,
  `link` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `tgl_bayar` date NOT NULL,
  `tgl_verifikasi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id`, `id_pemesan`, `link`, `status`, `tgl_bayar`, `tgl_verifikasi`) VALUES
(1, 3, 'path', 0, '2019-05-01', '0000-00-00'),
(2, 1, 'path', 0, '2019-05-01', '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `pemesanan`
--

CREATE TABLE `pemesanan` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `id_guru` int(11) NOT NULL,
  `id_pemesan` int(11) NOT NULL,
  `id_mapel` int(11) DEFAULT NULL,
  `nama_murid` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kelas` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tgl_pertemuan_pertama` date NOT NULL,
  `status` tinyint(1) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `pemesanan`
--

INSERT INTO `pemesanan` (`id`, `id_guru`, `id_pemesan`, `id_mapel`, `nama_murid`, `kelas`, `tgl_pertemuan_pertama`, `status`, `created_at`, `updated_at`) VALUES
(1, 2, 1, 1, 'Rafi', '', '2019-05-25', 0, '2019-04-30 17:00:00', NULL),
(2, 2, 3, 2, 'Reza', '', '2019-05-25', 1, '2019-04-30 17:00:00', NULL),
(3, 36, 38, 1, 'Nadiah', '', '2019-05-25', 2, '2019-05-15 12:44:16', NULL),
(4, 36, 43, 2, 'Bella', '', '2019-05-25', 1, '2019-05-21 02:40:14', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `alamat` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `provinsi` varchar(126) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kabupaten_kota` varchar(126) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0',
  `role` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `no_hp` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jenis_kelamin` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `remember_token`, `alamat`, `provinsi`, `kabupaten_kota`, `status`, `role`, `no_hp`, `jenis_kelamin`, `created_at`, `updated_at`) VALUES
(2, 'Reza', 'reza@email.com', '123321', NULL, 'Jl. Teluk Langsa 4 Blok C.8 No.4', '', '', 2, '2', '08646546', 'Laki-laki', '2019-04-28 07:21:12', NULL),
(19, 'Priska', 'priska@email.com', 'admin', NULL, 'jakot', '', '', 2, '2', '124', 'perempuan', NULL, NULL),
(20, 'Bella', 'bella@gmail.com', 'admina', NULL, 'asdajksd', '', '', 2, '2', '123', 'perempuan', NULL, NULL),
(22, 'Rafi', 'rafiaja@email.com', '123321', NULL, 'Bojong', '', '', 3, '2', '038285625', 'Laki-Laki', '2019-05-02 09:09:01', '2019-05-02 09:09:01'),
(24, 'Nadiah Tsamara Pratiwi', 'tspnadiah@gmail.com', 'admin', NULL, 'Jl. Kalibata Tengah XVII No.29', '', '', 1, '2', '089699179002', 'Perempuan', '2019-05-02 09:17:17', '2019-05-02 09:17:17'),
(25, 'Jack Martin R', 'jack@gmail.com', 'admin', NULL, 'Jl. Depok Baru', '', '', 1, '2', '123451234', 'Perempuan', '2019-05-13 09:30:12', '2019-05-13 09:30:12'),
(27, 'Muhammad Adhi Herliyanto', 'adhi@gmail.com', 'admin', NULL, 'Jl. Babon', '', '', 0, '2', '125', 'Laki-Laki', '2019-05-13 09:33:13', '2019-05-13 09:33:13'),
(28, 'Siti Nur Haliza', 'liza@gmail.com', 'admin', NULL, 'Jl.Teluk', '', '', 0, '2', '234', 'Perempuan', '2019-05-13 09:34:35', '2019-05-13 09:34:35'),
(29, 'Alfa', 'alfa@gmail.com', 'admin', NULL, 'Teluk Langsa 4', '', '', 0, '2', '1234', 'Perempuan', '2019-05-13 17:53:14', '2019-05-13 17:53:14'),
(30, 'Beta', 'beta@gmail.com', 'admin', NULL, 'Teluk Langsa 4', '', '', 0, '2', '1234', 'Laki-Laki', '2019-05-13 18:04:10', '2019-05-13 18:04:10'),
(31, 'Gama', 'gama@gmail.com', 'admin', NULL, 'Jl. Teluk Langsa 4', '', '', 0, '2', '92922', 'Laki-Laki', '2019-05-13 18:09:23', '2019-05-13 18:09:23'),
(32, 'Teta', 'teta@gmail.com', 'admin', NULL, 'Teluk Langsa 4', '', '', 2, '2', '1234', 'Laki-Laki', '2019-05-13 18:16:42', '2019-05-13 18:16:42'),
(33, 'priska', 'priskaputri15@gmail', 'friska15', NULL, 'jl. budi mulia', '', '', 1, '2', '082227738902', 'Perempuan', '2019-05-14 04:37:24', '2019-05-14 04:37:24'),
(34, 'Asymala Permata Sari', 'asymalapsari@gmail.com', '123456', NULL, 'Lembah Nirmala 1, RT 11/14 No.47. Cimanggis, Depok', '', '', 0, '2', '081807879100', 'Perempuan', '2019-05-14 05:24:44', '2019-05-14 05:24:44'),
(36, 'Muhammad Reza Pahlevi Y', 'rezarubik17@gmail.com', 'admin', NULL, 'Jl. Teluk Langsa 4 Blok C.8 No.4', 'DKI Jakarta', 'Jakarta Timur/Duren Sawit', 1, '2', '089501011011', 'Laki-Laki', '2019-05-14 16:57:25', '2019-05-14 16:57:25'),
(37, 'Student', 'student@email.com', '123321', NULL, NULL, '', '', 0, '1', '0667364957', 'Laki-laki', '2019-05-15 07:10:54', '2019-05-15 12:10:54'),
(38, 'Pilot', 'pilot@email.com', '123321', NULL, 'Jalan Pilot Gak Jadi', '', '', 1, '1', '0773349454', 'Laki-laki', '2019-05-15 08:33:18', '2019-05-15 13:33:18'),
(39, 'Rogue', 'rogue@mail.com', '123321', NULL, 'Jl. Rogue', '', '', 1, '1', '06676485', 'Laki-laki', '2019-05-15 09:04:21', '2019-05-15 14:04:21'),
(40, 'asymala', 'mala11@mail.com', '123321', NULL, 'gsgdhd', '', '', 1, '1', '5481558', 'Perempuan', '2019-05-18 11:26:42', '2019-05-18 16:26:42'),
(41, 'nadiah', 'n@email.com', '123456', NULL, 'kalibata no 29', '', '', 1, '1', '087882219516', 'Perempuan', '2019-05-18 12:01:57', '2019-05-18 17:01:57'),
(42, 'asd', 'asd@mail.com', '123456', NULL, 'hdhdhf', '', '', 1, '1', '54858855', 'Perempuan', '2019-05-18 13:57:59', '2019-05-18 18:57:59'),
(43, 'Wraith', 'wraith@email.com', '123321', NULL, 'Outlands', 'DKI Jakarta', 'Jakarta Utara', 1, '1', '096739482', 'Perempuan', '2019-05-21 02:39:09', '2019-05-21 07:39:09'),
(44, 'Muhammad Reza P', 'muhammad.reza.pahlevi.y@gmail.com', '12345678', NULL, 'Jl. Teluk Langsa 4 Blok C.8 No.4', 'dki', 'jkt', 1, '2', '089501011011', 'Laki-Laki', '2019-05-22 17:49:24', '2019-05-22 17:49:24');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absen`
--
ALTER TABLE `absen`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bahan_ajar`
--
ALTER TABLE `bahan_ajar`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `guru`
--
ALTER TABLE `guru`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jadwal_available`
--
ALTER TABLE `jadwal_available`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mata_pelajaran`
--
ALTER TABLE `mata_pelajaran`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `absen`
--
ALTER TABLE `absen`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `bahan_ajar`
--
ALTER TABLE `bahan_ajar`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `guru`
--
ALTER TABLE `guru`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `jadwal_available`
--
ALTER TABLE `jadwal_available`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `mata_pelajaran`
--
ALTER TABLE `mata_pelajaran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=318;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pemesanan`
--
ALTER TABLE `pemesanan`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
