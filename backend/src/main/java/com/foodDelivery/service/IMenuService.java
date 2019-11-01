package com.foodDelivery.service;

import java.io.IOException;
import java.util.List;
import com.foodDelivery.model.FoodItem;
import com.foodDelivery.model.Outlet;

public interface IMenuService {
	public void setMenu() throws IOException;

	public List<FoodItem> getMenu();
	public  List<FoodItem> getMenuByOutlet(Integer outlet);
}
