
package nomina;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;

/**
 * Carlos Augusto Rodas Guerra
 * 0901-17-963
 * 05/02/2019
 */

//El siguiente programa presenta una planilla en donde solo se ingresa el nombre del empleado y automaticamnete le asigna salario base, departamento
//donde trabaja, sus deducciones, percepciones y salario liquido todo de manera aleatoria
public class Nomina_F extends javax.swing.JFrame {

    int SalarioBase, Deducciones, Percepcion, SueldoLiquido, Nrand; // Las siguientes variales se utilizan en el metodo Datos
    String Departamento, Nombre; int opc;// la variable opc se utilizara en el switch del metodo Datos
    String Mat [][] = {}; // Esta matriz es la que se usa de referencia para llenar la tabla
    String Vec [] = {"Nombre","Departamento","Salario Base", "IGSS","ISR","Deducciones","Percepcion","Sueldo Liquido"};// Este vector es el que maneja el nombre de las columnas
    Random rand = new Random();// variable random para generar todos los valores del empleado.
    DefaultTableModel Modelo, SL;// Se crea un objeto tipo DefaultTableModel
    DecimalFormat Deci = new DecimalFormat("0.00");
    
    int TProy = 0, TInfo = 0, TCyD = 0, TRyS = 0, TNomi = 0;// Son variables que llevaran el control del total del sueldo liquido por departamento
    String Vec_Tsl[] = {"Proyectos", "Informatica","Capacitacion y Desarrollo","Reclutamiento y Selección","Nomina"};
    String Mat_Tsl [][] = {{}, {}};
    
    double ISR, IGSS = 0;;
    public Nomina_F() {
        initComponents();
        Modelo = new DefaultTableModel(Mat, Vec);// Se dice que el objeto Model se trabajara como una matriz
        jTable1.setModel(Modelo);// Se ajusta el modelo de la tabla al especificado en Modelo
        SL = new DefaultTableModel(Mat_Tsl, Vec_Tsl);
        jTable2.setModel(SL);
    }
    
    public void Total()// Metodo que agrega el sueldo liquido total por departamento
    {
        
        SL.setValueAt(Integer.toString(TProy), 0, 0);
        SL.setValueAt(Integer.toString(TInfo), 0, 1);
        SL.setValueAt(Integer.toString(TCyD), 0, 2);
        SL.setValueAt(Integer.toString(TRyS), 0, 3);
        SL.setValueAt(Integer.toString(TNomi), 0, 4);  
        
    }
    
public void Datos()// El siguiente metodo es el que genera y selecciona los datos del empleado utilizando Random, todos menos el sueldo Liquido
{
    Nrand = rand.nextInt(3000);
    SalarioBase = 2000+ Nrand;
    Deducciones = rand.nextInt(3000);
    Percepcion = rand.nextInt(3000);
    SueldoLiquido = SalarioBase + Percepcion - Deducciones;// Se calcula el sueldo liquido en base a los datos generados
    
    opc = rand.nextInt(5);
    switch(opc)// se crea un numero aleatorio que selecciona el departamento del empleado y le sumara al total del sueldo liquido del dep. correspondiente
    {
        case 0:{Departamento = "Proyectos"; TProy += SueldoLiquido;}break;
        case 1:{Departamento = "Informatica"; TInfo += SueldoLiquido;}break;
        case 2:{Departamento = "Capacitacion y Desarrollo"; TCyD += SueldoLiquido;}break;
        case 3:{Departamento = " Reclutamiento y Seleccion"; TRyS += SueldoLiquido;}break;
        case 4:{Departamento = "Nominas";TNomi += SueldoLiquido;}break;
    }
    
    // Calculos del ISR
    if ((SalarioBase > 2600)&&(SalarioBase < 5000)){ISR = SalarioBase*0.03;}
    else if ((SalarioBase >= 5000) &&(SalarioBase < 10000) ){ISR = SalarioBase*0.05;}
    else if (SalarioBase >= 10000){ISR = SalarioBase*0.1;}
    else {ISR = 0;}
    
    // Calculo IGSS
    if (Chb_IGSS.isSelected() == true){ IGSS = SalarioBase*0.0483;}
    else {IGSS = 0;}
}

public void Ingresar(){
    Nombre = Txt_nombre.getText();// Se obtiene el nombre ingresado
    String Nom,Dep, SB, igss, isr, Ded, Per, SL;// se crean variable que seran ingresadas a la tabla
    Nom = Nombre;
    Dep = Departamento;
    SB = Integer.toString(SalarioBase);
    Ded = Integer.toString(Deducciones);
    Per = Integer.toString(Percepcion);
    SL = Integer.toString(SueldoLiquido);
    isr = String.valueOf(Deci.format(ISR));
    igss = String.valueOf(Deci.format(IGSS));
    String Datos [] = {Nom,Dep,SB, igss,isr,Ded,Per,SL};// Se crea el vector el cual seguira el modelo del vector utilizado en la tabla
    Modelo.addRow(Datos); // se agregan los datos a la tabla
   
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Txt_nombre = new javax.swing.JTextField();
        Btn_agregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Chb_IGSS = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        Btn_agregar.setText("Agregar");
        Btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_agregarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Departamento", "Salario Base", "ISR", "Deducciones", "Percepcion", "Sueldo Liquido"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Proyectos", "Informatica", "Capacitacion & Desarrollo", "Reclutamiento y Selección", "Nomina"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setText("Sueldo Liquido por Departamento");

        Chb_IGSS.setText("IGSS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Chb_IGSS)
                                    .addComponent(Btn_agregar))))
                        .addGap(0, 526, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Chb_IGSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_agregarActionPerformed
        // Se verifica que el campo no este vacio
        if ("".equals(Txt_nombre.getText()))
        {
            JOptionPane.showMessageDialog(null, "Ingrese un Nombre por favor");
        }
        else
        {
            // se ejecutan los metodos si se ingreso un nombre
            Datos();
            Ingresar();
            Total();
        }
    }//GEN-LAST:event_Btn_agregarActionPerformed

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
            java.util.logging.Logger.getLogger(Nomina_F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nomina_F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nomina_F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nomina_F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nomina_F().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_agregar;
    private javax.swing.JCheckBox Chb_IGSS;
    private javax.swing.JTextField Txt_nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
