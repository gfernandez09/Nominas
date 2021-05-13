package nominas.pestanaNominas;

import nominas.menus.MenuAdministrador;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import static nominas.conexion.db.*;
import nominas.objetos.*;

//Clase para consultar todas las nominas desde la vision del administrador
public class ConsultarNominas extends javax.swing.JFrame {

    //Atributos
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public static String[] datos;
    public static DefaultTableModel dtm;        
    
    //Constructor de la clase
    public ConsultarNominas() {
        initComponents();
        this.conn = getConnection();
        rellenarTabla();
        posicionar();
        fechaActual();
        logeadoComo();
    }
    
    //Metodo para mostrar el usuario logeado
    public void logeadoComo() {
        nombreUsuario.setText(String.valueOf(Usuario.nombreUsuario));
    }
    
    //Metodo para rellenar la tabla con el registro de todas las nominas
    public void rellenarTabla() {
        String select = "SELECT NIF, fechaInicio, fechaFin, idConvenio, importeTotalAPercibir FROM Nomina";

        this.dtm = new DefaultTableModel();
        dtm.addColumn("NIF");
        dtm.addColumn("Fecha Inicio");
        dtm.addColumn("Fecha Fin");
        dtm.addColumn("Convenio");
        dtm.addColumn("Importe total");

        tabla.setModel(dtm);

        this.datos = new String[5];

        try {
            this.pst = this.conn.prepareStatement(select);
            this.rs = this.pst.executeQuery();

            
            while (this.rs.next()) {
                this.datos[0] = this.rs.getString("NIF");
                this.datos[1] = this.rs.getString("fechaInicio");
                this.datos[2] = this.rs.getString("fechaFin");
                this.datos[3] = this.rs.getString("idConvenio");
                this.datos[4] = this.rs.getString("ImporteTotalAPercibir");
                
                dtm.addRow(this.datos);                                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Metodo para posicionar la ventana en medio de la pantalla
    public void posicionar() {
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    //Metodo para mostrar la fecha y la hora en la barra del menu
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fechaFin = new javax.swing.JTextField();
        fechaInicio = new javax.swing.JTextField();
        nif = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        fecha = new javax.swing.JMenu();
        hora = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NOMINAS");

        jPanel1.setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/erase-128.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 10, 20, 20);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 40, 600, 190);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Logeado como:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(520, 350, 90, 20);

        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setText("nombreUsuario");
        jPanel1.add(nombreUsuario);
        nombreUsuario.setBounds(610, 350, 90, 20);

        jButton2.setText("EXPORT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(560, 320, 90, 30);

        jButton3.setText("JSON");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(560, 243, 90, 30);

        jButton4.setText("XML");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(560, 280, 90, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha Inicio");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 280, 90, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NIF");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 240, 90, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha Fin");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 320, 90, 30);
        jPanel1.add(fechaFin);
        fechaFin.setBounds(140, 320, 140, 30);

        fechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaInicioActionPerformed(evt);
            }
        });
        jPanel1.add(fechaInicio);
        fechaInicio.setBounds(140, 280, 140, 30);
        jPanel1.add(nif);
        nif.setBounds(140, 240, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nominas/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 380);

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

