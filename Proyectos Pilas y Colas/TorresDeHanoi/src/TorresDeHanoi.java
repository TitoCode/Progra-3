
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 * Carlos Augusto Rodas Guerra
 * 0901-17-963
 */
public class TorresDeHanoi extends javax.swing.JFrame {

    DefaultTableModel Modelo_A = new DefaultTableModel();
    DefaultTableModel Modelo_B = new DefaultTableModel();
    DefaultTableModel Modelo_C = new DefaultTableModel();
    Nodo A = null, B = null, C= null; // Se crean 3 listas, una para cada tabla.
                                      // A = Tabla Inicial , B = Tabla Auxiliar, C = Tabla Final
    
    int num; // Numero que ingresa el usuario,represanta el total de elementos a ser agregados.
    int opc; // varialbe utilizada en metodo Verificar, se utilisa ara seleccionar un Case del switch
    int movimientos = 0;//Numero de Movimientos realizados.
    
    //Metodo que vacia ("Limpia") la tabla
    public void Limpiar(){
        while (Modelo_A.getRowCount() > 0) {
               Modelo_A.removeRow(0);
        }
        while (Modelo_B.getRowCount() > 0) {
               Modelo_B.removeRow(0);
        }
        while (Modelo_C.getRowCount() > 0) {
               Modelo_C.removeRow(0);
        }
    }
    // Metodo que ingresa el numero de elementos deseados por el usuario en la pila/tabla A
    public void LlenarLista(int num){
        
        Nodo nodo=new Nodo(num);
        if (A==null){
            A=nodo;
	}
        else
        {
            Nodo temp=A;
            while (temp.Siguiente!=null) {
                    temp=temp.Siguiente;
                  }
            temp.Siguiente=nodo;
        }
        
        
    }
    
   public void Mostrar(){
       String Datos [] = new String[1];
        Nodo aux = A;
        while (aux!=null)
            {
                Datos[0] = String.valueOf(aux.info);
                Modelo_A.addRow(Datos);
                aux=aux.Siguiente;
            }
        aux = B;
        while (aux!=null)
            {
                Datos[0] = String.valueOf(aux.info);
                Modelo_B.addRow(Datos);
                aux=aux.Siguiente;
            }
        aux = C;
        while (aux!=null)
            {
                Datos[0] = String.valueOf(aux.info);
                Modelo_C.addRow(Datos);
                aux=aux.Siguiente;
            }
        int mov;
        mov = (int) Math.pow(2, num) - 1;
        this.lbl_MovTotal.setText(Integer.toString(mov));
        this.lbl_MovRealizado.setText("No. de Movimientos Reaizados: " + movimientos);
   }
   
