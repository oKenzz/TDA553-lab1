
public abstract class Truck extends Vehicle {

    protected int maximum_angle;
    protected int platform_angle;
    protected boolean is_platform_On;

    public void set_platform(int degree) {

        if (platform_angle == maximum_angle && platform_angle == degree) {
            System.out.println("The platform is already Up");
            return;
        }
        if (platform_angle == 0 && platform_angle == degree) {
            System.out.println("The platform is already Down");
            return;
        }
        if (currentSpeed != 0) {
            System.out
                    .println(
                            "You can not rasie or lower the platform while the truck is in motion or while the enginge is on");
            return;
        }
        if (degree <= maximum_angle && degree >= 0){
            platform_angle = degree;
            if (degree == 0){
                is_platform_On = false;
            }
            else {
                is_platform_On = true;
            }
        }
        else{
            System.out.println("You can not set the platform angle to this degree");
        }
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void startEngine() {
        if (is_platform_On) {
            currentSpeed = 0.1;
        } else {
            System.out.println("You can not start the engine while the platform is ON");
        }
    }

}
