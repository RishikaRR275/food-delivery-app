package com.foodDelivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodDelivery.model.Outlet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OutletRepo extends JpaRepository<Outlet, Integer> {

    @Query("select o from Outlet o where o.restaurant.id=:restaurant_id")
    public List<Outlet> getOutletsByRestaurant(@Param("restaurant_id") Integer restaurant_id);
}
