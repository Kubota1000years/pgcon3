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
    	int S = Integer.parseInt(br.readLine()); //指定文字数
        int N = Integer.parseInt(br.readLine()); //指定行数
        int M = Integer.parseInt(br.readLine()); //表示行数
        
        char[] charCodeList = str.toCharArray();
        Arrays.sort(charCodeList);
        
        int[][] digit = new int[S][M];
        int powNumber;
        char[][] answer = new char[S][M];
        
        for(int i = 0; i < S; i++) {
            powNumber = i + N;
            for(int j = 0; j < M; j++) {
                double pow = Math.pow(S, M - j - 1);
                while(powNumber > pow) {
                    digit[i][j]++;
                    powNumber -= pow;
                }
                answer[i][j] = charCodeList[digit[i][j]];
            }
        }
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < S - M; j++) {
                System.out.print('0');
            }
            for(int j = 0; j < M; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }
}