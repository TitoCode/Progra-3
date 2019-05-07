
/**
 *  Carlos Augusto Rodas Guerra
 *  0901-17-963
 */


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Pilas extends javax.swing.JFrame {
    
    DefaultTableModel Modelo = new DefaultTableModel();
    Nodo cima = null;
    int contLista = 0;
    boolean ListaCreada = false;
    
    //Metodo que vacia ("Limpia") la tabla
    public void Limpiar(){
        while (Modelo.getRowCount() > 0) {
               Modelo.removeRow(0);
        }
    }
    //El metodo ingresar los datos a la lista obteniendo los datos ingresados y pasa los parametros a la funcion InsertarPrincipio
    //que utiliza la clase Libro
    public void Ingresar(){
        
        String StrTitulo, StrAutor, StrISBN;
        StrTitulo = this.txt_Titulo.getText();
        StrAutor = this.txt_Autor.getText();
        StrISBN = this.txt_ISBN.getText();        
        Libro Nuevo = new Libro(StrTitulo, StrAutor, StrISBN);      
        InsertarFinal(Nuevo);
        
    }
    //Metodo InsertarPrincipio es llamado en Metodo Ingresar para agregar datos a la lista.
    public void InsertarFinal(Libro libro) {
		Nodo nodo=new Nodo(libro);
		if (cima==null){
                    cima=nodo;
		}else{
                    Nodo puntero=cima;
                    while (puntero.siguiente!=null) {
                        puntero=puntero.siguiente;
                    }
                    puntero.siguiente=nodo;
		}
		contLista++;
	}
    //Metodo Borrar elimina la cima de la pila.
    public void Borrar(){
        
        if (cima!= null) {
                if (cima.siguiente==null) {
                    cima=null;  
                    contLista--;
                } else {
                    Nodo puntero=cima;
                    while (puntero.siguiente.siguiente!=null) {                    
                        puntero=puntero.siguiente;
                    }
                    puntero.siguiente=null;
                    contLista--;
                }
            } 
        
    }
    //Metodo Mostrar agrega los datos en la lista a la tabla
    public void Mostrar(){
        
         String Data[] = new String[4];
        int Contador = 0;
        Nodo aux=cima;
        while (aux!=null){
        Data[0]= String.valueOf(Contador);
        Data[1]= String.valueOf(aux.libro.titulo);
        Data[2]= String.valueOf(aux.libro.autor);
        Data[3]= String.valueOf(aux.libro.isbn);
        Modelo.addRow(Data);
        aux=aux.siguiente;
        Contador += 1;
		}
    }
    //Metodo Top Muestra la cima de la Pila
    public void Top(){
        
        String Data[] = new String[4];
         int Contador = 0;
		Nodo aux=cima;
		while (Contador != contLista){
                    Data[0]= String.valueOf(Contador);
                    Data[1]= String.valueOf(aux.libro.titulo);
                    Data[2]= String.valueOf(aux.libro.autor);
                    Data[3]= String.valueOf(aux.libro.isbn);
                    aux=aux.siguiente;
                    Contador += 1;
		}
                 Modelo.addRow(Data);
        
    }
    
    public Pilas() {
        initComponents();
        
        this.Tabla.setModel(Modelo);
        Modelo.addColumn("No. Nodo");
        Modelo.addColumn("Título del Libro");
        Modelo.addColumn("Nombre del Autor");
        Modelo.addColumn("ISBN");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_Titulo = new javax.swing.JTextField();
        txt_Autor = new javax.swing.JTextField();
        txt_ISBN = new javax.swing.JTextField();
        btn_Ingresar = new javax.swing.JButton();
        btn_Borrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        btn_Top = new javax.swing.JButton();
        btn_Mostrar = new javax.swing.JButton();
        btn_Vacia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Titulo del Libro:");

        jLabel2.setText("Nombre del Autor: ");

        jLabel3.setText("ISBN: ");

        btn_Ingresar.setText("Ingresar");
        btn_Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IngresarActionPerformed(evt);
            }
        });

        btn_Borrar.setText("Borrar Cima");
        btn_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BorrarActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        btn_Top.setText("Top");
        btn_Top.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TopActionPerformed(evt);
            }
        });

        btn_Mostrar.setText("Mostrar");
        btn_Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MostrarActionPerformed(evt);
            }
        });

        btn_Vacia.setText("Verificar Lista vacia");
        btn_Vacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VaciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_Autor)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_ISBN))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_Ingresar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_Borrar))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_Vacia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Top)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Mostrar)
                        .addGap(147, 147, 147))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Ingresar)
                    .addComponent(btn_Borrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Top)
                    .addComponent(btn_Mostrar)
                    .addComponent(btn_Vacia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton para ingresar datos
    private void btn_IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IngresarActionPerformed
        Limpiar();
        Ingresar();
        Mostrar();
    }//GEN-LAST:event_btn_IngresarActionPerformed
    //Boton Borrar
    private void btn_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BorrarActionPerformed
        Limpiar();
        Borrar();
        Mostrar();
    }//GEN-LAST:event_btn_BorrarActionPerformed
    //Boton Top
    private void btn_TopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TopActionPerformed
        Limpiar();
        Top();
    }//GEN-LAST:event_btn_TopActionPerformed
    //Boton Mostrar
    private void btn_MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MostrarActionPerformed
        Limpiar();
        Mostrar();
    }//GEN-LAST:event_btn_MostrarActionPerformed
    //Boton Verificar lista vacia
    private void btn_VaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VaciaActionPerformed
        if(cima == null){JOptionPane.showMessageDialog(null,"La lista se encuentra vacia.");}
        else{JOptionPane.showMessageDialog(null,"La lista contiene dato/s.");}
    }//GEN-LAST:event_btn_VaciaActionPerformed

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
            java.util.logging.Logger.getLogger(Pilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pilas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pilas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btn_Borrar;
    private javax.swing.JButton btn_Ingresar;
    private javax.swing.JButton btn_Mostrar;
    private javax.swing.JButton btn_Top;
    private javax.swing.JButton btn_Vacia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_Autor;
    private javax.swing.JTextField txt_ISBN;
    private javax.swing.JTextField txt_Titulo;
    // End of variables declaration//GEN-END:variables
}
