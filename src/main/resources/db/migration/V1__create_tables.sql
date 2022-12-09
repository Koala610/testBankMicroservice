CREATE TABLE `limits` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `account_id` bigint unsigned NOT NULL,
  `limit_sum` double DEFAULT NULL,
  `remaining_sum` double DEFAULT NULL,
  `limit_datetime` datetime DEFAULT NULL,
  `expense_category` enum('product','service') NOT NULL,
  `limit_currency_shortname` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `expense_category_id` (`expense_category`)
);
CREATE TABLE `transactions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_from` bigint unsigned NOT NULL,
  `account_to` bigint unsigned NOT NULL,
  `sum` double DEFAULT NULL,
  `currency_shortname` varchar(3) DEFAULT NULL,
  `expense_category` enum('product','service') NOT NULL,
  `datetime` datetime DEFAULT NULL,
  `limit_exceeded` tinyint(1) DEFAULT '0',
  `limit_id` bigint unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `expense_category_id` (`expense_category`),
  KEY `fk_limit_id` (`limit_id`),
  CONSTRAINT `fk_limit_id` FOREIGN KEY (`limit_id`) REFERENCES `limits` (`id`)
);