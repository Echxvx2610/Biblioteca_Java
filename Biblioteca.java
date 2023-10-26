/*
 * @ author: Cristian A. Echevarria
 * @ author: Oscar A. Teran
 * @ version: 1.0
 */

// ...::: Pendientes ::::...
/*
* - metodos eliminarLibro()-eliminarRevista()-Mediante ID ---> sobrecarga(Libro-Revista)  [Hecho]
* - metodos editarLibro() - editarRevista() - Mediante ID --> sobrecarga(Libro-Revista)   [Hecho]
* - metodo devoluciones()                                                                 [Pendiente]
* - metodo deudores()                                                                     [Pendiente]
* - generarTabla() --> sobrecarga(libros,estudiantes,revistas,prestamos)                  [Pendiente]
* - calculo de fecha vencimiento                                                          [Pendiente]
* - titulo y alineacion de tablas de datos                                                [Pendiente]
* - sistema de prestamos                                                                  [Pendiente]
* - metodos para crear o registrar libros y revistas                                      [Pendiente]
*/
package Sistemas_comp.Biblioteca_Java;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Biblioteca {
        // variables globales
        static Biblioteca control = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Arraylist de Documentos
        Documento documentos[] = new Documento[100];
        int cantidadDocumentos = 0;

        // ArrayList de Libros
        private ArrayList<Libro> libros = new ArrayList<>();
        int cantidadLibros = 0;

        // ArrayList de Revistas
        private ArrayList<Revista> revistas = new ArrayList<>();
        int cantidadRevistas = 0;

        // ArrayList de Estudiantes
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        int cantidadEstudiantes = 0;

        // ArrayList de Prestamos
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        int cantidadPrestamos = 0;

        public static void main(String[] args) {

                control.registro();
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
                        System.out.println("[2] Prestamos");
                        System.out.println("[3] Devoluciones");
                        System.out.println("[4] Deudores");
                        System.out.println("[5] Salir del programa");
                        System.out.print("Selecciona una opción: ");

                        // se guarda la opción en la variable opcion
                        opcion = sc.nextInt();

                        switch (opcion) {
                                case 1:
                                        int invOpcion;
                                        do {
                                                System.out.println("\n              --- [INVENTARIO] ---");
                                                System.out.println("[1] Libros");
                                                System.out.println("[2] Revistas");
                                                System.out.println("[3] Volver al menú principal");
                                                System.out.print("Selecciona una opción: ");
                                                invOpcion = sc.nextInt();
                                                switch (invOpcion) {
                                                        case 1:
                                                                // Inicializa sub-submenu
                                                                int opcionLibro;
                                                                do {
                                                                        System.out.println(
                                                                                        "\n              --- [INVENTARIO DE LIBROS] ---");
                                                                        System.out.println(
                                                                                        "[1] Ver inventario de libros");
                                                                        System.out.println("[2] Editar libro");
                                                                        System.out.println("[3] Eliminar libro");
                                                                        System.out.println(
                                                                                        "[4] Volver al menú principal");
                                                                        System.out.print("Selecciona una opcion: ");
                                                                        opcionLibro = sc.nextInt();
                                                                        switch (opcionLibro) {
                                                                                case 1:
                                                                                        // control.inventarioLibros();
                                                                                        control.generarTablaLibros();
                                                                                        break;
                                                                                case 2:
                                                                                        control.editarLibro();
                                                                                        break;
                                                                                case 3:
                                                                                        control.eliminarLibro();
                                                                                        break;
                                                                                case 4:
                                                                                        break;
                                                                                default:
                                                                                        System.out.println("La opcion "
                                                                                                        + opcionLibro
                                                                                                        + " no es valida");
                                                                        }
                                                                } while (opcionLibro != 4);
                                                                break;
                                                        case 2:
                                                                // Inicializa un sub-submenu
                                                                int opcionRevista;
                                                                do {
                                                                        System.out.println(
                                                                                        "\n              --- [INVENTARIO DE REVISTAS] ---");
                                                                        System.out.println(
                                                                                        "[1] Ver inventario de revistas");
                                                                        System.out.println("[2] Editar revista");
                                                                        System.out.println("[3] Eliminar revista");
                                                                        System.out.println(
                                                                                        "[4] Volver al menú principal");
                                                                        System.out.print("Selecciona una opción: ");
                                                                        opcionRevista = sc.nextInt();
                                                                        switch (opcionRevista) {
                                                                                case 1:
                                                                                        // control.inventarioRevistas();
                                                                                        control.generarTablaRevistas();
                                                                                        break;
                                                                                case 2:
                                                                                        control.editarRevista();
                                                                                        break;
                                                                                case 3:
                                                                                        control.eliminarRevista();
                                                                                        break;
                                                                                case 4:
                                                                                        break;
                                                                                default:
                                                                                        System.out.println("La opción "
                                                                                                        + opcionRevista
                                                                                                        + " no es valida");
                                                                        }
                                                                } while (opcionRevista != 4);
                                                                break;
                                                        case 3:
                                                                break;
                                                        default:
                                                                System.out.println("La opcion " + invOpcion
                                                                                + " no es valida");
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
                                                                // control.prestarLibro();
                                                                break;
                                                        case 2:
                                                                // control.prestarRevista();
                                                                break;
                                                        case 3:
                                                                // control.verPrestamos();
                                                                control.generarTablaPrestamos();
                                                                break;
                                                        case 4:
                                                                break;
                                                        default:
                                                                System.out.println("La opcion " + subOpcion
                                                                                + " no valida");
                                                }
                                        } while (subOpcion != 4);
                                        break;
                                case 3: // llamar al método devoluciones
                                        control.devoluciones();
                                        break;
                                case 4: // llamar al método Deudores
                                        control.deudores();
                                        break;
                                case 5:
                                        System.out.println("Saliendo del programa...");
                                        System.exit(0);
                                default: // cualquier otra opción no es válida
                                        System.out.println("La opción " + opcion + " no es válida");
                        } // fin del swith menú
                } while (opcion != 5);
        }

        // inicializa el registro de estudiantes,libros,revistas y prestamos.
        void registro() {
                // registro de array 20 estudiantes

                estudiantes.add(new Estudiante("Cristian", "Echevarria", "Sistemas", "2376005"));
                estudiantes.add(new Estudiante("Oscar", "Teran", "Administracion", "2376006"));
                estudiantes.add(new Estudiante("Israel ", "Tejeda", "Administracion", "2376007"));
                estudiantes.add(new Estudiante("Cristian", "Malacara", "Sistemas", "2376008"));
                estudiantes.add(new Estudiante("Rosa", "Melano", "Sistemas", "2376009"));
                estudiantes.add(new Estudiante("Alma", "Marcela", "Sistemas", "2376005"));
                estudiantes.add(new Estudiante("Elvis", "Cocho", "Gestion", "2376005"));
                estudiantes.add(new Estudiante("Bad bunny", "Mamberroi", "Sistemas", "2376005"));
                estudiantes.add(new Estudiante("Luis Miguel", "Ferras", "Sistemas", "2376005"));
                estudiantes.add(new Estudiante("Felix", "Navarro", "Electronica", "2376005"));
                estudiantes.add(new Estudiante("Alejandro", "Mendoza", "Sistemas", "2376005"));
                estudiantes.add(new Estudiante("Oscar", "Ojeda", "Gestion", "2376006"));
                estudiantes.add(new Estudiante("Gael ", "Olea", "Sistemas", "2376007"));
                estudiantes.add(new Estudiante("Alonso", "Marquez", "Sistemas", "2376008"));
                estudiantes.add(new Estudiante("Nestor", "Romero", "Sistemas", "2376009"));
                estudiantes.add(new Estudiante("Abelardo", "Castro", "Sistemas", "2376005"));
                estudiantes.add(new Estudiante("Consuelo", "Sanchez", "Sistemas", "2376005"));
                estudiantes.add(new Estudiante("Alejandra", "Ruiz", "Industrial", "2376005"));
                estudiantes.add(new Estudiante("Luis", "Zazueta", "Industrial", "2376005"));
                estudiantes.add(new Estudiante("Raul", "Felix", "Gestion", "2376005"));

                // registrar Libros
                libros.add(new Libro("El retrato de la muerte", "Ray Bradbury", "0001", 1955, true, "434JKLJFAISF7",
                                "Planeta", 1));
                libros.add(new Libro("Solo tu", "Paulo Cohelo", "0002", 1955, true, "DJF223JKMNA", "Planeta", 3));
                libros.add(new Libro("La dama de negro", "Guillermo Del Toro", "0003", 1955, true, "KAJSKDJAKSFU8674B",
                                "Planeta", 3));
                libros.add(new Libro("La autopista", "Juan Rulfo", "0004", 1955, true, "ASJDAFS8743", "Planeta", 3));
                libros.add(new Libro("Breaking bad", "Ray Bradbury", "0005", 1955, true, "ASKFJAS7530", "Planeta", 3));
                libros.add(new Libro("Los infinitos", "Dr.Felix", "0006", 1955, true, "DAOOIASD8263", "Planeta", 3));
                libros.add(new Libro("Principio del derecho", "Ray Bradbury", "0007", 1955, true, "ASDU6ASFHKAJFH",
                                "Planeta", 3));
                libros.add(new Libro("Que pasa con mi cuerpo?", "Jordi Rosado", "0008", 1955, true, "AS8D7AFHSJFASF",
                                "Planeta", 3));
                libros.add(new Libro("las cronicas de Narnia", "C.S. Lewis", "0009", 1955, true, "GOJOUE8978A6GS",
                                "Planeta", 3));
                libros.add(new Libro("Piratas del Caribe", "Ray Bradbury", "0010", 1955, true, "POIFAOSPFAI977",
                                "Planeta", 3));
                libros.add(new Libro("El Principio", "Ray Bradbury", "0011", 1955, true, "IKAFOIA8S66AFG", "Planeta",
                                3));

                // registrar Revistas
                revistas.add(new Revista("10 habitos exitosos", "Sandra Bullock", "0022", 1955, true,
                                "KLAHSFIASFU78903", "Planeta", 1));
                revistas.add(new Revista("Muy interesante", "Sandra Bullock", "0012", 1955, true, "ASOFIAS7FA65",
                                "Planeta", 3));
                revistas.add(new Revista("National Geographic", "Ray Bradbury", "0013", 1955, true, "ASUYTFASYGABJKSD",
                                "Planeta", 3));
                revistas.add(new Revista("SpaceX", "Elon Musk", "0014", 1955, true, "KAHSFUAISTFA67S", "Planeta", 3));
                revistas.add(new Revista("Tesla el gigante", "Elon Musk", "0015", 1955, true, "76A54768UHJKAFDS",
                                "Planeta", 3));
                revistas.add(new Revista("History channel", "Ray Bradbury", "0016", 1955, true, "A795S87ASFGKJA",
                                "Planeta", 3));
                revistas.add(new Revista("Animal Planet", "Ray Bradbury", "0017", 1955, true, "ASOIFYAS76FA1",
                                "Planeta", 3));
                revistas.add(new Revista("Para adultos", "Ray Bradbury", "0018", 1955, true, "OAIUSI9FI07AS08F",
                                "Planeta", 3));
                revistas.add(new Revista("Emprendedores", "Ray Bradbury", "0019", 1955, true, "APS9F87A9SFDAHSJD",
                                "Planeta", 3));
                revistas.add(new Revista("Ecomista", "Ray Bradbury", "0020", 1955, true, "87A5S68DASGHDJAAS", "Planeta",
                                3));
                revistas.add(new Revista("Cosmopolitan", "Ray Bradbury", "0021", 1955, true, "89567A467DSGYAGS",
                                "Planeta", 3));

                // Registrar Prestamos
                prestamos.add(new Prestamo("001", "23760067", 1, new GregorianCalendar(2023, 10, 21),
                                new GregorianCalendar(2023, 10, 28), true));
                prestamos.add(new Prestamo("002", "23760068", 2, new GregorianCalendar(2023, 10, 21),
                                new GregorianCalendar(2023, 10, 28), false));
                prestamos.add(new Prestamo("003", "23760069", 3, new GregorianCalendar(2023, 10, 21),
                                new GregorianCalendar(2023, 10, 28), true));
                prestamos.add(new Prestamo("004", "23760070", 4, new GregorianCalendar(2023, 10, 21),
                                new GregorianCalendar(2023, 10, 28), false));
                prestamos.add(new Prestamo("005", "23760071", 5, new GregorianCalendar(2023, 10, 21),
                                new GregorianCalendar(2023, 10, 28), true));
                prestamos.add(new Prestamo("006", "23760072", 6, new GregorianCalendar(2023, 10, 21),
                                new GregorianCalendar(2023, 10, 28), true));
                prestamos.add(new Prestamo("007", "23760073", 7, new GregorianCalendar(2023, 10, 21),
                                new GregorianCalendar(2023, 10, 28), false));
                prestamos.add(new Prestamo("006", "23760074", 8, new GregorianCalendar(2023, 10, 21),
                                new GregorianCalendar(2023, 10, 28), true));
                prestamos.add(new Prestamo("007", "23760075", 9, new GregorianCalendar(2023, 10, 21),
                                new GregorianCalendar(2023, 10, 28), false));
                prestamos.add(new Prestamo("010", "23760076", 10, new GregorianCalendar(2023, 10, 21),
                                new GregorianCalendar(2023, 10, 28), false));
        }

        // metodos generarTabla() aplican para metodo sobrecargado por ejemplo,
        // generar(array de objetos)-->
        // generarTabla(estudiantes),generarTabla(prestamos)
        void generarTablaEstudiantes() {
                // Imprimir la cabecera de la tabla
                System.out.println(
                                "____________________________________________________________________\n");
                System.out.printf("%-15s %-17s %-20s %-20s\n",
                                "No. Control", "Nombre", "Apellido", "Carrera");
                System.out.println(
                                "__________________________________________________________________________");

                // Recorrer arraylist de estudiantes y mostrar la información de cada
                // estudiante
                for (Estudiante estudiante : estudiantes) {
                        System.out.printf("%-15s %-17s %-20s %-20s\n",
                                        estudiante.getNumeroControl(),
                                        estudiante.getNombre(),
                                        estudiante.getApellido(),
                                        estudiante.getCarrera());
                }
                // Pie de la tabla
                System.out.println(
                                "____________________________________________________________________________");
        }

        void generarTablaPrestamos() {
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

        void generarTablaLibros() {
                // Imprimir la cabecera de la tabla
                System.out.println(
                                "_______________________________________________________________________________________________________________________\n");
                System.out.printf("%-7s %-25s %-20s %-10s %-10s %-20s %-10s %-5s\n",
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

        void generarTablaRevistas() {
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

        void inventarioLibros() {
                System.out.println("Listando inventario libros....");
        }

        public void editarLibro() {
                sc.nextLine(); // Limpia el salto de línea
                int opcion;

                do {
                        System.out.print("Introduce el ID del libro que deseas editar (o 0 para salir): ");
                        String idLibro = sc.nextLine();

                        if (idLibro.equals("0")) {
                                break; // Salir del menú de edición
                        }

                        int indice_libro = -1;

                        // Busca el libro en el ArrayList por su ID
                        for (int i = 0; i < libros.size(); i++) {
                                if (libros.get(i).getID().equals(idLibro)) {
                                        indice_libro = i;
                                        break;
                                }
                        }

                        if (indice_libro != -1) {
                                Libro libro = libros.get(indice_libro);

                                do {
                                        System.out.println("Editar Libro (ID: " + idLibro + ")");
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
                                                        String nuevoTitulo = sc.nextLine();
                                                        libro.setTitulo(nuevoTitulo);
                                                        System.out.println("Título actualizado.");
                                                        break;
                                                case 2:
                                                        System.out.print("Nuevo autor: ");
                                                        String nuevoAutor = sc.nextLine();
                                                        libro.setAutor(nuevoAutor);
                                                        System.out.println("Autor actualizado.");
                                                        break;
                                                case 3:
                                                        System.out.println("Nuevo año de publicación: ");
                                                        int nuevoAnioPublicacion = sc.nextInt();
                                                        libro.setAnioPublicacion(nuevoAnioPublicacion);
                                                        System.out.println("Año de publicación actualizado.");
                                                        break;
                                                case 4:
                                                        System.out.print("Nuevo ISBN: ");
                                                        String nuevoISBN = sc.nextLine();
                                                        libro.setISBN(nuevoISBN);
                                                        System.out.println("ISBN actualizado.");
                                                        break;
                                                case 5:
                                                        System.out.print("Nueva editorial: ");
                                                        String nuevaEditorial = sc.nextLine();
                                                        libro.setEditorial(nuevaEditorial);
                                                        System.out.println("Editorial actualizada.");
                                                        break;
                                                case 6:
                                                        System.out.print("Nueva edición: ");
                                                        int nuevaEdicion = sc.nextInt();
                                                        libro.setEdicion(nuevaEdicion);
                                                        System.out.println("Edición actualizada.");
                                                        break;
                                                case 7:
                                                        // Salir del submenú
                                                        break;
                                                default:
                                                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                                                        break;
                                        }
                                } while (opcion != 7);

                                // Actualiza el objeto en el ArrayList
                                libros.set(indice_libro, libro);

                                System.out.println("Libro actualizado en el inventario.");
                        } else {
                                System.out.println("El libro con ID " + idLibro + " no existe en el inventario.");
                        }
                } while (true);
        }

        void eliminarLibro() {
                // Eliminar libro por ID de libro
                // limpiar buffer
                sc.nextLine();
                System.out.println("Ingrese el ID del libro a eliminar: ");
                String id = sc.nextLine();
                for (int i = 0; i < libros.size(); i++) {
                        if (libros.get(i).getID().equals(id)) {
                                libros.remove(i);
                                System.out.println("Libro eliminado correctamente.");
                                return;
                        }
                }
                System.out.println("No se encontró ningún libro con el ID especificado.");
        }

        public void editarRevista() {
                sc.nextLine(); // Limpia el salto de línea
                int opcion;

                do {
                        System.out.print("Introduce el ID de la revista que deseas editar (o 0 para salir): ");
                        String idRevista = sc.nextLine();

                        if (idRevista.equals("0")) {
                                break; // Salir del menú de edición
                        }

                        int indice_revista = -1;

                        // Busca el libro en el ArrayList por su ID
                        for (int i = 0; i < revistas.size(); i++) {
                                if (revistass.get(i).getID().equals(idRevista)) {
                                        indice_revista = i;
                                        break;
                                }
                        }

                        if (indice_revista != -1) {
                                Revista revista = revistas.get(indice_revista);

                                do {
                                        System.out.println("Editar Revista (ID: " + idRevista + ")");
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
                                                        String nuevoTitulo = sc.nextLine();
                                                        revista.setTitulo(nuevoTitulo);
                                                        System.out.println("Título actualizado.");
                                                        break;
                                                case 2:
                                                        System.out.print("Nuevo autor: ");
                                                        String nuevoAutor = sc.nextLine();
                                                        revista.setAutor(nuevoAutor);
                                                        System.out.println("Autor actualizado.");
                                                        break;
                                                case 3:
                                                        System.out.println("Nuevo año de publicación: ");
                                                        int nuevoAnioPublicacion = sc.nextInt();
                                                        revista.setAnioPublicacion(nuevoAnioPublicacion);
                                                        System.out.println("Año de publicación actualizado.");
                                                        break;
                                                case 4:
                                                        System.out.print("Nuevo ISSN: ");
                                                        String nuevoISSN = sc.nextLine();
                                                        revista.setISSN(nuevoISSN);
                                                        System.out.println("ISBN actualizado.");
                                                        break;
                                                case 5:
                                                        System.out.print("Nueva Nombre: ");
                                                        String nuevoNombre = sc.nextLine();
                                                        revista.setNombre(nuevoNombre);
                                                        System.out.println("Editorial actualizada.");
                                                        break;
                                                case 6:
                                                        System.out.print("Nueva Volumen: ");
                                                        int nuevoVolumen = sc.nextInt();
                                                        revista.setVolumen(nuevoVolumen);
                                                        System.out.println("Edición actualizada.");
                                                        break;
                                                case 7:
                                                        // Salir del submenú
                                                        break;
                                                default:
                                                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                                                        break;
                                        }
                                } while (opcion != 7);

                                // Actualiza el objeto en el ArrayList
                                revistas.set(indice_revista, revista);

                                System.out.println("Revista actualizada en el inventario.");
                        } else {
                                System.out.println("La revista con ID " + idRevista + " no existe en el inventario.");
                        }
                } while (true);
        }

        void eliminarRevista() {
                // Eliminar revista por ID de revista
                // limpiar buffer
                sc.nextLine();
                System.out.println("Ingrese el ID de la revista a eliminar: ");
                String id = sc.nextLine();
                for (int i = 0; i < revistas.size(); i++) {
                        if (revistas.get(i).getID().equals(id)) {
                                revistas.remove(i);
                                System.out.println("Revista eliminada correctamente.");
                                return;
                        }
                }
                System.out.println("No se encontro ninguna revista con el ID especificado.");
        }

        void inventarioRevistas() {
                System.out.println("Listando inventario revistas....");
        }

        void verPrestamos() {
                System.out.println("Listando prestamos....");
        }

        void devoluciones() {
                System.out.println("Realizando devoluciones....");
        }

        void deudores() {
                System.out.println("Listando deudores....");
        }
        // logica de la aplicacion....
}