    //Accion del boton para volver al menu del administrador
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuAdministrador menu = new MenuAdministrador();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    //Accion del boton para exportar una nomina en especifico (PDF, HTML, CSV)
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {         
            
            JRPdfExporter exporter = new JRPdfExporter();        
            
            JasperDesign jdesign = JRXmlLoader.load("src\\Nominas\\archivos\\jasperReports\\nominal.jrxml");
            
            String select = """
                            SELECT C.idConvenio AS idConvenio, C.nombreConvenio AS nombreConvenio, C.irpf AS irpfConvenio, 
                            C.contingenciasComunes AS contingenciasComunesConvenio, C.paro AS paroConvenio, C.formacionProfesional 
                            AS formacionProfesionalConvenio, C.horasExtraordinarias AS horasExtraordinariasConvenio, 
                            C.horasExtraordinariasPorFuerzaMayor AS horasExtraordinariasPorFuerzaMayorConvenio, C.salarioBase 
                            AS salarioBaseConvenio, T.NIF AS NIFTrabajador, T.nombreTrabajador AS nombreTrabajador, T.primerApellido 
                            AS primerApellidoTrabajador, T.segundoApellido AS segundoApellidoTrabajador, T.numeroAfiliacion AS 
                            numeroAfiliacionTrabajador,T.puesto AS puestoTrabajador, T.hijos AS hijosTrabajador, T.grupoCotizacion 
                            AS grupoCotizacionTrabajador, T.idConvenio AS idConvenioTrabajador, T.fechaAntiguedad AS 
                            fechaAntiguedadTrabajador, U.id AS idUsuario, U.nombreUsuario, U.password AS passwordUsuario, U.rol 
                            AS rolUsuario, U.NIF AS NIFUsuario, N.idNomina, N.NIF AS NIFNomina, N.fechaInicio AS fechaInicioNomina,
                            N.fechaFin AS fechaFinNomina, N.horasExtra AS horasExtraNomina, N.horasExtraMayor AS horasExtraMayorNomina, 
                            N.horasComplementarias AS horasComplementariasNomina, N.ccInfo AS ContComunesInfo, N.paroInfo AS ParoInfo, 
                            N.fpInfo AS FormProfInfo, N.irpfInfo AS irpfINFO, N.totalDevengado AS totalDevengadoNomina, 
                            N.contingenciasComunes AS contingenciasComunesNomina, N.paro AS paroNomina, N.formacionProfesional AS 
                            formacionProfesionalNomina, N.irpf AS irpfNomina, N.totalAportaciones AS totalAportacionesNomina, 
                            N.totalReducir AS totalReducirNomina, N.idConvenio AS idConvenioNomina, N.importeTotalAPercibir AS 
                            importeTotalAPercibirNomina FROM Convenio as C INNER JOIN Trabajador as T 
                            ON C.idConvenio = T.IdConvenio INNER JOIN Usuarios as U ON T.NIF = U.NIF INNER JOIN Nomina as N 
                            ON U.NIF = N.NIF WHERE N.NIF = '""" + nif.getText() + "'"
                    + " AND N.fechaInicio = '" + fechaInicio.getText() + "' AND N.fechaFin = '" + fechaFin.getText() + "'";
            
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(select);
            
            jdesign.setQuery(updateQuery);
            
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, this.conn);                        
            
            JasperViewer.viewReport(jprint);                        

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //Accion del boton para exportar una nomina en XML
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            String select = """
                            SELECT C.idConvenio, C.nombreConvenio, C.irpf, 
                            C.contingenciasComunes, C.paro, C.formacionProfesional, C.horasExtraordinarias, 
                            C.horasExtraordinariasPorFuerzaMayor, C.salarioBase, T.NIF, T.nombreTrabajador, T.primerApellido, 
                            T.segundoApellido, T.numeroAfiliacion, T.puesto, T.hijos, T.grupoCotizacion, T.idConvenio, T.fechaAntiguedad, 
                            U.id, U.nombreUsuario, U.password, U.rol, U.NIF, N.idNomina, N.NIF, N.fechaInicio,
                            N.fechaFin, N.horasExtra, N.horasExtraMayor, 
                            N.horasComplementarias, N.ccInfo, N.paroInfo, 
                            N.fpInfo, N.irpfInfo, N.totalDevengado, 
                            N.contingenciasComunes, N.paro, N.formacionProfesional, N.irpf, N.totalAportaciones, 
                            N.totalReducir, N.idConvenio, N.importeTotalAPercibir FROM Convenio as C INNER JOIN Trabajador as T 
                            ON C.idConvenio = T.IdConvenio INNER JOIN Usuarios as U ON T.NIF = U.NIF INNER JOIN Nomina as N 
                            ON U.NIF = N.NIF WHERE N.NIF = '""" + nif.getText() + "'"
                    + " AND N.fechaInicio = '" + fechaInicio.getText() + "' AND N.fechaFin = '" + fechaFin.getText() + "'";

