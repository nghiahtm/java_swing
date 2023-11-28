-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: 127.0.0.1    Database: book_store
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary view structure for view `detail_books`
--

DROP TABLE IF EXISTS `detail_books`;
/*!50001 DROP VIEW IF EXISTS `detail_books`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `detail_books` AS SELECT 
 1 AS `id_book`,
 1 AS `book_title`,
 1 AS `book_name`,
 1 AS `publish_year`,
 1 AS `insb_code`,
 1 AS `id_author`,
 1 AS `author_name`,
 1 AS `id_genre`,
 1 AS `genre`,
 1 AS `id_publisher`,
 1 AS `publisher`,
 1 AS `selling_price`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `information_bill`
--

DROP TABLE IF EXISTS `information_bill`;
/*!50001 DROP VIEW IF EXISTS `information_bill`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `information_bill` AS SELECT 
 1 AS `id`,
 1 AS `create_date`,
 1 AS `id_user`,
 1 AS `username`,
 1 AS `id_sales`,
 1 AS `sale`,
 1 AS `book_name`,
 1 AS `insb_code`,
 1 AS `selling_price`,
 1 AS `quantity`,
 1 AS `total_price`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `detail_books`
--

/*!50001 DROP VIEW IF EXISTS `detail_books`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `detail_books` AS select `books`.`id_book` AS `id_book`,`books`.`title` AS `book_title`,`books`.`name` AS `book_name`,`books`.`publish_year` AS `publish_year`,`books`.`insb_code` AS `insb_code`,`authors`.`id_author` AS `id_author`,`authors`.`name` AS `author_name`,`genres`.`id_genre` AS `id_genre`,`genres`.`name` AS `genre`,`publishers`.`id` AS `id_publisher`,`publishers`.`name` AS `publisher`,`books`.`selling_price` AS `selling_price` from (((`books` left join `authors` on((`authors`.`id_author` = `books`.`id_author`))) left join `genres` on((`genres`.`id_genre` = `books`.`id_genre`))) left join `publishers` on((`publishers`.`id` = `books`.`id_publisher`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `information_bill`
--

/*!50001 DROP VIEW IF EXISTS `information_bill`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `information_bill` AS select `bills`.`id` AS `id`,`bills`.`create_date` AS `create_date`,`bills`.`id_user` AS `id_user`,`u`.`username` AS `username`,`bills`.`id_sales` AS `id_sales`,`s`.`username` AS `sale`,`books`.`name` AS `book_name`,`books`.`insb_code` AS `insb_code`,`books`.`selling_price` AS `selling_price`,`detail_bills`.`quantity` AS `quantity`,`detail_bills`.`total_price` AS `total_price` from ((((`detail_bills` left join `books` on((`books`.`id_book` = `detail_bills`.`id_book`))) left join `bills` on((`bills`.`id` = `detail_bills`.`id_bill`))) left join `users` `u` on((`bills`.`id_user` = `u`.`id`))) left join `users` `s` on((`bills`.`id_sales` = `s`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-28 18:10:11
