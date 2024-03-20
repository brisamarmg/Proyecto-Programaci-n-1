package app;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
public class App {
    private static List<String> carros = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {


            System.out.println("=== MENU ===");
            System.out.println("1: Fase 1 - Objetos y Recursividad ");
            System.out.println("2: Fase 2");
            System.out.println("3: Fase 3");
            System.out.println("4: Salir del programa");
            System.out.println("=== Selecciona una opción ===");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    submenu1();
                    break;
                case 2:
                    System.out.println("Opcion 2");
                    break;
                case 3:
                    System.out.println("Opcion 3");
                    break;
                case 4:
                    System.out.println("Saliendo del programa.....");
                default:
                    System.out.println("Selecciona una opcion valida");
            }

        }while (opcion != 4);
            
    }

    public static void submenu1(){
        Scanner sub1 = new Scanner(System.in);
        char opcion;

        System.out.println("a: Ingrese datos de vehiculos");
        System.out.println("b: Mostrar datos de vehiculos");
        System.out.println("c: Crear una torre de Hanoi");
        System.out.println("d: Regresar al menu principal");
        opcion = sub1.nextLine().charAt(0);

        switch (opcion){
            case 'a':
                System.out.println("Selecciona un vehiculo");
                vehiculos();
                break;
            case 'b':
                mostrarDatos();
                break;
            case 'c':
                hanoi();
                break;
            case 'd':
                System.out.println("Seleccionaste la opcion d");
                break;
            default:
                System.out.println("Selecciona una opcion valida");
                break;
        }

    }

    public static void vehiculos(){
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("1: Carro");
        System.out.println("2: Balsa");
        System.out.println("3: Avion");
        opcion = sc.nextInt();

        switch (opcion){
            case 1:
                carro();
                break;
            case 2:
                balsa();
                break;
            case 3:
                avion();
                break;
            default:
                System.out.println("Selecciona una opcion valida");
                break;
        }

    }

    public static void carro(){

        Scanner sc = new Scanner(System.in);
        System.out.println("=== Datos del carro ===");
        System.out.println("**********************");
        System.out.println("Tipo de Gasolina");
        String tipoGasolina = sc.nextLine();
        carros.add(tipoGasolina);
    }

    public static void balsa(){
        System.out.println("=== Datos de la balsa ===");

    }

    public static void avion(){

        System.out.println("=== Datos del avion ===");

    }

    public static void mostrarDatos(){
       for (int i = 0; i < carros.size(); i++){
            System.out.println("Tipo de combustible "+ carros.get(i));
       }

    }

    public static void hanoi(){
        Scanner sc = new Scanner(System.in);
        char torreOrigen = 'A';
        char torreAuxiliar = 'B';
        char torreDestino = 'C';

        System.out.println("Bienvenido al juego de las Torres de Hanoi");
        System.out.println("Seleccione una opción:");
        System.out.println("a) Resolver con 3 discos");
        System.out.println("b) Resolver con 4 discos");
        System.out.println("c) Resolver con un número personalizado de discos");

        String opcion = sc.nextLine();

        int numDiscos;
        if (opcion.equalsIgnoreCase("a")) {
            numDiscos = 3;
        } else if (opcion.equalsIgnoreCase("b")) {
            numDiscos = 4;
        } else if (opcion.equalsIgnoreCase("c")) {
            do {
                System.out.println("Ingrese el número de discos (mínimo 3):");
                numDiscos = sc.nextInt();
            } while (numDiscos < 3);
        } else {
            System.out.println("Opción inválida. Saliendo del programa.");
            return;
        }

        resolverTorresDeHanoi(numDiscos, torreOrigen, torreAuxiliar, torreDestino);

    }

    public static void resolverTorresDeHanoi(int numDiscos, char torreOrigen, char torreAuxiliar, char torreDestino) {
        if (numDiscos == 1) {
            System.out.println(torreOrigen + " --> " + torreDestino);
        } else {
            resolverTorresDeHanoi(numDiscos - 1, torreOrigen, torreDestino, torreAuxiliar);
            System.out.println(torreOrigen + " --> " + torreDestino);
            resolverTorresDeHanoi(numDiscos - 1, torreAuxiliar, torreOrigen, torreDestino);
        }
    }


}
