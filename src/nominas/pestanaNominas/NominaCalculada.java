package nominas.pestanaNominas;

import nominas.menus.MenuAdministrador;
import java.awt.*;
import java.util.*;
import java.sql.*;
import static nominas.conexion.db.*;

public class NominaCalculada extends javax.swing.JFrame {

    //Metodos de la clase
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    //Constructor de la clase
    public NominaCalculada() {
        initComponents();
        this.conn = getConnection();
        posicionar();
        fechaActual();
        rellenarCampo();
    }

    //Metodo para rellenar los campos automaticamente con los datos de toda la nomina
    //con datos directos de la base de datos calculados.
    public void rellenarCampo() {
        empresa.setText("CIDE SL");
        domicilio.setText("C/ L'Arner 3, Son Rapinya");
        cif.setText("F07038722");
        ccc.setText("CIDECCC");
        horasExtras.setText(CalculoNomina.horasExtraInfo);
        nombreTrabajador.setText(CalculoNomina.nombreTrabajador1);
        numeroAfiliacion.setText(CalculoNomina.numeroAfiliacion1);
        nif.setText(CalculoNomina.nif1);
        puesto.setText(CalculoNomina.puesto1);
        horasFuerzaMayor.setText(CalculoNomina.horasExtraMayorInfo);
        salarioBase.setText(CalculoNomina.salarioBaseS);
        fechaInicio.setText(CalculoNomina.fechaInicioCampo);
        fechaFin.setText(CalculoNomina.fechaFinCampo);
        totalDevengado.setText(CalculoNomina.totalDevengado);
        horasComplementarias.setText(CalculoNomina.horasComplementariasInfo);
        contingenciasComunes.setText(CalculoNomina.ccInfo);
        paro.setText(CalculoNomina.paroInfo);
        formacionProfesional.setText(CalculoNomina.fpInfo);
        ccP.setText(CalculoNomina.contingenciasComunesPS + "%");
        paroP.setText(CalculoNomina.paroPS + "%");
        fpP.setText(CalculoNomina.formacionProfesionalPS + "%");
        ccdp.setText(CalculoNomina.contingenciasComunesDP);
        pdp.setText(CalculoNomina.paroDP);
        fpdp.setText(CalculoNomina.formacionProfesionalDP);
        totalAportaciones.setText(CalculoNomina.totalAportaciones);
        totalReducir.setText(CalculoNomina.totalReducir);
        importeLiquido.setText(CalculoNomina.importeLiquido);
        irpf.setText(CalculoNomina.irpfInfo);
        irpfdp.setText(CalculoNomina.irpfDP);
        irpfP.setText(CalculoNomina.irpfPS + "%");
    }

