import java.util.ArrayList;
import java.util.Currency;
import java.awt.Point;
import vehicles.cars.*;
import vehicles.trucks.Scania;
import vehicletypes.Vehicle;


//Has data that other modules manipulate
//This means that other modules have a Model
public class CarModel {
    
    private ArrayList<VehicleObject> cars = new ArrayList<>();

    public CarModel(){

        VehicleObject volvo240 = new VehicleObject(new Volvo240());
        VehicleObject saab95 = new VehicleObject(new Saab95(), new Point(0,100));
        VehicleObject scania = new VehicleObject(new Scania(), new Point(0,200));

        cars.add(volvo240);
        cars.add(saab95);
        cars.add(scania);

    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (VehicleObject car : cars) {
            Vehicle currnet_vehicle = car.getVehicle();
            currnet_vehicle.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (VehicleObject car : cars) {
            Vehicle currnet_vehicle = car.getVehicle();
            currnet_vehicle.brake(brake);
        }
    }

    public void turboOn() {
        for (VehicleObject car : cars) {
            if (car.getVehicle() instanceof Saab95) {
                Saab95 saab = (Saab95) car.getVehicle();
                saab.setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (VehicleObject car : cars) {
            if (car.getVehicle() instanceof Saab95) {
                Saab95 saab = (Saab95) car.getVehicle();
                saab.setTurboOff();
            }
        }
    }

    public void liftBed() {
        int max_degree = Scania.getMaxDegree();
        for (VehicleObject car : cars) {
            if (car.getVehicle() instanceof Scania) {
                Scania scania = (Scania) car.getVehicle();
                scania.set_platform(max_degree);
            }
        }
    }

    public void lowerBed() {
        for (VehicleObject car : cars) {
            if (car.getVehicle() instanceof Scania) {
                Scania scania = (Scania) car.getVehicle();
                scania.set_platform(0);
            }
        }
    }

    public void startCars() {
        for (VehicleObject car : cars) {
            Vehicle currnet_vehicle = car.getVehicle();
            currnet_vehicle.startEngine();        
        }
    }

    public void stopCars() {
        for (VehicleObject car : cars) {
            Vehicle currnet_vehicle = car.getVehicle();
            currnet_vehicle.stopEngine();        
        }
    }

    //TODO: methods for turning right and left

    public void setPosition(int x, int y, VehicleObject car){
        car.setPosition(x, y);
    }

    public void move(Vehicle car){
        car.move();
    }

    public void turnRight(){
        for (VehicleObject car : cars) {
            Vehicle currnet_vehicle = car.getVehicle();
            currnet_vehicle.turnRight();
        }
    }

    public void turnLeft(){
        for (VehicleObject car : cars) {
            Vehicle currnet_vehicle = car.getVehicle();
            currnet_vehicle.turnLeft();        
        }
    }

    public void check_bounds(int x, int y){
        int x_max = x;
        int y_max = y;
        for (VehicleObject car : cars) {
            if (car.getX() > x_max || car.getX() < 0){
                car.getVehicle().turnRight(); // Change to a set Direction
                car.getVehicle().turnRight();
            } else if (car.getY() > x_max || car.getX() < 0){
                car.getVehicle().turnRight();
                car.getVehicle().turnRight();
            }
        }
    }


    public ArrayList<VehicleObject> getCars() {
        return cars;
    }    

    


}
