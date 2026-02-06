import java.util.Scanner;

public class Main {

    public static void imprimirTicket(
            int tipoServicio,
            double peso,
            int distancia,
            boolean zonaRemota,
            double subtotal,
            double iva,
            double total) {

        System.out.println("\n========= TICKET DE ENVÍO =========");
        System.out.println("Servicio: " + (tipoServicio == 1 ? "Estándar" : "Express"));
        System.out.println("Peso (kg): " + peso);
        System.out.println("Distancia (km): " + distancia);
        System.out.println("Zona remota: " + zonaRemota);
        System.out.println("");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("IVA (16%): $" + iva);
        System.out.println("Total final: $" + total);
        System.out.println("=================================");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InputValidator iv = new InputValidator();
        ShippingCalculator calc = new ShippingCalculator();

        double pesoKg = iv.leerDoubleEnRango(
                "Ingrese peso (0.1 - 50.0 kg): ", sc, 0.1, 50.0);

        int distanciaKm = iv.leerIntEnRango(
                "Ingrese distancia (1 - 2000 km): ", sc, 1, 2000);

        int tipoServicio = iv.leerIntEnRango(
                "Tipo de servicio (1=Estándar, 2=Express): ", sc, 1, 2);

        boolean zonaRemota = iv.leerBoolean(
                "¿Es zona remota? (true/false): ", sc);

        double subtotal = calc.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, zonaRemota);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal, iva);

        imprimirTicket(tipoServicio, pesoKg, distanciaKm, zonaRemota, subtotal, iva, total);

        sc.close();
    }
}
