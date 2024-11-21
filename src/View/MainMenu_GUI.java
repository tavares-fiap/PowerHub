/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Device;
import Model.Residence;
import javax.swing.JOptionPane;

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
        Model.FieldFuncs_DAO.refreshResidenceCombobox();
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
        energyFee_txt = new javax.swing.JTextField();
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
        exit_btn1 = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        addDevice_btn = new javax.swing.JButton();
        residencesNewDevice_cbx = new javax.swing.JComboBox();
        powerInWattsNewDevice_txt = new javax.swing.JTextField();
        deviceNameNewDevice_txt = new javax.swing.JTextField();
        logout_btn1 = new javax.swing.JButton();
        exit_btn2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        deleteDevice_btn = new javax.swing.JButton();
        updateDeviceInfo_btn = new javax.swing.JButton();
        generateDeviceReport_btn = new javax.swing.JButton();
        devices_cbx = new javax.swing.JComboBox();
        residencesMyDevices_cbx = new javax.swing.JComboBox();
        status_togglebtn = new javax.swing.JToggleButton();
        powerInWattsMyDevices_txt = new javax.swing.JTextField();
        deviceNameMyDevices_txt = new javax.swing.JTextField();
        logout_btn2 = new javax.swing.JButton();
        exit_btn3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        residencesMyResidences_cbx = new javax.swing.JComboBox();
        searchResidence_btn = new javax.swing.JButton();
        cep_txt1 = new javax.swing.JTextField();
        country_txt1 = new javax.swing.JTextField();
        uf_txt1 = new javax.swing.JTextField();
        city_txt1 = new javax.swing.JTextField();
        neighborhood_txt1 = new javax.swing.JTextField();
        street_txt1 = new javax.swing.JTextField();
        number_txt1 = new javax.swing.JTextField();
        additional_txt1 = new javax.swing.JTextField();
        energyFee_txt1 = new javax.swing.JTextField();
        generateDeviceReport_btn1 = new javax.swing.JButton();
        updateDeviceInfo_btn1 = new javax.swing.JButton();
        deleteResidence_btn = new javax.swing.JButton();
        logout_btn3 = new javax.swing.JButton();
        exit_btn4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setLayout(null);

        energyFee_txt.setText("Tarifa de energia eletrica");
        jPanel2.add(energyFee_txt);
        energyFee_txt.setBounds(130, 460, 230, 30);

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
        searchCEP_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCEP_btnActionPerformed(evt);
            }
        });
        jPanel2.add(searchCEP_btn);
        searchCEP_btn.setBounds(270, 20, 90, 30);

        save_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        save_btn.setText("SALVAR RESIDENCIA");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });
        jPanel2.add(save_btn);
        save_btn.setBounds(50, 500, 290, 30);

        exit_btn1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit_btn1.setText("SAIR");
        exit_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn1ActionPerformed(evt);
            }
        });
        jPanel2.add(exit_btn1);
        exit_btn1.setBounds(250, 640, 130, 30);

        logout_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logout_btn.setText("LOGOUT");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });
        jPanel2.add(logout_btn);
        logout_btn.setBounds(250, 600, 130, 30);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PowerHub_AddResidence.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(-10, 0, 410, 690);

        jTabbedPane1.addTab("New Residence", jPanel2);

        jPanel1.setLayout(null);

        addDevice_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addDevice_btn.setText("ADICIONAR");
        addDevice_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDevice_btnActionPerformed(evt);
            }
        });
        jPanel1.add(addDevice_btn);
        addDevice_btn.setBounds(30, 280, 330, 30);

        residencesNewDevice_cbx.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        residencesNewDevice_cbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residencesNewDevice_cbxActionPerformed(evt);
            }
        });
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

        logout_btn1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logout_btn1.setText("LOGOUT");
        logout_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(logout_btn1);
        logout_btn1.setBounds(250, 600, 130, 30);

        exit_btn2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit_btn2.setText("SAIR");
        exit_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn2ActionPerformed(evt);
            }
        });
        jPanel1.add(exit_btn2);
        exit_btn2.setBounds(250, 640, 130, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PowerHub_AddDevice.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(-10, 0, 410, 690);

        jTabbedPane1.addTab("New Device", jPanel1);

        jPanel3.setLayout(null);

        deleteDevice_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteDevice_btn.setForeground(new java.awt.Color(255, 0, 0));
        deleteDevice_btn.setText("EXCLUIR DISPOSITIVO");
        deleteDevice_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDevice_btnActionPerformed(evt);
            }
        });
        jPanel3.add(deleteDevice_btn);
        deleteDevice_btn.setBounds(30, 535, 320, 20);

        updateDeviceInfo_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updateDeviceInfo_btn.setForeground(new java.awt.Color(255, 51, 0));
        updateDeviceInfo_btn.setText("ALTERAR INFORMACOES");
        updateDeviceInfo_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDeviceInfo_btnActionPerformed(evt);
            }
        });
        jPanel3.add(updateDeviceInfo_btn);
        updateDeviceInfo_btn.setBounds(30, 510, 320, 20);

        generateDeviceReport_btn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        generateDeviceReport_btn.setText("GERAR RELATORIO");
        jPanel3.add(generateDeviceReport_btn);
        generateDeviceReport_btn.setBounds(30, 473, 320, 30);

        devices_cbx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        devices_cbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devices_cbxActionPerformed(evt);
            }
        });
        jPanel3.add(devices_cbx);
        devices_cbx.setBounds(30, 160, 330, 40);

        residencesMyDevices_cbx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        residencesMyDevices_cbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residencesMyDevices_cbxActionPerformed(evt);
            }
        });
        jPanel3.add(residencesMyDevices_cbx);
        residencesMyDevices_cbx.setBounds(30, 80, 330, 40);

        status_togglebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        status_togglebtn.setText("OFF");
        status_togglebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status_togglebtnActionPerformed(evt);
            }
        });
        jPanel3.add(status_togglebtn);
        status_togglebtn.setBounds(30, 373, 90, 30);

        powerInWattsMyDevices_txt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        powerInWattsMyDevices_txt.setText("Potencia em Watts");
        jPanel3.add(powerInWattsMyDevices_txt);
        powerInWattsMyDevices_txt.setBounds(30, 430, 320, 30);

        deviceNameMyDevices_txt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deviceNameMyDevices_txt.setText("Nome do dispositivo");
        deviceNameMyDevices_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deviceNameMyDevices_txtActionPerformed(evt);
            }
        });
        jPanel3.add(deviceNameMyDevices_txt);
        deviceNameMyDevices_txt.setBounds(30, 320, 320, 30);

        logout_btn2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logout_btn2.setText("LOGOUT");
        logout_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btn2ActionPerformed(evt);
            }
        });
        jPanel3.add(logout_btn2);
        logout_btn2.setBounds(250, 600, 130, 30);

        exit_btn3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit_btn3.setText("SAIR");
        exit_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn3ActionPerformed(evt);
            }
        });
        jPanel3.add(exit_btn3);
        exit_btn3.setBounds(250, 640, 130, 30);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PowerHub_MyDevices.png"))); // NOI18N
        jPanel3.add(jLabel3);
        jLabel3.setBounds(-10, -40, 410, 730);

        jTabbedPane1.addTab("My Devices", jPanel3);

        jPanel4.setLayout(null);

        residencesMyResidences_cbx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(residencesMyResidences_cbx);
        residencesMyResidences_cbx.setBounds(30, 180, 330, 30);

        searchResidence_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchResidence_btn.setText("BUSCAR");
        jPanel4.add(searchResidence_btn);
        searchResidence_btn.setBounds(30, 220, 330, 20);

        cep_txt1.setText("CEP da residencia");
        jPanel4.add(cep_txt1);
        cep_txt1.setBounds(80, 270, 280, 20);

        country_txt1.setText("Pais");
        jPanel4.add(country_txt1);
        country_txt1.setBounds(80, 300, 280, 20);

        uf_txt1.setText("Estado");
        jPanel4.add(uf_txt1);
        uf_txt1.setBounds(60, 340, 300, 20);

        city_txt1.setText("Cidade");
        jPanel4.add(city_txt1);
        city_txt1.setBounds(100, 370, 260, 20);

        neighborhood_txt1.setText("Bairro");
        jPanel4.add(neighborhood_txt1);
        neighborhood_txt1.setBounds(100, 410, 260, 20);

        street_txt1.setText("Rua");
        jPanel4.add(street_txt1);
        street_txt1.setBounds(80, 440, 280, 20);

        number_txt1.setText("Numero");
        jPanel4.add(number_txt1);
        number_txt1.setBounds(110, 480, 250, 20);

        additional_txt1.setText("Complemento");
        jPanel4.add(additional_txt1);
        additional_txt1.setBounds(160, 510, 200, 20);

        energyFee_txt1.setText("Tarifa de energia eletrica");
        jPanel4.add(energyFee_txt1);
        energyFee_txt1.setBounds(100, 580, 260, 20);

        generateDeviceReport_btn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        generateDeviceReport_btn1.setText("GERAR RELATORIO");
        jPanel4.add(generateDeviceReport_btn1);
        generateDeviceReport_btn1.setBounds(30, 605, 330, 25);

        updateDeviceInfo_btn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updateDeviceInfo_btn1.setForeground(new java.awt.Color(255, 51, 0));
        updateDeviceInfo_btn1.setText("ALTERAR INFORMACOES");
        jPanel4.add(updateDeviceInfo_btn1);
        updateDeviceInfo_btn1.setBounds(30, 630, 330, 20);

        deleteResidence_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteResidence_btn.setForeground(new java.awt.Color(255, 0, 0));
        deleteResidence_btn.setText("EXCLUIR RESIDENCIA");
        jPanel4.add(deleteResidence_btn);
        deleteResidence_btn.setBounds(30, 650, 330, 20);

        logout_btn3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logout_btn3.setText("LOGOUT");
        logout_btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btn3ActionPerformed(evt);
            }
        });
        jPanel4.add(logout_btn3);
        logout_btn3.setBounds(20, 10, 130, 30);

        exit_btn4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit_btn4.setText("SAIR");
        exit_btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn4ActionPerformed(evt);
            }
        });
        jPanel4.add(exit_btn4);
        exit_btn4.setBounds(20, 50, 130, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PowerHub_MyResidences.png"))); // NOI18N
        jPanel4.add(jLabel4);
        jLabel4.setBounds(-10, 0, 410, 690);

        jTabbedPane1.addTab("My Residences", jPanel4);

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

    private void exit_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn1ActionPerformed
        Model.Funcs_DAO.exit();
    }//GEN-LAST:event_exit_btn1ActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        Controller.LoggedUser_Controller.logout();
        JOptionPane.showMessageDialog(null, "Logout realizado com sucesso! Ate mais!");
        Model.Funcs_DAO.changeScreen(this, new Login_GUI());
    }//GEN-LAST:event_logout_btnActionPerformed

    private void logout_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btn1ActionPerformed
        Controller.LoggedUser_Controller.logout();
        JOptionPane.showMessageDialog(null, "Logout realizado com sucesso! Ate mais!");
        Model.Funcs_DAO.changeScreen(this, new Login_GUI());
    }//GEN-LAST:event_logout_btn1ActionPerformed

    private void exit_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn2ActionPerformed
        Model.Funcs_DAO.exit();
    }//GEN-LAST:event_exit_btn2ActionPerformed

    private void logout_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btn2ActionPerformed
        Controller.LoggedUser_Controller.logout();
        JOptionPane.showMessageDialog(null, "Logout realizado com sucesso! Ate mais!");
        Model.Funcs_DAO.changeScreen(this, new Login_GUI());
    }//GEN-LAST:event_logout_btn2ActionPerformed

    private void exit_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn3ActionPerformed
        Model.Funcs_DAO.exit();
    }//GEN-LAST:event_exit_btn3ActionPerformed

    private void logout_btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btn3ActionPerformed
        Controller.LoggedUser_Controller.logout();
        JOptionPane.showMessageDialog(null, "Logout realizado com sucesso! Ate mais!");
        Model.Funcs_DAO.changeScreen(this, new Login_GUI());
    }//GEN-LAST:event_logout_btn3ActionPerformed

    private void exit_btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn4ActionPerformed
        Model.Funcs_DAO.exit();
    }//GEN-LAST:event_exit_btn4ActionPerformed

    private void searchCEP_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCEP_btnActionPerformed
        Model.FieldFuncs_DAO.autoCompleteAddress(cep_txt.getText());
    }//GEN-LAST:event_searchCEP_btnActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        Model.ResidenceFuncs_DAO.addResidence(cep_txt.getText(), country_txt.getText(), uf_txt.getText(), city_txt.getText(), neighborhood_txt.getText(), street_txt.getText(), number_txt.getText(), additional_txt.getText(), energyFee_txt.getText());
    }//GEN-LAST:event_save_btnActionPerformed

    private void addDevice_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDevice_btnActionPerformed
        try {
            String selectedResidence = String.valueOf(residencesNewDevice_cbx.getSelectedItem());
            int residenceId = Integer.parseInt(selectedResidence.split(" ")[0]);
            Model.DeviceFuncs_DAO.addDevice(deviceNameNewDevice_txt.getText(), powerInWattsNewDevice_txt.getText(), residenceId);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Residencia nao encontrada!");
        }

    }//GEN-LAST:event_addDevice_btnActionPerformed

    private void residencesNewDevice_cbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residencesNewDevice_cbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_residencesNewDevice_cbxActionPerformed

    private void residencesMyDevices_cbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residencesMyDevices_cbxActionPerformed
        try {
            String selectedResidence = String.valueOf(residencesNewDevice_cbx.getSelectedItem());
            int residenceId = Integer.parseInt(selectedResidence.split(" ")[0]);
            Model.FieldFuncs_DAO.refreshDeviceCombobox(residenceId);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Residencia nao encontrada!");
            System.out.println("Residencia nao encontrada!");
        }
    }//GEN-LAST:event_residencesMyDevices_cbxActionPerformed

    private void deviceNameMyDevices_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deviceNameMyDevices_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deviceNameMyDevices_txtActionPerformed

    private void status_togglebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status_togglebtnActionPerformed
        String selectedDevice = String.valueOf(devices_cbx.getSelectedItem());
        int deviceId = Integer.parseInt(selectedDevice.split(" ")[0]);
        Device device = Model.DeviceFuncs_DAO.getDeviceById(deviceId);
        if (status_togglebtn.isSelected()) {
            try {
                if (Model.MeasurementFuncs_DAO.newMeasurement(device)) {
                    Model.DeviceFuncs_DAO.changeDeviceStatus(device, true);
                    View.MainMenu_GUI.status_togglebtn.setText("ON");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu algum erro ao tentar ligar aparelho e adicionar medicao no banco de dados");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Residencia nao encontrada!");
            }
        } else {
            try {
                String selectedResidence = String.valueOf(residencesNewDevice_cbx.getSelectedItem());
                int residenceId = Integer.parseInt(selectedResidence.split(" ")[0]);
                Residence residence = Model.ResidenceFuncs_DAO.getResidenceById(residenceId);
                View.MainMenu_GUI.status_togglebtn.setText("OFF");
                Model.DeviceFuncs_DAO.changeDeviceStatus(device, false);
                Model.MeasurementFuncs_DAO.endMeasurement(device, residence.getEnergyFee());
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Residencia nao encontrada!");
                System.out.println("Residencia nao encontrada!");
            }
        }
    }//GEN-LAST:event_status_togglebtnActionPerformed

    private void devices_cbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devices_cbxActionPerformed
        try {
            String selectedDevice = String.valueOf(devices_cbx.getSelectedItem());
            int deviceId = Integer.parseInt(selectedDevice.split(" ")[0]);
            Model.FieldFuncs_DAO.refreshMyDevicesFields(deviceId);
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Residencia nao encontrada!");
            System.out.println("Dispositivo nao encontrada!");
        }
    }//GEN-LAST:event_devices_cbxActionPerformed

    private void updateDeviceInfo_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDeviceInfo_btnActionPerformed
        try {
            String selectedDevice = String.valueOf(devices_cbx.getSelectedItem());
            int deviceId = Integer.parseInt(selectedDevice.split(" ")[0]);
            Model.DeviceFuncs_DAO.updateDeviceInfo(deviceId, deviceNameMyDevices_txt.getText(), powerInWattsMyDevices_txt.getText());
        } catch (Exception e) {
            System.out.println("Dispositivo nao encontrado!");
        }

    }//GEN-LAST:event_updateDeviceInfo_btnActionPerformed

    private void deleteDevice_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDevice_btnActionPerformed
        try {
            String selectedDevice = String.valueOf(devices_cbx.getSelectedItem());
            int deviceId = Integer.parseInt(selectedDevice.split(" ")[0]);
            Model.DeviceFuncs_DAO.deleteDevice(deviceId);
        } catch (Exception e) {
            System.out.println("Dispositivo nao encontrado!");
        }
    }//GEN-LAST:event_deleteDevice_btnActionPerformed

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
    public static javax.swing.JTextField additional_txt1;
    public static javax.swing.JTextField cep_txt;
    public static javax.swing.JTextField cep_txt1;
    public static javax.swing.JTextField city_txt;
    public static javax.swing.JTextField city_txt1;
    public static javax.swing.JTextField country_txt;
    public static javax.swing.JTextField country_txt1;
    private javax.swing.JButton deleteDevice_btn;
    private javax.swing.JButton deleteResidence_btn;
    public static javax.swing.JTextField deviceNameMyDevices_txt;
    public static javax.swing.JTextField deviceNameNewDevice_txt;
    public static javax.swing.JComboBox devices_cbx;
    public static javax.swing.JTextField energyFee_txt;
    public static javax.swing.JTextField energyFee_txt1;
    private javax.swing.JButton exit_btn1;
    private javax.swing.JButton exit_btn2;
    private javax.swing.JButton exit_btn3;
    private javax.swing.JButton exit_btn4;
    private javax.swing.JButton generateDeviceReport_btn;
    private javax.swing.JButton generateDeviceReport_btn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton logout_btn1;
    private javax.swing.JButton logout_btn2;
    private javax.swing.JButton logout_btn3;
    public static javax.swing.JTextField neighborhood_txt;
    public static javax.swing.JTextField neighborhood_txt1;
    public static javax.swing.JTextField number_txt;
    public static javax.swing.JTextField number_txt1;
    public static javax.swing.JTextField powerInWattsMyDevices_txt;
    public static javax.swing.JTextField powerInWattsNewDevice_txt;
    public static javax.swing.JComboBox residencesMyDevices_cbx;
    public static javax.swing.JComboBox residencesMyResidences_cbx;
    public static javax.swing.JComboBox residencesNewDevice_cbx;
    private javax.swing.JButton save_btn;
    private javax.swing.JButton searchCEP_btn;
    private javax.swing.JButton searchResidence_btn;
    public static javax.swing.JToggleButton status_togglebtn;
    public static javax.swing.JTextField street_txt;
    public static javax.swing.JTextField street_txt1;
    public static javax.swing.JTextField uf_txt;
    public static javax.swing.JTextField uf_txt1;
    private javax.swing.JButton updateDeviceInfo_btn;
    private javax.swing.JButton updateDeviceInfo_btn1;
    // End of variables declaration//GEN-END:variables
}
