package nominas.pestanaNominas;

import nominas.objetos.Convenio;
import nominas.objetos.Trabajador;
import nominas.menus.MenuAdministrador;
import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;
import static nominas.conexion.db.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import nominas.objetos.Usuario;

public class CalculoNomina extends javax.swing.JFrame {

    //Atributos de la clase
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    //DATOS TRABAJADOR
    public static String nombreTrabajador1;
    public static String puesto1;
    public static String nif1;
    public static String numeroAfiliacion1;

    //PORCENTAJES DE LA BASE DE DATOS DE LA TABLA CONVENIO.
    public static double irpfP;
    public static double contingenciasComunesP;
    public static double paroP;
    public static double formacionProfesionalP;
    public static double horasExtraordinariasP;
    public static double horasExtraordinariasPorFuerzaMayorP;
    public static double salarioBase;

    public static String irpfPS;
    public static String contingenciasComunesPS;
    public static String paroPS;
    public static String formacionProfesionalPS;

    //INFORMACION
    public static String ccInfo;
    public static String paroInfo;
    public static String fpInfo;
    public static String irpfInfo;
    public static String horasExtraInfo;
    public static String horasExtraMayorInfo;
    public static String horasComplementariasInfo;
    public static String salarioBaseS;
    public static String horasExtrasS;
    public static String horasExtraMayorS;
    public static String horasComplS;

    //CAMPOS PASADOS POR EL USUARIO
    public static double horasExtraordinariasCampo;
    public static double horasExtraordinariasFuerzaMayorCampo;
    public static double horasComplementariasCampo;
    public static String fechaInicioCampo;
    public static String fechaFinCampo;

    //CAMPOS CALCULADOS        
    public static String totalDevengado;
    public static String contingenciasComunesDP;
    public static String paroDP;
    public static String formacionProfesionalDP;
    //_____________________________
    public static String totalAportaciones;

    public static String irpfDP;
    public static String totalReducir;
    public static String importeLiquido;

    //ASIGNAMOS FECHA DEL USUARIO PARA CALCULAR LA ANTIGUEDAD CON LA NOMINA
    public static String fechaAntiguedadUsuario;
    public static String numeroDias;

    //Constructor de la clase
    public CalculoNomina() {
        initComponents();
        this.conn = getConnection();
        posicionar();
        fechaActual();
        logeadoComo();
    }
    
    public void logeadoComo() {
        nombreUsuario.setText(String.valueOf(Usuario.nombreUsuario));
    }

    //Metodo para vaciar los campos de la ventana
    public void vaciarCampo() {
        nif.setText("");
        nombre.setText("");
        apellido.setText("");
        idConvenio.setText("");
        fechaInicio.setText("");
        fechaFin.setText("");
        numeroAfiliacion.setText("");
        grupoCotizacion.setText("");
        puesto.setText("");
        horasExtras.setText("");
        horasExtrasMayor.setText("");
        horasComplementarias.setText("");
    }

