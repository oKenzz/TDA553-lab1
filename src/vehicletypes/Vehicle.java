package vehicletypes;

import java.awt.*;
import java.util.HashMap;
import interfaces.IMovable;

public abstract class Vehicle implements IMovable {
    private final static HashMap<String, int[]> DIRECTIONS = createDirectionsMap(); // HashMap of directions

    // Car attributes
    private int nrDoors; // Number of doors on the car
    private Color color; // The color of the car
    private double enginePower; // The enginePower of the car
    private String modelName; // The car model name
    private double currentSpeed; // The current speed of the car
    private double x = 0; // The car x coordinate
    private double y = 0; // The car y coordinate
    private int dx = 1; // Direction in x-axis
    private int dy = 0; // Direction in y-axis
    private String direction = "RIGHT"; // The direction of the car (Default: up)
    private boolean movable = true;

    public Vehicle(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    protected void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double[] get_position() {
        double[] position = { x, y };
        return position;
    }

    public void set_position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    private String getDirection() {
        return direction;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public void setDirection(String d) {
        int[] directionValues = DIRECTIONS.get(d);
        direction = d;
        this.dx = directionValues[0];
        this.dy = directionValues[1];
    }

    private static HashMap<String, int[]> createDirectionsMap() {
        HashMap<String, int[]> directions = new HashMap<String, int[]>();
        directions.put("UP", new int[] { 0, -1 });
        directions.put("RIGHT", new int[] { 1, 0 });
        directions.put("DOWN", new int[] { 0, 1 });
        directions.put("LEFT", new int[] { -1, 0 });
        return directions;
    }

    public void startEngine() {
        if (!movable) throw new IllegalStateException("Not in a movable state");
        currentSpeed = 0.1;
    }


    public void stopEngine() {
        currentSpeed = 0;
    }

    public void turnRight() {
        switch (getDirection()) {
            case "UP":
                setDirection("RIGHT");
                break;
            case "RIGHT":
                setDirection("DOWN");
                break;
            case "DOWN":
                setDirection("LEFT");
                break;
            case "LEFT":
                setDirection("UP");
                break;
        }
    }

    public void turnLeft() {
        switch (getDirection()) {
            case "UP":
                setDirection("LEFT");
                break;
            case "LEFT":
                setDirection("DOWN");
                break;
            case "DOWN":
                setDirection("RIGHT");
                break;
            case "RIGHT":
                setDirection("UP");
                break;
        }
    }

    public void move() {
        x = x + dx * currentSpeed;
        y = y + dy * currentSpeed;
    }

    public abstract double speedFactor();

    private void incrementSpeed(double amount) {
        double new_speed = 0;
        new_speed = currentSpeed + (speedFactor() * amount);
        if (SpeedLimit(new_speed)) {
            currentSpeed = new_speed;
        }
        if (new_speed > enginePower){
            currentSpeed = enginePower;
        }
    }

    private void decrementSpeed(double amount) {
        double new_speed = 0;
        new_speed = currentSpeed - (speedFactor() * amount);
        if (SpeedLimit(new_speed)) { // currentSpeed always lies between interval [0, enginePower]
            currentSpeed = new_speed;
        }
        if (new_speed < 0){
            currentSpeed = 0;
        }
    }

    public void gas(double amount) {
        if (!interval(amount)) throw new IllegalStateException("Can only gas by a amount of 0 to 1");
        if (currentSpeed == 0) throw new IllegalStateException("Engine must be on to gas"); 
        incrementSpeed(amount);
        System.out.println(currentSpeed);
    }

    public void brake(double amount) {
        if (!interval(amount)) throw new IllegalStateException("Can only gas by a amount of 0 to 1");
        if (currentSpeed == 0) throw new IllegalStateException("Engien must be on to brake"); 
        decrementSpeed(amount);

    }

    private boolean interval(double number){
        double high = 1;
        double low = 0;
        return number >= low && number <= high;
    }

    private boolean SpeedLimit(double new_speed) {
        return new_speed >= 0 && new_speed <= enginePower;
    }

    public String getModelName() {
        return modelName;
    }
}