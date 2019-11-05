package com.foodDelivery;

import com.foodDelivery.dao.FoodItemRepo;
import com.foodDelivery.dao.OutletRepo;
import com.foodDelivery.model.FoodItem;
import com.foodDelivery.model.Outlet;
import com.foodDelivery.model.OutletAddress;
import com.foodDelivery.model.Restaurant;
import com.foodDelivery.service.IMenuService;
import com.foodDelivery.service.IRestaurantService;
import com.foodDelivery.service.MenuService;
import com.foodDelivery.service.RestaurantService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class MenuServiceTest {
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public IMenuService menuService() {
            return new MenuService();
        }
    }
    @Autowired
    IMenuService menuService;
    @MockBean
    FoodItemRepo menuRepo;
    @MockBean
    OutletRepo outletRepo;

    @Before
    public void setUp()  throws Exception {
        File[] files = new File("./src/main/resources/image/cream stone").listFiles();
        ClassPathResource RestaurantImage = new ClassPathResource("image/restaurants/cream stone.jpeg");
        byte[] arrayPic = new byte[(int) RestaurantImage.contentLength()];
        RestaurantImage.getInputStream().read(arrayPic);
        Restaurant restaurant = new Restaurant("cream stone",
                arrayPic);

        OutletAddress address = new OutletAddress(4, "himayat nagar", 500029, "hyderabad");

        Outlet outlet = new Outlet(4.0f, restaurant, address);
        outlet.setId(1);
        List<FoodItem> menu=new ArrayList<>();
        for (File image : files) {
            ClassPathResource img = new ClassPathResource("image/cream stone" + "/" + image.getName());
            byte[] foodItemArrayPic = new byte[(int) img.contentLength()];
            img.getInputStream().read(foodItemArrayPic);
            FoodItem item = new FoodItem(image.getName().substring(0, image.getName().length() - 5), 220, "deserts",
                    outlet, foodItemArrayPic);
            menu.add(item);

        }
        Mockito.when(menuRepo.getMenuByOutlet(outlet.getId())).thenReturn(menu);
    }
    @Test
    public void whenValidOutletId_thenMenuShouldbeFound(){
        List<String> foodItems=new ArrayList<>();
        foodItems.add("Brownie Break");
        foodItems.add("Chocoholics");
        foodItems.add("Coffee Craze");
        foodItems.add("Devils Brownie");
        foodItems.add("Ferrero Rocher");
        foodItems.add("Willy Wonka");
        List<FoodItem> menu=menuRepo.getMenuByOutlet(1);
        assertThat(menu).isNotEmpty();
        for(FoodItem item:menu)
            assertThat(item.getName()).isIn(foodItems);
    }
}
