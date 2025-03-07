import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cajafuerte pin = new Cajafuerte();
        menuPrincipal(scanner, pin);
    }

    public static void menuPrincipal(Scanner scanner, Cajafuerte pin) {
        while (true) {
            System.out.println("\n🔒 Bienvenido a la caja fuerte 🔒");
            System.out.println("1. Modificar contraseña (Por defecto = 0000)");
            System.out.println("2. Abrir caja");
            System.out.println("3. Cerrar caja");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    pin.setPin();
                    break;

                case 2:
                    abrirCaja(scanner, pin);
                    break;

                case 3:
                    System.out.println("Caja cerrada.");
                    pin.setAbierta(false);
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    public static void abrirCaja(Scanner scanner, Cajafuerte pin) {
        if (pin.isAbierta()) {
            menuCajaFuerte(scanner, pin);
            return;
        }
        if (pin.estaBloqueada()) {
            System.out.println("La caja fuerte está bloqueada por demasiados intentos fallidos.");
            return;
        }

        boolean accesoPermitido;
        int pinIngresado;

        do {
            System.out.print("Ingrese el Código: ");
            pinIngresado = scanner.nextInt();
            accesoPermitido = pin.VerificarPin(pinIngresado);

            if (accesoPermitido) {
                System.out.println("Caja abierta.");
                pin.setAbierta(true);
                menuCajaFuerte(scanner, pin);
            } else {
                pin.setIntentos(pin.getIntentos() + 1);
                System.out.println("Código incorrecto. Intentos restantes: " + (10 - pin.getIntentos()));
                if (pin.estaBloqueada()) {
                    System.out.println("Has superado el número máximo de intentos, caja cerrada.");
                }
            }
        } while (!accesoPermitido && !pin.estaBloqueada());
    }

    public static void menuCajaFuerte(Scanner scanner, Cajafuerte pin) {
        while (pin.isAbierta()) {
            System.out.println("Menú de la Caja Fuerte");
            System.out.println("1. Agregar objeto");
            System.out.println("2. Eliminar objeto");
            System.out.println("3. Mostrar objetos");
            System.out.println("4. Cerrar caja");
            System.out.println("5. Regresar al menu principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el objeto a guardar: ");
                    String objeto = scanner.nextLine();
                    pin.agregarObjeto(objeto);
                    System.out.println("Objeto agregado.");
                    break;

                case 2:
                    System.out.print("Ingrese el objeto a eliminar: ");
                    String eliminar = scanner.nextLine();
                    if (pin.eliminarObjeto(eliminar)) {
                        System.out.println(" Objeto eliminado.");
                    } else {
                        System.out.println("El objeto no está en la caja.");
                    }
                    break;

                case 3:
                    pin.mostrarObjetos();
                    break;

                case 4:
                    System.out.println("Cerrando la caja...");
                    pin.setAbierta(false);
                    return;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    return;
                default:
                    System.out.println(" Opción no válida.");
            }
        }
    }
}
