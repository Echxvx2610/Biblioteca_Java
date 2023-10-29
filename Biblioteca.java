/*
 * @ author: Cristian A. Echevarria
 * @ author: Oscar A. Teran
 * @ version: 1.0
 */
package Sistemas_comp.Biblioteca_Java;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.print.Doc;
import java.text.SimpleDateFormat;

public class Biblioteca {
        // variables globales
        static Biblioteca control = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcion;
        // Arraylist de Documentos
        private static ArrayList<Documento> documentos = new ArrayList<>();
        int cantidadDocumentos = 0;
        // ArrayList de Libros
        private static ArrayList<Libro> libros = new ArrayList<>();
        int cantidadLibros = 0;
        // ArrayList de Revistas
        private static ArrayList<Revista> revistas = new ArrayList<>();
        int cantidadRevistas = 0;
        // ArrayList de Estudiantes
        private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
        int cantidadEstudiantes = 0;
        // ArrayList de Prestamos
        private static ArrayList<Prestamo> prestamos = new ArrayList<>();
        int cantidadPrestamos = 0;

        public static void main(String[] args) {
                control.registro();
                // control.generarTablaEstudiantes();
                // control.generarTablaLibros();
                // control.generarTablaRevistas();
                // control.generarTablaPrestamos();
                control.obtenerFechaActual();
                control.calcularFechaVencimiento();
                control.menu();
        }

