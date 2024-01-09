package com.example.XiaoLiuqiu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class XiaoLiuqiuApplication {

	public static void main(String[] args) {
		SpringApplication.run(XiaoLiuqiuApplication.class, args);
	}

}
