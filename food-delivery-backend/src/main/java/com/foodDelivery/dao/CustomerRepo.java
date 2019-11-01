package com.foodDelivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodDelivery.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
