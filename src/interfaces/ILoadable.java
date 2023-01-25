package interfaces;

import vehicletypes.Vehicle;

public interface ILoadable{
    public void load_car(Vehicle car, double x, double y);
    public void unload_car(Vehicle car, double x, double y);
}