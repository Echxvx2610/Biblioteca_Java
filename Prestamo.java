/*
* @ author: Cristian Echevarria
* @ author: Oscar Teran
*/

// Pendientes:
// 1. agregar que los libros se presten por 7 días y las revistas por 3 días

package Sistemas_comp.Biblioteca_Java;

import java.util.HashSet;
import java.util.Set;
import java.text.SimpleDateFormat;
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

    void generarTabla() {
        // Imprimir la cabecera de la tabla
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(
                "______________________________________________________________________________________\n");
        System.out.printf("%-5s %-10s %-13s %-18s %-20s %-10s\n",
                "ID", "No_Control", "ID_Documento", "Fecha_Prestamo", "Fecha_Vencimiento",
                "Con Atraso");
        System.out.println(
                "______________________________________________________________________________________");

        for (Prestamo prestamo : prestamos) {
            String fechaPrestamoStr = dateFormat.format(prestamo.getFechaPrestamo().getTime());
            String fechaVencimientoStr = dateFormat.format(prestamo.getFechaVencimiento().getTime());
            System.out.printf("%-5s %-15s %-8s %-20s %-20s %-10s\n",
                    prestamo.getId(),
                    prestamo.getNumeroControl(),
                    prestamo.getIdDocumento(),
                    fechaPrestamoStr,
                    fechaVencimientoStr,
                    prestamo.isConAtraso());
        }
        // Pie de la tabla
        System.out.println(
                "______________________________________________________________________________________");
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
