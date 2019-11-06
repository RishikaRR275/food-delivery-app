package com.foodDelivery.service;

import com.foodDelivery.dao.OutletAddressRepo;
import com.foodDelivery.dao.OutletRepo;
import com.foodDelivery.dao.RestaurantRepo;
import com.foodDelivery.model.Address;
import com.foodDelivery.model.Outlet;
import com.foodDelivery.model.OutletAddress;
import com.foodDelivery.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OutletService implements IOutletService {

    @Autowired
    OutletRepo outletRepo;
    @Autowired
    RestaurantRepo restaurantRepo;
    @Autowired
    OutletAddressRepo outletAddressRepo;
    @Override
    public List<Outlet> getOutlets() {
        return outletRepo.findAll();
    }

    @Override
    public List<Outlet> getOutletsByRestaurant(Integer restaurantId) {
        return outletRepo.getOutletsByRestaurant(restaurantId);
    }

    @Override
    public void setOutlets() {
        List<Restaurant> restaurants=restaurantRepo.findAll();
        for (Restaurant restaurant:restaurants){
            OutletAddress address=new OutletAddress(4,"himayat nagar",500029,"hyderabad");
            outletAddressRepo.save(address);
            Outlet outlet=new Outlet(4.0f,restaurant,address);
            outletRepo.save(outlet);
        }
    }
}
