import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static java.util.Calendar.SECOND;

public class SmartLight extends SmartObject implements LocationControl,Programmable {
    private boolean hasLightTurned;
    private Calendar programTime;
    private boolean programAction = true;

    public SmartLight(String alias, String macId) {
        setAlias(alias);
        setMacId(macId);
         programTime = new GregorianCalendar();

    }
    public void turnOnLight(){
        if(controlConnection()){
            if(!hasLightTurned){
                hasLightTurned = true;
                Calendar cal = new GregorianCalendar();
                System.out.println("Smart Light - " + getAlias() + " is turned on now (Current time: " + cal.get(Calendar.HOUR_OF_DAY) +":" + cal.get(Calendar.MINUTE) + ":" + cal.get(SECOND) +" )" );
                programAction = false;

            }
            else{
                System.out.println("Smart Light - " + getAlias() + " has been already turned on" );
                programAction = false;
        }
        }

    }
    public void turnOffLight(){
        if(controlConnection()){
            if(hasLightTurned){
                hasLightTurned = false;
                Calendar cal = new GregorianCalendar();
                System.out.println("Smart Light - " + getAlias() + " is turned off now (Current time: " + cal.get(Calendar.HOUR_OF_DAY) +":" + cal.get(Calendar.MINUTE) + ":" + cal.get(SECOND) +  " )" );
                programAction = true;
            }
            else{
                System.out.println("Smart Light - " + getAlias() + " has been already turned off" );
                programAction = true;
            }
        }

    }
    @Override
    public boolean testObject() {
        if(controlConnection()){
            System.out.println("Test is starting for SmartLight");
            System.out.print("This is SmartLight device ");
             super.SmartObjectToString();
             turnOnLight();
             turnOffLight();
            System.out.println("Test completed for Smart Light");
            System.out.println();
            return true;
          }
        else {
            return false;
        }
    }
    @Override
    public boolean shutDownObject() {
        if (controlConnection()){
            System.out.print("This is SmartLight device ");
            super.SmartObjectToString();
            if (hasLightTurned) {
                turnOffLight();
                return true;
            }
            return false;
        }

        return false;
    }
    @Override
    public void onLeave() {
        if (controlConnection()){
            System.out.println("On Leave -> Smart Light - " + getAlias());
            turnOffLight();
        }
    }

    @Override
    public void onCome() {
        if (controlConnection()){
        System.out.println("On Come -> Smart Light - " + getAlias());
            turnOnLight();
        }

    }

    @Override
    public void setTimer(int seconds) {
        if (controlConnection()){
            setProgramTime(programTime);
            Calendar cal = new GregorianCalendar();
            if (!hasLightTurned) {
                hasLightTurned = true;
                System.out.print("Smart light - " + getAlias() + " will be turned on " + seconds + " seconds later!");
                System.out.println("(Current time: " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(SECOND) + " )");
                programAction = false;
            }
            else{
                hasLightTurned = false;
                System.out.print("Smart light - " + getAlias() + " will be turned off " + seconds + " seconds later!");
            System.out.println("(Current time: " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(SECOND) + " )");
                programAction = true;
        }

        }

    }

    @Override
    public void cancelTimer() {
        if (controlConnection()){
            programTime = null;
        }

    }

    @Override
    public void runProgram() {
        if(controlConnection()) {
            if (programTime == Calendar.getInstance()) {
                if (programAction) {
                    System.out.println("runProgram -> Smart Light - " + getAlias());
                    turnOnLight();
                    programAction = false;
                    programTime = null;

                } else {
                    System.out.println("runProgram -> Smart Light - " + getAlias());
                    turnOffLight();
                    programAction = true;
                    programTime = null;
                }

            }
        }
    }



    public boolean isHasLightTurned() {
        return hasLightTurned;
    }

    public void setHasLightTurned(boolean hasLightTurned) {
        this.hasLightTurned = hasLightTurned;
    }

    public Calendar getProgramTime() {
        return programTime;
    }

    public void setProgramTime(Calendar programTime) {
        this.programTime = programTime;
    }

    public boolean isProgramAction() {
        return programAction;
    }

    public void setProgramAction(boolean programAction) {
        this.programAction = programAction;
    }
}
