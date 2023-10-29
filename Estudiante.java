/**
 * @author: Cristian Echevarria
 * @author: Oscar Teran
 */

package Sistemas_comp.Biblioteca_Java;

public class Estudiante {
    // atributos
    private String nombre;
    private String apellido;
    private String carrera;
    private String numeroControl;
    private boolean deudor;

    // constructor default
    public Estudiante() {
        this.nombre = "";
        this.apellido = "";
        this.carrera = "";
        this.numeroControl = "";
        this.deudor = false;
    }

    public Estudiante(String nombre, String apellido, String carrera, String numeroControl, boolean deudor) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.numeroControl = numeroControl;
        this.deudor = deudor;
    }

    // getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public boolean isDeudor() {
        return deudor;
    }

    public void setDeudor(boolean deudor) {
        this.deudor = deudor;
    }

    void generarTabla() {
        // Imprimir la cabecera de la tabla
        System.out.println(
                "____________________________________________________________________\n");
        System.out.printf("%-15s %-17s %-20s %-20s\n",
                "No. Control", "Nombre", "Apellido", "Carrera");
        System.out.println(
                "__________________________________________________________________________");

        // Recorrer arraylist de estudiantes y mostrar la información de cada
        // estudiante
        for (Estudiante estudiante : estudiantes) {
            System.out.printf("%-15s %-17s %-20s %-20s\n",
                    estudiante.getNumeroControl(),
                    estudiante.getNombre(),
                    estudiante.getApellido(),
                    estudiante.getCarrera());
        }
        // Pie de la tabla
        System.out.println(
                "____________________________________________________________________________");
    }

    @Override
    public String toString() {
        return "Informacion Estudiante:\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Carrera: " + carrera + "\n" +
                "Numero de control: " + numeroControl + "\n";
    }
}
