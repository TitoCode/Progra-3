package listaslibro;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Carlos Augusto Rodas Guerra
 * 0901-17-963
 */
public class Menu extends javax.swing.JFrame {

    DefaultTableModel Modelo = new DefaultTableModel();
    Nodo cabeza = null;
    int contLista = 0;
    //Metodo que limpia la tabla
    public void Limpiar(){
        while (Modelo.getRowCount() > 0) {
               Modelo.removeRow(0);
        }
    }
    
     public static boolean EsNumero(String Posicion) {
        boolean resultado;
        try {
            Integer.parseInt(Posicion);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
    
    public void Ingresar(){
        
        Limpiar();
        int opc = cb_Ingresar.getSelectedIndex();
        
        switch(opc){
            // En este case se llama al metodo de ingreso al principio de la lista
            case 0:{ 
                String StrTitulo, StrAutor, StrISBN;
                StrTitulo = this.txt_Titulo.getText();
                StrAutor = this.txt_Autor.getText();
                StrISBN = this.txt_ISBN.getText();        
                Libro Nuevo = new Libro(StrTitulo, StrAutor, StrISBN);      
                insertarPrincipio(Nuevo);
        
            }break;//fin case 0
            // En este case se llama al metodo de ingreso al final de la lista
            case 1:{
                String StrTitulo, StrAutor, StrISBN;
                StrTitulo = this.txt_Titulo.getText();
                StrAutor = this.txt_Autor.getText();
                StrISBN = this.txt_ISBN.getText();        
                Libro Nuevo = new Libro(StrTitulo, StrAutor, StrISBN);      
                insertarFinal(Nuevo);
            
            }break;//fin case 1
            // En este case se llama al metodo de ingreso despus del nodo especificado
            case 2:{
                int posicion;
                String StrTitulo, StrAutor, StrISBN, StrPosicion;
                StrTitulo = this.txt_Titulo.getText();
                StrAutor = this.txt_Autor.getText();
                StrISBN = this.txt_ISBN.getText();
                StrPosicion = this.txt_Nodo.getText();
                Libro Nuevo = new Libro(StrTitulo, StrAutor, StrISBN);      
                insertarFinal(Nuevo);
                boolean EsNumero = EsNumero(StrPosicion); 
                if (EsNumero==true) { //
                    posicion = Integer.parseInt(StrPosicion);
                    insertarDespues(posicion, Nuevo);
                }       
                else{
                    JOptionPane.showMessageDialog(rootPane, "Ingrese Un Número Válido", "ERROR", HEIGHT);
                }   
            }break;//fin case 2
            
        }//fin switch
        JOptionPane.showMessageDialog(null, "Datos Ingresados Correctamente");
        Mostrar();
    }
    
    public void Borrar(){
        
        Limpiar();
        int opc = cb_Ingresar.getSelectedIndex();
        
        switch (opc){
            //En este case borra el primer dato de la lista simplemente llamndo al metodo correspondiente.
            case 0:{eliminarPrincipio();}break;// fin case 0
            
            //En este case se borra el ultimo dato de la lista simplemente llamndo al metodo correspondiente.
            case 1:{eliminarUltimo();}break;//fin case 1
            
            //En este Case se borra el numero de nodo ingresado simplemente llamndo al metodo correspondiente.
            case 2:{
            String StrPosicion;
            StrPosicion = this.txt_Nodo.getText();
            int IntPosicion;
            boolean EsNumero = EsNumero(StrPosicion);
            if (EsNumero==true) {
                IntPosicion = Integer.parseInt(StrPosicion);
                eliminarLibro(IntPosicion);
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Ingrese Un Número Válido", "ERROR", HEIGHT);
            }        
            }break;//fin case 2
        }//fin switch
        Mostrar();
    }
    
    //Metodo que recorre la Lista e ingresa los datos en la tabla.
    public void Mostrar(){
                String Data[] = new String[4];
                int Contador = 0;
		Nodo aux=cabeza;
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
    public Menu() {
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
        btn_Mostrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        cb_Ingresar = new javax.swing.JComboBox<>();
        cb_Borrar = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_Nodo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Título del Libro: ");

        jLabel2.setText("Nombre del Autor: ");

        jLabel3.setText("ISBN:");

        btn_Ingresar.setText("Ingresar");
        btn_Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IngresarActionPerformed(evt);
            }
        });

        btn_Borrar.setText("Borrar");
        btn_Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BorrarActionPerformed(evt);
            }
        });

        btn_Mostrar.setText("Mostrar");
        btn_Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MostrarActionPerformed(evt);
            }
        });

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tabla);

        cb_Ingresar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agregar al Principio", "Agregar al Final", "Agregar Despues de", " " }));

        cb_Borrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Borrar Primero", "Borrar Ultimo", "Borrar por Posicion" }));

        jLabel4.setText("No.Nodo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Autor)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_Mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Ingresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_Ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Nodo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_Borrar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Ingresar)
                    .addComponent(cb_Ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Borrar)
                    .addComponent(cb_Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Mostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_Nodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IngresarActionPerformed
        Ingresar();
    }//GEN-LAST:event_btn_IngresarActionPerformed

    private void btn_MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MostrarActionPerformed
        Mostrar();
    }//GEN-LAST:event_btn_MostrarActionPerformed

    private void btn_BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BorrarActionPerformed
        Borrar();
    }//GEN-LAST:event_btn_BorrarActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    public void insertarPrincipio(Libro libro) {
		Nodo Nuevo =new Nodo(libro);
		Nuevo.siguiente=cabeza;
		cabeza=Nuevo;
		contLista++;	
	}
    public void insertarFinal(Libro libro) {
		Nodo nodo=new Nodo(libro);
		if (cabeza==null){
                    cabeza=nodo;
		}else{
                    Nodo puntero=cabeza;
                    while (puntero.siguiente!=null) {
                        puntero=puntero.siguiente;
                    }
                    puntero.siguiente=nodo;
		}
		contLista++;
	}
    public void insertarDespues(int n, Libro libro) {
		Nodo Nuevo =new Nodo(libro);
		if (cabeza==null) {
			cabeza=Nuevo;
		} else {
			Nodo puntero=cabeza;
			int contador=0;
			while (contador<n && puntero.siguiente!=null) {
				puntero=puntero.siguiente;
				contador++;
			}
			Nuevo.siguiente=puntero.siguiente;
			puntero.siguiente=Nuevo;
		}
		contLista++;
	}
    public Libro obtener(int n) {
		if (cabeza==null) {
			return null;
		} 
                else {
                    Nodo puntero=cabeza;
                    int contador=0;
                    while (contador<n && puntero.siguiente!=null) {
                       	puntero=puntero.siguiente;
                    	contador++;
			}
			if (contador!=n) {
                            return null;
			} 
                        else {
                            return puntero.libro;
			}
		}
	}
    public void eliminarPrincipio() {
            cabeza=cabeza.siguiente;
        }
    public void eliminarUltimo() {
            if (cabeza!= null) {
                if (cabeza.siguiente==null) {
                    cabeza=null;  
                    contLista--;
                } else {
                    Nodo puntero=cabeza;
                    while (puntero.siguiente.siguiente!=null) {                    
                        puntero=puntero.siguiente;
                    }
                    puntero.siguiente=null;
                    contLista--;
                }
            }
        }
    public void eliminarLibro(int n) {
            if (cabeza!=null){
                if (n==0){
                    Nodo primer=cabeza;
                    cabeza=cabeza.siguiente;
                    primer.siguiente=null;
                    contLista--;
                } else if (n<contLista) {
                    Nodo puntero=cabeza;
                    int contador=1;
                    while (contador<(n-1)){
                        puntero=puntero.siguiente;
                        contador++;
                    }
                    Nodo temp=puntero.siguiente;
                    puntero.siguiente=temp.siguiente;
                    temp.siguiente=null;
                    contLista--;
                }
            }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btn_Borrar;
    private javax.swing.JButton btn_Ingresar;
    private javax.swing.JButton btn_Mostrar;
    private javax.swing.JComboBox<String> cb_Borrar;
    private javax.swing.JComboBox<String> cb_Ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_Autor;
    private javax.swing.JTextField txt_ISBN;
    private javax.swing.JTextField txt_Nodo;
    private javax.swing.JTextField txt_Titulo;
    // End of variables declaration//GEN-END:variables
}
