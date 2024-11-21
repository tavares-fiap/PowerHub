
package Model;



public class Device {
    private int id;
    private String deviceName;
    private double powerInWatts;
    private boolean status;

    public Device(int id, String deviceName, double powerInWatts, boolean status) {
        this.id = id;
        this.deviceName = deviceName;
        this.powerInWatts = powerInWatts;
        this.status = status;
    }
    
    public String getDeviceName() {
        return deviceName;
    }

    public double getPowerInWatts() {
        return powerInWatts;
    }

    public boolean getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
    
    
    
    
    
}
