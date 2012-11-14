-- MySQL dump 10.13  Distrib 5.5.16, for osx10.5 (i386)
--
-- Host: localhost    Database: haricot
-- ------------------------------------------------------
-- Server version	5.5.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `haricot`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `haricot` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `haricot`;

--
-- Table structure for table `SEQUENCE`
--

DROP TABLE IF EXISTS `SEQUENCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SEQUENCE` (
  `SEQ_NAME` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SEQUENCE`
--

LOCK TABLES `SEQUENCE` WRITE;
/*!40000 ALTER TABLE `SEQUENCE` DISABLE KEYS */;
INSERT INTO `SEQUENCE` VALUES ('SEQ_GEN',0);
/*!40000 ALTER TABLE `SEQUENCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='contains product categories, e.g., dairy, meats, etc.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'dairy'),(2,'meats'),(3,'bakery'),(4,'fruit & veg');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `city_region` varchar(2) COLLATE utf8_unicode_ci NOT NULL,
  `cc_number` varchar(19) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='maintains customer details';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Charlie Pace','c.pace@youareeverybody.com','605434778','Široká 45','1','4224311324421331'),(2,'MC Hammer','hammer@hammertime.com','226884562','Ruská 11','2','4321123443211234'),(3,'Karel Gott','gott@karelgott.com','224517995','Kostelní 83','7','3311332222444411'),(4,'Helena Vondrácková','h.vondrackova@seznam.cz','224517995','Letohradská 18','7','1111222244443333'),(5,'Sawyer Ford','sawyer.ford@gmail.com','204888845','Dušní 87','1','2222333311114444'),(6,'Dalibor Janda','dalibor@dalibor.cz','728331184','Krkonošská 9','3','3111444222212334'),(7,'Richard Genzer','r.genzer@nova.cz','737610775','Plzenská 131','5','2244443321123311'),(8,'Iveta Bartošová','i.bartosova@volny.cz','734556133','Prokopská 60','1','3333111144442222'),(9,'Jin-Soo Kwon','jin.kwon@hotmail.kr','606338909','Ve Strešovickách 49','6','1111222233334444'),(10,'Benjamin Linus','b.linus@lost.com','222756448','Družstevní 77','4','4444222233331111'),(11,'Leoš Mareš','mares@ferrari.it','608995383','Parížská 89','1','2222444411113333'),(12,'John Locke','maninblack@lostpedia.com','413443727','Valecovská 20','9','2244331133114422'),(13,'Lucie Bílá','lucie@jampadampa.cz','733556813','Na hájku 3','8','3333444422221111'),(14,'Sayid Jarrah','sayid@gmail.com','602680793','Kodanská 78','10','5490123456789128'),(15,'Hugo Reyes','hurley@mrcluck.com','605449336','Žerotínova 64','3','4539992043491562');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_order`
--

DROP TABLE IF EXISTS `customer_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `amount` decimal(6,2) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `confirmation_number` int(10) unsigned NOT NULL,
  `customer_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_order_customer` (`customer_id`),
  CONSTRAINT `FK_customer_order_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_customer_order_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='maintains customer order details';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_order`
--

LOCK TABLES `customer_order` WRITE;
/*!40000 ALTER TABLE `customer_order` DISABLE KEYS */;
INSERT INTO `customer_order` VALUES (1,16.50,'2010-05-14 16:00:11',285434339,15),(2,16.11,'2010-05-14 15:56:23',428278565,14),(3,26.00,'2010-05-14 15:51:37',503113888,13),(4,17.63,'2010-05-14 15:47:46',916407556,12),(5,17.24,'2010-05-14 15:45:21',189191209,11),(6,15.57,'2010-05-14 15:43:12',274027361,10),(7,4.49,'2010-05-14 16:04:09',250764732,9),(8,19.70,'2010-05-14 16:10:09',766244032,8),(9,37.49,'2010-05-14 16:23:08',53395157,7),(10,18.90,'2010-05-14 16:25:56',818358116,6),(11,18.92,'2010-05-14 16:32:03',244956320,5),(12,17.66,'2010-05-14 16:35:07',868642371,4),(13,10.22,'2010-05-14 16:40:38',344549009,3),(14,12.16,'2010-05-14 16:51:58',475644436,2),(15,10.75,'2010-05-14 16:56:13',247455344,1);
/*!40000 ALTER TABLE `customer_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordered_product`
--

DROP TABLE IF EXISTS `ordered_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordered_product` (
  `customer_order_id` int(10) unsigned NOT NULL,
  `product_id` int(10) unsigned NOT NULL,
  `quantity` smallint(5) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`customer_order_id`,`product_id`),
  KEY `fk_ordered_product_customer_order` (`customer_order_id`),
  KEY `fk_ordered_product_product` (`product_id`),
  CONSTRAINT `FK_ordered_product_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_ordered_product_customer_order` FOREIGN KEY (`customer_order_id`) REFERENCES `customer_order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ordered_product_customer_order_id` FOREIGN KEY (`customer_order_id`) REFERENCES `customer_order` (`id`),
  CONSTRAINT `fk_ordered_product_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='matches products with customer orders and records their quantity';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_product`
--

LOCK TABLES `ordered_product` WRITE;
/*!40000 ALTER TABLE `ordered_product` DISABLE KEYS */;
INSERT INTO `ordered_product` VALUES (1,2,2),(1,8,1),(1,10,1),(1,12,1),(1,13,1),(2,2,1),(2,4,1),(2,5,1),(2,11,2),(2,13,1),(2,15,1),(2,16,1),(3,1,1),(3,8,6),(4,1,1),(4,4,1),(4,8,1),(4,11,1),(4,14,2),(4,16,1),(5,7,5),(5,15,1),(6,3,1),(6,4,2),(6,6,1),(6,9,1),(6,15,2),(7,16,1),(8,8,2),(8,9,1),(8,11,1),(8,14,1),(8,15,2),(8,16,1),(9,5,2),(9,6,2),(9,7,2),(9,8,5),(10,13,10),(11,2,2),(11,9,1),(11,10,1),(11,13,1),(11,14,2),(11,16,1),(12,1,3),(12,12,4),(13,4,1),(13,10,2),(13,13,1),(13,16,1),(14,5,4),(15,1,1),(15,3,2),(15,15,3);
/*!40000 ALTER TABLE `ordered_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `price` decimal(5,2) NOT NULL,
  `description` tinytext COLLATE utf8_unicode_ci,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `category_id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_category` (`category_id`),
  CONSTRAINT `FK_product_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='contains product details';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'milk',1.70,'semi skimmed (1L)','2012-11-13 20:45:56',1),(2,'cheese',2.39,'mild cheddar (330g)','2012-11-13 20:45:56',1),(3,'butter',1.09,'unsalted (250g)','2012-11-13 20:45:56',1),(4,'free range eggs',1.76,'medium-sized (6 eggs)','2012-11-13 20:45:56',1),(5,'organic meat patties',2.29,'rolled in fresh herbs<br>2 patties (250g)','2012-11-13 20:45:56',2),(6,'parma ham',3.49,'matured, organic (70g)','2012-11-13 20:45:56',2),(7,'chicken leg',2.59,'free range (250g)','2012-11-13 20:45:56',2),(8,'sausages',3.55,'reduced fat, pork<br>3 sausages (350g)','2012-11-13 20:45:56',2),(9,'sunflower seed loaf',1.89,'600g','2012-11-13 20:45:56',3),(10,'sesame seed bagel',1.19,'4 bagels','2012-11-13 20:45:56',3),(11,'pumpkin seed bun',1.15,'4 buns','2012-11-13 20:45:56',3),(12,'chocolate cookies',2.39,'contain peanuts<br>(3 cookies)','2012-11-13 20:45:56',3),(13,'corn on the cob',1.59,'2 pieces','2012-11-13 20:45:56',4),(14,'red currants',2.49,'150g','2012-11-13 20:45:56',4),(15,'broccoli',1.29,'500g','2012-11-13 20:45:56',4),(16,'seedless watermelon',1.49,'250g','2012-11-13 20:45:56',4);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-13 22:54:37