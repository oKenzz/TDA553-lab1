import java.awt.*;

public class Main {
    public static void main(String[] args){
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        //VOLVO
        System.out.println(volvo.getDirection());
        System.out.println(volvo.getEnginePower());
        volvo.gas(1);
        volvo.turnRight();
        volvo.turnRight();
        volvo.move();
        volvo.turnRight();
        volvo.turnRight();
        volvo.move();
        volvo.turnRight();
        volvo.move();
        volvo.turnRight();
        volvo.move();
        //SAAB
        System.out.println(saab.getEnginePower());
        
        System.out.println(2 % 4);
    }
}
