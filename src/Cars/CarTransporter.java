import java.util.ArrayList;
import java.util.List;

public class CarTransporter extends Car{
    protected boolean platform_down;
    private List<Car> loaded_cars = new ArrayList<Car>(5); 

    public void set_platform(){
        platform_down = (platform_down) ? false : true;
    }

    public void load_car(Car car){
        if(platform_down && in_proximity(car)){
            loaded_cars.add(car);
        }
    }

    public void unload_car(Car car){
        if(platform_down){
            // car.setX(random_value_within_proximity);
            // car.setY(random_value_within_proximity);
            loaded_cars.remove(car);
        }
    }

    public boolean in_proximity(Car car){
        double car_x = car.getX();
        double car_y = car.getY();
        System.out.println(car_y <=y+2.5);
        return ((car_x >= x-2.5 && car_x <= x+2.5) && (car_y >= y-2.5 && car_y <= y+2.5));
    }

    @Override
    public double speedFactor() {
        int movable = 1;
        if (platform_down){
            movable = 0;
        }
        return getEnginePower() * 0.01 * movable;
    }

    public List<Car> getLoaded_cars() {
        return loaded_cars;
    }

  
}
