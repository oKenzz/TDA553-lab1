import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    private ArrayList<VehicleObject> cars;

    public void setModel(ArrayList<VehicleObject> cars){
        this.cars = cars;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (VehicleObject car : cars){
            g.drawImage(car.getImg(), car.getX(), car.getY(), null);
        }
    }
}
