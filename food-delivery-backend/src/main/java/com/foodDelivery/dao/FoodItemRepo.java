package com.foodDelivery.dao;

import com.foodDelivery.model.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import com.foodDelivery.model.FoodItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> {
    @Query("select f from FoodItem f where f.outlet.id=:outlet_id")
    public List<FoodItem> getMenuByOutlet(@Param("outlet_id") Integer outlet_id);
}
