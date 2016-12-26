import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> numberList_String = new ArrayList<String>();
        ArrayList<Short> numberList = new ArrayList<Short>();
        
        while(scan.hasNext()) {
            String number = scan.next();
            numberList_String.add(number);
            numberList.add(parseNumber(number));
        }
        
        Collections.sort(numberList);
        
        for(int i = 0; i < numberList.size(); i++) {
            for(int j = 0; j < numberList_String.size(); j++) {
                if(numberList.get(i) == parseNumber(numberList_String.get(j))) {
                    System.out.print(numberList_String.get(j));
                    break;
                }
            }
            if(i == numberList.size() - 1) System.out.println();
            else System.out.print(" ");
        }
    }
    
    static short parseNumber(String number) {
        short parsedNumber = 0;
        try {
            parsedNumber = Short.parseShort(number);
        } catch(Exception e) {
            parsedNumber = (short)(Integer.parseInt(number.substring(2), 16));
        }
        return parsedNumber;
    }
}