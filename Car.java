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

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    
    public abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed += speedFactor() * amount;
    }

    private void decrementSpeed(double amount){
        currentSpeed -= speedFactor() * amount;

    }

    public void gas(double amount){
        incrementSpeed(amount);
    }

    public void brake(double amount){
        decrementSpeed(amount);
    }

}