package com.example.demo1.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.dao.FoodItemRepo;
import com.example.demo1.dao.RestaurantRepo;
import com.example.demo1.model.FoodItem;

@RestController
public class MenuController {

	@Autowired
	FoodItemRepo menuRepo;
	@Autowired
	RestaurantRepo resturantRepo;

	@GetMapping("/menu/{restaurant}")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<FoodItem> getMenu(@PathVariable String restaurant) {
		
		return menuRepo.getMenu(restaurant);
	}

	public void setMenu() throws IOException {

		List<String> restaurants = resturantRepo.getRestaurantNames();
		for (int i = 0; i < restaurants.size(); i++) {
			File[] files = new File("./src/main/resources/image/" + restaurants.get(i)).listFiles();
			for (File image : files) {
				ClassPathResource img = new ClassPathResource("image/" + restaurants.get(i) + "/" + image.getName());
				byte[] arrayPic = new byte[(int) img.contentLength()];
				img.getInputStream().read(arrayPic);
				FoodItem item = new FoodItem();
				item.setName(image.getName().substring(0, image.getName().length() - 5));
				item.setCategory("deserts");
				item.setPic(arrayPic);
				item.setPrice(220);
				item.setRestaurant(restaurants.get(i));
				menuRepo.save(item);
			}
		}
	}
}
