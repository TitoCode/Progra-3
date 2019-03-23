/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.sql.*;


/*
0901-17-65 Antonio Manuel Alejandro Garcia Gonzalez.

*/

public class Inicio extends javax.swing.JFrame {
    
    
    DefaultTableModel tabla = new DefaultTableModel();
    String IGSS, sueldo, ISR;
    double ValorDetalle;
    private void Clear(){
        while (tabla.getRowCount() > 0) {
               tabla.removeRow(0);
        }
    }
    
    public void ObtenerDatos(){
        Clear();        
            try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/umg", "root", "");
            PreparedStatement pst = cn.prepareStatement("select encabezado_nomina.codigo_nomina, empleado.codigo_empleado,"
            + "empleado.sueldo_empleado, empleado.IGSS from encabezado_nomina, empleado where codigo_nomina = ?");
            pst.setString(1, txt_CodigoNomina.getText().trim());
            ResultSet ConsultaNomina = pst.executeQuery();
          
            while(ConsultaNomina.next())
           {
               Object []fila = new Object[5];
               fila[0] = ConsultaNomina.getString("codigo_nomina");
               fila[1] = ConsultaNomina.getString("codigo_empleado");
               fila[2] = ConsultaNomina.getString("sueldo_empleado");
               fila[3] = ConsultaNomina.getString("IGSS");
               sueldo = fila[2].toString();
               IGSS= fila[3].toString();
               
               if (Integer.parseInt(IGSS) == 1)
               {
                   
               }
               else
               {
                    if ((Double.parseDouble(sueldo)>2600) && (Double.parseDouble(sueldo)<5000))
                    {
                        ISR = "C3"; 
                        ValorDetalle = Double.parseDouble(sueldo)*0.03;
                        fila[4] = (ValorDetalle);
                    }
                    else if ((Double.parseDouble(sueldo) >= 5000) &&(Double.parseDouble(sueldo) < 10000) )
                    {
                        ISR = "C4"; 
                        ValorDetalle = Double.parseDouble(sueldo)*0.03;
                        fila[4] = (ValorDetalle);
                    }
                    else if (Double.parseDouble(sueldo) >= 10000)
                    {
                        ISR = "C5"; 
                        ValorDetalle = Double.parseDouble(sueldo)*0.03;
                        fila[4] = (ValorDetalle);
                    }
                    else
                    {
                        ISR = "C2"; 
                        ValorDetalle = Double.parseDouble(sueldo)*0.03;
                        fila[4] = (ValorDetalle);
                    }
               }
               tabla.addRow(fila);
               
           }

            
           }catch (Exception e){
           JOptionPane.showMessageDialog(null, "No Se Encuentra La Nomina");
           }
        if ((TXT_InsNombre.getText() == "")&&(txt_CodigoNomina.getText() != ""))
        {
           
            
        }
        else if(txt_CodigoNomina.getText() == "")
        {
            
        }
        else
        {
            
        }
         
    }
    public Inicio() {
        
        initComponents();
        this.Tabla_Detalles.setModel(tabla);
        tabla.addColumn("Codigo Nomina");
        tabla.addColumn("Codigo Empleado");
        tabla.addColumn("Codigo Concept");
        tabla.addColumn("Valor Detalle");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TXT_InsNombre = new javax.swing.JTextField();
        BT_InsNombre = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Detalles = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_CodigoNomina = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TXT_InsNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_InsNombreActionPerformed(evt);
            }
        });

        BT_InsNombre.setText("Buscar");
        BT_InsNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_InsNombreActionPerformed(evt);
            }
        });

        Tabla_Detalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Nomina", "Codigo Empleado", "Codigo Concepto", "Valor Detalle"
            }
        ));
        jScrollPane1.setViewportView(Tabla_Detalles);

        jLabel1.setText("Nombre:");

        jLabel5.setText("Codigo Nomina");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_CodigoNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(BT_InsNombre))
                            .addComponent(TXT_InsNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_InsNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_CodigoNomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_InsNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXT_InsNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_InsNombreActionPerformed
        
    }//GEN-LAST:event_TXT_InsNombreActionPerformed

    private void BT_InsNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_InsNombreActionPerformed
        ObtenerDatos();

    }//GEN-LAST:event_BT_InsNombreActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_InsNombre;
    private javax.swing.JTextField TXT_InsNombre;
    private javax.swing.JTable Tabla_Detalles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_CodigoNomina;
    // End of variables declaration//GEN-END:variables
}
