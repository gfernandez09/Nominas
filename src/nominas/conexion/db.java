package nominas.conexion;

import java.sql.*;
import javax.swing.JOptionPane;

//Clase para las conexiones, rs y stmt con la base de datos.
public class db {

    private static final String JDBC_URL = "jdbc:MySQL://localhost:3306/nominas";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    //Metodo para obtener la conexion con la base de datos
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        }
    }

    //Metodo para cerrar el resultset
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    //Metodo para cerrar el Statement
    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    //Metodo para cerrar el PreparedStatement
    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    //Metodo para cerrar la conexion
    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
