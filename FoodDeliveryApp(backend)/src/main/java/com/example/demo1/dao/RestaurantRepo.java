package com.example.demo1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo1.model.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, String> {

	@Query("select r.name from Restaurant r")
	public List<String> getRestaurantNames();
}
