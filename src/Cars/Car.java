import java.awt.*;
import java.util.HashMap;

public abstract class Car implements Movable {
    // HashMap for directions
    private final static int[] UP = {0,1}; // Represents Directions up,right,down,left
    private final static int[] RIGHT = {1,0};
    private final static int[] DOWN = {0,-1};
    private final static int[] LEFT = {-1,0};
    private final static HashMap<String,int[]> DIRECTIONS = createDirections(); // HashMap of directions

    // Car attributes
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // The enginePower of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // The color of the car
    protected String modelName; // The car model name
    private double x = 0; // The car x coordinate
    private double y = 0; // The car y coordinate
    private int dx = 0; // Direction in x-axis
    private int dy = 1; // Direction in y-axis
    private String direction = "UP"; // The direction of the car (Default: up)
    private double speed = 0; // Used to check SpeedLimit


    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getX() {
        return x;
    }

    private void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    private void setY(double y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    private void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    private void setDy(int dy) {
        this.dy = dy;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public String getDirection(){
        return direction;
    }

    private void setDirection(String d){
        int[] directionValues = DIRECTIONS.get(d);
        direction = d;
        setDx(directionValues[0]);
        setDy(directionValues[1]);
    }

    private static HashMap<String,int[]> createDirections(){
        HashMap<String,int[]> directions = new HashMap<String, int[]>();
        directions.put("UP", UP);
        directions.put("RIGHT", RIGHT);
        directions.put("DOWN", DOWN);
        directions.put("LEFT", LEFT);
        return directions;
    }

    public void turnRight(){
        switch(getDirection()){
            case "UP": 
                setDirection("RIGHT");
                directionMsg(direction);
                break;
            case "RIGHT": 
                setDirection("DOWN");
                directionMsg(direction);
                break;
            case "DOWN": 
                setDirection("LEFT");
                directionMsg(direction);
                break;
            case "LEFT": 
                setDirection("UP");
                directionMsg(direction);
                break;
        }
    }

    public void turnLeft(){
        switch(getDirection()){
            case "UP": 
                setDirection("LEFT");
                directionMsg(direction);
                break;
            case "LEFT": 
                setDirection("DOWN");
                directionMsg(direction);
                break;
            case "DOWN": 
                setDirection("RIGHT");
                directionMsg(direction);
                break;
            case "RIGHT": 
                setDirection("UP");
                directionMsg(direction);
                break;
        }
    }
    
    // Movable
    public void move() {
        setX(getX() + getDx()*currentSpeed);
        setY(getY() + getDy()*currentSpeed);
        moveMsg();
    }

    private void directionMsg(String direction){
        System.out.println("Direction is now " + direction.toLowerCase());
    }

    private void moveMsg(){
        System.out.println("The cars location is now;");
        System.out.println("x: " + getX());
        System.out.println("y: " + getY());
    }

    public abstract double speedFactor();

    private void incrementSpeed(double amount){
        speed += speedFactor() * amount;
        if (SpeedLimit(speed)){
        currentSpeed = speed;
        }
    }

    private void decrementSpeed(double amount){
        speed -= speedFactor() * amount;
        if (SpeedLimit(speed)){ // currentSpeed always lies between interval [0, enginePower]
        currentSpeed = speed;
        }
    }

    public void gas(double amount){
        if (interval(amount)){ // gas accepts value in the interval [0,1]
        incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (interval(amount)){  // brake accepts value in the interval [0,1]
        decrementSpeed(amount);
        }
    }

    private boolean interval(double number){
        double high = 1;
        double low = 0;
        return number >= low && number <= high;
    }

    private boolean SpeedLimit(double speed){
        return speed >= 0 && speed <= enginePower;
    }



}