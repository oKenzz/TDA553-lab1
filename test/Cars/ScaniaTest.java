import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScaniaTest {
    
    private Scania scania;

    @Before
    public void create_scania(){
        scania = new Scania();
    }

    @Test
    public void move_platform_true(){
        scania.move_platform(45);
        assertEquals(scania.getPlatform_degree() == 45, true);
    }


    @Test
    public void scania_cant_move_with_platform_raised_true(){
        scania.move_platform(10);
        scania.gas(1);
        assertEquals(scania.getCurrentSpeed() == 0, true);
    }

    @Test
    public void scania_load_car_true(){
        Volvo240 volvo = new Volvo240();
        scania.set_platform();
        scania.load_car(volvo);
        assertEquals(scania.getLoaded_cars().contains(volvo), true);
    }

    @Test
    public void cant_load_cars_outside_proximity_true(){
        Volvo240 volvo = new Volvo240();
        volvo.gas(1);
        volvo.move();
        volvo.move();
        volvo.move();
        scania.set_platform();
        scania.load_car(volvo);
        assertEquals(!scania.getLoaded_cars().contains(volvo), true);
    }

    @Test
    public void scania_can_unload_cars_true(){
        Volvo240 volvo = new Volvo240();
        scania.set_platform();
        scania.load_car(volvo);
        scania.unload_car(volvo);
        assertEquals(!scania.getLoaded_cars().contains(volvo), true);
    }

}