            this.pst = conn.prepareStatement(select);
            this.rs = pst.executeQuery();

            while (this.rs.next()) {
                Trabajador.nombre = rs.getString("T.nombreTrabajador");
                Trabajador.numeroAfiliacion = rs.getString("T.numeroAfiliacion");
                Trabajador.grupoCotizacion = rs.getString("T.grupoCotizacion");
                Trabajador.puesto = rs.getString("T.puesto");
                Convenio.salarioBase = rs.getDouble("salarioBase");
                Nomina.idNomina = rs.getInt("N.idNomina");
                Nomina.nif = rs.getString("N.NIF");
                Nomina.fechaInicio = rs.getString("N.fechaInicio");
                Nomina.fechaFin = rs.getString("N.fechaFin");
                Nomina.horasExtra = rs.getString("N.horasExtra");
                Nomina.horasExtraMayor = rs.getString("N.horasExtraMayor");
                Nomina.horasComplementarias = rs.getString("N.horasComplementarias");
                Nomina.ccInfo = rs.getString("N.ccInfo");
                Nomina.paroInfo = rs.getString("N.paroInfo");
                Nomina.fpInfo = rs.getString("N.fpInfo");
                Nomina.irpfInfo = rs.getString("N.irpfInfo");
                Nomina.totalDevengado = rs.getString("N.totalDevengado");
                Nomina.contingenciasComunes = rs.getString("N.contingenciasComunes");
                Nomina.paro = rs.getString("N.paro");
                Nomina.formacionProfesional = rs.getString("N.formacionProfesional");
                Nomina.irpf = rs.getString("N.irpf");
                Nomina.totalAportaciones = rs.getString("N.totalAportaciones");
                Nomina.totalReducir = rs.getString("N.totalReducir");
                Nomina.importeTotalAPercibir = rs.getString("N.importeTotalAPercibir");
            }

            BufferedWriter bw = null;

            try {
                String xml = "<?xml version='1.0' encoding='utf8'?>\n"
                        + "    <nominas>\n"
                        + "        <nomina>\n"
                        + "            <idNomina>" + Nomina.idNomina + "</idNomina>\n"
                        + "            <trabajador>\n"
                        + "                <nif>" + Nomina.nif + "</nif>\n"
                        + "                <nombreTrabajador>" + Trabajador.nombre + "</nombreTrabajador>\n"
                        + "                <numeroAfiliacion>" + Trabajador.numeroAfiliacion + "</numeroAfiliacion>\n"
                        + "                <puesto>" + Trabajador.puesto + "</puesto>\n"
                        + "                <salarioBase>" + Convenio.salarioBase + "</salarioBase>\n"                        
                        + "            </trabajador>\n"
                        + "            <empresa>\n"
                        + "                <nombreEmpresa>CIDE</nombreEmpresa>\n"
                        + "                <domicilio>C/ L'Arner 3</domicilio>\n"
                        + "                <cif>F07038722</cif>\n"
                        + "                <ccc>CIDECCC</ccc>\n"
                        + "            </empresa>\n"
                        + "            <fechaInicio>" + Nomina.fechaInicio + "</fechaInicio>\n"
                        + "            <fechaFin>" + Nomina.fechaFin + "</fechaFin>\n"
                        + "            <horasExtraordinarias>" + Nomina.horasExtra + "</horasExtraordinarias>\n"
                        + "            <horasExtraordinariasPorFuerzaMayor>" + Nomina.horasExtraMayor + "</horasExtraordinariasPorFuerzaMayor>\n"
                        + "            <horasComplementarias>" + Nomina.horasComplementarias + "</horasComplementarias>\n"
                        + "            <totalDevengado>" + Nomina.totalDevengado + "</totalDevengado>\n"
                        + "            <contingenciasComunes>" + Nomina.contingenciasComunes + "</contingenciasComunes>\n"
                        + "            <paro>" + Nomina.paro + "</paro>\n"
                        + "            <formacionProfesional>" + Nomina.formacionProfesional + "</formacionProfesional>\n"
                        + "            <totalAportaciones>" + Nomina.totalAportaciones + "</totalAportaciones>\n"
                        + "            <totalReducir>" + Nomina.totalReducir + "</totalReducir>\n"
                        + "            <importeLiquidoPercibir>" + Nomina.importeTotalAPercibir + "</importeLiquidoPercibir>\n"
                        + "        </nomina>\n"
                        + "    </nominas>\n";

                String path = "src\\Nominas\\archivos\\xmls\\";

                String nombreArchivo = Trabajador.nombre + " " + fechaInicio.getText() + ".xml";
                File archivo = new File(path + nombreArchivo);

                if (!archivo.exists()) {
                    archivo.createNewFile();
                }

                FileWriter fw = new FileWriter(archivo);
                bw = new BufferedWriter(fw);
                bw.write(xml);
                JOptionPane.showMessageDialog(null, "Archivo XML creado correctamente como " + path + archivo);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                close(rs);
                close(pst);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        
    }//GEN-LAST:event_tablaMouseClicked

