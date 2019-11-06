package com.foodDelivery.dao;

import com.foodDelivery.model.OutletAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutletAddressRepo extends JpaRepository<OutletAddress,Integer> {
}
