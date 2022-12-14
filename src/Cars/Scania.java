import java.awt.*;

public class Scania extends CarTransporter{
    
    private int platform_degree;

    public Scania() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 200;
        platform_down = false;
        platform_degree = 0;
        modelName = "Scania";
        stopEngine();
    }

    @Override
    public double speedFactor() {
        int movable = 0;
        if (platform_down){
            movable = 1;
        }
        return getEnginePower() * 0.01 * movable;
    }

    public void move_platform(int amount){
        if (degree_interval(amount)){
            increment_degree(amount);
        }
        is_platform_raised();
    }

    // Increment degree method
    private void increment_degree(int amount){
        platform_degree += amount;
    }

    private void is_platform_raised(){
        platform_down = (platform_degree > 0) ? false : true;
    }
    

    private boolean degree_interval(int amount){
        int low = 0;
        int high = 70;
        return amount >= low && amount <= high;
    }

    public int getPlatform_degree() {
        return platform_degree;
    }
}
