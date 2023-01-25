package vehicles.cars;

import java.awt.*;
import vehicletypes.Vehicle;

public class Volvo240 extends Vehicle {

    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, Color.black, 100, "Volvo240");
    }
  
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
