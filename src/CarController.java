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
    private CarView frame;

    // Model
    private CarModel model;

    // methods:

    public CarController(CarModel model, CarView frame){
        this.model = model;
        this.frame = frame;
        setupActions();
    }

    public static void main(String[] args) {
        // Instance of this class
        CarModel model = new CarModel();
        CarView frame = new CarView("CarSim 1.0");
        CarController cc = new CarController(model, frame);

        // Start a new view and send a reference of self
        cc.frame.getDrawPanel().setModel(model.getCars());
        // Start the timer
        cc.timer.start();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (VehicleObject car : model.getCars()) {
                Vehicle current_car = car.getVehicle();
                model.move(current_car);
                int x = (int) Math.round(current_car.getX());
                int y = (int) Math.round(current_car.getY());
                model.setPosition(x, y, car);
                model.check_bounds(frame.getX(), frame.getY()-frame.getDIFF());
                frame.getDrawPanel().repaint();
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

    private void gasSpinnerSetup(){
        frame.getGasSpinner().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int gasAmount = (int) ((JSpinner)e.getSource()).getValue();
                model.setAmount(gasAmount);
            }
        });
    }

    private void gasButtonSetup(){
        frame.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas();
            }
        });
    }

    private void brakeButtonSetup(){
        frame.getBrakeButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.brake();
            }
        });
    }

    private void turboOnButtonSetup(){
        frame.getTurboOnButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.turboOn();
            }
        });
    }

    private void turboOffButtonSetup(){
        frame.getTurboOffButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.turboOff();
            }
        });
    }

    private void liftBedButtonSetup(){
        frame.getLiftBedButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.liftBed();
            }
        });
    }

    private void lowerBedButtonSetup(){
        frame.getLowerBedButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.lowerBed();
            }
        });
    }

    private void startButtonSetup(){
        frame.getStartButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.startCars();
            }
        });
    }

    private void stopButtonSetup(){
        frame.getStopButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.stopCars();
            }
        });
    }

    private void turnRightButtonSetup(){
        frame.getTurnRightButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.turnRight();
            }
        });
    }

    private void turnLeftButtonSetup(){
        frame.getTurnLeftButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                model.turnLeft();
            }
        });
    }
}
