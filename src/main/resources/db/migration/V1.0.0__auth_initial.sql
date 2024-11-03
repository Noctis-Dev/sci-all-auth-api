CREATE TABLE `contacts` (
  `contact_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `contact_uuid` varchar(36) UNIQUE NOT NULL,
  `phone_number` varchar(15) UNIQUE,
  `email` varchar(55) UNIQUE,
  `created_at` date NOT NULL,
  `user_id` bigint NULL
);

CREATE TABLE `users` (
  `user_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `user_uuid` varchar(36) UNIQUE NOT NULL,
  `created_at` date NOT NULL,
  `activated_at` date,
  `deleted_at` date,
  `status` enum('INACTIVE','ACTIVE','BLOCKED') NOT NULL,
  `contact_id` bigint
);

CREATE TABLE `token_settings` (
  `token_setting_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `is_active` bool DEFAULT true,
  `token_expiration_days` integer NOT NULL,
  `refresh_token_expiration_days` integer NOT NULL,
  `token_type` enum('VERIFICATION','AUTHORIZATION') NOT NULL
);

CREATE TABLE `tokens` (
  `token_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `token` varchar(255) UNIQUE NOT NULL,
  `token_type` enum('VERIFICATION','AUTHORIZATION') NOT NULL,
  `expiration_date` date NOT NULL,
  `token_setting_id` bigint
);

CREATE TABLE `credentials` (
  `credential_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `credential_uuid` varchar(36) UNIQUE NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_at` date NOT NULL,
  `verified_at` date,
  `contact_id` bigint,
  `token_id` bigint
);

ALTER TABLE `contacts` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `users` ADD FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`contact_id`);

ALTER TABLE `tokens` ADD FOREIGN KEY (`token_setting_id`) REFERENCES `token_settings` (`token_setting_id`);

ALTER TABLE `credentials` ADD FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`contact_id`);

ALTER TABLE `credentials` ADD FOREIGN KEY (`token_id`) REFERENCES `tokens` (`token_id`);