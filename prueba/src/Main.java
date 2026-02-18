import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double subtotal = 0.0;
        while (true) {
            System.out.print("Precio del producto (0 para pagar): ");
            if (!sc.hasNextDouble()) {
                System.out.println("Error: Entrada no es un número.");
                sc.next();
                continue;
            }

            double precio = sc.nextDouble();
            if (precio == 0) break;
            if (!U2Service.esPrecioValido(precio)) {
                System.out.println("Precio inválido (debe ser mayor a 0)");
                continue;
            }
            subtotal = U2Service.calcularSubtotal(subtotal, precio);
            System.out.println("Subtotal actual: $" + subtotal);
        }

        if (subtotal > 0) {
            System.out.println("\nTotal acumulado: $" + subtotal);
            System.out.println("Método de pago: 1) Efectivo  2) Tarjeta");

            if (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Saliendo.");
                return;
            }
            int metodo = sc.nextInt();

            if (metodo < 1 || metodo > 2) {
                System.out.println("Método inválido.");
                return;
            }
            double descuento = U2Service.calcularDescuento(subtotal, metodo);
            double total = U2Service.calcularTotal(subtotal, descuento);

            System.out.println("\n--- TICKET DE VENTA ---");
            System.out.printf("Subtotal:  $%.2f\n", subtotal);
            System.out.printf("Descuento: $%.2f\n", descuento);
            System.out.printf("TOTAL:     $%.2f\n", total);
        } else {
            System.out.println("No se registraron ventas.");
        }
    }
}