import java.util.ArrayList;
import java.util.List;

public abstract class Truck extends Vehicle {


    protected boolean platform_down;

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
    
    public abstract void set_platform();
}
