/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import Controlador.ConexionMySQL;
import Controlador.ControladorSQL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * La clase ActualizarDatosDiag representa una ventana de diálogo para actualizar datos
 * de una tabla en una base de datos. Permite al usuario editar los registros de la tabla
 * y guardar los cambios en la base de datos.
 * 
 * Esta ventana se utiliza para mostrar y actualizar datos de una tabla seleccionada.
 * Utiliza un ControladorSQL para interactuar con la base de datos y un DefaultTableModel
 * para mostrar y editar los datos en una tabla de interfaz gráfica.
 * 
 * @author franr
 */
public class ActualizarDatosDiag extends javax.swing.JDialog {
    
    private DefaultTableModel modeloDatos = new DefaultTableModel();
    private ControladorSQL cn = new ControladorSQL();
    private String tablaElegida;
     /**
     * Constructor de la clase ActualizarDatosDiag.
     * 
     * @param parent El marco principal de la aplicación.
     * @param modal Un indicador booleano que determina si el diálogo es modal o no.
     * @param nombresColumnas Una cadena con los nombres de las columnas de la tabla.
     * @param tablaElegida El nombre de la tabla que se actualizará.
     * @throws SQLException En caso de errores al conectar o cargar datos desde la base de datos.
     */
    public ActualizarDatosDiag(java.awt.Frame parent, boolean modal,String nombresColumnas,String tablaElegida) throws SQLException {
        super(parent, modal);
        this.tablaElegida = tablaElegida;
        initComponents();
        setResizable(false);
        String[] cadenaNombresColumnas = nombresColumnas.split(",");
        rellenarColumnasTabla(cadenaNombresColumnas);
        modeloDatos = cn.cargarDatos(tablaElegida,modeloDatos);;
        tblDatos.setModel(modeloDatos);
    }

    /**
     * Llena las columnas del modelo de tabla con los nombres de columnas proporcionados.
     * 
     * @param cadenaNombresColumnas Un arreglo de cadenas con los nombres de las columnas.
     */
    public void rellenarColumnasTabla(String[] cadenaNombresColumnas) {
        modeloDatos.setRowCount(0);
        modeloDatos.setColumnCount(0);
        for(int i = 0; i<cadenaNombresColumnas.length; i++){
            modeloDatos.addColumn("Columna"+i);
        }
        modeloDatos.setColumnIdentifiers(cadenaNombresColumnas);
    }

    
    
    // Definiciones de componentes visuales y eventos se generan automáticamente.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDatos);

        btnAceptar.setText("Aceptar");
        btnAceptar.setActionCommand("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de hacer clic en el botón "Aceptar". Actualiza los datos de la tabla
     * en la base de datos y recarga los datos en la tabla de interfaz gráfica.
     * 
     * @param evt Evento de acción que desencadena el clic en el botón "Aceptar".
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            cn.actualizarDatos(modeloDatos, tablaElegida);
            modeloDatos = cn.cargarDatos(tablaElegida, modeloDatos);
            tblDatos.setModel(modeloDatos);
        } catch (SQLException ex) {
            Logger.getLogger(ActualizarDatosDiag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
