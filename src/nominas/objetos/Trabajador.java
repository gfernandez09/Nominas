package nominas.objetos;

public class Trabajador {

    public static String NIF;
    public static String nombre;
    public static String primerApellido;
    public static String segundoApellido;
    public static String puesto;
    public static String hijos;
    public static String fechaAntiguedad;
    public static String numeroAfiliacion;
    public static String grupoCotizacion;
    public static String idConvenio;

    public Trabajador(String CIF, String nombre, String primerApellido, String segundoApellido, String puesto, String hijos, String antiguedad, String numeroAfiliacion, String numeroCotizacion, String idConvenio) {
        Trabajador.NIF = CIF;
        Trabajador.nombre = nombre;
        Trabajador.primerApellido = primerApellido;
        Trabajador.segundoApellido = segundoApellido;
        Trabajador.puesto = puesto;
        Trabajador.hijos = hijos;
        Trabajador.fechaAntiguedad = antiguedad;
        Trabajador.numeroAfiliacion = numeroAfiliacion;
        Trabajador.grupoCotizacion = grupoCotizacion;
        Trabajador.idConvenio = idConvenio;
    }

    public static String getHijos() {
        return hijos;
    }

    public static void setHijos(String hijos) {
        Trabajador.hijos = hijos;
    }

    public static String getCIF() {
        return NIF;
    }

    public static void setCIF(String CIF) {
        Trabajador.NIF = CIF;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Trabajador.nombre = nombre;
    }

    public static String getPrimerApellido() {
        return primerApellido;
    }

    public static void setPrimerApellido(String primerApellido) {
        Trabajador.primerApellido = primerApellido;
    }

    public static String getSegundoApellido() {
        return segundoApellido;
    }

    public static void setSegundoApellido(String segundoApellido) {
        Trabajador.segundoApellido = segundoApellido;
    }

    public static String getPuesto() {
        return puesto;
    }

    public static void setPuesto(String puesto) {
        Trabajador.puesto = puesto;
    }

    public static String getAntiguedad() {
        return fechaAntiguedad;
    }

    public static void setAntiguedad(String antiguedad) {
        Trabajador.fechaAntiguedad = antiguedad;
    }

    public static String getNumeroAfiliacion() {
        return numeroAfiliacion;
    }

    public static void setNumeroAfiliacion(String numeroAfiliacion) {
        Trabajador.numeroAfiliacion = numeroAfiliacion;
    }

    public static String getGrupoCotizacion() {
        return grupoCotizacion;
    }

    public static void setGrupoCotizacion(String grupoCotizacion) {
        Trabajador.grupoCotizacion = grupoCotizacion;
    }

    public static String getIdConvenio() {
        return idConvenio;
    }

    public static void setIdConvenio(String idConvenio) {
        Trabajador.idConvenio = idConvenio;
    }

}
