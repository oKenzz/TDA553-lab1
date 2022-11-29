import java.awt.*;

public abstract class Car implements Movable {

    // private boolean turboOn;
    private int nrDoors; // Number of doors on the car
    private Color color; // Color of the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private String modelName; // The car model name

    // Volvo + Saab
    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    
    public abstract double speedFactor();

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    public abstract void gas(double amount);
    public abstract void brake(double amount);

}