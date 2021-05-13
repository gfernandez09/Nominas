package nominas.objetos;

//Clase convenio para tratar los objetos de convenio
public class Convenio {

    public static String idConvenio;
    public static String nombreConvenio;
    public static double irpf;
    public static double contingenciasComunes;
    public static double paro;
    public static double formacionProfesional;
    public static double horasExtraordinarias;
    public static double horasExtraordinariasPorFuerzaMayor;
    public static double salarioBase;

    //Getters y setters
    public static String getIdConvenio() {
        return idConvenio;
    }

    public static void setIdConvenio(String idConvenio) {
        Convenio.idConvenio = idConvenio;
    }

    public static String getNombreConvenio() {
        return nombreConvenio;
    }

    public static void setNombreConvenio(String nombreConvenio) {
        Convenio.nombreConvenio = nombreConvenio;
    }

    public static double getIrpf() {
        return irpf;
    }

    public static void setIrpf(double irpf) {
        Convenio.irpf = irpf;
    }

    public static double getContingenciasComunes() {
        return contingenciasComunes;
    }

    public static void setContingenciasComunes(double contingenciasComunes) {
        Convenio.contingenciasComunes = contingenciasComunes;
    }

    public static double getParo() {
        return paro;
    }

    public static void setParo(double paro) {
        Convenio.paro = paro;
    }

    public static double getFormacionProfesional() {
        return formacionProfesional;
    }

    public static void setFormacionProfesional(double formacionProfesional) {
        Convenio.formacionProfesional = formacionProfesional;
    }

    public static double getHorasExtraordinarias() {
        return horasExtraordinarias;
    }

    public static void setHorasExtraordinarias(double horasExtraordinarias) {
        Convenio.horasExtraordinarias = horasExtraordinarias;
    }

    public static double getHorasExtraordinariasPorFuerzaMayor() {
        return horasExtraordinariasPorFuerzaMayor;
    }

    public static void setHorasExtraordinariasPorFuerzaMayor(double horasExtraordinariasPorFuerzaMayor) {
        Convenio.horasExtraordinariasPorFuerzaMayor = horasExtraordinariasPorFuerzaMayor;
    }

    public static double getSalarioBase() {
        return salarioBase;
    }

    public static void setSalarioBase(double salarioBase) {
        Convenio.salarioBase = salarioBase;
    }
}
