
package Model;

import java.util.HashMap;
import java.util.Map;


public class Client extends User{
    private Map<Integer, Residence> residences = new HashMap<>();

    public Client(String cpf, String name, String phoneNumber, String emailAddress, String password) {
        super(cpf, name, phoneNumber, emailAddress, password);
    }
    
}
