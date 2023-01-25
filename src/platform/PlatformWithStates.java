package platform;

public class PlatformWithStates{

    private boolean is_platform_On;

    public PlatformWithStates(){
        this.is_platform_On = false;
    }

    public void set_platform(){
        is_platform_On = is_platform_On ? false : true;
    }
    
    public boolean getIs_platform_On() {
        return is_platform_On;
    }

    
}
