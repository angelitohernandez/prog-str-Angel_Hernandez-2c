import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalRegistros = 0;
        int totalPermitidos = 0;
        int totalDenegados = 0;

        while (true) {
            System.out.print("ID (o FIN para salir): ");
            String id = sc.next();

            // Rompe el ciclo si el usuario escribe FIN
            if (id.equalsIgnoreCase("FIN")) break;

            System.out.print("Hora (0..23): ");
            // Validar que el usuario ingrese un número para evitar errores
            if (!sc.hasNextInt()) {
                System.out.println("Error: Debes ingresar un número para la hora.");
                break;
            }
            int hora = sc.nextInt();

            // Si la hora está fuera del rango de un día, termina el programa
            if (hora < 0 || hora > 23) {
                System.out.println("Hora inválida. Fin del programa.");
                return;
            }

            // Validar el ID usando nuestra clase U2Service
            if (!U2Service.esIdValido(id)) {
                System.out.println("ID inválido (debe ser de 8 caracteres alfanuméricos)");
                continue; // Salta al siguiente ciclo sin contar el registro
            }

            totalRegistros++;

            // Verificar si el acceso es permitido según la hora
            if (U2Service.esHorarioPermitido(hora)) {
                totalPermitidos++;
                System.out.println(">>> ACCESO PERMITIDO");
            } else {
                totalDenegados++;
                System.out.println(">>> ACCESO DENEGADO");
            }
        }

        // Mostrar resultados finales
        System.out.println("\n=========================");
        System.out.println("       RESUMEN           ");
        System.out.println("=========================");
        System.out.println("Total registros: " + totalRegistros);
        System.out.println("Permitidos:      " + totalPermitidos);
        System.out.println("Denegados:       " + totalDenegados);

        // Cálculo del porcentaje con casting a double para precisión
        double porcentaje = 0;
        if (totalRegistros > 0) {
            porcentaje = ((double) totalPermitidos / totalRegistros) * 100;
        }

        System.out.printf("Porcentaje permitidos: %.2f%%\n", porcentaje);
        System.out.println("=========================");

        sc.close();
    }
}