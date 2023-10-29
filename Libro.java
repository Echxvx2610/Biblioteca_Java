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
        this.ISBN = iSBN;
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

    void generarTabla() {
        // Imprimir la cabecera de la tabla
        System.out.println(
                "_______________________________________________________________________________________________________________________\n");
        System.out.printf("%-7s %-25s %-20s %-10s %-12s %-20s %-10s %-5s\n",
                "ID", "Titulo", "Autor", "Año Pub.",
                "Edición", "ISBN", "Editorial", "Disponible");
        System.out.println(
                "_______________________________________________________________________________________________________________________");

        for (Libro libro : libros) {
            System.out.printf("%-7s %-25s %-20s %-12s %-10s %-20s %-10s %-5s\n",
                    libro.getID(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getAnioPublicacion(),
                    libro.getEdicion(),
                    libro.getISBN(),
                    libro.getEditorial(),
                    libro.isDisponible());
        }
        // Pie de la tabla
        System.out.println(
                "_______________________________________________________________________________________________________________________\n");
    }

    public String toString() {
        return super.toString() +
                "ISBN: " + ISBN + "\n" +
                "Editorial: " + editorial + "\n" +
                "Edicion: " + edicion + "\n";

    }
}
