/*
* @ author: Cristian Echevarria
* @ author: Oscar Teran
*/

package Sistemas_comp.Biblioteca_Java;

public class Revista extends Documento {
    // atributos propios de la clase
    private String ISSN;
    private String nombre;
    private int volumen;

    // constructor default
    public Revista() {
        super();
        this.ISSN = "";
        this.nombre = "";
        this.volumen = 0;
    }

    public Revista(String Titulo, String Autor, String ID, int AnioPublicacion, boolean Disponible, String ISSN,
            String nombre, int volumen) {
        super(Titulo, Autor, ID, AnioPublicacion, Disponible);
        this.ISSN = ISSN;
        this.nombre = nombre;
        this.volumen = volumen;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String iSSN) {
        ISSN = iSSN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    void generarTabla() {
        // Imprimir la cabecera de la tabla
        System.out.println(
                "________________________________________________________________________________________________________\n");
        System.out.printf("%-7s %-20s %-15s %-10s %-9s %-20s %-10s %-10s\n",
                "ID", "Titulo", "Autor", "Año_Pub",
                "Disp", "ISSN", "Nombre", "Vol");
        System.out.println(
                "________________________________________________________________________________________________________");

        for (Revista revista : revistas) {
            System.out.printf("%-7s %-20s %-15s %-10s %-9s %-20s %-10s %-10s\n",
                    revista.getID(),
                    revista.getTitulo(),
                    revista.getAutor(),
                    revista.getAnioPublicacion(),
                    revista.isDisponible(),
                    revista.getISSN(),
                    revista.getNombre(),
                    revista.getVolumen());
        }
        // Pie de la tabla
        System.out.println(
                "_____________________________________________________________________________________________________\n");
    }

    @Override
    public String toString() {
        return super.toString() +
                "ISSN: " + ISSN + "\n" +
                "Nombre: " + nombre + "\n" +
                "Volumen: " + volumen + "\n";

    }

}
