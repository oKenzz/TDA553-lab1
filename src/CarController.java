import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import vehicletypes.Vehicle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> lab3_develop

    // A list of cars
    private ArrayList<VehicleObject> cars = new ArrayList<>();

    // Controllers
    private JPanel controlPanel = new JPanel();
    private JPanel gasPanel = new JPanel();
    private JSpinner gasSpinner = new JSpinner();
    private JLabel gasLabel = new JLabel("Amount of gas");
    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turnRightButton = new JButton("Turn Right");
    private JButton turnLeftButton = new JButton("Turn Left");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");
    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");

<<<<<<< HEAD
>>>>>>> d26cf1d (update)
=======
>>>>>>> lab3_develop

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
<<<<<<< HEAD
<<<<<<< HEAD
        CarController cc = new CarController(model, frame);

        // Start a new view and send a reference of self
        cc.frame.getDrawPanel().setModel(model.getCars());
=======
        frame.getDrawPanel().setModel(model.getCars());
        CarController cc = new CarController(model, frame);

        // Start a new view and send a reference of self
>>>>>>> d26cf1d (update)
=======
        frame.getDrawPanel().setModel(model.getCars());
        CarController cc = new CarController(model, frame);

        // Start a new view and send a reference of self
>>>>>>> lab3_develop
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

    public CarController(CarModel carModel, CarView view){
        this.model = carModel;
        this.frame = view;
        addComponents();
        setupActions();
        frame.revalidate();
    }

    private void addComponents(){
        SpinnerModel spinnerModel =
        new SpinnerNumberModel(0, //initial value
                0, //mindelay
                100, //max
                1);//step
        gasSpinner = new JSpinner(spinnerModel);
       

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        frame.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,5));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turnRightButton, 1);
        controlPanel.add(turboOnButton, 2);
        controlPanel.add(liftBedButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turnLeftButton, 5);
        controlPanel.add(turboOffButton, 6);
        controlPanel.add(lowerBedButton, 7);
        controlPanel.setPreferredSize(new Dimension((frame.getX()/2)+4, 200));
        controlPanel.setBackground(Color.CYAN);
        frame.add(controlPanel);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(frame.getX()/5-15,200));
        frame.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(frame.getX()/5-15,200));
        frame.add(stopButton);

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

