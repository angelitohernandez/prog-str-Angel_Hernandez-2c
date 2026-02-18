public class U2Service {

    // Cambiado a boolean para validar si el precio es correcto
    public static boolean esPrecioValido(double precio) {
        return precio > 0;
    }

    // Acumula el precio al subtotal actual
    public static double calcularSubtotal(double subtotalActual, double precio) {
        return subtotalActual + precio;
    }

    // Calcula el descuento según las reglas de negocio
    public static double calcularDescuento(double subtotal, int metodoPago) {
        double descuento = 0.0;

        // Regla: Solo si el subtotal es >= 500 hay descuento
        if (subtotal >= 500) {
            if (metodoPago == 1) { // 1: Efectivo (8%)
                descuento = subtotal * 0.08;
            } else if (metodoPago == 2) { // 2: Tarjeta (5%)
                descuento = subtotal * 0.05;
            }
        }
        return descuento;
    }

    // Resta el descuento al subtotal
    public static double calcularTotal(double subtotal, double descuento) {
        return subtotal - descuento;
    }
}