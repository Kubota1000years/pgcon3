import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String product1 = scan.next();
        String product2 = scan.next();
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        double num3 = scan.nextDouble();
        
        String output = String.format("%-19s %19s %09d %9s %9.3f", 
            product1, product2, num1, num2, num3);
        System.out.println(output);
    }
}