import java.awt.*;

public class Scania extends Truck {

    public Scania() {
        super(2, Color.red, 200, "Scania", new PlatformWithAngle(70));
        stopEngine();
    }
}
 
