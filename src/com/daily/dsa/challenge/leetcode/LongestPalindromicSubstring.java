package src.com.daily.dsa.challenge.leetcode;

public class LongestPalindromicSubstring {
    String result = "";

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            getPalindrome(s, i, i);
            getPalindrome(s, i, i + 1);
        }
        return result;
    }


    private void getPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if ((right - left + 1) > result.length()) {
                result = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
    }
}
