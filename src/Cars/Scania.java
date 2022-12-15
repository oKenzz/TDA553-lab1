import java.awt.*;

public class Scania extends Truck {

    private int platform_degree;

    public Scania() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 200;
        platform_down = true;
        platform_degree = 0;
        modelName = "Scania";
        stopEngine();
    }
    
    public void set_platform(int amount) {
        if (degree_interval(amount) && currentSpeed == 0) {
            platform_degree = amount;
        }
        is_platform_raised();
    }

    private void is_platform_raised() {
        platform_down = (platform_degree > 0) ? false : true;

    }

    private boolean degree_interval(int amount) {
        int low = 0;
        int high = 70;
        return amount >= low && amount <= high;
    }

    @Override
    public void startEngine() {
        if (platform_down) {
            currentSpeed = 0.1;
        } else {
            System.out.println("You can not start the engine while the platform is raised");
        }
    }

    public int getPlatform_degree() {
        return platform_degree;
    }
}
