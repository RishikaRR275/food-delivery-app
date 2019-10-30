package com.example.demo1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo1.model.FoodItem;

public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> {
	@Query("select i from FoodItem i where i.restaurant=:restaurant")
	public List<FoodItem> getMenu(@Param("restaurant") String restaurant);
}
