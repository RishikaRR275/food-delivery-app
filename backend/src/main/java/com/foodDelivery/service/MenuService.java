package com.foodDelivery.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.foodDelivery.dao.FoodItemRepo;
import com.foodDelivery.dao.OutletRepo;
import com.foodDelivery.dao.RestaurantRepo;
import com.foodDelivery.model.FoodItem;
import com.foodDelivery.model.Outlet;
import com.foodDelivery.model.Restaurant;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuService implements IMenuService {
	@Autowired
	FoodItemRepo menuRepo;
	@Autowired
	OutletRepo outletRepo;

	@Override
	public void setMenu() throws IOException {
		List<Outlet> outlets = outletRepo.findAll();
		for (int i = 0; i < outlets.size(); i++) {
			File[] files = new File("./src/main/resources/image/" + outlets.get(i).getRestaurant().getName()).listFiles();
			for (File image : files) {
				ClassPathResource img = new ClassPathResource("image/" + outlets.get(i).getRestaurant().getName() + "/" + image.getName());
				byte[] arrayPic = new byte[(int) img.contentLength()];
				img.getInputStream().read(arrayPic);
				FoodItem item = new FoodItem(image.getName().substring(0, image.getName().length() - 5), 220, "deserts",
						outlets.get(i), arrayPic);
				menuRepo.save(item);
			}
		}
	}

	@Override
	public List<FoodItem> getMenu() {
		return menuRepo.findAll();
	}

	@Override
	public List<FoodItem> getMenuByOutlet(Integer outlet) {
		return menuRepo.getMenuByOutlet(outlet);
	}
}
