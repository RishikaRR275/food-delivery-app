package com.example.demo1.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.dao.RestaurantRepo;
import com.example.demo1.model.Restaurant;

@RestController
public class RestaurantController {
	@Autowired
	RestaurantRepo restaurantRepo;

	@GetMapping("/restaurants")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Restaurant> getRestaurants() {
		return restaurantRepo.findAll();
	}

	public void setRestaurants() throws IOException {
		File[] files = new File("./src/main/resources/image/restaurants").listFiles();
		for (File file : files) {
			ClassPathResource restaurant = new ClassPathResource("image/restaurants/" + file.getName());
			byte[] arrayPic = new byte[(int) restaurant.contentLength()];
			restaurant.getInputStream().read(arrayPic);
			Restaurant r = new Restaurant();
			r.setName(file.getName().substring(0, file.getName().length() - 5));
			r.setNoOfOutlets(1);
			r.setPic(arrayPic);
			r.setRating(4.0f);
			restaurantRepo.save(r);

		}

	}
}
