package com.example.demo1;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo1.controller.RestaurantController;

@SpringBootApplication
public class FoodDeliveryAppApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(FoodDeliveryAppApplication.class, args);
	}

}
