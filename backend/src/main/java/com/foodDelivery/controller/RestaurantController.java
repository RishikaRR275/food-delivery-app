package com.foodDelivery.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.foodDelivery.model.Restaurant;
import com.foodDelivery.service.IRestaurantService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantController {
	@Autowired
	IRestaurantService restaurantService;

	@GetMapping("/")
	public List<Restaurant> getRestaurants() {
		return restaurantService.getRestaurants();
	}
}
