import java.awt.*;

public class Main {
    public static void main(String[] args){
        Volvo240 volvo = new Volvo240(4, Color.black, 100,"Volvo240");
        Saab95 saab = new Saab95(2, Color.red, 125, "Saab95", false);
        System.out.println(saab.speedFactor());
        saab.setTurboOn();
        System.out.println(saab.speedFactor());
        volvo.setColor(Color.black);
        System.out.println(volvo.getColor());
        System.out.println(saab.getColor());
        System.out.println(saab.getCurrentSpeed());
        System.out.println(volvo.getEnginePower());

    }
}
