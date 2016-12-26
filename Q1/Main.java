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
        
        System.out.println(String.format("%-19s", product1) + " " + String.format("%19s", product2) + " " + 
            String.format("%09d", num1) + " " + String.format("%9s", String.valueOf(num2)) + " " + 
            String.format("%9s", String.format("%.3f", num3)));
    }
}