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
public class Login_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Splash_GUI
     */
    public Login_GUI() {
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

        jPanel1 = new javax.swing.JPanel();
        showPassword_btn = new javax.swing.JToggleButton();
        exit_btn = new javax.swing.JButton();
        send_btn = new javax.swing.JButton();
        signUp_btn1 = new javax.swing.JButton();
        password_txt = new javax.swing.JPasswordField();
        cpf_txt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

        showPassword_btn.setBackground(new java.awt.Color(255, 255, 255));
        showPassword_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eyeIcon.png"))); // NOI18N
        showPassword_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassword_btnActionPerformed(evt);
            }
        });
        jPanel1.add(showPassword_btn);
        showPassword_btn.setBounds(300, 220, 60, 30);

        exit_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exit_btn.setText("SAIR");
        exit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btnActionPerformed(evt);
            }
        });
        jPanel1.add(exit_btn);
        exit_btn.setBounds(260, 660, 130, 30);

        send_btn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        send_btn.setText("ENTRAR");
        send_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_btnActionPerformed(evt);
            }
        });
        jPanel1.add(send_btn);
        send_btn.setBounds(40, 270, 320, 40);

        signUp_btn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signUp_btn1.setText("Não tenho cadastro");
        signUp_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUp_btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(signUp_btn1);
        signUp_btn1.setBounds(40, 320, 320, 20);

        password_txt.setText("jPasswordField1");
        jPanel1.add(password_txt);
        password_txt.setBounds(150, 220, 150, 30);

        cpf_txt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cpf_txt.setText("Insira seu CPF");
        jPanel1.add(cpf_txt);
        cpf_txt.setBounds(150, 170, 210, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/PowerHub_SetUp.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 704);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(396, 704));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signUp_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUp_btn1ActionPerformed
        Model.Funcs_DAO.changeScreen(this, new SignUp_GUI());
    }//GEN-LAST:event_signUp_btn1ActionPerformed

    private void exit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btnActionPerformed
        Model.Funcs_DAO.exit();
    }//GEN-LAST:event_exit_btnActionPerformed

    private void send_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_btnActionPerformed
        if (Model.Login_DAO.login(cpf_txt.getText(), password_txt.getText())) {
            Model.Funcs_DAO.changeScreen(this, new MainMenu_GUI());
        }
    }//GEN-LAST:event_send_btnActionPerformed

    private void showPassword_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassword_btnActionPerformed
        if (showPassword_btn.isSelected()) {
            // Mostrar os caracteres reais
            password_txt.setEchoChar('\0');
        } else {
            // Ocultar os caracteres reais
            password_txt.setEchoChar('\u25cf');
        }
    }//GEN-LAST:event_showPassword_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Login_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField cpf_txt;
    private javax.swing.JButton exit_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPasswordField password_txt;
    private javax.swing.JButton send_btn;
    private javax.swing.JToggleButton showPassword_btn;
    private javax.swing.JButton signUp_btn1;
    // End of variables declaration//GEN-END:variables
}
