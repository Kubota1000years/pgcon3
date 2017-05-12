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
        long N = Long.parseLong(br.readLine()); //指定行数
        int M = Integer.parseInt(br.readLine()); //表示行数
        
        char[] charCodeList = str.toCharArray();
        Arrays.sort(charCodeList);
        
        int[][] digit = new int[M][S];
        Long powNumber;
        char[][] answer = new char[M][S];
        
        for(int i = 0; i < M; i++) {
            boolean isMaxLongValue = false;
            if(i + N >= 0) {
                powNumber = i + N;
            } else {
                //Long値の最大値を超えないよう、Mの最大値である1000を減算
                powNumber = (-1000) + i + N;
                isMaxLongValue = true;
            }
            for(int j = 0; j < S; j++) {
                double pow = Math.pow(charCodeList.length, S - j - 1);
                long lPow = (long)pow;
                while(powNumber > lPow) {
                    digit[i][j]++;
                    powNumber -= lPow;
                    
                    if(isMaxLongValue) {
                        powNumber += 1000;
                        isMaxLongValue = false;
                    }
                }
                
                answer[i][j] = charCodeList[digit[i][j]];
            }
        }
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < S; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }
}