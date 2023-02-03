package vehicletypes;

import java.awt.*;

public abstract class Truck extends Vehicle {

    public Truck(int nrDoors, Color color, double enginePower, String modelName){
        super(nrDoors, color, enginePower, modelName);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }  
    
    @Override
    public void startEngine(){
        if (!check_movable()) throw new IllegalStateException("You can not start the engine while the platform is ON");
        if (getCurrentSpeed() > 0.1) throw new IllegalStateException("Engine is already on");
        setCurrentSpeed(0.1);
    }

    private boolean check_movable(){
        if (getIs_platform_On()){
            setMovable(false);
        } else {
            setMovable(true);
        }
        return isMovable();
    }

    public abstract boolean getIs_platform_On();
}
