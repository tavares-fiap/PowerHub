package Model;


public class User {
    private String cpf;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String password;

    public User(String cpf, String name, String phoneNumber, String emailAddress, String password) {
        this.cpf = cpf;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.password = password;
    }
    
    
}
