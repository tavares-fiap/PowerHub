
package Model;

import java.util.ArrayList;
import java.util.List;


public class Device {
    private int id;
    private String deviceName;
    private double powerInWatts;
    private boolean status;
    
    private List<Measurement> usageMeasurement = new ArrayList<>();
    
    public Device(int id, String deviceName, double powerInWatts, boolean status) {
        this.id = id;
        this.deviceName = deviceName;
        this.powerInWatts = powerInWatts;
        this.status = status;
    }
    
    
}
