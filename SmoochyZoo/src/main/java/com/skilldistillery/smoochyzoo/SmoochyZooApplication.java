package com.skilldistillery.smoochyzoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.skilldistillery.jpasmoochyzoo.entities")
public class SmoochyZooApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmoochyZooApplication.class, args);
	}

}
