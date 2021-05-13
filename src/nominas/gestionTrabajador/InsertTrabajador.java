package nominas.gestionTrabajador;

import nominas.menus.MenuAdministrador;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

import static nominas.conexion.db.*;
import nominas.objetos.Usuario;

public final class InsertTrabajador extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public InsertTrabajador() {
        initComponents();
        this.conn = getConnection();
        posicionar();
        fechaActual();
        logeadoComo();
    }
    
    public void logeadoComo() {
        nombreUsuario.setText(String.valueOf(Usuario.nombreUsuario));
    }

    public void vaciarCampo() {
        nif.setText("");
        nombre.setText("");
        primerApellido.setText("");
        segundoApellido.setText("");
        puesto.setText("");
        hijos.setText("");
        antiguedad.setText("");
        numeroAfiliacion.setText("");
        grupoCotizacion.setText("");
        idConvenio.setText("");
    }

    public void posicionar() {
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    //Método para poner fecha y hora en la barra.
    public void fechaActual() {
        Calendar cal = new GregorianCalendar();
        int mes = cal.get(Calendar.MONTH) + 1;
        int ano = cal.get(Calendar.YEAR);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        String diaS = null;
        String mesS = null;
        if (dia < 10) {
            diaS = ("0" + dia);
        } else {
            diaS = Integer.toString(dia);
        }
        if (mes < 10) {
            mesS = ("0" + mes);
        } else {
            mesS = Integer.toString(mes);
        }

        fecha.setText(diaS + "-" + (mesS) + "-" + ano);

        int minuto = cal.get(Calendar.MINUTE);
        int time = cal.get(Calendar.HOUR_OF_DAY);
        String minutoS = null;
        String horaS = null;
        if (minuto < 10) {
            minutoS = ("0" + minuto);
        } else {
            minutoS = Integer.toString(minuto);
        }
        if (time < 10) {
            horaS = ("0" + time);
        } else {
            horaS = Integer.toString(time);
        }
        hora.setText(horaS + ":" + minutoS);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        hijos = new javax.swing.JTextField();
        antiguedad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        puesto = new javax.swing.JTextField();
        numeroAfiliacion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        grupoCotizacion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        idConvenio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        nif = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        segundoApellido = new javax.swing.JTextField();
        primerApellido = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        fecha = new javax.swing.JMenu();
        hora = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NOMINAS");

        jPanel1.setLayout(null);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hijos");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(90, 140, 30, 30);
        jPanel1.add(hijos);
        hijos.setBounds(130, 140, 160, 30);
        jPanel1.add(antiguedad);
        antiguedad.setBounds(130, 200, 160, 30);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Antigüedad");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 200, 70, 30);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NIF");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(90, 20, 30, 30);
        jPanel1.add(puesto);
        puesto.setBounds(130, 170, 160, 30);
        jPanel1.add(numeroAfiliacion);
        numeroAfiliacion.setBounds(130, 230, 160, 30);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Numero de Afiliación");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 230, 110, 30);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Grupo de Cotización");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 260, 110, 30);
        jPanel1.add(grupoCotizacion);
        grupoCotizacion.setBounds(130, 260, 160, 30);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Puesto");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(80, 170, 50, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 50, 60, 30);
        jPanel1.add(nombre);
        nombre.setBounds(130, 50, 160, 30);
        jPanel1.add(idConvenio);
        idConvenio.setBounds(130, 290, 160, 30);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Id del Convenio");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(40, 290, 90, 30);

        nif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nifActionPerformed(evt);
            }
        });
        jPanel1.add(nif);
        nif.setBounds(130, 20, 160, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Primer Apellido");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 80, 90, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Segundo Apellido");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 110, 100, 30);
        jPanel1.add(segundoApellido);
        segundoApellido.setBounds(130, 110, 160, 30);

        primerApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primerApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(primerApellido);
        primerApellido.setBounds(130, 80, 160, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/Save-icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(260, 330, 30, 25);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/erase-128.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 10, 20, 20);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Logeado como:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(520, 350, 100, 20);

        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setText("nombreUsuario");
        jPanel1.add(nombreUsuario);
        nombreUsuario.setBounds(610, 350, 80, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/fondo.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 700, 380);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        fecha.setText("Fecha");
        jMenuBar1.add(fecha);

        hora.setText("Hora");
        jMenuBar1.add(hora);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nifActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Estas seguro/a de guardar este nuevo trabajador?", "Añadir trabajador", JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            try {
                String insert = "INSERT INTO Trabajador("
                        + "NIF, nombreTrabajador, primerApellido, segundoApellido,"
                        + "numeroAfiliacion, puesto, hijos, grupoCotizacion, fechaAntiguedad ,idConvenio) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                this.pst = this.conn.prepareStatement(insert);
                pst.setString(1, nif.getText());
                pst.setString(2, nombre.getText());
                pst.setString(3, primerApellido.getText());
                pst.setString(4, segundoApellido.getText());
                pst.setString(5, numeroAfiliacion.getText());
                pst.setString(6, puesto.getText());
                pst.setString(7, hijos.getText());
                pst.setString(8, grupoCotizacion.getText());
                //java.util.Date fecha = new java.util.Date(antiguedad.getText());
                //Timestamp fechaAntiguedadD = new Timestamp(fecha.getTime());            
                pst.setString(9, antiguedad.getText());
                pst.setString(10, idConvenio.getText());

                this.pst.execute();
                JOptionPane.showMessageDialog(null, "Trabajador añadido correctamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    close(pst);
                    vaciarCampo();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else {
            vaciarCampo();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MenuAdministrador menu = new MenuAdministrador();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void primerApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primerApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_primerApellidoActionPerformed

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
            java.util.logging.Logger.getLogger(InsertTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertTrabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField antiguedad;
    private javax.swing.JMenu fecha;
    private javax.swing.JTextField grupoCotizacion;
    private javax.swing.JTextField hijos;
    private javax.swing.JMenu hora;
    private javax.swing.JTextField idConvenio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nif;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombreUsuario;
    private javax.swing.JTextField numeroAfiliacion;
    private javax.swing.JTextField primerApellido;
    private javax.swing.JTextField puesto;
    private javax.swing.JTextField segundoApellido;
    // End of variables declaration//GEN-END:variables
}
