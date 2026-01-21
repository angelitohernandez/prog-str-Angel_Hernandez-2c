import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seleccion;
        do {
            System.out.println("      MENÚ DE OPERACIONES");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectangulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular área de un círculo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next();
            }
            seleccion = scanner.nextInt();

            switch (seleccion) {
                case 1:
                    System.out.print("Ingresa tu peso en kg: ");
                    double peso = scanner.nextDouble();
                    System.out.print("Ingresa tu altura en metros: ");
                    double altura = scanner.nextDouble();
                    double imc = calcularIMC(peso, altura);
                    System.out.printf("Tu IMC es: ", imc);
                    break;

                case 2:
                    System.out.print("Ingresa la base del rectángulo: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingresa la altura del rectángulo: ");
                    double alturaRect = scanner.nextDouble();
                    double areaRect = calcularAreaRectangulo(base, alturaRect);
                    System.out.println("El área del rectángulo es: " + areaRect);
                    break;

                case 3:
                    System.out.print("Ingresa los grados Celsius: ");
                    double celsius = scanner.nextDouble();
                    double fahrenheit = convertirCelsiusAFahrenheit(celsius);
                    System.out.println(celsius + "°celsius equivalen a " + fahrenheit + "°fahrenheit");
                    break;

                case 4:
                    System.out.print("Ingresa el radio del círculo: ");
                    double radio = scanner.nextDouble();
                    double areaCirculo = calcularAreaCirculo(radio);
                    System.out.println("El área del rectángulo es: " + areaCirculo);
                    break;

                case 5:
                    System.out.println("Usted ha salido del programa");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
            System.out.println();
        } while (seleccion != 5);}

    /**
     * Fórmula: peso / (altura * altura).
     * * @param peso El peso de la personxa en kilogramos y la altura en Metros.
     * @return Resultado del IMC del usuario.
     */
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    /**
     * Calcula el área de un rectángulo.
     * Fórmula: base * altura.
     * * @param base La longitud de la base del rectángulo.
     * @param altura La longitud de la altura del rectángulo.
     * @return El área total del rectángulo.
     */
    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Fórmula: (C * 1.8) + 32.
     * * @param Ingresa los GRADOS A CONVERTIR
     * @return La temperatura a grados fahrenheit
     */
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Fórmula: PI * radio^2.
     * * @param radio del círculo.
     * @return El área calculada del círculo.
     */
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
}
