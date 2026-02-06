import java.util.Scanner;

public class InputValidator {

    public double leerDoubleEnRango(String mensaje, Scanner sc, double min, double max) {
        double value;

        while (true) {
            System.out.println(mensaje);

            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                sc.nextLine();

                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("El número está fuera de rango");
                }
            } else {
                System.out.println("El dato no es numérico");
                sc.nextLine();
            }
        }
    }

    public int leerIntEnRango(String mensaje, Scanner sc, int min, int max) {
        int value;

        while (true) {
            System.out.println(mensaje);

            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();

                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("El número está fuera de rango");
                }
            } else {
                System.out.println("El dato no es numérico");
                sc.nextLine();
            }
        }
    }

    public boolean leerBoolean(String mensaje, Scanner sc) {
        while (true) {
            System.out.println(mensaje);

            if (sc.hasNextBoolean()) {
                boolean value = sc.nextBoolean();
                sc.nextLine();
                return value;
            } else {
                System.out.println("Solo se acepta true o false");
                sc.nextLine();
            }
        }
    }
}
