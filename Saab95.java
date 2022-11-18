import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    // public int nrDoors; // Number of doors on the car
    // public double enginePower; // Engine power of the car
    // public double currentSpeed; // The current speed of the car
    // public Color color; // Color of the car
    // public String modelName; // The car model name
    
    public Saab95(int nrDoors, Color color, double enginePower, String modelName, boolean turboON){
        super(nrDoors, color, enginePower, modelName, turboON);
        // nrDoors = 2;
        // color = Color.red;
        // enginePower = 125;
	    // turboOn = false;
        // modelName = "Saab95";
        // stopEngine();
    }
    
    // Inheritance
    // public int getNrDoors(){
    //     return nrDoors;
    // }
    // public double getEnginePower(){
    //     return enginePower;
    // }

    // public double getCurrentSpeed(){
    //     return currentSpeed;
    // }

    // public Color getColor(){
    //     return color;
    // }

    // public void setColor(Color clr){
	//     color = clr;
    // }

    // public void startEngine(){
	//     currentSpeed = 0.1;
    // }

    // public void stopEngine(){
	//     currentSpeed = 0;
    // }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    // Overriding
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        // Varför måste jag ge enginePower ett värde men inte för volvo
        enginePower = this.getEnginePower();
        return enginePower * 0.01 * turbo;
    }

    @Override
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }
    
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
    
    // Movable
    public void move(){
    }

    public void turnLeft(){

    }

    public void turnRight(){
        
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
