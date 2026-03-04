public class U2Service {

    // ID válido: exactamente 8 caracteres alfanuméricos (A-Z, a-z, 0-9)
    public static boolean esIdValido(String id) {
        if (id == null) return false;

        // 1. Validamos longitud exacta de 8 y que no tenga espacios
        if (id.length() != 8 || id.contains(" ")) {
            return false;
        }

        // 2. Revisamos cada carácter uno por uno
        for (int i = 0; i < id.length(); i++) {
            char ch = id.charAt(i);

            // Verificamos si es letra (mayúscula o minúscula) o número
            boolean esLetra = (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
            boolean esDigito = (ch >= '0' && ch <= '9');

            // Si NO es letra Y TAMPOCO es dígito, el ID es inválido
            if (!esLetra && !esDigito) {
                return false;
            }
        }

        // Si pasó todas las pruebas anteriores, es válido
        return true;
    }

    // Horario permitido: 7..19 inclusive
    public static boolean esHorarioPermitido(int hora) {
        // Retorna verdadero si la hora está entre 7 y 19
        return (hora >= 7 && hora <= 19);
    }
}