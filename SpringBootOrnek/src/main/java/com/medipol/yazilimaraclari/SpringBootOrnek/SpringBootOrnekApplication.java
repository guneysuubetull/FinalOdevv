package com.medipol.yazilimaraclari.SpringBootOrnek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 1-) Run as Java application

// 2-) Maven Build : goal kısmına "spring-boot:run"
@SpringBootApplication
public class SpringBootOrnekApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOrnekApplication.class, args);
	}
}
