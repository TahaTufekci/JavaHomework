

public class SmartCamera extends SmartObject implements MotionControl,Comparable<SmartCamera>{
    private boolean status;
    private int batteryLife;
    private boolean nightVision;

    public SmartCamera(String alias, String macId,boolean nightVision, int batteryLife) {
        this.batteryLife = batteryLife;
        this.nightVision = nightVision;
        setAlias(alias);
        setMacId(macId);
    }

    public void recordOn(boolean isDay){
        if (controlConnection()){
            if (isDay){
                    if (!status){
                        System.out.println("Smart Camera - " + getAlias() +" is turned on now");
                        status = true;
                    }
                    else{
                        System.out.println("Smart Camera - " + getAlias() + " has been already turned on");
                    }

                }
            else{
                if (!nightVision){
                    System.out.println("Sorry! Smart Camera - " + getAlias() + " does not have night vision feature.");
                }
                else {
                    if (!status){
                        System.out.println("Smart Camera - " + getAlias() +" is turned on now");
                        status = true;
                    }
                    else{
                        System.out.println("Smart Camera - " + getAlias() + " has been already turned on");
                    }

                }
            }

            }
        }
    public void recordOff(){
        if (controlConnection()){
            if (!status){
                System.out.println("Smart Camera - " + getAlias() + " has been already turned off");

            }
            else{
                System.out.println("Smart Camera - " + getAlias() +" is turned off now");
                status = false;
            }

        }
    }
    @Override
    public boolean testObject() {
        if (controlConnection()){
            System.out.println("Test is starting for SmartCamera");
            System.out.print("This is SmartCamera device ");
            super.SmartObjectToString();
            System.out.println("Test is starting for SmartCamera day time");
            recordOn(true);
                recordOff();
            System.out.println("Test is starting for SmartCamera night time");
            recordOn(false);
            recordOff();
            System.out.println("Test completed for SmartCamera");
            System.out.println();
                return true;

        }

        return false;
    }

    @Override
    public boolean shutDownObject() {
        if (controlConnection()){
            System.out.print("This is SmartCamera device ");
            super.SmartObjectToString();
            if (status) {
                recordOff();
                return true;
            }
            return false;
        }

        return false;
    }


    @Override
    public void controlMotion(boolean hasMotion, boolean isDay) {
        if (hasMotion){
            System.out.println("Motion detected!");
            if (isDay){
                recordOn(isDay);
                status = true;
            }
            else{
                if (nightVision){
                    recordOn(isDay);
                    status = true;
                }
                else{
                    recordOff();
                    status = false;
                }
            }
        }
        else{
            System.out.println("Motion not detected!");
        }

    }
    @Override
    public int compareTo(SmartCamera o) {
        if (batteryLife > o.batteryLife){
            return 1;
        }
        else if (batteryLife == o.batteryLife){
            return 0;
        }
        else{
            return -1;
        }
    }
    @Override
    public String toString() {
        return "SmartCamera -> " + getAlias() + "'s battery life is "+  this.batteryLife +
                " status is recording" ;

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public boolean isNightVision() {
        return nightVision;
    }

    public void setNightVision(boolean nightVision) {
        this.nightVision = nightVision;
    }
}
