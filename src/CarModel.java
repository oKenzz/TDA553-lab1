import java.util.ArrayList;
import java.util.Currency;
import java.awt.Point;
import vehicles.cars.*;
import vehicles.trucks.Scania;
import vehicletypes.Vehicle;

public class CarModel {
    
    private ArrayList<VehicleObject> cars = new ArrayList<>();
    private int amount = 0;

    public CarModel(){

        VehicleObject volvo240 = new VehicleObject(new Volvo240());
        VehicleObject saab95 = new VehicleObject(new Saab95(), new Point(0,100));
        VehicleObject scania = new VehicleObject(new Scania(), new Point(0,200));

        cars.add(volvo240);
        cars.add(saab95);
        cars.add(scania);

    }

    public void gas() {
        double gas = ((double) amount) / 100;
        for (VehicleObject car : cars) {
            Vehicle currnet_vehicle = car.getVehicle();
            try{
                currnet_vehicle.gas(gas);
                } catch (IllegalStateException e){
                    e.printStackTrace();
                }
        }
    }

    public void brake() {
        double brake = ((double) amount) / 100;
        for (VehicleObject car : cars) {
            Vehicle currnet_vehicle = car.getVehicle();
            try{
                currnet_vehicle.brake(brake);
                } catch (IllegalStateException e){
                    e.printStackTrace();
                }
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
                try{
                    scania.set_platform(max_degree);
                } catch (IllegalStateException e){
                        e.printStackTrace();
                }
            }
        }
    }

    public void lowerBed() {
        for (VehicleObject car : cars) {
            if (car.getVehicle() instanceof Scania) {
                Scania scania = (Scania) car.getVehicle();
                try{
                    scania.set_platform(0);
                } catch (IllegalStateException e){
                        e.printStackTrace();
                }
            }
        }
    }

    public void startCars() {
        for (VehicleObject car : cars) {
            Vehicle currnet_vehicle = car.getVehicle();
            try{
            currnet_vehicle.startEngine();
            } catch (IllegalStateException e){
                e.printStackTrace();
            }
        }
    }

    public void stopCars() {
        for (VehicleObject car : cars) {
            Vehicle currnet_vehicle = car.getVehicle();
            currnet_vehicle.stopEngine();        
        }
    }

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
            Vehicle current_vehicle = car.getVehicle();
            if (car.getX() > x_max - 115){
                current_vehicle.setDirection("LEFT");
            } else if (car.getX() < 0){
                current_vehicle.setDirection("RIGHT");
            } else if (car.getY() > y_max - 60){
                current_vehicle.setDirection("UP");
            } else if (car.getY() < 0){
                current_vehicle.setDirection("DOWN");
            }
        }
    }
    
    public ArrayList<VehicleObject> getCars() {
        return cars;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }        
}
