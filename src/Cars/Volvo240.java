import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;
    

    public Volvo240(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
  
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
