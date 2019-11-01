package com.foodDelivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodDelivery.model.Outlet;

public interface OutletRepo extends JpaRepository<Outlet, Integer> {

}
