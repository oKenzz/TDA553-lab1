import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;
    

    public Saab95(int nrDoors, Color color, double enginePower, String modelName, boolean turboOn) {
        super(nrDoors, color, enginePower, modelName);
        this.turboOn = turboOn;
        // this.enginePower = 125;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    // Overriding
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn)
            turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    @Override
    public void incrementSpeed(double amount) {
        if (getCurrentSpeed() != 0) {
            setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
        }
        else {
            System.out.println("The carEngine is off");
        }
    }

    @Override
    public void decrementSpeed(double amount) {
        // currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    }

    // Movable
    public void move() {
    }

    public void turnLeft() {

    }

    public void turnRight() {

    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }
}