        public void menu() {
                // ciclo para mostrar las opciones del menú
                do {
                        // menú del programa el cual pide ingresar una opción
                        System.out.println("\n --- [BIENVENIDO A LA BIBLIOTECA VIRTUAL] --- \n");
                        System.out.println("              --- [MENU] ---");
                        System.out.println("[1] Inventario");
                        System.out.println("[2] Prestamos");
                        System.out.println("[3] Devoluciones");
                        System.out.println("[4] Deudores");
                        System.out.println("[5] Salir del programa");
                        System.out.print("Selecciona una opción: ");
                        // se guarda la opción en la variable opcion
                        opcion = sc.nextInt();
                        switch (opcion) {
                        case 1:
                                // submenu de inventario
                                int invOpcion;
                                do {
                                        System.out.println("\n              --- [INVENTARIO] ---");
                                        System.out.println("[1] Libros");
                                        System.out.println("[2] Revistas");
                                        System.out.println("[3] Volver al menú anterior");
                                        System.out.print("Selecciona una opción: ");
                                        invOpcion = sc.nextInt();
                                        switch (invOpcion) {
                                        case 1:
                                                // Inicializa sub-submenu
                                                sc.nextLine(); // limpiar buffer
                                                int opcionLibro;
                                                do {
                                                        System.out.println("\n              --- [INVENTARIO DE LIBROS] ---");
                                                        System.out.println("[1] Ver inventario de libros");
                                                        System.out.println("[2] Editar libro");
                                                        System.out.println("[3] Eliminar libro");
                                                        System.out.println("[4] Volver al menú principal");
                                                        System.out.print("Selecciona una opcion: ");
                                                        opcionLibro = sc.nextInt();
                                                        switch (opcionLibro) {
                                                        case 1:
                                                                // control.inventarioLibros();
                                                                control.generarTablaLibros();
                                                                break;
                                                        case 2:
                                                                sc.nextLine(); // limpiar buffer
                                                                System.out.println("Introduce el ID del libro que deseas editar: ");
                                                                String idLibro = sc.nextLine();
                                                                // buscamos el libro en el
                                                                // arraylist libros
                                                                Libro libro = null;
                                                                for (Libro l : libros) {
                                                                        if (l.getID().equals(idLibro)) {
                                                                                libro = l;
                                                                                break;
                                                                        }
                                                                }
                                                                if (libro != null) {
                                                                        control.editar(libro);
                                                                } else {
                                                                        System.out.println("El libro con el ID " + idLibro + " no existe");
                                                                }
                                                                break;
                                                        case 3:
                                                                sc.nextLine();
                                                                System.out.println("Introduce el ID del libro que deseas eliminar: ");
                                                                String idlibro = sc.nextLine();
                                                                // buscamos el libro en el
                                                                // arraylist
                                                                for (Libro l : libros) {
                                                                        if (l.getID().equals(idlibro)) {
                                                                                control.eliminar(l);
                                                                                break;
                                                                        } else {
                                                                                System.out.println("[ERROR] El libro con el ID " + idlibro + " no existe");
                                                                        }
                                                                }
                                                                break;
                                                        case 4:
                                                                break;
                                                        default:
                                                                System.out.println("[ERROR] La opcion " + opcionLibro + " no es valida");
                                                        }
                                                } while (opcionLibro != 4);
                                                break;
                                        case 2:
                                                // Inicializa un sub-submenu
                                                int opcionRevista;
                                                do {
                                                        System.out.println("\n              --- [INVENTARIO DE REVISTAS] ---");
                                                        System.out.println("[1] Ver inventario de revistas");
                                                        System.out.println("[2] Editar revista");
                                                        System.out.println("[3] Eliminar revista");
                                                        System.out.println("[4] Volver al menú principal");
                                                        System.out.print("Selecciona una opción: ");
                                                        opcionRevista = sc.nextInt();
                                                        switch (opcionRevista) {
                                                        case 1:
                                                                // control.inventarioRevistas();
                                                                control.generarTablaRevistas();
                                                                break;
                                                        case 2:
                                                                sc.nextLine(); // limpiar buffer
                                                                System.out.println("Introduce el ID de la revista que deseas editar: ");
                                                                String idRevista = sc.nextLine();
                                                                // buscamos el libro en el
                                                                // arraylist libros
                                                                Revista revista = null;
                                                                for (Revista r : revistas) {
                                                                        if (r.getID().equals(idRevista)) {
                                                                                revista = r;
                                                                                break;
                                                                        }
                                                                }
                                                                if (revista != null) {
                                                                        control.editar(revista);
                                                                } else {
                                                                        System.out.println("La revista con el ID " + idRevista + " no existe");
                                                                }
                                                                break;
                                                        case 3:
                                                                sc.nextLine();
                                                                System.out.println("Introduce el ID de la revista que deseas eliminar: ");
                                                                String idrevista = sc.nextLine();
                                                                // buscamos la revista en el
                                                                // arraylist
                                                                for (Revista r : revistas) {
                                                                        if (r.getID().equals(idrevista)) {
                                                                                control.eliminar(r);
                                                                                break;
                                                                        } else {
                                                                                System.out.println("[ERROR] El libro con el ID " + idrevista + " no existe");
                                                                        }
                                                                }
                                                                break;
                                                        case 4:
                                                                break;
                                                        default:
                                                                System.out.println("[ERROR] La opción " + opcionRevista + " no es valida");
                                                        }
                                                } while (opcionRevista != 4);
                                                break;
                                        case 3:
                                                break;
                                        default:
                                                System.out.println("[ERROR] La opcion " + invOpcion + " no es valida");
                                        }
                                } while (invOpcion != 3);
                                break;
                        case 2:
                                // Inicia menu de prestamos
                                int subOpcion;
                                do {
                                        System.out.println("\n              --- [MENU DE PRESTAMO] ---");
                                        System.out.println("[1] Prestar libro");
                                        System.out.println("[2] Prestar revista");
                                        System.out.println("[3] Visualizar Prestamos");
                                        System.out.println("[4] Volver al menú principal");
                                        System.out.print("Selecciona una opción: ");
                                        subOpcion = sc.nextInt();
                                        switch (subOpcion) {
                                        case 1:
                                                control.generarTablaEstudiantes();
                                                control.generarTablaPrestamos();
                                                sc.nextLine();
                                                System.out.print("Ingresa un ID para el préstamo de libro: ");
                                                String idPrestamoLibro = sc.nextLine();
                                                System.out.print("Ingresa el ID del libro: ");
                                                String idLibro = sc.nextLine();
                                                System.out.print("Ingresa el número de control del estudiante: ");
                                                String numeroControlEstudianteLibro = sc.nextLine();
                                                control.prestar(idPrestamoLibro, libros.stream().filter(libro -> libro.getID().equals(idLibro)).findFirst().orElse(null), numeroControlEstudianteLibro);
                                                break;
                                        case 2:
                                                control.generarTablaEstudiantes();
                                                control.generarTablaPrestamos();
                                                sc.nextLine();
                                                System.out.print("Ingresa un ID para el préstamo de revista: ");
                                                String idPrestamoRevista = sc.nextLine();
                                                System.out.print("Ingresa el ID de la revista: ");
                                                String idRevista = sc.nextLine();
                                                System.out.print("Ingresa el número de control del estudiante: ");
                                                String numeroControlEstudianteRevista = sc.nextLine();
                                                control.prestar(idPrestamoRevista, revistas.stream().filter(revista -> revista.getID().equals(idRevista)).findFirst().orElse(null),
                                                                numeroControlEstudianteRevista);
                                                break;
                                        case 3:
                                                control.generarTablaPrestamos();
                                                break;
                                        case 4:
                                                break;
                                        default:
                                                System.out.println("[ERROR] La opcion " + subOpcion + " no valida");
                                        }
                                } while (subOpcion != 4);
                                break;
                        case 3: // llamar al método devoluciones
                                sc.nextLine(); // limpiar buffer
                                control.generarTablaPrestamos();
                                System.out.println("Ingrese el ID del Prestamo a regresar: ");
                                control.devoluciones(sc.nextLine()); // llamar al método devoluciones
                                break;
                        case 4: // llamar al método Deudores
                                control.deudores();
                                break;
                        case 5:
                                System.out.println("[SISTEMA] Saliendo del programa...");
                                System.exit(0);
                        default: // cualquier otra opción no es válida
                                System.out.println("[ERROR] La opción " + opcion + " no es válida");
                        } // fin del swith menú
                } while (opcion != 5);
        }

