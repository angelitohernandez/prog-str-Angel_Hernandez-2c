import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;

        do {
            try {
                System.out.println("Menu de Conversiones");
                System.out.println("1) C a F");
                System.out.println("2) F a C");
                System.out.println("3) Km a Millas");
                System.out.println("4) Millas a Km");
                System.out.println("5) Salir");
                System.out.print("Elige una opcion: ");
                opcion = sc.nextInt();

                if (opcion >= 1 && opcion <= 4) {
                    switch (opcion) {
                        case 1:
                            System.out.println("\nCelsius a Fahrenheit");
                            System.out.println("Ingrese la temperatura: ");
                            double valor1 = sc.nextDouble();
                            System.out.println("Resultado: " + ((valor1 * 9/5) + 32) + " °F");
                            c1++;
                            break;
                        case 2:
                            System.out.println("\nFahrenheit a Celsius");
                            System.out.println("Ingrese la temperatura: ");
                            double valor2 = sc.nextDouble();
                            System.out.println("Resultado: " + ((valor2 - 32) * 5/9) + " °C");
                            c2++;
                            break;
                        case 3:
                            System.out.println("\nKilometros a Millas");
                            System.out.println("Ingrese los Kilometros: ");
                            double valor3 = sc.nextDouble();
                            System.out.println("Resultado: " + (valor3 * 0.621) + "Mi");
                            c3++;
                            break;
                        case 4:
                            System.out.println("\nMillas a Kilometros");
                            System.out.println("Ingrese las millas: ");
                            double valor4 = sc.nextDouble();
                            System.out.println("Resultado: " + (valor4 / 0.621) + "Km");
                            c4++;
                            break;
                    }
                } else if (opcion != 5) {
                    System.out.println("Error: Elige un numero entre 1 y 5.");
                }

            } catch (Exception e) {
                System.out.println("¡Error! Solo se permiten datos numericos.");
                sc.next();
                opcion = 0;
            }
        } while (opcion != 5);

        System.out.println("\nResumen de Menu de Conversiones");
        System.out.println("Conversiones C a F: " + c1);
        System.out.println("Conversiones F a C: " + c2);
        System.out.println("Conversiones Km a Mi: " + c3);
        System.out.println("Conversiones Mi a Km: " + c4);
        System.out.println("Total realizado: " + (c1 + c2 + c3 + c4));
    }
}