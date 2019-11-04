package com.foodDelivery.controller;

import java.sql.SQLOutput;
import java.util.List;

import com.foodDelivery.model.Outlet;
import com.foodDelivery.service.IOutletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.foodDelivery.model.FoodItem;
import com.foodDelivery.service.IMenuService;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "http://localhost:3000")
public class MenuController {
	@Autowired
	IMenuService menuService;
	@Autowired
	IOutletService outletService;

	@GetMapping("/{restaurantId}")
	public List<FoodItem> getMenu(@PathVariable Integer restaurantId) {
		List<Outlet> outlets=outletService.getOutletsByRestaurant(restaurantId);
		if(outlets.size()>0){
			return menuService.getMenuByOutlet(outlets.get(0).getId());
		}
		else return null;
	}
}
