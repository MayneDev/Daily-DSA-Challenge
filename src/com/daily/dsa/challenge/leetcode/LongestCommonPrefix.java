package src.com.daily.dsa.challenge.leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int x = 0;
        while (x < strs[0].length()) {
            for (String s : strs) {
                if (x > s.length() - 1 || s.charAt(x) != strs[0].charAt(x))
                    return strs[0].substring(0, x);
            }
            x++;
        }
        return strs[0];
    }
}
