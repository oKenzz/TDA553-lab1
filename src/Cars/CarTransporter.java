
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class CarTransporter extends Truck implements iloadable{
    protected boolean platform_down;
    private List<Vehicle> loaded_cars;

    public CarTransporter(String modelname){
        loaded_cars = new ArrayList<Vehicle>(2); 
        nrDoors = 2;
        color = Color.black;
        enginePower = 300;
        platform_down = false;
        modelName = modelname;
        stopEngine();
    }

    public void set_platform(){
        platform_down = (platform_down) ? false : true;
    }

    public void load_car(Vehicle car){
        if(platform_down && in_proximity(car)){
            loaded_cars.add(car);
            double carTransporterX = this.get_position()[0];
            double carTransporterY = this.get_position()[1];
            car.set_position(carTransporterX, carTransporterY);
        }
    }

    public void unload_car(Vehicle car){
        if(platform_down){
            double carTransporterX = this.get_position()[0];
            double carTransporterY = this.get_position()[1];
            loaded_cars.remove(car);
            car.set_position(carTransporterX + 1, carTransporterY + 1);
        }
    }

    public boolean in_proximity(Vehicle car){
        double car_x = car.get_position()[0];
        double car_y = car.get_position()[1];

        double carTransporterX = this.get_position()[0];
        double carTransporterY = this.get_position()[1];
        return ((car_x >= carTransporterX-2.5 && car_x <= carTransporterX+2.5) && (car_y >= carTransporterY-2.5 && car_y <= carTransporterY+2.5));
    }

    public List<Vehicle> getLoaded_cars() {
        return loaded_cars;
    }

    @Override
    public void move(){
        double x = this.get_position()[0];
        double y = this.get_position()[1];
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
