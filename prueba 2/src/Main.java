import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double subtotal = 0.0;
        while (true) {
            System.out.print("Precio (0 para terminar): ");

            if (!sc.hasNextDouble()) {
                System.out.println("Entrada inválida");
                sc.next();
                continue;
            }

            double p = sc.nextDouble();

            if (p == 0) break;

            if (!U2Service.esPrecioValido(p)) {
                System.out.println("Precio inválido (debe ser mayor a 0)");
                continue;
            }

            subtotal = U2Service.sumarAlSubtotal(subtotal, p);
        }
        if (subtotal == 0) {
            System.out.println("No se ingresaron productos. Saliendo...");
            return;
        }

        System.out.println("Método de pago: 1) Efectivo  2) Tarjeta");
        if (!sc.hasNextInt()) {
            System.out.println("Entrada inválida");
            return;
        }
        int metodo = sc.nextInt();

        if (metodo < 1 || metodo > 2) {
            System.out.println("Método inválido");
            return;
        }

        double porcentajeDescuento = U2Service.calcularDescuento(subtotal, metodo);
        double montoDescuento = subtotal * (porcentajeDescuento / 100);
        double total = U2Service.calcularTotal(subtotal, montoDescuento);

        System.out.println("\n=== TICKET ===");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Descuento (" + porcentajeDescuento + "%): " + montoDescuento);
        System.out.println("Total: " + total);

    }
}