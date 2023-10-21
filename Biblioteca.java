/*
 * @ author: Cristian A. Echevarria
 * @ author: Oscar A. Teran
 * @ version: 1.0
 */

package Sistemas_comp.Biblioteca_Java;

import java.util.GregorianCalendar;
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
    // Array de Revistas
    Revista revistas[] = new Revista[100];
    int cantidadRevistas = 0;
    // Array de Estudiantes
    Estudiante estudiantes[] = new Estudiante[20];
    int cantidadEstudiantes = 0;
    // Array de Prestamos
    Prestamo prestamos[] = new Prestamo[10];
    int cantidadPrestamos = 0;

    public static void main(String[] args) {

        // control.registro();
        // control.generarTablaEstudiantes();
        // control.generarTablaLibros();
        // control.generarTablaRevistas();
        control.generarTablaPrestamos();
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

    void registro() {
        // registro de array 20 estudiantes
        estudiantes[0] = new Estudiante("Cristian", "Echevarria", "Sistemas Computacionales", "2376005");
        estudiantes[1] = new Estudiante("Oscar", "Teran", "Sistemas Computacionales", "2376006");
        estudiantes[2] = new Estudiante("Israel ", "Tejeda", "Sistemas Computacionales", "2376007");
        estudiantes[3] = new Estudiante("Cristian", "Malacara", "Sistemas Computacionales", "2376008");
        estudiantes[4] = new Estudiante("Rosa", "Melano", "Sistemas Computacionales", "2376009");
        estudiantes[5] = new Estudiante("Alma", "Marcela", "Sistemas Computacionales", "2376005");
        estudiantes[6] = new Estudiante("Elvis", "Cocho", "Sistemas Computacionales", "2376005");
        estudiantes[7] = new Estudiante("Bad bunny", "Mamberroi", "Sistemas Computacionales", "2376005");
        estudiantes[8] = new Estudiante("Luis Miguel", "Ferras", "Sistemas Computacionales", "2376005");
        estudiantes[9] = new Estudiante("Felix", "Navarro", "Sistemas Computacionales", "2376005");
        estudiantes[10] = new Estudiante("Alejandro", "Mendoza", "Sistemas Computacionales", "2376005");
        estudiantes[11] = new Estudiante("Oscar", "Ojeda", "Sistemas Computacionales", "2376006");
        estudiantes[12] = new Estudiante("Gael ", "Olea", "Sistemas Computacionales", "2376007");
        estudiantes[13] = new Estudiante("Alonso", "Marquez", "Sistemas Computacionales", "2376008");
        estudiantes[14] = new Estudiante("Nestor", "Romero", "Sistemas Computacionales", "2376009");
        estudiantes[15] = new Estudiante("Abelardo", "Castro", "Sistemas Computacionales", "2376005");
        estudiantes[16] = new Estudiante("Consuelo", "Sanchez", "Sistemas Computacionales", "2376005");
        estudiantes[17] = new Estudiante("Alejandra", "Ruiz", "Sistemas Computacionales", "2376005");
        estudiantes[18] = new Estudiante("Luis", "Zazueta", "Sistemas Computacionales", "2376005");
        estudiantes[19] = new Estudiante("Raul", "Felix", "Sistemas Computacionales", "2376005");

        // registrar Libros
        libros[0] = new Libro("El retrato de la muerte", "Ray Bradbury", "0001", 1955, true, "434JKLJFAISF7", "Planeta",
                1);
        libros[1] = new Libro("Solo tu", "Paulo Cohelo", "0002", 1955, true, "DJF223JKMNA", "Planeta", 3);
        libros[2] = new Libro("La dama de negro", "Guillermo Del Toro", "0003", 1955, true, "KAJSKDJAKSFU8674B",
                "Planeta", 3);
        libros[3] = new Libro("La autopista", "Juan Rulfo", "0004", 1955, true, "ASJDAFS8743", "Planeta", 3);
        libros[4] = new Libro("Breaking bad", "Ray Bradbury", "0005", 1955, true, "ASKFJAS7530", "Planeta", 3);
        libros[5] = new Libro("Los infinitos", "Dr.Felix", "0006", 1955, true, "DAOOIASD8263", "Planeta", 3);
        libros[6] = new Libro("Principio del derecho", "Ray Bradbury", "0007", 1955, true, "ASDU6ASFHKAJFH", "Planeta",
                3);
        libros[7] = new Libro("Que pasa con mi cuerpo?", "Jordi Rosado", "0008", 1955, true, "AS8D7AFHSJFASF",
                "Planeta", 3);
        libros[8] = new Libro("las cronicas de Narnia", "C.S. Lewis", "0009", 1955, true, "GOJOUE8978A6GS", "Planeta",
                3);
        libros[9] = new Libro("Piratas del Caribe", "Ray Bradbury", "0010", 1955, true, "POIFAOSPFAI977", "Planeta", 3);
        libros[10] = new Libro("El Principio", "Ray Bradbury", "0011", 1955, true, "IKAFOIA8S66AFG", "Planeta", 3);

        // registrar Revistas
        revistas[0] = new Revista("10 habitos exitosos", "Sandra Bullock", "0022", 1955, true, "KLAHSFIASFU78903",
                "Planeta", 1);
        revistas[1] = new Revista("Muy interesante", "Sandra Bullock", "0012", 1955, true, "ASOFIAS7FA65", "Planeta",
                3);
        revistas[2] = new Revista("National Geographic", "Ray Bradbury", "0013", 1955, true, "ASUYTFASYGABJKSD",
                "Planeta", 3);
        revistas[3] = new Revista("SpaceX", "Elon Musk", "0014", 1955, true, "KAHSFUAISTFA67S", "Planeta", 3);
        revistas[4] = new Revista("Tesla el gigante", "Elon Musk", "0015", 1955, true, "76A54768UHJKAFDS", "Planeta",
                3);
        revistas[5] = new Revista("History channel", "Ray Bradbury", "0016", 1955, true, "A795S87ASFGKJA", "Planeta",
                3);
        revistas[6] = new Revista("Animal Planet", "Ray Bradbury", "0017", 1955, true, "ASOIFYAS76FA1", "Planeta", 3);
        revistas[7] = new Revista("Para adultos", "Ray Bradbury", "0018", 1955, true, "OAIUSI9FI07AS08F", "Planeta", 3);
        revistas[8] = new Revista("Emprendedores", "Ray Bradbury", "0019", 1955, true, "APS9F87A9SFDAHSJD", "Planeta",
                3);
        revistas[9] = new Revista("Ecomista", "Ray Bradbury", "0020", 1955, true, "87A5S68DASGHDJAAS", "Planeta", 3);
        revistas[10] = new Revista("Cosmopolitan", "Ray Bradbury", "0021", 1955, true, "89567A467DSGYAGS", "Planeta",
                3);

        // registrar Prestamos
        prestamos[0] = new Prestamo(001, "23760067", 1, new GregorianCalendar(2023, 10, 21),
                new GregorianCalendar(2023, 10, 28), false);
        prestamos[1] = new Prestamo(002, "23760068", 2, new GregorianCalendar(2023, 10, 21),
                new GregorianCalendar(2023, 10, 28), false);
        prestamos[2] = new Prestamo(003, "23760069", 3, new GregorianCalendar(2023, 10, 21),
                new GregorianCalendar(2023, 10, 28), false);
        prestamos[3] = new Prestamo(004, "23760070", 4, new GregorianCalendar(2023, 10, 21),
                new GregorianCalendar(2023, 10, 28), false);
        prestamos[4] = new Prestamo(005, "23760071", 5, new GregorianCalendar(2023, 10, 21),
                new GregorianCalendar(2023, 10, 28), false);
        prestamos[5] = new Prestamo(006, "23760072", 6, new GregorianCalendar(2023, 10, 21),
                new GregorianCalendar(2023, 10, 28), false);
        prestamos[6] = new Prestamo(007, "23760073", 7, new GregorianCalendar(2023, 10, 21),
                new GregorianCalendar(2023, 10, 28), false);
        prestamos[7] = new Prestamo(0011, "23760074", 8, new GregorianCalendar(2023, 10, 21),
                new GregorianCalendar(2023, 10, 28), false);
        prestamos[8] = new Prestamo(0012, "23760075", 9, new GregorianCalendar(2023, 10, 21),
                new GregorianCalendar(2023, 10, 28), false);
        prestamos[9] = new Prestamo(010, "23760076", 10, new GregorianCalendar(2023, 10, 21),
                new GregorianCalendar(2023, 10, 28), false);
    }

    void generarTablaEstudiantes() {
        // Imprimir la cabecera de la tabla
        System.out.println(
                "----------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-30s %-20s\n", "Nombre", "Apellido", "\tCarrera", "Número de Estudiante");
        System.out.println(
                "----------------------------------------------------------------------------------------------");

        // Iterar a través del array de estudiantes y mostrar la información de cada
        // estudiante
        for (int i = 0; i < estudiantes.length; i++) {
            Estudiante estudiante = estudiantes[i];
            if (estudiante != null) {
                System.out.printf("%-20s %-20s %-30s %-20s\n",
                        estudiante.getNombre(),
                        estudiante.getApellido(),
                        estudiante.getCarrera(),
                        estudiante.getNumeroControl());
            }
        }
        // Pie de la tabla
        System.out.println(
                "----------------------------------------------------------------------------------------------");
    }

    void generarTablaPrestamos() {
        // Imprimir la cabecera de la tabla
        System.out.println(
                "---------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-10s %-20s %-10s\n",
                "\tID", "ID_Documento", "Fecha_Prestamo", "Fecha_Vencimiento", "Con Atraso");
        System.out.println(
                "---------------------------------------------------------------------------------------------");

        for (int i = 0; i < prestamos.length; i++) {
            Prestamo prestamo = prestamos[i];
            if (prestamo != null) {
                System.out.printf("%-20s %-20s %-10s %-20s %-10s\n",
                        prestamo.getId(),
                        prestamo.getIdDocumento(),
                        prestamo.getFechaPrestamo(),
                        prestamo.getFechaVencimiento(),
                        prestamo.isConAtraso());
            }
        }
    }

    void generarTablaLibros() {
        // Imprimir la cabecera de la tabla
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-10s %-20s %-10s %-18s %-10s %-5s\n",
                "\tTitulo", "Autor", "ID", "Año_Pub",
                "Disp", "ISBN", "Editorial", "Edicion");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < libros.length; i++) {
            Libro libro = libros[i];
            if (libro != null) {
                System.out.printf("%-25s %-20s %-10s %-20s %-10s %-20s %-10s %-5s\n",
                        libro.getTitulo(),
                        libro.getAutor(),
                        libro.getID(),
                        libro.getAnioPublicacion(),
                        libro.isDisponible(),
                        libro.getISBN(),
                        libro.getEditorial(),
                        libro.getEdicion());
            }
        }

        // Pie de la tabla
        System.out.println(
                "------------------------------------------------------------------------------------------------------");
    }

    void generarTablaRevistas() {
        // Imprimir la cabecera de la tabla
        System.out.println(
                "---------------------------------------------------------------------------------------------");
        System.out.printf("%-30s %-20s %-8s %-15s %-12s %-25s %-20s %-10s\n",
                "Titulo", "Autor", "ID", "Año_Pub",
                "Disp", "ISSN", "Nombre", "Vol");
        System.out.println(
                "---------------------------------------------------------------------------------------------");

        for (int i = 0; i < revistas.length; i++) {
            Revista revista = revistas[i];
            if (revista != null) {
                System.out.printf("%-30s %-20s %-8s %-15s %-12s %-25s %-20s %-10s\n",
                        revista.getTitulo(),
                        revista.getAutor(),
                        revista.getID(),
                        revista.getAnioPublicacion(),
                        revista.isDisponible(),
                        revista.getISSN(),
                        revista.getNombre(),
                        revista.getVolumen());
            }
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
