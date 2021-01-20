-- MySQL dump 10.13  Distrib 5.7.32, for Win64 (x86_64)
--
-- Host: localhost    Database: covid
-- ------------------------------------------------------
-- Server version	5.7.32-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `areas`
(
    `name`      varchar(50) NOT NULL,
    `country`   varchar(50) NOT NULL,
    `confirmed` int(11)     NOT NULL,
    `recovered` int(11)     NOT NULL,
    `deaths`    int(11)     NOT NULL,
    `updated`   datetime DEFAULT NULL,
    PRIMARY KEY (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas`
    DISABLE KEYS */;
INSERT INTO `areas`
VALUES ('Aichi', 'Japan', 21688, 17400, 320, '2021-01-19 13:22:32'),
       ('Akita', 'Japan', 219, 164, 1, '2021-01-19 13:22:32'),
       ('Alabama', 'US', 424028, 0, 6121, '2021-01-19 13:22:32'),
       ('Alaska', 'US', 52093, 0, 229, '2021-01-19 13:22:32'),
       ('American Samoa', 'US', 0, 0, 0, '1970-01-01 00:00:00'),
       ('Anguilla', 'United Kingdom', 15, 15, 0, '2021-01-19 13:22:32'),
       ('Anhui', 'China', 993, 987, 6, '2021-01-19 13:22:32'),
       ('Aomori', 'Japan', 656, 542, 8, '2021-01-19 13:22:32'),
       ('Arizona', 'US', 679282, 0, 11265, '2021-01-19 13:22:32'),
       ('Arkansas', 'US', 272263, 0, 4343, '2021-01-19 13:22:32'),
       ('Beijing', 'China', 1007, 960, 9, '2021-01-19 13:22:32'),
       ('Bermuda', 'United Kingdom', 683, 598, 12, '2021-01-19 13:22:32'),
       ('British Virgin Islands', 'United Kingdom', 114, 95, 1, '2021-01-19 13:22:32'),
       ('California', 'US', 3019758, 0, 33746, '2021-01-19 13:22:32'),
       ('Cayman Islands', 'United Kingdom', 380, 330, 2, '2021-01-19 13:22:32'),
       ('Channel Islands', 'United Kingdom', 3370, 3073, 78, '2021-01-19 13:22:32'),
       ('Chiba', 'Japan', 18177, 11368, 173, '2021-01-19 13:22:32'),
       ('Chongqing', 'China', 591, 584, 6, '2021-01-19 13:22:32'),
       ('Colorado', 'US', 376171, 0, 5386, '2021-01-19 13:22:32'),
       ('Connecticut', 'US', 230125, 0, 6670, '2021-01-19 13:22:32'),
       ('Delaware', 'US', 70910, 0, 1016, '2021-01-19 13:22:32'),
       ('Diamond Princess', 'US', 49, 0, 0, '2020-08-04 02:27:56'),
       ('District of Columbia', 'US', 34033, 0, 857, '2021-01-19 13:22:32'),
       ('Ehime', 'Japan', 849, 573, 15, '2021-01-19 13:22:32'),
       ('England', 'United Kingdom', 2992238, 0, 78636, '2021-01-19 13:22:32'),
       ('Falkland Islands (Malvinas)', 'United Kingdom', 32, 27, 0, '2021-01-19 13:22:32'),
       ('Florida', 'US', 1579281, 0, 24274, '2021-01-19 13:22:32'),
       ('Fujian', 'China', 532, 513, 1, '2021-01-19 13:22:32'),
       ('Fukui', 'Japan', 461, 373, 13, '2021-01-19 13:22:32'),
       ('Fukuoka', 'Japan', 13829, 9470, 148, '2021-01-19 13:22:32'),
       ('Fukushima', 'Japan', 1483, 1081, 35, '2021-01-19 13:22:32'),
       ('Gansu', 'China', 182, 180, 2, '2021-01-19 13:22:32'),
       ('Georgia', 'US', 820952, 0, 12360, '2021-01-19 13:22:32'),
       ('Gibraltar', 'United Kingdom', 3712, 2840, 45, '2021-01-19 13:22:32'),
       ('Gifu', 'Japan', 3618, 2858, 58, '2021-01-19 13:22:32'),
       ('Grand Princess', 'US', 103, 0, 3, '2020-08-04 02:27:56'),
       ('Guam', 'US', 7474, 0, 125, '2021-01-19 13:22:32'),
       ('Guangdong', 'China', 2090, 2039, 8, '2021-01-19 13:22:32'),
       ('Guangxi', 'China', 266, 262, 2, '2021-01-19 13:22:32'),
       ('Guizhou', 'China', 147, 145, 2, '2021-01-19 13:22:32'),
       ('Gunma', 'Japan', 3375, 2634, 58, '2021-01-19 13:22:32'),
       ('Hainan', 'China', 171, 165, 6, '2021-01-19 13:22:32'),
       ('Hawaii', 'US', 24710, 0, 321, '2021-01-19 13:22:32'),
       ('Hebei', 'China', 1198, 383, 7, '2021-01-19 13:22:32'),
       ('Heilongjiang', 'China', 1143, 953, 13, '2021-01-19 13:22:32'),
       ('Henan', 'China', 1303, 1275, 22, '2021-01-19 13:22:32'),
       ('Hiroshima', 'Japan', 4447, 3708, 69, '2021-01-19 13:22:32'),
       ('Hokkaido', 'Japan', 16024, 13695, 532, '2021-01-19 13:22:32'),
       ('Hong Kong', 'China', 9720, 8827, 164, '2021-01-19 13:22:32'),
       ('Hubei', 'China', 68149, 63637, 4512, '2021-01-19 13:22:32'),
       ('Hunan', 'China', 1026, 1017, 4, '2021-01-19 13:22:32'),
       ('Hyogo', 'Japan', 14217, 11454, 304, '2021-01-19 13:22:32'),
       ('Ibaraki', 'Japan', 3941, 2911, 46, '2021-01-19 13:22:32'),
       ('Idaho', 'US', 155554, 0, 1607, '2021-01-19 13:22:32'),
       ('Illinois', 'US', 1072214, 0, 20118, '2021-01-19 13:22:32'),
       ('Indiana', 'US', 592709, 0, 9340, '2021-01-19 13:22:32'),
       ('Inner Mongolia', 'China', 366, 350, 1, '2021-01-19 13:22:32'),
       ('Iowa', 'US', 306235, 0, 4324, '2021-01-19 13:22:32'),
       ('Ishikawa', 'Japan', 1358, 1120, 56, '2021-01-19 13:22:32'),
       ('Isle of Man', 'United Kingdom', 432, 354, 25, '2021-01-19 13:22:32'),
       ('Iwate', 'Japan', 475, 379, 25, '2021-01-19 13:22:32'),
       ('Jiangsu', 'China', 688, 684, 0, '2021-01-19 13:22:32'),
       ('Jiangxi', 'China', 935, 934, 1, '2021-01-19 13:22:32'),
       ('Jilin', 'China', 240, 155, 2, '2021-01-19 13:22:32'),
       ('Kagawa', 'Japan', 545, 340, 6, '2021-01-19 13:22:32'),
       ('Kagoshima', 'Japan', 1401, 1125, 17, '2021-01-19 13:22:32'),
       ('Kanagawa', 'Japan', 34929, 27345, 363, '2021-01-19 13:22:32'),
       ('Kansas', 'US', 261825, 0, 3511, '2021-01-19 13:22:32'),
       ('Kentucky', 'US', 328667, 0, 3167, '2021-01-19 13:22:32'),
       ('Kochi', 'Japan', 791, 714, 13, '2021-01-19 13:22:32'),
       ('Kumamoto', 'Japan', 3038, 2034, 46, '2021-01-19 13:22:32'),
       ('Kyoto', 'Japan', 7130, 5013, 87, '2021-01-19 13:22:32'),
       ('Liaoning', 'China', 396, 366, 2, '2021-01-19 13:22:32'),
       ('Louisiana', 'US', 369951, 0, 8253, '2021-01-19 13:22:32'),
       ('Macau', 'China', 46, 46, 0, '2021-01-19 13:22:32'),
       ('Maine', 'US', 34262, 0, 519, '2021-01-19 13:22:32'),
       ('Maryland', 'US', 328214, 0, 6596, '2021-01-19 13:22:32'),
       ('Massachusetts', 'US', 473441, 0, 13705, '2021-01-19 13:22:32'),
       ('Michigan', 'US', 585128, 0, 14686, '2021-01-19 13:22:32'),
       ('Mie', 'Japan', 1821, 1430, 23, '2021-01-19 13:22:32'),
       ('Minnesota', 'US', 447349, 0, 6007, '2021-01-19 13:22:32'),
       ('Mississippi', 'US', 253932, 0, 5524, '2021-01-19 13:22:32'),
       ('Missouri', 'US', 450694, 0, 6470, '2021-01-19 13:22:32'),
       ('Miyagi', 'Japan', 3086, 2353, 20, '2021-01-19 13:22:32'),
       ('Miyazaki', 'Japan', 1596, 1130, 14, '2021-01-19 13:22:32'),
       ('Montana', 'US', 89576, 0, 1093, '2021-01-19 13:22:32'),
       ('Montserrat', 'United Kingdom', 13, 12, 1, '2021-01-19 13:22:32'),
       ('Nagano', 'Japan', 2027, 1536, 22, '2021-01-19 13:22:32'),
       ('Nagasaki', 'Japan', 1302, 843, 17, '2021-01-19 13:22:32'),
       ('Nara', 'Japan', 2633, 2202, 32, '2021-01-19 13:22:32'),
       ('Nebraska', 'US', 182176, 0, 1842, '2021-01-19 13:22:32'),
       ('Nevada', 'US', 262794, 0, 3784, '2021-01-19 13:22:32'),
       ('New Hampshire', 'US', 56864, 0, 933, '2021-01-19 13:22:32'),
       ('New Jersey', 'US', 631074, 0, 20458, '2021-01-19 13:22:32'),
       ('New Mexico', 'US', 164263, 0, 2958, '2021-01-19 13:22:32'),
       ('New York', 'US', 1255971, 0, 41173, '2021-01-19 13:22:32'),
       ('Niigata', 'Japan', 781, 612, 7, '2021-01-19 13:22:32'),
       ('Ningxia', 'China', 75, 75, 0, '2021-01-19 13:22:32'),
       ('North Carolina', 'US', 674637, 0, 8083, '2021-01-19 13:22:32'),
       ('North Dakota', 'US', 95934, 0, 1406, '2021-01-19 13:22:32'),
       ('Northern Ireland', 'United Kingdom', 96001, 0, 1625, '2021-01-19 13:22:32'),
       ('Northern Mariana Islands', 'US', 129, 0, 2, '2021-01-19 13:22:32'),
       ('Ohio', 'US', 831066, 0, 10281, '2021-01-19 13:22:32'),
       ('Oita', 'Japan', 939, 780, 11, '2021-01-19 13:22:32'),
       ('Okayama', 'Japan', 2124, 1434, 17, '2021-01-19 13:22:32'),
       ('Okinawa', 'Japan', 6595, 5697, 89, '2021-01-19 13:22:32'),
       ('Oklahoma', 'US', 356816, 0, 2994, '2021-01-19 13:22:32'),
       ('Oregon', 'US', 133851, 0, 1803, '2021-01-19 13:22:32'),
       ('Osaka', 'Japan', 39052, 31302, 712, '2021-01-19 13:22:32'),
       ('Pennsylvania', 'US', 774566, 0, 19330, '2021-01-19 13:22:32'),
       ('Port Quarantine', 'Japan', 2107, 1940, 1, '2021-01-19 13:22:32'),
       ('Puerto Rico', 'US', 88373, 0, 1703, '2021-01-19 13:22:32'),
       ('Qinghai', 'China', 18, 18, 0, '2021-01-19 13:22:32'),
       ('Recovered', 'US', 0, 0, 0, '2021-01-19 13:22:32'),
       ('Rhode Island', 'US', 104443, 0, 2005, '2021-01-19 13:22:32'),
       ('Saga', 'Japan', 822, 573, 6, '2021-01-19 13:22:32'),
       ('Saitama', 'Japan', 21561, 14361, 282, '2021-01-19 13:22:32'),
       ('Scotland', 'United Kingdom', 163762, 0, 5305, '2021-01-19 13:22:32'),
       ('Shaanxi', 'China', 531, 502, 3, '2021-01-19 13:22:32'),
       ('Shandong', 'China', 865, 856, 7, '2021-01-19 13:22:32'),
       ('Shanghai', 'China', 1602, 1509, 7, '2021-01-19 13:22:32'),
       ('Shanxi', 'China', 228, 224, 0, '2021-01-19 13:22:32'),
       ('Shiga', 'Japan', 1798, 1355, 19, '2021-01-19 13:22:32'),
       ('Shimane', 'Japan', 243, 219, 0, '2021-01-19 13:22:32'),
       ('Shizuoka', 'Japan', 3964, 2931, 63, '2021-01-19 13:22:32'),
       ('Sichuan', 'China', 863, 852, 3, '2021-01-19 13:22:32'),
       ('South Carolina', 'US', 391464, 0, 6248, '2021-01-19 13:22:32'),
       ('South Dakota', 'US', 105659, 0, 1667, '2021-01-19 13:22:32'),
       ('Taiwan', 'China', 868, 766, 7, '2021-01-19 13:22:32'),
       ('Tennessee', 'US', 687751, 0, 8430, '2021-01-19 13:22:32'),
       ('Texas', 'US', 2138190, 0, 32711, '2021-01-19 13:22:32'),
       ('Tianjin', 'China', 329, 306, 3, '2021-01-19 13:22:32'),
       ('Tibet', 'China', 1, 1, 0, '2021-01-19 13:22:32'),
       ('Tochigi', 'Japan', 3341, 1870, 24, '2021-01-19 13:22:32'),
       ('Tokushima', 'Japan', 304, 211, 11, '2021-01-19 13:22:32'),
       ('Tokyo', 'Japan', 87982, 65169, 719, '2021-01-19 13:22:32'),
       ('Tottori', 'Japan', 185, 126, 2, '2021-01-19 13:22:32'),
       ('Toyama', 'Japan', 817, 627, 27, '2021-01-19 13:22:32'),
       ('Turks and Caicos Islands', 'United Kingdom', 1105, 902, 7, '2021-01-19 13:22:32'),
       ('United States Virgin Islands', 'US', 0, 0, 0, '1970-01-01 00:00:00'),
       ('Unknown', 'Japan', 8, 8, 0, '2021-01-19 13:22:32'),
       ('Utah', 'US', 324919, 0, 1500, '2021-01-19 13:22:32'),
       ('Vermont', 'US', 10220, 0, 163, '2021-01-19 13:22:32'),
       ('Virgin Islands', 'US', 2260, 0, 24, '2021-01-19 13:22:32'),
       ('Virginia', 'US', 446550, 0, 5739, '2021-01-19 13:22:32'),
       ('Wakayama', 'Japan', 904, 737, 11, '2021-01-19 13:22:32'),
       ('Wales', 'United Kingdom', 181493, 0, 4294, '2021-01-19 13:22:32'),
       ('Washington', 'US', 289939, 0, 3903, '2021-01-19 13:22:32'),
       ('West Virginia', 'US', 109809, 0, 1784, '2021-01-19 13:22:32'),
       ('Wisconsin', 'US', 569335, 0, 5926, '2021-01-19 13:22:32'),
       ('Wyoming', 'US', 49708, 0, 522, '2021-01-19 13:22:32'),
       ('Xinjiang', 'China', 980, 977, 3, '2021-01-19 13:22:32'),
       ('Yamagata', 'Japan', 447, 396, 12, '2021-01-19 13:22:32'),
       ('Yamaguchi', 'Japan', 968, 740, 5, '2021-01-19 13:22:32'),
       ('Yamanashi', 'Japan', 866, 680, 10, '2021-01-19 13:22:32'),
       ('Yunnan', 'China', 231, 225, 2, '2021-01-19 13:22:32'),
       ('Zhejiang', 'China', 1314, 1298, 1, '2021-01-19 13:22:32');
/*!40000 ALTER TABLE `areas`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `countries`
(
    `name`      varchar(50) NOT NULL,
    `confirmed` int(11)     NOT NULL,
    `recovered` int(11)     NOT NULL,
    `deaths`    int(11)     NOT NULL,
    `updated`   datetime DEFAULT NULL,
    PRIMARY KEY (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries`
    DISABLE KEYS */;
INSERT INTO `countries`
VALUES ('China', 98226, 91305, 4799, '2021-01-19 23:04:25'),
       ('Japan', 340924, 257563, 4549, '2021-01-19 23:04:29'),
       ('United Kingdom', 3443350, 8246, 90031, '2021-01-19 23:04:28'),
       ('US', 24079744, 0, 399008, '2021-01-19 23:04:27');
/*!40000 ALTER TABLE `countries`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2021-01-20 11:17:16
