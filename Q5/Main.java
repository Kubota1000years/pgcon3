import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for(int i = 20*(N/20); i >= 0; i = i-20) {
            if(isFinished(N, i, 0, 0, 0)) return;
            for(int j = 9*(N/9); j >= 0; j = j-9) {
                if(isFinished(N, i, j, 0, 0)) return;
                for(int k = 6*(N/6); k >= 0; k = k-6) {
                    if(isFinished(N, i, j, k, 0)) return;
                    for(int l = 4*(N/4); l >= 0; l = l-4) {
                        if(isFinished(N, i, j, k, l)) return;
                    }
                }
            }
        }
    }
    
    static boolean isFinished(int N, int i, int j, int k, int l) {
        if(N - i - j - k - l == 0) {
            System.out.println(i/20 + " " + j/9 + " " + k/6 + " " + l/4);
            return true;
        }
        return false;
    }
}