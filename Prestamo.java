/*
* @ author: Cristian Echevarria
* @ author: Oscar Teran
*/

// Pendientes:
// 1. agregar que los libros se presten por 7 días y las revistas por 3 días

package Sistemas_comp.Biblioteca_Java;

import java.util.HashSet;
import java.util.Set;
import java.util.GregorianCalendar;

public class Prestamo {
    // atributos de la clase Prestamo
    public String id;
    public String numeroControl;
    public String idDocumento;
    public GregorianCalendar fechaPrestamo;
    public GregorianCalendar fechaVencimiento;
    public boolean conAtraso;

    // constructor default
    public Prestamo() {
        this.id = "0000";
        this.numeroControl = "";
        this.idDocumento = "0000";
        this.fechaPrestamo = new GregorianCalendar();
        this.fechaVencimiento = new GregorianCalendar();
        this.conAtraso = false;
    }

    private static Set<String> ids = new HashSet<>();

    // constructor con parámetros
    public Prestamo(String id, String numeroControl, String idDocumento, GregorianCalendar fechaPrestamo,
            GregorianCalendar fechaVencimiento, boolean conAtraso) {
        if (!ids.contains(id)) {
            this.id = id;
            this.numeroControl = numeroControl;
            this.idDocumento = idDocumento;
            this.fechaPrestamo = fechaPrestamo;
            this.fechaVencimiento = fechaVencimiento;
            this.conAtraso = conAtraso;
            // Agregar el ID al conjunto de IDs para evitar duplicados
            ids.add(id);
        } else {
            // Si el ID ya existe, puedes manejarlo de la forma que desees, por ejemplo,
            // lanza una excepción
            throw new IllegalArgumentException("El ID ya existe.");
        }
    }

    // getter y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public GregorianCalendar getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(GregorianCalendar fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public GregorianCalendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(GregorianCalendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isConAtraso() {
        return conAtraso;
    }

    public void setConAtraso(boolean conAtraso) {
        this.conAtraso = conAtraso;
    }

    public static Set<String> getIds() {
        return ids;
    }

    public static void setIds(Set<String> ids) {
        Prestamo.ids = ids;
    }

    // método toString
    @Override
    public String toString() {
        return "Número de control: " + numeroControl +
                "\nID del documento: " + idDocumento +
                "\nFecha de préstamo: " + fechaPrestamo +
                "\nFecha de vencimiento: " + fechaVencimiento +
                "\nCon atraso: " + conAtraso;
    }
}
