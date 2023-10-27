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
* - metodo deudores()                                                                     [Hecho]
* - generarTabla() --> sobrecarga(libros,estudiantes,revistas,prestamos)                  [Pendiente]
* - calculo de fecha vencimiento                                                          [Hecho]
* - titulo y alineacion de tablas de datos                                                [Hecho]
* - sistema de prestamos                                                                  [Hecho 50%]
* - metodos para crear o registrar libros y revistas                                      [Pendiente]
* - debugear y corregir error en la devolución de revistas                                [Pendiente]
* - revisar el método registro todo OK en                                                 [Pendiente]
* - descomentar los prestamos                                                             [Pendiente]      
*/
package Sistemas_comp.Biblioteca_Java;

import java.util.ArrayList;
import java.util.Calendar;
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
                                                                                        System.out.println(
                                                                                                        "[SISTEMA] La opcion "
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
                                                                                        System.out.println(
                                                                                                        "[SISTEMA] La opción "
                                                                                                                        + opcionRevista
                                                                                                                        + " no es valida");
                                                                        }
                                                                } while (opcionRevista != 4);
                                                                break;
                                                        case 3:
                                                                break;
                                                        default:
                                                                System.out.println("[SISTEMA] La opcion " + invOpcion
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
                                                                control.generarTablaEstudiantes();
                                                                control.generarTablaPrestamos();
                                                                sc.nextLine();
                                                                // Revisar si el ID del préstamo ya existe
                                                                System.out.print("Ingresa un ID para el prestamo: ");
                                                                String id_prestamoLibro = sc.nextLine();
                                                                boolean existePrestamo = false;
                                                                for (Prestamo prestamo : prestamos) {
                                                                        if (prestamo.getId().equals(id_prestamoLibro)) {
                                                                                existePrestamo = true;
                                                                                break;
                                                                        }
                                                                }

                                                                if (existePrestamo) {
                                                                        System.out.println(
                                                                                        "[SISTEMA] El ID del préstamo ya existe. Por favor, ingrese un ID válido.");
                                                                        // Aquí puedes agregar el código adicional que
                                                                        // necesites
                                                                } else {
                                                                        System.out.print(
                                                                                        "Ingresa el Numero de Control del Estudiante: ");
                                                                        String num_control = sc.nextLine();
                                                                        System.out.print("Ingresa el ID del Libro: ");
                                                                        String id_libro = sc.nextLine();
                                                                        control.prestarLibro(id_prestamoLibro, id_libro,
                                                                                        num_control);
                                                                }
                                                                break;
                                                        case 2:
                                                                control.generarTablaEstudiantes();
                                                                control.generarTablaPrestamos();
                                                                sc.nextLine();
                                                                // Revisar si el ID del préstamo ya existe
                                                                System.out.print("Ingresa un ID para el prestamo: ");
                                                                String id_prestamoRevista = sc.nextLine();
                                                                boolean existePrestamo2 = false;

                                                                // Ciclo for para settearla variable existePrestamo a
                                                                // true
                                                                for (Prestamo prestamo : prestamos) {
                                                                        if (prestamo.getId()
                                                                                        .equals(id_prestamoRevista)) {
                                                                                existePrestamo2 = true;
                                                                                break;
                                                                        }
                                                                }
                                                                if (existePrestamo2) {
                                                                        System.out.println(
                                                                                        "[SISTEMA] El ID del préstamo ya existe. Por favor, ingrese un ID válido.");
                                                                        // Aquí puedes agregar el código adicional que
                                                                        // necesites
                                                                } else {
                                                                        System.out.print(
                                                                                        "Ingresa el Numero de Control del Estudiante: ");
                                                                        String num_control = sc.nextLine();
                                                                        System.out.print(
                                                                                        "Ingresa el ID de la revista: ");
                                                                        String id_revista = sc.nextLine();
                                                                        control.prestarRevista(id_prestamoRevista,
                                                                                        id_revista,
                                                                                        num_control);
                                                                }
                                                                break;
                                                        case 3:
                                                                // control.verPrestamos();
                                                                control.generarTablaPrestamos();
                                                                break;
                                                        case 4:
                                                                break;
                                                        default:
                                                                System.out.println("[SISTEMA] La opcion " + subOpcion
                                                                                + " no valida");
                                                }
                                        } while (subOpcion != 4);
                                        break;
                                case 3: // llamar al método devoluciones
                                        control.generarTablaPrestamos();
                                        sc.nextLine(); // limpiar buffer
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
                                        System.out.println("[SISTEMA] La opción " + opcion + " no es válida");
                        } // fin del swith menú
                } while (opcion != 5);
        }

        // inicializa el registro de estudiantes,libros,revistas y prestamos.
        void registro() {
                // registro de array 20 estudiantes

                estudiantes.add(new Estudiante("Cristian", "Echevarria", "Sistemas", "23760055", true));
                estudiantes.add(new Estudiante("Oscar", "Teran", "Administracion", "23760066", false));
                estudiantes.add(new Estudiante("Israel ", "Tejeda", "Administracion", "23760077", false));
                estudiantes.add(new Estudiante("Cristian", "Malacara", "Sistemas", "23760087", false));
                estudiantes.add(new Estudiante("Rosa", "Melano", "Sistemas", "23760097", false));
                estudiantes.add(new Estudiante("Alma", "Marcela", "Sistemas", "23760108", false));
                estudiantes.add(new Estudiante("Elvis", "Cocho", "Gestion", "23760058", false));
                estudiantes.add(new Estudiante("Bad bunny", "Mamberroi", "Sistemas", "23760011", false));
                estudiantes.add(new Estudiante("Luis Miguel", "Ferras", "Sistemas", "23760012", false));
                estudiantes.add(new Estudiante("Felix", "Navarro", "Electronica", "23760013", false));
                estudiantes.add(new Estudiante("Alejandro", "Mendoza", "Sistemas", "2376014", false));
                estudiantes.add(new Estudiante("Oscar", "Ojeda", "Gestion", "23760015", false));
                estudiantes.add(new Estudiante("Gael ", "Olea", "Sistemas", "23760016", false));
                estudiantes.add(new Estudiante("Alonso", "Marquez", "Sistemas", "23760017", false));
                estudiantes.add(new Estudiante("Nestor", "Romero", "Sistemas", "23760018", false));
                estudiantes.add(new Estudiante("Abelardo", "Castro", "Sistemas", "23760019", false));
                estudiantes.add(new Estudiante("Consuelo", "Sanchez", "Sistemas", "23760020", false));
                estudiantes.add(new Estudiante("Alejandra", "Ruiz", "Industrial", "23760021", false));
                estudiantes.add(new Estudiante("Luis", "Zazueta", "Industrial", "23760022", false));
                estudiantes.add(new Estudiante("Raul", "Felix", "Gestion", "2376023", false));

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
                prestamos.add(new Prestamo("0001", "23760055", "0001", new GregorianCalendar(2023, 10, 21),
                                new GregorianCalendar(2023, 9, 28), false));
                /*
                 * prestamos.add(new Prestamo("002", "23760068", "0002", new
                 * GregorianCalendar(2023, 10, 21),
                 * new GregorianCalendar(2023, 10, 28), false));
                 * prestamos.add(new Prestamo("003", "23760069", "0003", new
                 * GregorianCalendar(2023, 10, 21),
                 * new GregorianCalendar(2023, 10, 28), true));
                 * prestamos.add(new Prestamo("004", "23760070", "0004", new
                 * GregorianCalendar(2023, 10, 21),
                 * new GregorianCalendar(2023, 10, 28), false));
                 * prestamos.add(new Prestamo("005", "23760071", "0005", new
                 * GregorianCalendar(2023, 10, 21),
                 * new GregorianCalendar(2023, 10, 28), true));
                 * prestamos.add(new Prestamo("006", "23760072", "0006", new
                 * GregorianCalendar(2023, 10, 21),
                 * new GregorianCalendar(2023, 10, 28), true));
                 * prestamos.add(new Prestamo("007", "23760073", "0007", new
                 * GregorianCalendar(2023, 10, 21),
                 * new GregorianCalendar(2023, 10, 28), false));
                 * prestamos.add(new Prestamo("008", "23760074", "0008", new
                 * GregorianCalendar(2023, 10, 21),
                 * new GregorianCalendar(2023, 10, 28), true));
                 * prestamos.add(new Prestamo("009", "23760075", "0009", new
                 * GregorianCalendar(2023, 10, 21),
                 * new GregorianCalendar(2023, 10, 28), false));
                 * prestamos.add(new Prestamo("0010", "23760076", "0010", new
                 * GregorianCalendar(2023, 10, 21),
                 * new GregorianCalendar(2023, 10, 28), false));
                 */
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
                System.out.println("[SISTEMA] Listando inventario libros....");
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
                                                        System.out.println(
                                                                        "[SISTEMA] Año de publicación actualizado con éxito.");
                                                        break;
                                                case 4:
                                                        System.out.print("Nuevo ISBN: ");
                                                        libro.setISBN(sc.nextLine());
                                                        System.out.println("[SISTEMA] ISBN actualizado con éxito.");
                                                        break;
                                                case 5:
                                                        System.out.print("Nueva editorial: ");
                                                        libro.setEditorial(sc.nextLine());
                                                        System.out.println(
                                                                        "[SISTEMA] Editorial actualizada con éxito.");
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
                                                        System.out.println(
                                                                        "[SISTEMA] Opción no válida. Inténtalo de nuevo.");
                                                        break;
                                        }
                                } while (opcion != 7);

                                // Actualiza el objeto en el ArrayList
                                libros.set(indice_libro, libro);

                                System.out.println("[SISTEMA] Libro actualizado en el inventario.");
                        } else {
                                System.out.println("[SISTEMA] El libro con ID " + idLibro
                                                + " no existe en el inventario.");
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
                                System.out.println("[SISTEMA] Libro eliminado correctamente.");
                                return;
                        }
                }
                System.out.println("[SISTEMA] No se encontró ningún libro con el ID especificado.");
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
                                if (revistas.get(i).getID().equals(idRevista)) {
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
                                                        revista.setTitulo(sc.nextLine());
                                                        System.out.println("[SISTEMA] Titulo actualizado con éxito.");
                                                        break;
                                                case 2:
                                                        System.out.print("Nuevo autor: ");
                                                        revista.setAutor(sc.nextLine());
                                                        System.out.println("[SISTEMA] Autor actualizado con éxito.");
                                                        break;
                                                case 3:
                                                        System.out.println("Nuevo año de publicación: ");
                                                        revista.setAnioPublicacion(sc.nextInt());
                                                        System.out.println(
                                                                        "[SISTEMA] Año de publicación actualizado con éxito.");
                                                        break;
                                                case 4:
                                                        System.out.print("Nuevo ISSN: ");
                                                        String nuevoISSN = sc.nextLine();
                                                        revista.setISSN(sc.nextLine());
                                                        System.out.println("[SISTEMA] ISBN actualizado con éxito.");
                                                        break;
                                                case 5:
                                                        System.out.print("Nuevo Nombre: ");
                                                        revista.setNombre(sc.nextLine());
                                                        System.out.println(
                                                                        "[SISTEMA] Editorial actualizada con éxito.");
                                                        break;
                                                case 6:
                                                        System.out.print("Nueva Volumen: ");
                                                        revista.setVolumen(sc.nextInt());
                                                        System.out.println("[SISTEMA] Edición actualizada con éxito.");
                                                        break;
                                                case 7:
                                                        // Salir del submenú
                                                        break;
                                                default:
                                                        System.out.println(
                                                                        "[SISTEMA] Opción no válida. Inténtalo de nuevo.");
                                                        break;
                                        }
                                } while (opcion != 7);

                                // Actualiza el objeto en el ArrayList
                                revistas.set(indice_revista, revista);

                                System.out.println("[SISTEMA] Revista actualizada en el inventario.");
                        } else {
                                System.out.println("[SISTEMA] La revista con ID " + idRevista
                                                + " no existe en el inventario.");
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
                                System.out.println("[SISTEMA] Revista eliminada correctamente.");
                                return;
                        }
                }
                System.out.println("[SISTEMA] No se encontro ninguna revista con el ID especificado.");
        }

        void inventarioRevistas() {
                System.out.println("[SISTEMA] Listando inventario revistas....");
        }

        void verPrestamos() {
                System.out.println("[SISTEMA] Listando prestamos....");
        }

        void devoluciones(String id_prestamo) {
                Prestamo prestamo = null;
                Libro libro = null;
                Estudiante estudiante = null;

                // buscamos el prestamo por el ID
                for (Prestamo p : prestamos) {
                        if (p.getId().equals(id_prestamo)) {
                                prestamo = p;
                                break;
                        }
                }

                // Buscamos el libro referente al prestamo
                if (prestamo != null) {
                        for (Libro l : libros) {
                                if (l.getID().equals(prestamo.getIdDocumento())) {
                                        libro = l;
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

                if (libro != null && estudiante != null) {
                        // cambiamos el estado del libro a disponible
                        libro.setDisponible(true);

                        // cambiamos el estado del libro como no deudor
                        estudiante.setDeudor(false);

                        // eliminamos el prestamo de la lista de prestamos
                        prestamos.remove(prestamo);

                        System.out.println("[SISTEMA] Devolucion Exitosa.");
                } else if (libro == null || estudiante == null) {
                        System.out.println("[SISTEMA] No se encontro nigun libro o estudiante asociado al prestamo.");
                } else {
                        System.out.println("[SISTEMA] No se encontro un prestamo con el ID ingresado.");
                }
        }

        void deudores() {
                // Imprimir la cabecera de la tabla
                System.out.println(
                                "____________________________________________________________________\n");
                System.out.printf("%-15s %-17s %-20s %-20s\n",
                                "No. Control", "Nombre", "Apellido", "Carrera");
                System.out.println(
                                "__________________________________________________________________________");

                // Recorrer arraylist de estudiantes y muestra estudiantes con atributo deudor =
                // true
                for (Estudiante e : estudiantes) {
                        if (e.isDeudor()) {
                                System.out.printf("%-15s %-17s %-20s %-20s\n",
                                                e.getNumeroControl(),
                                                e.getNombre(),
                                                e.getApellido(),
                                                e.getCarrera());
                        }
                }
                // Pie de la tabla
                System.out.println(
                                "____________________________________________________________________________");
        }

        // logica de la aplicacion....
        void prestarLibro(String id, String idLibro, String numeroControlEstudiante) {
                Libro libro = null;
                Estudiante estudiante = null;

                // Buscamos el libro en nuestro ArrayList
                for (Libro l : libros) {
                        if (l.getID().equals(idLibro)) {
                                libro = l;
                                break;
                        }
                }
                // Buscamos el estudiante en nuestro ArrayList
                for (Estudiante e : estudiantes) {
                        if (e.getNumeroControl().equals(numeroControlEstudiante)) {
                                estudiante = e;
                                break;
                        }
                }
                if (libro != null && libro.isDisponible() && estudiante != null) {
                        // Si el libro esta disponible y existe, se puede prestar
                        Prestamo prestamo = crearPrestamo(id, numeroControlEstudiante, idLibro);
                        libro.setDisponible(false);
                        estudiante.setDeudor(true);
                        // Agregamos el prestamo a la lista de prestamos
                        prestamos.add(prestamo);
                        System.out.println("[SISTEMA] Libro prestado exitosamente.");
                } else if (libro != null && !libro.isDisponible()) {
                        System.out.println("[SISTEMA] El libro ya se encuentra prestado.");
                } else if (estudiante == null) {
                        System.out.println("[SISTEMA] El estudiante no existe.");
                } else {
                        System.out.println("[SISTEMA] El libro no existe en el inventario.");
                }
        }

        // prestar (metodo que englobe prestar revistas y libros)

        void prestarRevista(String id, String idRevista, String numeroControlEstudiante) {
                Revista revista = null;
                Estudiante estudiante = null;

                // Buscamos la revista en nuestro ArrayList
                for (Revista l : revistas) {
                        if (l.getID().equals(idRevista)) {
                                revista = l;
                                break;
                        }
                }
                // Buscamos el estudiante en nuestro ArrayList
                for (Estudiante e : estudiantes) {
                        if (e.getNumeroControl().equals(numeroControlEstudiante)) {
                                estudiante = e;
                                break;
                        }
                }
                if (revista != null && revista.isDisponible() && estudiante != null) {
                        // Si la revista esta disponible y existe, se puede prestar
                        Prestamo prestamo = crearPrestamo(id, numeroControlEstudiante, idRevista);
                        revista.setDisponible(false);
                        estudiante.setDeudor(true);
                        // Agregamos el prestamo a la lista de prestamos
                        prestamos.add(prestamo);
                        System.out.println("[SISTEMA] Revista prestada exitosamente.");
                } else if (revista != null && !revista.isDisponible()) {
                        System.out.println("[SISTEMA] La revista ya se encuentra prestado.");
                } else if (estudiante == null) {
                        System.out.println("[SISTEMA] El estudiante no existe.");
                } else {
                        System.out.println("[SISTEMA] La revista no existe en el inventario.");
                }
        }

        Prestamo crearPrestamo(String id, String numeroControlEstudiante, String idLibro) {
                Prestamo prestamo = new Prestamo();
                prestamo.setId(id);
                prestamo.setNumeroControl(numeroControlEstudiante);
                prestamo.setIdDocumento(idLibro);
                prestamo.setFechaPrestamo(obtenerFechaActual());
                prestamo.setFechaVencimiento(calcularFechaVencimiento());
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
}
