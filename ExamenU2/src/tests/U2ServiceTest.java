


public class U2ServiceTest {

    private static void assertTrue(boolean cond, String msg) {
        if (!cond) throw new AssertionError("FALLÓ: " + msg);
    }

    private static void assertFalse(boolean cond, String msg) {
        if (cond) throw new AssertionError("FALLÓ: " + msg);
    }

    public static void main(String[] args) {
        // ---- esIdValido ----
        //assertTrue(U2Service.esIdValido("AB12cd34"), "ID alfanumérico 8 chars debería ser válido");
        assertTrue(U2Service.esIdValido("12345678"), "8 dígitos válido");
        //assertTrue(U2Service.esIdValido("abcdEF12"), "8 alfanum válido");

        assertFalse(U2Service.esIdValido(null), "null inválido");
        assertFalse(U2Service.esIdValido(""), "vacío inválido");
        assertFalse(U2Service.esIdValido("ABC123"), "longitud != 8 inválido");
        assertFalse(U2Service.esIdValido("ABCDEFGHI"), "longitud 9 inválido");
        assertFalse(U2Service.esIdValido("AB12 CD3"), "espacio inválido");
        assertFalse(U2Service.esIdValido("AB12-CD3"), "guion inválido");
        assertFalse(U2Service.esIdValido("AB12_cd3"), "underscore inválido");
        assertFalse(U2Service.esIdValido("AB12cd3!"), "símbolo inválido");

        // ---- esHorarioPermitido ----
        assertTrue(U2Service.esHorarioPermitido(7), "7 permitido");
        assertTrue(U2Service.esHorarioPermitido(19), "19 permitido");
        assertTrue(U2Service.esHorarioPermitido(12), "12 permitido");

        assertFalse(U2Service.esHorarioPermitido(6), "6 NO permitido");
        assertFalse(U2Service.esHorarioPermitido(20), "20 NO permitido");
        assertFalse(U2Service.esHorarioPermitido(-1), "-1 NO permitido");
        assertFalse(U2Service.esHorarioPermitido(24), "24 NO permitido");

        System.out.println("Todas las pruebas pasaron (U2ServiceTest).");
    }
}