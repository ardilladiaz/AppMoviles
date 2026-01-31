

import java.util.Scanner;

public class AlkeWalletApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String usuarioReg = "", claveReg = "";
        boolean registrado = false;

        // Registro
        System.out.println("BIENVENIDO A ALKE WALLET: REGISTRO");
        while (!registrado) {
            System.out.print("Nombre de usuario: ");
            usuarioReg = scanner.next();
            System.out.print("Cree su contraseña: ");
            String pass1 = scanner.next();
            System.out.print("Confirme su contraseña: ");
            String pass2 = scanner.next();

	// Comparación
            if (pass1.equals(pass2)) { 
                claveReg = pass1;
                registrado = true;
                System.out.println("Registro completado con éxito.");
            } else {
                System.out.println("Las contraseñas no coinciden. Reintente.");
            }
        }

        // Inicio de sesión
        System.out.println("\nINICIO DE SESIÓN");
        boolean login = false;
        while (!login) {
            System.out.print("Usuario: ");
            String user = scanner.next();
            System.out.print("Contraseña: ");
            String pass = scanner.next();

            if (user.equals(usuarioReg) && pass.equals(claveReg)) {
                login = true;
                System.out.println("Acceso concedido.");
                menuOperaciones(scanner);
            } else {
                System.out.println("Credenciales incorrectas.");
            }
        }
        scanner.close();
    }

    public static void menuOperaciones(Scanner scanner) {
        CuentaDebito miCuenta = new CuentaDebito();
        int opcion;
        // Valores de conversión
        final double USD = 873.36; //Valor Viernes 30 de Enero
        final double EUR = 1028.22; //Valor Viernes 30 de Enero

        do {
            System.out.println("\nMENU DE OPERACIONES");
            System.out.println("1. Ver Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Saldo en Dólares");
            System.out.println("5. Saldo en Euros");
            System.out.println("6. Salir");
            System.out.print("Seleccione: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + miCuenta.getSaldo() + " CLP");
                    break;
                case 2:
                    System.out.print("Monto a depositar: ");
                    miCuenta.depositar(scanner.nextDouble());
                    break;
                case 3:
                    System.out.print("Monto a retirar: ");
                    if (!miCuenta.retirar(scanner.nextDouble())) {
                        System.out.println("Error: Fondos insuficientes.");
                    } else {
                        System.out.println("Retiro exitoso.");
                    }
                    break;
                case 4:
                    System.out.printf("Saldo: %.2f USD\n", (miCuenta.getSaldo() / USD));
                    break;
                case 5:
                    System.out.printf("Saldo: %.2f EUR\n", (miCuenta.getSaldo() / EUR));
                    break;
                case 6:
                    System.out.println("Sesión cerrada.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6); // Estructura repetitiva
    }
}
