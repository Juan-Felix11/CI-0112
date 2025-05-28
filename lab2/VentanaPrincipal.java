/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab2;

/**
 *
 * @author Juan Félix
 */
//Imports 
import java.io.FileWriter;
import java.io.IOException; 
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
public class VentanaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());

    //Se crea una ventana principal JFrame
    public VentanaPrincipal() {
        initComponents();
        
        //La tuve que poner aca, por que si la metia dentro de la funcion del menu, se tenia que tocar 2 veces 
         itemSalir.addActionListener(e -> System.exit(0));
         
         //Acción del boton Guardar, solo funciona si se selecciona un usuario y el checkbox de los terminos y condiciones estan clickados 
         botonGuardar.addActionListener(e -> {
         if (tipoUsuario.getSelectedIndex() !=0 && terminosCondiciones.isSelected()){
             guardarDatos();    
         } else {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de usuario válido, completar todos los campos y aceptar los términos y condiciones.");
    }
               
         });
         
         
         //Llama a la accion silenciosa del boton Limpiar 
         botonLimpiar.addActionListener(e -> {
        limpiarCampos();

        });
         
         //Cargar datos al iniciar 
         cargarUsuario();
                 
    }
    
    //Método para guardar datos 
    private void guardarDatos(){
        //Valida que las casillas donde se escriben los datos del usuario estan llenos y ninguna vacía
        if (campoNombre.getText().trim().isEmpty() || campoEmail.getText().trim().isEmpty() || campoTelefono.getText().trim().isEmpty() || tipoUsuario.getSelectedItem() == null){
            
            //muestra un mensaje, ya que algun campo este vacío vacios 
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos anteriores antes de guardar . " , "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return; //No guarda 
        }
         
        //Se verifica que el email ingresado sea valido (que contenga @ y .)
        String email = campoEmail.getText().trim();
        if (!email.contains("@") || !email.contains(".")){
            JOptionPane.showMessageDialog(this, "El email no es válido. ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Guarda los datos en un archivo de texto que se llama usurario.txt 
        //Se utiliza los buffered para que sea mas rápido 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuario.txt"))){
            writer.write(campoNombre.getText().trim() + "," + campoEmail.getText().trim() + "," + campoTelefono.getText().trim() + "," + tipoUsuario.getSelectedItem().toString());
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente. ");
        } catch (IOException e){
            //En caso de no guardarse, se lanza el mensaje de error 
            JOptionPane.showMessageDialog(this, "Error al guardar", "Error", JOptionPane.ERROR_MESSAGE);
        }          
    }
    //Carga los datos, si los hay
    //Primero verifica si existe el archivo y lee su primera linea, luego divide la linea en columnas separas por "," y rellena los campos con esos datos 
    private void cargarUsuario(){
        File archivo = new File("usuario.txt");
        if (archivo.exists()){
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))){
                String linea = reader.readLine();
                if (linea != null ){
                    String[] partes = linea.split(",");
                    if (partes.length ==4){
                        campoNombre.setText(partes[0]);
                        campoEmail.setText(partes[1]);
                        campoTelefono.setText(partes[2]);
                        tipoUsuario.setSelectedItem(partes[3]);
                    }
                }
            } catch (IOException e){
                //Si se cae y no se cargan los datos lanza un mensaje 
                JOptionPane.showMessageDialog(this, "Error al cargar los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
        
        //método que utiliza el boton limpiar 
        private void limpiarCampos(){
        campoNombre.setText("");
        campoEmail.setText("");
        campoTelefono.setText("");
        tipoUsuario.setSelectedIndex(0);
        terminosCondiciones.setSelected(false);
}
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFormulario = new javax.swing.JPanel();
        tipoUsuario = new javax.swing.JComboBox<>();
        botonGuardar = new javax.swing.JButton();
        terminosCondiciones = new javax.swing.JCheckBox();
        botonLimpiar = new javax.swing.JButton();
        campoEmail = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        etiquetaTelefono = new javax.swing.JLabel();
        etiquetaEmail = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        etiquetaDeTipoUsuario = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        ArchivoMenu = new javax.swing.JMenu();
        itemNuevo = new javax.swing.JMenuItem();
        itemGuardar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione: ", "Cliente", "Empleado", "Administrador", " " }));
        tipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoUsuarioActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        terminosCondiciones.setText("Acepte los términos y condiciones para poder registrarse en el problema. ");
        terminosCondiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminosCondicionesActionPerformed(evt);
            }
        });

        botonLimpiar.setText("Limpiar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
            }
        });

        campoTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelefonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addComponent(tipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(terminosCondiciones)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(terminosCondiciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        etiquetaTelefono.setText("Teléfono: ");

        etiquetaEmail.setText("Email: ");

        etiquetaNombre.setText("Nombre: ");

        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });

        etiquetaDeTipoUsuario.setText("Tipo de Usuario: ");

        ArchivoMenu.setText("Archivo");

        itemNuevo.setText("Nuevo");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        ArchivoMenu.add(itemNuevo);

        itemGuardar.setText("Guardar");
        ArchivoMenu.add(itemGuardar);

        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        ArchivoMenu.add(itemSalir);

        menuBar.add(ArchivoMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(etiquetaNombre)
                        .addGap(129, 129, 129)
                        .addComponent(etiquetaDeTipoUsuario)
                        .addGap(162, 162, 162)
                        .addComponent(etiquetaEmail)
                        .addGap(143, 143, 143)
                        .addComponent(etiquetaTelefono)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaEmail)
                    .addComponent(etiquetaNombre)
                    .addComponent(etiquetaDeTipoUsuario))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_itemSalirActionPerformed

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:}
        
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void campoTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTelefonoActionPerformed

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailActionPerformed

    private void tipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoUsuarioActionPerformed

    private void terminosCondicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminosCondicionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_terminosCondicionesActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonLimpiarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ArchivoMenu;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JLabel etiquetaDeTipoUsuario;
    private javax.swing.JLabel etiquetaEmail;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaTelefono;
    private javax.swing.JMenuItem itemGuardar;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JCheckBox terminosCondiciones;
    private javax.swing.JComboBox<String> tipoUsuario;
    // End of variables declaration//GEN-END:variables
}
