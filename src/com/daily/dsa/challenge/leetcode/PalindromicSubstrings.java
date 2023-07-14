package src.com.daily.dsa.challenge.leetcode;

public class PalindromicSubstrings {


    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += countPalindrome(s, i, i);
            result += countPalindrome(s, i, i + 1);
        }
        return result;
    }

    private int countPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }

    /*
     * OPTION II
     */
    public int countSubstrings1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            //Check palindrome from even number
            int start = i;
            int end = i;
            while (isPalindrome(s, start, end)) {
                start--;
                end++;
                result++;
            }

            //check palindrome for odd number
            start = i;
            end = i + 1;
            while (isPalindrome(s, start, end)) {
                start--;
                end++;
                result++;
            }
        }

        return result;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start < 0 || end == s.length()) {
            return false;
        }
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
