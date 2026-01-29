import java.util.Scanner;

public class ActividadIfElseTarifa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int edad;
        int tarifa = 0;
        boolean estudiante;

        System.out.println("Ingresa tu edad:");
        edad = scanner.nextInt();

        if (edad < 0 || edad > 120) {
            System.out.println("Edad no valida :(");
            return;
        }

        System.out.println("¿Eres un estudiante? (true/false)");
        estudiante = scanner.nextBoolean();

        if (edad < 12) {
            tarifa = 50;
        } else if (edad >= 12 && edad <= 17) {
            if (estudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        } else if (edad >= 18) {
            if (estudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }

        System.out.println("La edad es: " + edad);
        System.out.println("Es un estudiante: " + estudiante);
        System.out.println("La tarifa es de: " + tarifa);
    }
}