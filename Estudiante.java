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

    // constructor default
    public Estudiante() {
        this.nombre = "";
        this.apellido = "";
        this.carrera = "";
        this.numeroControl = "";
    }

    public Estudiante(String nombre, String apellido, String carrera, String numeroControl) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.numeroControl = numeroControl;
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

    @Override
    public String toString() {
        return "Informacion Estudiante:\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Carrera: " + carrera + "\n" +
                "Numero de control: " + numeroControl + "\n";
    }
}
