package com.foodDelivery.service;

import java.io.IOException;
import java.util.List;
import com.foodDelivery.model.Restaurant;

public interface IRestaurantService {
	public void setRestaurants() throws IOException;

	public List<Restaurant> getRestaurants();
}
