package com.foodDelivery.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.foodDelivery.dao.RestaurantRepo;
import com.foodDelivery.model.Restaurant;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RestaurantService implements IRestaurantService {
	@Autowired
	RestaurantRepo restaurantRepo;

	@Override
	public void setRestaurants() throws IOException {
		File[] files = new File("./src/main/resources/image/restaurants").listFiles();
		for (File file : files) {
			ClassPathResource RestaurantImage = new ClassPathResource("image/restaurants/" + file.getName());
			byte[] arrayPic = new byte[(int) RestaurantImage.contentLength()];
			RestaurantImage.getInputStream().read(arrayPic);
			Restaurant restaurant = new Restaurant(file.getName().substring(0, file.getName().length() - 5),
					arrayPic);
			restaurantRepo.save(restaurant);

		}
	}

	@Override
	public List<Restaurant> getRestaurants() {
		return restaurantRepo.findAll();
	}

}
