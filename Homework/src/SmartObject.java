public abstract class SmartObject {
    private String alias;
    private String macId;
    private String IP;
    private boolean connectionStatus;

    public SmartObject(){}

    public boolean connect(String IP){
        setIP(IP);
        this.connectionStatus = true;
        System.out.println(alias + " connection established");
        return true;
    }
    public boolean disconnect(){
        this.connectionStatus = false;
        setIP(IP);
        return true;
    }
    public void SmartObjectToString() {
        System.out.println( getAlias() + "\n      MacId :" + getMacId() + "\n      IP: " + getIP());

    }
    public boolean controlConnection(){
        if(!connectionStatus){
            System.out.println("This device is not connected. SmartCamera -> " + getAlias());
            return false;
        }
        else {
            return true;
        }

    }
    public abstract boolean testObject();
    public abstract boolean shutDownObject();

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
}
