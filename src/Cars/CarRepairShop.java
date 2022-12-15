import java.util.ArrayList;
import java.util.List;

public class CarRepairShop {
    private List<Vehicle> cars = new ArrayList<Vehicle>(5);
    private int x = 10;
    private int y = 10;

    public void load_car(Vehicle car){
        if(in_proximity(car)){
            cars.add(car);
        }
    }

    public void unload_car(Vehicle car){
            // car.setX(random_value_within_proximity);
            // car.setY(random_value_within_proximity);
            cars.remove(car);
        }

    public boolean in_proximity(Vehicle car){
        int car_x = car.getDx();
        int car_y = car.getDy();
        return (car_x >= x-10 || car_x <= x+10 && car_y >= y-10 || car_y <= y+10);
    }
}
