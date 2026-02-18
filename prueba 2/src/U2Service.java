public class U2Service {

    public static boolean esPrecioValido(double precio) {
        return precio > 0;
    }
    public static double sumarAlSubtotal(double subtotalActual, double precio) {
        return subtotalActual + precio;
    }

    public static double calcularDescuento(double subtotal, int metodoPago) {
        if (subtotal >= 500) {
            if (metodoPago == 1) return 8;
            if (metodoPago == 2) return 5;
        }
        return 0;
    }
    public static double calcularTotal(double subtotal, double montoDescuento) {
        return subtotal - montoDescuento;
    }
}