    private void fechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioActionPerformed

    //Accion del boton para exportar una nomina en JSON
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String buscarId = """
                            SELECT C.idConvenio, C.nombreConvenio, C.irpf, 
                            C.contingenciasComunes, C.paro, C.formacionProfesional, C.horasExtraordinarias, 
                            C.horasExtraordinariasPorFuerzaMayor, C.salarioBase, T.NIF, T.nombreTrabajador, T.primerApellido, 
                            T.segundoApellido, T.numeroAfiliacion, T.puesto, T.hijos, T.grupoCotizacion, T.idConvenio, T.fechaAntiguedad, 
                            U.id, U.nombreUsuario, U.password, U.rol, U.NIF, N.idNomina, N.NIF, N.fechaInicio,
                            N.fechaFin, N.horasExtra, N.horasExtraMayor, 
                            N.horasComplementarias, N.ccInfo, N.paroInfo, 
                            N.fpInfo, N.irpfInfo, N.totalDevengado, 
                            N.contingenciasComunes, N.paro, N.formacionProfesional, N.irpf, N.totalAportaciones, 
                            N.totalReducir, N.idConvenio, N.importeTotalAPercibir FROM Convenio as C INNER JOIN Trabajador as T 
                            ON C.idConvenio = T.IdConvenio INNER JOIN Usuarios as U ON T.NIF = U.NIF INNER JOIN Nomina as N 
                            ON U.NIF = N.NIF WHERE N.NIF = '""" + nif.getText() + "'"
                    + " AND N.fechaInicio = '" + fechaInicio.getText() + "' AND N.fechaFin = '" + fechaFin.getText() + "'";

            this.pst = conn.prepareStatement(buscarId);
            this.rs = pst.executeQuery();

            while (this.rs.next()) {
                Trabajador.nombre = rs.getString("T.nombreTrabajador");
                Trabajador.numeroAfiliacion = rs.getString("T.numeroAfiliacion");
                Trabajador.grupoCotizacion = rs.getString("T.grupoCotizacion");
                Trabajador.puesto = rs.getString("T.puesto");
                Convenio.salarioBase = rs.getDouble("salarioBase");
                Nomina.idNomina = rs.getInt("N.idNomina");
                Nomina.nif = rs.getString("N.NIF");
                Nomina.fechaInicio = rs.getString("N.fechaInicio");
                Nomina.fechaFin = rs.getString("N.fechaFin");
                Nomina.horasExtra = rs.getString("N.horasExtra");
                Nomina.horasExtraMayor = rs.getString("N.horasExtraMayor");
                Nomina.horasComplementarias = rs.getString("N.horasComplementarias");
                Nomina.ccInfo = rs.getString("N.ccInfo");
                Nomina.paroInfo = rs.getString("N.paroInfo");
                Nomina.fpInfo = rs.getString("N.fpInfo");
                Nomina.irpfInfo = rs.getString("N.irpfInfo");
                Nomina.totalDevengado = rs.getString("N.totalDevengado");
                Nomina.contingenciasComunes = rs.getString("N.contingenciasComunes");
                Nomina.paro = rs.getString("N.paro");
                Nomina.formacionProfesional = rs.getString("N.formacionProfesional");
                Nomina.irpf = rs.getString("N.irpf");
                Nomina.totalAportaciones = rs.getString("N.totalAportaciones");
                Nomina.totalReducir = rs.getString("N.totalReducir");
                Nomina.importeTotalAPercibir = rs.getString("N.importeTotalAPercibir");
            }

