import javax.swing.*;

import vehicles.cars.*;
import vehicles.trucks.Scania;
import vehicletypes.Vehicle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the
    // statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    // Model
    CarModel model;

    // A list of cars, modify if needed
    ArrayList<VehicleObject> cars = new ArrayList<>();

    // methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.model = new CarModel();
        cc.cars = cc.model.getCars();

        // Volvo240 volvo240 = new Volvo240();
        // Saab95 saab95 = new Saab95();
        // Scania scania = new Scania();

        // saab95.set_position(0, 100);
        // scania.set_position(0,200);

        // cc.cars.add(volvo240);
        // cc.cars.add(saab95);
        // cc.cars.add(scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.frame.drawPanel.setModel(cc.cars); // Getter for drawPanel????

        // Start the timer
        cc.timer.start();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (VehicleObject car : cars) {
                Vehicle current_car = car.getVehicle();
                // current_car.move();
                model.move(current_car);
                int x = (int) Math.round(current_car.getX());
                int y = (int) Math.round(current_car.getY());
                model.setPosition(x, y, car);
                model.check_bounds(1000, 360); // Find the correct x and y value
                // frame.drawPanel.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        model.gas(amount);
    }

    public void brake(int amount) {
        model.brake(amount);
    }

    public void turboOn() {
        model.turboOn();
    }

    public void turboOff() {
        model.turboOff();
    }

    public void liftBed() {
        model.liftBed();
    }

    public void lowerBed() {
        model.lowerBed();
    }

    public void startCars() {
        model.startCars();
    }

    public void stopCars() {
        model.stopCars();
    }

    public void turnRight(){
        model.turnRight();
    }

    public void turnLeft(){
        model.turnLeft();
    }
}
