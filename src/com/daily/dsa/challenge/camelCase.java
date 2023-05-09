package src.com.daily.dsa.challenge;

public class camelCase {
    public static void main(String[] args) {
        System.out.println(camelcase("saveChangesInTheEditor"));
    }

    /**
     * <a href="https://www.hackerrank.com/challenges/camelcase/problem">camelcase</a>
     */
    public static int camelcase(String s) {
       int words = 1;
       for(int x = 1; x<s.length(); x++){
           if (s.charAt(x) >= 'A' && s.charAt(x) <= 'Z') words++;
       }
       return words;
    }
}
