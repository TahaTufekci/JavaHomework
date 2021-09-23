import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.sort;


public class SmartHome {
    private ArrayList<SmartObject> smartObjectList;

    public SmartHome(){
        smartObjectList = new ArrayList<SmartObject>();
    }
    public boolean addSmartObject(SmartObject smartObject){
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Adding new SmartObject");
        System.out.println("---------------------------------------------------------------------------");
        smartObjectList.add(smartObject);
        smartObject.connect("10.0.0.10" + String.valueOf(smartObjectList.indexOf(smartObject)));
        smartObject.testObject();
        return true;
    }

    public boolean removeSmartObject(SmartObject smartObject){
        smartObjectList.remove(smartObject);
        return true;
    }
    public void controlLocation(boolean onCome){
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("LocationControl : OnCome");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < smartObjectList.size(); i++){
            if(smartObjectList.get(i) instanceof SmartLight ){
                if(onCome){
                    ((SmartLight) smartObjectList.get(i)).onCome();
                }
                else{
                    ((SmartLight) smartObjectList.get(i)).onLeave();
                }
            }
        }
    }
    public void controlMotion(boolean hasMotion, boolean isDay){
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("MotionControl : HasMotion, isDay");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < smartObjectList.size(); i++){
            if(smartObjectList.get(i) instanceof SmartCamera ){
                    ((SmartCamera) smartObjectList.get(i)).controlMotion(hasMotion,isDay);
            }
        }
    }
    public void controlProgrammable(){
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Programmable : runProgram");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < smartObjectList.size(); i++){
            if(smartObjectList.get(i) instanceof SmartLight ) {
                ((SmartLight) smartObjectList.get(i)).runProgram();
            }
             if(smartObjectList.get(i) instanceof SmartPlug)  {
                    ((SmartPlug) smartObjectList.get(i)).runProgram();
                }

        }
    }
    public void controlTimer(int seconds){
        for (int i = 0; i < smartObjectList.size(); i++){
            if(smartObjectList.get(i) instanceof SmartLight ) {
                if (seconds > 0)
                ((SmartLight) smartObjectList.get(i)).setTimer(seconds);
                else if(seconds == 0){
                    ((SmartLight) smartObjectList.get(i)).cancelTimer();

                }
            }
            if(smartObjectList.get(i) instanceof SmartPlug)  {
                if (seconds > 0)
                    ((SmartPlug) smartObjectList.get(i)).setTimer(seconds);
                else if(seconds == 0){
                    ((SmartPlug) smartObjectList.get(i)).cancelTimer();

                }
            }

        }
    }
    public void controlTimerRandomly(){
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Programmable : Timer = 5 or 10 seconds randomly");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < smartObjectList.size(); i++){
            if(smartObjectList.get(i) instanceof SmartLight ) {
                while (true) {
                    int second = (int) (Math.random() * 11);
                    if (second == 5) {
                        ((SmartLight) smartObjectList.get(i)).setTimer(5);
                        break;
                    }
                    else if (second == 10) {
                        ((SmartLight) smartObjectList.get(i)).setTimer(10);
                        break;
                    }
                    else if (second == 0) {
                        ((SmartLight) smartObjectList.get(i)).cancelTimer();
                        break;
                    }
                }
            }
            if(smartObjectList.get(i) instanceof SmartPlug) {
                while (true) {
                    int second = (int) (Math.random() * 11);
                    if (second == 5){
                        ((SmartPlug) smartObjectList.get(i)).setTimer(5);
                         break;
                    }
                    else if (second == 10) {
                        ((SmartPlug) smartObjectList.get(i)).setTimer(10);
                        break;
                    }
                       else if (second == 0) {
                        ((SmartPlug) smartObjectList.get(i)).cancelTimer();
                            break;
                    }
                }
            }

        }
    }
    public void sortCameras(){
        SmartCamera[] smartCameras = new SmartCamera[3]; // for sorting cameras
        ArrayList<SmartCamera> scam = new ArrayList<>();
        for (int i = 0; i < smartObjectList.size(); i++) {
            if (smartObjectList.get(i) instanceof SmartCamera) {
               scam.add((SmartCamera) smartObjectList.get(i));
            }
        }scam.toArray();
        Arrays.sort(new ArrayList[]{scam});


        for (int j = 0 ; j < smartCameras.length-1; j++){
            System.out.println(scam.get(j).toString());
        }

    }




    public ArrayList<SmartObject> getSmartObjectList() {
        return smartObjectList;
    }

    public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
        this.smartObjectList = smartObjectList;
    }
}