        // inicializa el registro de estudiantes,libros,revistas y prestamos.
        void registro() {
                // registro de array 20 estudiantes
                estudiantes.add(new Estudiante("Cristian", "Echevarria", "Sistemas", "23760055", true));
                estudiantes.add(new Estudiante("Oscar", "Teran", "Sistemas", "23760066", true));
                estudiantes.add(new Estudiante("Israel ", "Tejeda", "Administracion", "23760077", true));
                estudiantes.add(new Estudiante("Cristian", "Malacara", "Sistemas", "23760087", true));
                estudiantes.add(new Estudiante("Leticia", "Maya", "Industrial", "23760097", true));
                estudiantes.add(new Estudiante("Alma", "Buena", "Sistemas", "23760108", true));
                estudiantes.add(new Estudiante("Elvis", "Cocho", "Gestion", "23760058", false));
                estudiantes.add(new Estudiante("Miguel", "Rodriguez", "Sistemas", "23760011", true));
                estudiantes.add(new Estudiante("Luis Miguel", "Ferras", "Sistemas", "23760012", true));
                estudiantes.add(new Estudiante("Felix", "Navarro", "Electronica", "23760013", true));
                estudiantes.add(new Estudiante("Alejandro", "Mendoza", "Sistemas", "2376014", false));
                estudiantes.add(new Estudiante("Oscar", "Ojeda", "Gestion", "23760015", false));
                estudiantes.add(new Estudiante("Gael ", "Olea", "Sistemas", "23760016", false));
                estudiantes.add(new Estudiante("Alonso", "Marquez", "Sistemas", "23760017", false));
                estudiantes.add(new Estudiante("Nestor", "Romero", "Sistemas", "23760018", false));
                estudiantes.add(new Estudiante("Abelardo", "God", "Sistemas", "23760019", false));
                estudiantes.add(new Estudiante("Consuelo", "Sanchez", "Sistemas", "23760020", false));
                estudiantes.add(new Estudiante("Alejandra", "Ruiz", "Industrial", "23760021", false));
                estudiantes.add(new Estudiante("Luis", "Zazueta", "Industrial", "23760022", false));
                estudiantes.add(new Estudiante("Raul", "Felix", "Gestion", "23760023", false));
                // registrar Libros
                libros.add(new Libro("El retrato de la muerte", "Ray Bradbury", "0001", 1955, false, "434JKLJFAISF7", "Planeta", 1));
                libros.add(new Libro("Solo tu", "Paulo Cohelo", "0002", 1955, false, "DJF223JKMNA", "Planeta", 3));
                libros.add(new Libro("La dama de negro", "Guillermo Del Toro", "0003", 1955, true, "KAJSKDJAKSFU8674B", "Planeta", 3));
                libros.add(new Libro("La autopista", "Juan Rulfo", "0004", 1955, false, "ASJDAFS8743", "Planeta", 3));
                libros.add(new Libro("Breaking bad", "Ray Bradbury", "0005", 1955, true, "ASKFJAS7530", "Planeta", 3));
                libros.add(new Libro("Los infinitos", "Dr.Felix", "0006", 1955, true, "DAOOIASD8263", "Planeta", 3));
                libros.add(new Libro("Principio del derecho", "Ray Bradbury", "0007", 1955, true, "ASDU6ASFHKAJFH", "Planeta", 3));
                libros.add(new Libro("Que pasa con mi cuerpo?", "Jordi Rosado", "0008", 1955, true, "AS8D7AFHSJFASF", "Planeta", 3));
                libros.add(new Libro("las cronicas de Narnia", "C.S. Lewis", "0009", 1955, true, "GOJOUE8978A6GS", "Planeta", 3));
                libros.add(new Libro("Piratas del Caribe", "Ray Bradbury", "0010", 1955, true, "POIFAOSPFAI977", "Planeta", 3));
                libros.add(new Libro("El Principio", "Ray Bradbury", "0011", 1955, true, "IKAFOIA8S66AFG", "Planeta", 3));
                // registrar Revistas
                revistas.add(new Revista("10 habitos exitosos", "Sandra Bullock", "0022", 1955, true, "KLAHSFIASFU78903", "Planeta", 1));
                revistas.add(new Revista("Muy interesante", "Sandra Bullock", "0012", 1955, false, "ASOFIAS7FA65", "Planeta", 3));
                revistas.add(new Revista("National Geographic", "Ray Bradbury", "0013", 1955, false, "ASUYTFASYGABJKSD", "Planeta", 3));
                revistas.add(new Revista("SpaceX", "Elon Musk", "0014", 1955, false, "KAHSFUAISTFA67S", "Planeta", 3));
                revistas.add(new Revista("Tesla el gigante", "Elon Musk", "0015", 1955, false, "76A54768UHJKAFDS", "Planeta", 3));
                revistas.add(new Revista("History channel", "Ray Bradbury", "0016", 1955, false, "A795S87ASFGKJA", "Planeta", 3));
                revistas.add(new Revista("Animal Planet", "Ray Bradbury", "0017", 1955, false, "ASOIFYAS76FA1", "Planeta", 3));
                revistas.add(new Revista("Para adultos", "Ray Bradbury", "0018", 1955, true, "OAIUSI9FI07AS08F", "Planeta", 3));
                revistas.add(new Revista("Emprendedores", "Ray Bradbury", "0019", 1955, true, "APS9F87A9SFDAHSJD", "Planeta", 3));
                revistas.add(new Revista("Ecomista", "Ray Bradbury", "0020", 1955, true, "87A5S68DASGHDJAAS", "Planeta", 3));
                revistas.add(new Revista("Cosmopolitan", "Ray Bradbury", "0021", 1955, true, "89567A467DSGYAGS", "Planeta", 3));
                // Registrar Prestamos
                prestamos.add(new Prestamo("0001", "23760055", "0001", obtenerFechaActual(), calcularFechaVencimiento(), false));
                prestamos.add(new Prestamo("0002", "23760066", "0002", obtenerFechaActual(), calcularFechaVencimiento(), false));
                prestamos.add(new Prestamo("0003", "23760077", "0003", obtenerFechaActual(), calcularFechaVencimiento(), false));
                prestamos.add(new Prestamo("0004", "23760087", "0004", obtenerFechaActual(), calcularFechaVencimiento(), false));
                prestamos.add(new Prestamo("0005", "23760097", "0012", obtenerFechaActual(), calcularFechaVencimientoRevista(), false));
                prestamos.add(new Prestamo("0006", "23760018", "0013", obtenerFechaActual(), calcularFechaVencimientoRevista(), false));
                prestamos.add(new Prestamo("0007", "23760019", "0014", obtenerFechaActual(), calcularFechaVencimientoRevista(), false));
                prestamos.add(new Prestamo("0008", "23760020", "0015", obtenerFechaActual(), calcularFechaVencimientoRevista(), false));
                prestamos.add(new Prestamo("0009", "23760022", "0016", obtenerFechaActual(), calcularFechaVencimientoRevista(), false));
                prestamos.add(new Prestamo("0010", "23760023", "0017", obtenerFechaActual(), calcularFechaVencimientoRevista(), false));
        }

