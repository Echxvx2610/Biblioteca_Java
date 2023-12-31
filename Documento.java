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
    String titulo;
    String autor;
    String ID;
    int anioPublicacion;
    boolean disponible;

    // Constructor default
    public Documento() {
        this.titulo = "";
        this.autor = "";
        this.ID = "0000";
        this.anioPublicacion = 0;
        this.disponible = false;
    }

    // variable para llevar control de ids
    private static Set<String> ids = new HashSet<>();

    public Documento(String Titulo, String Autor, String ID, int AnioPublicacion, boolean Disponible) {
        if (!ids.contains(ID)) {
            this.titulo = Titulo;
            this.autor = Autor;
            this.ID = ID;
            this.anioPublicacion = AnioPublicacion;
            this.disponible = Disponible;
            // Agregar el ID al conjunto de IDs para evitar duplicados
            ids.add(ID);
        } else {
            // Si el ID ya existe, puedes manejarlo de la forma que desees, por ejemplo,
            // lanza una excepción
            throw new IllegalArgumentException("El ID ya existe.");
        }
    }
    // getters y setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        this.ID = iD;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public static Set<String> getIds() {
        return ids;
    }

    public static void setIds(Set<String> ids) {
        Documento.ids = ids;
    }

    public String toString() {
        return "Informacion del Documento:\n" +
                "Titulo: " + titulo + "\n" +
                "Autor: " + autor + "\n" +
                "ID: " + ID + "\n" +
                "Año de publicacion: " + anioPublicacion + "\n" +
                "Disponible: " + disponible + "\n";
    }
}
