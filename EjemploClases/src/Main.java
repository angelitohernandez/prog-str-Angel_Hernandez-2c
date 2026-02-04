import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tiket tiket = new Tiket();//Declaracion de un Objeto
        InputValidator inputValidator = new InputValidator();
        Scanner sc = new Scanner(System.in);
        //I-P-O
        //Input

        int cantidad = inputValidator.getValidint("Ingresa la cantidad de articulos",sc);

        //Process
        tiket.process(cantidad);
        //Output
        tiket.imprimirTicket(cantidad);
    }
}
