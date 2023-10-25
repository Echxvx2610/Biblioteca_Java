/*
* @ author: Cristian Echevarria
* @ author: Oscar Teran
*/

// Pendientes:
// 1. agregar que los libros se presten por 7 días y las revistas por 3 días

package Sistemas_comp.Biblioteca_Java;

import java.util.GregorianCalendar;

public class Prestamo {
    // atributos de la clase Prestamo
    public String id;
    public String numeroControl;
    public int idDocumento;
    public GregorianCalendar fechaPrestamo;
    public GregorianCalendar fechaVencimiento;
    public boolean conAtraso;

    // constructor default
    public Prestamo() {
        this.id = "0000";
        this.numeroControl = "";
        this.idDocumento = 0;
        this.fechaPrestamo = new GregorianCalendar();
        this.fechaVencimiento = new GregorianCalendar();
        this.conAtraso = false;
    }

    // constructor con parámetros
    public Prestamo(String id, String numeroControl, int idDocumento, GregorianCalendar fechaPrestamo,
            GregorianCalendar fechaVencimiento, boolean conAtraso) {
        this.id = id;
        this.numeroControl = numeroControl;
        this.idDocumento = idDocumento;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaVencimiento = fechaVencimiento;
        this.conAtraso = conAtraso;
    }

    // getter y setter
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

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
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
