package vehicle;

import org.junit.Before;
import org.junit.Test;

import vehicles.trucks.Scania;

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
        scania.set_platform(45);
        assertEquals(scania.getPlatform_angle() == 45, true);
    }
    
    @Test(expected = IllegalStateException.class)
    public void startEngine_while_raised_is_false(){
        scania.set_platform(70);
        scania.startEngine();
    }

    @Test(expected = IllegalStateException.class)
    public void cant_raise_platform_while_in_motion_true(){
        scania.gas(1);
        scania.set_platform(60);
    }
}
