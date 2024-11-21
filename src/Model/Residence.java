package Model;



public class Residence {
    private int id;
    private String cep;
    private String country;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String number;
    private String additional;
    private double energyFee;
    
    public Residence(int id, String cep, String country, String state, String city, String neighborhood, String street, String number, String additional, double energyFee) {
        this.id = id;
        this.cep = cep;
        this.country = country;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.additional = additional;
        this.energyFee = energyFee;
    }

    public int getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getAdditional() {
        return additional;
    }

    public double getEnergyFee() {
        return energyFee;
    }
    
    
}
