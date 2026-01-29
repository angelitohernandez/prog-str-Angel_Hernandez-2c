import java.util.Scanner;
public class ActividadSwitchCalculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        double numero1;
        double numero2;
        double resultado;

        System.out.println("Menu Calculadora ");
        System.out.println("1. Suma ");
        System.out.println("2. Resta ");
        System.out.println("3. Multiplicacion ");
        System.out.println("4. Division ");
        System.out.println("5. Salir ");
        System.out.println("Ingresa la opcion solicitada:  ");
        opcion = scanner.nextInt();

        switch (opcion){

            case 1:
                System.out.println("SUMA");
                System.out.println("Ingresa un numero");
                numero1 = scanner.nextDouble();
                System.out.println("Ingresa un numero");
                numero2 = scanner.nextDouble();
                resultado = numero1+numero2;
                System.out.println("El resultado es: " + resultado);
                break;

            case 2:
                System.out.println("RESTA");
                System.out.println("Ingresa un numero");
                numero1 = scanner.nextDouble();
                System.out.println("Ingresa un numero");
                numero2 = scanner.nextDouble();
                resultado = numero1-numero2;
                System.out.println("El resultado es: " + resultado);
                break;

            case 3:
                System.out.println("MULTIPLICACION");
                System.out.println("Ingresa un numero");
                numero1 = scanner.nextDouble();
                System.out.println("Ingresa un numero");
                numero2 = scanner.nextDouble();
                resultado = numero1*numero2;
                System.out.println("El resultado es: " + resultado);
                break;

            case 4:
                System.out.println("DIVISION");
                System.out.println("Ingresa un numero");
                numero1 = scanner.nextDouble();
                System.out.println("Ingresa un numero");
                numero2 = scanner.nextDouble();
                if(numero2==0){
                    System.out.println("Numero no valido, ingresa un numero mayor a 0");
                }else {
                    resultado = numero1 / numero2;
                    System.out.println("El resultado es: " + resultado);
                }
                break;
            case 5:
                System.out.println("Usted ha salidor del programa");
                break;
            default:
                System.out.println("Opción no válida. Por favor intenta de nuevo.");

        }

    }

}