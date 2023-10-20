package Clases.Biblioteca;

public class Libro {
    // atributos
    public String titulo;
    public String autor;
    public String isbn;
    public int anioPublicacion;
    public String genero;
    public int numeroPaginas;
    public boolean enStock;

    // método constructor
    Libro();
    this.titulo = "";
    this.autor = "";
    this.isbn = "";
    this.anioPublicacion = 0;
    this.genero = "genero";
    this.numeroPaginas = 0;
    this.enStock = false;

    // sobrecarga de constructores
    Libro(String titulo, String autor, String isbn, int anioPublicacion, String genero, int numeroPaginas, boolean enStock){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
    }

    // métodos get y set
    public String getTitulo(){
        return this.titulo;
    }

    public String setTitulo(){
        this.titulo = titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public String setAutor(){
        this.autor = autor;
    }
}
