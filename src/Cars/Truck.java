
public abstract class Truck extends Vehicle {

    protected int maximum_angle;
    protected int platform_angle;
    protected boolean is_platform_On;

    public void set_platform(int degree){
        if (check_states(degree)){
            return;
        } else {
            set_degree(degree);
        }
    }


    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void startEngine() {
        if (is_platform_On) {
            System.out.println("You can not start the engine while the platform is ON");
        } else {
            currentSpeed = 0.1;
        }
    }
    
    private boolean check_states(int degree){
        boolean check = false;
        if (check_platform_is_up(degree)){
            check = true;
            platformUpMsg();
        }
        if (check_platform_is_down(degree)){
            check = true;
            platformDownMsg();
        }
        if (check_in_motion()){
            check = true;
            in_motionMsg();
        }
        return check;
    }

    
    private boolean check_platform_is_up(int degree){
        return platform_angle == maximum_angle && platform_angle == degree;
    }

    private boolean check_platform_is_down(int degree){
        return platform_angle == 0 && platform_angle == degree;
    }

    private boolean check_in_motion(){
        return currentSpeed != 0;
    }

    private void set_degree(int degree){
        if (degree_interval(degree)){
            platform_angle = degree;
            is_platform_On = (degree > 0) ? true : false;
        }
        else{
            invalid_degreeMsg();
        }
    }

    private boolean degree_interval(int degree){
        return degree <= maximum_angle && degree >= 0;
    }

    private void platformUpMsg(){
        System.out.println("The platform is already Up");
    }

    private void platformDownMsg(){
        System.out.println("The platform is already Down");
    }

    private void in_motionMsg(){
        System.out.println("You can not rasie or lower the platform while the truck is in motion or while the enginge is on");
    }

    private void invalid_degreeMsg(){
        System.out.println("You can not set the platform angle to this degree");
    }
}
