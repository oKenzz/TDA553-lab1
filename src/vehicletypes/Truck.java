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
        if (getCurrentSpeed() != 0) throw new IllegalStateException("Engine is already on"); 
        if (getIs_platform_On()) throw new IllegalStateException("You can not start the engine while the platform is ON");
        setCurrentSpeed(0.1);
    }

    public abstract boolean getIs_platform_On();
}
