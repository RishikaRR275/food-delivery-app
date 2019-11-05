package com.foodDelivery;

import com.foodDelivery.dao.RestaurantRepo;
import com.foodDelivery.model.Restaurant;
import com.foodDelivery.service.IRestaurantService;
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
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class RestaurantServiceTest {
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public IRestaurantService restaurantService() {
            return new RestaurantService();
        }
    }

    @Autowired
    IRestaurantService restaurantService;
    @MockBean
    RestaurantRepo restaurantRepo;

    @Before
    public void setUp()  throws Exception{
        List<Restaurant>  restaurants=new ArrayList<>();
        ClassPathResource RestaurantImage = new ClassPathResource("image/restaurants/cream stone.jpeg");
        byte[] arrayPic = new byte[(int) RestaurantImage.contentLength()];
        RestaurantImage.getInputStream().read(arrayPic);
        Restaurant restaurant = new Restaurant("cream stone",
                arrayPic);
        restaurants.add(restaurant);
        Mockito.when(restaurantRepo.findAll()).thenReturn(restaurants);
    }

    @Test
    public void whenValidRestaurantName_thenRestaurantShouldbeFound(){
        String name="cream stone";
        List<Restaurant> restaurants=restaurantRepo.findAll();
        assertThat(restaurants).isNotEmpty();
        assertThat(restaurants.get(0).getName()).isEqualTo(name);
    }

}
