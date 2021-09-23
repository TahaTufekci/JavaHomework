   import java.util.Calendar;
   import java.util.GregorianCalendar;

   import static java.util.Calendar.SECOND;

   public class SmartPlug extends SmartObject implements Programmable {
        private boolean status;
        private Calendar programTime;
        private boolean programAction = true;

        public SmartPlug(String alias, String macId) {
            setAlias(alias);
            setMacId(macId);
            programTime = new GregorianCalendar();
        }
        public void turnOn() {
            if (controlConnection()) {
                if (!status) {
                    status = true;
                    Calendar cal = new GregorianCalendar();
                    System.out.println("Smart Plug - " + getAlias() + " is turned on now (Current time: " + cal.get(Calendar.HOUR_OF_DAY) +":" + cal.get(Calendar.MINUTE) + ":" + cal.get(SECOND) +" )" );
                    programAction = false;
                } else {
                    System.out.println("Smart Plug - " + getAlias() + " has been already turned on");
                    programAction = false;
                }
            }
        }
        public void turnOff() {
            if (controlConnection()) {
                if (status) {
                    status = false;
                    Calendar cal = new GregorianCalendar();
                    System.out.println("Smart Plug - " + getAlias() + " is turned off now (Current time: " + cal.get(Calendar.HOUR_OF_DAY) +":" + cal.get(Calendar.MINUTE) + ":" + cal.get(SECOND) +" )" );
                    programAction = true;
                } else {
                    System.out.println("Smart Plug - Kitchen Plug 1 has been already turned off");
                    programAction = true;
                }
            }
        }
        public boolean testObject() {
            if(controlConnection()){
                System.out.println("Test is starting for SmartPlug");
                System.out.print("This is SmartPlug device ");
                super.SmartObjectToString();
                turnOn();
                turnOff();
                System.out.println("Test completed for SmartPlug");
                System.out.println();
                return true;
            }
            else {
                return false;
            }
        }
        public boolean shutDownObject() {
            if (controlConnection()){
                System.out.print("This is SmartCamera device ");
                super.SmartObjectToString();
                if (status) {
                    turnOff();
                    return true;
                }
                return false;
            }

            return false;
        }


        @Override
        public void setTimer(int seconds) {
            if (controlConnection()){
                setProgramTime(programTime);
                Calendar cal = new GregorianCalendar();
                if (!status) {
                    status = true;
                    System.out.print("Smart plug - " + getAlias() + " will be turned on " + seconds + " seconds later!");
                    System.out.println("(Current time: " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(SECOND) + " )");
                    programAction = false;
                }
                else{
                    status = false;
                    System.out.print("Smart plug - " + getAlias() + " will be turned off " + seconds + " seconds later!");
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
                if (programAction) {
                    System.out.println("runProgram -> Smart Plug - " + getAlias());
                    turnOn();
                    programAction = false;
                    programTime = null;

                }
                else{
                    System.out.println("runProgram -> Smart Plug - " + getAlias());
                    turnOff();
                    programAction = true;
                    programTime = null;

                }

            }

        }



        public boolean isStatus() {
            return status;
        }



        public void setStatus(boolean status) {
            this.status = status;
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
