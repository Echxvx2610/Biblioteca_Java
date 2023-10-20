package Sistemas_comp.Biblioteca_Java;

import java.util.Scanner;

public class Biblioteca {
    // variables globales o atributos de la clase
    static Biblioteca control = new Biblioteca();
    Scanner sc = new Scanner(System.in);
    int opcion;

    public static void main(String[] args) {
        control.menu();
    }

    public void menu(){
        // ciclo para mostrar las opciones del menú
        do{
        // menú del programa el cual pide ingresar una opción
        System.out.println("--- [BIENVENIDO A LA BIBLIOTECA VIRTUAL] ---\n");
        System.out.println("              --- [MENU] ---");
        System.out.println("[1] Inventario");
        System.out.println("[2] Prestar libro");
        System.out.println("[3] Prestar una revista");
        System.out.println("[4] Devoluciones");
        System.out.println("[5] Prestamos");
        System.out.println("[6] Deudores");
        System.out.println("[7] Salir del programa");

        // se guarda la opción en la variable opcion
        opcion = sc.nextInt();

        switch(opcion){
            case 1: // llamar al método ver inventario
                control.verInventario(); break;
            case 2: // llamar al método prestar libro
                control.prestarLibro(); break;
            case 3: // llamar al método prestar una revista
                control.prestarRevista();break;
            case 4: // llamar al método devoluciones
                control.devoluciones(); break;
            case 5: // llamar al método prestamos
                control.prestamos(); break;
            case 6: // llamar al método Deudores
                control.deudores(); break;
            default: // cualquier otra opción no es válida
                System.out.println("La opción " +opcion " no es válida");
            } // fin del swith menú 
        } while(opcion != 7); // se sale del menú si seleccionan 7
    }

    void verInventario() {
        System.out.println("Viendo el inventario....");
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
