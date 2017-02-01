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
        
        Iterator<Short> it = numberMap.keySet().iterator();
        while (it.hasNext()) {
            Short key = it.next();
            if(it.hasNext()) System.out.print(numberMap.get(key) + " ");
            else System.out.println(numberMap.get(key));
        }
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