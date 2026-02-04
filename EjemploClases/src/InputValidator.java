import java.util.Scanner;

public class InputValidator {
    public int getValidint(String message, Scanner sc){
        int value;
        while (true){
            System.out.println(message);
            if(sc.hasNextInt()){
                value = sc.nextInt();
                if(value>0){
                    return value;
                }
                System.out.println("el numero no es positivo");
            }else{
                System.out.println("el numero no es numerico");
                sc.nextLine();
            }
        }
    }
}
