/*
 * @ author: Cristian A. Echevarria
 * @ author: Oscar A. Teran
 * @ version: 1.0
 */

package Sistemas_comp.Biblioteca_Java;

import java.util.Scanner;

public class Biblioteca {
    // variables globales
    static Biblioteca control = new Biblioteca();
    Scanner sc = new Scanner(System.in);
    int opcion;
    // Array de Documentos
    Documento documentos[] = new Documento[100];
    int cantidadDocumentos = 0;
    // Array de Libros
    Libro libros[] = new Libro[100];
    int cantidadLibros = 0;

    public static void main(String[] args) {
        // creacion de un objeto para testear Documento
        Documento miDocumento = new Documento("El retrano de la muerte", "Ray Bradbury", "0001", 1955, true);
        System.out.println(miDocumento);
        Libro miLibro = new Libro();
        System.out.println(miLibro);

        control.menu();
    }

    public void menu() {
        // ciclo para mostrar las opciones del menú
        do {
            // menú del programa el cual pide ingresar una opción
            System.out.println("\n --- [BIENVENIDO A LA BIBLIOTECA VIRTUAL] --- \n");
            System.out.println("              --- [MENU] ---");
            System.out.println("[1] Inventario");
            System.out.println("[2] Prestar libro");
            System.out.println("[3] Prestar una revista");
            System.out.println("[4] Devoluciones");
            System.out.println("[5] Prestamos");
            System.out.println("[6] Deudores");
            System.out.println("[7] Salir del programa");
            System.out.print("Selecciona una opción: ");

            // se guarda la opción en la variable opcion
            opcion = sc.nextInt();

            switch (opcion) {
                case -1: // llamar al método mostrar documentos
                    control.mostrarDocumentos();
                    break;
                case 0: // llamar al método registrar documento
                    control.registrarDocumento();
                    break;
                case 1: // llamar al método ver inventario
                    control.verInventario();
                    break;
                case 2: // llamar al método prestar libro
                    control.prestarLibro();
                    break;
                case 3: // llamar al método prestar una revista
                    control.prestarRevista();
                    break;
                case 4: // llamar al método devoluciones
                    control.devoluciones();
                    break;
                case 5: // llamar al método prestamos
                    control.prestamos();
                    break;
                case 6: // llamar al método Deudores
                    control.deudores();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default: // cualquier otra opción no es válida
                    System.out.println("La opción " + opcion + " no es válida");
            } // fin del swith menú
        } while (opcion != 7); // se sale del menú si seleccionan 7
    }

    void registrarDocumento() {
        // 1. Crear un objeto para testear Documento
        Documento documento = new Documento();
        sc.nextLine();
        // 2. Pedir los datos del documento
        System.out.println("Ingresa los datos del documento");
        System.out.print("Titulo: ");
        documento.setTitulo(sc.nextLine());
        System.out.print("Autor: ");
        documento.setAutor(sc.nextLine());
        System.out.print("ID: ");
        documento.setID(sc.nextLine());
        System.out.print("Anio de publicacion: ");
        documento.setAnioPublicacion(sc.nextInt());
        sc.nextLine();
        System.out.print("Disponible: ");
        documento.setDisponible(sc.nextBoolean());
        // 3. Llamar al método para registrar el documento
        documentos[cantidadDocumentos] = documento;
        cantidadDocumentos++;
    }

    void mostrarDocumentos() {
        for (int i = 0; i < cantidadDocumentos; i++) {
            System.out.println("Documento " + (i + 1) + ":" + "\n" + documentos[i] + "\n");
        }
    }

    void verInventario() {
        System.out.println("Listando inventario....");
    }

    void prestarLibro() {
        System.out.println("Prestando un libro....");
    }

    void prestarRevista() {
        System.out.println("Prestando una revista....");
    }

    void devoluciones() {
        System.out.println("Realizando devoluciones....");
    }

    void prestamos() {
        System.out.println("Realizando prestamos....");
    }

    void deudores() {
        System.out.println("Listando deudores....");
    }
}
