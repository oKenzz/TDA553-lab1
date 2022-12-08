import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;
    

    public Saab95(int nrDoors, Color color, double enginePower, String modelName, boolean turboOn) {
        super(nrDoors, color, enginePower, modelName);
        this.turboOn = turboOn;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }
    

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn)
            turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public boolean isTurboOn() {
        return turboOn;
    }
}
