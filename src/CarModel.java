import java.util.List;
import java.util.ArrayList;

public class CarModel {
    private List<Vehicle> cars = new ArrayList<>();

    public CarModel() {
        Volvo240 volvo = new Volvo240();
        Saab95 saab = new Saab95();
        Scania scania = new Scania();

        cars.add(volvo);
        cars.add(saab);
        cars.add(scania);

        // TODO Create VehicleFactory
    }
    
    public List<Vehicle> getCars() {
        return cars;
    }

    // TODO Methods that alters data (i.e gas, move)

    // Calls the gas method for each car once
    // void gas(int amount) {
    //     double gas = ((double) amount) / 100;
    //     for (Vehicle car : cars) {
    //         car.gas(gas);
    //     }
    // }

    
}
