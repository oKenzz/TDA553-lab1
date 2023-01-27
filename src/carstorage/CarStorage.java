package carstorage;

import java.util.ArrayList;
import java.util.List;
import interfaces.ILoadable;
import vehicletypes.Vehicle;

public class CarStorage implements ILoadable{

    private List<Vehicle> loaded_cars;
    private int max_cars;

    public CarStorage(int max_cars){
        loaded_cars = new ArrayList<Vehicle>(max_cars);
    }
  
    @Override
    public void load_car(Vehicle car, double x, double y) {
        if (in_proximity(car, x, y)) {
            loaded_cars.add(car);
            car.set_position(x, y);
        }        
    }

    @Override
    public void unload_car(Vehicle car, double x, double y) {
        loaded_cars.remove(car);
        car.set_position(x + 1, y + 1);        
    }

    private boolean in_proximity(Vehicle car, double x, double y){
        double car_x = car.getX();
        double car_y = car.getY();
        return ((car_x >= x-2.5 && car_x <= x+2.5) && (car_y >= y-2.5 && car_y <= y+2.5));
    }

    public List<Vehicle> getLoaded_cars() {
        return loaded_cars;
    }    
}
