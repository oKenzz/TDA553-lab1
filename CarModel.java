import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import vehicles.cars.*;
import vehicles.trucks.Scania;
import vehicletypes.Vehicle;


//Has data that other modules manipulate
//This means that other modules have a Model
public class CarModel {
    
    private static ArrayList<VehicleObject> cars = new ArrayList<>(); // Okay to make static????

    public CarModel(){

        VehicleObject volvo240 = new VehicleObject(new Volvo240());
        VehicleObject saab95 = new VehicleObject(new Saab95(), new Point(0,100));
        VehicleObject scania = new VehicleObject(new Scania(), new Point(0,200));

        cars.add(volvo240);
        cars.add(saab95);
        cars.add(scania);

    }

    public ArrayList<VehicleObject> getCars() {
        return cars;
    }    

    


}
