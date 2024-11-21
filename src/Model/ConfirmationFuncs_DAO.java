
package Model;

import javax.swing.JOptionPane;

public class ConfirmationFuncs_DAO {
    
    public static boolean deleteConfirmation() {
        String response = JOptionPane.showInputDialog(null, "Você tem certeza de que deseja excluir? Essa ação é irreversível!\n1 - Sim\n2 - Cancelar");
        try {
            if (Integer.parseInt(response) == 1) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada.");
            return false;
        }
        JOptionPane.showMessageDialog(null, "Exclusão cancelada.");
        return false;
    }
}
