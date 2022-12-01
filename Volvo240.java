import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;
    

    public Volvo240(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }

    // @Override
    // public double speedFactor() {
    //     return getEnginePower() * 0.01 * trimFactor;
    // }

    // @Override
    // public void incrementSpeed(double amount) {
    //     if (getCurrentSpeed() != 0) {
    //         setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    //     } else {
    //         System.out.println("The carEngine is off");
    //     }
    // }

    // @Override
    // public void decrementSpeed(double amount) {
    //     setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    // }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    // TODO fix this method according to lab pm
    // public void gas(double amount) {
    //     incrementSpeed(amount);
    // }


    // TODO fix this method according to lab pm
    // public void brake(double amount) {
    //     decrementSpeed(amount);
    // }
}
