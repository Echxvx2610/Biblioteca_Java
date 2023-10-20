/*
 * @ author: Cristian A. Echevarria
 * @ author: Oscar A. Teran
 * @ version: 1.0
 */

package Sistemas_comp.Biblioteca_Java;

import java.util.HashSet;
import java.util.Set;

public class Documento {
    // Atributos superclase
    String Titulo;
    String Autor;
    String ID;
    int AnioPublicacion;
    boolean Disponible;

    // Constructor default
    public Documento() {
        this.Titulo = "";
        this.Autor = "";
        this.ID = "0000";
        this.AnioPublicacion = 0;
        this.Disponible = false;
    }

    // variable para llevar control de ids
    private static Set<String> ids = new HashSet<>();

    public Documento(String Titulo, String Autor, String ID, int AnioPublicacion, boolean Disponible) {
        if (!ids.contains(ID)) {
            this.Titulo = Titulo;
            this.Autor = Autor;
            this.ID = ID;
            this.AnioPublicacion = AnioPublicacion;
            this.Disponible = Disponible;
            // Agregar el ID al conjunto de IDs para evitar duplicados
            ids.add(ID);
        } else {
            // Si el ID ya existe, puedes manejarlo de la forma que desees, por ejemplo,
            // lanza una excepción
            throw new IllegalArgumentException("El ID ya existe.");
        }
    }
    // Metodos get y set
    //

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public int getAnioPublicacion() {
        return AnioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        AnioPublicacion = anioPublicacion;
    }

    public boolean isDisponible() {
        return Disponible;
    }

    public void setDisponible(boolean disponible) {
        Disponible = disponible;
    }

    public static Set<String> getIds() {
        return ids;
    }

    public static void setIds(Set<String> ids) {
        Documento.ids = ids;
    }

    @Override
    public String toString() {
        return "Informacion del Documento:\n" +
                "Titulo: " + Titulo + "\n" +
                "Autor: " + Autor + "\n" +
                "ID: " + ID + "\n" +
                "Año de publicacion: " + AnioPublicacion + "\n" +
                "Disponible: " + Disponible + "\n";
    }
}
