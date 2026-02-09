import java.util.Scanner;
public class Validador {
    public static String leerTextoNoVacio(Scanner sc, String Mensaje) {
        String texto;
        do {
            System.out.print(Mensaje);
            texto = sc.nextLine();
        } while (texto.isEmpty());
        return texto;
    }
    public static double leerDoubleEnRango(Scanner sc, String Mensaje, double min, double max) {
        double valor;
        while (true) {
            System.out.print(Mensaje);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                if (valor >= min && valor <= max) {
                    sc.nextLine();
                    return valor;
                }
            } else {
                sc.next();
            }
            System.out.println("Valor inválido. Rango permitido: " + min + " a " + max);
        }
    }
    public static int leerIntEnRango(Scanner sc, String Mensaje, int min, int max) {
        int valor;
        while (true) {
            System.out.print(Mensaje);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    sc.nextLine();
                    return valor;
                }
            } else {
                sc.next();
            }
            System.out.println("Valor inválido. Rango permitido: " + min + " a " + max);
        }
    }
    public static boolean leerBoolean(Scanner sc, String Mensaje) {
        while (true) {
            System.out.print(Mensaje);
            if (sc.hasNextBoolean()) {
                boolean valor = sc.nextBoolean();
                sc.nextLine();
                return valor;
            } else {
                sc.next();
                System.out.println("Solo se acepta true o false.");
            }
        }
    }
}