   public void Verificar(int opc){
       int dato1, dato2 = 0;
       switch (opc){
           case 1:{// Boton de A a B, mueve el valor en la cima de la pila A hacia la pila B
                if(A == null){
                    JOptionPane.showMessageDialog(null,"La tabla no contiene ningún dato");
                }//fin if   
                else{
                    dato1 = A.info;
                    Nodo Nuevo = new Nodo(dato1);
                    if(B == null){
                        B = Nuevo;
                        A = A.Siguiente;
                        movimientos += 1;
                    }//Fin if
                    else{
                        dato2 = B.info;
                        if (dato1 > dato2){
                            JOptionPane.showMessageDialog(null,"No se puede realizar moviemiento, el valor que quiere mover es mayor a la base donde sera colocada.");
                        }//fin if
                        else{
                            Nuevo.Siguiente = B;
                            B = Nuevo;
                            A = A.Siguiente;
                            movimientos += 1;
                        }//fin else
                    }//fin else   
                }//fin else
           }break;//fin case 1
           case 2:{// Boton de A a C, mueve el valor en la cima de la pila A hacia la pila C
                if ( A == null){
                    JOptionPane.showMessageDialog(null,"La tabla no contiene ningún dato");
                }//fin if
                else{
                    dato1 = A.info;
                    Nodo Nuevo = new Nodo(dato1);
                    if(C == null){
                        C = Nuevo;
                        A = A.Siguiente;
                        movimientos += 1;
                    }//Fin if
                    else{
                        dato2 = C.info;
                        if (dato1 > dato2){
                            JOptionPane.showMessageDialog(null,"No se puede realizar moviemiento, el valor que quiere mover es mayor a la base donde sera colocada.");
                        }//fin if
                        else{
                            Nuevo.Siguiente = C;
                            C = Nuevo;
                            A = A.Siguiente;
                            movimientos += 1;
                        }//fin else
                    }//fin else
                }//fin else
           }break;//fin case 2
           case 3:{// Boton de B a C, mueve el valor en la cima de la pila B hacia la pila C
               
                if (B == null){
                    JOptionPane.showMessageDialog(null,"La tabla no contiene ningún dato");
                }
                else{
                    
                    dato1 = B.info;
                    Nodo Nuevo = new Nodo(dato1);
                    if(C == null){
                        C = Nuevo;
                        B = B.Siguiente;
                        movimientos += 1;
                    }//Fin if
                    else{
                        dato2 = C.info;
                        if (dato1 > dato2){
                            JOptionPane.showMessageDialog(null,"No se puede realizar moviemiento, el valor que quiere mover es mayor a la base donde sera colocada.");
                        }//fin if
                        else{
                            Nuevo.Siguiente = C;
                            C = Nuevo;
                            B = B.Siguiente;
                            movimientos += 1;
                        }//fin else
                    }//fin else   
                }//fin else 
           }break;//fin case 3
           case 4:{// Boton de B a A, mueve el valor en la cima de la pila B hacia la pila A
               
                if (B == null){
                    JOptionPane.showMessageDialog(null,"La tabla no contiene ningún dato");
                }
                else{
                    
                    dato1 = B.info;
                    Nodo Nuevo = new Nodo(dato1);
                    if(A == null){
                        A = Nuevo;
                        B = B.Siguiente;
                        movimientos += 1;
                    }//Fin if
                    else{
                        dato2 = A.info;
                        if (dato1 > dato2){
                            JOptionPane.showMessageDialog(null,"No se puede realizar moviemiento, el valor que quiere mover es mayor a la base donde sera colocada.");
                        }//fin if
                        else{
                            Nuevo.Siguiente = A;
                            A = Nuevo;
                            B = B.Siguiente;
                            movimientos += 1;
                        }//fin else
                    }//fin else   
                }//fin else 
               
           }break;//fin case 4
           case 5:{// Boton de C a B, mueve el valor en la cima de la pila C hacia la pila B
               
               if (C == null){
                    JOptionPane.showMessageDialog(null,"La tabla no contiene ningún dato");
                }
                else{
                    
                    dato1 = C.info;
                    Nodo Nuevo = new Nodo(dato1);
                    if(B == null){
                        B = Nuevo;
                        C = C.Siguiente;
                        movimientos += 1;
                    }//Fin if
                    else{
                        dato2 = B.info;
                        if (dato1 > dato2){
                            JOptionPane.showMessageDialog(null,"No se puede realizar moviemiento, el valor que quiere mover es mayor a la base donde sera colocada.");
                        }//fin if
                        else{
                            Nuevo.Siguiente = B;
                            B = Nuevo;
                            C = C.Siguiente;
                            movimientos += 1;
                        }//fin else
                    }//fin else   
                }//fin else 
               
           }break;//fin case 5
           case 6:{// Boton de C a A, mueve el valor en la cima de la pila C hacia la pila A
               
               if (C == null){
                    JOptionPane.showMessageDialog(null,"La tabla no contiene ningún dato");
                }
                else{
                    
                    dato1 = C.info;
                    Nodo Nuevo = new Nodo(dato1);
                    if(A == null){
                        A = Nuevo;
                        C = C.Siguiente;
                        movimientos += 1;
                    }//Fin if
                    else{
                        dato2 = A.info;
                        if (dato1 > dato2){
                            JOptionPane.showMessageDialog(null,"No se puede realizar moviemiento, el valor que quiere mover es mayor a la base donde sera colocada.");
                        }//fin if
                        else{
                            Nuevo.Siguiente = A;
                            A = Nuevo;
                            C = C.Siguiente;
                            movimientos += 1;
                        }//fin else
                    }//fin else   
                }//fin else 
               
           }break;//fin case 6
       }//fin switch
   }
    
