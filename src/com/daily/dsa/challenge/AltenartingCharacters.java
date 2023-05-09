package src.com.daily.dsa.challenge;

public class AltenartingCharacters {
    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAAA"));
        System.out.println(alternatingCharacters("BBBBB"));
        System.out.println(alternatingCharacters("ABABABAB"));
        System.out.println(alternatingCharacters("BABABA"));
        System.out.println(alternatingCharacters("AAABBB"));
    }

    /**
     * link: <a href="https://www.hackerrank.com/challenges/alternating-characters/problem">Alternating Characters</a>
     * You are given a string containing characters  and  only.
     * Your task is to change it into a string such that there are no matching adjacent characters.
     * To do this, you are allowed to delete zero or more characters in the string.
     * Your task is to find the minimum number of required deletions.
     */

    public static int alternatingCharacters(String s) {
        int deletion = 0;
        for (int x = 1; x < s.length(); x++) {
            if (s.charAt(x) == s.charAt(x - 1)) deletion++;
        }
        return deletion;
    }
}