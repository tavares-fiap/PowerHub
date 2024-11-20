
package Model;



public class Device {
    private int id;
    private String deviceName;
    private double powerInWatts;
    private boolean status;
    
    public Device(String deviceName, double powerInWatts, boolean status) {
        this.deviceName = deviceName;
        this.powerInWatts = powerInWatts;
        this.status = status;
    }
    
    
}