    public TorresDeHanoi() {
        
        initComponents();
        
        this.TablaInicial.setModel(Modelo_A);
        Modelo_A.addColumn("A");
        this.TablaAux.setModel(Modelo_B);
        Modelo_B.addColumn("B");
        this.TablaFinal.setModel(Modelo_C);
        Modelo_C.addColumn("C");
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_NoElementos = new javax.swing.JTextField();
        btn_Iniciar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbl_MovTotal = new javax.swing.JLabel();
        btn_AaB = new javax.swing.JButton();
        btn_BaC = new javax.swing.JButton();
        btn_BaA = new javax.swing.JButton();
        btn_CaB = new javax.swing.JButton();
        btn_AaC = new javax.swing.JButton();
        btn_CaA = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaInicial = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaAux = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaFinal = new javax.swing.JTable();
        lbl_MovRealizado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("No. de Elementos: ");

        btn_Iniciar.setText("Crear o Reiniciar");
        btn_Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IniciarActionPerformed(evt);
            }
        });

        jLabel2.setText("No. Total de Movimientos para Completar: ");

        lbl_MovTotal.setText("-");

        btn_AaB.setText("De A a B");
        btn_AaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AaBActionPerformed(evt);
            }
        });

        btn_BaC.setText("De B a C");
        btn_BaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BaCActionPerformed(evt);
            }
        });

        btn_BaA.setText("De B a A");
        btn_BaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BaAActionPerformed(evt);
            }
        });

        btn_CaB.setText("De C a B");
        btn_CaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CaBActionPerformed(evt);
            }
        });

        btn_AaC.setText("De A a C");
        btn_AaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AaCActionPerformed(evt);
            }
        });

        btn_CaA.setText("De C a A");
        btn_CaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CaAActionPerformed(evt);
            }
        });

        TablaInicial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "A"
            }
        ));
        jScrollPane1.setViewportView(TablaInicial);

        TablaAux.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "B"
            }
        ));
        jScrollPane2.setViewportView(TablaAux);

        TablaFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "C"
            }
        ));
        jScrollPane3.setViewportView(TablaFinal);

        lbl_MovRealizado.setText("No. de Movimientos Realizados: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_MovTotal))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_NoElementos, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_Iniciar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_AaC, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addComponent(btn_AaB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(42, 42, 42)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_BaA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_BaC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(54, 54, 54)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_CaB, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_CaA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lbl_MovRealizado))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_NoElementos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Iniciar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_MovTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_MovRealizado)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_AaB)
                    .addComponent(btn_BaC)
                    .addComponent(btn_CaB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_BaA)
                    .addComponent(btn_AaC)
                    .addComponent(btn_CaA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Boton De C a B
    private void btn_CaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CaBActionPerformed
        if("".equals(this.txt_NoElementos.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el numero de elementos que desea usar.");
        }
        else{
            opc = 5;
            Limpiar();
            Verificar(opc);
            Mostrar();
        }
    }//GEN-LAST:event_btn_CaBActionPerformed
    // Boton Crear / Reiniciar
    private void btn_IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IniciarActionPerformed

        if("".equals(this.txt_NoElementos.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el numero de elementos que desea usar.");
        }
        else{
            Limpiar();
            A = null;
            B = null;
            C = null;
            num = Integer.parseInt(this.txt_NoElementos.getText());
            for(int i = 1; i <= num; i++){
                 LlenarLista(i);
            }
            Mostrar();
        
        }
        

    }//GEN-LAST:event_btn_IniciarActionPerformed
    // Boton de A a B
    private void btn_AaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AaBActionPerformed
       
        if("".equals(this.txt_NoElementos.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el numero de elementos que desea usar.");
        }
        else{
            opc = 1;
            Limpiar();
            Verificar(opc);
            Mostrar();
        }
    }//GEN-LAST:event_btn_AaBActionPerformed
    // Boton de A a C
    private void btn_AaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AaCActionPerformed
        if("".equals(this.txt_NoElementos.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el numero de elementos que desea usar.");
        }
        else{
            opc = 2;
            Limpiar();
            Verificar(opc);
            Mostrar();
        }
    }//GEN-LAST:event_btn_AaCActionPerformed
    // Boton de  B a C
    private void btn_BaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BaCActionPerformed

        if("".equals(this.txt_NoElementos.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el numero de elementos que desea usar.");
        }
        else{
            opc = 3;
            Limpiar();
            Verificar(opc);
            Mostrar();
        }
        
    }//GEN-LAST:event_btn_BaCActionPerformed
    // Boton de B a A
    private void btn_BaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BaAActionPerformed
        if("".equals(this.txt_NoElementos.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el numero de elementos que desea usar.");
        }
        else{
            opc = 4;
            Limpiar();
            Verificar(opc);
            Mostrar();
        }
    }//GEN-LAST:event_btn_BaAActionPerformed
    // Boton de C a A
    private void btn_CaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CaAActionPerformed
        if("".equals(this.txt_NoElementos.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el numero de elementos que desea usar.");
        }
        else{
            opc = 6;
            Limpiar();
            Verificar(opc);
            Mostrar();
        }
    }//GEN-LAST:event_btn_CaAActionPerformed

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
            java.util.logging.Logger.getLogger(TorresDeHanoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TorresDeHanoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TorresDeHanoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TorresDeHanoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TorresDeHanoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAux;
    private javax.swing.JTable TablaFinal;
    private javax.swing.JTable TablaInicial;
    private javax.swing.JButton btn_AaB;
    private javax.swing.JButton btn_AaC;
    private javax.swing.JButton btn_BaA;
    private javax.swing.JButton btn_BaC;
    private javax.swing.JButton btn_CaA;
    private javax.swing.JButton btn_CaB;
    private javax.swing.JButton btn_Iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_MovRealizado;
    private javax.swing.JLabel lbl_MovTotal;
    private javax.swing.JTextField txt_NoElementos;
    // End of variables declaration//GEN-END:variables
}
