package com.foodDelivery.service;

import java.io.IOException;
import java.util.List;
import com.foodDelivery.model.FoodItem;

public interface IMenuService {
	public void setMenu() throws IOException;

	public List<FoodItem> getMenu();
}
