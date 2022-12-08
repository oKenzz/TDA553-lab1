import java.awt.*;

public abstract class Car implements Movable {

    // private boolean turboOn;
    private int nrDoors; // Number of doors on the car
    private Color color; // Color of the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private String modelName; // The car model name
    private double x; // The car x coordinate
    private double y; // The car x coordinate
    private int dx; // Direction in x-axis
    private int dy; // Direction in y-axis
    private double speed = 0; // Used to check SpeedLimit


    // Volvo + Saab
    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.x = 0;
        this.y = 0;
        this.dx = 0;
        this.dy = 1;
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
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

    // Movable
    public void move() {
        setX(getX() + getDx()*currentSpeed);
        setY(getY() + getDy()*currentSpeed);
        moveMsg();
    }

    private void moveMsg(){
        System.out.println("The cars location is now;");
        System.out.println("x: " + getX());
        System.out.println("y: " + getY());

    }

    public void turnLeft() {
        if (this.dx == 0 && this.dy == 1){
            setDx(-1);
            setDy(0);
            leftMsg();
        } else if (this.dx == -1 && this.dy == 0){
            setDx(0);
            setDy(-1);
            downMsg();
        } else if (this.dx == 0 && this.dy == -1){
            setDx(1);
            setDy(0);
            rightMsg();
        } else if (this.dx == 1 && this.dy == 0){
            setDx(0);
            setDy(1);
            upMsg();
        } 
    }

    public void turnRight() {
        if (this.dx == 0 && this.dy == 1){
            setDx(1);
            setDy(0);
            rightMsg();
        } else if (this.dx == 1 && this.dy == 0){
            setDx(0);
            setDy(-1);
            downMsg();
        } else if (this.dx == 0 && this.dy == -1){
            setDx(-1);
            setDy(0);
            leftMsg();
        } else if (this.dx == -1 && this.dy == 0){
            setDx(0);
            setDy(1);
            upMsg();
        } 
    }

    private void upMsg(){
        System.out.println("Direction is now up");
    }
    private void leftMsg(){
        System.out.println("Direction is now left");
    }
    private void rightMsg(){
        System.out.println("Direction is now right");
    }
    private void downMsg(){
        System.out.println("Direction is now down");
    }

    public abstract double speedFactor();

    private void incrementSpeed(double amount){
        speed += speedFactor() * amount;
        if (SpeedLimit(speed)){
        currentSpeed = speed;
        }
        // currentSpeed += speedFactor() * amount;
    }

    private void decrementSpeed(double amount){
        speed -= speedFactor() * amount;
        if (SpeedLimit(speed)){ // currentSpeed always lies between interval [0, enginePower]
        currentSpeed = speed;
        }
        // currentSpeed -= speedFactor() * amount;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (interval(amount)){ // gas accepts value in the interval [0,1]
        incrementSpeed(amount);
        }
    }

    // TODO fix this method according to lab pm
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