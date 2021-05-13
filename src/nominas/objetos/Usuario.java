package nominas.objetos;

//Clase para el tratamiento de los objetos de los usuarios
public class Usuario {

    //Atributos
    public static String nombreUsuario;
    public static int id;
    public static String password;
    public static String rol;
    public static String nif;

    //Constructor de la clase
    public Usuario(String nombreUsuario, int id, String password, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.id = id;
        this.password = password;
        this.rol = rol;
    }

    //Constructor de nombre, contraseña y rol del usuario
    public Usuario(String nombreUsuario, String password, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
    }

    //Constructor del id del usuario
    public Usuario(int id) {
        this.id = id;
    }

    //Getters y setters
    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", id=" + id + ", password=" + password + ", rol=" + rol + '}';
    }

}
