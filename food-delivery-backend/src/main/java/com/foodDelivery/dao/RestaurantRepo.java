package com.foodDelivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodDelivery.model.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, String> {

}
