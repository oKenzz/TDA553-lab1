import java.awt.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;


public class CarTest {

    @Test
    public void can_car_move_y_axis_true(){
    Car car = new Volvo240(4, Color.black, 100,"Volvo240");
    car.gas(1);
    car.move();
    assertTrue(car.getY() == 1.25);
    }

    // TODO write more tests for movable

}
