package interfaces;


// Implement to guarantee that subclasses of Truck have getIs_platform_On because all truck have getIs_platform_On
public interface IPlatform {
    public void set_platform(int value);
    public boolean getIs_platform_On(); 
}
