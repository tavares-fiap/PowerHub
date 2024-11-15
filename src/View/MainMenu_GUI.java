/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


/**
 *
 * @author sapat
 */
public class MainMenu_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Splash_GUI
     */
    public MainMenu_GUI() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        additional_txt = new javax.swing.JTextField();
        number_txt = new javax.swing.JTextField();
        street_txt = new javax.swing.JTextField();
        neighborhood_txt = new javax.swing.JTextField();
        city_txt = new javax.swing.JTextField();
        uf_txt = new javax.swing.JTextField();
        country_txt = new javax.swing.JTextField();
        cep_txt = new javax.swing.JTextField();
        searchCEP_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        addDevice_btn = new javax.swing.JButton();
        residencesNewDevice_cbx = new javax.swing.JComboBox();
        powerInWattsNewDevice_txt = new javax.swing.JTextField();
        deviceNameNewDevice_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        deleteDevice_btn = new javax.swing.JButton();
        updateDeviceInfo_btn = new javax.swing.JButton();
        generateDeviceReport_btn = new javax.swing.JButton();
        searchDevice_btn = new javax.swing.JButton();
        devices_cbx = new javax.swing.JComboBox();
        residencesMyDevices_cbx = new javax.swing.JComboBox();
        status_togglebtn = new javax.swing.JToggleButton();
        powerInWattsMyDevices_txt = new javax.swing.JTextField();
        deviceNameMyDevices_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setLayout(null);

        additional_txt.setText("Complemento");
        jPanel2.add(additional_txt);
        additional_txt.setBounds(220, 370, 140, 30);

        number_txt.setText("Numero");
        jPanel2.add(number_txt);
        number_txt.setBounds(150, 320, 210, 30);

        street_txt.setText("Rua");
        jPanel2.add(street_txt);
        street_txt.setBounds(100, 270, 260, 30);

        neighborhood_txt.setText("Bairro");
        jPanel2.add(neighborhood_txt);
        neighborhood_txt.setBounds(140, 220, 220, 30);

        city_txt.setText("Cidade");
        jPanel2.add(city_txt);
        city_txt.setBounds(140, 170, 220, 30);

        uf_txt.setText("Estado");
        jPanel2.add(uf_txt);
        uf_txt.setBounds(100, 120, 260, 30);

        country_txt.setText("Pais");
        jPanel2.add(country_txt);
        country_txt.setBounds(100, 70, 260, 30);

        cep_txt.setText("CEP da residencia");
        jPanel2.add(cep_txt);
        cep_txt.setBounds(100, 20, 160, 30);

        searchCEP_btn.setText("BUSCAR");
        jPanel2.add(searchCEP_btn);
        searchCEP_btn.setBounds(270, 20, 90, 30);

        save_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        save_btn.setText("SALVAR RESIDENCIA");
        jPanel2.add(save_btn);
        save_btn.setBounds(50, 410, 290, 30);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PowerHub_AddResidence.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(-10, 0, 410, 690);

        jTabbedPane1.addTab("New Residence", jPanel2);

        jPanel1.setLayout(null);

        addDevice_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addDevice_btn.setText("ADICIONAR");
        jPanel1.add(addDevice_btn);
        addDevice_btn.setBounds(30, 280, 330, 30);

        residencesNewDevice_cbx.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(residencesNewDevice_cbx);
        residencesNewDevice_cbx.setBounds(30, 120, 330, 30);

        powerInWattsNewDevice_txt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        powerInWattsNewDevice_txt.setText("Potencia do dispositivo em Watts");
        jPanel1.add(powerInWattsNewDevice_txt);
        powerInWattsNewDevice_txt.setBounds(30, 240, 330, 30);

        deviceNameNewDevice_txt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deviceNameNewDevice_txt.setText("Nome do Dispositivo");
        jPanel1.add(deviceNameNewDevice_txt);
        deviceNameNewDevice_txt.setBounds(30, 180, 330, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PowerHub_AddDevice.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(-10, 0, 410, 690);

        jTabbedPane1.addTab("New Device", jPanel1);

        jPanel3.setLayout(null);

        deleteDevice_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteDevice_btn.setForeground(new java.awt.Color(255, 0, 0));
        deleteDevice_btn.setText("EXCLUIR DISPOSITIVO");
        jPanel3.add(deleteDevice_btn);
        deleteDevice_btn.setBounds(30, 535, 320, 20);

        updateDeviceInfo_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updateDeviceInfo_btn.setForeground(new java.awt.Color(255, 51, 0));
        updateDeviceInfo_btn.setText("ALTERAR INFORMACOES");
        jPanel3.add(updateDeviceInfo_btn);
        updateDeviceInfo_btn.setBounds(30, 510, 320, 20);

        generateDeviceReport_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        generateDeviceReport_btn.setText("GERAR RELATORIO");
        jPanel3.add(generateDeviceReport_btn);
        generateDeviceReport_btn.setBounds(30, 473, 320, 30);

        searchDevice_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchDevice_btn.setText("BUSCAR");
        jPanel3.add(searchDevice_btn);
        searchDevice_btn.setBounds(30, 210, 330, 30);

        devices_cbx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(devices_cbx);
        devices_cbx.setBounds(30, 160, 330, 40);

        residencesMyDevices_cbx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(residencesMyDevices_cbx);
        residencesMyDevices_cbx.setBounds(30, 80, 330, 40);

        status_togglebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        status_togglebtn.setText("OFF");
        jPanel3.add(status_togglebtn);
        status_togglebtn.setBounds(30, 380, 53, 23);

        powerInWattsMyDevices_txt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        powerInWattsMyDevices_txt.setText("Potencia em Watts");
        jPanel3.add(powerInWattsMyDevices_txt);
        powerInWattsMyDevices_txt.setBounds(30, 430, 320, 30);

        deviceNameMyDevices_txt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deviceNameMyDevices_txt.setText("Nome do dispositivo");
        jPanel3.add(deviceNameMyDevices_txt);
        deviceNameMyDevices_txt.setBounds(30, 320, 320, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PowerHub_MyDevices.png"))); // NOI18N
        jPanel3.add(jLabel3);
        jLabel3.setBounds(-10, -40, 410, 730);

        jTabbedPane1.addTab("My Devices", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setSize(new java.awt.Dimension(396, 704));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDevice_btn;
    public static javax.swing.JTextField additional_txt;
    public static javax.swing.JTextField cep_txt;
    public static javax.swing.JTextField city_txt;
    public static javax.swing.JTextField country_txt;
    private javax.swing.JButton deleteDevice_btn;
    public static javax.swing.JTextField deviceNameMyDevices_txt;
    public static javax.swing.JTextField deviceNameNewDevice_txt;
    public static javax.swing.JComboBox devices_cbx;
    private javax.swing.JButton generateDeviceReport_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextField neighborhood_txt;
    public static javax.swing.JTextField number_txt;
    public static javax.swing.JTextField powerInWattsMyDevices_txt;
    public static javax.swing.JTextField powerInWattsNewDevice_txt;
    public static javax.swing.JComboBox residencesMyDevices_cbx;
    public static javax.swing.JComboBox residencesNewDevice_cbx;
    private javax.swing.JButton save_btn;
    private javax.swing.JButton searchCEP_btn;
    private javax.swing.JButton searchDevice_btn;
    public static javax.swing.JToggleButton status_togglebtn;
    public static javax.swing.JTextField street_txt;
    public static javax.swing.JTextField uf_txt;
    private javax.swing.JButton updateDeviceInfo_btn;
    // End of variables declaration//GEN-END:variables
}
