
package Model;

import java.time.LocalDateTime;

public class Measurement {
    private int id;
    private Device device;
    private LocalDateTime started;
    private LocalDateTime ended;
    private double consumptionInWatts;

    public Measurement(Device device, LocalDateTime started) {
        this.device = device;
        this.started = started;
    }
    
    
}