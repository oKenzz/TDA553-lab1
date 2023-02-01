package vehicles.trucks;

import java.awt.*;
import platform.PlatformWithAngle;
import vehicletypes.Truck;

public class Scania extends Truck{

    private final static int MAX_DEGREE = 70;
    private PlatformWithAngle platform;

    public Scania() {
        super(2, Color.red, 200, "Scania");
        this.platform = new PlatformWithAngle(MAX_DEGREE);
        stopEngine();
    }

    public void set_platform(int angle){
        if(getCurrentSpeed() > 0) throw new IllegalStateException("Can not raise platform while in motion");
            platform.set_platform(angle);
    }


    public boolean getIs_platform_On() {
        return platform.getIs_platform_On();
    }

    public int getPlatform_angle() {
        return platform.getPlatform_angle();
    }

    public static int getMaxDegree() {
        return MAX_DEGREE;
    }
}
 