    //Metodo para posicionar la ventana actual en medio de la pantalla
    public void posicionar() {
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    //Metodo para mostrar la fecha y hora actual dentro de la barra de menu
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
        jLabel13 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        horasComplementarias = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        horasFuerzaMayor = new javax.swing.JTextField();
        horasExtras = new javax.swing.JTextField();
        irpfdp = new javax.swing.JLabel();
        irpfP = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        irpf = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        importeLiquido = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        totalReducir = new javax.swing.JTextField();
        totalAportaciones = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        ccdp = new javax.swing.JLabel();
        fpdp = new javax.swing.JLabel();
        pdp = new javax.swing.JLabel();
        fpP = new javax.swing.JLabel();
        paroP = new javax.swing.JLabel();
        ccP = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        contingenciasComunes = new javax.swing.JTextField();
        formacionProfesional = new javax.swing.JTextField();
        paro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fechaInicio = new javax.swing.JTextField();
        fechaFin = new javax.swing.JTextField();
        totalDevengado = new javax.swing.JTextField();
        salarioBase = new javax.swing.JTextField();
        ccc = new javax.swing.JTextField();
        cif = new javax.swing.JTextField();
        domicilio = new javax.swing.JTextField();
        empresa = new javax.swing.JTextField();
        puesto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nif = new javax.swing.JTextField();
        nombreTrabajador = new javax.swing.JTextField();
        numeroAfiliacion = new javax.swing.JTextField();
        LabelPuesto = new javax.swing.JLabel();
        LabelNIF = new javax.swing.JLabel();
        LabelNumeroAfiliacion = new javax.swing.JLabel();
        labelNombreTrabajador = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        fecha = new javax.swing.JMenu();
        hora = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NOMINAS");

        jPanel1.setLayout(null);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Resultados");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(340, 190, 80, 30);

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Horas Complementarias");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(460, 160, 130, 30);

        horasComplementarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horasComplementariasActionPerformed(evt);
            }
        });
        jPanel1.add(horasComplementarias);
        horasComplementarias.setBounds(590, 160, 100, 30);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Horas Extras Fuerza Mayor");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(200, 160, 170, 30);

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Horas Extras");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(20, 160, 80, 30);
        jPanel1.add(horasFuerzaMayor);
        horasFuerzaMayor.setBounds(350, 160, 100, 30);
        jPanel1.add(horasExtras);
        horasExtras.setBounds(90, 160, 100, 30);

        irpfdp.setForeground(new java.awt.Color(255, 255, 255));
        irpfdp.setText("IRPFDP");
        jPanel1.add(irpfdp);
        irpfdp.setBounds(350, 330, 170, 30);

        irpfP.setForeground(new java.awt.Color(255, 255, 255));
        irpfP.setText("IRPFP");
        jPanel1.add(irpfP);
        irpfP.setBounds(250, 330, 80, 30);

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("IRPF");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(10, 330, 90, 30);

        irpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irpfActionPerformed(evt);
            }
        });
        jPanel1.add(irpf);
        irpf.setBounds(140, 330, 80, 30);

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Importe Líquido a percibir");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(420, 280, 140, 30);
        jPanel1.add(importeLiquido);
        importeLiquido.setBounds(560, 280, 130, 30);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Total a reducir");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(420, 250, 120, 30);
        jPanel1.add(totalReducir);
        totalReducir.setBounds(560, 250, 130, 30);
        jPanel1.add(totalAportaciones);
        totalAportaciones.setBounds(560, 220, 130, 30);

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Total aportaciones");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(420, 220, 120, 30);

        ccdp.setForeground(new java.awt.Color(255, 255, 255));
        ccdp.setText("CCDP");
        jPanel1.add(ccdp);
        ccdp.setBounds(350, 220, 80, 30);

        fpdp.setForeground(new java.awt.Color(255, 255, 255));
        fpdp.setText("FPDP");
        jPanel1.add(fpdp);
        fpdp.setBounds(350, 280, 80, 30);

        pdp.setForeground(new java.awt.Color(255, 255, 255));
        pdp.setText("PDP");
        jPanel1.add(pdp);
        pdp.setBounds(350, 250, 70, 30);

        fpP.setForeground(new java.awt.Color(255, 255, 255));
        fpP.setText("FP");
        jPanel1.add(fpP);
        fpP.setBounds(250, 280, 50, 30);

        paroP.setForeground(new java.awt.Color(255, 255, 255));
        paroP.setText("Paro");
        jPanel1.add(paroP);
        paroP.setBounds(250, 250, 60, 30);

        ccP.setForeground(new java.awt.Color(255, 255, 255));
        ccP.setText("CC");
        jPanel1.add(ccP);
        ccP.setBounds(250, 220, 50, 30);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Porcentajes");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(250, 190, 90, 30);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Formación Profesional");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 280, 130, 30);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Contingencias Comunes");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 220, 140, 30);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Paro");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 250, 130, 30);
        jPanel1.add(contingenciasComunes);
        contingenciasComunes.setBounds(140, 220, 80, 30);
        jPanel1.add(formacionProfesional);
        formacionProfesional.setBounds(140, 280, 80, 30);
        jPanel1.add(paro);
        paro.setBounds(140, 250, 80, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total Devengado");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(490, 130, 100, 30);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha fin");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(530, 100, 90, 30);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha inicio");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(520, 70, 90, 30);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Salario base");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(520, 40, 90, 30);
        jPanel1.add(fechaInicio);
        fechaInicio.setBounds(590, 70, 100, 30);
        jPanel1.add(fechaFin);
        fechaFin.setBounds(590, 100, 100, 30);
        jPanel1.add(totalDevengado);
        totalDevengado.setBounds(590, 130, 100, 30);
        jPanel1.add(salarioBase);
        salarioBase.setBounds(590, 40, 100, 30);
        jPanel1.add(ccc);
        ccc.setBounds(90, 130, 150, 30);

        cif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cifActionPerformed(evt);
            }
        });
        jPanel1.add(cif);
        cif.setBounds(90, 100, 150, 30);
        jPanel1.add(domicilio);
        domicilio.setBounds(90, 70, 150, 30);

        empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresaActionPerformed(evt);
            }
        });
        jPanel1.add(empresa);
        empresa.setBounds(90, 40, 150, 30);
        jPanel1.add(puesto);
        puesto.setBounds(350, 130, 100, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CIF");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 100, 60, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CCC");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 130, 60, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Domicilio");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 70, 60, 30);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Empresa");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 40, 60, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/erase-128.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 10, 20, 20);
        jPanel1.add(nif);
        nif.setBounds(350, 100, 150, 30);
        jPanel1.add(nombreTrabajador);
        nombreTrabajador.setBounds(350, 40, 150, 30);
        jPanel1.add(numeroAfiliacion);
        numeroAfiliacion.setBounds(350, 70, 150, 30);

        LabelPuesto.setForeground(new java.awt.Color(255, 255, 255));
        LabelPuesto.setText("Puesto");
        jPanel1.add(LabelPuesto);
        LabelPuesto.setBounds(250, 130, 80, 30);

        LabelNIF.setForeground(new java.awt.Color(255, 255, 255));
        LabelNIF.setText("NIF");
        jPanel1.add(LabelNIF);
        LabelNIF.setBounds(250, 100, 100, 30);

        LabelNumeroAfiliacion.setForeground(new java.awt.Color(255, 255, 255));
        LabelNumeroAfiliacion.setText("Numero Afiliación");
        jPanel1.add(LabelNumeroAfiliacion);
        LabelNumeroAfiliacion.setBounds(250, 70, 100, 30);

        labelNombreTrabajador.setForeground(new java.awt.Color(255, 255, 255));
        labelNombreTrabajador.setText("Nombre Trabajador");
        jPanel1.add(labelNombreTrabajador);
        labelNombreTrabajador.setBounds(250, 40, 100, 30);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Calculos Finales");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(470, 190, 120, 30);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(fondo);
        fondo.setBounds(0, 0, 700, 400);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Accion del boton para volver al menu del administrador
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuAdministrador menu = new MenuAdministrador();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cifActionPerformed

    private void empresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empresaActionPerformed

    private void irpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_irpfActionPerformed

    private void horasComplementariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horasComplementariasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horasComplementariasActionPerformed

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
            java.util.logging.Logger.getLogger(NominaCalculada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NominaCalculada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NominaCalculada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NominaCalculada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NominaCalculada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelNIF;
    private javax.swing.JLabel LabelNumeroAfiliacion;
    private javax.swing.JLabel LabelPuesto;
    private javax.swing.JLabel ccP;
    private javax.swing.JTextField ccc;
    private javax.swing.JLabel ccdp;
    private javax.swing.JTextField cif;
    private javax.swing.JTextField contingenciasComunes;
    private javax.swing.JTextField domicilio;
    private javax.swing.JTextField empresa;
    private javax.swing.JMenu fecha;
    private javax.swing.JTextField fechaFin;
    private javax.swing.JTextField fechaInicio;
    private javax.swing.JLabel fondo;
    private javax.swing.JTextField formacionProfesional;
    private javax.swing.JLabel fpP;
    private javax.swing.JLabel fpdp;
    private javax.swing.JMenu hora;
    private javax.swing.JTextField horasComplementarias;
    private javax.swing.JTextField horasExtras;
    private javax.swing.JTextField horasFuerzaMayor;
    private javax.swing.JTextField importeLiquido;
    private javax.swing.JTextField irpf;
    private javax.swing.JLabel irpfP;
    private javax.swing.JLabel irpfdp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JLabel labelNombreTrabajador;
    private javax.swing.JTextField nif;
    private javax.swing.JTextField nombreTrabajador;
    private javax.swing.JTextField numeroAfiliacion;
    private javax.swing.JTextField paro;
    private javax.swing.JLabel paroP;
    private javax.swing.JLabel pdp;
    private javax.swing.JTextField puesto;
    private javax.swing.JTextField salarioBase;
    private javax.swing.JTextField totalAportaciones;
    private javax.swing.JTextField totalDevengado;
    private javax.swing.JTextField totalReducir;
    // End of variables declaration//GEN-END:variables
}
