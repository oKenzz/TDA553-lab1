
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class CarTransporter extends Truck implements ILoadable{
    private List<Vehicle> loaded_cars;

    public CarTransporter(String modelname){
        loaded_cars = new ArrayList<Vehicle>(2); 
        nrDoors = 2;
        color = Color.black;
        enginePower = 300;
        is_platform_On = false;
        platform_angle = 0;
        maximum_angle = 1;
        modelName = modelname;
        stopEngine();
    }

    public void load_car(Vehicle car){
        if(is_platform_On && in_proximity(car)){
            loaded_cars.add(car);
            double carTransporterX = this.getX();
            double carTransporterY = this.getY();
            car.set_position(carTransporterX, carTransporterY);
        }
    }

    public void unload_car(Vehicle car){
        if(is_platform_On){
            double carTransporterX = this.getX();
            double carTransporterY = this.getY();
            loaded_cars.remove(car);
            car.set_position(carTransporterX + 1, carTransporterY + 1);
        }
    }

    private boolean in_proximity(Vehicle car){
        double car_x = car.getX();
        double car_y = car.getY();

        double carTransporterX = this.getX();
        double carTransporterY = this.getY();
        return ((car_x >= carTransporterX-2.5 && car_x <= carTransporterX+2.5) && (car_y >= carTransporterY-2.5 && car_y <= carTransporterY+2.5));
    }

    public List<Vehicle> getLoaded_cars() {
        return loaded_cars;
    }

    @Override
    public void move(){
        double x = this.getX();
        double y = this.getY();
        double new_x = x + getDx()*currentSpeed;
        double new_y = y + getDy()*currentSpeed;
        set_position(new_x, new_y);
        CarPositionMsg();

        List<Vehicle> cars = getLoaded_cars();
        for (Vehicle car : cars){
            car.set_position(new_x, new_y);
        }

        
    }

}