            BufferedWriter bw = null;

            try {
                String json = "{\n"
                        + "    \"nominas\": {\n"
                        + "        \"nomina\": {\n"
                        + "            \"idNomina\": " + Nomina.idNomina + ",\n"
                        + "            \"trabajador\": {\n"
                        + "                \"nif\": \"" + Nomina.nif + "\",\n"
                        + "                \"nombreTrabajador\": \"" + Trabajador.nombre + "\",\n"
                        + "                \"numeroAfiliacion\": \"" + Trabajador.numeroAfiliacion + "\",\n"
                        + "                \"puesto\": \"" + Trabajador.puesto + "\",\n"
                        + "                \"salarioBase\": \"" + Convenio.salarioBase + "\"\n"
                        + "            },\n"
                        + "            \"empresa\": {\n"
                        + "                \"nombreEmpresa\": \"CIDE\",\n"
                        + "                \"domicilio\": \"C/L'Arner 3\",\n"
                        + "                \"cif\": \"F07038722\",\n"
                        + "                \"ccc\": \"CIDECCC\"\n"
                        + "            },\n"
                        + "            \"fechaInicio\": \"" + Nomina.fechaInicio + "\",\n"
                        + "            \"fechaFin\": \"" + Nomina.fechaFin + "\",\n"
                        + "            \"horasExtraordinarias\": \"" + Nomina.horasExtra + "\",\n"
                        + "            \"horasExtraordinariasPorFuerzaMayor\": \"" + Nomina.horasExtraMayor + "\",\n"
                        + "            \"horasComplementarias\": \"" + Nomina.horasComplementarias + "\",\n"
                        + "            \"totalDevengado\": \"" + Nomina.totalDevengado + "\",\n"
                        + "            \"contingenciasComunes\": \"" + Nomina.contingenciasComunes + "\",\n"
                        + "            \"paro\": \"" + Nomina.paro + "\",\n"
                        + "            \"formacionProfesional\": \"" + Nomina.formacionProfesional + "\",\n"
                        + "            \"totalAportaciones\": \"" + Nomina.totalAportaciones + "\",\n"
                        + "            \"totalReducir\": \"" + Nomina.totalReducir + "\",\n"
                        + "            \"importeLiquidoPercibir\": \"" + Nomina.importeTotalAPercibir + "\"\n"
                        + "        }\n"
                        + "    }\n"
                        + "}\n";

                String path = "src\\Nominas\\archivos\\jsons\\";

                String nombreArchivo = Trabajador.nombre + " " + fechaInicio.getText() + ".json";
                File archivo = new File(path + nombreArchivo);

                if (!archivo.exists()) {
                    archivo.createNewFile();
                }

                FileWriter fw = new FileWriter(archivo);
                bw = new BufferedWriter(fw);
                bw.write(json);
                JOptionPane.showMessageDialog(null, "Archivo JSON creado correctamente como " + path + archivo);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                close(rs);
                close(pst);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarNominas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarNominas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarNominas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarNominas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarNominas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu fecha;
    private javax.swing.JTextField fechaFin;
    private javax.swing.JTextField fechaInicio;
    private javax.swing.JMenu hora;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nif;
    private javax.swing.JLabel nombreUsuario;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}