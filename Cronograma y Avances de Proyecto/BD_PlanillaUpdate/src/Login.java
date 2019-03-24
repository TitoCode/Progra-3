import java.sql.*;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {


    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtCod_Usuario = new javax.swing.JTextField();
        BtnIngreso = new javax.swing.JButton();
        TxtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PASSWORD");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CÓDIGO  USUARIO");

        TxtCod_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtCod_UsuarioKeyPressed(evt);
            }
        });

        BtnIngreso.setText("INGRESAR");
        BtnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresoActionPerformed(evt);
            }
        });

        TxtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtPasswordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtCod_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(TxtPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(BtnIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCod_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// Boton para acceder a un usuario segun credenciales
    private void BtnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresoActionPerformed
       //Se realiza una consula en la tabla usuario del codigo de usuario y clave  y si existe y coincide permite el acceso
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from usuario where codigo_usuario = ? and clave_usuario=? and estado_usuario=1");

            pst.setString(1, TxtCod_Usuario.getText().trim());
            pst.setString(2, TxtPassword.getText().trim());
            ResultSet rs = pst.executeQuery();

            // Se de acceso al usuario y se llama a la form Inicio
            if(rs.next()){
                new Inicio().setVisible(true);
                //Sentencia para cerrar el programa
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario Invalido");
            }
            cn.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido Realizar el Login");
        }
    }//GEN-LAST:event_BtnIngresoActionPerformed

//Si se le da "Enter" al campo de Codigo usurio enfocara al campo de contraseña
    private void TxtCod_UsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCod_UsuarioKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
                 TxtPassword.requestFocus();
        }
    }//GEN-LAST:event_TxtCod_UsuarioKeyPressed

    //Si se le da "Enter" al campo de contraseña de igual manrea realiza la consulta para dejar acceder al usuario
    private void TxtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPasswordKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
                 if (TxtCod_Usuario.getText().length()==0 || TxtPassword.getText().length()==0) {
           JOptionPane.showMessageDialog(null,"Ingrese Los Datos");
        }else{
            try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from usuario where codigo_usuario = ? and clave_usuario=? and estado_usuario=1");

            pst.setString(1, TxtCod_Usuario.getText().trim());
            pst.setString(2, TxtPassword.getText().trim());
            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                new Inicio().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario Invalido");
            }
            cn.close();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido Realizar el Login");
        }         
        }
                        
        }
    }//GEN-LAST:event_TxtPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnIngreso;
    private javax.swing.JTextField TxtCod_Usuario;
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
