import java.util.ArrayList;
import java.util.List;

public class CarRepairShop{
    private CarStorage storage;
    private int x = 10;
    private int y = 10;

    public CarRepairShop(){
        this.storage = new CarStorage(5);
    }

    public void load_car(Vehicle car) {
        storage.load_car(car, x, y);
    }

    public void unload_car(Vehicle car) {
        storage.unload_car(car, x, y);
    }

    public List<Vehicle> getLoaded_cars() {
        return storage.getLoaded_cars();
    }

}
