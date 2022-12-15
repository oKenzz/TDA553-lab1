import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class CarTransporterTest{

    private CarTransporter carTransporter;

    @Before
    public void create_CarTransporter(){
        carTransporter = new CarTransporter("SAAB");
    }

    @Test
    public void test_if_CarTransporter_can_load_cars_true(){
        Volvo240 volvo = new Volvo240();
        carTransporter.set_platform();
        carTransporter.load_car(volvo);
        assertEquals(carTransporter.getLoaded_cars().contains(volvo), true);
    }

    @Test
    public void if_cars_have_same_position_as_CarTransporter_true(){
        Volvo240 volvo = new Volvo240();
        carTransporter.set_platform();
        carTransporter.load_car(volvo);
        carTransporter.set_platform();
        carTransporter.gas(1);
        carTransporter.move();
        carTransporter.move();
        List<Vehicle> cars = carTransporter.getLoaded_cars();
        Vehicle car = cars.get(0);
        double[] coordinate = {0, 6};
        System.out.println(car.get_position()[0] + car.get_position()[1]);
        System.out.println(coordinate[0] + coordinate[1]);
        assertEquals(car.get_position()[0] == (coordinate[0]), true);
        assertEquals(car.get_position()[1] == (coordinate[1]), true);
        
    }   

    @Test
    public void test_if_CarTransporter_can_unload_cars_true(){
        Volvo240 volvo = new Volvo240();
        carTransporter.set_platform();
        carTransporter.load_car(volvo);
        carTransporter.unload_car(volvo);
        assertEquals(!carTransporter.getLoaded_cars().contains(volvo), true);
    }





}