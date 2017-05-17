import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    static final int PERFECT_MATCH = 0;
    static final int LEFT_MATCH = 1;
    static final int RIGHT_MATCH = 2;
    static final int MIDDLE_MATCH = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String[] compareWord = new String[N];
        
        for(int i = 0; i < N; i++) {
            compareWord[i] = br.readLine();
        }
        
        line = br.readLine();
        int M = Integer.parseInt(line);
        String[] searchWord = new String[M];
        HashMap<String, Integer> searchMap = new HashMap<String, Integer>();
        
        for(int i = 0; i < M; i++) {
            String c = br.readLine();
            searchWord[i] = c;
            searchMap.put(c, matchType(c));
        }
        
        LinkedList<Integer> answerList = new LinkedList<Integer>();
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int type = searchMap.get(searchWord[i]);
                if(isMatched(type, searchWord[i], compareWord[j])) {
                    answerList.add(j+1);
                }
            }
            
            int listSize = answerList.size();
            
            if(listSize == 0) {
                System.out.println("Not match");
            } else {
                for(int j = 0; j < listSize; j++) {
                    int answer = answerList.remove(0);
                    if(j != listSize-1) System.out.print(answer + " ");
                    else System.out.println(answer);
                }
            }
        }
    }
    
    static int matchType(String searchWord) {
        if(searchWord.equals("") || searchWord == null) return -1;
        
        char left = searchWord.charAt(0);
        char right = searchWord.charAt(searchWord.length()-1);
        
        if(left != '%' && right != '%') {
            return PERFECT_MATCH;
        } else if(left != '%' && right == '%') {
            return LEFT_MATCH;
        } else if(left == '%' && right != '%') {
            return RIGHT_MATCH;
        } else if(left == '%' && right == '%') {
            return MIDDLE_MATCH;
        }
        return -1;
    }
 
    static boolean isMatched(int type, String searchWord, String compareWord) {
        if(searchWord.equals("") || searchWord == null || 
            compareWord.equals("") || compareWord == null ||
            searchWord.length() > compareWord.length()) return false;
        
        switch(type) {
            case PERFECT_MATCH:
                return searchWord.equals(compareWord);
            case LEFT_MATCH:
                return compareWord.substring(0, searchWord.length()-1).equals(
                    searchWord.substring(0, searchWord.length()-1));
            case RIGHT_MATCH:
                return compareWord.substring(compareWord.length()-searchWord.length()+1).equals(
                    searchWord.substring(1));
            case MIDDLE_MATCH:
                return compareWord.indexOf(searchWord.substring(1,searchWord.length()-1)) != -1;
        }
        return false;
    }
}