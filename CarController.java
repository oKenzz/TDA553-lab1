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
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    //Model
    CarModel model;

    // A list of cars, modify if needed
    ArrayList<VehicleObject> cars = new ArrayList<>();

    //methods:

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

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (VehicleObject car : model.getCars()) {
                car.getVehicle().move();
                int x = (int) Math.round(car.getVehicle().getX());
                int y = (int) Math.round(car.getVehicle().getY());
                car.setPosition(x, y);
                // frame.drawPanel.moveit(x, y, car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (VehicleObject car : model.getCars()) {
            car.getVehicle().gas(gas);
        }
    }
}
