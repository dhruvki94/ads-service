package com.example.adsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AdsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdsServiceApplication.class, args);
	}


}