    //Metodo para posicionar la ventana en medio de la pantalla
    public void posicionar() {
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    //Metodo para indicar la fecha y hora actual en la barra de menu
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
        nombreUsuario = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        puesto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        grupoCotizacion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        numeroAfiliacion = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        fechaFin = new javax.swing.JTextField();
        horasExtras = new javax.swing.JTextField();
        fechaInicio = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        idConvenio = new javax.swing.JTextField();
        horasComplementarias = new javax.swing.JTextField();
        horasExtrasMayor = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        nif = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        fecha = new javax.swing.JMenu();
        hora = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NOMINAS");

        jPanel1.setLayout(null);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Logeado como:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(520, 350, 110, 20);

        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setText("nombreUsuario");
        jPanel1.add(nombreUsuario);
        nombreUsuario.setBounds(610, 350, 90, 20);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Puesto");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(80, 140, 80, 30);
        jPanel1.add(puesto);
        puesto.setBounds(80, 170, 100, 30);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Grupo de Cotización");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(220, 140, 120, 30);
        jPanel1.add(grupoCotizacion);
        grupoCotizacion.setBounds(220, 170, 100, 30);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Numero de Afiliación");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(360, 140, 130, 30);
        jPanel1.add(numeroAfiliacion);
        numeroAfiliacion.setBounds(360, 170, 100, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/attachment-512.png"))); // NOI18N
        jButton2.setText("Calcular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(360, 290, 100, 30);
        jPanel1.add(fechaFin);
        fechaFin.setBounds(220, 290, 100, 30);

        horasExtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horasExtrasActionPerformed(evt);
            }
        });
        jPanel1.add(horasExtras);
        horasExtras.setBounds(80, 230, 100, 30);
        jPanel1.add(fechaInicio);
        fechaInicio.setBounds(80, 290, 100, 30);
        jPanel1.add(apellido);
        apellido.setBounds(220, 110, 100, 30);
        jPanel1.add(idConvenio);
        idConvenio.setBounds(360, 110, 100, 30);
        jPanel1.add(horasComplementarias);
        horasComplementarias.setBounds(360, 230, 100, 30);
        jPanel1.add(horasExtrasMayor);
        horasExtrasMayor.setBounds(220, 230, 100, 30);
        jPanel1.add(nombre);
        nombre.setBounds(80, 110, 100, 30);

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
        nif.setBounds(80, 40, 100, 30);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Horas Extra fuerza Mayor");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(220, 200, 140, 30);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Horas Extraordinarias");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(80, 200, 120, 30);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Horas Complementarias");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(360, 200, 140, 30);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NIF");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 40, 30, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 80, 100, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(220, 80, 100, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha Inicio");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(80, 260, 70, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha Fin");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(220, 260, 60, 30);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Id del Convenio");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(360, 80, 100, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/erase-128.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 10, 20, 20);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(fondo);
        fondo.setBounds(0, 0, 700, 380);

        jLabel14.setText("jLabel10");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(480, 80, 41, 14);

        jTextField4.setText("jTextField1");
        jPanel1.add(jTextField4);
        jTextField4.setBounds(490, 110, 60, 20);

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

    //Accion del boton para volver al menu
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuAdministrador menu = new MenuAdministrador();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nifActionPerformed

    //Accion para autocompletar los campos requeridos del trabajador para calcular la nomina
    private void nifKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nifKeyReleased
        try {
            String buscar = "SELECT nombreTrabajador, primerApellido, numeroAfiliacion, fechaAntiguedad,"
                    + "puesto, grupoCotizacion, idConvenio FROM Trabajador WHERE (NIF = ?) ";

            pst = conn.prepareStatement(buscar);
            pst.setString(1, nif.getText());
            rs = pst.executeQuery();

            while (this.rs.next()) {
                Trabajador.nombre = rs.getString("nombreTrabajador");
                Trabajador.primerApellido = rs.getString("primerApellido");
                Trabajador.numeroAfiliacion = rs.getString("numeroAfiliacion");
                Trabajador.fechaAntiguedad = rs.getString("fechaAntiguedad");
                Trabajador.puesto = rs.getString("puesto");
                Trabajador.grupoCotizacion = rs.getString("grupoCotizacion");
                Trabajador.idConvenio = rs.getString("idConvenio");
            }

            this.fechaAntiguedadUsuario = Trabajador.fechaAntiguedad;

            nombre.setText(String.valueOf(Trabajador.nombre));
            this.nif1 = nif.getText();
            apellido.setText(String.valueOf(Trabajador.primerApellido));
            this.nombreTrabajador1 = Trabajador.nombre + " " + Trabajador.primerApellido;
            puesto.setText(String.valueOf(Trabajador.puesto));
            this.puesto1 = Trabajador.puesto;
            numeroAfiliacion.setText(String.valueOf(Trabajador.numeroAfiliacion));

            this.numeroAfiliacion1 = Trabajador.numeroAfiliacion;
            grupoCotizacion.setText(String.valueOf(Trabajador.grupoCotizacion));
            idConvenio.setText(String.valueOf(Trabajador.idConvenio));
        } catch (Exception e) {
        } finally {
            try {
                close(rs);
                close(pst);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_nifKeyReleased

    //Metodo para guardar la nomina en la base de datos
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String selectSalarioBase = "SELECT C.idConvenio, C.nombreConvenio, C.irpf, C.contingenciasComunes, "
                    + "C.paro, C.formacionProfesional, C.horasExtraordinarias, C.horasExtraordinariasPorFuerzaMayor, "
                    + "C.salarioBase FROM Convenio AS C INNER JOIN Trabajador AS T ON "
                    + "C.idConvenio = T.IdConvenio WHERE (NIF = ?)";

            pst = conn.prepareStatement(selectSalarioBase);
            pst.setString(1, nif.getText());
            rs = pst.executeQuery();

            while (this.rs.next()) {
                Convenio.idConvenio = rs.getString("idConvenio");
                Convenio.nombreConvenio = rs.getString("nombreConvenio");
                Convenio.irpf = rs.getDouble("irpf");
                Convenio.contingenciasComunes = rs.getDouble("contingenciasComunes");
                Convenio.paro = rs.getDouble("paro");
                Convenio.formacionProfesional = rs.getDouble("formacionProfesional");
                Convenio.horasExtraordinarias = rs.getDouble("horasExtraordinarias");
                Convenio.horasExtraordinariasPorFuerzaMayor = rs.getDouble("horasExtraordinariasPorFuerzaMayor");
                Convenio.salarioBase = rs.getDouble("salarioBase");
            }
            
            this.horasExtrasS = horasExtras.getText();
            this.horasExtraMayorS = horasExtrasMayor.getText();
            this.horasComplS = horasComplementarias.getText();

            //ASIGNAMOS PORCENTAJES
            this.irpfP = Convenio.irpf;
            this.irpfPS = Double.toString(Convenio.irpf);
            this.contingenciasComunesP = Convenio.contingenciasComunes;
            this.contingenciasComunesPS = Double.toString(Convenio.contingenciasComunes);
            this.paroP = Convenio.paro;
            this.paroPS = Double.toString(Convenio.paro);
            this.formacionProfesionalP = Convenio.formacionProfesional;
            this.formacionProfesionalPS = Double.toString(Convenio.formacionProfesional);
            this.horasExtraordinariasP = Convenio.horasExtraordinarias;
            this.horasExtraordinariasPorFuerzaMayorP = Convenio.horasExtraordinariasPorFuerzaMayor;
            this.salarioBase = Convenio.salarioBase;
            String salarioBaseSt = Double.toString(Convenio.salarioBase);
            this.salarioBaseS = salarioBaseSt;

            //año
            char ano1 = this.fechaAntiguedadUsuario.charAt(6);
            char ano2 = this.fechaAntiguedadUsuario.charAt(7);
            char ano3 = this.fechaAntiguedadUsuario.charAt(8);
            char ano4 = this.fechaAntiguedadUsuario.charAt(9);

            //mes
            char mes1 = this.fechaAntiguedadUsuario.charAt(3);
            char mes2 = this.fechaAntiguedadUsuario.charAt(4);

            //dia
            char dia1 = this.fechaAntiguedadUsuario.charAt(0);
            char dia2 = this.fechaAntiguedadUsuario.charAt(1);

            String anoS = Character.toString(ano1) + Character.toString(ano2) + Character.toString(ano3) + Character.toString(ano4) + "-" + Character.toString(mes1) + Character.toString(mes2) + "-" + Character.toString(dia1) + Character.toString(dia2);

            LocalDate ld1 = LocalDate.now();
            LocalDate ld2 = LocalDate.parse(anoS);
            long dias = ChronoUnit.DAYS.between(ld2, ld1);
            this.numeroDias = Long.toString(dias);

            //ASIGNAMOS CAMPOS INTRODUCIDOS POR EL USUARIO
            double horasExtrasD = Double.parseDouble(horasExtras.getText());
            this.horasExtraInfo = Double.toString(horasExtrasD);
            this.horasExtraordinariasCampo = horasExtrasD;

            double horasExtrasMayorD = Double.parseDouble(horasExtrasMayor.getText());
            this.horasExtraMayorInfo = Double.toString(horasExtrasMayorD);
            this.horasExtraordinariasFuerzaMayorCampo = horasExtrasMayorD;

            double horasComplementariasD = Double.parseDouble(horasComplementarias.getText());
            this.horasComplementariasInfo = Double.toString(horasComplementariasD);
            this.horasComplementariasCampo = horasComplementariasD;

            this.fechaInicioCampo = fechaInicio.getText();
            this.fechaFinCampo = fechaFin.getText();

            //CALCULAMOS CAMPOS NOMINA
            long tresAnos = 1095;

            if (dias >= tresAnos) {
                this.salarioBase = this.salarioBase * 1.05;
            } else if (dias >= tresAnos * 2) {
                this.salarioBase = this.salarioBase * 1.05;
            } else if (dias >= tresAnos * 3) {
                this.salarioBase = this.salarioBase * 1.05;
            } else if (dias >= tresAnos * 4) {
                this.salarioBase = this.salarioBase * 1.05;
            } else if (dias >= tresAnos * 5) {
                this.salarioBase = this.salarioBase * 1.05;
            } else if (dias >= tresAnos * 6) {
                this.salarioBase = this.salarioBase * 1.05;
            }

            DecimalFormat df = new DecimalFormat("0.00");
            double totalDevengadoD = this.salarioBase + this.horasExtraordinariasCampo + this.horasExtraordinariasFuerzaMayorCampo + this.horasComplementariasCampo;
            String totalDevengadoS = df.format(totalDevengadoD);
            this.totalDevengado = totalDevengadoS;

            String salarioBaseS = Double.toString(salarioBase);
            this.ccInfo = salarioBaseS;

            String sumaSalarioBaseHorasExtra = Double.toString(salarioBase + horasExtraordinariasCampo);
            this.paroInfo = sumaSalarioBaseHorasExtra;
            this.fpInfo = sumaSalarioBaseHorasExtra;

            double ccCalculoD = (this.salarioBase * this.contingenciasComunesP) / 100;
            String ccCalculo = df.format(ccCalculoD);
            this.contingenciasComunesDP = ccCalculo;

            double pCalculoD = ((salarioBase + horasExtraordinariasCampo) * this.paroP) / 100;
            String pCalculo = df.format(pCalculoD);
            this.paroDP = pCalculo;

            double fpCalculoD = ((salarioBase + horasExtraordinariasCampo) * this.formacionProfesionalP) / 100;
            String fpCalculo = df.format(fpCalculoD);
            this.formacionProfesionalDP = fpCalculo;

            double totalAportacionesD = ccCalculoD + pCalculoD + fpCalculoD;
            String totalAportacionesS = df.format(totalAportacionesD);
            this.totalAportaciones = totalAportacionesS;

            double irpfInfoD = totalDevengadoD;
            String irpfS = df.format(irpfInfoD);
            this.irpfInfo = irpfS;

            double irpfDPD = ((irpfInfoD * this.irpfP) / 100);
            String irpfDPS = df.format(irpfDPD);
            this.irpfDP = irpfDPS;

            double totalReducirD = totalAportacionesD + irpfDPD;
            String totalReducirS = df.format(totalReducirD);
            this.totalReducir = totalReducirS;

            double importeLiquidoD = totalDevengadoD - totalReducirD;
            String importeLiquidoS = df.format(importeLiquidoD);
            this.importeLiquido = importeLiquidoS;

            String insertNomina = "INSERT INTO Nomina(NIF, fechaInicio, fechaFin, horasExtra, horasExtraMayor, horasComplementarias, ccInfo, paroInfo, fpInfo, irpfInfo, totalDevengado, contingenciasComunes, paro, formacionProfesional, irpf, totalAportaciones, totalReducir, idConvenio, importeTotalAPercibir) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pst = conn.prepareStatement(insertNomina);
            pst.setString(1, nif.getText());
            pst.setString(2, fechaInicio.getText());
            pst.setString(3, fechaFin.getText());
            pst.setString(4, this.horasExtrasS);
            pst.setString(5, this.horasExtraMayorS);
            pst.setString(6, this.horasComplS);
            pst.setString(7, ccInfo);
            pst.setString(8, paroInfo);
            pst.setString(9, fpInfo);
            pst.setString(10, irpfInfo);
            pst.setString(11, this.totalDevengado);
            pst.setString(12, this.contingenciasComunesDP);
            pst.setString(13, this.paroDP);
            pst.setString(14, this.formacionProfesionalDP);
            pst.setString(15, this.irpfDP);
            pst.setString(16, this.totalAportaciones);
            pst.setString(17, this.totalReducir);
            pst.setString(18, idConvenio.getText());
            pst.setString(19, this.importeLiquido);

            this.pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                close(rs);
                close(pst);
                NominaCalculada nc = new NominaCalculada();
                nc.setVisible(true);
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void horasExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horasExtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horasExtrasActionPerformed

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
            java.util.logging.Logger.getLogger(CalculoNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculoNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculoNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculoNomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculoNomina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JMenu fecha;
    private javax.swing.JTextField fechaFin;
    private javax.swing.JTextField fechaInicio;
    private javax.swing.JLabel fondo;
    private javax.swing.JTextField grupoCotizacion;
    private javax.swing.JMenu hora;
    private javax.swing.JTextField horasComplementarias;
    private javax.swing.JTextField horasExtras;
    private javax.swing.JTextField horasExtrasMayor;
    private javax.swing.JTextField idConvenio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField nif;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombreUsuario;
    private javax.swing.JTextField numeroAfiliacion;
    private javax.swing.JTextField puesto;
    // End of variables declaration//GEN-END:variables
}
