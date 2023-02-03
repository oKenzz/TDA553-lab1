import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.IOException;

import vehicletypes.Vehicle;
import java.awt.Point;

public class VehicleObject {
    
    private Vehicle vehicle;
    private BufferedImage img;
    private Point position;

    public VehicleObject(Vehicle car){
        this.vehicle = car;
        this.position = new Point();
        try{
            this.img = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+car.getModelName()+".jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }    
    }

    public VehicleObject(Vehicle car, Point position){
        this.vehicle = car;
        this.position = position;
        car.set_position(position.x, position.y);
        try{
            this.img = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+car.getModelName()+".jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }    
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public BufferedImage getImg() {
        return img;
    }

    public Point getPosition() {
        return position;
    }

    public int getX(){
        return position.x;
    }

    public int getY(){
        return position.y;
    }

    

    public void setPosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;
    }

    public void setX(int x) {
        this.position.x = x;
    }

    public void setY(int y) {
        this.position.y = y;
    }

    

}
