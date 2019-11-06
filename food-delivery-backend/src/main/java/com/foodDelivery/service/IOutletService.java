package com.foodDelivery.service;

import com.foodDelivery.model.Outlet;
import java.util.List;

public interface IOutletService {
    public List<Outlet> getOutlets();
    public List<Outlet> getOutletsByRestaurant(Integer restaurantId);
    public  void setOutlets();

}
