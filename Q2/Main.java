import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<Short, String> numberMap = new TreeMap<Short, String>();
        
        while(scan.hasNext()) {
            String number = scan.next();
            numberMap.put(parseNumber(number), number);
        }
        
        for (Short key : numberMap.keySet()) {
            System.out.print(numberMap.get(key));
            if(key != numberMap.lastKey()) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    static short parseNumber(String number) {
        short parsedNumber = 0;
        if(number.startsWith("0x")) {
            parsedNumber = (short)(Integer.parseInt(number.substring(2), 16));
        } else {
            parsedNumber = (short)(Integer.parseInt(number));
        }
        return parsedNumber;
    }
}