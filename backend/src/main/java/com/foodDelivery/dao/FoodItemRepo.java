package com.foodDelivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodDelivery.model.FoodItem;

public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> {

}
