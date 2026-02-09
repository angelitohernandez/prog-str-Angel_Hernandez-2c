import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();

        String nombre = Validador.leerTextoNoVacio(sc, "Nombre del alumno: ");
        double p1 = Validador.leerDoubleEnRango(sc, "Parcial 1 (0-100): ", 0, 100);
        double p2 = Validador.leerDoubleEnRango(sc, "Parcial 2 (0-100): ", 0, 100);
        double p3 = Validador.leerDoubleEnRango(sc, "Parcial 3 (0-100): ", 0, 100);

        int asistencia = Validador.leerIntEnRango(sc, "Asistencia (0-100): ", 0, 100);
        boolean entregoProyecto = Validador.leerBoolean(sc, "¿Entregó proyecto? (true/false): ");

        double promedio = service.calcularPromedio(p1, p2, p3);
        double finalCalificacion = service.calcularFinal(promedio, asistencia);
        String estado = service.determinarEstado(finalCalificacion, asistencia, entregoProyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia,
                entregoProyecto, finalCalificacion, estado);

        sc.close();
    }
    public static void imprimirReporte(
            String nombre,
            double p1, double p2, double p3,
            double promedio,
            int asistencia,
            boolean entregoProyecto,
            double finalCalificacion,
            String estado
    ) {
        System.out.println("\n      REPORTE FINAL ");
        System.out.println("Alumno: " + nombre);
        System.out.println("Parciales: " + "Parcial 1: " + p1 + ", " + "Parcial 2: " + p2 + ", "+"Parcial 3: " + p3);
        System.out.printf("Promedio: %.2f%n", promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entregó proyecto: " + entregoProyecto);
        System.out.printf("Calificación final: %.2f%n", finalCalificacion);
        System.out.println("Estado: " + estado);
    }
}
