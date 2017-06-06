import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int S = Integer.parseInt(br.readLine()); //�w�蕶����
        long N = Long.parseLong(br.readLine()); //�w��s��
        int M = Integer.parseInt(br.readLine()); //�\���s��
        
        char[] charCodeList = str.toCharArray();
        Arrays.sort(charCodeList);
        
        int[] digit = new int[S];
        long powNumber;
        
        for(int i = 0; i < M; i++) {
            powNumber = i + N - 1;
            
            for(int j = S-1; j >= 0; j--) {
                digit[j] = (int)(powNumber % charCodeList.length);
                powNumber /= charCodeList.length;
            }
            
            for(int j = 0; j < S; j++) {
                System.out.print(charCodeList[digit[j]]);
            }
            System.out.println();
        }
    }
}