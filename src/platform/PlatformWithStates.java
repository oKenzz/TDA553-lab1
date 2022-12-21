public class PlatformWithStates implements IPlatform{

    private boolean is_platform_On;

    public PlatformWithStates(){
        this.is_platform_On = false;
    }

    public void set_platform(int value){
        if(!check_states()) change_platform_state(value);
    }

    private void change_platform_state(int state){
        if(accepts_0_and_1(state)){
            is_platform_On = (state == 1) ? true : false;
        } else {
            invalidValueMsg();
        }
    }

    private boolean check_states(){
        boolean state = false;
        if(is_platform_On){
            state = true;
            platformUpMsg();
        } else {
            state = false;
            platformDownMsg();
        }
        return state;
    }

    private boolean accepts_0_and_1(int value){
        return value == 0 || value == 1;
    }

    private void invalidValueMsg(){
        System.out.println("Must input value 0 or 1");
    }
    
    private void platformUpMsg(){
        System.out.println("The platform is already Up");
    }

    private void platformDownMsg(){
        System.out.println("The platform is already Down");
    }

    public boolean getIs_platform_On() {
        return is_platform_On;
    }


    // REMOVE FROM INTERFACE!!!!!!!!! (FOR TEST ONLY!!!!)
    @Override
    public int getPlatform_angle() {
        // TODO Auto-generated method stub
        return 0;
    }

    
}
