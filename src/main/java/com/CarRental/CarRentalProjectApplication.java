package com.CarRental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.CarRental")
public class CarRentalProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(CarRentalProjectApplication.class, args);
	}

}
