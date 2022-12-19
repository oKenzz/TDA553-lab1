import java.util.ArrayList;
import java.util.List;

public class CarRepairShop implements ILoadable {
    private List<Vehicle> loaded_cars;
    private int x = 10;
    private int y = 10;

    public CarRepairShop(){
        loaded_cars = new ArrayList<Vehicle>(5);
    }

    public void load_car(Vehicle car) {
        if (in_proximity(car)) {
            loaded_cars.add(car);
        }
    }

    public void unload_car(Vehicle car) {
        loaded_cars.remove(car);
    }

    private boolean in_proximity(Vehicle car) {

        double car_x = car.get_position()[0];
        double car_y = car.get_position()[1];

        return (car_x >= x - 10 || car_x <= x + 10 && car_y >= y - 10 || car_y <= y + 10);
    }
}