        void generarTablaEstudiantes() {
                // Imprimir la cabecera de la tabla
                System.out.println("____________________________________________________________________\n");
                System.out.printf("%-15s %-17s %-20s %-20s\n", "No. Control", "Nombre", "Apellido", "Carrera");
                System.out.println("__________________________________________________________________________");
                // Recorrer arraylist de estudiantes y mostrar la información de cada
                // estudiante
                for (Estudiante estudiante : estudiantes) {
                        System.out.printf("%-15s %-17s %-20s %-20s\n", estudiante.getNumeroControl(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getCarrera());
                }
                // Pie de la tabla
                System.out.println("____________________________________________________________________________");
        }

        void generarTablaPrestamos() {
                // Imprimir la cabecera de la tabla
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("______________________________________________________________________________________\n");
                System.out.printf("%-5s %-10s %-13s %-18s %-20s %-10s\n", "ID", "No_Control", "ID_Documento", "Fecha_Prestamo", "Fecha_Vencimiento", "Con Atraso");
                System.out.println("______________________________________________________________________________________");
                // recorre arraylist de prestamos y mostrar la información de cada
                for (Prestamo prestamo : prestamos) {
                        String fechaPrestamoStr = dateFormat.format(prestamo.getFechaPrestamo().getTime());
                        String fechaVencimientoStr = dateFormat.format(prestamo.getFechaVencimiento().getTime());
                        System.out.printf("%-5s %-15s %-8s %-20s %-20s %-10s\n", prestamo.getId(), prestamo.getNumeroControl(), prestamo.getIdDocumento(), fechaPrestamoStr, fechaVencimientoStr,
                                        prestamo.isConAtraso());
                }
                // Pie de la tabla
                System.out.println("______________________________________________________________________________________");
        }

        void generarTablaLibros() {
                // Imprimir la cabecera de la tabla
                System.out.println("_______________________________________________________________________________________________________________________\n");
                System.out.printf("%-7s %-25s %-20s %-10s %-12s %-20s %-10s %-5s\n", "ID", "Titulo", "Autor", "Año Pub.", "Edición", "ISBN", "Editorial", "Disponible");
                System.out.println("_______________________________________________________________________________________________________________________");
                // Recorrer arraylist de libros y mostrar la información de cada
                for (Libro libro : libros) {
                        System.out.printf("%-7s %-25s %-20s %-12s %-10s %-20s %-10s %-5s\n", libro.getID(), libro.getTitulo(), libro.getAutor(), libro.getAnioPublicacion(), libro.getEdicion(),
                                        libro.getISBN(), libro.getEditorial(), libro.isDisponible());
                }
                // Pie de la tabla
                System.out.println("_______________________________________________________________________________________________________________________\n");
        }

        void generarTablaRevistas() {
                // Imprimir la cabecera de la tabla
                System.out.println("________________________________________________________________________________________________________\n");
                System.out.printf("%-7s %-20s %-15s %-10s %-9s %-20s %-10s %-10s\n", "ID", "Titulo", "Autor", "Año_Pub", "Disp", "ISSN", "Nombre", "Vol");
                System.out.println("________________________________________________________________________________________________________");
                // Recorrer arraylist de revistas y mostrar la información de cada
                for (Revista revista : revistas) {
                        System.out.printf("%-7s %-20s %-15s %-10s %-9s %-20s %-10s %-10s\n", revista.getID(), revista.getTitulo(), revista.getAutor(), revista.getAnioPublicacion(),
                                        revista.isDisponible(), revista.getISSN(), revista.getNombre(), revista.getVolumen());
                }
                // Pie de la tabla
                System.out.println("_____________________________________________________________________________________________________\n");
        }

        void editar(Documento documento) {
                // si la instancia es de tipo libro
                if (documento instanceof Libro) {
                        Libro libro = (Libro) documento;
                        int opcion;
                        do {
                                System.out.println("Editar Libro (ID: " + libro.getID() + ")");
                                System.out.println("[1] Editar Título");
                                System.out.println("[2] Editar Autor");
                                System.out.println("[3] Editar Año de publicación");
                                System.out.println("[4] Editar ISBN");
                                System.out.println("[5] Editar Editorial");
                                System.out.println("[6] Editar Edición");
                                System.out.println("[7] Volver al menú principal");
                                System.out.print("Selecciona una opción: ");
                                opcion = sc.nextInt();
                                sc.nextLine(); // Limpia el salto de línea
                                switch (opcion) {
                                case 1:
                                        System.out.print("Nuevo título: ");
                                        libro.setTitulo(sc.nextLine());
                                        System.out.println("[SISTEMA] Título actualizado con éxito.");
                                        break;
                                case 2:
                                        System.out.print("Nuevo autor: ");
                                        libro.setAutor(sc.nextLine());
                                        System.out.println("[SISTEMA] Autor actualizado con éxito.");
                                        break;
                                case 3:
                                        System.out.println("Nuevo año de publicación: ");
                                        libro.setAnioPublicacion(sc.nextInt());
                                        System.out.println("[SISTEMA] Año de publicación actualizado con éxito.");
                                        break;
                                case 4:
                                        System.out.print("Nuevo ISBN: ");
                                        libro.setISBN(sc.nextLine());
                                        System.out.println("[SISTEMA] ISBN actualizado con éxito.");
                                        break;
                                case 5:
                                        System.out.print("Nueva editorial: ");
                                        libro.setEditorial(sc.nextLine());
                                        System.out.println("[SISTEMA] Editorial actualizada con éxito.");
                                        break;
                                case 6:
                                        System.out.print("Nueva edición: ");
                                        libro.setEdicion(sc.nextInt());
                                        System.out.println("[SISTEMA] Edición actualizada con éxito.");
                                        break;
                                case 7:
                                        // Salir del submenú
                                        break;
                                default:
                                        System.out.println("[ERROR] Opción no válida. Inténtalo de nuevo.");
                                        break;
                                }
                        } while (opcion != 7);
                        // Actualiza el objeto en el ArrayList
                        int indice_libro = libros.indexOf(libro);
                        libros.set(indice_libro, libro);
                        System.out.println("[SISTEMA] Libro actualizado en el inventario.");
                } else if (documento instanceof Revista) {
                        // si la instancia es de tipo revista
                        Revista revista = (Revista) documento;
                        int opcion;
                        do {
                                System.out.println("Editar Revista (ID: " + revista.getID() + ")");
                                System.out.println("[1] Editar Título");
                                System.out.println("[2] Editar Autor");
                                System.out.println("[3] Editar Año de publicación");
                                System.out.println("[4] Editar ISSN");
                                System.out.println("[5] Editar Nombre");
                                System.out.println("[6] Editar Volumen");
                                System.out.println("[7] Volver al menú principal");
                                System.out.print("Selecciona una opción: ");
                                opcion = sc.nextInt();
                                sc.nextLine(); // Limpia el salto de línea
                                switch (opcion) {
                                case 1:
                                        System.out.print("Nuevo título: ");
                                        revista.setTitulo(sc.nextLine());
                                        System.out.println("[SISTEMA] Título actualizado con éxito.");
                                        break;
                                case 2:
                                        System.out.print("Nuevo autor: ");
                                        revista.setAutor(sc.nextLine());
                                        System.out.println("[SISTEMA] Autor actualizado con éxito.");
                                        break;
                                case 3:
                                        System.out.println("Nuevo año de publicación: ");
                                        revista.setAnioPublicacion(sc.nextInt());
                                        System.out.println("[SISTEMA] Año de publicación actualizado con éxito.");
                                        break;
                                case 4:
                                        System.out.print("Nuevo ISSN: ");
                                        revista.setISSN(sc.nextLine());
                                        System.out.println("[SISTEMA] ISSN actualizado con éxito.");
                                        break;
                                case 5:
                                        System.out.print("Nuevo Nombre: ");
                                        revista.setNombre(sc.nextLine());
                                        System.out.println("[SISTEMA] Nombre actualizado con éxito.");
                                        break;
                                case 6:
                                        System.out.print("Nuevo Volumen: ");
                                        revista.setVolumen(sc.nextInt());
                                        System.out.println("[SISTEMA] Volumen actualizado con éxito.");
                                        break;
                                case 7:
                                        // Salir del submenú
                                        break;
                                default:
                                        System.out.println("[ERROR] Opción no válida. Inténtalo de nuevo.");
                                        break;
                                }
                        } while (opcion != 7);
                        // Actualiza el objeto en el ArrayList
                        int indice_revista = revistas.indexOf(revista);
                        revistas.set(indice_revista, revista);
                        System.out.println("[SISTEMA] Revista actualizada en el inventario.");
                }
        }

        void eliminar(Documento documento) {
                // si la instancia es de tipo libro
                if (documento instanceof Libro) {
                        Libro libro = (Libro) documento;
                        if (libros.remove(libro)) {
                                System.out.println("[SISTEMA] Libro eliminado correctamente.");
                        } else {
                                System.out.println("[ERROR] El libro no se encontró en el inventario.");
                        }
                        // si la instancia es de tipo revista
                } else if (documento instanceof Revista) {
                        Revista revista = (Revista) documento;
                        if (revistas.remove(revista)) {
                                System.out.println("[SISTEMA] Revista eliminada correctamente.");
                        } else {
                                System.out.println("[ERROR] La revista no se encontró en el inventario.");
                        }
                        // si la instancia no es de ninguno de los dos
                } else {
                        System.out.println("[ERROR] Tipo de documento no válido.");
                }
        }

        void devoluciones(String id_prestamo) {
                Prestamo prestamo = null;
                Documento documento = null;
                Estudiante estudiante = null;
                // fusionar array libros y revistas
                documentos.addAll(libros);
                documentos.addAll(revistas);
                // buscamos el prestamo por el ID
                for (Prestamo p : prestamos) {
                        if (p.getId().equals(id_prestamo)) {
                                prestamo = p;
                                break;
                        }
                }
                // Buscamos el libro o revista referente al prestamo
                if (prestamo != null) {
                        for (Documento doc : documentos) {
                                if (doc.getID().equals(prestamo.getIdDocumento())) {
                                        documento = doc;
                                        break;
                                }
                        }
                }
                // Buscamos el estudiante referente al prestamo
                if (prestamo != null) {
                        for (Estudiante e : estudiantes) {
                                if (e.getNumeroControl().equals(prestamo.getNumeroControl())) {
                                        estudiante = e;
                                        break;
                                }
                        }
                }
                if (documento != null && estudiante != null) {
                        // cambiamos el estado del libro a disponible
                        documento.setDisponible(true);
                        // cambiamos el estado del libro como no deudor
                        estudiante.setDeudor(false);
                        // eliminamos el prestamo de la lista de prestamos
                        prestamos.remove(prestamo);
                        System.out.println("[SISTEMA] Devolución exitosa.");
                } else if (documento == null || estudiante == null) {
                        System.out.println("[ERROR] No se encontro nigun libro o estudiante asociado al prestamo.");
                } else {
                        System.out.println("[ERROR] No se encontró un prestamo con el ID ingresado.");
                }
        }

        void deudores() {
                // Imprimir la cabecera de la tabla
                System.out.println("____________________________________________________________________\n");
                System.out.printf("%-15s %-17s %-20s %-20s\n", "No. Control", "Nombre", "Apellido", "Carrera");
                System.out.println("__________________________________________________________________________");
                // Recorrer arraylist de estudiantes y muestra estudiantes con atributo deudor =
                // true
                for (Estudiante e : estudiantes) {
                        if (e.isDeudor()) {
                                System.out.printf("%-15s %-17s %-20s %-20s\n", e.getNumeroControl(), e.getNombre(), e.getApellido(), e.getCarrera());
                        }
                }
                // Pie de la tabla
                System.out.println("____________________________________________________________________________");
        }

        private void prestar(String id, Documento documento, String numeroControlEstudiante) {
                Estudiante estudiante = null;
                // Buscamos el estudiante en nuestro ArrayList
                for (Estudiante e : estudiantes) {
                        if (e.getNumeroControl().equals(numeroControlEstudiante)) {
                                estudiante = e;
                                break;
                        }
                }
                // si el documento no es nulo ,esta diponible y el estudiante existe y no esta
                // deudor
                if (documento != null && documento.isDisponible() && estudiante != null && estudiante.isDeudor() == false) {
                        // Si el documento está disponible y existe, se puede prestar
                        Prestamo prestamo = crearPrestamo(id, numeroControlEstudiante, documento.getID());
                        documento.setDisponible(false);
                        estudiante.setDeudor(true);
                        // Agregamos el préstamo a la lista de préstamos
                        prestamos.add(prestamo);
                        if (documento instanceof Libro) {
                                System.out.println("[SISTEMA] Libro prestado exitosamente.");
                        } else if (documento instanceof Revista) {
                                System.out.println("[SISTEMA] Revista prestada exitosamente.");
                        }
                } else if (documento != null && documento.isDisponible() == false) {
                        if (documento instanceof Libro) {
                                System.out.println("[ERROR] El libro ya se encuentra prestado.");
                        } else if (documento instanceof Revista) {
                                System.out.println("[ERROR] La revista ya se encuentra prestada.");
                        }
                } else if (estudiante == null) {
                        System.out.println("[ERROR] El estudiante no existe.");
                } else if (estudiante.isDeudor() == true) {
                        System.out.println("[ERROR] El estudiante ya tiene un prestamo activo!.");
                } else {
                        if (documento instanceof Libro) {
                                System.out.println("[ERROR] El libro no existe en el inventario.");
                        } else if (documento instanceof Revista) {
                                System.out.println("[ERROR] La revista no existe en el inventario.");
                        }
                }
        }

        Prestamo crearPrestamo(String id, String numeroControlEstudiante, String idLibro) {
                Prestamo prestamo = new Prestamo();
                prestamo.setId(id);
                prestamo.setNumeroControl(numeroControlEstudiante);
                prestamo.setIdDocumento(idLibro);
                prestamo.setFechaPrestamo(obtenerFechaActual());
                prestamo.setFechaVencimiento(calcularFechaVencimientoRevista());
                return prestamo;
        }

        public GregorianCalendar obtenerFechaActual() {
                // Obtener la fecha actual
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                // String fechaActualStr = dateFormat.format(cal.getTime());
                // Convertir la fecha actual en formato "yyyy-MM-dd" a un objeto
                // GregorianCalendar
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                return new GregorianCalendar(year, (month - 1), day);
        }

        public GregorianCalendar calcularFechaVencimiento() {
                // Obtener la fecha actual
                GregorianCalendar fechaActual = obtenerFechaActual();
                // Sumarle 7 días a la fecha actual
                fechaActual.add(Calendar.DAY_OF_MONTH, 7);
                return fechaActual;
        }

        public GregorianCalendar calcularFechaVencimientoRevista() {
                // Obtener la fecha actual
                GregorianCalendar fechaActual = obtenerFechaActual();
                // sumarle 3 dias a la fecha actual
                fechaActual.add(Calendar.DAY_OF_MONTH, 3);
                return fechaActual;
        }
}
