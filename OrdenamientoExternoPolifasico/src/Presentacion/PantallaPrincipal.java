/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author ariel
 */
import Logica.*;
import com.csvreader.CsvReader;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
public class PantallaPrincipal extends javax.swing.JFrame {
    private static String ruta=null;
    Polifasico ordPolifasico;
    String cabecera = null;
    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
//     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label4 = new java.awt.Label();
        jComboBox1 = new javax.swing.JComboBox<>();
        Ordenar = new javax.swing.JButton();
        Ruta = new javax.swing.JButton();
        textoarchivo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ordenamiento Polifasico");
        setBackground(new java.awt.Color(102, 102, 102));
        setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        setForeground(new java.awt.Color(102, 102, 102));

        label1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        label1.setText("Algoritmo de Ordenamiento Externo");

        label2.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        label2.setText("        Intercalacion Polifasica");

        label4.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        label4.setText("Campo de ordenamiento:");

        jComboBox1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enteros", "String", "Booleano", "Fecha" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        Ordenar.setBackground(new java.awt.Color(255, 255, 255));
        Ordenar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Ordenar.setText("Ordenar");
        Ordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenarActionPerformed(evt);
            }
        });

        Ruta.setBackground(new java.awt.Color(255, 255, 255));
        Ruta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Ruta.setText("Buscar Archivo");
        Ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RutaActionPerformed(evt);
            }
        });

        textoarchivo.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        textoarchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoarchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(Ruta)
                        .addGap(54, 54, 54)
                        .addComponent(textoarchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(Ordenar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoarchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addComponent(Ordenar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
   private void ManejoCabecerasSCV(int caso, File file) throws FileNotFoundException, IOException
    {
        if(caso ==0)
        {
            file.renameTo(new File(file.getParent() + "\\" + "copA111341520.csv"));
            
            PrintWriter archS = new PrintWriter(new File(file.getParent() + "\\" + file.getName()));
            CsvReader lect = new CsvReader(file.getParent() + "\\" + "copA111341520.csv");
            
            if(lect.readHeaders())
                this.cabecera = lect.getRawRecord();
            
            if(this.cabecera.indexOf("campo1")!=-1&&this.cabecera.indexOf("campo2")!=-1&&this.cabecera.indexOf("campo3")!=-1&&this.cabecera.indexOf("campo4")!=-1){}
            else
            {
                this.cabecera = null;
                archS.println(lect.getRawRecord());
            } 
                
            while(lect.readRecord()){
                archS.println(lect.getRawRecord());
            }
            archS.close();
            lect.close();
            new File(file.getParent() + "\\" + "copA111341520.csv").delete();
        }   
        
    }
   

    private void OrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenarActionPerformed
          //primero validamos que los campos esten llenos y que esten bien ingresados
        if(textoarchivo.getText().length()==0 ){
            JOptionPane.showMessageDialog(null, "Primero seleccione la ruta del archivo a ordenar");
        }else{
           try{
             File file = new File(textoarchivo.getText());
              int campo =-1;
        if(jComboBox1.getSelectedItem().equals("Enteros")){
             campo = 0;
        }
           
        else if(jComboBox1.getSelectedItem().equals("String")){
             campo = 1;
        }
           
        else if(jComboBox1.getSelectedItem().equals("Booleano")){
            campo = 2;
        }
        else if(jComboBox1.getSelectedItem().equals("Fecha")){
            campo = 3;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error, seleccione el campo sobre el cual se va a hacer\nel ordenamiento.", "Error al procesar", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
               this.ManejoCabecerasSCV(0, file);
               double tinicio = (double) System.currentTimeMillis();
                new Polifasico().Ordenar(campo, textoarchivo.getText());
                double tfin = (double) System.currentTimeMillis();
                double tEjecucion = tfin - tinicio;
                JOptionPane.showMessageDialog(null, "El archivo se ordeno en: "+tEjecucion+" milisegundos");
                 Desktop.getDesktop().open(file);
           }catch(Exception e){
               
           }
        }
    }//GEN-LAST:event_OrdenarActionPerformed

    private void RutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RutaActionPerformed
      JFileChooser ventanaBusqueda = new JFileChooser();//Objeto ventana de busqueda
        ventanaBusqueda.setFileSelectionMode(JFileChooser.FILES_ONLY);//Tipo de busqueda
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".CSV", "CSV");
        ventanaBusqueda.setFileFilter(filter);//Extenciones
        //ventanaBusqueda.setMultiSelectionEnabled(true);//Seleccionar varios archivos
        int returnVal = ventanaBusqueda.showOpenDialog(null);//Condicional de aceptacion seleccion
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File archivo = ventanaBusqueda.getSelectedFile();
            ruta = archivo.getAbsolutePath();
            textoarchivo.setText(ruta);
        }        
    }//GEN-LAST:event_RutaActionPerformed

    private void textoarchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoarchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoarchivoActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new PantallaPrincipal().setVisible(true);
          }
       });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ordenar;
    private javax.swing.JButton Ruta;
    private javax.swing.JComboBox<String> jComboBox1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label4;
    private javax.swing.JTextField textoarchivo;
    // End of variables declaration//GEN-END:variables
}