
package Model;

import java.util.ArrayList;
import java.util.List;


public class Device {
    private int id;
    private String deviceName;
    private double powerInWatts;
    private boolean status;
    
    private List<Measurement> usageMeasurement = new ArrayList<>();
    
    public Device(String deviceName, double powerInWatts, boolean status) {
        this.deviceName = deviceName;
        this.powerInWatts = powerInWatts;
        this.status = status;
    }
    
    
}
