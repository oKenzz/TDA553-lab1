import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

    // A list of cars
    ArrayList<VehicleObject> cars = new ArrayList<>();

    // methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.model = new CarModel();
        cc.cars = cc.model.getCars();

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0");
        cc.frame.drawPanel.setModel(cc.cars);
        cc.setupActions();
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
                model.move(current_car);
                int x = (int) Math.round(current_car.getX());
                int y = (int) Math.round(current_car.getY());
                model.setPosition(x, y, car);
                model.check_bounds(frame.getX(), frame.getY()-frame.getDIFF());
                frame.drawPanel.repaint();
            }
        }
    }

    private void setupActions(){
        gasSpinnerSetup();
        gasButtonSetup();
        brakeButtonSetup();
        turboOnButtonSetup();
        turboOffButtonSetup();
        liftBedButtonSetup();
        lowerBedButtonSetup();
        startButtonSetup();
        stopButtonSetup();
        turnRightButtonSetup();
        turnLeftButtonSetup();
    }

    //TODO: use getters through frame.get() instead, remove parameters
    public void gasSpinnerSetup(){
        frame.getGasSpinner().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int gasAmount = (int) ((JSpinner)e.getSource()).getValue();
                model.setAmount(gasAmount);
            }
        });
    }

    public void gasButtonSetup(){
        frame.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas();
            }
        });
    }

    public void brakeButtonSetup(){
        frame.getBrakeButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.brake();
            }
        });
    }

    public void turboOnButtonSetup(){
        frame.getTurboOnButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.turboOn();
            }
        });
    }

    public void turboOffButtonSetup(){
        frame.getTurboOffButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.turboOff();
            }
        });
    }

    public void liftBedButtonSetup(){
        frame.getLiftBedButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.liftBed();
            }
        });
    }

    public void lowerBedButtonSetup(){
        frame.getLowerBedButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.lowerBed();
            }
        });
    }

    public void startButtonSetup(){
        frame.getStartButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.startCars();
            }
        });
    }

    public void stopButtonSetup(){
        frame.getStopButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.stopCars();
            }
        });
    }

    public void turnRightButtonSetup(){
        frame.getTurnRightButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.turnRight();
            }
        });
    }

    public void turnLeftButtonSetup(){
        frame.getTurnLeftButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.turnLeft();
            }
        });
    }


    //TODO: Remove and add directly in the acitonlisteners
    // public void gas(int amount) {
    //     model.gas(amount);
    // }

    // public void brake(int amount) {
    //     model.brake(amount);
    // }

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
