package Model;

import java.util.ArrayList;
import java.util.List;


public class Residence {
    private int id;
    private String cep;
    private String country;
    private String state;
    private String neighborhood;
    private String street;
    private String number;
    private String additional;
    private String energyFee;
    private List<Device> devices = new ArrayList<>();
    
    public Residence(String cep, String country, String state, String neighborhood, String street, String number, String additional, String energyFee) {
        this.cep = cep;
        this.country = country;
        this.state = state;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.additional = additional;
        this.energyFee = energyFee;
    }
    
    
}
