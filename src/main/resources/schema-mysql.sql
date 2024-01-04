CREATE DATABASE `xiaoliuqiu`;


CREATE TABLE `car` (
  `car_id` varchar(45) NOT NULL,
  `car_type_id` int NOT NULL,
  `car_introduce` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `car_type` (
  `car_type_id` int NOT NULL AUTO_INCREMENT,
  `car_type_name` varchar(45) NOT NULL,
  `car_type_price` varchar(45) NOT NULL,
  PRIMARY KEY (`car_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `extra` (
  `extra_id` int NOT NULL AUTO_INCREMENT,
  `room_id` varchar(20) NOT NULL,
  `extra_name` varchar(45) NOT NULL,
  `extra_price` varchar(45) NOT NULL,
  PRIMARY KEY (`extra_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `member` (
  `member_id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(60) NOT NULL,
  `member_name` varchar(45) NOT NULL,
  `member_phone` varchar(45) DEFAULT NULL,
  `member_email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `message_board` (
  `message_board_id` int NOT NULL AUTO_INCREMENT,
  `member_name` varchar(45) NOT NULL,
  `message_board_description` varchar(200) NOT NULL,
  PRIMARY KEY (`message_board_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `member_id` int NOT NULL,
  `room_id` varchar(400) DEFAULT NULL,
  `car_id` varchar(400) DEFAULT NULL,
  `extra_id` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `room` (
  `room_id` varchar(20) NOT NULL,
  `room_type_id` int NOT NULL,
  `room_introduce` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `room_type` (
  `room_type_id` int NOT NULL AUTO_INCREMENT,
  `room_type_name` varchar(45) NOT NULL,
  `room_type_price` varchar(45) NOT NULL,
  PRIMARY KEY (`room_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



