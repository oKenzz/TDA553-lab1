import java.awt.*;

public abstract class Truck extends Vehicle {

    private IPlatform platform; // Gets behaviour from a platform

    public Truck(int nrDoors, Color color, double enginePower, String modelName, IPlatform platform){
        super(nrDoors, color, enginePower, modelName);
        this.platform = platform;
    }

    //TODO : use delegation through getPlatform from Scania and CarTransporter
    public void set_platform(int value){
        if (check_in_motion()){
            in_motionMsg();
        } else {
            platform.set_platform(value);
        }
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void startEngine() {
        if (platform.getIs_platform_On()) {
            System.out.println("You can not start the engine while the platform is ON");
        } else {
            setCurrentSpeed(0.1);
        }
    }

    private boolean check_in_motion(){
        return getCurrentSpeed() != 0;
    }

    private void in_motionMsg(){
        System.out.println("You can not rasie or lower the platform while the truck is in motion or while the enginge is on");
    }
    
    public boolean getPlatform_state(){
        return platform.getIs_platform_On();
    }

    public int getPlatform_angle(){
        return platform.getPlatform_angle();
    }

    public IPlatform getPlatform(){
        return platform;
    }


}
