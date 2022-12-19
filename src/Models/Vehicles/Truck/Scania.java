import java.awt.*;

public class Scania extends Truck {

    public Scania() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 200;
        is_platform_On = false;
        platform_angle = 0;
        maximum_angle = 70;
        modelName = "Scania";
        stopEngine();
    }

    public int getPlatform_degree(){
        return platform_angle;
    }
}
