--CREATE DATABASE `xiaoliuqiu`;


CREATE TABLE  if  not exists `car` (
  `car_id` varchar(45) NOT NULL,
  `car_type_id` int NOT NULL,
  `car_introduce` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE if  not exists `car_type` (
  `car_type_id` int NOT NULL AUTO_INCREMENT,
  `car_type_name` varchar(45) NOT NULL,
  `car_type_price` varchar(45) NOT NULL,
  PRIMARY KEY (`car_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE if  not exists `extra` (
  `extra_id` int NOT NULL AUTO_INCREMENT,
  `extra_name` varchar(45) NOT NULL,
  `extra_price` varchar(45) NOT NULL,
  PRIMARY KEY (`extra_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE if not exists `member` (
  member_id int NOT NULL AUTO_INCREMENT,
  account varchar(20) NOT NULL,
  password varchar(60) NOT NULL,
  member_name varchar(45) NOT NULL,
  member_phone varchar(45) DEFAULT NULL,
  member_email varchar(45) DEFAULT NULL,
  rest_code varchar(255) DEFAULT NULL,
  verification_code varchar(255) DEFAULT NULL,
  verified tinyint DEFAULT '0',
  member_photo mediumtext NOT NULL,
  PRIMARY KEY (member_id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE if  not exists `room_message_board` (
  `room_message_board_id` int NOT NULL AUTO_INCREMENT,
  `member_name` varchar(45) NOT NULL,
  `room_id` varchar(20) NOT NULL,
  `room_message_board_description` varchar(200) NOT NULL,
  PRIMARY KEY (`room_message_board_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE if not exists orders (
  order_id int NOT NULL AUTO_INCREMENT,
  member_name varchar(45) NOT NULL,
  room_id varchar(400) NOT NULL,
  order_item varchar(400) NOT NULL,
  start_date date NOT NULL,
  end_date date NOT NULL,
  order_date_time datetime DEFAULT NULL,
  order_payment tinyint NOT NULL DEFAULT '0',
  pay_or_not tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (order_id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE if not exists `room` (
  room_id varchar(20) NOT NULL,
  room_name varchar(45) NOT NULL,
  room_introduce varchar(200) DEFAULT NULL,
  room_price int NOT NULL,
  is_open tinyint NOT NULL DEFAULT '0',
  room_photo mediumtext NOT NULL,
  PRIMARY KEY (room_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE if  not exists `attractions_message_board` (
  `attractions_message_board_id` int NOT NULL AUTO_INCREMENT,
  `member_name` varchar(45) NOT NULL,
  `attractions_message_board_description` varchar(45) NOT NULL,
  PRIMARY KEY (`attractions_message_board_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE if not exists `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `access` int NOT NULL,
  `role` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  `active` tinyint DEFAULT '0',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;







