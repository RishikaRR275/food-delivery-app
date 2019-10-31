package com.foodDelivery.controller;

import java.util.List;
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

	@GetMapping("/{restaurant}")
	public List<FoodItem> getMenu(@PathVariable String restaurant) {
		return menuService.getMenu();
	}
}