<<<<<<< HEAD
<<<<<<< HEAD
    private void gasSpinnerSetup(){
        frame.getGasSpinner().addChangeListener(new ChangeListener() {
            @Override
=======
    //TODO: use getters through frame.get() instead, remove parameters
    private void gasSpinnerSetup(){
        gasSpinner.addChangeListener(new ChangeListener() {
>>>>>>> d26cf1d (update)
=======
    //TODO: use getters through frame.get() instead, remove parameters
    private void gasSpinnerSetup(){
        gasSpinner.addChangeListener(new ChangeListener() {
>>>>>>> lab3_develop
            public void stateChanged(ChangeEvent e) {
                int gasAmount = (int) ((JSpinner)e.getSource()).getValue();
                model.setAmount(gasAmount);
            }
        });
    }

    private void gasButtonSetup(){
<<<<<<< HEAD
<<<<<<< HEAD
        frame.getGasButton().addActionListener(new ActionListener() {
=======
        gasButton.addActionListener(new ActionListener() {
>>>>>>> d26cf1d (update)
=======
        gasButton.addActionListener(new ActionListener() {
>>>>>>> lab3_develop
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas();
            }
        });
    }

    private void brakeButtonSetup(){
<<<<<<< HEAD
<<<<<<< HEAD
        frame.getBrakeButton().addActionListener(new ActionListener(){
=======
        brakeButton.addActionListener(new ActionListener(){
>>>>>>> d26cf1d (update)
=======
        brakeButton.addActionListener(new ActionListener(){
>>>>>>> lab3_develop
            @Override
            public void actionPerformed(ActionEvent e){
                model.brake();
            }
        });
    }

    private void turboOnButtonSetup(){
<<<<<<< HEAD
<<<<<<< HEAD
        frame.getTurboOnButton().addActionListener(new ActionListener(){
=======
        turboOnButton.addActionListener(new ActionListener(){
>>>>>>> d26cf1d (update)
=======
        turboOnButton.addActionListener(new ActionListener(){
>>>>>>> lab3_develop
            @Override
            public void actionPerformed(ActionEvent e){
                model.turboOn();
            }
        });
    }

    private void turboOffButtonSetup(){
<<<<<<< HEAD
<<<<<<< HEAD
        frame.getTurboOffButton().addActionListener(new ActionListener(){
=======
        turboOffButton.addActionListener(new ActionListener(){
>>>>>>> d26cf1d (update)
=======
        turboOffButton.addActionListener(new ActionListener(){
>>>>>>> lab3_develop
            @Override
            public void actionPerformed(ActionEvent e){
                model.turboOff();
            }
        });
    }

    private void liftBedButtonSetup(){
<<<<<<< HEAD
<<<<<<< HEAD
        frame.getLiftBedButton().addActionListener(new ActionListener(){
=======
        liftBedButton.addActionListener(new ActionListener(){
>>>>>>> d26cf1d (update)
=======
        liftBedButton.addActionListener(new ActionListener(){
>>>>>>> lab3_develop
            @Override
            public void actionPerformed(ActionEvent e){
                model.liftBed();
            }
        });
    }

    private void lowerBedButtonSetup(){
<<<<<<< HEAD
<<<<<<< HEAD
        frame.getLowerBedButton().addActionListener(new ActionListener(){
=======
        lowerBedButton.addActionListener(new ActionListener(){
>>>>>>> d26cf1d (update)
=======
        lowerBedButton.addActionListener(new ActionListener(){
>>>>>>> lab3_develop
            @Override
            public void actionPerformed(ActionEvent e){
                model.lowerBed();
            }
        });
    }

    private void startButtonSetup(){
<<<<<<< HEAD
<<<<<<< HEAD
        frame.getStartButton().addActionListener(new ActionListener(){
=======
        startButton.addActionListener(new ActionListener(){
>>>>>>> d26cf1d (update)
=======
        startButton.addActionListener(new ActionListener(){
>>>>>>> lab3_develop
            @Override
            public void actionPerformed(ActionEvent e){
                model.startCars();
            }
        });
    }

    private void stopButtonSetup(){
<<<<<<< HEAD
<<<<<<< HEAD
        frame.getStopButton().addActionListener(new ActionListener(){
=======
        stopButton.addActionListener(new ActionListener(){
>>>>>>> d26cf1d (update)
=======
        stopButton.addActionListener(new ActionListener(){
>>>>>>> lab3_develop
            @Override
            public void actionPerformed(ActionEvent e){
                model.stopCars();
            }
        });
    }

    private void turnRightButtonSetup(){
<<<<<<< HEAD
<<<<<<< HEAD
        frame.getTurnRightButton().addActionListener(new ActionListener(){
=======
        turnRightButton.addActionListener(new ActionListener(){
>>>>>>> d26cf1d (update)
=======
        turnRightButton.addActionListener(new ActionListener(){
>>>>>>> lab3_develop
            @Override
            public void actionPerformed(ActionEvent e){
                model.turnRight();
            }
        });
    }

    private void turnLeftButtonSetup(){
<<<<<<< HEAD
<<<<<<< HEAD
        frame.getTurnLeftButton().addActionListener(new ActionListener(){
=======
        turnLeftButton.addActionListener(new ActionListener(){
>>>>>>> d26cf1d (update)
=======
        turnLeftButton.addActionListener(new ActionListener(){
>>>>>>> lab3_develop
            @Override
            public void actionPerformed(ActionEvent e){
                model.turnLeft();
            }
        });
    }
}
