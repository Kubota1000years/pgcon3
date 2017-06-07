import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String[] compareWord = new String[N];
        
        for(int i = 0; i < N; i++) compareWord[i] = br.readLine();
        
        line = br.readLine();
        int M = Integer.parseInt(line);
        
        for(int i = 0; i < M; i++) {
            String searchWord = br.readLine();
            List<Integer> answerList = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                if(isMatched(searchWord, compareWord[j])) {
                    answerList.add(j+1);
                }
            }
            
            int listSize = answerList.size();
            
            if(listSize == 0) {
                System.out.println("Not match");
            } else {
                for(int j = 0; j < listSize; j++) {
                    int answer = answerList.get(j);
                    if(j != listSize-1) System.out.print(answer + " ");
                    else System.out.println(answer);
                }
            }
        }
    }
    
    static boolean isMatched(String searchWord, String compareWord) {
        if(searchWord == null || searchWord.equals("") || 
            compareWord == null || compareWord.equals("") || 
            searchWord.length() > compareWord.length()) {
            return false;
        }
        
        char left = searchWord.charAt(0);
        char right = searchWord.charAt(searchWord.length()-1);
        searchWord = searchWord.replaceAll("%","");
        
        if(left != '%' && right != '%') {
            return searchWord.equals(compareWord);
        } else if(left != '%' && right == '%') {
            return compareWord.startsWith(searchWord);
        } else if(left == '%' && right != '%') {
            return compareWord.endsWith(searchWord);
        } else {
            return compareWord.indexOf(searchWord) != -1;
        }
    }
}