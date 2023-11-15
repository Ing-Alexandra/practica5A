package uabc.ic.MasterMind;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a MasterMind");
        System.out.println("¿Qué versión deseas jugar?");
        System.out.println("1. Versión completa");
        System.out.println("2. Versión de prueba (con clave secreta)");

        int opcion = scanner.nextInt();

        if (opcion == 1) {
            MasterMind juegoCompleto = new MasterMind();
            juegoCompleto.jugar();
        } else if (opcion == 2) {
            MasterMind juegoPrueba = new MasterMind(true);
            juegoPrueba.jugar();
        } else {
            System.out.println("Opción no válida. Por favor, elige 1 o 2.");
        }
    }
}