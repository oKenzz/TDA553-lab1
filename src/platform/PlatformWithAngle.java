package platform;

import interfaces.IPlatform;

public class PlatformWithAngle implements IPlatform{
    private int maximum_angle;
    private int platform_angle;
    private boolean is_platform_On;     


    public PlatformWithAngle(int maximum_angle){
        this.maximum_angle = maximum_angle;
        this.platform_angle = 0;
        this.is_platform_On = false;
    }

    public void set_platform(int degree){
        check_degree(degree);
        change_platform_degree(degree);
    }

    private void change_platform_degree(int degree){
        this.platform_angle = degree;
        this.is_platform_On  = (degree > 0) ? true : false;
    }

    private void check_degree(int degree){
        if(!degree_interval(degree)) throw new IllegalStateException("You can not set the platform angle to this degree");
        if(check_platform_is_up(degree)) throw new IllegalStateException("The platform is already Up");
        if(check_platform_is_down(degree)) throw new IllegalStateException("The platform is already Down");
    }

    private boolean check_platform_is_up(int degree){
        return platform_angle == maximum_angle && degree == maximum_angle;
    }

    private boolean check_platform_is_down(int degree){
        return platform_angle == 0 && degree == 0;
    }


    private boolean degree_interval(int degree){
        return degree <= maximum_angle && degree >= 0;
    }

    public boolean getIs_platform_On() {
        return this.is_platform_On;
    }

    public int getPlatform_angle() {
        return platform_angle;
    }

    
}
