/*
 * @ author: Cristian A. Echevarria
 * @ author: Oscar A. Teran
 * @ version: 1.0
 */
package Sistemas_comp.Biblioteca_Java;

public class Libro extends Documento {
    // Atributos propios de clase hija
    private String ISBN;
    private String editorial;
    private int edicion;

    // Constructor default
    public Libro() {
        // atributos superclase
        super();
        this.ISBN = "";
        this.editorial = "";
        this.edicion = 0;
    }

    // Construcor con todos los atributos
    public Libro(String titulo, String autor, String ID, int anioPublicacion, boolean disponible, String iSBN,
            String editorial, int edicion) {
        super(titulo, autor, ID, anioPublicacion, disponible);
        ISBN = iSBN;
        this.editorial = editorial;
        this.edicion = edicion;
    }

    // Metodos get and set
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    // Getter and Setter methods for edicion
    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String toString() {
        return super.toString() +
                "ISBN: " + ISBN + "\n" +
                "Editorial: " + editorial + "\n" +
                "Edicion: " + edicion + "\n";

    }
}
