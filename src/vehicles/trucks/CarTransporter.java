package vehicles.trucks;

import java.util.ArrayList;
import java.util.List;

import carstorage.CarStorage;
import vehicletypes.Truck;
import vehicletypes.Vehicle;


import java.awt.*;
import platform.PlatformWithStates;


public class CarTransporter extends Truck{
    private CarStorage storage;
    private PlatformWithStates platform;
    private int platform_state;

    public CarTransporter(){
        super(2, Color.black, 300, "CarTransporter");
        this.storage = new CarStorage(2);
        this.platform = new PlatformWithStates();
        stopEngine();
    }

    public void set_platform(){
        if(getCurrentSpeed() > 0) throw new IllegalStateException("Can not raise platform while in motion");
        if(getIs_platform_On()){
            platform_state = 0;
        } else {
            platform_state = 1;
        }
        platform.set_platform(platform_state);
    }

    public void load_car(Vehicle car){
        if(getIs_platform_On()){
            storage.load_car(car, getX(), getY());
        }
    }

    public void unload_car(Vehicle car){
        if(getIs_platform_On()){
            storage.unload_car(car, getX(), getY());
        }
    }

    public List<Vehicle> getLoaded_cars() {
        return storage.getLoaded_cars();
    }

    @Override
    public void move(){
        double x = this.getX();
        double y = this.getY();
        double new_x = x + getDx() * getCurrentSpeed();
        double new_y = y + getDy() * getCurrentSpeed();
        set_position(new_x, new_y);
        CarPositionMsg();

        List<Vehicle> cars = storage.getLoaded_cars();
        for (Vehicle car : cars){
            car.set_position(new_x, new_y);
        }
    }

    public boolean getIs_platform_On() {
        return platform.getIs_platform_On();
    }

    
}
