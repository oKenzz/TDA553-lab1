package platform;

import interfaces.IPlatform;

public class PlatformWithStates implements IPlatform{

    private boolean is_platform_On;

    public PlatformWithStates(){
        this.is_platform_On = false;
    }

    public void set_platform(int state){
        if(state == 1){
            is_platform_On = true;
        } else {
            is_platform_On = false;
        }
    }
    
    public boolean getIs_platform_On() {
        return is_platform_On;
    }

    
}
