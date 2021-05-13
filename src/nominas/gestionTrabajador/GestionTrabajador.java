package nominas.gestionTrabajador;

import nominas.objetos.Trabajador;
import nominas.menus.MenuAdministrador;
import static nominas.conexion.db.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import static nominas.conexion.db.*;
import java.text.Normalizer;
import nominas.objetos.Usuario;

public class GestionTrabajador extends javax.swing.JFrame {

    //Atributos de la clase
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //Constructor de la clase
    public GestionTrabajador() {
        initComponents();
        this.conn = getConnection();
        posicionar();
        fechaActual();
        logeadoComo();
    }
    
    public void logeadoComo() {
        nombreUsuario.setText(String.valueOf(Usuario.nombreUsuario));
    }

    //Metodo para posicionar la ventana en medio de la pantalla
    public void posicionar() {
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    //Metodo para vaciar los campos de la ventana
    public void vaciarCampo() {
        nif.setText("");
        nombre1.setText("");
        primerApellido1.setText("");
        segundoApellido1.setText("");
        puesto1.setText("");
        hijos.setText("");
        antiguedad1.setText("");
        numeroAfiliacion1.setText("");
        grupoCotizacion1.setText("");
        idConvenio1.setText("");
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
        fecha.setText(horaS + ":" + minutoS);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hijos = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        nombre1 = new javax.swing.JTextField();
        idConvenio1 = new javax.swing.JTextField();
        segundoApellido1 = new javax.swing.JTextField();
        grupoCotizacion1 = new javax.swing.JTextField();
        antiguedad1 = new javax.swing.JTextField();
        numeroAfiliacion1 = new javax.swing.JTextField();
        puesto1 = new javax.swing.JTextField();
        primerApellido1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nif = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        fecha = new javax.swing.JMenu();
        hora = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NOMINAS");

        jPanel1.setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hijos");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 210, 34, 30);
        jPanel1.add(hijos);
        hijos.setBounds(130, 210, 100, 30);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/attachment-512.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(330, 40, 30, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/update icon.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(290, 40, 30, 30);

        nombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre1ActionPerformed(evt);
            }
        });
        jPanel1.add(nombre1);
        nombre1.setBounds(130, 90, 100, 30);
        jPanel1.add(idConvenio1);
        idConvenio1.setBounds(130, 330, 100, 30);
        jPanel1.add(segundoApellido1);
        segundoApellido1.setBounds(130, 150, 100, 30);
        jPanel1.add(grupoCotizacion1);
        grupoCotizacion1.setBounds(130, 300, 100, 30);
        jPanel1.add(antiguedad1);
        antiguedad1.setBounds(130, 240, 100, 30);
        jPanel1.add(numeroAfiliacion1);
        numeroAfiliacion1.setBounds(130, 270, 100, 30);
        jPanel1.add(puesto1);
        puesto1.setBounds(130, 180, 100, 30);

        primerApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primerApellido1ActionPerformed(evt);
            }
        });
        jPanel1.add(primerApellido1);
        primerApellido1.setBounds(130, 120, 100, 30);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/delete_16x16.gif"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(250, 40, 30, 30);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Id del Convenio");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(40, 330, 90, 30);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Grupo de Cotización");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 300, 110, 30);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Numero de Afiliación");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 270, 110, 30);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Antigüedad");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 240, 70, 30);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Puesto");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(70, 180, 50, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Primer Apellido");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 120, 90, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Segundo Apellido");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 150, 100, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 90, 50, 30);

        nif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nifActionPerformed(evt);
            }
        });
        nif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nifKeyReleased(evt);
            }
        });
        jPanel1.add(nif);
        nif.setBounds(110, 40, 130, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/erase-128.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 10, 20, 20);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NIF a buscar:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 40, 80, 30);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Logeado como:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(520, 350, 100, 20);

        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setText("nombreUsuario");
        jPanel1.add(nombreUsuario);
        nombreUsuario.setBounds(610, 350, 80, 20);

        a.setForeground(new java.awt.Color(255, 255, 255));
        a.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/fondo.jpg"))); // NOI18N
        a.setText("jLabel1");
        jPanel1.add(a);
        a.setBounds(0, 0, 700, 380);

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

    //Metodo para mostrar los valores del trabajador de la base de datos segun el NIF
    private void nifKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nifKeyReleased
        try {
            String buscar = "SELECT nombreTrabajador, primerApellido, segundoApellido, numeroAfiliacion, "
                    + "puesto, hijos, grupoCotizacion, idConvenio, fechaAntiguedad FROM Trabajador WHERE (NIF = ?) ";

            pst = conn.prepareStatement(buscar);
            pst.setString(1, nif.getText());
            rs = pst.executeQuery();

            while (this.rs.next()) {
                Trabajador.nombre = rs.getString("nombreTrabajador");
                Trabajador.primerApellido = rs.getString("primerApellido");
                Trabajador.segundoApellido = rs.getString("segundoApellido");
                Trabajador.numeroAfiliacion = rs.getString("numeroAfiliacion");
                Trabajador.puesto = rs.getString("puesto");
                Trabajador.hijos = rs.getString("hijos");
                Trabajador.grupoCotizacion = rs.getString("grupoCotizacion");
                Trabajador.idConvenio = rs.getString("idConvenio");
                Trabajador.fechaAntiguedad = rs.getString("fechaAntiguedad");
            }

            nombre1.setText(String.valueOf(Trabajador.nombre));
            primerApellido1.setText(String.valueOf(Trabajador.primerApellido));
            segundoApellido1.setText(String.valueOf(Trabajador.segundoApellido));
            puesto1.setText(String.valueOf(Trabajador.puesto));
            hijos.setText(String.valueOf(Trabajador.hijos));
            antiguedad1.setText(String.valueOf(Trabajador.fechaAntiguedad));
            numeroAfiliacion1.setText(String.valueOf(Trabajador.numeroAfiliacion));
            grupoCotizacion1.setText(String.valueOf(Trabajador.grupoCotizacion));
            idConvenio1.setText(String.valueOf(Trabajador.idConvenio));

        } catch (Exception e) {
        } finally {
            try {
                close(this.rs);
                close(this.pst);
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_nifKeyReleased

    //Accion del boton para volver al menu
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuAdministrador menu = new MenuAdministrador();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nifActionPerformed

    //Accion del boton para eliminar un trabajador de la base de datos
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Estas seguro/a de eliminar este trabajador?", "Eliminar trabajador", JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            try {
                String borrar = "DELETE FROM Trabajador WHERE (NIF = ?) ";
                String borrarUsuario = "DELETE FROM Usuarios WHERE (NIF = ?) ";

                pst = conn.prepareStatement(borrar);
                pst.setString(1, nif.getText());
                pst.execute();

                pst = conn.prepareStatement(borrarUsuario);
                pst.setString(1, nif.getText());
                pst.execute();

                JOptionPane.showMessageDialog(null, "Trabajador eliminado correctamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    close(rs);
                    close(pst);
                    vaciarCampo();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else {
            vaciarCampo();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre1ActionPerformed

    private void primerApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primerApellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_primerApellido1ActionPerformed

    //Accion del boton para actualizar un trabajador
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Estas seguro/a de actualizar este trabajador?", "Actualizar trabajador", JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            try {
                String val = nif.getText();
                String val1 = nombre1.getText();
                String val2 = primerApellido1.getText();
                String val3 = segundoApellido1.getText();
                String val4 = puesto1.getText();
                String val5 = hijos.getText();
                String val6 = antiguedad1.getText();
                String val7 = numeroAfiliacion1.getText();
                String val8 = grupoCotizacion1.getText();
                String val9 = idConvenio1.getText();

                String actualizar = "UPDATE Trabajador SET nombreTrabajador = '" + val1 + "', primerApellido = '" + val2 + "', "
                        + "segundoApellido = '" + val3 + "', puesto = '" + val4 + "', hijos = '" + val5 + "', "
                        + "fechaAntiguedad = '" + val6 + "', numeroAfiliacion = '" + val7 + "', "
                        + "grupoCotizacion = '" + val8 + "', idConvenio = '" + val9 + "' WHERE NIF = '" + val + "'";

                pst = conn.prepareStatement(actualizar);
                pst.execute();

                JOptionPane.showMessageDialog(null, "Trabajador actualizado correctamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    close(rs);
                    close(pst);
                    vaciarCampo();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else {
            vaciarCampo();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //Accion del boton para crear un nuevo usuario para el programa
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Estas seguro/a de crear un usuario a este trabajador?", "Crear usuario", JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            try {
                String nombre = nombre1.getText();
                char letraNombre = nombre.charAt(0);
                String napellido = letraNombre + primerApellido1.getText();
                String sapellido = segundoApellido1.getText();
                String nombreUser = napellido + sapellido.charAt(0);

                //Pasar string a minusula y quitar caracteres especiales.
                nombreUser = nombreUser.toLowerCase();
                nombreUser = Normalizer.normalize(nombreUser, Normalizer.Form.NFD);
                nombreUser = nombreUser.replaceAll("[^\\p{ASCII}]", "");

                String contrasena = nombreUser + "1234";

                String insert = "INSERT INTO Usuarios (nombreUsuario, password, rol, NIF) "
                        + "VALUES(?, ?, ?, ?)";

                this.pst = this.conn.prepareStatement(insert);

                pst.setString(1, nombreUser);
                pst.setString(2, contrasena);
                pst.setString(3, "Usuario");
                pst.setString(4, nif.getText());

                this.pst.execute();

                JOptionPane.showMessageDialog(null, "Usuario añadido correctamente.\nUsuario: " + nombreUser + "\nContraseña: " + contrasena);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    pst.close();
                    vaciarCampo();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } else {
            vaciarCampo();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(GestionTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionTrabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JTextField antiguedad1;
    private javax.swing.JMenu fecha;
    private javax.swing.JTextField grupoCotizacion1;
    private javax.swing.JTextField hijos;
    private javax.swing.JMenu hora;
    private javax.swing.JTextField idConvenio1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField nombre1;
    private javax.swing.JLabel nombreUsuario;
    private javax.swing.JTextField numeroAfiliacion1;
    private javax.swing.JTextField primerApellido1;
    private javax.swing.JTextField puesto1;
    private javax.swing.JTextField segundoApellido1;
    // End of variables declaration//GEN-END:variables
}
