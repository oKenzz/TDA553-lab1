import java.awt.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CarTest {

    Volvo240 volvo;
    Saab95 saab;

    @Before
    public void create_cars() {
        volvo = new Volvo240();
        saab = new Saab95();
    }

    @Test
    public void can_car_start_engine_true() {
        volvo.startEngine();
        assertTrue(volvo.getCurrentSpeed() == 0.1);
    }

    @Test
    public void can_car_stop_engine_true() {
        volvo.startEngine();
        volvo.stopEngine();
        assertTrue(volvo.getCurrentSpeed() == 0);
    }

    @Test
    public void can_car_gas_true() {
        saab.gas(1);
        assertTrue(saab.getCurrentSpeed() == 1.25);
    }

    @Test
    public void can_saab_set_turboOn_true() {
        saab.setTurboOn();
        assertTrue(saab.isTurboOn() == true);
    }


    @Test
    public void can_car_face_up_true() {
        assertTrue(saab.getDx() == 0);
        assertTrue(saab.getDy() == 1);
    }

    @Test
    public void can_car_face_right_true() {
        saab.turnRight();
        assertTrue(saab.getDx() == 1);
        assertTrue(saab.getDy() == 0);
    }

    @Test
    public void can_car_face_left_true() {
        saab.turnLeft();
        assertTrue(saab.getDx() == -1);
        assertTrue(saab.getDy() == 0);
    }

    @Test
    public void can_car_face_down_true() {
        saab.turnRight();
        saab.turnRight();
        assertTrue(saab.getDx() == 0);
        assertTrue(saab.getDy() == -1);
    }

    @Test
    public void can_car_move_y_axis_true() {
        volvo.gas(1);
        volvo.move();
        assertTrue(volvo.getY() == 1.25);
    }

    @Test
    public void can_car_move_x_axis_true() {
        volvo.gas(1);
        volvo.turnRight();
        volvo.move();
        assertTrue(volvo.getX() == 1.25);
    }

    @Test
    public void can_gas_accept_value_outside_interval_false(){
        volvo.gas(2);
        assertEquals(volvo.getCurrentSpeed() == 2.5, false);
    }

    @Test
    public void can_gas_decrement_speed_false(){
        volvo.gas(-1);
        assertEquals(volvo.getCurrentSpeed() == -1.25, false);
    }

    @Test
    public void can_brake_increment_speed_false(){
        volvo.brake(-1);
        assertEquals(volvo.getCurrentSpeed() == 1.25, false);
    }

    @Test
    public void currentSpeed_always_within_interval_false(){
        saab.brake(1);
        assertEquals(saab.getCurrentSpeed() == -1.25, false);
    }

    @Test
    public void currentSpeed_higher_than_interval_false(){
        while(saab.getCurrentSpeed() < saab.getEnginePower()){
            saab.gas(1);
            System.out.println(saab.getCurrentSpeed());
        }
        saab.gas(1);
        assertEquals(saab.getCurrentSpeed() > saab.getEnginePower(), false);
    }
}
