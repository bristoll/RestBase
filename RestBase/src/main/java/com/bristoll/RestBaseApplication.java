package com.bristoll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.bristoll"})
public class RestBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestBaseApplication.class, args);
	}

}
