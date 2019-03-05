package laboratorioparcial;

import java.util.Random;
import java.text.DecimalFormat;
/**
 *Carlos Augusto Rodas Guerra
 *0901-17-963
 */

// El siguiente programa realiza automaticamente el ingreso de 10 alumnos y sus notas correspondientes
// y muestra si estos aprobaron el curso o no
public class SolucionParcial extends javax.swing.JFrame {

    Random rand = new Random();
    String Mat [][] = new String[10][3];
    DecimalFormat deci = new DecimalFormat("0.00");
    double prom = 0;
    
    //Metodo donde se generan los datos
    public void Datos(){
    int nota;
    String nombre = null;
    for(int fila = 0; fila < 10; fila++)
        {
           nota = rand.nextInt(101);
           Mat[fila][1] = String.valueOf(nota);
           //Verifica si se aprobo o no
           if (nota < 61){Mat[fila][2] = "Reprobado";}
           else{Mat[fila][2] = "Aprobado";}
           
           prom+= nota;
        }
    
    for (int nom = 0; nom < 10; nom ++)
        {
            switch (nom)
            {
                case 0:{nombre = "Carlos";}break;
                case 1:{nombre = "Antonio";}break;
                case 2:{nombre = "Augusto";}break;
                case 3:{nombre = "Manuel";}break;
                case 4:{nombre = "Alejandro";}break;
                case 5:{nombre = "Raul";}break;
                case 6:{nombre = "Alexander";}break;
                case 7:{nombre = "Sthefany";}break;
                case 8:{nombre = "Johanna";}break;
                case 9:{nombre = "Carmen";}break;
            }
            Mat[nom][0] = nombre;
        }   
        prom = prom/10;
    }
    //Metodo que agrega los datos
    public void Agregar(){
String nomb, not, res;
        for(int fila = 0; fila < 10; fila++)
        {
           for(int columna = 0; columna < 3; columna ++)
           {
               Tabla_Datos.setValueAt(Mat[fila][columna], fila, columna);
           }
        }

//        for(int fila = 0; fila < 10; fila++)
//        {
//               nomb = Mat[fila][0];
//               Tabla_Datos.setValueAt(nomb, fila, 0);   
//        }
//        for(int fila = 0; fila < 10; fila++)
//        {
//               not = Mat[fila][1];
//               Tabla_Datos.setValueAt(not, fila, 1);   
//        }
//        for(int fila = 0; fila < 10; fila++)
//        {
//               res = Mat[fila][2];
//               Tabla_Datos.setValueAt(res, fila, 2);   
//        }


        Txtb_Promedio.setText(String.valueOf(deci.format(prom)));
    }
    public SolucionParcial() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_IngresarDatos = new javax.swing.JButton();
        Txtb_Promedio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_Datos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btn_IngresarDatos.setText("Realizar Ingreso");
        Btn_IngresarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_IngresarDatosActionPerformed(evt);
            }
        });

        jLabel3.setText("Promedio:");

        Tabla_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Nota", "Resultado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Tabla_Datos);
        if (Tabla_Datos.getColumnModel().getColumnCount() > 0) {
            Tabla_Datos.getColumnModel().getColumn(0).setHeaderValue("Nombre");
            Tabla_Datos.getColumnModel().getColumn(1).setHeaderValue("Nota");
            Tabla_Datos.getColumnModel().getColumn(2).setHeaderValue("Resultado");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_IngresarDatos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Txtb_Promedio, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Btn_IngresarDatos)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txtb_Promedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_IngresarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_IngresarDatosActionPerformed
        Datos();
        Agregar();
    }//GEN-LAST:event_Btn_IngresarDatosActionPerformed

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
            java.util.logging.Logger.getLogger(SolucionParcial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolucionParcial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolucionParcial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolucionParcial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolucionParcial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_IngresarDatos;
    private javax.swing.JTable Tabla_Datos;
    private javax.swing.JTextField Txtb_Promedio;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
