package com.foodDelivery;

import com.foodDelivery.dao.OutletAddressRepo;
import com.foodDelivery.dao.OutletRepo;
import com.foodDelivery.dao.RestaurantRepo;
import com.foodDelivery.model.Outlet;
import com.foodDelivery.model.Restaurant;
import com.foodDelivery.service.IOutletService;
import com.foodDelivery.service.OutletService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class OutletServiceTest {
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public IOutletService restaurantService() {
            return new OutletService();
        }
    }
    @Autowired
    OutletService outletService;
    @MockBean
    OutletRepo outletRepo;
    @MockBean
    RestaurantRepo restaurantRepo;
    @MockBean
    OutletAddressRepo outletAddressRepo;

    @Before
    public void  setUp(){
        List<Outlet> outlets=new ArrayList<>();
        List<Outlet> outletsOfSameRestaurant=new ArrayList<>();
        Restaurant restaurant=new Restaurant();
        restaurant.setId(1);
       for(int i=1;i<=3;i++) {
           Outlet outlet = new Outlet(4f, restaurant, null);
           outlet.setId(i);
           outlets.add(outlet);
           outletsOfSameRestaurant.add(outlet);
       }
       for (int i=4;i<=5;i++){
           Outlet outlet = new Outlet(4f, null, null);
           outlet.setId(i);
           outlets.add(outlet);
       }
        Mockito.when(outletRepo.findAll()).thenReturn(outlets);
        Mockito.when(outletRepo.getOutletsByRestaurant(restaurant.getId())).thenReturn(outletsOfSameRestaurant);
    }

    @Test
    public void whenValidOutletId_thenOutletShouldBeFound(){
        List<Outlet> outlets=outletService.getOutlets();
        assertThat(outlets).isNotEmpty();
        for(int i=1;i<=5;i++)
            assertThat(outlets.get(i-1).getId()).isEqualTo(i);
    }
    @Test
    public void whenValidOutlets_thenOutletShouldBeFound(){
        List<Outlet> outlets=outletService.getOutletsByRestaurant(1);
        assertThat(outlets).isNotEmpty();
        for(int i=1;i<=3;i++)
            assertThat(outlets.get(i-1).getId()).isEqualTo(i);
    }

}
