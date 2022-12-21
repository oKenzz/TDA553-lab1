public class PlatformWithAngle implements IPlatform{
    private int maximum_angle;
    private int platform_angle;
    private boolean is_platform_On;     


    public PlatformWithAngle(int maximum_angle){
        this.maximum_angle = maximum_angle;
        this.platform_angle = 0;
        this.is_platform_On = false;
    }

    public void set_platform(int value){
    //    change_platform_degree(value);
        if(!check_degree(value)) change_platform_degree(value);
    }

    private void change_platform_degree(int degree){
        if (degree_interval(degree)){
            this.platform_angle = degree;
            this.is_platform_On  = (degree > 0) ? true : false;
        }
        else{
            invalid_degreeMsg();
        }
    }

    private boolean check_degree(int degree){
        boolean check = false;
        if(check_platform_is_up(degree)){
            check = true;
            platformUpMsg();
        }
        if(check_platform_is_down(degree)){
            check = true;
            platformDownMsg();
        }
        return check;
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

    private void invalid_degreeMsg(){
        System.out.println("You can not set the platform angle to this degree");
    }
    
    protected void platformUpMsg(){
        System.out.println("The platform is already Up");
    }

    protected void platformDownMsg(){
        System.out.println("The platform is already Down");
    }

    public boolean getIs_platform_On() {
        return this.is_platform_On;
    }

    public int getPlatform_angle() {
        return platform_angle;
    }

    
}
