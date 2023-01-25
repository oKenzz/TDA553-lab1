package repairshop;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import vehicles.cars.Volvo240;

public class CarRepairShopTest {
    
    private CarRepairShop shop;

    @Before
    public void create_CarRepairShop(){
        shop = new CarRepairShop();
    }

    @Test
    public void test_if_CarRepairShop_can_load_car_true(){
        Volvo240 volvo = new Volvo240();
        shop.load_car(volvo);
        assertEquals(shop.getLoaded_cars().contains(volvo), true);
    }

    @Test
    public void test_if_CarRepairShop_can_unload_car_true(){
        Volvo240 volvo = new Volvo240();
        shop.load_car(volvo);
        shop.unload_car(volvo);
        assertEquals(!shop.getLoaded_cars().contains(volvo), true);
    }
}
