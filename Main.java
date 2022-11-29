import java.awt.*;

public class Main {
    public static void main(String[] args){
        Volvo240 volvo = new Volvo240(4, Color.black, 100,"Volvo240");
        Saab95 saab = new Saab95(2, Color.red, 125, "Saab95", false);
        //VOLVO
        System.out.println(volvo.getCurrentSpeed());
        volvo.setCurrentSpeed(13);
        System.out.println(volvo.getCurrentSpeed());
        //SAAB
        // saab.setTurboOn();
        // System.out.println(saab.speedFactor());
        // System.out.println(saab.getCurrentSpeed());
        // saab.startEngine();
        // saab.gas(13);
        // System.out.println(saab.getCurrentSpeed());
    }
}
