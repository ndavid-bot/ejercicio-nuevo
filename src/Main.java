// David Fernando Gonzalez Soler

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cajafuerte pin = new Cajafuerte();
        while (true) {
            System.out.println("\n🔒 Bienvenido a la caja fuerte 🔒");
            System.out.println("1. Modificar contraseña (Por defecto = 0000)");
            System.out.println("2. Abrir caja");
            System.out.println("3. Cerrar caja");
            System.out.println("4. Salir ");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                        pin.setPin();
                    break;

                case 2:
                    System.out.println("Ingrese el Código : ");
                    int pinIngresado = scanner.nextInt();



                break;

                case 3:
                    System.out.println("🔒 Caja cerrada.");
                    break;

                case 4:
                    System.out.println("🚪 Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Opción no válida, intente de nuevo.");
            }




        }
    }
}