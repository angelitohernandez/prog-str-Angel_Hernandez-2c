public class ShippingCalculator {

    private final double IVA = 0.16;
    private final double PRECIO_ESTANDAR = 50;
    private final double PRECIO_EXPRESS = 90;
    private final double COSTO_POR_KG = 12;

    public ShippingCalculator() {
    }

    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {

        double subtotal = 0;

        if (tipoServicio == 1) {
            subtotal += PRECIO_ESTANDAR;
        } else {
            subtotal += PRECIO_EXPRESS;
        }

        subtotal += pesoKg * COSTO_POR_KG;

        if (distanciaKm <= 50) {
            subtotal += 20;
        } else if (distanciaKm <= 200) {
            subtotal += 60;
        } else {
            subtotal += 120;
        }

        if (zonaRemota) {
            subtotal += subtotal * 0.10;
        }

        return subtotal;
    }

    public double calcularIVA(double subtotal) {
        return subtotal * IVA;
    }

    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}
