import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import vehicles.cars.Volvo240;
import vehicletypes.Vehicle;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage Saab95;
    BufferedImage carImage;
    // To keep track of a singel cars position
    Point volvoPoint = new Point(0, 0);
    Point scaniaPoint = new Point(100, 100);
    Point carPoint = new Point();
    Vehicle vehicle = new Volvo240();

    // TODO: Make this genereal for all cars
    void moveit(int x, int y, Vehicle car) {
        carPoint.x = x;
        carPoint.y = y;
        vehicle = car;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to
            // pics.
            // if you are starting in IntelliJ.
            if (vehicle.modelName == "Volvo240"){
                carImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            }  else if (vehicle.modelName == "Scania"){
                carImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(carImage, carPoint.x, carPoint.y, null); // see javadoc for more info on the parameters
    }
}
